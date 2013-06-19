package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegRePublishMgrCCmd implements KJFCommand{
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegRePublishMgrCCmd() {
    }

    public RegRePublishMgrCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        String scCHECK = vl.getValueAsString("CHECK");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        //코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
         if (scCHECK.equalsIgnoreCase("TRUE"))
        {
        	sQuery.append(" SELECT RECV_NUM FROM PT_R_RE_DERIVERY_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append(" AND	SIDO_CODE = '" + scSIDO_CODE + "' ");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
         else if((scCHECK.equalsIgnoreCase("FALSE")))
        {
 	        //Master Table
         	sQuery.append(" SELECT * FROM PT_R_RE_DERIVERY_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' ");
         	sWhere.append(" AND	SIDO_CODE = '" + scSIDO_CODE + "' ");
 	        
         	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	        
 	        //Memo Table
 	        sQuery.append(" SELECT '0' AS CHECKER, A.* FROM PT_R_MEMO A ");
 	        sWhere.append(" WHERE 1 = 1 ");
 	        sWhere.append(" AND	RECV_NUM = '" + scRECV_NUM + "' \n");
 	       sWhere.append(" AND	SIDO_CODE = '" + scSIDO_CODE + "' ");
 	       	
 	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	       	//Deficit Table
	        sQuery.append(" SELECT PDEF.*, PDEF_CODE.CONT AS DEFI_CONT ");
	        sQuery.append(" FROM PT_R_DEFICIT PDEF LEFT JOIN (SELECT DEFI_CODE, CONT FROM PT_R_DEFICIT_CODE WHERE DEFI_GROUP = 'GUBU') PDEF_CODE ");
	        sQuery.append(" ON PDEF.DEFI_CODE = PDEF_CODE.DEFI_CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PDEF.RECV_NUM = '" + scRECV_NUM + "' ");
	        sWhere.append(" AND	PDEF.SIDO_CODE = '" + scSIDO_CODE + "' ");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
        }
        else if((scCHECK.equalsIgnoreCase("GET_CORP")))
        {
         	sQuery.append(" SELECT TMP_WRT_NUM, NAME, MANA_NUM, COI_WRT_NUM, REP_NM_KOR, ADDR_TEL_NUM, ");
         	sQuery.append(" ADDR_POST_NUM, ADDR_ADDR, ADDR_DETAIL_ADDR ");
         	sQuery.append(" FROM PT_R_COMPANY_MASTER ");
         	sQuery.append(" WHERE 1 = 1 ");
         	sQuery.append(" AND TMP_WRT_NUM = '" + scRECV_NUM + "' " );
 	
         	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
         	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else
        {
         	//Deficit Codes Table
         	sQuery.append(" SELECT * ");
         	sQuery.append(" FROM PT_R_DEFICIT_CODE ");
         	sQuery.append(" WHERE DEFICIT_GROUP = 'GUBU' ");
 	
         	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
                
        request.setAttribute("dl", dl);  

        return next;
    }

}
