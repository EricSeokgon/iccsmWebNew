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

public class RegOnlyLineNetMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegOnlyLineNetMgrCmd() {
    }

    public RegOnlyLineNetMgrCmd(String next_url) {
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
                
        sQuery.append(" SELECT MAX(SC.SIDO_NM) AS ORG_NM, COUNT(JOINT_ORG_NUM) AS JOINT_ORG_NUM,OL.SIDO_CODE, \n");
        sQuery.append("        '-' AS ITEM_NM, '-' AS JOINT_CIR, '-' AS JOINT_DT, SUM(LINE_QTT) AS LINE_QTT    \n");
        sQuery.append("   FROM PT_C_RES_ONLY_LINE OL, PT_SIDO_CODE SC       \n");
        sWhere.append("  WHERE OL.SIDO_CODE = SC.AREA_CODE   \n");
        gWhere.append(" GROUP BY OL.SIDO_CODE  \n");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
