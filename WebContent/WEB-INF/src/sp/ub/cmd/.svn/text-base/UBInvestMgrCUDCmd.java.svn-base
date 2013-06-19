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
import kjf.util.KJFFile;
import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_UB_MEMODAO;
import sp.dao.PT_UB_MEMOEntity;
import sp.dao.PT_UB_USEBEFOREDAO;
import sp.dao.PT_UB_USEBEFOREEntity;
import sp.dao.PT_UB_DETAILDAO;
import sp.dao.PT_UB_DETAILEntity;
import sp.dao.PT_UB_FILEDAO;
import sp.dao.PT_UB_FILEEntity;

import sp.dao.PT_UB_EQUIPMENTDAO;
import sp.dao.PT_UB_EQUIPMENTEntity;

import sp.util.sms.*;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;



public class UBInvestMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_UB_USEBEFOREDAO    dao = new PT_UB_USEBEFOREDAO();
    private PT_UB_USEBEFOREEntity Eent = new PT_UB_USEBEFOREEntity();
    
    private PT_UB_DETAILDAO    DETAILdao = new PT_UB_DETAILDAO();
    private PT_UB_DETAILEntity DETAILEent = new PT_UB_DETAILEntity();
    
    private PT_UB_MEMODAO    MEMOdao = new PT_UB_MEMODAO();
    private PT_UB_MEMOEntity MEMOEent = new PT_UB_MEMOEntity();

    private PT_UB_FILEDAO FileDao = new PT_UB_FILEDAO();
    private PT_UB_FILEEntity FileEent = new PT_UB_FILEEntity();
    
    private PT_UB_EQUIPMENTDAO EquipDao = new PT_UB_EQUIPMENTDAO();
    private PT_UB_EQUIPMENTEntity EquipEent = new PT_UB_EQUIPMENTEntity();
    
    private VariableList vl = new VariableList();
    private static DatasetList  dl = new DatasetList();
    private int smsre = 2;
    
    public UBInvestMgrCUDCmd() {
    }


    public UBInvestMgrCUDCmd(String next_url) {
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
    
    	if(scMODE.equalsIgnoreCase("ALL"))
    	{
	    	ds = pReq.getDatasetList().getDataset("ds_PT_UB_USEBEFORE");
	    	if(ds != null) dsProc(ds);
			dsde = pReq.getDatasetList().getDataset("ds_DETAIL_1");
			if(dsde != null) dsProcDe(dsde);
			dsde = pReq.getDatasetList().getDataset("ds_DETAIL_2");
			if(dsde != null) dsProcDe(dsde);
			dsde = pReq.getDatasetList().getDataset("ds_DETAIL_3");
			if(dsde != null) dsProcDe(dsde);
			ds = pReq.getDatasetList().getDataset("ds_PT_UB_FILE");
	    	if(ds != null) dsProc(ds);
			ds = pReq.getDatasetList().getDataset("ds_PT_UB_EQUIPMENT");
	    	if(ds != null) dsProc(ds);
    	}
    	else if (scMODE.equalsIgnoreCase("MEMO"))
    	{
	    	ds = pReq.getDatasetList().getDataset("dsPT_UB_MEMO");
	    	if(ds != null) dsProc(ds);
    	}
    	else if (scMODE.equalsIgnoreCase("FILE"))
    	{
    		ds = pReq.getDatasetList().getDataset("ds_PT_UB_FILE");
	    	if(ds != null) dsProc(ds);
    	}
    	
    	 Dataset ds2 = new Dataset("output");
 		
    	 ds2.addColumn("SMS",ColumnInfo.CY_COLINFO_STRING, 20);
 		
 		int row = ds2.appendRow();
 		ds2.setColumn(row, "SMS", smsre);

 		/********* 생성된 Dataset을 DatasetList에 추가 ************/
 		dl.addDataset(ds2);
 		
        request.setAttribute("dl", dl);  
        
        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception{
    	/******** Dataset을 INSERT, UPDATE처리 ********/
    	//System.out.println("ds.getRowCount() : "+ds.getRowCount());
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
	
			String RECV_NUM = DOC_NUM(SIDO_CODE,SIGUNGU_CODE);
    	
    		/****** Dataset one_row 값 전체 자동 세팅 ******/
    		Eent.setDsOnlyString(ds, arg_row);//  
	    	/****** 이후 변경되는 값들 세팅 ******/
	        String CIV_RECV_NUM  = KJFMi.dsGet(ds,arg_row,"CIV_RECV_NUM");
	    	/******세팅 값들 콘솔창에서 확인 ******/
	    	KJFLog.debug(Eent.toString()); 		
	    	Eent.setRECV_NUM(SIDO_CODE+RECV_NUM);
	    	Eent.setCIV_RECV_NUM(CIV_RECV_NUM);
	    	Eent.setSIDO_CODE(SIDO_CODE);
	    	Eent.setSIGUNGU_CODE(SIGUNGU_CODE);
	    	Eent.setWRT_ID(WRT_ID);
	    	Eent.setINS_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
	    	/******저장 ******/
	    	dao.insert(Eent);
    	}else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{    		
    		MEMOEent.setDsOnlyString(ds, arg_row);// 
           	KJFLog.debug(MEMOEent.toString());
           	MEMOEent.setINS_DT(KJFDate.getCurDatetime());
           	MEMOdao.insert(MEMOEent);
    	}
    	else if(ds.getId().equalsIgnoreCase("ds_PT_UB_FILE"))
    	{
    		String RECV_NUM = vl.getValueAsString("scRECV_NUM");
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			String WRT_ID = vl.getValueAsString("WRT_ID");
			String SEQ = KJFDBUtil.getMaxID("SEQ","PT_UB_FILE");
    		
    		FileEent.setDsOnlyString(ds, arg_row);
           	KJFLog.debug(MEMOEent.toString());
           	FileEent.setSEQ(SEQ);
           	FileEent.setRECV_NUM(RECV_NUM);
           	FileEent.setINS_DT(KJFDate.getCurDatetime());
           	FileEent.setSIDO_CODE(SIDO_CODE);
           	FileEent.setSIGUNGU_CODE(SIGUNGU_CODE);
           	FileEent.setWRT_ID(WRT_ID);
           	FileDao.insert(FileEent);
    	}
    	else if(ds.getId().equalsIgnoreCase("ds_PT_UB_EQUIPMENT"))
    	{    		
    		EquipEent.setDsOnlyString(ds, arg_row); 
           	KJFLog.debug(EquipEent.toString());
           	EquipEent.setINS_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
           	EquipDao.insert(EquipEent);
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
	    	String SRL = KJFDBUtil.getMaxID2("SRL","PT_UB_DETAIL",2);
    		
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
    	
    	if(ds.getId().equalsIgnoreCase("ds_PT_UB_USEBEFORE"))
    	{
    		
    		/****** Dataset one_row 값 전체 자동 세팅 ******/
	    	Eent.setDsOnlyString(ds, arg_row);//     	
	    	String[] fields={"RECV_NUM", "SIDO_CODE", "SIGUNGU_CODE", "INS_DT" };   	
	    	/******특정한 필드를 제외한 수정 ******/
	    	dao.updateExcludeOnly(Eent, fields); 
	    	
	    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String WRT_ID = vl.getValueAsString("WRT_ID");
			
//			if("3".equals(Eent.getPROC_STE())){
//				if("1".equals(Eent.getCER_DELI_YN()) && !KJFUtil.isEmpty(Eent.getUSEBEFINSP_DELINUM())){
//					if("bsbs".equals(SIDO_CODE)){
//						if(!KJFUtil.isEmpty(Eent.getAPPLPER_TELNUM()) && ("01".equals(Eent.getAPPLPER_TELNUM().substring(0,2)))){
//							smsre = sandSMS(WRT_ID,Eent.getAPPLPER_TELNUM());
//						}
//					}
//				}
//			}
			
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{
    		MEMOEent.setDsOnlyString(ds, arg_row);//     	
    		String[] fields2={"RECV_NUM", "SIDO_CODE", "SIGUNGU_CODE", "SEQ" };   	
    		MEMOdao.updateExcludeOnly(MEMOEent, fields2);
    	}
    	else if(ds.getId().equalsIgnoreCase("ds_PT_UB_FILE"))
    	{	
    		FileEent.setDsOnlyString(ds, arg_row);// 
    		String[] fields2={"RECV_NUM", "SIDO_CODE", "SIGUNGU_CODE", "SEQ" };   	
    		FileDao.updateExcludeOnly(FileEent, fields2);
    	}
    	else if(ds.getId().equalsIgnoreCase("ds_PT_UB_EQUIPMENT"))
        {	
    			EquipEent.setDsOnlyString(ds, arg_row);// 
    			EquipEent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));
        		String[] fields2={"RECV_NUM,SIDO_CODE,SIGUNGU_CODE,CIV_RECV_NUM,INS_DT"};   	
        		EquipDao.updateExcludeOnly(EquipEent, fields2);
        }

    }
    
    private int sandSMS(String WRT_ID, String TELNUM)throws Exception{
    	
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
    	String SQL = "SELECT SIDO_CODE, SIGUNGU_CODE, TEL  FROM PT_MI_USER WHERE OFFI_ID = '"+WRT_ID+"' ";
    	
    	rEntity = rDAO.select(SQL);
    	
    	String SIDO_CODE = rEntity.getValue(0,"SIDO_CODE");
    	String SIGUNGU_CODE = rEntity.getValue(0,"SIGUNGU_CODE");
    	String TEL = rEntity.getValue(0,"TEL");
    	
    	SmsMd sm= new SmsMd();
    	int result= sm.SendMsg(WRT_ID,SIDO_CODE,SIGUNGU_CODE,TEL,TELNUM,"사용전 검사 필증 발급이 완료 되었습니다.");
    	
    	return result;
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
    	
    	if(ds.getId().equalsIgnoreCase("ds_PT_UB_USEBEFORE"))
    	{
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
			ReportDAO    rDAO        = new ReportDAO();
	    	Eent.setRECV_NUM(SIDO_CODE+RECV_NUM);
	    	Eent.setSIDO_CODE(SIDO_CODE);
	    	Eent.setSIGUNGU_CODE(SIGUNGU_CODE);
	    	String DELETE = " DELETE FROM PT_UB_DETAIL  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND RECV_NUM = '"+RECV_NUM+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
	    	rDAO.execute(DELETE);
	    	dao.delete(Eent);
	    	DELETE = " DELETE FROM PT_UB_MEMO  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND RECV_NUM = '"+RECV_NUM+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
	    	rDAO.execute(DELETE);
	    	DELETE = " DELETE FROM PT_UB_DETAIL  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND RECV_NUM = '"+RECV_NUM+"' ";
	    	rDAO.execute(DELETE);
	    	DELETE = " DELETE FROM PT_UB_FILE  WHERE SIDO_CODE = '"+SIDO_CODE+"' AND RECV_NUM = '"+RECV_NUM+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
	    	rDAO.execute(DELETE);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_UB_MEMO"))
    	{
    		String SIDO_CODE = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
			String SIGUNGU_CODE = ds.getDeleteColumn(arg_row,"SIGUNGU_CODE").getString();
			String SEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
			String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
			
    		deleteQuery = " DELETE FROM PT_UB_MEMO WHERE RECV_NUM = '" + RECV_NUM + "'";
    		deleteQuery += " AND SIDO_CODE = '" + SIDO_CODE + "' AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "' AND SEQ = '" + SEQ + "'";
    		ReportDAO rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    	}   
    	else if(ds.getId().equalsIgnoreCase("ds_PT_UB_EQUIPMENT"))
    	{
    		String SIDO_CODE = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
			String SIGUNGU_CODE = ds.getDeleteColumn(arg_row,"SIGUNGU_CODE").getString();
			String SEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
			String RECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
			
    		deleteQuery = " DELETE FROM PT_UB_EQUIPMENT WHERE RECV_NUM = '" + RECV_NUM + "'";
    		deleteQuery += " AND SIDO_CODE = '" + SIDO_CODE + "' AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "' AND SEQ = '" + SEQ + "'";
    		ReportDAO rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    	}   
    	else if(ds.getId().equalsIgnoreCase("ds_PT_UB_FILE"))
    	{
    		String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
			String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
			
			String SEQ = KJFUtil.print(ds.getDeleteColumn(arg_row,"SEQ").getString(),"");	
			String RECV_NUM = KJFUtil.print(ds.getDeleteColumn(arg_row,"RECV_NUM").getString(),"");
			String FILE_NM = KJFUtil.print(ds.getDeleteColumn(arg_row,"FILE_NM").getString(),"");

			
			//String SEQ = ds.getColumn(arg_row, "SEQ").toString();
			//String RECV_NUM =  ds.getColumn(arg_row, "RECV_NUM").getString();
			
			//System.out.println(ds.getId()+"###"+(arg_row, "SEQ")+"##"+ds);			
    		deleteQuery = " DELETE FROM PT_UB_FILE WHERE RECV_NUM = '" + RECV_NUM + "'";
    		deleteQuery += " AND SIDO_CODE = '" + SIDO_CODE + "' AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "' AND SEQ = '" + SEQ + "'";
    		ReportDAO rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	String dirs = "/data/webroot/attache/ICCSM/usebefore/"+SIDO_CODE+"/"+SIGUNGU_CODE+"/";
        	KJFFile.deleteFile( dirs+ KJFFile.FILE_S, FILE_NM); // dir에서 파일을 삭제한다.
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
    				"SELECT COUNT(*) AS CNT FROM PT_UB_DETAIL  \n" +
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
        sWhere.append(" WHERE DOC_CLASS = 'BeforeMgrCUD'  ");
        sWhere.append("   AND SD_CODE = '"+SD_CODE+"'  ");
         
         if(!KJFUtil.isEmpty(SGG_CODE)){
        	 sWhere.append("   AND SGG_CODE = '"+SGG_CODE+"'  ");
         }
         
         rEntity    = rDAO.select(sSelect.toString() + sFrom.toString() + sWhere.toString());    
         
         if(rEntity.getRowCnt() > 0){
        	 DOC_NUM = rEntity.getValue(0,"DOC_NUM");
        	 sDAO.execute("UPDATE PT_R_DOC_NUM SET = '"+DOC_NUM+"' "+sWhere.toString());
         }else{
        	 DOC_NUM = "100";
        	 String insert = " insert into PT_R_DOC_NUM (DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2) values " +
        	 				 "('BeforeMgrCUD','"+SD_CODE+"','"+SGG_CODE+"','"+SD_CODE+"','100')";
        	 sDAO.execute(insert);
         }
         
         return DOC_NUM;
    }

}