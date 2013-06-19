/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.ub.cmd;

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

import sp.dao.PT_UB_SUVSPOT_MASTERDAO;
import sp.dao.PT_UB_SUVSPOT_MASTEREntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class SuvspotMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_UB_SUVSPOT_MASTERDAO    dao = new PT_UB_SUVSPOT_MASTERDAO();
    private PT_UB_SUVSPOT_MASTEREntity Eent = new PT_UB_SUVSPOT_MASTEREntity();
    
    private VariableList vl = new VariableList();
    
    public SuvspotMgrCUDCmd() {
    }


    public SuvspotMgrCUDCmd(String next_url) {
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
    	
    	Dataset ds;
    	
    		ds = pReq.getDatasetList().getDataset("ds_SUV");
    		dsProc(ds);
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
    	
    	String WRT_ID = vl.getValueAsString("WRT_ID");
		
    	String SEQ = KJFDBUtil.getMaxID("SEQ","PT_UB_SUVSPOT_MASTER");
    	
    	
		/****** Dataset one_row 값 전체 자동 세팅 ******/
    	Eent.setDsOnlyString(ds, arg_row);//  
	    /****** 이후 변경되는 값들 세팅 ******/
	    /******세팅 값들 콘솔창에서 확인 ******/
	    KJFLog.debug(Eent.toString());
	    Eent.setSEQ(SEQ);
	    Eent.setWRT_ID(WRT_ID);
		Eent.setINS_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
	    /******저장 ******/
	    dao.insert(Eent);
	    	
    }
   

    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
		/****** Dataset one_row 값 전체 자동 세팅 ******/
    	Eent.setDsOnlyString(ds, arg_row);//     	
    	String[] fields={"SEQ", "WRT_ID", "INS_DT" };   	
    	/******특정한 필드를 제외한 수정 ******/
    	Eent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
    	dao.updateExcludeOnly(Eent, fields); 
    	
    	
			
    }

    
    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	ReportDAO    rDAO        = new ReportDAO();
    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
		String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    	String DELETE = " DELETE FROM PT_UB_DETAIL  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND RECV_NUM = '"+RECV_NUM+"' ";
    	rDAO.execute(DELETE);
    	dao.delete(Eent);    
    }
   
}