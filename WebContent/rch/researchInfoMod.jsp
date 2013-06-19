<%--
*************************************************************************************************
*
*
* 파  일  명 : researchView.jsp
* 설      명 : 설문조사 상세  화면
*
* 이력사항 :
* 2007/12/27  윤영수  수정작성
*************************************************************************************************
--%>

<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashMap,java.util.ArrayList" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.uent.UserEnt" %>
<%@ page import="sp.rch.RchParam" %>
<%

	//초기 변수 들 선언
	RchParam pm=(RchParam)request.getAttribute("pm");
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

	ReportEntity objQstList = (ReportEntity)request.getAttribute("objQstList");
	ReportEntity sbjQstList = (ReportEntity)request.getAttribute("sbjQstList");

	int objQstCnt = objQstList.getRowCnt();
	int sbjQstCnt = sbjQstList.getRowCnt();

	HashMap examMap = (HashMap)request.getAttribute("examMap");

	boolean isFinished = false;	 // 종료
	boolean isReady    = false;  // 준비중


	Date myDate 	= new Date();	// 시스템 날짜를 사용할  mydate객체 생성
	Date finishDate = new Date();   // 게시물에 등록일을  사용할 indate객체 생성
	Date startDate  = new Date();   // 게시물에 시작일을  사용할 indate객체 생성

	String today       = "";   	// 오늘 날짜
	String finish_date = "";    // 등록 일자
	String start_date  = "";    // 등록 일자

	// 출력 형태를 가지고 있는 객체를 생성
	SimpleDateFormat myToday = new SimpleDateFormat("yyyy-MM-dd");

	finishDate = KJFDate.str2date(rEntity.getValue(0, "E_DATE"), "yyyy-MM-dd");
	startDate  = KJFDate.str2date(rEntity.getValue(0, "S_DATE"), "yyyy-MM-dd");

	today   	= myToday.format(myDate);
	finish_date = myToday.format(finishDate);
	start_date  = myToday.format(startDate);

	//설문조사 결과 공개 레벨
	int publishLvl = KJFUtil.str2int(rEntity.getValue(0, "PUBLISH_LVL"));

	//응답자 수
	int ansCnt = KJFUtil.str2int(rEntity.getValue(0, "ANS_CNT"));

	//설문조사진행중 구분
	boolean ingRch = "Y".equals(rEntity.getValue(0, "ING_YN"));


		// 설문조사를 강제 종료햇을 경우
	if ("Y".equals(rEntity.getValue(0, "FINISH_YN"))) {
		isFinished = true;
	}

	// 설문조사 기간이 종료되었을 경우
	if ( 0 < KJFDate.getDaysDiff(today , finish_date)) {
		isFinished = true;
	}

	// 설문조사 기간이 준비중일  경우
	if ( 0 > KJFDate.getDaysDiff(today , start_date)) {
		isReady = true;
	}

	UserEnt user = (UserEnt)session.getAttribute("user");

	boolean isAdmin = user.isAdmin();
	boolean isOwner = user.getUSER_ID().equals(rEntity.getValue(0, "USER_ID"));

	String funcBtn = "C";

	// (진행중) 설문조사이면
	if(!isFinished && !isReady) {
		//publishLvl 1:진행중공개, 2:완료후공개, 3:비공개
		if(publishLvl==1) funcBtn = "RSP,RSR,GL"; // 설문조사 참여,결과보기,취소
		else funcBtn = "RSP,GL"; // 설문조사 참여,취소

		if (isAdmin || isOwner)  {
			funcBtn = "RSP,RSE,RSR,M,D,GL"; //참여,종료,결과보기,수정,삭제,취소
		}

	// (준비중) 설문조사이면,
	} else if(!isFinished && isReady) {
		funcBtn = "GL";		// 취소

		if (isAdmin || isOwner)  {
			funcBtn = "M,D,GL"; //수정,삭제,취소
		}

	// (종료)된 설문조사이면
	} else {
		//publishLvl 1:진행중공개, 2:완료후공개, 3:비공개
		if(publishLvl==3) funcBtn = "GL";		// 취소
		else funcBtn = "RSR,GL";		// 결과보기, 취소

		if (isAdmin || isOwner)  {
			funcBtn = "RSR,M,D,GL"; //결과보기,수정,삭제,취소
		}
	}

	StringBuffer objQstIdxs = new StringBuffer();
	String oQstInpType = null;
%>
<html>

<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>설문조사 상세보기</title>
<style type="text/css">
<!--
.style1 {font-weight: bold}
.style2 {color: #FF0000}
-->
</style>
</head>

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--

	/**********************************************
	* CONTENTS : 취소
	***********************************************/

	function fn_cancel(){
		history.back();
	}


	function fn_save(){
		kjsSubmit('fmParam');
	}


	//전송전 체크하기
	function beforeKjs(){
		var fm = document.fmParam;
		return true;
	}


	//입력 문자 길이 검사
	function fc_chk_byte(aro_value,ari_max){

		//onKeyUp="fc_chk_byte(this, 80);"

		var ls_str = aro_value.value; // 이벤트가 일어난 컨트롤의 value 값
		var li_str_len = ls_str.length; // 전체길이

		// 변수초기화
		var li_max = ari_max; // 제한할 글자수 크기
		var i = 0; // for문에 사용
		var li_byte = 0; // 한글일경우는 2 그밗에는 1을 더함
		var li_len = 0; // substring하기 위해서 사용
		var ls_one_char = ""; // 한글자씩 검사한다
		var ls_str2 = ""; // 글자수를 초과하면 제한할수 글자전까지만 보여준다.

		for(i=0; i< li_str_len; i++){
			// 한글자추출
			ls_one_char = ls_str.charAt(i);

			if (escape(ls_one_char).length > 4){
				// 한글이면 2를 더한다.
				li_byte += 2;
			}else{
				// 그밗의 경우는 1을 더한다.
				li_byte++;
			}

			// 전체 크기가 li_max를 넘지않으면
			if(li_byte <= li_max){
				li_len = i + 1;
			}
			//document.fmParam.appLength.value=li_byte;
		}

		// 전체길이를 초과하면
		if(li_byte > li_max){
			alert( li_max + " 글자를 초과 입력할수 없습니다. \n 초과된 글자는 자동으로 삭제 됩니다. ");
			ls_str2 = ls_str.substr(0, li_len);
			aro_value.value = ls_str2;
			//document.fmParam.appLength.value=ari_max;
		}
	}

//-->
</SCRIPT>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name=fmParam method="post" action="../rch/RchMgrAction.do"  >

<!-- CUD 모드-->
<input type=hidden name="cmd"  value="RchMgrCUD">
<input type=hidden name="mode" value="IU">
<input type=hidden name="RID" value="<%=request.getParameter("RID")%>">
<input type=hidden name="CT_ID" value="<%=request.getParameter("CT_ID")%>">

<!-- 페이징 관련(필수)-->
<input type=hidden name="nowPage"         value="<%=KJFUtil.print(pm.getNowPage())%>">
<input type=hidden name="scSLCT_GUBUN"         value="<%=KJFUtil.print(pm.getScSLCT_GUBUN())%>">
<input type=hidden name="scTEXTVALUE"         value="<%=KJFUtil.print(pm.getScTEXTVALUE())%>">

<input type=hidden name="nextURL">
<input type=hidden name="fromPage">

<!-- 타이틀 정보-->
<input type="hidden"  name="titPgId"    value="<%= KJFUtil.print(request.getParameter("titPgId")) %>" >
<input type="hidden"  name="titPgGrId"  value="<%= KJFUtil.print(request.getParameter("titPgGrId")) %>" >


<!-- 상단 타이틀 START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle"   value="설문조사 수정"/>
<jsp:param name="ButtonType" value="S,C"/></jsp:include>
<!-- 상단 타이틀 END -->


<!-- 입력부 디자인 부분 START -->
<jsp:include page="../com/inc/bgBox_top_inc.jsp" flush="true"/>
<table width="100%"  border="0" cellspacing="0" cellpadding="5" class="inputTable" >
	<tr >
		<td width="70" class=inputTable_header_td>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</td>
		<td colspan=2 class="inputTable_td"><input type="text" name="TITLE" size="95" value="<%=rEntity.getValue(0, "TITLE")%>" required></td>
	</tr>
	<tr >
		<td class=inputTable_header_td>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;간</td>
		<td class="inputTable_td" colspan=2>
			<input name="S_DATE" type=text id="scStartDate" value="<%=rEntity.getValue(0, "S_DATE")%>" size="10" required="시작일자를 입력하세요" readonly>
			<div id="div_start" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; " >
				<iframe src='../com/calander.jsp?frm=fmParam&fName=S_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onclick="MM_showHideLayers('div_start','','show')" align="absmiddle" style="cursor:hand" >
			~
			<input name="E_DATE" type=text id="scEndDate" value="<%=rEntity.getValue(0, "E_DATE")%>" size="10" required="종료일자를 입력하세요" readonly>
			<div id="div_end" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; ">
				<iframe src='../com/calander.jsp?frm=fmParam&fName=E_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onclick="MM_showHideLayers('div_end','','show')" align="absmiddle" style="cursor:hand" >
		</td>
	</tr>
	<tr >
		<td class=inputTable_header_td>설문결과</td>
		<td class="inputTable_td" colspan=2>
			<%=publishLvl==1?"진행중 공개":(publishLvl==2?"종료후 공개":"비공개")%>
		</td>
	</tr>
	<tr >
		<td height="40" class=inputTable_header_td>내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용</td>
		<td class="inputTable_td" colspan=2>
			<textarea name="RS_DESC" cols="72" rows="8"><%=rEntity.getValue(0, "RS_DESC")%></textarea></td>
	</tr>
	<%if(objQstCnt>0){%>
	<tr >
		<td class=inputTable_header_td>객 관 식<br>
		  질&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</td>
		<td class="inputTable_td">
			<table width="100%"  border="0" cellspacing="0" cellpadding="3">
			<%
				for(int i=0;i<objQstCnt;i++){
					oQstInpType = "Y".equals(objQstList.getValue(i,2))?"checkbox":"radio";
			%>
				<tr>
					<td>
						<span class="style1"><%=i+1%>. <%=objQstList.getValue(i,1)%></span>
						<%="Y".equals(objQstList.getValue(i,2))?"<font color='blue'>(복수응답가능)</font>":""%>
					</td>
				</tr>
				<tr>
					<td class="" style="padding-left:20px; ">
						<table>
						<%
						String tempSeq = objQstList.getValue(i,0);
						objQstIdxs.append(tempSeq+",");
						ArrayList examList = (ArrayList)examMap.get(tempSeq);
						if(isFinished){
							for(int j=0;j<examList.size();j++)
								out.println("<tr><td>"+(j+1)+". "+((String)examList.get(j))+"</td></tr>");
						}else{
							for(int j=0;j<examList.size();j++)
								out.println("<tr><td>"+(j+1)+". "+((String)examList.get(j))+"</td><td><input type='"+oQstInpType+"' name='objAns_"+tempSeq+"' value='"+(j+1)+"'></td></tr>");
						}
						%>
						</table>
					</td>
				</tr>
				<tr>
					<td height="5"></td>
				</tr>
			<%}%>
			</table>
		</td>
	</tr>
	<%}%>

	<%if(sbjQstCnt>0){%>
	<tr >
		<td class=inputTable_header_td>주 관 식<br>
		  질&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</td>
		<td class="inputTable_td">
			<table width="100%" border="0">
              <tr>
                <td width="16"><img src="../images/common/propedit_marker.gif" width="16" height="16" align="absmiddle"></td>
                <td><strong>주관식 문항당  &quot;<span class="style2">300글자</span>&quot; 이내에서 입력하실 수 있습니다. </strong></td>
              </tr>
            </table>
			<br>
			<table width="100%"  border="0" cellspacing="3" cellpadding="5">
			<%
			if(isFinished){
				for(int i=0;i<sbjQstCnt;i++){
			%>
				<tr>
					<td class="style1"><%=i+1%>. <%=sbjQstList.getValue(i,1)%></td>
				</tr>
			<%
				}
			}else{
				for(int i=0;i<sbjQstCnt;i++){
			%>
				<tr>
					<td class=""><span class="style1"><%=i+1%>. <%=sbjQstList.getValue(i,1)%><br>
					</span>					  <textarea name="sbjAns" style="width:100%" cols="75" rows="3" maxlength=10 onkeyup='javascript:fc_chk_byte(this,300);' ></textarea></td>
				</tr>
			<%}}%>
			</table>
		</td>
	</tr>
	<%}%>
</table>



<jsp:include page="../com/inc/bgBox_bottom_inc.jsp" flush="true"/>
<!-- 리스트  테이블 END-->



<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
<input type=hidden name="objQstIdxs" value="<%=objQstIdxs%>">
</form>
</body>
</html>
