<%@ page contentType="text/html;charset=utf-8"%>

<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="inputTable">
  	
	<!-- ======================= 제목  일력필드 START ========================= -->
	<tr>
    	<td class="inputTable_header_td" width="10%">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</td>
    	<td class="inputTable_td" colspan="3"> 
	    	<input type="text" name="SUBJECT" class="input_bbs" size="80%" maxlength=90 value="<%=SUBJECT%>" required="제목을 입력하여 주세요!" maxbyte="200">&nbsp; 
    	</td>
  	</tr>
	<!-- ======================= 제목 일력필드 END =========================== -->


	<!-- ======================= 작성자 일력필드 START ======================= -->
  	<tr>
    	<td class="inputTable_header_td">작&nbsp;성&nbsp;자</td>
    	<td class="inputTable_td"> 
			<Input name="USER_NAME" class="input_bbs" type=text id="USER_NAME" value="<%=USER_NAME%>" size=30 required="이름을  입력하여 주세요!" readonly>
    	</td>
  	</tr>  
	<!-- ======================= 작성자 일력필드 END ========================= -->
	
	<!-- ======================= 시.도(시.군.구) 일력필드 START ============== -->
	<% if (status.isSD_DIV_YN()) { %>
	<tr>
		<td class="inputTable_header_td" width="10%">지&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;역</td>
    	<td class="inputTable_td" colspan="3"> 
	    	  <table border="0" align="left" cellPadding="0" cellSpacing="0">
				<tr> 
					<!-- ================= 시.도 코드 START ================== -->
					<td>            
			            <KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_SD_CD")%>"
										 name="SD_CD"
										 value="<%=SIDO_CODE%>"
										 script="class='input_bbs' onchange='fn_changeSGG_CD()' "/>    
					</td>
					<!-- ================ 시.도 코드 END ===================== -->
					
					<td>&nbsp;</td>

					<% if(status.isSGG_DIV_YN()) { %>
					<!-- ================= 시.군.구 코드 START =============== -->
		            <td> 
						<div id="layer_sggcd" name="layer_sggcd">
						<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scSGG_CD")%>"
										 name="SGG_CD"
										 value="<%=SIGUNGU_CODE%>"
										 script="class='input_bbs' "/>   
						</div>
					</td>
					<!-- ================ 시.군.구 코드 END ================== -->
					<%} %>
				</tr>
			</table>
    	</td>
	</tr>
	<%} %>
	<!-- ======================= 시.도(시.군.구) 일력필드 END ================ -->


	<!-- ======================= 내용 일력필드 START ========================= -->
  	<tr>
    	<td class="inputTable_content_td" colspan="2"> 
	    	<%
				FCKeditor oFCKeditor ;
				oFCKeditor = new FCKeditor( request, "EditorDefault" ) ;
				oFCKeditor.setHeight("400");
				oFCKeditor.setBasePath( "../com/FCKeditor/" ) ;
				oFCKeditor.setToolbarSet("Bbs");
				oFCKeditor.setValue(CONTENT);
				oFCKeditor.setInstanceName("CONTENT");
				out.println( oFCKeditor.create() ) ;
			%> 
		</td>
  	</tr>
	<!-- ======================= 내용 일력필드 END ========================= -->


	<!-- ======================= 첨부파일 일력필드 START ===================== -->
  	<% if (status.getATT_NUM() > 0) { %>
  	<tr>
    	<td class="inputTable_header_td">첨부파일</td>
    	<td class="inputTable_td">

		    <table width="100%" border="0" cellpadding="0" cellspacing="3" style="padding-top:5px;padding-bottom:5px">
		        <% for (int i = 0; i < FileEntity.getRowCnt(); i++) { %>
		    	<tr>
		    		<td bgcolor="#EFF5FB" style="padding-left:10px;padding-right:10px">
		    			<a href="javascript:fn_att_del('<%= FileEntity.getValue(i, "SYS_FILE_NAME") %>');">
				    	<img src="../images/bbs/btn_file_delete.gif" alt="파일 삭제" border="0" align="absmiddel"></a>
				    	<%= FileEntity.getValue(i, "FILE_REAL_NAME") %>
						(<%= KJFFile.fileSize(KJFUtil.str2long(FileEntity.getValue(i, "FILE_SIZE"))) %>)
		    		</td>
		    	</tr>
		    	<% } %>
		    	
		    	<% if ((status.getATT_NUM() - FileEntity.getRowCnt()) > 0) { %>
		    	<tr>
		    		<td>
		    			<table name="attachFile" id="attachFile" border="0" cellpadding="0" cellspacing="0">

							<!--필드 추가 제거 할때 쓰임-->
			            	<input type="hidden" NAME="fileCnt" VALUE="1">

			          		<tr>			              	
			                	<td width="100%"> &nbsp; 
									<input type="file" class="input_bbs"  name="BBS_FILE[0]" size=50 >
			                		<% if (status.getATT_NUM() - FileEntity.getRowCnt() > 1) { %>
			                		<img src="../images/bbs/btn_file_add.gif" alt="파일 추가" border="0" onclick="javascript:addFile(fmWrite, '<%=status.getATT_NUM() - FileEntity.getRowCnt()%>', 1);" style='CURSOR:hand'></a>
			                		<img src="../images/bbs/btn_file_minus.gif" alt="파일 빼기" border="0" onclick="javascript:deleteFile(fmWrite);" style='CURSOR:hand'></a>
			                		<% } %>
			                	</td>			                
			              	</tr>		              
			            </table>
		    		</td>
		    	</tr>
		    	<%}%>
		    </table>

	 	</td>
  	</tr>
 	<%}%>
	<!-- ======================= 첨부파일 일력필드 END ===================== -->

</table>
