<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.sql.*, java.io.*, java.net.*, java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>세션키 암호화</title>

	<script language='javascript' src='./gpkisecureweb/var.js'></script>
	<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>
	<script language='javascript' src='./gpkisecureweb/object.js'></script>

</head>	

<body>
<!-- 폼-->
<form name='encSession' action="./encJsessionPro.jsp" method="post">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" valign="center">
			<table width="600" valign="center" align="center"  bgcolor="#79A7D9">
				<tr>
					<td valign="center" align="center">
						<a href="encJsession.jsp"><font size="3" color="white">&nbsp;세션키암호화&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
						<a href="signJsession.jsp"><font size="3" color="white">&nbsp;전자서명&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
						<a href="encSignJsession.jsp"><font size="3" color="white">&nbsp;전자서명+세션키암호화&nbsp;</font></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td align="center" valign="middle">
			<table width="600" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align="center" valign="top" bgcolor="#F7F7F7">

						<TABLE style="MARGIN-TOP: 5px" cellSpacing=0 cellPadding=0 width=699 border=0>
							<TR>
								<TD class=tb align=right>
								<FONT color=red><B>*</B></FONT>표시는 필수입력사항입니다.
								</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>

				<TR>
					<TD vAlign=top>
						<TABLE cellSpacing=1 cellPadding=0 width=699 bgColor=#cccccc border=0>
							<TR bgColor=white>
								<TD class="tb pL10" bgColor=#daeef0 height=28>
									이<FONT color=#daeef0>....</FONT>름 <FONT color=red><STRONG>*</STRONG></FONT>
								</TD>
								<TD class=pL10 width=240 bgColor=#fffff7>
								<INPUT class=box_1c3 style="WIDTH: 157px" name=name>
								</TD>
								<TD class="tb pL10" width=107 bgColor=#daeef0>주민등록번호 <FONT color=red><STRONG>*</STRONG></FONT>
								</TD>
								<TD class=pL10 bgColor=#fffff7>
								<INPUT class=box_1c3 style="WIDTH: 50px" maxLength=6 name=ssn1> - 
								<INPUT class=box_1c3 style="WIDTH: 50px" maxLength=7 name=ssn2>
								</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>

				<TR>
					<TD vAlign=top height=22><SPAN class="tDb tb">일반사항입력</SPAN> <SPAN class=pL10>
					</TD>
				</TR>
			</table>
			<TABLE cellSpacing=1 cellPadding=0 width=699 bgColor=#cccccc border=0>
				<TR bgColor=white>
					<TD class="tb pL10" width=107 bgColor=#daeef0 height=28>부서명 <FONT color=red><STRONG>*</STRONG></FONT></TD>
					<TD class=pL10 bgColor=#fffff7 colSpan=3><INPUT class=box_1c3 style="WIDTH: 480px" name=depart></TD>
				</TR>
				<TR bgColor=white>
					<TD class="tb pL10" width=107 bgColor=#daeef0 height=28>회사주소 <FONT color=red><STRONG>*</STRONG></FONT></TD>
					<TD class=pL10 bgColor=#fffff7 colSpan=3><INPUT class=box_1c3 style="WIDTH: 480px"  name=address></TD>
				</TR>
				<tr>
					<TD class="tb pL10" width=107 bgColor=#daeef0>E-mail <FONT color=red><STRONG>*</STRONG></FONT></td>
					<TD  class=pL10 bgColor=#fffff7><INPUT class=box_1c3 style="WIDTH: 157px" name=email></TD>
				</TR>
				<TR bgColor=white>
					<TD class="tb pL10" bgColor=#daeef0 height=28>연락처</TD>
					<TD class=pL10 bgColor=#fffff7><INPUT class=box_1c3 style="WIDTH: 157px" name=homephone></TD>
				</tr>
				<tr>
					<TD class="tb pL10" bgColor=#daeef0>휴대폰</TD>
					<TD class=pL10 bgColor=#fffff7><INPUT class=box_1c3 style="WIDTH: 157px" name=mobile> </TD>
				</TR>
				<TR bgColor=white>
					<TD class="tb pL10" bgColor=#daeef0 height=28>직<FONT color=#daeef0>....</FONT>급</TD>
					<TD class=pL10 bgColor=#fffff7><INPUT class=box_1c3 style="WIDTH: 157px" name=emptype></TD>
				</tr>
				<tr>
					<TD class="tb pL10" bgColor=#daeef0>직<FONT color=#daeef0>....</FONT>위</TD>
					<TD class=pL10 bgColor=#fffff7><INPUT class=box_1c3 style="WIDTH: 157px" name=title></TD>
				</TR>
				<tr>
					<td colspan="2">
						<Center>	
						<input type="button" name="btn" value="세션키암호화" onClick="Encrypt(encSession)"> 
					</td>
				</tr>

			</TABLE>
		</TD>
	</TR>
</TABLE>
</form>

</body>
</html>
