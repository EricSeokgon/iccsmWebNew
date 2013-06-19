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

import sp.dao.PT_UB_SUVDEFICITDAO;
import sp.dao.PT_UB_SUVDEFICITEntity;
import sp.dao.PT_UB_SUVMEMODAO;
import sp.dao.PT_UB_SUVMEMOEntity;
import sp.dao.PT_UB_SUVSPOTDAO;
import sp.dao.PT_UB_SUVSPOTEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class SupervisionSpotMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_UB_SUVSPOTDAO    dao = new PT_UB_SUVSPOTDAO();
    private PT_UB_SUVSPOTEntity Eent = new PT_UB_SUVSPOTEntity();

    private PT_UB_SUVMEMODAO    MEMOdao = new PT_UB_SUVMEMODAO();
    private PT_UB_SUVMEMOEntity MEMOEent = new PT_UB_SUVMEMOEntity();
    
    private PT_UB_SUVDEFICITDAO    PT_R_DEFICITdao = new PT_UB_SUVDEFICITDAO();
    private PT_UB_SUVDEFICITEntity PT_R_DEFICITEnt = new PT_UB_SUVDEFICITEntity();
    
    private VariableList vl = new VariableList();
    
    public SupervisionSpotMgrCUDCmd() {
    }


    public SupervisionSpotMgrCUDCmd(String next_url) {
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
    		ds = pReq.getDatasetList().getDataset("ds_PT_UB_SUVSPOT");
    		if(ds != null) dsProc(ds);
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null) dsProc(ds);
    	}else if (scMODE.equalsIgnoreCase("MEMO"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_UB_MEMO");
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
    	
	    	String WRT_ID = vl.getValueAsString("WRT_ID");
	    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			String RECV_NUM = vl.getValueAsString("scRECV_NUM");
			
			if(ds.getId().equalsIgnoreCase("ds_PT_UB_SUVSPOT"))
	    	{
				RECV_NUM = DOC_NUM(SIDO_CODE,SIGUNGU_CODE);
	    		/****** Dataset one_row 값 전체 자동 세팅 ******/
	    		Eent.setDsOnlyString(ds, arg_row);//  
		    	/****** 이후 변경되는 값들 세팅 ******/
		    	/******세팅 값들 콘솔창에서 확인 ******/
		    	KJFLog.debug(Eent.toString()); 		
		    	Eent.setWRT_ID(WRT_ID);
				Eent.setSIDO_CODE(SIDO_CODE);
		    	Eent.setSIGUNGU_CODE(SIGUNGU_CODE);
		    	Eent.setRECV_NUM(SIDO_CODE+RECV_NUM);
		    	Eent.setINS_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
		    	/******저장 ******/
		    	dao.insert(Eent);
	    	}else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
	    	{
	    		MEMOEent.setDsOnlyString(ds, arg_row);// 
	           	KJFLog.debug(MEMOEent.toString());
	           	MEMOEent.setRECV_NUM(RECV_NUM);
	           	MEMOEent.setINS_DT(KJFDate.getCurDatetime());
	           	MEMOdao.insert(MEMOEent);
	    	}
	    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
	    	{
	    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
	    		KJFLog.debug(PT_R_DEFICITEnt.toString());
				PT_R_DEFICITEnt.setSIDO_CODE(SIDO_CODE);
				PT_R_DEFICITEnt.setSIGUNGU_CODE(SIGUNGU_CODE);
	    		PT_R_DEFICITEnt.setRECV_NUM(RECV_NUM);
	    		PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
	    	}
    	
    }
   

    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	if(ds.getId().equalsIgnoreCase("ds_PT_UB_SUVSPOT"))
    	{
	    	/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	Eent.setDsOnlyString(ds, arg_row);//     	
	    	String[] fields={"RECV_NUM", "SIDO_CODE", "SIGUNGU_CODE", "WRT_ID", "INS_DT" };   	
	    	/******특정한 필드를 제외한 수정 ******/
	    	Eent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
	    	dao.updateExcludeOnly(Eent, fields); 
	    	
    	
    	}else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{
	    	MEMOEent.setDsOnlyString(ds, arg_row);//     	
			String[] fields2={"RECV_NUM", "SIDO_CODE", "SIGUNGU_CODE" };   	
			MEMOdao.updateExcludeOnly(MEMOEent, fields2);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String[] fields = {"DEFICIT_CONTENT","SEQ"};
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			PT_R_DEFICITEnt.setSIDO_CODE(SIDO_CODE);
			PT_R_DEFICITEnt.setSIGUNGU_CODE(SIGUNGU_CODE);
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_DEFICITdao.updateExcludeOnly(PT_R_DEFICITEnt, fields);
    	}
			
    }

    
    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String deleteQuery;    	
    	ReportDAO rDAO;
    	
    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
    	
    	if(ds.getId().equalsIgnoreCase("ds_PT_UB_SUVSPOT"))
    	{
    		
			String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
			
			rDAO        = new ReportDAO();
			
	    	Eent.setRECV_NUM(RECV_NUM);
	    	Eent.setSIDO_CODE(SIDO_CODE);
	    	Eent.setSIGUNGU_CODE(SIGUNGU_CODE);
	    	
	    	String DELETE = " DELETE FROM PT_UB_SUVMEMO  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND RECV_NUM = '"+RECV_NUM+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
	    	rDAO.execute(DELETE);
	    	
	    	DELETE = " DELETE FROM PT_UB_SUVDEFICIT  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND RECV_NUM = '"+RECV_NUM+"' ";
	    	rDAO.execute(DELETE);
	    	dao.delete(Eent);
    	
	    }else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
		{
	    	
			String SEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
			String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
			SIGUNGU_CODE = ds.getDeleteColumn(arg_row,"SIGUNGU_CODE").getString();
			SIDO_CODE = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
			
    		deleteQuery = " DELETE FROM PT_UB_SUVMEMO WHERE RECV_NUM = '" + RECV_NUM + "'";
    		deleteQuery += " AND SIDO_CODE = '" + SIDO_CODE + "' AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "' AND SEQ = '" + SEQ + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
		}
	    else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    		
    		deleteQuery = " DELETE FROM PT_UB_SUVDEFICIT WHERE RECV_NUM = '" + RECV_NUM + "'";
    		deleteQuery += " AND SIDO_CODE = '" + SIDO_CODE + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
    	}   
    }
   
    private String DOC_NUM(String SD_CODE, String SGG_CODE)throws Exception{
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportDAO    sDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        String DOC_NUM = "";
        
        StringBuilder sSelect = new StringBuilder();
        StringBuilder sFrom = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        sSelect.append("SELECT COUNT(*) AS CNT , ");
        sSelect.append("       NVL( MAX( to_number(DOC_NUM2) ), 0 ) + 1 AS DOC_NUM   ");
        sFrom.append("  FROM PT_R_DOC_NUM ");
        sWhere.append(" WHERE DOC_CLASS = 'SuvSpotMgrCUD'  ");
        sWhere.append("   AND SD_CODE = '"+SD_CODE+"'  ");
         
         if(!KJFUtil.isEmpty(SGG_CODE)){
        	 sWhere.append("   AND SGG_CODE = '"+SGG_CODE+"'  ");
         }
         
         rEntity    = rDAO.select(sSelect.toString() + sFrom.toString() + sWhere.toString());    
         
         System.out.println("RowCnt : "+rEntity.getRowCnt());
         
         if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
        	 DOC_NUM = rEntity.getValue(0,"DOC_NUM");
        	 sDAO.execute("update PT_R_DOC_NUM set DOC_NUM2 = '"+DOC_NUM+"' "+sWhere.toString());
         }else{
        	 DOC_NUM = "100";
        	 String insert = " insert into PT_R_DOC_NUM (DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2) values " +
        	 				 "('SuvSpotMgrCUD','"+SD_CODE+"','"+SGG_CODE+"','"+SD_CODE+"','100')";
        	 sDAO.execute(insert);
         }
         
         return DOC_NUM;
    }
}