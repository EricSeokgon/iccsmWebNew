<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.rch.RchParam" %>
<%@ page import="sp.uent.UserEnt" %>

<%

	//초기 변수 들 선언
	RchParam pm = (RchParam)request.getAttribute("pm");

	ReportEntity rEntity = (ReportEntity)request.getAttribute("rEntity");
	
	String CT_ID = request.getParameter("CT_ID");

	//페이징 관련(필수)
	String nowPage      = KJFUtil.print(pm.getNowPage());
	String rowPerPage   = KJFUtil.print(pm.getRowPerPage());
	String totalCount   = KJFUtil.print(pm.getTotalCount());	
	
	int int_rnum = KJFUtil.str2int(totalCount)-(KJFUtil.str2int(nowPage) *KJFUtil.str2int(rowPerPage) - KJFUtil.str2int(rowPerPage));
	
	UserEnt user = (UserEnt)session.getAttribute("user");
	
	boolean isAdmin = user.isAdmin();
	
	String funcBtn = "";
	
	if (isAdmin && !CT_ID.equals("ALL")) {
		funcBtn = "N";
	}

%>
<html>

<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>설문조사 관리</title>

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
	function detail(rid) {
		var fm = document.fmParam;
		fm.cmd.value = "RchV";
		fm.RID.value=rid;
		fm.submit();
	}

	function fn_new() {
		var fm = document.fmParam;
		
		fm.cmd.value = "RchC";
		fm.submit();
	}

	function search() {
		var fm = document.fmParam;
		fm.nowPage.value=1;
		fm.submit();
	}

/////////////////////////////페이지 이동 스크립트////////////////////////////
function movePage(page){
    var fm= document.fmParam;

    fm.nowPage.value= page;
    //fm.method = "post";
    fm.submit();
}

function changeRowPerPage(obj){
    var fm= document.fmParam;

    fm.rowPerPage.value= obj.value;
    fm.nowPage.value="1";
    //fm.method = "post";
    fm.submit();
}
/////////////////////////////페이지 이동 스크립트////////////////////////////



// 탭관련 스크립트 
function go_tab(value){
	if (value == 1) {
		location.href="../rch/RchMgrAction.do?cmd=RchL&CT_ID=<%=CT_ID%>&titPgId=<%=request.getParameter("titPgId")%>";
	} else if(value == 2) {
		location.href="../rch/RchMgrAction.do?cmd=RchRL&CT_ID=<%=CT_ID%>&titPgId=<%=request.getParameter("titPgId")%>";
	} else if(value == 3) {
		location.href="../rch/RchMgrAction.do?cmd=RchEL&CT_ID=<%=CT_ID%>&titPgId=<%=request.getParameter("titPgId")%>";
	}
}

//-->
</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name=fmParam method="post" action="../rch/RchMgrAction.do"  >

<!-- CUD 모드-->
<input type=hidden name="cmd"  value="RchRL">
<input type=hidden name="mode" value="">
<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage"  value="<%=nowPage%>">


<input type=hidden name="RID">
<input type=hidden name="CT_ID" value="<%=CT_ID%>">

<!-- 타이틀 정보-->
<input type="hidden"  name="titPgId"    value="<%= KJFUtil.print(request.getParameter("titPgId")) %>" >
<input type="hidden"  name="titPgGrId"  value="<%= KJFUtil.print(request.getParameter("titPgGrId")) %>" >

<!-- 상단 타이틀 START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value="<%=funcBtn%>"/></jsp:include>
<!-- 상단 타이틀 END -->


<!-- 리스트 테이블 START -->
<jsp:include page="../com/inc/noBox_top_inc.jsp" flush="true"/>
<table width="100%" border="0"  cellspacing="0" cellpadding="0">
	<tr>
		<td align="left">
		  		<!-- tab 시작  -->      
		<%
			String Tabcolum[] ={								
					            "진행|go_tab(1)|80",
					            "준비|go_tab(2)|sel-80", 
					            "종료|go_tab(3)|80"
								};
			KJFTab tab = new KJFTab(Tabcolum);	
		%>
				<%=tab.toScript() %>        
		        <!-- tab 끝  -->  				
		</td>
	</tr>
</table>

<!-- 준비중 설문조사   START -->
<table width="100%" border="0"  cellspacing="0" cellpadding="3">
   <tr>
		<td  class="listTable_header" width="40">번호</td>
		<td  class="listTable_header_section">설문조사 제목</td>
		<td  class="listTable_header_section" width="70">작성자</td>
		<td  class="listTable_header_section" width="140">조사 기간</td>
		<td  class="listTable_header_section" width="70">참여자수</td>
		<td  class="listTable_header_section" width="70">상태</td>
	</tr>
<%
	for (int i=0; i < rEntity.getRowCnt(); i++ ){
%>
	<tr>
		<td align="center" class="listTable_td"><%=int_rnum--%></td>
		<td class="listTable_td"><a href="javascript:detail(<%=rEntity.getValue(i,"RID")%>)"><%=rEntity.getValue(i,"TITLE")%></a></td>
		<td align="center" class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i, "USER_NAME"), "&nbsp;")%></td>
		<td align="center" class="listTable_td"><%=rEntity.getValue(i,"S_DATE")%> ~ <%=rEntity.getValue(i,"E_DATE")%></td>
		<td align="center" class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i, "CNT"),"0")%></td>
		<td align="center" class="listTable_td">준비중</td>
	</tr>
<%}
	if( rEntity.getRowCnt() == 0) {
%>
	<tr>
		<td class="listTable_td" colspan="9" align="center">준비중인  설문조사가 없습니다.</td>
	</tr>
<%}%>
</table>
<!-- 준비중 설문조사  END -->


<jsp:include page="../com/inc/noBox_bottom_inc.jsp" flush="true"/>
<!-- 리스트  테이블 END-->

<!-- 페이징 START -->
			<jsp:include page="../com/inc/paging.jsp" flush="true">
				<jsp:param name="pagePerScreen" value="10"/>
				<jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
				<jsp:param name="totalCount" value="<%=totalCount%>"/>
				<jsp:param name="nowPage"    value="<%=nowPage %>"/>
			</jsp:include>
			<!-- 페이징 END -->

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>
</body>
</html>