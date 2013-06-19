<%--
*************************************************************************************************
* 파  일  명 : ComCodeMgr.jsp
* 설      명 : 공통코드 관리화면
*
* 이력사항 :
* 2006/07/10  오두식  최초작성
* 2006/09/21  양석환  공무원 연수원 프로젝트용으로 내용 수정
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

	Vector v_code_group_search= (Vector)request.getAttribute("v_code_group_search");
	Vector v_code_group = (Vector)request.getAttribute("v_code_group");
	
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

// 신규 등록 폼 초기화
function fn_new() {
	var fm = document.fmParam;

 	fm.SEQ.value       = "";
    fm.P_CODE.value    = "000";
    fm.CODE.value      = "";
	fm.CODE_NAME.value = "";
    fm.BIGO.value      = "";
    fm.ORDER_SEQ.value = "";
    fm.USE_YN.value    = "Y";
    fm.mode.value      = "C";

    fm.CODE.focus();
}

// 수정
function fn_modify( SEQ,
					P_CODE,
                    CODE,
                    CODE_NAME,
                    BIGO,
                    USE_YN,
                    ORDER_SEQ   ) {

 	var fm = document.fmParam;
	
	if(CODE == '000'){
		fm.P_CODE.value    = CODE;
		fm.CODE.value      = P_CODE;
	}else {
		fm.P_CODE.value    = P_CODE;
		fm.CODE.value      = CODE;
	}
 	fm.SEQ.value       = SEQ;    
    fm.CODE_NAME.value = CODE_NAME;
    fm.BIGO.value      = BIGO;
    fm.ORDER_SEQ.value = ORDER_SEQ;
    fm.USE_YN.value    = USE_YN;
    fm.mode.value      = "U";
	
    fm.CODE_NAME.focus();
}

// 내용 저장
function fn_save(){
	var fm = document.fmParam;

	fm.cmd.value="ComCodeMgrCUD";
    kjsSubmit("fmParam");
}

// 선택 삭제
function fn_delete() {

	var fm = document.fmParam;

	if(chkBoxChildCheck('chk')){ // 선택된 항목이 있는지 체크
		var isOK = confirm('선택한 항목을 삭제하시겠습니까?');

		if(isOK){
			//삭제 처리
			fm.cmd.value = "ComCodeMgrCUD";

			fm.mode.value   = "D";
			fm.submit();
		}
    }
}

// 검색 창 처리
function fn_search(){
	var fm = document.fmParam;

	fm.isSearch.value = "show";
	fm.cmd.value="ComCodeMgr";
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

//선택된 항목이 있는지 검사.
function chkBoxChildCheck(chkName){
	var fm = document.fmParam;

	chkCount = 0;
	ChildChk = 0;

	for(i = 0;i < fm.elements.length;i++){
		if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName && fm.elements[i].checked == true){
	       	chkCount ++;
			ChildChk = fm.elements[i].value.split(',');
			if(ChildChk[3] > 0){
				alert("하위항목이 존재하는 코드가 포함되어 있습니다.");
				return false;
			}
	    }
	}

	if(chkCount == 0){
		alert("삭제 할 항목을 선택해 주십시오");
		return false;
	}
	return true;
}

function beforeKjs(){
	var fm = document.fmParam;

	fm.cmd.value = "ComCodeMgrCUD";
	return true;
}

//-->
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name=fmParam method="post" action="../sys/SysAction.do"  >
<!-- CUD 모드-->
<input type="hidden" name="cmd"  value="ComCodeMgr">
<input type="hidden" name="mode" value="C">
<!-- 검색창 상태 처리(필수)-->   
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">
<!-- 페이징 관련(필수)-->
<input type="hidden" name="nowPage"  value="<%=nowPage%>">


<!-- 타이틀 시작-->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle"   value=""/>
	<jsp:param name="ButtonType" value="N,S,D"/>
</jsp:include>
<!-- 타이틀 끝 -->

<!-- 입력부 디자인 부분 START -->
<jsp:include page="../com/inc/bgBox_title_top_inc.jsp" flush="true">
			<jsp:param name="title" value="<font size=2>등<br>록<br>/<br>수<br>정</font>"/>
</jsp:include>

<table width="100%"  border="0" cellspacing="0" cellpadding="3">
    <tr>
        <td class="listTable_header" align="center">코드그룹</td>
        <td class="listTable_header_section" width="100" align="center">코드</td>
        <td class="listTable_header_section" align="center">코드명</td>
        <td class="listTable_header_section" align="center" nowrap>비고</td>
        <td class="listTable_header_section" width="80">정렬순서</td>
        <td class="listTable_header_section" width="80">사용유무</td>
	</tr>
	
	<tr>
		<td class="inputTable_td">
			<input type="hidden" name="SEQ" value="">
			<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_code_group")%>'
								name="P_CODE"
								value="<%=KJFUtil.print(pm.getScP_CODE()) %>"
								script="class='input_combobox' style='border:0px' "/>
		</td>
		<td class="inputTable_td">&nbsp;
                          <input name=CODE type="text" class="input_textfield"      value="" size="10" maxlength="16" required></td>
		<td class="inputTable_td">&nbsp;
                          <input name=CODE_NAME type="text" class="input_textfield" value="" size="20" maxlength="64" required></td>
		<td class="inputTable_td">&nbsp;
                          <input name=BIGO type="text" class="input_textfield"      value="" size="20" maxlength="100"></td>
		                <td align="center" class="inputTable_td">&nbsp;
                          <input name=ORDER_SEQ type="text" class="input_textfield" onkeyup="ee_on_keyup(this)" value="" size="4" number required>
                        </td>
		                <td align="center" class="inputTable_td">
                          <SELECT NAME="USE_YN" class="input_combobox">
				<option value="Y">Y</option>
				<option value="N">N</option>
			</SELECT>
                        </td>
	</tr>
</table>

<jsp:include page="../com/inc/bgBox_title_bottom_inc.jsp" flush="true"/>
<!-- 입력부 디자인 부분 END -->

<!-- 리스트 테이블 START -->
<jsp:include page="../com/inc/noBox_top_inc.jsp" flush="true"/>

	<table width="100%" border="0"  cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" >
					<tr>					
						<td align="right">
							<table>
								<tr>
									<td>
										<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_code_group_search")%>'
														 name="scP_CODE"
														 value="<%=KJFUtil.print(pm.getScP_CODE()) %>"
														 script="class='input_combobox' "/>
									</td>
									<td>&nbsp;</td>
									<td>
										<input type="text" name="scCODE_NAME" value="<%=KJFUtil.print(pm.getScCODE_NAME()) %>" class="input_textfield">
									</td>
									<td>&nbsp;<a href="javascript:fn_search();"><img src="../images/bt_search.gif" alt="검색" border="0" align="absmiddle"></a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
    

<!-- 리스트 테이블 시작-->
    <table width="100%" border="0"  cellspacing="0" cellpadding="0" class="listTable">
        <tr>
			<td width="5%" height="33"  class="listTable_header" onClick="selectAll('chk');" style="cursor:hand">선택</td>
            <td class="listTable_header_section">그룹코드</td>
            <td class="listTable_header_section">코드</td>
            <td class="listTable_header_section">그룹명</td>
            <td class="listTable_header_section">코드명</td>
            <td class="listTable_header_section">비고</td>
            <td class="listTable_header_section">사용유무</td>
            <td class="listTable_header_section">정렬순번</td>
            <td class="listTable_header_section">수정</td>
        </tr>

<%
 if (rEntity!=null){
     for (int i = 0; i < rEntity.getRowCnt(); i++ ){
%>
	<tr onMouseOver="this.style.backgroundColor='#f7f7f7'; style.cursor='hand'" onMouseOut="this.style.backgroundColor='#FFFFFF'; style.cursor='hand'">
		<td class="listTable_td" align="center"><input type="checkbox" name="chk" value="<%=rEntity.getValue(i,"SEQ")%>,<%=rEntity.getValue(i,"CODE")%>,<%=rEntity.getValue(i,"P_CODE")%>,<%=rEntity.getValue(i,"CHILD_CHK")%>"></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i,"P_CODE")%></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i,"CODE")%></td>
		<td class="listTable_td" align="left">&nbsp;<%=rEntity.getValue(i,"P_NAME")%></td>
		<td class="listTable_td" align="left">&nbsp;<%=rEntity.getValue(i,"CODE_NAME")%></td>
		<td class="listTable_td" align="left">&nbsp;<%=rEntity.getValue(i,"BIGO")%></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i,"USE_YN")%></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i,"ORDER_SEQ")%></td>
		<td class="listTable_td" align="center">
			<a href="javascript:fn_modify( '<%=rEntity.getValue(i,"SEQ")%>'
										  ,'<%=rEntity.getValue(i,"P_CODE")%>'
										  ,'<%=rEntity.getValue(i,"CODE")%>'
										  ,'<%=rEntity.getValue(i,"CODE_NAME")%>'
										  ,'<%=rEntity.getValue(i,"BIGO")%>'
										  ,'<%=rEntity.getValue(i,"USE_YN")%>'
										  ,'<%=rEntity.getValue(i,"ORDER_SEQ")%>')"><img src="../images/modifyicon.gif" border="0" align="absmiddle"></a>					</td>
	</tr>

<%
     }//end for (int i=0;i< rEntity.getRowCnt();i++ )
 }
 if (rEntity == null || rEntity.getRowCnt() == 0) {
%>
    <tr><td class="listTable_td" align="center" colspan="9">등록된 자료가 없습니다.</td></tr>
<%  } %>
</table>
<!-- 리스트  테이블 끝-->
<br>

<!-- 페이징 -->
<jsp:include page="../com/inc/paging_normal.jsp" flush="true">
	<jsp:param name="pagePerScreen" value="10"/>
	<jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
	<jsp:param name="totalCount" value="<%=totalCount%>"/>
	<jsp:param name="nowPage" value="<%=nowPage %>"/>
</jsp:include>
<!-- 페이징 -->		

</td>
</table>
<jsp:include page="../com/inc/noBox_bottom_inc.jsp" flush="true"/>
<!-- 리스트  테이블 END-->

 <!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>
</body>
</html>
