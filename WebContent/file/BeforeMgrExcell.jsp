<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page language="java"%>
<%@ page import="com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page import="com.tobesoft.platform.data.DatasetList" %>
<%@ page import="com.tobesoft.platform.data.VariableList" %>
<%@ page import="com.tobesoft.platform.data.ColumnInfo" %>
<%@ page import="com.tobesoft.platform.data.Dataset" %>
<%@ page import="java.io.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="kjf.util.KJFFile" %>
<%@ page import="kjf.ops.ReportDAO" %>
<%@ page import="kjf.ops.ReportEntity" %>
<%@ page import="sp.ub.cmd.BeforeExcelWCmd" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%
	String default_charset = "utf-8";
	
	int default_encode_method = PlatformRequest.ZLIB_COMP;
	PlatformRequest platformRequest = new PlatformRequest(request, default_charset);
	PlatformResponse platformResponse = new PlatformResponse(response, default_encode_method, default_charset);
  PlatformData in_data = null;
	VariableList out_vl = new VariableList();
	DatasetList  out_dl = new DatasetList();

  /****** Service API 초기화 ******/
  DatasetList  dl = new DatasetList();  	
	VariableList vl = new VariableList();
	
	ReportDAO    rDAO        = new ReportDAO();
  ReportEntity rEntity     = null;

  String CIV_RECV_NUM = request.getParameter("CIV_RECV_NUM");
  String SIDO_CODE = request.getParameter("SIDO_CODE");
  String SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");

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

		String filename;
		Variant aa;
		byte[] file = inds.getColumn(0, "content").getBinary();
		filename = inds.getColumn(0, "file_name").toString();
		InputStream is = new ByteArrayInputStream(file);
		String excelResult[][]= null;

		KJFExcel excel = new KJFExcel(is);
		
		excel.setStartRow(1);
		excel.setLastCell(109);
		excelResult = excel.read();
		
		
		/*for (int i =0 ; i <= excelResult.length-1; i++){			
			for (int j = 0 ; j < excelResult[i].length; j++){				
				if (KJFUtil.print(excelResult[i][j],"") != "" ){
					System.out.println(excelResult[i][j]);
				}
			}
		}
		*/
		
		for (int i =0 ; i <= excelResult.length-1; i++){			
			for (int j = 0 ; j < excelResult[i].length; j++){				
				if (KJFUtil.print(excelResult[i][j],"")!= "" ){
					 System.out.println("excelResult["+i+"]["+j+"]==="+excelResult[i][j]);  //좌표 확인용
				 }  
				}
		}
		

		String ORPE_NM = ""; 					//건축주 성명
		String ORPE_ADDR_TEMP = "";		//건축주 소재지 임시저장
		String ORPE_ADDR_TEMP2 = "";
		String ORPE_ADDR_TEMP3 = "";
		String ORPE_ADDR ="";														//건축주 소재지 
		String ORPE_DETAILADDR ="";											//건축주 상세주소소재지 
		String ORPE_TEL ="";														//건축주 연락처 
		
		String PLANER_NM = "";					//설계자 성명
		String PLANER_NAME ="";				//설계자 상호
		String PLANER_TEL = "";													//설계자 연락처
		String PLANER_ADDR_TEMP ="";	//설계자 소재지 임시저장
		String PLANER_ADDR_TEMP2 ="";
		String PLANER_ADDR_TEMP3 ="";
		String PLANER_ADDR = "";												//설계자 소재지
		String PLANER_DETAILADDR = "";									//설계자 소재지 상세주소
		String STRU_ADDR_ADDR = "";		//건축물 소재지
		String STRU_ADDR_DETAILADDR = "";		//건축물 소재지 상세주소
		
		String AREA = "";						//연면적
		String USE ="";						//용도
		

    if(excelResult[13][22] !=null && excelResult[14][22] !=null){

    	 ORPE_NM = excelResult[13][22]; 					//건축주 성명
		 ORPE_ADDR_TEMP = excelResult[14][22];		//건축주 소재지 임시저장
		 ORPE_ADDR ="";														//건축주 소재지 
		 ORPE_DETAILADDR ="";											//건축주 상세주소소재지 
		 ORPE_TEL ="";														//건축주 연락처 
		
		 PLANER_NM = excelResult[22][23];					//설계자 성명
		 PLANER_NAME = excelResult[23][22];				//설계자 상호
		 PLANER_TEL = "";													//설계자 연락처
		 PLANER_ADDR_TEMP = excelResult[25][22];	//설계자 소재지 임시저장
		 PLANER_ADDR = "";												//설계자 소재지
		 PLANER_DETAILADDR = "";									//설계자 소재지 상세주소
		 STRU_ADDR_ADDR = excelResult[26][22];		//건축물 소재지
		 STRU_ADDR_DETAILADDR = excelResult[27][66];		//건축물 소재지 상세주소
		
		 AREA = excelResult[32][71];						//연면적
		 USE = excelResult[36][12];	
		
    }
    else if(excelResult[14][27] !=null && excelResult[15][27] !=null){
		
    	 ORPE_NM = excelResult[14][27]; 					//건축주 성명
		 ORPE_ADDR_TEMP = excelResult[15][27];		//건축주 소재지 임시저장
		 ORPE_ADDR ="";														//건축주 소재지 
		 ORPE_DETAILADDR ="";											//건축주 상세주소소재지 
		 ORPE_TEL ="";														//건축주 연락처 
		
		 PLANER_NM = excelResult[16][27];					//설계자 성명
		 PLANER_NAME = excelResult[18][27];				//설계자 상호
		 PLANER_TEL = "";													//설계자 연락처
		 PLANER_ADDR_TEMP = excelResult[19][27];	//설계자 소재지 임시저장
		 PLANER_ADDR = "";												//설계자 소재지
		 PLANER_DETAILADDR = "";									//설계자 소재지 상세주소
		 STRU_ADDR_ADDR = excelResult[20][27];		//건축물 소재지
		 STRU_ADDR_DETAILADDR = excelResult[21][27];		//건축물 소재지 상세주소
		
		 AREA = excelResult[27][72];						//연면적
		 USE = excelResult[31][13];						//용도
		
		
    }
    else if(excelResult[13][21] !=null && excelResult[14][21] !=null){
    	 ORPE_NM = excelResult[13][21]; 					//건축주 성명
		 ORPE_ADDR_TEMP = excelResult[14][21];		//건축주 소재지 임시저장
		 ORPE_ADDR ="";														//건축주 소재지 
		 ORPE_DETAILADDR ="";											//건축주 상세주소소재지 
		 ORPE_TEL ="";														//건축주 연락처 
		
		 PLANER_NM = excelResult[22][22];					//설계자 성명
		 PLANER_NAME = excelResult[23][21];				//설계자 상호
		 PLANER_TEL = "";													//설계자 연락처
		 PLANER_ADDR_TEMP = excelResult[25][21];	//설계자 소재지 임시저장
		 PLANER_ADDR = "";												//설계자 소재지
		 PLANER_DETAILADDR = "";									//설계자 소재지 상세주소
		 STRU_ADDR_ADDR = excelResult[26][21];		//건축물 소재지
		 STRU_ADDR_DETAILADDR = excelResult[27][21];		//건축물 소재지 상세주소
		
		 AREA = excelResult[32][69];						//연면적
		 USE = excelResult[36][11]; 						//용도
		
    }
    else if(excelResult[14][29] !=null && excelResult[16][29] !=null){
   	     ORPE_NM = excelResult[14][29]; 					//건축주 성명
		 ORPE_ADDR_TEMP2 = excelResult[16][29];		//건축주 소재지 임시저장
		 ORPE_ADDR ="";														//건축주 소재지 
		 ORPE_DETAILADDR ="";											//건축주 상세주소소재지 
		 ORPE_TEL = excelResult[16][95];								//건축주 연락처 
		
		 PLANER_NM = excelResult[25][19];					//설계자 성명
		 PLANER_NAME = excelResult[27][25];				//설계자 상호
		 PLANER_TEL = excelResult[29][93];					//설계자 연락처
		 PLANER_ADDR_TEMP2 = excelResult[29][25];	//설계자 소재지 임시저장
		 PLANER_ADDR = "";												//설계자 소재지
		 PLANER_DETAILADDR = "";									//설계자 소재지 상세주소
		 STRU_ADDR_ADDR = excelResult[32][25];		//건축물 소재지
		 STRU_ADDR_DETAILADDR = excelResult[34][25];		//건축물 소재지 상세주소
		
		 AREA = excelResult[46][75];						//연면적
		 USE = excelResult[53][17];							//용도
		
   }

    else if(excelResult[14][28] !=null && excelResult[16][28] !=null && excelResult[29][95] !=null){
 	     ORPE_NM = excelResult[14][28]; 					//건축주 성명
		 ORPE_ADDR_TEMP2 = excelResult[16][28];		//건축주 소재지 임시저장
		 ORPE_ADDR ="";														//건축주 소재지 
		 ORPE_DETAILADDR ="";											//건축주 상세주소소재지 
		 ORPE_TEL = excelResult[29][95];								//건축주 연락처 
		
		 PLANER_NM = excelResult[25][18];					//설계자 성명
		 PLANER_NAME = excelResult[27][24];				//설계자 상호
		 PLANER_TEL = excelResult[29][95];					//설계자 연락처
		 PLANER_ADDR_TEMP2 = excelResult[29][24];	//설계자 소재지 임시저장
		 PLANER_ADDR = "";												//설계자 소재지
		 PLANER_DETAILADDR = "";									//설계자 소재지 상세주소
		 STRU_ADDR_ADDR = excelResult[31][31];		//건축물 소재지
		 STRU_ADDR_DETAILADDR = excelResult[33][24];		//건축물 소재지 상세주소
		
		 AREA = excelResult[43][75];						//연면적
		 USE = excelResult[48][16];							//용도
		 
 }
    else if(excelResult[16][22] !=null && excelResult[18][22] !=null ){
 	     ORPE_NM = excelResult[16][22]; 					//건축주 성명
		 ORPE_ADDR_TEMP3 = excelResult[18][22];		//건축주 소재지 임시저장
		 ORPE_ADDR ="";														//건축주 소재지 
		 ORPE_DETAILADDR ="";											//건축주 상세주소소재지 
		 ORPE_TEL = excelResult[18][69];								//건축주 연락처 
		
		 PLANER_NM = excelResult[27][11];					//설계자 성명
		 PLANER_NAME = excelResult[29][21];				//설계자 상호
		 PLANER_TEL = excelResult[31][70];					//설계자 연락처
		 PLANER_TEL = PLANER_TEL.substring(PLANER_TEL.indexOf(':')+1,PLANER_TEL.lastIndexOf(')')); //설계자 연락처 파싱
		 //PLANER_ADDR_TEMP3 = excelResult[31][21];	//설계자 소재지 임시저장
		 //PLANER_ADDR = "";												//설계자 소재지
		 PLANER_ADDR = excelResult[31][21];											//설계자 소재지
		 PLANER_DETAILADDR = "";									//설계자 소재지 상세주소
		 STRU_ADDR_ADDR = excelResult[33][23];		//건축물 소재지
		 STRU_ADDR_DETAILADDR = excelResult[34][23];		//건축물 소재지 상세주소
		
		 AREA = excelResult[44][62];						//연면적
		 USE = excelResult[47][16];							//용도
		
 }
		
    else{ 
    	System.out.println("엑셀");
    	return;
    }
/*		
	for (int i =0 ; i <= excelResult.length-1; i++){			
		for (int j = 0 ; j < excelResult[i].length; j++){				
			if (KJFUtil.print(excelResult[i][j],"") != "" ){
				 System.out.println("excelResult["+i+"]["+j+"]==="+excelResult[i][j]);  //좌표 확인용
			 }  
			}
	}
*/
	
		if (!"".equals(ORPE_ADDR_TEMP.trim())){
		 ORPE_ADDR = ORPE_ADDR_TEMP.substring(0,ORPE_ADDR_TEMP.lastIndexOf('동')+1);  
		 ORPE_DETAILADDR = ORPE_ADDR_TEMP.substring(ORPE_ADDR_TEMP.lastIndexOf('동')+1,ORPE_ADDR_TEMP.lastIndexOf('(')); 
		 ORPE_TEL = ORPE_ADDR_TEMP.substring(ORPE_ADDR_TEMP.indexOf(':')+1,ORPE_ADDR_TEMP.lastIndexOf(')')); 
		}

				
		if (!"".equals(PLANER_ADDR_TEMP.trim())){
		 PLANER_TEL = PLANER_ADDR_TEMP.substring(PLANER_ADDR_TEMP.indexOf(':')+1,PLANER_ADDR_TEMP.lastIndexOf(')')); //설계자 연락처 파싱
		 PLANER_ADDR = PLANER_ADDR_TEMP.substring(0,PLANER_ADDR_TEMP.lastIndexOf('동')+1);	//설계자 소재지 파싱
		 PLANER_DETAILADDR = PLANER_ADDR_TEMP.substring(PLANER_ADDR_TEMP.lastIndexOf('동')+1,PLANER_ADDR_TEMP.lastIndexOf('(')); //설계자 상세주소소재지 파싱
		}
		
		if (!"".equals(ORPE_ADDR_TEMP2.trim())){
				
			 ORPE_ADDR = ORPE_ADDR_TEMP2.substring(0,ORPE_ADDR_TEMP2.lastIndexOf('리')+1);  
			 ORPE_DETAILADDR = ORPE_ADDR_TEMP2.substring(ORPE_ADDR_TEMP2.lastIndexOf('리')+1); 
			 ORPE_TEL = ORPE_TEL.substring(ORPE_TEL.indexOf(':')+1,ORPE_TEL.lastIndexOf(')')); 
			}

					
			if (!"".equals(PLANER_ADDR_TEMP2.trim())){
			 PLANER_TEL = PLANER_TEL.substring(PLANER_TEL.indexOf(':')+1,PLANER_TEL.lastIndexOf(')')); //설계자 연락처 파싱
			 PLANER_ADDR = PLANER_ADDR_TEMP2.substring(0,PLANER_ADDR_TEMP2.lastIndexOf('리')+1);	//설계자 소재지 파싱
			 PLANER_DETAILADDR = PLANER_ADDR_TEMP2.substring(PLANER_ADDR_TEMP2.lastIndexOf('리')+1); //설계자 상세주소소재지 파싱
			}
			
			if (!"".equals(ORPE_ADDR_TEMP3.trim())){
				
				 ORPE_ADDR = ORPE_ADDR_TEMP3.substring(0,ORPE_ADDR_TEMP3.lastIndexOf('리')+1);  
				 ORPE_DETAILADDR = ORPE_ADDR_TEMP3.substring(ORPE_ADDR_TEMP3.lastIndexOf('리')+1); 
				 ORPE_TEL = ORPE_TEL.substring(ORPE_TEL.indexOf(':')+1,ORPE_TEL.lastIndexOf(')')); 
				}

						
				if (!"".equals(PLANER_ADDR_TEMP3.trim())){
				 
				PLANER_ADDR = PLANER_ADDR_TEMP3.substring(0,PLANER_ADDR_TEMP3.lastIndexOf('리')+1);	//설계자 소재지 파싱
				PLANER_DETAILADDR = PLANER_ADDR_TEMP3.substring(PLANER_ADDR_TEMP3.lastIndexOf('리')+1); //설계자 상세주소소재지 파싱
				}
		
		
    String selectSQL=
    		"	SELECT *   FROM PT_UB_CONSTRUCTION  \n";
    	
    String whereSQL = "WHERE CIV_RECV_NUM = '"+CIV_RECV_NUM+"'   \n" +
		   				   " AND SIDO_CODE = '"+SIDO_CODE+"'   \n" +
		   				   " AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  ";
    	
    rEntity    = rDAO.select(selectSQL+whereSQL);        
    
		Dataset ds = new Dataset("output");
		
		for(int j=0; j< rEntity.getFieldCnt();j++ ){			
			ds.addColumn(rEntity.getName(j),ColumnInfo.CY_COLINFO_STRING, 20);
		}
		
		for(int i=0; i< rEntity.getRowCnt();i++){
			int row = ds.appendRow();
			for(int j=0; j< rEntity.getFieldCnt();j++ ){
			ds.setColumn(row, rEntity.getName(j), rEntity.getValue(i,j).replace( '\0', ' ' ) );
			ds.setColumn(row, "ORPE_NM", ORPE_NM);
			ds.setColumn(row, "ORPE_ADDR", ORPE_ADDR);
			ds.setColumn(row, "ORPE_DETAILADDR", ORPE_DETAILADDR);
			ds.setColumn(row, "ORPE_TEL", ORPE_TEL);
			ds.setColumn(row, "PLANER_NM", PLANER_NM);
			ds.setColumn(row, "PLANER_NAME", PLANER_NAME);
			ds.setColumn(row, "PLANER_TEL", PLANER_TEL);
			ds.setColumn(row, "PLANER_ADDR", PLANER_ADDR);
			ds.setColumn(row, "PLANER_DETAILADDR", PLANER_DETAILADDR);
			ds.setColumn(row, "STRU_ADDR_ADDR", STRU_ADDR_ADDR);
			ds.setColumn(row, "STRU_ADDR_DETAILADDR", STRU_ADDR_DETAILADDR);
			ds.setColumn(row, "AREA", AREA);
			ds.setColumn(row, "USE", USE);
			}
		}	
		
		
	
/********* 생성된 Dataset을 DatasetList에 추가 ************/
		dl.addDataset(ds);
				 
	}catch (Exception e){
		e.printStackTrace();
	
	}

	
	vl.addStr("ErrorCode", "0");
	vl.addStr("ErrorMsg", "SUCC");
	
	/******** 결과 XML 생성 및 Web Server로 전달 ******/
	out.clear(); //out jsp자체 객체
	out=pageContext.pushBody(); //out jsp자체 객체
	PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "utf-8");
	pRes.sendData(vl, dl);
	

%>
