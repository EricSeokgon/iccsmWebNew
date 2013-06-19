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

public class ProcSchMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ProcSchMgrCmd() {
    }

    public ProcSchMgrCmd(String next_url) {
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
        
    	String selectSQL="	SELECT MU.NM,MU.TEL, MU.PART AS PART ,MU.POS, MU.OFFI_ID    \n";
    					  //"	SELECT MU.NM,MU.TEL, (SELECT SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE = MU.SIGUNGU_CODE) || ' ' || MU.PART AS PART ,MU.POS, MU.OFFI_ID    \n";
    	
    	String fromSQL =  "   FROM PT_MI_USER MU \n";
    	
    	String whereSQL = "  WHERE MU.SIDO_CODE = '"+scSIDO_CODE+"'  \n" +
    					  "    AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    	
    	
    	if(!KJFUtil.isEmpty(scNM)){
    		whereSQL += "AND NM = '"+scNM+"'  \n";
    	}
    	
    	
    	String orderSQL = "ORDER BY NM DESC  \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}