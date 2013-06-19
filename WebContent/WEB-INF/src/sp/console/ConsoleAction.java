package sp.console;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.console.cmd.ConsoleStatusCmd;

public class ConsoleAction extends KJFAction {
    
    /** 명령패턴 class들 **/
    private HashMap commands; 

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
                                HttpServletResponse response) throws Exception {

        initCommands();
        KJFCommand cmd = lookupCommand( (KJFUtil.print(request.getParameter("cmd"),"BbsKList")));

        return cmd.execute(request, form) ;
    }


    /**
     * Command들을 등록한다.
     * @param
     * @return
     */
    private void initCommands(){

        commands = new HashMap();
     
        commands.put("ConsoleStatus",   new ConsoleStatusCmd("/console/Consol_01.jsp"));   // 정보통신공사 업무 현황
    }    


    /**
     * 요청받은 명령의 Command instance를 구한다.
     * @param cmd 명령명
     * @return Command class instance
     */
    private KJFCommand lookupCommand(String cmd) throws Exception {
        
        if (commands.containsKey(cmd)) {
            return (KJFCommand)commands.get(cmd);
            
        } else {
            throw new Exception("Invalid Command Identifier:" + cmd );
        }
    }
}
