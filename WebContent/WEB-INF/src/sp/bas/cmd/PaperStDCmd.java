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

public class PaperStDCmd implements KJFCommand {
	private String next;
	private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public PaperStDCmd(){
    	
    }
    
    public PaperStDCmd(String next_url){
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
    	String _scDEFI_GROUP = vl.getValueAsString("_scDEFI_GROUP");
    	
    	if ("".equals(_scDEFI_GROUP) || "null".equals(_scDEFI_GROUP))
    	{
    		_scDEFI_GROUP = "GUBU";
    	}
    	
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	if(sWorkMODE.equalsIgnoreCase("PaperStD"))
    	{
	        sQuery.append(" SELECT * ");
	        sQuery.append(" FROM PT_R_DEFICIT_CODE ");
	        sWhere.append(" WHERE DEFI_GROUP = '"+_scDEFI_GROUP+"' ");
    		
    		rEntity = rDAO.select(sQuery.toString() + sWhere.toString());
            KJFMi.ReEnt2Ds(dl,rEntity,"output");
    	}
    	
    	request.setAttribute("dl", dl);
        
        return next;
	}
}
