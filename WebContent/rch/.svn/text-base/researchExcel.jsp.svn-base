<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="kjf.cfg.Config" %>
<%@ page import="org.apache.poi.hssf.util.*,org.apache.poi.hssf.usermodel.*,java.io.*,java.util.Date,java.sql.*"%>

<%
	// 설문정보 
  	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

	ReportEntity objQstList = (ReportEntity)request.getAttribute("objQstList");
	ReportEntity sbjQstList = (ReportEntity)request.getAttribute("sbjQstList");
	ReportEntity userInfoList = (ReportEntity)request.getAttribute("userInfoList");
	
	ArrayList listObjqst_Exam     = (ArrayList)request.getAttribute("listObjqst_Exam");
	ArrayList listObjqstUser_Exam = (ArrayList)request.getAttribute("listObjqstUser_Exam");
	ArrayList listSbjQstAnswer    = (ArrayList)request.getAttribute("listSbjQstAnswer");	// 주관식 대답List

	// 참여자수 
	String totJoinCnt = (String)request.getAttribute("totJoinCnt");
	
	// 참여기간 
	String strDate = rEntity.getValue(0, "S_DATE") + " ~ " + rEntity.getValue(0, "E_DATE");

  	String filename = "[" + rEntity.getValue(0, "S_DATE") + "]-[" + rEntity.getValue(0, "E_DATE") + "]"+ "_설문결과.xls";
	// 엑셀로출력될 화일이름.. request.getParameter("filename")으로 받아서 사용하면 다른 화일이름으로도 저장이 가능합니다.
  	

  	String filePath = Config.props.get("BBS_FILE_DIR");

  	HSSFWorkbook wb = new HSSFWorkbook();            //workbook생성
  	HSSFSheet sheet1 = wb.createSheet("RESELT");  //worksheet에 new sheet생성

  	HSSFRow row   = null;
  	HSSFCell cell = null;

	// 스타일 부분으로  alias 제목 부분에 아쿠아색의 빗살무늬를 지정합니다.
	
	// 타이틀 스타일 
	HSSFCellStyle style = wb.createCellStyle();
	style.setAlignment(HSSFCellStyle.ALIGN_CENTER);	
	style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    style.setFillForegroundColor(HSSFColor.TAN.index);
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	
    // 질문 스타일 
	HSSFCellStyle style1 = wb.createCellStyle();
	style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
	style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	
	// 객관식 질문 타이틀 스타일 
	HSSFCellStyle style2 = wb.createCellStyle();
	style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);	
	style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	style2.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
    style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    
	// 객관신 질문 스타일 
	HSSFCellStyle style3 = wb.createCellStyle();
	style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);	
	style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	style3.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
    style3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    
	// 객관신 질문 스타일 
	HSSFCellStyle styleUser = wb.createCellStyle();
	styleUser.setAlignment(HSSFCellStyle.ALIGN_CENTER);	
	styleUser.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	styleUser.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
	styleUser.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

  	row = sheet1.createRow((short)0);
	
  	/********************************* 타이틀 START ****************************/  
  	// 셀병합 
  	sheet1.addMergedRegion(new Region(1, (short)0, 1, (short)5)); 	// RowFrom(), ColumnFrom(), RowTo(), ColumnTo  	
  	sheet1.addMergedRegion(new Region(1, (short)6, 1, (short)8)); 	
  	sheet1.addMergedRegion(new Region(1, (short)9, 1, (short)10)); 
  	sheet1.addMergedRegion(new Region(1, (short)11, 1, (short)12)); 
  	
  	cell = row.createCell((short)0);
   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
   	cell.setCellValue("제목");   	
   	sheet1.addMergedRegion(new Region(0, (short)0, 0, (short)5));   	
   	cell.setCellStyle(style);
   	
   	cell = row.createCell((short)6);
   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
   	cell.setCellValue("기간");   	
   	sheet1.addMergedRegion(new Region(0, (short)6, 0, (short)8)); 	
   	cell.setCellStyle(style);
   	
   	cell = row.createCell((short)9);
   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
   	cell.setCellValue("등록인");   	
   	sheet1.addMergedRegion(new Region(0, (short)9, 0, (short)10)); 
   	cell.setCellStyle(style);
   	
   	cell = row.createCell((short)11);
   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
   	cell.setCellValue("참여자수");   	
   	sheet1.addMergedRegion(new Region(0, (short)11, 0, (short)12));   	
   	cell.setCellStyle(style);
   	
   	row = sheet1.createRow((short)1);
   	cell = row.createCell((short)0);
   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
   	cell.setCellValue(rEntity.getValue(0, "TITLE"));
   	cell.setCellStyle(style1);
   	
   	cell = row.createCell((short)6);
   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
   	cell.setCellValue(strDate);
   	cell.setCellStyle(style1);
   	
   	cell = row.createCell((short)9);
   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
   	cell.setCellValue(rEntity.getValue(0, "USER_INFO"));
   	cell.setCellStyle(style1);
   	
   	cell = row.createCell((short)11);
   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
   	cell.setCellValue(totJoinCnt);
   	cell.setCellStyle(style1);   
   	/********************************* 타이틀 END ****************************/
	
   	
   	
   	/********************************* 질문결과  START ****************************/  
   	int colQstIdx          = 1;	// 객관식질문 타이틀  셀 인덱스
   	int colOstexamIdx      = 0;	// 객관식질문 셀 인덱스 
	int colQstUserCntIdx   = 0; // 사용자결과 셀 인덱스  	
	int colAnswerIdx       = 1;
	int tempExamSize       = 1;
	
	
	// 시트 컬럼 디폴트 사이즈 적용 (10)
   	sheet1.setDefaultColumnWidth((short)10);      	
   	
   	
   	// 객관식 질문 
   	for (int i = 0; i < objQstList.getRowCnt(); i++) {          
   	    
   	 	ReportEntity entExam = (ReportEntity)listObjqst_Exam.get(i);      // 객관식 질문 List Entity   
   	    ArrayList arrUserExam  = (ArrayList)listObjqstUser_Exam.get(i);
   	 	
   	 	/************************** 객관식 질문 타이틀 START ***********************/
	    row = sheet1.createRow((short)4);
	    
	    cell = row.createCell((short)colQstIdx);
	   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
	   	cell.setCellValue(objQstList.getValue(i, "QUESTION"));
	 	cell.setCellStyle(style2);  
	   	
	   	// 셀병합 (객관식 타이틀을 객관식 질문갯수만큼 셀병합을 한다.)
	    sheet1.addMergedRegion( new Region(4, (short)colQstIdx, 4, (short)(colQstIdx + entExam.getRowCnt()-1) ));
	   
	    colQstIdx++;
	    /************************** 객관식 질문 타이틀 END *************************/
	   		 	
	    
    	/************************** 객관식 질문 List START ***********************/
   	 	for(int k = 0; k < entExam.getRowCnt(); k++) {
	   	 	row = sheet1.createRow((short)5);
		    
		    cell = row.createCell((short)++colOstexamIdx);
		   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
		   	cell.setCellValue((k+1) + "." + entExam.getValue(k, "EXAM"));
		   	cell.setCellStyle(style3); 
   	 	}
   	 	/************************** 객관식 질문 List END *************************/  	 	
   	 	
   	 	colQstIdx += entExam.getRowCnt() -1;	
   	 	
   	 	
		/************************** 객관식 사용자 응답 START ***********************/   	 	
   	 	
   	 	int rowQstAnswerIdx = 7;		// 사용자 응답 ROW인덱스    	 	
   	 	
   	 	
		// 객관식 사용자 응답 List
   	 	for (int m = 0; m < arrUserExam.size(); m++) {    	 	    
   	 	    
	   	 	HashMap mapTemp = (HashMap) arrUserExam.get(m);
	   	    
	   	    String USER_ID       = (String) mapTemp.get("USER_ID");
	   	    String ETC_ANSWER    = (String) mapTemp.get("ETC_ANSWER");
	   	    ArrayList listAnswer = (ArrayList) mapTemp.get("LIST_ANSERE");	
   	 	    
	   	 	row = sheet1.createRow((short)rowQstAnswerIdx++);	  	 			   	    
		   	    
	   	 	colAnswerIdx = tempExamSize;
	   	 	
   	 		for(int n = 0; n < entExam.getRowCnt(); n++) {
   	 		    	
 	 			for (int p = 0; p < listAnswer.size(); p++) {
 	 			    
 	 			    if ( !"99".equals(entExam.getObjValue(n, "NUM")) ) {
 	 			      if ((n + 1) == KJFUtil.str2int((String) listAnswer.get(p))) {
 		 	 		        cell = row.createCell((short)colAnswerIdx);
 					   		cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
 					   		cell.setCellValue((String) listAnswer.get(p)); 
 			   	      	} 
 	 			    } else {
 	 			      	cell = row.createCell((short)colAnswerIdx);
				   		cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
				   		cell.setCellValue(ETC_ANSWER); 
 	 			    } 	 		         	 		    	    
 	 		    }
 	 		    
 	 		  colAnswerIdx++;
 	 		    
			   	 			   	   
	   	    }		   	
   	 		
   	 	 	
   	 	}
   	 	/************************** 객관식 사용자 응답 START ***********************/	
   	 	
   	 	tempExamSize += (entExam.getRowCnt());
		 	 	
   	}
   	
  	/************************** 객관식응답 사용자  START ***********************/   	 	
 	int rowUserCntIdx = 7;		// 사용자 응답 ROW인덱스      	 	
 
 	for (int i = 0; i < userInfoList.getRowCnt(); i++) {   	 	    
 	   	row = sheet1.createRow((short)rowUserCntIdx++);    	 		   
 	   	 	
	    cell = row.createCell((short)0);
	   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
	   	cell.setCellValue((i + 1) + "." + userInfoList.getValue(i, "USER_NAME"));  
	   	cell.setCellStyle(styleUser); 		   		
 	}
 	/************************** 객관식응답 사용자   END ***********************/	  
   	
   	
 	
   	/************************** 주관식 질문   START ***********************/
   	for (int i = 0; i < sbjQstList.getRowCnt(); i++) {
   	 	row = sheet1.createRow((short)4);
	    
	    cell = row.createCell((short)colQstIdx);
	   	cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
	   	cell.setCellValue(sbjQstList.getValue(i, "QUESTION"));
	   	
	   	// 주관식 사용자 응답정보
	   	ReportEntity sbjAnswerEnt = (ReportEntity) listSbjQstAnswer.get(i);
	   	
	   	
	   	int colObjQstIdx = colQstIdx;
	   	int rowbjQstIdx = 7;
	   	for (int j = 0; j < sbjAnswerEnt.getRowCnt(); j++) {
	   	 	row = sheet1.createRow((short)rowbjQstIdx++);
	   	    cell = row.createCell((short)colObjQstIdx);
	   		cell.setEncoding( HSSFCell.ENCODING_UTF_16 );
	   		cell.setCellValue((String)sbjAnswerEnt.getObjValue(j, "ANSWER"));
	   		cell.setCellStyle(styleUser);
	   	}
	   	
	   	colQstIdx++;
	   	
   	}   	                                    
   	/************************** 객주관식 질문    END ***********************/	  
   	
   	
   	/********************************* 질문결과 END ****************************/  
   	
   	
   	

  	// 파일저장("_temp/"에 임시 저장을 합니다. 그리고 아래부분에서 다운받는 즉시 삭제합니다. 
  	// 중복은 거의 없을 겁니다. 이부분에서 고생을 많이 했는데 더 좋은 방법있는분은 알려주세요.)
  	FileOutputStream fileOut = null;
  	
  	try {
   		fileOut = new FileOutputStream(filePath+filename);
  	} catch (FileNotFoundException e) {
   		System.out.println(e);
  	}
  	
 	try {
   		wb.write(fileOut);
   		fileOut.close();
  	} catch (IOException e) {
   		System.out.println(e);
  	}
%>

<%
 	/** 여기부터 화일 다운로드 창이 자동으로 뜨게 하기 위한 코딩(임시화일을 스트림으로 저장) **/
	File file = new File (filePath + filename);  			// 해당 경로의 파일 객체를 만든다.
 	
	byte[] bytestream = new byte[(int)file.length()];  		// 파일 스트림을 저장하기 위한 바이트 배열 생성.
 	
 	FileInputStream filestream = new FileInputStream(file); // 파일 객체를 스트림으로 불러온다.
 	
 	int i = 0, j = 0;   // 파일 스트림을 바이트 배열에 넣는다.
 	
 	while ((i = filestream.read()) != -1) {
  		bytestream[j] = (byte)i;
  		j++;
 	}
 
 	filestream.close();   // FileInputStream을 닫아줘야 file이 삭제된다.

 	try {
  		boolean  success = file.delete(); // 화일을 생성과 동시에 byte[]배열에 입력후 화일은 삭제
  		if(!success) System.out.println("<script>alert('not success')</script>");
  	
 	} catch (IllegalArgumentException e) {
  		System.err.println(e.getMessage());
 	}

 	String filename1 = "";

 	filename1= java.net.URLEncoder.encode(filename, "UTF8");

 	response.setContentType("application/vnd.ms-excel;charset=EUC-KR");  		  	// 응답 헤더의 Content-Type을 세팅한다.
 	response.setHeader("Content-Disposition", "attachment; filename=" + filename1); // Content-Disposition 헤더에 파일 이름 세팅.
 	out.clear();
 	OutputStream outStream = response.getOutputStream();  // 응답 스트림 객체를 생성한다.
 	outStream.write(bytestream);  						  // 응답 스트림에 파일 바이트 배열을 쓴다.
 	outStream.close();
%>