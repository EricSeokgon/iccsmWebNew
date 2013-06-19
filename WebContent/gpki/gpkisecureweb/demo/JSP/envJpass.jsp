<%@ page language="java" contentType="text/html; charset=euc_kr" %>
<%@ page import="com.gpki.gpkiapi.cert.*" %>
<%@ page import="com.gpki.gpkiapi.cms.*" %>
<%@ page import="com.gpki.gpkiapi.util.*" %>
<%@ page import="com.dsjdf.jdf.Logger" %>
<%@include file='./gpkisecureweb.jsp'%>


<%
            X509Certificate cert = null;
            byte[] signData = null;
            byte[] privatekey_random = null;
            String signType = "";
            String queryString = "";
            
            cert = gpkirequest.getSignerCert();
Logger.debug.println(this, "cert : " + cert);
            String subDN = cert.getSubjectDN();
Logger.debug.println(this, "subDN : "+cert.getSubjectDN());         
            
            int message_type =  gpkirequest.getRequestMessageType();
Logger.debug.println(this, "message_type : "+message_type); 
            if( message_type == gpkirequest.ENCRYPTED_SIGNDATA || message_type == gpkirequest.LOGIN_ENVELOP_SIGN_DATA ||
                message_type == gpkirequest.ENVELOP_SIGNDATA || message_type == gpkirequest.SIGNED_DATA){
				signData = gpkirequest.getSignedData();
                if(privatekey_random != null) {
                    privatekey_random   = gpkirequest.getSignerRValue();
                }
                signType            = gpkirequest.getSignType();
            }       
            
            queryString = gpkirequest.getQueryString();
%>

<html>
<head>
	<title>웹보안 API Demo Site 로그인 성공</title>

<script language='javascript' src='./gpkisecureweb/var.js'></script>
<script language='javascript' src='./gpkisecureweb/object.js'></script>
<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>

</head>

<body>
<table width="600" valign="center" align="center"  bgcolor="#79A7D9">
	<tr>
		<td valign="center" align="center">
			<a href="encJsession.jsp"><font size="3" color="white">&nbsp;세션키암호화&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
			<a href="signJsession.jsp"><font size="3" color="white">&nbsp;전자서명&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
			<a href="encSignJsession.jsp"><font size="3" color="white">&nbsp;전자서명+세션키암호화&nbsp;</font></a>
		</td>
	</tr>
</table>

<table   align="center" valign="center" width="100%" height="100%">
		<tr>
			<td align="center" valign="center">
				<table width="600" valign="center" align="center"  bgcolor="#79A7D9">
					<tr>
						<td>
							<table width="600">
								<tr>
									<td valign="center" align="left" width="599">
									<font color="white">

										<e>인증서 정보</e>
										<%
										if( cert != null || !cert.equals("") ) {
										%>
											로그인한 인증서는 : <ENCRYPT_DATA> <%= subDN %> </ENCRYPT_DATA> 입니다. <br><hr>
										<%	
										}								
											byte[] signContent ;    // 원본메시지
											SignedData signedData = new SignedData();
											signedData.verify(signData);    // signedData를 가지고 sign 검증 실행
											signContent  = signedData.getMessage();  // signedData에서 원본 메시지를 꺼낸다. 
										%>

										<ENCRYPT_DATA>
										서명값 :  <%= new Base64().encode(signData) %>  입니다.<br><hr>
										</ENCRYPT_DATA>

										<ENCRYPT_DATA>
										signData :  <%= new Base64().encode(signContent)  %>  입니다.<br><hr>
										</ENCRYPT_DATA>

										<ENCRYPT_DATA>
										<%
										if(privatekey_random != null) {
										%>
											privatekey_random 값은 :  <%= new Base64().decode(privatekey_random.toString()) %>  입니다.<br><hr>
										<%
										}
										%>

										QueryString : <%= queryString %> 입니다.<br><hr>

										<%
										Logger.debug.println(this, "finish");
										%>

										</ENCRYPT_DATA>
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