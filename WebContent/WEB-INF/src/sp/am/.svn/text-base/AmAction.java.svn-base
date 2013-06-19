/**
 * 파일명    : AmAction.java 
 * 설명      : Am 메인관리 Action 
 * 이력사항
 *
 */

package sp.am; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFMiAction;
import sp.am.cmd.AMCodeCCmd;
import sp.am.cmd.ActualInvestMgrCUDCmd;
import sp.am.cmd.ActualInvestMgrCmd;
import sp.am.cmd.AmReceiptMgr;
import sp.am.cmd.AmReceiptMgrC;
import sp.am.cmd.AmReceiptMgrCUDCmd;
import sp.am.cmd.AmReceiptMgrCUD_NewCmd;
import sp.am.cmd.AmReceiptMgrC_New;
import sp.am.cmd.AmReceiptMgrC_New2;
import sp.am.cmd.AmReceiptMgr_New;
import sp.am.cmd.CancelMgrCCmd;
import sp.am.cmd.CancelMgrCUDCmd;
import sp.am.cmd.CancelMgrCmd;
import sp.am.cmd.CorrectMgrCCmd;
import sp.am.cmd.CorrectMgrCUDCmd;
import sp.am.cmd.CorrectMgrCmd;
import sp.am.cmd.FineMgrCCmd;
import sp.am.cmd.FineMgrCUDCmd;
import sp.am.cmd.FineMgrCmd;
import sp.am.cmd.IncidenceMgrCCmd;
import sp.am.cmd.IncidenceMgrCUDCmd;
import sp.am.cmd.IncidenceMgrCmd;
import sp.am.cmd.StopIncidenceMgrCCmd;
import sp.am.cmd.StopIncidenceMgrCUDCmd;
import sp.am.cmd.StopIncidenceMgrCmd;
import sp.am.cmd.StopMgrCCmd;
import sp.am.cmd.StopMgrCUDCmd;
import sp.am.cmd.StopMgrCmd;
import sp.am.cmd.WarnMgrCCmd;
import sp.am.cmd.WarnMgrCUDCmd;
import sp.am.cmd.WarnMgrCmd;

public class AmAction extends KJFMiAction{

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
      
        
        //공사업 신규개발 행정처분
        commands.put("AmReceiptMgr_New", new AmReceiptMgr_New("dtsList"));
        commands.put("AmReceiptMgrC_New", new AmReceiptMgrC_New("dtsList"));
        commands.put("AmReceiptMgrC_New2", new AmReceiptMgrC_New2("dtsList"));
        commands.put("AmReceiptMgrCUD_New", new AmReceiptMgrCUD_NewCmd("dtsList"));;
        //개별 cmd를 여기에 등록한다.
        
        commands.put("AmReceiptMgr", new AmReceiptMgr("dtsList"));
        commands.put("AmReceiptMgrC", new AmReceiptMgrC("dtsList"));
        commands.put("AMCodeC", new AMCodeCCmd("dtsList"));
        commands.put("AmReceiptMgrCUD", new AmReceiptMgrCUDCmd("dtsList"));
        
        commands.put("StopMgr", new StopMgrCmd("dtsList"));
        commands.put("StopMgrC", new StopMgrCCmd("dtsList"));
        commands.put("StopMgrCUD", new StopMgrCUDCmd("dtsList"));
        
        commands.put("CancelMgr", new CancelMgrCmd("dtsList"));
        commands.put("CancelMgrC", new CancelMgrCCmd("dtsList"));
        commands.put("CancelMgrCUD", new CancelMgrCUDCmd("dtsList"));
        
        commands.put("IncidenceMgrC", new IncidenceMgrCCmd("dtsList"));
        commands.put("IncidenceMgr", new IncidenceMgrCmd("dtsList"));
        commands.put("IncidenceMgrCUD", new IncidenceMgrCUDCmd("dtsList"));
        
        commands.put("FineMgrC", new FineMgrCCmd("dtsList"));
        commands.put("FineMgr", new FineMgrCmd("dtsList"));
        commands.put("FineMgrCUD", new FineMgrCUDCmd("dtsList"));
        
        commands.put("CorrectMgrC", new CorrectMgrCCmd("dtsList"));
        commands.put("CorrectMgr", new CorrectMgrCmd("dtsList"));
        commands.put("CorrectMgrCUD", new CorrectMgrCUDCmd("dtsList"));
        
        commands.put("WarnMgrC", new WarnMgrCCmd("dtsList"));
        commands.put("WarnMgr", new WarnMgrCmd("dtsList"));
        commands.put("WarnMgrCUD", new WarnMgrCUDCmd("dtsList"));
        
        commands.put("ActualInvestMgrCUD", new ActualInvestMgrCUDCmd("dtsList"));
        commands.put("ActualInvestMgr", new ActualInvestMgrCmd("dtsList"));
        
        commands.put("StopIncidenceMgr", new StopIncidenceMgrCmd("dtsList"));
        commands.put("StopIncidenceMgrC", new StopIncidenceMgrCCmd("dtsList"));
        commands.put("StopIncidenceMgrCUD", new StopIncidenceMgrCUDCmd("dtsList"));
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
