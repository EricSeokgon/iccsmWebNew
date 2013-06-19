package kjf.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title         : 에러처리 유틸함수 </p>
 * <p>Description   :  에러처리 유틸함수를 구현하여 제공. </p> * 
 * @author 오두식
 * @version 1.0 2003.05.29 <br/>
 */
public class ErrorPage extends HttpServlet {

	  // keys used to retrieve the error info from the request
	  final String EXCEPTION = "javax.servlet.error.exception";
	  final String MESSAGE = "javax.servlet.error.message";
	  final String STATUS = "javax.servlet.error.status_code";

	  public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {

	    // retrieve all the error information from the request
	    Exception exception = (Exception) req.getAttribute(EXCEPTION);
	    String message = (String) req.getAttribute(MESSAGE);
	    Integer statusCode = (Integer) req.getAttribute(STATUS);

	    PrintWriter out = res.getWriter();
	    out.println("<html>");
	    out.println("<body>");
	    out.println("<h1>Oops! An Error Has Occurred</h1>" );
	    out.println("<b>Status Code : </b>" + statusCode + "<br/>");
	    out.println("<b>Exception Type :</b>" + exception.getClass());
	    out.println("<br/><b>Message : </b>" + message + "<br/><hr/>" );
	    out.println("Please try again later");
	    out.println("</body>");
	    out.println("</html>");
	    out.flush();

	  }
}
