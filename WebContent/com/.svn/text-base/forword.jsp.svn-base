<%@page contentType="text/html;charset=euc-kr" %>
<%
	String path = "";
	
	if(request.getParameter("path") != null){
		path = request.getParameter("path");
	}
	
	else if(request.getAttribute("path") != null){
		path = (String)request.getAttribute("path");
	}

	response.sendRedirect(path);
%>
