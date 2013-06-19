<%@ page contentType="text/html;charset=utf-8"%>

<!-- 삭제용-->
<input type=hidden name="chk" value="0">

<table width="670" border="0" align="center" cellpadding="0" cellspacing="0">
  	<tr>
    	<td>
			<!--FAQ검색:시작 -->
			<table width="670" border="0" cellspacing="0" cellpadding="0">
      			<tr>
        			<td align="right"><img src="../images/bbs/faq_title.gif" /></td>
      			</tr>
      			<tr>
        			<td><img src="../images/bbs/box_top.gif" width="670" height="8" /></td>
      			</tr>
      			<tr>
        			<td height="50" background="../images/bbs/box_bg.gif">
					<!--검색:시작 -->
						<table border="0" align="center">
          					<tr>
            					<td width="25"><img src="../images/bbs/faq_glass.gif" /></td>
            					<td>
					            	<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSLCT_GUBUN")%>'
										 name='scSLCT_GUBUN'
										 value='<%=KJFUtil.print(scSLCT_GUBUN) %>'
										 script="class='input_bbs'  "/>
								</td>
								<td><input name="scTEXTVALUE" type="text" onkeyup="if(event.keyCode == 13) fn_search();" size="35" maxlength="35" value="<%=scTEXTVALUE %>" /></td>
								<td><img src="../images/bbs/btn_search.gif" alt="검색" onClick="javascript:fn_search()" class="cursor" /></td>
          					</tr>
        				</table>
						<!--검색:끝 -->
					</td>
      			</tr>
      			<tr>
        			<td><img src="../images/bbs/box_bottom.gif" width="670" height="8" /></td>
      			</tr>
    		</table>
			<!--FAQ검색:끝 -->
		</td>
  	</tr>

  	<tr>
    	<td height="25"></td>
  	</tr>

  	<tr>
    	<td>
			<!--FAQ 리스트:시작 -->
			<table width="670" border="0" cellpadding="0" cellspacing="0">
      			<tr>
        			<td height="25" class="sfont_gray66B" style="padding:0 0 0 0;">
	            	분류: <KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scFAQ_L_CATE")%>'
						 name='scFAQ_L_CATE'
						 value='<%=KJFUtil.print(scFAQ_L_CATE) %>'
						 script="class='input_bbs'  onchange='fn_changeFAQ_CD()'  "/>
					<span id="layer_faqcd" name="layer_faqcd">
					<% if ("ALL".equals(scFAQ_L_CATE)){ %>
						<select name='scFAQ_S_CATE' class='input_bbs' >
			 				<option value='ALL'  selected > 소분류 선택 </option>
						</select>
					<% }else{ %>	
						<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scFAQ_S_CATE")%>'
						 name='scFAQ_S_CATE'
						 value='<%=KJFUtil.print(scFAQ_S_CATE) %>'
						 script="class='input_bbs' "/>
					<%	} %>
        			</span>	
        			<a href="javascript:fn_search()"><img src="../images/bbs/btn_go.gif" alt="go" style="cursor:pointer"></a>
        			&nbsp;&nbsp;&nbsp;<!--검색 했을 시 -->고객님이 검색하신 <span class="font_orangeB">FAQ</span>에 대한 질문검색 결과 <span class="font_orangeB">총 <%=totalCount%>건</span> 입니다.
					</td>
      			</tr>
      			<tr>
	        		<td>
						<table border="0" cellpadding="0" cellspacing="0" class="underline">
	          				<tr>
	            				<td><img src="../images/bbs/view_top.gif" width="670" height="2" /></td>
	          				</tr>
							
							<% if(ListEntity.getRowCnt() > 0) { %>
								<!--- ============ 등록된 일반글  리스트 START ============= -->
								<%for (int i = (ListEntity.getRowCnt() - 1); i >= 0 ; i--) {%>
			          				<tr>
			            				<td>
											<table width="670" border="0" cellpadding="4" cellspacing="0" >
												<tr>
													<td width="40" align="center"><img src="../images/bbs/faq_q.gif" alt="질문" width="20" height="20" /></td>				
													<td width="580">
														<a href="javascript:changeLayer('Q<%= ListEntity.getValue(i,"BOARD_SEQ") %>')">
														<%=KJFUtil.java2html(ListEntity.getValue(i,"SUBJECT"))%></a>
												  	</td>			    
											  		<td width="50">
														<% if ( status.isWRITE() ) { // 쓰기허용 %>
															<a href="javascript:fn_Write('modify', '<%= ListEntity.getValue(i,"BOARD_SEQ") %>');" class="sfont_grayCCB">수정</a>
														<% } %>
														<% if( status.isADMIN() || status.getUSER_ID().equals(ListEntity.getValue(i, "USER_ID")) ) { %>
															<a href="javascript:fn_delete('<%= ListEntity.getValue(i,"BOARD_SEQ") %>');" class="sfont_grayCCB">삭제</a>
														<% } %>
													</td>
											    </tr>
								
											    <tr id="Q<%= ListEntity.getValue(i,"BOARD_SEQ") %>" style="display:none; background-color: #f7f7f7;">
											    	<td colspan="3" width="680">
											    		<table>
											    			<tr>
											    				<td width="40" align="center"><img src="../images/bbs/faq_q.gif" alt="질문" width="20" height="20" /></td>			
																<td width="580"><%=KJFUtil.java2html(ListEntity.getValue(i,"ETC_1"))%></td>
																<td width="50" class="sfont_grayCCB">&nbsp;</td>
															</tr>		    
															<tr>
														      	<td width="40"  align="center" valign="top" style="padding-top:8px;"><img src="../images/bbs/faq_a.gif" alt="답변" /></td>
																<td class="td_faq_a" width="580"><%=KJFUtil.FCKeditorView_no_iframe(ListEntity.getValue(i, "CONTENT")) %></td>
																<td width="50"  class="sfont_grayCCB">&nbsp;</td>
															</tr>
														</table>
													</td>
											    </tr>
		    
			            					</table>
										</td>
			          				</tr>
		
			          				<tr>
			            				<td><img src="../images/bbs/faq_underline.gif" width="670" height="1" /></td>
			          				</tr>								
								<% } %>
							<% } else { %>
								<tr>
		            				<td align="center" height="30px" >등록된 정보가 없습니다.</td>
		          				</tr>	
							<% } %>
							
	        			</table>
					</td>
      			</tr>

      			<tr>
        			<td><img src="../images/bbs/faq_underline.gif" width="670" height="1" /></td>
      			</tr>
    		</table>
			<!--FAQ 리스트:끝 -->
		</td>
  	</tr>


	<% if ( status.isWRITE() ) { // 쓰기허용 %>
							
  	<tr>
    	<td height="35">
			<!--글쓰기 버튼:시작 -->
			<table width="650" height="35" border="0" align="center" cellpadding="0" cellspacing="0">
      		<tbody>
        		<tr>
          			<td width="60" height="0"></td>
          			<td width="530" align="center"></td>
          			<td width="60" align="right">
           				<img src="../images/bbs/btn_write.gif" alt="글쓰기" border="0" 
							 onClick="javascript:fn_Write01('BbsKWrite')" style="cursor:hand">
					</td>
        			</tr>
      		</tbody>
    		</table>
			<!--글쓰기 버튼:끝 -->
		</td>
  	</tr>
	<% } %>

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
</table>





