<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page language="java"%>
<%@ page import="com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page import="java.io.*" %>

<%@ page import="kjf.util.*" %>
<%@ page import="kjf.cfg.Config" %>
<%@ page import="kjf.util.KJFFile" %>
<%@ page import="sp.webservice.UBAgentPortTypeProxy" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%

	String default_charset = "utf-8";

	// ZLIB_COMP,LZSS_COMP,XML

	int default_encode_method = PlatformRequest.ZLIB_COMP;
	

	PlatformRequest platformRequest = new PlatformRequest(request, default_charset);
	PlatformResponse platformResponse = new PlatformResponse(response, default_encode_method, default_charset);
	//System.out.println("--->" + request.getContentLength());	
	PlatformData in_data = null;

	VariableList out_vl = new VariableList();

	String sido_code = request.getParameter("SIDO_CODE");
	String sigg_code = request.getParameter("SIGUNGU_CODE");
	String area_url  = request.getParameter("AREA_URL");
  
	DatasetList  out_dl = new DatasetList();

	try { 
	 	if ( request.getContentLength() > 0 )
	 	{
			 platformRequest.receiveData();
	 	}
	 	else
	 	{
			out_vl.addStr("ErrorCode", "-1");
			out_vl.addStr("ErrorMsg","입력할 Dataset를 넘겨받지 못하였습니다.");
			platformResponse.sendData(out_vl, out_dl);
			return;
	 	}

		in_data = platformRequest.getPlatformData();
		VariableList in_vl = platformRequest.getVariableList();
		DatasetList in_dl = platformRequest.getDatasetList();
		Dataset inds = in_data.getDatasetList().getDataset("input");

		if (inds == null)
		{
			out_vl.addStr("ErrorCode", "-1");
			out_vl.addStr("ErrorMsg","입력 Dataset을 찾을 수 없습니다.[input]");
			platformResponse.sendData(out_vl, out_dl);
			return;
		}

		int irow = inds.getRowCount();
		int nrow = 0;

	/* 기본 설정 */
		for (int i = 0 ; i < irow ; i++)
		{
			String filename;
			Variant aa;
			KJFLog.log("filename:" + inds.getColumn(i, "file_name") + ", path:" + inds.getColumn(i, "path") + 	", filesize:" + inds.getColumn(i, "filesize"));
			byte[] file = inds.getColumn(i, "content").getBinary();
			filename = inds.getColumn(i, "file_name").toString();
		
//			ByteArrayInputStream is = new ByteArrayInputStream(file);
			
//			String filePath = Config.props.get("AREA_FILE_DIR")+"usebefore"+KJFFile.FILE_S+sido_code+KJFFile.FILE_S+sigg_code;
			
//			filePath = filePath + KJFFile.FILE_S + filename;

//			FileOutputStream s = new FileOutputStream(filePath);

			byte[] in = new byte[(int)file.length];  
			
/*		
			int len = 0;  
			int byteData = 0;
			int offset = 0;
			int ch;

			while ((len = is.read(in, offset, in.length)) != -1 );
			len = is.read(in, offset, in.length);

			s.write(in);			//서버로 파일 write
			is.close();
			s.close();
*/

			UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(area_url+"/iccsWs/services/UBAgent");
			
			String key= KJFSec.encode(sigg_code);

			//String filePath2 = Config.props.get("AREA_FILE_DIR")+"usebefore/"+sido_code+"/"+sigg_code;
			//filePath2 = filePath2 + "/" + filename;
			//String filePath2 = Config.props.get("AREA_FILE_DIR")+"usebefore"+KJFFile.FILE_S+sido_code+KJFFile.FILE_S+sigg_code;
			//filePath2 = filePath2 + KJFFile.FILE_S + filename;
			//File files = new File(filePath2); 
			//int result = ub.setFile(key,KJFFile.readFromFile(files),sigg_code,filename);

			int result = ub.setFile(key,in,sigg_code,filename);
			System.out.println("발송 값 : "+result);
			System.out.println("0 : 전송실패");
			System.out.println("1 : 완료 ");
			break;
		}
	}	
	catch(Exception e)
	{
		System.out.println(e.toString());
	}

	out_vl.addStr("ErrorCode", "0");
	out_vl.addStr("ErrorMsg","OK");

	//PlatformData pdata = new PlatformData (out_vl, out_dl);
	//platformResponse.sendData(out_vl, out_dl);

%>