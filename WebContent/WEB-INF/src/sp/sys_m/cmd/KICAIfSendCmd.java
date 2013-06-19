/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.sys_m.cmd;

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

public class KICAIfSendCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public KICAIfSendCmd() {
    }

    public KICAIfSendCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
    	String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
    	String scDATE1 = vl.getValueAsString("scDATE1");
    	String scDATE2 = vl.getValueAsString("scDATE2");
    	String scSND_CLASS = vl.getValueAsString("scSND_CLASS");
    		
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	sQuery.append(" SELECT	PT_H.TMP_WRT_NUM, PT_H.CHGBRE_SEQ, PT_H.STA_CHG_CLASS_CODE, ");
    	sQuery.append(" 		PT_C.CODE_NAME AS STA_CHG_CLASS_NAME, PT_H.CHG_DT, 		PT_H.NAME, ");
    	sQuery.append(" 		PT_H.RECV_NUM, DECODE(PT_H.SND_STE, 'O', '송신', '') AS TMPSND_STE, ");
    	sQuery.append(" 		PT_H.SND_STE, PT_H.SND_DT, '0' AS CHECKER, PT_H.COI_WRT_NUM ");
    	sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_H LEFT JOIN ");
    	sQuery.append(" 	 (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGDIV') PT_C ");
    	sQuery.append(" 	 ON PT_H.STA_CHG_CLASS_CODE = PT_C.CODE ");
    	sWhere.append(" WHERE 1 = 1 ");
    	sWhere.append(" AND	PT_H.STA_CHG_CLASS_CODE IN ('R00001', 'R00002', 'R00004', 'R00005', 'R00006', 'R00011') ");
    	sWhere.append(" AND	PT_H.MOT_STE = 'STD003' ");
   		sWhere.append(" AND PT_H.SIDO_CODE = '" + scSIDO_CODE + "' ");
    	if (!KJFUtil.isEmpty(scSND_CLASS) && !scSND_CLASS.equalsIgnoreCase("A"))
    		sWhere.append(" AND PT_H.SND_STE = '" + scSND_CLASS + "' ");		
    	sWhere.append(" AND PT_H.CHG_DT BETWEEN '" + scDATE1 + "' ");
    	sWhere.append(" 	AND '" + scDATE2 + "' ");
    	
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
    	KJFMi.ReEnt2Ds(dl,rEntity,"output");
    	
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());
    	
    	sQuery.append(" SELECT 	'0' AS CHECKER, PT_R.COI_WRT_NUM, PT_M.TMP_WRT_NUM, PT_M.WRT_NUM, PT_R.NAME, PT_C.CODE_NAME AS TMPDISPO_CONT, PT_M.SND_STE, ");
    	sQuery.append(" 	   	PT_M.DISPO_CONT, PT_M.DISPO_DT, DECODE(PT_M.SND_STE, 'O', '송신', '') AS TMPSND_STE, PT_M.SND_DT ");
    	sQuery.append(" FROM   	PT_M_MASTER PT_M LEFT JOIN PT_R_COMPANY_MASTER PT_R ");
    	sQuery.append(" 		ON PT_M.TMP_WRT_NUM = PT_R.TMP_WRT_NUM ");
    	sQuery.append(" 		LEFT JOIN ");
    	sQuery.append(" 	 	(SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'PTMPRO') ");
    	sQuery.append(" 	   PT_C ON PT_M.DISPO_CONT = PT_C.CODE ");
    	sWhere.append(" WHERE 1 = 1 ");
    	sWhere.append(" AND	PT_M.MOT_STE = 'C00002' ");
    	if (!KJFUtil.isEmpty(scSIDO_CODE))
    		sWhere.append(" AND PT_M.SIDO_CODE = '" + scSIDO_CODE + "' ");
    	if (!KJFUtil.isEmpty(scSND_CLASS) && !scSND_CLASS.equalsIgnoreCase("A"))
    		sWhere.append(" AND PT_M.SND_STE = '" + scSND_CLASS + "' ");    		
    	sWhere.append(" AND PT_M.DISPO_DT BETWEEN '" + scDATE1 + "' ");
    	sWhere.append(" 	AND '" + scDATE2 + "' ");
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
        KJFMi.ReEnt2Ds(dl,rEntity,"output2");
    	 
        request.setAttribute("dl", dl);  

        return next;
    }


}