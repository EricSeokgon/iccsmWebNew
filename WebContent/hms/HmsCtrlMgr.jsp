<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.hms.HmsParam" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	// 초기 변수 들 선언
	HmsParam pm =(HmsParam)request.getAttribute("pm");

	ReportEntity rEntity = (ReportEntity)request.getAttribute("rEntity");
	
	// 페이징 관련(필수)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());
	String totalCount = KJFUtil.print(pm.getTotalCount());
	
	// 검색 코드
    String scSLCT_GUBUN = KJFUtil.print(pm.getScSLCT_GUBUN());
    String scTEXTVALUE  = KJFUtil.print(pm.getScTEXTVALUE());
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<script language="javascript" src="../com/js/httpRequest.js" type="text/javascript"></script>
<!-- 공퉁 부분 -->

<SCRIPT LANGUAGE="JavaScript">
<!--

/***************************************************************************
* Title   : 신규
* Content : 신규 처리를 한다.  
****************************************************************************/
function fn_new() {
	var fm = document.fmParam;

    fm.cmd.value="HmsCtrlW";
    fm.submit();
}

/***************************************************************************
* Title   : 보기
* Content : 상세보기 처리를 한다.  
****************************************************************************/
function fn_view(MENU_ID) {
 	var fm = document.fmParam;

    fm.MENU_ID.value = MENU_ID;
    fm.cmd.value="HmsCtrlV";
    fm.submit();

}

/***************************************************************************
* Title   : 수정
* Content : 수정 처리를 한다.  
****************************************************************************/
function fn_modify(MENU_ID) {
 	var fm = document.fmParam;

    fm.MENU_ID.value = MENU_ID;
    fm.cmd.value="HmsCtrlW";
    fm.mode.value="M";
    fm.submit();

}

/***************************************************************************
* Title   : 삭제
* Content : 삭제 처리를 한다.  
****************************************************************************/
function fn_delete() {
	var fm = document.fmParam;

	var fm = document.fmParam;

	if(chkBoxCheck('chk')){ // 선택된 항목이 있는지 체크

		var isOK = confirm("선택된 항목을 삭제 하시겠습니까?\n삭제된 게시물은 영구히 삭제됩니다.");

		if(isOK) {
			fm.cmd.value="HmsCtrlD";
    		fm.submit();
		}
	}
}

/***************************************************************************
* Title   : 검색
* Content : 검색 처리를 한다.  
****************************************************************************/
function fn_search() {
	var fm = document.fmParam;

	fm.cmd.value = "HmsCtrlMgr";
	fm.submit();
}

/***************************************************************************
* Title   : 중분류 코드를 검색한다   
* Content : 중분류 코드 Ajax검색 처리를 한다. 
****************************************************************************/
function fn_changeM_MenuCode() {

	var fm = document.fmParam;
	
	if (fm.scL_MENU_CD.value == "") {
		document.getElementById("layer_m_menu").innerHTML = 
			"<select name='scM_MENU_CD' class='input_bbs' > " +
			" 	<option value=''  selected > 중분류 선택 </option> " +
			" </select> ";
		
	} else {		
		var scL_MENU_CD = fm.scL_MENU_CD.value;

		sendRequest("../hms/HmsAction.do", "cmd=HmsLscMenu&scL_MENU_CD=" + scL_MENU_CD, fn_M_MenuCodeView, "POST");
	}
}

/***************************************************************************
* Title   : 중분류 코드 화면 처리 화면
* Content : 중분류 코드 Ajax로 검색 리스트를 화면 처리 한다. 
****************************************************************************/
function fn_M_MenuCodeView() {
	document.getElementById("layer_m_menu").innerHTML = httpRequest.responseText;
}

//-->
</SCRIPT>

</head>

<body leftmargin="0" marginwidth="0" marginheight="0">

<!-- 폼은 가능한 하나로 처리한다. -->
<form name=fmParam method="post" action="../hms/HmsAction.do" >

<!-- 필수 사항 (삭제하지 말 것) START -->

<!-- CUD 모드-->
<INPUT type="hidden" name="cmd" value="HmsCtrlMgr">
<INPUT type="hidden" name="mode">

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage" value="<%=nowPage%>">

<!-- 필수 사항 (삭제하지 말 것) END -->

<!-- 기타 페이지별 폼 등록 START -->
<INPUT type="hidden" name="MENU_ID">
<!-- 기타 페이지별 폼 등록 END -->

<!-- 상단 타이틀 START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle"   value=""/>
<jsp:param name="ButtonType" value="N,D"/></jsp:include>
<!-- 상단 타이틀 END -->


<!-- ============================ 검색 테이블 START ========================== -->
<table width="100%" border="0" cellspacing="0" cellpadding="1" class="table_line">
	<tr>
		<td align="right">

			<table border="0" align="right" cellPadding="0" cellSpacing="5">
				<tr> 
					<TD>            
						<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSLCT_GUBUN")%>'
										 name='scSLCT_GUBUN'
										 value='<%=KJFUtil.print(scSLCT_GUBUN) %>'
										 script="class='input_bbs' "/> 
					</TD>
		            <td> 
						<table cellSpacing=0 cellPadding=0 border=0>
		                  	<tr> 
		                    	<td><INPUT class="input_bbs" name="scTEXTVALUE" size="30" maxlength="20" value="<%=scTEXTVALUE %>"> </TD>
		                  	</tr>
		              	</table>
					</td>
		            <td>
		            	<a href="javascript:fn_search()">
				            <img src="../images/bbs/bt_search.gif" border="0" align="absMiddle" alt="검색"> 
		            	</a>
		            </td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- ============================ 검색 테이블 END ============================ -->


<!-- =========================== 리스트 테이블 START ========================= -->
<table width="100%" border="0" cellspacing="0" cellpadding="3" >
    <tr>
		<td class="listTable_header" width="5%"><a href="#" onclick="selectAll('chk')">선택</a></td>
        <td class="listTable_header_section" width="5%">ID</td>
        <td class="listTable_header_section" >대분류</td>
		<td class="listTable_header_section" >중분류</td>
		<td class="listTable_header_section" >소분류</td>
        <td class="listTable_header_section" >페이지명 및 디자인 페이지 </td>
    </tr>

	<% for (int i = 0; i < rEntity.getRowCnt(); i++) { %>
	<tr>
		<td class="listTable_td" align="center"><input type="checkbox" name="chk" value="<%= rEntity.getValue(i, "MENU_ID") %>"></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i, "MENU_ID")%>&nbsp;</td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i, "L_MENU"), "&nbsp;")%></td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i, "M_MENU"), "&nbsp;")%></td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i, "S_MENU"), "&nbsp;")%></td>
		<td class="listTable_td">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
				
				<tr>
					<td>
						<font color="blue"><%=KJFUtil.print(rEntity.getValue(i, "TITLE"), "&nbsp;")%></font><br>
						<a href="javascript:fn_modify( '<%=rEntity.getValue(i, "MENU_ID")%>');">
						<%=KJFUtil.print(rEntity.getValue(i, "URL"), "&nbsp;")%></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<% } %>

   <% if (rEntity.getRowCnt()==0) { %>
    <tr>
       <td class="listTable_td" align="center" colspan="8">등록된 자료가 없습니다.</td>
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