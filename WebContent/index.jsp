<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="kjf.cfg.*" %>
<%@ page import="sp.uent.*" %>
<%
UserEnt  user=(UserEnt)session.getAttribute("user");
String url = "login/Login.jsp";
if(user != null){
	url = "main/MainFrame.jsp";
}
%>
<html>
<head>
<title>:: ICCS °ü¸®ÀÚ :: </title>
</head>
	
<frameset rows="*,0" cols="*" frameborder="no" framespacing=0>
	<frame name="mainFrame" src="<%=url%>" marginheight=0 marginwidth=0>
	<frame name=" hiddenFrame" src="about:blank" marginheight=0 marginwidth=0>
</frameset>
</html>

