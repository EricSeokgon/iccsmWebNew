<%@ page language="java" contentType="text/html; charset=euc_kr" %>
<%@ page import="com.gpki.gpkiapi.cert.*" %>
<%@ page import="com.gpki.gpkiapi.cms.*" %>
<%@ page import="com.gpki.gpkiapi.util.*" %>
<%@ page import="com.dsjdf.jdf.Logger" %>
<%@include file='./gpkisecureweb.jsp'%>

<%
            X509Certificate cert = null;
            String signType = "";
            String queryString = "";
            
            cert = gpkirequest.getSignerCert();

            String subDN = cert.getSubjectDN();
            
            int message_type =  gpkirequest.getRequestMessageType();

            if( message_type == gpkirequest.ENCRYPTED_SIGNDATA || message_type == gpkirequest.LOGIN_ENVELOP_SIGN_DATA ||
                message_type == gpkirequest.ENVELOP_SIGNDATA || message_type == gpkirequest.SIGNED_DATA){
                signType = gpkirequest.getSignType();
            }           
            queryString = gpkirequest.getQueryString();
%>

<html>
<head>
<script language='javascript' src='./gpkisecureweb/var.js'></script>
<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>
<script language='javascript' src='./gpkisecureweb/object.js'></script>
</head>
<body>

<table   align="center" valign="center" width="100%" height="100%">
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
			</table>
		</td>
	</tr>

	<tr>
		<td>
			<table width="600" width="59%" valign="center" align="center"  bgcolor="#79A7D9">
				<tr>
					<td>

						사용자 인증서 정보 : <ENCRYPT_DATA> <%= subDN %> </ENCRYPT_DATA>
						<hr>
						message_type : <%= message_type %>
						<hr>
						<ENCRYPT_DATA>
						signType : <%= signType %>
						<hr>
						QueryString : <%= queryString %> 
						<hr>
					</td>
				</tr>

				<tr>
					<td align="center">
						<input type="button" name="logOut" value="LogOut" onClick='Logout()'>
					</td>
				</tr>
			</table>

		</td>
	</tr>
</table>
</ENCRYPT_DATA>
<%
Logger.info.println(this, "finish");
%>    
</body>
</html>
