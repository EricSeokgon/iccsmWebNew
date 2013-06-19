package sp.bas.cmd;
import javax.servlet.http.HttpServletRequest;
import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.*;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class ComCodeDupChk implements KJFCommand {
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ComCodeDupChk() {
    }

    public ComCodeDupChk(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        String P_CODE = vl.getValueAsString("P_CODE");
        String CODE = vl.getValueAsString("CODE");
        String WORKMODE = vl.getValueAsString("WORKMODE");
        StringBuilder sQuery = new StringBuilder();
        System.out.println(WORKMODE);
        if(WORKMODE.equalsIgnoreCase("GROUPCODE"))
        {
        	sQuery.append(" SELECT P_CODE FROM PT_COM_CODE ");
        	sQuery.append(" WHERE P_CODE ='"+P_CODE +"'");
        	rEntity    = rDAO.select(sQuery.toString());  
    	
    		KJFMi.ReEnt2Ds(dl,rEntity,"output");        
    		request.setAttribute("dl", dl);  
        }
        else 
        {        	
		    sQuery.append(" SELECT CODE FROM PT_COM_CODE ");
			sQuery.append(" WHERE P_CODE ='"+P_CODE +"' AND CODE='" +CODE+"'");
			rEntity    = rDAO.select(sQuery.toString());  
		
			KJFMi.ReEnt2Ds(dl,rEntity,"output");        
			request.setAttribute("dl", dl); 
	    } 	
        return next;
    }
}
