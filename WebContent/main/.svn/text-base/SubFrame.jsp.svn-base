<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="kjf.util.*" %>

<%
	String PG_GROUP_ID = KJFUtil.print(request.getParameter("PG_GROUP_ID"));
	String go_url = KJFUtil.print(request.getParameter("go_url"));
	if(go_url==null || "".equals(go_url)){
		go_url = "blank/BlankAction.do?cmd=Blank&nextURL=/blank/blank.jsp&PG_GROUP_ID=4";
		
//		go_url = "main/Main.jsp";
		PG_GROUP_ID = "4";
	}
%>

<frameset rows="1000,*" cols="218,*" frameborder="NO" border="0" framespacing="0">
	<frame name="LeftMenu" src="LeftMenu.jsp?PG_GROUP_ID=<%=PG_GROUP_ID%>" frameborder="no" scrolling="auto" noresize marginwidth="0" marginheight="0" id="menu">
	<frame name="SubMain"  src="../<%=URLDecoder.decode(go_url,"UTF-8")%>" frameborder="no" noresize marginwidth="0" marginheight="0" id="main">
</frameset>