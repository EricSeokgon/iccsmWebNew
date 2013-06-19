/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.amr.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_M_MASTERDAO;
import sp.dao.PT_M_MASTEREntity;
import sp.dao.PT_M_MGRDAO;
import sp.dao.PT_M_MGREntity;
import sp.dao.PT_R_COMPANY_MASTERDAO;
import sp.dao.PT_R_COMPANY_MASTEREntity;
import sp.dao.PT_R_ENGINEER_CHANGEDAO;
import sp.dao.PT_R_ENGINEER_CHANGEEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class AmReceiptMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_M_MGRDAO    PT_M_MGRdao = new PT_M_MGRDAO();
    private PT_M_MGREntity PT_M_MGREnt = new PT_M_MGREntity();
    
    private PT_M_MASTERDAO    PT_M_MASTERdao = new PT_M_MASTERDAO();
    private PT_M_MASTEREntity PT_M_MASTEREnt = new PT_M_MASTEREntity();
    
    private PT_R_COMPANY_MASTERDAO    PT_R_COMPANY_MASTERdao = new PT_R_COMPANY_MASTERDAO();
    private PT_R_COMPANY_MASTEREntity PT_R_COMPANY_MASTEREnt = new PT_R_COMPANY_MASTEREntity();
    
    private PT_R_ENGINEER_CHANGEDAO    PT_R_ENGINEER_CHANGEdao = new PT_R_ENGINEER_CHANGEDAO();
    private PT_R_ENGINEER_CHANGEEntity PT_R_ENGINEER_CHANGEEnt = new PT_R_ENGINEER_CHANGEEntity();
    
    private VariableList vl = new VariableList();
    
    public AmReceiptMgrCUDCmd() {
    }


    public AmReceiptMgrCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	String scMODE = vl.getValueAsString("workMODE");
    	
    	System.out.println("--workMODE------------------"+scMODE);
    	
    	Dataset ds;
    	/** List 획득 및 Dataset 획득 **/
    	if (scMODE.equalsIgnoreCase("INSERT"))
    	{
    	 ds = pReq.getDatasetList().getDataset("dsPT_M_MGR");
    	if(ds != null) dsProc(ds);
    	}
     	else if (scMODE.equalsIgnoreCase("UPDATE"))
    	{
    	 ds = pReq.getDatasetList().getDataset("dsPT_M_MGR");
    	if(ds != null) dsProc(ds);
    	}
    	else if (scMODE.equalsIgnoreCase("UPDATE2"))
    	{
    	 ds = pReq.getDatasetList().getDataset("dsPT_M_MGR");
    	if(ds != null) dsProc(ds);
    	//System.out.println("--dsPT_M_MGR------------------"+ds);
    	ds = pReq.getDatasetList().getDataset("dsPT_M_MASTER");
    	if(ds != null) dsProc(ds);
    	//System.out.println("--dsPT_M_MASTER------------------"+ds);
    	}
    	else if (scMODE.equalsIgnoreCase("UPDATE3"))
    	{
    	 ds = pReq.getDatasetList().getDataset("dsPT_M_MGR");
    	if(ds != null) dsProc(ds);
    	
    	ds = pReq.getDatasetList().getDataset("dsPT_M_MASTER");
    	if(ds != null) dsProc(ds);
    	//System.out.println("--dsPT_M_MASTER------------------"+ds);
 	   	ds = pReq.getDatasetList().getDataset("dsPT_R_COMPANY_MASTER");
		if (ds != null) dsProc(ds);
		
		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");
		if (ds != null) dsProc(ds);
    	}
     	else if (scMODE.equalsIgnoreCase("DELETE"))
    	{
     		System.out.println("--workMODE------------------"+scMODE);
    	 ds = pReq.getDatasetList().getDataset("dsPT_M_MGR");
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
    	String scMODE = vl.getValueAsString("workMODE");
    	if (scMODE.equalsIgnoreCase("INSERT"))
    	{
    	PT_M_MGREnt.setDsOnlyString(ds, arg_row);// 
       	PT_M_MGREnt.setINS_DT(KJFDate.getCurDatetime());
       	KJFLog.debug(PT_M_MGREnt.toString());
        PT_M_MGRdao.insert(PT_M_MGREnt);
    	}
      	else if (scMODE.equalsIgnoreCase("UPDATE2"))
    	{
        	PT_M_MASTEREnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_MASTEREnt.toString());
           	PT_M_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());
           	PT_M_MASTERdao.insert(PT_M_MASTEREnt);
    	}
      	else if (scMODE.equalsIgnoreCase("UPDATE3"))
    	{
        	PT_M_MASTEREnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_MASTEREnt.toString());
           	PT_M_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());
           	PT_M_MASTERdao.insert(PT_M_MASTEREnt);
    	}

    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	String scMODE = vl.getValueAsString("workMODE");
    	if (scMODE.equalsIgnoreCase("UPDATE"))
    	{
    		System.out.println("--workMODE---UPDATE---------------"+scMODE);
    	PT_M_MGREnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_M_MGREnt.toString());
       	PT_M_MGREnt.setUPD_DT(KJFDate.getCurDatetime());
       	PT_M_MGRdao.update(PT_M_MGREnt);
    	}
    	else if(scMODE.equalsIgnoreCase("UPDATE2"))
    	//else if(scMODE.equalsIgnoreCase("dsPT_M_MGR"))
    	{
    		//System.out.println("--workMODE-----UPDATE2-------------"+scMODE);
    	 	PT_M_MGREnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_MGREnt.toString());
           	PT_M_MGREnt.setUPD_DT(KJFDate.getCurDatetime());
           	PT_M_MGRdao.update(PT_M_MGREnt);
    	}
    	//else if(scMODE.equalsIgnoreCase("UPDATE3"))
        	else if(ds.getId().equalsIgnoreCase("dsPT_M_MGR"))
        	{
    		System.out.println("--workMODE-----UPDATE3-------------"+scMODE);
        	 	PT_M_MGREnt.setDsOnlyString(ds, arg_row);// 
               	KJFLog.debug(PT_M_MGREnt.toString());
               	PT_M_MGREnt.setUPD_DT(KJFDate.getCurDatetime());
               	PT_M_MGRdao.update(PT_M_MGREnt);
        	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_MASTER"))
    	{
        	PT_M_MASTEREnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_MASTEREnt.toString());
           	PT_M_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
           	PT_M_MASTERdao.update(PT_M_MASTEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		//String[] fields = {"RET_YMD"};
    		//PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);
    		//PT_R_ENGINEER_CHANGEdao.updateModifiedOnly(PT_R_ENGINEER_CHANGEEnt, fields);
    		
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_ENGINEER_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ENGINEER_CHANGEEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGEdao.update(PT_R_ENGINEER_CHANGEEnt);
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
    	String sDISPO_CONT = ds.getDeleteColumn(arg_row,"DISPO_CONT").getString();
    	
    	System.out.println("WRT_NUM ============= " + sKey1);
    	System.out.println("TMP_WRT_NUM ============= " + sKey2);
    	System.out.println("DISPO_CONT ============= " + sDISPO_CONT);
    	String scMODE = vl.getValueAsString("workMODE");
    	if (scMODE.equalsIgnoreCase("DELETE"))
    	{
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	  	
    	
    	ReportDAO rDAO = new ReportDAO();

    	sQuery.append(" DELETE FROM PT_M_MGR ");
    	sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
		sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
		
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
    	}
    }
}