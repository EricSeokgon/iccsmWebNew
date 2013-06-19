<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.io.*" %>
<%
//�α������� �ִ� ���丮
String log_dir = "D:\\work\\JSP_Project\\tomcat5\\logs";

if(request.getParameter("log_dir")!=null){
	log_dir=(String)request.getParameter("log_dir");
	session.setAttribute("log_dir",log_dir);
}else if((String)session.getAttribute("log_dir")!=null){
	log_dir = (String)session.getAttribute("log_dir");
}
%>
<HTML>
<HEAD>
<title>�α����Ϻ���</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<style type="text/css">
<!--
a {text-decoration:none; color: black;}
a:link {text-decoration:none; color: black;}
a:visited {text-decoration:none; color: black;}
a:active {text-decoration:none; color: black;}
a:hover {text-decoration:none; color:black;}
body,table,tr,td {  font-family: "����"; font-size: 9pt; font-style: normal; color: black;}
-->
</style> 
<script>
	//ajax�� ���� �Լ��Դϴ�.
	function getXmlHttpRequest(){
		var xmlhttp = false;
		// Mozilla/Safari
		if (window.xmlhttpuest) {
				xmlhttp = new xmlhttpuest();
		}
		// IE
		else if (window.ActiveXObject) {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
	}
</script>
</head>
<body leftmargin="0" topmargin="0" style="overflow-x:hidden" style="overflow-y:hidden">
<table cellspacing="0" cellPadding="1" width="100%" align="center" border="0">
<form name="frm" action="tail_log.jsp" method="post">
	<tr>
		<td>�α����� ��� : <input type ="text" name="log_dir" maxlength="300" style="width: 300px;" value="<%=log_dir%>"><input type ="button" name="btn" value="�б�" onclick="frm.submit();" class=btn></td>
	</tr>
</form>
</table>
<%
if(log_dir != null && log_dir.length() > 0){

//ȭ�鿡 ��Ÿ�� �α����� ����
long log_length = 10000;
//�α����ϸ�
String log_filename = request.getParameter("log_filename") == null ? "": request.getParameter("log_filename");

// ���丮�� ��ü�� ���� 
File myDir = new File(log_dir); 
// ���丮�� ���� ���ϱ� 
File[] list_files = myDir.listFiles(); 

//���Ͻ�����ġ
long start_point = 0;
//���ϳ���ġ
long end_point = 0;
//���ϳ���
String log_data = "";
if(!log_filename.equals("")){
	StringBuffer sb = new StringBuffer();
	RandomAccessFile read_file = new RandomAccessFile(log_dir+"\\"+log_filename, "r"); 
	//���� ���̸� ���Ѵ�.
	long str_length = read_file.length(); 
	//������ ���� ��ġ�� ���Ѵ�.
	start_point = (str_length<log_length)?0:(str_length-log_length);
	read_file.seek(start_point);   
	String str;
	end_point = str_length;
	while((str = read_file.readLine()) != null){
		sb.append(toKorean(str)+"\n");
		//������ �а� ������ ��ġ�� �˾Ƴ���.
		end_point = read_file.getFilePointer();
		read_file.seek(end_point);   
	}
	read_file.close();
	//���ϳ���
	log_data = sb.toString();
}
%>
<table border="0" cellspacing="0" cellpadding="0" width="100%" height="96%">
	<tr height="10%">
		<td align="left" valign="bottom">
			<table border="0" cellspacing="0" cellpadding="0">
			<form name="fileform" method="post" action="tail_log.jsp">
			<input type ="hidden" name="flag" value="y">
				<%if (list_files != null) {%>
				<tr>
					<td>
						<select name="log_filename">
							<option value="">���ϼ���</option>
							<%
								for (int i = 0; i < list_files.length; i++) {
									if(!list_files[i].isDirectory()){
										String filename = list_files[i].getName();
										filename = filename.substring(filename.lastIndexOf("/")+1,filename.length());
							%>
							<option value="<%=filename%>" <%=log_filename.equals(filename)?"selected":""%>><%=filename%></option>
							<%
									}
								}
							%>
						</select>
						
					</td>
					<td>
						<input type="submit" value="����"><input type ="button" name="btn" value="����" onclick="fileform.flag.value='n';fileform.submit(); " class=btn>
					</td>
				</tr>
				<%}%>
			</form>
			</table>
		</td>
	</tr>
	<tr height="90%">
		<td>
			<table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
			<form name="logform">
				<tr>
					<td><textarea id="log_data_area" name="log_data" style="background-color:black;color:#797979;white;width:100%;height:97%;"><%=log_data%></textarea></td>
				</tr>
			</form>
			</table>
		</td>
	</tr>
</table>
<%
String flag = request.getParameter("flag") == null ? "": request.getParameter("flag");

if(!log_filename.equals("") && flag.equals("y")){
%>
<script>
	var end_point = <%=end_point%>;
	function include_ajax_repeat(){
		var url = 'tail_log_ajax.jsp?log_filename=<%=log_filename%>&end_point='+end_point;
		//alert(url);
		var xmlhttp = getXmlHttpRequest();
		if(url){
			xmlhttp.open("GET", url, true);
			xmlhttp.onreadystatechange = function() {
				if(xmlhttp.readyState == 4) {
					if(xmlhttp.status == 200) {
						var resText = xmlhttp.responseText;
						//������ ��ġ
						end_point = resText.substring(0,resText.indexOf(','));
						//���ο� �α� ����Ÿ
						var log_data = resText.substring(resText.indexOf(',')+1,resText.length);
						document.logform.log_data.value = document.logform.log_data.value + log_data;
						//������ ���� �α׵���Ÿ�� �����.
						if(document.logform.log_data.value.length><%=log_length%>) document.logform.log_data.value = document.logform.log_data.value.substring(document.logform.log_data.value.length-<%=log_length%>);
						//��ũ�� �̵�
						document.getElementById('log_data_area').scrollTop=document.getElementById('log_data_area').scrollHeight+10000;
					} else {
						alert("Error loading "+url+", "+xmlhttp.status+"("+xmlhttp.statusText+")");
					}
				}
			}
			xmlhttp.send(null);
		}
		setTimeout("include_ajax_repeat()", 1000);//msec ���� ������ �����
		return false;
	}
	include_ajax_repeat();
</script>
<%
}
%>
</body>
</html>
<%}%>








<%!
public String toKorean(String param) {
	try{
		param=new String(param.getBytes("ISO-8859-1"),"EUC-KR"); 
	}catch(Exception e){ 
	}
	return param; 
}
%>