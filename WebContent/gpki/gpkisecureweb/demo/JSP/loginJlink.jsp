<%@ page contentType="text/html;charset=euc-kr" %>
<%@	page import="java.sql.*, java.io.*, java.net.*, java.util.*" %>

<%@ include file="./gpkisecureweb.jsp" %>
<%@ page import="com.gpki.servlet.GPKIHttpServletResponse" %>

<%
	String challenge = ((GPKIHttpServletResponse)gpkiresponse).getChallenge();
%>


<html>
<head>
<title>������ API Demo Site �α���</title>

<script language='javascript' src='./gpkisecureweb/var.js'></script>
<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>
<script language='javascript' src='./gpkisecureweb/object.js'></script>


</head>

<body>

<table width="100%" height="100%" align="center" valign="center">
	
	<tr>
	<!--  ������ �ֱ� ���� -->
		<td align="center" valign="center">
			<table width="58%" height="200" align="center">
				<!-- ���ϴ� �α������� ���� -->
				
				<tr>
					<td align="center" valign="center">
						<table height=20" width="600" bgcolor="#A8D170">
		
							<tr>
								<td valign="center" align="center">
									<a href="loginJemb.jsp"><font size="3" color="white">&nbsp;�Ӻ����&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
									<a href="loginJpop.jsp"><font size="3" color="white">&nbsp;�˾�&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
									<a href="loginJlink.jsp"><font size="3" color="white">&nbsp;��ũ&nbsp;</font></a>&nbsp;<font size="3"
									color="white">/</font>&nbsp;
									<a href="envJdata.jsp"><font size="3" color="white">&nbsp;���ĪŰ��ȣȭ&nbsp;</font></a>&nbsp;<font size="3"
									color="white">/</font>&nbsp;
									<a href="envSignJData.jsp"><font size="3" color="white">&nbsp;���ڼ���+���ĪŰ��ȣȭ&nbsp;</font></a>
								</td>
							</tr>
							<tr>
								<td><hr></td>
							</tr>
							<tr>
								<td align="center" valign="center">
									<a href="./envJpass.jsp?challenge=<%=challenge%>" onclick="LoginLink(this);return false;" >�α���</a>
								</td>
							</tr>		
						</table>
					</td>
				</tr>
			</table>			
		</td>
		<!-- ������ �ֱ� �� -->	
	</tr>
</table>

</body>
</html>
