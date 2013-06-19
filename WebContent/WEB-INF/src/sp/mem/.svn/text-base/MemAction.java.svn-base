package sp.mem; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.mem.cmd.MemHomePageCompulsionMgrLCmd;
import sp.mem.cmd.MemHomePageJoinMgrLCmd;
import sp.mem.cmd.MemHomePageMgrCUDCmd;
import sp.mem.cmd.MemHomePageSecedeMgrLCmd;



public class MemAction extends KJFAction {
	
    /** 명령패턴 class들 */
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
        KJFCommand cmd = lookupCommand(request.getParameter("cmd"));         
    
        return cmd.execute(request, form) ; 
	} 
	
	
    /**
     * Command들을 등록한다.
     * @param 
     * @return       
     */
    private void initCommands() {

        commands = new HashMap();
        
        commands.put("MemHomePageJoinMgrL",         new MemHomePageJoinMgrLCmd("/member/MemHomePageJoinMgrL.jsp"));             // 가입사용자 리스트
        commands.put("MemHomePageSecedeMgrL",       new MemHomePageSecedeMgrLCmd("/member/MemHomePageSecedeMgrL.jsp"));         // 탈퇴사용자 리스트
        commands.put("MemHomePageCompulsionMgrL",   new MemHomePageCompulsionMgrLCmd("/member/MemHomePageCompulsionMgrL.jsp")); // 강제탈퇴 리스트
        
        commands.put("MemHomePageSecedeU",          new MemHomePageMgrCUDCmd("/member/MemAction.do?cmd=MemHomePageJoinMgrL"));            // 사용자 강제탈퇴
        commands.put("MemHomePageUseU",             new MemHomePageMgrCUDCmd("/member/MemAction.do?cmd=MemHomePageJoinMgrL"));            // 사용자 사용전환
        commands.put("MemHomePageMgrD",	            new MemHomePageMgrCUDCmd("/member/MemAction.do?cmd=MemHomePageJoinMgrL"));            // 사용자 정보삭제
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
            throw new Exception("Invalid Command Identifier");
        }
    }
}
