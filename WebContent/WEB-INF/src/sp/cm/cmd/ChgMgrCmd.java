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

public class ChgMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ChgMgrCmd() {
    }

    public ChgMgrCmd(String next_url) {
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
        
        String scDATE1 = vl.getValueAsString("scDATE1");
        String scDATE2 = vl.getValueAsString("scDATE2");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scNAME = vl.getValueAsString("scNAME");

        sQuery.append(" SELECT '0' AS CHECKER, BB.SIDO_CODE,BB.CHGBRE_SEQ, BB.MOT_STE, AA.COI_WRT_NUM, AA.WRT_DT, AA.NAME, ");
        sQuery.append(" AA.REP_NM_KOR, AA.C_COM_DT, AA.ADDR_ADDR,  DECODE(AA.C_COM_DT, NULL, '', '폐업') AS TMPC_COM_DT, ");
        sQuery.append(" AA.TMP_WRT_NUM, BB.RECV_NUM, AA.MANA_NUM, CC.CODE_NAME AS TMPMOT_STE ");
        sQuery.append(" FROM (PT_R_COMPANY_MASTER AA INNER JOIN ");
        sQuery.append(" (SELECT SIDO_CODE, RECV_NUM, TMP_WRT_NUM, CHGBRE_SEQ, MOT_STE, INS_DT ");
        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY ");
        sQuery.append(" WHERE STA_CHG_CLASS_CODE = 'R00011') BB ON AA.TMP_WRT_NUM = BB.TMP_WRT_NUM) ");
        sQuery.append(" LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGSTDPROC') CC ");
        sQuery.append(" ON BB.MOT_STE = CC.CODE ");

        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND (REPLACE(SUBSTR(BB.INS_DT,0, 10), '-', '') BETWEEN '" + scDATE1 + "'");
        sWhere.append(" AND '" + scDATE2 + "')");
        if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
        	sWhere.append(" AND AA.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
        if (!KJFUtil.isEmpty(scNAME))
        	sWhere.append(" AND AA.NAME LIKE '" + scNAME + "%'");
    	
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}