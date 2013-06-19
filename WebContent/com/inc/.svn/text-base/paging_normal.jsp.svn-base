<%--
*************************************************************************************************
*
*
* 파  일  명 : paging.jsp
* 설      명 : 페이징 include 화면
*
* 이력사항 :
* 2004/01/02  김경덕  최초작성
*************************************************************************************************
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="kjf.util.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%if( !"".equals(KJFUtil.print(request.getParameter("cmd"))) ){%><input type=hidden name="cmdP" value="<%=KJFUtil.print(request.getParameter("cmd"))%>"><%}%>

<%!
final static String PREV_MARK = "<img src='../images/bt_pre.gif'  border='0' align='absbottom'>";
final static String NEXT_MARK = "<img src='../images/bt_next.gif' border='0' align='absbottom'>";
%>
<%

	int pagePerScreen = 10; //한 스크린 당 페이지 갯수
	int row_perPage    = 10; //한 페이지당 목록갯수

	int totalScreen = 1; //전체 스크린 수
	int totalPage   = 1; //전체 페이지 수
	int nowScreen   = 1; //현재 스크린
	int n_page     = 1; //현재 페이지
	int total_cnt  = 1; //전체 검색결과 수
	int firstPageNumber = 1;  //현재 스크린의 시작번호
	int lastPageNumber  = 1; //현재 스크린의 마지막번호

	//파라미터 값으로 셋팅
	try {
		row_perPage    = request.getParameter("rowPerPage")   ==null? 10 : Integer.parseInt(request.getParameter("rowPerPage"));
		total_cnt    = request.getParameter("totalCount")   ==null?  1 : Integer.parseInt(request.getParameter("totalCount"));
		n_page       = request.getParameter("nowPage")      ==null?  1 : Integer.parseInt(request.getParameter("nowPage"));
	}catch (Exception ex) {
	}

	//전체 페이지 수 구함.
	if (row_perPage==0){
		totalPage = 1;
	} else {
		totalPage = (int)Math.ceil((double)total_cnt / (double)row_perPage);
		if (totalPage == 0) totalPage = 1;
	}

	//전체 스크린 수 구함
	totalScreen = (int)Math.ceil((double)totalPage / (double)pagePerScreen);
	if (totalScreen == 0) totalScreen = 1;

	//현재 스크린 구함
	nowScreen = (int)Math.ceil((double)n_page / (double)pagePerScreen);

	//현재 스크린의 시작번호
	firstPageNumber = (nowScreen * pagePerScreen) - (pagePerScreen - 1);
	//현재 스크린의 마지막번호
	if (nowScreen == totalScreen) {
		lastPageNumber = totalPage;
	}else{
		lastPageNumber = nowScreen * pagePerScreen;
	}

%>

<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#f5f5f5">
	<tr>
		<td width="11" height="11"><img src="../images/page_box/neo_box02_1.gif"></td>
		<td background="../images/page_box/neo_box02_2.gif"></td>
		<td width="11"><img src="../images/page_box/neo_box02_3.gif"></td>
	</tr>
	<tr>
		<td background="../images/page_box/neo_box02_8.gif"></td>
		<td  align="center" valign="top">
			<!------box table start-------->
			<table width="97%" border="0" cellpadding="0" cellspacing="0">
			  <tr>
			  <td class="paging" width="200" align="left">Page[<%=n_page%>/<%=totalPage%>], Total:<%=total_cnt%></td>
				<td height="30" align="center">



<table  border="0" cellspacing="0" cellpadding="0">

  <tr>



		<td  width="18" style="font-size: 13px">
			<%
				//[이전] 표시
				if (nowScreen == 1) {
					out.print(PREV_MARK);
				}else{
					out.print("<a href=\"javascript:movePage('" + ((nowScreen - 1) * 10) + "')\">" + PREV_MARK + "</a>");
				}
			%>
		</td>


    <td  align="center" style="font-size: 13px;font-weight: bold">
      <%
			//페이지 Numbering
			for (int i = firstPageNumber; i <= lastPageNumber ; i++) {
				if (i != firstPageNumber)
					out.print("<img src='../images/pagebar.gif'>");

				if (i == n_page) {
					out.print("<FONT style=color='#1A71D2'><SPAN style='FONT-SIZE: 9pt'>");
					out.print("<b>&nbsp;" + i + "&nbsp;</b></SPAN></FONT>&nbsp;");
				}else{
					out.print("<a href=\"javascript:movePage('" + i + "')\">");
					out.print("&nbsp;" + i + "&nbsp;");
					out.print("</a>&nbsp;");
				}
			}
		%>
		</td>


		<td  width="18" style="font-size: 13px">
		  <%
			//[다음] 표시
			if (nowScreen == totalScreen) {
				out.print(NEXT_MARK);
			}else{
				out.print("<a href=\"javascript:movePage('" + (nowScreen * 10 + 1) + "')\">" + NEXT_MARK + "</a>");
			}
			%>
			</td>




	</tr>

</table>





				</td>
			   <td  width="200" align="right"> <KTags:KJFSelect item='<%=KJFUtil.getSelPageLine()%>'
			name='rowPerPage' value='<%=row_perPage+""%>'
			script=" onchange='changeRowPerPage(this)' "  />
    		</td>
			  </tr>
			</table>
		</td>
		<td background="../images/page_box/neo_box02_4.gif"></td>
	</tr>
	<tr>
		<td width="11" height="11"><img src="../images/page_box/neo_box02_7.gif"></td>
		<td background="../images/page_box/neo_box02_6.gif"></td>
		<td width="11"><img src="../images/page_box/neo_box02_5.gif"></td>
	</tr>
</table>
<!------box end--------->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="8"></td>
	</tr>
</table>
<!------높이 조절용 end --------->






<!--
  <tr>
    <td>
    <%
      out.print("total_cnt:" + total_cnt);
      out.print("totalScreen:"+totalScreen+", totalPage:" + totalPage + ", ");
      out.print("n_page:" + n_page + ", nowScreen=" + nowScreen + ", ");
      out.print("firstPageNumber:" + firstPageNumber + ", lastPageNumber:" + lastPageNumber);
      //시작 및 끝 RowNO
      int startRowNO = (n_page * row_perPage) - (row_perPage - 1);
      int endRowNO = n_page * row_perPage;
      out.print("startRowNO:" + startRowNO + ", endRowNO:"+ endRowNO);
    %>
    </td>
  </tr>
-->

