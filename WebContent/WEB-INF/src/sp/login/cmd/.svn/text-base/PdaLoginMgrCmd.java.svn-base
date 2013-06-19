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
public class PdaLoginMgrCmd implements KJFCommandResp {
	
	private String next;
	
    public PdaLoginMgrCmd() {
    }
    
    public PdaLoginMgrCmd(String next_url) {
    	next = next_url; 
    }
    
    public String execute(HttpServletRequest request, HttpServletResponse response,  ActionForm form) throws Exception {
        
        
       	loginprocess(request,"admin");
    	
        return next;
    }
    
    public void loginprocess(HttpServletRequest request, String isWhere) throws  Exception{
    	
    	
    	
        String scUSER_ID = request.getParameter("id");
        String scPASSWD = request.getParameter("pass");
    	
    	
        String selectSQL =

          	 "SELECT              	  	\n"+	
          	 "	COUNT(*) AS CNT   \n"+	
          	 "FROM   PT_MI_USER  		\n"+	
          	 "WHERE OFFI_ID =?   		\n"+
          	 "  AND PASS = ? 	\n";	

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        String result = "N";
        int cnt=1;
        rDAO.setValue(cnt++, scUSER_ID);
        rDAO.setValue(cnt++, scPASSWD);
        rEntity = rDAO.select(selectSQL);
        
        if(rEntity.getRowCnt() > 0){
        	int CNT = KJFUtil.str2int(rEntity.getValue(0,"CNT"));
        	
        	if(CNT > 0){
        		result = "Y";
        	}
        }
        
        request.getSession().setAttribute("result", result);

		
        
    }
    	
}