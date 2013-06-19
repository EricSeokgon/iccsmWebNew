<%
	if(request.getAttribute("nextURL")!=null)
		response.sendRedirect((String)request.getAttribute("nextURL"));
	else if(request.getParameter("nextURL")!=null)
		response.sendRedirect(request.getParameter("nextURL"));
	else
		out.println("<script>history.back();</script>");
%>
