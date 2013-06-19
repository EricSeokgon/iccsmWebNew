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

public class BasComCodeStDCmd implements KJFCommand{
	private String next;
	private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BasComCodeStDCmd(){
    	
    }
    
    public BasComCodeStDCmd(String next_url){
    	next = next_url;
    }
    
public String execute(HttpServletRequest request, ActionForm form) throws Exception {
		
		/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        String scGCode_combo = vl.getValueAsString("scGCode_combo");
        String scCode = vl.getValueAsString("scCode");
        
        
        
        
        String selectSQL =

          	 "SELECT     *       \n"+
          	 /* "  SEQ,            \n"+
          	 "	ZIPCODE,        \n"+	
          	 "	SIDO,  	  		\n"+
          	 "	GUGUN,  	  	\n"+
          	 "	DONG,    	  	\n"+	
          	 "	BUNJI    	  	\n"+	*/
          	 "FROM   PT_COM_CODE  \n"+          	 
          	 "WHERE P_CODE like ?  \n"+	         	 		
          	     	" AND CODE like ?  \n";
        	
           ReportDAO    rDAO        = new ReportDAO();
           ReportEntity rEntity     = null;  
          
           int cnt=1;
          
           if(scGCode_combo != null)rDAO.setValue(cnt++, "%"+scGCode_combo+"%");
           if(scCode != null)rDAO.setValue(cnt++,"%"+scCode+"%");
          
           rEntity = rDAO.select(selectSQL);
           
        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"ds_code");
        
        
        request.setAttribute("dl", dl);
        
    return next;
	}
}
