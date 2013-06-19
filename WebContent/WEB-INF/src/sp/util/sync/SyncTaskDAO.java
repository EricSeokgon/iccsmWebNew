package sp.util.sync;

import java.sql.SQLException;

import sp.webservice.UBAgentPortTypeProxy;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFSec;
import kjf.util.KJFUtil;

public class SyncTaskDAO {
	
	UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(Config.props.get("KICA_ENDPOINT"));
	
    public  void  insertOneTable(String header, String tbName, String where)throws Exception {
    	
    	String key= KJFSec.encode("kica");  
    	int hdCnt = header.split(",").length;
    	ReportDAO    rDAO        = new ReportDAO();
    	
    	rDAO.execute("delete from "+tbName);
    	
    	int row_perPage    = 2000; //한 페이지당 목록갯수
    	if("TB_ICS_SAUPJA_MT".equals(tbName)) row_perPage =1000;
    	int totalPage   = 1; //전체 페이지 수
    	
    	int total_cnt  = 1; //전체 검색결과 수
    	
    	String sql= "SELECT COUNT(*)  CNT, 'dumy' FROM "+tbName+" "+ where;
    	//SyncLog.log(sql);
    	System.out.println(sql);
    	
    	String s_result[]=ub.select(key, sql);
    	String resultFlag=s_result[0];
    	String kica_data=s_result[1];    	
    	
    	//협회서버 오류일경우.
    	if(resultFlag.equals("0") ){
    		SyncLog.log("공사협회시스템 오류 :"+ tbName +": "+kica_data);
        	return;
    	}
    	  	
    	total_cnt= KJFUtil.str2int(KJFUtil.str2strs(kica_data, "!#$")[0]);
    	
    	//정상적이나 데이타가 없을 경우
    	if(resultFlag.equals("1") && total_cnt==0){
    		SyncLog.log("가져올 데이타가 없음 :"+ tbName +": "+kica_data);    		
        	return;
    	}
    	
    	totalPage = (int)Math.ceil((double)total_cnt / (double)row_perPage);
    	
    	//웹서비스로 데이타를 가져올때 한꺼번에 많은 데이타를 가져 올 수 없으므로 적당하게 나누어서 여러번 가져온다.
    	for(int k=0; k < totalPage ;k++ ){
    		String subQuery= "select "+header+" from "+tbName+" "+ where;
    	
    		sql=getPageQuery(  subQuery,  k+1,  row_perPage);
    		
    		//SyncLog.log(sql);
    		System.out.println(sql);
    		
    		try{
    			s_result=ub.select(key, sql);
    		}catch (Exception e) {    			
    			Thread.sleep(3 * 1000);
        		try{
        			s_result=ub.select(key, sql);
        		}catch (Exception ex) {
        			Thread.sleep(5 * 1000);      			
        			try {
	        			s_result=ub.select(key, sql);
        			}catch (Exception i) {
        			    throw i;
        			}
        		}
			}
        	
        	resultFlag=s_result[0];
        	kica_data=s_result[1]; 
        	
        	//협회서버 오류일경우.
        	if(resultFlag.equals("0") ){
        		SyncLog.log("공사협회시스템 오류 :"+ tbName +": "+kica_data);
            	return;
        	}     	
        	if(resultFlag.equals("1") && KJFUtil.isEmpty(kica_data)){
        		SyncLog.log("가져올 데이타가 없음 :"+ tbName +": "+kica_data);    		
            	return;
        	}   
        	       	
        	//System.out.println(kica_data);
        	String rows[] =KJFUtil.str2strs(kica_data, "!#$");
        
        	
        	String sqls[] = new String[rows.length];

        	
        	for(int i=0;i< rows.length ;i++ ){
        		//KJFUtil.str2strs를 쓰게 되면 공백일 경우 에러가 나기 때문에
        		System.out.println("============rows["+i+"]===: "+rows[i]);
        		//System.out.println("============hdCnt===: "+hdCnt);
        		String attrs[]=rows[i].split("\t", hdCnt);
        		
        		StringBuffer sb = new StringBuffer(); 		
        		sb.append("insert into "+tbName+" ( "+header+" ) values ( ");

        		for(int j=0;j< attrs.length ;j++ ){        			
        			sb.append( "'" +SyncUtil.removeComma(attrs[j].trim())  + "', " );
        			//sb.append( "'" + attrs[j].trim() + "', " );
        		}
        		sb = new StringBuffer(sb.substring(0, sb.length()-2));
        		sb.append(" ) ");
        		//rDAO.execute(sb.toString());  
        		
        		sqls[i]= sb.toString();
        		
        	}//end for(int i=0;i< rows.length ;i++ )
        	
        	int updateCounts[] = rDAO.batchUpdate(sqls);
        	System.out.println("updateCounts : "+updateCounts.length);
        	
    	}//end for(int k=0; k < totalPage ;k++ )
    }
    
    
	public String getPageQuery( String subQuery, int pageIndex, int sizePerPage) {
	    String query = " SELECT *" +
	            " FROM   (" +
	            " SELECT PAGE_QUERY.*, ROWNUM NUM" +
	            " FROM   (" +
	            "         " + subQuery +
	            "        ) PAGE_QUERY" +
	            " )" +
	            " WHERE  NUM between " +
	            ( (pageIndex - 1) * sizePerPage + 1 ) +
	            " AND " +
	            ( pageIndex * sizePerPage  );         	
       
        return query;
	}
    	
	
	
	public ReportEntity  getMasterEnt() throws Exception {
		
		ReportDAO    rDAO		= new ReportDAO();

		String sql=
			"select * " +
			"from pt_r_company_master " +
			"where c_com_dt is null " +
			//"and tmp_wrt_num ='9000' " +
			"and trans_union_proc is null and sido_code !='tete' " +
			"order by to_number(tmp_wrt_num) asc";
		
		
		return rDAO.select(sql);
	}		
	
	public ReportEntity  getOmitedKicaMasterEnt() throws Exception {
		
		ReportDAO    rDAO		= new ReportDAO();

		String sql=
			"select * from TB_ICS_SAUPJA_MT  " +
			"where REGIST_NO not in " +
			"(select coi_wrt_num from pt_r_company_master  " +
			"where c_com_dt is null and trans_union_proc is null and sido_code !='tete')";
		
		
		return rDAO.select(sql);
	}			
	
	public ReportEntity  getKicaMasterEnt(String REGIST_NO) throws Exception {
		
		ReportDAO    rDAO		= new ReportDAO();

		String sql=
			"select * " +
			"from TB_ICS_SAUPJA_MT " +
			"where REGIST_NO='"+REGIST_NO+"' ";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetSubDiaryEnt(String TMP_WRT_NUM) throws Exception {
		
		ReportDAO    rDAO		= new ReportDAO();

		String sql=
			"select * " +
			"from PT_R_SUBSIDIARY " +
			"where TMP_WRT_NUM='"+TMP_WRT_NUM+"' ";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaSubDiaryEnt(String cOIWRTNUM) throws Exception {
		ReportDAO    rDAO		= new ReportDAO();

		String sql=
			"select * " +
			"from TB_ICS_KYUMUP_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' ";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetWorkResultsEnt(String tMPWRTNUM) throws Exception {
		ReportDAO    rDAO		= new ReportDAO();

		String sql=
			"select * " +
			"from PT_R_WORK_RESULTS " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' ";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaWorkResultsEnt(String cOIWRTNUM) throws Exception {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_SILJUK_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' ";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetWorkCapabilityEnt(String tMPWRTNUM) throws Exception  {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_R_WORK_CAPABILITY " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' ";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaWorkCapabilityEnt(String cOIWRTNUM) throws Exception {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_EVALMAIN_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' ";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetMEnt(String tMPWRTNUM) throws Exception {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_M_MASTER " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' ";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaMEnt(String cOIWRTNUM) throws Exception {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_PUNISH_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' and PUNISH_LIST not in ('40','45','46','49')";
		
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetEngineerEnt(String tMPWRTNUM)throws Exception {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_R_ENGINEER_CHANGE " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' " +
			"and (EMPL_YMD >= '20100101' or RET_YMD >= '20100101' or RET_YMD is null ) ";
				
		return rDAO.select(sql);
	}


	public ReportEntity getKicaEngineerEnt(String cOIWRTNUM)throws Exception {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_R_ENGINEER_CHANGE " +
			"where REGIST_NO='"+cOIWRTNUM+"' " +
			"and (EMPL_YMD >= '20100101' or RET_YMD >= '20100101' or RET_YMD is null ) ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetChgRepEnt(String tMPWRTNUM)throws Exception {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_R_BASIC_CHANGE_HISTORY " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' " +
			"and EXT_CHG_CLASS_CODE like '%C%' and CHG_DT >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaChgRepEnt(String cOIWRTNUM)throws Exception {
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_DAEPYO_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' " +
			"and daepyo_nm is not null "+
			"and CHANGE_YMD >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetChgComEnt(String tMPWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_R_BASIC_CHANGE_HISTORY " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' " +
			"and EXT_CHG_CLASS_CODE like '%D%' and CHG_DT >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaChgComEnt(String cOIWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_SANGHO_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' " +
			"and CHANGE_YMD >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetChgAddrEnt(String tMPWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_R_BASIC_CHANGE_HISTORY " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' " +
			"and EXT_CHG_CLASS_CODE like '%A%' and CHG_DT >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaChgAddrEnt(String cOIWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_SOJAEJI_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' " +
			"and CHANGE_YMD >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetChgMoneyEnt(String tMPWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_R_BASIC_CHANGE_HISTORY " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' " +
			"and EXT_CHG_CLASS_CODE like '%B%' and CHG_DT >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaChgMoneyEnt(String cOIWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_JABON_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' " +
			"and CHANGE_YMD >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetHistoryEnt(String tMPWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from PT_R_BASIC_CHANGE_HISTORY " +
			"where TMP_WRT_NUM='"+tMPWRTNUM+"' and MOT_STE ='STD003' " +
			"and STA_CHG_CLASS_CODE not in ('R00007', 'R00008', 'R00009', 'R00010') and CHG_DT >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getKicaHistoryEnt(String cOIWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_HISTORY_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' " +
			"and CHANGE_YMD >= '20100101' ";
		
		return rDAO.select(sql);
	}


	public ReportEntity getNetRefferEnt(String tMPWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"SELECT  B.*  " +
			"FROM PT_R_COMPANY_MASTER A,  PT_R_REFFER  B  " +
			"WHERE 1=1  " +
			"AND A.TMP_WRT_NUM =B.TMP_WRT_NUM  " +
			"AND B.POS_CLASS IN ('P1','P4')   " +
			"AND trim(B.NM_KOR) != trim(A.REP_NM_KOR)  " +
			"AND NVL(DEL_YN,'N') !='Y' " +
			"AND A.TMP_WRT_NUM =  '"+tMPWRTNUM+"'     ";

	
		return rDAO.select(sql);
	}


	public ReportEntity getKicaRefferEnt(String cOIWRTNUM) throws Exception{
		ReportDAO    rDAO		= new ReportDAO();
		
		String sql=
			"select * " +
			"from TB_ICS_REP_DT " +
			"where REGIST_NO='"+cOIWRTNUM+"' " ;
		
		
		return rDAO.select(sql);
	}		
	
	
}
