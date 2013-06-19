<%@ page contentType="text/html; charset=utf-8" %>
<%//@ page errorPage="error.jsp" %>
<%@ page import="java.io.*" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="kjf.cfg.*" %>
<%@ page import="kjf.util.*" %>
<%
		String strClient = request.getHeader("user-agent");	//사용자 브라우저 정보
		String Lo = request.getParameter("Lo");
		//서브 디렉토리는 없어도 됨
		String Sub_Lo =KJFUtil.print(request.getParameter("Sub_Lo"));
        String SYS_FILE_NAME = KJFUtil.eng2kor(request.getParameter("SYS_FILE_NAME"));  //서버에 저장된 이름

        //charset이 utf-8 일때
        String FILE_REAL_NAME = java.net.URLDecoder.decode(request.getParameter("FILE_REAL_NAME"));
        String fName= FILE_REAL_NAME;

		//파일이 존재하면 다운로드 시작
		if(KJFFile.existFile(Config.props.get(Lo)+Sub_Lo+KJFFile.FILE_S,SYS_FILE_NAME)){
	        //response.setContentType("application/x-muj-type");	        

	        String path = Config.props.get(Lo)+Sub_Lo+KJFFile.FILE_S+SYS_FILE_NAME;


	        File file = new File(path);

	        int fileSize = (int)file.length();  //파일 크기
	        
	        //사이즈가 0이면 종료처리
	        if(fileSize == 0){
	        	response.setContentType("text/html;charset=utf-8");
        		out.println(" <script>alert('파일에 문제가 있습니다.!'); history.back(-1);       </script>");
	        }else{
	        	response.setContentType("application/x-msdownload;charset=utf-8");
	        	response.setHeader("Content-Disposition", "attachment ; filename =" + fName);
		        response.setHeader("Content-Length", ""+fileSize);
		        response.setHeader("Content-Transfer-Encoding", "binary;");	
	
		        //파일 스트림을 저장하기 위한 바이트 배열 생성.
		        byte bytestream[] = new byte[fileSize];
		        out.clear();
		        //파일 객체를 스트림으로 불러온다.
		        BufferedInputStream Bfin = new BufferedInputStream(new FileInputStream(file));
		        BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
		        int read = 0;
		        while ((read = Bfin.read(bytestream)) != -1){
		        outs.write(bytestream,0,read);
		        }
		        outs.close();
		        Bfin.close();
	        }
        }else{
        	response.setContentType("text/html;charset=utf-8");
        	out.println(" <script>alert('파일이 존재하지 않습니다.!'); history.back(-1);       </script>");
        }
%>