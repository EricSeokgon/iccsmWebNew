/**
 * ���ϸ�   : ComCodeMgrCUDCmd.java
 * ����     : CUD cmd
 * �̷»���
 * CH00     : 2008/12/22 ���� �����ۼ�
 */

package sp.c_res.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_C_RES_CHARGE_EQUDAO;
import sp.dao.PT_C_RES_CHARGE_EQUEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class RegChargeMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_C_RES_CHARGE_EQUDAO    dao = new PT_C_RES_CHARGE_EQUDAO();
    private PT_C_RES_CHARGE_EQUEntity Eent = new PT_C_RES_CHARGE_EQUEntity();
   
    private VariableList vl = new VariableList();
    
    public RegChargeMgrCUDCmd() {
    }


    public RegChargeMgrCUDCmd(String next_url) {
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
    	Dataset ds ;
    	Dataset dsde ;
    	   	
	    	ds = pReq.getDatasetList().getDataset("dsPT_C_RES_CHARGE_EQU");
	    	if(ds != null) dsProc(ds);
    		
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
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_C_RES_CHARGE_EQU"))
    	{
    		String WRT_ID = vl.getValueAsString("WRT_ID");
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
    		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
    		
    		String SEQ = KJFDBUtil.getMaxID("SEQ","PT_C_RES_CHARGE_EQU");
    		
    		Eent.setDsOnlyString(ds, arg_row);
           	KJFLog.debug(Eent.toString());
           	Eent.setSEQ(SEQ);
           	Eent.setWRT_ID(WRT_ID);
           	Eent.setSIDO_CODE(SIDO_CODE);
           	Eent.setSIGUNGU_CODE(SIGUNGU_CODE);
           	Eent.setINS_DT(KJFDate.getCurDatetime());
           	dao.insert(Eent);
    	}
    	
    	
    }
    
    

    /**
     * ����
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_C_RES_CHARGE_EQU"))
    	{
    		
    		/****** Dataset one_row �� ��ü �ڵ� ���� ******/
	    	Eent.setDsOnlyString(ds, arg_row);//     	
	    	String[] fields={"SEQ", "WRT_ID", "SIDO_CODE", "INS_DT" };   	
	    	/******Ư���� �ʵ带 ������ ���� ******/
	    	
	    	Eent.setUPD_DT(KJFDate.getCurDatetime());
	    	dao.updateExcludeOnly(Eent, fields);     	
    	}

    }
    
    
    /**
     * ����
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	 StringBuilder deleteQuery = new StringBuilder();
    	
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_C_RES_CHARGE_EQU"))
    	{
    		String SEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			
			ReportDAO    rDAO        = new ReportDAO();			
	    	
			deleteQuery.append(" DELETE FROM PT_C_RES_CHARGE_EQU  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND SEQ = '"+SEQ+"' ");
	    	rDAO.execute(deleteQuery.toString());
    	}
    }
   
}