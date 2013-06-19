<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*"%>
<%
String id = request.getParameter("id");
String text = request.getParameter("text");
out.print("id : "+id + "\\\\");
out.print("text : "+text + "\\\\");
out.print("ETC : 신청인||사용전검사||필증관리||관리대장");
%>
