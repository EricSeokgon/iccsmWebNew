<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="kjf.util.*" %>
<%@ page isErrorPage="true" %>
<%
String exPage = (String)request.getAttribute("exPage");
Exception ex = (Exception)request.getAttribute("ex");
%>
<html>
<head>
<title>오류페이지</title>
<style>
<!--
    body {font-size:9pt; font-family:tahoma;}
    table {font-size:9pt; font-family:tahoma;color:black}
    A {color:#000000; text-decoration:none}
    A:hover {color:red;text-decoration:none;}
    A.footer {color:silver; text-decoration:none}
    A.footer:hover {color:red;text-decoration:none;}
    td {padding:10;height:20}
    tr.err {background-color:#f4f4f4;}
    td.title {height:30;}
//-->
</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<center><BR><br>
<table cellpadding=0 cellspacing=0 border=0 width=520>
    <tr><td class=title align="center"><b><font size=3><<<<<<<    에러 리포트      >>>>>>>></font></b></td></tr>
</table>
<br>
<br>
<table cellpadding=0 cellspacing=1 border=0 bgcolor=#666666 width=520>
    <tr class=err>
        <td>에러 타입</td>
        <td><%=ex.getClass().getName()%>
		</td>
    </tr>
    <tr class=err>
        <td>요청 페이지</td>
        <td><%=request.getRequestURL()%><%=request.getQueryString()!=null?"?"+request.getQueryString():""%>
		</td>
    </tr>
    <tr class=err>
        <td>에러 메세지</td>
        <td><%=ex.toString()%>
		</td>
    </tr>
</table>
</center>
<center>
	<table cellpadding=0 cellspacing=1 border=0 bgcolor=#666666 width=520>
	    <tr class=err>
	        <td><a href="../">홈으로 가기</a></td>
	    </tr>	    
	</table>
</center>
</body>
</html>







