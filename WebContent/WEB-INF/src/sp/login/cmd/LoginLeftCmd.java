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
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
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
public class LoginLeftCmd implements KJFCommandResp {
	
	private String next;
	
    public LoginLeftCmd() {
    }
    
    public LoginLeftCmd(String next_url) {
    	next = next_url; 
    }
    
    public String execute(HttpServletRequest request, HttpServletResponse response,  ActionForm form) throws Exception {
        
        
       	loginprocess(request,"admin");
    	
        return next;
    }
    
    public void loginprocess(HttpServletRequest request, String isWhere) throws  Exception{
    	
    	
    	 UserEnt user = (UserEnt) request.getSession().getAttribute("user");
        String scUSER_ID = request.getParameter("scUSER_ID");
        String scPASSWD = request.getParameter("scPASSWD");
       
    	if(KJFUtil.isEmpty(user)){
	        String selectSQL =
	
	          	 "SELECT              	  	\n"+	
	          	 "	OFFI_ID AS USER_ID,     \n"+	
	          	 "	NM AS USER_NAME,  	  	\n"+
	          	 "	E_MAIL AS USER_EMAIL,  	\n"+
	          	 "	PASS AS USER_PASSWD,    \n"+
	          	 "	SIDO_CODE,				\n"+
	          	 "	SIGUNGU_CODE,			\n"+	
	          	 "	HOME_GROUP AS CAPITAL,   \n"+
	          	 "  PART, \n"+
	          	 "	TEL,   \n"+
	          	 "	(SELECT SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE = SIGUNGU_CODE) || ' ' || PART AS PARTPLUS,  \n"+	          	
	          	 " 	RECV_DIV  \n"+
	          	 "FROM   PT_MI_USER  		\n"+	
	          	 "WHERE OFFI_ID =?   		\n"+
	          	 "  AND PASS = ? 	\n";	
	
	        ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity rEntity     = null;
	        
	        int cnt=1;
	        rDAO.setValue(cnt++, scUSER_ID);
	        rDAO.setValue(cnt++, scPASSWD);
	        rEntity = rDAO.select(selectSQL);
	        
	        UserEnt users= new UserEnt();
	        
	        if((scUSER_ID.equals(Config.props.get("SYS_ID"))&&scPASSWD.equals(Config.props.get("SYS_PASS")))){
	        	users.setUSER_ID(Config.props.get("SYS_ID"));	
	    		users.setUSER_NAME("시스템관리자");	
		    	users.setUSER_EMAIL("");	
		    	users.setUSER_PASSWORD(Config.props.get("SYS_PASS"));
		    	users.setSIDO_CODE("baba");
		    	users.setSIGUNGU_CODE("baba");
		    	users.setCAPITAL("S");
		    	users.setRECV_DIV("본청");
	    	}
	        
	        for(int i=0; i< rEntity.getRowCnt();i++){
	        	
	        	users.setUSER_ID(rEntity.getValue(0,"USER_ID"));	
	        	users.setUSER_NAME(rEntity.getValue(0,"USER_NAME"));	
	        	users.setUSER_EMAIL(rEntity.getValue(0,"USER_EMAIL"));	
	        	users.setUSER_PASSWORD(rEntity.getValue(0,"USER_PASSWD"));
	        	users.setCAPITAL(rEntity.getValue(0,"CAPITAL"));
	        	users.setSIDO_CODE(rEntity.getValue(0,"SIDO_CODE"));
	        	users.setSIGUNGU_CODE(rEntity.getValue(0,"SIGUNGU_CODE"));
	        	users.setRECV_DIV(rEntity.getValue(0,"RECV_DIV"));
	        	
	        }
	        
	        request.getSession().setAttribute("user", users);
        
    	}else{    	
    		request.getSession().setAttribute("user", user);
    	}
        
    }
    	
}