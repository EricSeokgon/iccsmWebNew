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
		�� ȣ��Ʈ : <%= request.getLocalName() %>&nbsp;&nbsp;
		<% SimpleDateFormat formatter = new SimpleDateFormat("yyyy�� MM��dd�� a hh��mm�� ss��", Locale.KOREA); %>
		�� �����ð� : <%= formatter.format(new Date()) %>
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
<td align="center" colspan="2">��ü ����ӽ� �޸� (<b><%= total/1024 %> KB</b>)</td>
</tr>
<tr bgcolor=#E3E3E3>
<td align="center">������� �޸� (<b><%= (total - free)/1024 %> KB</b>)</td>
<td align="center">�����ִ� �޸� (<b><%= free/1024 %> KB</b>)</td>
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
<img src="trash.gif" valign=middle border=0> �������÷��� ����</a>
&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<a href="<%= request.getRequestURI() %>">
<img src="refresh.gif" valign=middle border=0> �ٽ� �б�</a>

</td></tr>
</table>

</center>


