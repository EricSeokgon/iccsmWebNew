<%@ page contentType="text/html;charset=utf-8"%>
<%//@ page errorPage="../com/error.jsp" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.bbs.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	// 초기 변수 들 선언
	StatusEnt status = (StatusEnt)session.getAttribute("status");
		
	BbsParam pm = (BbsParam)request.getAttribute("pm");
	
	ReportEntity NoticeEntity = (ReportEntity)request.getAttribute("NoticeEntity");
	ReportEntity ListEntity   = (ReportEntity)request.getAttribute("ListEntity");
	        
	String url_us = KJFUtil.print(request.getParameter("URL"),(String)request.getAttribute("url_us"));
	String cmd    = KJFUtil.print(request.getParameter("cmd"));
		
	//페이징 관련(필수)
	String nowPage    = KJFUtil.print(pm.getNowPage());
	String rowPerPage = KJFUtil.print(pm.getRowPerPage());
	String totalCount = KJFUtil.print(pm.getTotalCount());
	
	String button   = "";				// 버튼타입
	String repTitle = KJFUtil.print(request.getParameter("repTitle"));
	
	if (status.isADMIN()) {	// 관리자일경우
	    button = "N,D";
	
	} else if(status.isWRITE()) { // 쓰기 권한이있을경우 버튼생성
	    button = "N";
	}

	if (!KJFUtil.isEmpty(request.getAttribute("repTitle"))) {
		repTitle = (String)request.getAttribute("repTitle");
	}
	
	if (!KJFUtil.isEmpty(request.getAttribute("menuTitle"))) {
		repTitle = (String)request.getAttribute("menuTitle");
	}
	
    String CT_ID     = status.getCT_ID();
    String BOARD_SEQ = KJFUtil.print(request.getParameter("BOARD_SEQ"));	
    String URL       = "";
    
   
    if ("/bbs/BbsK.jsp".equals(url_us)) {
    	URL = "/bbs/BbsK.jsp";
    } else {
    	URL	= status.getURL();
    }
           			
	String bbsType = status.getTYPE();
//	String bbsSKIN = status.getSKIN();
	
	int CutStr = KJFUtil.str2int(status.getCUT_TITLE());

	// 검색 코드
	String scSD_CD      = KJFUtil.print(pm.getScSD_CD());
	String scSGG_CD     = KJFUtil.print(pm.getScSGG_CD());	
    String scSLCT_GUBUN = KJFUtil.print(pm.getScSLCT_GUBUN());
    String scTEXTVALUE  = KJFUtil.print(pm.getScTEXTVALUE());
    
	boolean isAdmin		= status.isADMIN();

	//  타이틀 표시 여부
	boolean isTitleDate = status.isTITLE_DATE_YN();
	boolean isTitleHit  = status.isTITLE_HIT_YN();
	boolean isTitleIp   = status.isTITLE_IP_YN();
	
	String modify_go_url = "showPassForm('confirmPassModify')";
	
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

	int int_rnum = KJFUtil.str2int(totalCount)-(KJFUtil.str2int(nowPage) *KJFUtil.str2int(rowPerPage) - KJFUtil.str2int(rowPerPage));
%>

<SCRIPT LANGUAGE="JavaScript">
<!--
/***************************************************************************
* Title   : 페이징
* Content : 선택된 페이지 이동 처리를 한다.  
****************************************************************************/
function movePage(page){
    var fm = document.fmParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKList";
    fm.nowPage.value= page;
    
    fm.submit();
}

/***************************************************************************
* Title   : 페이지 목록수 
* Content : 선택된 페이지 목록수 처리를 한다.  
****************************************************************************/
function changeRowPerPage(obj){
    var fm = document.fmParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKList";
    fm.rowPerPage.value= obj.value;
    fm.nowPage.value="1";
    
    fm.submit();
}

/***************************************************************************
* Title   : 상세보기 
* Content : 선택된 글 상세보기 처리를 한다.  
****************************************************************************/
function viewDetail(BOARD_SEQ) {
    var fm = document.fmParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKView";
    fm.BOARD_SEQ.value= BOARD_SEQ;    
    
    fm.submit();
}

/***************************************************************************
* Title   : 검색  
* Content : 등록된 글 검색 처리를 한다. 
****************************************************************************/
function fn_search() {
    var fm = document.fmParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKList";
    fm.nowPage.value = 1;
    fm.submit();
}

/***************************************************************************
* Title   : 시도 검색  
* Content : 등록된 글 검색 처리를 한다. 
****************************************************************************/
function fn_searchSD_CD() {
    var fm = document.fmParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKList";
    fm.nowPage.value = 1;
    fm.scSGG_CD.value = "ALL";
    fm.submit();
}

/***************************************************************************
* Title   : 등록  
* Content : 등록 처리를 한다. 
****************************************************************************/
function fn_new() {
	var fm = document.fmParam;

    fm.action = "../bbs/BbsAction.do?cmd=BbsKWrite";

    fm.submit();
}

/***************************************************************************
* Title   : 삭제
* Content : 삭제 처리를 한다. 
****************************************************************************/
function fn_delete(){
	var fm = document.fmParam;

	if(chkBoxCheck('chk')){ // 선택된 항목이 있는지 체크

		var isOK = confirm("선택된 항목을 삭제 하시겠습니까?\n삭제된 게시물은 영구히 삭제됩니다.");

		if(isOK){
			fm.action = "../bbs/BbsAction.do?cmd=BbsLD";
    		fm.submit();
		}
	}
}

/***************************************************************************
* Title   : 시.군.구 코드를 검색한다   
* Content : 시.군.구 코드 Ajax검색 처리를 한다. 
****************************************************************************/
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

/***************************************************************************
* Title   : 시.군.구 코드 화면 처리 화면
* Content : 시.군.구 코드 Ajax로 검색 리스트를 화면 처리 한다. 
****************************************************************************/
function fn_SggCodeView() {
	document.getElementById("layer_sggcd").innerHTML = httpRequest.responseText;
}


/***************************************************************************
* Title   : FAQ
* Content : FAQ 화면 처리 한다. 
****************************************************************************/
var preNum;
var flag=1;
function changeLayer(sNum)
{
	if(sNum==preNum && flag==1){
		//alert('a');
		temp = eval("document.all."+sNum);
		if(temp){
			temp.style.display='none';
			flag=0;
		}
	}
	else if(sNum==preNum && flag==0){
		//alert('b');
		temp = eval("document.all."+sNum);
		if(temp){
			temp.style.display='';
			flag=1;
		}
	}
	else if(sNum!=preNum){
		//alert('c');
		temp = eval("document.all."+preNum);
		if(temp)
			temp.style.display='none';

		temp1 = eval("document.all."+sNum);
		if(temp1)
			temp1.style.display='';
		flag=1;


	}
	preNum=sNum;
}

/***************************************************************************
* Title   : FAQ 쓰기  
* Content : 작성된 게시글을 등록 처리한다. 
****************************************************************************/
function fn_Write(mode, board_seq) {
    var fm = document.fmParam;
    
    fm.action = "../bbs/BbsAction.do?cmd=BbsKWrite";
    fm.mode.value      = mode;
    fm.BOARD_SEQ.value = board_seq;
  
    fm.submit();
}

//-->
</SCRIPT>

<!-- 타이틀이 이보다 외부에 있어서 타이틀 값 전송 안됨-->
<form name="fmParam" method="post">

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage" value="<%=nowPage%>">
<!-- rowPerPage는 셀렉트 박스에 있으므로 필요 없다.-->

<input type=hidden name="mode">

<!-- 게시판 기본 정보-->
<input type=hidden name="URL"      value="<%=URL%>">
<input type=hidden name="CT_ID"    value="<%=CT_ID%>">
<input type=hidden name="repTitle" value="<%=repTitle%>">
<input type=hidden name="BOARD_SEQ">

<!-- 타이틀 정보-->
<input type="hidden"  name="titPgId"   value="<%= KJFUtil.print(request.getParameter("titPgId")) %>" >
<input type="hidden"  name="titPgGrId" value="<%= KJFUtil.print(request.getParameter("titPgGrId")) %>" >

	<% if("/bbs/BbsK.jsp".equals(url_us) && "BbsKList".equals(cmd)){%>
	<!-- 상단 타이틀 START -->
	<jsp:include page="../com/inc/title_inc.jsp" flush="true">
		<jsp:param name="repTitle"   value="<%=repTitle%>"/>
		<jsp:param name="ButtonType" value="<%=button%>"/>
	</jsp:include>
	<!-- 상단 타이틀 END -->
	<br>
	<%}%>
	
	<!-- ========================= 게시판 스킨 START ======================== -->

	<!-- 일반 게시판 -->
	<% if(bbsType.equals("general_basic")) { %>
	<jsp:directive.include file="skin/general_basic/list.jsp" />
	
	<!-- FAQ 게시판 -->
	<% } else if(bbsType.equals("faq_basic")) { %>
	<jsp:directive.include file="skin/faq_basic/list.jsp" />

	<!-- QNA 게시판 -->
	<% } else if(bbsType.equals("qna_basic")) { %>
	<jsp:directive.include file="skin/qna_basic/list.jsp" />
	
	<!-- 자료실 게시판 -->
	<% } else if(bbsType.equals("morgue_basic")) { %>
	<jsp:directive.include file="skin/morgue_basic/list.jsp" />
	<% } %>					

	<!-- ========================= 게시판 스킨 END ======================== -->

</form>
