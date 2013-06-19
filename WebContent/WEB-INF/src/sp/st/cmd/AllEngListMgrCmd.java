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

public class AllEngListMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public AllEngListMgrCmd () {
    }

    public  AllEngListMgrCmd (String next_url) {
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
        
    	String scREP_NM = vl.getValueAsString( "scREP_NM" );
		String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scNAME = vl.getValueAsString("scNAME");
        String scSSN = vl.getValueAsString("scSSN");
        
        sQuery.append(" select PT_S.SIDO_NM_CUT AS SiDO_NM, b.COI_WRT_NUM, b.name, a.TMP_FIELD, a.ENGINEER_NM, a.CARE_BOOK_ISSUE_NUM, a.ENGINEER_SSN1||'-'||a.ENGINEER_SSN2 as ENGINEER_SSN, a.EMPL_YMD, a.RET_YMD ");
        sQuery.append(" from PT_R_ENGINEER_CHANGE a, PT_R_company_master b  ");
        sQuery.append(" LEFT JOIN  PT_SIDO_CODE PT_S ON b.SIDO_CODE = PT_S.AREA_CODE ");
        sQuery.append(" WHERE 1=1 ");
        sQuery.append(" AND a.tmp_wrt_num =b.tmp_wrt_num ");
    	sWhere.append(" AND a.RET_YMD is null AND ENGINEER_NM is NOT null " );
		
		
        if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
        	sWhere.append(" AND b.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
        
        if (!KJFUtil.isEmpty(scNAME))
        	sWhere.append(" AND b.NAME LIKE '%" + scNAME + "%'");
       
        if (!KJFUtil.isEmpty(scSIDO_CODE) && !scSIDO_CODE.equalsIgnoreCase("ALL"))
        	sWhere.append(" AND b.SIDO_CODE = '" + scSIDO_CODE + "'");
       
        if (!KJFUtil.isEmpty( scREP_NM ) )
        	sWhere.append( " AND a.ENGINEER_NM LIKE '%" + scREP_NM + "%' " );
        
        if (!KJFUtil.isEmpty( scSSN ) )
        	sWhere.append( " AND a.ENGINEER_SSN1 = '" + scSSN.substring(0, 6) + "' " );
        if (!KJFUtil.isEmpty( scSSN ) )
        	sWhere.append( " OR a.ENGINEER_SSN2 = '" + scSSN.substring(7, 13) + "' " );
        
        sWhere.append( " ORDER BY b.COI_WRT_NUM , ENGINEER_SSN1 " );
  
        rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}
