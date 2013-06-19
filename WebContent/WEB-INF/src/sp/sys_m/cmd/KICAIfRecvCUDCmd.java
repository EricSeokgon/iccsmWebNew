/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.sys_m.cmd;

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



public class KICAIfRecvCUDCmd implements KJFCommand {
	
    private String next;

    private PT_R_COMPANY_MASTERDAO    PT_R_COMPANY_MASTERdao = new PT_R_COMPANY_MASTERDAO();
    private PT_R_COMPANY_MASTEREntity PT_R_COMPANY_MASTEREnt = new PT_R_COMPANY_MASTEREntity();
    
    private PT_R_BASIC_CHANGE_HISTORYDAO    PT_R_BASIC_CHANGE_HISTORYdao = new PT_R_BASIC_CHANGE_HISTORYDAO();
    private PT_R_BASIC_CHANGE_HISTORYEntity PT_R_BASIC_CHANGE_HISTORYEnt = new PT_R_BASIC_CHANGE_HISTORYEntity();
    
    private VariableList vl = new VariableList();
    
    
    public KICAIfRecvCUDCmd() {
    }


    public KICAIfRecvCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds;
    	
		ds = pReq.getDatasetList().getDataset("dsPT_R_COMPANY_MASTER");
		if (ds != null) dsProc(ds);
		
		ds = pReq.getDatasetList().getDataset("dsPT_R_BASIC_CHANGE_HISTORY");
		if (ds != null)dsProc(ds);
		
		ds = pReq.getDatasetList().getDataset("dsPT_TMP_RECEIVE_KEY");
		if (ds != null)dsProc(ds);		

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

    	if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);//
    		PT_R_COMPANY_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	PT_R_COMPANY_MASTERdao.insert(PT_R_COMPANY_MASTEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setCHGBRE_SEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_BASIC_CHANGE_HISTORY"));
    	    //PT_R_BASIC_CHANGE_HISTORYEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.insert(PT_R_BASIC_CHANGE_HISTORYEnt);
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
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.update(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_TMP_RECEIVE_KEY"))
    	{
    		String sSEQ = ds.getDeleteColumn(arg_row, "SEQ").getString();
    		String sCOI_WRT_NUM = ds.getDeleteColumn(arg_row, "COI_WRT_NUM").getString();
    		String sMANA_NUM = ds.getDeleteColumn(arg_row, "MANA_NUM").getString();
    		
    		StringBuilder sQuery = new StringBuilder();
    		sQuery.append(" DELETE FROM PT_TMP_RECEIVE_KEY ");
    		sQuery.append(" WHERE SEQ = '" + sSEQ + "' ");
    		sQuery.append(" AND COI_WRT_NUM = '" + sCOI_WRT_NUM + "' ");
    		sQuery.append(" AND MANA_NUM = '" + sMANA_NUM + "' ");
    		
    		ReportDAO rDAO = new ReportDAO();
    		rDAO.execute(sQuery.toString());
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
    
}