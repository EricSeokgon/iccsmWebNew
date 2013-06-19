<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="sp.util.sms.*" %>
<%
	SmsMd sm= new SmsMd();
	int result= sm.SendMsg("admin","bsbs","bsbs","0510000000","0175460745","테스트메세지입니다.!");
	//사용자 ID, 16개시도 코드, 사용하는 시도시군구 코드, 발신자번호, 송신자번호, 메세지)
	//전화번호는 특수문자 없이 번호만 입력 (중요!!!)
%>
<html>
<head>
<title>smsTest </title>
</head>
<body>
 sms 발송테스트 페이지<br/>
 결과값: <%=result+"" %><br/>
 성공일 경우 1을 리턴<br/>
 실패일 경우 0을 리턴<br/>
 
</body>	
</html>

