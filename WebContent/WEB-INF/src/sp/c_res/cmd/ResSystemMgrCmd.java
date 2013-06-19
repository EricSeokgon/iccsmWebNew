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

public class ResSystemMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ResSystemMgrCmd() {
    }

    public ResSystemMgrCmd(String next_url) {
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
        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        
        sQuery.append(" SELECT MAX(SC.SIDO_NM) AS ORG_NM, '-' AS ITEM_NM, SUM(INLINE_NUM) AS INLINE_NUM, \n");
        sQuery.append("        SUM(OUTLINE_CH_NUM) AS OUTLINE_CH_NUM,SUM(OUTLINE_E1_NUM) AS OUTLINE_E1_NUM,'-' AS INSTAL_DT,  \n");
        sQuery.append("         SUM(ESTAB_AOM) AS ESTAB_AOM, '' AS REMARK,RS.SIDO_CODE  \n");
        sQuery.append("   FROM PT_C_RES_SWIT RS, PT_SIDO_CODE SC   \n");
        sWhere.append(" WHERE RS.SIDO_CODE = SC.AREA_CODE  \n");
        gWhere.append(" GROUP BY RS.SIDO_CODE  \n");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
