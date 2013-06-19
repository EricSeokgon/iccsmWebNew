package sp.bbs ;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.bbs.cmd.BbsCodeMgrCUDCmd;
import sp.bbs.cmd.BbsCodeMgrCmd;
import sp.bbs.cmd.BbsCtrlCUDCmd;
import sp.bbs.cmd.BbsCtrlMgrCmd;
import sp.bbs.cmd.BbsCtrlVCmd;
import sp.bbs.cmd.BbsCtrlWCmd;
import sp.bbs.cmd.BbsKCUDCmd;
import sp.bbs.cmd.BbsKListCmd;
import sp.bbs.cmd.BbsKViewCmd;
import sp.bbs.cmd.BbsKWriteCmd;
import sp.bbs.cmd.BbsKscFAQCdCmd;
import sp.bbs.cmd.BbsKscSggCdCmd;

/**
 * <p>Title       : BbsAction Class</p>
 * <p>Description : bbs 메인관리 Action 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : bbs 메인관리 Action 처리를 한다. 
 * 
 * @version 1.0
 * @author  PKT
 */
public class BbsAction extends KJFAction{
    
    /** 명령패턴 class들 **/
	private HashMap commands; 

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
					            HttpServletResponse response) throws Exception {

	    initCommands();
	    KJFCommand cmd = lookupCommand( (KJFUtil.print(request.getParameter("cmd"),"BbsKList")));

	    return cmd.execute(request, form) ;
	}


    /**
     * Command들을 등록한다.
     * @param
     * @return
     */
    private void initCommands(){

        commands = new HashMap();
        
        // 게시판
        commands.put("BbsKList",        new BbsKListCmd());     // 게시물 리스트
        commands.put("BbsKWrite",       new BbsKWriteCmd());    // 게시물 쓰기
        commands.put("BbsKView",        new BbsKViewCmd());     // 게시물 상세보기
         
        commands.put("BbsKC",           new BbsKCUDCmd("/bbs/BbsAction.do?cmd=BbsKList"));      // 게시판 입력
        commands.put("BbsKR",           new BbsKCUDCmd("/bbs/BbsAction.do?cmd=BbsKList"));      // 게시판 답변
        commands.put("BbsKU",           new BbsKCUDCmd("/bbs/BbsAction.do?cmd=BbsKView"));      // 게시판 수정
        commands.put("BbsKD",           new BbsKCUDCmd("/bbs/BbsAction.do?cmd=BbsKList"));      // 게시판 삭제
        commands.put("BbsLD",           new BbsKCUDCmd("/bbs/BbsAction.do?cmd=BbsKList"));      // 게시판 삭제

        commands.put("BbsKFileDel",     new BbsKCUDCmd("/bbs/BbsAction.do?cmd=BbsKWrite"));     // 첨부파일 삭제
        
        commands.put("BbsLSggCd",       new BbsKscSggCdCmd("/bbs/BbsLscSggCd.jsp"));  // 시군구 코드 검색        
        commands.put("BbsWSggCd",       new BbsKscSggCdCmd("/bbs/BbsWscSggCd.jsp"));  // 시군구 코드 검색      

        // 게시판 관리
        commands.put("BbsCtrlMgr",      new BbsCtrlMgrCmd("/bbs/BbsCtrlMgr.jsp"));              // 게시판 설정 리스트
        commands.put("BbsCtrlV",        new BbsCtrlVCmd("/bbs/BbsCtrlV.jsp"));                  // 게시판 설정 상세 보기
        commands.put("BbsCtrlW",        new BbsCtrlWCmd("/bbs/BbsCtrlW.jsp"));                  // 게시판 설정 등록
        commands.put("BbsCtrlC",        new BbsCtrlCUDCmd("/bbs/BbsAction.do?cmd=BbsCtrlMgr")); // 게시판 생성
        commands.put("BbsCtrlU",        new BbsCtrlCUDCmd("/bbs/BbsAction.do?cmd=BbsCtrlW"));   // 게시판 수정
        commands.put("BbsCtrlD",        new BbsCtrlCUDCmd("/bbs/BbsAction.do?cmd=BbsCtrlMgr")); // 게시판 삭제
        commands.put("BbsCtrlTD",       new BbsCtrlCUDCmd("/bbs/BbsAction.do?cmd=BbsCtrlMgr")); // 게시판 초기화

        // 게시판 코드 관리
        commands.put("BbsCodeMgr",      new BbsCodeMgrCmd("/bbs/BbsCodeMgr.jsp"));                  // 게시판 공통코드 관리
        commands.put("BbsCodeMgrCUD",   new BbsCodeMgrCUDCmd("/bbs/BbsAction.do?cmd=BbsCodeMgr"));  // 게시판 공통코드 관리 CUD

        // 질의회신 분류 코드 
        commands.put("BbsLFAQCd",       new BbsKscFAQCdCmd());  // 질의회신 코드 검색        
        commands.put("BbsWFAQCd",       new BbsKscFAQCdCmd());  // 질의회신 코드 검색

    }    


    /**
     * 요청받은 명령의 Command instance를 구한다.
     * @param cmd 명령명
     * @return Command class instance
     */
    private KJFCommand lookupCommand(String cmd) throws Exception {
        
        if (commands.containsKey(cmd)) {
        	return (KJFCommand)commands.get(cmd);
            
        } else {
            throw new Exception("Invalid Command Identifier:" + cmd );
        }
    }
}
