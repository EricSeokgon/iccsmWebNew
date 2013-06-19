package sp.log;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.log.cmd.*;

public class LogAction extends KJFAction{

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
      
        //개별 cmd를 여기에 등록한다.
        
        commands.put("PageDAY",			new LogMgr("/homepage/log/PageDAY.jsp"));//일자별 페이지 뷔
        commands.put("PageHOUR",		new LogMgr("/homepage/log/PageHOUR.jsp"));//일자별 페이지 뷔
        commands.put("UserDAY",			new LogMgr("/homepage/log/UserDAY.jsp"));//일자별 페이지 뷔
        commands.put("UserHOUR",		new LogMgr("/homepage/log/UserHOUR.jsp"));//일자별 페이지 뷔

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
