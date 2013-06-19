<%@ page language="java" contentType="text/html; charset=euc_kr" %>
<%@ page import="com.gpki.gpkiapi.cert.*" %>
<%@ page import="com.gpki.gpkiapi.cms.*" %>
<%@ page import="com.gpki.gpkiapi.util.*" %>
<%@ page import="com.dsjdf.jdf.Logger" %>
<%@ include file='./gpkisecureweb.jsp'%>

<%
            X509Certificate cert = null; 
            byte[] signData = null;
            byte[] privatekey_random = null;
            String signType = "";
            String queryString = "";
// 			GPKIHttpServletRequest gpkirequest = new GPKIHttpServletRequest(request);
            
            cert = gpkirequest.getSignerCert(); 
            String subDN = cert.getSubjectDN();

            java.math.BigInteger b = cert.getSerialNumber();
            b.toString();

            int message_type =  gpkirequest.getRequestMessageType();
 
            if( message_type == gpkirequest.ENCRYPTED_SIGNDATA || message_type == gpkirequest.LOGIN_ENVELOP_SIGN_DATA ||
                message_type == gpkirequest.ENVELOP_SIGNDATA || message_type == gpkirequest.SIGNED_DATA){
                signData = gpkirequest.getSignedData();
                if(privatekey_random != null) {
                    privatekey_random   = gpkirequest.getSignerRValue();
                }
                signType = gpkirequest.getSignType();
            }       
            
            queryString = gpkirequest.getQueryString();
%>

<html>
<head>
	<title>웹보안 API Demo Site 로그인 성공</title>

<script language='javascript' src='./gpkisecureweb/var.js'></script>
<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>
<script language='javascript' src='./gpkisecureweb/object.js'></script>

</head>

<body>
<table   align="center" valign="center" width="100%" height="100%">
<tr>
<td>
	<table width="59%" height="100%" align="center">
		<!-- 원하는 로그인형태 선택 -->
		
		<tr>
			<td align="center" valign="center">
				<table width="600" valign="center" align="center"  bgcolor="#79A7D9">
					<tr>
						<td valign="center" align="center">
							<a href="encJsession.jsp"><font size="3" color="white">&nbsp;세션키암호화&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
							<a href="signJsession.jsp"><font size="3" color="white">&nbsp;전자서명&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
							<a href="encSignJsession.jsp"><font size="3" color="white">&nbsp;전자서명+세션키암호화&nbsp;</font></a>
						</td>
					</tr>

					<tr>
						<td>
							<table width="600">
								<tr>
									<td valign="center" align="left">
									<font color="white">
											queryString = <%= queryString %><br><hr>
											b = <%= b%><br><hr>
											subDN = <%= subDN%><br><hr>
											message_type = <%= message_type%><br><hr>
											privatekey_random = <%= privatekey_random%><br><hr>
											signType = <%= signType%><br><hr>
											int값 <%= message_type %>
									<center><input type="button" name="logOut" value="LogOut" onClick='Logout()'></center>
									</font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>

	</table>			
</td>
</tr>
<%
//로그출력후 finish 메시지 뿌림
Logger.info.println(this, "finish");
%>
</table>
</body>
</html>
