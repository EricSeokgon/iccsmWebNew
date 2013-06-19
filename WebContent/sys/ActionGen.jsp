<%--
*************************************************************************************************
* 파  일  명 : ActionGen.jsp
* 설      명 : Action자동 생성 
* 
* 이력사항 :
* 2006/05/29  김경덕  최초작성
* 2006/10/02  양석환  공무원연수원 디자인 적용
*************************************************************************************************
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.sys.SysParam" %>
<%@ page import="sp.uent.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	String result = KJFUtil.print((String)request.getAttribute("result"));

	//필수 변수 (검색창 상태)
	// String isSearch   = KJFUtil.print(pm.getIsSearch());
	String isSearch   = "";
%>

<html>
<head>
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<script language="JavaScript">
<!--
// 신규 등록 폼 초기화
function fn_new() {
}

// 내용 저장
function fn_save(){
}

// 선택 삭제
function fn_delete() {
}

// 검색 창 처리
function fn_search(){
}

// 츨력 처리
function fn_print(){
}

// 엑셀 츨력 처리
function fn_excel(){
}

//-->
</SCRIPT>
</head>

<body>
<form name=fmParam method="post" action="../sys/SysAction.do?cmd=ActionGen" >
<!-- 검색창 상태 처리(필수)-->   
<input type="hidden" name="isSearch" value="<%=isSearch%>">

<!-- 타이틀 시작--> 
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
	<jsp:param name="ButtonType" value=""/>
</jsp:include>
<!-- 타이틀 끝 -->
<br>

<jsp:include page="../com/inc/bgBox_top_inc.jsp" flush="true"/>
<!-- 입력부 디자인 부분 시작 -->
<table class="table_hide" width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" >
							<tr>
								<td class="table_header_center" width="70">&nbsp;&nbsp;&nbsp;폴더명</td>
								<td class="table_header_bright"><input type="text" name="folderNm" lower minlength ="2" required="폴더명을 입력하세요!">
								&nbsp;&nbsp;<input type='checkBox' name='MiChk' value='Y'>마이플래폼용</td>
							</tr>
						</table>
					</td>
					<td>
						<!-- 검색버튼 -->
						<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" id="searchButton">
							<tr>
								<td align="right">
									<img src="../images/bt_create.gif" alt="생성" onClick="javascript:kjsSubmit('fmParam');" border="0" style="cursor:hand"> 
								</td>
							</tr>
						</table>
						<!-- 검색버튼 -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 입력부 디자인 부분 끝 -->
<jsp:include page="../com/inc/bgBox_bottom_inc.jsp" flush="true"/>	

<!-- 테두리 시작 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr><td>
            <!-- 제너레이트 결과 시작 -->
            <table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E5E5E5">
                <tr><td align="left" height="30" bgcolor="#60A0D6">&nbsp;&nbsp;&nbsp;<font color="#FFFFFF"><b>결과</b></font></td></tr>
                <tr><td align="center" bgcolor="#EBF5FC"><%=KJFUtil.java2html(result) %>&nbsp;</td></tr>
            </table>           
            <!-- 제너레이트 결과 끝 -->        </td>
    </tr>
</table>
<!-- 테두리 끝 -->

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>    
</body>
</html>

