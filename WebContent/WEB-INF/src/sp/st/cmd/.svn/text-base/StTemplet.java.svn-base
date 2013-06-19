package sp.st.cmd;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_TEMPLETDAO;
import sp.dao.PT_TEMPLETEntity;
import sp.dao.PT_XMLDAO;
import sp.dao.PT_XMLEntity;


import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;
import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.util.KJFLog;

public class StTemplet implements KJFCommand{
	private String next;	
    private VariableList vl = new VariableList();
   
   
    private PT_TEMPLETDAO    PT_TEMPLETdao = new PT_TEMPLETDAO();
    private PT_TEMPLETEntity PT_TEMPLETEnt = new PT_TEMPLETEntity();
    private PT_XMLDAO    PT_XMLdao = new PT_XMLDAO();
    private PT_XMLEntity PT_XMLEnt = new PT_XMLEntity();

    public StTemplet() {
    }

    public StTemplet(String next_url) {
     	next = next_url;
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
   	   	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    
    	Dataset ds;
    	ds = pReq.getDatasetList().getDataset("ds_PT_TEMPLET");
    	dsProc(ds);

    	ds = pReq.getDatasetList().getDataset("ds_PT_XML");
    	dsProc(ds);
    	
    	return next; 
    }
    private void dsProc(Dataset ds) throws Exception
    {
    	for(int i = 0; i < ds.getRowCount(); i++){
    		insertExe(ds,i);
    	}
    }
     private void insertExe(Dataset ds, int arg_row)throws Exception{
    	        
    	 if(ds.getId().equalsIgnoreCase("ds_PT_TEMPLET"))
    	 {
    	    PT_TEMPLETEnt.setDsOnlyString(ds, arg_row);
    	    KJFLog.debug(PT_TEMPLETEnt.toString());   	         
    	    PT_TEMPLETdao.insert(PT_TEMPLETEnt);     
    	 }else  
    	 {
    	    PT_XMLEnt.setDsOnlyString(ds, arg_row);
         	KJFLog.debug(PT_XMLEnt.toString()); 
            PT_XMLdao.insert(PT_XMLEnt);   	    
    	 }
     	       
     }
}
