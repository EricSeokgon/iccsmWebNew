package sp.cm.cmd;
import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;

import org.apache.struts.action.ActionForm;

import sp.util.keng.KengWorker;
import sp.util.keng.Kengineer;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;


public class RegRePublishMgrPCmd implements KJFCommand{
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegRePublishMgrPCmd() {
    }

    public RegRePublishMgrPCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
        String scWorkMODE = vl.getValueAsString("workMODE");
        //String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        //String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scSORT = vl.getValueAsString("scSORT");



        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;
                        
        //코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        if("".equals(scWorkMODE)) scWorkMODE = "ALL";
        
        if (scWorkMODE.equalsIgnoreCase("ALL"))
        {
        	//Company Master
        	sQuery.append(" SELECT * FROM PT_R_COMPANY_MASTER");
        	sWhere.append(" WHERE 1=1 \n");
        	sWhere.append(" AND TMP_WRT_NUM = '" +scTMP_WRT_NUM +"'\n");
        	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	    	
	    	// 테스트용으로 시도가 tete 예외 처리를 위해 wbjeon 2010-08-25
	        String rscSIDO_CODE = rMasterEntity.getValue(0, "SIDO_CODE");
	        
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
        		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output1");
        	}
        	
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
     	
 	       	//Work Capability Table
 	        sQuery.append(" SELECT '0' AS CHECKER, PT_RWC.* FROM PT_R_COMPANY_MASTER PT_RCM");
 	        sQuery.append(" INNER JOIN PT_R_WORK_CAPABILITY PT_RWC ON PT_RCM.TMP_WRT_NUM = PT_RWC.TMP_WRT_NUM");
 	        sWhere.append(" WHERE	1=1	\n");
 	        sWhere.append(" AND PT_RCM.TMP_WRT_NUM ='" +scTMP_WRT_NUM+"'\n");
 	        sWhere.append(" ORDER BY ASSE_DT ASC \n");
 	      	     
       		    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
	    		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	    	}
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
 	       	

	       	// History Table
	       	sQuery.append(" SELECT '0' AS CHECKER, CASE PT_RBCH.STA_CHG_CLASS_CODE WHEN 'R00007' THEN PT_RBCH.ADDR_ADDR WHEN 'R00008' THEN PT_RBCH.REA_CAP WHEN 'R00009' THEN PT_RBCH.REP_NM_KOR WHEN 'R00002' THEN '차기신고일자(' || TO_CHAR(ADD_MONTHS(BAS_STA_DT, 36), 'yyyy-mm-dd') || ')'   END AS VALUE, PT_CC.CODE_NAME, PT_RBCH.CHG_DT, '' AS CONFIRM ");
	       	sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_RBCH ");
	       	sQuery.append(" INNER JOIN(SELECT * FROM PT_COM_CODE WHERE P_CODE = 'REGDIV') PT_CC ON PT_RBCH.STA_CHG_CLASS_CODE = PT_CC.CODE  ");
 	        sWhere.append(" WHERE	1=1	\n");
 	        sWhere.append(" AND PT_RBCH.TMP_WRT_NUM ='" +scTMP_WRT_NUM+"'\n");
 	        sWhere.append(" ORDER BY PT_RBCH.CHG_DT ");
  	     
       		    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
	    		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	    	}
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	       	// M_Master Table
	       	sQuery.append(" SELECT  '0' AS CHECKER, PT_C.NAME, PT_M.*, '' AS CONFIRM, ");
	        sQuery.append(" PT_C1.CODE_NAME AS TMPD_PER_CODE, PT_C2.CODE_NAME AS TMPDISPO_CONT, PT_C3.CODE_NAME AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT ");
	        sQuery.append(" FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M ");
	        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM) ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_M.DISPO_CONT = PT_C2.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMSTE' )PT_C3 ON PT_M.MOT_STE = PT_C3.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMCONT' )PT_C4 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE ");
	        
 	        sWhere.append(" WHERE	1=1	\n");
 	        sWhere.append(" AND PT_M.TMP_WRT_NUM ='" +scTMP_WRT_NUM+"'\n"); 	        
  	        
 	   	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
	    		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
	    	}
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());

	       	
	       	//Engineer
	       	sQuery.append(" SELECT ENGINEER_NM,TMP_WRT_NUM, SEQ, ENGINEER_SSN1 || ENGINEER_SSN2 AS SSN, EMPL_YMD, RET_YMD ");
	        sQuery.append(" FROM PT_R_ENGINEER_CHANGE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
	        sWhere.append(" ORDER BY EMPL_YMD ");
	        //sWhere.append(" AND RET_YMD IS NULL ");
	        
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
		        String[] sSSN = new String[rMasterEntity.getRowCnt()];
		        for(int nLoop = 0; nLoop < rMasterEntity.getRowCnt(); nLoop++)
		        {
		        	sSSN[nLoop] = rMasterEntity.getValue(nLoop, "SSN");
		        }
	        


/********************************************************/
/*	      TEST후 원복해야 함      wbjeon 2010-08-25  		    */
/********************************************************/	
//		        		        Dataset ds = new Dataset("output3");
//		        		        ds.addColumn("CHECKER",ColumnInfo.CY_COLINFO_STRING, 20);
//		        		        ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("ENGINEER_SSN",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("NM_KOR",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("CODE_NAME",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("ENGINEER_GRADE",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("NAME",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("EMPL_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("RET_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("SEQ",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("EDU_COMP_DT",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("E_CONFIRM",ColumnInfo.CY_COLINFO_STRING, 20);
//		        				ds.addColumn("R_CONFIRM",ColumnInfo.CY_COLINFO_STRING, 20);
//		        		        
//		        				
//		        				iccsSelectBySSN(dl, ds, sSSN, rMasterEntity);
		        		        
		        		        
		        if ("tete".equals(rscSIDO_CODE)){
			           KJFMi.ReEnt2Ds(dl,rMasterEntity,"output7");
			    } else {		        
		        
			        Dataset ds = new Dataset("output3");
			        ds.addColumn("CHECKER",ColumnInfo.CY_COLINFO_STRING, 20);
			        ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_NM",ColumnInfo.CY_COLINFO_STRING, 20);
			        ds.addColumn("SSN",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("NM_KOR",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CODE_NAME",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_GRADE",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("NAME",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("EMPL_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("RET_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("SEQ",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("EDU_COMP_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("E_CONFIRM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("R_CONFIRM",ColumnInfo.CY_COLINFO_STRING, 20);
					
					iccsSelectBySSN(dl, ds, sSSN, rMasterEntity);
					dl.addDataset(ds);
			    }
		    }
        }
        
        /**
         * 수정자 : 김원
         * 수정일 : 09/12/19
         * scWorkMODE에 따라서 쿼리 따로 실행
         */
        
        if("baseInfo".equalsIgnoreCase(scWorkMODE)) {
        	//Company Master
        	sQuery.append(" SELECT * FROM PT_R_COMPANY_MASTER");
        	sWhere.append(" WHERE 1=1 \n");
        	sWhere.append(" AND TMP_WRT_NUM = '" +scTMP_WRT_NUM +"'\n");
        	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        	
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
        		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output1");
        	}
        	
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }
        
        if("workCap".equalsIgnoreCase(scWorkMODE)) {
        	//Work Capability Table
 	        sQuery.append(" SELECT '0' AS CHECKER, PT_RWC.*,");
 	        sQuery.append("	CASE"); 
 	        sQuery.append("		WHEN LENGTH(APPL_TERM_START_DT) = 8 AND LENGTH(APPL_TERM_END_DT) = 8 THEN"); 
 	        sQuery.append("			SUBSTR(APPL_TERM_START_DT,0,4) || '/' || SUBSTR(APPL_TERM_START_DT,5,2) || '/' || SUBSTR(APPL_TERM_START_DT,7,2) || ' ∼ ' ||");
 	        sQuery.append("    		SUBSTR(APPL_TERM_END_DT,0,4) || '/' || SUBSTR(APPL_TERM_END_DT,5,2) || '/' || SUBSTR(APPL_TERM_END_DT,7,2)");
 	        sQuery.append("		ELSE ''");
 	        sQuery.append("	END T_TERM_DT"); 
 	        sQuery.append("	FROM PT_R_COMPANY_MASTER PT_RCM");
 	        sQuery.append(" INNER JOIN PT_R_WORK_CAPABILITY PT_RWC ON PT_RCM.TMP_WRT_NUM = PT_RWC.TMP_WRT_NUM");
 	        sWhere.append(" WHERE	1=1	\n");
 	        sWhere.append(" and PT_RWC.seq in(select max(seq) seq from PT_R_WORK_CAPABILITY PT_RWC ");
 	        sWhere.append(" INNER JOIN PT_R_COMPANY_MASTER  PT_RCM ON PT_RCM.TMP_WRT_NUM = PT_RWC.TMP_WRT_NUM");
 	        sWhere.append(" AND PT_RCM.TMP_WRT_NUM ='" +scTMP_WRT_NUM+"')\n");
 	       // sWhere.append(" ORDER BY ASSE_DT ASC \n");
 	        
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
	    		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	    	}
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }
        
        if("engineer".equalsIgnoreCase(scWorkMODE)) {
        	//Engineer
        	
	       	sQuery.append(" SELECT '0' AS CHECKER, ENGINEER_NM AS NM_KOR,TMP_WRT_NUM, SEQ, ENGINEER_SSN1 || ENGINEER_SSN2 AS SSN, TMP_FIELD||' '||CARE_BOOK_ISSUE_NUM AS ENGINEER_GRADE, EMPL_YMD, RET_YMD,TMP_FIELD AS CODE_NAME,TMP_FIELD ,CARE_BOOK_ISSUE_NUM,CARE_BOOK_VAL_START_DT,CARE_BOOK_VAL_END_DT ");
	        sQuery.append(" FROM PT_R_ENGINEER_CHANGE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'  ");
	       
	        /*
        	sQuery.append(" SELECT a.ENGINEER_NM,a.TMP_WRT_NUM, a.SEQ, a.ENGINEER_SSN1 || a.ENGINEER_SSN2 AS SSN,  ");
        	sQuery.append(" a.EMPL_YMD, a.RET_YMD,TMP_FIELD,a.CARE_BOOK_ISSUE_NUM,a.CARE_BOOK_VAL_START_DT,a.CARE_BOOK_VAL_END_DT, b.EDU_COMP_DT ");
        	sQuery.append("   FROM PT_R_ENGINEER_CHANGE a, PT_R_ENGINEER_MASTER b   ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' AND a.ENGINEER_SSN1=b.ENGINEER_SSN1 AND a.ENGINEER_SSN2=b.ENGINEER_SSN2 ");
	        */
	        
	        if (scSORT.equalsIgnoreCase("ALL")){
	        sWhere.append(" ORDER BY RET_YMD DESC ");
	        }
	        else if (scSORT.equalsIgnoreCase("A")){
		   //     sWhere.append(" AND RET_YMD IS NULL ORDER BY RET_YMD DESC  ");
	             sWhere.append(" AND RET_YMD IS NULL ORDER BY EMPL_YMD,ENGINEER_NM ASC ");
	        }
	        else if (scSORT.equalsIgnoreCase("B")){
		        sWhere.append(" AND RET_YMD IS NOT NULL ORDER BY RET_YMD DESC ");
	        }
	        
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
	    		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	    	}
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }
        
	        /*
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	          
	        Dataset ds = new Dataset("output3");
	                ds.addColumn("CHECKER",ColumnInfo.CY_COLINFO_STRING, 20);
	                ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_NM",ColumnInfo.CY_COLINFO_STRING, 20);
	                ds.addColumn("SSN",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("NM_KOR",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CODE_NAME",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_GRADE",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("NAME",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("EMPL_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("RET_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("SEQ",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("EDU_COMP_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("E_CONFIRM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("R_CONFIRM",ColumnInfo.CY_COLINFO_STRING, 20);
			        
					if (rMasterEntity.getRowCnt() != 0 && rMasterEntity != null){
				        
				        String[] sSSN = new String[rMasterEntity.getRowCnt()];
				        for(int nLoop = 0; nLoop < rMasterEntity.getRowCnt(); nLoop++)
				        {
				        	sSSN[nLoop] = rMasterEntity.getValue(nLoop, "SSN");
				        }
		
								iccsSelectBySSN(dl, ds, sSSN, rMasterEntity);
			        }
			        dl.addDataset(ds);
		   
        }
         */
        
        if("chgHistory".equalsIgnoreCase(scWorkMODE)) {
        	/*
        	sQuery.append(" SELECT '0' AS CHECKER, ");
        	sQuery.append("		CASE PT_RBCH.STA_CHG_CLASS_CODE ");
        	sQuery.append("			WHEN 'R00007' THEN PT_RBCH.ADDR_ADDR ");
        	sQuery.append("			WHEN 'R00008' THEN PT_RBCH.REA_CAP ");
        	sQuery.append("			WHEN 'R00009' THEN PT_RBCH.REP_NM_KOR ");
        	sQuery.append("			WHEN 'R00010' THEN PT_RBCH.NAME ");
        	sQuery.append("			WHEN 'R00002' THEN '차기신고일자(' || TO_CHAR(ADD_MONTHS(BAS_STA_DT, 36), 'yyyy-mm-dd') || ')' ");
        	sQuery.append("		END AS VALUE, PT_CC.CODE_NAME, PT_RBCH.CHG_DT, '' AS CONFIRM ");
	       	sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_RBCH ");
	       	sQuery.append(" INNER JOIN(SELECT * FROM PT_COM_CODE WHERE P_CODE = 'REGDIV') PT_CC ON PT_RBCH.STA_CHG_CLASS_CODE = PT_CC.CODE  ");
 	        sWhere.append(" WHERE	1=1	\n");
 	        sWhere.append(" AND PT_RBCH.TMP_WRT_NUM ='" +scTMP_WRT_NUM+"' \n");
 	        sWhere.append(" ORDER BY PT_RBCH.CHG_DT ");
 	        */
        	  sQuery.append(" SELECT '0' AS CHECKER, A.CHGBRE_SEQ,  CASE A.STA_CHG_CLASS_CODE WHEN 'R00007' THEN A.ADDR_ADDR || ' ' || A.ADDR_DETAIL_ADDR WHEN 'R00008' THEN A.REA_CAP     ");
              sQuery.append(" WHEN 'R00009' THEN A.REP_NM_KOR  WHEN 'R00002' THEN '충족 (다음신고예정일:' || TO_CHAR(ADD_MONTHS(BAS_STA_DT, 36), 'yyyy/mm/dd') || ')'  WHEN 'R00010' THEN A.NAME    ");
              sQuery.append(" END AS VALUE,  B.CODE_NAME,  A.CHG_DT,'' AS CONFIRM ");   
              sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY A,   PT_COM_CODE B      ");    
              sWhere.append(" WHERE    1=1 ");
              sWhere.append(" AND A.STA_CHG_CLASS_CODE = B.CODE(+)   AND B.P_CODE = 'REGDIV'   AND A.TMP_WRT_NUM ='" +scTMP_WRT_NUM+ "'   AND A.CHG_DT >(SELECT MAX(NVL(C.CHG_DT,0)) FROM PT_R_BASIC_CHANGE_HISTORY  C "); 
              sWhere.append(" WHERE    1=1             AND C.TMP_WRT_NUM ='" +scTMP_WRT_NUM+ "' ");
              sWhere.append(" AND C.STA_CHG_CLASS_CODE  IN ('R00001', 'R00017', 'R00018' ,'R00016' ,'R00021' ,'R00006', 'R00005' ,'R00011', 'R00004'))   ORDER BY A.CHG_DT ASC ");
               
  	     
       		    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
	    		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	    	}
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }

        if("measure".equalsIgnoreCase(scWorkMODE)) {
        	// M_Master Table 
	       	sQuery.append(" SELECT  '0' AS CHECKER, PT_C.NAME, PT_M.*, '' AS CONFIRM, ");
	        sQuery.append(" PT_C1.CODE_NAME AS TMPD_PER_CODE, PT_C2.CODE_NAME AS TMPDISPO_CONT, PT_C3.CODE_NAME AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT ");
	        sQuery.append(" FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M ");
	        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM) ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_M.DISPO_CONT = PT_C2.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMSTE' )PT_C3 ON PT_M.MOT_STE = PT_C3.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMCONT' )PT_C4 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE ");
	        
 	        sWhere.append(" WHERE	1=1	\n");
 	        sWhere.append(" AND PT_M.TMP_WRT_NUM ='" +scTMP_WRT_NUM+"'\n"); 	        
  	        
 	   	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	    	if (rMasterEntity.getRowCnt() > 0 && rMasterEntity != null){
	    		KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
	    	}
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }
        
        request.setAttribute("dl", dl);  

        return next;
    }
    

	private void iccsSelectBySSN(DatasetList dl, Dataset ds, String[] sSSN, ReportEntity ent) throws Exception
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
    	KengWorker kWorker = new KengWorker();
   		Kengineer kengs[]= kWorker.getKengs(sSSN);
   		
   		if( kengs == null )
  			return;
   		
   		for(int i=0; i < kengs.length;i++ )
   		{
            Kengineer keng = kengs[i];
            // wbjeon 2010-09-17 수정
            String NM_KOR  		= ent.getValue(i,"ENGINEER_NM"); 
            String SSN        	= ent.getValue(i,"SSN");         
            String GRADE     	=  "";    
            String TMP_GRADE	= ent.getValue(i,"TMP_FIELD");    
            String BOOK_NUM     = ent.getValue(i,"CARE_BOOK_ISSUE_NUM");
            String EDU_DT    	= "";
            String S_DT       	= ent.getValue(i,"CARE_BOOK_VAL_START_DT");
            String E_DT       	= ent.getValue(i,"CARE_BOOK_VAL_END_DT");
            String CORP      	= "";
            String EMPL_YMD 	= ent.getValue(i, "EMPL_YMD");
            String RET_YMD 		= ent.getValue(i, "RET_YMD");
            String TMP_WRT_NUM 	= ent.getValue(i, "TMP_WRT_NUM");
            String SEQ ="";

            for (int j = 0; j< ent.getRowCnt(); j++){
	            if (ent.getValue(j,"SSN").equals(keng.getSSN())){	            	
		             NM_KOR  		=   keng.getNM_KOR();	                     
		             SSN        	=   keng.getSSN();          
		             GRADE     		=   keng.getGRADE();      
		             TMP_GRADE		=   keng.getTMP_GRADE(); 
		             BOOK_NUM       =   keng.getBOOK_NUM();  
		             EDU_DT    		=   keng.getEDU_DT();    
		             S_DT       	=   keng.getS_DT();        
		             E_DT       	=   keng.getE_DT();        
		             CORP      		=   keng.getCORP();
		             EMPL_YMD 		= ent.getValue(j, "EMPL_YMD");
		             RET_YMD 		= ent.getValue(j, "RET_YMD");
		             TMP_WRT_NUM 	= ent.getValue(j, "TMP_WRT_NUM");
		             SEQ = ent.getValue(i, "SEQ");		             
	            }
            }
            //sQuery.delete(0, sQuery.length());
            //sWhere.delete(0, sWhere.length());
            
            /*
            sQuery.append(" SELECT NAME FROM PT_R_COMPANY_MASTER ");
            sWhere.append(" WHERE COI_WRT_NUM = '" + CORP + "' ");
            sWhere.append(" AND C_COM_DT IS NULL ");
            
            rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
            */
	            int row = ds.appendRow();
	            ds.setColumn(row, "CARE_BOOK_ISSUE_NUM", BOOK_NUM);
	            ds.setColumn(row, "CHECKER", "0");
				//ds.setColumn(row, "ENGINEER_NM", ENGINEER_NM);
	            ds.setColumn(row, "SSN", SSN);
	            ds.setColumn(row, "ENGINEER_SSN1", SSN.substring(0, 6));
	            ds.setColumn(row, "ENGINEER_SSN2", SSN.substring(6, 13));
	            ds.setColumn(row, "NM_KOR", NM_KOR);
	            ds.setColumn(row, "CARE_BOOK_VAL_START_DT", S_DT);
	            ds.setColumn(row, "CARE_BOOK_VAL_END_DT", E_DT);
	            ds.setColumn(row, "ISSUE_DT", "");
	            ds.setColumn(row, "CODE_NAME", TMP_GRADE);
	            ds.setColumn(row, "ENGINEER_GRADE", GRADE);
	            ds.setColumn(row, "NAME", "");
	            ds.setColumn(row, "EMPL_YMD", EMPL_YMD);
	            ds.setColumn(row, "RET_YMD", RET_YMD);
	            ds.setColumn(row, "TMP_WRT_NUM", TMP_WRT_NUM);
	            ds.setColumn(row, "SEQ", SEQ);
	            ds.setColumn(row, "EDU_COMP_DT", EDU_DT);
	            ds.setColumn(row, "E_CONFIRM", "");
	            ds.setColumn(row, "R_CONFIRM", "");
	   		}
    }

}
