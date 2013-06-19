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

public class StTempletLoadXml implements KJFCommand {
		
	    private String next;	
        private DatasetList  dl = new DatasetList();
        private VariableList vl = new VariableList();
	    
	    public StTempletLoadXml() {
	    }

	    public StTempletLoadXml(String next_url) {
	    	next = next_url;
	    }



	    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
	    	
	    	/****** Service API 초기화 ******/
	    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
	    	/** Web Server에서 XML수신 및 Parsing **/
	    	pReq.receiveData();
	    	/** 변수 획득 **/
	    	vl = pReq.getVariableList();
	    	    	
	       
	        String SampleName = vl.getValueAsString("SAMPLENAME");
	        String UserID = vl.getValueAsString("USERID");
	        String FormID = vl.getValueAsString("FORMID");  	        
	
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity rEntity     = null;
	    	
	        sQuery.append(" SELECT XML FROM PT_XML ");
	        sWhere.append(" WHERE 	1 = 1 ");	 
	        sWhere.append(" AND	USERID ='" + UserID + "' AND FORMID ='" + FormID +"'");
	        sWhere.append(" AND SAMPLENAME = '" + SampleName +"'");
	     
	    	
	        rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 

	        
	        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
	        KJFMi.ReEnt2Ds(dl,rEntity,"output");
	               
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
