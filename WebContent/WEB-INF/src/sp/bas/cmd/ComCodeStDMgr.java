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

public class ComCodeStDMgr implements KJFCommand {
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ComCodeStDMgr() {
    }

    public ComCodeStDMgr(String next_url) {
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
        String scGROUPCODE = vl.getValueAsString("scGROUPCODE");
        String scCODENAME = vl.getValueAsString("scCODENAME");
        
   

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        sQuery.append(" SELECT  '0' AS CHECKER, P_CODE, P_CODE_NAME, CODE, ");
        sQuery.append(" CODE_NAME,SEQ ");
        sQuery.append(" FROM PT_COM_CODE");
        sQuery.append(" WHERE 1=1");   
    
        if(!KJFUtil.isEmpty(scGROUPCODE))
        {
        	sWhere.append(" AND	P_CODE = '" + scGROUPCODE + "'");
      
        }
        if(!KJFUtil.isEmpty(scCODENAME))	
        {
        	sWhere.append(" AND	CODE_NAME LIKE '%" + scCODENAME + "%'");		       	
      
        } 
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
       
        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
        request.setAttribute("dl", dl);  

        return next;
    }

}

