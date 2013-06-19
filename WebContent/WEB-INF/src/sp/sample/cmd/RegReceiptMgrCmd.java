/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.sample.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys_m.Sys_mParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegReceiptMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegReceiptMgrCmd() {
    }

    public RegReceiptMgrCmd(String next_url) {
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
        String scREC_NUM = vl.getValueAsString("scREC_NUM");
        
        //
    	String selectSQL =  " SELECT	REC_NUM, REG_NUM, COMPANY_NM, REC_DATE " +
    						" PRO_PERIOD, REC_WRITE, NOTE " +
    						" FROM     PT_SAMPLE     ";
    	
    	String 	whereSQL = 	" WHERE 1 = 1 " +
    						" AND (SUBSTR(REC_DATE, 0, 8) BETWEEN '" + scDATE1 + "'" +
    						" AND '" + scDATE2 + "')";
    						if (scREC_NUM != null && scREC_NUM.length() > 0)
    							whereSQL += " AND REC_NUM = '" + scREC_NUM + "'";
    	
    	rEntity    = rDAO.select(selectSQL + whereSQL);
    	KJFMi.ReEnt2Ds(dl,rEntity,"output");
      
    	selectSQL = " SELECT * FROM PT_R_MEMO ";
    	whereSQL = " WHERE 1 = 1 ";
		whereSQL += " AND REC_NUM = '" + scREC_NUM + "'";
    	
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        
        
        
        request.setAttribute("dl", dl);  

        return next;
    }


}