import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsjdf.jdf.Logger;
import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.util.Dump;
import com.gpki.servlet.GPKIHttpServlet;
import com.gpki.servlet.GPKIHttpServletRequest;
import com.gpki.util.GPKIUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class EncData extends GPKIHttpServlet 
{

	/**
	* ������ 
	* 
	*/
	public EncData()
	{
		super();
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		doPost(req, res);
	}

	/**
	* ��ȣȭ �� �����͸� �޾� Ŭ���̾�Ʈ�� �ڹٽ�ũ��Ʈ���� ��ȣȭ �Լ��� ȣ���Ͽ� ȭ�鿡 ������ش� 
	* 
	* @param req		GPKIHttpServletRequest.java���� �������� request
	* @parm  res		GPKIHttpServletResponse.java���� �������� response
	* @return			void
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{	
		res.setContentType("text/plain; charset=euc-kr");

		try {
			// ���� �󿡼� write �� �� ��ũ��Ʈ �±׸� ������ �κо�ȣȭ ����
			PrintWriter out = res.getWriter();

		    String queryString = "";
		    
			int message_type =  ((GPKIHttpServletRequest)req).getRequestMessageType();

			queryString = ((GPKIHttpServletRequest)req).getQueryString();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<OBJECT id='GPKISecureWeb' classid='clsid:C8223F3A-1420-4245-88F2-D874FC081572'> </OBJECT>");
		out.println("<script language='javascript' src='/gpkisecureweb/var.js'></script>");
		out.println("<script language='javascript' src='/gpkisecureweb/GPKIFunc.js'></script>");
		out.println("<script language='javascript' src='/gpkisecureweb/install.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table width='100%' height='100%' align='center'>");
		out.println("	<tr>");
		out.println("		<td align='center'>");
		out.println("<table width='600' bgcolor='#DEB887'>");
		out.println("	<tr>");
		out.println("		</td>");
		out.println("		<td>");
		out.println("<a href='/encSsession.jsp'>����Ű��ȣȭ</a>");
		out.println("		<td>");
		out.println("<a href='/signSsession.jsp'>���ڼ���</a>");
		out.println("		</td>");
		out.println("		<td>");
		out.println("<a href='/encSignSsession.jsp'>���ڼ���+����Ű��ȣȭ</a>");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("</table>");
		out.println("<table width='600' bgcolor='#E6E6FA'>");
		out.println("	<tr>");
		out.println("		<td>");
		out.println("<strong>message_type </strong>: " + message_type + " ");
		out.println("<br>");
		out.println("<br>");
		out.println("<ENCRYPT_DATA>");
		out.println("<strong>���� �޽���  : </strong>"+ queryString + " ");
		out.println("<br>");
		out.println("<br>");
		out.println("</ENCRYPT_DATA>");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("</table>");
		out.println("		</td>");
		out.println("	<tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
Logger.info.println(this, "Finish");		

		out.close();
		
		} catch (Exception e) {
			Logger.err.println(this, e.getMessage());
			GPKIUtil.goErrorPage(e);
		}
	}
}
