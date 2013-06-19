<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="kjf.util.*" %>
<%@ page import="javax.activation.*" %>
<%@ page import="sp.webservice.UBAgentPortTypeProxy" %>

<%
	String fName = request.getParameter("filename");
	String sfName = request.getParameter("sysfilename");//2010-05-07
	String fileSize = request.getParameter("fileSize");
	String recv_num = request.getParameter("recv_num");
	String sido_code = request.getParameter("sido_code");//2010-05-07
	String sigungu_code = request.getParameter("sigungu_code");
	String sigungu_server = request.getParameter("sigungu_server");  //2009-09-13

try{
	response.setContentType("application/x-msdownload;charset=utf-8");
	response.setHeader("Content-Disposition", "attachment ; filename =" + fName);
    response.setHeader("Content-Length", ""+fileSize);
    response.setHeader("Content-Transfer-Encoding", "binary;");	

	//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://localhost/iccsWs/services/UBAgent");
	
	UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(sigungu_server+"/iccsWs/services/UBAgent");
	String key= KJFSec.encode(sigungu_code);  		
	//byte [] ea = ub.getFile(key,recv_num,fName);
	//byte [] ea = ub.getFile(key,sigungu_code,fName); //2009-09-13
  
	//sigungu_code = "usebefore"+KJFFile.FILE_S+sido_code+KJFFile.FILE_S+sigungu_code; //2010-05-07
	
	byte [] ea = ub.getFile(key,sigungu_code,sfName); //2010-05-04
//	System.out.println("---> ea" + ea );
	ByteArrayInputStream Bain = new ByteArrayInputStream(ea);  
	BufferedOutputStream os = new BufferedOutputStream(response.getOutputStream());
	
    int read = 0;
    
    while ((read = Bain.read(ea)) != -1){
    	os.write(ea,0,read);
    }
    os.close();
    Bain.close();
		
}catch(Exception e){
	  System.out.println("Download err : \n "+e);	  
}
       
%>
<script>
window.close();
</script>