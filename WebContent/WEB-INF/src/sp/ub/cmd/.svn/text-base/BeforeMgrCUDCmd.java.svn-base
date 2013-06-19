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

import sp.dao.PT_UB_CONDEFICITDAO;
import sp.dao.PT_UB_CONDEFICITEntity;
import sp.dao.PT_UB_CONMEMODAO;
import sp.dao.PT_UB_CONMEMOEntity;
import sp.dao.PT_UB_CONSTRUCTIONDAO;
import sp.dao.PT_UB_CONSTRUCTIONEntity;
import sp.dao.PT_UB_CON_DETAILDAO;
import sp.dao.PT_UB_CON_DETAILEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.PlatformData;
import com.tobesoft.platform.data.VariableList;



public class BeforeMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_UB_CONSTRUCTIONDAO    dao = new PT_UB_CONSTRUCTIONDAO();
    private PT_UB_CONSTRUCTIONEntity Eent = new PT_UB_CONSTRUCTIONEntity();
    
    private PT_UB_CON_DETAILDAO    DETAILdao = new PT_UB_CON_DETAILDAO();
    private PT_UB_CON_DETAILEntity DETAILEent = new PT_UB_CON_DETAILEntity();
    
    private PT_UB_CONMEMODAO    MEMOdao = new PT_UB_CONMEMODAO();
    private PT_UB_CONMEMOEntity MEMOEent = new PT_UB_CONMEMOEntity();
    
    private PT_UB_CONDEFICITDAO    PT_R_DEFICITdao = new PT_UB_CONDEFICITDAO();
    private PT_UB_CONDEFICITEntity PT_R_DEFICITEnt = new PT_UB_CONDEFICITEntity();

    private VariableList vl = new VariableList();
    
    public BeforeMgrCUDCmd() {
    }


    public BeforeMgrCUDCmd(String next_url) {
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
    	
    	PlatformData pd = pReq.getPlatformData();
    	System.out.println(pd.toString());
    	
    	if(scMODE.equalsIgnoreCase("ALL")){
	    	ds = pReq.getDatasetList().getDataset("ds_PT_UB_CONSTRUCTION");
	    	if(ds != null) dsProc(ds);
	    	dsde = pReq.getDatasetList().getDataset("ds_DETAIL_1");
			if(dsde != null) dsProcDe(dsde);
			dsde = pReq.getDatasetList().getDataset("ds_DETAIL_2");
			if(dsde != null) dsProcDe(dsde);
			dsde = pReq.getDatasetList().getDataset("ds_DETAIL_3");
			if(dsde != null) dsProcDe(dsde);
			ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null) dsProc(ds);
    	}else if (scMODE.equalsIgnoreCase("MEMO"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_UB_MEMO");
	    	if(ds != null) dsProc(ds);
    	}else if(scMODE.equalsIgnoreCase("DEL")){
    		ds = pReq.getDatasetList().getDataset("ds_PT_UB_CONSTRUCTION");
    		if(ds != null) dsProc(ds); //20100212 삭제 처리  dsProcDel(ds);
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
    
    private void dsProcDe(Dataset ds) throws Exception{
    	/******** Dataset을 INSERT, UPDATE처리 ********/
    	System.out.println("dsde.getRowCount() : "+ds.getRowCount());
    	
    	for(int i=0;i<ds.getRowCount();i++){
    		if(ds.getRowStatus(i).equals("insert")) insertNupdate(ds,i);
    		if(ds.getRowStatus(i).equals("update")) insertNupdate(ds,i);
    	}
    	
    }
    
    private void dsProcDel(Dataset ds) throws Exception{
    	/******** Dataset을 INSERT, UPDATE처리 ********/    
    	System.out.println("ds.getRowCount() : "+ds.getRowCount());
    	    	
    	/****** Dataset을 DELETE처리 ****/
    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
    		deleteUpdata(ds,i);
    	}
    }
    
    /**
     * 입력
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{
    		
    		MEMOEent.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(MEMOEent.toString());
           	MEMOEent.setINS_DT(KJFDate.getCurDatetime());
           	MEMOdao.insert(MEMOEent);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			PT_R_DEFICITEnt.setSIDO_CODE(SIDO_CODE);
			PT_R_DEFICITEnt.setSIGUNGU_CODE(SIGUNGU_CODE);
    		KJFLog.debug(PT_R_DEFICITEnt.toString());
    		PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
    	}
    	
    }
    
    
    private void insertDe(Dataset ds, int arg_row)throws Exception{
    	
    	
	    	String RECV_NUM = Eent.getRECV_NUM();
	    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			String WRT_ID = vl.getValueAsString("WRT_ID");
			
			if(KJFUtil.isEmpty(RECV_NUM)){
				RECV_NUM = vl.getValueAsString("scRECV_NUM");
	    	}
	    	String SRL = KJFDBUtil.getMaxID2("SRL","PT_UB_CON_DETAIL",1);
    		
    		/****** Dataset one_row 값 전체 자동 세팅 ******/
    		DETAILEent.setDsOnlyString(ds, arg_row);//  
	    	/****** 이후 변경되는 값들 세팅 ******/
	    	/******세팅 값들 콘솔창에서 확인 ******/
	    	KJFLog.debug(DETAILEent.toString()); 		
	    	DETAILEent.setSRL(SRL);
	    	DETAILEent.setRECV_NUM(RECV_NUM);
	    	DETAILEent.setSIDO_CODE(SIDO_CODE);
	    	DETAILEent.setSIGUNGU_CODE(SIGUNGU_CODE);
	    	DETAILEent.setWRT_ID(WRT_ID);
	    	DETAILEent.setINS_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
	    	
	    	/******저장 ******/
	    	DETAILdao.insert(DETAILEent);
    	

    }
    


    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("ds_PT_UB_CONSTRUCTION"))
    	{
    		
    		/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	Eent.setDsOnlyString(ds, arg_row);//     	
	    	String[] fields={"RECV_NUM", "WRT_ID", "SIDO_CODE", "SIGUNGU_CODE", "INS_DT" };   	
	    	/******특정한 필드를 제외한 수정 ******/
	    	if("1".equals(Eent.getPROC_STE())){
	    		Eent.setPROC_STE("2");
	    	}
	    	dao.updateExcludeOnly(Eent, fields); 
    	
    	}else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{
    		MEMOEent.setDsOnlyString(ds, arg_row);//     	
    		String[] fields2={"RECV_NUM", "SIDO_CODE", "SIGUNGU_CODE", "SEQ" };   	
    		MEMOdao.updateExcludeOnly(MEMOEent, fields2);
    	}else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{
    		MEMOEent.setDsOnlyString(ds, arg_row);//     	
    		String[] fields2={"RECV_NUM", "SIDO_CODE", "SIGUNGU_CODE", "SEQ" };   	
    		MEMOdao.updateExcludeOnly(MEMOEent, fields2);
    	}else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String[] fields = {"DEFI_SEQ","DEFI_GROUP","WRT_ID","INS_DT","RECV_NUM","SIDO_CODE","SIGUNGU_CODE"};
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			PT_R_DEFICITEnt.setSIDO_CODE(SIDO_CODE);
			PT_R_DEFICITEnt.setSIGUNGU_CODE(SIGUNGU_CODE);
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_DEFICITdao.updateExcludeOnly(PT_R_DEFICITEnt, fields);
    	}
    	

    }
    
    private void updateDe(Dataset ds, int arg_row)throws Exception{
    	
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	DETAILEent.setDsOnlyString(ds, arg_row);//     	
    	String REV_NUM = Eent.getRECV_NUM();
    	if(KJFUtil.isEmpty(REV_NUM)){
    		REV_NUM = vl.getValueAsString("scRECV_NUM");
    	}
    	
    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
		String WRT_ID = vl.getValueAsString("WRT_ID");
		
		DETAILEent.setSIDO_CODE(SIDO_CODE);
    	DETAILEent.setSIGUNGU_CODE(SIGUNGU_CODE);
    	DETAILEent.setWRT_ID(WRT_ID);
    	DETAILEent.setRECV_NUM(REV_NUM);

    	String[] fields={"SRL","RECV_NUM", "SIDO_CODE" ,"SIGUNGU_CODE","INS_DT","WRT_ID"};   	
    	/******특정한 필드를 제외한 수정 ******/
    	DETAILEent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
    
    	/******특정한 필드를 제외한 수정 ******/
    	DETAILdao.updateExcludeOnly(DETAILEent, fields); 
    }
    
    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String deleteQuery;
    	String sKey = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    	if(ds.getId().equalsIgnoreCase("ds_PT_UB_CONSTRUCTION"))
    	{
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			ReportDAO    rDAO        = new ReportDAO();
			
			
	    	Eent.setRECV_NUM(sKey);
	    	Eent.setSIDO_CODE(SIDO_CODE);
	    	Eent.setSIGUNGU_CODE(SIGUNGU_CODE);

	    	String DELETE = " DELETE FROM PT_UB_CON_DETAIL  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND RECV_NUM = '"+sKey+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
	    	rDAO.execute(DELETE);
	    	DELETE = " DELETE FROM PT_UB_CONMEMO  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND RECV_NUM = '"+sKey+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
	    	rDAO.execute(DELETE);
	    	DELETE = " DELETE FROM PT_UB_CONDEFICIT  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND RECV_NUM = '"+sKey+"' ";
	    	rDAO.execute(DELETE);
	    	 DELETE = " DELETE FROM PT_UB_CONSTRUCTION  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND RECV_NUM = '"+sKey+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
	    	rDAO.execute(DELETE);
	    	dao.delete(Eent);
	    
    	}else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{
    		String SIDO_CODE = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
			String SIGUNGU_CODE = ds.getDeleteColumn(arg_row,"SIGUNGU_CODE").getString();
			String SEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
			String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
			
    		deleteQuery = " DELETE FROM PT_UB_CONMEMO WHERE RECV_NUM = '" + RECV_NUM + "'";
    		deleteQuery += " AND SIDO_CODE = '" + SIDO_CODE + "' AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "' AND SEQ = '" + SEQ + "'";
    		ReportDAO rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String sSIDO_CODE = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
    		ReportDAO    rDAO        = new ReportDAO();
    		deleteQuery = " DELETE FROM PT_UB_CONDEFICIT WHERE RECV_NUM = '" + sKey + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sSIDO_CODE + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
    	}   
    }
    
    
    private void insertNupdate(Dataset ds, int arg_row)throws Exception{
    	String REV_NUM = Eent.getRECV_NUM();
    	if(KJFUtil.isEmpty(REV_NUM)){
    		REV_NUM = vl.getValueAsString("scRECV_NUM");
    	}
    	String SEQ  = KJFMi.dsGet(ds,arg_row,"SEQ");
    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");

		String SQL = 
    				"SELECT COUNT(*) AS CNT FROM PT_UB_CON_DETAIL  \n" +
    				" WHERE RECV_NUM = '"+REV_NUM+"'  \n" +
    				"   AND SEQ = '"+SEQ+"'  \n" +
    				"   AND SIDO_CODE  = '"+SIDO_CODE+"'  \n" +
    				"   AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n" ;
    	
    	ReportDAO    rDAO        = new ReportDAO(); 
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(SQL);
        if(rEntity != null){
        	if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) == 0){
	        	insertDe(ds,arg_row);
	        	DETAILEent.setSIDO_CODE(SIDO_CODE);
	        	DETAILEent.setSIGUNGU_CODE(SIGUNGU_CODE);
	        }else{
	        	updateDe(ds,arg_row);
	        	DETAILEent.setSIDO_CODE(SIDO_CODE);
	        	DETAILEent.setSIGUNGU_CODE(SIGUNGU_CODE);
	        }
        }
    }
    
    private void deleteUpdata(Dataset ds, int arg_row)throws Exception{
    	ReportDAO    rDAO        = new ReportDAO();
    	
    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
		String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    	
    	String UPDATA = "UPDATE PT_UB_CONSTRUCTION SET SUV_APPL = '',REPO_DT='', SW_BEF_REPO_DELINUM = '' WHERE RECV_NUM = '"+RECV_NUM+"' AND SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' ";
    	
    	rDAO.execute(UPDATA);
    	
    }
}