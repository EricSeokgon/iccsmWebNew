package sp.am.cmd;
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

public class AmReceiptMgrC_New2 implements KJFCommand {
	 
		private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public AmReceiptMgrC_New2() {
	    }

	    public AmReceiptMgrC_New2(String next_url) {
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
	        String scWRT_NUM = vl.getValueAsString("scWRT_NUM");
	        String scCHECK = vl.getValueAsString("CHECK");
	         
	        ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity rMasterEntity     = null;
	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        if (scCHECK.equalsIgnoreCase("TRUE"))
	        {
	        	sQuery.append(" SELECT * FROM PT_M_MASTER ");
	        	sWhere.append(" WHERE	1=1	\n");
	        	sWhere.append("  AND	TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' \n");
	        	sWhere.append("  AND	WRT_NUM = '" + scWRT_NUM + "' \n");
		    	
		    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
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
		      	sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
			
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
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output1");
	        }
	  	        
	        //KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");        
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
