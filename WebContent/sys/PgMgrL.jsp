<%--
*************************************************************************************************
* 파  일  명 : PgMgrL.jsp
* 설      명 : 프로그램 등록화면
*
* 이력사항 :
* 2006/09/05  양석환  최초작성(프로그램 그룹 구조 트리로 표현되도록 추가)
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
	SysParam pm =(SysParam)request.getAttribute("pm");
	ReportEntity rEntity  =(ReportEntity)request.getAttribute("rEntity");

	//페이징 관련(필수)
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

<script language="JavaScript">
<!--

function initGroupId(groupid){
	if(groupid){
		parent.document.fmParam.scP_CODE.value = groupid;
		parent.document.fmParam.PG_GROUP_ID.value = groupid;
	}
}

/////////////////////////////페이지 이동 스크립트////////////////////////////
function movePage(page){
    var fm = document.fmParam;

    fm.action = "SysAction.do?cmd=PgMgrL";
    fm.nowPage.value= page;
    fm.method = "post";
    fm.submit();
}

function changeRowPerPage(obj){
    var fm = document.fmParam;

    fm.action = "SysAction.do?cmd=PgMgrL";
    fm.rowPerPage.value= obj.value;
    fm.nowPage.value="1";
    fm.method = "post";
    fm.submit();
}
/////////////////////////////페이지 이동 스크립트////////////////////////////

// 수정
function f_modify(	PG_GROUP_ID,
					PG_ID,
					PG_NAME,
					PG_URL,
					ORDER_SEQ,
					USE_YN	)
{
 	var fm = parent.document.fmParam;

    fm.PG_GROUP_ID.value = PG_GROUP_ID;
    fm.PG_ID.value     = PG_ID;
    fm.PG_NAME.value   = PG_NAME;
    fm.PG_URL.value    = PG_URL;
    fm.ORDER_SEQ.value = ORDER_SEQ;
    fm.USE_YN.value    = USE_YN;

    fm.PG_NAME.focus();
    fm.mode.value="U";
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

//-->
</script>
</head>

<body OnLoad="initGroupId('<%=KJFUtil.print(pm.getScP_CODE())%>')">

<!-- 테두리 시작 -->
<form name="fmParam" method="post" action="SysAction.do?cmd=PgMgrCUD"  >
	<!-- CUD 모드-->
	<input type="hidden" name="cmd"  value="">
	<input type="hidden" name="mode" value="">

	<!-- 페이징 관련(필수) -->
	<input type=hidden name="nowPage"	 value="<%=nowPage%>">

	<!-- 검색 조건절 -->
	<input type=hidden name="scP_CODE"  value="<%=KJFUtil.print(pm.getScP_CODE())%>">
	<input type=hidden name="scPG_NAME" value="<%=KJFUtil.print(pm.getScP_CODE_NAME()) %>">
	<input type=hidden name="PG_ID" >


<!-- 리스트 테이블 시작-->
<jsp:include page="../com/inc/bgBox_top_inc.jsp" flush="true"/>

<table width="100%" border="0"  cellspacing="0" cellpadding="1"  class="table_line" style="table-layout:fixed;" nowrap>
    <tr>
    	<td class="listTable_header" width="30"  nowrap><span onClick="selectAll('chk')" style="cursor:hand">선택</span></td>
        <td class="listTable_header_section" width="90"  nowrap>프로그램 그룹</td>
        <td class="listTable_header_section" width="25"  nowrap>ID</td>
        <td class="listTable_header_section" nowrap>프로그램 명</td>
        <td class="listTable_header_section" width="150" nowrap>url</td>
        <td class="listTable_header_section" width="30"  nowrap>사용</td>
        <td class="listTable_header_section" width="30"  nowrap> 정렬</td>
        <td class="listTable_header_section" width="30"  nowrap>수정</td>
    </tr>
<%
if (rEntity!=null){
	for (int i=0;i< rEntity.getRowCnt();i++ ){
%>
<tr>
	<td class="listTable_td" nowrap align="center"><input type="checkbox" name="chk" value="<%=rEntity.getValue(i,"PG_ID")%>"></td>
	<td class="listTable_td" nowrap align="left"  ><%=rEntity.getValue(i,"GROUP_NAME")%>&nbsp;</td>
	<td class="listTable_td" nowrap align="left"  ><%=rEntity.getValue(i,"PG_ID")%></td>
	<td class="listTable_td" nowrap align="left"  ><%=rEntity.getValue(i,"PG_NAME")%></td>
	<td class="listTable_td" nowrap align="left"  ><%=rEntity.getValue(i,"PG_URL")%></td>
	<td class="listTable_td" nowrap align="center"><%=rEntity.getValue(i,"USE_YN")%></td>
	<td class="listTable_td" nowrap align="center"><%=rEntity.getValue(i,"ORDER_SEQ")%></td>
	<td class="listTable_td" nowrap align="center">
		<a href="javascript:f_modify(   '<%=rEntity.getValue(i,"PG_GROUP_ID")%>',
										'<%=rEntity.getValue(i,"PG_ID")%>',
										'<%=rEntity.getValue(i,"PG_NAME")%>',
										'<%=rEntity.getValue(i,"PG_URL")%>',
										'<%=rEntity.getValue(i,"ORDER_SEQ")%>',
										'<%=rEntity.getValue(i,"USE_YN")%>' );"><img src="../images/modifyicon.gif" border="0" align="absmiddle"></a>
	</td>
</tr>
<%
	}//end for (int i=0;i< rEntity.getRowCnt();i++ )
}
if (rEntity==null || rEntity.getRowCnt()==0){
%>
<tr><td class="listTable_td" align="center" colspan="8">등록된 자료가 없습니다.</td></tr>
<%  } %>
        </table>
<jsp:include page="../com/inc/bgBox_bottom_inc.jsp" flush="true"/>
<!-- 리스트  테이블 끝-->



<!-- 페이징 -->
<jsp:include page="../com/inc/paging_ad.jsp" flush="true">
<jsp:param name="pagePerScreen" value="10"/>
<jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
<jsp:param name="totalCount" value="<%=totalCount%>"/>
<jsp:param name="nowPage" value="<%=nowPage %>"/>
</jsp:include>
<br>
<!-- 테두리 끝 -->

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>
</body>
</html>