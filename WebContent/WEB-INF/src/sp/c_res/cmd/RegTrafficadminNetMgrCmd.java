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

public class RegTrafficadminNetMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegTrafficadminNetMgrCmd() {
    }

    public RegTrafficadminNetMgrCmd(String next_url) {
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
                
        sQuery.append(" SELECT MAX(SC.SIDO_NM) AS ORG_NM,ROUND(AVG(LINE_QTT),0) AS LINE_QTT,ROUND(AVG(SIDO),0) AS SIDO,ROUND(AVG(POS),0) AS POS,TA.SIDO_CODE,   \n");
        sQuery.append("        ROUND(AVG(FINISH),0) AS FINISH, ROUND(AVG(TIME),2) AS TIME,ROUND(AVG(TRAFFIC_ERL),2) AS TRAFFIC_ERL,ROUND(AVG(TRAFFIC_LINE),2) AS TRAFFIC_LINE, '-' AS REMARK    \n");
        sQuery.append("   FROM PT_C_RES_TRAFFIC_ADMIN TA, PT_SIDO_CODE SC       \n");
        sWhere.append("  WHERE TA.SIDO_CODE = SC.AREA_CODE   \n");
        gWhere.append(" GROUP BY TA.SIDO_CODE  \n");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
