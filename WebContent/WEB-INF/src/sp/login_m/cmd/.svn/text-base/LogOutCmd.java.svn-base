/**
 * 파일명   : LoginCmd.java 
 * 설명     : 로그인 프로세스  
 * 이력사항
 * CH00     :2006/04/19 김경덕 최초작성 
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