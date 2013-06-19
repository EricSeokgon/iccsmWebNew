<?php
	// 응용어플단 로직   
	include 'gpkisecureweb.php';
  
	$gpkiobj = &new GPKISecureWEB('D:/Java/Apache2/htdocs/conf');
	$ex = java_last_exception_get();
	if ($ex) {
	  echo '[GPKISecureWeb Error]'.$ex->toString();
	  java_last_exception_clear();
	  return;
	}
	
?>
<?
	$challenge =$gpkiobj->get_challenge();
?>
<html>
<head>
<title>로그인01</title>

<script language='javascript' src='.\gpkisecureweb\var.js'></script>
<script language='javascript' src='.\gpkisecureweb\GPKIFunc.js'></script>
<script language='javascript' src='.\gpkisecureweb\object.js'></script>
</head>

<body background="img/login_bg.gif" OnLoad='document.LoginData.pwd.focus()' >
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="middle">
	  <table width="621" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td align="left"><img src="img/top_ci.gif"></td>
        </tr>
        <tr> 
          <td height="10" align="left"></td>
        </tr>
        <tr> 
          <td align="center"><img src="img/login_tlt.gif"></td>
        </tr>
        <tr>
          <td align="center" valign="top" bgcolor="#F7F7F7">
		    <table height="146" width='290' border="0" cellspacing="0" cellpadding="0">        	
							<form name = 'LoginData' action='Login01_S.php' method='post'onSubmit='return false;'>
	
							<tr>
								<td  height='130' colspan='3'>
									<!-- 인증서 ActiveX 삽입 -->
									<script language='javascript' src='.\gpkisecureweb\object.js'></script>
									<!-- 인증서 ActiveX 삽입 끝-->
								</td>
							</tr>
							
							<tr>
								<td>
									<table border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width='80'>&nbsp;<font size = 2>인증서 암호: </font></td>
											<td><input type="password" name="pwd" value="" size='15' onkeydown=embeddedEnterEvent(this.form);>&nbsp;</td>
											<input type="hidden" name="challenge" value=<?=$challenge?>><BR> 
											<td><img name="confirm" src="./img/login_button.gif" style="cursor:hand;"  border='0' onClick="LoginEmbedded(LoginData);"></td>
								   		</tr>
								   	</table>
								</td>
							</tr>
								
							</form>
			</table>
		  </td>
        </tr>
	</td>
  </tr>
</table>
</body>
</html>
