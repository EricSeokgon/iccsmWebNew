/**
 * 파일명   : RegMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RefferListMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RefferListMgrCmd() {
    }

    public RefferListMgrCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scNAME = vl.getValueAsString("scNAME");
       // String scCOMPANY_DIV = vl.getValueAsString("scCOMPANY_DIV");
        String scDATE = vl.getValueAsString("scDATE");
        
        sQuery.append("        SELECT P.SEQ, P.TMP_WRT_NUM, P.SI_DO_CODE, ");
        sQuery.append("        P.SI_GUN_GU_CODE, P.POS_CLASS, P.ENT_DT, ");
        sQuery.append("        P.RET_DT, P.NM_KOR, P.NM_HAN, ");
        sQuery.append("        P.ORI, P.ADDR, P.SSN1, ");
        sQuery.append("        P.SSN2, P.SSN1||P.SSN2 AS TMPSSN, P.HEFA, P.HEFA_RELA, ");
        sQuery.append("        P.REMARK, P.CHAR_REF_YN, P.WRT_ID, ");
        sQuery.append("        P.INS_DT, P.UPD_DT, P.SEND_YN, ");
        sQuery.append("        P.FOREIGN_YN, P.ACCEPT_NO, ");
        sQuery.append("        P.DEL_YN, BB.COI_WRT_NUM, BB.NAME ");
        //sQuery.append(" SELECT AA.NM_KOR,AA.CHAR_REF_YN, AA.SSN1 || AA.SSN2 AS TMPSSN, BB.COI_WRT_NUM, BB.NAME ");
        //sQuery.append(" SELECT AA.*, AA.SSN1 || AA.SSN2 AS TMPSSN, BB.COI_WRT_NUM, BB.NAME ");
        //sQuery.append(" FROM PT_R_REFFER AA LEFT JOIN PT_R_COMPANY_MASTER BB ON AA.TMP_WRT_NUM = BB.TMP_WRT_NUM ");
        
        //sQuery.append(" FROM PT_R_REFFER AA LEFT JOIN " + scDATE + " ");
        
        sQuery.append(" FROM PT_R_REFFER P LEFT JOIN " + scDATE + " ");
        
        if ("PT_R_ASSI_TRANS_STATEMENT".equals(scDATE)){
        	sQuery.append(" BB ON P.TMP_WRT_NUM = BB.ASSI_TMP_WRT_NUM ");
        }
        else{
        sQuery.append(" BB ON P.TMP_WRT_NUM = BB.TMP_WRT_NUM ");
        }
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND P.SEND_YN IS NOT NULL ");
        sWhere.append(" AND	P.CHAR_REF_YN = '2' ");
        if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
        	sWhere.append(" AND BB.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
        if (!KJFUtil.isEmpty(scNAME))
        	sWhere.append(" AND BB.NAME LIKE '%" + scNAME + "%'");
       	sWhere.append(" AND BB.SIDO_CODE = '" + scSIDO_CODE + "'");
       	sWhere.append(" ORDER BY P.TMP_WRT_NUM ");
    	
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}