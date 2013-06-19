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

public class RegMobilePhoneComMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegMobilePhoneComMgrCmd() {
    }

    public RegMobilePhoneComMgrCmd(String next_url) {
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
                
        sQuery.append(" SELECT ORG_NM,SKT_QTT,SKT_AOM,KTF_QTT,KTF_AOM,LGT_QTT,LGT_AOM,QTT_010,AOM_010, \n");
        sQuery.append(" 	   SKT_QTT+KTF_QTT+LGT_QTT+QTT_010 AS SUM_QTT ,  \n");
        sQuery.append(" 	   SKT_AOM+KTF_AOM+LGT_AOM+AOM_010 AS SUM_AOM,SIDO_CODE  \n");
        sQuery.append(" FROM(  \n");
        sQuery.append(" 	SELECT MAX(SC.SIDO_NM) AS ORG_NM,SUM(SKT_QTT) AS SKT_QTT,SUM(SKT_AOM) AS SKT_AOM, \n");
        sQuery.append("        	   SUM(KTF_QTT) AS KTF_QTT, SUM(KTF_AOM) AS KTF_AOM, SUM(LGT_QTT) AS LGT_QTT,    \n");
        sQuery.append("		   	   SUM(LGT_AOM) AS LGT_AOM, SUM(QTT_010) AS QTT_010, SUM(AOM_010) AS AOM_010,MAX(MP.SIDO_CODE) AS SIDO_CODE    \n");
        sQuery.append("   	  FROM PT_C_RES_MOBILE_PHONE MP, PT_SIDO_CODE SC       \n");
        sWhere.append("  	 WHERE MP.SIDO_CODE = SC.AREA_CODE   \n");
        gWhere.append(" 	 GROUP BY MP.SIDO_CODE  \n");
        gWhere.append(" )  \n");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString() + gWhere.toString());    	
    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
