package sp.util.kica;

import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFSec;
import kjf.util.KJFUtil;
import sp.dao.PT_KICA_TRANS_LOGDAO;
import sp.dao.PT_KICA_TRANS_LOGEntity;
import sp.webservice.UBAgentPortTypeProxy;

public  class KicaTaskDAO  {
	
	

	UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(Config.props.get("KICA_ENDPOINT"));
	//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://211.34.100.185:8080/iccsWs/services/UBAgent");
	//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://localhost/iccWsKica/services/UBAgent");
	//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://118.37.186.201/iccsWs/services/UBAgent");
	
    public  void insTransLog(String U_D_FLAG, 
    						String TABLE_NAME,
    						String LOG,
    						String ERR_YN  )throws Exception {
    	
        PT_KICA_TRANS_LOGDAO    PT_KICA_TRANS_LOGdao = new PT_KICA_TRANS_LOGDAO();
        PT_KICA_TRANS_LOGEntity PT_KICA_TRANS_LOGent = new PT_KICA_TRANS_LOGEntity();    	

    	String SEQ = KJFDBUtil.getMaxID("SEQ", "PT_KICA_TRANS_LOG");
    	String now_dt =KJFDate.getCurDatetime();
    	
    	PT_KICA_TRANS_LOGent.setSEQ(SEQ);
    	PT_KICA_TRANS_LOGent.setU_D_FLAG(U_D_FLAG);
    	PT_KICA_TRANS_LOGent.setTABLE_NAME(TABLE_NAME);
    	PT_KICA_TRANS_LOGent.setLOG(LOG);
    	PT_KICA_TRANS_LOGent.setERR_YN(ERR_YN);
    	PT_KICA_TRANS_LOGent.setUPD_DT(now_dt);
    	PT_KICA_TRANS_LOGent.setINS_DT(now_dt);
    	
    	PT_KICA_TRANS_LOGdao.insert(PT_KICA_TRANS_LOGent);
	   	
    }  
    

    public  void  kicaToIcs(String header, String tbName, boolean keyRegYn)throws Exception {
    	
    	String key= KJFSec.encode("kica");  	
    	int hdCnt = header.split(",").length;  
    	
    	String sql= "";
    	sql += "SELECT "+header+" FROM (";
    	sql += "select "+header+" from "+tbName+" where ICS_TRANS_DT is null ORDER BY SEQ";
    	sql += ") WHERE ROWNUM < 200";
    	//String sql="select "+header+" from "+tbName+" ";
    	
    	KicaLog.log(sql);
    	
    	String s_result[]=ub.select(key, sql);
    	String resultFlag=s_result[0];
    	String kica_data=s_result[1];   
    	
//    	System.out.println("###"+sql);
//    	System.out.println("###"+resultFlag);
//    	System.out.println("###"+KJFUtil.isEmpty(kica_data));
//    	System.out.println("###"+kica_data);
    	
    	
    	if(resultFlag.equals("1") && KJFUtil.isEmpty(kica_data)){
        	//가져올 데이타 없음    		
        	insTransLog("D", tbName, "가져올 데이타가 없습니다.!","N");  
        	return;
    	}
    	
    	//협회서버 오류일경우.
    	if(resultFlag.equals("0") ){
        	insTransLog("D", tbName, kica_data ,"Y");  
        	return;
    	}   	
    	
    	//System.out.println(kica_data);
    	String rows[] =KJFUtil.str2strs(kica_data, "!#$");
    	String rows_seq="";
    	ReportDAO    rDAO        = new ReportDAO();
    	
    	String now_dt =KJFDate.getCurDatetime();
    	
    	for(int i=0;i< rows.length ;i++ ){
    		//KJFUtil.str2strs를 쓰게 되면 공백일 경우 에러가 나기 때문에
    		System.out.println("============rows["+i+"]===: "+rows[i]);
    		//System.out.println("============hdCnt===: "+hdCnt);
    		String attrs[]=rows[i].split("\t", hdCnt);
    		
    		StringBuffer sb = new StringBuffer(); 		
    		sb.append("insert into "+tbName+" ( "+header+" ) values ( ");
    		for(int j=0;j< attrs.length ;j++ ){
    			// INSERT 완료 후, ICS_TRANS_DT 값을 UPDATE 처리할 PK.
    			if( j == 0 )
    				rows_seq += "'" + attrs[j] + "'" + ", ";
    			
    			sb.append( "'" + attrs[j].trim() + "', " );
    		}
    		
    		sb.append("'"+now_dt+"'").append(" ) ");
    		
    		rDAO.execute(sb.toString());
    		
    		//변경 업무관련 키 저장.
    		if(keyRegYn){
    			//소재지, 자본금, 대표자, 상호, 시공능력, 실적
	    		StringBuffer sb_PT_TMP_RECEIVE_KEY = new StringBuffer();//PT_TMP_RECEIVE_KEY 입력데이타용
	    		sb_PT_TMP_RECEIVE_KEY
		  		  .append("insert into PT_TMP_RECEIVE_KEY ( TB_NM, SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM, INS_DT ) values ( ")
		  		  .append("'"+tbName+"', ");
	    		for(int j=0;j< 4 ;j++ ){
	    			sb_PT_TMP_RECEIVE_KEY.append("'"+attrs[j]+"'").append(",");    			   			
	    		}
	    		sb_PT_TMP_RECEIVE_KEY.append("'"+now_dt+"'").append(" ) ");
	    		rDAO.execute(sb_PT_TMP_RECEIVE_KEY.toString());

    		} else {
    			//기술자
//    			if ("PT_TMP_ENGINEER".equals(tbName)){
//    				String NOW_DT =KJFDate.getCurDatetime();
//    	    		StringBuffer sb_PT_TMP_RECEIVE_KEY = new StringBuffer();//PT_TMP_RECEIVE_KEY 입력데이타용
//    	    		sb_PT_TMP_RECEIVE_KEY
//    		  		  .append("insert into PT_TMP_RECEIVE_KEY ( TB_NM, SEQ, INS_DT ) values ( ")
//    		  		  .append("'"+tbName+"', ")
//    		  		  .append("'"+attrs[0]+"',")    		  		  
//    	    		  .append("'"+NOW_DT+"'")
//    	    		  .append(")");    			   			
//    	    		rDAO.execute(sb_PT_TMP_RECEIVE_KEY.toString());
//    			}
    			
    		}

    	}
    			
		//rows_seq = rows_seq.substring(0,rows_seq.length()-2);
    	insTransLog("D", tbName, KJFUtil.getTitleLimit(rows_seq,1900),"N");
    	
    	sql= "update "+tbName+" set ICS_TRANS_DT='"+now_dt+"' where seq in ("+rows_seq+"'0')";
    	KicaLog.log(sql);
    	
    	//성공로그 남기기    	-실제 적용시에는 주석풀어야 함
    	String result= ub.excute(key, sql);
    	if(!result.equals("1")){
    		throw new Exception("Kica 서버 오류 :"+ result);
    	}
    }
    

    

        
    public  ReportEntity  getTransKeyEnt()throws Exception {
  	
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEntity     = null;
    	
    	//String sql="select * from PT_TMP_TRANS_KEY ";
    	String sql=
    		"SELECT *  FROM PT_TMP_TRANS_KEY A, PT_R_COMPANY_MASTER B " +
    		"WHERE A.KEY1 = B.TMP_WRT_NUM " +
    		" and to_date(a.ins_dt, 'yyyy-mm-dd hh24:mi:ss')+(1/24) < sysdate "+     //등록된지 1시간 이상인것만 보낸다.
    		"AND nvl(KEY5,' ') !='S' AND CUD_FLAG='C' AND SIDO_CODE !='tete' ";
//   		"AND nvl(KEY5,' ') !='S' AND CUD_FLAG='C' AND SIDO_CODE !='tete' AND SIDO_CODE ='susu' ";
    	    
    	       	
    	
//    	sysdate + 1            -- 1일
//    	sysdate + 1/24         -- 1시간
//    	sysdate + 1/(24*60)    -- 1분
//    	sysdate + 1/(24*60*60) -- 1초 
    	
    	KicaLog.log(sql);
    	rEntity= rDAO.select(sql);
    	
    	
    	return rEntity;
    	
    }
    
    //수신정보 키 select
    public  ReportEntity  getReceiveKeyEnt()throws Exception {
      	
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEntity     = null;
    	
    	String sql=" select * from PT_TMP_RECEIVE_KEY a \n";
    	sql += " left outer join PT_R_COMPANY_MASTER b \n";
    	sql += " ON a.COI_WRT_NUM=b.COI_WRT_NUM";
    	sql += " WHERE 1=1";
//    	sql += " AND a.seq = '34807'";
//    	sql += " AND a.TB_NM = 'PT_TMP_ENGINEER_CHANGE'";
    	sql += " ORDER BY TO_NUMBER(a.SEQ)";
    	
    	
//    	String sql=" SELECT 'PT_TMP_REP_CHANGE' TB_NM, A.SEQ, A.COI_WRT_NUM, A.SIDO_CODE, B.TMP_WRT_NUM  " +
//		"FROM PT_TMP_REP_CHANGE A,   " +
//		"PT_R_COMPANY_MASTER B " +
//		"WHERE A.COI_WRT_NUM =B.COI_WRT_NUM(+) " +
//		"AND A.COI_WRT_NUM ='110598' " +
//		"ORDER BY TO_NUMBER(A.SEQ) \n";
    	
    	
    	KicaLog.log(sql);
    	rEntity= rDAO.select(sql);
    	
    	return rEntity;
    	
    }
    

    

    
    public  void  transLow(	String SEQ,
    						String WORK_CLASS_CODE, 
    						String KEY1,
    						String KEY2,
    						String KEY3,
    						String CUD_FLAG )throws Exception {
    	
    	KicaLog.log("--------------------------------------구분:"+WORK_CLASS_CODE +"  TMP_WRT_NUM:"+KEY1+"  KEY2:"+KEY2);
    	
    	KicaTaskSql taskSql = new KicaTaskSql(WORK_CLASS_CODE, KEY1, KEY2, KEY3, CUD_FLAG);
    	
    	//지자체 접수
    	String TB_TMP_COMM_ACCEPT_MT_SQL= taskSql.getTB_TMP_COMM_ACCEPT_MT();

    	//지자체접수 사업자
    	String TB_TMP_COMM_SAUPJA_MT_SQL= taskSql.getTB_TMP_COMM_SAUPJA_MT();
    
    	//보유기술자
    	String TB_TMP_COMM_KEEPTECH_DT_SQL= taskSql.getTB_TMP_COMM_KEEPTECH_DT();
  	
    	//공동대표
    	String TB_TMP_REP_MT_SQL= taskSql.getTB_TMP_REP_MT(); 
    	
    	//겸업
    	String TB_TMP_KYUMUP_DT_SQL= taskSql.getTB_TMP_KYUMUP_DT() ; 
    	

    	String now_dt =KJFDate.getCurDatetime();
    	String kicaToSql="";
    	
    	if(WORK_CLASS_CODE.equals("R00001")){ //신규
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_ACCEPT_MT_SQL, "TB_TMP_COMM_ACCEPT_MT", now_dt);//지자체접수
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_SAUPJA_MT_SQL, "TB_TMP_COMM_SAUPJA_MT", now_dt);//지자체접수사업자
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_KEEPTECH_DT_SQL, "TB_TMP_COMM_KEEPTECH_DT", now_dt);//보유기술자
	    	kicaToSql += getKicaToInsSql( TB_TMP_REP_MT_SQL, "TB_TMP_REP_MT", now_dt);//공동대표
	    	kicaToSql += getKicaToInsSql( TB_TMP_KYUMUP_DT_SQL, "TB_TMP_KYUMUP_DT", now_dt);//겸업사항
	    	
    	}else if(WORK_CLASS_CODE.equals("R00006") ){ // 합병(R00006)
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_ACCEPT_MT_SQL, "TB_TMP_COMM_ACCEPT_MT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_SAUPJA_MT_SQL, "TB_TMP_COMM_SAUPJA_MT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_KEEPTECH_DT_SQL, "TB_TMP_COMM_KEEPTECH_DT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_REP_MT_SQL, "TB_TMP_REP_MT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_KYUMUP_DT_SQL, "TB_TMP_KYUMUP_DT", now_dt);
    		
    		//-- 시작 :: 접수이전기본정보 -----
	    	
	    	ReportEntity rEntity     = getPrevBeforeEnt(  KEY1, "PT_R_UNION_COMPANY_BEFORE" );
	    	
	    	String TB_TMP_COMM_BEFORE_DT_SQL="";
	    	for (int i = 0; i < rEntity.getRowCnt(); i++) {
	    		
	    		TB_TMP_COMM_BEFORE_DT_SQL= taskSql.getTB_TMP_COMM_BEFORE_DT( rEntity.getValue(i,"TMP_WRT_NUM"), rEntity.getValue(i,"RECV_NUM"), "PT_R_UNION_COMPANY_BEFORE") ;

	    		kicaToSql += getKicaToInsSql( TB_TMP_COMM_BEFORE_DT_SQL, "TB_TMP_COMM_BEFORE_DT", now_dt);	    		
	    		
	    	}
	    	

	    	
	    	//-- 종료 :: 접수이전기본정보 -----
    			
    	}else if(WORK_CLASS_CODE.equals("R00004")||WORK_CLASS_CODE.equals("R00005") ||WORK_CLASS_CODE.equals("R00011") ){ 
    		// 양도양수(R00004),//분할합병(R00005),//법인전환(R00011)
    		
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_ACCEPT_MT_SQL, "TB_TMP_COMM_ACCEPT_MT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_SAUPJA_MT_SQL, "TB_TMP_COMM_SAUPJA_MT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_KEEPTECH_DT_SQL, "TB_TMP_COMM_KEEPTECH_DT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_REP_MT_SQL, "TB_TMP_REP_MT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_KYUMUP_DT_SQL, "TB_TMP_KYUMUP_DT", now_dt);
	    	
	    	//가져올접수이전기본정보검색
	    	//ReportEntity rEntity     = getPrevBeforeEnt( KEY1, "PT_R_TRANS_COMPANY_BEFORE" );
	    	/////////////////////////////////// 반드시 수정해야 함..ㅡ.ㅡ;//////////////////////////////
	 
	    	//가져올접수이전기본정보검색
	    	ReportEntity rEntity     = getATPrevEnt(KEY2, KEY3 );
	   
	    	
    		String TB_TMP_COMM_BEFORE_DT_SQL= taskSql.getTB_TMP_COMM_BEFORE_DT( rEntity.getValue(0,"ASSI_TMP_WRT_NUM"), rEntity.getValue(0,"RECV_NUM"), "PT_R_TRANS_COMPANY_BEFORE") ; //양도자 정보
    		kicaToSql += getKicaToInsSql( TB_TMP_COMM_BEFORE_DT_SQL, "TB_TMP_COMM_BEFORE_DT", now_dt); //지자체 접수이전기본정보
	    	
   		
    		if(WORK_CLASS_CODE.equals("R00005")){ //분할 합병인 경우 합병과 동일하게 2업체 정보를 보내야 한다.
    			    			
	    		TB_TMP_COMM_BEFORE_DT_SQL= taskSql.getTB_TMP_COMM_BEFORE_DT( rEntity.getValue(0,"TRAN_TMP_WRT_NUM"), rEntity.getValue(0,"RECV_NUM"), "PT_R_TRANS_COMPANY_BEFORE") ;
	    			    		
	    		kicaToSql += getKicaToInsSql( TB_TMP_COMM_BEFORE_DT_SQL, "TB_TMP_COMM_BEFORE_DT", now_dt);
    		}
    		                                
    	}else if(WORK_CLASS_CODE.equals("R00002") ){ // 기준신고 (R00002)
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_ACCEPT_MT_SQL, "TB_TMP_COMM_ACCEPT_MT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_SAUPJA_MT_SQL, "TB_TMP_COMM_SAUPJA_MT", now_dt);
	    	
    		//등록기준신고
	    	
    		String TB_TMP_COMM_RENEW_DT_SQL= taskSql.getTB_TMP_COMM_RENEW_DT() ;
    		kicaToSql += getKicaToInsSql( TB_TMP_COMM_RENEW_DT_SQL, "TB_TMP_COMM_RENEW_DT", now_dt);//등록기준신고		    	
    		
    	}else if(WORK_CLASS_CODE.equals("R00013")){ //재교부
    		//재교부
    		String TB_TMP_REISSUE_DT =taskSql.getTB_TMP_REISSUE_DT();
    		kicaToSql += getKicaToInsSql( TB_TMP_REISSUE_DT, "TB_TMP_REISSUE_DT", now_dt); // 재교부접수 
    		
    	}else if(WORK_CLASS_CODE.equals("R00012") ){ // 행정처분 (R00012)
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_ACCEPT_MT_SQL, "TB_TMP_COMM_ACCEPT_MT", now_dt);
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_SAUPJA_MT_SQL, "TB_TMP_COMM_SAUPJA_MT", now_dt);
	    	
    		String TB_TMP_COMM_PUNISH_DT_SQL= taskSql.getTB_TMP_COMM_PUNISH_DT() ;
    		kicaToSql += getKicaToInsSql( TB_TMP_COMM_PUNISH_DT_SQL, "TB_TMP_COMM_PUNISH_DT", now_dt);		    	
    		
    	}else if(WORK_CLASS_CODE.equals("R00003") ){ // 폐업 (R00003)
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_ACCEPT_MT_SQL, "TB_TMP_COMM_ACCEPT_MT", now_dt);//지자체접수
	    	kicaToSql += getKicaToInsSql( TB_TMP_COMM_SAUPJA_MT_SQL, "TB_TMP_COMM_SAUPJA_MT", now_dt);
    	}
    	
    	KicaLog.log(kicaToSql);
    	
    	String key= KJFSec.encode("kica");  
    	//정상실행시 변경해야 함.
    	

    	//전송후..key table 삭제.
    	//String sql= "delete from pt_tmp_trans_key where seq='"+SEQ+"'";
    	String sql= "update pt_tmp_trans_key set key5='S' where seq='"+SEQ+"'";
  
    	ReportDAO    rDAO        = new ReportDAO();
    	KicaLog.log(sql);
    	rDAO.execute(sql);
    	////전송이 완료된후 pt_r_company_master, pt_r_basic_change_history에 동시에
    	////snd_ste에 전송값을 남기는 것은 협회와 협의하여 추후에 진행한다.- cud_flag
    	
    	//System.out.println( kicaToSql );
    	
    	StringBuffer sb = new StringBuffer( kicaToSql );
    	/*
    	// 웹서비스 통해 넣은건 널이 들어가 있는게 많다. 원칙적으로 안들어가게 하고 우선은..
    	for( int i = 0; i < sb.length(); i++ ) {
    		if( sb.charAt( i ) == '\0' ) {
    			System.out.println( "NULL charAt : " + i );
    			System.out.println( "PREV 10 : " + sb.substring( i - 11, i - 1 ) );
    		}
    	}
    	*/
    	
    	
    	
    	String sqls[] =KJFUtil.str2strs(kicaToSql,"\t");
    	if(sqls != null && sqls.length >0){
    		for(int i=0;i<sqls.length;i++){
    			rDAO.execute(sqls[i]);
    		}
    	}
    	
    	
    	String result= ub.excute(key, kicaToSql);
    	if(!result.equals("1")){
    		if(!WORK_CLASS_CODE.equals("R00013")){ //재교부가 아니면.....
    	    	ReportEntity rEntity     = null;
    	    	
    	    	rEntity = rDAO.select(TB_TMP_COMM_ACCEPT_MT_SQL);
    	    	
    	    	String comm_office = rEntity.getValue(0,"COMM_OFFICE");
    	    	String accept_no = rEntity.getValue(0,"ACCEPT_NO");
    	    	
    	    	String delresult =kicaRollback(comm_office, accept_no, WORK_CLASS_CODE);
    	    	if(!delresult.equals("1")){	
    	    		throw new Exception("Kica 롤백처리 실패:"+ delresult);
    	    	}	
    		}
    		throw new Exception("Kica 서버 오류(롤백처리 성공) :"+ result);
    	}
    	
    }    
    
    
    
    public  String  getKicaToInsSql( String sql, String tbName, String now_dt)throws Exception {
    	
	
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEntity     = null;
    	String header="";
    	
    	KicaLog.log(sql);
    	rEntity = rDAO.select(sql);
    	
    	if( rEntity==null || rEntity.getRowCnt()==0){
    		return "";
    	}
		for(int j=0; j< rEntity.getFieldCnt();j++ ){
			header += rEntity.getName(j)+", ";;    			
		}    	    
		header =  header.substring(0, header.length()-2);
    	
    	
    	String rows_seq="";
    	StringBuffer sb = new StringBuffer();
    	for(int i=0; i< rEntity.getRowCnt();i++){
    		sb.append("insert into "+tbName+" ")
    	    .append(" ( "+header+" ) ")
    	    .append(" values ( ");
    		for(int j=0; j< rEntity.getFieldCnt()-1;j++ ){
    			if(j==0) rows_seq += "'"+rEntity.getValue(i,j)+"'"+", ";
    	        sb.append("'"+rEntity.getValue(i,j).replaceAll( "\0", "").trim()+"'")
    				.append(",");    			
    		}
    		sb.append("'"+now_dt+"'").append(" ) ");
    		sb.append("\t");
    	}
    	
    	
    	rows_seq = rows_seq.substring(0, rows_seq.length()-2);
    	//성공로그 남기기
    	insTransLog("U", tbName, rows_seq ,"N");   	
    	
    	return sb.toString();
    	 	
    }
    
    /**
     * 양도양수 접수시 양수자의 이전 정보 가져오기
     * @param tmpWrtNum 현재 TMP_WRT_NUM
     * @throws Exception
     */
    private ReportEntity getATPrevEnt(String recv_num, String sido_code  ) throws Exception {
    	
    	String sql;
    	ReportDAO rDAO = new ReportDAO();
    	ReportEntity rEntity     = null;
    	
    	sql= 
	    	" SELECT  ASSI_TMP_WRT_NUM ,  RECV_NUM ,   TRAN_TMP_WRT_NUM   				\n" +
	    	" FROM PT_R_ASSI_TRANS_STATEMENT B										\n" +
	    	" WHERE 1=1																\n" +
	    	"  AND RECV_NUM = '"+recv_num+"'										\n" +
	    	"  AND SIDO_CODE = '"+sido_code+"'									\n" ;
    		
    	KicaLog.log(sql);
    	rEntity = rDAO.select(sql);

    	
    	return rEntity;
    }    
    

    /**
     * 접수 이전 정보 가져오기
     * @param tmpWrtNum 현재 TMP_WRT_NUM
     * @param chgbreSeq 현재 CHGBRE_SEQ
     * @return 접수이전정보에 해당하는 CHGBRE_SEQ 값
     * @throws Exception
     */
    private ReportEntity getPrevBeforeEnt(String tmpWrtNum, String tb_nm ) throws Exception {
    	
    	String sql;
    	ReportDAO rDAO = new ReportDAO();
    	ReportEntity rEntity     = null;
    	
    	sql= 
	    	" SELECT   A.RECV_NUM,  B.TMP_WRT_NUM        \n" +
	    	" FROM PT_R_COMPANY_MASTER A,										\n" +
	    	"      "+tb_nm+" B										\n" +
	    	" WHERE 1=1																\n" +
	    	"  AND A.RECV_NUM = B.RECV_NUM											\n" +
	    	"  AND A.TMP_WRT_NUM = '"+tmpWrtNum+"'									\n" +
	    	"  ORDER BY TMP_WRT_NUM DESC									\n" ;
    	
    	
    	KicaLog.log(sql);
    	rEntity = rDAO.select(sql);

    	
    	return rEntity;
    }
    
    
    
    /**
     * 협회 삭제쿼리.
     */
    private String kicaRollback(String comm_office, String accept_no, String WORK_CLASS_CODE) throws Exception {
    	
    	
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append("delete from TB_TMP_COMM_ACCEPT_MT where comm_office='"+comm_office+"'  and  accept_no='"+accept_no+"' ");
    	sb.append("\t");
    	sb.append("delete from TB_TMP_COMM_SAUPJA_MT where comm_office='"+comm_office+"'  and  accept_no='"+accept_no+"' ");
    	sb.append("\t");
    	
    	if(WORK_CLASS_CODE.equals("R00001") ||       //신규
    			WORK_CLASS_CODE.equals("R00004")||   //양도양수
    			WORK_CLASS_CODE.equals("R00005") ||  //분할합병
    			WORK_CLASS_CODE.equals("R00011") ||  //법인전환
    			WORK_CLASS_CODE.equals("R00006")    //합병
    			){  
	    	sb.append("delete from TB_TMP_COMM_KEEPTECH_DT where comm_office='"+comm_office+"'  and  accept_no='"+accept_no+"' ");
	    	sb.append("\t");
	    	sb.append("delete from TB_TMP_REP_MT where comm_office='"+comm_office+"'  and  accept_no='"+accept_no+"' ");
	    	sb.append("\t");
	    	sb.append("delete from TB_TMP_KYUMUP_DT where comm_office='"+comm_office+"'  and  accept_no='"+accept_no+"' ");
	    	sb.append("\t");
    	}
 
    	if(WORK_CLASS_CODE.equals("R00004")||   //양도양수
    			WORK_CLASS_CODE.equals("R00005") ||  //분할합병
    			WORK_CLASS_CODE.equals("R00011") ||  //법인전환
    			WORK_CLASS_CODE.equals("R00006")    //합병
    			){ 
        	sb.append("delete from TB_TMP_COMM_BEFORE_DT where comm_office='"+comm_office+"'  and  accept_no='"+accept_no+"' ");
        	sb.append("\t"); 		
    		
    	}
    	
    	if(WORK_CLASS_CODE.equals("R00002")){  //기준신고
        	sb.append("delete from TB_TMP_COMM_RENEW_DT where comm_office='"+comm_office+"'  and  accept_no='"+accept_no+"' ");
        	sb.append("\t"); 		
    	}
    	
    	if(WORK_CLASS_CODE.equals("R00012")){  //행정처분
        	sb.append("delete from TB_TMP_COMM_PUNISH_DT where comm_office='"+comm_office+"'  and  accept_no='"+accept_no+"' ");
        	sb.append("\t"); 		
    	}    	
    	

    	String key= KJFSec.encode("kica"); 
    	KicaLog.log(sb.toString());
    	return ub.excute(key, sb.toString());
    }    
    
    
//  /**
//  * 접수 이전 정보 가져오기
//  * @param tmpWrtNum 현재 TMP_WRT_NUM
//  * @param chgbreSeq 현재 CHGBRE_SEQ
//  * @return 접수이전정보에 해당하는 CHGBRE_SEQ 값
//  * @throws Exception
//  */
// private String getPrevChgbreSeq(String tmpWrtNum, String chgbreSeq ) throws Exception {
// 	
// 	String newChgbreSeq;
// 	String sql;
// 	ReportDAO rDAO = new ReportDAO();
// 	ReportEntity rEntity     = null;
// 	
// 	sql= "SELECT NVL(MAX(TO_NUMBER(CHGBRE_SEQ)),0) SEQ FROM PT_R_BASIC_CHANGE_HISTORY WHERE TMP_WRT_NUM = '" + tmpWrtNum + "' AND TO_NUMBER(CHGBRE_SEQ) <"+chgbreSeq+" AND NAME IS NOT NULL AND REA_CAP IS NOT NULL AND ADDR_ADDR IS NOT NULL AND REP_NM_KOR IS NOT NULL AND OFFICE_AREA IS NOT NULL";
// 	rEntity = rDAO.select(sql);
// 	newChgbreSeq = rEntity.getValue(0,"SEQ");
// 	if( newChgbreSeq.equals( "0" ) ) {
// 		throw new Exception( "접수 이전정보가 없다." );
// 	}
// 	
// 	return newChgbreSeq;
// }    
    
}

