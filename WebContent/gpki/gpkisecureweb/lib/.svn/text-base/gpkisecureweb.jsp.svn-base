<%@ page import="com.gpki.io.GPKIJspWriter" %>
<%@ page import="com.gpki.servlet.GPKIHttpServletRequest" %>
<%@ page import="com.gpki.servlet.GPKIHttpServletResponse" %>
<%@ page import="com.gpki.secureweb.GPKIKeyInfo" %>
<%@ page import="com.dsjdf.jdf.*" %>
<%@ page import="java.net.*"%>
<%
    GPKIHttpServletResponse gpkiresponse = null;
    GPKIHttpServletRequest gpkirequest = null;

    try{
        gpkiresponse=new GPKIHttpServletResponse(response); 
	    gpkirequest= new GPKIHttpServletRequest(request);

        gpkiresponse.setRequest(gpkirequest);

        out=new GPKIJspWriter(out,(GPKIKeyInfo)session.getAttribute("GPKISession"));  
Logger.debug.println(this, "[current_thread]["+Thread.currentThread()+"] gpkisecureweb ref= " + out.toString());             
    }catch(Exception e){

        com.dsjdf.jdf.Config dsjdf_config = new com.dsjdf.jdf.Configuration();
        StringBuffer sb=new StringBuffer(1500);
        sb.append(dsjdf_config.get("GPKISecureWeb.errorPage"));
        sb.append("?errmsg=");
        sb.append(URLEncoder.encode(e.getMessage()));
        
        response.sendRedirect(sb.toString()) ;  

		return;
    }
%>