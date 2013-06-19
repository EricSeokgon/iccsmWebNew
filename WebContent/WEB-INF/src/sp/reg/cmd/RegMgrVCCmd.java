package sp.reg.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.LoginException;
import sp.reg.RegParam;
import sp.uent.UserEnt;

import org.apache.struts.action.ActionForm;

public class RegMgrVCCmd implements KJFCommand {

	public String execute(HttpServletRequest request, ActionForm form)
	throws Exception {
		// TODO Auto-generated method stub
	
		String cmd = KJFUtil.print(request.getParameter("cmd"));
		
		masterLoadDetail(request);  //공사업자 기본사항
		resultLoadDetail(request);  //공사실적
		appraisalLoadDetail(request);  //시공능력 평가액
		disposeLoadDetail(request);  //행정처분 사항
		changeLoadDetail(request);  //등록기준신고
		sidelineLoadDetail(request);  //등록기준신고
		technicianLoadDetail(request);  //보유기술자
		close_statementDetail(request);  //폐업정보
		
		return cmd;
	}
	
	/*
	 * 공사업자 기본사항
	 */
	private void masterLoadDetail(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity masterEntity     = null;
        ReportEntity refferEntity     = null;  
        
        String cmd = request.getParameter("cmd");
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        //tmp_wrt_num
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	PT_C.*    \n";	

        String fromSQL=
        	" 	FROM   \n"+
        	" 	PT_R_COMPANY_MASTER PT_C LEFT JOIN   \n"+
			" 	(SELECT CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'BLDDIV')PT_CD   	\n"+
        	" 	ON PT_C.OFFICE_USE_CODE = PT_CD.CODE  \n";	

        String whereSQL = 
        	" 	WHERE 1=1 \n"+
        	" 	AND PT_C.COI_WRT_NUM = '"+p_coi_wrt_num+"'   \n";
      
        masterEntity = rDAO.select(selectSQL + fromSQL + whereSQL);
        
        String refferSQL =
        	" SELECT distinct(A.SSN1||A.SSN2),A.SSN1, A.SSN2, A.NM_KOR \n"+ 
			" 	FROM PT_R_REFFER A WHERE   A.COI_WRT_NUM = '"+p_coi_wrt_num+"' AND (A.POS_CLASS='P1' OR   A.POS_CLASS='P4') AND NVL(A.DEL_YN,'N') != 'Y' \n";
        
        refferEntity = rDAO.select(refferSQL);
        
        int cnt = refferEntity.getRowCnt();
        String ceo_nm = masterEntity.getValue(0, "REP_NM_KOR"); //공동대표 명
        String master_ssn = masterEntity.getValue(0, "REP_SSN1")+masterEntity.getValue(0, "REP_SSN2");
        String sub_ssn = "";
        
        int j = 0;
        
        for(int i=0; i < cnt; i++) {
        	sub_ssn = refferEntity.getValue(i, "SSN1")+refferEntity.getValue(i, "SSN2");
        	
        	if(j == 1) {
        		ceo_nm = ceo_nm + " 외 2명";
        		break;
        	}
        	
        	if(!master_ssn.equals(sub_ssn)) {
        		ceo_nm = ceo_nm + ", "+refferEntity.getValue(i, "NM_KOR");
        		j++;
        	}
        }
        request.setAttribute("ceo_nm", ceo_nm);  //기술자 48명 이상일 경우 활성
        
        request.setAttribute("masterEntity", masterEntity);
	}
	
	/*
	 * 공사실적
	 */
	private void resultLoadDetail(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity resultEntity     = null;
        
        String cmd = request.getParameter("cmd");
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	YEAR, WORK_ROM    \n";	

        String fromSQL=
        	" 	FROM PT_R_WORK_RESULTS  \n";	

        String whereSQL = 
        	" 	WHERE 1=1 \n"+
        	" 	AND TMP_WRT_NUM = (SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"' " +
        			"				AND  (C_COM_DT IS NOT NULL OR TRANS_UNION_PROC IS NOT NULL OR TRANS_UNION_PARENT IS NOT NULL)  )  \n";
        
        
        
        String orderSEQ =
        	" 	ORDER BY YEAR ASC \n";
      
        resultEntity = rDAO.select(selectSQL + fromSQL + whereSQL + orderSEQ);
        
        request.setAttribute("resultEntity", resultEntity);
	}
	
	/*
	 * 시공능력 평가액
	 */
	private void appraisalLoadDetail(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity appraisalEntity     = null;
        
        String cmd = request.getParameter("cmd");
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	ASSE_AOM    \n";	

        String fromSQL=
        	" 	FROM PT_R_WORK_CAPABILITY A  \n";	

        String whereSQL = 
        	" 	WHERE  \n"+
        	" 	A.COI_WRT_NUM='"+p_coi_wrt_num+"' AND A.ASSE_DT = (SELECT MAX(ASSE_DT) FROM PT_R_WORK_CAPABILITY WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"')  \n";
    
        appraisalEntity = rDAO.select(selectSQL + fromSQL + whereSQL);
        
        request.setAttribute("appraisalEntity", appraisalEntity);
	}
	
	/*
	 * 행정처분 사항
	 */
	private void disposeLoadDetail(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity disposeEntity     = null;
        
        String cmd = request.getParameter("cmd");
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	WRT_NUM, DISPO_DT, DISPO_CONT, DISPO_CONT_NM, DISPO_CAUSE, PUNISHMENT_AGENCY , BUSISUSP_START_DT, BUSISUSP_END_DT   \n";	

        String fromSQL=
        	" 	FROM PT_M_MASTER  \n";	

        String whereSQL = 
        	" 	WHERE 1=1 \n"+
        	" 	AND TMP_WRT_NUM = (SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"'   " +
        			"  				AND  (C_COM_DT IS NOT NULL OR TRANS_UNION_PROC IS NOT NULL OR TRANS_UNION_PARENT IS NOT NULL) )    \n";
        
        String orderSEQ =
        	" 	ORDER BY DISPO_DT ASC \n";
      
        disposeEntity = rDAO.select(selectSQL + fromSQL + whereSQL + orderSEQ);
        
        request.setAttribute("disposeEntity", disposeEntity);
	}

	/*
	 * 등록기준신고
	 */
	private void changeLoadDetail(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity changeEntity     = null;
        
        String cmd = request.getParameter("cmd");
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num")); //등록번호
        
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	NVL(BAS_STA_DT,WRT_DT) AS BAS_STA_DT, TO_CHAR(ADD_MONTHS(NVL(BAS_STA_DT,WRT_DT), 36), 'yyyy-mm-dd') AS DUE_DATE, DOC_CODE, NAME, COI_WRT_NUM ,STA_CHG_CLASS_CODE    \n";	

        String fromSQL=
        	" 	FROM PT_R_BASIC_CHANGE_HISTORY  \n";	

        String whereSQL = 
        	" 	WHERE 1=1 \n"+
        	" 	AND COI_WRT_NUM = '"+p_coi_wrt_num+"' AND STA_CHG_CLASS_CODE IN ('R00001','R00002','R00004','R00005','R00006','R00011')  \n";
        
        String orderSEQ =
        	" 	ORDER BY NVL(BAS_STA_DT,WRT_DT) ASC  \n";
      
        changeEntity = rDAO.select(selectSQL + fromSQL + whereSQL + orderSEQ);
        
        request.setAttribute("changeEntity", changeEntity);
	}
	
	/*
	 * 겸업사항
	 */
	private void sidelineLoadDetail(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity sidelineEntity     = null;
        
        String cmd = request.getParameter("cmd");
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num")); //등록번호
        
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	SUB_WRT_NUM, SUB_CODE, WRT_ID, substr(INS_DT,0,10) AS  INS_DT,   \n"+ 
			" 	(SELECT COM.CODE_NAME FROM PT_COM_CODE COM WHERE COM.CODE=SUB_CODE) AS SUB_NM    \n";

        String fromSQL=
        	" 	FROM PT_R_SUBSIDIARY  \n";	

        String whereSQL = 
        	" 	WHERE 1=1 \n"+
        	" 	AND TMP_WRT_NUM = (SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"'   " +
        			"				AND  (C_COM_DT IS NOT NULL OR TRANS_UNION_PROC IS NOT NULL OR TRANS_UNION_PARENT IS NOT NULL)  )  \n";
        
        String orderSEQ =
        	" 	ORDER BY SEQ ASC \n";
      
        sidelineEntity = rDAO.select(selectSQL + fromSQL + whereSQL + orderSEQ);
        
        request.setAttribute("sidelineEntity", sidelineEntity);
	}
	
	/*
	 * 보유기술자
	 */
	private void technicianLoadDetail(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity technicianEntity     = null;
        
        String cmd = request.getParameter("cmd");
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num")); //등록번호
        
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,   EMPL_YMD,  TMP_FIELD    \n";

        String fromSQL=
        	" 	FROM PT_R_ENGINEER_CHANGE    \n";	

        String whereSQL = 
        	" 	WHERE 1=1 \n"+
        	" 	AND TMP_WRT_NUM = (SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"'" +
        			"	AND  (C_COM_DT IS NOT NULL OR TRANS_UNION_PROC IS NOT NULL OR TRANS_UNION_PARENT IS NOT NULL) ) AND RET_YMD IS NULL \n";
        
        String orderSEQ =
        	" 	ORDER BY ENGINEER_SSN1 ASC \n";
      
        technicianEntity = rDAO.select(selectSQL + fromSQL + whereSQL + orderSEQ);
        
        request.setAttribute("technicianEntity", technicianEntity);
	}	
	
	
	/*
	 * 폐업젇보
	 */
	private void close_statementDetail(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity close_statement     = null;
        
        String cmd = request.getParameter("cmd");
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num")); //등록번호
        
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	C.SIDO_NM, M.C_COM_DT, M.C_COM_CAUSE    \n";

        String fromSQL=
        	" 	FROM PT_R_CLOSE_STATEMENT M, PT_SIDO_CODE C    \n";	

        String whereSQL = 
        	" 	WHERE M.SIDO_CODE = C.AREA_CODE \n"+
        	" 	AND M.COI_WRT_NUM  = '"+p_coi_wrt_num+"'  \n";
        
        String orderSEQ =
        	" 	 \n";
      
        close_statement = rDAO.select(selectSQL + fromSQL + whereSQL + orderSEQ);
        
        request.setAttribute("close_statementEntity", close_statement);
	}
	
	
}
