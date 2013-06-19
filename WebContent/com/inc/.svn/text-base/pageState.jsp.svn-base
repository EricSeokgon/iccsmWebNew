<%--
*************************************************************************************************
*
*
* 파  일  명 : pageState.jsp
* 설      명 : 페이지 현황 include 화면
*
* 이력사항 :
* 2004/01/02  김경덕  최초작성
*************************************************************************************************
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="kjf.util.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%
    int row_per_page    = 10; //한 페이지당 목록갯수
    int total_page   = 1; //전체 페이지 수
    int now_page     = 1; //현재 페이지
    int total_count  = 1; //전체 검색결과 수

    //파라미터 값으로 셋팅
    try {
        row_per_page   = request.getParameter("rowPerPage")   ==null? 10 : Integer.parseInt(request.getParameter("rowPerPage"));
        total_count    = request.getParameter("totalCount")   ==null?  1 : Integer.parseInt(request.getParameter("totalCount"));
        now_page       = request.getParameter("nowPage")      ==null?  1 : Integer.parseInt(request.getParameter("nowPage"));
    }catch (Exception ex) {
    }

    //전체 페이지 수 구함.

    if(row_per_page==0){
        total_page = 1;
    } else {
        total_page = (int)Math.ceil((double)total_count / (double)row_per_page);
        if (total_page == 0) total_page = 1;
    }

    out.print("Page ["+ now_page + "/" + total_page +"] Total : "+  total_count);
%>
<KTags:KJFSelect item="<%=KJFUtil.getSelPageLine()%>"
name="rowPerPage" value="<%=row_per_page+""%>"
script=" class='input_combobox2' onchange='changeRowPerPage(this)'"  />
