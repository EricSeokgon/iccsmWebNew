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

public class RegFixingFlagEtcMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegFixingFlagEtcMgrCmd() {
    }

    public RegFixingFlagEtcMgrCmd(String next_url) {
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
                
        sQuery.append(" SELECT MAX(SC.SIDO_NM) AS ORG_NM,'-' AS FIR_COMMIT_DT,SUM(RE_ST_QTT) AS RE_ST_QTT, \n");
        sQuery.append("        SUM(MO_ST_QTT) AS MO_ST_QTT, '-' AS WATT, '-' AS USE, '-' AS REMARK, FF.SIDO_CODE    \n");
        sQuery.append("   FROM PT_C_RES_FIXING_FLAG FF, PT_SIDO_CODE SC       \n");
        sWhere.append("  WHERE FF.SIDO_CODE = SC.AREA_CODE   \n");
        gWhere.append(" GROUP BY FF.SIDO_CODE  \n");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
