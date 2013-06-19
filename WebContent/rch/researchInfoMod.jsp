<%--
*************************************************************************************************
*
*
* ��  ��  �� : researchView.jsp
* ��      �� : �������� ��  ȭ��
*
* �̷»��� :
* 2007/12/27  ������  �����ۼ�
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

	//�ʱ� ���� �� ����
	RchParam pm=(RchParam)request.getAttribute("pm");
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

	ReportEntity objQstList = (ReportEntity)request.getAttribute("objQstList");
	ReportEntity sbjQstList = (ReportEntity)request.getAttribute("sbjQstList");

	int objQstCnt = objQstList.getRowCnt();
	int sbjQstCnt = sbjQstList.getRowCnt();

	HashMap examMap = (HashMap)request.getAttribute("examMap");

	boolean isFinished = false;	 // ����
	boolean isReady    = false;  // �غ���


	Date myDate 	= new Date();	// �ý��� ��¥�� �����  mydate��ü ����
	Date finishDate = new Date();   // �Խù��� �������  ����� indate��ü ����
	Date startDate  = new Date();   // �Խù��� ��������  ����� indate��ü ����

	String today       = "";   	// ���� ��¥
	String finish_date = "";    // ��� ����
	String start_date  = "";    // ��� ����

	// ��� ���¸� ������ �ִ� ��ü�� ����
	SimpleDateFormat myToday = new SimpleDateFormat("yyyy-MM-dd");

	finishDate = KJFDate.str2date(rEntity.getValue(0, "E_DATE"), "yyyy-MM-dd");
	startDate  = KJFDate.str2date(rEntity.getValue(0, "S_DATE"), "yyyy-MM-dd");

	today   	= myToday.format(myDate);
	finish_date = myToday.format(finishDate);
	start_date  = myToday.format(startDate);

	//�������� ��� ���� ����
	int publishLvl = KJFUtil.str2int(rEntity.getValue(0, "PUBLISH_LVL"));

	//������ ��
	int ansCnt = KJFUtil.str2int(rEntity.getValue(0, "ANS_CNT"));

	//�������������� ����
	boolean ingRch = "Y".equals(rEntity.getValue(0, "ING_YN"));


		// �������縦 ���� �������� ���
	if ("Y".equals(rEntity.getValue(0, "FINISH_YN"))) {
		isFinished = true;
	}

	// �������� �Ⱓ�� ����Ǿ��� ���
	if ( 0 < KJFDate.getDaysDiff(today , finish_date)) {
		isFinished = true;
	}

	// �������� �Ⱓ�� �غ�����  ���
	if ( 0 > KJFDate.getDaysDiff(today , start_date)) {
		isReady = true;
	}

	UserEnt user = (UserEnt)session.getAttribute("user");

	boolean isAdmin = user.isAdmin();
	boolean isOwner = user.getUSER_ID().equals(rEntity.getValue(0, "USER_ID"));

	String funcBtn = "C";

	// (������) ���������̸�
	if(!isFinished && !isReady) {
		//publishLvl 1:�����߰���, 2:�Ϸ��İ���, 3:�����
		if(publishLvl==1) funcBtn = "RSP,RSR,GL"; // �������� ����,�������,���
		else funcBtn = "RSP,GL"; // �������� ����,���

		if (isAdmin || isOwner)  {
			funcBtn = "RSP,RSE,RSR,M,D,GL"; //����,����,�������,����,����,���
		}

	// (�غ���) ���������̸�,
	} else if(!isFinished && isReady) {
		funcBtn = "GL";		// ���

		if (isAdmin || isOwner)  {
			funcBtn = "M,D,GL"; //����,����,���
		}

	// (����)�� ���������̸�
	} else {
		//publishLvl 1:�����߰���, 2:�Ϸ��İ���, 3:�����
		if(publishLvl==3) funcBtn = "GL";		// ���
		else funcBtn = "RSR,GL";		// �������, ���

		if (isAdmin || isOwner)  {
			funcBtn = "RSR,M,D,GL"; //�������,����,����,���
		}
	}

	StringBuffer objQstIdxs = new StringBuffer();
	String oQstInpType = null;
%>
<html>

<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>�������� �󼼺���</title>
<style type="text/css">
<!--
.style1 {font-weight: bold}
.style2 {color: #FF0000}
-->
</style>
</head>

<!-- ���� �κ� -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--

	/**********************************************
	* CONTENTS : ���
	***********************************************/

	function fn_cancel(){
		history.back();
	}


	function fn_save(){
		kjsSubmit('fmParam');
	}


	//������ üũ�ϱ�
	function beforeKjs(){
		var fm = document.fmParam;
		return true;
	}


	//�Է� ���� ���� �˻�
	function fc_chk_byte(aro_value,ari_max){

		//onKeyUp="fc_chk_byte(this, 80);"

		var ls_str = aro_value.value; // �̺�Ʈ�� �Ͼ ��Ʈ���� value ��
		var li_str_len = ls_str.length; // ��ü����

		// �����ʱ�ȭ
		var li_max = ari_max; // ������ ���ڼ� ũ��
		var i = 0; // for���� ���
		var li_byte = 0; // �ѱ��ϰ��� 2 �׹ܿ��� 1�� ����
		var li_len = 0; // substring�ϱ� ���ؼ� ���
		var ls_one_char = ""; // �ѱ��ھ� �˻��Ѵ�
		var ls_str2 = ""; // ���ڼ��� �ʰ��ϸ� �����Ҽ� ������������ �����ش�.

		for(i=0; i< li_str_len; i++){
			// �ѱ�������
			ls_one_char = ls_str.charAt(i);

			if (escape(ls_one_char).length > 4){
				// �ѱ��̸� 2�� ���Ѵ�.
				li_byte += 2;
			}else{
				// �׹��� ���� 1�� ���Ѵ�.
				li_byte++;
			}

			// ��ü ũ�Ⱑ li_max�� ����������
			if(li_byte <= li_max){
				li_len = i + 1;
			}
			//document.fmParam.appLength.value=li_byte;
		}

		// ��ü���̸� �ʰ��ϸ�
		if(li_byte > li_max){
			alert( li_max + " ���ڸ� �ʰ� �Է��Ҽ� �����ϴ�. \n �ʰ��� ���ڴ� �ڵ����� ���� �˴ϴ�. ");
			ls_str2 = ls_str.substr(0, li_len);
			aro_value.value = ls_str2;
			//document.fmParam.appLength.value=ari_max;
		}
	}

//-->
</SCRIPT>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name=fmParam method="post" action="../rch/RchMgrAction.do"  >

<!-- CUD ���-->
<input type=hidden name="cmd"  value="RchMgrCUD">
<input type=hidden name="mode" value="IU">
<input type=hidden name="RID" value="<%=request.getParameter("RID")%>">
<input type=hidden name="CT_ID" value="<%=request.getParameter("CT_ID")%>">

<!-- ����¡ ����(�ʼ�)-->
<input type=hidden name="nowPage"         value="<%=KJFUtil.print(pm.getNowPage())%>">
<input type=hidden name="scSLCT_GUBUN"         value="<%=KJFUtil.print(pm.getScSLCT_GUBUN())%>">
<input type=hidden name="scTEXTVALUE"         value="<%=KJFUtil.print(pm.getScTEXTVALUE())%>">

<input type=hidden name="nextURL">
<input type=hidden name="fromPage">

<!-- Ÿ��Ʋ ����-->
<input type="hidden"  name="titPgId"    value="<%= KJFUtil.print(request.getParameter("titPgId")) %>" >
<input type="hidden"  name="titPgGrId"  value="<%= KJFUtil.print(request.getParameter("titPgGrId")) %>" >


<!-- ��� Ÿ��Ʋ START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle"   value="�������� ����"/>
<jsp:param name="ButtonType" value="S,C"/></jsp:include>
<!-- ��� Ÿ��Ʋ END -->


<!-- �Էº� ������ �κ� START -->
<jsp:include page="../com/inc/bgBox_top_inc.jsp" flush="true"/>
<table width="100%"  border="0" cellspacing="0" cellpadding="5" class="inputTable" >
	<tr >
		<td width="70" class=inputTable_header_td>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</td>
		<td colspan=2 class="inputTable_td"><input type="text" name="TITLE" size="95" value="<%=rEntity.getValue(0, "TITLE")%>" required></td>
	</tr>
	<tr >
		<td class=inputTable_header_td>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</td>
		<td class="inputTable_td" colspan=2>
			<input name="S_DATE" type=text id="scStartDate" value="<%=rEntity.getValue(0, "S_DATE")%>" size="10" required="�������ڸ� �Է��ϼ���" readonly>
			<div id="div_start" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; " >
				<iframe src='../com/calander.jsp?frm=fmParam&fName=S_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onclick="MM_showHideLayers('div_start','','show')" align="absmiddle" style="cursor:hand" >
			~
			<input name="E_DATE" type=text id="scEndDate" value="<%=rEntity.getValue(0, "E_DATE")%>" size="10" required="�������ڸ� �Է��ϼ���" readonly>
			<div id="div_end" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; ">
				<iframe src='../com/calander.jsp?frm=fmParam&fName=E_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
			</div>
			<img src="../images/cal.gif" onclick="MM_showHideLayers('div_end','','show')" align="absmiddle" style="cursor:hand" >
		</td>
	</tr>
	<tr >
		<td class=inputTable_header_td>�������</td>
		<td class="inputTable_td" colspan=2>
			<%=publishLvl==1?"������ ����":(publishLvl==2?"������ ����":"�����")%>
		</td>
	</tr>
	<tr >
		<td height="40" class=inputTable_header_td>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</td>
		<td class="inputTable_td" colspan=2>
			<textarea name="RS_DESC" cols="72" rows="8"><%=rEntity.getValue(0, "RS_DESC")%></textarea></td>
	</tr>
	<%if(objQstCnt>0){%>
	<tr >
		<td class=inputTable_header_td>�� �� ��<br>
		  ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</td>
		<td class="inputTable_td">
			<table width="100%"  border="0" cellspacing="0" cellpadding="3">
			<%
				for(int i=0;i<objQstCnt;i++){
					oQstInpType = "Y".equals(objQstList.getValue(i,2))?"checkbox":"radio";
			%>
				<tr>
					<td>
						<span class="style1"><%=i+1%>. <%=objQstList.getValue(i,1)%></span>
						<%="Y".equals(objQstList.getValue(i,2))?"<font color='blue'>(�������䰡��)</font>":""%>
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
		<td class=inputTable_header_td>�� �� ��<br>
		  ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</td>
		<td class="inputTable_td">
			<table width="100%" border="0">
              <tr>
                <td width="16"><img src="../images/common/propedit_marker.gif" width="16" height="16" align="absmiddle"></td>
                <td><strong>�ְ��� ���״�  &quot;<span class="style2">300����</span>&quot; �̳����� �Է��Ͻ� �� �ֽ��ϴ�. </strong></td>
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
<!-- ����Ʈ  ���̺� END-->



<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
<input type=hidden name="objQstIdxs" value="<%=objQstIdxs%>">
</form>
</body>
</html>
