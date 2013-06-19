<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.bbs.*" %>

<!-- 공통 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<script language="javascript" src="../com/js/httpRequest.js" type="text/javascript"></script>
<!-- 공통 부분 -->

<%
	StatusEnt status = (StatusEnt) request.getSession().getAttribute("status");

	String cmd = KJFUtil.print(request.getParameter("cmd"), "BbsKList");

	/// 파일 업로드 (multipart/form-data) 일경우 처리 로직
	if(!KJFUtil.isEmpty(request.getAttribute("cmdA"))){
		cmd = (String)request.getAttribute("cmdA");
	}
%>

<table width="<%=status.getBOARD_WIDTH()%>" align="<%=status.getBOARD_ALIGN()%>" border="0" cellspacing="0" cellpadding="0" >
	<tr>
		<td>
			<% if(cmd.equals("BbsKView")) { %>
				<jsp:include page="../bbs/BbsKView.jsp" />
			<% } %>
			
			<% if(cmd.equals("BbsKList")) { %>
				<jsp:include page="../bbs/BbsKList.jsp" />
			<% } %>
			
			<% if(cmd.equals("BbsKWrite")){ %>
				<jsp:include page="../bbs/BbsKWrite.jsp" />
			<% } %>
		</td>
	</tr>
</table>