<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>

<%
  if (request.getParameter("gc") != null) {
    System.gc();
    System.runFinalization();
  }
%>
<center><p>

<table width="100%" cellpadding="10" cellspacing="0" border="0" >
<tr>
	<td bgcolor="f8f8f8" align="right">
		■ 호스트 : <%= request.getLocalName() %>&nbsp;&nbsp;
		<% SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월dd일 a hh시mm분 ss초", Locale.KOREA); %>
		■ 측정시각 : <%= formatter.format(new Date()) %>
	</td>
</tr>

<tr><td align=center>

<%
   Runtime rt = Runtime.getRuntime();
   long free = rt.freeMemory();
   long total = rt.totalMemory();
   long usedRatio = (total - free) * 100 / total;
   long unusedRatio = free * 100 / total;
%>

<table width=100% bgcolor="lightgrey" border=0 cellpadding=6 cellspacing=0>
<tr>
<td align="center" colspan="2">전체 가상머신 메모리 (<b><%= total/1024 %> KB</b>)</td>
</tr>
<tr bgcolor=#E3E3E3>
<td align="center">사용중인 메모리 (<b><%= (total - free)/1024 %> KB</b>)</td>
<td align="center">남아있는 메모리 (<b><%= free/1024 %> KB</b>)</td>
</tr>
<tr bgcolor=#E8EEEC>
<td><hr color="#CC3366" align=left size=10 width="<%= usedRatio %>%" noshade>
(<%= usedRatio %> %)</td>
<td><hr color="#0066FF" align=left size=10 width="<%= unusedRatio %>%" noshade>
(<%= unusedRatio %> %)</td>
</tr>
</table>

<p>
<a href="<%= request.getRequestURI() %>?gc="> 
<img src="trash.gif" valign=middle border=0> 가비지컬렉션 실행</a>
&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<a href="<%= request.getRequestURI() %>">
<img src="refresh.gif" valign=middle border=0> 다시 읽기</a>

</td></tr>
</table>

</center>


