<%@ page contentType="text/html; charset=utf-8" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>사용전검사 필증</title>
	</head>
	<body>	
	<OBJECT width = "0" height = "0" ID="ZTransferX" CLASSID="CLSID:C7C7225A-9476-47AC-B0B0-FF3B79D55E67" codebase="http://99.1.5.75/oz/ozviewer/ZTransferX.cab#version=2,2,0,8">
	<PARAM NAME="download.Server" VALUE="http://99.1.5.75/oz/ozviewer">
	<PARAM NAME="download.Port" VALUE="80">
	<PARAM NAME="download.Instruction" VALUE="ozrviewer.idf">
	<PARAM NAME="install.Base" VALUE="<PROGRAMS>/Forcs">
	<PARAM NAME="install.Namespace" VALUE="OzViewerSetUp">
	</OBJECT>
		
	<OBJECT id = "ozrviewer" CLASSID="CLSID:0DEF32F8-170F-46f8-B1FF-4BF7443F5F25" width="100%" height="100%">
		<PARAM NAME="connection.servlet" value="http://99.1.5.75/oz/server">
		<PARAM NAME="connection.reportname" value="/BeforeInvest/InvestR.ozr">
		<PARAM NAME="odi.odinames" value="Q)InvestR">
		<% 
		String SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		
		String scSggn = SIGUNGU_CODE.substring(0,4); 
		
		if("gncw".equals(scSggn.trim())){ %>
		<PARAM NAME="toolbar.save" value="false">
		<PARAM NAME="toolbar.pdf" value="true">
		<% } %>
		<PARAM NAME="odi.Q)InvestR.pcount" value="4">
		<PARAM NAME="odi.Q)InvestR.args1" value="RECV_NUM=<%=request.getParameter("scRECV_NUM")%>">
		<PARAM NAME="odi.Q)InvestR.args2" value="SIDO_CODE=<%=request.getParameter("SIDO_CODE")%>">
		<PARAM NAME="odi.Q)InvestR.args3" value="SIGUNGU_CODE=<%=request.getParameter("SIGUNGU_CODE")%>">
		<PARAM NAME="odi.Q)InvestR.args4" value="SYSVAR_CNT=<%=request.getParameter("SYSVAR_CNT")%>">
		<PARAM NAME="viewer.isframe" value="false">
	</OBJECT>
	</body>
</html> 
