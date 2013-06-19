/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
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
    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** List 획득 및 Dataset 획득 **/
    	vl = pReq.getVariableList();
    	String scMODE = vl.getValueAsString("workMODE");
    	Dataset ds ;
    	Dataset dsde ;
    	   	
	    	ds = pReq.getDatasetList().getDataset("dsPT_C_RES_CHARGE_EQU");
	    	if(ds != null) dsProc(ds);
    		
        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception{
    	/******** Dataset을 INSERT, UPDATE처리 ********/
    	System.out.println("ds.getRowCount() : "+ds.getRowCount());
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
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_C_RES_CHARGE_EQU"))
    	{
    		
    		/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	Eent.setDsOnlyString(ds, arg_row);//     	
	    	String[] fields={"SEQ", "WRT_ID", "SIDO_CODE", "INS_DT" };   	
	    	/******특정한 필드를 제외한 수정 ******/
	    	
	    	Eent.setUPD_DT(KJFDate.getCurDatetime());
	    	dao.updateExcludeOnly(Eent, fields);     	
    	}

    }
    
    
    /**
     * 삭제
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