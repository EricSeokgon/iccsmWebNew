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

public class SuvspotMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public SuvspotMgrCmd() {
    }

    public SuvspotMgrCmd(String next_url) {
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
    	
    	String workMODE = vl.getValueAsString("workMODE");
    	if(workMODE.equalsIgnoreCase("ALL")){
    		
	        String scSUV_NAME = vl.getValueAsString("scSUV_NAME");
	        String scSUV_NM = vl.getValueAsString("scSUV_NM");
	        String scSUV_STANUM = vl.getValueAsString("scSUV_STANUM");
	        
	       
	        
	    	String selectSQL=
	    		"	SELECT '0' AS CHECKER, SM.*    \n";
	    	
	    	String fromSQL = " FROM PT_UB_SUVSPOT_MASTER SM \n";
	    	
	    	String whereSQL = "WHERE 1 = 1 \n";
	    					 
	    	
	    	
	    	if(!KJFUtil.isEmpty(scSUV_NAME)){
	    		whereSQL += "AND SUV_NAME LIKE '%"+scSUV_NAME+"%'  \n";
	    	}
	    	
	    	if(!KJFUtil.isEmpty(scSUV_NM)){
	    		whereSQL += "AND SUV_NM LIKE '%"+scSUV_NM+"%'  \n";
	    	}
	    	
	    	if(!KJFUtil.isEmpty(scSUV_STANUM)){
	    		whereSQL += "AND SUV_STANUM LIKE '%"+scSUV_STANUM+"%'  \n";
	    	}
	    		    	
	    	String orderSQL = "ORDER BY SUV_NAME ASC ";	    		   
	    	
	    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   	
	        
	        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
	        KJFMi.ReEnt2Ds(dl,rEntity,"output");
	        
    	}else if(workMODE.equalsIgnoreCase("CODE")){
    		String SEQ = vl.getValueAsString("scSEQ");
    		String selectSQL= 
    			"SELECT SUV_NAME, SUV_NM, SUV_STANUM, SUV_TELNUM, \n" +
    			"	    SUV_MOBILE, SUV_POSTNUM, SUV_ADDR, SUV_DETAILADDR  \n" +
    			"  FROM PT_UB_SUVSPOT_MASTER   \n" +
    			" WHERE SEQ = '"+SEQ+"' ";
    		
    			rEntity    = rDAO.select(selectSQL);   	
	        
	        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
	        KJFMi.ReEnt2Ds(dl,rEntity,"output");
    	}
                
        request.setAttribute("dl", dl);  

        return next;
    }


}