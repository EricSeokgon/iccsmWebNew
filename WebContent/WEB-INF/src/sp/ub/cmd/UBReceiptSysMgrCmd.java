/**
 * 파일명   : UBReceiptSysMgrCmd.java
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
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBReceiptSysMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBReceiptSysMgrCmd() {
    }

    public UBReceiptSysMgrCmd(String next_url) {
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
		
		System.out.println("scSIDO  "+SIDO_CODE);
		String selectSQL	= " SELECT SERVER_YN, GROUPWARE_MODULE_TYPE \n";
		
		String fromSQL		= "  FROM PT_S_SYSVAR_MASTER   \n";

		String whereSQL		= " WHERE 1 = 1    \n";

		whereSQL += "      AND SIDO_CODE = '" + SIDO_CODE + "'       \n";
		whereSQL += "	   AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "' \n"; 
		whereSQL += "	   AND SERVER_ADDR IS NOT NULL AND SEND_SYS_ID IS NOT NULL AND RECV_SYS_ID IS NOT NULL \n";
		whereSQL += "	   AND SERVER_YN  = '1' \n";
		
		rEntity = rDAO.select( selectSQL + fromSQL + whereSQL );

        String b_target_server = "false";
        
        if (rEntity.getRowCnt() > 0 ){
        	if ("P".equals(KJFUtil.print(rEntity.getValue(0, "GROUPWARE_MODULE_TYPE"),""))){
        		b_target_server ="true";
        	}
        }
        Dataset ds = new Dataset("output");
        ds.addColumn("TARGET_SERVER",ColumnInfo.CY_COLINFO_STRING, 10);   
        int row = ds.appendRow();
        ds.setColumn(row, "TARGET_SERVER", b_target_server);
		dl.addDataset(ds);
		request.setAttribute("dl", dl); 

// 프로퍼티 설정값
/*		
        String UB_SERVER[]= null;
        String ub_temp = "";
        ub_temp = Config.props.get("UB_ENDPOINT");
        
        String uSIGUNGU_CODE = SIGUNGU_CODE;
        String ubSIGUNGU_CODE = "";
        String b_target_server = "false";
        if (ub_temp.indexOf("/") >= 0){
	        UB_SERVER = ub_temp.split("/");
	        for (int i = 0; i < UB_SERVER.length; i++){
	        	ubSIGUNGU_CODE = UB_SERVER[i];
	        	if (uSIGUNGU_CODE.equals(ubSIGUNGU_CODE)){
	        		b_target_server = "true";
	        	}
	        }        
        } else {
        	if (uSIGUNGU_CODE.equals(ub_temp)){
        		b_target_server = "true";
        	}
        }
        
        Dataset ds = new Dataset("output");
        ds.addColumn("TARGET_SERVER",ColumnInfo.CY_COLINFO_STRING, 10);   
        int row = ds.appendRow();
        ds.setColumn(row, "TARGET_SERVER", b_target_server);
		dl.addDataset(ds);
		request.setAttribute("dl", dl); 
*/		
 

        return next;
    }
}
