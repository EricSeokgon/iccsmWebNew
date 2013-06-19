/**
 * 파일명   : ReportUBReceiptMgrCmd.java
 * 설명     : 
 * 이력사항
 * CH00     : 2010/01/25 전원배 최초작성
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

public class ReportUBReceiptMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ReportUBReceiptMgrCmd() {
    }

    public ReportUBReceiptMgrCmd(String next_url) {
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
    	
//        String scCIV_RECV_NUM = vl.getValueAsString("scCIV_RECV_NUM");
//        String scOPE_NAME = vl.getValueAsString("scOPE_NAME");
        String scDATE = vl.getValueAsString("scDATE");
    	String scAPPLPER_NM = vl.getValueAsString("scAPPLPER_NM");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
		String scFINISH = vl.getValueAsString("scFINISH");
        
    	String selectSQL=
    		"	SELECT ROWNUM AS SEQ, UB.* FROM ( " +
    		"   SELECT RECV_DT, APPLPER_NM, '신규' AS PROC_STE , \n" +
    		"	AREA, INSP_FEE, INSP_DT, DECODE(NAPPL_YN,1,'적합',2,'부적합') AS NAPPL_YN_S, \n" +
    		"   DELI_DT, NAPPL_CAUSE   \n";
    		
    	String fromSQL = " FROM PT_UB_USEBEFORE  \n";
    	
    	String whereSQL = "WHERE 1 = 1 \n"+
    					  "  AND  SIDO_CODE = '"+SIDO_CODE+"' \n"+
    					  "  AND  SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n ";
    					 
    	//if("0".equals(scFINISH)){
    		//whereSQL += "AND (PROC_STE = '1' OR PROC_STE = '2')  \n";
    		 whereSQL += "AND (PROC_STE = '3')  \n";
    		 whereSQL += "AND NAPPL_YN IN ('1','2')  \n";
    		 
    	//}
//    	
//    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){
//    		whereSQL += "AND CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";
//    	}
//    	
    	if(!KJFUtil.isEmpty(scAPPLPER_NM)){
    		whereSQL += "AND APPLPER_NM LIKE '"+scAPPLPER_NM+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    		whereSQL += "AND " + scDATE + " BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
    	}
    	
    	
    	String orderSQL = "ORDER BY " + scDATE + " ASC ) UB ORDER BY SEQ ASC \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}
