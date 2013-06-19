

package kjf.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

/**
 * <b>class : </b> MainAction
 * <b>Class Description</b><br>
 * ActionActionServlet 클래스를 상속받은  클래스
 * @author 김경덕
 * @version 1.0.0
 */
public class KJFActionServlet extends ActionServlet {

	public KJFActionServlet() {
	    super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    request.setCharacterEncoding("utf-8");
	    process(request, response);
	}


	public void doPost( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    request.setCharacterEncoding("utf-8");
	    process(request, response);
	}

}
