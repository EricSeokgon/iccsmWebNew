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
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>EnvelopedData</title>

<script language='javascript' src='.\gpkisecureweb\var.js'></script>
<script language='javascript' src='.\gpkisecureweb\GPKIFunc.js'></script>
<script language='javascript' src='.\gpkisecureweb\object.js'></script>
	
</head>	

<body background="img/login_bg.gif">
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
		    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px solid #DFDFDF">

				<!-- 전자서명 -->
			  <tr>
				<form name='envDataPhp' action='EnvData_S.php' method="post">
				<td>
					<table width="100% border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td align="center" valign="middle">
								<table width="461" height="129" border="0" cellpadding="0" cellspacing="0" background="img/login_bg_m.gif">
									<tr align="right" valign="top">
										<td width="500">암호화할 데이터 : &nbsp;</td>
										<td align="left" valign="top">
										<input type="text" name="id" size ="30" >
										<input type="text" name="pass" size ="30" >
										<input type="hidden" name="challenge" value=<?=$challenge?>><BR> 
										<input type="button" name="btn" value="SignData(Php)" onClick="EnvelopedData(envDataPhp)">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

				</td>
				</form>
			  </tr>
			</table>
			
		  </td>
        </tr>
	</td>
  </tr>
</table>
</body>
</html>
