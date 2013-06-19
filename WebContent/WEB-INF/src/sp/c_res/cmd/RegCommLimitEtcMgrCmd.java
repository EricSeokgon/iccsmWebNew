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

public class RegCommLimitEtcMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegCommLimitEtcMgrCmd() {
    }

    public RegCommLimitEtcMgrCmd(String next_url) {
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
                
        sQuery.append(" SELECT MAX(ORG_NM) AS ORG_NM,SUM(PGP_CAF) AS PGP_CAF,SUM(PGP_PMS) AS PGP_PMS,SUM(NBS_4_CAF) AS NBS_4_CAF,SUM(NBS_4_PMS) AS NBS_4_PMS,  \n");
        sQuery.append("        SUM(NBS_6_CAF) AS NBS_6_CAF,SUM(NBS_6_PMS) AS NBS_6_PMS,SUM(NBS_7_CAF) AS NBS_7_CAF,SUM(NBS_7_PMS) AS NBS_7_PMS,   \n");
        sQuery.append("        SUM(NBS_8_CAF) AS NBS_8_CAF,SUM(NBS_8_PMS) AS NBS_8_PMS,SUM(NBS_9_CAF) AS NBS_9_CAF,SUM(NBS_9_PMS) AS NBS_9_PMS,   \n");
        sQuery.append("        SUM(TBS_EXCH_CAF) AS TBS_EXCH_CAF,SUM(TBS_TECOM_PMS) AS TBS_TECOM_PMS,MAX(SIDO_CODE) AS SIDO_CODE,   \n");
        sQuery.append(" 	   SUM(NBS_4_CAF+NBS_6_CAF+NBS_7_CAF+NBS_8_CAF+NBS_9_CAF+NBS_6_CAF+NBS_7_CAF) NBS_T_CAF, SUM(TBS_TECOM_CAF) AS TBS_TECOM_CAF,  \n");
        sQuery.append(" 	   SUM(NBS_4_PMS+NBS_6_PMS+NBS_7_PMS+NBS_8_PMS+NBS_9_PMS+NBS_6_PMS+NBS_7_PMS) NBS_T_PMS, SUM(TBS_EXCH_PMS) AS TBS_EXCH_PMS, \n");
        sQuery.append(" 	   SUM(TBS_EXCH_CAF+TBS_EXCH_CAF) TBS_T_CAF,SUM(TBS_EXCH_PMS+TBS_EXCH_PMS) TBS_T_PMS,  \n");
        sQuery.append(" 	   SUM(NBS_4_CAF+NBS_6_CAF+NBS_7_CAF+NBS_8_CAF+NBS_9_CAF+NBS_6_CAF+NBS_7_CAF+TBS_EXCH_CAF+TBS_EXCH_CAF) TOTEL_CAF,  \n");
        sQuery.append(" 	   SUM(NBS_4_PMS+NBS_6_PMS+NBS_7_PMS+NBS_8_PMS+NBS_9_PMS+NBS_6_PMS+NBS_7_PMS+TBS_EXCH_PMS+TBS_EXCH_PMS) TOTEL_PMS  \n");
        sQuery.append("   FROM (   \n");
        sQuery.append(" 	  SELECT MAX(SC.SIDO_NM) AS ORG_NM, SUM(PGP_CAF) AS PGP_CAF, SUM(PGP_PMS) AS PGP_PMS,MAX(CL.SIDO_CODE) AS SIDO_CODE, \n");
        sQuery.append("              SUM(NBS_4_CAF) AS NBS_4_CAF, SUM(NBS_4_PMS) AS NBS_4_PMS, SUM(NBS_6_CAF) AS NBS_6_CAF,    \n");
        sQuery.append("           	 SUM(NBS_6_PMS) AS NBS_6_PMS, SUM(NBS_7_CAF) AS NBS_7_CAF, SUM(NBS_7_PMS) AS NBS_7_PMS,    \n");
        sQuery.append("           	 SUM(NBS_8_CAF) AS NBS_8_CAF, SUM(NBS_8_PMS) AS NBS_8_PMS, SUM(NBS_9_CAF) AS NBS_9_CAF,    \n");
        sQuery.append("           	 SUM(NBS_9_PMS) AS NBS_9_PMS, SUM(TBS_TECOM_CAF) AS TBS_TECOM_CAF, SUM(TBS_TECOM_PMS) AS TBS_TECOM_PMS,    \n");
        sQuery.append("           	 SUM(TBS_EXCH_CAF) AS TBS_EXCH_CAF, SUM(TBS_EXCH_PMS) AS TBS_EXCH_PMS    \n");
        sQuery.append("         FROM PT_C_RES_COMM_LIMIT CL, PT_SIDO_CODE SC       \n");
        sWhere.append("  	   WHERE CL.SIDO_CODE = SC.AREA_CODE   \n");
        gWhere.append(" 	   GROUP BY CL.SIDO_CODE  \n");
        gWhere.append("    )  \n");
        
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
