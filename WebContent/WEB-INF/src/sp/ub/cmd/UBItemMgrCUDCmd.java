/**
 * ���ϸ�   : ComCodeMgrCUDCmd.java
 * ����     : CUD cmd
 * �̷»���
 * CH00     : 2008/12/22 ���� �����ۼ�
 */

package sp.ub.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFMi;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_UB_DETAIL_MASTERDAO;
import sp.dao.PT_UB_DETAIL_MASTEREntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class UBItemMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_UB_DETAIL_MASTERDAO    dao = new PT_UB_DETAIL_MASTERDAO();
    private PT_UB_DETAIL_MASTEREntity Eent = new PT_UB_DETAIL_MASTEREntity();

    private VariableList vl = new VariableList();
    
    public UBItemMgrCUDCmd() {
    }


    public UBItemMgrCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** List ȹ�� �� Dataset ȹ�� **/
    	vl = pReq.getVariableList();
    	String scMODE = vl.getValueAsString("workMODE");
    	Dataset ds = pReq.getDatasetList().getDataset("ds_DETAIL");
    	
    	dsProc(ds);
    	

        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception{
    	/******** Dataset�� INSERT, UPDATEó�� ********/
    	System.out.println("ds.getRowCount() : "+ds.getRowCount());
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
    	
    	/****** Dataset one_row �� ��ü �ڵ� ���� ******/
    	Eent.setDsOnlyString(ds, arg_row);// 
 
    	/****** ���� ����Ǵ� ���� ���� ******/
        String SEQ  = KJFDBUtil.getMaxID("SEQ","PT_UB_DETAIL_MASTER");
        
    	/******���� ���� �ܼ�â���� Ȯ�� ******/
    	KJFLog.debug(Eent.toString()); 		
    	Eent.setSEQ(SEQ);
    	/******���� ******/
    	dao.insert(Eent);


    }
    


    /**
     * ����
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row �� ��ü �ڵ� ���� ******/
    	Eent.setDsOnlyString(ds, arg_row);//     	
    	dao.update(Eent);
    	String[] fields={"SEQ", "REG_DATE" };   	
    	/******Ư���� �ʵ带 ������ ���� ******/
    	//dao.updateExcludeOnly(Eent, fields); 
    	
//////////////////etc method Example//////////////////////////////////  
//
//    	String[] fields={"CODE", "P_CODE", "CODE_NAME", "ORDER_SEQ", 
//    			"USE_YN", "BIGO", "MOD_DATE" };   	
//    	/******Ư���� �ʵ常 ���� ******/
//    	PT_COM_CODEdao.updateModifiedOnly(PT_COM_CODEent, fields);
//    	
//
//
//		/******��ü �ʵ� ���� ******/
//		PT_COM_CODEdao.update(PT_COM_CODEent); 	
//    	
//
//
//    	/******���� ���� ���� ******/
//    	ReportDAO    rDAO        = new ReportDAO();
//    	String UpdataSql = "UPDATA PT_COM_CODE SET CODE = ?, SET P_CODE = ?, \n"+
//    	             "SET CODE_NAME = ?, SET ORDER_SEQ = ?, SET USE_YN = ?,  \n"+
//    				 "SET BIGO = ?, SET MOD_DATE = ?,  \n";
//    	int cnt=1;
//    	rDAO.setValue(cnt++, PT_COM_CODEent.getCODE());
//    	rDAO.setValue(cnt++, PT_COM_CODEent.getP_CODE());
//    	rDAO.setValue(cnt++, PT_COM_CODEent.getCODE_NAME());
//    	rDAO.setValue(cnt++, PT_COM_CODEent.getORDER_SEQ());
//    	rDAO.setValue(cnt++, PT_COM_CODEent.getUSE_YN());
//    	rDAO.setValue(cnt++, PT_COM_CODEent.getBIGO());
//    	rDAO.setValue(cnt++, KJFDate.datetimeOnly(KJFDate.getCurTime()));
//    	rDAO.execute(UpdataSql);
//
//////////////////etc method Example//////////////////////////////////      	
    	

    }

    /**
     * ����
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	Eent.setSEQ(ds.getDeleteColumn(arg_row,"SEQ").getString());
    	dao.delete(Eent);
    	
    }

}