/**
 * 파일명    : BasAction.java 
 * 설명      : Bas 메인관리 Action 
 * 이력사항
 *
 */

package sp.bas; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFMiAction;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.bas.cmd.*;
import sp.sys_m.cmd.ComCodeMgrCmd;

public class BasAction extends KJFMiAction{

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
        commands.put("PostStD",    new BasPostStDCmd("dtsList"));// 우편번호 검색
        commands.put("NewPostStD",    new NewBasPostStDCmd("dtsList"));// 새주소 우편번호 검색
        commands.put("ExperStD",    new BasExperStDCmd("dtsList"));// 기술자  검색
        commands.put("CMStD",    new BasCMStDCmd("dtsList"));// 공사업체   검색
        commands.put("ACMStD",    new BasACMStDCmd("dtsList"));// 행정처분 공사업체   검색
        commands.put("SidoCode", new BasSidoCodeCmd("dtsList"));// 시군구코드 검색
        commands.put("ComCodeStD", new BasComCodeStDCmd("dtsList"));// 코드  검색
        commands.put("ComCodeStDCUD", new ComCodeStDCmd("dtsList"));// 공통코드
        commands.put("ComCodeStDC", new ComCodeStDC("dtsList"));
        commands.put("ComCodeStDMgr", new ComCodeStDMgr("dtsList"));
        commands.put("ComCodeStDCombo", new  ComCodeStDCombo("dtsList"));
        commands.put("ComCodeDupChk", new   ComCodeDupChk("dtsList"));
        commands.put("CheckStD", new   CheckStDCmd("dtsList")); //확인사항 (흠결)
        commands.put("PaperStD", new   PaperStDCmd("dtsList")); //확인사항 (흠결)
            
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
