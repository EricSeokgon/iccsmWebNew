<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="java.io.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.hms.HmsParam" %>
<%@ page import="sp.uent.*" %>
<%@ page import="com.fredck.FCKeditor.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	// 초기 변수 들 선언
	HmsParam pm = (HmsParam)request.getAttribute("pm");

	// 신규인경우에는 초기화가 되지 않으면 error가  나기 때문에 초기화가 필요하다.
	ReportEntity rEntity    = KJFUtil.REntPrint((ReportEntity)request.getAttribute("rEntity"));
	ReportEntity hEntity    = KJFUtil.REntPrint((ReportEntity)request.getAttribute("hEntity"));
	ReportEntity hlstEntity = KJFUtil.REntPrint((ReportEntity)request.getAttribute("hlstEntity"));
	
    String mode  = KJFUtil.print(request.getParameter("mode"));
    	
	String MENU_ID = rEntity.getValue(0, "MENU_ID");	
	String L_MENU  = rEntity.getValue(0, "L_MENU");
	String M_MENU  = rEntity.getValue(0, "M_MENU");
	String S_MENU  = rEntity.getValue(0, "S_MENU");
	String TITLE   = rEntity.getValue(0, "TITLE");
	String URL	   = rEntity.getValue(0, "URL");
	String WRT_ID  = rEntity.getValue(0, "WRT_ID");
	String INS_DT  = rEntity.getValue(0, "INS_DT");
	String UDP_DT  = rEntity.getValue(0, "UPD_DT");	
	String CONTENT  = hEntity.getValue(0, "CONTENT");
	
	//필수 변수 (페이징 처리)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());
	String totalCount = KJFUtil.print(pm.getTotalCount());
	
	// 검색 필수 
    String scSLCT_GUBUN = KJFUtil.print(pm.getScSLCT_GUBUN());
    String scTEXTVALUE  = KJFUtil.print(pm.getScTEXTVALUE());
%>
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<script language="javascript" src="../com/js/httpRequest.js" type="text/javascript"></script>
<!-- 공퉁 부분 -->


<SCRIPT LANGUAGE="JavaScript">
<!--

/***************************************************************************
* Title   : 탭 처리  
* Content : 탭 처리를 한다.    
****************************************************************************/
function go_tab(value) {
	
	if (value == 1) {
		document.all['tab1'].style.display="block";
		document.all['tab2'].style.display="none";
		document.all['tab3'].style.display="none";
		
	} else if(value == 2) {
		document.all['tab1'].style.display="none";
		document.all['tab2'].style.display="block";
		document.all['tab3'].style.display="none";
		
	} else if(value == 3) {
		document.all['tab1'].style.display="none";
		document.all['tab2'].style.display="none";
		document.all['tab3'].style.display="block";
	}
}


/***************************************************************************
* Title   : 저장  
* Content : 저장 처리를 한다.    
****************************************************************************/
function fn_save() {
	var fm = document.fmParam;		

	if(beforeKjs()) {
		kjsSubmit('fmParam');
	}
	//if(isSubmit==true) loading_st("저장중 입니다.");
}


/***************************************************************************
* Title   : 입력값 체크  
* Content : 입력값 체크 처리를 한다.    
****************************************************************************/
function beforeKjs() {
	var fm = document.fmParam;
	var modeValue = fm.mode.value;

	if (fm.MENU_ID.value.trim() == "") {
		alert("메뉴 ID를 입력해 주세요");
		return false;
		
	} else if (fm.L_MENU.value.trim() == "") {
		alert("대분류를 입력해 주세요");
		return false;
		
	} else if (fm.M_MENU.value.trim() == "") {
		alert("중분류를 입력해 주세요");
		return false;
		
	} else if (fm.TITLE.value.trim() == "") {
		alert("페이지명을 입력해 주세요");
		return false;
		
	} else if (fm.URL.value.trim() == "") {
		alert("디자인 페이지를  입력해 주세요");
		return false;
	}

	if (modeValue == "M") { // 수정 상태
		fm.cmd.value = "HmsCtrlU";
		
	} else {
		fm.cmd.value = "HmsCtrlC";
	}

	return true;
}

/***************************************************************************
* Title   : 취소  
* Content : 취소 처리를 한다.    
****************************************************************************/
function fn_cancel( ) {
	var fm = document.fmParam;
		
    fm.cmd.value="HmsCtrlMgr";
    fm.submit();
}

/***************************************************************************
* Title   : 삭제
* Content : 삭제 처리를 한다.  
****************************************************************************/
function fn_delete() {

	var fm = document.fmParam;

	if(chkBoxCheck('chk')){ // 선택된 항목이 있는지 체크

		var isOK = confirm("선택된 항목을 삭제 하시겠습니까?\n삭제된 게시물은 영구히 삭제됩니다.");

		if(isOK){
			fm.action = "../hms/HmsAction.do?cmd=HmsHistoryD";
    		fm.submit();
		}
	}
}

/***************************************************************************
* Title   : 수정
* Content : 히스토리 사용유무 수정 처리를 한다.  
****************************************************************************/
function fn_updateHistory(SEQ) {
	var fm = document.fmParam;

    if (!confirm("선택된 항목을 사용 하시겠습니까?")){
        return;
    }

    fm.SEQ.value = SEQ; 
    fm.cmd.value="HmsHistoryU";
    fm.submit();
}

/***************************************************************************
* Title   : 미리보기
* Content : 히스토리 소스 미리보기 한다.  
****************************************************************************/
function fn_Preview(seq) {

	var fm = document.fmParam;

	cw = 700;
	ch = 700;
	
	// 스크린의 크기
	sw = screen.availWidth;
	sh = screen.availHeight;
	
	// 열 창의 포지션
	px = (sw-cw)/2;
	py = (sh-ch)/2;
	
	var menu_id = fm.MENU_ID.value;
	var param = "&MENU_ID=" + menu_id + "&SEQ=" + seq;
	window.open("../hms/HmsAction.do?cmd=HmsPreView" + param, "Preview", "scrollbars=no,resizable=no, width=" + cw + " , height=" + ch + ",left=" + px + ",top=" + py + "");
}

//-->
</SCRIPT>


</HEAD>
<BODY leftMargin=0 marginheight='0' marginwidth='0'>

<form name=fmParam method="post" action="../hms/HmsAction.do"  >
<!-- CUD 모드-->
<input type=hidden name="cmd">
<input type=hidden name="mode" value="<%=mode%>">

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage"    value="<%=nowPage%>">
<input type=hidden name="rowPerPage" value="<%=rowPerPage%>">

<!-- 검색 조건절-->
<input type=hidden name="scSLCT_GUBUN" value="<%=scSLCT_GUBUN%>">
<input type=hidden name="scTEXTVALUE"  value="<%=scTEXTVALUE%>">

<!-- 기타 페이지별 폼 등록 START -->
<input type="hidden" name="SEQ">
<!-- 기타 페이지별 폼 등록 END -->


<!-- ============================= 타이틀 시작 =============================== -->
 <jsp:include page="../com/inc/title_inc.jsp" flush="true">
  <jsp:param name="repTitle" value=""/>
  <jsp:param name="ButtonType" value="D,S,C"/>
 </jsp:include>
<!-- ============================= 타이틀 끝 ================================= -->

<!-- ======================== TAB 디자인 부분 START ========================== -->
<table width="100%" border="0"  cellspacing="0" cellpadding="0">
	<tr>
     	<td align="left">
	        <!-- tab 시작  -->
	        <%
			String Tabcolum[] ={
								"기본정보|go_tab(1)|sel-80",
								"HTML|go_tab(2)|80",
								"버전정보|go_tab(3)|80"
								};
			KJFTab tab = new KJFTab(Tabcolum);
			%>
	        <%=tab.toScript() %>
        <!-- tab 끝  -->
      	</td>
	</tr>
</table>
<!-- ======================== TAB 디자인 부분 END ============================ -->


<!-- ======================== [TAB1] 기본설정 START ========================= -->
<table width="100%"  border="0" cellspacing="0" cellpadding="5" class="inputTable" id="tab1">
	
	<% if(mode.equals("M")) { %>
	<tr>
      	<td class="inputTable_header_td" width="100">수정 타입 </td>
      	<td height="25" class="inputTable_td">
			<input name="CHANGE_MODE" type="radio" value="B" checked> 기본정보 수정
	      	<input name="CHANGE_MODE" type="radio" value="H"> HTML 수정
			<input name="CHANGE_MODE" type="radio" value="ALL"> 기본정보 + HTML 수정
		</td>
    </tr>
	<% } %>

	<tr>
      	<td class="inputTable_header_td" width="100">메뉴 ID </td>
      	<td height="25" class="inputTable_td">
			<input name="MENU_ID" type="text" size="10" maxlength="10" value="<%=MENU_ID%>" <%=mode.equals("M")?"readonly":""%> >
		</td>
    </tr>

	<tr>
      	<td class="inputTable_header_td" width="100">대분류 명 </td>
      	<td height="25" class="inputTable_td">
			<input name="L_MENU" type="text" size="30" maxlength="30" value="<%=L_MENU%>">
		</td>
    </tr>

	<tr>
      	<td class="inputTable_header_td" width="100">중분류 명</td>
      	<td height="25" class="inputTable_td">			
			<input name="M_MENU" type="text" size="30" maxlength="30" value="<%=M_MENU%>">
		</td>
    </tr>

	<tr>
      	<td class="inputTable_header_td" width="100">소분류 명</td>
      	<td height="25" class="inputTable_td">
			<input name="S_MENU" type="text" size="30" maxlength="30" value="<%=S_MENU%>">
		</td>
    </tr>

	<tr>
      	<td class="inputTable_header_td" width="100">페이지 명 </td>
      	<td height="25" class="inputTable_td">
			<input name="TITLE" type="text" size="40" maxlength="40" value="<%=TITLE%>">
		</td>
    </tr>

	<tr>
      	<td class="inputTable_header_td" width="100">디자인 페이지 </td>
      	<td height="25" class="inputTable_td">
			<input name="URL" type="text" size="40" maxlength="40" value="<%=URL%>">
			&nbsp;ex) /test/test.jsp
		</td>
    </tr>
</table>
<!-- ======================== [TAB1] 기본설정 END =========================== -->


<!-- ======================== [TAB2] 추가속성 START ========================= -->
<table width="100%"  border="0" cellspacing="0" cellpadding="5" class="inputTable" id="tab2" style="display:none;">
	 <% if(mode.equals("M")) { %>
	
	<tr>
      	<td class="inputTable_header_td" width="10%">버전정보</td>
      	<td width="20%" height="25" class="inputTable_td">
			<%=hEntity.getValue(0, "VERSION")%>
		</td>

		<td class="inputTable_header_td" width="10%">등록자</td>
      	<td width="20%" height="25" class="inputTable_td">
			<%=hEntity.getValue(0, "WRT_NM")%>
		</td>

		<td class="inputTable_header_td" width="10%">등록일</td>
      	<td width="20%" height="25" class="inputTable_td">
			<%=hEntity.getValue(0, "INS_DT")%>
		</td>
    </tr>

	<% } %>
	
	<tr>
      	<td colspan="6" class="inputTable_header_td" width="100">HTML</td>
	</tr>
	<tr>
      	<td colspan="6" height="25" class="inputTable_td">
			<%
				FCKeditor oFCKeditor;
				oFCKeditor = new FCKeditor( request, "EditorDefault" );
				oFCKeditor.setHeight("500");
				oFCKeditor.setBasePath( "../com/FCKeditor/" ) ;
				oFCKeditor.setToolbarSet("Bbs");
				oFCKeditor.setValue(CONTENT);
				oFCKeditor.setInstanceName("CONTENT");
				out.println( oFCKeditor.create() ) ;
			%> 
		</td>
    </tr>
	
</table>
<!-- ======================== [TAB2] 추가속성 END =========================== -->


<!-- ======================== [TAB3] 추가속성 START ========================= -->
<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="inputTable" id="tab3" style="display:none;">
	 <tr>
		<td  class="listTable_header" width="30"><a href="#" onclick="selectAll('chk')">선택</a></td>
        <td class="listTable_header_section" width="5%">번호</td>		
        <td class="listTable_header_section" width="10%">사용유무 </td>
		<td class="listTable_header_section" width="10%">버전정보</td>
        <td class="listTable_header_section" >등록자</td>
        <td class="listTable_header_section" width="20%">등록일</td>
		<td class="listTable_header_section" width="10%">소스보기 </td>
		<td class="listTable_header_section" width="10%">사용 </td>

    </tr>

	<% if(hlstEntity.getRowCnt() > 0) { %>

		<% for (int i = 0; i < hlstEntity.getRowCnt(); i++) {%>
		<tr>
			<td class="inputTable_td" align="center">
				<% if(hlstEntity.getValue(i, "USE_YN").equals("Y")) {%>
					<img src="../images/html/html_delete.gif" border="" alt="삭제불가">
				<% } else { %> 
					<input type="checkbox" name="chk" value="<%= hlstEntity.getValue(i, "SEQ") %>">
				<% } %>				
			</td>

			<td class="listTable_td" align="center"><%=hlstEntity.getRowCnt()-i%></td>

			<td class="listTable_td" align="center">
				<% if(hlstEntity.getValue(i, "USE_YN").equals("Y")) {%>
					<img src="../images/html/tick.gif" border="0">
				<% } else { %> 
					<img src="../images/html/bullet_delete.gif" border="0">
				<% } %>
			</td>

			<td class="listTable_td" align="center"><%=hlstEntity.getValue(i, "VERSION")%></td>
			<td class="listTable_td" align="center"><%=hlstEntity.getValue(i, "WRT_NM")%></td>
			<td class="listTable_td" align="center"><%=hlstEntity.getValue(i, "INS_DT")%></td>
			
			
			
			<td class="listTable_td" align="center">
				<% if(hlstEntity.getValue(i, "USE_YN").equals("N")) { %>
					<img src="../images/html/html_go.gif" alt="소스보기" border="0" 
						onClick="javascript:fn_Preview('<%=hlstEntity.getValue(i, "SEQ")%>');"
						style="cursor:hand">
				<% } else { %>
					<img src="../images/html/bullet_blue.gif" border="0">
				<% } %>
			</td>

			<td class="listTable_td" align="center">				
				<% if(hlstEntity.getValue(i, "USE_YN").equals("N")) { %>
					<img src="../images/html/html_valid.gif" alt="사용" border="0" 
						onClick="javascript:fn_updateHistory('<%=hlstEntity.getValue(i, "SEQ")%>');" 
						style="cursor:hand">
				<% } else { %>
					<img src="../images/html/bullet_blue.gif" border="0">
				<% } %>
			</td>
		</tr>	
		<% } %> 

	<% } else { %>
	<tr>
		<td class="listTable_td" align="center" colspan="8">등록된 정보가 없습니다.</td>
	</tr>
	<% } %>
	
</table>
<!-- ======================== [TAB3] 추가속성 END =========================== -->

<!-- ======================== Copyright START ============================== -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
<!-- ======================== Copyright END ================================ -->

</form>


</BODY>
</HTML>