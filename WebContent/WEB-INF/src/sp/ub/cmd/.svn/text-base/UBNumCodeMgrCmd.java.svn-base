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
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBNumCodeMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBNumCodeMgrCmd() {
    }

    public UBNumCodeMgrCmd(String next_url) {
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
        
    	String selectSQL=
    		"	SELECT COUNT(*) AS CNT		\n" +
    		"	  FROM PT_UB_USEBEFORE			\n";
    	
    	String whereSQL = "WHERE CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'";
    		
    	rEntity    = rDAO.select(selectSQL+whereSQL);        
    	
    	 String type = "Y";
         
         if(rEntity != null){
         	if(rEntity.getRowCnt() > 0){
         		if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
         			type = "N";
         		}
         	}
         }
         
         Dataset ds = new Dataset("output");
 		
 		ds.addColumn("CHKYN",ColumnInfo.CY_COLINFO_STRING, 20);
 		
 		int row = ds.appendRow();
 		ds.setColumn(row, "CHKYN", type);
                
        request.setAttribute("dl", dl);  

        return next;
    }
    
    


}