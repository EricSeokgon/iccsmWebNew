/**
 * ���ϸ�   : ComCodeMgrCUDCmd.java
 * ����     : CUD cmd
 * �̷»���
 * CH00     : 2008/12/22 ���� �����ۼ�
 */

package sp.am.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;

import kjf.util.KJFDate;
import kjf.util.KJFLog;


import org.apache.struts.action.ActionForm;

import sp.dao.PT_M_MASTERDAO;
import sp.dao.PT_M_MASTEREntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;



public class AmReceiptMgrCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_M_MASTERDAO    PT_M_MASTERdao = new PT_M_MASTERDAO();
    private PT_M_MASTEREntity PT_M_MASTEREnt = new PT_M_MASTEREntity();
    
    private VariableList vl = new VariableList();
    
    public AmReceiptMgrCUDCmd() {
    }


    public AmReceiptMgrCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	/** List ȹ�� �� Dataset ȹ�� **/
    	Dataset ds = pReq.getDatasetList().getDataset("dsPT_M_MASTER");
    	if(ds != null) dsProc(ds);

        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception
    {
    	for(int i=0;i<ds.getRowCount();i++){
    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);
    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
    	}

    	/****** Dataset�� DELETEó�� ****/
    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
    		deleteExe(ds,i);
    	}
    }

    /**
     * �Է�
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{

    	PT_M_MASTEREnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_M_MASTEREnt.toString());
       	PT_M_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());
       	PT_M_MASTERdao.insert(PT_M_MASTEREnt);
    }
    
    /**
     * ����
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	PT_M_MASTEREnt.setDsOnlyString(ds, arg_row);// 
       	KJFLog.debug(PT_M_MASTEREnt.toString());
       	PT_M_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
       	PT_M_MASTERdao.update(PT_M_MASTEREnt);
    }

    /**
     * ����
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String sKey1 = ds.getDeleteColumn(arg_row,"WRT_NUM").getString();
    	String sKey2 = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();
    	String sDISPO_CONT = ds.getDeleteColumn(arg_row,"DISPO_CONT").getString();
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	sWhere.append(" WHERE WRT_NUM = '" + sKey1 + "' ");
		sWhere.append(" AND	TMP_WRT_NUM = '" + sKey2 + "' ");
    	
    	ReportDAO rDAO = new ReportDAO();
    	
		sQuery.append(" DELETE FROM PT_M_MEMO ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
		
		sQuery.append(" DELETE FROM PT_M_BEF_REPORT ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
		
		if (sDISPO_CONT.equalsIgnoreCase("M00001")) //������
		{	sQuery.append(" DELETE FROM PT_M_AUDI_DICTION ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());
			
			sQuery.append(" DELETE FROM PT_M_AUDI_OPINION ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());
			
			sQuery.append(" DELETE FROM PT_M_AUDI_REPORT ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());

			sQuery.append(" DELETE FROM PT_M_REGIST_CANCEL ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());
			
			sQuery.append(" DELETE FROM PT_M_AUDI_BEF_REPORT ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());
		}
		else if(sDISPO_CONT.equalsIgnoreCase("M00002")) //��������
		{
			sQuery.append(" DELETE FROM PT_M_SUSPENSION ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());
		}
//		else if(sDISPO_CONT.equalsIgnoreCase("M00003")) // �������� �� ���·�
//		{
//			sQuery.append(" DELETE FROM PT_M_SUSNEG ");
//			rDAO.execute(sQuery.toString() + sWhere.toString());
//			sQuery.delete(0, sQuery.length());			
//		}
		else if(sDISPO_CONT.equalsIgnoreCase("M00003")) // ���·� �ΰ�
		{
			sQuery.append(" DELETE FROM PT_M_NEGLIGENCE ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());
		}
		else if(sDISPO_CONT.equalsIgnoreCase("M00004")) // �������
		{
			sQuery.append(" DELETE FROM PT_M_CORRECT ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());
		}
		else if(sDISPO_CONT.equalsIgnoreCase("M00005")) // ������
		{
			sQuery.append(" DELETE FROM PT_M_PROSECUTION ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());
		}
		else if(sDISPO_CONT.equalsIgnoreCase("M00006")) // �����ġ
		{
			sQuery.append(" DELETE FROM PT_M_WARNING ");
			rDAO.execute(sQuery.toString() + sWhere.toString());
			sQuery.delete(0, sQuery.length());			
		}
		
		sQuery.append(" DELETE FROM PT_M_MASTER ");
		rDAO.execute(sQuery.toString() + sWhere.toString());
		sQuery.delete(0, sQuery.length());
    }
}