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
import kjf.util.KJFMi;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_MI_USERDAO;
import sp.dao.PT_MI_USEREntity;
import sp.util.Crypto;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class UserMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_MI_USERDAO    dao = new PT_MI_USERDAO();
    private PT_MI_USEREntity Eent = new PT_MI_USEREntity();

    private VariableList vl = new VariableList();
    
    public UserMgrCUDCmd() {
    }


    public UserMgrCUDCmd(String next_url) {
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
    	Dataset ds = pReq.getDatasetList().getDataset("ds_PT_MI_USER");
    	
    	dsProc(ds);
    
        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception{
    	/******** Dataset을 INSERT, UPDATE처리 ********/

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
    	
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	Eent.setDsOnlyString(ds, arg_row);// 
        
    	Eent.setPASS(Eent.getPASS());
    	
    	/******세팅 값들 콘솔창에서 확인 ******/
    	KJFLog.debug(Eent.toString());
    	String WRT_ID = vl.getValueAsString("WRT_ID");
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
    	
    	//Eent.setPASS(Crypto.Encrypt(Eent.getPASS()));  //패스워드수정
    	
    	Eent.setPASS(Eent.getPASS());  //패스워드수정
    	
    	dao.update(Eent);
    	String[] fields={"OFFI_ID", "INS_DT" };   	
    	/******특정한 필드를 제외한 수정 ******/
    	String WRT_ID = vl.getValueAsString("WRT_ID");
    	Eent.setWRT_ID(WRT_ID);
    	Eent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
    	dao.updateExcludeOnly(Eent, fields); 
    	

    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	Eent.setOFFI_ID(ds.getDeleteColumn(arg_row,"OFFI_ID").getString());
    	dao.delete(Eent);
    	
    }

}