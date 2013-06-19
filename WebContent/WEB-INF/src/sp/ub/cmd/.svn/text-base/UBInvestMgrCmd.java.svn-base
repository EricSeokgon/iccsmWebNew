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

public class UBInvestMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBInvestMgrCmd() {
    }

    public UBInvestMgrCmd(String next_url) {
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
    	
        String scINSP_SPOT_NM = vl.getValueAsString("scINSP_SPOT_NM");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        String scAPPLPER_NM = vl.getValueAsString("scAPPLPER_NM");
        String scOPE_NAME = vl.getValueAsString("scOPE_NAME");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scGUGUN_CODE = vl.getValueAsString("scGUGUN_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        
    	String selectSQL=
    		"	 SELECT '0' AS CHECKER, UU.CIV_RECV_NUM, INSP_SPOT_NM, APPLPER_NM, OPE_NAME,UU.RECV_NUM,       \n" +
    		"	        COI_WRT_NUM, UU.RECV_DT, OFFI_NM,PROC_LIM,          \n" +
    		"   	    CASE UU.PROC_STE WHEN '1' THEN '신규입력' WHEN '2' THEN '처리중' WHEN '3' THEN '처리완료' ELSE ' ' END AS  PROC_STE,   \n"+
    		"   	    CASE UC.SUV_APPL WHEN '1' THEN '적합' WHEN '2' THEN '부적합' WHEN '3' THEN '감리대상' ELSE '미처리' END AS SUV_APPL   \n";
    	
    	String fromSQL = "  FROM PT_UB_USEBEFORE UU LEFT OUTER JOIN  PT_UB_CONSTRUCTION UC    \n" +
    					 "    ON  UU.SW_BEF_REPO_DELINUM = UC.SW_BEF_REPO_DELINUM  AND UU.SIGUNGU_CODE = UC.SIGUNGU_CODE   \n";
    	
    	String whereSQL = "WHERE 1 = 1    \n" +
    					  "	 AND UU.NAPPL_YN is null   \n" +
    					  "  AND (UU.DEFI_YN = 'Y' or UU.DEFI_YN = 'N') \n" +
    					  "	 AND UU.SIDO_CODE = '"+SIDO_CODE+"'  \n"+
    					  "	 AND UU.SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n";
    	
    	
    	if(!KJFUtil.isEmpty(scINSP_SPOT_NM)){
    		whereSQL += "AND UU.INSP_SPOT_NM LIKE '"+scINSP_SPOT_NM+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    		whereSQL += "AND UU.RECV_DT BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scAPPLPER_NM)){
    		whereSQL += "AND UU.APPLPER_NM LIKE '"+scAPPLPER_NM+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scOPE_NAME)){
    		whereSQL += "AND UU.OPE_NAME LIKE '"+scOPE_NAME+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scSIDO_CODE)){
    		whereSQL += "AND UU.SIDO_CODE = '"+scSIDO_CODE+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scGUGUN_CODE)){
    		whereSQL += "AND UU.SIGUNGU_CODE = '"+scGUGUN_CODE+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scCOI_WRT_NUM)){
    		whereSQL += "AND UU.COI_WRT_NUM = '"+scCOI_WRT_NUM+"'  \n";
    	}
    	
    	
    	String orderSQL = "ORDER BY UU.RECV_DT, CIV_RECV_NUM ASC ";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}