<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="sp.util.sms.*" %>
<%
	SmsMd sm= new SmsMd();
	int result= sm.SendMsg("admin","bsbs","bsbs","0510000000","0175460745","�׽�Ʈ�޼����Դϴ�.!");
	//����� ID, 16���õ� �ڵ�, ����ϴ� �õ��ñ��� �ڵ�, �߽��ڹ�ȣ, �۽��ڹ�ȣ, �޼���)
	//��ȭ��ȣ�� Ư������ ���� ��ȣ�� �Է� (�߿�!!!)
%>
<html>
<head>
<title>smsTest </title>
</head>
<body>
 sms �߼��׽�Ʈ ������<br/>
 �����: <%=result+"" %><br/>
 ������ ��� 1�� ����<br/>
 ������ ��� 0�� ����<br/>
 
</body>	
</html>

