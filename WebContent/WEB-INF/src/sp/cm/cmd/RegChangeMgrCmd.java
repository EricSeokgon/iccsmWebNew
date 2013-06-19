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

public class RegChangeMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegChangeMgrCmd() {
    }

    public RegChangeMgrCmd(String next_url) {
    	next = next_url;
    }

    //목록 처리
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
        
        String scworkMode = vl.getValueAsString("scworkMode");
        String scDATE1 = vl.getValueAsString("scDATE1");
        String scDATE2 = vl.getValueAsString("scDATE2");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scNAME = vl.getValueAsString("scNAME");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        

        if(scworkMode.equalsIgnoreCase("ALL"))
        {
	        sQuery.append(" SELECT '0' AS CHECKER, BB.COI_WRT_NUM, BB.WRT_DT, BB.NAME, BB.REP_NM_KOR, BB.C_COM_DT, BB.ADDR_ADDR, ");
	        sQuery.append(" DECODE(BB.C_COM_DT, NULL, '', '폐업') AS TMPC_COM_DT,  BB.TMP_WRT_NUM, BB.MANA_NUM ");
	        sQuery.append(" FROM    PT_R_COMPANY_MASTER BB ");
	        //sQuery.append(" LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGPROC')CC ON BB.MOT_STE = CC.CODE ");
	
	        sWhere.append(" WHERE 1 = 1 ");
	        //sWhere.append(" AND (REPLACE(SUBSTR(BB.INS_DT, 0, 10), '-', '') BETWEEN '" + scDATE1 + "'");
	        //sWhere.append(" AND '" + scDATE2 + "')");
	        if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
	        	sWhere.append(" AND BB.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
	        if (!KJFUtil.isEmpty(scNAME))
	        	sWhere.append(" AND BB.NAME LIKE '%" + scNAME + "%'");
	        //sWhere.append(" AND BB.STA_CHG_CLASS_CODE = 'R00001'");
	        sWhere.append(" AND BB.SIDO_CODE = '" + scSIDO_CODE + "' ");
	        sWhere.append(" AND BB.C_COM_DT IS NULL ");
	    	
	    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        }
        else if(scworkMode.equalsIgnoreCase("MOT"))
        {
        	String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
            String scCHGBRE_SEQ = vl.getValueAsString("scCHGBRE_SEQ");
            
        	sQuery.append(" SELECT * FROM PT_R_MOT_STE ");
        	sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        	sWhere.append(" AND   CHGBRE_SEQ = '" + scCHGBRE_SEQ + "' ");
        	
        	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        }
        request.setAttribute("dl", dl);  

        return next;
    }
}