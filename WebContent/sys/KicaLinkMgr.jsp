<%--
*************************************************************************************************
* 파  일  명 : KicaLinkMgr.jsp
* 설      명 : 협회데이타연계관리
* 
* 이력사항 :
* 2009/04/220  김경덕  최초작성
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
	// 초기 변수 들 선언
	SysParam pm = (SysParam)request.getAttribute("pm");
	ReportEntity rEntity = (ReportEntity)request.getAttribute("rEntity");  
	String bt = KJFUtil.print((String)request.getAttribute("bt"));
	String isSearch="";
	String mode   = KJFUtil.print((String)request.getAttribute("mode"),"run");
	
	// 페이징 관련(필수)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());
	String totalCount = KJFUtil.print(pm.getTotalCount());		
%>

<html>
<head>
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
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


function fn_run(mode){
	var fm = document.fmParam;

	fm.mode.value=mode;
	fm.submit();
}


//-->
</SCRIPT>
</head>

<body leftmargin="0" marginwidth="0" marginheight="0">
<form name="fmParam" method="post" action="../sys/SysAction.do?cmd=KicaLinkMgr" >

<!-- 페이징 관련(필수)-->       
<input type=hidden name="nowPage"         value="<%=nowPage%>">

<input type="hidden" name="mode" value="<%=mode%>">


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
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#E5E5E5">
							<tr><td align="left" height="30" bgcolor="#60A0D6" colspan="2">&nbsp;&nbsp;&nbsp;<font color="#FFFFFF"><b>스케쥴러 시스템 상태</b></font></td></tr>
							<tr>
								<td  align="right" bgcolor="#EBF5FC" height="70" width="50%">
									<%
									if(bt.equals("bt_start")){
										out.println("<font color=#60a0d6><b>스케쥴러가 <font color=#003399>중지</font> 되었습니다.</b></font>");
									}else{
										out.println("<font color=#60a0d6><b>스케쥴러가 <font color=#003399>실행</font> 중입니다.</b></font>");
									}
									%>
								</td>
								<td align="left" bgcolor="#EBF5FC">							
								&nbsp;&nbsp;&nbsp;<img src="../images/<%=bt %>.gif"  onClick="javascript:fn_run('run');" border="0" style="cursor:hand">
									
								</td>
							</tr>
						</table>					
					</td>
				</tr>			
			</table>
			<!-- 입력부 디자인 부분 끝 -->
			</br>
 
 
<!-- ======================= 검색 테이블 START =============================== -->
<table width="100%" border="0" cellspacing="0" cellpadding="1" class="table_line">
	<tr>
		<td align="right">
			<table border="0"  cellspacing="0" cellpadding="1"  class="table_line">
				<tr>
					<td class="searchTable_td"   >						
			          <select name="scERR_YN" class='input_combobox2' >
			            <option value=""  <%=KJFUtil.print(pm.getScERR_YN()).equals("")?"Selected":"" %> >전체</option>
			            <option value="Y"  <%=KJFUtil.print(pm.getScERR_YN()).equals("Y")?"Selected":"" %> >오류</option> 
			            <option value="N"  <%=KJFUtil.print(pm.getScERR_YN()).equals("N")?"Selected":"" %> >성공</option> 
			          </select>						
					</td>
					<td class="searchTable_td">
						<input type=text name=scTABLE_NAME value="<%=KJFUtil.print(pm.getScTABLE_NAME()) %>" class="input_textfield">
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
		<td  class="listTable_header" width="40">SEQ</td>
		<td  class="listTable_header_section" width="40">Up/Down</td>
		<td  class="listTable_header_section"  width="120">테이블명</td>
		<td  class="listTable_header_section" >로그</td>
		<td  class="listTable_header_section" width="50">에러여부</td>
		<td  class="listTable_header_section" width="120">실행시간</td>
	</tr>

	<% if (rEntity != null) { %>
		<% for (int i = 0; i < rEntity.getRowCnt(); i++ ) { %>
	
	<tr> 
		<td class="listTable_td" align="center">
			<%=rEntity.getValue(i,"SEQ")%></td>
		<td class="listTable_td" align="center"> 
			<%=rEntity.getValue(i,"U_D_FLAG")%></td>
		<td class="listTable_td"> 
			<%=rEntity.getValue(i,"TABLE_NAME")%>&nbsp;</td>
		<td class="listTable_td" Title='<%=rEntity.getValue(i,"LOG").replaceAll("'","")%>'> 
			<%=KJFUtil.getTitleLimit(rEntity.getValue(i,"LOG").replaceAll("'",""),46)%>&nbsp;</td>
		<td class="listTable_td" align="center"> 
			<%=KJFUtil.print(rEntity.getValue(i,"ERR_YN")).equals("Y")?"오류":""%>&nbsp;</td>													
		<td class="listTable_td" align="center"> 
			<%=rEntity.getValue(i,"INS_DT")%></td>									
	</tr>
		<% } %>
    <% }%>
	
    <% if (rEntity==null || rEntity.getRowCnt()==0) {%>
	<tr>
		<td class="listTable_td" align="center" colspan="6">등록된 자료가 없습니다.</td>
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
         </td>
    </tr>
</table>
<!-- 테두리 끝 -->



</form>    
</body>
</html>

