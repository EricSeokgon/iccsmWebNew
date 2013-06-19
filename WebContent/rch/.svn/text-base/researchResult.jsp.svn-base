<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.util.HashMap,java.util.ArrayList" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.uent.UserEnt" %>
<%

	//초기 변수 들 선언
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

	ReportEntity objQstList = (ReportEntity)request.getAttribute("objQstList");
	ReportEntity sbjQstList = (ReportEntity)request.getAttribute("sbjQstList");

	int objQstCnt = objQstList.getRowCnt();
	int sbjQstCnt = sbjQstList.getRowCnt();

	HashMap oAnsMap = (HashMap)request.getAttribute("oAnsMap");
	HashMap sAnsMap = (HashMap)request.getAttribute("sAnsMap");
	HashMap etcAnsMap = (HashMap)request.getAttribute("etcAnsMap");
	
	UserEnt user = (UserEnt)session.getAttribute("user");

	boolean isAdmin = user.isAdmin();

	String funcBtn = "P,GL";

	if (isAdmin) {
		funcBtn = "P,E,GL";
	}

	int totJoinCnt = KJFUtil.str2int((String)request.getAttribute("totJoinCnt"));
	boolean signRch = "RCH_SIGN".equals(rEntity.getValue(0, "CT_ID"));
%>
<html>

<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>설문조사 상세보기</title>
<style type="text/css">
<!--
.style1 {font-weight: bold}
-->
</style>
</head>

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">

<script language="javascript" src="../com/js/httpRequest.js" type="text/javascript"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--

	//본문 내용 출력
	function fn_print(){
		//centerwin('../com/pagePrint.jsp','printwin', '760', '500', '1');
		printwin = window.open("../com/pagePrint2.jsp","print","left=100px;top=10px;height=500,width=760,scrollbars=yes,toolbar=yes,menubar=yes");
		printwin.focus();
	}

	function fn_cancel(){
		<%if("view".equals(request.getParameter("fromPage"))) {%>
			history.back();
		<%} else {%>
			document.fmParam.submit();
		<%}%>
	}

	function fn_list(){
		<%if("view".equals(request.getParameter("fromPage"))) {%>
			var fm = document.fmParam;
			fm.cmd.value="RchL";
			fm.submit();
		<%} else {%>
			document.fmParam.submit();
		<%}%>
	}

	// 엑셀 출력 처리
	function fn_excel(){
		var fm = document.fmParam;

		var RID = fm.RID.value;
		var CT_ID = fm.CT_ID.value;

		var param = "&RID=" + RID + "&CT_ID="+CT_ID;
		excelFrame.document.location.href="../rch/RchMgrAction.do?cmd=RchExcel"+param;
	}

//-->
</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name=fmParam method="post" action="../rch/RchMgrAction.do"  >

<!-- CUD 모드-->
<input type=hidden name="cmd" value="RchL">
<input type=hidden name="mode">
<input type=hidden name="RID" value="<%=request.getParameter("RID")%>">
<input type=hidden name="CT_ID" value="<%=request.getParameter("CT_ID")%>">

<!-- 페이징 관련(필수)-->

<!-- 타이틀 정보-->
<input type="hidden"  name="titPgId"    value="<%= KJFUtil.print(request.getParameter("titPgId")) %>" >
<input type="hidden"  name="titPgGrId"  value="<%= KJFUtil.print(request.getParameter("titPgGrId")) %>" >


<!-- 상단 타이틀 START -->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value="설문조사 결과보기"/>
<jsp:param name="ButtonType" value="<%=funcBtn %>"/>
</jsp:include>
<!-- 상단 타이틀 END -->

<span id='PrintDiv'>
<!-- 입력부 디자인 부분 START -->
<jsp:include page="../com/inc/noBox_top_inc.jsp" flush="true"/>
<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="inputTable" >
	<tr >
	  <td width="70" class=inputTable_header_td>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</td>
		<td colspan=2 class="inputTable_td"><strong><%=rEntity.getValue(0, "TITLE")%></strong></td>
	</tr>
	<tr >
	  <td class=inputTable_header_td>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;간</td>
		<td class="inputTable_td" colspan=2>
			<%=rEntity.getValue(0, "S_DATE")%> ~ <%=rEntity.getValue(0, "E_DATE")%>
		</td>
	</tr>
	<tr >
		<td class=inputTable_header_td>등&nbsp;록&nbsp;인</td>
		<td class="inputTable_td" colspan=2><%=rEntity.getValue(0, "USER_INFO")%></td>
	</tr>
	<tr >
	  <td height="40" class=inputTable_header_td>내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용</td>
		<td class="inputTable_td" colspan=2><%=rEntity.getValue(0, "RS_DESC").replaceAll("\n", "<br>")%></td>
	</tr>
	<% if(objQstCnt > 0) {%>
	<tr >
	  <td class=inputTable_header_td>참여자수</td>
	  <td class="inputTable_td style1" >전체 <%=totJoinCnt%> 명</td>
	  </tr>
	<tr >
	  <td class=inputTable_header_td>객 관 식<br>
  질&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</td>
		<td class="inputTable_td" >
			<table width="100%"  border="0" cellspacing="0" cellpadding="3">
			<% for(int i = 0; i < objQstCnt; i++) {%>
				<tr>
					<td>
						<b><%=i+1%>. <%=objQstList.getValue(i, 1)%></b> <%="Y".equals(objQstList.getValue(i,2))?"<font color='blue'>(복수응답)</font>":""%>
					</td>
				</tr>
				<tr>
					<td style="padding-left:20px; " >
						<table border=0 width="600">
						<%
						String tempSeq = objQstList.getValue(i,0);

						ArrayList oAnsList = (ArrayList)oAnsMap.get(tempSeq);

						if (oAnsList.size() > 0) {

							for(int j = 0; j < oAnsList.size(); j++) {

								String[] rsArr = (String[])oAnsList.get(j);
								if(rsArr[0].startsWith("ETC_ANS")){
									out.println("<tr><td width='10'></td><td width=250 colspan=3 style='padding:3px;line-height:120%;'> "+rsArr[0].substring(7)+"");
									out.println("<table width=550 border=1 cellspacing=0 cellpadding=3>");
									ArrayList etcAnsList = (ArrayList)etcAnsMap.get(tempSeq);
									for (int k=0;k<etcAnsList.size();k++){
										String[] etcAnsArr = (String[])etcAnsList.get(k);
										out.println("<tr><td width=150>"+(signRch?etcAnsArr[0]:"&nbsp;")+"</td><td width=400>"+etcAnsArr[1]+"</td></tr>");
									}
									out.println("</table></td></tr>");
								}else{
									int cntVote= KJFUtil.str2int(rsArr[1]);
									int rate = 0;

									if (totJoinCnt > 0) {
										rate = (int)cntVote*100/totJoinCnt;
									}

									out.println("<tr><td width='10'>"+(j+1)+".</td><td width=250 style='padding:3px;line-height:120%; word-break:break-all'> "+rsArr[0]+"</td>");
									out.println("<td width=250 height=20><table width=100% height=7><tr><td bgcolor=#CCCCCC><img src='../images/graph.gif' height=7 width='"+rate+"%'></td></tr></table></td>");
									out.println("<td>"+cntVote+"명 ("+rate+"%)</td></tr>");
								}
							}
						}
						%>
						</table>
					</td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>
			<%}%>
			</table>
		</td>
	</tr>
	<%}%>

	<% if (sbjQstCnt > 0) {%>
	<tr >
	  <td class=inputTable_header_td>주 관 식<br>
  질&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</td>
		<td class="inputTable_td">
			<table width="100%"  border="0" cellspacing="0" cellpadding="3">
			<% for(int i = 0; i < sbjQstCnt; i++) { %>
				<tr>
					<td><span class="style1"><%=i+1%>. <%=sbjQstList.getValue(i,1)%></span></td>
				</tr>
				<tr>
					<td class="" style="padding-left:20px; ">
						<table border=0 width="95%">
						<%
						String tempSeq = sbjQstList.getValue(i,0);
						ArrayList sAnsList = (ArrayList)sAnsMap.get(tempSeq);

						if (sAnsList != null) {
							for(int j = 0; j < sAnsList.size(); j++) {
								String[] rsArr = (String[])sAnsList.get(j);
								out.println("<tr><td style='padding:3px;line-height:120%; word-break:break-all' height='20'><span style='background-color:#e6f0f9; width:100%; padding:7px;'><img src='../images/common/forum.gif' width='16' height='16' align='absmiddle'><b>"+(signRch?rsArr[0]:"")+"</b> : "+KJFUtil.rplc(KJFUtil.rplc(rsArr[1],"\n","<br>")," ","&nbsp;")+"</span></td></tr>");
							}
						}
						%>
						</table>
					</td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>
			<%}%>
			</table>
		</td>
	</tr>
	<%} %>
</table>

<jsp:include page="../com/inc/noBox_bottom_inc.jsp" flush="true"/>
<!-- 리스트  테이블 END-->
</span>

<!-- 하단 버튼 START -->
<jsp:include page="../com/inc/title_inc_bottom.jsp" flush="true">
<jsp:param name="ButtonType" value="<%=funcBtn %>"/></jsp:include>
<!-- 하단 버튼 END --> 

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
</form>

<iframe name="excelFrame" src="" width="100" height="0"></iframe>
</body>
</html>
