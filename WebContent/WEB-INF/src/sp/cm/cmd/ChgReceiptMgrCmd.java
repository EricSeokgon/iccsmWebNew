/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.cm.cmd;

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

public class ChgReceiptMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ChgReceiptMgrCmd() {
    }

    public ChgReceiptMgrCmd(String next_url) {
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
        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        
        //코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함 	
    	sQuery.append(" SELECT '0' AS CHECKER, PT_R.TMP_WRT_NUM, PT_R.RECV_NUM, PT_R.RECV_DT, PT_R.PROC_LIM, PT_M.COI_WRT_NUM, PT_R.SIDO_CODE, ");
    	sQuery.append(" DECODE(PT_R.DEFI_STE, 'O', '정상', '오류')AS DEFI_STE, BB.CODE_NAME AS MOT_STE, PT_M.NAME ");
		sQuery.append(" FROM (PT_R_CHANGE_STATEMENT PT_R LEFT JOIN (SELECT * FROM PT_R_BASIC_CHANGE_HISTORY WHERE STA_CHG_CLASS_CODE = 'R00011') PT_C  ");
		sQuery.append(" ON PT_R.RECV_NUM = PT_C.RECV_NUM AND PT_R.RECV_NUM = PT_C.RECV_NUM) LEFT JOIN ");
		sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
		sQuery.append(" WHERE P_CODE = 'REGSTDPROC')BB ON PT_C.MOT_STE = BB.CODE ");
		sQuery.append(" LEFT JOIN PT_R_COMPANY_MASTER PT_M ON PT_R.TMP_WRT_NUM = PT_M.TMP_WRT_NUM ");
   	
		sWhere.append(" WHERE 1 = 1 ");
		sWhere.append(" AND (SUBSTR(PT_R.RECV_DT, 0, 8) BETWEEN '" + scDATE1 + "'");
		sWhere.append(" AND '" + scDATE2 + "')");
		if (!KJFUtil.isEmpty(scRECV_NUM))
			sWhere.append(" AND PT_R.RECV_NUM = '" + scRECV_NUM + "'");
		sWhere.append(" AND PT_R.SIDO_CODE = '" + scSIDO_CODE + "'");
		//sWhere.append(" GROUP BY PT_R.RECV_NUM, PT_R.RECV_DT, PT_R.PROC_LIM, PT_R.COI_WRT_NUM, PT_R.SIDO_CODE,PT_R.DEFI_STE, BB.CODE_NAME, PT_R.NAME ");
		
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
    	//DB에서 가져오는 데이타 외 추가적으로 1개의 ROW만 추가하여 사용할 경우  ReEnt2CodeDs
    	//를 사용한다.
      
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }


}