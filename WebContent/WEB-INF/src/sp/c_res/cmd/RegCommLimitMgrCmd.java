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

public class RegCommLimitMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
     
    public RegCommLimitMgrCmd() {
    }

    public RegCommLimitMgrCmd(String next_url) {
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
        
        sQuery.append("	SELECT * FROM (   \n");
        sQuery.append(" SELECT '0' AS CHECKER ,MAX(NBS_4_CAF) AS NBS_4_CAF,MAX(NBS_6_CAF) AS NBS_6_CAF, ");
        sQuery.append(" 	   MAX(NBS_7_CAF) AS NBS_7_CAF,MAX(NBS_8_CAF) AS NBS_8_CAF,MAX(NBS_9_CAF) AS NBS_9_CAF,  \n");
        sQuery.append(" 	   MAX(NBS_4_PMS) AS NBS_4_PMS,MAX(NBS_6_PMS) AS NBS_6_PMS,MAX(NBS_7_PMS) AS NBS_7_PMS,  \n");
        sQuery.append(" 	   MAX(NBS_8_PMS) AS NBS_8_PMS,MAX(NBS_9_PMS) AS NBS_9_PMS,MAX(PGP_CAF) AS PGP_CAF,MAX(SEQ) AS SEQ,  \n");
        sQuery.append("		   MAX(TBS_TECOM_CAF) AS TBS_TECOM_CAF,MAX(TBS_TECOM_PMS) AS TBS_TECOM_PMS,MAX(TBS_EXCH_CAF) AS TBS_EXCH_CAF,MAX(TBS_EXCH_PMS) AS TBS_EXCH_PMS,			\n"); 
        sQuery.append(" 	   MAX(PGP_PMS) AS PGP_PMS,SUM(NBS_4_CAF+NBS_6_CAF+NBS_7_CAF+NBS_8_CAF+NBS_9_CAF) AS NBS_T_CAF,  \n");
        sQuery.append(" 	   SUM(NBS_4_PMS+NBS_6_PMS+NBS_7_PMS+NBS_8_PMS+NBS_9_PMS) AS NBS_T_PMS,MAX(SIDO_CODE) AS SIDO_CODE, MAX(SIGUNGU_CODE) AS SIGUNGU_CODE,  \n");
        sQuery.append(" 	   SUM(TBS_EXCH_CAF+TBS_TECOM_CAF) TBS_T_CAF,SUM(TBS_EXCH_PMS+TBS_TECOM_PMS) TBS_T_PMS,MAX(ORG_NM) AS ORG_NM,   \n");
        sQuery.append(" 	   SUM(PGP_CAF+NBS_4_CAF+NBS_6_CAF+NBS_7_CAF+NBS_8_CAF+NBS_9_CAF+TBS_EXCH_CAF+TBS_TECOM_CAF) TOTEL_CAF,  \n");
        sQuery.append(" 	   SUM(PGP_PMS+NBS_4_PMS+NBS_6_PMS+NBS_7_PMS+NBS_8_PMS+NBS_9_PMS+TBS_EXCH_PMS+TBS_TECOM_PMS) TOTEL_PMS   \n");
        sQuery.append(" FROM PT_C_RES_COMM_LIMIT CL    \n");
        sWhere.append(" WHERE SIDO_CODE = '"+SIDO_CODE+"'   \n");
        sWhere.append(" ) WHERE SIDO_CODE is not null  \n");
        
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        sidoQuery.append(" SELECT SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE LIKE '"+SIDO_CODE.substring(0,2)+"%' ORDER BY SEQ ");
        sEntity    = rDAO.select(sidoQuery.toString());   
        KJFMi.ReEnt2Ds(dl,sEntity,"output2");
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
