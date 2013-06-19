package sp.st.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;


import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class StTempletLoad implements KJFCommand{
	 private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public StTempletLoad() {
	    }

	    public StTempletLoad(String next_url) {
	    	next = next_url;
	    }

	    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
	    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
	    	/** Web Server¿¡¼­ XML¼ö½Å ¹× Parsing **/
	    	pReq.receiveData();
	    	/** º¯¼ö È¹µæ **/
	    	vl = pReq.getVariableList();
	    	
	        ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity rEntity     = null;

	        String scWORK_MODE = vl.getValueAsString("scWORK_MODE");
	        String scUSERID = vl.getValueAsString("scUSERID");
	        String scFORMID = vl.getValueAsString("scFORMID");
	        String scSAMPLENAME = vl.getValueAsString("scSAMPLENAME");
	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();

	        if (scWORK_MODE.equalsIgnoreCase("GET_KEY"))
	        {
	        	sQuery.append(" SELECT SAMPLENAME FROM PT_TEMPLET ");
		        sWhere.append(" WHERE USERID = '" + scUSERID + "'");
		        sWhere.append(" AND FORMID = '" + scFORMID + "'");
		        sWhere.append(" AND SAMPLENAME = '" + scSAMPLENAME + "'");
		        
		    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output");
	        }
	        else if (scWORK_MODE.equalsIgnoreCase("GET_NAME"))
	        {
		        sQuery.append(" SELECT SAMPLENAME FROM PT_TEMPLET ");
		        sWhere.append(" WHERE USERID = '" + scUSERID + "'");
		        sWhere.append(" AND FORMID = '" + scFORMID + "'");
		        
		        rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output");
	        }
	        else
	        {
		        sQuery.append(" SELECT XML, DSNAME FROM PT_XML ");
		        sWhere.append(" WHERE USERID = '" + scUSERID + "'");
		        sWhere.append(" AND FORMID = '" + scFORMID + "'");
		        sWhere.append(" AND SAMPLENAME = '" + scSAMPLENAME + "'");
		        
		        rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output");
	        }
	        	        
	        request.setAttribute("dl", dl);  

	        return next;	    
	    }

}
