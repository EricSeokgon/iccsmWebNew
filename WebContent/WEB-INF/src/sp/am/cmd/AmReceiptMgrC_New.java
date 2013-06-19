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

public class AmReceiptMgrC_New implements KJFCommand {
	 
		private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public AmReceiptMgrC_New() {
	    }

	    public AmReceiptMgrC_New(String next_url) {
	    	next = next_url;
	    }

	    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
	    	
	    	/****** Service API 초기화 ******/
	    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
	    	/** Web Server에서 XML수신 및 Parsing **/
	    	pReq.receiveData();
	    	/** 변수 획득 **/
	    	vl = pReq.getVariableList();
	    	    	
	        String scRECV_NUM = vl.getValueAsString("RECV_NUM");
	        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
	        String scCHECK = vl.getValueAsString("CHECK");
	        String scDOC_CODE = vl.getValueAsString("DOC_CODE");
	        
	        
	        ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity rMasterEntity     = null;
	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        if (scCHECK.equalsIgnoreCase("TRUE"))
	        {
	        	sQuery.append(" SELECT RECV_NUM FROM PT_M_MASTER ");
	        	sWhere.append(" WHERE	1=1	\n");
	        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
	        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
		    	
		    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
		        sQuery.delete(0, sQuery.length());
	 	       	sWhere.delete(0, sWhere.length());
	        }else{
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
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
