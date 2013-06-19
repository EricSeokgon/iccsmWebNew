<%@ page contentType="text/html; charset=euk-kr" %>
<%@ page language="java"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!--<%@ page import="org.apache.commons.logging.Log"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>
<% Log logger = LogFactory.getLog(this.getClass()); %>
//-->
<%
	String Insert_Sql = null;   // insert sql문으로 사용할 변수
	String Update_Sql = null;   // update sql문으로 사용할 변수
	String Delete_Sql = null;   // delete sql문으로 사용할 변수

	Connection conn = null; //Connection 객체
	
	//sql에서 사용할 statement를 선언
	PreparedStatement pstmt= null;
	
	// sql결과를 받을 resultset 선언
	ResultSet rs = null; 
	int rvalue=-1;
	
	String db_driver="oracle.jdbc.driver.OracleDriver"; 
	String db_url="jdbc:oracle:thin:@99.1.5.77:1521:iccs1";
	String db_user="iccs"; 
	String db_password="iccs1441$"; 

	try
	{ 
		Class.forName(db_driver); 
		try
		{ 
			conn = DriverManager.getConnection(db_url,db_user,db_password); 
		}catch(Exception e){ 
			System.out.println("DB에 연결할 수 없습니다." + e.toString()); 
			conn = null;
		} 
	}catch(ClassNotFoundException e){ 
		System.out.println("JDBC 드라이버를 찾을 수 없습니다." + e); 
		conn = null;
	} 
%>