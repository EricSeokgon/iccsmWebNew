<%--
*************************************************************************************************
* 파  일  명 : PgGrMgr.jsp
* 설      명 : 프로그램 등록화면
*
* 이력사항 :
* 2006/05/29  김경덕  최초작성
* 2006/10/02  양석환  공무원연수원 디자인적용
*************************************************************************************************
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.sys.SysParam" %>
<%@ page import="sp.uent.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>


<%
	//초기 변수 들 선언
	SysParam pm=(SysParam)request.getAttribute("pm");
	Vector v_menuEntList = (Vector)request.getAttribute("v_menuEntList");

	//필수 변수 (검색창 상태)
//	String isSearch   = KJFUtil.print(pm.getIsSearch());
	String isSearch   = "";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<!-- 공퉁 부분 -->

<script language="JavaScript">
<!--
// 신규 등록 폼 초기화
function fn_new() {
	var fm = document.fmParam;

    fm.PG_GROUP_ID.value = "";
    fm.P_PG_GROUP_ID.value = "0";
    fm.GROUP_NAME.value = "";
    fm.PG_GROUP_URL.value = "";
    fm.ORDER_SEQ.value = "";
    fm.USE_YN.value = "Y";

    fm.mode.value="C";
    fm.GROUP_NAME.focus();
}

// 추가
function fn_add(PG_GROUP_ID) {

	var fm = document.fmParam;

    fm.PG_GROUP_ID.value = "";
    fm.P_PG_GROUP_ID.value = PG_GROUP_ID;
    fm.GROUP_NAME.value = "";
    fm.PG_GROUP_URL.value = "";
    fm.ORDER_SEQ.value = "";
    fm.USE_YN.value = "Y";

    fm.mode.value="C";
    fm.GROUP_NAME.focus();
}

// 수정
function fn_modify(   PG_GROUP_ID,
                            P_PG_GROUP_ID,
                            GROUP_NAME,
                            PG_GROUP_URL,
                            ORDER_SEQ,
                            USE_YN
                            ) {

 	var fm = document.fmParam;

    fm.PG_GROUP_ID.value = PG_GROUP_ID;
    fm.P_PG_GROUP_ID.value = P_PG_GROUP_ID;
    fm.GROUP_NAME.value = GROUP_NAME;
    fm.PG_GROUP_URL.value = PG_GROUP_URL;
    fm.ORDER_SEQ.value = ORDER_SEQ;
    fm.USE_YN.value = USE_YN;

    fm.mode.value="U";
    fm.GROUP_NAME.focus();

}

// 내용 저장
function fn_save(){
	var fm = document.fmParam;

	fm.cmd.value="PgGrMgrCUD";
    kjsSubmit("fmParam");
}

// 선택 삭제
function fn_delete(PG_GROUP_ID) {
	var fm = document.fmParam;

    if (!confirm(" 하위의 모든 프로그램들도 삭제 됩니다.")){
        return;
    }

    if (!confirm(" 삭제 하시겠습니까? ")){
        return;
    }
    fm.PG_GROUP_ID.value = PG_GROUP_ID;
    fm.mode.value="D";
    fm.submit();
}



// 검색 창 처리
function fn_search(){
	var fm = document.fmParam;

	fm.isSearch.value = "show";
	fm.cmd.value="PgGrMgr";
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





function beforeKjs(){
	var fm = document.fmParam;

	fm.cmd.value = "PgGrMgrCUD";
	return true;
}

//-->
</script>


</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="fmParam" method="post" action="SysAction.do" >
<!-- CUD 모드-->
<input type="hidden" name="cmd"  value="PgGrMgrCUD">
<input type="hidden" name="mode" value="C">
<!-- 검색창 상태 처리(필수)-->
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">


<input type="hidden" name="PG_GROUP_ID" >

<!-- 타이틀 시작-->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value="N,S,D"/>
</jsp:include>
<!-- 타이틀 끝 -->

<!-- 입력부 디자인 부분 START -->
<jsp:include page="../com/inc/bgBox_title_top_inc.jsp" flush="true">
			<jsp:param name="title" value="<font size=2>입<br>력</font>"/>
</jsp:include>

<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="listTable">
	<tr>
		<td class="listTable_header">상위그룹</td>
		<td class="listTable_header_section">메뉴그룹명</td>
		<td class="listTable_header_section" >경로</td>
		<td class="listTable_header_section">정렬순서</td>
		<td class="listTable_header_section">사용유무</td>
	</tr>
	<tr>
		<td class="inputTable_td" align="center">
			<KTags:KJFSelect	item='<%=(Vector)request.getAttribute("v_p_group_id")%>'
								name="P_PG_GROUP_ID"
								value=""
								script="class='input_combobox'"/>
		</td>
		<td class="inputTable_td" align="center"><input type="text" name="GROUP_NAME"   value="" class="input" required maxlength="100"></td>
		<td class="inputTable_td" align="center"><input type="text" name="PG_GROUP_URL" value="" class="input" maxlength="100"></td>
		<td class="inputTable_td" align="center"><input type="text" name="ORDER_SEQ"    value="" class="input" required number onkeyup="ee_on_keyup(this)" ></td>
		<td class="inputTable_td" align="center">
			<SELECT NAME="USE_YN" class="input_combobox" style="width:40px">
				<option value="Y">Y</option>
				<option value="N">N</option>
			</SELECT>
		</td>
	</tr>
</table>

<jsp:include page="../com/inc/bgBox_title_bottom_inc.jsp" flush="true"/>
<!-- 입력부 디자인 부분 끝 -->



<!-- 리스트 테이블 START -->
<jsp:include page="../com/inc/noBox_top_inc.jsp" flush="true"/>
<table width="100%" border="0"  cellspacing="0" cellpadding="0" class="listTable" style="table-layout:fixed;" nowrap>
  <tr >
		<td  class="listTable_header" width="7%">코드</td>
		<td  class="listTable_header_section" width="20%">메뉴그룹명</td>
		<td  class="listTable_header_section" nowrap>URL</td>
		<td  class="listTable_header_section" width="10%">사용유무</td>
		<td  class="listTable_header_section" width="7%">정렬</td>
		<td  class="listTable_header_section" width="15%">하위그룹추가</td>
		<td  class="listTable_header_section" width="7%">수정</td>
		<td  class="listTable_header_section" width="7%">삭제</td>
	</tr>
<%
	if (v_menuEntList!=null  ){
		int cnt = v_menuEntList.size();
		for (int i = cnt-2 ; i+1 >  0  ; i--) {
			MenuEnt menuEnt = (MenuEnt)v_menuEntList.get(i);
			String del="";
			if (KJFUtil.isEmpty(menuEnt.getLOW_IDS())) {
				del =
					"<a href=javascript:fn_delete('"+menuEnt.getPG_GROUP_ID()+"');>"+
					"<img src='../images/appr_delete.gif' border='0' align='absmiddle'></a>";
			} else {
				del = "&nbsp;";
			}

%>
	<tr>
		<td class="listTable_td" align="center">
			<%=menuEnt.getPG_GROUP_ID() %></td>
		<td class="listTable_td">
			<img src="../images/board_vacant.gif" width="<%= (menuEnt.getDEPTH()-1) * 12 %>" height="2" border="0">
			<%= menuEnt.getDEPTH()==0 ? "":"<img src=\"../images/latdot.gif\"  >" %>
			<img src="../images/sch_depart.gif"><%=menuEnt.getGROUP_NAME() %></td>
		<td class="listTable_td">
			<%=KJFUtil.print(menuEnt.getPG_GROUP_URL(),"&nbsp") %></td>
		<td class="listTable_td" align="center">
			<%=menuEnt.getUSE_YN() %></td>
		<td class="listTable_td">
			<img src="../images/board_vacant.gif" width="<%= menuEnt.getDEPTH() * 10 %>" height="2" border="0"><%=menuEnt.getORDER_SEQ() %></td>
		<td class="listTable_td" align="center">
			<a href=javascript:fn_add('<%=menuEnt.getPG_GROUP_ID()%>');><img src='../images/modifyicon.gif' border='0' align='absmiddle'></a></td>
		<td class="listTable_td" align="center">
			<a href="javascript:fn_modify('<%=menuEnt.getPG_GROUP_ID() %>',
			'<%=menuEnt.getP_PG_GROUP_ID() %>',
			'<%=menuEnt.getGROUP_NAME() %>',
			'<%=menuEnt.getPG_GROUP_URL() %>',
			'<%=menuEnt.getORDER_SEQ() %>',
			'<%=menuEnt.getUSE_YN() %>'         );"><img src='../images/modifyicon.gif' border='0' align='absmiddle'></a></td>
		<td class="listTable_td" align="center"><%= del%></td>
	</tr>

<%
		}// end for (int i = cnt-1 ; i+1 >  0  ; i--)
	}// end if (v_menuEntList!=null  )
%>

</table>
<jsp:include page="../com/inc/noBox_bottom_inc.jsp" flush="true"/>
<!-- 리스트  테이블 END-->


<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>


</form>
</body>

</html>
