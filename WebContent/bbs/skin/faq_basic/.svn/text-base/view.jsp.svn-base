<%@ page contentType="text/html;charset=utf-8"%>

<table width="100%"  border="1" cellspacing="0" cellpadding="3" class="inputTable">

	<!-- 제목 : S -->
	<tr>
	    <td class="inputTable_header_td" width="10%">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</td>
	   	<td class="inputTable_td" colspan="7">
	    	<table width="100%"  border="0" cellspacing="0" cellpadding="0">
	  			<tr>
	    			<td style="word-break:break-all"><%=rEntity.getValue(0, "SUBJECT") %></td>
	    		</tr>
	    	</table>
	    </td>
	</tr>
	<!-- 제목 : E -->


	<!-- 작성자, 등록일, 조회 보기 : S -->
	<tr>
		<% if(status.isSD_DIV_YN()) { %>
		<td class="inputTable_header_td" width="10%">지&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;역</td>
	    <td class="inputTable_td">
	    	<%=rEntity.getValue(0, "SD_NM") %>
			
			<% if(status.isSGG_DIV_YN()) { %>
				<%=rEntity.getValue(0, "SGG_NM") %>
			<% } %>
		</td>   	 
		<% } %>
  	
		<td class="inputTable_header_td" width="10%">작성자</td>
	    <td class="inputTable_td"><%=rEntity.getValue(0, "USER_NAME") %></td>
	    <td class="inputTable_header_td" width="10%">등&nbsp;록&nbsp;일</td>
	    <td class="inputTable_td" width="20%" align="center"><%=rEntity.getValue(0, "INS_DT") %></td>	    
	   	<td class="inputTable_header_td" width="10%">조&nbsp;&nbsp;&nbsp;회</td>    	
	   	<td class="inputTable_td" width="8%" align="center"><%=rEntity.getValue(0, "READ_NUM")%></td>	   	   	
	</tr>
	<!-- 작성자, 등록일, 조회 보기 : E -->


	<!-- 첨부파일 보기  : S -->
	<% if( status.getATT_NUM() > 0 && FileEntity.getRowCnt() > 0 ) {%>
	<tr>
		<td class="inputTable_header_td" width="10%">첨부파일</td>
	   	<td class="inputTable_td" colspan="7" style="padding-left:5px;padding-right:5px">
	    	<table  border="0" cellspacing="0" cellpadding="0">

   				<%for (int i = 0; i < FileEntity.getRowCnt(); i++ ) {%>
				<tr>
					<td style="padding-top:2px;padding-left:5px;padding-right:5px;padding-bottom:2px;">
						<img src="../images/bbs/fileicon/<%=KJFFile.getDownFileExt(FileEntity.getValue(i,"SYS_FILE_NAME"))%>.gif" border="0">
					</td>
   					<td style="word-break:break-all">
						<a href="../com/downLoad.jsp?Lo=BBS_FILE_DIR&Sub_Lo=<%=CT_ID%>
							&SYS_FILE_NAME=<%=FileEntity.getValue(i, "SYS_FILE_NAME") %>
							&FILE_REAL_NAME=<%=java.net.URLEncoder.encode(FileEntity.getValue(i,"FILE_REAL_NAME"))%>">
							<%=FileEntity.getValue(i,"FILE_REAL_NAME")%>
							(<%=KJFFile.fileSize(KJFUtil.str2long(FileEntity.getValue(i,"FILE_SIZE"))) %>)</a>
					</td>
   				</tr>					
				<%}%>					
					
	    	</table>
	    </td>
	</tr>
	<%} %>
	<!-- 첨부파일 보기 : E -->


	<!-- 내용 보기 : S -->
	<tr>
		<td class="inputTable_header_td" width="10%">내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용</td>
		<td class="inputTable_td" height="200" valign="top" colspan="7" id='PrintDiv' style="padding-top:20px;padding-left:10px;padding-right:10px;padding-bottom:20px">
			<table border="0" style="table-layout:fixed;" nowrap>
				<tr>
			   		<td>
						<%if (FileEntity.getRowCnt() > 0) { %>	
			   			<table width="100%"  border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
		   	 				<tr>
		   	 					<td align="center">			
									<% for(int i = 0; i < FileEntity.getRowCnt(); i++ ) {
									    
										String fileName = FileEntity.getValue(i, "SYS_FILE_NAME"); 
										String extension = fileName.substring(fileName.lastIndexOf("."));
											   
										if (extension.equals(".gif") || extension.equals(".jpg") || extension.equals("bmp") || 
											extension.equals(".GIF") || extension.equals(".JPG") || extension.equals("BMP")) {
									%>
											<img src="../com/downLoad.jsp?Lo=BBS_FILE_DIR&Sub_Lo=<%=CT_ID%>
											&SYS_FILE_NAME=<%=FileEntity.getValue(i,"SYS_FILE_NAME") %>
											&FILE_REAL_NAME=<%=FileEntity.getValue(i,"FILE_REAL_NAME") %>" 
											onload='init_content_img(this , 630);' onclick='big_img1(this);' style='cursor:hand'>					 
											
											<%if ( i < FileEntity.getRowCnt() - 1) {%><br><%}%>
										<%}%>
									<%}%>
								</td>
							</tr>
						</table>
						<br>	
						<%} %>

		   	 			<%=KJFUtil.FCKeditorView_no_iframe(rEntity.getValue(0, "CONTENT")) %>
		   	 		</td>
		   	 	</tr>
			</table>
		</td>
	</tr>
	<!-- 내용 보기 : E -->

</table>