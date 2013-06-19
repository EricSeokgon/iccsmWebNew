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
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBIssueListMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBIssueListMgrCmd() {
    }

    public UBIssueListMgrCmd(String next_url) {
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
    	
        String scCIV_RECV_NUM = vl.getValueAsString("scCIV_RECV_NUM");
        String scAPPLPER_NM = vl.getValueAsString("scAPPLPER_NM");
        String scUSEBEFINSP_DELINUM = vl.getValueAsString("scUSEBEFINSP_DELINUM");
        String scDELI_ST = vl.getValueAsString("scDELI_ST");
        String scDELI_ET = vl.getValueAsString("scDELI_ET");
        String scOPE_NAME = vl.getValueAsString("scOPE_NAME");
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        String scSORT = vl.getValueAsString("scSORT");
        
        // 프린트로그출력
    	String selectSQL=
    		" SELECT ROWNUM AS UB_SEQ,UB.* FROM ( \n"+
    		" SELECT APPLPER_NM, INSP_SPOT_ADDR||' '||INSP_SPOT_DETAILADDR INSP_SPOT_ADDR, DELI_DT, \n" +
    		" DECODE(WORK_ITEM_ETC,NULL,WORK_ITEM,WORK_ITEM||' '||WORK_ITEM_ETC) AS WORK_ITEM, PROC_OFFI, USEBEFINSP_DELINUM \n" +
    		" FROM PT_UB_USEBEFORE \n" ;
    	String whereSQL = 
    		" WHERE 1 = 1    \n" +
    		"AND SIDO_CODE = '"+SIDO_CODE+"'   \n"+
			"AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n"+
			"AND NAPPL_YN = '1'   \n"+			//적합
			"AND CER_DELI_YN = '1'  \n"+		//필증교부 유무
			"AND DELI_DT IS NOT NULL  \n"+		//필증교부 일자
			"AND USEBEFINSP_DELINUM IS NOT NULL  \n"; //필증교부 번호
    	
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){    		
    		whereSQL += "AND CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";    		
    	}
    	if(!KJFUtil.isEmpty(scAPPLPER_NM)){    		
    		whereSQL += "AND APPLPER_NM LIKE '%"+scAPPLPER_NM+"%'  \n";    		
    	}
    	if(!KJFUtil.isEmpty(scUSEBEFINSP_DELINUM)){
    		whereSQL += "AND USEBEFINSP_DELINUM LIKE '%"+scUSEBEFINSP_DELINUM+"%'  \n";
    	}
    	if(!KJFUtil.isEmpty(scDELI_ST) && !KJFUtil.isEmpty(scDELI_ET)){
    		whereSQL += "AND DELI_DT BETWEEN '"+scDELI_ST+"' AND '"+scDELI_ET+"'  \n";
    	}
    	if(!KJFUtil.isEmpty(scOPE_NAME)){
    		whereSQL += "AND OPE_NAME LIKE '%"+scOPE_NAME+"%'  \n";
    	}
    	
    	//String orderSQL = " ORDER BY REPLACE(USEBEFINSP_DELINUM,'-','') ASC \n";
    	
    		String orderSQL = " ORDER BY REPLACE(USEBEFINSP_DELINUM,'-','') ASC) UB ORDER BY UB_SEQ "+scSORT+" \n";
    	
    	//String orderSQL_etc  =" ) UB ORDER BY UB_SEQ DESC";
    	
    	//rEntity    = rDAO.select(selectSQL+whereSQL+orderSQL+orderSQL_etc);
    	rEntity    = rDAO.select(selectSQL+whereSQL+orderSQL);
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}