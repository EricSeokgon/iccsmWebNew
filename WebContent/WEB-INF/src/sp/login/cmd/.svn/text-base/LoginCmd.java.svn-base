/**
 * 파일명   : LoginCmd.java 
 * 설명     : 로그인 프로세스  
 * 이력사항
 * CH00     :2006/04/19 김경덕 최초작성 
 */

package sp.login.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

import sp.login.LoginWorker;
import sp.uent.UserEnt;


/****************************************************************************
 * <p>Title       : LoginCmd Class</p>
 * <p>Description : 로그인 처리를 하는 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 *
 * NOTE : 로그인 처리를 한다.
 *
 * @version
 * @author YYS
 ***************************************************************************/
public class LoginCmd implements KJFCommandResp {
	
	private String strID = null;
	private String strPass = null;
	private LoginWorker worker =new LoginWorker();
	
	private String next;
	
    public LoginCmd() {
    }
    
    public LoginCmd(String next_url) {
    	next = next_url; 
    }
    
    public String execute(HttpServletRequest request, HttpServletResponse response,  ActionForm form) throws Exception {
        
    	// 다른곳에 쓸일이 있어서 모듈로 빼놓았음
    	
        LoginWorker worker =new LoginWorker();
        
        strID = KJFUtil.print(request.getParameter("USER_ID"), KJFUtil.print(request.getParameter("id")));
        strPass = KJFUtil.print(request.getParameter("USER_PASSWD"), KJFUtil.print(request.getParameter("password")));
        
        System.out.print("-------------------------------------------------------------------------------------------------------\n\n\n\n\n\n\n\n\n");
    	if(KJFUtil.print(request.getParameter("cmd"),"LoginAdmin").equals("LoginUser")){
    		loginprocess(request,response,"user");    		  
    	}else{
    		loginprocess(request,response,"admin");
    	}
    	System.out.print("-------------------------------------------------------------------------------------------------------\n\n\n\n\n\n\n\n\n");
    	
    	       
        
        return next;
    }
    
    public void loginprocess(HttpServletRequest request, HttpServletResponse response, String isWhere) throws  Exception{
    	
    	KJFLog.log("로그인 시작");
    	
    	//사용자 로그인일 경우
    	if(isWhere.equals("user")){
    		
    		KJFLog.log("사용자 로그인...");
    		
        	if (!worker.isloginUser(strID, strPass.trim() )) {
        		
            	if (!worker.isInUserID(strID)) {
                    throw new MsgException("입력하신 아이디가 존재하지  않았습니다.");
                } else {
                    throw new MsgException("입력하신 패스워드가 일치하지 않습니다.");
                }
        	}
            
        	UserEnt user= new UserEnt(strID,"user");
            request.getSession().setAttribute("user", user);
        	
    	}
    	
    	//관리자 로그인일 경우
    	else if(isWhere.equals("admin")){
    		
    		KJFLog.log("관리자 로그인...");
    		
        	if (!worker.isloginAdmin(strID, strPass )) {
            	if (!worker.isInAdminID(strID)) {
                    throw new MsgException("입력하신 아이디가 존재하지 않았습니다.");
                } else {
                    throw new MsgException("입력하신 패스워드가 일치하지 않습니다.");
                }
        	}
        	
            UserEnt user= new UserEnt(strID,"admin");
            request.getSession().setAttribute("user", user);
            
    	}else{
    		
    		throw new MsgException("정상적인 로그인이 아닙니다.");
    		
    	}
        
    }
    
}