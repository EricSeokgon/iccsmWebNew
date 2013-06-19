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

public class BeforeMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BeforeMgrCmd() {
    }

    public BeforeMgrCmd(String next_url) {
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
        String scORPE_NM = vl.getValueAsString("scORPE_NM");
        String scPLANER_NAME = vl.getValueAsString("scPLANER_NAME");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        String scSUV_APPL = vl.getValueAsString("scSUV_APPL");
		String scFINISH = vl.getValueAsString("scFINISH");
        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        
    	String selectSQL=
    		"	SELECT '0' AS CHECKER,CIV_RECV_NUM,RECV_DT,ORPE_NM,SW_BEF_REPO_DELINUM,   \n" +
    		"		   RECV_NUM, PLANER_NAME, STRU_ADDR_ADDR||' '||STRU_ADDR_DETAILADDR AS ADDR,   \n" +
    		"   	   CASE PROC_STE WHEN '1' THEN '신규입력' WHEN '2' THEN '처리중' WHEN '3' THEN '처리완료' ELSE ' ' END AS  PROC_STE   \n";
    	
    	String fromSQL = 
    		"     FROM PT_UB_CONSTRUCTION  \n";
    	
    	String whereSQL = 
    		"	 WHERE 1 = 1    \n" +
    		"  	   AND SIDO_CODE = '"+SIDO_CODE+"'   \n" +
    		"  	   AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n";
    	
    	System.out.println(scFINISH);
    	
    	if("0".equals(scFINISH)){
    		whereSQL += "  	   AND (PROC_STE = '1' OR PROC_STE = '2')  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){
    		whereSQL += "  	   AND CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scORPE_NM)){
    		whereSQL += "  	   AND ORPE_NM LIKE '"+scORPE_NM+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scPLANER_NAME)){
    		whereSQL += "  	   AND PLANER_NAME LIKE '"+scPLANER_NAME+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scPLANER_NAME)){
    		whereSQL += "  	   AND PLANER_NAME LIKE '"+scPLANER_NAME+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    		whereSQL += "  	   AND RECV_DT BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scSUV_APPL) && !"0".equals(scSUV_APPL)){
    		whereSQL += "  	   AND SUV_APPL = '"+scSUV_APPL+"'  \n";
    	}
    	
    	String orderSQL = "  	   ORDER BY RECV_DT DESC  \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}