/**
 * 파일명    : Sys_mAction.java 
 * 설명      : Sys_m 메인관리 Action 
 * 이력사항
 *
 */

package sp.sys_m; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFMiAction;
import sp.sys_m.cmd.*;



public class Sys_mAction extends KJFMiAction{

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
	
	        return cmd.execute(request, form); 
	} 
	
	
    /**
     * Command들을 등록한다.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        //개별 cmd를 여기에 등록한다.

        // 공통코드 관리
        commands.put("ComCodeMgr",    new ComCodeMgrCmd("dtsList"));// 공통코드 관리
        commands.put("ComCodeMgrL",   new ComCodeMgrLCmd("dtsList"));		// 공통코드 관리 리스트
        commands.put("ComCodeMgrCUD", new ComCodeMgrCUDCmd("/sys_m/Sys_mAction.do?cmd=ComCodeMgr"));	// 공통코드 CUD
      
        commands.put("SidoCodeMgr", new  SidoCodeMgrCmd("dtsList")); // 시고코드 관리
        commands.put("SidoCodeMgrC", new  SidoCodeMgrCCmd("dtsList")); // 시고코드 관리
        commands.put("SidoCodeMgrCUD", new  SidoCodeMgrCUDCmd("dtsList")); // 시고코드 관리 CUD
        
        commands.put("UserMgr", new  UserMgrCmd("dtsList")); // 회원 관리
        commands.put("UserMgrC", new  UserMgrCCmd("dtsList")); // 회원  검색 리스트
        commands.put("UserMgrCUD", new  UserMgrCUDCmd("dtsList")); // 회원  관리 CUD
        
        // 신규 회원용
        commands.put("UserMgrBasicCUD", new  UserMgrBasicCUDCmd("dtsList")); // 회원  관리 CUD
        commands.put("UserMgrBasic", new  UserMgrBasicCmd("dtsList")); // 회원 관리
        commands.put("UserMgrBasicC", new  UserMgrBasicCCmd("dtsList")); // 회원  검색 리스트
        

        //우편번호검색
        commands.put("NewBasPostStD", new NewBasPostStDCmd("dtsList"));
        
        
        commands.put("SidoCode", new  SidoCodeCmd("dtsList")); // 시고코드 관리
        commands.put("MyinfoMgr", new  MyinfoMgrCmd("dtsList")); // 시고코드 관리
        
        commands.put("SysVarMgr", new  SysVarMgrCmd("dtsList")); // 지자체 시스템 변수 관리
        commands.put("SysVarMgrCUD", new  SysVarMgrCUDCmd("dtsList")); // 지자체 시스템 변수 관리 CUD
        
        commands.put("KICAIfSend", new  KICAIfSendCmd("dtsList")); // 협회전송 내역 조회
        commands.put("KICAIfSendCUD", new  KICAIfSendCUDCmd("dtsList")); // 협회전송 내역 조회
        commands.put("KICAIfRecv", new  KICAIfRecvCmd("dtsList")); // 협회수신내역 조회
        commands.put("KICAIfRecvCUD", new  KICAIfRecvCUDCmd("dtsList")); // 협회수신내역 조회
        
        
        commands.put("SiCodeMgr", new  SiCodeMgrCmd("dtsList")); // 회원  관리 CUD
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
