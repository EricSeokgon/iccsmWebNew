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

import sp.dao.PT_UB_DEFICITDAO;
import sp.dao.PT_UB_DEFICITEntity;
import sp.dao.PT_UB_FILEDAO;
import sp.dao.PT_UB_FILEEntity;
import sp.dao.PT_UB_MEMODAO;
import sp.dao.PT_UB_MEMOEntity;
import sp.dao.PT_UB_USEBEFOREDAO;
import sp.dao.PT_UB_USEBEFOREEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class UBReceiptMgrExCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_UB_USEBEFOREDAO    dao = new PT_UB_USEBEFOREDAO();
    private PT_UB_USEBEFOREEntity Eent = new PT_UB_USEBEFOREEntity();
    
    private PT_UB_MEMODAO    MAMOdao = new PT_UB_MEMODAO();
    private PT_UB_MEMOEntity MAMOEent = new PT_UB_MEMOEntity();
    
    private PT_UB_DEFICITDAO    PT_R_DEFICITdao = new PT_UB_DEFICITDAO();
    private PT_UB_DEFICITEntity PT_R_DEFICITEnt = new PT_UB_DEFICITEntity();

    private VariableList vl = new VariableList();
    
    public UBReceiptMgrExCUDCmd() {
    }


    public UBReceiptMgrExCUDCmd(String next_url) {
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
    		ds = pReq.getDatasetList().getDataset("ds_PT_UB_USEBEFORE");
    		if(ds != null) dsProc(ds);
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null) dsProc(ds);
    	}else if (scMODE.equalsIgnoreCase("ALL_Except")){
    		ds = pReq.getDatasetList().getDataset("ds_PT_UB_USEBEFORE");
    		if(ds != null) {
    			//dsProcDel2(ds);    
    			dsProc2(ds);
    		}
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null) dsProc(ds);
    	}else if (scMODE.equalsIgnoreCase("MEMO")){
	    	ds = pReq.getDatasetList().getDataset("dsPT_UB_MEMO");
	    	if(ds != null) dsProc(ds);
    	}else if(scMODE.equalsIgnoreCase("DEL")){
    		ds = pReq.getDatasetList().getDataset("ds_PT_UB_USEBEFORE");
    		//if(ds != null) dsProcDel(ds);
    	}else if(scMODE.equalsIgnoreCase("INSP")){
    		String RECV_NUM = vl.getValueAsString("RECV_NUM");
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE_");
    		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
    		IpspUpdata(RECV_NUM,SIDO_CODE,SIGUNGU_CODE);
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
    	 	
    
    }
    /*
     * 사용전검사 관리 
     */
    private void dsProc2(Dataset ds) throws Exception{
    	/******** Dataset을 INSERT, UPDATE처리 ********/
    	System.out.println("ds.getRowCount() : "+ds.getRowCount());
    	for(int i=0;i<ds.getRowCount();i++){
    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);
    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
    	} 	 	
    
    }
    
    /**
     * 입력
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("ds_PT_UB_USEBEFORE"))
    	{
    	
	    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			String WRT_ID = vl.getValueAsString("WRT_ID");
		
			//String RECV_NUM = DOC_NUM(SIDO_CODE,SIGUNGU_CODE);
    		
    		/****** Dataset one_row 값 전체 자동 세팅 ******/
    		Eent.setDsOnlyString(ds, arg_row);//  
	    	/****** 이후 변경되는 값들 세팅 ******/
	        String CIV_RECV_NUM  = KJFMi.dsGet(ds,arg_row,"CIV_RECV_NUM");
	    	/******세팅 값들 콘솔창에서 확인 ******/
	    	KJFLog.debug(Eent.toString()); 		
	    	//Eent.setRECV_NUM(SIDO_CODE+"-"+RECV_NUM);
	    	Eent.setCIV_RECV_NUM(CIV_RECV_NUM);
	    	Eent.setSIDO_CODE(SIDO_CODE);
	    	Eent.setSIGUNGU_CODE(SIGUNGU_CODE);
	    	Eent.setWRT_ID(WRT_ID);
	    	Eent.setINS_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
	    	/******저장 ******/
	    	updateReport();
	    	//dao.insert(Eent);
    	}
    	/*else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
    		MAMOEent.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(MAMOEent.toString());
           	MAMOEent.setINS_DT(KJFDate.getCurDatetime());
           	MAMOdao.insert(MAMOEent);
    	}else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			PT_R_DEFICITEnt.setSIDO_CODE(SIDO_CODE);
			PT_R_DEFICITEnt.setSIGUNGU_CODE(SIGUNGU_CODE);
    		KJFLog.debug(PT_R_DEFICITEnt.toString());
    		PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
    	}*/
    	 
    }
    private void updateReport()throws Exception{
	 	
    	ReportDAO rDAO;
    	String sql = "";
 
    	sql = 	" INSERT INTO PT_UB_USEBEFORE		\n" +
    			" (RECV_NUM,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,RECV_DT,APPLPER_NM,AREA,INSP_FEE,INSP_DT,INS_DT,WRT_ID,NAPPL_YN,PROC_STE,DELI_DT,NAPPL_CAUSE)	\n" +
    			" VALUES	\n" +
    			" ('"+Eent.getSIGUNGU_CODE()+"' ||'0'|| PT_UB_USEBEFORE_NO.nextval," +
    			" '"+Eent.getSIGUNGU_CODE()+"' ||'0'|| PT_UB_USEBEFORE_NO.nextval," +
    			//" '"+PT_UB_USEBEFOREEnt.getCIV_RECV_NUM()+"'," +
    			" '"+Eent.getSIDO_CODE()+"',"+
    			" '"+Eent.getSIGUNGU_CODE()+"'," +
    			" '"+Eent.getRECV_DT()+"'," +
    			" '"+Eent.getAPPLPER_NM()+"','"+Eent.getAREA()+"'," +
    			" '"+Eent.getINSP_FEE()+"','"+Eent.getINSP_DT()+"',"+
    			" '"+Eent.getINS_DT()+"'," +
    			" '"+Eent.getWRT_ID()+"'," +
    			" '"+Eent.getNAPPL_YN()+"'," +
    			" 3," +
    			//" '"+Eent.getPROC_STE()+"'," +
    			" '"+Eent.getDELI_DT()+"'," +
    			" '"+Eent.getNAPPL_CAUSE()+"')";
    	
    	rDAO = new ReportDAO();
    	rDAO.execute(sql);
        	
       	return;
    }	

    
    
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    	if(ds.getId().equalsIgnoreCase("ds_PT_UB_USEBEFORE"))
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
    		MAMOEent.setDsOnlyString(ds, arg_row);//     	
    		String[] fields2={"RECV_NUM", "SIDO_CODE", "SIGUNGU_CODE", "SEQ" };   	
    		MAMOdao.updateExcludeOnly(MAMOEent, fields2);
    	}else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String[] fields = {"DEFI_SEQ","DEFI_GROUP","WRT_ID","INS_DT","RECV_NUM","SIDO_CODE"};
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			PT_R_DEFICITEnt.setSIDO_CODE(SIDO_CODE);
			PT_R_DEFICITEnt.setSIGUNGU_CODE(SIGUNGU_CODE);
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_DEFICITdao.updateExcludeOnly(PT_R_DEFICITEnt, fields);
    	}
    	


    }

    
    private void IpspUpdata(String RECV_NUM,String SIDO_CODE,String SIGUNGU_CODE)throws Exception{
    	ReportDAO    rDAO        = new ReportDAO();
    	
    	String UPDATA = "UPDATE PT_UB_USEBEFORE SET ISSUE_ITEM = 'M' WHERE RECV_NUM = '"+RECV_NUM+"' AND SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' ";
    	
    	rDAO.execute(UPDATA);
    	
    }
   
}