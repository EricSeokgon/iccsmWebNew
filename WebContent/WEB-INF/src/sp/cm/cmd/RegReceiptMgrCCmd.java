/**
 * ���ϸ�   : ComCodeMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegReceiptMgrCCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegReceiptMgrCCmd() {
    }

    public RegReceiptMgrCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData();
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        String scRECV_NUM = vl.getValueAsString("RECV_NUM");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCHECK = vl.getValueAsString("CHECK");

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;
                        
        //�ڵ强 ����Ÿ �� ��� �׻� �ʵ尡 2���� �����ؾ� ��
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
         if (scCHECK.equalsIgnoreCase("TRUE"))
        {
        	sQuery.append(" SELECT RECV_NUM FROM PT_R_REGIST_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else if((scCHECK.equalsIgnoreCase("FALSE")))
        {
	        //Master Table
        	sQuery.append(" SELECT * FROM PT_R_REGIST_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	        
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        
	        //Memo Table
	        sQuery.append(" SELECT '0' AS CHECKER, A.* FROM PT_R_MEMO A ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND	RECV_NUM = '" + scRECV_NUM + "' \n");
	        sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	        //Corp Table
	        sQuery.append(" SELECT '0' AS CHECKER, A.*, B.CODE_NAME AS OTOB_COM_TOB_CONT ");
	        sQuery.append(" FROM PT_R_SUBSIDIARY_COMPANY A LEFT JOIN  ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'SUBSIDIARY') ");
	        sQuery.append(" B ON A.OTOB_COM_CODE = B.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND	A.RECV_NUM = '" + scRECV_NUM + "' \n");
	        sWhere.append("  AND	A.SIDO_CODE = '" + scSIDO_CODE + "' \n");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        
	        //Deficit Table
	        sQuery.append(" SELECT PDEF.*, PDEF_CODE.CONT AS DEFI_CONT FROM PT_R_DEFICIT PDEF LEFT JOIN ");
	        sQuery.append(" (SELECT DEFI_CODE, CONT FROM PT_R_DEFICIT_CODE WHERE DEFI_GROUP = 'GUBU') ");
	        sQuery.append(" PDEF_CODE  ON PDEF.DEFI_CODE = PDEF_CODE.DEFI_CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PDEF.RECV_NUM = '" + scRECV_NUM + "' ");
	        sWhere.append("  AND	PDEF.SIDO_CODE = '" + scSIDO_CODE + "' \n");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }
        else if((scCHECK.equalsIgnoreCase("VALIDATION")))
        {
        	String scMANA_NUM = vl.getValueAsString("scMANA_NUM");
        	
        	sQuery.append(" SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER  ");
        	sWhere.append(" WHERE 1 = 1 ");
        	sWhere.append(" AND MANA_NUM = '" + scMANA_NUM + "' ");
        	        	
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }
        else
        {
        	//Deficit Codes Table
        	sQuery.append(" SELECT * ");
        	sQuery.append(" FROM PT_R_DEFICIT_CODE ");
        	sQuery.append(" WHERE DEFI_GROUP = 'GUBU' ");
	
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
                
        request.setAttribute("dl", dl);  

        return next;
    }
}