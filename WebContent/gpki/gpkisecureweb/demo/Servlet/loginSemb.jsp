<%@ page contentType="text/html;charset=euc-kr" %>

<%@ include file="./gpkisecureweb.jsp"  %>
<%@ page import="com.gpki.servlet.GPKIHttpServletResponse" %>

<%
	String challenge = gpkiresponse.getChallenge();
%>

<html>
<head>
<title>웹보안 API Demo Site 로그인</title>

<script language='javascript' src='./gpkisecureweb/var.js'></script>
<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>
<script language='javascript' src='./gpkisecureweb/object.js'></script>


</head>

<body>

<table width="100%" height="100%" align="center" valign="center">
	
	<tr>
	<!--  페이지 넣기 시작 -->
		<td align="center" valign="center">
			<table width="58%" height="200" align="center">
				<!-- 원하는 로그인형태 선택 -->
				
				<tr>
					<td align="center" valign="center">
						<table height=20" width="600" bgcolor="#A8D170">
		
							<tr>
								<td valign="center" align="center">
									<a href="loginSemb.jsp"><font size="3" color="white">&nbsp;임베디드&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
									<a href="loginSpop.jsp"><font size="3" color="white">&nbsp;팝업&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
									<a href="loginSlink.jsp"><font size="3" color="white">&nbsp;링크&nbsp;</font></a>&nbsp;<font size="3"
									color="white">/</font>&nbsp;
									<a href="envSdata.jsp"><font size="3" color="white">&nbsp;비대칭키암호화&nbsp;</font></a>&nbsp;<font size="3"
									color="white">/</font>&nbsp;
									<a href="envSignSData.jsp"><font size="3" color="white">&nbsp;전자서명+비대칭키암호화&nbsp;</font></a>
								</td>
							</tr>
              <tr> 
                <td><hr></td>
              </tr>
              <tr> 
                <td align="center" valign="center"> 
                  <!-- 폼 시작 -->
                  <form action="/servlet/Login01" method="post" name="LoginData" onSubmit="return false;">
                    <table>
                      <tr> 
                        <td> 
                          <!-- 인증서 ActiveX 삽입 -->
			  <script language='javascript' src='./gpkisecureweb/embobject.js'></script>
                          <!-- 인증서 ActiveX 삽입 끝-->
                        </td>
                      </tr>
                      <tr> 
                        <td colspan="2" align="right" valign="center"> <font color="white"><strong>비밀번호&nbsp;</strong></font>
                          <input type="password" size="16" maxlength="16" name="pwd" onkeydown="embeddedEnterEvent(this.form)">&nbsp; 
						  <input type="button" name="login" value="로긴" onClick="LoginEmbedded(LoginData);"> 
                          <input type="hidden" name="challenge" value=<%= challenge %>> 
                        </td>
                      </tr>
                    </table>
                  </form>
                  <!-- 폼끝 -->
                </td>
              </tr>
            </table></td>
        </tr>
      </table>	
	 </td>
	<!-- 페이지 넣기 끝 -->	
	</tr>

</table>

</body>
</html>