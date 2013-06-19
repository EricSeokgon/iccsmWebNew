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
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** ���� ȹ�� **/
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
           
        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"ds_code");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }
}
