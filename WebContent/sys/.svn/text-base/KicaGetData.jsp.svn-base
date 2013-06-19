 <%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="sp.util.kica.KicaAgent" %>
<%@ page import="sp.util.sync.SyncAgent" %>

<%
	System.out.println("---KicaGetData.jsp Start--");
	KicaAgent ka = new KicaAgent();
	ka.start();
	
	SyncAgent Sa = new SyncAgent();
	Sa.oneAday();
	//Sa.start();
	System.out.println("---KicaGetData.jsp End--");	
%>