/**
 * 파일명    : AmrAction.java 
 * 설명      : Amr 메인관리 Action 
 * 이력사항
 *
 */

package sp.amr; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFAction;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.amr.cmd.*;



public class AmrAction extends KJFAction{

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
        //공사업 신규개발 행정처분
        commands.put("AmReceiptMgr", new AmReceiptMgr("dtsList"));
        commands.put("AmReceiptMgrC", new AmReceiptMgrC("dtsList"));
        commands.put("AmReceiptMgrCUD", new AmReceiptMgrCUDCmd("dtsList"));
        commands.put("FineReceiptMgr", new FineReceiptMgr("dtsList"));
        commands.put("WaringResultStMgr", new WaringResultStMgrCmd("dtsList")); //경고대장
        commands.put("StopResultStMgr", new StopResultStMgrCmd("dtsList"));  //영업정지대장
        commands.put("RegCancelResultStMgr", new  RegCancelResultStMgrCmd("dtsList"));//등록취소대장
        commands.put("FineResultStMgr", new  FineResultStMgrCmd("dtsList"));//과태료처분대장
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
