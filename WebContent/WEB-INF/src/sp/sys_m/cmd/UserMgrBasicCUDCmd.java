/**
 * ���ϸ�   : ComCodeMgrCUDCmd.java
 * ����     : CUD cmd
 * �̷»���
 * CH00     : 2008/12/22 ���� �����ۼ�
 */

package sp.sys_m.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_MI_USERDAO;
import sp.dao.PT_MI_USEREntity;
import sp.dao.PT_MI_USER_BASICDAO;
import sp.dao.PT_MI_USER_BASICEntity;
import sp.util.Crypto;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;

public class UserMgrBasicCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_MI_USER_BASICDAO    dao = new PT_MI_USER_BASICDAO();
    private PT_MI_USER_BASICEntity Eent = new PT_MI_USER_BASICEntity();
    
    private PT_MI_USERDAO    udao = new PT_MI_USERDAO();
    private PT_MI_USEREntity uEent = new PT_MI_USEREntity();

    private VariableList vl = new VariableList();
    
    public UserMgrBasicCUDCmd() {
    }


    public UserMgrBasicCUDCmd(String next_url) {
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
    	Dataset ds = null;
    	if("ALL".equals(scMODE)){
    		ds = pReq.getDatasetList().getDataset("ds_PT_MI_USER");
    		dsProc(ds);
    	}else if("OK".equals(scMODE)){
    		ds = pReq.getDatasetList().getDataset("ds_PT_MI_USER");
    		okProc(ds);
    	}
    	
        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception{
    	/******** Dataset�� INSERT, UPDATEó�� ********/
    	for(int i=0;i<ds.getRowCount();i++){
    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);
    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
    		
    	}
    	 	
    	/****** Dataset�� DELETEó�� ****/
    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
    		deleteExe(ds,i);
    	}
    }
    
    private void okProc(Dataset ds) throws Exception{
    	/******** Dataset�� INSERT, UPDATEó�� ********/
    	for(int i=0;i<ds.getRowCount();i++){
    		if(ds.getRowStatus(i).equals("insert")) okExe(ds,i);
    		if(ds.getRowStatus(i).equals("update")) okExe(ds,i);
    		
    	}
    	
    }
    
    /**
     * �Է�
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{
    	
    	/****** Dataset one_row �� ��ü �ڵ� ���� ******/
    	Eent.setDsOnlyString(ds, arg_row);
    	
    	Eent.setPASS(Eent.getPASS());
    
    	
    	/******���� ���� �ܼ�â���� Ȯ�� ******/
    	KJFLog.debug(Eent.toString()); 	
    	/******���� ******/
    	dao.insert(Eent);
       	String WRT_ID = vl.getValueAsString("WRT_ID");
    	Eent.setWRT_ID(WRT_ID);
    	Eent.setINS_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));

    }


	/**
     * ����
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row �� ��ü �ڵ� ���� ******/
    	Eent.setDsOnlyString(ds, arg_row);//     	
    	
        Eent.setPASS(Eent.getPASS());  //�н��������
    	
    	dao.update(Eent);
    	String[] fields={"OFFI_ID", "INS_DT" };   	
    	/******Ư���� �ʵ带 ������ ���� ******/
    	dao.updateExcludeOnly(Eent, fields); 
     	String WRT_ID = vl.getValueAsString("WRT_ID");
    	Eent.setWRT_ID(WRT_ID);
    	Eent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
    	dao.updateExcludeOnly(Eent, fields); 

    }
    
    
    private void okExe(Dataset ds, int arg_row)throws Exception{
    	Eent.setDsOnlyString(ds, arg_row);// 
    	uEent.setDsOnlyString(ds, arg_row);//
    	
        uEent.setPASS(uEent.getPASS()); 
    	
    	KJFLog.debug(uEent.toString()); 	
    	udao.insert(uEent);
    	dao.delete(Eent);
    }

    /**
     * ����
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	Eent.setOFFI_ID(ds.getDeleteColumn(arg_row,"OFFI_ID").getString());
    	dao.delete(Eent);
    	
    }

}