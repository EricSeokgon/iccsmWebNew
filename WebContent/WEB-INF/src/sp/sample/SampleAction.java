/**
 * ���ϸ�    : SampleAction.java 
 * ����      : Sample ���ΰ��� Action 
 * �̷»���
 *
 */

package sp.sample; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFMiAction;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.sample.cmd.*;

public class SampleAction extends KJFMiAction{

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
	
	        return cmd.execute(request, form) ; 
	} 
	
	
    /**
     * Command���� ����Ѵ�.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        //���� cmd�� ���⿡ ����Ѵ�.

        commands.put("RegReceiptMgr", new RegReceiptMgrCmd("dtsList"));
        commands.put("RegReceiptMgrC", new RegReceiptMgrCCmd("dtsList"));
        //commands.put("RegReceiptMgrCCUD", new RegReceiptMgrCCUDCmd("/sample/sample_mAction.do?cmd=RegReceiptMgrC"));
        commands.put("RegReceiptMgrCCUD", new RegReceiptMgrCCUDCmd("dtsList"));
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
