package sp.util.transdb;

import java.sql.SQLException;

import kjf.cfg.Config;
import kjf.db.TX_MGR;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFSec;
import kjf.util.KJFUtil;
//import sp.dao.PT_KICA_TRANS_LOGDAO;
//import sp.dao.PT_KICA_TRANS_LOGEntity;
import sp.webservice.EchoPortTypeProxy;
import sp.webservice.UBAgentPortTypeProxy;

public  class BackupTaskDAO  {
	//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(Config.props.get("KICA_ENDPOINT"));
	//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://localhost/iccsWs/services/UBAgent");

    /**
     *  연계서버에 보낼 테이블의 필드 정보를 가져온다.
     *  
     * @param TB_NM
     * @param CUD_FLAG
     * @throws Exception
     */
    public  void  transLow(String TB_NM,String CUD_FLAG, String SIGUNGU_CODE,String SERVER_ADDR)throws Exception {  
    	BackupTaskSql taskSql = new BackupTaskSql(TB_NM,CUD_FLAG,SIGUNGU_CODE);
    	// 착공전 설계 접수 기본정보
    	String PT_UB_CONSTRUCTION_SQL= taskSql.getPT_UB_CONSTRUCTION();
       	// 착공전설계도 메모
    	String PT_UB_CONMEMO_SQL= taskSql.getPT_UB_CONMEMO();
    	// 착공전 세부검토 정보 테이블
    	String PT_UB_CON_DETAIL_SQL= taskSql.getPT_UB_CON_DETAIL();    	
    	// 착공전 검사 흠결
    	String PT_UB_CONDEFICIT_SQL= taskSql.getPT_UB_CONDEFICIT();
    	
    	// 사용전 검사 기본정보
    	String PT_UB_USEBEFORE_SQL= taskSql.getPT_UB_USEBEFORE();
    	// 사용전 검사 메모
    	String PT_UB_MEMO_SQL= taskSql.getPT_UB_MEMO();
    	// 사용전 세부 검토 정보
    	String PT_UB_DETAIL_SQL= taskSql.getPT_UB_DETAIL();
        // 사용전 검사 첨부파일
    	String PT_UB_FILE_SQL= taskSql.getPT_UB_FILE();
        // 사용전 검사 흠결
    	String PT_UB_DEFICIT_SQL= taskSql.getPT_UB_DEFICIT();

    	// 감리결과 관리        
    	String PT_UB_SUVSPOT_SQL= taskSql.getPT_UB_SUVSPOT();
    	// 감리결과 메모
    	String PT_UB_SUVMEMO_SQL= taskSql.getPT_UB_SUVMEMO();
    	// 착공전검사흠결
    	String PT_UB_SUVDEFICIT_SQL= taskSql.getPT_UB_SUVDEFICIT();
    	
    	
    	String now_dt =KJFDate.getCurDatetime();
    	String backupToSql="";
    	String backupToUpdateSql="";
    	
    	if ("C".equals(CUD_FLAG)){
			// 착공전    		
			backupToSql += getBackupToInsSql(PT_UB_CONSTRUCTION_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_CONSTRUCTION_SQL, TB_NM, now_dt);
			backupToSql += getBackupToInsSql(PT_UB_CONMEMO_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_CONMEMO_SQL, TB_NM, now_dt);			
			backupToSql += getBackupToInsSql(PT_UB_CON_DETAIL_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_CON_DETAIL_SQL, TB_NM, now_dt);
			backupToSql += getBackupToInsSql(PT_UB_CONDEFICIT_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_CONDEFICIT_SQL, TB_NM, now_dt);
			// 사용전
			backupToSql += getBackupToInsSql(PT_UB_USEBEFORE_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_USEBEFORE_SQL, TB_NM, now_dt);
			backupToSql += getBackupToInsSql(PT_UB_MEMO_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_MEMO_SQL, TB_NM, now_dt);
			backupToSql += getBackupToInsSql(PT_UB_DETAIL_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_DETAIL_SQL, TB_NM, now_dt);
			backupToSql += getBackupToInsSql(PT_UB_FILE_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_FILE_SQL, TB_NM, now_dt);
			backupToSql += getBackupToInsSql(PT_UB_DEFICIT_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_DEFICIT_SQL, TB_NM, now_dt);
			// 감리
			backupToSql += getBackupToInsSql(PT_UB_SUVSPOT_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_SUVSPOT_SQL, TB_NM, now_dt);
			backupToSql += getBackupToInsSql(PT_UB_SUVMEMO_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_SUVMEMO_SQL, TB_NM, now_dt);
			backupToSql += getBackupToInsSql(PT_UB_SUVDEFICIT_SQL, TB_NM, now_dt);
			backupToUpdateSql += getBackupToInsUpdateSql(PT_UB_SUVDEFICIT_SQL, TB_NM, now_dt);

    	} else if ("U".equals(CUD_FLAG)){
    		// 착공전90
//    		backupToSql += getBackupToUpdSql(PT_UB_CONSTRUCTION_SQL, TB_NM, now_dt);
//    		backupToUpdateSql += getBackupToUpdateSql(PT_UB_CONSTRUCTION_SQL, TB_NM, now_dt);    		
//			backupToSql += getBackupToUpdSql(PT_UB_CONMEMO_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_CONMEMO_SQL, TB_NM, now_dt);
//			backupToSql += getBackupToUpdSql(PT_UB_CON_DETAIL_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_CON_DETAIL_SQL, TB_NM, now_dt);
//			backupToSql += getBackupToUpdSql(PT_UB_CONDEFICIT_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_CONDEFICIT_SQL, TB_NM, now_dt);
//			// 사용전
//			backupToSql += getBackupToUpdSql(PT_UB_USEBEFORE_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_USEBEFORE_SQL, TB_NM, now_dt);
//			backupToSql += getBackupToUpdSql(PT_UB_MEMO_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_MEMO_SQL, TB_NM, now_dt);
//			backupToSql += getBackupToUpdSql(PT_UB_DETAIL_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_DETAIL_SQL, TB_NM, now_dt);
//			backupToSql += getBackupToUpdSql(PT_UB_FILE_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_FILE_SQL, TB_NM, now_dt);
//			backupToSql += getBackupToUpdSql(PT_UB_DEFICIT_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_DEFICIT_SQL, TB_NM, now_dt);
//			// 감리
//			backupToSql += getBackupToUpdSql(PT_UB_SUVSPOT_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_SUVSPOT_SQL, TB_NM, now_dt);
//			backupToSql += getBackupToUpdSql(PT_UB_SUVMEMO_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_SUVMEMO_SQL, TB_NM, now_dt);
//			backupToSql += getBackupToUpdSql(PT_UB_SUVDEFICIT_SQL, TB_NM, now_dt);
//			backupToUpdateSql += getBackupToUpdateSql(PT_UB_SUVDEFICIT_SQL, TB_NM, now_dt);
//			
    	} else if ("D".equals(CUD_FLAG)){
    		
    	}
    	
    	UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(SERVER_ADDR+"/iccsWs/services/UBAgent");
    	
    	//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://99.1.16.140/iccsWs/services/UBAgent");

    	//웹 서비스 구동 확인
    	//EchoPortTypeProxy ec =new EchoPortTypeProxy("http://105.30.1.50/iccsWs/services/Echo");
    	//System.out.println("##############"+ec.getWecome("abc"));
    	//String key = KJFSec.encode("ggae"); //안성시청 
    	String key = KJFSec.encode("bsgs"); 
    	
    	//정상실행시 변경해야 함.
//    	ReportDAO rDAO = new ReportDAO();
//    	if(KJFUtil.print(backupToSql)!=""){
//	    	String sqls[] =KJFUtil.str2strs(backupToSql,"\t");
//	    	if(sqls != null && sqls.length >0){
//	    		for(int i=0;i<sqls.length;i++){
//	    			System.out.println(i+" == "+ sqls[i]);
//	    			//rDAO.execute(sqls[i]);      
//	    		}
//	    	}
//    	}
    
//		System.out.println(ub.getEndpoint());
    	
     	String result="";
     	
     	result = ub.excute(key, backupToSql);
     	
//     	System.out.println("##"+result);
    	if(!result.equals("1")){
    		throw new Exception("BACKUP 서버 오류 :"+ result);
    	} else {
        	ReportDAO rDAO = new ReportDAO();
        	if(KJFUtil.print(backupToUpdateSql)!=""){
        		System.out.println("++"+backupToUpdateSql);
    	    	String sqls[] =KJFUtil.str2strs(backupToUpdateSql,"\t\t");
    	    	if(sqls != null && sqls.length >0){
    	    		for(int i=0;i<sqls.length;i++){
    	    			System.out.println(sqls[i]);
    	    			KJFLog.log(sqls[i]);
    	    			//rDAO.execute(sqls[i]);      
    	    		}
    	    	}
        	}
    	}
    }
    
    public  void insTransLog(String U_D_FLAG, 
			String TABLE_NAME,
			String LOG,
			String ERR_YN  )throws Exception {
			//PT_KICA_TRANS_LOGDAO    PT_KICA_TRANS_LOGdao = new PT_KICA_TRANS_LOGDAO();
			//PT_KICA_TRANS_LOGEntity PT_KICA_TRANS_LOGent = new PT_KICA_TRANS_LOGEntity();    	
			//
			//String SEQ = KJFDBUtil.getMaxID("SEQ", "PT_KICA_TRANS_LOG");
			//String now_dt =KJFDate.getCurDatetime();
			//
			//PT_KICA_TRANS_LOGent.setSEQ(SEQ);
			//PT_KICA_TRANS_LOGent.setU_D_FLAG(U_D_FLAG);
			//PT_KICA_TRANS_LOGent.setTABLE_NAME(TABLE_NAME);
			//PT_KICA_TRANS_LOGent.setLOG(LOG);
			//PT_KICA_TRANS_LOGent.setERR_YN(ERR_YN);
			//PT_KICA_TRANS_LOGent.setUPD_DT(now_dt);
			//PT_KICA_TRANS_LOGent.setINS_DT(now_dt);
			//PT_KICA_TRANS_LOGdao.insert(PT_KICA_TRANS_LOGent);
    }  


    /**
     *  
     *  시군구 데이터 전송후 시도행정 데이터에 전송일자 및 업데이터 날자(수정된 데이터 체크를 위해)를 저장한다.
     * @param TB_NM
     * @param CUD_FLAG
     * @param NOW_DT
     * @param KEY1
     * @param KEY2
     * @param KEY3
     * @param KEY4
     * @param KEY5
     * @throws Exception
     */
    public  void TransOfAfterDate(String TB_NM,String CUD_FLAG,String NOW_DT,String KEY1,String KEY2,String KEY3,String KEY4,String KEY5 )throws SQLException, Exception {
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEnt 		 = null;
    	System.out.println("====TransOfAfterDate=====");
    	String updateSql = " UPDATE " + TB_NM + " \n" + 
    					   " SET BACKUP_TRANS_DT = '" + NOW_DT + "'";
    	
    	if ("U".equals(CUD_FLAG)){ updateSql += " , UPD_DT_OLD = '"+KEY5+"'";}
    	
    	if ("PT_UB_CONSTRUCTION".equals(TB_NM) || "PT_UB_USEBEFORE".equals(TB_NM)){
    		updateSql 		+=  " WHERE  RECV_NUM 			= '"+KEY1+"' 	\n"+ //접수번호
    					   		"  		AND SIDO_CODE 		= '"+KEY2+"' 	\n"+ //시도코드
    					   		"  		AND SIGUNGU_CODE  	= '"+KEY3+"' 	\n"+ //시군구코드
    							"		AND PROC_STE ='3' \n";
    	} else if("PT_UB_SUVSPOT".equals(TB_NM)){
    		updateSql 		+=  " WHERE  RECV_NUM 			= '"+KEY1+"' 	\n"+ //접수번호
	   							"  		AND SIDO_CODE 		= '"+KEY2+"' 	\n"+ //시도코드
	   							"  		AND SIGUNGU_CODE  	= '"+KEY3+"' 	\n"; //시군구코드    		
    	} else if ("PT_UB_MEMO".equals(TB_NM) || "PT_UB_FILE".equals(TB_NM) || "PT_UB_SUVMEMO".equals(TB_NM) || "PT_UB_SUVMEMO".equals(TB_NM)){
    		if ("PT_UB_SUVMEMO".equals(TB_NM)){
    			updateSql 		+=  " WHERE  SEQ 				= '"+KEY4+"' 	\n"; //일련번호
    		} else {
    			updateSql 		+=  " WHERE  SEQ 				= "+KJFUtil.str2int(KEY4)+" 	\n"; //일련번호    			
    		}
    		
    		updateSql 		+=  " WHERE  SEQ 				= '"+KEY1+"' 	\n"+ //일련번호
	    						"  AND RECV_NUM 			= '"+KEY2+"' 	\n"+ //접수번호
	    						"  AND SIDO_CODE 			= '"+KEY3+"' 	\n"+ //시도코드
	    						"  AND SIGUNGU_CODE 		= '"+KEY4+"' 	\n"; //시군구코드
    	} else if ("PT_UB_CON_DETAIL".equals(TB_NM) || "PT_UB_DETAIL".equals(TB_NM)){
    		updateSql 		+=  " WHERE SRL					= '"+KEY1+"' 	\n"+ //일련번호
	    						"  AND RECV_NUM 			= '"+KEY2+"' 	\n"+ //접수번호
	    						"  AND SIDO_CODE 			= '"+KEY3+"' 	\n"+ //시도코드
	    						"  AND SIGUNGU_CODE 		= '"+KEY4+"' 	\n"; //시군구코드
    	} else if ("PT_UB_CONDEFICIT".equals(TB_NM) || "PT_UB_DEFICIT".equals(TB_NM) || "PT_UB_SUVDEFICIT".equals(TB_NM)){
    		updateSql 		+=  " WHERE DEFI_SEQ			= '"+KEY1+"' 	\n"+ //일련번호
	    						"  AND RECV_NUM 			= '"+KEY2+"' 	\n"+ //접수번호
	    						"  AND SIDO_CODE 			= '"+KEY3+"' 	\n"+ //시도코드
	    						"  AND SIGUNGU_CODE 		= '"+KEY4+"' 	\n"; //시군구코드
    	}
    	
    	//KJFLog.log("백업된 날자 " +updateSql);
    	
       	KJFLog.log("전송후 업데이트 날자 저장"+ updateSql);
       	rDAO.execute(updateSql);                        
         	
	}   
    
        
    /**
     * 1. 연계서버에 보낼 쿼리문 조합 (INSERT) 
     * @param sql
     * @param tbName
     * @param now_dt
     * @return
     * @throws Exception
     */
    public  String  getBackupToInsSql( String sql, String tbName, String now_dt)throws Exception {
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEntity     = null;
    	String header="";
    	String rows_seq="";
    	StringBuffer sb = new StringBuffer();
    	
    	if ("NOT".equals(sql)){
    		sb.append("");
    	} else {

    		rEntity = rDAO.select(sql);
    		
	    	if( rEntity==null || rEntity.getRowCnt()==0){
	    		return "";
	    	}
			for(int j=0; j< rEntity.getFieldCnt();j++ ){
				header += rEntity.getName(j)+", ";    			
			} 
			header += " RECEIVER_DT ";
			//header =  header.substring(0, header.length()-2);

	    	for(int i=0; i< rEntity.getRowCnt();i++){
	    		sb.append("INSERT INTO "+tbName+"_B ") //테스트 용으로 _B 를 붙임
	    	    .append(" ( "+header+" ) ")
	    	    .append(" VALUES ( ");
	    		for(int j=0; j< rEntity.getFieldCnt();j++ ){
	    			if(j==0) rows_seq += "'"+rEntity.getValue(i,"RECV_NUM")+"/"+rEntity.getValue(i,"SIDO_CODE")+"/"+rEntity.getValue(i,"SIGUNGU_CODE")+"'"+", ";
	    	        //sb.append("'"+KJFUtil.print(rEntity.getValue(i,j),"").trim()+"'").append(",");
	    	        sb.append("'"+rEntity.getValue(i,j).trim()+"'");
	    	        sb.append(",");
	    		}
	    		sb.append("'"+now_dt+"'").append(" ) ");
	    		sb.append("\t\t");	    		
	    	}
	    	
	    	
	    	rows_seq = rows_seq.substring(0, rows_seq.length()-2);
	    	//System.out.println("=="+rows_seq);
	    	//성공로그 남기기
	    	
	    	//KJFLog.log("로그"+rows_seq);	    	
	    	//insTransLog("U", tbName, rows_seq ,"N");
	    	
//	    	for(int i=0; i< rEntity.getRowCnt();i++){
//	    		// 시도 테이블에 전송일자 저장
//	    		TransOfAfterDate(tbName,"C",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),"","");
//	    	}
	    	
    	}
    	//System.out.println("추가 ==" +sb.toString());
    	return sb.toString();
    	 	
    }  
 
    
    /**
     * 2. 연계서버에 보낼 쿼리문 조합 (insert 한 원data에 백업 날자 업데이트) 
     * @param sql
     * @param tbName
     * @param now_dt
     * @return
     * @throws Exception
     */
    public  String  getBackupToInsUpdateSql( String sql, String tbName, String now_dt)throws Exception {
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEntity     = null;
    	String header="";
    	String rows_seq="";
    	StringBuffer sb = new StringBuffer();
    	
    	if ("NOT".equals(sql)){
    		sb.append("");
    	} else {
    		if (!"".equals(sql)){
	    		rEntity = rDAO.select(sql);
	    		
		    	if( rEntity==null || rEntity.getRowCnt()==0){
		    		return "";
		    	}
				for(int i=0; i< rEntity.getRowCnt();i++){
					
		    		// 시도 테이블에 전송일자 저장
		        	if ("PT_UB_CONSTRUCTION".equals(tbName) || "PT_UB_USEBEFORE".equals(tbName)){
		        		sb.append("  UPDATE "+ tbName +" SET BACKUP_TRANS_DT = '" + now_dt + "' , UPD_DT_OLD = '"+rEntity.getValue(i,"UPD_DT")+"' \n");
		        		sb.append(" WHERE  RECV_NUM 			= '"+rEntity.getValue(i,"RECV_NUM")+"' 	\n"); //접수번호
		        		sb.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"' 	\n"); //시도코드
		    			sb.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"' 	\n"); //시군구코드
		    			sb.append("		AND PROC_STE ='3' \n");						   		
		        	} else if("PT_UB_SUVSPOT".equals(tbName)){		        		
		        		sb.append("  UPDATE "+ tbName +" SET BACKUP_TRANS_DT = '" + now_dt + "' , UPD_DT_OLD = '"+rEntity.getValue(i,"UPD_DT")+"' \n");
		        		sb.append(" WHERE  RECV_NUM 			= '"+rEntity.getValue(i,"RECV_NUM")+"' 	\n"); //접수번호
		        		sb.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"' 	\n"); //시도코드
		    			sb.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"' 	\n"); //시군구코드
		        	} else if ("PT_UB_MEMO".equals(tbName) || "PT_UB_CONMEMO".equals(tbName) || "PT_UB_FILE".equals(tbName) || "PT_UB_SUVMEMO".equals(tbName)){
		        		sb.append("  UPDATE "+ tbName +" SET BACKUP_TRANS_DT = '" + now_dt + "' , UPD_DT_OLD = '"+rEntity.getValue(i,"UPD_DT")+"' ");		        		
		        		if ("PT_UB_SUVMEMO".equals(tbName)){
		        			sb.append(" WHERE SEQ = '"+rEntity.getValue(i,"SEQ")+"' \n"); //일련번호
		        		} else {
		        			sb.append(" WHERE SEQ = "+KJFUtil.str2int(rEntity.getValue(i,"SEQ"))+" \n"); //일련번호    			
		        		}	        		
		        		sb.append("         AND RECV_NUM 		= '"+rEntity.getValue(i,"RECV_NUM")+"' 	\n"); //접수번호
		        		sb.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"' 	\n"); //시도코드
		    			sb.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"' 	\n"); //시군구코드
		    			
		        	} else if ("PT_UB_CON_DETAIL".equals(tbName) || "PT_UB_DETAIL".equals(tbName)){
		        		sb.append("  UPDATE "+ tbName +" SET BACKUP_TRANS_DT = '" + now_dt + "' , UPD_DT_OLD = '"+rEntity.getValue(i,"UPD_DT")+"' \n");
		        		sb.append(" WHERE   SRL					= "+KJFUtil.str2int(rEntity.getValue(i,"SRL"))+"\n"); //일련번호
		        		sb.append("         AND RECV_NUM 		= '"+rEntity.getValue(i,"RECV_NUM")+"' 	\n"); //접수번호
		        		sb.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"' 	\n"); //시도코드
		    			sb.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"' 	\n"); //시군구코드
		    			
		        	} else if ("PT_UB_CONDEFICIT".equals(tbName) || "PT_UB_DEFICIT".equals(tbName) || "PT_UB_SUVDEFICIT".equals(tbName)){
		        		sb.append("  UPDATE "+ tbName +" SET BACKUP_TRANS_DT = '" + now_dt + "' , UPD_DT_OLD = '"+rEntity.getValue(i,"UPD_DT")+"' \n");
		        		sb.append(" WHERE   DEFI_SEQ			= "+KJFUtil.str2int(rEntity.getValue(i,"DEFI_SEQ"))+"\n"); //일련번호
		        		sb.append("         AND RECV_NUM 		= '"+rEntity.getValue(i,"RECV_NUM")+"' 	\n"); //접수번호
		        		sb.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"' 	\n"); //시도코드
		    			sb.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"' 	\n"); //시군구코드
		        	}
		    		sb.append("\t\t");		    		
		    		//sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),"","");
//		    		if ("PT_UB_CONSTRUCTION".equals(tbName) || "PT_UB_USEBEFORE".equals(tbName) || "PT_UB_SUVSPOT".equals(tbName)){
//		    			sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),"",rEntity.getValue(i,"UPD_DT"));
//		        	} else if ("PT_UB_MEMO".equals(tbName) || "PT_UB_CONMEMO".equals(tbName) || "PT_UB_FILE".equals(tbName) || "PT_UB_SUVMEMO".equals(tbName)){
//		    			sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),rEntity.getValue(i,"SEQ"),rEntity.getValue(i,"UPD_DT"));
//		        	} else if ("PT_UB_CON_DETAIL".equals(tbName) || "PT_UB_DETAIL".equals(tbName)){
//		    			sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),rEntity.getValue(i,"SRL"),rEntity.getValue(i,"UPD_DT"));	        		
//		        	} else if ("PT_UB_CONDEFICIT".equals(tbName) || "PT_UB_DEFICIT".equals(tbName) || "PT_UB_SUVDEFICIT".equals(tbName)){
//		    			sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),rEntity.getValue(i,"DEFI_SEQ"),rEntity.getValue(i,"UPD_DT"));	        		
//		        	}
		    	}
				
    		}
    	}
		
    	return sb.toString();
    	 	
    } 
    
    /**
     * 3. 연계서버에  보낼 쿼리문 조합 (UPDATE) 
     * @param sql
     * @param tbName
     * @param now_dt
     * @return
     * @throws Exception
     */
    public  String  getBackupToUpdSql( String sql, String tbName, String now_dt)throws Exception {
    	
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEntity     = null;
    	String header="";
    	String rows_seq="";
    	StringBuffer sb = new StringBuffer();
    	
    	if ("NOT".equals(sql)){
    		sb.append("");
    	} else{	
    		rEntity = rDAO.select(sql.toString());

    		if( rEntity==null || rEntity.getRowCnt()==0){
	    		return "";
	    	}
	    		    	
//	    	for(int j=0; j< rEntity.getFieldCnt();j++ ){
//				if(j==0) header += " SET "+rEntity.getName(j)+"'"+", ";
//				header += rEntity.getName(j)+", ";    			
//			}
//			header =  header.substring(0, header.length()-2);
	    	
	    	if (rEntity != null){
		    	for(int i=0; i< rEntity.getRowCnt();i++){
		    		
		    		sb.append( " UPDATE " + tbName +"_B"); //테스트용으로 _B 붙임
		    
		    		for(int j=0; j< rEntity.getFieldCnt();j++ ){
		        		if (j==0){ 
		        			sb.append(" SET " + rEntity.getName(j) + " = '"+rEntity.getValue(i,j)+"'");
		        		} else {
			    		    sb.append("   , " + rEntity.getName(j) + " = '"+rEntity.getValue(i,j)+"'");
		        		}
		    		}
		        	if ("PT_UB_CONSTRUCTION".equals(tbName) || "PT_UB_USEBEFORE".equals(tbName) || "PT_UB_SUVSPOT".equals(tbName)){
		        		sb.append( " WHERE RECV_NUM = '"+rEntity.getValue(i,"RECV_NUM")+"' AND SIDO_CODE = '"+rEntity.getValue(i,"SIDO_CODE")+"' AND SIGUNGU_CODE = '"+rEntity.getValue(i,"SIGUNGU_CODE")+"'");		        	
		        	} else if ("PT_UB_MEMO".equals(tbName) || "PT_UB_CONMEMO".equals(tbName) || "PT_UB_FILE".equals(tbName) || "PT_UB_SUVMEMO".equals(tbName)){
		        		sb.append( " WHERE SEQ = '"+rEntity.getValue(i,"SEQ")+"' AND RECV_NUM = '"+rEntity.getValue(i,"RECV_NUM")+"' AND SIDO_CODE = '"+rEntity.getValue(i,"SIDO_CODE")+"' AND SIGUNGU_CODE = '"+rEntity.getValue(i,"SIGUNGU_CODE")+"'");
		        	} else if ("PT_UB_CON_DETAIL".equals(tbName) || "PT_UB_DETAIL".equals(tbName)){
		        		sb.append( " WHERE SRL = '"+rEntity.getValue(i,"SRL")+"' AND RECV_NUM = '"+rEntity.getValue(i,"RECV_NUM")+"' AND SIDO_CODE = '"+rEntity.getValue(i,"SIDO_CODE")+"' AND SIGUNGU_CODE = '"+rEntity.getValue(i,"SIGUNGU_CODE")+"'");
		        	} else if ("PT_UB_CONDEFICIT".equals(tbName) || "PT_UB_DEFICIT".equals(tbName) || "PT_UB_SUVDEFICIT".equals(tbName)){
		        		sb.append( " WHERE DEFI_SEQ = '"+rEntity.getValue(i,"DEFI_SEQ")+"' AND RECV_NUM = '"+rEntity.getValue(i,"RECV_NUM")+"' AND SIDO_CODE = '"+rEntity.getValue(i,"SIDO_CODE")+"' AND SIGUNGU_CODE = '"+rEntity.getValue(i,"SIGUNGU_CODE")+"'");		        		
		        	}
		    		
		    		sb.append("\t\t");
		    	}
	    	}
	    	
//	    	for(int i=0; i< rEntity.getRowCnt();i++){
//	    		TransOfAfterDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),"",rEntity.getValue(i,"UPD_DT"));
//	    	}
	    	//rows_seq = rows_seq.substring(0, rows_seq.length()-2);
	    	//성공로그 남기기
	    	//insTransLog("U", tbName, rows_seq ,"N");   	
    	}
    	//System.out.println("업데이트==  "+ sb.toString());
    	return sb.toString();
    	 	
    }    

    /**
     * 4. 연계서버에 보낼 쿼리문 조합 (UPDATE 수행후 백업날자 처리) 
     * @param sql
     * @param tbName
     * @param now_dt
     * @return
     * @throws Exception
     */
    public  String  getBackupToUpdateSql( String sql, String tbName, String now_dt)throws Exception {
    	
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEntity     = null;
    	String header="";
    	String rows_seq="";
    	
    	StringBuffer sb = new StringBuffer();
    	
    	if ("NOT".equals(sql)){
    		sb.append("");
    	} else{	
    		rEntity = rDAO.select(sql.toString());
    		if( rEntity==null || rEntity.getRowCnt()==0){
	    		return "";
	    	}
	    	for(int i=0; i< rEntity.getRowCnt();i++){
	    		
	        	if ("PT_UB_CONSTRUCTION".equals(tbName) || "PT_UB_USEBEFORE".equals(tbName)){
	        		sb.append("UPDATE "+ tbName +" \n")
	        		.append( " SET BACKUP_TRANS_DT = '" + now_dt + "' ")
	    	        .append(" , UPD_DT_OLD = '"+rEntity.getValue(i,"UPD_DT")+"' ")
	        		.append(" WHERE  RECV_NUM 			= '"+rEntity.getValue(i,"RECV_NUM")+"'") //접수번호
	        		.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"'") //시도코드
	    			.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"'") //시군구코드
	    			.append("		AND PROC_STE ='3'");						   		
	        	} else if("PT_UB_SUVSPOT".equals(tbName)){
	        		sb.append("UPDATE "+ tbName +" \n")
	        		.append( " SET BACKUP_TRANS_DT = '" + now_dt + "' ")
	    	        .append(" , UPD_DT_OLD = '"+rEntity.getValue(i,"UPD_DT")+"' ")
	        		.append(" WHERE  RECV_NUM 			= '"+rEntity.getValue(i,"RECV_NUM")+"'") //접수번호
	        		.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"'") //시도코드
	    			.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"'"); //시군구코드
	        	} else if ("PT_UB_MEMO".equals(tbName) || "PT_UB_CONMEMO".equals(tbName) || "PT_UB_FILE".equals(tbName) || "PT_UB_SUVMEMO".equals(tbName)){
	        		if ("PT_UB_SUVMEMO".equals(tbName)){
	        			sb.append(" WHERE SEQ = '"+rEntity.getValue(i,"SEQ")+"' \n"); //일련번호
	        		} else {
	        			sb.append(" WHERE SEQ = "+KJFUtil.str2int(rEntity.getValue(i,"SEQ"))+" \n"); //일련번호    			
	        		}	        		
	        		sb.append("         AND RECV_NUM 		= '"+rEntity.getValue(i,"RECV_NUM")+"' 	\n"); //접수번호
	        		sb.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"' 	\n"); //시도코드
	    			sb.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"' 	\n"); //시군구코드

	        	} else if ("PT_UB_CON_DETAIL".equals(tbName) || "PT_UB_DETAIL".equals(tbName)){
	        		sb.append(" WHERE   SRL					= "+KJFUtil.str2int(rEntity.getValue(i,"SRL"))+"")
	        		.append("         AND RECV_NUM 		= '"+rEntity.getValue(i,"RECV_NUM")+"' 	\n") //접수번호
	        		.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"' 	\n") //시도코드
	    			.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"' 	\n"); //시군구코드
	    			
	        	} else if ("PT_UB_CONDEFICIT".equals(tbName) || "PT_UB_DEFICIT".equals(tbName) || "PT_UB_SUVDEFICIT".equals(tbName)){
	        		sb.append(" WHERE   DEFI_SEQ			= "+KJFUtil.str2int(rEntity.getValue(i,"DEFI_SEQ"))+"\n"); //일련번호
	        		sb.append("         AND RECV_NUM 		= '"+rEntity.getValue(i,"RECV_NUM")+"' 	\n"); //접수번호
	        		sb.append("  		AND SIDO_CODE 		= '"+rEntity.getValue(i,"SIDO_CODE")+"' 	\n"); //시도코드
	    			sb.append("  		AND SIGUNGU_CODE  	= '"+rEntity.getValue(i,"SIGUNGU_CODE")+"' 	\n"); //시군구코드
	        	}
	    		sb.append("\t\t");

	    		
//	    		if ("PT_UB_CONSTRUCTION".equals(tbName) || "PT_UB_USEBEFORE".equals(tbName) || "PT_UB_SUVSPOT".equals(tbName)){
//	    			sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),"",rEntity.getValue(i,"UPD_DT"));
//	        	} else if ("PT_UB_MEMO".equals(tbName) || "PT_UB_CONMEMO".equals(tbName) || "PT_UB_FILE".equals(tbName) || "PT_UB_SUVMEMO".equals(tbName)){
//	    			sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),rEntity.getValue(i,"SEQ"),rEntity.getValue(i,"UPD_DT"));
//	        	} else if ("PT_UB_CON_DETAIL".equals(tbName) || "PT_UB_DETAIL".equals(tbName)){
//	    			sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),rEntity.getValue(i,"SRL"),rEntity.getValue(i,"UPD_DT"));	        		
//	        	} else if ("PT_UB_CONDEFICIT".equals(tbName) || "PT_UB_DEFICIT".equals(tbName) || "PT_UB_SUVDEFICIT".equals(tbName)){
//	    			sb += TransOfAfterUpdateDate(tbName,"U",now_dt,rEntity.getValue(i,"RECV_NUM"),rEntity.getValue(i,"SIDO_CODE"),rEntity.getValue(i,"SIGUNGU_CODE"),rEntity.getValue(i,"DEFI_SEQ"),rEntity.getValue(i,"UPD_DT"));	        		
//	        	}
	    	}
    	}    	
    	return sb.toString();
    	 	
    }
    
    
    /**
     *  
     *  연계서버에 데이터 전송후 시도행정 데이터에 전송일자 및 업데이터 날자(수정된 데이터 체크를 위해)를 저장한다.
     * @param TB_NM
     * @param CUD_FLAG
     * @param NOW_DT
     * @param KEY1
     * @param KEY2
     * @param KEY3
     * @param KEY4
     * @param KEY5
     * @throws Exception
     */
//    public  String TransOfAfterUpdateDate(String TB_NM,String CUD_FLAG,String NOW_DT,String KEY1,String KEY2,String KEY3,String KEY4,String KEY5 )throws SQLException, Exception {
//    	ReportDAO    rDAO        = new ReportDAO();
//    	ReportEntity rEnt 		 = null;
//    	
//    	String updateSql = "";
//    	StringBuffer sb = new StringBuffer();
//  
//    	sb.append("UPDATE "+ TB_NM +" \n");
//    	sb.append( " SET BACKUP_TRANS_DT = '" + NOW_DT + "' \n");
//    	
//    	if ("U".equals(CUD_FLAG)){ sb.append(" , UPD_DT_OLD = '"+KEY5+"' \n");}    	 
//    	
//    	if ("PT_UB_CONSTRUCTION".equals(TB_NM) || "PT_UB_USEBEFORE".equals(TB_NM)){
//    		sb.append(" WHERE  RECV_NUM 			= '"+KEY1+"' 	\n"); //접수번호
//    		sb.append("  		AND SIDO_CODE 		= '"+KEY2+"' 	\n"); //시도코드
//			sb.append("  		AND SIGUNGU_CODE  	= '"+KEY3+"' 	\n"); //시군구코드
//			sb.append("		AND PROC_STE ='3' \n");						   		
//    	} else if("PT_UB_SUVSPOT".equals(TB_NM)){
//    		sb.append(" WHERE  RECV_NUM 			= '"+KEY1+"' 	\n"); //접수번호
//    		sb.append("  		AND SIDO_CODE 		= '"+KEY2+"' 	\n"); //시도코드
//			sb.append("  		AND SIGUNGU_CODE  	= '"+KEY3+"' 	\n"); //시군구코드
//    	} else if ("PT_UB_MEMO".equals(TB_NM) || "PT_UB_CONMEMO".equals(TB_NM) || "PT_UB_FILE".equals(TB_NM) || "PT_UB_SUVMEMO".equals(TB_NM)){
//    		
//    		if ("PT_UB_SUVMEMO".equals(TB_NM)){
//    			sb.append(" WHERE SEQ = '"+KEY4+"' \n"); //일련번호
//    		} else {
//    			sb.append(" WHERE SEQ = "+KJFUtil.str2int(KEY4)+" \n"); //일련번호    			
//    		}
//    		
//    		sb.append("         AND RECV_NUM 		= '"+KEY1+"' 	\n"); //접수번호
//    		sb.append("  		AND SIDO_CODE 		= '"+KEY2+"' 	\n"); //시도코드
//			sb.append("  		AND SIGUNGU_CODE  	= '"+KEY3+"' 	\n"); //시군구코드
//
//    	} else if ("PT_UB_CON_DETAIL".equals(TB_NM) || "PT_UB_DETAIL".equals(TB_NM)){
//    		sb.append(" WHERE   SRL					= "+KJFUtil.str2int(KEY4)+"\n"); //일련번호
//    		sb.append("         AND RECV_NUM 		= '"+KEY1+"' 	\n"); //접수번호
//    		sb.append("  		AND SIDO_CODE 		= '"+KEY2+"' 	\n"); //시도코드
//			sb.append("  		AND SIGUNGU_CODE  	= '"+KEY3+"' 	\n"); //시군구코드
//			
//    	} else if ("PT_UB_CONDEFICIT".equals(TB_NM) || "PT_UB_DEFICIT".equals(TB_NM) || "PT_UB_SUVDEFICIT".equals(TB_NM)){
//    		sb.append(" WHERE   DEFI_SEQ			= "+KJFUtil.str2int(KEY4)+"\n"); //일련번호
//    		sb.append("         AND RECV_NUM 		= '"+KEY1+"' 	\n"); //접수번호
//    		sb.append("  		AND SIDO_CODE 		= '"+KEY2+"' 	\n"); //시도코드
//			sb.append("  		AND SIGUNGU_CODE  	= '"+KEY3+"' 	\n"); //시군구코드
//    	}
//		sb.append("\t\t");
//		
//    	//KJFLog.log("백업된 날자 " +updateSql);
//       //	KJFLog.log("전송후 업데이트 날자 저장"+ updateSql+"\t\t ");
//       	
//       	return sb.toString(); 	
//	}   
// 

}

		 


