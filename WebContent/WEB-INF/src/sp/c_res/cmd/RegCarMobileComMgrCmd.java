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

public class RegCarMobileComMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegCarMobileComMgrCmd() {
    }

    public RegCarMobileComMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData();
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        StringBuilder gWhere = new StringBuilder();
                
        sQuery.append(" SELECT MAX(SC.SIDO_NM) AS ORG_NM,'-' AS FIR_COMMIT_DT, \n");
        sQuery.append("        '-' AS WATT, '-' AS USE, '-' AS REMARK, SUM(QTT) AS QTT, MAX(SIDO_CODE) AS SIDO_CODE    \n");
        sQuery.append("   FROM PT_C_RES_CAR_MOBILE_SY MS, PT_SIDO_CODE SC       \n");
        sWhere.append("  WHERE MS.SIDO_CODE = SC.AREA_CODE   \n");
        gWhere.append(" GROUP BY MS.SIDO_CODE  \n");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
