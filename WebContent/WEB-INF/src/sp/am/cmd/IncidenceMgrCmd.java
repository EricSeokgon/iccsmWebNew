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

public class IncidenceMgrCmd implements KJFCommand  {
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
	public IncidenceMgrCmd() {
		
	}
	
	public IncidenceMgrCmd(String next_url) {
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
        String scRC_REGIST_NUM = vl.getValueAsString("scRC_REGIST_NUM");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
		
        sQuery.append(" SELECT '0' AS CHECKER,PT_M.WRT_NUM,PT_M.TMP_WRT_NUM,PT_M.INS_DT, PT_C.NAME,PT_M.D_PER_CODE, PT_M.DISPO_DT, ");
        sQuery.append(" PT_M.WRT_DT,PT_M.MOT_STE, PT_N.NEFI, PT_N.PAY_LIM, ");
        sQuery.append(" PT_C1.CODE_NAME AS TMPD_PER_CODE, PT_C3.CODE_NAME AS TMPMOT_STE ");
        //sQuery.append(" DECODE(PT_M.MOT_STE, 'C00001', '최초등록', 'C00002', '내부건의', 'C00003', '처분완료', '') AS TMPMOT_STE, ");
        //sQuery.append(" DECODE(PT_M.D_PER_CODE, 'REQ001', '정보통신공사협회', 'REQ002', '공제조합', 'REQ003', '지방자치단체', '') AS TMPD_PER_CODE ");
        sQuery.append(" FROM (PT_M_MASTER PT_M INNER JOIN PT_R_COMPANY_MASTER PT_C  ON PT_M.TMP_WRT_NUM = RTRIM(PT_C.TMP_WRT_NUM)) ");
        sQuery.append(" LEFT JOIN PT_M_NEGLIGENCE PT_N ON PT_M.WRT_NUM = PT_N.WRT_NUM ");
        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
        sQuery.append(" WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE ");
        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
        sQuery.append(" WHERE P_CODE = 'PTMSTE' )PT_C3 ON PT_M.MOT_STE = PT_C3.CODE ");
        
        sWhere.append(" WHERE 	1 = 1 ");
        sWhere.append(" AND PT_M.DISPO_CONT = 'M00003' ");	// 과태료부과 코드
        sWhere.append(" AND		(PT_M.WRT_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
		
        if(scRC_REGIST_NUM.length() > 0)
        	sWhere.append(" AND     PT_M.WRT_NUM = '" + scRC_REGIST_NUM + "' ");
        if(scCOM_NAME.length() > 0)
        	sWhere.append(" AND     PT_C.NAME LIKE '%" + scCOM_NAME + "%' ");
        sWhere.append(" AND     PT_M.SIDO_CODE = '" + scSIDO_CODE + "' ");
		
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	

        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
        request.setAttribute("dl", dl);  

		
		return next;
	}
}

