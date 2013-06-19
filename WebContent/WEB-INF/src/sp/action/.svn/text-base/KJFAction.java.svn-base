package sp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.db.TX_MGR;
import kjf.util.KJFLog;
import kjf.util.LoginException;
import kjf.util.MsgException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sp.login.LoginWorker;
import sp.sys.SysWorker;
import sp.uent.UserEnt;


/**
 * <b>class : </b> MainAction
 * <b>Class Description</b><br>
 * Action클래스를 상속받은 추상화 클래스
 * <b>History</b><br>
 * @author 김경덕
 * @version 1.0.0
 * @since 05/13/2006
 */
abstract public class KJFAction extends Action {

	public String  next;
    public String _error = "error";
    public ActionForward a_next;

    
    /**
     * 전체 프레임워크의 공통적 처리를 위해서 구현해 둔 함수
     * (향후 확장성을 위해서..)
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws java.lang.Exception
     */
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        try {

			String serverURL 	= request.getContextPath();
			String url		= request.getRequestURI() + "?" + request.getQueryString();
			String cmd = url.replaceAll(serverURL,"");

        	KJFLog.log("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        	KJFLog.log("==========================================================================================================");
        	KJFLog.log(cmd);
        	KJFLog.log("==========================================================================================================");


        	String Parameters = "";
        	java.util.Enumeration enuma = request.getParameterNames();

    		while(enuma.hasMoreElements()) {

	    		String key = (String)enuma.nextElement();
	    		String value = request.getParameter(key);
	    		KJFLog.log(key + " : " + value);
	    		if(!key.equals("cmd")){
	    			Parameters += "&"+key+"="+value;
	    		}

    		}


    		KJFLog.log("==========================================================================================================");
    		KJFLog.log(request.getCharacterEncoding());
    		KJFLog.log("==========================================================================================================");

        	TX_MGR.begin("KJF");

        	//세션 체크
        	LoginWorker.checkSession(request);

        	UserEnt user = (UserEnt)request.getSession().getAttribute("user");

        	if(user != null){
        		if("admin".equals(user.getIsWhere())){

            	//타이틀 네비게이션
            	SysWorker.setTitleNavi(request);
            	//사용자 프로그램 로그 남기기
//            	SysWorker.userActionLog(request);
        		}

        	}

        	next= executeAction(mapping, form, request, response);

            //	next 가 다이렉트 경로 인지 mapping forward 경로인지 "."로 판단한다.
        	//그러므로  struts-config 에 "." 을 넣어 놓으면 안된다.
            if(next.indexOf(".")== -1){
            	a_next = mapping.findForward(next);
            } else{
            	a_next = new ActionForward(next);
            }

            KJFLog.log("==========================================================================================================");
            KJFLog.log("=== next_url : "+ a_next.getPath() +" =====");
            KJFLog.log("==========================================================================================================");

            //new PermissionFilter(request, a_next.getPath());// 해당 사용자 정회원,준회원 구분

            TX_MGR.commit(); //db commit
            
            return a_next;
        }
        catch (Exception ex) {

            TX_MGR.rollback(); //db rollbacd

            request.setAttribute("ex", ex.getMessage());
            KJFLog.log(ex.toString()); // Exception log

            if (ex instanceof MsgException || ex instanceof LoginException) { //alert 메세지 창

                return mapping.findForward("alertMsg");

            } else {

	            ex.printStackTrace();

	            return mapping.findForward(_error);
            }
        }
    }





    abstract public String executeAction(ActionMapping mapping,
                                                ActionForm form,
                                                HttpServletRequest request,
                                                HttpServletResponse response) throws Exception;

}