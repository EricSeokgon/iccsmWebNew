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
import sp.dao.PT_R_CLOSE_STATEMENTDAO;
import sp.dao.PT_R_CLOSE_STATEMENTEntity;
import sp.dao.PT_R_COMPANY_MASTERDAO;
import sp.dao.PT_R_COMPANY_MASTEREntity;
import sp.dao.PT_R_DEFICITDAO;
import sp.dao.PT_R_DEFICITEntity;
import sp.dao.PT_R_ENGINEER_CHANGEDAO;
import sp.dao.PT_R_ENGINEER_CHANGEEntity;
import sp.dao.PT_R_MEMODAO;
import sp.dao.PT_R_MEMOEntity;
import sp.dao.PT_R_REFFERDAO;
import sp.dao.PT_R_REFFEREntity;
import sp.dao.PT_TMP_TRANS_KEYDAO;
import sp.dao.PT_TMP_TRANS_KEYEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.PlatformData;
import com.tobesoft.platform.data.VariableList;

public class CloseReceiptMgrCCUDCmd implements KJFCommand {
	
	private String next;
	private String scSIDO;
	
    private PT_R_CLOSE_STATEMENTDAO    PT_R_CLOSE_STATEMENTdao = new PT_R_CLOSE_STATEMENTDAO();
    private PT_R_CLOSE_STATEMENTEntity PT_R_CLOSE_STATEMENTEnt = new PT_R_CLOSE_STATEMENTEntity();
    
    private PT_R_MEMODAO    PT_R_MEMOdao = new PT_R_MEMODAO();
    private PT_R_MEMOEntity PT_R_MEMOEnt = new PT_R_MEMOEntity();
    
    private PT_R_COMPANY_MASTERDAO    PT_R_COMPANY_MASTERdao = new PT_R_COMPANY_MASTERDAO();
    private PT_R_COMPANY_MASTEREntity PT_R_COMPANY_MASTEREnt = new PT_R_COMPANY_MASTEREntity();
    
    private PT_R_DEFICITDAO    PT_R_DEFICITdao = new PT_R_DEFICITDAO();
    private PT_R_DEFICITEntity PT_R_DEFICITEnt = new PT_R_DEFICITEntity();
    
    private PT_R_BASIC_CHANGE_HISTORYDAO    PT_R_BASIC_CHANGE_HISTORYdao = new PT_R_BASIC_CHANGE_HISTORYDAO();
    private PT_R_BASIC_CHANGE_HISTORYEntity PT_R_BASIC_CHANGE_HISTORYEnt = new PT_R_BASIC_CHANGE_HISTORYEntity();
    
    private PT_R_REFFERDAO    PT_R_REFFERdao = new PT_R_REFFERDAO();
    private PT_R_REFFEREntity PT_R_REFFEREnt = new PT_R_REFFEREntity();
    
    private PT_R_ENGINEER_CHANGEDAO    PT_R_ENGINEER_CHANGEdao = new PT_R_ENGINEER_CHANGEDAO();
    private PT_R_ENGINEER_CHANGEEntity PT_R_ENGINEER_CHANGEEnt = new PT_R_ENGINEER_CHANGEEntity();
    
    private PT_TMP_TRANS_KEYDAO    PT_TMP_TRANS_KEYdao = new PT_TMP_TRANS_KEYDAO();
    private PT_TMP_TRANS_KEYEntity PT_TMP_TRANS_KEYEent = new PT_TMP_TRANS_KEYEntity();    

    private VariableList vl = new VariableList();
    
    public CloseReceiptMgrCCUDCmd() {
    }


    public CloseReceiptMgrCCUDCmd(String next_url) {
    	next = next_url;
    }

    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API 초기화 ******/ 
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	//PlatformData pd = new PlatformData(vl, pReq.getDatasetList());
    	//System.out.println("========= pd ============" + pd.toXml());
    	
    	
    	String scMODE = vl.getValueAsString("workMODE");
    	String scMOT_STE = vl.getValueAsString("MOT_STE");
    	//System.out.println("--초기1--------------------"+scMODE);
    	//System.out.println("--초기2--------------------"+scMOT_STE);
    	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds;
    	
    	if (scMODE.equalsIgnoreCase("ALL"))
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_DEFICIT");
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_CLOSE_STATEMENT");
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_BASIC_CHANGE_HISTORY");
    		System.out.println("---초기 입력 히스토리----------------"+ds);
    		if(ds != null) dsProc(ds);    		
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_COMPANY_MASTER");
    		    		//System.out.println("--초기--마스터POST------------------"+ds);
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_TMP_TRANS_KEY");
    		if(ds != null) dsProc(ds);
    	}
    	else
    	{
    		
	    	if (scMODE.equalsIgnoreCase("MEMO"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_MEMO");
	    		if(ds != null) dsProc(ds);
	    	}
		    	else
	    	{
		    	System.out.println("--초기--폐업------------------"+scMODE);
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_CLOSE_STATEMENT");
	    		if(ds != null) dsProc(ds);
	    		//System.out.println("--초기--폐업------------------"+ds);
	    	}
	    	if ( scMOT_STE.equalsIgnoreCase("STD003") )
	    	{
	    		System.out.println("--초기--트랜스------------------"+scMODE);
	    		ds = pReq.getDatasetList().getDataset("dsPT_TMP_TRANS_KEY");
	    		if(ds != null) dsProc(ds);
		    }	    	    	  	    	
	    	//dsProc(ds);
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
    	String scMOT_STE = vl.getValueAsString("MOT_STE");
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		PT_R_MEMOEnt.setDsOnlyString(ds, arg_row);// 
        	KJFLog.debug(PT_R_MEMOEnt.toString());
        	PT_R_MEMOdao.insert(PT_R_MEMOEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    		System.out.println("---입력 히스토리1111----------------");
    		PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);// 
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString());
        	PT_R_BASIC_CHANGE_HISTORYEnt.setCHGBRE_SEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_BASIC_CHANGE_HISTORY"));
        	PT_R_BASIC_CHANGE_HISTORYdao.insert(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		System.out.println("----------------------"+ds.getColumn(arg_row, "SEQ"));
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_DEFICITEnt.toString());
    		PT_R_DEFICITEnt.setINS_DT(KJFDate.getCurDatetime());    		
    		PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
    	}    	
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_CLOSE_STATEMENT"))
    	{
    		System.out.println("--입력-폐업-------------------"+scMOT_STE);
        	PT_R_CLOSE_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
        	PT_R_CLOSE_STATEMENTEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_CLOSE_STATEMENTEnt.toString()); 		    	
        	PT_R_CLOSE_STATEMENTdao.insert(PT_R_CLOSE_STATEMENTEnt);
    	}
    	else if (ds.getId().equalsIgnoreCase("dsPT_TMP_TRANS_KEY"))
    	{
    		System.out.println("---트렌스-------------------"+scMOT_STE);
    		PT_TMP_TRANS_KEYEent.setDsOnlyString(ds, arg_row);//
    		PT_TMP_TRANS_KEYEent.setSEQ(getMaxSeq("PT_TMP_TRANS_KEY"));
    		PT_TMP_TRANS_KEYEent.setINS_DT(KJFDate.getCurDatetime()); 
    		PT_TMP_TRANS_KEYdao.insert(PT_TMP_TRANS_KEYEent);
    	}
     }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	String scMOT_STE = vl.getValueAsString("MOT_STE");
    	

    	/******특정한 필드를 제외한 수정 ******/
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		PT_R_MEMOEnt.setDsOnlyString(ds, arg_row);
        	PT_R_MEMOdao.update(PT_R_MEMOEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    		System.out.println("---수정 히스토리2222----------------");
    		PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);// 
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString());
        	PT_R_BASIC_CHANGE_HISTORYEnt.setCHGBRE_SEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_BASIC_CHANGE_HISTORY"));
        	PT_R_BASIC_CHANGE_HISTORYdao.insert(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    		System.out.println("---트렌스4444----------------");
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);
    		PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);	
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String[] fields = {"DEFICIT_CONTENT"};
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_DEFICITdao.updateExcludeOnly(PT_R_DEFICITEnt, fields);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFFER"))
    	{
    		String[] fields = {"RET_DT"};
    		//PT_R_REFFEREnt.setDsOnlyString(ds, arg_row);
    		PT_R_REFFERdao.updateModifiedOnly(PT_R_REFFEREnt, fields);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		String[] fields = {"RET_YMD"};
    		//PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);
    		PT_R_ENGINEER_CHANGEdao.updateModifiedOnly(PT_R_ENGINEER_CHANGEEnt, fields);
    	}
    	else if (ds.getId().equalsIgnoreCase("dsPT_R_CLOSE_STATEMENT"))
    	{
    		System.out.println("--수정--폐업------------------"+scMOT_STE);
    		PT_R_CLOSE_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_CLOSE_STATEMENTEnt.setUPD_DT(KJFDate.getCurDatetime());
    		PT_R_CLOSE_STATEMENTdao.update(PT_R_CLOSE_STATEMENTEnt);
    	}/*
    	else if (ds.getId().equalsIgnoreCase("dsPT_TMP_TRANS_KEY"))
    	{
    		System.out.println("----------------------"+ds.getColumn(arg_row, "scMOT_STE"));
    		PT_TMP_TRANS_KEYEent.setDsOnlyString(ds, arg_row);//
    		PT_TMP_TRANS_KEYEent.setSEQ(getMaxSeq("PT_TMP_TRANS_KEY"));
    		PT_TMP_TRANS_KEYEent.setINS_DT(KJFDate.getCurDatetime()); 
    		PT_TMP_TRANS_KEYdao.insert(PT_TMP_TRANS_KEYEent);
    	}
    	*/
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
    	
    	String sKey = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    	String sKey2 = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
    	
    	String deleteQuery;
    	
    	ReportDAO rDAO;
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_MEMO"))
    	{
    		String sSEQ = ds.getDeleteColumn(arg_row,"MEMO_SEQ").getString();
    		deleteQuery = " DELETE FROM PT_R_MEMO WHERE RECV_NUM = '" + sKey + "'" + " AND MEMO_SEQ = '" + sSEQ + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else
    	{
    		deleteQuery = " DELETE FROM PT_R_DEFICIT WHERE RECV_NUM = '" + sKey + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sKey2 + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
    		deleteQuery = " DELETE FROM PT_R_MEMO WHERE RECV_NUM = '" + sKey + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sKey2 + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);

        	deleteQuery = " DELETE FROM PT_R_CLOSE_STATEMENT WHERE RECV_NUM = '" + sKey + "'";
        	deleteQuery += " AND SIDO_CODE = '" + sKey2 + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    	}    	
    }
        private String getMaxChangeSeq(String sKEY, String sTABLE) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(CHGBRE_SEQ)), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
        private String getMaxSeq(String sTABLE) throws Exception {
        	
            ReportDAO rDAO = new ReportDAO();

            String sQuery = " SELECT NVL(MAX(to_number(SEQ)), 0) + 1 MAX_ID ";
            sQuery += " FROM " + sTABLE + " ";
            
            ReportEntity rEntity     = null;
            
            rEntity = rDAO.select(sQuery);

            return rEntity.getValue(0,"MAX_ID");
        }
}
