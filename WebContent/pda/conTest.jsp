<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.io.*" %>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./image/style.css" type="text/css">

</HEAD>
<BODY>
	<% 
		String sURI = request.getParameter("sURI");
		out.print("==" + sURI);
	%>
</BODY>
</HTML>
