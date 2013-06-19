package sp.amr.cmd;
import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class AmReceiptMgrC implements KJFCommand {
	 
		private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public AmReceiptMgrC() {
	    }

	    public AmReceiptMgrC(String next_url) {
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
	        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
	        String scWRT_NUM = vl.getValueAsString("scWRT_NUM");
	        System.out.println("KEY ============= " + scWRT_NUM);
	        String scCHECK = vl.getValueAsString("CHECK");
	        String scDOC_CODE = vl.getValueAsString("DOC_CODE");
	        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
	        
	        ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity rMasterEntity     = null;
	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        if (scCHECK.equalsIgnoreCase("TRUE"))
	        {
	        	sQuery.append(" SELECT * FROM PT_M_MGR ");
	        	sWhere.append(" WHERE	1=1	\n");
	        	//sWhere.append("  AND	TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' \n");
	        	sWhere.append("  AND	COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n");
	        	sWhere.append("  AND	WRT_NUM = '" + scWRT_NUM + "' \n");
	        	
		    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    	sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
		        
		        sQuery.append(" SELECT * FROM PT_M_MASTER ");
	        	sWhere.append(" WHERE	1=1	\n");
	        	sWhere.append("  AND	TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' \n");
	        	sWhere.append("  AND	COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n");
	        	
		    	
		    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    	sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output1");
		        
		    	sQuery.append(" SELECT PT_C.*, PT_C5.SIDO_NM AS PUNISHMENT_AGENCY FROM PT_R_COMPANY_MASTER PT_C ");
	            sQuery.append(" LEFT JOIN (SELECT AREA_CODE, SIDO_NM FROM PT_SIDO_CODE WHERE SIGUNGU_NM = '본청' )PT_C5 ON  PT_C.SIDO_CODE = PT_C5.AREA_CODE ");
	        	sWhere.append(" WHERE	1=1	\n");
	        	sWhere.append("  AND	TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' \n");
	        	
	        	
	        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    	sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
		        
		        sQuery.append(" SELECT DECODE(DISPO_CLASS,'1','경고','2','영업정지','3','등록취소','4','제 78조관련 과태료') AS DISPO_CLASS FROM PT_M_MGR ");
	         	sWhere.append(" WHERE	1=1	\n");
	         	sWhere.append("  AND	MOT_STE =  'C00001'  \n");
	         	sWhere.append("  AND	COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	        }
	        
	        if (scCHECK.equalsIgnoreCase("KKK"))
	        {
	        	/*
	        	sQuery.append(" SELECT * FROM PT_R_COMPANY_MASTER ");
	        	sWhere.append(" WHERE	1=1	\n");
	        	sWhere.append("  AND	TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' \n");
	        	//sWhere.append("  AND	WRT_NUM = '" + scWRT_NUM + "' \n");
		    	*/
	            	          
	        	sQuery.append(" SELECT PT_C.*, PT_C5.SIDO_NM AS PUNISHMENT_AGENCY FROM PT_R_COMPANY_MASTER PT_C ");
	            sQuery.append(" LEFT JOIN (SELECT AREA_CODE, SIDO_NM FROM PT_SIDO_CODE WHERE SIGUNGU_NM = '본청' )PT_C5 ON  PT_C.SIDO_CODE = PT_C5.AREA_CODE ");
	        	sWhere.append(" WHERE	1=1	\n");
	        	sWhere.append("  AND	TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' \n");
	        	//sWhere.append("  AND	WRT_NUM = '" + scWRT_NUM + "' \n");
	        	
		    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
		        sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		       	
		        sQuery.append(" SELECT NVL(MAX(to_number(M_SEQ)), 0) + 1 M_SEQ, MAX(M_SEQ) AS TMP_SEQ FROM PT_M_MGR  ");
		        sWhere.append(" WHERE 1 = 1 ");
		        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
			
		        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		        sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output1");
		        

		        sQuery.append(" SELECT  '0' AS CHECKER, PT_C.NAME, PT_C.REP_NM_KOR, PT_M.*,  PT_C1.CODE_NAME AS TMPD_PER_CODE,DECODE(PT_M.DISPO_CONT2,'',PT_C2.CODE_NAME,PT_C2.CODE_NAME ||' 및 '||PT_C2_2.CODE_NAME) AS TMPDISPO_CONT,	      	   ");
		        sQuery.append(" PT_C3.CODE_NAME AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT, DECODE(PUNISHMENT_AGENCY, '서울특별시', '서울', '부산광역시', '부산','울산광역시','울산 ','대구광역시', '대구','경상남도' , '경남', '인천광역시',     ");
		        sQuery.append(" '인천', '경기도', '경기' ,'경상북도','경북','광주광역시','광주','전라남도','전남','대전광역시','대전','충청남도','충남','전라북도','전북','강원도','강원','충청북도','충북','제주특별자치도','제주' ) AS SIDO_NM   ");
		        sQuery.append(" FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM)													   ");
		        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE											   ");
		        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_M.DISPO_CONT = PT_C2.CODE											   ");
		        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2_2 ON PT_M.DISPO_CONT2 = PT_C2_2.CODE											   ");
		        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMSTE' )PT_C3 ON PT_M.MOT_STE = PT_C3.CODE												   ");
		        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMCONT' )PT_C4 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE											   ");
		        sWhere.append(" WHERE 	1 = 1 AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'																					   ");
		        
		        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		        sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
		        
		        sQuery.append(" SELECT DOC_CODE FROM PT_M_MGR ");
	         	sWhere.append(" WHERE	1=1	\n");
	         	sWhere.append("  AND	MOT_STE =  'C00001'  \n");
	         	sWhere.append("  AND	COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	 	       	
	 	        sQuery.append(" SELECT DECODE(DISPO_CLASS,'1','경고','2','영업정지','3','등록취소','4','제 78조관련 과태료') AS DISPO_CLASS FROM PT_M_MGR ");
	         	sWhere.append(" WHERE	1=1	\n");
	         	sWhere.append("  AND	MOT_STE =  'C00001'  \n");
	         	sWhere.append("  AND	COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	 	       	
	 	       sQuery.append(" SELECT      \n");
	 	       sQuery.append(" NVL(BAS_STA_DT,WRT_DT) AS REGSTD_START_DT, TO_CHAR(ADD_MONTHS(NVL(BAS_STA_DT,WRT_DT), 36), 'yyyymmdd') AS REGSTD_END_DT \n");    
	 	       sWhere.append(" FROM PT_R_BASIC_CHANGE_HISTORY \n");
	 	       sWhere.append("WHERE 1=1 \n"); 
	 	       sWhere.append("AND COI_WRT_NUM = '" + scCOI_WRT_NUM + "' AND chgbre_seq=(SELECT max(chgbre_seq) as chgbre_seq FROM PT_R_BASIC_CHANGE_HISTORY WHERE 1=1 AND COI_WRT_NUM = '" + scCOI_WRT_NUM + "' AND STA_CHG_CLASS_CODE ='R00002') \n");   
	 	       sWhere.append("ORDER BY NVL(BAS_STA_DT,WRT_DT) ASC \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	 	       	
				// 2010.01.14. PT_R_ENGINEER_MASTER 사용안함.
				sQuery.append(" SELECT  ");
				sQuery.append(" ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,  ");
				sQuery.append(" EMPL_YMD, RET_YMD, REMARK, WRT_ID, UPD_DT, INS_DT,  ");
				sQuery.append(" SEQ, TMP_WRT_NUM, TMP_FIELD,  ");
				sQuery.append(" CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, CARE_BOOK_ISSUE_NUM, ");
				sQuery.append(" ENGINEER_NM AS NM_KOR, ENGINEER_SSN1 || ENGINEER_SSN2 AS ENGINEER_SSN, TMP_FIELD AS TMP_GRADE ");
				sQuery.append(" FROM PT_R_ENGINEER_CHANGE ");
	        	sWhere.append(" WHERE 1 = 1 ");
	        	sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
	        	sWhere.append(" AND RET_YMD IS NULL ");
	        				
		       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		       	sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
	 	       	
	        }
	         if (scCHECK.equalsIgnoreCase("CHECK2"))
	         {
	         	sQuery.append(" SELECT DOC_CODE, TMP_WRT_NUM FROM PT_R_REGIST_STATEMENT ");
	         	sWhere.append(" WHERE	1=1	\n");
	         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
	         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	 	       	
	 	       	sQuery.append(" SELECT DOC_CODE FROM PT_R_BASIC_STATEMENT ");
	         	sWhere.append(" WHERE	1=1	\n");
	         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
	         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	 	       	
	 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_ASSI_TRANS_STATEMENT ");
	         	sWhere.append(" WHERE	1=1	\n");
	         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
	         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	 	       	
	 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_M_UNION_STATEMENT ");
	         	sWhere.append(" WHERE	1=1	\n");
	         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
	         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	 	       	
	 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_CLOSE_STATEMENT ");
	         	sWhere.append(" WHERE	1=1	\n");
	         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
	         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	 	    	
	 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
	 	        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	 	       	
	        	sQuery.append(" SELECT DOC_CODE FROM PT_M_MASTER ");
	        	sWhere.append(" WHERE	1=1	\n");
	        	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
	        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
		    	
		    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	  	       
	            KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
	            sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	         }
	        //KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");        
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
