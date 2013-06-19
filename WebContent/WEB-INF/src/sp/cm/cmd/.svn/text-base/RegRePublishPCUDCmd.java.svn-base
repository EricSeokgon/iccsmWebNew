package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;



import sp.dao.PT_R_DELIVERY_BOOKDAO;
import sp.dao.PT_R_DELIVERY_BOOKEntity;



import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;

public class RegRePublishPCUDCmd implements KJFCommand{
	
	private String next;
	
    private PT_R_DELIVERY_BOOKDAO    PT_R_DELIVERY_BOOKDao = new PT_R_DELIVERY_BOOKDAO();
    private PT_R_DELIVERY_BOOKEntity PT_R_DELIVERY_BOOKEntity = new PT_R_DELIVERY_BOOKEntity();
   
    
    private VariableList vl = new VariableList();
    
    public RegRePublishPCUDCmd() {
    }


    public RegRePublishPCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API 초기화 ******/ 
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	String scMODE = vl.getValueAsString("workMODE");
    	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds;
    	
    	if (scMODE.equalsIgnoreCase("ALL"))
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DELIVERY_BOOK");
    		dsProc(ds);
    	}
    	
        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception
    {
    	if(ds == null){ 
    		System.out.println(" ds 값이 없습니다");
    	}else{
	    	for(int i=0;i<ds.getRowCount();i++){
	    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);
	    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
	    	}
	
	    	/****** Dataset을 DELETE처리 ****/
	    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
	    		deleteExe(ds,i);
	    	}
    	}
    }

    /**
     * 입력
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{
    	if(ds.getId().equalsIgnoreCase("dsPT_R_DELIVERY_BOOK"))
    	{
    		PT_R_DELIVERY_BOOKEntity.setDsOnlyString(ds, arg_row);// 
    		PT_R_DELIVERY_BOOKEntity.setSEQ(
     	    		getMaxChangeSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_DELIVERY_BOOK"));
    		KJFLog.debug(PT_R_DELIVERY_BOOKEntity.toString()); 		    	
        	PT_R_DELIVERY_BOOKDao.insert(PT_R_DELIVERY_BOOKEntity);
    	}
    	
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	

    	/******특정한 필드를 제외한 수정 ******/
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		PT_R_DELIVERY_BOOKEntity.setDsOnlyString(ds, arg_row);
          	KJFLog.debug(PT_R_DELIVERY_BOOKEntity.toString());
    		PT_R_DELIVERY_BOOKDao.update(PT_R_DELIVERY_BOOKEntity);
    	}
    	

    }
    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String sKey = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    	String sKey2 = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
    	
    	String deleteQuery;
    	
    	ReportDAO rDAO;
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		deleteQuery = " DELETE FROM PT_R_MEMO WHERE RECV_NUM = '" + sKey + "'" + " AND MEMO_SEQ = '" + sSEQ + "'";
    		deleteQuery += " AND SIDO_CODE ='" + sKey2 + "' ";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY_COMPANY"))
    	{
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		deleteQuery = " DELETE FROM PT_R_SUBSIDIARY_COMPANY WHERE RECV_NUM = '" + sKey + "'" + " AND SEQ = '" + sSEQ + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else
    	{
    		deleteQuery = " DELETE FROM PT_R_DEFICIT WHERE RECV_NUM = '" + sKey + "'";
    		deleteQuery += " AND SIDO_CODE ='" + sKey2 + "' ";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
    		deleteQuery = " DELETE FROM PT_R_MEMO WHERE RECV_NUM = '" + sKey + "'";
    		deleteQuery += " AND SIDO_CODE ='" + sKey2 + "' ";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);        	        
        	
        	deleteQuery = " DELETE FROM PT_R_RE_DERIVERY_STATEMENT WHERE RECV_NUM = '" + sKey + "'";
        	deleteQuery += " AND SIDO_CODE ='" + sKey2 + "' ";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    	}  
   }
    private String getMaxChangeSeq(String sKEY, String sTABLE) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(SEQ)), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }

}

