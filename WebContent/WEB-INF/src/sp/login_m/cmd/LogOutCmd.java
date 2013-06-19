/**
 * ���ϸ�   : LoginCmd.java 
 * ����     : �α��� ���μ���  
 * �̷»���
 * CH00     :2006/04/19 ���� �����ۼ� 
 */

package sp.login_m.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;

import org.apache.struts.action.ActionForm;

import sp.login.LoginWorker;

public class LogOutCmd implements KJFCommandResp {


	private String next;
	
    public LogOutCmd() {
    }
    
    public LogOutCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, HttpServletResponse response,  ActionForm form) throws Exception {
        

    	LoginWorker worker =new LoginWorker();
    	
    	worker.LogOutProcess(request, response);

    	
        return next;
    }


}