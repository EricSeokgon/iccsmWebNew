/**
 * 파일명    : Main_mAction.java 
 * 설명      : Main_m 메인관리 Action 
 * 이력사항
 *
 */

package sp.main_m; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFMiAction;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.main_m.cmd.*; 



public class Main_mAction extends KJFMiAction{

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
      
        //개별 cmd를 여기에 등록한다.
        commands.put("CenterBoardSIDOMgr",    new CenterBoardSIDOMgrCmd("dtsList"));// 착공전설계도  접수 번호 중복 체크 
        commands.put("CenterBoardSIGUNGUMgr",    new CenterBoardSIGUNGUMgrCmd("dtsList"));// 착공전설계도  접수 번호 중복 체크

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
