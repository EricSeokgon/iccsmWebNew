package sp.bas.cmd;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

public class CheckStDCmd implements KJFCommand {
	private String next;
	private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public CheckStDCmd(){
    	
    }
    
    public CheckStDCmd(String next_url){
    	next = next_url;
    }
    
public String execute(HttpServletRequest request, ActionForm form) throws Exception {
		
		/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;  
    	
    	vl = pReq.getVariableList();
    	
    	String sWorkMODE = vl.getValueAsString("workMODE");
    	
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	if(sWorkMODE.equalsIgnoreCase("CheckStD"))
    	{
	        sQuery.append(" SELECT '0' AS DEFI_OUT, AA.DEFI_CODE, AA.CONT AS DEFI_CONT ");
	        sQuery.append(" FROM PT_R_DEFICIT_CODE AA ");
	        sWhere.append(" WHERE DEFI_GROUP = 'REGDEF' ");
    		
    		rEntity = rDAO.select(sQuery.toString() + sWhere.toString());
            KJFMi.ReEnt2Ds(dl,rEntity,"output");
    	}
    	
    	request.setAttribute("dl", dl);
        
        return next;
	}
}
