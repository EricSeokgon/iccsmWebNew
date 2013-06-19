<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="kjf.util.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%!
final static String PREV_MARK = "<img src='../bbs/images/bot_bt_p.gif' border='0' align='absmiddle'>";
final static String NEXT_MARK = "<img src='../bbs/images//bot_bt_n.gif' border='0' align='absmiddle'>";
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



	            <table border="0" cellpadding="0" cellspacing="0" width=100%>
                <tr>
                    <td align=center class=bbs04>
					<%if(n_page == 1){%>
                    <a href="javascript:alert('더이상 페이지가 없습니다.')">
					<%}else{%>
					<a href="javascript:movePage('1')">
					<%}%>
					<img src="../bbs/images/arr_left.gif" align="absmiddle" border="0"></a>
                    <%
				if (nowScreen == 1) {
					if(n_page == 1){				
				%>
				<%}else{%>
				<a href="javascript:movePage('<%=(n_page-1)%>')"></a>	
				<%}%>
				<%
				}else{
					out.print("<a href=\"javascript:movePage('" + ((nowScreen - 1) * 10) + "')\">" + "</a>");
				}
			%>
			<%
			for (int i = firstPageNumber; i <= lastPageNumber ; i++) {
				if (i != firstPageNumber)
					out.print("|");
				if (i == n_page) {
					out.print("&nbsp;<B>" + i + "</B>&nbsp;");
				}else{
				%>
					<a href="javascript:movePage('<%=i%>')">&nbsp;<%=i%>&nbsp;</a>&nbsp;
				<%
				}
			}
		%>
		 <%
			if (nowScreen == totalScreen) {
				if(n_page == lastPageNumber){
			%>
			<%	
				}else{%>
				<a href="javascript:movePage('<%=(n_page+1)%>')"></a>	
			<%	}
			}else{
			%>
				<a href="javascript:movePage('<%=(nowScreen * 10 + 1)%>')"></a>
			<%
			}
			%>
			<%if(n_page == lastPageNumber){%>
			<a href="javascript:alert('더이상 페이지가 없습니다.');"><img src="../bbs/images/arr_right.gif" align="absmiddle" border="0"></a>
			<%}else{%>
			<a href="javascript:movePage('<%=lastPageNumber%>')"><img src="../bbs/images/arr_right.gif" align="absmiddle" border="0"></a>
			<%}%>
		 </td>
                </tr>
            </table>