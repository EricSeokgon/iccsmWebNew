<%@ page contentType="text/xml; charset=utf-8" %>
<%@ page import="com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>


<%
/****** Service API 초기화 ******/
VariableList vl = new VariableList();
DatasetList  dl = new DatasetList();
try {

	DatasetList  tmp_dl = (DatasetList)request.getAttribute("dl");
	if(tmp_dl != null){
		dl= tmp_dl;
	}
	dl = (DatasetList)request.getAttribute("dl");
	/********* 변수를 VariableList에 추가 ************/
	vl.addStr("ErrorCode", "0");
	vl.addStr("ErrorMsg", "SUCC");
}catch(Exception e) {
	/********* Error처리 ************/
	vl.addStr("ErrorCode", "-1");
	vl.addStr("ErrorMsg", e.getMessage());
}

/******** 결과 XML 생성 및 Web Server로 전달 ******/
out.clear(); //out--> jsp자체 객체
out=pageContext.pushBody(); //out--> jsp자체 객체
PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "utf-8");
pRes.sendData(vl, dl);

%>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head> 
    

<body leftmargin="20" topmargin="0"  >

</body>
</html>
