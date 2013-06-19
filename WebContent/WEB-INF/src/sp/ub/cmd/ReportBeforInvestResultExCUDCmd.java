package sp.ub.cmd;


import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_UB_CONSTRUCTIONDAO;
import sp.dao.PT_UB_CONSTRUCTIONEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;

public class ReportBeforInvestResultExCUDCmd implements KJFCommand{
 
	  private String next;
	
		private PT_UB_CONSTRUCTIONDAO    PT_UB_CONSTRUCTIONdao = new PT_UB_CONSTRUCTIONDAO();
	    private PT_UB_CONSTRUCTIONEntity PT_UB_CONSTRUCTIONEnt = new PT_UB_CONSTRUCTIONEntity();
	    
	    private VariableList vl = new VariableList();
	    
	    
	    public  ReportBeforInvestResultExCUDCmd() {
	    }


	    public  ReportBeforInvestResultExCUDCmd(String next_url) {
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
	    	
			ds = pReq.getDatasetList().getDataset("ds_PT_UB_CONSTRUCTION");
		    
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
	    	PT_UB_CONSTRUCTIONEnt.setDsOnlyString(ds, arg_row);//
			PT_UB_CONSTRUCTIONEnt.setINS_DT(KJFDate.getCurDatetime());

			
			String recv=PT_UB_CONSTRUCTIONEnt.getRECV_DT();
			String repo=PT_UB_CONSTRUCTIONEnt.getREPO_DT();
			
			if(recv.length()==10){
			String str = recv.substring(0,4)+recv.substring(5,7)+recv.substring(8,10);
			PT_UB_CONSTRUCTIONEnt.setRECV_DT(str);
			}
			
			if(repo.length()==10){
			String str2 = repo.substring(0,4)+repo.substring(5,7)+repo.substring(8,10);
			PT_UB_CONSTRUCTIONEnt.setREPO_DT(str2);
			}
				
			
			KJFLog.debug(PT_UB_CONSTRUCTIONEnt.toString()); 		    	
			updateReport();
			//PT_UB_CONSTRUCTIONdao.insert(PT_UB_CONSTRUCTIONEnt);
	    	
	    }
	    /**
	     * Insert
	     * @param Dataset ds, int arg_row
	     * @return
	     */
	    private void updateReport()throws Exception{
	    	 	
	    	ReportDAO rDAO;
	    	String sql = "";
	 
	    	
	    	sql = 	" INSERT INTO PT_UB_CONSTRUCTION		\n" +
	    			"	(RECV_NUM,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,RECV_DT,ORPE_NM,PLANER_NAME,STRU_ADDR_ADDR,SUV_APPL,INS_DT,WRT_ID,SW_BEF_REPO_DELINUM,PROC_STE,REPO_DT)	\n" +
	    			"	VALUES	\n" +
	    			" ('"+PT_UB_CONSTRUCTIONEnt.getRECV_NUM()+"'," +
	    			//" '"+PT_UB_CONSTRUCTIONEnt.getSIGUNGU_CODE()+"' ||'0'|| PT_UB_CONSTRUCTION_NO.nextval," +
	    		    " '"+PT_UB_CONSTRUCTIONEnt.getCIV_RECV_NUM()+"'," +
	    			" '"+PT_UB_CONSTRUCTIONEnt.getSIDO_CODE()+"',"+
	    			" '"+PT_UB_CONSTRUCTIONEnt.getSIGUNGU_CODE()+"'," +
	    			" '"+PT_UB_CONSTRUCTIONEnt.getRECV_DT()+"'," +
	    			" '"+PT_UB_CONSTRUCTIONEnt.getORPE_NM()+"','"+PT_UB_CONSTRUCTIONEnt.getPLANER_NAME()+"'," +
	    			" '"+PT_UB_CONSTRUCTIONEnt.getSTRU_ADDR_ADDR()+"','"+PT_UB_CONSTRUCTIONEnt.getSUV_APPL()+"',"+
	    			" '"+PT_UB_CONSTRUCTIONEnt.getINS_DT()+"'," +
	    			" '"+PT_UB_CONSTRUCTIONEnt.getWRT_ID()+"'," +
	    			" '"+PT_UB_CONSTRUCTIONEnt.getSW_BEF_REPO_DELINUM()+"'," +
	    			" '"+PT_UB_CONSTRUCTIONEnt.getPROC_STE()+"'," +
	    			" '"+PT_UB_CONSTRUCTIONEnt.getREPO_DT()+"')";
	    	     
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
	    	
			PT_UB_CONSTRUCTIONEnt.setDsOnlyString(ds, arg_row);// 
			PT_UB_CONSTRUCTIONEnt.setUPD_DT(KJFDate.getCurDatetime());
	    	KJFLog.debug(PT_UB_CONSTRUCTIONEnt.toString()); 		    	
	    	PT_UB_CONSTRUCTIONdao.update(PT_UB_CONSTRUCTIONEnt);
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
			
			sQuery.append(" DELETE FROM PT_UB_CONSTRUCTION ");
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
