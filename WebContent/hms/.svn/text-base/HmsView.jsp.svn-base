<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.uent.*" %>

<%
	ReportEntity rEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("rEntity") );

	UserEnt user = (UserEnt)request.getSession().getAttribute("user");
	
	String CONTENT = "";
	String URL     = "";
	String VERSION = "";
	String MENU_ID = "";
	
	if (rEntity.getRowCnt() > 0) {
	    CONTENT = rEntity.getValue(0, "CONTENT");
	    URL     = rEntity.getValue(0, "URL");
	    VERSION = rEntity.getValue(0, "VERSION");
	    MENU_ID = rEntity.getValue(0, "MENU_ID");
	}	                              
%>
<table width="100%" align="center" border="0" cellspacing="0" cellpadding="0" >
	<tr> 
	    <td align="center"><%=KJFUtil.FCKeditorView_no_iframe(CONTENT).replace("../","http://net.go.kr/") %></td>
	</tr>
</table>

	