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

public class SupervisionSpotMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public SupervisionSpotMgrCmd() {
    }

    public SupervisionSpotMgrCmd(String next_url) {
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
    	
        String scSUV_NAME = vl.getValueAsString("scSUV_NAME");
        String scSUV_NM = vl.getValueAsString("scSUV_NM");
        String scSIWORK_NAME = vl.getValueAsString("scSIWORK_NAME");
        String scSIWORK_REP = vl.getValueAsString("scSIWORK_REP");
        String scSPOTNM = vl.getValueAsString("scSPOTNM");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        
    	/*String selectSQL=
    		"	SELECT '0' AS CHECKER,substr(replace(INS_DT,'-',''),1,8) AS INS_DT,CIV_RECV_NUM,RECV_NUM,SUV_NAME,SIWORK_NAME,SPOTNM,WORK_ITEM,b.CODE_NAME AS USE  \n";
    	
    	String fromSQL = " FROM PT_UB_SUVSPOT a, PT_COM_CODE b \n";
    	
    	String whereSQL = "WHERE 1 = 1 AND a.USE = b.CODE \n"+
    	*/
    /*	String selectSQL=
    		"	SELECT '0' AS CHECKER,UPD_DT_OLD,substr(replace(INS_DT,'-',''),1,8) AS INS_DT,CIV_RECV_NUM,RECV_NUM,SUV_NAME,SIWORK_NAME,SPOTNM,WORK_ITEM,decode(USE_ETC,'',COM.CODE_NAME,USE_ETC,COM.CODE_NAME||','||USE_ETC) AS USE \n";
    	*/
    	String selectSQL=
    		"	SELECT '0' AS CHECKER,UPD_DT_OLD,substr(replace(UPD_DT_OLD,'-',''),1,8) AS INS_DT,CIV_RECV_NUM,RECV_NUM,SUV_NAME,SIWORK_NAME,SPOTNM,WORK_ITEM,decode(USE_ETC,'',COM.CODE_NAME,USE_ETC,COM.CODE_NAME||','||USE_ETC) AS USE \n";
    
    	String fromSQL = " FROM PT_UB_SUVSPOT UB left join PT_COM_CODE COM ON  UB.USE=COM.CODE\n";
    	
    	String whereSQL = "WHERE 1 = 1  \n"+
    	
    					  "  AND SIDO_CODE = '"+SIDO_CODE+"'"+
    					  "  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'";
    	
    	
    	if(!KJFUtil.isEmpty(scSUV_NAME)){
    		whereSQL += "AND SUV_NAME LIKE '%"+scSUV_NAME+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scSUV_NM)){
    		whereSQL += "AND SUV_NM LIKE '%"+scSUV_NM+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scSIWORK_NAME)){
    		whereSQL += "AND SIWORK_NAME LIKE '%"+scSIWORK_NAME+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scSIWORK_REP)){
    		whereSQL += "AND SIWORK_REP LIKE '%"+scSIWORK_REP+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scSPOTNM)){
    		whereSQL += "AND SPOTNM LIKE '"+scSPOTNM+"%'";
    	}
    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    		//whereSQL += "AND substr(replace(INS_DT,'-',''),1,8) BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
    		whereSQL += "AND UPD_DT_OLD BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
    	}
    	
    	String orderSQL = "ORDER BY UPD_DT_OLD DESC";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}