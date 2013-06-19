<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="java.util.*,sp.uent.UserEnt" %>

<%
	//상위 타이틀 제목
	String repTitle = KJFUtil.print(request.getParameter("repTitle"));

	if(!KJFUtil.isEmpty(request.getAttribute("repTitle"))){
		repTitle = (String)request.getAttribute("repTitle");
	} else {
		repTitle = "설문조사 관리";
	}
%>
<html>

<head>

<title></title>

<!-- 공퉁 부분 -->
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../com/css/style_noSelectBox.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
	var ojbQstCnt = 0;
	var sjbQstCnt = 0;
	var objQstIdxs = "";


	/**********************************************************
	* Title   : 객관식 질문에 속하는 추가의견 질문 추가/삭제 함수
	* Content : 선택된 질문에 추가의견 질문 추가/삭제
	**********************************************************/
	function includeEtcAns(chkObj, ojbQstSeq){
		if(chkObj.checked){
			document.getElementById("examQst_"+ojbQstSeq).innerHTML += "추가의견에 대한 질문 <input name='etc_exam_"+ojbQstSeq+"' size='59'>";
			document.getElementById("examCnt"+ojbQstSeq).disabled = true;
		}else{
			var examQstObj = document.getElementById("examQst_"+ojbQstSeq);
			var tmpHtm = examQstObj.innerHTML;
			examQstObj.innerHTML = tmpHtm.substring(0, tmpHtm.indexOf("추가의견에 대한 질문"));
			document.getElementById("examCnt"+ojbQstSeq).disabled = false;
		}
	}

	/**********************************************************
	* Title   : 질문 전체 추가 함수
	* Content : 석택된 항목값에 의해  질문 추가
	**********************************************************/
	function addObjQst() {
		var fm = document.fmParam;
		ojbQstCnt++;
		var newObjQstHtm =
			"<span id='objQst_"+ojbQstCnt+"'><b>객관식 질문  </b> : <input name='objQst' size='70'> " +
				"<a href='javascript:delObjQst(" + ojbQstCnt + ")'><img src='../images/common/buttom_delete.gif' width='45' height='22' border='0' align='absmiddle'></a><br><br>" +
				"<span id='sel_"+ojbQstCnt+"'> 문항수 : " +
					"<select name='examCnt" + ojbQstCnt + "' OnChange='addSubOst(" + ojbQstCnt + ");'>" +

						"<option value='2'>2 항" +
						"<option value='3'>3 항" +
						"<option value='4'>4 항" +
						"<option value='5'>5 항" +
						"<option value='6'>6 항" +
						"<option value='7'>7 항" +
						"<option value='8'>8 항" +
					"</select>&nbsp;&nbsp;<input type='checkbox' name='DUP_YN'>복수응답가능" +
					"&nbsp;&nbsp;<input type='checkbox' name='REQ_YN' checked>필수응답" +
					"&nbsp;&nbsp;<input type='checkbox' name='INCLUDE_ETC' onClick='includeEtcAns(this, "+ojbQstCnt+")'>추가의견 포함" +
					"<br><br>" +
				"</span>" +

				"<span id='examQst_" + ojbQstCnt + "'>" +
				"객관식 1. <input name='exam_" + ojbQstCnt + "' size='70'><br>" +
				"객관식 2. <input name='exam_" + ojbQstCnt + "' size='70'><br>" +
				"</span><br><HR><BR>" +
			"</span>";

		document.getElementById("OQDiv").innerHTML += newObjQstHtm;
		fm.objQstIdxs.value += ojbQstCnt + ",";
	}

	function addSbjQstFrm() {
		var fm = document.fmParam;
		ojbQstCnt++;

		var newObjQstHtm =
			"<span id='sbjQst_"+ojbQstCnt+"'><b>주관식 질문</b> : "+
			"<a href='javascript:addSbjQst(" + ojbQstCnt + ")'><img src='../images/common/poll_add_sub1.gif' width='99' height='21' border='0' align='absmiddle'></a>" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"<a href='javascript:delSbjQstFrm("+ojbQstCnt+")'><img src='../images/common/button_delete_all.gif' width='90' height='22' border='0' align='absmiddle'></a><br><br>" +
				"<span id='sel1_" + ojbQstCnt + "'>" +
					"<span id='sbjQst_" + ++sjbQstCnt + "'>주관식. <input name='sbjQst' size='70'> " +
					 	"<a href='javascript:delSbjQst(" + sjbQstCnt + ")'><img src='../images/common/buttom_delete.gif' width='45' height='22' border='0' align='absmiddle'></a><br></span>" +

					//"<span id='sbjQst_" + ++sjbQstCnt + "'>주관식. <input name='sbjQst' size='50'> " +
					//"<input type='button' value='삭제' onclick='delSbjQst(" + sjbQstCnt + ")'><br></span>" +

				"</span><BR><HR><br>" +
			"</span>";

		document.getElementById("OQDiv").innerHTML += newObjQstHtm;
		document.getElementById("sbjQstAddBtn").style.display = "none";
	}

	/**********************************************************
	* Title   : 객관식 질문 추가 함수
	* Content : 석택된 항목값에 의해 객관식  질문 추가
	**********************************************************/
	function addSubOst(ojbCnt) {
		var fm = document.fmParam;
		var oldExam = eval("fm.exam_"+ojbCnt);
		var oldExamCnt = oldExam.length;
		var newExamCnt = document.getElementById("examCnt" + ojbCnt).value;
		var newObjQstHtm1 = "";
		for(var i = 1; i <= newExamCnt; i++){
			var tmpVal = "";
			if(oldExamCnt >= i) tmpVal = oldExam[i-1].value;
			newObjQstHtm1 += "객관식 " + i + ". <input name='exam_" + ojbCnt +"' size='70' value='"+tmpVal+"'><br>";
		}

		document.getElementById("examQst_" + ojbCnt).innerHTML = newObjQstHtm1;
	}

	/**********************************************************
	* Title   : 주관식 질문 추가 함수
	* Content : 석택된 항목값에 의해 주관식 질문 추가
	**********************************************************/
	function addSbjQst(ojbCnt){
		sjbQstCnt++;
		var newSbjQstHtm =
			"<span id='sbjQst_" + sjbQstCnt + "'>주관식. <input name='sbjQst' size='70'> "+
			"<a href='javascript:delSbjQst(" + sjbQstCnt + ")'><img src='../images/common/buttom_delete.gif' width='45' height='22' border='0' align='absmiddle'></a><br></span>";
		document.getElementById("sel1_" + ojbCnt).innerHTML += newSbjQstHtm;

	}

	/**********************************************************
	* Title   : 질문 전체 삭제  함수
	* Content : 석택된 항목값에  질문 전체 삭제
	**********************************************************/
	function delObjQst(idx){
		var fm = document.fmParam;
		var objQstIdxs = fm.objQstIdxs.value;

		fm.objQstIdxs.value = objQstIdxs.replace(idx + ",", "");
		document.getElementById("objQst_" + idx).innerHTML = "";
	}

	/**********************************************************
	* Title   : 주관식 질문 전체 삭제  함수
	* Content : 석택된 항목값에 주관식 질문 전체 삭제
	**********************************************************/
	function delSbjQstFrm(idx){
		document.getElementById("sbjQst_" + idx).innerHTML = "";
		document.getElementById("sbjQstAddBtn").style.display = "";
	}

	/**********************************************************
	* Title   : 주관식 질문 삭제
	* Content : 석택된 항목값에 의해 주관식 질문 삭제
	**********************************************************/
	function delSbjQst(idx){
		document.getElementById("sbjQst_" + idx).innerHTML = "";
	}

	function fn_save(){
		kjsSubmit('fmParam');
	}


	//전송전 체크하기
	function beforeKjs(){
		var fm = document.fmParam;
		var dupYnArr = "";
		var reqYnArr = "";
		var incEtcArr = "";

		if(fm.objQst!=null){
			if(fm.objQst.length==null){
				dupYnArr += (fm.DUP_YN.checked?"Y":"N");
				reqYnArr += (fm.REQ_YN.checked?"Y":"N");
				incEtcArr += (fm.INCLUDE_ETC.checked?"Y":"N");
				if(fm.objQst.value==""){
					alert("객관식 질문을 채워주세요");
					fm.objQst.focus();
					return false;
				}
			}else{
				for(var i=0;i<fm.objQst.length;i++){
					dupYnArr += (fm.DUP_YN[i].checked?"Y,":"N,");
					reqYnArr += (fm.REQ_YN[i].checked?"Y,":"N,");
					incEtcArr += (fm.INCLUDE_ETC[i].checked?"Y,":"N,");
					if(fm.objQst[i].value==""){
						alert("객관식 질문을 채워주세요");
						fm.objQst[i].focus();
						return false;
					}
				}
			}
			var tempObjQstIdxs = fm.objQstIdxs.value.substring(0, fm.objQstIdxs.value.length-1);
			var objQstIdxArr = tempObjQstIdxs.split(",");
			for(var i=0;i<objQstIdxArr.length;i++){
				var examObj = eval("fm.exam_"+objQstIdxArr[i]);
				for(var j=0;j<examObj.length;j++){
					if(examObj[j].value==""){
						alert("객관식 예문을 채워주세요");
						examObj[j].focus();
						return false;
					}
				}
			}
		}

		if(fm.sbjQst!=null){
			if(fm.sbjQst.length==null){
				if(fm.sbjQst.value==""){
					alert("주관식 질문을 채워주세요");
					fm.sbjQst.focus();
					return false;
				}
			}else{
				for(var i=0;i < fm.sbjQst.length;i++){
					if(fm.sbjQst[i].value==""){
						alert("주관식 질문을 채워주세요");
						fm.sbjQst[i].focus();
						return false;
					}
				}
			}
		}
		if( (fm.objQst==null) && (fm.sbjQst==null) ){
			alert("설문조사의 질문을 등록해주세요.");
			return false;
		}
		fm.dupYnStr.value = dupYnArr;
		fm.reqYnStr.value = reqYnArr;
		fm.includeEtcStr.value = incEtcArr;
		return true;
	}

	function fn_cancel(){
		history.back();
	}


//-->
</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<form name=fmParam method="post" action="../rch/RchMgrAction.do"  >
<!-- CUD 모드-->
<input type=hidden name="cmd" value="RchMgrCUD">
<input type=hidden name="mode" value="C">

<input type=hidden name="objQstIdxs" value="">
<input type=hidden name="dupYnStr" value="">
<input type=hidden name="reqYnStr" value="">
<input type=hidden name="includeEtcStr" value="">
<input type=hidden name="CT_ID" value="<%=request.getParameter("CT_ID")%>">



<!-- 상단 타이틀 START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value="S,C"/>
</jsp:include>
<!-- 상단 타이틀 END -->
<!-- 입력부 디자인 부분 START -->
<jsp:include page="../com/inc/noBox_top_inc.jsp" flush="true"/>
<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="inputTable" >
	<tr >
		<td class=inputTable_header_td>설문 제목</td>
		<td class="inputTable_td">
			<input type="text" name="TITLE" size="95" required>
			 </td>
	</tr>
	<tr >
		<td class=inputTable_header_td>설문 기간</td>
		<td class="inputTable_td">
			<input name="S_DATE" type=text id="scStartDate" value="" size="10" required="시작일자를 입력하세요" readonly>
			<div id="div_start" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; " >
				<iframe src='../com/calander.jsp?frm=fmParam&fName=S_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onclick="MM_showHideLayers('div_start','','show')" align="absmiddle" style="cursor:hand" >
			~
			<input name="E_DATE" type=text id="scEndDate" value="" size="10" required="종료일자를 입력하세요" readonly>
			<div id="div_end" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; ">
				<iframe src='../com/calander.jsp?frm=fmParam&fName=E_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onclick="MM_showHideLayers('div_end','','show')" align="absmiddle" style="cursor:hand" >
             </td>
	</tr>
	<tr >
		<td class=inputTable_header_td>설문조사 결과</td>
		<td class="inputTable_td">
			<select name="PUBLISH_LVL">
				<option value="1">진행중 공개</option>
				<option value="2">완료후 공개</option>
				<option value="3">공개하지 않음</option>
			</select>
		</td>
	</tr>
	<tr >
		<td class=inputTable_header_td>설문 개요</td>
		<td class="inputTable_td">
			<textarea name="RS_DESC" cols="72" rows="8"></textarea>
		</td>
	</tr>
	<tr >
		<td class=inputTable_header_td>질문 등록</td>
		<td class="inputTable_td">
			<div id="OQDiv"></div>
			&nbsp;
			<center>
				<a href="javascript:addObjQst();">
				<img src="../images/common/poll_add_ask.gif" alt="객관식 질문 추가" width="135" height="21" border="0" align="absmiddle"></a>
				<a href="javascript:addSbjQstFrm();">
				<img src="../images/common/poll_add_sub.gif" alt="주관식 질문 추가" width="135" height="21" border="0" align="absmiddle" id="sbjQstAddBtn"></a>
			</center>
		</td>
	</tr>
</table>
<jsp:include page="../com/inc/noBox_bottom_inc.jsp" flush="true"/>
<!-- 리스트  테이블 END-->


<!-- 페이징 START -->
<!-- 페이징 END -->


<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
</form>
</body>
</html>