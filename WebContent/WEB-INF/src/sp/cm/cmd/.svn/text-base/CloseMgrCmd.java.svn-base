package sp.cm.cmd;

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

public class CloseMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public CloseMgrCmd() {
    }

    public CloseMgrCmd(String next_url) {
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
	     
	     String scDATE1 = vl.getValueAsString("scDATE1");
	     String scDATE2 = vl.getValueAsString("scDATE2");
	     String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
	     String scNAME = vl.getValueAsString("scNAME");	     
	     // 시도코드 검색 추가 : 09/12/13
	     String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
	     
	     sQuery.append(" SELECT	'0' AS CHECKER, A.* ");
	     //sQuery.append(" A.RECV_NUM, A.REC_DATE, B.STATE_PERIOD, A.MEASURE_STATE, A.FIRST_REGIST_OFFICAL ");
	     sQuery.append(" FROM    PT_R_COMPANY_MASTER A ");
	//     sQuery.append(" WHERE A.TMP_REG_NUM = SELECET TMP_REG_NUM FORM PT_R_BASIC_CHANGE_HISTORY B LEFT JOIN PT_R_REGIST_STATEMENT C ON B.RECV_NUM = C.RECV_NUM ");
	
	     sWhere.append(" WHERE 1 = 1 ");
	     
	     // 시도코드 검색 추가 : 09/12/13 
	     sWhere.append(" AND SIDO_CODE = '" + scSIDO_CODE + "'");
	     
	     sWhere.append(" AND (SUBSTR(A.C_COM_DT, 0, 8) BETWEEN '" + scDATE1 + "'");
	     sWhere.append(" AND '" + scDATE2 + "')");
	     if (scCOI_WRT_NUM != null && scCOI_WRT_NUM.length() > 0)
	     	sWhere.append(" AND A.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
	     if (scNAME != null && scNAME.length() > 0)
	     	sWhere.append(" AND A.NAME LIKE '%" + scNAME + "%'");
	 	
	     sWhere.append(" AND C_COM_DT IS NOT NULL ");
	     
	 	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	 	//DB에서 가져오는 데이타 외 추가적으로 1개의 ROW만 추가하여 사용할 경우  ReEnt2CodeDs
	 	//를 사용한다.
	   
	     //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
	     KJFMi.ReEnt2Ds(dl,rEntity,"output");
	     
	     
	     request.setAttribute("dl", dl);  
	
	     return next;
 	}

}
