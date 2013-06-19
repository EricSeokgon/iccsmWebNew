/**
 * 파일명   : UBEquipmentMgrCmd.java
 * 설명     : 디지털전환관련 기자재 설치현황 관리 cmd
 * 이력사항
 * CH00     : 2010/01/22 전원배 최초작성
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

public class UBEquipmentMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBEquipmentMgrCmd() {
    }

    public UBEquipmentMgrCmd(String next_url) {
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
        String scORPE_NM = vl.getValueAsString("scORPE_NM");
        String scPLANER_NAME = vl.getValueAsString("scPLANER_NAME");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        String scNAPPL_YN = vl.getValueAsString("scNAPPL_YN");
		//String scFINISH = vl.getValueAsString("scFINISH");
        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
		String scSORT = vl.getValueAsString("scSORT");
		
	   	String selectSQL=
	   		"   SELECT ROWNUM AS SEQ, UB.* FROM ("+
    		"	SELECT UU.RECV_NUM,UU.INSP_DT, (SELECT CODE_NAME FROM PT_COM_CODE CC WHERE  CC.CODE = UU.USE AND CC.P_CODE = 'BLDDIV' )  ||' '|| DECODE(NVL(UU.AREA,'0'),'0','',to_char(UU.AREA,'999,999.99') || '㎡') AS CODE_NAME,   \n" +
    		"		   UU.INSP_SPOT_ADDR ||' '|| UU.INSP_SPOT_DETAILADDR AS INSP_SPOT_ADDR, UU.APPLPER_NM, UU.OPE_NAME,   \n" +
    		"   	   UE.TYPE_PROC_NO_CA, UE.TYPE_PROC_NM_CA, UE.FREQUENCY_SCOPE_CA,WIRE_TYPE_CA , \n" +
    		"		   UE.TYPE_PROC_NO_MA, UE.TYPE_PROC_NM_MA, UE.FREQUENCY_SCOPE_MA,WIRE_TYPE_MA , \n" +
    		"		   UE.TYPE_PROC_NO_SMA, UE.TYPE_PROC_NM_SMA, UE.FREQUENCY_SCOPE_SMA,WIRE_TYPE_SMA, UU.ADMIT_DT \n";
		
    	String fromSQL = 
    		"     FROM PT_UB_USEBEFORE UU, PT_UB_EQUIPMENT UE  \n"; 
    	
    	String whereSQL = 
    		"	 WHERE 1 = 1    \n" +
    		"  	   AND UU.SIDO_CODE = '"+SIDO_CODE+"'   \n" +
    		"  	   AND UU.SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n"+
    		"      AND UU.RECV_NUM =  UE.RECV_NUM \n";
    	
   
    	
   		whereSQL += "  	   AND UU.PROC_STE = '3'   \n";
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){
    		whereSQL += "  	   AND UU.CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scORPE_NM)){
    		whereSQL += "  	   AND UU.ORPE_NM LIKE '"+scORPE_NM+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scPLANER_NAME)){
    		whereSQL += "  	   AND UU.PLANER_NAME LIKE '"+scPLANER_NAME+"%'  \n";
    	}

    	
    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    		whereSQL += "  	   AND UU.INSP_DT BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scNAPPL_YN) && !"0".equals(scNAPPL_YN)){
    		whereSQL += "  	   AND UU.NAPPL_YN = '"+scNAPPL_YN+"'  \n";
    	}
    	
    	String orderSQL = "";
    	    	
    	if (!KJFUtil.isEmpty(scSORT) && "ASC".equals(scSORT)){
    		orderSQL = "  	   ORDER BY UU.INSP_DT ASC ) UB ORDER BY SEQ ASC  \n";
    	} else if (!KJFUtil.isEmpty(scSORT) && "DESC".equals(scSORT)){
    		orderSQL = "  	   ORDER BY UU.INSP_DT ASC ) UB ORDER BY SEQ DESC  \n";
    	}
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}