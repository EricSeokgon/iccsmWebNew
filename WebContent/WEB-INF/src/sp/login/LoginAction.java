/**
 * ���ϸ�    : LoginAction.java 
 * ����      : login ���ΰ��� Action 
 * �̷»���
 * CH00      :2004/01/02 ���� �����ۼ� 
 */


package sp.login ; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFAction;
import kjf.action.KJFCommandResp;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sp.login.cmd.*;

public class LoginAction extends KJFAction{
	
	private HashMap commands; //������� class��
        	
    /**
     * ����Command���� �����Ѵ�.
     * @param ActionMapping mapping,
     *         ActionForm form,
     *         HttpServletRequest request,
     *         HttpServletResponse response
     * @return  ActionForward    
     */

	public String executeAction(ActionMapping mapping,
							            ActionForm form,
							            HttpServletRequest request,
							            HttpServletResponse response) throws Exception{
		
		initCommands();		
        KJFCommandResp cmd = lookupCommand(request.getParameter("cmd"));         

        return  cmd.execute(request, response, form)  ; 
	} 
	
	
    /**
     * Command���� ����Ѵ�.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        //���α׷� ���
        commands.put("LoginAdmin",			new LoginCmd("/main/MainFrame.jsp"));//�α���
        commands.put("LoginLife",			new LoginLeftCmd("/com/sessionCheck.jsp"));//�α���
        commands.put("LogOut",              new LogOutCmd("/login/Login.jsp"));//�α���
        
        commands.put("PdaLoginMgr",			new PdaLoginMgrCmd("/pda/loginpage.jsp"));//�α���
    }	
	
	
    /**
     * ��û���� ����� Command instance�� ���Ѵ�.
     * @param cmd ��ɸ�
     * @return Command class instance
     */
    private KJFCommandResp lookupCommand(String cmd) throws Exception{
        if (commands.containsKey(cmd)) {
            return (KJFCommandResp)commands.get(cmd);
        }else{
            throw new Exception("Invalid Command Identifier");
        }
    }//end lookupCommand

		
}
