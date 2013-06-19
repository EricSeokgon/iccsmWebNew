/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.sample.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_SAMPLEDAO;
import sp.dao.PT_SAMPLEEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;



public class RegReceiptMgrCCUDCmd implements KJFCommand {
	
    private String next;
    private PT_SAMPLEDAO    PT_SAMPLEdao = new PT_SAMPLEDAO();
    private PT_SAMPLEEntity PT_SAMPLEEnt = new PT_SAMPLEEntity();

    public RegReceiptMgrCCUDCmd() {
    }


    public RegReceiptMgrCCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds = pReq.getDatasetList().getDataset("dsPT_SAMPLE");
  	    	
    	/******** Dataset을 INSERT, UPDATE처리 ********/
    	for(int i=0;i<ds.getRowCount();i++){
    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);
    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
    	}

    	/****** Dataset을 DELETE처리 ****/
    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
    		deleteExe(ds,i);
    	}

        return next;
    }

    /**
     * 입력
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{
    	
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	PT_SAMPLEEnt.setDsOnlyString(ds, arg_row);// 
 
    	/****** 이후 변경되는 값들 세팅 ******/
    	/*
        String P_CODE  = KJFMi.dsGet(ds,arg_row,"P_CODE");
    	
    	if("000".equals(P_CODE)){
    		PT_SAMPLEEnt.setP_CODE(KJFMi.dsGet(ds,arg_row,"CODE"));
    		PT_SAMPLEEnt.setCODE("000");
    	}
		*/

    	//String SEQ     = KJFDBUtil.getMaxID("SEQ", "PT_COM_CODE");
    	//String date    = KJFDate.datetimeOnly(KJFDate.getCurTime());
    	//PT_SAMPLEEnt.setSEQ(SEQ);				
    	//PT_SAMPLEEnt.setREG_DATE(date);	// 현재 시간.
    	//PT_SAMPLEEnt.setMOD_DATE(date);	// 현재 시간.
    	
    	/******세팅 값들 콘솔창에서 확인 ******/
    	KJFLog.debug(PT_SAMPLEEnt.toString()); 		
    	
    	/******저장 ******/
    	PT_SAMPLEdao.insert(PT_SAMPLEEnt);


    }
    


    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	PT_SAMPLEEnt.setDsOnlyString(ds, arg_row);//     	
 
    	/****** 이후 변경되는 값들 세팅 ******/
    	String P_CODE  = KJFMi.dsGet(ds,arg_row,"P_CODE");
    	String date    = KJFDate.getCurDatetime();
    	
    	String[] fields={"SEQ", "REG_DATE" };   	
    	/******특정한 필드를 제외한 수정 ******/
    	PT_SAMPLEdao.updateExcludeOnly(PT_SAMPLEEnt, fields); 
    	
//////////////////etc method Example//////////////////////////////////  
//
//    	String[] fields={"CODE", "P_CODE", "CODE_NAME", "ORDER_SEQ", 
//    			"USE_YN", "BIGO", "MOD_DATE" };   	
//    	/******특정한 필드만 수정 ******/
//    	PT_SAMPLEdao.updateModifiedOnly(PT_SAMPLEEnt, fields);
//    	
//
//
//		/******전체 필드 수정 ******/
//		PT_SAMPLEdao.update(PT_SAMPLEEnt); 	
//    	
//
//
//    	/******쿼리 수정 수정 ******/
//    	ReportDAO    rDAO        = new ReportDAO();
//    	String UpdataSql = "UPDATA PT_COM_CODE SET CODE = ?, SET P_CODE = ?, \n"+
//    	             "SET CODE_NAME = ?, SET ORDER_SEQ = ?, SET USE_YN = ?,  \n"+
//    				 "SET BIGO = ?, SET MOD_DATE = ?,  \n";
//    	int cnt=1;
//    	rDAO.setValue(cnt++, PT_SAMPLEEnt.getCODE());
//    	rDAO.setValue(cnt++, PT_SAMPLEEnt.getP_CODE());
//    	rDAO.setValue(cnt++, PT_SAMPLEEnt.getCODE_NAME());
//    	rDAO.setValue(cnt++, PT_SAMPLEEnt.getORDER_SEQ());
//    	rDAO.setValue(cnt++, PT_SAMPLEEnt.getUSE_YN());
//    	rDAO.setValue(cnt++, PT_SAMPLEEnt.getBIGO());
//    	rDAO.setValue(cnt++, KJFDate.datetimeOnly(KJFDate.getCurTime()));
//    	rDAO.execute(UpdataSql);
//
//////////////////etc method Example//////////////////////////////////      	
    	

    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{

    	//PT_SAMPLEEnt.setSEQ(ds.getDeleteColumn(arg_row,"SEQ").getString());
    	PT_SAMPLEEnt.setREC_NUM(ds.getDeleteColumn(arg_row,"REC_NUM").getString());
    	PT_SAMPLEEnt.setREG_NUM(ds.getDeleteColumn(arg_row,"REG_NUM").getString());
    	PT_SAMPLEdao.delete(PT_SAMPLEEnt);
    }

}