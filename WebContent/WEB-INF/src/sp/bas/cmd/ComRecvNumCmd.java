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

public class ComRecvNumCmd implements KJFCommand{
	private String next;
	private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ComRecvNumCmd(){
    	
    }
    
    public ComRecvNumCmd(String next_url){
    	next = next_url;
    }
	public String execute(HttpServletRequest request, ActionForm form)throws Exception {
		/****** Service API �ʱ�ȭ ******/
	   	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
	   	/** Web Server���� XML���� �� Parsing **/
	   	pReq.receiveData(); 	
	   	/** ���� ȹ�� **/
	   	vl = pReq.getVariableList();
	      
	    String scRecvNum = vl.getValueAsString("scRecv_num");
	    String scTblName = vl.getValueAsString("scTblName");
	    	
	    String selectSQL = "SELECT RECV_NUM  FROM "+ scTblName +" WHERE RECV_NUM ="+scRecvNum;	 
	    ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;       	           	 
	          	 
        rEntity = rDAO.select(selectSQL);       
	         
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
       
        
        request.setAttribute("dl", dl);
	
		return next;  	           	          
	        	       
	}
}
