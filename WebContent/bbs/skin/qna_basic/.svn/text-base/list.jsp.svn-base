<%@ page contentType="text/html;charset=utf-8"%>

<!--게시판 : S -->
<table width="670" border="0" align="center" cellpadding="0" cellspacing="0">
	
	<!-- 검색 : S -->
  	<% if (status.isSD_DIV_YN()) { %>
	<tr> 
	    <td>			
			<table border="0" align="left" cellPadding="0" cellSpacing="5">
				<tr>					

					<% if(status.isSGG_DIV_YN()) { %>
						<!-- 시.도 코드 : S -->
						<td>            
				            <KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSD_CD")%>'
											 name='scSD_CD'
											 value='<%=KJFUtil.print(scSD_CD) %>'
											 script="class='input_bbs' onchange='fn_changeSGG_CD()' "/>       
						</td>
						<!-- 시.도 코드 : E -->	
	
						<!-- 시.군.구 코드 : S -->
			            <td> 
							<div id="layer_sggcd" name="layer_sggcd">
							<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSGG_CD")%>'
											 name='scSGG_CD'
											 value='<%=KJFUtil.print(scSGG_CD) %>'
											 script="class='input_bbs' "/>   
							</div>
						</td>
						<!-- 시.군.구 코드 : E -->

					<% } else { %>
						<!-- 시.도 코드 : S -->
						<td>            
				            <KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSD_CD")%>'
											 name='scSD_CD'
											 value='<%=KJFUtil.print(scSD_CD) %>'
											 script="class='input_bbs' "/>       
						</td>
						<!-- 시.도 코드 : E -->	
					<% } %>

					<td><a href="javascript:fn_search()"><img src="../images/bbs/btn_go.gif" alt="go" style="cursor:pointer"></a></td>

				</tr>
			</table>
		</td>
  	</tr>
	<% } %>
	<!-- 검색 : E -->

	
	<!-- 리스트 타이틀  : S -->
	<tr>
	    <td width="670" align="center">
			<table width="670" height="26" border="0" cellpadding="0" cellspacing="0" background="../images/bbs/list_bg.gif">
		      	<tr>
			        <td width="5"><img src="../images/bbs/list_left.gif" alt=""></td>
			        <td width="40" align="center"><img src="../images/bbs/list_num.gif" alt="번호"></td>
					
					<!-- 시도 구분 : S -->
					<% if(status.isSD_DIV_YN()) { %>
					<td width="40" align="center"><img src="../images/bbs/list_province.gif" alt="시도"></td>
			        <% } %>
					<!-- 시도 구분 : E -->
	
					<!-- 시.군.구 구분 : S -->
					<% if(status.isSGG_DIV_YN()) { %>
					<td width="60" align="center"><img src="../images/bbs/list_county.gif" alt="시군구"></td>
			        <% } %>
					<!-- 시.군.구 구분 : E -->

					<td align="center"><img src="../images/bbs/list_title.gif" alt="제목"></td>

					<!-- 첨부파일 : S -->
					<% if(status.isATTACH() && status.getATT_NUM() > 0) { %>
			        <td width="60" align="center"><img src="../images/bbs/list_file.gif" alt="첨부파일"></td>
					<% } %>
					<!-- 첨부파일 : E -->
					
					<!-- 작성자 : S -->
					<% if (status.isTITLE_WRT_YN()) {%>
					<td width="100" align="center"><img src="../images/bbs/list_name.gif" alt="작성자"></td>
					<% } %>
					<!-- 작성자 : E -->
					
			        <td width="70" align="center"><img src="../images/bbs/list_date.gif" alt="등록일"></td>
			        <td width="55" align="center"><img src="../images/bbs/list_hit.gif" alt="조회수"></td>
		        	<td width="5"><img src="../images/bbs/list_right.gif" width="5" height="26"></td>
		      	</tr>
		    </table>
		</td>
  	</tr>
	<!-- 리스트 타이틀  : E -->	


	<!-- 리스트 본문 : S --> 
  	<tr>
	    <td align="center" valign="top">
			<table width="670" border="0" cellpadding="0" cellspacing="0" class="underline">
		   	<tbody>
	
				<%for (int i = 0; i < ListEntity.getRowCnt(); i++) {
			
						String vacant_img  = "<img src='../images/bbs/bbs_vacant.gif'  height='2' width='"+ 
							(KJFUtil.str2int(ListEntity.getValue(i, "DEPTH")) * 15 - 15) +"' border='0'>";
							
						String replied_img = "";
						
						if (ListEntity.getValue(i,"REPLIED_YN").equals("Y")) {
						    replied_img = "<img src='../images/bbs/bbs_reply.gif'>";//답변 image
						}
				%>
	
				<tr> 			     
					<td width="40" height="26" align="center" class="sfont_gray99" style="padding-left:5px"><%=int_rnum--%></td>
	
					<!-- 시도 구분 : S -->
					<% if(status.isSD_DIV_YN()) { %>
					<td width="40" align="center" class="sfont_orengeB"><%=KJFArea.getSido_Name(ListEntity.getValue(i, "SIDO_CODE"))%></td>
					<% } %>			
					<!-- 시도 구분 : E -->		
	
					<!-- 시.군.구 구분 : S -->
					<% if(status.isSGG_DIV_YN()) { %>
					<td width="60" align="center" class="sfont_gray99B"><%=KJFUtil.print(ListEntity.getValue(i, "SGG_NM"), "&nbsp;")%></td>
					<% } %>
					<!-- 시.군.구 구분 : E -->
					
					<td align="left" class="td_list">
						<%=vacant_img%><%=replied_img %>
						<a href="javascript:viewDetail('<%= ListEntity.getValue(i, "BOARD_SEQ") %>')" >
						<%=KJFUtil.java2html(KJFUtil.getTitleLimit(ListEntity.getValue(i,"SUBJECT"), CutStr))%></a>

						<%if (KJFDate.isNew(status.getNEW_DAY(), ListEntity.getValue(i,"INS_DT")) ) { %>
							<img src='../images/bbs/ico_new.gif'>
						<% } %>			
				  	</td>

					<!-- 첨부파일 : S -->
					<% if(status.isATTACH() && status.getATT_NUM() > 0) { %>
			      	<td align="center" width="60">						
						<% if(KJFUtil.str2int(ListEntity.getValue(i, "FILE_CNT")) > 0) { %>
							<img src='../images/bbs/ico_file.gif' alt='첨부파일' border='0'>
						<% } else {%>&nbsp;<% } %>					
					</td>	
					<% } %>
					<!-- 첨부파일 : E -->
					
					<!-- 작성자 : S -->
					<% if (status.isTITLE_WRT_YN()) {%>
					<td width="100" align="center" class="sfont_gray99 letter0"><%=KJFUtil.print(ListEntity.getValue(i, "USER_NAME"), "&nbsp;")%></td>
					<% } %>
	      			<!-- 작성자 : E -->		
			
			  		<td width="70" align="center" class="sfont_gray99 letter0"><%=KJFDate.dateOnly(KJFDate.str2date(ListEntity.getValue(i,"INS_DT"),""))%></td>
					<td width="55" align="center" class="sfont_gray99 letter0" style="padding-right:5px"><%=ListEntity.getValue(i,"READ_NUM")%></td>
			    </tr>
	
			    <tr>
		          <td height="1" colspan="7" bgcolor="#ededed"></td>
		        </tr>	
				<% } %>

				<% if (ListEntity.getRowCnt() < 1) { %>
				<tr>
		        	<td align="center" colspan="7" class="td_none">등록된 정보가 없습니다.</td>
		        </tr>
				<% } %>
		    </tbody>
		    </table>
		</td>
  	</tr>
	<!-- 리스트 본문 : E --> 


	<!-- 버튼 : S --> 
	<%  if ( status.isWRITE() ) { // 관리자 || 쓰기허용 %>	
	<tr>
	  	<td align="center">
			<table width="650" height="35" border="0" align="center" cellpadding="0" cellspacing="0">
		    	<tbody>
		       		<tr>		  
						<td>&nbsp;</td>       		
		         		<td width="60" align="right">
							<Img src="../images/bbs/btn_write.gif" alt="글쓰기" border="0" onClick="javascript:fn_Write01('BbsKWrite');" style="cursor:pointer"></a>
			  			</td>
		       		</tr>
		     	</tbody>
		   	</table>
		</td>
	 </tr>
	 <%} %>			
	<!-- 버튼 : E -->	
  	

	<!-- 페이징 : S --> 
	<tr>
	    <td height="45" align="center">
			<jsp:include page="../com/inc/paging.jsp" flush="true">
			  <jsp:param name="pagePerScreen" value="10"/>
			  <jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
			  <jsp:param name="totalCount" value="<%=totalCount%>"/>
			  <jsp:param name="nowPage" value="<%=nowPage %>"/>
			</jsp:include>	
		</td>
  	</tr>
	<!-- 페이징 : E -->

	
	<!-- 검색 : S --> 
  	<tr>
    	<td height="45" align="center">		
			<table height="27"  border="0" cellpadding="0" cellspacing="0">
				<tr> 
					<td width="80" align="right">
						<table>
							<tr>
								<td>
									<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSLCT_GUBUN")%>'
													 name='scSLCT_GUBUN'
													 value='<%=KJFUtil.print(scSLCT_GUBUN) %>'
													 script="class='input_bbs'  "/>
								</td>
							</tr>
						</table>
					</td>
					<td width="4">&nbsp;</td>
		            <td width="115"><input class="input_bbs" name="scTEXTVALUE" size="17" onkeyup="if(event.keyCode == 13) fn_search();" value="<%=scTEXTVALUE %>"></td>
		            <td width="50" align="center"><img src="../images/bbs/btn_search.gif" border="0" alt="검색" onClick="javascript:fn_search()" class="cursor" style="cursor:pointer"></td>
				</tr>
			</table>
		</td>
  	</tr>
	<!-- 검색 : E -->  	

</table>
<!-- 게시판 : E -->
