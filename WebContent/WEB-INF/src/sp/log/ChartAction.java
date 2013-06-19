package sp.log;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.log.cmd.PageDAYChartCmd;
import sp.log.cmd.PageHOURChartCmd;
import sp.log.cmd.UserDAYChartCmd;
import sp.log.cmd.UserHOURChartCmd;

public class ChartAction extends KJFAction{
	
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
        commands.put("UserDAYChart",		new UserDAYChartCmd(""));//일자별 방문자
        commands.put("PageDAYChart",		new PageDAYChartCmd(""));//일자별 페이지 뷔 
        commands.put("PageHOURChart",		new PageHOURChartCmd(""));//시간별 페이지 뷔
        commands.put("UserHOURChart",		new UserHOURChartCmd(""));//시간별 방문자  
        
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
