/**
 * 파일명    : SysAction.java 
 * 설명      : Sys 메인관리 Action 
 * 이력사항
 * CH00      :2006/04/19 김경덕 최초작성 
 */


package sp.sys ; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFAction;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.sys.cmd.*;



public class SysAction extends KJFAction{
	
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
	
        return  cmd.execute(request, form) ; 
	}
	
	
    /**
     * Command들을 등록한다.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        // 프로그램 그룹 관리
        commands.put("PgGrMgr",       new PgGrMgrCmd("/sys/PgGrMgr.jsp"));		// 프로그램 그룹 리스트
        commands.put("PgGrMgrL",      new PgGrMgrLCmd("/sys/PgGrMgrL.jsp"));		// 프로그램 리스트
        commands.put("PgGrMgrCUD",    new PgGrMgrCUDCmd("/sys/SysAction.do?cmd=PgGrMgr"));		// 프로그램 그룹 CUD
        
        // 프로그램 관리
        commands.put("PgMgr",         new PgMgrCmd("/sys/PgMgr.jsp"));			// 프로그램 트리
        commands.put("PgMgrL",        new PgMgrLCmd("/sys/PgMgrL.jsp"));			// 프로그램 리스트
        commands.put("PgMgrCUD",      new PgMgrCUDCmd("/sys/SysAction.do?cmd=PgMgrL"));		// 프로그램 CUD
        
        // DAO Auto Gen
        commands.put("DaoGen",     	  new DaoGenCmd("/sys/DaoGen.jsp"));		    // DAO 자동 생성        

        // Action Auto Gen
        commands.put("ActionGen",     new ActionGenCmd("/sys/ActionGen.jsp"));		// Action 자동 생성        

        // 공통코드 관리
        commands.put("ComCodeMgr",    new ComCodeMgrCmd("/sys/ComCodeMgr.jsp"));		// 공통코드 리스트
        commands.put("ComCodeMgrP",   new ComCodeMgrPCmd("/sys/ComCodeMgrP.jsp"));		// 공통코드 리스트
        commands.put("ComCodeMgrCUD", new ComCodeMgrCUDCmd("/sys/SysAction.do?cmd=ComCodeMgr"));	// 공통코드 CUD

        // 권한그룹 관리
        commands.put("AuthGrMgr",     new AuthGrMgrCmd("/sys/AuthGrMgr.jsp"));		// 권한그룹 리스트
        commands.put("AuthGrMgrCUD",  new AuthGrMgrCUDCmd("/sys/SysAction.do?cmd=AuthGrMgr"));	// 권한그룹 CUD
        
        // 권한별 프로그램  관리
        commands.put("AuthPgMgr",     new AuthPgMgrCmd("/sys/AuthPgMgr.jsp"));		// 권한별 프로그램 리스트
        commands.put("AuthPgMgrL",    new AuthPgMgrLCmd("/sys/AuthPgMgrL.jsp"));		// 권한별 프로그램 리스트
        commands.put("AuthPgMgrCUD",  new AuthPgMgrCUDCmd("/sys/SysAction.do?cmd=AuthPgMgrL"));	// 권한별 프로그램 CUD
        commands.put("AuthPgW",		  new AuthPgWCmd("/sys/SysAction.do?cmd=AuthPgMgr"));		// 권한별 프로그램 저장
        commands.put("AuthPgMgrUserL",    new AuthPgMgrUserLCmd("/sys/AuthPgMgrUserL.jsp"));    // 권한별 프로그램 사용자 리스트
        commands.put("AuthUserMgrPgL",    new AuthPgMgrLCmd("/sys/AuthUserMgrPgL.jsp"));     // 권한별 사용자 프로그램 리스트
         
        // 권한별 사용자 관리
        commands.put("AuthUserMgr",   new AuthUserMgrCmd("/sys/AuthUserMgr.jsp"));	// 권한별 사용자 리스트
        commands.put("AuthUserMgrL",  new AuthUserMgrLCmd("/sys/AuthUserMgrL.jsp"));	// 권한별 사용자 리스트
        commands.put("AuthUserMgrCUD",new AuthUserMgrCUDCmd("/sys/SysAction.do?cmd=AuthUserMgrL"));	// 권한별 사용자 CUD
        commands.put("AuthUserW",     new AuthUserWCmd("/sys/AuthUserMgr.jsp"));		// 권한별 사용자 저장
        
        // 프로그램 로그 관리
        commands.put("PgLogL",        new PgLogLCmd("/sys/PgLogL.jsp"));	        // 프로그램 로그 리스트
        commands.put("PgLogCUD",      new PgLogCUDCmd("/sys/SysAction.do?cmd=PgLogL"));	    // 프로그램 로그 CUD

        // 접속 로그 관리
        commands.put("ConnLogL",      new ConnLogLCmd("/sys/ConnLogL.jsp"));	    // 접속 로그 리스트
        commands.put("ConnLogCUD",    new ConnLogCUDCmd("/sys/SysAction.do?cmd=ConnLogL"));	    // 접속 로그 CUD
        
        //협회데이타연계스케쥴관리
        commands.put("KicaLinkMgr",        new KicaLinkMgrCmd("/sys/KicaLinkMgr.jsp"));	        // 프로그램 로그 리스트
        //백업스케쥴관리
        commands.put("BackupLinkMgr",        new BackupLinkMgrCmd("/sys/BackupLinkMgr.jsp"));	        // 프로그램 로그 리스트
        
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
            throw new Exception("Invalid Command Identifier : "+cmd);
        }
    }//end lookupCommand

		
}
