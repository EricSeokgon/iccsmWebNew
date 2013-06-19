/**
 * 파일명   : RegMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.sys_m.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class MyinfoMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public MyinfoMgrCmd() {
    }

    public MyinfoMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();

        String scOFFI_ID = vl.getValueAsString("scOFFI_ID");

    	sQuery.append(" SELECT PASS,offi_id,nm,tel,sido_code,sigungu_code,part,pos,group_code,recv_div,home_group,"); 
    	sQuery.append(" tel1,tel2,tel3,mobile1,mobile2,mobile3,fax1,fax2,fax3,e_mail,recv_id,offseal FROM PT_MI_USER");
		sWhere.append(" WHERE 1 = 1 ");
		sWhere.append(" AND OFFI_ID = '" + scOFFI_ID + "' ");
		
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        String UB_SERVER[]= null;
        //String ub_temp = "";
        //ub_temp = Config.props.get("UB_ENDPOINT");
        
//        String uSIGUNGU_CODE = rEntity.getValue(0, "SIGUNGU_CODE");
//        String ubSIGUNGU_CODE = "";
        String b_target_server = "false";
//        if (ub_temp.indexOf("/") >= 0){
//	        UB_SERVER = ub_temp.split("/");
//	        for (int i = 0; i < UB_SERVER.length; i++){
//	        	ubSIGUNGU_CODE = UB_SERVER[i];
//	        	if (uSIGUNGU_CODE.equals(ubSIGUNGU_CODE)){
//	        		b_target_server = "true";
//	        	}
//	        }        
//        } else {
//        	if (uSIGUNGU_CODE.equals(ub_temp)){
//        		b_target_server = "true";
//        	}
//        }

        b_target_server = "true"; // 2010-02-08 박동호 주사님 요청으로 시군구 사용자들 먼저 테스트용으로 사용하므로 활성화 시킴 

        Dataset ds = new Dataset("output2");
        ds.addColumn("TARGET_SERVER",ColumnInfo.CY_COLINFO_STRING, 10);   
        int row = ds.appendRow();
        ds.setColumn(row, "TARGET_SERVER", b_target_server);
		dl.addDataset(ds);
		
        request.setAttribute("dl", dl); 
        return next;
    }
}