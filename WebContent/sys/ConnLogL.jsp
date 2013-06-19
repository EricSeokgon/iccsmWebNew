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

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad=""> 
<form name=fmParam method="post" action="../sys/SysAction.do?cmd=ConnLogL">
<input type="hidden" name="LOG_NUM">

<!-- CUD 모드-->  
<INPUT type="hidden" name="cmd"  value="ConnLogL">
<INPUT type="hidden" name="mode" value="">

<!-- 페이징 관련(필수)-->       
<input type=hidden name="nowPage" value="<%=nowPage%>">

<!-- 검색창 상태 처리(필수)-->   
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">

<!-- 상단 타이틀 START -->
<jsp:include page="../../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value=""/></jsp:include>
<!-- 상단 타이틀 END -->           


<!-- 리스트 테이블 START -->
<jsp:include page="../../com/inc/noBox_top_inc.jsp" flush="true"/>

<table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">                
	<tr>
		<td colspan="2" align="right">
			<table border="0" cellspacing="0" cellpadding="3">
				<tr align="left" height="28">
					<td>
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
					<td>&nbsp;</td>
				  	<td>
				  		<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scUSER_CODE")%>" 
										 name="scUSER_CODE"
										 value="<%=KJFUtil.print(pm.getScUSER_CODE())%>"
									 	 script="class='input_combobox' style='width:100' "/>
					</td>
					<td><img src="../images/bt_search.gif" alt="검색" onclick='fn_search();' border="0"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<!-- 리스트 테이블 시작-->
<table width="100%" border="0"  cellspacing="0" cellpadding="0"  class="listTable">
	<tr>
  		<td class="listTable_header" width="7%">번호</td>
        <td class="listTable_header_section" width="15%">ID</td>
        <td class="listTable_header_section" width="20%">접속시간</td>
        <td class="listTable_header_section" width="20%">종료시간</td>
		<td class="listTable_header_section" width="15%">접속IP</td>		
		<td class="listTable_header_section">BROWSER</td>
    </tr>

	<%
    if (rEntity != null) {
        for (int i = 0; i < rEntity.getRowCnt(); i++) {
	%>
				
	<tr align="center">
		<td class="listTable_td">
			<%=KJFUtil.print(rEntity.getValue(i,"LOG_NUM"), "&nbsp;")%></td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i,"USER_ID"), "&nbsp;")%></td>		
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i,"ACCESS_TIME"), "&nbsp;")%></td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i,"END_TIME"), "&nbsp;")%></td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i,"ACCESS_IP"), "&nbsp;")%></td>
		<td class="listTable_td"><%=KJFUtil.print(rEntity.getValue(i,"BROWSER"), "&nbsp;")%></td>
	</tr>

	<%
        }
    }
	
    if (rEntity == null || rEntity.getRowCnt()==0){

	%>
     <tr>
         <td class="listTable_td" align="center" colspan="6">등록된 자료가 없습니다.</td>
     </tr>
	<%}%>   
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
