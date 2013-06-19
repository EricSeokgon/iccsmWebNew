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
    
    /** ������� class�� **/
    private HashMap commands; 

    /**
     * ����Command���� �����Ѵ�.
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
     * Command���� ����Ѵ�.
     * @param
     * @return
     */
    private void initCommands() {
        commands = new HashMap();      
        
        commands.put("HmsView",         new HmsContentCmd());      // HTML �޴��ڵ� �˻�
        
        // HTML ������ ������
        commands.put("HmsCtrlMgr",      new HmsCtrlMgrCmd("/hms/HmsCtrlMgr.jsp"));                // HTML ����Ʈ
        commands.put("HmsCtrlW",        new HmsCtrlWCmd("/hms/HmsCtrlW.jsp"));                    // HTML ����
        commands.put("HmsCtrlC",        new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlMgr"));   // HTML ���
        commands.put("HmsCtrlU",        new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlW"));     // HTML ����
        commands.put("HmsCtrlD",        new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlMgr"));   // HTML ����
                
        // HTML ������ ����
        commands.put("HmsHistoryD",     new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlW"));     // HTML �����丮 ����
        commands.put("HmsHistoryU",     new HmsCtrlCUDCmd("/hms/HmsAction.do?cmd=HmsCtrlW"));     // HTML �����丮 ����  
        
        // HTML ������ �̸�����
        commands.put("HmsPreView",      new HmsPreviewCmd("/hms/HmsPreview.jsp"));
        
        // HTML �ڵ� ����
        commands.put("HmsCodeMgr",      new HmsCodeMgrCmd("/hms/HmsCodeMgr.jsp"));                  // HTML �����ڵ� ����
        commands.put("HmsCodeMgrCUD",   new HmsCodeMgrCUDCmd("/hms/HmsAction.do?cmd=HmsCodeMgr"));  // HTML �����ڵ� ���� CUD        
    }    


    /**
     * ��û���� ����� Command instance�� ���Ѵ�.
     * @param cmd ��ɸ�
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
