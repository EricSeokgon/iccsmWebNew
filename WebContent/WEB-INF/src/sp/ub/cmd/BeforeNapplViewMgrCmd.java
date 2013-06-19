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

public class BeforeNapplViewMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BeforeNapplViewMgrCmd() {
    }

    public BeforeNapplViewMgrCmd(String next_url) {
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
    	
        String RECV_NUM = vl.getValueAsString("scRECV_NUM");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scSIGUNGU_CODE = vl.getValueAsString("scSIGUNGU_CODE");
        System.out.println("RECV_NUM"+RECV_NUM);
    	
        
    	String selectSQL= "  \n"+
    		             "	SELECT ORPE_NM,PLANER_NM,PLANER_NAME,RECV_DT,CC.CODE_NAME AS USE,WORK_ITEM,NUM_FL,AREA,   \n" +
    		             "		   INSP_OPIN,REPO_DT,SW_BEF_REPO_DELINUM,ORPE_TEL,ORPE_POSTNUM,   \n" +
    		             "		   ORPE_ADDR,ORPE_DETAILADDR,PLANER_TEL,PLANER_POSTNUM,PLANER_ADDR,PLANER_DETAILADDR,   \n" +
    		             "		   STRU_COMMIT_NUM,STRU_ADDR_POSTNUM,STRU_ADDR_ADDR,STRU_ADDR_DETAILADDR,   \n" +
    		             "       INSP_BAS, PRE_ITEM \n";
    	
    	String fromSQL = "    FROM PT_UB_CONSTRUCTION UB LEFT JOIN PT_COM_CODE CC ON CC.CODE = UB.USE AND CC.P_CODE = 'BLDDIV'  \n";
    	
    	String whereSQL = "  WHERE RECV_NUM = '"+RECV_NUM+"'  \n" +
    					  "    AND SIDO_CODE = '"+scSIDO_CODE+"'  \n" +
    					  "    AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    	
    	String orderSQL = "ORDER BY RECV_DT DESC  \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        String selectSQL2= "  \n"+
        "	SELECT ORPE_NM,PLANER_NM,PLANER_NAME,RECV_DT,CC.CODE_NAME AS USE ,WORK_ITEM,NUM_FL,AREA,   \n" +
        "		   INSP_OPIN,REPO_DT,SW_BEF_REPO_DELINUM,ORPE_TEL,ORPE_POSTNUM,   \n" +
        "		   ORPE_ADDR,ORPE_DETAILADDR,PLANER_TEL,PLANER_POSTNUM,PLANER_ADDR,PLANER_DETAILADDR,   \n" +
        "		   STRU_COMMIT_NUM,STRU_ADDR_POSTNUM,STRU_ADDR_ADDR,STRU_ADDR_DETAILADDR,CONFIRMER_NM,CONFIRMER_POSI,CONFIRMER_TEL,   \n" +
        //"     	 CASE SUV_APPL WHEN '1' THEN '적합' WHEN '2' THEN '부적합' WHEN '3' THEN '감리대상' ELSE ' ' END AS  SUV_APPL,	 \n" +
        "       INSP_BAS, PRE_ITEM,CHG_INSP,STRU_INFO_BIGO,CER_DELI_YN,PROC_STE,WORK_ITEM_ETC \n";

        String fromSQL2 = "    FROM PT_UB_CONSTRUCTION UB LEFT JOIN PT_COM_CODE CC ON CC.CODE = UB.USE AND CC.P_CODE = 'BLDDIV'  \n";

        String whereSQL2 = "  WHERE RECV_NUM = '"+RECV_NUM+"'  \n" +
		  "    AND SIDO_CODE = '"+scSIDO_CODE+"'  \n" +
		  "    AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";

        String orderSQL2 = "ORDER BY RECV_DT DESC  \n";
        
	    rEntity    = rDAO.select(selectSQL2+fromSQL2+whereSQL2+orderSQL2);   

        KJFMi.ReEnt2Ds(dl,rEntity,"output1");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}