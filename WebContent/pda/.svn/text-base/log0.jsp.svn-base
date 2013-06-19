<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*"%>
<%@ page import="kjf.util.*" %>
<%@ page import="kjf.ops.*" %>
<%
String id		=	KJFUtil.print(request.getParameter("id"));
String pass		=	KJFUtil.print(request.getParameter("pass"));
String s_n		=   KJFUtil.print(request.getParameter("s_n"));

String result 	=(String)request.getAttribute("result");

%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>
<body onlo>
	<form action="../login/LoginAction.do?cmd=PdaLoginMgr" method="post" name="fmParam">
		<input name="id" type="hidden" value = "<%=id%>"> 
		<input name="pass" type="hidden" value = "<%=pass%>"> 
		<input name="s_n" type="hidden" value = "<%=s_n%>"> 
	</form>
	<%
 	if(KJFUtil.isEmpty(rEntity)){
	%>
		<script language="JavaScript" type="text/JavaScript">
			var fm = document.fmParam;
			fm.action = "../login/LoginAction.do?cmd=PdaLoginMgr";
			fm.method = "post";
			fm.submit();
		</script>
	<%}else{
		
		out.print("ID : "+id + "\\\\");
		out.print("Serial No : "+s_n + "\\\\");
		
		if("Y".equals(result)){
			out.print("ETC : ok");
		}else if("N".equals(result)){
			out.print("ETC : no");
		}
	 }%>
</body>
</html>