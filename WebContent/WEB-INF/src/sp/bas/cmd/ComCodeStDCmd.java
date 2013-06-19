package sp.bas.cmd;
import javax.servlet.http.HttpServletRequest;
import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;


import org.apache.struts.action.ActionForm;

import sp.dao.PT_COM_CODEDAO;
import sp.dao.PT_COM_CODEEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;
public class ComCodeStDCmd implements KJFCommand {
		
	    private String next;
	    
	    private PT_COM_CODEDAO    PT_COM_CODEdao = new PT_COM_CODEDAO();
	    private PT_COM_CODEEntity PT_COM_CODEEnt = new PT_COM_CODEEntity();
	    
	    private VariableList vl = new VariableList();
	    
	    public ComCodeStDCmd() {
	    }


	    public ComCodeStDCmd(String next_url) {
	    	next = next_url;
	    }


	    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
	    	/****** Service API 초기화 ******/
	    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
	    	/** Web Server에서 XML수신 및 Parsing **/
	    	pReq.receiveData(); 	
	        StringBuilder sQuery = new StringBuilder();
	    	Dataset ds = pReq.getDatasetList().getDataset("dsPT_COM_CODE");
	    	if(ds != null) dsProc(ds);
	    	
	        
	    	
	    	
	    	
	    	return next;  	
	    } 
	    private void dsProc(Dataset ds) throws Exception
	    {
	    	for(int i=0;i<ds.getRowCount();i++){
	    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);	    			
	    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
	    	}

	    	/****** Dataset을 DELETE처리 ****/
	    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
	    		deleteExe(ds,i);
	    	}
	    }
	    
	    private void insertExe(Dataset ds, int arg_row)throws Exception{
	    	
	        String SEQ = KJFDBUtil.getMaxID("SEQ", "PT_COM_CODE");
	      
	        
	        PT_COM_CODEEnt.setDsOnlyString(ds, arg_row);
	        PT_COM_CODEEnt.setSEQ(SEQ);
	    	KJFLog.debug(PT_COM_CODEEnt.toString());
	       	PT_COM_CODEdao.insert(PT_COM_CODEEnt);
	   
	    }
	    private void updateExe(Dataset ds, int arg_row)throws Exception{
    	
	    	PT_COM_CODEEnt.setDsOnlyString(ds, arg_row);// 
	     	KJFLog.debug(PT_COM_CODEEnt.toString());
	     	PT_COM_CODEdao.update(PT_COM_CODEEnt);
	    }
	    private void deleteExe(Dataset ds, int arg_row)throws Exception{
	       	String sKey = ds.getDeleteColumn(arg_row,"SEQ").getString();
	    	
	       	
	       	int i = 1;
	    	StringBuilder sQuery = new StringBuilder();
	    	StringBuilder sWhere = new StringBuilder();
	    	
	    	ReportDAO rDAO = new ReportDAO();
    		sQuery.append(" DELETE FROM PT_COM_CODE ");
    		sWhere.append(" WHERE SEQ = ? ");
    		
    		rDAO.setValue(i++, sKey);
    	
        	
        	rDAO.execute(sQuery.toString() + sWhere.toString());
        	sQuery.delete(0, sQuery.length());
        	sWhere.delete(0, sWhere.length());
	    
	    
	    }
	
}
