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

public class FineMgrCmd implements KJFCommand {
	 
		private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public FineMgrCmd() {
	    }

	    public FineMgrCmd(String next_url) {
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
	        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        sQuery.append(" SELECT '0' AS CHECKER, PT_C.NAME, PT_M.WRT_NUM, PT_M.TMP_WRT_NUM, ");
	        sQuery.append(" PT_C.COI_WRT_NUM, PT_M.RECV_NUM, PT_M.MOT_STE, PT_M.WRT_DT, PT_M.D_PER_CODE, PT_M.DISPO_DT, PT_S.PRSEC_DT, PT_S.PRSEC_PART, ");
	        sQuery.append(" PT_C1.CODE_NAME AS TMPD_PER_CODE, PT_C3.CODE_NAME AS TMPMOT_STE ");
	        //sQuery.append(" DECODE(PT_M.MOT_STE, 'C00001', '최초등록', 'C00002', '내부건의', 'C00003', '처분완료', '') AS TMPMOT_STE, ");
	        //sQuery.append(" DECODE(PT_M.D_PER_CODE, 'REQ001', '정보통신공사협회', 'REQ002', '공제조합', 'REQ003', '지방자치단체', '') AS TMPD_PER_CODE ");
	        
	        sQuery.append(" FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M ");
	        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM)	");
	        sQuery.append(" LEFT JOIN PT_M_PROSECUTION PT_S ON PT_M.WRT_NUM = PT_S.WRT_NUM	");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMSTE' )PT_C3 ON PT_M.MOT_STE = PT_C3.CODE ");

	        sWhere.append(" WHERE 	1 = 1 ");	
	        sWhere.append(" AND PT_M.DISPO_CONT = 'M00005' ");
	        sWhere.append(" AND		(PT_M.WRT_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
	        if(scWRT_NUM.length() > 0)
	        	sWhere.append(" AND     PT_S.WRT_NUM = '" + scWRT_NUM + "' ");
	        if(scCOM_NAME.length() > 0)
	        	sWhere.append(" AND     PT_C.NAME LIKE '%" + scCOM_NAME + "%' ");
	        sWhere.append(" AND     PT_M.SIDO_CODE = '" + scSIDO_CODE + "' ");
	        sWhere.append(" ORDER BY PT_M.WRT_DT DESC ");
	        
	    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	

	        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
