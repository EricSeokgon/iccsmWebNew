<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="kjf.util.KJFUtil" %>
<%@ page import="kjf.util.KJFDate" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="sp.main.*" %>
<%@ page import="sp.bbs.BbsJsp" %>
<%@ page import="sp.uent.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%
	BbsJsp bj = new BbsJsp();
	ReportEntity notice = bj.mainboardNoticeList("board_01");
	ReportEntity faq = bj.mainboardNoticeList("board_09");
	ReportEntity qna = bj.mainboardNoticeList("board_11");
	UserEnt  user=(UserEnt)session.getAttribute("user");
%>

<html>
<head>
<title> IPARK 관리자 </title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/styleAdmin.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>

<script>
function fn_viewDetail(CT_ID,SEQ){
	var fm = document.fmParam;

	centerwin('','nWin', 750, 450,'1');

	fm.cmd.value		= "BbsKView";
	fm.BOARD_SEQ.value	= SEQ;
	fm.CT_ID.value 		= CT_ID;

	fm.action = "../bbs/BbsAction.do";
	fm.target = "nWin";
	fm.method = "post";

	fm.submit();
}

function fn_viewList(CT_ID){
	var fm = document.fmParam;

	centerwin('','nWin', 750, 450,'1');

	fm.cmd.value		= "BbsKList";
	fm.CT_ID.value 		= CT_ID;

	fm.action = "../bbs/BbsAction.do";
	fm.target = "nWin";
	fm.method = "post";

	fm.submit();
}

</script>
</head>

<body topmargin="0" leftmargin="0" bgcolor="ffffff">
<form name="fmParam">
<input type="hidden" name=scMonth>
<input type="hidden" name=cmd>
<input type=hidden name="BOARD_SEQ">
<input type=hidden name="CT_ID"    >
<input type=hidden name="URL" value="/bbs/bbs.jsp">
<table width="968" border="0" cellspacing="0" cellpadding="0" height="100%">
	<tr>
		<!--좌측메뉴-->
		<td background="../images/left_bg.gif" width="218" height="100%" valign="top">
			<table cellspacing="0" cellPadding="0" width="218" align="center" border="0">
				<tr>
					<td valign="middle" bgcolor="efefef" width="218" height="50">
						<!-- 로그인 시작 -->
						<table width="218" border="0" cellpadding="0" cellspacing="0" valign="top">
							<tr>
								<td width="150" align="center">안녕하세요. <b><%=user.getUSER_ID()%></b>님</td>
								<td width="68"><img src="../images/btn_logout.gif" onclick="parent.parent.location.href

='../login/LoginAction.do?cmd=LogOut';" style="cursor:hand"></td>
							</tr>
						</table>
						<!-- 로그인 끝 -->
					</td>
				</tr>
				<tr>
					<td align="center" height="5"><Img src="../images/title_bar.gif" width="218"></td>
				</tr>
			</table>
		</td>
		<!--좌측메뉴-->
		<td valign="top" align="left" width="750">
			<table width="750" border="0" cellspacing="0" cellpadding="0" >
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr><td height="11" colspan="3"></td></tr>
							<tr>
								<td valign="top">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td height="45" colspan="2"></td></tr>
										<tr>
											<td width="50%" valign="top">
												<!--news table start-->
												<table width="100%" border="0" cellspacing="0"

cellpadding="0">
													<tr>
														<td width="95" valign="top"><a

href="javascript:fn_viewList('board_01');"><img src="images/b_news_title.gif" border="0"></a></td>
														<td valign="top">
															<table width="100%" border="0"

cellspacing="0" cellpadding="0">
																<%
																for (int i=0;i<

notice.getRowCnt();i++ ){
																%>
																<tr><td height="1"

colspan="2" bgcolor="E6E6E6"></td></tr>
																<tr>
																	<td height="24"

style=padding-left:5><a href="javascript:fn_viewDetail('board_01','<%= notice.getValue(i,"BOARD_SEQ") %>')" onfocus='this.blur()'><span class=notice><font

color=32345B><%=KJFUtil.java2html(KJFUtil.getTitleLimit(notice.getValue(i,"SUBJECT"),24))%></font></span></a></td>
																	<td width="40%"

align="right" class="num"><%=KJFDate.dateOnly(KJFDate.str2date(notice.getValue(i,"INP_DT"),""))%></td>
																</tr>
																<tr><td height="1"

colspan="2" bgcolor="E6E6E6"></td></tr>
																<%
																	}
																if (notice==null ||

notice.getRowCnt()==0){
																%>
																<tr>
																	<td align="center"

colspan="6">등록된 자료가 없습니다.</td>
																</tr>
																<tr>
																	<td colspan=6

bgcolor=#DCDFE5 height=1></td>
																</tr>
																<%}%>
															</table>
														</td>
													</tr>
												</table>
												<!--News table end-->
											</td>
											<td valign="top">
												<!--Faq table start-->
												<table width="100%" border="0" cellspacing="0"

cellpadding="0">
													<tr>
														<td width="95" valign="top"><a

href="javascript:fn_viewList('board_09');"><img src="images/b_faq_title.gif" border="0"></a></td>
														<td valign="top">
															<table width="100%" border="0"

cellspacing="0" cellpadding="0">
																<%
																for (int i=0;i<

faq.getRowCnt();i++ ){
																%>
																<tr>
																	<td height="1"

colspan="2" bgcolor="E6E6E6"></td>
																</tr>
																<tr>
																	<td height="24"

style=padding-left:5><a href="javascript:javascript:fn_viewDetail('board_09','<%= faq.getValue(i,"BOARD_SEQ") %>')" onfocus='this.blur()'><span

class=notice><font color=32345B><%=KJFUtil.java2html(KJFUtil.getTitleLimit(faq.getValue(i,"SUBJECT"),24))%></font></span></a></td>
																	<td width="40%"

align="right" class="num"><%=KJFDate.dateOnly(KJFDate.str2date(faq.getValue(i,"INP_DT"),""))%></td>
																</tr>
																<tr>
																	<td height="1"

colspan="2" bgcolor="E6E6E6"></td>
																</tr>
																<%
																	}
																if (faq==null ||

faq.getRowCnt()==0){
																%>
																<tr>
																	<td align="center"

colspan="6">등록된 자료가 없습니다.</td>
																</tr>
																<tr>
																	<td colspan=6

bgcolor=#DCDFE5 height=1></td>
																</tr>
																<%}%>
															</table>
														</td>
													</tr>
												</table>
												<!--Faq table end-->
											</td>
										</tr>
										<tr><td height="30" colspan="2"></td></tr>
										<tr>
											<td valign="top">
												<!--Qna table start-->
												<table width="100%" border="0" cellspacing="0"

cellpadding="0">
													<tr>
														<td width="95" valign="top"><a

href="javascript:fn_viewList('board_11');"><img src="images/b_qna_title.gif" border="0"></a></td>
														<td valign="top">
															<table width="100%" border="0"

cellspacing="0" cellpadding="0">
																<%
																for (int i=0;i<

qna.getRowCnt();i++ ){
																%>
																<tr>
																	<td height="1"

colspan="2" bgcolor="E6E6E6"></td>
																</tr>
																<tr>
																	<td height="24"

style=padding-left:5><a href="javascript:viewDetail('board_11','<%= qna.getValue(i,"BOARD_SEQ") %>')" onfocus='this.blur()'><span class=notice><font

color=32345B><%=KJFUtil.java2html(KJFUtil.getTitleLimit(qna.getValue(i,"SUBJECT"),24))%></font></span></a></td>
																	<td width="40%"

align="right" class="num"><%=KJFDate.dateOnly(KJFDate.str2date(qna.getValue(i,"INP_DT"),""))%></td>
																</tr>
																<tr>
																	<td height="1"

colspan="2" bgcolor="E6E6E6"></td>
																</tr>
																<%
																	}
																if (qna==null ||

qna.getRowCnt()==0){
																%>
																<tr>
																	<td align="center"

colspan="6">등록된 자료가 없습니다.</td>
																</tr>
																<tr>
																	<td colspan=6

bgcolor=#DCDFE5 height=1></td>
																</tr>
																<%}%>
															</table>
														</td>
													</tr>
												</table>
												<!--Qna table end-->
											</td>
											<td valign="top">
												<!--Help Desk table start-->
												<table  border="0" cellspacing="0" cellpadding="0">
													<tr valign="top">
														<td height="28" colspan="4"><img

src="images/help01.gif"></td>
													</tr>
													<tr>
														<td width="13"></td>
														<td><a href="#"><img src="images/help02.gif"

border="0"></a></td>
														<td width="5"></td>
														<td><a href="#"><img src="images/help03.gif"

border="0"></a></td>
													</tr>
												</table>
												<!--Help Desk table end-->
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>

<%--


	--%>