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

public class ResIPTMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ResIPTMgrCmd() {
    }

    public ResIPTMgrCmd(String next_url) {
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
        
        sQuery.append(" SELECT MAX(SC.SIDO_NM) AS ORG_NM,'-' AS IPP_PDT,'-' AS IPP_ITEM_NM,SUM(IPP_ESTAB_AOM) AS IPP_ESTAB_AOM, \n");
        sQuery.append("        '-' AS IPP_INSTAL_DT, '-' AS IPM_PDT, '-' AS IPM_ITEM_NM,SIDO_CODE,  \n");
        sQuery.append("         SUM(IPM_QTT) AS IPM_QTT, SUM(IPM_ESTAB_AOM) AS IPM_ESTAB_AOM  \n");
        sQuery.append("   FROM PT_C_RES_IPT RI, PT_SIDO_CODE SC     \n");
        sWhere.append("  WHERE RI.SIDO_CODE = SC.AREA_CODE   \n");
        gWhere.append(" GROUP BY RI.SIDO_CODE  \n");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
