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

public class RepAMListMgrCmd implements KJFCommand {
	 
		private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public RepAMListMgrCmd() {
	    }

	    public RepAMListMgrCmd(String next_url) {
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
	        
	        
	        String scCOM_NAME = vl.getValueAsString("scNAME");
	        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
			String scREP_NM = vl.getValueAsString( "scREP_NM");
			String scCOI_WRT_NUM = vl.getValueAsString( "scCOI_WRT_NUM");
			String scSSN = vl.getValueAsString( "scSSN");
			String scCOM_NUM = vl.getValueAsString( "scCOM_NUM");
	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        sQuery.append(" SELECT  '0' AS CHECKER, SIDO_NM_CUT, PT_C.NAME, PT_C.COM_NUM, PT_C.REP_NM_KOR, PT_C.REP_SSN1||'-'|| PT_C.REP_SSN2 AS SSN, to_char(ADD_MONTHS(fn_date(dispo_dt, 'yyyymmdd'),24), 'yyyymmdd') dispo_dt2,PT_M.*, ");
	        sQuery.append(" PT_C1.CODE_NAME AS TMPD_PER_CODE,   DECODE(PT_M.DISPO_CONT2,'',PT_C2.CODE_NAME,PT_C2.CODE_NAME ||' 및 '||PT_C2_2.CODE_NAME)  AS TMPDISPO_CONT, PT_C3.CODE_NAME AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT ");
	        sQuery.append(" FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M ");
	        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM) ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_M.DISPO_CONT = PT_C2.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMPRO' )PT_C2_2 ON PT_M.DISPO_CONT2 = PT_C2_2.CODE ");	        
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMSTE' )PT_C3 ON PT_M.MOT_STE = PT_C3.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMCONT' )PT_C4 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE ");
	        sQuery.append(" LEFT JOIN  PT_SIDO_CODE PT_S ON PT_C.SIDO_CODE = PT_S.AREA_CODE ");
	        sWhere.append(" WHERE 	1 = 1 ");
	        sWhere.append(" AND to_char(ADD_MONTHS(dispo_dt,24), 'yyyymmdd') > to_char(sysdate,'yyyymmdd') ");
	        sWhere.append(" AND PT_M.PUNISHMENT_AGENCY !='TEST시도' ");
	        
	        if(!KJFUtil.isEmpty(scCOM_NAME))
	        	sWhere.append(" AND     PT_C.NAME LIKE '%" + scCOM_NAME + "%' ");
	       						
			if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
				sWhere.append( " AND PT_C.COI_WRT_NUM LIKE '%" + scCOI_WRT_NUM + "%' " );
			
			if( !KJFUtil.isEmpty( scREP_NM ) )
				sWhere.append( " AND PT_C.REP_NM_KOR LIKE '%" + scREP_NM + "%' " );
			
			if( !KJFUtil.isEmpty( scCOM_NUM ) )
				sWhere.append( " AND PT_C.COM_NUM = '" + scCOM_NUM + "' " );
			
	        if (!KJFUtil.isEmpty( scSSN ) )
	        	sWhere.append( " AND PT_C.REP_SSN1 = '" + scSSN.substring(0, 6) + "' " );
	        if (!KJFUtil.isEmpty( scSSN ) )
	        	sWhere.append( " OR PT_C.REP_SSN2 = '" + scSSN.substring(7, 13) + "' " );
			
			if (!KJFUtil.isEmpty(scSIDO_CODE) && !scSIDO_CODE.equalsIgnoreCase("ALL"))
	        	sWhere.append(" AND PT_C.SIDO_CODE = '" + scSIDO_CODE + "' ");
			
			sWhere.append(" AND PT_M.DISPO_CONT = 'M00001'  order by dispo_dt desc ");
			
	    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	

	        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
