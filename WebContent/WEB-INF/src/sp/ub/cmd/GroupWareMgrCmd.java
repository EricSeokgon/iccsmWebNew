/**
 * 파일명   : GroupWareMgrCmd.java
 * 설명     : 사용전 전자결재 연동 cmd
 * 이력사항
 * CH00     : 2009/09/01 오두식 최초작성
 */

package sp.ub.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import sp.ub.cmd.modul1.GrpHCmd;
import sp.ub.cmd.modul2.GrpPCmd;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.VariableList;

public class GroupWareMgrCmd implements KJFCommand {
	
    private String next;	
    private VariableList vl = new VariableList();
    
    public GroupWareMgrCmd() {
    }

    public GroupWareMgrCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	UbParam pm = (UbParam)form;
    	
    	GrpHCmd GrpHCmd =new GrpHCmd(); // 하나인포
    	GrpPCmd GrpPCmd =new GrpPCmd(); // 피케이티
    	
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
    	String GroupWare_Gubun 		= KJFUtil.print(vl.getValueAsString("scGrpWareModule"),"P");
    	
    	if ("H".equals(GroupWare_Gubun)){
    		GrpHCmd.Grp_Exe(request, vl, pm); 
    	} else if ("P".equals(GroupWare_Gubun)){
    		GrpPCmd.Grp_Exe(request, vl, pm);
    	}
    	
        return next;
    }
}