<%@ page contentType="text/html;charset=utf-8"%>
<%//@ page errorPage="../com/error.jsp" %>
<%@ page import="java.net.*" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.bbs.*" %>
<%@ page import="com.fredck.FCKeditor.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	// 초기 변수 들 선언
	StatusEnt status = (StatusEnt)session.getAttribute("status");

	BbsParam pm = (BbsParam)request.getAttribute("pm");
	
	ReportEntity rEntity    = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("rEntity"));
	ReportEntity FileEntity = KJFUtil.REntPrint((ReportEntity)request.getAttribute("FileEntity"));
	
	String url_us = KJFUtil.print(request.getParameter("URL"),(String)request.getAttribute("url_us"));

	String button   = "";				// 버튼타입
	String repTitle = KJFUtil.print(request.getParameter("repTitle"));

	if (status.isWRITE()) {	// 관리자 일경우 버튼생성
	    button = "S,GL";
	} else {
	    button = "GL";
	}
	
	if (!KJFUtil.isEmpty(request.getAttribute("repTitle"))) {
		repTitle = (String)request.getAttribute("repTitle");
	}

	if (!KJFUtil.isEmpty(request.getAttribute("menuTitle"))) {
		repTitle = (String)request.getAttribute("menuTitle");
	}
	
	// 페이징 관련(필수)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());

    String CT_ID = status.getCT_ID();
    String URL   = "/bbs/BbsK.jsp";
    
	String bbsType = status.getTYPE();
	
    // 검색 조건절
    String scSD_CD		= KJFUtil.print(pm.getScSD_CD());
	String scSGG_CD     = KJFUtil.print(pm.getScSGG_CD());
    String scSLCT_GUBUN = KJFUtil.print(pm.getScSLCT_GUBUN());
    String scTEXTVALUE  = KJFUtil.print(pm.getScTEXTVALUE());

    // 신규, 수정 답변 구분
    String mode	= KJFUtil.print(request.getParameter("mode"), KJFUtil.print(request.getAttribute("mode"),"new"));    

    String cmd	="BbsKC";
    if(mode.equals("modify")) cmd="BbsKU";
    if(mode.equals("reply"))  cmd="BbsKR";

    //타이틀 표시 여부
	boolean isTitleDate = status.isTITLE_DATE_YN();
	boolean isTitleHit 	= status.isTITLE_HIT_YN();
	boolean isTitleIp 	= status.isTITLE_IP_YN();

	String maxFileUpSize = Integer.toString(status.getFILE_SIZE());

	//	추가 필드 처리
    String SUBJ_1 = "";
	String SUBJ_2 = "";
	String SUBJ_3 = "";
	String SUBJ_4 = "";
	String SUBJ_5 = "";
	String SUBJ_6 = "";
	String SUBJ_7 = "";
	String SUBJ_8 = "";
	String SUBJ_9 = "";
	String SUBJ_10 = "";

	if(!KJFUtil.isEmpty(status.getSUBJ_1())) SUBJ_1 = status.getSUBJ_1();
	if(!KJFUtil.isEmpty(status.getSUBJ_2())) SUBJ_2 = status.getSUBJ_2();
	if(!KJFUtil.isEmpty(status.getSUBJ_3())) SUBJ_3 = status.getSUBJ_3();
	if(!KJFUtil.isEmpty(status.getSUBJ_4())) SUBJ_4 = status.getSUBJ_4();
	if(!KJFUtil.isEmpty(status.getSUBJ_5())) SUBJ_5 = status.getSUBJ_5();
	if(!KJFUtil.isEmpty(status.getSUBJ_6())) SUBJ_6 = status.getSUBJ_6();
	if(!KJFUtil.isEmpty(status.getSUBJ_7())) SUBJ_7 = status.getSUBJ_7();
	if(!KJFUtil.isEmpty(status.getSUBJ_8())) SUBJ_8 = status.getSUBJ_8();
	if(!KJFUtil.isEmpty(status.getSUBJ_9())) SUBJ_9 = status.getSUBJ_9();
	if(!KJFUtil.isEmpty(status.getSUBJ_10())) SUBJ_10 = status.getSUBJ_10();

	String SIDO_CODE    = status.getSIDO_CODE();
	String SIGUNGU_CODE = status.getSIGUNGU_CODE();
	
    String USER_NAME  = status.getUSER_NAME();
    String USER_EMAIL = status.getUSER_EMAIL();
    String USER_TEL   = status.getUSER_Tel();
    String SUBJECT    = "";
    String CONTENT    = "";
    String NOTICE_YN  = "";
    String NOGUBUN  = "";
	String ETC_1 = "";	
	String ETC_2 = "";	
	String ETC_3 = "";  
	String ETC_4 = "";	
	String ETC_5 = "";	
	boolean REPLY_ENABLED	= false;
	
    if (mode.equals("modify")) {
        
        SIDO_CODE    = rEntity.getValue(0, "SIDO_CODE");	
        SIGUNGU_CODE = rEntity.getValue(0, "SIGUNGU_CODE");	
        
    	USER_NAME  = rEntity.getValue(0, "USER_NAME") ;
    	USER_EMAIL = rEntity.getValue(0, "USER_EMAIL") ;
    	USER_TEL   = rEntity.getValue(0, "USER_TEL") ;

    	SUBJECT    = rEntity.getValue(0, "SUBJECT") ;
    	CONTENT    = rEntity.getValue(0, "CONTENT") ;
    	NOTICE_YN  = rEntity.getValue(0, "NOTICE_YN") ;    	
    }

    if (mode.equals("reply")) {
    	SUBJECT = "RE :" + rEntity.getValue(0,"SUBJECT");
    	REPLY_ENABLED = true;
    }
%>

<SCRIPT LANGUAGE="JavaScript">
<!--

/***************************************************************************
* Title   : 저장 
* Content : 작성된 게시글을 저장 처리한다.  
****************************************************************************/
function fn_save(cmd) {
    var fm = document.fmWrite;

    fm.action = "../bbs/BbsAction.do?cmd=<%=cmd%>";
    
	<%if (status.getATT_NUM() > 0) { // 파일 첨부 갯수가 0개 이상이면  나타낸다.  %>
    		fm.encoding  ="multipart/form-data";
	<%}%>
	
    kjsSubmit('fmWrite');
}

/***************************************************************************
* Title   : 목록 
* Content : 리스트 목록으로 처리한다.
****************************************************************************/
function fn_list() {
    var fm = document.fmWrite;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKList";
	
	<%if (status.getATT_NUM() > 0) { // 파일 첨부 갯수가 0개 이상이면  나타낸다.  %>
    	fm.encoding  ="multipart/form-data";
	<%}%>
    
    fm.submit();
}

/***************************************************************************
* Title   : 첨부파일 
* Content : 첨부된 파일을 삭제 처리한다.   
****************************************************************************/
function fn_att_del(SYS_FILE_NAME) {
    var fm= document.fmWrite;

    fm.SYS_FILE_NAME.value = SYS_FILE_NAME;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKFileDel";
	
	<%if( status.getATT_NUM() > 0 ){ //파일 첨부 갯수가 0개 이상이면  나타낸다.  %>
    	fm.encoding  ="multipart/form-data";
 	<%}%>
 	
 	if (confirm("선택한 파일을 삭제하시겠습니까?")) {
    	fm.method = "post";
    	fm.submit();
    }
}

//파일 첨부할때 필드 추가 제거 하는 스크립트 시작
var rowIndex = 1;

/***************************************************************************
* Title   : 피일 입력폼 추가  
* Content : 첨부파일 입력폼을  추가 처리한다.   
****************************************************************************/
function addFile(form, max, k) {
	if (rowIndex > (max - k)) return false;

	var oCurrentRow, oCurrentCell;
	var sAddingHtml;

	oCurrentRow  = attachFile.insertRow();
	rowIndex     = oCurrentRow.rowIndex;
	oCurrentCell = oCurrentRow.insertCell();

	oCurrentCell.innerHTML = "<tr><td>&nbsp;&nbsp;<input type='file' class='input_bbs' name='BBS_FILE[" + rowIndex + "]' size='50' ></td></tr>";

	rowIndex++;

	form.fileCnt.value = rowIndex;
}

/***************************************************************************
* Title   : 파일 입력폼 빼기  
* Content : 첨부파일 입력폼을 삭제 처리한다.   
****************************************************************************/
function deleteFile(form) {
	if (rowIndex < 2) {
		return false;
	} else {
		form.fileCnt.value = form.fileCnt.value - 1;
		rowIndex--;
		attachFile.deleteRow(rowIndex);
	}
}
//파일 첨부할때 필드 추가 제거 하는 스크립트 끝


/***************************************************************************
* Title   : 시.군.구 코드를 검색한다   
* Content : 시.군.구 코드 Ajax검색 처리를 한다. 
****************************************************************************/
function fn_changeSGG_CD() {

	var fm = document.fmWrite;
	
	if (fm.SIDO_CODE.value == "") {
		document.getElementById("layer_sggcd").innerHTML = 
			"<select name='SIGUNGU_CODE' class='input_bbs' > " +
			" 	<option value=''  selected > 시.군.구 선택 </option> " +
			" </select> ";
		
	} else {		
		var SD_CD = fm.SIDO_CODE.value;

		sendRequest("../bbs/BbsAction.do", "cmd=BbsWSggCd&scSD_CD=" + SD_CD, fn_SggCodeView, "POST");
	}
}

/***************************************************************************
* Title   : 시.군.구 코드 화면 처리 화면
* Content : 시.군.구 코드 Ajax로 검색 리스트를 화면 처리 한다. 
****************************************************************************/
function fn_SggCodeView() {
	document.getElementById("layer_sggcd").innerHTML = httpRequest.responseText;
}

//-->
</SCRIPT>


<!-- 타이틀이 이보다 외부에 있어서 타이틀 값 전송 안됨 -->
<form name="fmWrite" method="post" >

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage"    value="<%=nowPage%>">
<input type=hidden name="rowPerPage" value="<%=rowPerPage%>">

<!-- 게시판 기본 정보-->
<input type=hidden name="URL"      value="<%=URL%>">
<input type=hidden name="CT_ID"    value="<%=CT_ID%>">
<input type=hidden name="repTitle" value="<%=repTitle%>">

<!-- 신규, 수정 답변 구분-->
<input type=hidden name="mode" value="<%=mode%>">

<input type=hidden name="BOARD_SEQ" value="<%=rEntity.getValue(0,"BOARD_SEQ") %>">
<input type=hidden name="INDEX1"    value="<%=rEntity.getValue(0,"INDEX1") %>">
<input type=hidden name="INDEX2"    value="<%=rEntity.getValue(0,"INDEX2") %>">
<input type=hidden name="DEPTH"     value="<%=rEntity.getValue(0,"DEPTH") %>">

<!-- 첨부파일 삭제용-->
<input type=hidden name="SYS_FILE_NAME">

<!-- 검색 조건절-->
<input type=hidden name="scSLCT_GUBUN" value="<%=scSLCT_GUBUN%>">
<input type=hidden name="scTEXTVALUE"  value="<%=scTEXTVALUE%>">
<input type=hidden name="scSD_CD"      value="<%=scSD_CD%>">
<input type=hidden name="scSGG_CD"     value="<%=scSGG_CD%>">

<!-- ============================ 상단 타이틀 START ========================== -->
	<% if ("/bbs/BbsK.jsp".equals(url_us) && !"BbsKView".equals(cmd)) {%>

	<jsp:include page="../com/inc/title_inc.jsp" flush="true">
		<jsp:param name="repTitle"   value="<%=repTitle%>"/>
		<jsp:param name="ButtonType" value="<%=button%>"/>
	</jsp:include>

	<br>
	<%}%>
<!-- ============================ 상단 타이틀 END ============================ -->


<!-- ============================ 게시판 스킨 START ========================== -->

	<!-- 일반 게시판  -->
	<% if(bbsType.equals("general_basic")) { %>
	<jsp:directive.include file="skin/general_basic/write.jsp" />

	<!-- FAQ 게시판  -->
	<% } else if(bbsType.equals("faq_basic")) { %>
	<jsp:directive.include file="skin/faq_basic/write.jsp" />

	<!-- QNA 게시판 -->
	<% } else if(bbsType.equals("qna_basic")) { %>
	<jsp:directive.include file="skin/qna_basic/write.jsp" />

	<!-- 자료실 게시판  -->
	<% } else if(bbsType.equals("morgue_basic")) { %>
	<jsp:directive.include file="skin/morgue_basic/write.jsp" />
	<% } %>

<!-- ============================ 게시판 스킨 END ============================ -->

</form>
