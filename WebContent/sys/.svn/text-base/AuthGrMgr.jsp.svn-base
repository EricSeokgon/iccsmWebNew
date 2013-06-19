<%--
*************************************************************************************************
* 파  일  명 : AuthGrMgr.jsp
* 설      명 : 권한그룹 관리화면
* 
* 이력사항 :
* 2006/09/12  양석환  최초작성
*************************************************************************************************
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.sys.SysParam" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	//초기 변수 들 선언
	SysParam pm=(SysParam)request.getAttribute("pm");
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

	//페이징 관련(필수)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());
	String totalCount = KJFUtil.print(pm.getTotalCount());

	//필수 변수 (검색창 상태)
	String isSearch   = KJFUtil.print(pm.getIsSearch());

	int int_rnum = KJFUtil.str2int(totalCount) - (KJFUtil.str2int(nowPage) * KJFUtil.str2int(rowPerPage) - KJFUtil.str2int(rowPerPage));
%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>

<script language="JavaScript">
<!--

/////////////////////////////페이지 이동 스크립트////////////////////////////
function movePage(page){
    var fm= document.fmParam;
   
    fm.nowPage.value= page;
    fm.method = "post";
    fm.submit();
}

function changeRowPerPage(obj){
    var fm= document.fmParam;
    
    fm.rowPerPage.value= obj.value;
    fm.nowPage.value="1";
    fm.method = "post";
    fm.submit();
}
/////////////////////////////페이지 이동 스크립트////////////////////////////

// 신규
function fn_new() {

	var fm = document.fmParam;
	
    fm.AUTH_GROUP_CODE.value = "";
    fm.AUTH_GROUP_NAME.value = "";
    fm.ORDER_SEQ.value = "";
    fm.USE_YN.value = "Y";
    fm.mode.value="C";

	fm.AUTH_GROUP_NAME.focus();
}

// 수정
function fn_modify(	AUTH_GROUP_CODE, 
					AUTH_GROUP_NAME,
					ORDER_SEQ,
					USE_YN
					) {

 	var fm = document.fmParam;
 	
	fm.cmd.value = "AuthGrMgrCUD";
    fm.AUTH_GROUP_CODE.value = AUTH_GROUP_CODE;
    fm.AUTH_GROUP_NAME.value = AUTH_GROUP_NAME;
    fm.ORDER_SEQ.value = ORDER_SEQ;
    fm.USE_YN.value = USE_YN;
    fm.mode.value="U";

	fm.AUTH_GROUP_NAME.focus();
}

// 내용 저장
function fn_save(){
	var fm = document.fmParam;

	fm.cmd.value="AuthGrMgrCUD";
    kjsSubmit("fmParam");
}

// 선택 삭제
function fn_delete() {

	var fm = document.fmParam;

	if(chkBoxCheck('chk')){ // 선택된 항목이 있는지 체크
		var isOK = confirm('선택한 항목을 삭제하시겠습니까?');

		if(isOK){
			//삭제 처리
			fm.cmd.value = "AuthGrMgrCUD";

			fm.mode.value   = "D";
			fm.submit();
		}
    }
}

// 검색 창 처리
function fn_search(){
	var fm = document.fmParam;

	fm.isSearch.value = "show";
	fm.cmd.value="AuthGrMgr";
    fm.submit();
}

// 츨력 처리
function fn_print(){
	var fm = document.fmParam;

	fm.cmd.value="Blank";
    fm.submit();
}

// 엑셀 츨력 처리
function fn_excel(){
	var fm = document.fmParam;

	fm.cmd.value="Blank";
    fm.submit();
}

//체크 박스 전체 선택 및 전체 해제
function selectAll(chkName) {
	var fm = document.fmParam;

	for(i = 0;i < fm.elements.length;i++){
		if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName){
			fm.elements[i].checked = !fm.elements[i].checked;
		}
	}
}

function beforeKjs(){
	var fm = document.fmParam;
	
	fm.cmd.value = "AuthGrMgrCUD";
	return true;
}

//-->
</SCRIPT>
</head>

<body>
<form  name="fmParam" method="post"  action="SysAction.do" >
<!-- CUD 모드-->
<input type="hidden" name="cmd"  value="AuthGrMgr">
<input type="hidden" name="mode" value="C">
<!-- 검색창 상태 처리(필수)-->   
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">
<!-- 페이징 관련(필수)-->
<input type="hidden" name="nowPage"  value="<%=nowPage%>">


<!-- 타이틀 시작--> 
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
	<jsp:param name="ButtonType" value="N,S,D"/>
</jsp:include>
<!-- 타이틀 끝 -->

<!-- 검색 테이블  START -->
<jsp:include page="../com/inc/bgBox_title_top_inc.jsp" flush="true">
	<jsp:param name="title" value="<font size=2>검<br>색</font>"/>
</jsp:include>

<table width="100%" border="0" cellspacing="0" cellpadding="1" >
	<tr>
		<td width="120"  class="" align="right">권한그룹코드 :&nbsp;&nbsp;&nbsp;</td>
		<td width="240" class="">
			<input type="text" name="scCODE" value="<%=KJFUtil.print(pm.getScCODE()) %>" class="input_textfield" maxlength="5">
		</td>
		<td>&nbsp;</td>
		<td width="120"  class="" align="right">권한그룹명 :&nbsp;&nbsp;&nbsp;</td>
		<td width="" class="">
			<input type="text" name="scCODE_NAME" value="<%=KJFUtil.print(pm.getScCODE_NAME()) %>" class="input_textfield" maxlength="30">
                       <a href="#" onclick="fn_search();"><img src="../images/bt_search.gif" border="0" align="absmiddle"></a>
                     </td>
	</tr>
</table>

<jsp:include page="../com/inc/bgBox_title_bottom_inc.jsp" flush="true"/>
<!-- 검색 테이블  END -->


<!-- 입력부 디자인 부분 START -->
<jsp:include page="../com/inc/bgBox_title_top_inc.jsp" flush="true">
			<jsp:param name="title" value="<font size=2>입<br>력</font>"/>
</jsp:include>

<table width="720"  border="0" cellspacing="0" cellpadding="1" class="">
	<tr>
		<td class="" align="right">권한그룹명 : </td>
		<td class=""><input type="hidden" name="AUTH_GROUP_CODE"  value="" class="input_textfield" maxlength="5">
			<input type="text" name="AUTH_GROUP_NAME" value="" class="input_textfield" maxlength="15" required></td>
		<td class="" align="right">정렬순서 : </td>
		<td class="">&nbsp;<input type="text" name="ORDER_SEQ"       value="" class="input_textfield" onkeyup="ee_on_keyup(this)" number required></td>
		<td class="" align="right">사용유무 : </td>
		<td class="">
			<SELECT NAME="USE_YN" class="input_combobox">
				<option value="Y">Y</option>
				<option value="N">N</option>
			</SELECT>
		</td>
	</tr>
</table>

<jsp:include page="../com/inc/bgBox_title_bottom_inc.jsp" flush="true"/>
<!-- 입력부 디자인 부분 END -->

            
<!-- 리스트 테이블 시작-->
<table width="100%" border="0"  cellspacing="0" cellpadding="0" class="listTable">
	<tr>
		<td  class="listTable_header" width="7%"><a href="#" onClick="selectAll('chk')">선택</a></td>
        <td  class="listTable_header_section" width="14%">권한그룹코드</td>
        <td  class="listTable_header_section">권한그룹명</td>
        <td  class="listTable_header_section" width="10%">정렬순번</td>
        <td  class="listTable_header_section" width="10%">사용유무</td>
        <td  class="listTable_header_section" width="7%">수정</td>
	</tr>

<%
if (rEntity != null) {
    for (int i = 0; i < rEntity.getRowCnt(); i++ ) {
%>
	<tr>
		<td class="listTable_td" align="center"><input type="checkbox" name="chk" value="<%=rEntity.getValue(i,"AUTH_GROUP_CODE")%>"></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i,"AUTH_GROUP_CODE")%></td>
		<td class="listTable_td" align="left">&nbsp;<%=rEntity.getValue(i,"AUTH_GROUP_NAME")%></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i,"ORDER_SEQ")%></td>
		<td class="listTable_td" align="center">&nbsp;<%=rEntity.getValue(i,"USE_YN")%></td>
		<td class="listTable_td" align="center">
			<a href="javascript:fn_modify( '<%=rEntity.getValue(i,"AUTH_GROUP_CODE")%>'
							  				,'<%=rEntity.getValue(i,"AUTH_GROUP_NAME")%>'
							  				,'<%=rEntity.getValue(i,"ORDER_SEQ")%>'
							  				,'<%=rEntity.getValue(i,"USE_YN")%>')"><img src="../images/modifyicon.gif" border="0" align="absmiddle"></a></td>
</tr>

<%
    }
}

if ( rEntity == null || rEntity.getRowCnt() == 0 ) {
%>
	<tr><td class="listTable_td" align="center" colspan="6">등록된 자료가 없습니다.</td></tr>
<%  } %>

</table>
<!-- 리스트  테이블 끝-->
<br>

<!-- 페이징 -->
<jsp:include page="../com/inc/paging_ad.jsp" flush="true">
	<jsp:param name="pagePerScreen" value="10"/>
	<jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
	<jsp:param name="totalCount" value="<%=totalCount%>"/>
	<jsp:param name="nowPage" value="<%=nowPage %>"/>
</jsp:include>
<!-- 페이징 -->
            
<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>
</body>
</html>
