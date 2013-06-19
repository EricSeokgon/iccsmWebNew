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

public class Login01 extends GPKIHttpServlet 
{

	/**
	* 생성자 
	* 
	*/
	public Login01()
	{
		super();
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		doPost(req, res);
	}

	/**
	* 암호화 된 데이터를 받아 클라이언트의 자바스크립트에서 복호화 함수를 호출하여 화면에 출력해준다 
	* 
	* @param req		GPKIHttpServletRequest.java에서 재정의한 request
	* @parm  res		GPKIHttpServletResponse.java에서 재정의한 response
	* @return			void
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{	
		res.setContentType("text/plain; charset=euc-kr");

		try {

			// 서블릿 상에서 write 할 때 인크립트 태그를 만나면 부분암호화 수행
			PrintWriter out = res.getWriter();

			X509Certificate cert = null;
		    byte[] signData = null;
		    byte[] privatekey_random = null;
		    String signType = "";
		    String queryString = "";
		    
			cert = ((GPKIHttpServletRequest)req).getSignerCert();
			String subDN = cert.getSubjectDN();
			
			int message_type =  ((GPKIHttpServletRequest)req).getRequestMessageType();

			if( message_type == ((GPKIHttpServletRequest)req).ENCRYPTED_SIGNDATA || message_type == ((GPKIHttpServletRequest)req).LOGIN_ENVELOP_SIGN_DATA ||
			    message_type == ((GPKIHttpServletRequest)req).ENVELOP_SIGNDATA || message_type == ((GPKIHttpServletRequest)req).SIGNED_DATA){
				signData 			= ((GPKIHttpServletRequest)req).getSignedData();
				if(privatekey_random != null) {
					privatekey_random 	= ((GPKIHttpServletRequest)req).getSignerRValue();
				}
				signType 			= ((GPKIHttpServletRequest)req).getSignType();
			}	    
			
			queryString = ((GPKIHttpServletRequest)req).getQueryString();
		
		out.println("<html>");
		out.println("<head><title></title>");
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
		out.println("<a href='/encSsession.jsp'>세션키암호화</a>");
		out.println("		<td>");
		out.println("<a href='/signSsession.jsp'>전자서명</a>");
		out.println("		</td>");
		out.println("		<td>");
		out.println("<a href='/encSignSsession.jsp'>전자서명+세션키암호화</a>");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("</table>");
		out.println("<table width='600' bgcolor='#E6E6FA'>");
		out.println("	<tr>");
		out.println("		<td>");
		out.println("<strong>로그인한 사용자 인증서 정보 : </strong>");
		out.println("<ENCRYPT_DATA>");
		out.println(" "+subDN+" ");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("</ENCRYPT_DATA>");
		out.println("	<tr>");
		out.println("		<td>");
		out.println("<ENCRYPT_DATA>");
		out.println("<strong>message_type : </strong>" + message_type + " ");
		out.println("<br>");
		out.println("<br>");
		out.println("<strong>signType : </strong>" + signType + " ");
		out.println("<br>");
		out.println("<br>");
		out.println("<strong>signData : </strong>" + Dump.toHexString(signData, 0, signData.length) + " ");
		out.println("<br>");
		out.println("<br>");
		if(privatekey_random != null) {
		out.println("<strong>privatekey_random : </strong>" + Dump.toHexString(privatekey_random, 0, privatekey_random.length) + " ");
Logger.debug.println(this, "privatekey_random = "+Dump.toHexString(privatekey_random, 0, privatekey_random.length));

		out.println("<br>");
		out.println("<br>");
		}
		out.println("<strong>원본 sign 메시지  : </strong>"+ queryString + " ");
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
