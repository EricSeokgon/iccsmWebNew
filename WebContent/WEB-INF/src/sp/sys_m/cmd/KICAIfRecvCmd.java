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

public class KICAIfRecvCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public KICAIfRecvCmd() {
    }

    public KICAIfRecvCmd(String next_url) {
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
    	
    	String scMODE = vl.getValueAsString("scMODE");
    		
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	if (scMODE.equalsIgnoreCase("MASTER"))
    	{
    		String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        	String scDATE1 = vl.getValueAsString("scDATE1");
        	String scDATE2 = vl.getValueAsString("scDATE2");
        	
    		sQuery.append(" SELECT '0' AS CHECKER, PT_RECV.TB_NM, PT_RECV.SEQ, PT_RECV.COI_WRT_NUM, ");
    		sQuery.append(" PT_RECV.SIDO_CODE, PT_RECV.MANA_NUM, PT_R.NAME, ");
    		sQuery.append(" REPLACE(SUBSTR(PT_RECV.INS_DT, 0, 10), '-', '') AS INS_DT,  ");
    		sQuery.append(" CASE TB_NM WHEN 'PT_TMP_ENGINEER_CHANGE' THEN '기술자변경' ");
    		sQuery.append(" WHEN 'PT_TMP_REP_CHANGE' THEN '대표자변경' ");
    		sQuery.append(" WHEN 'PT_TMP_NAME_CHANGE' THEN '상호변경' ");
    		sQuery.append(" WHEN 'PT_TMP_ADDR_CHANGE' THEN '주소지변경' ");
    		sQuery.append(" WHEN 'PT_TMP_WORK_CAPABILITY' THEN '시공능력평가' ");
    		sQuery.append(" WHEN 'PT_TMP_WORK_RESULTS' THEN '공사실적' ");
    		sQuery.append(" WHEN 'PT_TMP_CAPITAL_CHANGE' THEN '자본금변경' ");
    		sQuery.append(" END AS WORK_CLASS ");
    		sQuery.append(" FROM   PT_TMP_RECEIVE_KEY PT_RECV LEFT JOIN PT_R_COMPANY_MASTER PT_R ");
    		sQuery.append(" ON PT_RECV.COI_WRT_NUM = PT_R.COI_WRT_NUM AND PT_RECV.MANA_NUM = PT_R.MANA_NUM ");
    		
    		sWhere.append(" WHERE 1 = 1 ");
    		sWhere.append(" AND PT_RECV.SIDO_CODE = '" + scSIDO_CODE + "'");
    		sWhere.append(" AND REPLACE(SUBSTR(PT_RECV.INS_DT, 0, 10), '-', '') BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "' ");
    		sWhere.append(" GROUP BY PT_RECV.SEQ, PT_RECV.TB_NM, PT_RECV.SEQ, PT_RECV.COI_WRT_NUM, ");
    		sWhere.append(" PT_RECV.SIDO_CODE, PT_RECV.MANA_NUM, PT_R.NAME, PT_RECV.INS_DT ");
    		
    		rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
        	KJFMi.ReEnt2Ds(dl,rEntity,"output");
        	
        	request.setAttribute("dl", dl);
    	}
    	else if (scMODE.equalsIgnoreCase("DETAIL"))
    	{
    		String scSEQ = vl.getValueAsString("scSEQ");
    		String scTB_NM = vl.getValueAsString("scTB_NM");
    		String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
    		String scMANA_NUM = vl.getValueAsString("scMANA_NUM");
    		
    		sQuery.append(" SELECT * ");
			sQuery.append(" FROM PT_R_COMPANY_MASTER ");
			sWhere.append(" WHERE 1 = 1 ");
			sWhere.append(" AND COI_WRT_NUM = '" + scCOI_WRT_NUM + "' ");
			sWhere.append(" AND C_COM_DT IS NULL ");
			//sWhere.append(" AND MANA_NUM = '" + scMANA_NUM + "' ");

			rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
        	KJFMi.ReEnt2Ds(dl,rEntity,"output");
        	
        	sQuery.delete(0, sQuery.length());
        	sWhere.delete(0, sWhere.length());
        	
    		if (scTB_NM.equalsIgnoreCase("PT_TMP_REP_CHANGE"))
    		{
            	sQuery.append(" SELECT PT_RECV.REP_NM_KOR, PT_RECV.REP_NM_HAN, PT_RECV.REP_SSN1, ");
            	sQuery.append(" PT_RECV.REP_SSN2, PT_RECV.CHG_STA_DT, '대표자변경' AS WORK_CLASS ");
            	sQuery.append(" FROM PT_TMP_REP_CHANGE PT_RECV ");
            	sWhere.append(" WHERE 1 = 1 ");
            	sWhere.append(" AND PT_RECV.SEQ = '" + scSEQ + "' ");
            	
            	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
            	KJFMi.ReEnt2Ds(dl,rEntity,"output2");
            	
            	request.setAttribute("dl", dl);
    		}
    		else if (scTB_NM.equalsIgnoreCase("PT_TMP_NAME_CHANGE"))
    		{
            	sQuery.append(" SELECT PT_RECV.NAME, PT_RECV.CHG_STA_DT, '상호변경' AS WORK_CLASS ");
            	sQuery.append(" FROM PT_TMP_NAME_CHANGE PT_RECV ");
            	sWhere.append(" WHERE 1 = 1 ");
            	sWhere.append(" AND PT_RECV.SEQ = '" + scSEQ + "' ");
            	
            	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
            	KJFMi.ReEnt2Ds(dl,rEntity,"output2");
            	
            	request.setAttribute("dl", dl);
    		}
    		else if (scTB_NM.equalsIgnoreCase("PT_TMP_ADDR_CHANGE"))
    		{
            	sQuery.append(" SELECT PT_RECV.CHG_STA_DT, '소재지변경' AS WORK_CLASS, ");
            	sQuery.append(" PT_RECV.ADDR_POST_NUM, PT_RECV.ADDR_ADDR, PT_RECV.ADDR_DETAIL_ADDR, ");
            	sQuery.append(" PT_RECV.OFFICE_AREA, PT_RECV.ADDR_TEL_NUM, PT_RECV.ADDR_FAX_NUM ");
            	sQuery.append(" FROM PT_TMP_ADDR_CHANGE PT_RECV ");
            	sWhere.append(" WHERE 1 = 1 ");
            	sWhere.append(" AND PT_RECV.SEQ = '" + scSEQ + "' ");
            	
            	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
            	KJFMi.ReEnt2Ds(dl,rEntity,"output2");
            	
            	request.setAttribute("dl", dl);
    		}
    		else if (scTB_NM.equalsIgnoreCase("PT_TMP_ENGINEER_CHANGE"))
    		{
    			String scTMP_WRT_NUM = rEntity.getValue(0, "TMP_WRT_NUM");
    			
    			sQuery.append(" SELECT '기술자변경' AS WORK_CLASS, AA.*, AA.ENGINEER_SSN1 || AA.ENGINEER_SSN2 AS TMPSSN ");
    	        sQuery.append(" FROM PT_TMP_ENGINEER_CHANGE AA  ");
    	        sWhere.append(" WHERE 1 = 1 ");
    	        sWhere.append(" AND AA.SEQ = '" + scSEQ + "'");
            	
            	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
            	KJFMi.ReEnt2Ds(dl,rEntity,"output2");
            	
            	sQuery.delete(0, sQuery.length());
            	sWhere.delete(0, sWhere.length());
    			
    			sQuery.append(" SELECT '0' AS CHECKER, AA.*, DD.NM_KOR, DD.CARE_BOOK_ISSUE_NUM, DD.ENGINEER_GRADE, ");
    	        sQuery.append(" 	   DD.CARE_BOOK_VAL_START_DT, DD.CARE_BOOK_VAL_END_DT, DD.TMP_GRADE, AA.ENGINEER_SSN1 || AA.ENGINEER_SSN2 AS TMPSSN ");
    	        sQuery.append(" FROM PT_R_ENGINEER_CHANGE AA LEFT JOIN   ");
    	        sQuery.append(" 	 (SELECT BB.NM_KOR, BB.CARE_BOOK_ISSUE_NUM, BB.ENGINEER_GRADE, ");
    	        sQuery.append(" 	 BB.CARE_BOOK_VAL_START_DT, BB.CARE_BOOK_VAL_END_DT, ");
    	        sQuery.append(" 	 PC.CODE_NAME AS TMP_GRADE, BB.ENGINEER_SSN1, BB.ENGINEER_SSN2 ");
    	        sQuery.append(" 	 FROM PT_R_ENGINEER_MASTER BB ");
    	        sQuery.append(" 	 LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'ENGCLASS') PC ");
    	        sQuery.append(" 	 ON BB.ENGINEER_GRADE = PC.CODE) DD ");
    	        sQuery.append(" 	 ON AA.ENGINEER_SSN1 = DD.ENGINEER_SSN1 AND AA.ENGINEER_SSN2 = DD.ENGINEER_SSN2 ");
    	        sWhere.append(" WHERE 1 = 1 ");
    	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
    	        sWhere.append(" AND AA.RET_YMD IS NULL ");
            	
            	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
            	KJFMi.ReEnt2Ds(dl,rEntity,"output3");
            	
            	request.setAttribute("dl", dl);
    		}
    	}  

        return next;
    }


}