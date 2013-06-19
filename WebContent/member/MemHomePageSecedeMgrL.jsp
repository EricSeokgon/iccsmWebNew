<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.mem.MemParam" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%
	//초기 변수 들 선언
	MemParam pm          = (MemParam)request.getAttribute("pm");
	ReportEntity rEntity = (ReportEntity)request.getAttribute("rEntity");

	// 페이징 관련(필수)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());
	String totalCount = KJFUtil.print(pm.getTotalCount());

	int int_rnum= KJFUtil.str2int(totalCount)-(KJFUtil.str2int(nowPage) * KJFUtil.str2int(rowPerPage) - KJFUtil.str2int(rowPerPage));
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../com/js/kjs.js" type="text/javascript"></script>
<script language="javascript" src="../com/js/com.js" type="text/javascript"></script>
<script language="javascript" src="../com/js/httpRequest.js" type="text/javascript"></script>

<SCRIPT LANGUAGE="JavaScript">

// 검색
function f_search() {
	var fm = document.fmParam;
	fm.submit();
}

//회원 등록
function fn_MemUse(value) {
	var fm = document.fmParam;
	
	if (confirm("선택된 회원을 회원으로 등록 하시겠습니까?")) {
		fm.action = "MemAction.do?cmd=MemHomePageUseU";
		fm.USER_ID.value = value;
		fm.submit();
    }
}

// 회원 삭제
function fn_MemDel(value) {

	var fm = document.fmParam;
	
	if (confirm("선택된 회원을 삭제 하시겠습니까?\n 선택된 회원의 정보는 영구 삭제됩니다.")) {
		fm.action = "MemAction.do?cmd=MemHomePageMgrD";
		fm.USER_ID.value = value;
		fm.submit();
    }
}

// 탭처리
function go_tab(value) {

	var fm = document.fmParam;
	
	if (value == 1) {
		
		fm.action = "MemAction.do?cmd=MemHomePageJoinMgrL";
		fm.nowPage.value = "1";
		fm.submit();
		
	} else if(value == 2) {
		
		fm.action = "MemAction.do?cmd=MemHomePageSecedeMgrL";
		fm.nowPage.value = "1";
		fm.submit();
		
	} else if(value == 3) {
		
		fm.action = "MemAction.do?cmd=MemHomePageCompulsionMgrL";
		fm.nowPage.value = "1";
		fm.submit();
	}	
}

//시.군.구 코드 Ajax검색 처리를 한다
function fn_changeSGG_CD() {

	var fm = document.fmParam;
	
	if (fm.scSD_CD.value.trim() == "") {
		document.getElementById("layer_sggcd").innerHTML = 
			"<select name='scSGG_CD' class='input_bbs' > " +
			" 	<option value=''  selected > 시.군.구 선택 </option> " +
			" </select> ";
		
	} else {		
		var scSD_CD = fm.scSD_CD.value;

		sendRequest("../bbs/BbsAction.do", "cmd=BbsLSggCd&scSD_CD=" + scSD_CD, fn_SggCodeView, "POST");
	}
}

// 시.군.구 코드 Ajax로 검색 리스트를 화면 처리 한다. 
function fn_SggCodeView() {
	document.getElementById("layer_sggcd").innerHTML = httpRequest.responseText;
}

</SCRIPT>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<form name="fmParam" method="post"  action="MemAction.do?cmd=MemHomePageSecedeMgrL">
<INPUT type="hidden" name="mode">

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage" value="<%=nowPage%>">

<INPUT type="hidden" name="USER_ID">

<!-- 상단 타이틀 START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value=""/></jsp:include>

<!-- 상단 타이틀 END -->


<!-- 입력부 디자인 부분 START -->
<jsp:include page="../com/inc/bgBox_title_top_inc.jsp" flush="true">
			<jsp:param name="title" value="<font size=2>검<br>색</font>"/>
</jsp:include>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr> 
		<td height="5" colspan="4"></td>
 	</tr>
 	<tr> 
		<td align="left">
			<table align="center" border="0" cellspacing="0" cellpadding="10"  class="table_line">
				<tr> 
					<td>
						<table border="0" cellspacing="0" cellpadding="2"  class="table_line">
							<tr>
								<td> 
									<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scSD_CD")%>"
													 name="scSD_CD"
													 value="<%=KJFUtil.print(pm.getScSD_CD()) %>"
													 script="class='input_bbs' onchange='fn_changeSGG_CD()' "/>
									
								</td>

								<td>
									<div id="layer_sggcd" name="layer_sggcd">
									<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scSGG_CD")%>"
													 name="scSGG_CD"
													 value="<%=KJFUtil.print(pm.getScSGG_CD()) %>"
													 script="class='input_bbs' onchange='fn_search()' "/> 
									</div>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table border="0" cellspacing="0" cellpadding="2"  class="table_line">
							<tr>
								<td> 
									<select name="scMEM_GUBUN">
										<option value="">회원선택</option>
										<option value="U" <%=KJFUtil.print(pm.getScMEM_GUBUN()).equals("U")?"selected":""%>>개인회원</option>
										<option value="E" <%=KJFUtil.print(pm.getScMEM_GUBUN()).equals("E")?"selected":""%>>기업회원</option>
									</select>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table border="0" cellspacing="0" cellpadding="2"  class="table_line">
							<tr>
								<td> 
									<select name="scSLCT_GUBUN">
										<option value="ID" <%=KJFUtil.print(pm.getScSLCT_GUBUN()).equals("ID")?"selected":""%>>아이디</option>
										<option value="NM" <%=KJFUtil.print(pm.getScSLCT_GUBUN()).equals("NM")?"selected":""%>>이름</option>
									</select>
								</td>
								<td align="right">
								<input type=text name=scTEXT value="<%=KJFUtil.print(pm.getScTEXTVALUE()) %>"
											class="input_textfield2"
											entSubmit='fmParam' onkeyup ="ee_on_keyup(this)">
								</td>
								<td><input name="button2" type="image" src="../images/bt_search.gif" onClick="f_search();" value="검색"></td>
							</tr>
						</table>
					</td>
				</tr>
  			</table>			
  		</td>
	</tr>
</table>

<jsp:include page="../com/inc/bgBox_title_bottom_inc.jsp" flush="true"/>
<!-- 입력부 디자인 부분 끝 -->

<!-- ======================== TAB 디자인 부분 START ========================== -->
<table width="100%" border="0"  cellspacing="0" cellpadding="0">
	<tr>
     	<td align="left">
	        <!-- tab 시작  -->
	        <%
			String Tabcolum[] ={
								"가입회원|go_tab(1)|80",
								"탈퇴회원|go_tab(2)|sel-80",
								"강제탈퇴|go_tab(3)|80"
								};
			KJFTab tab = new KJFTab(Tabcolum);
			%>
	        <%=tab.toScript() %>
        <!-- tab 끝  -->
      	</td>
	</tr>
</table>
<!-- ======================== TAB 디자인 부분 END ============================ -->

<!-- 리스트 테이블 START -->			
<table width="100%" border="0"  cellspacing="0" cellpadding="0">
  	<tr>
	    <td width="5%" height="33"  class="listTable_header"> <strong>번호</strong></td>
		<td class="listTable_header_section"><strong>시도</strong></td>
		<td class="listTable_header_section"><strong>시군구</strong></td>
		<td class="listTable_header_section"><strong>ID</strong></td>
		<td class="listTable_header_section"><strong>성명</strong></td>
		<td class="listTable_header_section"><strong>회원종류</strong></td>
		<td class="listTable_header_section"><strong>가입일자</td>
		<td width="5%" class="listTable_header_section"><strong>사용</strong></td>
		<td width="5%" class="listTable_header_section"><strong>삭제</strong></td>
	</tr>
	
	<%for(int i = 0; i < rEntity.getRowCnt(); i++) {%>
	<tr> 
		<td class="listTable_td" align="center" height="24"><%=int_rnum--%></td>
		
		<td class="listTable_td" align="center"><%=KJFArea.getSido_Name(rEntity.getValue(i, "SIDO_CODE"))%></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i, "SIGUNGU_NM")%></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i,"USER_ID")%></td>
		<td class="listTable_td" align="center"><%=rEntity.getValue(i,"USER_NAME")%></td>	
		<td class="listTable_td" align="center"><%if ( rEntity.getValue(i, "CAPITAL").equals("U") ) out.print("개인회원"); else out.print("기업회원");%></td>	
		<td class="listTable_td" align="center"><%=KJFDate.dateOnly(KJFDate.str2date(rEntity.getValue(i,"INS_DT"),""))%></td>
		<td class="listTable_td" align="center"><a href="javascript:fn_MemUse('<%=rEntity.getValue(i,"USER_ID")%>');">
			<img src="../images/modifyicon.gif" border="0" align="absmiddle" alt="사용"></a>
		</td>
		<td class="listTable_td" align="center"><a href="javascript:fn_MemDel('<%=rEntity.getValue(i,"USER_ID")%>');">
			<img src="../images/appr_delete.gif" border="0" align="absmiddle" alt="삭제"></a>
		</td>
	</tr>
	<%}%>
		  
	<%if (rEntity.getRowCnt() == 0) {%>
	<tr> 
		<td class="listTable_td" align="center" colspan="13">등록된 회원이 없습니다.</td>
	</tr>
	<%}%>
</table>
<!-- 리스트  테이블 END -->
<br>

<!-- 페이징  테이블 START -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>		
	  	<td> 
			<!-- =========================== 페이징 START =============================== -->
			<jsp:include page="../com/inc/paging_normal.jsp" flush="true">
			  <jsp:param name="pagePerScreen" value="10"/>
			  <jsp:param name="rowPerPage"    value="<%=rowPerPage%>"/>
			  <jsp:param name="totalCount"    value="<%=totalCount%>"/>
			  <jsp:param name="nowPage"       value="<%=nowPage %>"/>
			</jsp:include>
			<!-- =========================== 페이징 START =============================== -->	
		</td>
	</tr>
</table>
<!-- 페이징  테이블 END -->

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>
</body>
</html>