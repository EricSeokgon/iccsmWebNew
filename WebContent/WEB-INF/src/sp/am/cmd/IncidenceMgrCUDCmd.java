package sp.am.cmd;
import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_M_BEF_REPORTDAO;
import sp.dao.PT_M_BEF_REPORTEntity;
import sp.dao.PT_M_MASTERDAO;
import sp.dao.PT_M_MASTEREntity;
import sp.dao.PT_M_MEMODAO;
import sp.dao.PT_M_MEMOEntity;
import sp.dao.PT_M_NEGLIGENCEDAO;
import sp.dao.PT_M_NEGLIGENCEEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;

public class IncidenceMgrCUDCmd implements KJFCommand  {
    
	    String next;
	    private PT_M_MASTERDAO    PT_M_MASTERdao = new PT_M_MASTERDAO();
	    private PT_M_MASTEREntity PT_M_MASTEREnt = new PT_M_MASTEREntity();
	    
	    private PT_M_NEGLIGENCEDAO PT_M_NEGLIGENCEdao = new PT_M_NEGLIGENCEDAO();
	    private PT_M_NEGLIGENCEEntity PT_M_NEGLIGENCEEnt = new PT_M_NEGLIGENCEEntity();
	  
	    private PT_M_MEMODAO PT_M_MEMOdao = new PT_M_MEMODAO();
	    private PT_M_MEMOEntity PT_M_MEMOEnt = new PT_M_MEMOEntity();
	    
	    private PT_M_BEF_REPORTDAO PT_M_BEF_REPORTdao = new PT_M_BEF_REPORTDAO();
	    private PT_M_BEF_REPORTEntity PT_M_BEF_REPORTEnt = new PT_M_BEF_REPORTEntity();
	    
	    private VariableList vl = new VariableList();
	    
	    
	public IncidenceMgrCUDCmd() {
		
	}
	
	public IncidenceMgrCUDCmd(String next_url) {
    	next = next_url;
    }
	
	public String execute(HttpServletRequest request, ActionForm form) throws Exception {

	   	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	Dataset ds;
    	
    	String scworkMODE = vl.getValueAsString("workMODE");
    	
    	if (scworkMODE.equalsIgnoreCase("INSERT_SAVE"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_MASTER");
	    	if(ds != null) dsProc(ds);
	    	
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_NEGLIGENCE");
	    	if(ds != null) dsProc(ds);
    	}
    	else if (scworkMODE.equalsIgnoreCase("ALL"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_MASTER");
	    	if(ds != null) dsProc(ds);
	    	
	    	ds = pReq.getDatasetList().getDataset("dsPT_M_NEGLIGENCE");
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
    		ds = pReq.getDatasetList().getDataset("dsPT_M_NEGLIGENCE");
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

    	/****** Dataset�� DELETEó�� ****/
    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
    		deleteExe(ds,i);
    	}
    }
		
    /**
     * �Է�
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_NEGLIGENCE"))
    	{
    		PT_M_NEGLIGENCEEnt.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(PT_M_NEGLIGENCEEnt.toString());
           	PT_M_NEGLIGENCEEnt.setINS_DT(KJFDate.getCurDatetime());
           	PT_M_NEGLIGENCEdao.insert(PT_M_NEGLIGENCEEnt);
    	
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
     * ����
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_NEGLIGENCE"))
    	{
    		PT_M_NEGLIGENCEEnt.setDsOnlyString(ds, arg_row);// 
         	KJFLog.debug(PT_M_NEGLIGENCEEnt.toString());
         	PT_M_NEGLIGENCEEnt.setUPD_DT(KJFDate.getCurDatetime());
         	PT_M_NEGLIGENCEdao.update(PT_M_NEGLIGENCEEnt);
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
     * ����
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_M_NEGLIGENCE"))
    	{
    		sQuery.append(" DELETE FROM PT_M_MEMO ");
			sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
			sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	sWhere.delete(0, sWhere.length());
	    	
	    	sQuery.append(" DELETE FROM PT_M_BEF_REPORT ");
			sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
			sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	sWhere.delete(0, sWhere.length());
	    	
	    	sQuery.append(" UPDATE PT_M_MASTER SET DISPO_CONT = NULL, MOT_STE = NULL, DISPO_DT = NULL ");
			sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
			sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	sWhere.delete(0, sWhere.length());
	    	
	    	sQuery.append(" DELETE FROM PT_M_NEGLIGENCE ");
			sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
			sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
	    	
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
	    	sWhere.delete(0, sWhere.length());
	    	
	    	sQuery.append(" DELETE FROM PT_M_BEF_REPORT ");
			sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
			sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	sWhere.delete(0, sWhere.length());
	    	
	    	sQuery.append(" DELETE FROM PT_M_NEGLIGENCE ");
			sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
			sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
	    	sQuery.delete(0, sQuery.length());
	    	sWhere.delete(0, sWhere.length());
	    	
			sQuery.append(" DELETE FROM PT_M_MASTER ");
			sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
			sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
	    	
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	}
    }
}
