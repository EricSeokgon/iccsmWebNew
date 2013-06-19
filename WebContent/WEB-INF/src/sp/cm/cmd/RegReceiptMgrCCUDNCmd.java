/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import org.apache.struts.action.ActionForm;

import sp.dao.PT_R_BASIC_CHANGE_HISTORYDAO;
import sp.dao.PT_R_BASIC_CHANGE_HISTORYEntity;
import sp.dao.PT_R_MOT_STEDAO;
import sp.dao.PT_R_MOT_STEEntity;
import sp.dao.PT_R_REGIST_STATEMENTDAO;
import sp.dao.PT_R_REGIST_STATEMENTEntity;
import sp.dao.PT_R_SUBSIDIARY_COMPANYDAO;
import sp.dao.PT_R_SUBSIDIARY_COMPANYEntity;

import sp.dao.PT_R_MEMODAO;
import sp.dao.PT_R_MEMOEntity;

import sp.dao.PT_R_DEFICITDAO;
import sp.dao.PT_R_DEFICITEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class RegReceiptMgrCCUDNCmd implements KJFCommand {
	
    private String next;
    private PT_R_REGIST_STATEMENTDAO    PT_R_REGIST_STATEMENTdao = new PT_R_REGIST_STATEMENTDAO();
    private PT_R_REGIST_STATEMENTEntity PT_R_REGIST_STATEMENTEnt = new PT_R_REGIST_STATEMENTEntity();
    
    private PT_R_MEMODAO    PT_R_MEMOdao = new PT_R_MEMODAO();
    private PT_R_MEMOEntity PT_R_MEMOEnt = new PT_R_MEMOEntity();
    
    private PT_R_DEFICITDAO    PT_R_DEFICITdao = new PT_R_DEFICITDAO();
    private PT_R_DEFICITEntity PT_R_DEFICITEnt = new PT_R_DEFICITEntity();
    
    private PT_R_SUBSIDIARY_COMPANYDAO    PT_R_SUBSIDIARY_COMPANYdao = new PT_R_SUBSIDIARY_COMPANYDAO();
    private PT_R_SUBSIDIARY_COMPANYEntity PT_R_SUBSIDIARY_COMPANYEnt = new PT_R_SUBSIDIARY_COMPANYEntity();

    private PT_R_MOT_STEDAO PT_R_MOT_STEdao = new PT_R_MOT_STEDAO();
    private PT_R_MOT_STEEntity PT_R_MOT_STEEnt = new PT_R_MOT_STEEntity();
    
    private PT_R_BASIC_CHANGE_HISTORYDAO    PT_R_BASIC_CHANGE_HISTORYdao = new PT_R_BASIC_CHANGE_HISTORYDAO();
    private PT_R_BASIC_CHANGE_HISTORYEntity PT_R_BASIC_CHANGE_HISTORYEnt = new PT_R_BASIC_CHANGE_HISTORYEntity();
    
    
    private VariableList vl = new VariableList();
    
    public RegReceiptMgrCCUDNCmd() {
    }


    public RegReceiptMgrCCUDNCmd(String next_url) {
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
    	
    	if (scMODE.equalsIgnoreCase("ALL"))
    	{
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null)
    			dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_MOT_STE");
    		if (ds != null) 
    			dsProc(ds);
    		//dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REGIST_STATEMENT");
    		dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_BASIC_CHANGE_HISTORY");
    		if (ds != null)dsProc(ds);
    	
    	}
    	if(scMODE.equalsIgnoreCase("LICTAX")){
    		String scLICTAX = vl.getValueAsString("scLICTAX");
    		String scHOSCRE = vl.getValueAsString("scHOSCRE");
    		String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
    		String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REGIST_STATEMENT");
    		if (ds != null)
    		{
    			ReportDAO    rDAO;
            	String deleteQuery = " UPDATE PT_R_REGIST_STATEMENT " +
            			" SET LICTAX ='"+scLICTAX+"', HOSCRE = '"+scHOSCRE+"' " +
            			" WHERE TMP_WRT_NUM  ='"+scTMP_WRT_NUM+"' AND  RECV_NUM  ='"+scRECV_NUM+"' ";
            	rDAO = new ReportDAO();
            	rDAO.execute(deleteQuery);

    			//dsProc(ds);
    		}
    	}    	
    	else
    	{
	    	if (scMODE.equalsIgnoreCase("MEMO"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_MEMO");
	    	}
	    	else if (scMODE.equalsIgnoreCase("COMPANY"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_SUBSIDIARY_COMPANY");
	    	}
	    	else
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_REGIST_STATEMENT");
	    	}
	  	    	
	    	dsProc(ds);
    	}
        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception
    {
    	if(ds == null){ 
    		System.out.println(" ds 값이 없습니다");
    	}else{
	    	for(int i=0;i<ds.getRowCount();i++){
	    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);
	    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
	    	}
	
	    	/****** Dataset을 DELETE처리 ****/
	    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
	    		deleteExe(ds,i);
	    	}
    	}
    }

    /**
     * 입력
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		PT_R_MEMOEnt.setDsOnlyString(ds, arg_row);// 
        	KJFLog.debug(PT_R_MEMOEnt.toString()); 		    	
        	PT_R_MEMOdao.insert(PT_R_MEMOEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY_COMPANY"))
    	{
    		PT_R_SUBSIDIARY_COMPANYEnt.setDsOnlyString(ds, arg_row);// 
        	KJFLog.debug(PT_R_SUBSIDIARY_COMPANYEnt.toString()); 		    	
        	PT_R_SUBSIDIARY_COMPANYdao.insert(PT_R_SUBSIDIARY_COMPANYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		System.out.println("----------------------"+ds.getColumn(arg_row, "SEQ"));
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_DEFICITEnt.toString());
    		PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_MOT_STE"))
    	{
    		PT_R_MOT_STEEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_MOT_STEEnt.toString());
    		PT_R_MOT_STEdao.insert(PT_R_MOT_STEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    		
    		 PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
     	    PT_R_BASIC_CHANGE_HISTORYEnt.setCHGBRE_SEQ(
     	    		getMaxChangeSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_BASIC_CHANGE_HISTORY", "CHGBRE_SEQ"));
     	    PT_R_BASIC_CHANGE_HISTORYEnt.setINS_DT(KJFDate.getCurDatetime());
         	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
         	PT_R_BASIC_CHANGE_HISTORYdao.insert(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else
    	{
        	PT_R_REGIST_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
        	//PT_R_REGIST_STATEMENTEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REGIST_STATEMENTEnt.toString()); 		    	
        	PT_R_REGIST_STATEMENTdao.insert(PT_R_REGIST_STATEMENTEnt);
        	
        	/*PT_R_MOT_STEEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_MOT_STEEnt.toString());
    		PT_R_MOT_STEdao.insert(PT_R_MOT_STEEnt);*/
    	}
    	
    	
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	    	
    	

    	/******특정한 필드를 제외한 수정 ******/
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		PT_R_MEMOEnt.setDsOnlyString(ds, arg_row);
        	PT_R_MEMOdao.update(PT_R_MEMOEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY_COMPANY"))
    	{
    		PT_R_SUBSIDIARY_COMPANYEnt.setDsOnlyString(ds, arg_row);
        	PT_R_SUBSIDIARY_COMPANYdao.update(PT_R_SUBSIDIARY_COMPANYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String[] fields = {"DEFICIT_CONTENT"};
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_DEFICITdao.update(PT_R_DEFICITEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_MOT_STE"))
    	{
    		PT_R_MOT_STEEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_MOT_STEEnt.toString());
    		PT_R_MOT_STEdao.update(PT_R_MOT_STEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.update(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else
    	{
    		PT_R_REGIST_STATEMENTEnt.setDsOnlyString(ds, arg_row);//
    		//PT_R_REGIST_STATEMENTEnt.setUPD_DT(KJFDate.getCurDatetime());
    		KJFLog.debug(PT_R_REGIST_STATEMENTEnt.toString()); 
    		PT_R_REGIST_STATEMENTdao.update(PT_R_REGIST_STATEMENTEnt);
    		
    		/*PT_R_MOT_STEEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_MOT_STEEnt.toString());
    		PT_R_MOT_STEdao.update(PT_R_MOT_STEEnt);*/
    	}
    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String sKey = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    	
    	String deleteQuery;
    	
    	ReportDAO rDAO;
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		String sSEQ = ds.getDeleteColumn(arg_row,"MEMO_SEQ").getString();
    		String sSIDO_CODE = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
    		
    		deleteQuery = " DELETE FROM PT_R_MEMO WHERE RECV_NUM = '" + sKey + "'" + " AND MEMO_SEQ = '" + sSEQ + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sSIDO_CODE + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY_COMPANY"))
    	{
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		String sSIDO_CODE = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
    		
    		deleteQuery = " DELETE FROM PT_R_SUBSIDIARY_COMPANY WHERE RECV_NUM = '" + sKey + "'" + " AND SEQ = '" + sSEQ + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sSIDO_CODE + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else
    	{
    		String sSIDO_CODE = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
        	String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
        	System.out.println("KEY ============= " + scTMP_WRT_NUM);
    		
    		deleteQuery = " DELETE FROM PT_R_DEFICIT WHERE RECV_NUM = '" + sKey + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sSIDO_CODE + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
    		deleteQuery = " DELETE FROM PT_R_MEMO WHERE RECV_NUM = '" + sKey + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sSIDO_CODE + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_SUBSIDIARY_COMPANY WHERE RECV_NUM = '" + sKey + "'";
        	deleteQuery += " AND SIDO_CODE = '" + sSIDO_CODE + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_REGIST_STATEMENT WHERE RECV_NUM = '" + sKey + "'";
        	deleteQuery += " AND SIDO_CODE = '" + sSIDO_CODE + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_BASIC_CHANGE_HISTORY WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_MOT_STE WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    	}    	
    }
    
    private String getMaxChangeSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
}