package sp.ub.cmd;


import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_UB_SUVSPOTDAO;
import sp.dao.PT_UB_SUVSPOTEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;

import kjf.util.KJFUtil;

public class UBSupervisionResultExCmd implements KJFCommand{
 
	  private String next;
	
		private PT_UB_SUVSPOTDAO    PT_UB_SUVSPOTdao = new PT_UB_SUVSPOTDAO();
	    private PT_UB_SUVSPOTEntity PT_UB_SUVSPOTEnt = new PT_UB_SUVSPOTEntity();
	    
	    private VariableList vl = new VariableList();
	    
	    
	    public  UBSupervisionResultExCmd() {
	    }


	    public  UBSupervisionResultExCmd(String next_url) {
	    	next = next_url;
	    }
 

	    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
	    	
	    	/****** Service API 초기화 ******/
	    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
	    	/** Web Server에서 XML수신 및 Parsing **/
	    	pReq.receiveData(); 	
	    	
	    	vl = pReq.getVariableList();
	    	
	    	String scMODE = vl.getValueAsString("workMODE");
	    	
	    	/** List 획득 및 Dataset 획득 **/
	    	Dataset ds;
	    	
			ds = pReq.getDatasetList().getDataset("ds_PT_UB_SUVSPOT");
		    
			if (ds != null) dsProc(ds);
	    	
	        return next;
	    }
	    
	    private void dsProc(Dataset ds) throws Exception
	    {	
	    	System.out.println("ds.getRowCount() : "+ds.getRowCount());
	    	for(int i=0;i<ds.getRowCount();i++){
	    		if(ds.getRowStatus(i).equals("insert")) {
	    			insertExe(ds,i);
	    		
	    		}
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
	    	PT_UB_SUVSPOTEnt.setDsOnlyString(ds, arg_row);//
	    	String INS_DT=PT_UB_SUVSPOTEnt.getINS_DT();
	    	String date = INS_DT.substring(0,4)+"-"+INS_DT.substring(4,6)+"-"+INS_DT.substring(6,8)+" 00:00:00";
	    	
	    	PT_UB_SUVSPOTEnt.setINS_DT(date);
	    	//PT_UB_SUVSPOTEnt.setINS_DT(KJFDate.getCurDatetime());

			KJFLog.debug(PT_UB_SUVSPOTEnt.toString()); 		    	
			updateReport();
			//PT_UB_SUVSPOTdao.insert(PT_UB_SUVSPOTEnt);  
	    	
	    }
	    /**
	     * Insert
	     * @param Dataset ds, int arg_row
	     * @return
	     */
	    private void updateReport()throws Exception{
	    	 	
	    	ReportDAO rDAO;
	    	String sql = "";
	 
	    	
	    	sql = 	" INSERT INTO PT_UB_SUVSPOT		\n" +
	    			"	(RECV_NUM,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,INS_DT,SUV_NAME,SUV_STANUM,SIWORK_NAME,COI_WRT_NUM,SPOTNM,SW_DT,EW_DT,STRU_AREA,UPD_DT_OLD,AREA)	\n" +
	    			"	VALUES	\n" +
	    			" ('"+PT_UB_SUVSPOTEnt.getRECV_NUM()+"'," +
	    			" '"+PT_UB_SUVSPOTEnt.getCIV_RECV_NUM()+"',"+
	    			" '"+PT_UB_SUVSPOTEnt.getSIDO_CODE()+"',"+
	    			" '"+PT_UB_SUVSPOTEnt.getSIGUNGU_CODE()+"'," +
	    			" '"+PT_UB_SUVSPOTEnt.getINS_DT()+"'," +
	    			" '"+PT_UB_SUVSPOTEnt.getSUV_NAME()+"','"+PT_UB_SUVSPOTEnt.getSUV_STANUM()+"'," +
	    			" '"+PT_UB_SUVSPOTEnt.getSIWORK_NAME()+"','"+PT_UB_SUVSPOTEnt.getCOI_WRT_NUM()+"',"+
	    			" '"+PT_UB_SUVSPOTEnt.getSPOTNM()+"'," +
	    			" '"+PT_UB_SUVSPOTEnt.getSW_DT()+"'," +
	    			" '"+PT_UB_SUVSPOTEnt.getEW_DT()+"'," +
	    			" '"+PT_UB_SUVSPOTEnt.getSTRU_AREA()+"',"+
	    			" '"+PT_UB_SUVSPOTEnt.getUPD_DT_OLD()+"',"+
	    	        " '"+PT_UB_SUVSPOTEnt.getAREA()+"')";
	    	
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
	    		
	    	/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	
			PT_UB_SUVSPOTEnt.setDsOnlyString(ds, arg_row);// 
			PT_UB_SUVSPOTEnt.setUPD_DT(KJFDate.getCurDatetime());
	    	KJFLog.debug(PT_UB_SUVSPOTEnt.toString()); 		    	
	    	PT_UB_SUVSPOTdao.update(PT_UB_SUVSPOTEnt);
	    }

	    /**
	     * 삭제
	     * @param Dataset ds, int arg_row
	     * @return
	     */
	    private void deleteExe(Dataset ds, int arg_row)throws Exception{
	    	
	    	String sKey = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();
	    	   	
	    	ReportDAO rDAO;
	   		StringBuilder sQuery = new StringBuilder();
	    		
			String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
			
			sQuery.append(" DELETE FROM PT_UB_SUVSPOT ");
			sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
			sQuery.append(" AND SEQ = '" + sSEQ + "' ");
	    	rDAO = new ReportDAO();
	    	rDAO.execute(sQuery.toString());
	        	
	       	return;
	    }
	    
	    private String getMaxChangeSeq(String sKEY, String sTABLE, String sField) throws Exception {
	    	
	        ReportDAO rDAO = new ReportDAO();

	        
	        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
	        sQuery += " FROM " + sTABLE + " ";
	        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
	        
	        ReportEntity rEntity  = null;
	        
	        rEntity = rDAO.select(sQuery);

	        return rEntity.getValue(0,"MAX_ID");
	    }
}
