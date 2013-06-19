<%--
*************************************************************************************************
* 파  일  명 : BbsCtrlW.jsp
* 설      명 : 게시판 등록화면
*
* 이력사항 :
* 2006/07/05  오두식  최초작성
*************************************************************************************************
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//KO" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.bbs.BbsParam" %>
<%@ page import="sp.bbs.BbsParam" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>


<%

	//초기 변수 들 선언
	BbsParam pm				= (BbsParam)request.getAttribute("pm");
	ReportEntity rEntity 	= (ReportEntity)request.getAttribute("rEntity");

	//페이징 관련(필수)
	String nowPage          = KJFUtil.print(pm.getNowPage());
	String rowPerPage       = KJFUtil.print(pm.getRowPerPage());
	String totalCount      	 = KJFUtil.print(pm.getTotalCount());

	String CT_ID 			= rEntity.getValue(0,"CT_ID");
	String BOARD_NAME 		= rEntity.getValue(0,"BOARD_NAME");
	String TYPE 			= rEntity.getValue(0,"BOARD_TYPE");
	String LOGIN_YN 		= rEntity.getValue(0,"LOGIN_YN");
	String WRITE_YN 		= rEntity.getValue(0,"WRITE_YN");
	String ATTACH_YN 		= rEntity.getValue(0,"ATTACH_YN");
	String REPLY_YN 		= rEntity.getValue(0,"REPLY_YN");
	String ONE_LINE_YN 		= rEntity.getValue(0,"ONE_LINE_YN");
	String USE_YN 			= rEntity.getValue(0,"USE_YN");
	String UPD_DT 			= rEntity.getValue(0,"UPD_DT");
	String REG_ID 			= rEntity.getValue(0,"REG_ID");
	String INS_DT 			= rEntity.getValue(0,"INS_DT");


%>

<html>
<head>
<link href="../com/css/Style.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>


<SCRIPT LANGUAGE="JavaScript">
<!--
// 취소
function f_cancel( ) {

	var fm = document.fmParam;

    fm.cmd.value="BbsCtrlMgr";
    fm.method = "post";
    fm.submit();
}

// 수정
function f_modify( ) {

	var fm = document.fmParam;

    fm.cmd.value="BbsCtrlW";
    fm.mode.value="M";
    fm.method = "post";
    fm.submit();
}

//-->
</SCRIPT>


</head>

<body leftmargin="0" marginwidth="0" marginheight="0">
<form name=fmParam method="post" action="../bbs/BbsAction.do"  >
<!-- CUD 모드-->
<input type=hidden name="cmd">
<input type=hidden name="mode">
<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage"       value="<%=nowPage%>">
<input type=hidden name="rowPerPage"    value="<%=rowPerPage%>">

<!-- 검색 조건절-->
<input type=hidden name="scTYPE"        value="<%=KJFUtil.print(pm.getScTYPE())%>">
<input type=hidden name="scBOARD_NAME"  value="<%=KJFUtil.print(pm.getScBOARD_NAME()) %>">

<input type=hidden name="CT_ID" 		value="<%=CT_ID%>">


<!-- 타이틀 시작-->
<jsp:include page="../com/title_inc_admin.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
</jsp:include>
<!-- 타이틀 끝 -->


<!-- 테두리 시작 -->
<table width="95%" align="center"  border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td>
			** 게시판 설정 보기 **
            <br>
			<br>
            <!-- 입력 시작 -->
            <table width="100%" border="1"  cellspacing="0" cellpadding="1"  class="table_line">
                <tr>
                    <td class="table_header_center"  width="20%" >보드 ID </td>
                    <td class="table_header_bright" width="30%"><%=CT_ID%></td>
                    <td width="50%" class="table_header_bright" >&nbsp;</td>
                </tr>
                <tr >
                  <td class="table_header_center">보드명</td>
                  <td class="table_header_bright"><%=BOARD_NAME%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
                <tr >
                    <td class="table_header_center">보드 Type</td>
                    <td class="table_header_bright"><%=TYPE%></td>
                    <td class="table_header_bright">&nbsp;</td>
                </tr>
				<tr >
                  <td class="table_header_center">로그인 유무</td>
                  <td class="table_header_bright"><%=LOGIN_YN%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
				<tr >
                  <td class="table_header_center">파일첨부 유무</td>
                  <td class="table_header_bright"><%=ATTACH_YN%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
				<tr >
                  <td class="table_header_center">답변 유무</td>
                  <td class="table_header_bright"><%=REPLY_YN%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
				<tr >
                  <td class="table_header_center">한줄 답변 유무(코멘트) </td>
                  <td class="table_header_bright"><%=ONE_LINE_YN%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
				<tr >
                  <td class="table_header_center">사용 유무</td>
                  <td class="table_header_bright"><%=USE_YN%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
                <tr >
                  <td class="table_header_center">생성자</td>
                  <td class="table_header_bright"><%=REG_ID%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
                <tr >
                  <td class="table_header_center">생성일</td>
                  <td class="table_header_bright"><%=INS_DT%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
                <tr >
                  <td class="table_header_center">수정일</td>
                  <td class="table_header_bright"><%=UPD_DT%></td>
                  <td class="table_header_bright">&nbsp;</td>
                </tr>
            </table>
            <!-- 입력 끝 -->

            <!-- 버튼부 시작 -->
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="5" colspan="2"></td>
                </tr>
                <tr>
                     <td align="left">
                    	<input type="button" value="취소" onclick="javascript:f_cancel( );">
                    </td>
                    <td align="right">
                    	<input type="button" value="수정" onclick="javascript:f_modify( );">
                    </td>
                </tr>

            </table>
        </td>
    </tr>
</table>
<!-- 테두리 끝 -->

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>
</body>
</html>