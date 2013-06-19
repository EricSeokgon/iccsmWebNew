/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.am.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;

import kjf.util.KJFDate;
import kjf.util.KJFLog;


import org.apache.struts.action.ActionForm;

import sp.dao.P_S_MASTERDAO;
import sp.dao.P_S_MASTEREntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class ActualInvestMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private P_S_MASTERDAO    P_S_MASTERdao = new P_S_MASTERDAO();
    private P_S_MASTEREntity P_S_MASTEREnt = new P_S_MASTEREntity();
    
    private VariableList vl = new VariableList();
    
    public ActualInvestMgrCUDCmd() {
    }


    public ActualInvestMgrCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds = pReq.getDatasetList().getDataset("dsP_S_MASTER");
    	if(ds != null) dsProc(ds);

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

    	P_S_MASTEREnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(P_S_MASTEREnt.toString());
       	P_S_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());
       	P_S_MASTERdao.insert(P_S_MASTEREnt);
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	P_S_MASTEREnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(P_S_MASTEREnt.toString());
       	P_S_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
       	P_S_MASTERdao.update(P_S_MASTEREnt);
    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String sKey1 = ds.getDeleteColumn(arg_row,"WRT_NUM").getString();
    	String sKey2 = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();

    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
		sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
    	
    	ReportDAO rDAO = new ReportDAO();
    	
    	sQuery.append(" DELETE FROM PT_S_CAPITAL ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
		
		sQuery.append(" DELETE FROM PT_S_OFFICE ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
		
		sQuery.append(" DELETE FROM PT_S_CAPABILLITY_ASSESSMENT ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
		
		sQuery.append(" DELETE FROM PT_S_WORK_ITEM ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
		
		sQuery.append(" DELETE FROM PT_M_DICTOR_HUMAN_TRACE ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
	
		sQuery.append(" DELETE FROM P_S_MASTER ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
    }
}