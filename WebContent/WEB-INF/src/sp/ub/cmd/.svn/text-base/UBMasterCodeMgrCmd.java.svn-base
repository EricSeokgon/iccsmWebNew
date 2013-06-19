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

public class UBMasterCodeMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBMasterCodeMgrCmd() {
    }

    public UBMasterCodeMgrCmd(String next_url) {
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
    	
    	String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
        
    	String selectSQL=
    		"	SELECT NAME, ADDR_POST_NUM, ADDR_ADDR, ADDR_DETAIL_ADDR,  \n" +
    		"   	   REP_NM_KOR,ADDR_TEL_NUM,COI_WRT_NUM		\n" +
    		"	  FROM PT_R_COMPANY_MASTER			\n";
    	
    	String whereSQL = "WHERE TMP_WRT_NUM = '"+scTMP_WRT_NUM+"'";
    		
    	rEntity    = rDAO.select(selectSQL+whereSQL);        
    	
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }
    
    


}