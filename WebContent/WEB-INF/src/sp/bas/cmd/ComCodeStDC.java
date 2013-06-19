package sp.bas.cmd;

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

public class ComCodeStDC implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ComCodeStDC(){
    }

    public ComCodeStDC(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData();
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();

    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;       	        
        StringBuilder sQuery = new StringBuilder();

        
        sQuery.append("SELECT DISTINCT P_CODE, P_CODE_NAME FROM PT_COM_CODE");       
    	rEntity    = rDAO.select(sQuery.toString());    	

        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
        request.setAttribute("dl", dl);  

        return next;
    }

}
