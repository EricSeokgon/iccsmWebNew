/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.main_m.cmd;

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

public class CenterBoardSIGUNGUMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public CenterBoardSIGUNGUMgrCmd() {
    }

    public CenterBoardSIGUNGUMgrCmd(String next_url) {
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
        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
           		   
	 	rEntity    = rDAO.select(CON_CD(SIGUNGU_CODE));    
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
	    
        rEntity    = rDAO.select(USE_CD(SIGUNGU_CODE));        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output2");
        
        rEntity    = rDAO.select(CON_LIST_CD(SIGUNGU_CODE));        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output3");
        
        rEntity    = rDAO.select(USE_LIST_CD(SIGUNGU_CODE),1,5);        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output4");
        
        
        
        
                
        request.setAttribute("dl", dl);  

        return next;
    }
    
    public String CON_CD(String SIGUNGU_CODE) throws Exception {
    	StringBuilder result = new StringBuilder();
    	
    		result.append("	SELECT * FROM (  \n");// 2010-03-22 add wbjeon
    		
        	result.append("	SELECT    \n");
        	result.append("		'착공전설계' AS GUBUN,     \n");
        	
        	result.append("		SUBSTR(RECV_DT,0,4) AS GB_YEAR,    \n"); // 2010-03-22 add wbjeon 
        	
        	result.append("		'20' AS GR_NM,    \n");
        	result.append("		NVL(MAX(SIGUNGU_CODE),'"+SIGUNGU_CODE+"') AS SIDO_CODE,    \n");
        	result.append("		NVL(sum(CASE PROC_STE WHEN '1' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,    \n");
        	result.append("		'ub::BeforeInvestResultSt.xml' AS N_URL_ID,    \n");
        	result.append("		'ub::BeforeInvestResultSt.xml' AS N_URL,    \n");
        	result.append("		'125' AS N_ID,    \n");
        	result.append("		NVL(sum(CASE PROC_STE WHEN '2' THEN 1 ELSE 0 END),'0') AS  ING_DATA,    \n");
        	result.append("		'ub::BeforeInvestResultSt.xml' AS M_URL_ID,    \n");
        	result.append("		'ub::BeforeInvestResultSt.xml' AS M_URL,    \n");
        	result.append("		'125' AS M_ID,    \n");
        	result.append("		'ub::BeforeInvestResultSt.xml' AS O_URL_ID,    \n");
        	result.append("		'ub::BeforeInvestResultSt.xml' AS O_URL,    \n");
        	result.append("		'125' AS O_ID,    \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 3  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,        \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 6  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,	      \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 9  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,	      \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER,	      \n");
        	result.append("     NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOAL_COUNT         \n");
        	result.append("	FROM PT_UB_CONSTRUCTION     \n");
        	result.append("	WHERE RECV_DT is not null     \n");
        	result.append("	AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'     \n");    	
        	// 2010-03-22 ADD wbjeon
        	result.append("	GROUP BY SUBSTR(RECV_DT,0,4)     \n");
        	result.append("	ORDER BY    SUBSTR(RECV_DT,0,4) DESC     \n");
        	result.append("		) WHERE GB_YEAR < TO_CHAR(SYSDATE+1,'yyyy-MM-DD') AND ROWNUM <=2     \n");
        	
		return result.toString();
    	
    }
    
    public String USE_CD(String SIGUNGU_CODE) throws Exception {
    	StringBuilder result = new StringBuilder();
    	
    		result.append("	SELECT * FROM (  \n");// 2010-03-22 add wbjeon
    		result.append("	SELECT    \n");
        	result.append("		'사용전검사' AS GUBUN ,     \n");
        	
        	result.append("		SUBSTR(RECV_DT,0,4)  AS GB_YEAR,    \n"); // 2010-03-22 add wbjeon 
        	
        	result.append("		'21' AS GR_NM,    \n");        	
        	result.append("		NVL(MAX(SIGUNGU_CODE),'"+SIGUNGU_CODE+"') AS SIDO_CODE,    \n");
        	result.append("		NVL(sum(CASE PROC_STE WHEN '1' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,    \n");
        	result.append("		'ub::UBReceiptMgr' AS N_URL_ID,    \n");
        	result.append("		'ub::UBReceiptMgr.xml' AS N_URL,    \n");
        	result.append("		'166' AS N_ID,    \n");
        	result.append("		NVL(sum(CASE PROC_STE WHEN '2' THEN 1 ELSE 0 END),'0') AS  ING_DATA,    \n");
        	result.append("		'ub::UBInvestMgr' AS M_URL_ID,    \n");
        	result.append("		'ub::UBInvestMgr.xml' AS M_URL,    \n");
        	result.append("		'167' AS M_ID,    \n");
        	result.append("		'ub::UBInvestResultSt.xml' AS O_URL_ID,    \n");
        	result.append("		'ub::UBInvestResultSt.xml' AS O_URL,    \n");
        	result.append("		'173' AS O_ID,    \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 3  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,        \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 6  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,	      \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 9  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,	      \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER,	      \n");
        	result.append("     NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOAL_COUNT         \n");
        	result.append("	FROM PT_UB_USEBEFORE     \n");
        	result.append("	WHERE RECV_DT is not null     \n");
        	result.append("	AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'     \n");
        	
        	// 2010-03-22 ADD wbjeon
        	result.append("	GROUP BY SUBSTR(RECV_DT,0,4)     \n");
        	result.append("	ORDER BY    SUBSTR(RECV_DT,0,4) DESC     \n");
        	result.append("	) WHERE GB_YEAR < TO_CHAR(SYSDATE+1,'yyyy-MM-DD') AND ROWNUM <=2    \n");
        	
        	
        	
		return result.toString();    	
    }
    
    public String CON_LIST_CD(String SIGUNGU_CODE) throws Exception {
    	StringBuilder result = new StringBuilder();
    	
    	result.append("  SELECT RECV_NUM,ORPE_NM,PLANER_NAME,RECV_DT,SUV_APPL,SUV_TYPE,SIDO_CODE   \n");
    	result.append("	   FROM(  \n");
    	result.append("			SELECT RECV_NUM,ORPE_NM,PLANER_NAME,RECV_DT,SIDO_CODE,  \n");
    	result.append("				   CASE SUV_APPL WHEN '3' THEN '감리대상' ELSE '비대상' END AS SUV_APPL,   \n");
    	result.append("			       CASE SUV_APPL WHEN '3' THEN 'Y' ELSE 'N' END AS SUV_TYPE     \n");
    	result.append("			  FROM PT_UB_CONSTRUCTION    \n");
    	//result.append("			 WHERE SUV_APPL is not null    \n"); 2009-09-18
    	//result.append("		       AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'    \n");
    	result.append("			 WHERE  \n");
    	result.append("		        SIGUNGU_CODE = '"+SIGUNGU_CODE+"'    \n");
    	result.append("			 ORDER BY RECV_DT ASC  \n");
    	result.append("		) WHERE ROWNUM <= 10    \n");
    	result.append("	 ORDER BY RECV_DT ASC    \n");
    	
    	return result.toString();
    }
    
    public String USE_LIST_CD(String SIGUNGU_CODE) throws Exception {
    	StringBuilder result = new StringBuilder();
    	
    	result.append("  SELECT RECV_NUM,APPLPER_NM,OPE_NAME,RECV_DT,INSP_DT,SIDO_CODE    \n");
    	result.append("	   FROM (   \n");
    	result.append("		      SELECT RECV_NUM,APPLPER_NM,OPE_NAME,RECV_DT,INSP_DT,SIDO_CODE    \n");
    	result.append("				FROM PT_UB_USEBEFORE    \n");
    	result.append("			   WHERE INSP_DT is not null     \n");
    	result.append("		         AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'    \n");
    	result.append("			   ORDER BY INSP_DT ASC    \n");
    	result.append("			) WHERE ROWNUM <= 10   \n");
    	result.append("	  ORDER BY INSP_DT ASC   \n");
    	
    	return result.toString();
    }


}