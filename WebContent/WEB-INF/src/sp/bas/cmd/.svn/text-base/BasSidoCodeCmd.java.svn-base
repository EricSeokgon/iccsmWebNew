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

public class BasSidoCodeCmd implements KJFCommand{
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BasSidoCodeCmd() {
    }

    public BasSidoCodeCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scSidoCode = vl.getValueAsString("scSidoCode");
       
        
        String selectSQL =

          	 "SELECT     *       \n"+
          	 "FROM   PT_COM_CODE  \n"+	          	 
          	 "WHERE  P_CODE like ? \n";	

           ReportDAO    rDAO        = new ReportDAO();
           ReportEntity rEntity     = null;  
           
           int cnt=1;
           rDAO.setValue(cnt++, "%"+scSidoCode+"%");
           
           rEntity = rDAO.select(selectSQL);
           
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"ds_code");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }
}
