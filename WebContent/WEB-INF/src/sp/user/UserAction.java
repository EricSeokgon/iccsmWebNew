/**
 * 파일명    : BbsAction.java 
 * 설명      : bbs 메인관리 Action 
 * 이력사항
 * CH00      :2004/01/02 김경덕 최초작성 
 */

package sp.user; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFAction;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sp.user.cmd.*;



public class UserAction extends KJFAction{
	
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
      
        //사용자 관리
        commands.put("UserMgr",               	  new UserMgrCmd("/user/UserMgr.jsp"));//리스트
        commands.put("UserMgrV",                  new UserMgrVCmd("/user/UserMgrV.jsp"));//상세 보기
        commands.put("UserMgrW",                  new UserMgrWCmd("/user/UserMgrW.jsp"));// 등록
        commands.put("UserMgrC",                  new UserMgrCUDCmd("/user/UserAction.do?cmd=UserMgr"));//등록 처리
        commands.put("UserMgrU",                  new UserMgrCUDCmd("/user/UserAction.do?cmd=UserMgrV"));//수정 처리
        commands.put("UserMgrD",                  new UserMgrCUDCmd("/user/UserAction.do?cmd=UserMgr"));//삭제 처리
        
        commands.put("ZipSearch",             	  new UserZipSearchCmd("/com/post_search.jsp"));//삭제 처리
        commands.put("UserIDCheck",               new UserIDCheckCmd("/user/id_check.jsp"));//아이디 검사
        commands.put("UserFind",				  new UserFindCmd("/user/id_search.jsp"));//아이디패스워드찾기

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
