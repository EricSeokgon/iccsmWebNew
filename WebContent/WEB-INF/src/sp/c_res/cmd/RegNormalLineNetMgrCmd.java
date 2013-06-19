package sp.c_res.cmd;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;

public class RegNormalLineNetMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegNormalLineNetMgrCmd() {
    }

    public RegNormalLineNetMgrCmd(String next_url) {
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
        StringBuilder gWhere = new StringBuilder();
                
        sQuery.append(" SELECT MAX(SC.SIDO_NM) AS ORG_NM,SUM(NOR_TEL) AS NOR_TEL,SUM(DID) AS DID,MAX(NL.SIDO_CODE) AS SIDO_CODE,  \n");
        sQuery.append("        SUM(DOD_INSIDE) AS DOD_INSIDE, SUM(DOD_SINGLE) AS DOD_SINGLE, '-' AS REMARK,   \n");
        sQuery.append("        TO_NUMBER(SUM(NOR_TEL)+SUM(DID)+SUM(DOD_INSIDE)+SUM(DOD_SINGLE)) AS TOTAL_CNT  \n");
        sQuery.append("   FROM PT_C_RES_NORMAL_LINE NL, PT_SIDO_CODE SC  \n");
        sWhere.append("  WHERE NL.SIDO_CODE = SC.AREA_CODE   \n");
        gWhere.append("  GROUP BY NL.SIDO_CODE  \n");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
