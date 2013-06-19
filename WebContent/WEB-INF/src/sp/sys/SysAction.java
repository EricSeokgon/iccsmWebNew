/**
 * ���ϸ�    : SysAction.java 
 * ����      : Sys ���ΰ��� Action 
 * �̷»���
 * CH00      :2006/04/19 ���� �����ۼ� 
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
	
        return  cmd.execute(request, form) ; 
	}
	
	
    /**
     * Command���� ����Ѵ�.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        // ���α׷� �׷� ����
        commands.put("PgGrMgr",       new PgGrMgrCmd("/sys/PgGrMgr.jsp"));		// ���α׷� �׷� ����Ʈ
        commands.put("PgGrMgrL",      new PgGrMgrLCmd("/sys/PgGrMgrL.jsp"));		// ���α׷� ����Ʈ
        commands.put("PgGrMgrCUD",    new PgGrMgrCUDCmd("/sys/SysAction.do?cmd=PgGrMgr"));		// ���α׷� �׷� CUD
        
        // ���α׷� ����
        commands.put("PgMgr",         new PgMgrCmd("/sys/PgMgr.jsp"));			// ���α׷� Ʈ��
        commands.put("PgMgrL",        new PgMgrLCmd("/sys/PgMgrL.jsp"));			// ���α׷� ����Ʈ
        commands.put("PgMgrCUD",      new PgMgrCUDCmd("/sys/SysAction.do?cmd=PgMgrL"));		// ���α׷� CUD
        
        // DAO Auto Gen
        commands.put("DaoGen",     	  new DaoGenCmd("/sys/DaoGen.jsp"));		    // DAO �ڵ� ����        

        // Action Auto Gen
        commands.put("ActionGen",     new ActionGenCmd("/sys/ActionGen.jsp"));		// Action �ڵ� ����        

        // �����ڵ� ����
        commands.put("ComCodeMgr",    new ComCodeMgrCmd("/sys/ComCodeMgr.jsp"));		// �����ڵ� ����Ʈ
        commands.put("ComCodeMgrP",   new ComCodeMgrPCmd("/sys/ComCodeMgrP.jsp"));		// �����ڵ� ����Ʈ
        commands.put("ComCodeMgrCUD", new ComCodeMgrCUDCmd("/sys/SysAction.do?cmd=ComCodeMgr"));	// �����ڵ� CUD

        // ���ѱ׷� ����
        commands.put("AuthGrMgr",     new AuthGrMgrCmd("/sys/AuthGrMgr.jsp"));		// ���ѱ׷� ����Ʈ
        commands.put("AuthGrMgrCUD",  new AuthGrMgrCUDCmd("/sys/SysAction.do?cmd=AuthGrMgr"));	// ���ѱ׷� CUD
        
        // ���Ѻ� ���α׷�  ����
        commands.put("AuthPgMgr",     new AuthPgMgrCmd("/sys/AuthPgMgr.jsp"));		// ���Ѻ� ���α׷� ����Ʈ
        commands.put("AuthPgMgrL",    new AuthPgMgrLCmd("/sys/AuthPgMgrL.jsp"));		// ���Ѻ� ���α׷� ����Ʈ
        commands.put("AuthPgMgrCUD",  new AuthPgMgrCUDCmd("/sys/SysAction.do?cmd=AuthPgMgrL"));	// ���Ѻ� ���α׷� CUD
        commands.put("AuthPgW",		  new AuthPgWCmd("/sys/SysAction.do?cmd=AuthPgMgr"));		// ���Ѻ� ���α׷� ����
        commands.put("AuthPgMgrUserL",    new AuthPgMgrUserLCmd("/sys/AuthPgMgrUserL.jsp"));    // ���Ѻ� ���α׷� ����� ����Ʈ
        commands.put("AuthUserMgrPgL",    new AuthPgMgrLCmd("/sys/AuthUserMgrPgL.jsp"));     // ���Ѻ� ����� ���α׷� ����Ʈ
         
        // ���Ѻ� ����� ����
        commands.put("AuthUserMgr",   new AuthUserMgrCmd("/sys/AuthUserMgr.jsp"));	// ���Ѻ� ����� ����Ʈ
        commands.put("AuthUserMgrL",  new AuthUserMgrLCmd("/sys/AuthUserMgrL.jsp"));	// ���Ѻ� ����� ����Ʈ
        commands.put("AuthUserMgrCUD",new AuthUserMgrCUDCmd("/sys/SysAction.do?cmd=AuthUserMgrL"));	// ���Ѻ� ����� CUD
        commands.put("AuthUserW",     new AuthUserWCmd("/sys/AuthUserMgr.jsp"));		// ���Ѻ� ����� ����
        
        // ���α׷� �α� ����
        commands.put("PgLogL",        new PgLogLCmd("/sys/PgLogL.jsp"));	        // ���α׷� �α� ����Ʈ
        commands.put("PgLogCUD",      new PgLogCUDCmd("/sys/SysAction.do?cmd=PgLogL"));	    // ���α׷� �α� CUD

        // ���� �α� ����
        commands.put("ConnLogL",      new ConnLogLCmd("/sys/ConnLogL.jsp"));	    // ���� �α� ����Ʈ
        commands.put("ConnLogCUD",    new ConnLogCUDCmd("/sys/SysAction.do?cmd=ConnLogL"));	    // ���� �α� CUD
        
        //��ȸ����Ÿ���轺�������
        commands.put("KicaLinkMgr",        new KicaLinkMgrCmd("/sys/KicaLinkMgr.jsp"));	        // ���α׷� �α� ����Ʈ
        //������������
        commands.put("BackupLinkMgr",        new BackupLinkMgrCmd("/sys/BackupLinkMgr.jsp"));	        // ���α׷� �α� ����Ʈ
        
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
            throw new Exception("Invalid Command Identifier : "+cmd);
        }
    }//end lookupCommand

		
}
