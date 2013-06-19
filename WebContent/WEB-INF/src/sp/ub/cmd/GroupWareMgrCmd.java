/**
 * ���ϸ�   : GroupWareMgrCmd.java
 * ����     : ����� ���ڰ��� ���� cmd
 * �̷»���
 * CH00     : 2009/09/01 ���ν� �����ۼ�
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
    	
    	GrpHCmd GrpHCmd =new GrpHCmd(); // �ϳ�����
    	GrpPCmd GrpPCmd =new GrpPCmd(); // ������Ƽ
    	
        /****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** ���� ȹ�� **/
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