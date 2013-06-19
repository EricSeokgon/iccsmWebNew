/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.am.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;

import kjf.util.KJFDate;
import kjf.util.KJFLog;


import org.apache.struts.action.ActionForm;

import sp.dao.PT_M_MASTERDAO;
import sp.dao.PT_M_MASTEREntity;

import sp.dao.PT_M_CORRECTDAO;
import sp.dao.PT_M_CORRECTEntity;

import sp.dao.PT_M_MEMODAO;
import sp.dao.PT_M_MEMOEntity;

import sp.dao.PT_M_BEF_REPORTDAO;
import sp.dao.PT_M_BEF_REPORTEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class CorrectMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_M_MASTERDAO    PT_M_MASTERdao = new PT_M_MASTERDAO();
    private PT_M_MASTEREntity PT_M_MASTEREnt = new PT_M_MASTEREntity();
    
    private PT_M_MEMODAO PT_M_MEMOdao = new PT_M_MEMODAO();
    private PT_M_MEMOEntity PT_M_MEMOEnt = new PT_M_MEMOEntity();
    
    private PT_M_BEF_REPORTDAO PT_M_BEF_REPORTdao = new PT_M_BEF_REPORTDAO();
    private PT_M_BEF_REPORTEntity PT_M_BEF_REPORTEnt = new PT_M_BEF_REPORTEntity();
    
    private PT_M_CORRECTDAO PT_M_CORRECTdao = new PT_M_CORRECTDAO();
    private PT_M_CORRECTEntity PT_M_CORRECTEnt = new PT_M_CORRECTEntity();
    
    private VariableList vl = new VariableList();
    
    public CorrectMgrCUDCmd() {
    }


    public CorrectMgrCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	Dataset ds;
    	
    	String scworkMODE = vl.getValueAsString("workMODE");
    	
    	if (scworkMODE.equalsIgnoreCase("INSERT_SAVE"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_MASTER");
	    	if(ds != null) dsProc(ds);
	    	
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_CORRECT");
	    	if(ds != null) dsProc(ds);
    	}
    	else if (scworkMODE.equalsIgnoreCase("ALL"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_MASTER");
	    	if(ds != null) dsProc(ds);
	    	
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_CORRECT");
	    	if(ds != null) dsProc(ds);
    	}
    	else if (scworkMODE.equalsIgnoreCase("MEMO"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_MEMO");
	    	if(ds != null) dsProc(ds);
    	}
    	else if (scworkMODE.equalsIgnoreCase("NOTI"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_BEF_REPORT");
	    	if(ds != null) dsProc(ds);
    	}
    	else if (scworkMODE.equalsIgnoreCase("SUS_DEL"))
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_M_CORRECT");
	    	if(ds != null) dsProc(ds);
    	}
    	
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

    /**
     * 입력
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{

    	if(ds.getId().equalsIgnoreCase("dsPT_M_MASTER"))
    	{
    		PT_M_MASTEREnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_MASTEREnt.toString());
           	PT_M_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());
           	PT_M_MASTERdao.insert(PT_M_MASTEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_CORRECT"))
    	{
    		PT_M_CORRECTEnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_CORRECTEnt.toString());
           	PT_M_CORRECTEnt.setINS_DT(KJFDate.getCurDatetime());
           	PT_M_CORRECTdao.insert(PT_M_CORRECTEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_MEMO"))
    	{
    		PT_M_MEMOEnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_MEMOEnt.toString());
           	PT_M_MEMOEnt.setINS_DT(KJFDate.getCurDatetime());
           	PT_M_MEMOdao.insert(PT_M_MEMOEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_BEF_REPORT"))
    	{
    		PT_M_BEF_REPORTEnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_BEF_REPORTEnt.toString());
           	PT_M_BEF_REPORTEnt.setINS_DT(KJFDate.getCurDatetime());
           	PT_M_BEF_REPORTdao.insert(PT_M_BEF_REPORTEnt);
    	}
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	if(ds.getId().equalsIgnoreCase("dsPT_M_MASTER"))
    	{
    		PT_M_MASTEREnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_MASTEREnt.toString());
           	PT_M_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
           	PT_M_MASTERdao.update(PT_M_MASTEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_CORRECT"))
    	{
    		PT_M_CORRECTEnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_CORRECTEnt.toString());
           	PT_M_CORRECTEnt.setUPD_DT(KJFDate.getCurDatetime());
           	PT_M_CORRECTdao.update(PT_M_CORRECTEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_MEMO"))
    	{
    		PT_M_MEMOEnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_MEMOEnt.toString());
           	PT_M_MEMOEnt.setUPD_DT(KJFDate.getCurDatetime());
           	PT_M_MEMOdao.update(PT_M_MEMOEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_BEF_REPORT"))
    	{
    		PT_M_BEF_REPORTEnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_BEF_REPORTEnt.toString());
           	PT_M_BEF_REPORTEnt.setUPD_DT(KJFDate.getCurDatetime());
           	PT_M_BEF_REPORTdao.update(PT_M_BEF_REPORTEnt);
    	}
    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String sKey1 = ds.getDeleteColumn(arg_row,"WRT_NUM").getString();
    	String sKey2 = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();
    	
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	ReportDAO rDAO = new ReportDAO();
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_M_MEMO"))
    	{
    		sQuery.append(" DELETE FROM PT_M_MEMO ");
    		sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
    		sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
        	
        	rDAO.execute(sQuery.toString() + sWhere.toString());
        	sQuery.delete(0, sQuery.length());
        	sWhere.delete(0, sWhere.length());
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_BEF_REPORT"))
    	{
    		sQuery.append(" DELETE FROM PT_M_BEF_REPORT ");
    		sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
    		sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
        	
        	rDAO.execute(sQuery.toString() + sWhere.toString());
        	sQuery.delete(0, sQuery.length());
        	sWhere.delete(0, sWhere.length());
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_CORRECT"))
    	{
    		sQuery.append(" DELETE FROM PT_M_MEMO ");
    		sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
    		sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	
	    	sQuery.append(" DELETE FROM PT_M_BEF_REPORT ");
	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    		    	
	    	sQuery.append(" UPDATE PT_M_MASTER SET DISPO_CONT = NULL, MOT_STE = NULL, DISPO_DT = NULL ");
				    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	
	    	sQuery.append(" DELETE FROM PT_M_CORRECT ");
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	sWhere.delete(0, sWhere.length());
    	}
    	else
    	{
	    	sQuery.append(" DELETE FROM PT_M_MEMO ");
	    	sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
    		sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	
	    	sQuery.append(" DELETE FROM PT_M_BEF_REPORT ");	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	
	    	sQuery.append(" DELETE FROM PT_M_CORRECT ");
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
    	}
    }
}