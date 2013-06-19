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

public class ProcPlanMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ProcPlanMgrCmd() {
    }

    public ProcPlanMgrCmd(String next_url) {
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
        String scDATE = vl.getValueAsString("scDATE");
        String scSidoChk = vl.getValueAsString("scSidoChk");
        
    	String selectSQL=
    		"	SELECT PLANER_NAME, PLANER_NM, PLANER_TEL, PLANER_POSTNUM, PLANER_ADDR, PLANER_DETAILADDR  \n";
    	//CIV_RECV_NUM,
    	String fromSQL = 
    		"     FROM PT_UB_CONSTRUCTION  \n";
    	
    	String whereSQL = 
    		"	 WHERE 1 = 1    \n" +
    		"  	   AND SIDO_CODE = '"+scSIDO_CODE+"'   \n" ;
    		//"  	   + AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n"; 인천 부평구 박윤석 시군구 옮기면 계속 저장해야 된다고해서 수정 서춘교 2012-03-21
    	
    	if(scSidoChk.equals("0")){  //시군구 전체 검색  추가 이석곤 2012-05-23
    	whereSQL += "  	    AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    	}
    	if(!KJFUtil.isEmpty(scNM)){
    		//whereSQL += "AND PLANER_NM = '"+scNM+"'  \n";
    		whereSQL += "AND "+scDATE+" like '%"+scNM+"%'  \n";
    	}
    	whereSQL += "AND PLANER_NM IS NOT NULL  \n";
    	
    	String orderSQL = "ORDER BY PLANER_NM ASC  \n";
    	
    	String groupSQL = "GROUP BY PLANER_NAME, PLANER_NM, PLANER_TEL, PLANER_POSTNUM, PLANER_ADDR, PLANER_DETAILADDR ";
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+groupSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}