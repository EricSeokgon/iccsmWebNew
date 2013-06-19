<%@ page contentType="text/html;charset=euc-kr" %>
<%@ 
page import="java.sql.*, java.io.*, java.net.*, java.util.*" 
%>
<%@ page import="com.gpki.servlet.GPKIHttpServletResponse" %>

<%@include file="/gpkisecureweb.jsp"%>
<%
String challenge =((GPKIHttpServletResponse)gpkiresponse).getChallenge();
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

			  <form name='envSignJsp' action='/servlet/SignData' method='post'>
			  <tr>
                <td align="center" valign="top">
				  <table width="461" height="129"  border="0" cellpadding="0" cellspacing="0" style="margin-top:16px;">
                    <tr> 
                      <td align="right" valign="top" background="img/login_bg_m.gif">
						<table width="319" height="87" border="0" cellpadding="0" cellspacing="0" style="margin-top:23px;">
                          <tr> 
                            <td valign="top"><strong>[Servlet]로그인 버튼</strong><font size="2">을 클릭 하시면 원하시는 
                              항목을 선택하여 통합 관리도구로 입장하실 수 있습니다.</font></td>
                          </tr>
                          <tr> 
                            <td valign="bottom">
                            <input type="hidden" name="challenge" value=<%=challenge%>><BR>
							<img src="img/btn_login.gif" width="178" height="36" hspace="48" border="0" style="cursor: hand" onClick="EnvelopedSignData(envSignJsp)">
							</td>
                          </tr>
                        </table>
					  </td>
                    </tr>
                  </table>
          		 </td>
				</tr>
			  </form>
              </tr>
			</table>
		  </td>
        </tr>
</table>
</body>
</html>
