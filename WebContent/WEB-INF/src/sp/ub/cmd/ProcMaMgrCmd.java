/**
 * 파일명   : ProcPlanMgrCmd.java
 * 설명     : 착공전 설계관리 설계자 검색 cmd
 * 이력사항
 * CH00     : 2010/01/28 전원배 최초작성
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

public class ProcMaMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ProcMaMgrCmd() {
    }

    public ProcMaMgrCmd(String next_url) {
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
    	
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scSIGUNGU_CODE = vl.getValueAsString("scSIGUNGU_CODE");
        String scNM = vl.getValueAsString("scNM");
        String scSidoChk = vl.getValueAsString("scSidoChk");
        
    	String selectSQL=
    		"	 SELECT  RECV_NUM, SIDO_CODE, SIGUNGU_CODE ,CIV_RECV_NUM ,TYPE_PROC_NO_CA,TYPE_PROC_NM_CA,FREQUENCY_SCOPE_CA,WIRE_TYPE_CA,TYPE_PROC_NO_MA,TYPE_PROC_NM_MA,FREQUENCY_SCOPE_MA,WIRE_TYPE_MA,TYPE_PROC_NO_SMA ,TYPE_PROC_NM_SMA,FREQUENCY_SCOPE_SMA, WIRE_TYPE_SMA,INS_DT,'U' AS EQU_CMD  \n";
    	//CIV_RECV_NUM,
    	String fromSQL = 
    		"     FROM PT_UB_EQUIPMENT  \n";
    	
    	String whereSQL = 
    		"	 WHERE 1 = 1    \n" +
    		"  	   AND SIDO_CODE = '"+scSIDO_CODE+"'   \n" ;
    		//"  	   AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    		if(scSidoChk.equals("0")){  //시군구 전체 검색  추가 이석곤 2012-07-19
    	    	whereSQL += "  	    AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    	    	}
    	
    	
    	if(!KJFUtil.isEmpty(scNM)){
    		whereSQL += "AND TYPE_PROC_NM_CA like '%"+scNM+"%'  \n";
    	}
    	//whereSQL += "AND PLANER_NM IS NOT NULL  \n";
    	
    	//String orderSQL = "ORDER BY PLANER_NM ASC  \n";
    	
    	//String groupSQL = "GROUP BY PLANER_NAME, PLANER_NM, PLANER_TEL, PLANER_POSTNUM, PLANER_ADDR, PLANER_DETAILADDR ";
    	//rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+groupSQL+orderSQL);   
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}