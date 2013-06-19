/**
 * 파일명   : UBSupervisionSpotMgrCmd.java
 * 설명     :   o 감리결과보고서 접수 처리목록 cmd
 * 이력사항
 * CH00     : 2010/01/25 전원배 최초작성
                   2012/07/23 서춘교 착공일, 완공일로 검색 추가
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

public class UBSupervisionSpotMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBSupervisionSpotMgrCmd() {
    }

    public UBSupervisionSpotMgrCmd(String next_url) {
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
    	
    	String scDATE = vl.getValueAsString("scDATE");
        String scSUV_NAME = vl.getValueAsString("scSUV_NAME");
        String scSIWORK_NAME = vl.getValueAsString("scSIWORK_NAME");
        String scSPOTNM = vl.getValueAsString("scSPOTNM");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        String scSW_DT = vl.getValueAsString("scSW_DT");
        String scEW_DT = vl.getValueAsString("scEW_DT");
        String scUPD_DT_OLD = vl.getValueAsString("scUPD_DT_OLD");
        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        
    	String selectSQL=
    		"	SELECT ROWNUM AS SEQ, US.* FROM ( SELECT substr(replace(UPD_DT_OLD,'-',''),1,8) AS UPD_DT_OLD,RECV_NUM,SUV_NAME, SUV_STANUM, SIWORK_NAME, COI_WRT_NUM,SPOTNM, SW_DT, EW_DT,  " +
    		"	STRU_AREA || DECODE(AREA,NULL,AREA,','||to_char(AREA,'99,999,999.99')||'㎡') AS  STRU_AREA_S    \n";
    	
    	String fromSQL = " FROM PT_UB_SUVSPOT  \n";
    	
    	String whereSQL = "WHERE 1 = 1 \n"+
    					  "  AND SIDO_CODE = '"+SIDO_CODE+"'"+
    					  "  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
    	
    	
    	if(!KJFUtil.isEmpty(scSUV_NAME)){
    		whereSQL += "AND SUV_NAME LIKE '%"+scSUV_NAME+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scSIWORK_NAME)){
    		whereSQL += "AND SIWORK_NAME LIKE '%"+scSIWORK_NAME+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scSPOTNM)){
    		whereSQL += "AND SPOTNM LIKE '"+scSPOTNM+"%'";
    	}
    	    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    	//	whereSQL += "AND UPD_DT_OLD BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
   		//whereSQL += "AND substr(replace(" + scDATE + ",'-',''),1,8) BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
   		whereSQL += "AND " + scDATE + " BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";  //서춘교  착공일자, 완공일자
    	}
    	
    	String orderSQL = " ORDER BY UPD_DT_OLD ASC ) US ORDER BY UPD_DT_OLD ASC";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}
