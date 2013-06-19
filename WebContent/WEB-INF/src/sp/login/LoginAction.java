/**
 * 파일명    : LoginAction.java 
 * 설명      : login 메인관리 Action 
 * 이력사항
 * CH00      :2004/01/02 김경덕 최초작성 
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
	
	private HashMap commands; //명령패턴 class들
        	
    /**
     * 개별Command들을 실행한다.
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
     * Command들을 등록한다.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        //프로그램 등록
        commands.put("LoginAdmin",			new LoginCmd("/main/MainFrame.jsp"));//로그인
        commands.put("LoginLife",			new LoginLeftCmd("/com/sessionCheck.jsp"));//로그인
        commands.put("LogOut",              new LogOutCmd("/login/Login.jsp"));//로그인
        
        commands.put("PdaLoginMgr",			new PdaLoginMgrCmd("/pda/loginpage.jsp"));//로그인
    }	
	
	
    /**
     * 요청받은 명령의 Command instance를 구한다.
     * @param cmd 명령명
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
