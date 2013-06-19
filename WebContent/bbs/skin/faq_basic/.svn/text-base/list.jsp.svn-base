<%@ page contentType="text/html;charset=utf-8"%>

<!-- 검색 영역 : S -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr> 
	    <td>
			<% if(status.isSD_DIV_YN()) { %>
			<table border="0" align="left" cellPadding="0" cellSpacing="5">
				<tr> 
					<!-- 시.도 코드 : S -->
					<td>            
			            <KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSD_CD")%>'
										 name='scSD_CD'
										 value='<%=KJFUtil.print(scSD_CD) %>'
										 script="class='input_bbs' onchange='fn_searchSD_CD()' "/> 
					</td>
					<!-- 시.도 코드 : E -->
					
					<% if(status.isSGG_DIV_YN()) { %>
					<!-- 시.군.구 코드 : S -->
		            <td> 
						<div id="layer_sggcd" name="layer_sggcd">
						<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSGG_CD")%>'
										 name='scSGG_CD'
										 value='<%=KJFUtil.print(scSGG_CD) %>'
										 script="class='input_bbs' onchange='fn_search()' "/>   
						</div>
					</td>
					<!-- 시.군.구 코드 : E -->
					<%} %>
				</tr>
			</table>
			<%} %>
			
			<!-- 검색 : S -->
			<table border="0" align="right" cellPadding="0" cellSpacing="5">
				<tr> 
					<td>            
			            <KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSLCT_GUBUN")%>'
										 name='scSLCT_GUBUN'
										 value='<%=KJFUtil.print(scSLCT_GUBUN) %>'
										 script="class='input_bbs'  "/>       
					</td>
		            <td><INPUT class="input_bbs" name="scTEXTVALUE" size="30" value="<%=scTEXTVALUE %>"></td>
		            <td><img src="../images/bbs/bt_search.gif" border="0" alt="검색" onClick="javascript:fn_search()" style="cusor:hand"></td>
				</tr>
			</table>
			<!-- 검색 : E -->
		</td>
  	</tr>
	
</table>
<!-- 검색 영역 : E -->


<!-- 게시판 List : S -->	
<table width="100%" border="0"  cellspacing="0" cellpadding="0" style="table-layout:fixed;" nowrap>
  	
	<tr>
		<% if(status.isADMIN()) { %>
		<td  class="listTable_header" width="30"><a href="#" onclick="selectAll('chk')">선택</a></td>  		
		<td  class="listTable_header_section" width="8%">번호</td>
		<% } else { %>
		<td  class="listTable_header" width="8%">번호</td>
		<% } %>	

		<% if(status.isSD_DIV_YN()) { %>
		<td class="listTable_header_section" width="8%">시도</td>
		<% } %>		

		<% if(status.isSGG_DIV_YN()) { %>
		<td class="listTable_header_section" width="10%">시군구</td>
		<% } %>

        <td class="listTable_header_section" >제목</td>

		<% if(status.isTITLE_WRT_YN()) { %>
        <td class="listTable_header_section" width="10%">작성자</td>
        <% } %>

		<% if(status.isTITLE_HIT_YN()) { %>
		<td class="listTable_header_section" width="8%">조회수</td>
        <% } %>

		<% if(status.isTITLE_DATE_YN()) { %>
		<td class="listTable_header_section" width="12%">등록일</td>  
		<% } %>       
    </tr>
				
  	<%for (int i = 0; i < ListEntity.getRowCnt(); i++) {

			String vacant_img  = "<img src='../images/bbs/bbs_vacant.gif'  height='2' width='"+ 
				(KJFUtil.str2int(ListEntity.getValue(i,"DEPTH")) * 15 - 15) +"' border='0'>";
				
			String replied_img = "";
			
			if (ListEntity.getValue(i,"REPLIED_YN").equals("Y")) {
			    replied_img = "<img src='../images/bbs/bbs_reply.gif'>";//답변 image
			}
	%>

	<tr>      
		<% if(status.isADMIN()) { %>
		<td class="inputTable_td" align="center"><input type="checkbox" name="chk" value="<%= ListEntity.getValue(i,"BOARD_SEQ") %>"></td>
		<% } %>

		<td class="inputTable_td" align="center" height="26"><%=int_rnum--%></td>
		

		<% if(status.isSD_DIV_YN()) { %>
		<td class="listTable_td" align="center"><%=KJFArea.getSido_Name(ListEntity.getValue(i, "SIDO_CODE"))%></td>
		<% } %>		

		<% if(status.isSGG_DIV_YN()) { %>
		<td class="listTable_td" align="center"><%=KJFUtil.print(ListEntity.getValue(i, "SGG_NM"), "&nbsp;")%></td>
		<% } %>

		<td class="listTable_td">
			<%=vacant_img%><%=replied_img %>
			<a href="javascript:viewDetail('<%= ListEntity.getValue(i,"BOARD_SEQ") %>')" >
			<%=KJFUtil.java2html(KJFUtil.getTitleLimit(ListEntity.getValue(i,"SUBJECT"),CutStr))%></a>

			
			<%if (KJFDate.isNew(status.getNEW_DAY(), ListEntity.getValue(i,"INS_DT")) ) { %>
				<img src='../images/bbs/ico_new.gif'>
			<% } %>	

			<!-- 첨부파일 : S -->
			<% if(status.isATTACH() && status.getATT_NUM() > 0) { %>
	      					
				<% if(KJFUtil.str2int(ListEntity.getValue(i, "FILE_CNT")) > 0) { %>
					<img src='../images/bbs/ico_file.gif' alt='첨부파일' border='0'>
				<% } %>			
			<% } %>
			<!-- 첨부파일 : E -->
	  	</td>

		<% if(status.isTITLE_WRT_YN()) { %>
      	<td class="listTable_td" align="center"><%=KJFUtil.getTitleLimit(ListEntity.getValue(i,"USER_NAME"), 6)%>&nbsp;</td>
      	<% } %>

		<% if(status.isTITLE_HIT_YN()) { %>
		<td class="listTable_td" align="center"><%=ListEntity.getValue(i,"READ_NUM")%>&nbsp;</td>
  		<% } %>

		<% if(status.isTITLE_DATE_YN()) { %>
		<td class="listTable_td" align="center"><%=KJFDate.dateOnly(KJFDate.str2date(ListEntity.getValue(i,"INS_DT"),""))%></td>
		<% } %>
    </tr>
	<% } %>

</table>  
<!-- 게시판 List : E -->

<% if ( (ListEntity == null || ListEntity.getRowCnt() == 0) ) {%>
<table width="100%" border="0"  cellspacing="0" cellpadding="0">
	<tr>
		<td class="inputTable_td" align="center" height="30">등록된 자료가 없습니다</td>
	</tr>
</table>
<%}%>
<br>

<!-- 페이징 START -->
<jsp:include page="../com/inc/paging_normal.jsp" flush="true">
	<jsp:param name="pagePerScreen" value="10"/>
	<jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
	<jsp:param name="totalCount" value="<%=totalCount%>"/>
	<jsp:param name="nowPage" value="<%=nowPage %>"/>
</jsp:include>
<!-- 페이징 END -->
