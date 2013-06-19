package sp.mem; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.mem.cmd.MemHomePageCompulsionMgrLCmd;
import sp.mem.cmd.MemHomePageJoinMgrLCmd;
import sp.mem.cmd.MemHomePageMgrCUDCmd;
import sp.mem.cmd.MemHomePageSecedeMgrLCmd;



public class MemAction extends KJFAction {
	
    /** ������� class�� */
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
        KJFCommand cmd = lookupCommand(request.getParameter("cmd"));         
    
        return cmd.execute(request, form) ; 
	} 
	
	
    /**
     * Command���� ����Ѵ�.
     * @param 
     * @return       
     */
    private void initCommands() {

        commands = new HashMap();
        
        commands.put("MemHomePageJoinMgrL",         new MemHomePageJoinMgrLCmd("/member/MemHomePageJoinMgrL.jsp"));             // ���Ի���� ����Ʈ
        commands.put("MemHomePageSecedeMgrL",       new MemHomePageSecedeMgrLCmd("/member/MemHomePageSecedeMgrL.jsp"));         // Ż������ ����Ʈ
        commands.put("MemHomePageCompulsionMgrL",   new MemHomePageCompulsionMgrLCmd("/member/MemHomePageCompulsionMgrL.jsp")); // ����Ż�� ����Ʈ
        
        commands.put("MemHomePageSecedeU",          new MemHomePageMgrCUDCmd("/member/MemAction.do?cmd=MemHomePageJoinMgrL"));            // ����� ����Ż��
        commands.put("MemHomePageUseU",             new MemHomePageMgrCUDCmd("/member/MemAction.do?cmd=MemHomePageJoinMgrL"));            // ����� �����ȯ
        commands.put("MemHomePageMgrD",	            new MemHomePageMgrCUDCmd("/member/MemAction.do?cmd=MemHomePageJoinMgrL"));            // ����� ��������
    }	
	
    /**
     * ��û���� ����� Command instance�� ���Ѵ�.
     * @param cmd ��ɸ�
     * @return Command class instance
     */
    private KJFCommand lookupCommand(String cmd) throws Exception {
        
        if (commands.containsKey(cmd)) {
            return (KJFCommand)commands.get(cmd);
            
        } else {
            throw new Exception("Invalid Command Identifier");
        }
    }
}
