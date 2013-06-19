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

public class RegListOpenMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegListOpenMgrCmd() {
    }

    public RegListOpenMgrCmd(String next_url) {
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
        
        String scDATE1 = vl.getValueAsString( "scDATE1" );
		String scDATE2 = vl.getValueAsString( "scDATE2" );
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scNAME = vl.getValueAsString("scNAME");
        String scREP_NM = vl.getValueAsString("scREP_NM");
        
        
//        sQuery.append(" SELECT PT_M.TMP_WRT_NUM, PT_M.NAME, PT_M.REP_NM_KOR, PT_M.MANA_NUM, ");
//        sQuery.append(" DECODE(PT_M.C_COM_DT, NULL, '', '폐업') AS C_COM_DT, ");
//        sQuery.append(" PT_M.WRT_DT, PT_M.COI_WRT_NUM ");
//        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_M ");
        
        sQuery.append(" SELECT PT_M.TMP_WRT_NUM, PT_M.NAME, decode(pt_rr.NM_KOR,'',PT_M.REP_NM_KOR,PT_M.REP_NM_KOR||','||pt_rr.NM_KOR) as REP_NM_KOR,  '('||SUBSTR(PT_M.ADDR_POST_NUM,1,3) || '-' ||SUBSTR(PT_M.ADDR_POST_NUM,4,3)||')'||PT_M.ADDR_ADDR||PT_M.ADDR_DETAIL_ADDR AS ADDR_ADDR, PT_M.ADDR_TEL_NUM, PT_M.ADDR_FAX_NUM, ");
        //sQuery.append(" DECODE(PT_M.C_COM_DT, NULL, PT_C2.CODE_NAME, '폐업'|| DECODE(PT_C2.CODE_NAME,NULL,'','('||PT_C2.CODE_NAME||')') )  AS C_COM_DT, ");
        sQuery.append(" DECODE(PT_S.SIDO_NM, '서울특별시', '서울', '부산광역시', '부산','울산광역시','울산 ','대구광역시', '대구','경상남도' , '경남', '인천광역시', '인천', " +
        		      "'경기도', '경기' ,'경상북도','경북','광주광역시','광주','전라남도','전남'," +
        		      "'대전광역시','대전','충청남도','충남','전라북도','전북','강원도','강원','충청북도','충북','제주특별자치도','제주','세종특별자치시','세종' ) AS SIDO_NM,");
        sQuery.append(" PT_M.WRT_DT, PT_M.COI_WRT_NUM, PT_M.C_COM_DT, BUSS_YMD ");
       // sQuery.append(" FROM (PT_R_COMPANY_MASTER PT_M LEFT JOIN PT_M_MASTER PT_MM ON PT_M.TMP_WRT_NUM = PT_MM.TMP_WRT_NUM)");
        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_M ");
        sQuery.append(" LEFT JOIN  PT_SIDO_CODE PT_S ON PT_M.SIDO_CODE = PT_S.AREA_CODE ");
        sQuery.append(" left join PT_R_REFFER pt_rr on pt_rr.TMP_WRT_NUM=PT_M.TMP_WRT_NUM AND (pt_rr.POS_CLASS='P1' OR   pt_rr.POS_CLASS='P4') AND NVL(pt_rr.DEL_YN,'N') != 'Y' AND PT_M.REP_NM_KOR!=pt_rr.NM_KOR ");
        //sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_MM.DISPO_CONT = PT_C2.CODE ");
        sQuery.append(" WHERE 1=1 ");
        sQuery.append(" AND (PT_M.C_COM_DT IS NULL AND TRANS_UNION_PROC IS NULL AND TRANS_UNION_PARENT IS NULL )");
	      
		
        //sWhere.append(" WHERE 1 = 1 ");
        if (!KJFUtil.isEmpty(scDATE1) || !KJFUtil.isEmpty(scDATE2))
            sWhere.append(" AND(PT_M.WRT_DT" + " BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "')  ");
        if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
        	sWhere.append(" AND PT_M.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
        if (!KJFUtil.isEmpty(scNAME))
        	sWhere.append(" AND PT_M.NAME LIKE '%" + scNAME + "%'");
        if (!KJFUtil.isEmpty(scSIDO_CODE) && !scSIDO_CODE.equalsIgnoreCase("ALL"))
        	sWhere.append(" AND PT_M.SIDO_CODE = '" + scSIDO_CODE + "'");
        if (!KJFUtil.isEmpty(scREP_NM))
        	sWhere.append(" AND PT_M.REP_NM_KOR LIKE '%" + scREP_NM + "%'");
        
        sWhere.append(" order by COI_WRT_NUM ");
        
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}