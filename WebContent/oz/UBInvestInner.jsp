<%@ page contentType="text/html; charset=utf-8" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>사용전검사 내부보고서</title>
	</head>
	<body>	
	<OBJECT id = "ozrviewer" CLASSID="CLSID:0DEF32F8-170F-46f8-B1FF-4BF7443F5F25" width="100%" height="100%">
		<PARAM NAME="connection.servlet" value="http://99.1.5.75/oz/server">
		<PARAM NAME="connection.reportname" value="/BeforeInvest/UBInvestInner.ozr">
		<PARAM NAME="odi.odinames" value="Q)UbInvestInner">
		<PARAM NAME="odi.Q)UbInvestInner.pcount" value="3">
		<PARAM NAME="odi.Q)UbInvestInner.args1" value="RECV_NUM=<%=request.getParameter("scRECV_NUM")%>">
		<PARAM NAME="odi.Q)UbInvestInner.args2" value="SIDO_CODE=<%=request.getParameter("SIDO_CODE")%>">
		<PARAM NAME="odi.Q)UbInvestInner.args3" value="SIGUNGU_CODE=<%=request.getParameter("SIGUNGU_CODE")%>">
		<PARAM NAME="viewer.isframe" value="false">
	</OBJECT>
	</body>
</html> 
