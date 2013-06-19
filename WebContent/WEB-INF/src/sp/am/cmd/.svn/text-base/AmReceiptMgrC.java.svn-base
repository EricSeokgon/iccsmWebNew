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
	    	    	
	        String scRECV_NUM = vl.getValueAsString("RECV_NUM");
	        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
	        String scCHECK = vl.getValueAsString("CHECK");
	        
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
	        }
	  	        
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");        
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
