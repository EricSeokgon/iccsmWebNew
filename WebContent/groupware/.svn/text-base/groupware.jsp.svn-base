<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.io.*"%>
<%@ page import="kjf.ops.*"%>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.webservice.UBAgentPortTypeProxy" %>
<%@ page import="com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page language="java"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %><%
	String default_charset = "utf-8";

	int default_encode_method = PlatformRequest.ZLIB_COMP;
	PlatformRequest platformRequest = new PlatformRequest(request, default_charset);
	PlatformResponse platformResponse = new PlatformResponse(response, default_encode_method, default_charset);
	
	VariableList out_vl = new VariableList();
	DatasetList  out_dl = new DatasetList();
	
	out_vl.addStr("ErrorCode", "0");
	out_vl.addStr("ErrorMsg","OK");
	PlatformData pdata = new PlatformData (out_vl, out_dl);
	platformResponse.sendData(out_vl, out_dl);	
%>

<%--
	String TO_DATE = (String)request.getAttribute("TO_DATE");
	String SIGUNGU_CODE = (String)request.getAttribute("SIGUNGU_CODE");
	String SERVER_ADDR = (String)request.getAttribute("SERVER_ADDR");
	

	
	UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(SERVER_ADDR+"/iccsWs/services/UBAgent");  
	String key= KJFSec.encode(SIGUNGU_CODE);   
	//String DIR = "/data/webroot/ICCSM/oz/"+TO_DATE+"_UBInvestInner.html";
	String DIR = "D:\\work\\Jsp_Project\\iccsm\\oz\\"+TO_DATE+"_UBInvestInner.html";
	File file1 = new File(DIR);
	int result1 = ub.setFile(key,KJFFile.readFromFile(file1),"report",TO_DATE+"_UBInvestInner.html");
	if(result1 == 1){
		 KJFFile.deleteFile(DIR,TO_DATE+"_UBInvestInner.html");
	}
	
	//	String DIR2 = "/data/webroot/ICCSM/oz/"+TO_DATE+"_UBInvestResultNotiR.html";
	String DIR2 = "D:\\work\\Jsp_Project\\iccsm\\oz\\"+TO_DATE+"_UBInvestResultNotiR.html";
	File file2 = new File(DIR2);
	int result2 = ub.setFile(key,KJFFile.readFromFile(file2),"report",TO_DATE+"_UBInvestResultNotiR.html");
	if(result2 == 1){
		 KJFFile.deleteFile(DIR2,TO_DATE+"_UBInvestResultNotiR.html");
	}
--%>
<html>
	<head>		
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<body>	
	</body>
</html> 
