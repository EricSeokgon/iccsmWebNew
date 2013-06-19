package sp.am.cmd;
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

public class WarnMgrCCmd implements KJFCommand {
	 
		private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public WarnMgrCCmd() {
	    }

	    public WarnMgrCCmd(String next_url) {
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

	        String scWRT_NUM = vl.getValueAsString("scWRT_NUM");
	        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
	        String sworkMODE = vl.getValueAsString("workMODE");
	        
	        	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        if (sworkMODE.equalsIgnoreCase("GET_NUM"))
	        {
		        sQuery.append(" SELECT  PT_C.NAME, PT_C.COI_WRT_NUM, PT_M.* ");
		        sQuery.append(" FROM    PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M	");
		        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM	");
		        sWhere.append(" WHERE 	1 = 1 ");	 
		        if(scWRT_NUM.length() > 0)
		        	sWhere.append(" AND     PT_M.WRT_NUM = '" + scWRT_NUM + "' ");
		        if(scTMP_WRT_NUM.length() > 0)
		        	sWhere.append(" AND     RTRIM(PT_M.TMP_WRT_NUM) = '" + scTMP_WRT_NUM + "' ");
	
		    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
		        request.setAttribute("dl", dl);  
		        sQuery.delete(0, sQuery.length());
		        sWhere.delete(0, sWhere.length());
		        
		        String scUSERID = vl.getValueAsString("scUSERID");
		        String scFORMID = vl.getValueAsString("scFORMID");
		        
		        sQuery.append(" SELECT  USE_YN FROM PT_TEMPLET ");
		        sWhere.append(" WHERE 	1 = 1 ");	 
		        sWhere.append(" AND     USERID = '" + scUSERID + "' ");
		        sWhere.append(" AND     FORMID = '" + scFORMID + "' ");
	
		    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output2");        
		        request.setAttribute("dl", dl);  
	        }
	        else if (sworkMODE.equalsIgnoreCase("CODE"))
	        {
	        	sQuery.append(" SELECT CODE_NAME AS Value, CODE  AS Code FROM PT_COM_CODE ");
	        	sQuery.append(" WHERE P_CODE = 'PTMSTE' ORDER BY CODE ");
	        	rEntity    = rDAO.select(sQuery.toString());    	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output"); 
		        request.setAttribute("dl", dl);
	        }
	        else
	        {
	        	sQuery.append(" SELECT  * FROM PT_M_WARNING ");
		        sWhere.append(" WHERE 	1 = 1 ");	 
	        	sWhere.append(" AND     WRT_NUM = '" + scWRT_NUM + "' ");
	        	sWhere.append(" AND     TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
		    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output");
		        sQuery.delete(0, sQuery.length());
		        
		        sQuery.append(" SELECT  PT_C.NAME, PT_C.ADDR_POST_NUM, PT_C.ADDR_ADDR, PT_C.ADDR_DETAIL_ADDR, PT_C.COI_WRT_NUM, PT_M.* ");
		        sQuery.append(" FROM    PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M	");
		        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM	");

		        sQuery.append(" WHERE 	1 = 1 ");	 
		        sQuery.append(" AND     PT_M.WRT_NUM = '" + scWRT_NUM + "' ");
		        sQuery.append(" AND     RTRIM(PT_M.TMP_WRT_NUM) = '" + scTMP_WRT_NUM + "' ");
	        	
	        	rEntity    = rDAO.select(sQuery.toString());    	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output2");
		        sQuery.delete(0, sQuery.length());
		        
		        sQuery.append(" SELECT  '0' AS CHECKER,  AA.* FROM PT_M_MEMO AA ");
		        rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output3");
		        sQuery.delete(0, sQuery.length());
		        
//		        sQuery.append(" SELECT  '0' AS CHECKER,  AA.*, BB.CODE_NAME AS NOTE_NAME  ");
//		        sQuery.append(" FROM PT_M_BEF_REPORT AA LEFT JOIN ");
//		        sQuery.append(" ( SELECT P_CODE, CODE_NAME, CODE FROM PT_COM_CODE  ");
//		        sQuery.append(" WHERE P_CODE = 'NOTICLASS' ");
//		        sQuery.append(" ) BB ON AA.NOTE_CLASS_CODE = BB.CODE ");
		        
		        sQuery.append(" SELECT  '0' AS CHECKER,  AA.*, BB.CODE_NAME AS TMP_GUBUN, CC.CODE_NAME AS NOTE_NAME  ");
		        sQuery.append(" ,  DD.CODE_NAME AS TMP_NOTE_METHOD, EE.CODE_NAME AS TMP_RECV_YN  ");
		        sQuery.append(" FROM PT_M_BEF_REPORT AA ");
		        sQuery.append(" LEFT JOIN ( SELECT P_CODE, CODE_NAME, CODE FROM PT_COM_CODE  ");
		        sQuery.append(" WHERE P_CODE = 'PTMGUB' ");
		        sQuery.append(" ) BB ON AA.GUBUN = BB.CODE ");
		        sQuery.append(" LEFT JOIN ( SELECT P_CODE, CODE_NAME, CODE FROM PT_COM_CODE  ");
		        sQuery.append(" WHERE P_CODE = 'NOTICLASS' ");
		        sQuery.append(" ) CC ON AA.NOTE_CLASS_CODE = CC.CODE ");
		        sQuery.append(" LEFT JOIN ( SELECT P_CODE, CODE_NAME, CODE FROM PT_COM_CODE  ");
		        sQuery.append(" WHERE P_CODE = 'PTMNOTI' ");
		        sQuery.append(" ) DD ON AA.NOTE_METHOD_CLASS = DD.CODE ");
		        sQuery.append(" LEFT JOIN ( SELECT P_CODE, CODE_NAME, CODE FROM PT_COM_CODE  ");
		        sQuery.append(" WHERE P_CODE = 'PTMSEND' ");
		        sQuery.append(" ) EE ON AA.RECV_YN = EE.CODE ");	

		        rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
		        KJFMi.ReEnt2Ds(dl,rEntity,"output4");
		        sQuery.delete(0, sQuery.length());
		        
		        request.setAttribute("dl", dl);  
	        }
	        return next;
	    }

}
