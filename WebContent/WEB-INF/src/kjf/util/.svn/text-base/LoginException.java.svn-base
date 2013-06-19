package kjf.util;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Subsystem		:  util </p>
 * <p>Title			:  메세 지클래스 </p>
 * <p>Description	:  메세지를 나타낸다. </p>
 * <p>관련 TABLE		: </p>
 * @author  PKT
 * @version 1.0
 */
public final class LoginException extends Exception {

    private String msg = "";
    private String returnURL = null;
    private HttpServletRequest beforeRequest = null;

    public LoginException(HttpServletRequest request, String msg) {
        String serverURL 	= request.getContextPath();
        String url		= request.getRequestURI() + "?" + request.getQueryString();
        this.returnURL = url.replaceAll(serverURL,"");
        this.beforeRequest = request;	  
        this.msg = msg;
	  
        request.getSession().setAttribute("beforeRequest", beforeRequest);
        request.getSession().setAttribute("returnURL", returnURL);
    }
    
    public LoginException(HttpServletRequest request, String msg, String URL) {
        this.returnURL = URL;
        this.msg = msg;
        request.getSession().setAttribute("returnURL", returnURL);
    }

    public String  getMessage() {
        return this.msg;
    }
}