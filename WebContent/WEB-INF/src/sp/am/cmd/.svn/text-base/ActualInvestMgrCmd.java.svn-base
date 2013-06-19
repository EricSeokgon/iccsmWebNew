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

public class ActualInvestMgrCmd implements KJFCommand {
	 
		private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public ActualInvestMgrCmd() {
	    }

	    public ActualInvestMgrCmd(String next_url) {
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
	        
	        String scDATE1 = vl.getValueAsString("scDATE1");
	        String scDATE2 = vl.getValueAsString("scDATE2");
	        String scCOM_NAME = vl.getValueAsString("scCOM_NAME");
	        String scWRT_NUM = vl.getValueAsString("scWRT_NUM");
	        String scMOT_STE = vl.getValueAsString("scMOT_STE");
	        String scPROC_STE = vl.getValueAsString("scPROC_STE");
	        String scDATE_CLASS = vl.getValueAsString("scDATE_CLASS");
	        
	        	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        sQuery.append(" SELECT  '0' AS CHECKER, PT_S.*, PT_C.NAME, ");
	        sQuery.append(" DECODE(MOT_STE, 'C00001', '최초등록', 'C00002', '내부건의', 'C00003', '처분완료', '') AS TMPMOT_STE, ");
	        sQuery.append(" DECODE(PROC_STE, 'P00001', '미실시', 'P00002', '보류중', 'P00003', '실시완료', '') AS TMPPROC_STE ");
	        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_C INNER JOIN P_S_MASTER PT_S ON PT_C.TMP_WRT_NUM = PT_S.TMP_WRT_NUM	");

	        sWhere.append(" WHERE 	1 = 1 ");
	        if (scDATE_CLASS.equalsIgnoreCase("D00001"))
	        	sWhere.append(" AND		(PT_S.WRT_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
	        else if(scDATE_CLASS.equalsIgnoreCase("D00002"))
	        	sWhere.append(" AND		(PT_S.INV_EXPC_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
	        else
	        	sWhere.append(" AND		(PT_S.INV_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
	        
	        if(scWRT_NUM.length() > 0)
	        	sWhere.append(" AND     PT_S.WRT_DT = '" + scWRT_NUM + "' ");
	        if(scMOT_STE.length() > 0 && !scMOT_STE.equalsIgnoreCase("ALL"))
	        	sWhere.append(" AND     PT_S.MOT_STE = '" + scMOT_STE + "' ");
	        if(scPROC_STE.length() > 0 && !scPROC_STE.equalsIgnoreCase("ALL"))
	        	sWhere.append(" AND     PT_S.PROC_STE = '" + scPROC_STE + "' ");	        
	        if(scCOM_NAME.length() > 0)
	        	sWhere.append(" AND     PT_C.NAME LIKE '%" + scCOM_NAME + "%' ");

	    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	

	        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
