<%@ page contentType="text/html;charset=ksc5601"%>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.sys.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%

	SysParam pm = (SysParam)request.getAttribute("pm");
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

	//필수 변수 (페이징 처리)
	String nowPage          	= KJFUtil.print(pm.getNowPage());
	String rowPerPage       	= KJFUtil.print(pm.getRowPerPage());
	String totalCount      	 	= KJFUtil.print(pm.getTotalCount());
	
	//필수 변수 (검색창 상태)
	String isSearch      	 	= KJFUtil.print(pm.getIsSearch());

	int int_rnum= KJFUtil.str2int(totalCount)-(KJFUtil.str2int(nowPage) *KJFUtil.str2int(rowPerPage) - KJFUtil.str2int(rowPerPage));
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../../com/js/kjs.js" type="text/javascript"></script>

<script>
// 신규 등록 폼 초기화
function fn_new(){

}

// 내용 저장
function fn_save(){

}

// 선택 삭제
function fn_delete(){

}

// 선택 수정
function fn_modify(val){

}

// 검색 창 처리
function fn_search(){
	var fm = document.fmParam;
	
	fm.submit();
}

// 츨력 처리
function fn_print(){
	var fm = document.fmParam;

}

// 엑셀 츨력 처리
function fn_excel(){
	var fm = document.fmParam;

}


</script>
<style type="text/css">
<!--
.style1 {font-weight: bold}
.style2 {
	color: #336699;
	font-style: italic;
	font-weight: bold;
	font-size: 12pt;
	font-family: Arial, Helvetica, sans-serif;
}
-->
</style>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad=""> 
<form name=fmParam method="post" action="../sys/SysAction.do?cmd=PgLogL">
<input type="hidden" name="LOG_NUM">
<!-- CUD 모드-->  
<INPUT type="hidden" name="cmd" value="PgLogL">
<INPUT type="hidden" name="mode" value="">
<!-- 페이징 관련(필수)-->       
<input type=hidden name="nowPage"       value="<%=nowPage%>">
<!-- 검색창 상태 처리(필수)-->   
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">


<!-- 상단 타이틀 START -->
<jsp:include page="../../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value=""/></jsp:include>
<!-- 상단 타이틀 END -->           

<!-- 입력부 디자인 부분 START -->
<jsp:include page="../../com/inc/bgBox_title_top_inc.jsp" flush="true">
			<jsp:param name="title" value="<font size=2>검<br>색</font>"/>
</jsp:include>
<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
	<tr>
 		<td class="listTable_header">기간</td>
        <td class="listTable_header_section" >프로그램명 </td>
		<td class="listTable_header_section" >작업</td>
        <td class="listTable_header_section" >사용자 </td>
        <td class="inputTable_box_td" align="center" rowspan="2"><img src="../images/bt_search.gif" onclick='fn_search();' alt="검색" border="0"></td>
	</tr>
	
	<tr>
		<td class="listTable_td" align="center">
			<input name="scSTART_DATE" type=text id="scSTART_DATE" value="<%=KJFUtil.print(pm.getScSTART_DATE())%>" size="10">
			<div id="div_start" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; " >
				<iframe src='../../com/calander.jsp?frm=fmParam&fName=scSTART_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onClick="MM_showHideLayers('div_start','','show')" align="absmiddle" style="cursor:hand" >
			~
			
			<input name="scEND_DATE" type=text id="scEND_DATE" value="<%=KJFUtil.print(pm.getScEND_DATE())%>" size="10">
			<div id="div_end" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; ">
			  <iframe src='../../com/calander.jsp?frm=fmParam&fName=scEND_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onClick="MM_showHideLayers('div_end','','show')" align="absmiddle" style="cursor:hand" >		
		</td>
		
		<td class="listTable_td" align="center">
			<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scPG_ID")%>" 
							name="scPG_ID"
							value="<%=KJFUtil.print(pm.getScPG_ID())%>"
							script="class='input_combobox' style='' "/>
		</td>
		
		<td class="listTable_td" align="center">
			<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_user_action")%>" 
							name="scCUD"
							value="<%=KJFUtil.print(pm.getScCUD())%>"
							script="class='input_combobox' style='' "/>
		</td>
		
		<td class="listTable_td" align="center">
			<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scUSER_CODE")%>" 
							name="scUSER_CODE"
							value="<%=KJFUtil.print(pm.getScUSER_CODE())%>"
							script="class='input_combobox' style='' "/>
		</td>
	</tr>
	
</table>


<jsp:include page="../../com/inc/bgBox_title_bottom_inc.jsp" flush="true"/>
<!-- 입력부 디자인 부분 END -->


<!-- 리스트 테이블 START -->
<jsp:include page="../../com/inc/noBox_top_inc.jsp" flush="true"/>

<!-- 리스트 테이블 시작-->
<table width="100%" border="0"  cellspacing="0" cellpadding="0"  class="listTable">
	<tr>
 		<td class="listTable_header" width="7%">번호</td>
        <td class="listTable_header_section" width="15%">ID</td>
        <td class="listTable_header_section" width="20%">프로그램명</td>
        <td class="listTable_header_section" width="10%">작업</td>
		<td class="listTable_header_section" width="15%">시간</td>		
		<td class="listTable_header_section" >URL</td>
	</tr>

	<%
    if (rEntity != null) {
        for (int i = 0; i < rEntity.getRowCnt(); i++) {
			String ua = rEntity.getValue(i,"USER_ACTION");
			String userAction = "";
			
			if("C".equals(ua) || "W".equals(ua)) userAction = "입력";
			else if("U".equals(ua)) userAction = "수정";
			else if("D".equals(ua)) userAction = "삭제";
			else userAction = "&nbsp;";
	%>
				
	<tr align="center">
		<td class="listTable_td">
			<%=KJFUtil.print(rEntity.getValue(i,"LOG_NUM"), "&nbsp;")%></td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i,"USER_ID"), "&nbsp;")%></td>
		<td class="listTable_td">&nbsp;<%=KJFUtil.print(rEntity.getValue(i,"PROGRAM_NAME"), "&nbsp;")%></td>
		<td class="listTable_td"><%=userAction%></td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i,"ACCESS_TIME"), "&nbsp;")%></td>		
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i,"REQ_URI"), "&nbsp;")%></td>				
	</tr>

<%
     	}//end for (int i=0;i< rEntity.getRowCnt();i++ )
    }
	
    if (rEntity == null || rEntity.getRowCnt() == 0) {

%>
    <tr>
        <td class="listTable_td" align="center" colspan="6">등록된 자료가 없습니다.</td>
    </tr>
<%  } %>   
</table>		        		        
<!-- 리스트  테이블 끝-->

<jsp:include page="../../com/inc/noBox_bottom_inc.jsp" flush="true"/>
<!-- 리스트 테이블 END -->

<!-- 페이징 START -->
<jsp:include page="../../com/inc/paging_ad.jsp" flush="true">
  <jsp:param name="pagePerScreen" value="10"/>
  <jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
  <jsp:param name="totalCount" value="<%=totalCount%>"/>
  <jsp:param name="nowPage" value="<%=nowPage %>"/>
</jsp:include>
<!-- 페이징 END -->

<!-- copyright End -->
<jsp:include page="../../com/inc/foot_inc.jsp" flush="true"/>
 
</form>
</body>
</html>
