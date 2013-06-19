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

import sp.dao.PT_R_COMPANY_MASTERDAO;
import sp.dao.PT_R_COMPANY_MASTEREntity;
import sp.dao.PT_R_ENGINEER_CHANGE_TEMPDAO;
import sp.dao.PT_R_ENGINEER_CHANGE_TEMPEntity;
import sp.dao.PT_R_M_UNION_STATEMENTDAO;
import sp.dao.PT_R_M_UNION_STATEMENTEntity;
import sp.dao.PT_R_UNION_COMPANY_BEFOREDAO;
import sp.dao.PT_R_UNION_COMPANY_BEFOREEntity;

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

import sp.dao.PT_R_SUBSIDIARY_TEMPDAO;
import sp.dao.PT_R_SUBSIDIARY_TEMPEntity;

import sp.dao.PT_R_COM_DEFICITDAO;
import sp.dao.PT_R_COM_DEFICITEntity;

import sp.dao.PT_R_MOT_STEDAO;
import sp.dao.PT_R_MOT_STEEntity;

import sp.dao.PT_R_WORK_CAPABILITYDAO;
import sp.dao.PT_R_WORK_CAPABILITYEntity;

import sp.dao.PT_R_WORK_RESULTSDAO;
import sp.dao.PT_R_WORK_RESULTSEntity;

import sp.dao.PT_R_WORK_CAPABILITY_TEMPDAO;
import sp.dao.PT_R_WORK_CAPABILITY_TEMPEntity;

import sp.dao.PT_R_WORK_RESULTS_TEMPDAO;
import sp.dao.PT_R_WORK_RESULTS_TEMPEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;

public class UnionMgrCCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_R_COMPANY_MASTERDAO    PT_R_COMPANY_MASTERdao = new PT_R_COMPANY_MASTERDAO();
    private PT_R_COMPANY_MASTEREntity PT_R_COMPANY_MASTEREnt = new PT_R_COMPANY_MASTEREntity();
    
    private PT_R_REFFERDAO    PT_R_REFFERdao = new PT_R_REFFERDAO();
    private PT_R_REFFEREntity PT_R_REFFEREnt = new PT_R_REFFEREntity();
    
    private PT_R_BASIC_CHANGE_HISTORYDAO    PT_R_BASIC_CHANGE_HISTORYdao = new PT_R_BASIC_CHANGE_HISTORYDAO();
    private PT_R_BASIC_CHANGE_HISTORYEntity PT_R_BASIC_CHANGE_HISTORYEnt = new PT_R_BASIC_CHANGE_HISTORYEntity();
    
    private PT_R_ENGINEER_CHANGEDAO    PT_R_ENGINEER_CHANGEdao = new PT_R_ENGINEER_CHANGEDAO();
    private PT_R_ENGINEER_CHANGEEntity PT_R_ENGINEER_CHANGEEnt = new PT_R_ENGINEER_CHANGEEntity();
    
    private PT_R_ENGINEER_CHANGE_TEMPDAO    PT_R_ENGINEER_CHANGE_TEMPdao = new PT_R_ENGINEER_CHANGE_TEMPDAO();
    private PT_R_ENGINEER_CHANGE_TEMPEntity PT_R_ENGINEER_CHANGE_TEMPEnt = new PT_R_ENGINEER_CHANGE_TEMPEntity();

    
    private PT_R_REFUSAL_REASONDAO    PT_R_REFUSAL_REASONdao = new PT_R_REFUSAL_REASONDAO();
    private PT_R_REFUSAL_REASONEntity PT_R_REFUSAL_REASONEnt = new PT_R_REFUSAL_REASONEntity();
    
    private PT_R_SUBSIDIARYDAO    PT_R_SUBSIDIARYdao = new PT_R_SUBSIDIARYDAO();
    private PT_R_SUBSIDIARYEntity PT_R_SUBSIDIARYEnt = new PT_R_SUBSIDIARYEntity();

    private PT_R_SUBSIDIARY_TEMPDAO    PT_R_SUBSIDIARY_TEMPdao = new PT_R_SUBSIDIARY_TEMPDAO();
    private PT_R_SUBSIDIARY_TEMPEntity PT_R_SUBSIDIARY_TEMPEnt = new PT_R_SUBSIDIARY_TEMPEntity();
    
    private PT_R_COM_DEFICITDAO    PT_R_COM_DEFICITdao = new PT_R_COM_DEFICITDAO();
    private PT_R_COM_DEFICITEntity PT_R_COM_DEFICITEnt = new PT_R_COM_DEFICITEntity();
    
    private PT_R_MOT_STEDAO PT_R_MOT_STEdao = new PT_R_MOT_STEDAO();
    private PT_R_MOT_STEEntity PT_R_MOT_STEEnt = new PT_R_MOT_STEEntity(); 
    
    private PT_R_M_UNION_STATEMENTDAO PT_R_M_UNION_STATEMENTdao = new PT_R_M_UNION_STATEMENTDAO();
    private PT_R_M_UNION_STATEMENTEntity PT_R_M_UNION_STATEMENTEnt = new PT_R_M_UNION_STATEMENTEntity(); 

    private PT_R_UNION_COMPANY_BEFOREDAO PT_R_UNION_COMPANY_BEFOREdao = new PT_R_UNION_COMPANY_BEFOREDAO();
    private PT_R_UNION_COMPANY_BEFOREEntity PT_R_UNION_COMPANY_BEFOREEnt = new PT_R_UNION_COMPANY_BEFOREEntity(); 
    
    private PT_R_WORK_CAPABILITYDAO PT_R_WORK_CAPABILITYdao = new PT_R_WORK_CAPABILITYDAO();
    private PT_R_WORK_CAPABILITYEntity PT_R_WORK_CAPABILITYEnt = new PT_R_WORK_CAPABILITYEntity(); 

    private PT_R_WORK_RESULTSDAO PT_R_WORK_RESULTSdao = new PT_R_WORK_RESULTSDAO();
    private PT_R_WORK_RESULTSEntity PT_R_WORK_RESULTSEnt = new PT_R_WORK_RESULTSEntity(); 

    private PT_R_WORK_CAPABILITY_TEMPDAO PT_R_WORK_CAPABILITY_TEMPdao = new PT_R_WORK_CAPABILITY_TEMPDAO();
    private PT_R_WORK_CAPABILITY_TEMPEntity PT_R_WORK_CAPABILITY_TEMPEnt = new PT_R_WORK_CAPABILITY_TEMPEntity(); 

    private PT_R_WORK_RESULTS_TEMPDAO PT_R_WORK_RESULTS_TEMPdao = new PT_R_WORK_RESULTS_TEMPDAO();
    private PT_R_WORK_RESULTS_TEMPEntity PT_R_WORK_RESULTS_TEMPEnt = new PT_R_WORK_RESULTS_TEMPEntity(); 
    
    private VariableList vl = new VariableList();
    
    
    public UnionMgrCCUDCmd() {
    }

    public UnionMgrCCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	String scMODE = vl.getValueAsString("workMODE");
    	String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
    	String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
    	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds;
    	
    	if (scMODE.equalsIgnoreCase("ALL"))
    	{
    		String scMOT_STE = vl.getValueAsString("sMOT_STE");
    		
    		if ("STD003".equals(scMOT_STE)){
    			
    			String scTMP_WRT_NUMS = vl.getValueAsString("scTMP_WRT_NUMS");
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_COMPANY_MASTER");
	    		if (ds != null)
	    		{
	    			ReportDAO    rDAO;
	            	String deleteQuery = " UPDATE PT_R_COMPANY_MASTER " +
	            			" SET UNION_PARENT ='"+scTMP_WRT_NUM+"', UNION_YN = 'Y' " +
	            			" WHERE TMP_WRT_NUM IN (" + scTMP_WRT_NUMS + ")";
	            	rDAO = new ReportDAO();
	            	rDAO.execute(deleteQuery);

	    			dsProc(ds);
	    		}
	    		
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_BASIC_CHANGE_HISTORY");
	    		if (ds != null)dsProc(ds);
	    		
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");
	    		if (ds != null) dsProc(ds);
    		
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_REPRESENT_CHANGE");
	    		if (ds != null) dsProc(ds);
	    		
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
	    		
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_WORK_RESULTS_TEMP");
	    		if (ds != null) dsProc(ds);
	    		
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_WORK_CAPABILITY_TEMP");
	    		if (ds != null) dsProc(ds);

	    		ds = pReq.getDatasetList().getDataset("dsPT_R_WORK_RESULTS");
	    		if (ds != null)
	    		{
	    			ReportDAO    rDAO;
	            	String deleteQuery = " DELETE FROM PT_R_WORK_RESULTS WHERE TMP_WRT_NUM = " + scTMP_WRT_NUM + "";
	            	rDAO = new ReportDAO();
	            	rDAO.execute(deleteQuery);

	    			dsProc(ds);
	    		}
	    		
	    		ds = pReq.getDatasetList().getDataset("dsPT_R_WORK_CAPABILITY");
	    		if (ds != null)
	    		{
	    			ReportDAO    rDAO;
	            	String deleteQuery = " DELETE FROM PT_R_WORK_CAPABILITY WHERE TMP_WRT_NUM =" + scTMP_WRT_NUM + "";
	            	rDAO = new ReportDAO();
	            	rDAO.execute(deleteQuery);

	    			dsProc(ds);	    		
	    		}
    		}
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE_TEMP");    		
    		if (ds != null) dsProc(ds);

    		ds = pReq.getDatasetList().getDataset("dsPT_R_MOT_STE");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_M_UNION_STATEMENT");
    		if(ds != null) dsProc(ds);
    		
    	}
    	else if (scMODE.equalsIgnoreCase("RECV_NUM_CHECK_SV")) // 접수번호
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_M_UNION_STATEMENT");
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_MOT_STE");		//세부업무진행사항
    		if(ds != null) dsProc(ds);
    		
    	}	
    	else if (scMODE.equalsIgnoreCase("UNION_COMPANY")) // 합병된 공사업체 등록
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_UNION_COMPANY_BEFORE");
    		if(ds != null) dsProc(ds);
    	}    	
    	else if (scMODE.equalsIgnoreCase("D_UNION_COMPANY")) // 합병된 공사업체 등록
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_UNION_COMPANY_BEFORE");
    		if(ds != null) dsProc(ds);
    		
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_M_UNION_STATEMENT");
    		if(ds != null){
    			String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
    	       	String deleteQuery = " DELETE FROM PT_R_M_UNION_STATEMENT WHERE RECV_NUM = '" + scRECV_NUM + "'";    		
    			deleteQuery += " AND SIDO_CODE = '"+scSIDO_CODE+"'";
    	        ReportDAO    rDAO        = new ReportDAO();
    	    	rDAO = new ReportDAO();
    	    	rDAO.execute(deleteQuery);
    			dsProc(ds);
    		}
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_SUBSIDIARY_TEMP");
    		if(ds != null){    			
    	       	String deleteQuery = " DELETE FROM PT_R_SUBSIDIARY_TEMP WHERE RECV_NUM = '" + scRECV_NUM + "'";    		
    			deleteQuery += " AND SUB_PROC = 'U'";
    	        ReportDAO    rDAO        = new ReportDAO();
    	    	rDAO = new ReportDAO();
    	    	rDAO.execute(deleteQuery);
    			dsProc(ds);
    		}
    		
    	}  
    	else if (scMODE.equalsIgnoreCase("SUBSIDIARY")) //  겸험 저장
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_SUBSIDIARY_TEMP");
    		if(ds != null) dsProc(ds);
    	}
    	else if (scMODE.equalsIgnoreCase("ENGINEER"))	// 보유기술자 
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE_TEMP");
    		if(ds != null) dsProc(ds);
    	}
    	if (scMODE.equalsIgnoreCase("REPER"))
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFFER");
    		if(ds != null) dsProc(ds);
    	}    	
    	if (scMODE.equalsIgnoreCase("REFUSAL"))
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFUSAL_REASON");
    		if(ds != null) dsProc(ds);
    	}    	
    	else if (scMODE.equalsIgnoreCase("ALL_DEL"))	// 조회 데이터 삭제
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_M_UNION_STATEMENT_LI");
    		if(ds != null) dsProc(ds);
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

    	if(ds.getId().equalsIgnoreCase("dsPT_R_REFFER"))
    	{    		
    		PT_R_REFFEREnt.setDsOnlyString(ds, arg_row);//
    		PT_R_REFFEREnt.setINS_DT(KJFDate.getCurDatetime());
    		PT_R_REFFEREnt.setSEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_REFFER", "SEQ"));
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY_TEMP"))
    	{
    		PT_R_SUBSIDIARY_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_SUBSIDIARY_TEMPEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_SUBSIDIARY_TEMPEnt.toString()); 		    	
        	PT_R_SUBSIDIARY_TEMPdao.insert(PT_R_SUBSIDIARY_TEMPEnt);
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
    		
       		if ("".equals(ds.getColumnAsString(0, "INS_DT"))){
       			PT_R_COMPANY_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());        			
       		}
       		
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setCHGBRE_SEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_BASIC_CHANGE_HISTORY", "CHGBRE_SEQ"));
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setINS_DT(KJFDate.getCurDatetime());
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.insert(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGEEnt.setINS_DT(KJFDate.getCurDatetime());
    		PT_R_ENGINEER_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
    		PT_R_ENGINEER_CHANGEEnt.setSEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_ENGINEER_CHANGE", "SEQ"));
        	KJFLog.debug(PT_R_ENGINEER_CHANGEEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGEdao.insert(PT_R_ENGINEER_CHANGEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE_TEMP"))
    	{	
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setINS_DT(KJFDate.getCurDatetime());
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setSEQ(
    				getMaxChangeEngSeq(ds.getColumnAsString(arg_row, "RECV_NUM"), "PT_R_ENGINEER_CHANGE_TEMP", "SEQ"));
    		
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setENG_PROC("U");
        	KJFLog.debug(PT_R_ENGINEER_CHANGE_TEMPEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGE_TEMPdao.insert(PT_R_ENGINEER_CHANGE_TEMPEnt);
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_M_UNION_STATEMENT")) 
    	{
    		PT_R_M_UNION_STATEMENTEnt.setDsOnlyString(ds, arg_row);
    		PT_R_M_UNION_STATEMENTEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_M_UNION_STATEMENTEnt.toString()); 		    	
        	PT_R_M_UNION_STATEMENTdao.insert(PT_R_M_UNION_STATEMENTEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_UNION_COMPANY_BEFORE")) 
    	{
    		PT_R_UNION_COMPANY_BEFOREEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_UNION_COMPANY_BEFOREEnt.setINS_DT(KJFDate.getCurDatetime());
    		PT_R_UNION_COMPANY_BEFOREEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_UNION_COMPANY_BEFOREEnt.toString()); 		    	
        	PT_R_UNION_COMPANY_BEFOREdao.insert(PT_R_UNION_COMPANY_BEFOREEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_RESULTS_TEMP")) 
    	{
    		PT_R_WORK_RESULTS_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_WORK_RESULTS_TEMPEnt.setINS_DT(KJFDate.getCurDatetime());    		
        	KJFLog.debug(PT_R_WORK_RESULTS_TEMPEnt.toString()); 		    	
        	PT_R_WORK_RESULTS_TEMPdao.insert(PT_R_WORK_RESULTS_TEMPEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_CAPABILITY_TEMP")) 
    	{
    		PT_R_WORK_CAPABILITY_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_WORK_CAPABILITY_TEMPEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_CAPABILITY_TEMPEnt.toString()); 		    	
        	PT_R_WORK_CAPABILITY_TEMPdao.insert(PT_R_WORK_CAPABILITY_TEMPEnt);
    	}

    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_RESULTS")) 
    	{
    		PT_R_WORK_RESULTSEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_WORK_RESULTSEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_RESULTSEnt.toString()); 		    	
        	PT_R_WORK_RESULTSdao.insert(PT_R_WORK_RESULTSEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_CAPABILITY")) 
    	{
    		PT_R_WORK_CAPABILITYEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_WORK_CAPABILITYEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_CAPABILITYEnt.toString()); 		    	
        	PT_R_WORK_CAPABILITYdao.insert(PT_R_WORK_CAPABILITYEnt);
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
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY_TEMP"))
    	{
    		PT_R_SUBSIDIARY_TEMPEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_SUBSIDIARY_TEMPEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_SUBSIDIARY_TEMPEnt.toString()); 		    	
        	PT_R_SUBSIDIARY_TEMPdao.update(PT_R_SUBSIDIARY_TEMPEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.update(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ENGINEER_CHANGEEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGEdao.update(PT_R_ENGINEER_CHANGEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE_TEMP"))
    	{
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ENGINEER_CHANGE_TEMPEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGE_TEMPdao.update(PT_R_ENGINEER_CHANGE_TEMPEnt);
    	}
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_UNION_COMPANY_BEFORE")) 
    	{
    		PT_R_UNION_COMPANY_BEFOREEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_UNION_COMPANY_BEFOREEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_UNION_COMPANY_BEFOREEnt.toString()); 		    	
        	PT_R_UNION_COMPANY_BEFOREdao.update(PT_R_UNION_COMPANY_BEFOREEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_M_UNION_STATEMENT")) 
    	{
    		PT_R_M_UNION_STATEMENTEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_M_UNION_STATEMENTEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_M_UNION_STATEMENTEnt.toString()); 		    	
        	PT_R_M_UNION_STATEMENTdao.update(PT_R_M_UNION_STATEMENTEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_RESULTS_TEMP")) 
    	{
    		PT_R_WORK_RESULTS_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_WORK_RESULTS_TEMPEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_RESULTS_TEMPEnt.toString()); 		    	
        	PT_R_WORK_RESULTS_TEMPdao.update(PT_R_WORK_RESULTS_TEMPEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_CAPABILITY_TEMP")) 
    	{
    		PT_R_WORK_CAPABILITY_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_WORK_CAPABILITY_TEMPEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_CAPABILITY_TEMPEnt.toString()); 		    	
        	PT_R_WORK_CAPABILITY_TEMPdao.update(PT_R_WORK_CAPABILITY_TEMPEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_RESULTS")) 
    	{
    		PT_R_WORK_RESULTSEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_WORK_RESULTSEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_RESULTSEnt.toString()); 		    	
        	PT_R_WORK_RESULTSdao.update(PT_R_WORK_RESULTSEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_WORK_CAPABILITY")) 
    	{
    		PT_R_WORK_CAPABILITYEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_WORK_CAPABILITYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_WORK_CAPABILITYEnt.toString()); 		    	
        	PT_R_WORK_CAPABILITYdao.update(PT_R_WORK_CAPABILITYEnt);
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
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY"))
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY_TEMP"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		String scRECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
        	
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_SUBSIDIARY_TEMP ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		sQuery.append(" AND RECV_NUM = '" + scRECV_NUM + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE_TEMP"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		sQuery.append(" DELETE FROM PT_R_ENGINEER_CHANGE_TEMP ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");

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
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_UNION_COMPANY_BEFORE")) 
    	{	
        	deleteQuery = " DELETE FROM PT_R_UNION_COMPANY_BEFORE WHERE TMP_WRT_NUM = '" + sKey + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);

        	deleteQuery = " DELETE FROM PT_R_ENGINEER_CHANGE_TEMP WHERE TMP_WRT_NUM = '" + sKey + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);

        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_M_UNION_STATEMENT_LI"))
    	{        	

    		// 작업진척사항
    		deleteQuery = " DELETE FROM PT_R_MOT_STE WHERE TMP_WRT_NUM = '" + sKey + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    		
        	// 임원
        	deleteQuery = " DELETE FROM PT_R_REFFER WHERE TMP_WRT_NUM = '" + sKey + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	// 등록결격 사유
        	deleteQuery = " DELETE FROM PT_R_REFUSAL_REASON WHERE TMP_WRT_NUM = '" + sKey + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    		
        	String scRECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    		
        	// 보유기술자 TEMP
    		deleteQuery = " DELETE FROM PT_R_ENGINEER_CHANGE_TEMP WHERE RECV_NUM = '" + scRECV_NUM + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);

        	// 겸업사항 TEMP
        	deleteQuery = " DELETE FROM PT_R_SUBSIDIARY_TEMP WHERE RECV_NUM = '" + scRECV_NUM + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);

        	// 합병관리 접수 TEMP
        	deleteQuery = " DELETE FROM PT_R_M_UNION_STATEMENT WHERE RECV_NUM = '" + scRECV_NUM + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);

        	// 합병관리 공사업 업체 TEMP
        	deleteQuery = " DELETE FROM PT_R_UNION_COMPANY_BEFORE WHERE RECV_NUM = '" + scRECV_NUM + "'";
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
    
    private String getMaxChangeEngSeq(String sKEY, String sTABLE, String sField) throws Exception {
     	
         ReportDAO rDAO = new ReportDAO();

         String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
         sQuery += " FROM " + sTABLE + " ";
         sQuery += " WHERE RECV_NUM = '" + sKEY + "' ";
         
         ReportEntity rEntity     = null;
         
         rEntity = rDAO.select(sQuery);

         return rEntity.getValue(0,"MAX_ID");
     }
    
}