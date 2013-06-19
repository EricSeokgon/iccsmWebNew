<%--
*************************************************************************************************
* 파  일  명 : DaoGen.jsp
* 설      명 : Dao자동 생성 
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
	//	String isSearch   = KJFUtil.print(pm.getIsSearch());
	String isSearch   = "";
%>

<html>
<head>
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<SCRIPT LANGUAGE="JavaScript">
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
<form name="fmParam" method="post" action="../sys/SysAction.do?cmd=DaoGen" >
<!-- 검색창 상태 처리(필수)-->   
<input type="hidden" name="isSearch" value="<%=isSearch%>">


<!-- 타이틀 시작--> 
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
	<jsp:param name="ButtonType" value=""/>
</jsp:include>
<!-- 타이틀 끝 -->
<br>

<!-- 테두리 시작 -->
<table width="99%" height="100%" border="0" cellspacing="0" cellpadding="0">	
	<tr>
		<td valign="top">
			<!-- 입력부 디자인 부분 시작 -->
			<table class="table_hide" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E5E5E5">
							<tr><td align="left" height="30" bgcolor="#60A0D6">&nbsp;&nbsp;&nbsp;<font color="#FFFFFF"><b>테이블</b></font></td></tr>
							<tr>
								<td align="center" bgcolor="#EBF5FC">
									<!---------------------------------- 입력영역 라인 --------------------------------------------->
									<!-- 공간은 &nbsp; 로 처리한다. -->
									<table width="100%" border="0" cellspacing="0" cellpadding="0" >
										<tr>
											<td align="center">
												<TEXTAREA NAME="TABLE_CD" required="테이블 명을 입력 해주세요." ROWS="2" COLS="80"></TEXTAREA>											</td>
										</tr>
									</table>
									<!---------------------------------- 입력영역 라인 --------------------------------------------->								</td>
							</tr>
						</table>					
					</td>
				</tr>
				
				<tr>
					<td>
						<br>
						<!-- 검색버튼 -->
						<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" id="searchButton">
							<tr>
								<td align ="right" height="28">
									<img src="../images/bt_create.gif" alt="생성" onClick="javascript:kjsSubmit('fmParam');" border="0" style="cursor:hand">
								</td>
							</tr>
						</table>
						<br>
						<!-- 검색버튼 -->					
					</td>
				</tr>
				
			</table>
			<!-- 입력부 디자인 부분 끝 -->

            <!-- 빌드로그 시작 -->
            <table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E5E5E5">
                <tr><td align="left" height="30" bgcolor="#60A0D6">&nbsp;&nbsp;&nbsp;<font color="#FFFFFF"><b>buil.xml 로그</b></font></td></tr>
                <tr><td align="left" bgcolor="#EBF5FC"><%=KJFUtil.java2html(result) %>&nbsp;</td></tr>
            </table>
          <!-- 빌드로그 끝 -->        
         </td>
    </tr>
</table>
<!-- 테두리 끝 -->

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>    
</body>
</html>

