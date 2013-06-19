<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.io.*" %>
<%!
public String toKorean(String param) {
	try{
		param=new String(param.getBytes("ISO-8859-1"),"EUC-KR"); 
	}catch(Exception e){ 
	}
	return param; 
}
%>

<%
response.setHeader("Pragma","No-cache"); //HTTP 1.0 
response.setDateHeader ("Expires", 0); 
response.setHeader ("Cache-Control", "no-cache"); 
%>

<%

String log_dir = "";

if(request.getParameter("log_dir")!=null){
	log_dir=(String)request.getParameter("log_dir");
	session.setAttribute("log_dir",log_dir);
}else if((String)session.getAttribute("log_dir")!=null){
	log_dir = (String)session.getAttribute("log_dir");
}


//로그파일명
String log_filename = request.getParameter("log_filename") == null ? "": request.getParameter("log_filename");
long end_point = (request.getParameter("end_point")==null)? 0:Long.parseLong(request.getParameter("end_point")+"");
//로그파일이 있는 디렉토리


StringBuffer sb = new StringBuffer();
RandomAccessFile read_file = new RandomAccessFile(log_dir+"\\"+log_filename, "r"); 
long str_length = read_file.length(); 
long start_point = (end_point>0)?end_point:str_length;
read_file.seek(start_point);   
String str;
long file_point = start_point;
while((str = read_file.readLine()) != null){
	sb.append(toKorean(str)+"\n");
	file_point = read_file.getFilePointer();
	read_file.seek(file_point);   
}
read_file.close(); 
String log_data = sb.toString();
out.print(file_point+","+log_data);
%>