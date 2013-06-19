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

public class RegReceiptMgrCCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegReceiptMgrCCmd() {
    }

    public RegReceiptMgrCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scREC_NUM = vl.getValueAsString("REC_NUM");
        String scREG_NUM = vl.getValueAsString("REG_NUM");
                
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
                
        //코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
        String selectSQL = "";
        String whereSQL = "";
        
        if (scREG_NUM != null && scREG_NUM.length() > 0){
	        selectSQL = " SELECT * FROM PT_SAMPLE ";
	    	
	    	whereSQL = " WHERE	1=1	\n";
	    	whereSQL += "  AND	REC_NUM = '" + scREC_NUM + "' \n";
	    	whereSQL += "  AND	REG_NUM = '" + scREG_NUM + "' \n";
        }
        else
        {
        	selectSQL = " SELECT REC_NUM FROM PT_SAMPLE ";
	    	
	    	whereSQL = " WHERE	1=1	\n";
	    	whereSQL += "  AND	REC_NUM = '" + scREC_NUM + "' \n";
        }
        
    	rEntity    = rDAO.select(selectSQL + whereSQL);    	
    	//DB에서 가져오는 데이타 외 추가적으로 1개의 ROW만 추가하여 사용할 경우  ReEnt2CodeDs
    	//를 사용한다.
      
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}