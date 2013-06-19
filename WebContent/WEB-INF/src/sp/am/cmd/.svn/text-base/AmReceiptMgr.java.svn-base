package sp.am.cmd;
import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class AmReceiptMgr implements KJFCommand {
	 
		private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public AmReceiptMgr() {
	    }

	    public AmReceiptMgr(String next_url) {
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
	        
	        String scDATE = vl.getValueAsString("scDATE");
	        String scDATE1 = vl.getValueAsString("scDATE1");
	        String scDATE2 = vl.getValueAsString("scDATE2");
	        String scCOM_NAME = vl.getValueAsString("scCOM_NAME");
	        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
	        String scMOT_STE = vl.getValueAsString("scMOT_STE");
	        String scDISPO_CONT = vl.getValueAsString("scDISPO_CONT");
	        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
	        String scWRT_NUM = vl.getValueAsString("scWRT_NUM");
	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        /*
	        sQuery.append(" SELECT  '0' AS CHECKER, PT_C.NAME, PT_M.*, ");
	        sQuery.append(" DECODE(DISPO_CONT, 'M00001', '등록취소', 'M00002', '영업정지', 'M00003', '과태료처분', ");
	        sQuery.append(" 'M00004', '시정명령', 'M00005', '형사고발', 'M00006', '경고조치', ' ') AS TMPDISPO_CONT, ");
	        sQuery.append(" DECODE(MOT_STE, 'C00001', '최초등록', 'C00002', '내부건의', 'C00003', '처분완료', '') AS TMPMOT_STE, ");
	        sQuery.append(" DECODE(D_PER_CODE, 'REQ001', '정보통신공사협회', 'REQ002', '공제조합', 'REQ003', '지방자치단체', '') AS TMPD_PER_CODE ");
	        
	        sQuery.append(" FROM    PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M	");
	        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM	");
	        */
	        sQuery.append(" SELECT  '0' AS CHECKER, PT_C.NAME, PT_M.*, ");
	        
	        sQuery.append(" PT_C1.CODE_NAME AS TMPD_PER_CODE,   DECODE(PT_M.DISPO_CONT2,'',PT_C2.CODE_NAME,PT_C2.CODE_NAME ||' 및 '||PT_C2_2.CODE_NAME)  AS TMPDISPO_CONT, PT_C3.CODE_NAME AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT ");
	        sQuery.append(" FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M ");
	        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM) ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_M.DISPO_CONT = PT_C2.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMPRO' )PT_C2_2 ON PT_M.DISPO_CONT2 = PT_C2_2.CODE ");	        
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMSTE' )PT_C3 ON PT_M.MOT_STE = PT_C3.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMCONT' )PT_C4 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE ");
	        
	        sWhere.append(" WHERE 	1 = 1 ");
	        
	        if(!KJFUtil.isEmpty(vl.getValueAsString("scDATE"))) {
	        	sWhere.append(" AND		(PT_M." + scDATE + " BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
	        }
	        
	        if(!KJFUtil.isEmpty(scWRT_NUM))
	        	sWhere.append(" AND     PT_M.WRT_NUM LIKE '%" + scWRT_NUM + "%' ");
	        
	        if(!KJFUtil.isEmpty(scRECV_NUM))
	        	sWhere.append(" AND     PT_M.RECV_NUM = '" + scRECV_NUM + "' ");
	        if(!KJFUtil.isEmpty(scMOT_STE) && !scMOT_STE.equalsIgnoreCase("ALL"))
	        	sWhere.append(" AND     PT_M.MOT_STE = '" + scMOT_STE + "' ");
	        if(scDISPO_CONT.length() > 0 && !scDISPO_CONT.equalsIgnoreCase("ALL"))
	        	sWhere.append(" AND     PT_M.DISPO_CONT = '" + scDISPO_CONT + "' ");	        
	        if(!KJFUtil.isEmpty(scCOM_NAME))
	        	sWhere.append(" AND     PT_C.NAME LIKE '%" + scCOM_NAME + "%' ");
	        
	        if(!KJFUtil.isEmpty(vl.getValueAsString("scSIDO_CODE"))) {
	        	sWhere.append(" AND     PT_M.SIDO_CODE = '" + scSIDO_CODE + "' ");
	        }

	    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	

	        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
	        request.setAttribute("dl", dl);  

	        return next;
	    }

}
