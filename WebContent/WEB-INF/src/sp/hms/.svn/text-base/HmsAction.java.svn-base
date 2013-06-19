package sp.hms;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.hms.cmd.HmsCodeMgrCUDCmd;
import sp.hms.cmd.HmsCodeMgrCmd;
import sp.hms.cmd.HmsContentCmd;
import sp.hms.cmd.HmsCtrlCUDCmd;
import sp.hms.cmd.HmsCtrlMgrCmd;
import sp.hms.cmd.HmsCtrlWCmd;
import sp.hms.cmd.HmsPreviewCmd;

public class HmsAction  extends KJFAction {
    
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
        KJFCommand cmd = lookupCommand( (KJFUtil.print(request.getParameter("cmd"), "HmsCtrMgr")));

        return cmd.execute(request, form);
    }


    /**
     * Command들을 등록한다.
     * @param
     * @return
     */
    private void initCommands() {
        commands = new HashMap();      
        
        commands.put("HmsView",         new HmsContentCmd());      // HTML 메뉴코드 검색
        
        // HTML 컨텐츠 관리자
        commands.put("HmsCtrlMgr",      new HmsCtrlMgrCmd("/hms/HmsCtrlMgr.jsp"));                // HTML 리스트
        commands.put("HmsCtrlW",        new HmsCtrlWCmd("/hms/HmsCtrlW.jsp"));                    // HTML 쓰기
        commands.put("HmsCtrlC",        new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlMgr"));   // HTML 등록
        commands.put("HmsCtrlU",        new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlW"));     // HTML 수정
        commands.put("HmsCtrlD",        new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlMgr"));   // HTML 삭제
                
        // HTML 컨텐츠 관리
        commands.put("HmsHistoryD",     new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlW"));     // HTML 히스토리 삭제
        commands.put("HmsHistoryU",     new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlW"));     // HTML 히스토리 수정  
        
        // HTML 컨텐츠 미리보기
        commands.put("HmsPreView",      new HmsPreviewCmd("/hms/HmsPreview.jsp"));
        
        // HTML 코드 관리
        commands.put("HmsCodeMgr",      new HmsCodeMgrCmd("/hms/HmsCodeMgr.jsp"));                  // HTML 공통코드 관리
        commands.put("HmsCodeMgrCUD",   new HmsCodeMgrCUDCmd("/hms/HmsAction.do?cmd=HmsCodeMgr"));  // HTML 공통코드 관리 CUD        
    }    


    /**
     * 요청받은 명령의 Command instance를 구한다.
     * @param cmd 명령명
     * @return Command class instance
     */
    private KJFCommand lookupCommand(String cmd) throws Exception {
        
    	if (commands.containsKey(cmd)) {
            return (KJFCommand)commands.get(cmd);
        }else{
            throw new Exception("Invalid Command Identifier");
        }
    }
}
