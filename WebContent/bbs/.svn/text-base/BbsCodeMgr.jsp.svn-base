<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.bbs.BbsParam" %>
<%@ page import="sp.uent.UserEnt" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	// 초기 변수 들 선언
	BbsParam pm = (BbsParam)request.getAttribute("pm");

	ReportEntity rEntity = (ReportEntity)request.getAttribute("rEntity");    
	
	String in = request.getParameter("JSESSIONID");
	
	UserEnt user = (UserEnt)request.getAttribute("user");

	// 페이징 관련(필수)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());
	String totalCount = KJFUtil.print(pm.getTotalCount());	
%>

<html>
<head>
<title></title>
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
* Title   : 페이지 이동
* Content : 페이지 이동 처리를 한다.  
****************************************************************************/
function movePage(page) {
    var fm= document.fmParam;
   
    fm.nowPage.value= page;

    fm.submit();
}

/***************************************************************************
* Title   : 리스트 목록수 변경
* Content : 리스트 목록수 변경 처리를 한다.  
****************************************************************************/
function changeRowPerPage(obj) {
    var fm= document.fmParam;
    
    fm.rowPerPage.value= obj.value;
    fm.nowPage.value="1";

    fm.submit();
}

/***************************************************************************
* Title   : 저장
* Content : 내용 저장 처리를 한다.  
****************************************************************************/
function fn_save(){
	kjsSubmit('fmParam');
}

/***************************************************************************
* Title   : 신규
* Content : 신규 작성 처리를 한다.  
****************************************************************************/
function fn_new() {
	var fm = document.fmParam;
	
	fm.CODE_NAME.value = "";
	fm.CODE.value      = "";
	fm.BIGO.value      = "";
	fm.ORDER_NUM.value = "";
	fm.mode.value      = "C";
	fm.USE_YN[0].selected = true;	
	
	fm.CODE.focus();
}

/***************************************************************************
* Title   : 수정
* Content : 내용 수정 처리를 한다.  
****************************************************************************/
function fn_modify(CODE_GROUP, CODE, CODE_NAME, BIGO,USE_YN, ORDER_NUM) {

 	var fm = document.fmParam;
 	
    fm.CODE_GROUP.value = CODE_GROUP;
    fm.CODE.value = CODE;
    fm.CODE_NAME.value = CODE_NAME;
    fm.BIGO.value = BIGO;
    fm.ORDER_NUM.value = ORDER_NUM;
    fm.USE_YN.value = USE_YN;

    fm.mode.value="U";
    fm.CODE_NAME.focus();
}

/***************************************************************************
* Title   : 삭제
* Content : 내용 삭제 처리를 한다.  
****************************************************************************/
function fn_del(CODE_GROUP, CODE) {

	var fm = document.fmParam;
	
    if (!confirm("선택된 항목을 삭제 하시겠습니까?")){
        return;
    }
	
	fm.cmd.value = "BbsCodeMgrCUD";	
	fm.CODE_GROUP.value = CODE_GROUP;
    fm.CODE.value = CODE;
    fm.mode.value="D";
    
    fm.submit();
}

/***************************************************************************
* Title   : 사용전 검사 처리
* Content : 사용전 검사 처리를 한다.  
****************************************************************************/
function beforeKjs() {
	var fm = document.fmParam;
	
	fm.cmd.value = "BbsCodeMgrCUD";	
	
	return true;
}
//-->
</SCRIPT>

</head>

<body leftmargin="0" marginwidth="0" marginheight="0">
<form name=fmParam method="post" action="../bbs/BbsAction.do">

<!-- CUD 모드-->
<input type=hidden name="cmd" value="BbsCodeMgr">  
<input type=hidden name="mode" value="C">

<!-- 페이징 관련(필수)-->       
<input type=hidden name="nowPage"         value="<%=nowPage%>">
           
<!-- 상단 타이틀 START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value="N,S"/></jsp:include>
<!-- 상단 타이틀 END -->

<!-- ======================= 입력부 디자인 부분 START ========================= -->
<jsp:include page="../com/inc/bgBox_title_top_inc.jsp" flush="true">
	<jsp:param name="title" value="<font size=2>입<br>력</font>"/>
</jsp:include>

<table width="100%" border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td class="listTable_header"  width="20%" >코드그룹</td>
		<td class="listTable_header_section" width="20%">코드</td>
		<td class="listTable_header_section" width="20%">코드명</td>
		<td class="listTable_header_section" >비고</td>
		<td class="listTable_header_section" width="10%">정렬순서</td>
		<td class="listTable_header_section" width="10%">사용유무</td>
	</tr>

	<tr>
		<td class="inputTable_td" align="center">
			<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_code_group")%>'
			name="CODE_GROUP"
			value="<%=KJFUtil.print(pm.getScCODE_GROUP()) %>"
			script="class='input_combobox2'"/></td>
		<td class="inputTable_td" align="center">
			<input type=text name=CODE value=""
			maxlength='30'
			class="input_textfield"
			required></td>
		<td class="inputTable_td" align="center">
			<input type=text name=CODE_NAME value=""
			maxlength='50'
			class="input_textfield"
			required></td>
		<td class="inputTable_td" align="center">
			<input type=text name=BIGO value=""
			maxlength='100'
			class="input_textfield"></td>
		<td class="inputTable_td" align="center">
			<input type=text name=ORDER_NUM value="" size="13"
			class="input_textfield"
			required
			number onkeyup="ee_on_keyup(this)" ></td>
		<td class="inputTable_td" align="center">
			<SELECT NAME="USE_YN" class="input_combobox2">
				<option value='Y' >Y</option>
				<option value='N' >N</option>
			</SELECT></td>
	</tr>
</table>

<jsp:include page="../com/inc/bgBox_title_bottom_inc.jsp" flush="true"/>
<!-- ======================= 입력부 디자인 부분 END =========================== -->


<!-- ======================= 검색 테이블 START =============================== -->
<table width="100%" border="0" cellspacing="0" cellpadding="1" class="table_line">
	<tr>
		<td align="right">
			<table border="0"  cellspacing="0" cellpadding="1"  class="table_line">
				<tr>
					<td class="searchTable_td"   >
						<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_code_group_search")%>'
						name="scCODE_GROUP"
						value="<%=KJFUtil.print(pm.getScCODE_GROUP()) %>"
						script="class='input_combobox2' onchange='submit()' "/>
					</td>
					<td class="searchTable_td">
						<input type=text name=scCODE_NAME value="<%=KJFUtil.print(pm.getScCODE_NAME()) %>" class="input_textfield">
					</td>
					<td class="searchTable_td">
						<img src="../images/bt_search.gif" border="0" alt="검색" onclick="submit()" style="cursor:hand"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- ======================= 검색 테이블 END ================================= -->


<!-- ======================= 리스트 테이블 START ============================= -->
<table width="100%" border="0"  cellspacing="0" cellpadding="3" >
	<tr>
		<td  class="listTable_header" width="80">코드그룹</td>
		<td  class="listTable_header_section" width="60">코드</td>
		<td  class="listTable_header_section"  width="150">코드명</td>
		<td  class="listTable_header_section" >비고</td>
		<td  class="listTable_header_section" width="80">사용유무</td>
		<td  class="listTable_header_section" width="75">정렬순번</td>
		<td  class="listTable_header_section" width="40">수정</td>
		<td  class="listTable_header_section" width="40">삭제</td>
	</tr>

	<% if (rEntity != null) { %>
		<% for (int i = 0; i < rEntity.getRowCnt(); i++ ) { %>
	
	<tr> 
		<td class="listTable_td" align="center">
			<%=rEntity.getValue(i,"CODE_GROUP")%>&nbsp;</td>
		<td class="listTable_td" align="center"> 
			<%=rEntity.getValue(i,"CODE")%></td>
		<td class="listTable_td"> 
			<%=rEntity.getValue(i,"CODE_NAME")%></td>
		<td class="listTable_td"> 
			<%=rEntity.getValue(i,"BIGO")%></td>
		<td class="listTable_td" align="center"> 
			<%=rEntity.getValue(i,"USE_YN")%></td>													
		<td class="listTable_td" align="center"> 
			<%=rEntity.getValue(i,"ORDER_NUM")%></td>
		<td class="listTable_td" align="center">
			<a href="javascript:fn_modify( '<%=rEntity.getValue(i,"CODE_GROUP")%>'
										 ,'<%=rEntity.getValue(i,"CODE")%>'
										 ,'<%=rEntity.getValue(i,"CODE_NAME")%>'
										 ,'<%=rEntity.getValue(i,"BIGO")%>'
										 ,'<%=rEntity.getValue(i,"USE_YN")%>'
										 ,'<%=rEntity.getValue(i,"ORDER_NUM")%>')">
			<img src="../images/modifyicon.gif" border="0" alt="수정" style="cursor:hand"></a> 
		</td>									
		<td class="listTable_td" align="center">
			<a href="javascript:fn_del('<%=rEntity.getValue(i,"CODE_GROUP")%>','<%=rEntity.getValue(i,"CODE")%>');">
				<img src="../images/appr_delete.gif" border="0" alt="삭제" style="cursor:hand"></a>
		</td>
	</tr>
		<% } %>
    <% }%>
	
    <% if (rEntity==null || rEntity.getRowCnt()==0) {%>
	<tr>
		<td class="listTable_td" align="center" colspan="8">등록된 자료가 없습니다.</td>
	</tr>
	<% } %> 

</table><br>
<!-- ======================= 리스트 테이블 END =============================== -->


<!-- =========================== 페이징 START =============================== -->
<jsp:include page="../com/inc/paging_normal.jsp" flush="true">
	<jsp:param name="pagePerScreen" value="10"/>
	<jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
	<jsp:param name="totalCount" value="<%=totalCount%>"/>
	<jsp:param name="nowPage" value="<%=nowPage %>"/>
</jsp:include>
<!-- =========================== 페이징 END ================================= -->


<!-- =========================== copyright START =========================== -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
<!-- =========================== copyright END ============================= -->

</form>

</body>
</html>
