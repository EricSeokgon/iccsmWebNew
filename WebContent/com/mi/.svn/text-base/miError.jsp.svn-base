<%@ page contentType="text/xml; charset=utf-8" %>
<%@ page import="com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page isErrorPage="true" %>

<%
Exception ex = (Exception)request.getAttribute("ex");

/****** Service API 초기화 ******/
VariableList vl = new VariableList();
DatasetList  dl = new DatasetList();

/********* Error처리 ************/
vl.addStr("ErrorCode", "-1");
vl.addStr("ErrorMsg", ex.getMessage());

/******** 결과 XML 생성 및 Web Server로 전달 ******/
out.clear(); //out--> jsp자체 객체
out=pageContext.pushBody(); //out--> jsp자체 객체
PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "utf-8");
pRes.sendData(vl, dl);

%>



