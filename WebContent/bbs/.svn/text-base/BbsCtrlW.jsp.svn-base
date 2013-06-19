<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="java.io.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.bbs.BbsParam" %>

<%@ page import="sp.uent.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%
	// 초기 변수 들 선언
	BbsParam pm = (BbsParam)request.getAttribute("pm");

	// 신규인경우에는 초기화가 되지 않으면 error가  나기 때문에 초기화가 필요하다.
	ReportEntity rEntity  = KJFUtil.REntPrint((ReportEntity)request.getAttribute("rEntity"));
    String mode 			= KJFUtil.print(request.getParameter("mode"));
	//BbsJsp bbsjsp			= new BbsJsp();

	// 페이징 관련(필수)
	String nowPage          = KJFUtil.print(pm.getNowPage());
	String rowPerPage       = KJFUtil.print(pm.getRowPerPage());
	String totalCount      	= KJFUtil.print(pm.getTotalCount());

	String CT_ID 			= rEntity.getValue(0, "CT_ID");
	String BOARD_NAME 		= rEntity.getValue(0, "BOARD_NAME");
	String BOARD_URL		= rEntity.getValue(0, "BOARD_URL");
	String BOARD_CATEGORY   = rEntity.getValue(0, "BOARD_CATEGORY");
	String BOARD_TYPE		= rEntity.getValue(0, "BOARD_TYPE");
	String BOARD_SKIN		= rEntity.getValue(0, "BOARD_SKIN");
	String BOARD_WIDTH		= rEntity.getValue(0, "BOARD_WIDTH");
	String BOARD_ALIGN		= rEntity.getValue(0, "BOARD_ALIGN");

	String CUT_TITLE		= rEntity.getValue(0, "CUT_TITLE");
	String ROWPERPAGE		= rEntity.getValue(0, "ROWPERPAGE");
	String NEW_DAY			= rEntity.getValue(0, "NEW_DAY");
	String TITLE_WRT_YN		= rEntity.getValue(0, "TITLE_WRT_YN");
	String TITLE_DATE_YN	= rEntity.getValue(0, "TITLE_DATE_YN");
	String TITLE_HIT_YN		= rEntity.getValue(0, "TITLE_HIT_YN");
	String TITLE_IP_YN		= rEntity.getValue(0, "TITLE_IP_YN");

	String HEADER_HTML		= rEntity.getValue(0, "HEADER_HTML");
	String MAIN_HTML		= rEntity.getValue(0, "MAIN_HTML");
	String BOTTOM_HTML		= rEntity.getValue(0, "BOTTOM_HTML");

	String LIST_LEVEL		= rEntity.getValue(0, "LIST_LEVEL");
	String READ_LEVEL		= rEntity.getValue(0, "READ_LEVEL");
	String WRITE_LEVEL		= rEntity.getValue(0, "WRITE_LEVEL");	

	String ATTACH_YN 		= rEntity.getValue(0, "ATTACH_YN");
	String FILE_SIZE 		= rEntity.getValue(0, "FILE_SIZE");
	String ATT_NUM 			= rEntity.getValue(0, "ATT_NUM");

	String DIV_USE_YN		= rEntity.getValue(0, "DIV_USE_YN");
	String SD_DIV_YN		= rEntity.getValue(0, "SD_DIV_YN");
	String SGG_DIV_YN		= rEntity.getValue(0, "SGG_DIV_YN");
	String PUBLIC_DIV_YN		= rEntity.getValue(0, "PUBLIC_DIV_YN");
	
	String SECRET_YN 		= rEntity.getValue(0, "SECRET_YN");
	String REPLY_YN 		= rEntity.getValue(0, "REPLY_YN");
	String ONE_LINE_YN 		= rEntity.getValue(0, "ONE_LINE_YN");
	String USE_YN 			= rEntity.getValue(0, "USE_YN");
	String UPD_DT 			= rEntity.getValue(0, "UPD_DT");
	String INS_DT 			= rEntity.getValue(0, "INS_DT");
	String WRT_ID 			= rEntity.getValue(0, "WRT_ID");
	String TABLE_ONE_YN 	= rEntity.getValue(0, "TABLE_ONE_YN");

	String SUBJ_1 			= rEntity.getValue(0, "SUBJ_1");
	String SUBJ_2			= rEntity.getValue(0, "SUBJ_2");
	String SUBJ_3 			= rEntity.getValue(0, "SUBJ_3");
	String SUBJ_4 			= rEntity.getValue(0, "SUBJ_4");
	String SUBJ_5 			= rEntity.getValue(0, "SUBJ_5");
	String SUBJ_6 			= rEntity.getValue(0, "SUBJ_6");
	String SUBJ_7 			= rEntity.getValue(0, "SUBJ_7");
	String SUBJ_8 			= rEntity.getValue(0, "SUBJ_8");
	String SUBJ_9 			= rEntity.getValue(0, "SUBJ_9");
	String SUBJ_10 			= rEntity.getValue(0, "SUBJ_10");

	String FILTER 			= rEntity.getValue(0,"FILTER");
	
	Vector v_sc_type   = (Vector)request.getAttribute("v_sc_type");
	Vector v_sc_use_yn = (Vector)request.getAttribute("v_sc_use_yn");

%>
<%
	String host_url    = request.getContextPath();
	String tbName      = request.getParameter("board_id");      // 테이블명
	String skin_folder = application.getRealPath("/")+"bbs/skin/";
	String skin_list   = null;

	File file       = new File(skin_folder);
	File[] fileList = file.listFiles();

	StringBuffer str = new StringBuffer();

	for(int i = 0; i < fileList.length; i++) {

		if (fileList[i].isDirectory() && !fileList[i].getName().equals("CVS")) {

			String skin_name = fileList[i].getName();

			if(skin_name.equals(BOARD_SKIN)) str.append("<option value=" + skin_name + " selected>" + skin_name + "</option>");
   			else
   				str.append("<option value=" + skin_name + ">" + skin_name + "</option>");
		}
	}
	
	skin_list = str.toString();
%>

<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<!-- 공퉁 부분 -->


<SCRIPT LANGUAGE="JavaScript">
<!--

/***************************************************************************
* Title   : 탭 처리  
* Content : 탭 처리를 한다.    
****************************************************************************/
function go_tab(value){
	if (value == 1) {
		document.all['tab1'].style.display="block";
		document.all['tab2'].style.display="none";
		document.all['tab3'].style.display="none";
		//document.all['tab4'].style.display="none";
		//document.all['tab5'].style.display="none";
	} else if(value == 2) {
		document.all['tab1'].style.display="none";
		document.all['tab2'].style.display="block";
		document.all['tab3'].style.display="none";
		//document.all['tab4'].style.display="none";
		//document.all['tab5'].style.display="none";
	} else if(value == 3) {
		document.all['tab1'].style.display="none";
		document.all['tab2'].style.display="none";
		document.all['tab3'].style.display="block";
		//document.all['tab4'].style.display="none";
		//document.all['tab5'].style.display="none";
	
	/*

	} else if(value == 4) {
		document.all['tab1'].style.display="none";
		document.all['tab2'].style.display="none";
		document.all['tab3'].style.display="none";
		document.all['tab4'].style.display="block";
		document.all['tab5'].style.display="none";
	} else if(value == 5) {
		document.all['tab1'].style.display="none";
		document.all['tab2'].style.display="none";
		document.all['tab3'].style.display="none";
		document.all['tab4'].style.display="none";
		document.all['tab5'].style.display="block";
	*/

	}
		

}

/***************************************************************************
* Title   : 입력값 체크  
* Content : 입력값 체크 처리를 한다.    
****************************************************************************/
function beforeKjs() {
	var fm = document.fmParam;
	var modeValue = fm.mode.value;

	if (fm.ATTACH_YN.checked==false) {
		fm.ATTACH_YN.value='N'
		fm.ATT_NUM.value='0';
		fm.ATTACH_YN.checked=true;

	} else if(fm.ATTACH_YN.checked==true &&fm.ATT_NUM.value == '0') {
		fm.ATT_NUM.value='1';
	}

	<% if("M".equals(mode)){%>
	fm.TABLE_ONE_YN[0].disabled = false;
	fm.TABLE_ONE_YN[1].disabled = false;
	<% }%>			
	
	if(modeValue == "M") // 수정 상태
		fm.cmd.value = "BbsCtrlU";
	else fm.cmd.value = "BbsCtrlC";

	return true;
}

/***************************************************************************
* Title   : 저장  
* Content : 저장 처리를 한다.    
****************************************************************************/
function fn_save() {
	var fm = document.fmParam;		
	
	kjsSubmit('fmParam');
	//if(isSubmit==true) loading_st("저장중 입니다.");
}

/***************************************************************************
* Title   : 취소  
* Content : 취소 처리를 한다.    
****************************************************************************/
function fn_cancel( ) {
	var fm = document.fmParam;
		
    fm.cmd.value="BbsCtrlMgr";
    fm.method = "post";
    fm.submit();
}

/***************************************************************************
* Title   : 라디오 버튼체크  
* Content : 선택값에 따른 처리를 한다.    
****************************************************************************/
function fn_radio(chkName){
	 var fm = document.fmParam;	 
	    
	 for(i = 0; i < fm.elements.length; i++) {
	 	if(fm.elements[i].type == "radio" && fm.elements[i].name == chkName){
	 		if(fm.elements[i].value == "9"){
		 		fm.elements[i].checked = true;
		 	}
	 	}
	 }
}

/***************************************************************************
* Title   : 체크박스 체크  
* Content : 체크박서 선택 값에 따른 처리를 한다.  
****************************************************************************/
function  fn_chkAll(chkName,yn) {
	
  	var fm = document.fmParam;
  	    
	for(i = 0; i < fm.elements.length; i++) {		
		if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName) {
			if(yn == "Y"){
	        	fm.elements[i].checked = true;
	        } else {
	        	fm.elements[i].checked = false;
	        }
		}
	}   
}

/***************************************************************************
* Title   : textarea 사이즈 늘이기  
* Content : textarea 사이즈 처리를 한다.  
****************************************************************************/
function form_size_up(target) {
	target.rows = target.rows+10;
}

/***************************************************************************
* Title   : textarea 사이즈 줄이기  
* Content : textarea 사이즈 처리를 한다.  
****************************************************************************/
function form_size_down(target) {
	if(target.rows>10) target.rows = target.rows-10;
}

/***************************************************************************
* Title   : 초기처리  
* Content : 초기실행서 초기 처리를 한다.  
****************************************************************************/
function fn_init() {
	var fm = document.fmParam;

	fm.TABLE_ONE_YN[<%="Y".equals(TABLE_ONE_YN)?"0":"1"%>].checked 		= true;

	fm.TITLE_WRT_YN[<%="Y".equals(TITLE_WRT_YN)?"1":"0"%>].checked 	    = true;
	fm.TITLE_DATE_YN[<%="Y".equals(TITLE_DATE_YN)?"1":"0"%>].checked 	= true;
	fm.TITLE_HIT_YN[<%="Y".equals(TITLE_HIT_YN)?"1":"0"%>].checked 		= true;
	fm.TITLE_IP_YN[<%="Y".equals(TITLE_IP_YN)?"1":"0"%>].checked 		= true;

	fm.BOARD_ALIGN[<%="left".equals(BOARD_ALIGN)?"0":"right".equals(BOARD_ALIGN)?"2":"1"%>].checked = true;


	<% if("M".equals(mode)){%>
	fm.TABLE_ONE_YN[0].disabled = true;
	fm.TABLE_ONE_YN[1].disabled = true;
	<% }%>
}
//-->
</SCRIPT>

</HEAD>
<BODY leftMargin=0 marginheight='0' marginwidth='0'>
<form name=fmParam method="post" action="../bbs/BbsAction.do"  >
<!-- CUD 모드-->
<input type=hidden name="cmd">
<input type=hidden name="mode" value="<%=mode%>">

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage"    value="<%=nowPage%>">
<input type=hidden name="rowPerPage" value="<%=rowPerPage%>">

<!-- 기타 페이지별 폼 등록 START -->
<!-- 검색 조건절-->
<input type=hidden name="scTYPE"       value="<%=KJFUtil.print(pm.getScTYPE())%>">
<input type=hidden name="scBOARD_NAME" value="<%=KJFUtil.print(pm.getScBOARD_NAME()) %>">
<input type=hidden name="INS_DT"       value="<%=INS_DT%>">
<!-- 기타 페이지별 폼 등록 END -->

<!-- 타이틀 시작-->
  <jsp:include page="../com/inc/title_inc.jsp" flush="true">
  <jsp:param name="repTitle" value=""/>
  <jsp:param name="ButtonType" value="S,C"/>
  </jsp:include>
<!-- 타이틀 끝 -->

<!-- ======================== 입력 디자인 부분 START ========================== -->
<jsp:include page="../com/inc/bgBox_top_inc_admin.jsp" flush="true"/>


<!-- ======================== TAB 디자인 부분 START ========================== -->
<table width="100%" border="0"  cellspacing="0" cellpadding="0">
	<tr>
     	<td align="left">
	        <!-- tab 시작  -->
	        <%
			String Tabcolum[] ={
								"기본정보|go_tab(1)|sel-80",
								"추가속성|go_tab(2)|80",
								"테이블속성|go_tab(3)|80"
								//"추가필드관리|go_tab(4)|80",
								//"HTML설정|go_tab(5)|80"
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
<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="inputTable" id="tab1">
	<tr>
		<td class="inputTable_header_td">게시판ID </td>
	    <td class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input type=text name=CT_ID value="<%=CT_ID%>" maxlength='100' class="input_textfield" required upper></td>
	</tr>
	<tr>
	    <td class="inputTable_header_td">게시판명 </td>
	    <td class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="BOARD_NAME" type="text" id="BOARD_NAME" value="<%=BOARD_NAME%>">
	    </td>
	</tr>
	<tr>
	    <td class="inputTable_header_td">게시판URL </td>
	    <td class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="BOARD_URL" type="text" size="80" id="BOARD_URL" value="<%=BOARD_URL%>">
	    </td>
	</tr>

	<tr >
	    <td class="inputTable_header_td">게시판  카테고리</td>
	    <td class="inputTable_td">&nbsp;&nbsp;&nbsp; <input name=BOARD_CATEGORY type=input size="80" id="BOARD_CATEGORY" value=> 예)국어/영어/수학 
	    </td>
	  </tr>

	<tr>
	    <td class="inputTable_header_td">DB테이블 타입 </td>
	    <td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="TABLE_ONE_YN" type="radio" value="Y"> 통합 테이블 구조
	      	<input name="TABLE_ONE_YN" type="radio" value="N"> 단독 테이블 구조
		</td>
	</tr>
	  <!-- 스킨 설정 -->
	<tr>
	    <td class="inputTable_header_td">게시판 종류 </td>
	    <td height="25" class="inputTable_td">&nbsp;&nbsp; 
	    	<KTags:KJFSelect item="<%=v_sc_type%>" name="BOARD_TYPE" value="<%=BOARD_TYPE%>" script=" "/> </td>
	</tr>
	<tr>
		<td class="inputTable_header_td">스킨명 </td>
		<td height="25" class="inputTable_td">&nbsp;&nbsp;
			<select name=BOARD_SKIN id="BOARD_SKIN">
				<%=skin_list%>
	      	</select>
		</td>
	</tr>
	<tr>
	    <td class="inputTable_header_td">사용유무</td>
	    <td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name=USE_YN type=checkbox value="Y" <%="Y".equals(USE_YN)?"checked":"".equals(mode)?"checked":""%>> 사용 
		</td>
	</tr>	  
</table>
<!-- ======================== [TAB1] 기본설정 END =========================== -->


<!-- ======================== [TAB2] 추가속성 START ========================= -->
<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="inputTable" id="tab2" style="display:none;">
	<tr>
      	<td class="inputTable_header_td" width="150">업 로 드 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="ATTACH_YN" type="checkbox" value="Y" <%="Y".equals(ATTACH_YN)?"checked":""%>>자료실 기능 사용
			<select name="ATT_NUM">
				<option value="">선택</option>
				<%for(int i = 1; i < 11; i++) { %>
				<option value="<%=i%>" <%= ATT_NUM.equals(Integer.toString(i))?"selected":""%>><%=i%></option>
				<%}%>
			</select>
		</td>
    </tr>
    
	  <tr>
      	<td class="inputTable_header_td" width="150">코멘트</td>
      	<td height='25' class="inputTable_td">&nbsp;&nbsp; <input name=ONE_LINE_YN type=checkbox value="Y"   <%="Y".equals(ONE_LINE_YN)?"checked":""%>>
        코멘트 기능 사용 </td> 
		</td>
    </tr>

	<tr>
      	<td class="inputTable_header_td" width="150">시.도 구분  기능</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="SD_DIV_YN" type="checkbox" value="Y" <%="Y".equals(SD_DIV_YN)?"checked":""%>>시.도 구분 기능 사용 
		</td>
    </tr>

	<tr>
      	<td class="inputTable_header_td" width="150">시.군.구  구분  기능</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="SGG_DIV_YN" type="checkbox" value="Y" <%="Y".equals(SGG_DIV_YN)?"checked":""%>>시.군.구 구분 기능 사용 
		</td>
    </tr>   

	<tr>
      	<td class="inputTable_header_td" width="150">공무원전용게시판  기능</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="PUBLIC_DIV_YN" type="checkbox" value="Y" <%="Y".equals(PUBLIC_DIV_YN)?"checked":""%>>전용게시판 사용 
		</td>
    </tr>
	
    <tr>
      	<td class="inputTable_header_td" width="150">업로드 파일 사이즈 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			
			<select name="FILE_SIZE">
				<%for(int i = 1; i < 21; i++) { %>
				<option value="<%=i%>" <%= FILE_SIZE.equals(Integer.toString(i))?"selected":"2"%>><%=i%>M byte</option>
				<%}%>
			</select>	
			&nbsp;(Max : 10M byte)
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td" width="150">리스트 권한 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
					<input type="radio" name="LIST_LEVEL" value="G" <%="G".equals(LIST_LEVEL)?"checked":"".equals(LIST_LEVEL)?"checked":""%> />전체
		     	<input type="radio" name="LIST_LEVEL" value="U" <%="U".equals(LIST_LEVEL)?"checked":""%> />일반
		     	<input type="radio" name="LIST_LEVEL" value="PU" <%="PU".equals(LIST_LEVEL)?"checked":""%> />공무원(ALL)
					<input type="radio" name="LIST_LEVEL" value="M" <%="M".equals(LIST_LEVEL)?"checked":""%> />시.도
					<input type="radio" name="LIST_LEVEL" value="C" <%="C".equals(LIST_LEVEL)?"checked":""%> />시.군.구
					<input type="radio" name="LIST_LEVEL" value="MC" <%="MC".equals(LIST_LEVEL)?"checked":""%> />시도/시군구
        	<input type="radio" name="LIST_LEVEL" value="A" <%="A".equals(LIST_LEVEL)?"checked":""%> />통합 관리자
				</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td" width="150">글읽기 권한 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
				<input type="radio" name="READ_LEVEL" value="G" <%="G".equals(READ_LEVEL)?"checked":"".equals(READ_LEVEL)?"checked":""%> />전체
       	<input type="radio" name="READ_LEVEL" value="U" <%="U".equals(READ_LEVEL)?"checked":""%> />일반
	     	<input type="radio" name="READ_LEVEL" value="PU" <%="PU".equals(READ_LEVEL)?"checked":""%> />공무원(ALL)       	
    		<input type="radio" name="READ_LEVEL" value="M" <%="M".equals(READ_LEVEL)?"checked":""%> />시.도
				<input type="radio" name="READ_LEVEL" value="C" <%="C".equals(READ_LEVEL)?"checked":""%> />시.군.구
				<input type="radio" name="READ_LEVEL" value="MC" <%="MC".equals(READ_LEVEL)?"checked":""%> />시도/시군구
    		<input type="radio" name="READ_LEVEL" value="A" <%="A".equals(READ_LEVEL)?"checked":""%> />통합 관리자
		</td>
    </tr>
    
	<tr>
      	<td class="inputTable_header_td" width="150">글쓰기 권한 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
				<input type="radio" name="WRITE_LEVEL" value="G" <%="G".equals(WRITE_LEVEL)?"checked":"".equals(WRITE_LEVEL)?"checked":""%> />전체
        <input type="radio" name="WRITE_LEVEL" value="U" <%="U".equals(WRITE_LEVEL)?"checked":""%> />일반
	     	<input type="radio" name="WRITE_LEVEL" value="PU" <%="PU".equals(WRITE_LEVEL)?"checked":""%> />공무원(ALL)        
				<input type="radio" name="WRITE_LEVEL" value="M" <%="M".equals(WRITE_LEVEL)?"checked":""%> />시.도  
    		<input type="radio" name="WRITE_LEVEL" value="C" <%="C".equals(WRITE_LEVEL)?"checked":""%> />시.군.구
				<input type="radio" name="WRITE_LEVEL" value="MC" <%="MC".equals(WRITE_LEVEL)?"checked":""%> />시도/시군구
    		<input type="radio" name="WRITE_LEVEL" value="A" <%="A".equals(WRITE_LEVEL)?"checked":""%> />통합 관리자
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td" width="150">답 글 기능 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="REPLY_YN" value="Y"  type="checkbox"  <%="Y".equals(REPLY_YN)?"checked":""%>>간단한 답글 기능 사용 
		</td>
    </tr>
	<!-- 
	 <tr>
      	<td class="inputTable_header_td" width="150">댓 글 기능</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="ONE_LINE_YN" type="checkbox" value="Y" <%="Y".equals(ONE_LINE_YN)?"checked":""%>>댓글 기능 사용 
		</td>
    </tr>
   
    <tr>
      	<td class="inputTable_header_td" width="150">비밀 글 기능 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
		<input name="SECRET_YN" type=checkbox value="Y"  <%="Y".equals(SECRET_YN)?"checked":""%>>비밀글 기능사용. 관리자와 비번 아는 사람만 볼수 있음 </td>
    </tr>

	
    <tr>
      	<td class="inputTable_header_td" width="150">금지 단어 첵크 </td>
      	<td height="25" class="inputTable_td"> <br> &nbsp;&nbsp; 
			<textarea name="FILTER" cols="70" rows="5" id="filter"><%=FILTER%></textarea>
        	<br> &nbsp;&nbsp;불량단어 필터링 목록입니다. <b>, (콤마)</b> 로 연결하세요 </td>
    </tr>
	
    <tr bgcolor=#FFFFFF height=25>
      	<td align="right" style="FONT-FAMILY: Tahoma; FONT-SIZE: 8pt" colspan="2">
        	<div align="center"> </div>
		</td>
    </tr>
    -->
</table>
<!-- ======================== [TAB2] 추가속성 END =========================== -->


<!-- ======================== [TAB3] 테이블속성 START ======================= -->
<table width="100%" border="0" cellspacing="0" cellpadding="3" class="inputTable" id="tab3" style="display:none;">
	<tr>
      	<td class="inputTable_header_td">게시판 폭 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input class=input maxlength=4 name=BOARD_WIDTH size=4
            style="BORDER-BOTTOM-COLOR: #b0b0b0; BORDER-LEFT-COLOR: #b0b0b0; BORDER-RIGHT-COLOR: #b0b0b0; BORDER-TOP-COLOR: #b0b0b0"
            value="<%=!"".equals(BOARD_WIDTH)?BOARD_WIDTH:"100%"%>"> &nbsp;&nbsp; 게시판 가로크기 (%로 설정시 기호 입력필요)
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">게시판 정렬 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;
        	<input name="BOARD_ALIGN" value="left" type="radio" >좌측정렬
        	<input name="BOARD_ALIGN" value="center" type="radio" >센터정렬
        	<input name="BOARD_ALIGN" value="right" type="radio" >우측정렬
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">제목 길이 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input class="input" maxlength="11" name="CUT_TITLE" size="11"
            style="BORDER-BOTTOM-COLOR: #b0b0b0; BORDER-LEFT-COLOR: #b0b0b0; BORDER-RIGHT-COLOR: #b0b0b0; BORDER-TOP-COLOR: #b0b0b0"
            value="<%=!"".equals(CUT_TITLE)?CUT_TITLE:"50"%>"> &nbsp;&nbsp; 지정된 길이 이상의 제목글은 ... 로 나머지 표시 (0:사용안함)
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">리스트 목록수 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
      		<KTags:KJFSelect 
      			item='<%=KJFUtil.getSelPageLine()%>' 
      			name='ROWPERPAGE' 
      			value='<%=ROWPERPAGE+""%>' 
      			script=" " /> &nbsp;&nbsp;
        	한페이지당 출력될 목록의 수 (1~999) 
		</td>
    </tr>

	<tr>
      <td class="inputTable_header_td">발광(NEW) 기간 </td>
      <td height='25' class="inputTable_td">&nbsp;&nbsp; 
      	<select name="NEW_DAY">
			<%for(int i = 1; i < 8; i++) { %>
			<option value="<%=i%>" <%= NEW_DAY.equals(Integer.toString(i))?"selected":""%>><%=i%>일</option>
			<%}%>
		</select> &nbsp;&nbsp;
        	등록 후  몇일까지의 기간만큼 New 표시 (1~7일) </td>
    </tr>

	<tr>
      	<td class="inputTable_header_td">작성자 보이기 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="TITLE_WRT_YN" value="N" type="radio">작성자 보이지 않음
			<input name="TITLE_WRT_YN" value="Y" type="radio">작성자 보임 </td>
    </tr>
   
    <tr>
      	<td class="inputTable_header_td">날짜 보이기 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="TITLE_DATE_YN" value="N" type="radio">날짜 보이지 않음
			<input name="TITLE_DATE_YN" value="Y" type="radio">날짜 보임 </td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">hit 보이기 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="TITLE_HIT_YN" value="N" type="radio">hit 보이지 않음
			<input name="TITLE_HIT_YN" value="Y" type="radio">hit 보임
		 </td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">IP 보이기 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp; 
			<input name="TITLE_IP_YN" value="N" type="radio">IP 보이지 않음
 			<input name="TITLE_IP_YN" value="Y" type="radio">IP 보임 
		</td>
    </tr>
</table>
<!-- ======================== [TAB3] 테이블속성 END ========================= -->


<!-- ======================== [TAB4] 추가필드관리 START ====================== -->
<table width="100%" border="0" cellspacing="0" cellpadding="3" class="inputTable" id="tab4" style="display:none;">
    <tr>
		<td width="120" class="inputTable_header_td">항목1 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_1" type="text" size="80" id="SUBJ_1" value="<%=SUBJ_1%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목2 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_2" type="text" size="80" id="SUBJ_2" value="<%=SUBJ_2%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목3</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_3" type="text" size="80" id="SUBJ_3" value="<%=SUBJ_3%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목4</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_4" type="text" size="80" id="SUBJ_4" value="<%=SUBJ_4%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목5</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_5" type="text" size="80" id="SUBJ_5" value="<%=SUBJ_5%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목6</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_6" type="text" size="80" id="SUBJ_6" value="<%=SUBJ_6%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목7</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_7" type="text" size="80" id="SUBJ_7" value="<%=SUBJ_7%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목8</td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_8" type="text" size="80" id="SUBJ_8" value="<%=SUBJ_8%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목9 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_9" type="text" size="80" id="SUBJ_9" value="<%=SUBJ_9%>">
		</td>
    </tr>

    <tr>
      	<td class="inputTable_header_td">항목10 </td>
      	<td height="25" class="inputTable_td">&nbsp;&nbsp;&nbsp; 
			<input name="SUBJ_10" type="text" size="80" id="SUBJ_10" value="<%=SUBJ_10%>">
		</td>
    </tr>
</table>
<!-- ======================== [TAB4] 추가필드관리 END ======================= -->


<!-- ======================== [TAB5] HTML 설정 START ======================== -->
<table width="100%" border="0" cellspacing="0" cellpadding="3" class="inputTable" id="tab5" style="display:none;">
	<tr height=25>
      	<td class="inputTable_header_td">
			윗 부분<br> <br>
        	HTML<br> <br>
        	(body 태그밑)
		</td>
      	<td height="25" class="inputTable_td" >
			<a href="javascript:form_size_down(document.fmParam.HEADER_HTML)">△</a>
			<a href="javascript:form_size_up(document.fmParam.HEADER_HTML)"><br>▽</a> 
			<textarea class=textarea cols=67 name=HEADER_HTML rows=10 
			style="BORDER-BOTTOM-COLOR: #b0b0b0; BORDER-LEFT-COLOR: #b0b0b0; BORDER-RIGHT-COLOR: #b0b0b0; BORDER-TOP-COLOR: #b0b0b0">
			<%=HEADER_HTML%></textarea>
      </td>
    </tr>

    <tr height=25>
      	<td class="inputTable_header_td" >
			본문 부분 <br> <br>
        	HTML<br> <br>
        	글쓰기시에 <br>
        	나타날 내용 
		</td>
      	<td height="25" class="inputTable_td" >
			<a href="javascript:form_size_down(document.fmParam.MAIN_HTML)">△</a>
			<a href="javascript:form_size_up(document.fmParam.MAIN_HTML)"><br>▽</a>
			<textarea name=MAIN_HTML cols=67 rows=10 class=textarea id=main 
			style="BORDER-BOTTOM-COLOR: #b0b0b0; BORDER-LEFT-COLOR: #b0b0b0; BORDER-RIGHT-COLOR: #b0b0b0; BORDER-TOP-COLOR: #b0b0b0">
			<%=MAIN_HTML%></textarea>
      </td>
    </tr>

    <tr height=25>
      	<td class="inputTable_header_td">
			아랫 부분 <br> <br>
      		HTML <br>
        	<br>
        	(/body 태그위)
		</td>
     	<td height="25" class="inputTable_td" >
			<a href="javascript:form_size_down(document.fmParam.BOTTOM_HTML)">△</a>
			<a href="javascript:form_size_up(document.fmParam.BOTTOM_HTML)"><br>▽</a>
			<textarea class="textarea" cols="67" name="BOTTOM_HTML" rows="10" 
			style="BORDER-BOTTOM-COLOR: #b0b0b0; BORDER-LEFT-COLOR: #b0b0b0; BORDER-RIGHT-COLOR: #b0b0b0; BORDER-TOP-COLOR: #b0b0b0">
			<%= BOTTOM_HTML %></textarea>
		</td>
    </tr>
  </table>
<!-- ======================== [TAB5] HTML 설정 END ========================== -->


<jsp:include page="../com/inc/bgBox_bottom_inc_admin.jsp" flush="true"/>
<!-- 입력부 디자인 부분 END -->


<!-- ======================== Copyright START ============================== -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
<!-- ======================== Copyright END ================================ -->

</form>

<script>
fn_init();
</script>

</BODY>
</HTML>