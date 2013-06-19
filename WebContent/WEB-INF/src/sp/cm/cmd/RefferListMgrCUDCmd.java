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

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class RefferListMgrCUDCmd implements KJFCommand {
	
    private String next;

    private PT_R_REFFERDAO    PT_R_REFFERdao = new PT_R_REFFERDAO();
    private PT_R_REFFEREntity PT_R_REFFEREnt = new PT_R_REFFEREntity();
    
    private VariableList vl = new VariableList();
    
    
    public RefferListMgrCUDCmd() {
    }


    public RefferListMgrCUDCmd(String next_url) {
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

		ds = pReq.getDatasetList().getDataset("dsPT_R_REFFER");
		if (ds != null) dsProc(ds);
    	
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
    		
		PT_R_REFFEREnt.setDsOnlyString(ds, arg_row);//
		PT_R_REFFEREnt.setINS_DT(KJFDate.getCurDatetime());
    	KJFLog.debug(PT_R_REFFEREnt.toString()); 		    	
    	PT_R_REFFERdao.insert(PT_R_REFFEREnt);
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	
		PT_R_REFFEREnt.setDsOnlyString(ds, arg_row);// 
		PT_R_REFFEREnt.setUPD_DT(KJFDate.getCurDatetime());
    	KJFLog.debug(PT_R_REFFEREnt.toString()); 		    	
    	PT_R_REFFERdao.update(PT_R_REFFEREnt);
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
		
		sQuery.append(" DELETE FROM PT_R_REFFER ");
		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    	rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString());
        	
       	return;
    }
}