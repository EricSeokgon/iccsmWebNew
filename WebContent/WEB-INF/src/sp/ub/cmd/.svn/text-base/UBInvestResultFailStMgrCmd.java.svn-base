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

public class UBInvestResultFailStMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBInvestResultFailStMgrCmd() {
    }

    public UBInvestResultFailStMgrCmd(String next_url) {
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
        String scRECV_DT = vl.getValueAsString("scRECV_DT");
        String scAPPLPER_NM = vl.getValueAsString("scAPPLPER_NM");
        String scUSEBEFINSP_DELICODE = vl.getValueAsString("scUSEBEFINSP_DELICODE");
        String scOPE_NAME = vl.getValueAsString("scOPE_NAME");
        //String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scSIDO_CODE = "0000";
        
    	String selectSQL=
    		"	SELECT '0' AS CHECKER, RECV_NUM, RECV_DT, APPLPER_NM, APPLPER_TELNUM, OPE_REP,  \n" +
    		"   	   OPE_TELNUM, USE, AREA, NUM_FL, WORK_ITEM, NAPPL_YN,		\n" +
    		"		   INSP_SPOT_POSTNUM||''||INSP_SPOT_ADDR||''||INSP_SPOT_DETAILADDR AS ADDR     \n" ;
    	
    	String fromSQL = " FROM PT_UB_USEBEFORE  \n";
    	
    	String whereSQL = "WHERE 1 = 1 \n";
    	
    	whereSQL += "AND NAPPL_YN = '2'   \n" +
    				"AND NAPPL_YN is not null";   
    	
    	//whereSQL += "AND SIDO_CODE = '"+scSIDO_CODE+"'";   
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){    		
    		whereSQL += "AND CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'";    		
    	}
    	
    	if(!KJFUtil.isEmpty(scRECV_DT)){    		
    		whereSQL += "AND RECV_DT = '"+scRECV_DT+"'";    		
    	}
    	
    	if(!KJFUtil.isEmpty(scAPPLPER_NM)){
    		whereSQL += "AND APPLPER_NM LIKE '%"+scAPPLPER_NM+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scUSEBEFINSP_DELICODE)){    		
    		whereSQL += "AND USEBEFINSP_DELICODE = '"+scUSEBEFINSP_DELICODE+"'";    		
    	}
    	
    	if(!KJFUtil.isEmpty(scOPE_NAME)){
    		whereSQL += "AND OPE_NAME LIKE '%"+scOPE_NAME+"%'";
    	}
    	
    	String orderSQL = "";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}