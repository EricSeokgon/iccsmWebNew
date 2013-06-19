<%@ page import="java.io.IOException"%>
<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<%
	String _cookie = null;
    Cookie theCookie = null;
    Cookie cookies[] = request.getCookies();
    
    if (cookies != null) {
	    for(int i=0, n=cookies.length; i < n; i++) {
	    	theCookie = cookies[i];
	    	if (theCookie.getName().equals("FileParam")) {
		        try {
		        	_cookie = theCookie.getValue().toString();
		        } catch (NumberFormatException ignored) {
		        	_cookie = null;
		        }
	        	break;
	      	}
	    }
    }
    
    int len;
    	
	// FileRead 처리 (_cookie로 전달됨) 
	String confPath = config.getServletContext().getRealPath("");
	String sido_code = request.getParameter("sido_code");
	String pathType = request.getParameter("pathType");
	
	String filePath = confPath + "/"+pathType+"/" +sido_code+"/"+ _cookie;
	   
	File   file = new File(filePath);

System.out.println("_cookie --->[" + filePath + "]");

	byte b[] = new byte[4096];
	
    theCookie = null;
    String retval = "";
	int bFile;
	
	if (file.isFile()){
    	retval = "SUCC::";
    	bFile = 1;
	} else {
    	retval = "FAIL::File Not Found!!";
    	bFile = 0;
	}
    theCookie = new Cookie ("FileParam", retval);
    response.addCookie(theCookie);	
    if ( bFile == 1 )
    {	
		response.setContentType("application/octet-stream");
		out.clearBuffer();

		BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
		int read = 0;
		try {
			while ((read = fin.read(b)) != -1){
	  			outs.write(b,0,read);
		}
		outs.close();
		fin.close();
		} catch (Exception e) {
		} finally {
			if(outs!=null) outs.close();
			if(fin!=null) fin.close();
		}
	}	
%>