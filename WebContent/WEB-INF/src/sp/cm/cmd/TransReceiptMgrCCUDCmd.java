/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;

import kjf.util.KJFLog;


import org.apache.struts.action.ActionForm;

import sp.dao.PT_R_REGIST_STATEMENTDAO;
import sp.dao.PT_R_REGIST_STATEMENTEntity;

import sp.dao.PT_R_ASSI_TRANS_STATEMENTDAO;
import sp.dao.PT_R_ASSI_TRANS_STATEMENTEntity;

import sp.dao.PT_R_MEMODAO;
import sp.dao.PT_R_MEMOEntity;

import sp.dao.PT_R_SUBSIDIARY_COMPANYDAO;
import sp.dao.PT_R_SUBSIDIARY_COMPANYEntity;

import sp.dao.PT_R_DEFICITDAO;
import sp.dao.PT_R_DEFICITEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class TransReceiptMgrCCUDCmd implements KJFCommand {
	
    private String next;
    private PT_R_ASSI_TRANS_STATEMENTDAO    PT_R_ASSI_TRANS_STATEMENTdao = new PT_R_ASSI_TRANS_STATEMENTDAO();
    private PT_R_ASSI_TRANS_STATEMENTEntity PT_R_ASSI_TRANS_STATEMENTEnt = new PT_R_ASSI_TRANS_STATEMENTEntity();
    
    private PT_R_MEMODAO    PT_R_MEMOdao = new PT_R_MEMODAO();
    private PT_R_MEMOEntity PT_R_MEMOEnt = new PT_R_MEMOEntity();
    
    private PT_R_DEFICITDAO    PT_R_DEFICITdao = new PT_R_DEFICITDAO();
    private PT_R_DEFICITEntity PT_R_DEFICITEnt = new PT_R_DEFICITEntity();
    
    private PT_R_SUBSIDIARY_COMPANYDAO    PT_R_SUBSIDIARY_COMPANYdao = new PT_R_SUBSIDIARY_COMPANYDAO();
    private PT_R_SUBSIDIARY_COMPANYEntity PT_R_SUBSIDIARY_COMPANYEnt = new PT_R_SUBSIDIARY_COMPANYEntity();

    private VariableList vl = new VariableList();
    
    public TransReceiptMgrCCUDCmd() {
    }


    public TransReceiptMgrCCUDCmd(String next_url) {
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
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ASSI_TRANS_STATEMENT");    	
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_MEMO");
    		if(ds != null) dsProc(ds);
    		
    		
    	} else if (scMODE.equalsIgnoreCase("DELETE")){
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ASSI_TRANS_STATEMENT");    		
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null) dsProc(ds);
    		
    	} 
    	
    	else if (scMODE.equalsIgnoreCase("CHECK"))
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ASSI_TRANS_STATEMENT");
    		if(ds != null) dsProc(ds);
    	}
    	else
    	{
	    	if (scMODE.equalsIgnoreCase("MEMO"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_MEMO");
	    		if(ds != null) dsProc(ds);
	    	}
	    	else
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_ASSI_TRANS_STATEMENT");
	    		if(ds != null) dsProc(ds);
	    	}

    	}
        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception
    {
//    	System.out.print(ds.toString());
    	
    	for(int i=0;i<ds.getRowCount();i++){
    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);
    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
    	}

    	/****** Dataset을 DELETE처리 ****/
    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
    		deleteExe(ds,i);
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
    		//System.out.println("----------------------"+ds.getColumn(arg_row, "SEQ"));
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_DEFICITEnt.toString());
    		PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ASSI_TRANS_STATEMENT"))
    	{
    		PT_R_ASSI_TRANS_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
        	KJFLog.debug(PT_R_ASSI_TRANS_STATEMENTEnt.toString()); 		    	
        	System.out.println(ds.getId());
        	PT_R_ASSI_TRANS_STATEMENTdao.insert(PT_R_ASSI_TRANS_STATEMENTEnt);
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY_COMPANY"))
    	{
    		PT_R_SUBSIDIARY_COMPANYEnt.setDsOnlyString(ds, arg_row);
        	PT_R_SUBSIDIARY_COMPANYdao.update(PT_R_SUBSIDIARY_COMPANYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String[] fields = {"DEFICIT_CONTENT"};
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_DEFICITdao.updateExcludeOnly(PT_R_DEFICITEnt, fields);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ASSI_TRANS_STATEMENT"))
    	{
    		PT_R_ASSI_TRANS_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
        	KJFLog.debug(PT_R_ASSI_TRANS_STATEMENTEnt.toString()); 		    	
        	PT_R_ASSI_TRANS_STATEMENTdao.update(PT_R_ASSI_TRANS_STATEMENTEnt);
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
    		String sSEQ = ds.getDeleteColumn(arg_row,"MEMO_SEQ").getString();
    		deleteQuery = " DELETE FROM PT_R_MEMO WHERE RECV_NUM = '" + sKey + "'" + " AND MEMO_SEQ = '" + sSEQ + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else
    	{
    		if ("".equals(sKey.trim())){sKey = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();}
    		if ("".equals(sKey2.trim())){sKey2 = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();}
    		
        	PT_R_ASSI_TRANS_STATEMENTEnt.setRECV_NUM(sKey);
        	PT_R_ASSI_TRANS_STATEMENTEnt.setSIDO_CODE(sKey2);
        	
        	PT_R_ASSI_TRANS_STATEMENTdao.delete(PT_R_ASSI_TRANS_STATEMENTEnt);
        	        	       
    		deleteQuery = " DELETE FROM PT_R_DEFICIT WHERE RECV_NUM = '" + sKey + "' AND SIDO_CODE ='"+sKey2+"'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
    		deleteQuery = " DELETE FROM PT_R_MEMO WHERE RECV_NUM = '" + sKey + "' AND SIDO_CODE ='"+sKey2+"'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    	}    	
    }
}