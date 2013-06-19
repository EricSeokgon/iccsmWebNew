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

import sp.dao.PT_UB_EQUIPMENTDAO;
import sp.dao.PT_UB_EQUIPMENTEntity;
import sp.dao.PT_UB_USEBEFOREDAO;
import sp.dao.PT_UB_USEBEFOREEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;

import kjf.util.KJFUtil;

public class UBEquipmentResultExCmd implements KJFCommand{
 
	  private String next;
	
		private PT_UB_EQUIPMENTDAO    PT_UB_EQUIPMENTdao = new PT_UB_EQUIPMENTDAO();
	    private PT_UB_EQUIPMENTEntity PT_UB_EQUIPMENTEnt = new PT_UB_EQUIPMENTEntity();
	    
	    private PT_UB_USEBEFOREDAO    dao = new PT_UB_USEBEFOREDAO();
	    private PT_UB_USEBEFOREEntity Eent = new PT_UB_USEBEFOREEntity();
	    
	    
	    private VariableList vl = new VariableList();
	    String temp;
	    
	    public  UBEquipmentResultExCmd() {
	    }


	    public  UBEquipmentResultExCmd(String next_url) {
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
	    	
			ds = pReq.getDatasetList().getDataset("ds_PT_UB_EQUIPMENT");
		    
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
	    	PT_UB_EQUIPMENTEnt.setDsOnlyString(ds, arg_row);//
			PT_UB_EQUIPMENTEnt.setINS_DT(KJFDate.getCurDatetime());

			KJFLog.debug(PT_UB_EQUIPMENTEnt.toString()); 		    	
			
			Eent.setDsOnlyString(ds, arg_row);//
			Eent.setINS_DT(KJFDate.getCurDatetime());

			KJFLog.debug(Eent.toString()); 	
		    //updateUseBefore();
			updateEq();
			
		
		
			//PT_UB_EQUIPMENTdao.insert(PT_UB_EQUIPMENTEnt);  
	    	
	    }
	    /**
	     * Insert
	     * @param Dataset ds, int arg_row
	     * @return
	     */
	    private void updateEq()throws Exception{
	    	 	
	    	ReportDAO rDAO;
	    	String sql ="";
	    	String sqln="";
	    	
	    	sql = 	" INSERT INTO PT_UB_EQUIPMENT		\n" +
	    			"(RECV_NUM,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,TYPE_PROC_NO_CA,TYPE_PROC_NM_CA,FREQUENCY_SCOPE_CA,WIRE_TYPE_CA," +
	    			"TYPE_PROC_NO_MA,TYPE_PROC_NM_MA,FREQUENCY_SCOPE_MA,WIRE_TYPE_MA,TYPE_PROC_NO_SMA,TYPE_PROC_NM_SMA,FREQUENCY_SCOPE_SMA,WIRE_TYPE_SMA)	\n" +
	    			"	VALUES	\n" +
	    			" ('"+PT_UB_EQUIPMENTEnt.getRECV_NUM()+"'," +
	    			" '"+PT_UB_EQUIPMENTEnt.getCIV_RECV_NUM()+"',"+
	    			" '"+PT_UB_EQUIPMENTEnt.getSIDO_CODE()+"',"+
	    			" '"+PT_UB_EQUIPMENTEnt.getSIGUNGU_CODE()+"'," +
	    			" '"+PT_UB_EQUIPMENTEnt.getTYPE_PROC_NO_CA()+"','"+PT_UB_EQUIPMENTEnt.getTYPE_PROC_NM_CA()+"'," +
	    			" '"+PT_UB_EQUIPMENTEnt.getFREQUENCY_SCOPE_CA()+"','"+PT_UB_EQUIPMENTEnt.getWIRE_TYPE_CA()+"',"+
	    			" '"+PT_UB_EQUIPMENTEnt.getTYPE_PROC_NO_MA()+"','"+PT_UB_EQUIPMENTEnt.getTYPE_PROC_NM_MA()+"'," +
	    			" '"+PT_UB_EQUIPMENTEnt.getFREQUENCY_SCOPE_MA()+"','"+PT_UB_EQUIPMENTEnt.getWIRE_TYPE_MA()+"',"+
	    			" '"+PT_UB_EQUIPMENTEnt.getTYPE_PROC_NO_SMA()+"','"+PT_UB_EQUIPMENTEnt.getTYPE_PROC_NM_SMA()+"'," +
	    			" '"+PT_UB_EQUIPMENTEnt.getFREQUENCY_SCOPE_SMA()+"','"+PT_UB_EQUIPMENTEnt.getWIRE_TYPE_SMA()+"')";
	    
	    	sqln= 	" INSERT INTO PT_UB_USEBEFORE		\n" +
			" (RECV_NUM,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,INSP_DT,AREA,INSP_SPOT_ADDR,INSP_SPOT_DETAILADDR,ADMIT_DT,APPLPER_NM,OPE_NAME,USE,PROC_STE,WRT_ID)	\n" +
			" VALUES	\n" +
			" ('"+PT_UB_EQUIPMENTEnt.getRECV_NUM()+"'," +
			" '"+PT_UB_EQUIPMENTEnt.getCIV_RECV_NUM()+"',"+
			//" '"+PT_UB_USEBEFOREEnt.getCIV_RECV_NUM()+"'," +
			" '"+Eent.getSIDO_CODE()+"',"+
			" '"+Eent.getSIGUNGU_CODE()+"'," +
			" '"+Eent.getINSP_DT()+"'," +
			" '"+Eent.getAREA()+"'," +
			" '"+Eent.getINSP_SPOT_ADDR()+"','"+Eent.getINSP_SPOT_DETAILADDR()+"'," +
			" '"+Eent.getADMIT_DT()+"','"+Eent.getAPPLPER_NM()+"',"+
			" '"+Eent.getOPE_NAME()+"'," +
			" '"+Eent.getUSE()+"'," +
			" 3," +
			" '"+Eent.getWRT_ID()+"')";
			//" '"+Eent.getPROC_STE()+"'," +
	    
	    	
	    	rDAO = new ReportDAO();
	    	rDAO.execute(sql);
	    	rDAO.execute(sqln);
	       	return;
	    }	    
	    
	  /*  private void updateUseBefore()throws Exception{
    	 	
	    	ReportDAO rDAO;
	    	String sql = "";
	 
	    	sql = 	" INSERT INTO PT_UB_USEBEFORE		\n" +
	    			" (RECV_NUM,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,AREA,INSP_SPOT_ADDR,INSP_SPOT_DETAILADDR,ADMIT_DT,APPLPER_NM,OPE_NAME,PROC_STE,WRT_ID)	\n" +
	    			" VALUES	\n" +
	    			" ('"+PT_UB_EQUIPMENTEnt.getSIGUNGU_CODE()+"' ||'00'|| PT_UB_EQUIPMENT_NO.nextval," +
	    			" '"+PT_UB_EQUIPMENTEnt.getSIGUNGU_CODE()+"' ||'00'|| PT_UB_EQUIPMENT_NO.nextval," +
	    			//" '"+PT_UB_USEBEFOREEnt.getCIV_RECV_NUM()+"'," +
	    			" '"+Eent.getSIDO_CODE()+"',"+
	    			" '"+Eent.getSIGUNGU_CODE()+"'," +
	    			" '"+Eent.getAREA()+"'," +
	    			" '"+Eent.getINSP_SPOT_ADDR()+"','"+Eent.getINSP_SPOT_DETAILADDR()+"'," +
	    			" '"+Eent.getADMIT_DT()+"','"+Eent.getAPPLPER_NM()+"',"+
	    			" '"+Eent.getOPE_NAME()+"'," +
	    			" 3," +
	    			" '"+Eent.getWRT_ID()+"')";
	    			//" '"+Eent.getPROC_STE()+"'," +
	    		
	    	rDAO = new ReportDAO();
	    	rDAO.execute(sql);
	        	
	       	return;
	    }	    
	  */
	
	    
	    /**
	     * 수정
	     * @param Dataset ds, int arg_row
	     * @return
	     */
	    private void updateExe(Dataset ds, int arg_row)throws Exception{
	    		
	    	/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	
			PT_UB_EQUIPMENTEnt.setDsOnlyString(ds, arg_row);// 
			PT_UB_EQUIPMENTEnt.setUPD_DT(KJFDate.getCurDatetime());
	    	KJFLog.debug(PT_UB_EQUIPMENTEnt.toString()); 		    	
	    	PT_UB_EQUIPMENTdao.update(PT_UB_EQUIPMENTEnt);
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
			
			sQuery.append(" DELETE FROM PT_UB_EQUIPMENT ");
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
