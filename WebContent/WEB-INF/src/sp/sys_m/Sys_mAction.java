/**
 * ���ϸ�    : Sys_mAction.java 
 * ����      : Sys_m ���ΰ��� Action 
 * �̷»���
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

    private HashMap commands; //������� class��
        	
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
							            HttpServletResponse response) throws Exception{
		
			initCommands();		
            KJFCommand cmd = lookupCommand(request.getParameter("cmd"));         
	
	        return cmd.execute(request, form); 
	} 
	
	
    /**
     * Command���� ����Ѵ�.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        //���� cmd�� ���⿡ ����Ѵ�.

        // �����ڵ� ����
        commands.put("ComCodeMgr",    new ComCodeMgrCmd("dtsList"));// �����ڵ� ����
        commands.put("ComCodeMgrL",   new ComCodeMgrLCmd("dtsList"));		// �����ڵ� ���� ����Ʈ
        commands.put("ComCodeMgrCUD", new ComCodeMgrCUDCmd("/sys_m/Sys_mAction.do?cmd=ComCodeMgr"));	// �����ڵ� CUD
      
        commands.put("SidoCodeMgr", new  SidoCodeMgrCmd("dtsList")); // �ð��ڵ� ����
        commands.put("SidoCodeMgrC", new  SidoCodeMgrCCmd("dtsList")); // �ð��ڵ� ����
        commands.put("SidoCodeMgrCUD", new  SidoCodeMgrCUDCmd("dtsList")); // �ð��ڵ� ���� CUD
        
        commands.put("UserMgr", new  UserMgrCmd("dtsList")); // ȸ�� ����
        commands.put("UserMgrC", new  UserMgrCCmd("dtsList")); // ȸ��  �˻� ����Ʈ
        commands.put("UserMgrCUD", new  UserMgrCUDCmd("dtsList")); // ȸ��  ���� CUD
        
        // �ű� ȸ����
        commands.put("UserMgrBasicCUD", new  UserMgrBasicCUDCmd("dtsList")); // ȸ��  ���� CUD
        commands.put("UserMgrBasic", new  UserMgrBasicCmd("dtsList")); // ȸ�� ����
        commands.put("UserMgrBasicC", new  UserMgrBasicCCmd("dtsList")); // ȸ��  �˻� ����Ʈ
        

        //�����ȣ�˻�
        commands.put("NewBasPostStD", new NewBasPostStDCmd("dtsList"));
        
        
        commands.put("SidoCode", new  SidoCodeCmd("dtsList")); // �ð��ڵ� ����
        commands.put("MyinfoMgr", new  MyinfoMgrCmd("dtsList")); // �ð��ڵ� ����
        
        commands.put("SysVarMgr", new  SysVarMgrCmd("dtsList")); // ����ü �ý��� ���� ����
        commands.put("SysVarMgrCUD", new  SysVarMgrCUDCmd("dtsList")); // ����ü �ý��� ���� ���� CUD
        
        commands.put("KICAIfSend", new  KICAIfSendCmd("dtsList")); // ��ȸ���� ���� ��ȸ
        commands.put("KICAIfSendCUD", new  KICAIfSendCUDCmd("dtsList")); // ��ȸ���� ���� ��ȸ
        commands.put("KICAIfRecv", new  KICAIfRecvCmd("dtsList")); // ��ȸ���ų��� ��ȸ
        commands.put("KICAIfRecvCUD", new  KICAIfRecvCUDCmd("dtsList")); // ��ȸ���ų��� ��ȸ
        
        
        commands.put("SiCodeMgr", new  SiCodeMgrCmd("dtsList")); // ȸ��  ���� CUD
    }




    /**
     * ��û���� ����� Command instance�� ���Ѵ�.
     * @param cmd ��ɸ�
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
