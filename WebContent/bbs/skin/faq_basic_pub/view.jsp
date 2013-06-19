<%@ page contentType="text/html;charset=utf-8"%>

<table width="670" border="0" align="center" cellpadding="0" cellspacing="0">
  	<tr> 
    	<td>
			<table border="0" cellpadding="0" cellspacing="0">
	          	<tr>
	            	<td><img src="../images/bbs/view_top.gif" height="2" alt=""></td>
	          	</tr>
				
				<!--제목 : S -->
	          	<tr>
	            	<td class="view_title"><%=rEntity.getValue(0,"SUBJECT") %></td>
	          	</tr>
				<!--제목 : E -->				

	          	<tr>
	            	<td><img src="../images/bbs/view_dot_line.gif" height="1" alt=""></td>
	          	</tr>
	
				<!-- 지역 : S -->	
				<% if (status.isSD_DIV_YN()) { %>
	          	<tr>
	            	<td>
						<table width="670" height="30" border="0" cellpadding="0" cellspacing="0">
		              		<tr>
		                		<td width="60" align="center" class="td_view_title"><img src="../images/bbs/view_region.gif" alt="지역"></td>
								<td class="td_view_detail">
									<%=rEntity.getValue(0, "SD_NM") %>
									<% if(status.isSGG_DIV_YN()) { %>
									&nbsp;<%=rEntity.getValue(0, "SGG_NM") %>
									<% } %>
								</td>
		              		</tr>					
	            		</table>
					</td>
	          	</tr>
				<!-- 지역 : E -->				

	          	<tr>
	            	<td><img src="../images/bbs/view_dot_line.gif" height="1" alt=""></td>
	         	</tr>
				<% } %>
			
				<!--등록, 조회수 : S -->
	          	<tr>
	            	<td>
						<table width="670" height="30" border="0" cellpadding="0" cellspacing="0">
	              			<tr>
								<!--작성자 자리 -->
	                			<td width="60" align="center" class="td_view_title"><img src="../images/bbs/view_name.gif" alt="작성자"></td>
	                			<td width="200" class="td_view_detail letter0"><%=rEntity.getValue(0,"USER_NAME") %></td>

								<!--등록일자리 -->
	                			<td width="60" align="center" class="td_view_title"><img src="../images/bbs/view_date.gif" alt="등록일"></td>
	                			<td class="td_view_detail"><%=rEntity.getValue(0,"INS_DT") %></td>
	                			
	                			<!--조회수자리 -->
								<td width="60" align="center" class="td_view_title"><img src="../images/bbs/view_hit.gif" alt="조회수"></td>
								<td width="80" align="center" class="td_view_detail"><%=rEntity.getValue(0,"READ_NUM")%></td>
	              			</tr>
	            		</table>
					</td>
	          	</tr>
				<!--등록, 조회수 : E -->
	
			  	<tr>
	            	<td><img src="../images/bbs/view_dot_line.gif" height="1" alt=""></td>
	          	</tr>
	          	
				<!-- 첨부파일 : S -->
				<!-- ========================= 첨부파일 보기 START ======================= -->
				<% if(status.getATT_NUM() > 0 && FileEntity.getRowCnt() > 0) {%>
				<tr>
	            	<td>
						<table width="670" height="30" border="0" cellpadding="0" cellspacing="0">
	              			<tr>
	                			<td width="60" align="center" class="td_view_title"><img src="../images/bbs/view_file.gif" alt="첨부파일"></td>
	                			<td class="td_view_detail">

									<!--첨부파일내용:시작 -->
									<table border="0" cellpadding="5" cellspacing="0">
										<% for (int i = 0; i < FileEntity.getRowCnt(); i++ ) {%>
				                  		<tr>
				                    		<td class="td_view_detail"><img src="../images/bbs/fileicon/<%=KJFFile.getDownFileExt(FileEntity.getValue(i,"SYS_FILE_NAME"))%>.gif" border="0"></td>
				                    		<td class="td_view_detail"><%=FileEntity.getValue(i,"FILE_REAL_NAME")%></td>
				                    		<td class="td_view_detail"><p class="sfont_gray99">|&nbsp;&nbsp;<%=KJFFile.fileSize(KJFUtil.str2long(FileEntity.getValue(i,"FILE_SIZE"))) %></p></td>
				                    		<td>
												<a href="../com/downLoad.jsp?Lo=BBS_FILE_DIR&Sub_Lo=<%=CT_ID%>
												&SYS_FILE_NAME=<%=FileEntity.getValue(i, "SYS_FILE_NAME") %>
												&FILE_REAL_NAME=<%=java.net.URLEncoder.encode(FileEntity.getValue(i,"FILE_REAL_NAME"))%>">
												<img src="../images/bbs/btn_down.gif" alt="다운로드"></a>
											</td>
				                  		</tr>
					  					<%}%>	
	                				</table>
									<!--첨부파일내용:끝 -->

								</td>
	              			</tr>					
	            		</table>
					</td>
				</tr>

          		<tr>
            		<td><img src="../images/bbs/view_top.gif" height="2" alt=""></td>
          		</tr>
				<% } %>
				<!-- 첨부파일 : E -->

			</table>
		</td>
	</tr>

	<!-- 내용 : S -->
  	<tr> 
    	<td class="td_detail">
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
								&FILE_REAL_NAME=<%=java.net.URLEncoder.encode(FileEntity.getValue(i,"FILE_REAL_NAME")) %>" 
								onload='init_content_img(this , 630);' onclick='big_img1(this);' style='cursor:hand'>					 
								<%if ( i < FileEntity.getRowCnt() - 1) {  %>
									<br>
								<%}%>
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
	<!-- 내용 : E -->

  	<tr>
    	<td height="2"><img src="../images/bbs/view_bottom.gif"></td>
  	</tr>

  	<tr> 
    	<td>&nbsp;</td>
  	</tr>

	<!-- 버튼 : S -->
  	<tr> 
    	<td height="50" valign="top"> 
			
      		<table width="100%" border="0" cellspacing="2" cellpadding="0">
        		<tr>
          			<td>		  				
						<%  if (IS_MODIFY ) { // 수정   %>
			    		<img src="../images/bbs/btn_modify.gif" alt="수정" class="cursor" style="cursor:pointer" onClick="fn_Write('modify');">
			    		<% } %>
						
						<%  if (status.isADMIN() && status.isREPLY()) { // 답변  %>
						<img src="../images/bbs/btn_reply.gif" alt="답변" class="cursor" style="cursor:pointer" onClick="fn_Write('reply');">
			    		<% } %>
						
						<%  if (IS_DELETE ) { //삭제  %> 
			    		<img src="../images/bbs/btn_delete.gif" alt="삭제" class="cursor" style="cursor:pointer" onClick="fn_del();">
			    		<% } %>						
					</td>
          			
					<!--목록버튼 -->
					<td align="right">
						<img src="../images/bbs/btn_list.gif" alt="목록" border="0" class="cursor" style="cursor:pointer" onClick="fn_goList('BbsKList');">
					</td>
        		</tr>
      		</table>
	  	</td>
  	</tr>
	<!-- 버튼 : E -->

</table>