/**
 * 파일명   : ReacapChgListMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.st.cmd;

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

public class ReacapChgListMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ReacapChgListMgrCmd () {
    }

    public  ReacapChgListMgrCmd (String next_url) {
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
		String scREP_NM = vl.getValueAsString( "scREP_NM" );
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scNAME = vl.getValueAsString("scNAME");
       // String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");

        //String scCLOSE = vl.getValueAsString("scCLOSE");
        
//        sQuery.append(" SELECT PT_M.TMP_WRT_NUM, PT_M.NAME, PT_M.REP_NM_KOR, PT_M.MANA_NUM, ");
//        sQuery.append(" DECODE(PT_M.C_COM_DT, NULL, '', '폐업') AS C_COM_DT, ");
//        sQuery.append(" PT_M.WRT_DT, PT_M.COI_WRT_NUM ");
//        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_M ");
       /* 
        sQuery.append(" SELECT PT_H.COI_WRT_NUM, PT_H.CHG_DT, PT_H.CHGBRE_SEQ, PT_R.NAME, PT_H.TMP_WRT_NUM,PT_C.CODE_NAME, PT_H.WRT_DT,PT_H.REA_CAP ");
        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_H LEFT JOIN PT_R_COMPANY_MASTER PT_R ON PT_H.TMP_WRT_NUM = PT_R.TMP_WRT_NUM ");
        sQuery.append(" LEFT JOIN  (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGDIV')  PT_C  ");
        sQuery.append(" ON PT_H.STA_CHG_CLASS_CODE = PT_C.CODE   ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND PT_H.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
        sWhere.append(" AND PT_C.CODE='R00008' ");
        sWhere.append(" AND PT_C.CODE is not null ");
    	sWhere.append( " AND (PT_H.CHG_DT BETWEEN '" + scDATE1 + "' " );
		sWhere.append( " AND '" + scDATE2 + "') " );
		*/
        sQuery.append(" select a.COI_WRT_NUM, b.name, a.WRT_CHG_DT, a.CHG_STA_DT, FNGetPrevReaCap(a.COI_WRT_NUM, a.WRT_CHG_DT ) prev_rea_cap, a.REA_CAP");
        sQuery.append(" from PT_TMP_CAPITAL_CHANGE a, PT_R_company_master b  ");
        sQuery.append(" where 1=1 ");
        sQuery.append(" and a.seq in(  ");
        sQuery.append(" select max(seq) seq from PT_TMP_CAPITAL_CHANGE  ");
        sQuery.append(" where cud_flag !='D' ");
        sQuery.append(" group by   SIDO_CODE, COI_WRT_NUM , WRT_CHG_DT)  ");
        sQuery.append(" and a.coi_wrt_num =b.coi_wrt_num  ");
   
        
    	sWhere.append( " AND (a.CHG_STA_DT BETWEEN '" + scDATE1 + "' " );
		sWhere.append( " AND '" + scDATE2 + "') " );
		
        if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
        	sWhere.append(" AND a.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
        
        if (!KJFUtil.isEmpty(scNAME))
        	sWhere.append(" AND b.NAME LIKE '%" + scNAME + "%'");
       
        if (!KJFUtil.isEmpty(scSIDO_CODE) && !scSIDO_CODE.equalsIgnoreCase("ALL"))
        	sWhere.append(" AND b.SIDO_CODE = '" + scSIDO_CODE + "'");
       
        if (!KJFUtil.isEmpty( scREP_NM ) )
        	
		sWhere.append( "AND b.REP_NM_KOR LIKE '%" + scREP_NM + "%' " );
        sWhere.append( "ORDER BY a.COI_WRT_NUM" );
        
        /*
        if (!KJFUtil.isEmpty(scCLOSE)) {
        	if( scCLOSE.equals( "A" ) )
        		sWhere.append(" AND C_COM_DT IS NULL");
        	else if( scCLOSE.equals( "C" ) )
        		sWhere.append(" AND C_COM_DT IS NOT NULL");
        }
  */  	
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}