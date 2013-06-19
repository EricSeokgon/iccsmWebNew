<%@ page contentType="text/html;charset=euc-kr" %><%@ 
page language="java"%><%@ 
page import="com.tobesoft.platform.*" %><%@ 
page import="com.tobesoft.platform.data.*" %><%@ 
page import="java.io.*" %><%@ 
page import="java.net.*" %><%@ 
page import="java.util.Enumeration" %><%@ 
page import="java.sql.*" %><%
    
PlatformData in_data = null;   
DatasetList  in_dl = new DatasetList();
VariableList in_vl = new VariableList();
	
System.out.println("---------------->");

String str = "abc\0def";

for (int i = 0; i < str.length(); i++) 
{ 
   if(str.charAt( i ) == 0x00)
   {
	   System.out.println(str.charAt( i ) + "<===null data");
   } else {
   	System.out.println(str.charAt( i ));
   }

   
} 

%>