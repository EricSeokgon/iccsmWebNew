package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;


import sp.dao.PT_R_DEFICITDAO;
import sp.dao.PT_R_DEFICITEntity;

import sp.dao.PT_R_MEMODAO;
import sp.dao.PT_R_MEMOEntity;

import sp.dao.PT_R_RE_DERIVERY_STATEMENTDAO;
import sp.dao.PT_R_RE_DERIVERY_STATEMENTEntity;

import sp.dao.PT_R_DELIVERY_BOOKDAO;
import sp.dao.PT_R_DELIVERY_BOOKEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;

public class RegRePublishMgrCCUDCmd implements KJFCommand{
	
	private String next;
	
    private PT_R_RE_DERIVERY_STATEMENTDAO    PT_R_RE_DERIVERY_STATEMENTdao = new PT_R_RE_DERIVERY_STATEMENTDAO();
    private PT_R_RE_DERIVERY_STATEMENTEntity PT_R_RE_DERIVERY_STATEMENTEnt = new PT_R_RE_DERIVERY_STATEMENTEntity();
    
    private PT_R_MEMODAO    PT_R_MEMOdao = new PT_R_MEMODAO();
    private PT_R_MEMOEntity PT_R_MEMOEnt = new PT_R_MEMOEntity();
    
    private PT_R_DEFICITDAO    PT_R_DEFICITdao = new PT_R_DEFICITDAO();
    private PT_R_DEFICITEntity PT_R_DEFICITEnt = new PT_R_DEFICITEntity();
    
    private PT_R_DELIVERY_BOOKDAO    PT_R_DELIVERY_BOOKDao = new PT_R_DELIVERY_BOOKDAO();
    private PT_R_DELIVERY_BOOKEntity PT_R_DELIVERY_BOOKEnt = new PT_R_DELIVERY_BOOKEntity();
    
    private VariableList vl = new VariableList();
    
    public RegRePublishMgrCCUDCmd() {
    }


    public RegRePublishMgrCCUDCmd(String next_url) {
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
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_RE_DERIVERY_STATEMENT");
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DELIVERY_BOOK");
    		if(ds != null) dsProc(ds);
    	}
    	else
    	{
	    	if (scMODE.equalsIgnoreCase("MEMO"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_MEMO");
	    	}	    	
	    	else
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_RE_DERIVERY_STATEMENT");
	    	}
	  	    	
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
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		PT_R_MEMOEnt.setDsOnlyString(ds, arg_row);// 
        	KJFLog.debug(PT_R_MEMOEnt.toString()); 		    	
        	PT_R_MEMOdao.insert(PT_R_MEMOEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		System.out.println("----------------------"+ds.getColumn(arg_row, "SEQ"));
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_DEFICITEnt.toString());
    		PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DELIVERY_BOOK"))
    	{
    		PT_R_DELIVERY_BOOKEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_DELIVERY_BOOKEnt.setSEQ(
     	    		getMaxChangeSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_DELIVERY_BOOK"));
    		PT_R_DELIVERY_BOOKEnt.setINS_DT(KJFDate.getCurDatetime());
    		KJFLog.debug(PT_R_DELIVERY_BOOKEnt.toString()); 		    	
        	PT_R_DELIVERY_BOOKDao.insert(PT_R_DELIVERY_BOOKEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_RE_DERIVERY_STATEMENT"))
    	{
    		PT_R_RE_DERIVERY_STATEMENTEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_RE_DERIVERY_STATEMENTEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_RE_DERIVERY_STATEMENTEnt.toString()); 		    	
        	PT_R_RE_DERIVERY_STATEMENTdao.insert(PT_R_RE_DERIVERY_STATEMENTEnt);
    	}
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	    	
    	

    	/******특정한 필드를 제외한 수정 ******/
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		PT_R_MEMOEnt.setDsOnlyString(ds, arg_row);
        	PT_R_MEMOdao.update(PT_R_MEMOEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_DEFICITdao.update(PT_R_DEFICITEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DELIVERY_BOOK"))
    	{
    		PT_R_DELIVERY_BOOKEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_DELIVERY_BOOKEnt.setSEQ(
     	    		getMaxChangeSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_DELIVERY_BOOK"));
    		PT_R_DELIVERY_BOOKEnt.setUPD_DT(KJFDate.getCurDatetime());
    		KJFLog.debug(PT_R_DELIVERY_BOOKEnt.toString()); 		    	
        	PT_R_DELIVERY_BOOKDao.update(PT_R_DELIVERY_BOOKEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_RE_DERIVERY_STATEMENT"))
    	{
    		PT_R_RE_DERIVERY_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_RE_DERIVERY_STATEMENTdao.update(PT_R_RE_DERIVERY_STATEMENTEnt);
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
