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

public class RegTrafficadminMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
     
    public RegTrafficadminMgrCmd() {
    }

    public RegTrafficadminMgrCmd(String next_url) {
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
        ReportEntity sEntity     = null;
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        StringBuilder sidoQuery = new StringBuilder();
        
        String SIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        
        sQuery.append(" SELECT '0' AS CHECKER ,TA.* ");
        sQuery.append(" FROM PT_C_RES_TRAFFIC_ADMIN TA");
        sWhere.append(" WHERE 1=1 ");
        sWhere.append("   AND SIDO_CODE = '"+SIDO_CODE+"' ");
        
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        sidoQuery.append(" SELECT SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE LIKE '"+SIDO_CODE.substring(0,2)+"%' ORDER BY SEQ ");
        sEntity    = rDAO.select(sidoQuery.toString());   
        KJFMi.ReEnt2Ds(dl,sEntity,"output2");
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
