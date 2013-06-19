<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="java.util.*,sp.uent.UserEnt" %>

<%
	//���� Ÿ��Ʋ ����
	String repTitle = KJFUtil.print(request.getParameter("repTitle"));

	if(!KJFUtil.isEmpty(request.getAttribute("repTitle"))){
		repTitle = (String)request.getAttribute("repTitle");
	} else {
		repTitle = "�������� ����";
	}
%>
<html>

<head>

<title></title>

<!-- ���� �κ� -->
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
	* Title   : ������ ������ ���ϴ� �߰��ǰ� ���� �߰�/���� �Լ�
	* Content : ���õ� ������ �߰��ǰ� ���� �߰�/����
	**********************************************************/
	function includeEtcAns(chkObj, ojbQstSeq){
		if(chkObj.checked){
			document.getElementById("examQst_"+ojbQstSeq).innerHTML += "�߰��ǰ߿� ���� ���� <input name='etc_exam_"+ojbQstSeq+"' size='59'>";
			document.getElementById("examCnt"+ojbQstSeq).disabled = true;
		}else{
			var examQstObj = document.getElementById("examQst_"+ojbQstSeq);
			var tmpHtm = examQstObj.innerHTML;
			examQstObj.innerHTML = tmpHtm.substring(0, tmpHtm.indexOf("�߰��ǰ߿� ���� ����"));
			document.getElementById("examCnt"+ojbQstSeq).disabled = false;
		}
	}

	/**********************************************************
	* Title   : ���� ��ü �߰� �Լ�
	* Content : ���õ� �׸񰪿� ����  ���� �߰�
	**********************************************************/
	function addObjQst() {
		var fm = document.fmParam;
		ojbQstCnt++;
		var newObjQstHtm =
			"<span id='objQst_"+ojbQstCnt+"'><b>������ ����  </b> : <input name='objQst' size='70'> " +
				"<a href='javascript:delObjQst(" + ojbQstCnt + ")'><img src='../images/common/buttom_delete.gif' width='45' height='22' border='0' align='absmiddle'></a><br><br>" +
				"<span id='sel_"+ojbQstCnt+"'> ���׼� : " +
					"<select name='examCnt" + ojbQstCnt + "' OnChange='addSubOst(" + ojbQstCnt + ");'>" +

						"<option value='2'>2 ��" +
						"<option value='3'>3 ��" +
						"<option value='4'>4 ��" +
						"<option value='5'>5 ��" +
						"<option value='6'>6 ��" +
						"<option value='7'>7 ��" +
						"<option value='8'>8 ��" +
					"</select>&nbsp;&nbsp;<input type='checkbox' name='DUP_YN'>�������䰡��" +
					"&nbsp;&nbsp;<input type='checkbox' name='REQ_YN' checked>�ʼ�����" +
					"&nbsp;&nbsp;<input type='checkbox' name='INCLUDE_ETC' onClick='includeEtcAns(this, "+ojbQstCnt+")'>�߰��ǰ� ����" +
					"<br><br>" +
				"</span>" +

				"<span id='examQst_" + ojbQstCnt + "'>" +
				"������ 1. <input name='exam_" + ojbQstCnt + "' size='70'><br>" +
				"������ 2. <input name='exam_" + ojbQstCnt + "' size='70'><br>" +
				"</span><br><HR><BR>" +
			"</span>";

		document.getElementById("OQDiv").innerHTML += newObjQstHtm;
		fm.objQstIdxs.value += ojbQstCnt + ",";
	}

	function addSbjQstFrm() {
		var fm = document.fmParam;
		ojbQstCnt++;

		var newObjQstHtm =
			"<span id='sbjQst_"+ojbQstCnt+"'><b>�ְ��� ����</b> : "+
			"<a href='javascript:addSbjQst(" + ojbQstCnt + ")'><img src='../images/common/poll_add_sub1.gif' width='99' height='21' border='0' align='absmiddle'></a>" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
			"<a href='javascript:delSbjQstFrm("+ojbQstCnt+")'><img src='../images/common/button_delete_all.gif' width='90' height='22' border='0' align='absmiddle'></a><br><br>" +
				"<span id='sel1_" + ojbQstCnt + "'>" +
					"<span id='sbjQst_" + ++sjbQstCnt + "'>�ְ���. <input name='sbjQst' size='70'> " +
					 	"<a href='javascript:delSbjQst(" + sjbQstCnt + ")'><img src='../images/common/buttom_delete.gif' width='45' height='22' border='0' align='absmiddle'></a><br></span>" +

					//"<span id='sbjQst_" + ++sjbQstCnt + "'>�ְ���. <input name='sbjQst' size='50'> " +
					//"<input type='button' value='����' onclick='delSbjQst(" + sjbQstCnt + ")'><br></span>" +

				"</span><BR><HR><br>" +
			"</span>";

		document.getElementById("OQDiv").innerHTML += newObjQstHtm;
		document.getElementById("sbjQstAddBtn").style.display = "none";
	}

	/**********************************************************
	* Title   : ������ ���� �߰� �Լ�
	* Content : ���õ� �׸񰪿� ���� ������  ���� �߰�
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
			newObjQstHtm1 += "������ " + i + ". <input name='exam_" + ojbCnt +"' size='70' value='"+tmpVal+"'><br>";
		}

		document.getElementById("examQst_" + ojbCnt).innerHTML = newObjQstHtm1;
	}

	/**********************************************************
	* Title   : �ְ��� ���� �߰� �Լ�
	* Content : ���õ� �׸񰪿� ���� �ְ��� ���� �߰�
	**********************************************************/
	function addSbjQst(ojbCnt){
		sjbQstCnt++;
		var newSbjQstHtm =
			"<span id='sbjQst_" + sjbQstCnt + "'>�ְ���. <input name='sbjQst' size='70'> "+
			"<a href='javascript:delSbjQst(" + sjbQstCnt + ")'><img src='../images/common/buttom_delete.gif' width='45' height='22' border='0' align='absmiddle'></a><br></span>";
		document.getElementById("sel1_" + ojbCnt).innerHTML += newSbjQstHtm;

	}

	/**********************************************************
	* Title   : ���� ��ü ����  �Լ�
	* Content : ���õ� �׸񰪿�  ���� ��ü ����
	**********************************************************/
	function delObjQst(idx){
		var fm = document.fmParam;
		var objQstIdxs = fm.objQstIdxs.value;

		fm.objQstIdxs.value = objQstIdxs.replace(idx + ",", "");
		document.getElementById("objQst_" + idx).innerHTML = "";
	}

	/**********************************************************
	* Title   : �ְ��� ���� ��ü ����  �Լ�
	* Content : ���õ� �׸񰪿� �ְ��� ���� ��ü ����
	**********************************************************/
	function delSbjQstFrm(idx){
		document.getElementById("sbjQst_" + idx).innerHTML = "";
		document.getElementById("sbjQstAddBtn").style.display = "";
	}

	/**********************************************************
	* Title   : �ְ��� ���� ����
	* Content : ���õ� �׸񰪿� ���� �ְ��� ���� ����
	**********************************************************/
	function delSbjQst(idx){
		document.getElementById("sbjQst_" + idx).innerHTML = "";
	}

	function fn_save(){
		kjsSubmit('fmParam');
	}


	//������ üũ�ϱ�
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
					alert("������ ������ ä���ּ���");
					fm.objQst.focus();
					return false;
				}
			}else{
				for(var i=0;i<fm.objQst.length;i++){
					dupYnArr += (fm.DUP_YN[i].checked?"Y,":"N,");
					reqYnArr += (fm.REQ_YN[i].checked?"Y,":"N,");
					incEtcArr += (fm.INCLUDE_ETC[i].checked?"Y,":"N,");
					if(fm.objQst[i].value==""){
						alert("������ ������ ä���ּ���");
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
						alert("������ ������ ä���ּ���");
						examObj[j].focus();
						return false;
					}
				}
			}
		}

		if(fm.sbjQst!=null){
			if(fm.sbjQst.length==null){
				if(fm.sbjQst.value==""){
					alert("�ְ��� ������ ä���ּ���");
					fm.sbjQst.focus();
					return false;
				}
			}else{
				for(var i=0;i < fm.sbjQst.length;i++){
					if(fm.sbjQst[i].value==""){
						alert("�ְ��� ������ ä���ּ���");
						fm.sbjQst[i].focus();
						return false;
					}
				}
			}
		}
		if( (fm.objQst==null) && (fm.sbjQst==null) ){
			alert("���������� ������ ������ּ���.");
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
<!-- CUD ���-->
<input type=hidden name="cmd" value="RchMgrCUD">
<input type=hidden name="mode" value="C">

<input type=hidden name="objQstIdxs" value="">
<input type=hidden name="dupYnStr" value="">
<input type=hidden name="reqYnStr" value="">
<input type=hidden name="includeEtcStr" value="">
<input type=hidden name="CT_ID" value="<%=request.getParameter("CT_ID")%>">



<!-- ��� Ÿ��Ʋ START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value="S,C"/>
</jsp:include>
<!-- ��� Ÿ��Ʋ END -->
<!-- �Էº� ������ �κ� START -->
<jsp:include page="../com/inc/noBox_top_inc.jsp" flush="true"/>
<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="inputTable" >
	<tr >
		<td class=inputTable_header_td>���� ����</td>
		<td class="inputTable_td">
			<input type="text" name="TITLE" size="95" required>
			 </td>
	</tr>
	<tr >
		<td class=inputTable_header_td>���� �Ⱓ</td>
		<td class="inputTable_td">
			<input name="S_DATE" type=text id="scStartDate" value="" size="10" required="�������ڸ� �Է��ϼ���" readonly>
			<div id="div_start" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; " >
				<iframe src='../com/calander.jsp?frm=fmParam&fName=S_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onclick="MM_showHideLayers('div_start','','show')" align="absmiddle" style="cursor:hand" >
			~
			<input name="E_DATE" type=text id="scEndDate" value="" size="10" required="�������ڸ� �Է��ϼ���" readonly>
			<div id="div_end" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; ">
				<iframe src='../com/calander.jsp?frm=fmParam&fName=E_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onclick="MM_showHideLayers('div_end','','show')" align="absmiddle" style="cursor:hand" >
             </td>
	</tr>
	<tr >
		<td class=inputTable_header_td>�������� ���</td>
		<td class="inputTable_td">
			<select name="PUBLISH_LVL">
				<option value="1">������ ����</option>
				<option value="2">�Ϸ��� ����</option>
				<option value="3">�������� ����</option>
			</select>
		</td>
	</tr>
	<tr >
		<td class=inputTable_header_td>���� ����</td>
		<td class="inputTable_td">
			<textarea name="RS_DESC" cols="72" rows="8"></textarea>
		</td>
	</tr>
	<tr >
		<td class=inputTable_header_td>���� ���</td>
		<td class="inputTable_td">
			<div id="OQDiv"></div>
			&nbsp;
			<center>
				<a href="javascript:addObjQst();">
				<img src="../images/common/poll_add_ask.gif" alt="������ ���� �߰�" width="135" height="21" border="0" align="absmiddle"></a>
				<a href="javascript:addSbjQstFrm();">
				<img src="../images/common/poll_add_sub.gif" alt="�ְ��� ���� �߰�" width="135" height="21" border="0" align="absmiddle" id="sbjQstAddBtn"></a>
			</center>
		</td>
	</tr>
</table>
<jsp:include page="../com/inc/noBox_bottom_inc.jsp" flush="true"/>
<!-- ����Ʈ  ���̺� END-->


<!-- ����¡ START -->
<!-- ����¡ END -->


<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
</form>
</body>
</html>