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

import kjf.util.KJFMi;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBIConfirmMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBIConfirmMgrCmd() {
    }

    public UBIConfirmMgrCmd(String next_url) {
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
    	
        String sOFFI_ID = vl.getValueAsString("scOFFI_ID");
        
        StringBuilder sQuery = new StringBuilder();
        
        sQuery.append(" SELECT  AA.RECV_ID, ");
        sQuery.append("         AA.SIDO_CODE, ");
        sQuery.append("         AA.SIGUNGU_CODE, ");
        sQuery.append("         AA.OFFI_ID, ");
        sQuery.append("         AA.E_MAIL, ");
        sQuery.append("         BB.SEND_SYS_ID, ");
        sQuery.append("         BB.RECV_SYS_ID, ");
        sQuery.append("         BB.SERVER_ADDR, ");
        sQuery.append("         CC.SIGUNGU_NM, ");
        sQuery.append("         BB.GROUPWARE_MODULE_TYPE, ");
        sQuery.append("         BB.APPL_GUBUN ");
        
        sQuery.append(" FROM    PT_MI_USER AA LEFT JOIN PT_S_SYSVAR_MASTER BB ");
        sQuery.append("         ON AA.SIDO_CODE = BB.SIDO_CODE AND AA.SIGUNGU_CODE = BB.SIGUNGU_CODE ");
        sQuery.append("         LEFT JOIN PT_SIDO_CODE CC ON AA.SIGUNGU_CODE = CC.AREA_CODE  ");
        sQuery.append(" WHERE   AA.OFFI_ID = '" + sOFFI_ID + "' ");

    	
    	rEntity    = rDAO.select(sQuery.toString());
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}
