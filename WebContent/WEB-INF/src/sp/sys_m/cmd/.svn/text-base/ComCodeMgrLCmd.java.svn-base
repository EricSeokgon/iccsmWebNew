/**
 * 파일명   : ComCodeMgrLCmd.java
 * 설명     : 공통코드관리 리스트 command
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.sys_m.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class ComCodeMgrLCmd implements KJFCommand {
	
    private String next;
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();

    public ComCodeMgrLCmd() {
    }

    public ComCodeMgrLCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	

    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scP_CODE = vl.getValueAsString("scP_CODE");
        String scCODE_NAME = vl.getValueAsString("scCODE_NAME");
        String scUSE_YN = vl.getValueAsString("scUSE_YN");
        

        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;       
        
        //SELECT 항목 SQL
        String selectSQL =
			" SELECT    *                    	\n"+           	
			" FROM      PT_COM_CODE       		\n";

        String whereSQL =
        	"WHERE	1=1	\n";
        
        if(!scP_CODE.equals("all")){
        	whereSQL +=
        	"  AND	P_CODE = '"+scP_CODE+"' \n";
        }
        if(!KJFUtil.isEmpty(scCODE_NAME)){
        	whereSQL +=
        	"  AND	CODE_NAME LIKE '%"+scCODE_NAME+"%' \n";
        }
        if(!scUSE_YN.equals("all")){
        	whereSQL +=
        	"  AND	USE_YN = '"+scUSE_YN+"' \n";
        }
 
        String orderSQL =
        	"ORDER BY P_CODE, ORDER_SEQ ASC  \n";


        rEntity    = rDAO.select(selectSQL+whereSQL+orderSQL);
        

        
        KJFMi.ReEnt2Ds(dl,rEntity,"ds_PT_COM_CODE");
        request.setAttribute("dl", dl);
        
        
        return next;
    }

}