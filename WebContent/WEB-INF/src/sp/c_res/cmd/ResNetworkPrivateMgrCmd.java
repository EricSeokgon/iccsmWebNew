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

public class ResNetworkPrivateMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ResNetworkPrivateMgrCmd() {
    }

    public ResNetworkPrivateMgrCmd(String next_url) {
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
        
        sQuery.append(" SELECT '0' AS CHECKER , MAX(TEL_TD) AS TEL_TD, MAX(ORG_NM) AS ORG_NM,MAX(SEQ) AS SEQ, \n");
        sQuery.append(" 	   MAX(M_BELOW) AS M_BELOW, MAX(USE) AS USE, MAX(REMARK) AS REMARK, \n");
        sQuery.append("  	   TO_NUMBER(MAX(NVL(TEL_TD,0)))+TO_NUMBER(MAX(NVL(M_BELOW,0))) AS TOTLE,  \n");
        sQuery.append("  	   MAX(SIDO_CODE) AS SIDO_CODE, MAX(SIGUNGU_CODE) AS SIGUNGU_CODE    \n");
        sQuery.append(" FROM PT_C_RES_PRIVATE RS  \n");
        sWhere.append(" WHERE 1=1  \n");
        sWhere.append("   AND SIDO_CODE = '"+SIDO_CODE+"' \n");
        
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        sidoQuery.append(" SELECT SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE LIKE '"+SIDO_CODE.substring(0,2)+"%' ORDER BY SEQ ");
        sEntity    = rDAO.select(sidoQuery.toString());    
        KJFMi.ReEnt2Ds(dl,sEntity,"output2");
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
