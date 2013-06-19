<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.sql.*, java.io.*, java.net.*, java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>전자서명 세션키암호화</title>

<script language='javascript' src='./gpkisecureweb/var.js'></script>
<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>
<script language='javascript' src='./gpkisecureweb/object.js'></script>

</OBJECT>	
</head>	

<body>
<table width="100%" height="100%">
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
			<table width="600" height="300" bgcolor="#F7F7F7">
				<tr>
				<!-- 전자서명-->
				<form name='encSignSession' action='./encSignJsessionPro.jsp' method="post">

					<td>
						<table>
							<tr>
								<td align="center" valign="middle">
									<table width="600">
										<tr>
											<td align="center" >전자서명+세션키암호화할 데이터&nbsp;</td>
											<td align="left">
											<input type="text" name="encSignData" size ="30" ></br>
											<input type="button" name="btn" value="전자서명+세션키" onClick="EncryptedSignData(encSignSession)">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>

					</td>
				</form>
				<!-- 전자서명-->
				</tr>
			</table>

		</td>
	</tr>
</table>
</body>
</html>
