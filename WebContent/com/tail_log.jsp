<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.io.*" %>
<%
//로그파일이 있는 디렉토리
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
<title>로그파일보기</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<style type="text/css">
<!--
a {text-decoration:none; color: black;}
a:link {text-decoration:none; color: black;}
a:visited {text-decoration:none; color: black;}
a:active {text-decoration:none; color: black;}
a:hover {text-decoration:none; color:black;}
body,table,tr,td {  font-family: "굴림"; font-size: 9pt; font-style: normal; color: black;}
-->
</style> 
<script>
	//ajax를 위한 함수입니다.
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
		<td>로그파일 경로 : <input type ="text" name="log_dir" maxlength="300" style="width: 300px;" value="<%=log_dir%>"><input type ="button" name="btn" value="읽기" onclick="frm.submit();" class=btn></td>
	</tr>
</form>
</table>
<%
if(log_dir != null && log_dir.length() > 0){

//화면에 나타낼 로그파일 길이
long log_length = 10000;
//로그파일명
String log_filename = request.getParameter("log_filename") == null ? "": request.getParameter("log_filename");

// 디렉토리인 객체를 생성 
File myDir = new File(log_dir); 
// 디렉토리의 내용 구하기 
File[] list_files = myDir.listFiles(); 

//파일시작위치
long start_point = 0;
//파일끝위치
long end_point = 0;
//파일내용
String log_data = "";
if(!log_filename.equals("")){
	StringBuffer sb = new StringBuffer();
	RandomAccessFile read_file = new RandomAccessFile(log_dir+"\\"+log_filename, "r"); 
	//파일 길이를 구한다.
	long str_length = read_file.length(); 
	//파일을 읽을 위치를 정한다.
	start_point = (str_length<log_length)?0:(str_length-log_length);
	read_file.seek(start_point);   
	String str;
	end_point = str_length;
	while((str = read_file.readLine()) != null){
		sb.append(toKorean(str)+"\n");
		//파일을 읽고 마지막 위치를 알아낸다.
		end_point = read_file.getFilePointer();
		read_file.seek(end_point);   
	}
	read_file.close();
	//파일내용
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
							<option value="">파일선택</option>
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
						<input type="submit" value="보기"><input type ="button" name="btn" value="정지" onclick="fileform.flag.value='n';fileform.submit(); " class=btn>
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
						//마지막 위치
						end_point = resText.substring(0,resText.indexOf(','));
						//새로운 로그 데이타
						var log_data = resText.substring(resText.indexOf(',')+1,resText.length);
						document.logform.log_data.value = document.logform.log_data.value + log_data;
						//일정한 양의 로그데이타만 남긴다.
						if(document.logform.log_data.value.length><%=log_length%>) document.logform.log_data.value = document.logform.log_data.value.substring(document.logform.log_data.value.length-<%=log_length%>);
						//스크롤 이동
						document.getElementById('log_data_area').scrollTop=document.getElementById('log_data_area').scrollHeight+10000;
					} else {
						alert("Error loading "+url+", "+xmlhttp.status+"("+xmlhttp.statusText+")");
					}
				}
			}
			xmlhttp.send(null);
		}
		setTimeout("include_ajax_repeat()", 1000);//msec 마다 서버와 통신함
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