/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
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

public class UserMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UserMgrCmd() {
    }

    public UserMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        ReportEntity sEntity     = null;
        
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
    	String scSIDO = vl.getValueAsString("scSIDO");
    		
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	sQuery.append(" SELECT SIDO_NM, AREA_CODE FROM PT_SIDO_CODE ");
    	sWhere.append(" WHERE 1 = 1 ");
    	if (!KJFUtil.isEmpty(scSIDO))
    		sWhere.append(" AND AREA_CODE = '" + scSIDO + "' ");
   		sWhere.append(" AND SIGUNGU_NM = '본청' ");
   		sWhere.append(" ORDER BY TO_NUMBER(SIDO_SEQ) ");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
    	
    	sQuery.delete(0, sQuery.length());
    	if (KJFUtil.isEmpty(scSIDO)){
    	sQuery.append(" SELECT SIDO_NM, SIGUNGU_NM, AREA_CODE FROM PT_SIDO_CODE ORDER BY TO_NUMBER(SIGUNGU_SEQ) ");
    	}else{
       	sQuery.append(" SELECT SIDO_NM, SIGUNGU_NM, AREA_CODE FROM PT_SIDO_CODE WHERE 1 = 1 AND SIDO_NM =(SELECT SIDO_NM FROM PT_SIDO_CODE  WHERE 1 = 1  AND AREA_CODE = '" + scSIDO + "') ORDER BY TO_NUMBER(SIGUNGU_SEQ) ");
    	}
    	sEntity    = rDAO.select(sQuery.toString());

        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        KJFMi.ReEnt2Ds(dl,sEntity,"output2");

        request.setAttribute("dl", dl);

        return next;
    }


}