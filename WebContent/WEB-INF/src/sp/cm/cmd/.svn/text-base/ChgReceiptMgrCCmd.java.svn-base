/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.cm.cmd;

import java.util.Vector;

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

public class ChgReceiptMgrCCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ChgReceiptMgrCCmd() {
    }

    public ChgReceiptMgrCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scRECV_NUM = vl.getValueAsString("RECV_NUM");
        String workMODE = vl.getValueAsString("workMODE");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;
                        
        //코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        if (workMODE.equalsIgnoreCase("GET_CORP"))
        {
        	String scCORP_NUM = vl.getValueAsString("scCORP_NUM");
        	
        	sQuery.append(" SELECT NAME, MANA_NUM, REP_NM_KOR, ADDR_TEL_NUM, WRT_DT, ");
        	sQuery.append(" ADDR_POST_NUM, ADDR_ADDR, ADDR_DETAIL_ADDR, COI_WRT_NUM ");
        	sQuery.append(" FROM PT_R_COMPANY_MASTER ");
        	sWhere.append(" WHERE 1 = 1	");
        	sWhere.append(" AND	TMP_WRT_NUM = '" + scCORP_NUM + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        sQuery.delete(0, sQuery.length());
	        sWhere.delete(0, sWhere.length());
	        
	        sQuery.append(" SELECT BB.SUB_WRT_NUM, SUB_CODE, CC.CODE_NAME AS SUB_NAME ");
        	sQuery.append(" FROM PT_R_SUBSIDIARY BB ");
        	sQuery.append(" LEFT JOIN ");
        	sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
        	sQuery.append(" WHERE P_CODE ='SUBSIDIARY') CC ON BB.SUB_CODE = CC.CODE ");
        	sWhere.append(" WHERE 1 = 1	");
        	sWhere.append(" AND	BB.TMP_WRT_NUM = '" + scCORP_NUM + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
        }
        else if (workMODE.equalsIgnoreCase("CHECK"))
        {
        	sQuery.append(" SELECT RECV_NUM FROM PT_R_CHANGE_STATEMENT ");
        	sWhere.append(" WHERE	1=1	");
        	sWhere.append(" AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append(" AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else if (workMODE.equalsIgnoreCase("CODE"))
        {
        	sQuery.append(" SELECT * ");
        	sQuery.append(" FROM PT_R_DEFICIT_CODE ");
        	sQuery.append(" WHERE DEFI_GROUP = 'GUBU' ");
	
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else if (workMODE.equalsIgnoreCase("ALL"))
        {
        	//Master Table
        	sQuery.append(" SELECT * FROM PT_R_CHANGE_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' ");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' ");
	        
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	       	String sTMP_WRT_NUM = rMasterEntity.getValue(0, "TMP_WRT_NUM");
	        
	        //Memo Table
	        sQuery.append(" SELECT '0' AS CHECKER, A.* FROM PT_R_MEMO A ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' ");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' ");
	       	
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
	        sWhere.append("  AND	A.RECV_NUM = '" + scRECV_NUM + "' ");
        	sWhere.append("  AND	A.SIDO_CODE = '" + scSIDO_CODE + "' ");
	       	
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
	        sWhere.append(" AND PDEF.SIDO_CODE = '" + scSIDO_CODE + "' ");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());

	       	//Company Master
	        sQuery.append(" SELECT NAME, MANA_NUM, REP_NM_KOR, ADDR_TEL_NUM, ADDR_FAX_NUM, ");
	        sQuery.append(" ADDR_POST_NUM, ADDR_ADDR, ADDR_DETAIL_ADDR, COI_WRT_NUM, WRT_DT ");
	        sQuery.append(" FROM PT_R_COMPANY_MASTER ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + sTMP_WRT_NUM + "' ");
	        	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }
        
        request.setAttribute("dl", dl);  

        return next;
    }
}