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

public class CloseReceiptMgrCCmd implements KJFCommand{
	private String next;
		
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public CloseReceiptMgrCCmd() {
    }

    public CloseReceiptMgrCCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scRECV_NUM = vl.getValueAsString("RECV_NUM");
        String scCHECK = vl.getValueAsString("CHECK");
        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
    	String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
    	String scDOC_CODE = vl.getValueAsString("DOC_CODE");

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;
                        
        //코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();

         if (scCHECK.equalsIgnoreCase("TRUE"))
        {
        	sQuery.append(" SELECT RECV_NUM FROM PT_R_CLOSE_STATEMENT ");
        	sWhere.append(" WHERE	1=1	");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' ");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' ");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
         else if (scCHECK.equalsIgnoreCase("CHECK2"))
         {
         	sQuery.append(" SELECT DOC_CODE, TMP_WRT_NUM FROM PT_R_REGIST_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	       	sQuery.append(" SELECT DOC_CODE FROM PT_R_BASIC_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_ASSI_TRANS_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_M_UNION_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_CLOSE_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
        	sQuery.append(" SELECT DOC_CODE FROM PT_M_MASTER ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	  	       
            KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
            sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
         }
         else if((scCHECK.equalsIgnoreCase("GET_CORP")))
        {
        	sQuery.append(" SELECT * ");
        	sWhere.append(" FROM PT_R_COMPANY_MASTER ");
        	sWhere.append(" WHERE TMP_WRT_NUM  = '" + scTMP_WRT_NUM + "' ");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else if((scCHECK.equalsIgnoreCase("FALSE")))
        {
	        //Master Table
        	sQuery.append(" SELECT * FROM PT_R_CLOSE_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' ");
	        
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        
	        //Memo Table
	        sQuery.append(" SELECT '0' AS CHECKER, A.* FROM PT_R_MEMO A ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND	RECV_NUM = '" + scRECV_NUM + "' \n");
	        sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' ");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	        //Deficit Table
	        sQuery.append(" SELECT PDEF.*, PDEF_CODE.CONT ");
	        sQuery.append(" FROM PT_R_DEFICIT PDEF LEFT JOIN PT_R_DEFICIT_CODE PDEF_CODE ");
	        sQuery.append(" ON PDEF.DEFI_CODE = PDEF_CODE.DEFI_CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PDEF.RECV_NUM = '" + scRECV_NUM + "' ");
	        sWhere.append(" AND PDEF_CODE.DEFI_GROUP = 'CLODEF' ");
	        sWhere.append("  AND	PDEF.SIDO_CODE = '" + scSIDO_CODE + "' ");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	       	//COMPANY MASTER
	       	sQuery.append(" SELECT * ");
        	sWhere.append(" FROM PT_R_COMPANY_MASTER ");
        	sWhere.append(" WHERE COI_WRT_NUM  = '" + scCOI_WRT_NUM + "' ");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	      
        }
        else if(scCHECK.equalsIgnoreCase("SEARCH"))
        {	
        	//PT_R_ENGINEER_CHANGE
	        sQuery.append(" SELECT RET_YMD FROM PT_R_ENGINEER_CHANGE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");        
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
	        
	        
	      //PT_R_REFER
	        sQuery.append(" SELECT RET_DT FROM PT_R_REFFER ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        
	        //Company Master Table
	        sQuery.append(" SELECT C_COM_DT,C_COM_CAUSE_CODE ");
	        sQuery.append(" FROM PT_R_COMPANY_MASTER");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");

	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
        	
        }
        if(scCHECK.equalsIgnoreCase("CODE"))
        {
        	sQuery.append(" SELECT * ");
        	sQuery.append(" FROM PT_R_DEFICIT_CODE ");
        	sQuery.append(" WHERE DEFI_GROUP = 'CLODEF' ");
	
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }

        request.setAttribute("dl", dl);  

        return next;
    }

}
