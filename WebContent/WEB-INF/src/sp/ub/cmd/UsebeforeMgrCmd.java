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

public class UsebeforeMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UsebeforeMgrCmd() {
    }

    public UsebeforeMgrCmd(String next_url) {
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
    	
        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scSIGUNGU_CODE = vl.getValueAsString("scSIGUNGU_CODE");
        
    	String selectSQL= "  \n"+
    		             "	SELECT APPLPER_NM,APPLPER_REP,APPLPER_TELNUM,APPLPER_POSTNUM,APPLPER_ADDR,APPLPER_DETAILADDR,AREA,NUM_FL,   \n" +
    		             "		   OPE_NAME,OPE_TELNUM,OPE_REP,COI_WRT_NUM,OPE_POSTNUM,OPE_ADDR,OPE_DETAILADDR,   \n" +
    		             "		   OFFI_NM,OFFI_TELNUM,SW_DT,INSP_WISH_YMD,PROC_OFFI,INSP_FEE,RECV_DT,PROC_LIM,   \n" +
    		             "		   INSP_SPOT_NM,INSP_SPOT_POSTNUM,INSP_SPOT_ADDR,INSP_SPOT_DETAILADDR,USE,WORK_ITEM   \n";
    	
    	String fromSQL = "    FROM PT_UB_USEBEFORE UB LEFT JOIN PT_COM_CODE CC ON CC.CODE = UB.USE AND CC.P_CODE = 'BLDDIV'  \n";
    	
    	String whereSQL = "  WHERE RECV_NUM = '"+scRECV_NUM+"'  \n" +
    					  "    AND SIDO_CODE = '"+scSIDO_CODE+"'  \n" +
    					  "    AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    	
    	String orderSQL = "ORDER BY RECV_DT DESC  \n";    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}