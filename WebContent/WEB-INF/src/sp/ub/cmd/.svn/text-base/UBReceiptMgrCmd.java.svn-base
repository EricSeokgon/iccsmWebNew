/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.ub.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBReceiptMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBReceiptMgrCmd() {
    }

    public UBReceiptMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scCIV_RECV_NUM = vl.getValueAsString("scCIV_RECV_NUM");
        String scOPE_NAME = vl.getValueAsString("scOPE_NAME");
        String scAPPLPER_NM = vl.getValueAsString("scAPPLPER_NM");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
		String scFINISH = vl.getValueAsString("scFINISH");
        
    	String selectSQL=
    		"	SELECT '0' AS CHECKER, CIV_RECV_NUM, INSP_SPOT_NM, APPLPER_NM, OPE_NAME, RECV_NUM,    \n" +
    		"	       COI_WRT_NUM, RECV_DT, OFFI_NM,  \n" +
    		"   	   CASE PROC_STE WHEN '1' THEN '신규입력' WHEN '2' THEN '처리중' WHEN '3' THEN '처리완료' ELSE ' ' END AS  PROC_STE ," +
    		"		   CASE WHEN LENGTH(TAKE_TM) > 0 THEN '●' ELSE 'x' END AS TAKE_TM \n";
    	
    	String fromSQL = " FROM PT_UB_USEBEFORE  \n";
    	
    	String whereSQL = "WHERE 1 = 1 \n"+
    					  "  AND  SIDO_CODE = '"+SIDO_CODE+"' \n"+
    					  "  AND  SIGUNGU_CODE = '"+SIGUNGU_CODE+"'   \n ";
    					  //"  AND (DEFI_YN = 'N' OR DEFI_YN is null)   \n";
    	
    	
    	if("0".equals(scFINISH)){
    		whereSQL += "AND (PROC_STE = '1' OR PROC_STE = '2')  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){
    		whereSQL += "AND CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scOPE_NAME)){
    		whereSQL += "AND OPE_NAME LIKE '%"+scOPE_NAME+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scAPPLPER_NM)){
    		whereSQL += "AND APPLPER_NM LIKE '"+scAPPLPER_NM+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    		whereSQL += "AND RECV_DT BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
    	}
    	
    	
    	
    	
    	String orderSQL = "ORDER BY RECV_DT, CIV_RECV_NUM DESC \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}
