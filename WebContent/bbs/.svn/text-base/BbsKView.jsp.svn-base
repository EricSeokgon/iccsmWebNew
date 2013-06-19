<%@ page contentType="text/html;charset=utf-8"%>
<%//@ page errorPage="../com/error.jsp" %>
<%@ page import="java.net.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.bbs.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	// 초기 변수 들 선언
	StatusEnt status = (StatusEnt)session.getAttribute("status");

	BbsParam pm = (BbsParam)request.getAttribute("pm");
	
	ReportEntity  rEntity      = KJFUtil.REntPrint((ReportEntity)request.getAttribute("rEntity"));
	ReportEntity  FileEntity   = KJFUtil.REntPrint((ReportEntity)request.getAttribute("FileEntity"));
	ReportEntity  cEntity      = KJFUtil.REntPrint((ReportEntity)request.getAttribute("cEntity")); 		// 한줄답변 가져오기
	
	String url_us = KJFUtil.print(request.getParameter("URL"),(String)request.getAttribute("url_us"));
	
	String button   = "";				// 버튼타입
	String repTitle = KJFUtil.print(request.getParameter("repTitle"));

	// 관리자 , 쓰기 허용 일때만 버튼 생성
	if ( status.isADMIN() ) {
		
	    if (status.isREPLY()) {
	        button = "M,RPL,BD,GL";
	    } else {
	        button = "M,BD,GL";
	    }		
		
	} else {
		String t_user_id = KJFUtil.print(status.getUSER_ID(),"");
		
		if( t_user_id.equals(rEntity.getValue(0,"USER_ID")) ) {
	    //if( status.getUSER_ID().equals(rEntity.getValue(0,"USER_ID")) ) {
	        button = "M,BD,GL";
	    } else {
	        button = "GL";
	    }	   
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
    String URL	= "/bbs/BbsK.jsp";
    
	String bbsType = status.getTYPE();
	
	String scSD_CD		= KJFUtil.print(pm.getScSD_CD());
	String scSGG_CD     = KJFUtil.print(pm.getScSGG_CD());
    String scSLCT_GUBUN = KJFUtil.print(pm.getScSLCT_GUBUN());
    String scTEXTVALUE  = KJFUtil.print(pm.getScTEXTVALUE());

	//  타이틀 표시 여부
	boolean isTitleDate = status.isTITLE_DATE_YN();
	boolean isTitleHit  = status.isTITLE_HIT_YN();
	boolean isTitleIp   = status.isTITLE_IP_YN();

	boolean IS_MODIFY = false;
	boolean IS_DELETE = false;
	
    //추가 필드 처리
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
%>

<SCRIPT LANGUAGE="JavaScript">
<!--
/***************************************************************************
* Title   : 상세보기 
* Content : 선택된 글 상세보기 처리를 한다.  
****************************************************************************/
function viewDetail(BOARD_SEQ) {
    var fm = document.ViewParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKView";
    fm.BOARD_SEQ.value= BOARD_SEQ;    
    
    fm.submit();
}

/***************************************************************************
* Title   : 쓰기  
* Content : 작성된 게시글을 등록 처리한다. 
****************************************************************************/
function fn_Write(mode) {
    var fm = document.ViewParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKWrite";
    fm.mode.value=mode;
  
    fm.submit();//kjsSubmit('ViewParam'); 
}

/***************************************************************************
* Title   : 삭제 
* Content : 선택된 내용을 삭제  처리한다.
****************************************************************************/
function fn_del(){
    var fm = document.ViewParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKD";

    if (!confirm("선택된 항목을 삭제 하시겠습니까?\n삭제된 게시물은 영구히 삭제됩니다.")) {
        return;
    }

    fm.submit();//kjsSubmit('ViewParam'); 
}

/***************************************************************************
* Title   : 수정 
* Content : 내용을 수정  처리한다.
****************************************************************************/
function fn_modify() {
	var fm = document.ViewParam;
	
    fm.action = "../bbs/BbsAction.do?cmd=BbsKWrite";
    fm.mode.value="modify";
    fm.submit();
}

/***************************************************************************
* Title   : 답글
* Content : 답글 등록 처리한다.
****************************************************************************/
function fn_reply() {
	var fm = document.ViewParam;

    fm.action = "../bbs/BbsAction.do?cmd=BbsKWrite";
    fm.mode.value = "reply";
    fm.submit();
}

/***************************************************************************
* Title   : 출력
* Content : 본문 내용 출력 처리한다.
****************************************************************************/
function fn_print() {
	
	printwin = window.open("../com/pagePrint.jsp","print","left=10px;top=10px;height=500,width=660,scrollbars=yes,toolbar=yes,menubar=yes");
	printwin.focus();
}

/***************************************************************************
* Title   : 목록 
* Content : 리스트 목록으로 처리한다.
****************************************************************************/
function fn_list() {
	var fm = document.ViewParam;

    fm.action = "../bbs/BbsAction.do?cmd=BbsKList";
    fm.method = "post";
    fm.submit();
}

/***************************************************************************
* Title   : 이미지 크기지정  
* Content : 로딩시 이미지 크기를 지정한다. 
****************************************************************************/
function init_content_img(obj , width) {
	var imgInfo = new Image();

	imgInfo.src = obj.src;
	org_width = imgInfo.width;
	org_heigth = imgInfo.height;

	if (org_width > eval(width)) {
		rate=eval(width)/org_width;
		obj.width = eval(width);
		obj.height = org_heigth*rate;
	}
}

/***************************************************************************
* Title   : 이미지 팝업창  
* Content : 선택된 이미지를 팝업창으로 보여준다. 
****************************************************************************/
function big_img1(obj) {
    var imgInfo = new Image();
    
    imgInfo.src = obj.src;

	// 새창의 크기
	if(imgInfo.width <= 800) {cw = imgInfo.width;}else {cw = 800;}
	if(imgInfo.height <= 600) {ch = imgInfo.height;}else {ch = 600;}

	// 스크린의 크기
	sw = screen.availWidth;
	sh = screen.availHeight;
	
	// 열 창의 포지션
	px = (sw-cw)/2;
	py = (sh-ch)/2;

	var imgsrc = obj.src;

	result = window.open('about:blank' , "big_img" , "scrollbars=no,resizable=yes, width=" + cw + " , height=" + ch + ",left=" + px + ",top=" + py + "");
	result.document.writeln("<body scroll='auto' leftmargin=0 topmargin=0><img src=" + imgsrc + " onClick=self.close() ></body>");
  	result.document.close();
}

//-->
</SCRIPT>

<!-- 타이틀이 이보다 외부에 있어서 타이틀 값 전송 안됨 -->
<form name="ViewParam" method="post" >

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage"    value="<%=nowPage%>">
<input type=hidden name="rowPerPage" value="<%=rowPerPage%>">

<!-- 게시판 기본 정보-->
<input type=hidden name="URL"      value="<%=URL%>">
<input type=hidden name="CT_ID"    value="<%=CT_ID%>">
<input type=hidden name="repTitle" value="<%=repTitle%>">

<!-- 신규, 답변 구분-->
<input type=hidden name="mode">

<input type=hidden name="BOARD_SEQ" value="<%=rEntity.getValue(0,"BOARD_SEQ") %>">

<!-- 삭제용-->
<input type=hidden name="chk" value="0">

<!-- 검색 조건절-->
<input type=hidden name="scSLCT_GUBUN" value="<%=scSLCT_GUBUN%>">
<input type=hidden name="scTEXTVALUE"  value="<%=scTEXTVALUE%>">
<input type=hidden name="scSD_CD"      value="<%=scSD_CD%>">
<input type=hidden name="scSGG_CD"     value="<%=scSGG_CD%>">

	<% if ("/bbs/BbsK.jsp".equals(url_us)) {%>
	<!-- 상단 타이틀 START -->
	<jsp:include page="../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle" value="<%=repTitle%>"/>
	<jsp:param name="ButtonType" value="<%=button%>"/></jsp:include>
	<!-- 상단 타이틀 END -->
	<br>
	<%}%>

	<!-- ========================= 게시판 스킨 START ======================== -->

	<!-- 일반 게시판  -->
	<% if (bbsType.equals("general_basic")) { %>
	<jsp:directive.include file="skin/general_basic/view.jsp" />

	<!-- FAQ 게시판 -->
	<% } else if(bbsType.equals("faq_basic")) { %>
	<jsp:directive.include file="skin/faq_basic/view.jsp" />


	<!-- 자료실 게시판  -->
	<% } else if(bbsType.equals("morgue_basic")) { %>
	<jsp:directive.include file="skin/morgue_basic/view.jsp" />
	<% } %>

	<!-- ========================== 게시판 스킨 END ========================= -->

</form>