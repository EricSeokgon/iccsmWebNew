/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFMi;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_R_BASIC_CHANGE_HISTORYDAO;
import sp.dao.PT_R_BASIC_CHANGE_HISTORYEntity;
import sp.dao.PT_R_COMPANY_MASTERDAO;
import sp.dao.PT_R_COMPANY_MASTEREntity;
import sp.dao.PT_R_ENGINEER_CHANGEDAO;
import sp.dao.PT_R_ENGINEER_CHANGEEntity;
import sp.dao.PT_R_WORK_CAPABILITYDAO;
import sp.dao.PT_R_WORK_CAPABILITYEntity;
import sp.dao.PT_R_WORK_RESULTSDAO;
import sp.dao.PT_R_WORK_RESULTSEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;



public class RegChangeMgrCCUDCmd implements KJFCommand {
	
    private String next;

    private PT_R_COMPANY_MASTERDAO    PT_R_COMPANY_MASTERdao = new PT_R_COMPANY_MASTERDAO();
    private PT_R_COMPANY_MASTEREntity PT_R_COMPANY_MASTEREnt = new PT_R_COMPANY_MASTEREntity();
    
    private PT_R_WORK_RESULTSDAO    PT_R_WORK_RESULTSdao = new PT_R_WORK_RESULTSDAO();
    private PT_R_WORK_RESULTSEntity PT_R_WORK_RESULTSEnt = new PT_R_WORK_RESULTSEntity();
    
    private PT_R_WORK_CAPABILITYDAO    PT_R_WORK_CAPABILITYdao = new PT_R_WORK_CAPABILITYDAO();
    private PT_R_WORK_CAPABILITYEntity PT_R_WORK_CAPABILITYEnt = new PT_R_WORK_CAPABILITYEntity();

    private PT_R_BASIC_CHANGE_HISTORYDAO    PT_R_BASIC_CHANGE_HISTORYdao = new PT_R_BASIC_CHANGE_HISTORYDAO();
    private PT_R_BASIC_CHANGE_HISTORYEntity PT_R_BASIC_CHANGE_HISTORYEnt = new PT_R_BASIC_CHANGE_HISTORYEntity();
    
    private PT_R_ENGINEER_CHANGEDAO    PT_R_ENGINEER_CHANGEdao = new PT_R_ENGINEER_CHANGEDAO();
    private PT_R_ENGINEER_CHANGEEntity PT_R_ENGINEER_CHANGEEnt = new PT_R_ENGINEER_CHANGEEntity();
    
    private VariableList vl = new VariableList();
    
    
    public RegChangeMgrCCUDCmd() {
    }


    public RegChangeMgrCCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	String scMODE = vl.getValueAsString("workMODE");
    	String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
    	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds;
    	
    	//PT_R_COMPANY_MASTER : 변경 반영
    	ds = pReq.getDatasetList().getDataset("dsPT_R_COMPANY_MASTER");
    	PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
		if (ds != null) dsProc(ds);
		
		//PT_R_BASIC_CHANGE_HISTORY : 변경 입력 처리
		ds = pReq.getDatasetList().getDataset("dsPT_R_BASIC_CHANGE_HISTORY_COPY");
		if(ds != null) dsProc(ds);
		
		//PT_R_WORK_RESULTS : 변경 입력 처리
		ds = pReq.getDatasetList().getDataset("dsPT_R_WORK_RESULTS");
		if(ds != null) dsProc(ds);
		
		//PT_R_WORK_CAPABILITY : 변경 입력 처리
		ds = pReq.getDatasetList().getDataset("dsPT_R_WORK_CAPABILITY");
		if(ds != null) dsProc(ds);
		
		//PT_R_ENGINEER_CHANGE
		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");
		if (ds != null) dsProc(ds);
		
		//PT_R_BASIC_CHANGE_HISTORY : 히스토리 변경내역 전체 내역 불러오기
		StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        ReportEntity rMasterEntity     = null;
        ReportDAO    rDAO        = new ReportDAO();
        DatasetList  dl = new DatasetList();
        
        sQuery.append(" SELECT  ");
        sQuery.append(" DECODE(b.CODE," +
        		"'R00007','신고'," +
        		"'R00008','신고'," +
        		"'R00009','신고'," +
        		"'R00010','신고','등록') CODE_TYPE,");
        sQuery.append(" b.CODE_NAME CODE_NAME,CHG_DT DT, NAME, REP_NM_KOR, REP_NM_HAN, REP_SSN1, REP_SSN2, ");
        sQuery.append(" ADDR_ADDR, ADDR_DETAIL_ADDR, OFFICE_AREA, ADDR_TEL_NUM, ADDR_FAX_NUM, ");
        sQuery.append(" PAY_CAP, REA_CAP, c.CODE_NAME DIAG_ORG_NAME, DIAG_NM_NM, STA_CHG_CLASS_CODE, REPLACE(SUBSTR (UPD_DT,0,10),'-','') UPD_DT ");
        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY a ");
        sWhere.append(" LEFT JOIN PT_COM_CODE b ON a.STA_CHG_CLASS_CODE=b.CODE ");
        sWhere.append(" LEFT JOIN PT_COM_CODE c ON a.DIAG_ORG_CODE=c.CODE ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        sWhere.append(" ORDER BY CHGBRE_SEQ DESC ");
	
        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
        sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
        
        request.setAttribute("dl", dl);
		
        //최종처리
        return next;
    }
    
    //process
    private void dsProc(Dataset ds) throws Exception
    {
    	for(int i=0;i<ds.getRowCount();i++){
    		System.out.println( ds.getDataSetID()+" : "+i+" : "+ds.getRowStatus(i) );
    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i,"");
    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
    	}
    	
    	/****** Dataset을 DELETE처리 ****/
    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
    		deleteExe(ds,i);
    	}
    }

    /**
     * 입력
     * @param Dataset ds, String scMODE
     * @return
     */
    private void insertExe(Dataset ds, int arg_row, String scMODE)throws Exception{
    	//입력처리 : history 변경 입력처리
    	if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY_COPY"))
    	{
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, 0);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setCHGBRE_SEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_BASIC_CHANGE_HISTORY", "CHGBRE_SEQ"));
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());
    	    
    	    //각 구분별로 change history 에 반영 처리:변경관련 코드값 처리해야됨
//        	if ( scMODE.equalsIgnoreCase("COMPANY") ){
//        		PT_R_BASIC_CHANGE_HISTORYEnt.setSTA_CHG_CLASS_CODE("R00010");
//        	}else if( scMODE.equalsIgnoreCase("REPRESENT") ){
//        		PT_R_BASIC_CHANGE_HISTORYEnt.setSTA_CHG_CLASS_CODE("R00009");
//        	}else if( scMODE.equalsIgnoreCase("ADDRESS") ){
//        		PT_R_BASIC_CHANGE_HISTORYEnt.setSTA_CHG_CLASS_CODE("R00007");
//        	}else if(scMODE.equals("CAPITAL")){
//        		PT_R_BASIC_CHANGE_HISTORYEnt.setSTA_CHG_CLASS_CODE("R00008");
//        	}
    	    
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.insert(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_RESULTS"))
    	{
    		String tmpWrtNum = ds.getColumn(arg_row,"TMP_WRT_NUM").getString();
    		
    		PT_R_WORK_RESULTSEnt.setDsOnlyString(ds, 0);//
    		PT_R_WORK_RESULTSEnt.setINS_DT(KJFDate.getCurDatetime());
    		
    		PT_R_WORK_RESULTSEnt.setSEQ( Long.parseLong(this.getMaxWorkSeq(tmpWrtNum, "PT_R_WORK_RESULTS", "SEQ")) +1 +"" );
     	    
    		KJFLog.debug(PT_R_WORK_RESULTSEnt.toString()); 		    	
    		PT_R_WORK_RESULTSdao.insert(PT_R_WORK_RESULTSEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_CAPABILITY"))
    	{
    		String tmpWrtNum = ds.getColumn(arg_row,"TMP_WRT_NUM").getString();
    		
    		PT_R_WORK_CAPABILITYEnt.setDsOnlyString(ds, 0);//
    		PT_R_WORK_CAPABILITYEnt.setINS_DT(KJFDate.getCurDatetime());
     	    
    		PT_R_WORK_CAPABILITYEnt.setSEQ( Long.parseLong(this.getMaxWorkSeq(tmpWrtNum, "PT_R_WORK_CAPABILITY", "SEQ")) +1 +"" );
    		
    		KJFLog.debug(PT_R_WORK_CAPABILITYEnt.toString()); 		    	
    		PT_R_WORK_CAPABILITYdao.insert(PT_R_WORK_CAPABILITYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGEEnt.setINS_DT(KJFDate.getCurDatetime());
    		PT_R_ENGINEER_CHANGEEnt.setSEQ(
    	    		getMaxSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_ENGINEER_CHANGE", "SEQ"));
        	KJFLog.debug(PT_R_ENGINEER_CHANGEEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGEdao.insert(PT_R_ENGINEER_CHANGEEnt);
    	}
    	
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    	//수정처리
    	if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    		PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.update(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_RESULTS"))
    	{
    		PT_R_WORK_RESULTSEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_WORK_RESULTSEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_RESULTSEnt.toString()); 		    	
        	PT_R_WORK_RESULTSdao.update(PT_R_WORK_RESULTSEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_CAPABILITY"))
    	{
    		PT_R_WORK_CAPABILITYEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_WORK_CAPABILITYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_CAPABILITYEnt.toString()); 		    	
        	PT_R_WORK_CAPABILITYdao.update(PT_R_WORK_CAPABILITYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ENGINEER_CHANGEEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGEdao.update(PT_R_ENGINEER_CHANGEEnt);
    	}
    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	String tmpWrtNum = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();
    	String seq = ds.getDeleteColumn(arg_row,"SEQ").getString();
    	String deleteQuery;
    	
    	ReportDAO rDAO;
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_CAPABILITY"))
    	{
    		deleteQuery =	" DELETE FROM PT_R_WORK_CAPABILITY WHERE TMP_WRT_NUM = '" +
    						"" + tmpWrtNum + "'" + " AND SEQ = '" + seq + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_RESULTS"))
    	{
    		deleteQuery =	" DELETE FROM PT_R_WORK_RESULTS WHERE TMP_WRT_NUM = '" +
    						"" + tmpWrtNum + "'" + " AND SEQ = '" + seq + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		//String sChgSeq = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_ENGINEER_CHANGE ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + tmpWrtNum + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		//sQuery.append(" AND SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    }
    
    //변경번호 처리
    private String getMaxChangeSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
    
    //PT_R_WORK_RESULTS PT_R_WORK_CAPABILITY : max SEQ 
    private String getMaxWorkSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
    
    //ENGINEER
    private String getMaxSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
    
}