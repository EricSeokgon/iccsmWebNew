/**
 * 파일명    : StAction.java 
 * 설명      : St 메인관리 Action 
 * 이력사항
 *
 */

package sp.st; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFMiAction;
import sp.st.cmd.AddrChgListMgrCmd;
import sp.st.cmd.AllEngListMgrCmd;
import sp.st.cmd.EngineerChgListMgrCmd;
import sp.st.cmd.NameChgListMgrCmd;
import sp.st.cmd.ReacapChgListMgrCmd;
import sp.st.cmd.RepAMListMgrCmd;
import sp.st.cmd.RepnameChgListMgrCmd;
import sp.st.cmd.StTemplet;
import sp.st.cmd.StTempletLoad;
import sp.st.cmd.StTempletLoadXml;



public class StAction extends KJFMiAction{

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
        commands.put("StTemplet",    new StTemplet("dtsList"));
        commands.put("StTempletLoad",    new StTempletLoad("dtsList"));
        commands.put("StTempletLoadXml",    new StTempletLoadXml("dtsList"));

        
        //기술자 변경조회1
        commands.put("EngineerChgListMgr",    new EngineerChgListMgrCmd("dtsList"));
        //시도별기술자 조회
        commands.put("AllEngListMgr", new AllEngListMgrCmd("dtsList"));
        //등록취소 대표자 조회
        commands.put("RepAMListMgr", new RepAMListMgrCmd("dtsList"));
        //대표자 변경조회
        commands.put("RepnameChgListMgr",    new RepnameChgListMgrCmd("dtsList"));
        //소재지 변경조회
        commands.put("AddrChgListMgr",    new AddrChgListMgrCmd("dtsList"));
        //자본금 변경조회
        commands.put("ReacapChgListMgr",    new ReacapChgListMgrCmd("dtsList"));
        //상호 변경조회
        commands.put("NameChgListMgr",    new NameChgListMgrCmd("dtsList"));
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
