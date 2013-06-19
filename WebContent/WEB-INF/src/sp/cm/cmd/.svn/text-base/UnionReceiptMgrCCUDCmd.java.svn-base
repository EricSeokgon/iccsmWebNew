package sp.cm.cmd;
import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_R_UNION_STATEMENTDAO;
import sp.dao.PT_R_UNION_STATEMENTEntity;
import sp.dao.PT_R_MEMODAO;
import sp.dao.PT_R_MEMOEntity;
import sp.dao.PT_R_DEFICITDAO;
import sp.dao.PT_R_DEFICITEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;
public class UnionReceiptMgrCCUDCmd  implements KJFCommand{
    String next;
    
    private PT_R_DEFICITDAO PT_R_DEFICITdao = new PT_R_DEFICITDAO();
    private PT_R_DEFICITEntity PT_R_DEFICITEnt = new PT_R_DEFICITEntity();
  
    private PT_R_MEMODAO PT_R_MEMOdao = new PT_R_MEMODAO();
    private PT_R_MEMOEntity PT_R_MEMOEnt = new PT_R_MEMOEntity();
    
    private PT_R_UNION_STATEMENTDAO PT_R_UNION_STATEMENTdao = new PT_R_UNION_STATEMENTDAO();
    private PT_R_UNION_STATEMENTEntity PT_R_UNION_STATEMENTEnt = new PT_R_UNION_STATEMENTEntity();
    
    private VariableList vl = new VariableList();
    
    
public UnionReceiptMgrCCUDCmd() {
	
}

public UnionReceiptMgrCCUDCmd(String next_url) {
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
	/*if (scworkMODE.equalsIgnoreCase("INSERT_SAVE"))
	{
    	ds = pReq.getDatasetList().getDataset("dsPT_M_MASTER");
    	if(ds != null) dsProc(ds);
    	
    	ds = pReq.getDatasetList().getDataset("dsPT_M_NEGLIGENCE");
    	if(ds != null) dsProc(ds);
	}*/
	//System.out.println(scworkMODE);

	if (scworkMODE.equalsIgnoreCase("ALL"))
	{
    	
		ds = pReq.getDatasetList().getDataset("dsPT_R_UNION_STATEMENT");
		if(ds != null) dsProc(ds);
    	ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    	if(ds != null) dsProc(ds);
	}
	else if (scworkMODE.equalsIgnoreCase("MEMO"))
	{
    	ds = pReq.getDatasetList().getDataset("dsPT_R_MEMO");
    	if(ds != null) dsProc(ds);
   	}

	else if (scworkMODE.equalsIgnoreCase("CHECK"))
	{
		
		ds = pReq.getDatasetList().getDataset("dsPT_R_UNION_STATEMENT");
		if(ds != null) dsProc(ds);
	}
	else if (scworkMODE.equalsIgnoreCase("DEFI"))
	{
		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
		if(ds != null)dsProc(ds);
	}
	else if(scworkMODE.equalsIgnoreCase("REMOVE"))
	{
		ds = pReq.getDatasetList().getDataset("dsPT_R_UNION_MASTER");
		System.out.println(ds.getRowCount());
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

   if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
	{
		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_R_DEFICITEnt.toString()); 
       	PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
	
	}
	else if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
	{
		PT_R_MEMOEnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_R_MEMOEnt.toString());
       	PT_R_MEMOdao.insert(PT_R_MEMOEnt);
	}
	else if(ds.getId().equalsIgnoreCase("dsPT_R_UNION_STATEMENT"))
	{
		PT_R_UNION_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_R_UNION_STATEMENTEnt.toString());
       	PT_R_UNION_STATEMENTdao.insert(PT_R_UNION_STATEMENTEnt);
	}

}

/**
 * 수정
 * @param Dataset ds, int arg_row
 * @return
 */
private void updateExe(Dataset ds, int arg_row)throws Exception{

    if(ds.getId().equalsIgnoreCase("dsPT_R_UNION_STATEMENT"))
	{
    	PT_R_UNION_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_R_UNION_STATEMENTEnt.toString());
       	PT_R_UNION_STATEMENTdao.update(PT_R_UNION_STATEMENTEnt);
	}
	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
	{
		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_R_DEFICITEnt.toString()); 
       	PT_R_DEFICITdao.update(PT_R_DEFICITEnt);
	}
	else if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
	{
		PT_R_MEMOEnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_R_MEMOEnt.toString());
       	PT_R_MEMOdao.update(PT_R_MEMOEnt);
	}   
}

/**
 * 삭제
 * @param Dataset ds, int arg_row
 * @return
 */
private void deleteExe(Dataset ds, int arg_row)throws Exception{
	
	String sKey1 = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
	
	StringBuilder sQuery = new StringBuilder();
	StringBuilder sWhere = new StringBuilder();
	
	ReportDAO rDAO = new ReportDAO();
	
	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
	{
		String sKey2 = ds.getDeleteColumn(arg_row, "MEMO_SEQ").getString();
		sQuery.append(" DELETE FROM PT_R_MEMO ");
		sWhere.append(" WHERE RECV_NUM = '" + sKey1 + "' ");
		sWhere.append(" AND MEMO_SEQ = '" + sKey2 + "' ");
    	
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());
	}	
    
	if(ds.getId().equalsIgnoreCase("dsPT_R_UNION_MASTER"))
	{
		sQuery.append(" DELETE FROM PT_R_UNION_STATEMENT ");
		sWhere.append(" WHERE RECV_NUM = '" + sKey1 + "' ");
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());
	}
  }
}


