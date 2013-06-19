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
import kjf.util.KJFDate;
import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class DeliNumViewMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public DeliNumViewMgrCmd() {
    }

    public DeliNumViewMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity cEntity     = null;
        ReportEntity oEntity     = null;
        ReportEntity rEntity     = null;
        
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String SIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("scSIGUNGU_CODE");
        String DELI_ITEM  = vl.getValueAsString("scDELI_ITEM");
        
        String year = KJFDate.getCurTime("yyyy");
    	
        String cntSQL=
    		"	SELECT COUNT(*) AS CNT FROM  PT_UB_DELI_MASTER WHERE SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND YEAR = '"+year+"' AND DELI_ITEM = '"+DELI_ITEM+"'   \n";
    	
    	cEntity    = rDAO.select(cntSQL);
    	
    	String selectSQL = "";
    		
//    	if(cEntity.getValue(0,"CNT").equals("0")){
//    	} else {
    	if ("B".equals(DELI_ITEM)){
	    	 selectSQL = 
	    		" SELECT CUR_DOC.SW_BEF_REPO_DELINUM AS LAST_DOC, DELI_SIGUNGU||'-'||YEAR||'-'||LPAD(TO_NUMBER(DELI_NUM)+1,5,'0')||'호' AS AUTO_DOC FROM \n"+ 
	    		"	(SELECT SW_BEF_REPO_DELINUM FROM (			 								 \n"+
	    		"	   SELECT SW_BEF_REPO_DELINUM, REPLACE(TMP,'호','') as delinum FROM (		 \n"+				 
	    		"	   		  SELECT SW_BEF_REPO_DELINUM, SUBSTR(SUBSTR(SW_BEF_REPO_DELINUM,-6,6) , INSTR(SUBSTR(SW_BEF_REPO_DELINUM,-6,6),'-')+1 ,LENGTH(SUBSTR(SW_BEF_REPO_DELINUM,-6,6)) ) AS 	TMP  \n"+
	    		"			  	FROM PT_UB_CONSTRUCTION											 \n"+
	    		"			  	WHERE SUBSTR(REPLACE(SW_BEF_REPO_DELINUM,'호',''),-6,6) IS NOT NULL  \n"+
	    		"			  	AND SIDO_CODE = '"+SIDO_CODE+"'									 \n"+
	    		"				AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' 							 \n"+
	    		"				AND RECV_DT LIKE '"+year+"%' 									 \n"+	   
	    		"			  ) 																 \n"+
	    		"			  where trim(REPLACE(TMP,'호','')) is not null  						 \n"+
	    		"			  ORDER BY DELINUM DESC												 \n"+  
	    		"	   ) TEMP_TB WHERE ROWNUM = 1  												 \n"+
	    		"	) CUR_DOC,  																 \n"+
	    		" PT_UB_DELI_MASTER UDM															 \n"+
	    		" WHERE UDM.SIDO_CODE = '"+SIDO_CODE+"' 										 \n"+
	    		" AND UDM.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' 									 \n"+
	    		"    				 AND UDM.YEAR = '"+year+"' 									 \n"+
	    		"    				 AND UDM.DELI_ITEM = '"+DELI_ITEM+"'  ";
    	} else if ("U".equals(DELI_ITEM)){
	    	 selectSQL = 
	    		 " SELECT CUR_DOC.USEBEFINSP_DELINUM AS LAST_DOC, DELI_SIGUNGU||'-'||YEAR||'-'||LPAD(TO_NUMBER(DELI_NUM)+1,5,'0')||'호' AS AUTO_DOC FROM \n"+ 
	    		 "	(SELECT USEBEFINSP_DELINUM FROM (			 								 \n"+
	    		 "	   SELECT USEBEFINSP_DELINUM, REPLACE(TMP,'호','') as delinum FROM (		 \n"+				 
	    		 "	   		  SELECT USEBEFINSP_DELINUM, SUBSTR(SUBSTR(USEBEFINSP_DELINUM,-6,6) , INSTR(SUBSTR(USEBEFINSP_DELINUM,-6,6),'-')+1 ,LENGTH(SUBSTR(USEBEFINSP_DELINUM,-6,6)) ) AS 	TMP  \n"+
	    		 "			  	FROM PT_UB_USEBEFORE											 \n"+
	    		 "			  	WHERE SUBSTR(REPLACE(USEBEFINSP_DELINUM,'호',''),-6,6) IS NOT NULL  \n"+
	    		 "			  	AND SIDO_CODE = '"+SIDO_CODE+"'									 \n"+
	    		 "				AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' 							 \n"+
	    		 "				AND RECV_DT LIKE '"+year+"%' 									 \n"+	   
	    		 "			  ) 																 \n"+
	    		 "			  where trim(REPLACE(TMP,'호','')) is not null  						 \n"+
	    		 "			  ORDER BY DELINUM DESC												 \n"+  
	    		 "	   ) TEMP_TB WHERE ROWNUM = 1  												 \n"+
	    		 "	) CUR_DOC,  																 \n"+
	    		 " PT_UB_DELI_MASTER UDM															 \n"+
	    		 " WHERE UDM.SIDO_CODE = '"+SIDO_CODE+"' 										 \n"+
	    		 " AND UDM.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' 									 \n"+
	    		 "    				 AND UDM.YEAR = '"+year+"' 									 \n"+
	    		 "    				 AND UDM.DELI_ITEM = '"+DELI_ITEM+"'  ";	
    	}
//    	}
    	rEntity = rDAO.select(selectSQL);  
    	
    	
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}