/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegRePublishPMgrCmd implements KJFCommand {
	
    private String next;
    
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
        
    public RegRePublishPMgrCmd() {
    }

    public RegRePublishPMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();    	     
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
      
       	String GUBUN = vl.getValueAsString("GUBUN");
       	String scDATE1 = vl.getValueAsString("scDATE1");
       	String scDATE2 = vl.getValueAsString("scDATE2");
        	
    	sQuery.append(" SELECT PT_RCM.TMP_WRT_NUM AS TMP_WRT_NUM, PT_RCM.NAME AS NAME, PT_RCM.COI_WRT_NUM AS COI_WRT_NUM,PT_RDB.DELI_YMD AS DELI_YMD, DECODE(PT_RDB.REMARK, '2' ,'등록수첩','3','등록증') AS REMARK FROM PT_R_COMPANY_MASTER PT_RCM ");
    	sQuery.append(" INNER JOIN PT_R_DELIVERY_BOOK PT_RDB ON PT_RCM.TMP_WRT_NUM = PT_RDB.TMP_WRT_NUM ");
    	sWhere.append(" WHERE 1 = 1 ");
    	sWhere.append(" AND (SUBSTR(PT_RDB.DELI_YMD, 0, 8) BETWEEN '" + scDATE1 + "'");
    	sWhere.append(" AND '" + scDATE2 + "')");
 
       	if(GUBUN.equalsIgnoreCase("2") || GUBUN.equalsIgnoreCase("3") )
    		sWhere.append(" AND PT_RDB.REMARK = '" + GUBUN + "'");  	
        
       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
       	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output1");
	    
        request.setAttribute("dl", dl);  

        return next;
    }
}
