<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.hms.*" %>

<!-- 공통 : S -->
<link href="../css/web_layout.css" rel="stylesheet" type="text/css" />
<link href="../css/web_style.css" rel="stylesheet" type="text/css" />
<link href="../css/web_form.css" rel="stylesheet" type="text/css" />
<!-- 공통 : E -->

<%
	String cmd = KJFUtil.print(request.getParameter("cmd"), "BbsKList");
%>

<% if(cmd.equals("HmsView")) { %>
	<jsp:include page="../hms/HmsView.jsp" />
<% } %>