/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.sys_m.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_S_SYSVAR_MASTERDAO;
import sp.dao.PT_S_SYSVAR_MASTEREntity;
import sp.dao.PT_S_SYSVAR_PDADAO;
import sp.dao.PT_S_SYSVAR_PDAEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class SysVarMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_S_SYSVAR_MASTERDAO    dao = new PT_S_SYSVAR_MASTERDAO();
    private PT_S_SYSVAR_MASTEREntity Eent = new PT_S_SYSVAR_MASTEREntity();
    
    private PT_S_SYSVAR_PDADAO     PdaDao   = new PT_S_SYSVAR_PDADAO();
    private PT_S_SYSVAR_PDAEntity  PdaEent  = new PT_S_SYSVAR_PDAEntity();

    private VariableList vl = new VariableList();
    
    public SysVarMgrCUDCmd() {
    }


    public SysVarMgrCUDCmd(String next_url) {
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
    	if(scMODE.equalsIgnoreCase("ALL")){
	    	ds = pReq.getDatasetList().getDataset("ds_PT_S_SYSVAR_MASTER");
	    	if(ds != null) dsProc(ds);
	    	
	    	ds = pReq.getDatasetList().getDataset("ds_PT_S_SYSVAR_PDA");
	    	if(ds != null) dsProc(ds);
	    	
    	}
    	

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
    	if(ds.getId().equalsIgnoreCase("ds_PT_S_SYSVAR_MASTER"))
    	{
	    	/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	Eent.setDsOnlyString(ds, arg_row);// 
	    	/******세팅 값들 콘솔창에서 확인 ******/
	    	KJFLog.debug(Eent.toString()); 		
	    	/******저장 ******/
	    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
	        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
	        Eent.setINS_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
	    	
	        Eent.setSIDO_CODE(SIDO_CODE);
	        Eent.setSIGUNGU_CODE(SIGUNGU_CODE);
	    	dao.insert(Eent);
    	}else if(ds.getId().equalsIgnoreCase("ds_PT_S_SYSVAR_PDA"))
    	{
	    	/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	PdaEent.setDsOnlyString(ds, arg_row);// 
	    	/******세팅 값들 콘솔창에서 확인 ******/
	    	KJFLog.debug(PdaEent.toString()); 		
	    	/******저장 ******/
	    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
	        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
	        String SEQ = KJFDBUtil.getMaxID("SEQ","PT_S_SYSVAR_PDA");
	        
	        PdaEent.setSEQ(SEQ);
	        PdaEent.setSIDO_CODE(SIDO_CODE);
	        PdaEent.setSIGUNGU_CODE(SIGUNGU_CODE);
	        PdaDao.insert(PdaEent);
    	}
    	


    }
    


    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("ds_PT_S_SYSVAR_MASTER"))
    	{
	    	/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	Eent.setDsOnlyString(ds, arg_row);//     	
	    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
	        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
	        Eent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
	        
	        Eent.setSIDO_CODE(SIDO_CODE);
	        Eent.setSIGUNGU_CODE(SIGUNGU_CODE);
	    	String[] fields={"SIDO_CODE", "SIGUNGU_CODE","WET_ID","INP_DT" };   	
	    	/******특정한 필드를 제외한 수정 ******/
	    	dao.updateExcludeOnly(Eent, fields);    	
    	}else if(ds.getId().equalsIgnoreCase("ds_PT_S_SYSVAR_PDA")){
    		/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	PdaEent.setDsOnlyString(ds, arg_row);//     	
	    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
	        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
	    	
	        PdaEent.setSIDO_CODE(SIDO_CODE);
	        PdaEent.setSIGUNGU_CODE(SIGUNGU_CODE);
	    	String[] fields={"SIDO_CODE", "SIGUNGU_CODE","WET_ID","INP_DT" };   	
	    	/******특정한 필드를 제외한 수정 ******/
	    	PdaDao.updateExcludeOnly(PdaEent, fields);    
    		
    		
    	}

    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("ds_PT_S_SYSVAR_PDA")){
    		
    		ReportDAO    rDAO        = new ReportDAO();
        	
        	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
    		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
    		String SEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
        	
        	String DELETE = "DELETE FROM PT_S_SYSVAR_PDA WHERE SEQ = '"+SEQ+"' AND SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' ";
        	
        	rDAO.execute(DELETE);
    	}
    }

}