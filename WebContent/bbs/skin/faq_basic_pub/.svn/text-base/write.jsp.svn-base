<%@ page contentType="text/html;charset=utf-8"%>

<!-- ////////////////////////// 등록  테이블 START //////////////////////////// -->

<table width="670" border="0" cellspacing="0" cellpadding="0" align="center">
  	<tr> 
    	<td>
			<table width="670" border="0" cellspacing="0" cellpadding="0">
	  			<tr>
	    			<td><img src="../images/bbs/view_top.gif" width="670" height="2"></td>
	  			</tr>
  				<tr>
    				<td>
						<!--글쓴이 정보입력 -->
						<table width="670" border="0" cellspacing="0" cellpadding="0">
      						<tr>
        						<td width="80" align="center" class="td_view_title"><img src="../images/bbs/view_name.gif" width="27" height="10"></td>
        						<td width="590" class="td_view_detail" >
									<Input name="USER_NAME" class="input_bbs" type=text id="USER_NAME" value="<%=USER_NAME %>" maxlength="20" required="이름을  입력하여 주세요!" readonly>
								</td>
      						</tr>

      						<tr>
        						<td colspan="2" align="center"><img src="../images/bbs/view_dot_line.gif" width="670" height="1"></td>
      						</tr>
	  						<tr>
        						<td width="80" align="center" class="td_view_title"><img src="../images/bbs/view_region.gif" width="17" height="10"></td>
        						<td class="td_view_detail" >
						           
									<table border="0" align="left" cellPadding="0" cellSpacing="0">
										<tr> 
											<!-- ================= 질의회신 대분류 코드 START ================== -->
											<td>            
								            	<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scFAQ_L_CATE")%>"
													 name="scFAQ_L_CATE"
													 value="<%=KJFUtil.print(scFAQ_L_CATE) %>"
													 script="class='input_bbs' onchange='fn_changeFAQ_CD()' "/>
												<input type="hidden" name="ETC_2" value=""/>	     
											</td>
											<!-- ================ 질의회신 대분류 코드 END ===================== -->
											
											<td>&nbsp;</td>
											<!-- ================= 질의회신 소분류  코드 START =============== -->
								            <td> 
												<div id="layer_faqcd" name="layer_faqcd">
												<% if ("ALL".equals(scFAQ_S_CATE)){ %>
													<select name='scFAQ_S_CATE' class='input_bbs' >
										 				<option value='ALL'  selected > 소분류 선택 </option>
													</select>
												<% }else{ %>	
													<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scFAQ_S_CATE")%>"
													 name="scFAQ_S_CATE"
													 value="<%=KJFUtil.print(scFAQ_S_CATE) %>"
													 script="class='input_bbs' "/>
												<%	} %>	 
												</div>
												<input type="hidden" name="ETC_3" value=""/>
											</td>
											<!-- ================ 질의회신 소분류  코드 END ================== -->
										</tr>
									</table>

								</td>
	  						</tr>
						 	<tr>
						        <td colspan="2" align="center"><img src="../images/bbs/view_dot_line.gif" width="670" height="1"></td>
							</tr>
							<tr>
						        <td width="80" height="20" align="center" class="td_view_title"><img src="../images/bbs/view_title.gif" width="19" height="10"></td>
						        <td class="td_view_detail"><input type="text" size="80" maxlength=80 name="SUBJECT" required="제목을 입력하여 주세요!" value="<%=SUBJECT%>" /></td>
						    </tr>
							<tr>
						        <td colspan="2" height="20" align="center" class="td_view_title"><img src="../images/bbs/view_question.gif"></td>
						    </tr>
						    <tr>
						        <td colspan="2" class="td_view_detail" align="center">
						        <textarea cols="610" rows="5" name="ETC_1" required="질의을 입력하여 주세요!" maxbyte="200" style="width:610px" onKeyup="var m=200; var s=this.scrollHeight; if(s>=m)this.style.pixelHeight=s+4"><%=KJFUtil.print(rEntity.getValue(0,"ETC_1"),"&nbsp;")%></textarea> 						        	
								</td>
						  	</tr>

	 						<tr>
        						<td colspan="2" align="center"><img src="../images/bbs/view_dot_line.gif" width="670" height="1"></td>
      						</tr>

							<!-- ======================= 첨부파일 일력필드 START ===================== -->
  							<% if(status.getATT_NUM() > 0) { %>
      						<tr>
        						<td width="80" height="20" align="center" class="td_view_title"><img src="../images/bbs/view_file.gif" width="35" height="10"></td>
        						<td>
									<table cellpadding="0" cellspacing="0">

										<% if ((status.getATT_NUM() - FileEntity.getRowCnt()) > 0) { %>
								    	<tr>
								    		<td class="td_view_detail">
								    			<table name="attachFile" id="attachFile" border="0" cellpadding="0" cellspacing="0">
						
													<!--필드 추가 제거 할때 쓰임-->
									            	<input type="hidden" NAME="fileCnt" VALUE="1">
						
									          		<tr>			              	
									                	<td><input type="file" class="input_bbs"  name="BBS_FILE[0]" size=50 ></td>
								                		<% if (status.getATT_NUM() - FileEntity.getRowCnt() > 1) { %>
								                		<td>&nbsp;<img src="../images/bbs/btn_add.gif" alt="파일 추가" border="0" onClick="addFile(fmWrite, '<%=status.getATT_NUM() - FileEntity.getRowCnt()%>', 1);" style='CURSOR:hand'></a></td>
								                		<td>&nbsp;<img src="../images/bbs/btn_remove.gif" alt="파일 빼기" border="0" onClick="deleteFile(fmWrite);" style='CURSOR:hand'></a></td>
								                		<% } %>	                
									              	</tr>		              
									            </table>
								    		</td>
								    	</tr>
								    	<%}%>

							          	

										 <% for (int i = 0; i < FileEntity.getRowCnt(); i++) { %>
								    	<tr>
								    		<td class="td_view_detail">
												<img src="../images/bbs/ico_file.gif" width="9" height="9">
												<%= FileEntity.getValue(i, "FILE_REAL_NAME") %>&nbsp;&nbsp;
												<span class="sfont_gray99">|&nbsp;&nbsp;<%= KJFFile.fileSize(KJFUtil.str2long(FileEntity.getValue(i, "FILE_SIZE"))) %></span>&nbsp;&nbsp;
												<a href="javascript:fn_att_del('<%= FileEntity.getValue(i, "SYS_FILE_NAME") %>');">
												<img src="../images/bbs/ico_delete.gif" alt="삭제" width="14" height="11"></a>
					
								    		</td>
								    	</tr>
								    	<% } %>
          								
        							</table>
								</td>
      						</tr>

	  						<tr>
        						<td colspan="2" align="center"><img src="../images/bbs/view_dot_line.gif" width="670" height="1"></td>
      						</tr>
							<%}%>
							<!-- ======================= 첨부파일 일력필드 END ===================== -->

      						<tr>
        						<td colspan="2" height="20" align="center" class="td_view_title"><img src="../images/bbs/view_answer.gif"></td>
 							</tr>
 							</tr>       						
        						<td colspan="2"  align="center" class="td_view_detail">
									<%
										FCKeditor oFCKeditor ;
										oFCKeditor = new FCKeditor( request, "EditorDefault" ) ;
										oFCKeditor.setHeight("400");
										oFCKeditor.setWidth("610");
										oFCKeditor.setBasePath( "../com/FCKeditor/" ) ;
										oFCKeditor.setToolbarSet("Bbs");
										oFCKeditor.setValue(CONTENT);
										oFCKeditor.setInstanceName("CONTENT");
										out.println( oFCKeditor.create() ) ;
									%> 
								</td>
      						</tr>
   	 					</table>
					</td>
  				</tr>
  				<tr>
    				<td><img src="../images/bbs/view_bottom.gif" width="670" height="2"></td>
  				</tr>
			</table>
		</td>
  	</tr>
  	<tr> 
    	<td>&nbsp;</td>
  	</tr>
  	<tr> 
    	<td align="right">
			
			<%  if (status.isWRITE() ) { // 쓰기허용 %>
			<img src="../images/bbs/btn_ok.gif" width="46" height="19" border="0" alt="확인" onClick="fn_save('<%=cmd%>')" style="cursor:pointer">
		    <% } %>

			<img src="../images/bbs/btn_cancel.gif" width="46" height="19" border="0" alt="취소" onClick="fn_goList01('BbsKList')" style="cursor:pointer"> 
		</td>
  	</tr>
</table>

<!-- ////////////////////////// 등록  테이블 END ////////////////////////////// -->
