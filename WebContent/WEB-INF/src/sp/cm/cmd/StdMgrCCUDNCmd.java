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

import sp.dao.PT_R_BASIC_STATEMENTDAO;
import sp.dao.PT_R_BASIC_STATEMENTEntity;
import sp.dao.PT_R_COMPANY_MASTERDAO;
import sp.dao.PT_R_COMPANY_MASTEREntity;
import sp.dao.PT_R_ENGINEER_CHANGE_TEMPDAO;
import sp.dao.PT_R_ENGINEER_CHANGE_TEMPEntity;
import sp.dao.PT_R_MOT_STEDAO;
import sp.dao.PT_R_MOT_STEEntity;

import sp.dao.PT_R_REFFERDAO;
import sp.dao.PT_R_REFFEREntity;

import sp.dao.PT_R_REG_MEMODAO;
import sp.dao.PT_R_REG_MEMOEntity;

import sp.dao.PT_R_BASIC_CHANGE_HISTORYDAO;
import sp.dao.PT_R_BASIC_CHANGE_HISTORYEntity;

import sp.dao.PT_R_ENGINEER_CHANGEDAO;
import sp.dao.PT_R_ENGINEER_CHANGEEntity;

import sp.dao.PT_R_ADDRESS_CHANGEDAO;
import sp.dao.PT_R_ADDRESS_CHANGEEntity;

import sp.dao.PT_R_COMPANY_DIAGNOSTICDAO;
import sp.dao.PT_R_COMPANY_DIAGNOSTICEntity;

import sp.dao.PT_R_REPRESENT_CHANGEDAO;
import sp.dao.PT_R_REPRESENT_CHANGEEntity;

import sp.dao.PT_R_COM_NAME_CHANGEDAO;
import sp.dao.PT_R_COM_NAME_CHANGEEntity;

import sp.dao.PT_R_REFUSAL_REASONDAO;
import sp.dao.PT_R_REFUSAL_REASONEntity;

import sp.dao.PT_R_SUBSIDIARYDAO;
import sp.dao.PT_R_SUBSIDIARYEntity;

import sp.dao.PT_R_COM_DEFICITDAO;
import sp.dao.PT_R_COM_DEFICITEntity;

import sp.dao.PT_R_MOT_STEDAO;
import sp.dao.PT_R_MOT_STEEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class StdMgrCCUDNCmd implements KJFCommand {
	
    private String next;

    private PT_R_COMPANY_MASTERDAO    PT_R_COMPANY_MASTERdao = new PT_R_COMPANY_MASTERDAO();
    private PT_R_COMPANY_MASTEREntity PT_R_COMPANY_MASTEREnt = new PT_R_COMPANY_MASTEREntity();
    
    private PT_R_REFFERDAO    PT_R_REFFERdao = new PT_R_REFFERDAO();
    private PT_R_REFFEREntity PT_R_REFFEREnt = new PT_R_REFFEREntity();
    
    private PT_R_REG_MEMODAO    PT_R_REG_MEMOdao = new PT_R_REG_MEMODAO();
    private PT_R_REG_MEMOEntity PT_R_REG_MEMOEnt = new PT_R_REG_MEMOEntity();

    private PT_R_BASIC_CHANGE_HISTORYDAO    PT_R_BASIC_CHANGE_HISTORYdao = new PT_R_BASIC_CHANGE_HISTORYDAO();
    private PT_R_BASIC_CHANGE_HISTORYEntity PT_R_BASIC_CHANGE_HISTORYEnt = new PT_R_BASIC_CHANGE_HISTORYEntity();
    
    private PT_R_ENGINEER_CHANGEDAO    PT_R_ENGINEER_CHANGEdao = new PT_R_ENGINEER_CHANGEDAO();
    private PT_R_ENGINEER_CHANGEEntity PT_R_ENGINEER_CHANGEEnt = new PT_R_ENGINEER_CHANGEEntity();
    
    private PT_R_ADDRESS_CHANGEDAO    PT_R_ADDRESS_CHANGEdao = new PT_R_ADDRESS_CHANGEDAO();
    private PT_R_ADDRESS_CHANGEEntity PT_R_ADDRESS_CHANGEEnt = new PT_R_ADDRESS_CHANGEEntity();
    
//    private PT_R_COMPANY_DIAGNOSTICDAO    PT_R_COMPANY_DIAGNOSTICdao = new PT_R_COMPANY_DIAGNOSTICDAO();
//    private PT_R_COMPANY_DIAGNOSTICEntity PT_R_COMPANY_DIAGNOSTICEnt = new PT_R_COMPANY_DIAGNOSTICEntity();
    
//    private PT_R_REPRESENT_CHANGEDAO    PT_R_REPRESENT_CHANGEdao = new PT_R_REPRESENT_CHANGEDAO();
//    private PT_R_REPRESENT_CHANGEEntity PT_R_REPRESENT_CHANGEEnt = new PT_R_REPRESENT_CHANGEEntity();
    
//    private PT_R_COM_NAME_CHANGEDAO    PT_R_COM_NAME_CHANGEdao = new PT_R_COM_NAME_CHANGEDAO();
//    private PT_R_COM_NAME_CHANGEEntity PT_R_COM_NAME_CHANGEEnt = new PT_R_COM_NAME_CHANGEEntity();
    
    private PT_R_REFUSAL_REASONDAO    PT_R_REFUSAL_REASONdao = new PT_R_REFUSAL_REASONDAO();
    private PT_R_REFUSAL_REASONEntity PT_R_REFUSAL_REASONEnt = new PT_R_REFUSAL_REASONEntity();
    
    private PT_R_SUBSIDIARYDAO    PT_R_SUBSIDIARYdao = new PT_R_SUBSIDIARYDAO();
    private PT_R_SUBSIDIARYEntity PT_R_SUBSIDIARYEnt = new PT_R_SUBSIDIARYEntity();
    
    private PT_R_COM_DEFICITDAO    PT_R_COM_DEFICITdao = new PT_R_COM_DEFICITDAO();
    private PT_R_COM_DEFICITEntity PT_R_COM_DEFICITEnt = new PT_R_COM_DEFICITEntity();
    
    private PT_R_MOT_STEDAO PT_R_MOT_STEdao = new PT_R_MOT_STEDAO();
    private PT_R_MOT_STEEntity PT_R_MOT_STEEnt = new PT_R_MOT_STEEntity();    
    
    private PT_R_ENGINEER_CHANGE_TEMPDAO    PT_R_ENGINEER_CHANGE_TEMPdao = new PT_R_ENGINEER_CHANGE_TEMPDAO();
    private PT_R_ENGINEER_CHANGE_TEMPEntity PT_R_ENGINEER_CHANGE_TEMPEnt = new PT_R_ENGINEER_CHANGE_TEMPEntity();

    private PT_R_BASIC_STATEMENTDAO    PT_R_BASIC_STATEMENTdao = new PT_R_BASIC_STATEMENTDAO();
    private PT_R_BASIC_STATEMENTEntity PT_R_BASIC_STATEMENTEnt = new PT_R_BASIC_STATEMENTEntity();
    
    
    private VariableList vl = new VariableList();
    
    public StdMgrCCUDNCmd() {
    }

    public StdMgrCCUDNCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	String scMODE = vl.getValueAsString("workMODE");
    	//scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
    	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds;
    	
    	if (scMODE.equalsIgnoreCase("ALL"))
    	{
    		ReportDAO rDAO;
    		StringBuilder sQuery = new StringBuilder();
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_COMPANY_MASTER");
    		if (ds != null)dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_BASIC_CHANGE_HISTORY");
    		if (ds != null)dsProc(ds);

    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE_TEMP");    		
    		if (ds != null) dsProc(ds);
    	
    		/*
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");   
    		
    		if (ds != null) {
    			sQuery.delete(0, sQuery.length());
        		for (int cnt=0; cnt < ds.getRowCount(); cnt++){
	        		sQuery.append(" DELETE FROM PT_R_ENGINEER_CHANGE ");
	        		sQuery.append(" WHERE TMP_WRT_NUM = '" + ds.getColumnAsString(cnt, "TMP_WRT_NUM") + "' ");
	        		sQuery.append(" AND RET_YMD IS NULL ");
	        		
	            	rDAO = new ReportDAO();
	            	rDAO.execute(sQuery.toString());
	    	       	sQuery.delete(0, sQuery.length());
        		}
            	dsProc(ds);
    		}
    	*/
    		    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFFER");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REG_MEMO");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFUSAL_REASON");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_SUBSIDIARY");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_COM_DEFICIT");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_MOT_STE");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_BASIC_STATEMENT");
    		if (ds != null) dsProc(ds);
    	}
    	else
    	{
	    	if (scMODE.equalsIgnoreCase("REPER"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFFER");
	    		dsProc(ds);
	    	}
	    	/*else if (scMODE.equalsIgnoreCase("ENGINEER"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");
	    		dsProc(ds);
	    	}*/
	    	else if (scMODE.equalsIgnoreCase("ENGINEER"))	// 보유기술자 
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");
	    		dsProc(ds);
	    		//ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");
	    		//if(ds != null) dsProc(ds);
	    	}
	    	else if (scMODE.equalsIgnoreCase("ENGINEER_TEMP"))	// 보유기술자 
	    	{
	    		//ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE_TEMP");
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE_TEMP");
	    		if(ds != null) dsProc(ds);
	    	}
	    	else if (scMODE.equalsIgnoreCase("MEMO"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_REG_MEMO");
	    		dsProc(ds);
	    	}
	    	else if (scMODE.equalsIgnoreCase("REFUSAL"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFUSAL_REASON");
	    		dsProc(ds);
	    	}
	    	else if (scMODE.equalsIgnoreCase("SUBSIDIARY"))
	    	{
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_SUBSIDIARY");
	    		dsProc(ds);
	    	}
    	}
        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception
    {
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

    	//if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	//{
    		//PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);//
    		//PT_R_COMPANY_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());
        	//KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	//PT_R_COMPANY_MASTERdao.insert(PT_R_COMPANY_MASTEREnt);
    	//}
    	//else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    
        	
        	// 2010-03-25 wbjeon
        	// 2010-04-23 아래는 왜 필요한지 모르겠지만 틀린것만 수정.
        	if ("".equals(PT_R_BASIC_CHANGE_HISTORYEnt.getCHGBRE_SEQ())){
        		PT_R_BASIC_CHANGE_HISTORYEnt.setTMP_WRT_NUM(PT_R_COMPANY_MASTEREnt.getTMP_WRT_NUM());
        		PT_R_BASIC_CHANGE_HISTORYEnt.setCHGBRE_SEQ("1");
        	}
        	PT_R_BASIC_CHANGE_HISTORYdao.insert(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFFER"))
    	{    		
    		PT_R_REFFEREnt.setDsOnlyString(ds, arg_row);//
    		PT_R_REFFEREnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REFFEREnt.toString()); 		    	
        	PT_R_REFFERdao.insert(PT_R_REFFEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY"))
    	{
    		PT_R_SUBSIDIARYEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_SUBSIDIARYEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_SUBSIDIARYEnt.toString()); 		    	
        	PT_R_SUBSIDIARYdao.insert(PT_R_SUBSIDIARYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFUSAL_REASON"))
    	{
    		PT_R_REFUSAL_REASONEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_REFUSAL_REASONEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REFUSAL_REASONEnt.toString()); 		    	
        	PT_R_REFUSAL_REASONdao.insert(PT_R_REFUSAL_REASONEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);//
    		PT_R_COMPANY_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		
    		
        	String temp = "1";
    		temp = getMaxSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_COMPANY_MASTER", "TMP_WRT_NUM");
    		if (temp.equals("1")){
    			PT_R_COMPANY_MASTERdao.insert(PT_R_COMPANY_MASTEREnt);
        	} else {
        		PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
        		if ("".equals(ds.getColumnAsString(0, "INS_DT"))){
        			PT_R_COMPANY_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());        			
        		}
        		PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);
        	} 
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REG_MEMO"))
    	{
    	    PT_R_REG_MEMOEnt.setDsOnlyString(ds, arg_row);// 
    	    PT_R_REG_MEMOEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REG_MEMOEnt.toString()); 		    	
        	PT_R_REG_MEMOdao.insert(PT_R_REG_MEMOEnt);
//    	}
//    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COM_NAME_CHANGE"))
//    	{
//    		PT_R_COM_NAME_CHANGEEnt.setDsOnlyString(ds, arg_row);//
//    		PT_R_COM_NAME_CHANGEEnt.setINS_DT(KJFDate.getCurDatetime());
//        	KJFLog.debug(PT_R_COM_NAME_CHANGEEnt.toString()); 		    	
//        	PT_R_COM_NAME_CHANGEdao.insert(PT_R_COM_NAME_CHANGEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE_TEMP"))
    	{	
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGEEnt.setINS_DT(KJFDate.getCurDatetime());    		
    		PT_R_ENGINEER_CHANGEEnt.setSEQ(
    				getMaxChangeEngSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_ENGINEER_CHANGE", "SEQ"));
    		
    		//PT_R_ENGINEER_CHANGE_TEMPEnt.setENG_PROC("S");
        	KJFLog.debug(PT_R_ENGINEER_CHANGE_TEMPEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGEdao.insert(PT_R_ENGINEER_CHANGEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGEEnt.setINS_DT(KJFDate.getCurDatetime());
    		PT_R_ENGINEER_CHANGEEnt.setSEQ(
    	    		getMaxSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_ENGINEER_CHANGE", "SEQ"));
        	KJFLog.debug(PT_R_ENGINEER_CHANGEEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGEdao.insert(PT_R_ENGINEER_CHANGEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ADDRESS_CHANGE"))
    	{
    		PT_R_ADDRESS_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ADDRESS_CHANGEEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ADDRESS_CHANGEEnt.toString()); 		    	
        	PT_R_ADDRESS_CHANGEdao.insert(PT_R_ADDRESS_CHANGEEnt);
//    	}
//    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_DIAGNOSTIC"))
//    	{
//    		PT_R_COMPANY_DIAGNOSTICEnt.setDsOnlyString(ds, arg_row);//
//    		KJFLog.debug(PT_R_COMPANY_DIAGNOSTICEnt.toString()); 		   
//        	PT_R_COMPANY_DIAGNOSTICEnt.setINS_DT(KJFDate.getCurDatetime());
//        	PT_R_COMPANY_DIAGNOSTICdao.insert(PT_R_COMPANY_DIAGNOSTICEnt);
//    	}
//    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REPRESENT_CHANGE"))
//    	{
//    		PT_R_REPRESENT_CHANGEEnt.setDsOnlyString(ds, arg_row);//
//    		PT_R_REPRESENT_CHANGEEnt.setINS_DT(KJFDate.getCurDatetime());
//        	KJFLog.debug(PT_R_REPRESENT_CHANGEEnt.toString()); 		    	
//        	PT_R_REPRESENT_CHANGEdao.insert(PT_R_REPRESENT_CHANGEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COM_DEFICIT"))
    	{
    		PT_R_COM_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_COM_DEFICITEnt.setINS_DT(KJFDate.getCurDatetime());
    		KJFLog.debug(PT_R_COM_DEFICITEnt.toString());
    		PT_R_COM_DEFICITdao.insert(PT_R_COM_DEFICITEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_MOT_STE"))
    	{
    		PT_R_MOT_STEEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_MOT_STEEnt.toString());
    		PT_R_MOT_STEdao.insert(PT_R_MOT_STEEnt);
    	}
    	else
    	{
    		PT_R_BASIC_STATEMENTEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_BASIC_STATEMENTEnt.setINS_DT(KJFDate.getCurDatetime());
    		KJFLog.debug(PT_R_BASIC_STATEMENTEnt.toString()); 		    	
        	PT_R_BASIC_STATEMENTdao.insert(PT_R_BASIC_STATEMENTEnt);
    	}
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    		String[] fields = {"NAME","MANA_NUM","COM_NUM","REP_NM_KOR","REP_NM_HAN","REP_SSN1","REP_SSN2","ADDR_TEL_NUM","ADDR_FAX_NUM","ADDR_POST_NUM","ADDR_ADDR","ADDR_DETAIL_ADDR","OFFICE_AREA","PAY_CAP","REA_CAP"};
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	//PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);
        	PT_R_COMPANY_MASTERdao.updateExcludeOnly(PT_R_COMPANY_MASTEREnt, fields);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    		//String[] fields = {"INS_DT"};
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.update(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFUSAL_REASON"))
    	{
    		PT_R_REFUSAL_REASONEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_REFUSAL_REASONEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REFUSAL_REASONEnt.toString()); 		    	
        	PT_R_REFUSAL_REASONdao.update(PT_R_REFUSAL_REASONEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFFER"))
    	{
    		PT_R_REFFEREnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_REFFEREnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REFFEREnt.toString()); 		    	
        	PT_R_REFFERdao.update(PT_R_REFFEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY"))
    	{
    		PT_R_SUBSIDIARYEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_SUBSIDIARYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_SUBSIDIARYEnt.toString()); 		    	
        	PT_R_SUBSIDIARYdao.update(PT_R_SUBSIDIARYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REG_MEMO"))
    	{
    	    PT_R_REG_MEMOEnt.setDsOnlyString(ds, arg_row);// 
    	    PT_R_REG_MEMOEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REG_MEMOEnt.toString()); 		    	
        	PT_R_REG_MEMOdao.update(PT_R_REG_MEMOEnt);
//    	}
//    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COM_NAME_CHANGE"))
//    	{
//    		PT_R_COM_NAME_CHANGEEnt.setDsOnlyString(ds, arg_row);//
//    		PT_R_COM_NAME_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
//        	KJFLog.debug(PT_R_COM_NAME_CHANGEEnt.toString()); 		    	
//        	PT_R_COM_NAME_CHANGEdao.update(PT_R_COM_NAME_CHANGEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE_TEMP"))
    	{
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ENGINEER_CHANGE_TEMPEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGE_TEMPdao.update(PT_R_ENGINEER_CHANGE_TEMPEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ENGINEER_CHANGEEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGEdao.update(PT_R_ENGINEER_CHANGEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ADDRESS_CHANGE"))
    	{
    		PT_R_ADDRESS_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ADDRESS_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ADDRESS_CHANGEEnt.toString()); 		    	
        	PT_R_ADDRESS_CHANGEdao.update(PT_R_ADDRESS_CHANGEEnt);
    	}
//    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_DIAGNOSTIC"))
//    	{
//    		PT_R_COMPANY_DIAGNOSTICEnt.setDsOnlyString(ds, arg_row);//
//    		PT_R_COMPANY_DIAGNOSTICEnt.setUPD_DT(KJFDate.getCurDatetime());
//        	KJFLog.debug(PT_R_COMPANY_DIAGNOSTICEnt.toString()); 		    	
//        	PT_R_COMPANY_DIAGNOSTICdao.update(PT_R_COMPANY_DIAGNOSTICEnt);
//    	}
//    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REPRESENT_CHANGE"))
//    	{
//    		PT_R_REPRESENT_CHANGEEnt.setDsOnlyString(ds, arg_row);//
//    		PT_R_REPRESENT_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
//        	KJFLog.debug(PT_R_REPRESENT_CHANGEEnt.toString()); 		    	
//        	PT_R_REPRESENT_CHANGEdao.update(PT_R_REPRESENT_CHANGEEnt);
//    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_COM_DEFICIT"))
    	{
    		PT_R_COM_DEFICITEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_COM_DEFICITEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COM_DEFICITEnt.toString()); 		    	
        	PT_R_COM_DEFICITdao.update(PT_R_COM_DEFICITEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_MOT_STE"))
    	{
    		PT_R_MOT_STEEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_MOT_STEEnt.toString());
    		PT_R_MOT_STEdao.update(PT_R_MOT_STEEnt);
    	}
    	else
    	{
    		PT_R_BASIC_STATEMENTEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_BASIC_STATEMENTEnt.setUPD_DT(KJFDate.getCurDatetime());
        	PT_R_BASIC_STATEMENTdao.update(PT_R_BASIC_STATEMENTEnt);    		
    	}
    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String sKey = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();
    	
    	String deleteQuery;
    	
    	ReportDAO rDAO;
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_REG_MEMO"))
    	{
    		String sSEQ = ds.getDeleteColumn(arg_row,"MEMO_SEQ").getString();
    		String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();
    		deleteQuery = " DELETE FROM PT_R_REG_MEMO WHERE TMP_WRT_NUM = '" + sKey + "'" + " AND MEMO_SEQ = '" + sSEQ + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		//String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_SUBSIDIARY ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		//sQuery.append(" AND CHGBRE_SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    	/*else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		//String sChgSeq = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_ENGINEER_CHANGE ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		//sQuery.append(" AND SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}*/
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		System.out.println("KEY ============= " + sKey);
    		//String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		String sSSN1 = ds.getDeleteColumn(arg_row,"ENGINEER_SSN1").getString();
    		String sSSN2 = ds.getDeleteColumn(arg_row,"ENGINEER_SSN2").getString();
    		//String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();

    		sQuery.append(" DELETE FROM PT_R_ENGINEER_CHANGE ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		//sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		sQuery.append(" AND ENGINEER_SSN1 = '" + sSSN1 + "' ");
    		sQuery.append(" AND ENGINEER_SSN2 = '" + sSSN2 + "' ");
    		//sQuery.append(" AND CHGBRE_SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}

    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFUSAL_REASON"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_REFUSAL_REASON ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		sQuery.append(" AND CHGBRE_SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFFER"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		//String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_REFFER ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		//sQuery.append(" AND CHGBRE_SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    		String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();
    		
    		//deleteQuery = " DELETE FROM PT_R_REFFER WHERE TMP_WRT_NUM = '" + sKey + "'";
    		//deleteQuery += " AND CHGBRE_SEQ = '" + sChgSeq + "'";
        	//rDAO = new ReportDAO();
        	//rDAO.execute(deleteQuery);
        	
       	
    		//deleteQuery = " DELETE FROM PT_R_ENGINEER_CHANGE WHERE TMP_WRT_NUM = '" + sKey + "'";
    		//deleteQuery += " AND CHGBRE_SEQ = '" + sChgSeq + "'";
        	//rDAO = new ReportDAO();
        	//rDAO.execute(deleteQuery);
    		
    		deleteQuery = " DELETE FROM PT_R_ENGINEER_CHANGE WHERE TMP_WRT_NUM = '" + sKey + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	      	   	
        	deleteQuery = " DELETE FROM PT_R_REG_MEMO WHERE TMP_WRT_NUM = '" + sKey + "'";
        	deleteQuery += " AND CHGBRE_SEQ = '" + sChgSeq + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);      	
     	       	
        	deleteQuery = " DELETE FROM PT_R_REFUSAL_REASON WHERE TMP_WRT_NUM = '" + sKey + "'";
        	deleteQuery += " AND CHGBRE_SEQ = '" + sChgSeq + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_MOT_STE WHERE TMP_WRT_NUM = '" + sKey + "'";
        	deleteQuery += " AND CHGBRE_SEQ = '" + sChgSeq + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_COM_DEFICIT WHERE TMP_WRT_NUM = '" + sKey + "'";
        	deleteQuery += " AND CHGBRE_SEQ = '" + sChgSeq + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_BASIC_CHANGE_HISTORY WHERE TMP_WRT_NUM = '" + sKey + "'";
        	deleteQuery += " AND CHGBRE_SEQ = '" + sChgSeq + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_BASIC_STATEMENT WHERE TMP_WRT_NUM = '" + sKey + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    	}    	
    }
    
        private String getMaxChangeEngSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
       // String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        System.out.println("KEY ============= " + scTMP_WRT_NUM);
      
        
        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 AS SEQ  ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"SEQ");
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
    
    private String getMaxSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
    
}