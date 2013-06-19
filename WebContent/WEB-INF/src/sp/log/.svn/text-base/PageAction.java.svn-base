package sp.log;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.log.cmd.*;

public class PageAction extends KJFAction{

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
		KJFCommand cmd = lookupCommand(request.getParameter("cmd"));         
		
		return cmd.execute(request, form) ; 
	} 
	
    /**
     * Command들을 등록한다.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        //프로그램 등록
        commands.put("PageMgrL",                  	new PageMgrLCmd("/homepage/log/PageMgrL.jsp"));
        commands.put("PageMgrW",                  	new PageMgrWCmd("/homepage/log/PageMgrW.jsp"));
        commands.put("PageMgrR",                  	new PageMgrRCmd("/homepage/log/PageMgrR.jsp"));
        
        commands.put("PageMgrC",                  	new PageMgrCUDCmd("/homepage/log/PageAction.do?cmd=PageMgrL"));
        commands.put("PageMgrU",                  	new PageMgrCUDCmd("/homepage/log/PageAction.do?cmd=PageMgrL"));
        commands.put("PageMgrD",                  	new PageMgrCUDCmd("/homepage/log/PageAction.do?cmd=PageMgrL"));
        
    }	
    
    /**
     * 요청받은 명령의 Command instance를 구한다.
     * @param cmd 명령명
     * @return Command class instance
     */
    private KJFCommand lookupCommand(String cmd) throws Exception{
        if (commands.containsKey(cmd)) {
            return (KJFCommand)commands.get(cmd);
        }else{
            throw new Exception("Invalid Command Identifier");
        }
    }//end lookupCommand

}
