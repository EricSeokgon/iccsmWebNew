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
<link href="/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>로그인01</title>

<script language='javascript' src='.\gpkisecureweb\var.js'></script>
<script language='javascript' src='.\gpkisecureweb\GPKIFunc.js'></script>
<script language='javascript' src='.\gpkisecureweb\object.js'></script>
</head>

<body background="img/login_bg.gif" >
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

			<!-- 팝업형식 -->
              <tr>
			  
			  <!-- Link Enc-->
			  <br><br>
			  <center>
			  <a href="Login01_S.php?challenge=<?= $challenge ?>" onclick="LoginLink(this);return false;"> 로그인</a>  
			  
</tr>
			  </center>
			</table>
		  </td>
        </tr>
	</td>
  </tr>
</table>
</body>
</html>
