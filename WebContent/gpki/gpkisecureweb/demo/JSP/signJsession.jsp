<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.sql.*, java.io.*, java.net.*, java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>���ڼ���</title>
	<script language='javascript' src='./gpkisecureweb/var.js'></script>
	<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>
	<script language='javascript' src='./gpkisecureweb/object.js'></script>
</head>	

<body>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" valign="center">
			<table width="600" valign="center" align="center"  bgcolor="#79A7D9">
				<tr>
					<td valign="center" align="center">
						<a href="encJsession.jsp"><font size="3" color="white">&nbsp;����Ű��ȣȭ&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
						<a href="signJsession.jsp"><font size="3" color="white">&nbsp;���ڼ���&nbsp;</font></a>&nbsp;<font size="3" color="white">/</font>&nbsp;
						<a href="encSignJsession.jsp"><font size="3" color="white">&nbsp;���ڼ���+����Ű��ȣȭ&nbsp;</font></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td align="center" valign="middle">
			<table width="600" height="200" bgcolor="#F7F7F7">
				<!-- ���ڼ��� -->
				<tr>
					<form name='signSession' action='./signJsessionPro.jsp' method="post">
						<td>
							<table width="100%" height="100%" align="center">
								<tr>
									<td align="right">������ ������&nbsp;</td>
									<td align="left" valign="middle">
									<input type="text" name="signData(JSP)" size ="30" >
									<input type="button" name="btn" value="���ڼ���" onClick="SignedDataForm(signSession)">
									</td>
								</tr>
							</table>
						</td>
					</form>
				</tr>
				<!-- ���ڼ���-->
			</table>
		</td>
	</tr>
</table>
</body>
</html>
