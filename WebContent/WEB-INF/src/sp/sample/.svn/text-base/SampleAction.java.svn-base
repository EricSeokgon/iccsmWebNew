/**
 * 파일명    : SampleAction.java 
 * 설명      : Sample 메인관리 Action 
 * 이력사항
 *
 */

package sp.sample; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFMiAction;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.sample.cmd.*;

public class SampleAction extends KJFMiAction{

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

        commands.put("RegReceiptMgr", new RegReceiptMgrCmd("dtsList"));
        commands.put("RegReceiptMgrC", new RegReceiptMgrCCmd("dtsList"));
        //commands.put("RegReceiptMgrCCUD", new RegReceiptMgrCCUDCmd("/sample/sample_mAction.do?cmd=RegReceiptMgrC"));
        commands.put("RegReceiptMgrCCUD", new RegReceiptMgrCCUDCmd("dtsList"));
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
