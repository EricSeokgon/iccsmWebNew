<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.bbs.BbsParam" %>
<%@ page import="sp.uent.UserEnt" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	// 초기 변수 들 선언
	BbsParam pm =(BbsParam)request.getAttribute("pm");

	ReportEntity rEntity = (ReportEntity)request.getAttribute("rEntity");
	
	UserEnt user = (UserEnt)request.getAttribute("user");
	
	// 페이징 관련(필수)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());
	String totalCount = KJFUtil.print(pm.getTotalCount());
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<!-- 공퉁 부분 -->

<SCRIPT LANGUAGE="JavaScript">
<!--

/***************************************************************************
* Title   : 신규
* Content : 신규 처리를 한다.  
****************************************************************************/
function fn_new() {
	var fm = document.fmParam;

    fm.cmd.value="BbsCtrlW";
    fm.submit();
}

/***************************************************************************
* Title   : 보기
* Content : 상세보기 처리를 한다.  
****************************************************************************/
function fn_view(CT_ID) {
 	var fm = document.fmParam;

    fm.CT_ID.value = CT_ID;
    fm.cmd.value="BbsCtrlV";
    fm.submit();

}

/***************************************************************************
* Title   : 수정
* Content : 수정 처리를 한다.  
****************************************************************************/
function fn_modify(CT_ID) {
 	var fm = document.fmParam;

    fm.CT_ID.value = CT_ID;
    fm.cmd.value="BbsCtrlW";
    fm.mode.value="M";
    fm.submit();

}

/***************************************************************************
* Title   : 삭제
* Content : 삭제 처리를 한다.  
****************************************************************************/
function fn_delete(CT_ID) {
	var fm = document.fmParam;

    if (!confirm("선택된 항목을 삭제 하시겠습니까?")){
        return;
    }

    fm.CT_ID.value = CT_ID;
    fm.cmd.value="BbsCtrlD";
    fm.submit();
}

/***************************************************************************
* Title   : 검색
* Content : 검색 처리를 한다.  
****************************************************************************/
function fn_search() {
	var fm = document.fmParam;

	fm.cmd.value = "BbsCtrlMgr";
	fm.submit();
}

/***************************************************************************
* Title   : 해당 게시물 삭제
* Content : 해당 게시물 삭제 처리를 한다.  
****************************************************************************/
function fn_reset(CT_ID, isOneTable) {
	var fm = document.fmParam;

    if (confirm("선택된 게사판의 게시물을 모두 삭제 하시겠습니까?")) {
	    fm.CT_ID.value = CT_ID;
	    fm.TABLE_ONE_YN.value = isOneTable;
	    fm.cmd.value="BbsCtrlTD";
	    fm.submit();
    }
}



//-->
</SCRIPT>

</head>

<body leftmargin="0" marginwidth="0" marginheight="0">

<!-- 폼은 가능한 하나로 처리한다. -->
<form name=fmParam method="post" action="../bbs/BbsAction.do" >

<!-- 필수 사항 (삭제하지 말 것) START -->

<!-- CUD 모드-->
<INPUT type="hidden" name="cmd" value="BbsCtrlMgr">
<INPUT type="hidden" name="mode">

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage" value="<%=nowPage%>">

<!-- 필수 사항 (삭제하지 말 것) END -->

<!-- 기타 페이지별 폼 등록 START -->
<INPUT type="hidden" name="CT_ID">
<INPUT type="hidden" name="TABLE_ONE_YN">
<!-- 기타 페이지별 폼 등록 END -->

<!-- 상단 타이틀 START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle"   value=""/>
<jsp:param name="ButtonType" value="N"/></jsp:include>
<!-- 상단 타이틀 END -->


<!-- ============================ 검색 테이블 START ========================== -->
<table width="100%" border="0" cellspacing="0" cellpadding="1" class="table_line">
	<tr>
		<td align="right">
			<table border="0" cellspacing="0" cellpadding="1">
				<tr>
					<td>
						<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_sc_type")%>'
						name='scTYPE'
						value='<%=KJFUtil.print(pm.getScTYPE()) %>'
						script="class='input_combobox2' onchange='fn_search()' "/></td>
					<td>
			            <input type=text name=scBOARD_NAME value="<%=KJFUtil.print(pm.getScBOARD_NAME()) %>"
			            class="input_textfield"
			            entSubmit="fmParam" onkeyup ="ee_on_keyup(this)"></td>
					<td align="right"><img src="../images/bt_search.gif" border="0" alt="검색"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- ============================ 검색 테이블 END ============================ -->


<!-- =========================== 리스트 테이블 START ========================= -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
    <tr>
        <td class="listTable_header" >보드명</td>
        <td class="listTable_header_section" >보드ID</td>
        <td class="listTable_header_section" >보드 타입 </td>
        <td class="listTable_header_section" width="75" >파일첨부</td>
        <td class="listTable_header_section" width="75" >답변유무</td>
        <td class="listTable_header_section" width="75">사용유무</td>
        <td class="listTable_header_section" width="30">리셋</td>
        <td class="listTable_header_section" width="30">상세</td>
        <td class="listTable_header_section" width="30">삭제</td>
    </tr>

	<% for (int i = 0; i < rEntity.getRowCnt(); i++) { %>
	<tr>
		<td class="listTable_td">
			<%=rEntity.getValue(i, "BOARD_NAME")%>&nbsp;</td>
		<td class="listTable_td" align="center">
			<%=rEntity.getValue(i, "CT_ID")%></td>
		<td class="listTable_td" align="center">
			<%=rEntity.getValue(i, "TYPE")%></td>
		<td class="listTable_td" align="center">
			&nbsp;<%=rEntity.getValue(i, "ATTACH_YN")%></td>
		<td class="listTable_td" align="center">
			&nbsp;<%=rEntity.getValue(i, "REPLY_YN")%></td>
		<td class="listTable_td" align="center">
			&nbsp;<%=rEntity.getValue(i, "USE_YN")%></td>
		<td class="listTable_td" align="center">
			<img src="../images/modifyicon.gif" alt="Reset" border="0" 
				onClick="javascript:fn_reset( '<%=rEntity.getValue(i, "CT_ID")%>','<%=rEntity.getValue(i, "TABLE_ONE_YN")%>');" 
					style="cursor:hand">
		</td>
		<td class="listTable_td" align="center">
			<img src="../images/modifyicon.gif" alt="수정" border="0" 
				onClick="javascript:fn_modify( '<%=rEntity.getValue(i, "CT_ID")%>');" 
					style="cursor:hand">
		</td>
		<td class="listTable_td" align="center">
			<img src="../images/appr_delete.gif" alt="삭제" border="0" 
				onClick="javascript:fn_delete('<%=rEntity.getValue(i, "CT_ID")%>');" 
					style="cursor:hand">
		</td>
	</tr>
	<% } %>

   <% if (rEntity.getRowCnt()==0) { %>
    <tr>
       <td class="listTable_td" align="center" colspan="10">등록된 자료가 없습니다.</td>
    </tr>
	<% } %>

</table><br>
<!-- =========================== 리스트 테이블 END =========================== -->

<!-- =========================== 페이징 START =============================== -->
<jsp:include page="../com/inc/paging_normal.jsp" flush="true">
  <jsp:param name="pagePerScreen" value="10"/>
  <jsp:param name="rowPerPage"    value="<%=rowPerPage%>"/>
  <jsp:param name="totalCount"    value="<%=totalCount%>"/>
  <jsp:param name="nowPage"       value="<%=nowPage %>"/>
</jsp:include>
<!-- =========================== 페이징 START =============================== -->

<!-- =========================== copyright START =========================== -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
<!-- =========================== copyright END ============================= -->
</form>
</body>
</html>