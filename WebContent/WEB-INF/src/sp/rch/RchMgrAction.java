package sp.rch;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.rch.cmd.RchMgrCUDCmd;
import sp.rch.cmd.RchMgrCmd;

public class RchMgrAction extends KJFAction {

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
        
        commands.put("RchL",                  	new RchMgrCmd("/rch/researchList.jsp"));
        commands.put("RchRL",               	new RchMgrCmd("/rch/researchReadyList.jsp"));   
        commands.put("RchEL",               	new RchMgrCmd("/rch/researchEndList.jsp"));   
        commands.put("RchC",               		new RchMgrCmd("/rch/researchReg.jsp"));           
        commands.put("RchV",                  	new RchMgrCmd("/rch/researchView.jsp"));
        commands.put("RchU",                  	new RchMgrCmd("/rch/researchModify.jsp"));
        commands.put("Result",                  new RchMgrCmd("/rch/researchResult.jsp"));
        commands.put("RchExcel",                new RchMgrCmd("/rch/researchExcel.jsp"));
        
        commands.put("RchMgrCUD",               new RchMgrCUDCmd("/com/redirectPage.jsp"));

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
