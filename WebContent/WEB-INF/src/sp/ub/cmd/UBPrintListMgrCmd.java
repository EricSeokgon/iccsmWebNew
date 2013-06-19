/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.ub.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBPrintListMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBPrintListMgrCmd() {
    }

    public UBPrintListMgrCmd(String next_url) {
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
        String scAPPLPER_NM = vl.getValueAsString("scAPPLPER_NM");
        String scUSEBEFINSP_DELINUM = vl.getValueAsString("scUSEBEFINSP_DELINUM");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        String scOPE_NAME = vl.getValueAsString("scOPE_NAME");
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        String scSORT = vl.getValueAsString("scSORT");
        
        // 프린트로그출력
    	String selectSQL=
    		"  SELECT ROWNUM AS SEQ, UB.* FROM ( SELECT B.CIV_RECV_NUM, OPE_NAME, APPLPER_NM, INSP_SPOT_NM, USEBEFINSP_DELINUM, " +
    		" A.USER_NAME, USER_IP, A.INSP_DT, USER_ID, USER_DN, COM_NAME, REG_NUM    " +
    		" FROM PT_UB_USEBEFORE_PRINT_LOG A " +
    		" RIGHT JOIN PT_UB_USEBEFORE B ON A.CIV_RECV_NUM=B.RECV_NUM \n";
    	String whereSQL = 
    		" WHERE 1 = 1    \n" +
			"AND SIDO_CODE = '"+SIDO_CODE+"'   \n"+
			"AND A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n";
			//"AND NAPPL_YN = '1'  \n";
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){    		
    		whereSQL += "AND A.CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";    		
    	}
    	if(!KJFUtil.isEmpty(scAPPLPER_NM)){    		
    		whereSQL += "AND APPLPER_NM LIKE '%"+scAPPLPER_NM+"%'  \n";    		
    	}
    	if(!KJFUtil.isEmpty(scUSEBEFINSP_DELINUM)){
    		whereSQL += "AND USEBEFINSP_DELINUM LIKE '%"+scUSEBEFINSP_DELINUM+"%'  \n";
    	}
    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    		whereSQL += "AND SUBSTR(A.INSP_DT,0,10) BETWEEN '"+KJFDate.getChangDatePattern(scRECV_ST, "yyyyMMdd", "yyyy-MM-dd")+"' AND '"+KJFDate.getChangDatePattern(scRECV_ET, "yyyyMMdd", "yyyy-MM-dd")+"'  \n";
    	}
    	if(!KJFUtil.isEmpty(scOPE_NAME)){
    		whereSQL += "AND OPE_NAME LIKE '%"+scOPE_NAME+"%'  \n";
    	}
    	
    	String orderSQL = " ORDER BY UB_LOG_SEQ  ASC) UB ORDER BY SEQ "+scSORT+" \n";
    	rEntity    = rDAO.select(selectSQL+whereSQL+orderSQL);   
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}