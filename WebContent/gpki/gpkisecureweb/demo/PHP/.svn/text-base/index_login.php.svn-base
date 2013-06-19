<?
	$hidden = $_REQUEST['response'];
?>
<html>
<head><title></title></head>

<body background="img/login_bg.gif">
<?
	if($hidden=="pop") {
		$values = $_REQUEST['values'];
?>
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
                <td align="center" valign="top">
				  <table width="461" height="129"  border="0" cellpadding="0" cellspacing="0" style="margin-top:16px;">
                    <tr> 
                      <td align="right" valign="top" background="img/login_bg_m.gif"><table width="319" height="87" border="0" cellpadding="0" cellspacing="0" style="margin-top:23px;">
                          <tr> 
                            <td valign="middle">
							<?= $values." 인증서를 선택하여 로그인하셨습니다.<br>" ?>
							</td>
                          </tr>
                        </table>
					  </td>
                    </tr>
                  </table>
				  </br>
				<input type="button" onclick="window.open('./register.php','_self')" name="register" value="사용자등록">
		        </td>
              </tr>
			</table>

		  </td>
        </tr>
	</td>
  </tr>
</table>
<?
		}else if($hidden=="id_pass"){
			$id = $_REQUEST['id'];
			$pass = $_REQUEST['pass'];
?>
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

				<!-- 아이디/패스워드 -->
              <tr>
                <td align="center" valign="top">
				  <table width="461" height="129"  border="0" cellpadding="0" cellspacing="0" style="margin-top:16px;">
                    <tr> 
                      <td align="right" valign="top" background="img/login_bg_m.gif"><table width="319" height="87" border="0" cellpadding="0" cellspacing="0" style="margin-top:23px;">
                          <tr> 
                            <td valign="top">
							<?= "id와 password를 가지고 로그인하셨습니다.<br>" ?><br>
							<?= "아이디 : ".$id ?><br>
							<?= "비밀번호 : ".$pass ?>
							</td>
                          </tr>
                        </table>
					  </td>
                    </tr>
                  </table>
				  </br>
				<input type="button" onclick="window.open('./register.php','_self')" name="register" value="사용자등록">
		        </td>
              </tr>
			</table>
		  </td>
        </tr>
	</td>
  </tr>
</table>
<?
		}else if($hidden=="emb"){
			$pass = $_REQUEST['pass'];
			$ra =  $_REQUEST['cert'];
?>
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

				<!-- 임베디드 -->
              <tr>
                <td align="center" valign="top">
				  <table width="461" height="129"  border="0" cellpadding="0" cellspacing="0" style="margin-top:16px;">
                    <tr> 
                      <td align="right" valign="top" background="img/login_bg_m.gif"><table width="319" height="87" border="0" cellpadding="0" cellspacing="0" style="margin-top:23px;">
                          <tr> 
                            <td valign="top">
							<strong><?= $ra ?></strong> 인증서를 선택하여 로그인하셨습니다.<br>
							<?= "비밀번호 : ".$pass ?>
							</td>
                          </tr>
                        </table>
					  </td>
                    </tr>
                  </table>
				  </br>
				<input type="button" onclick="window.open('./register.php','_self')" name="register" value="사용자등록">
		        </td>
             </tr>
			</table>
		  </td>
        </tr>
	</td>
  </tr>
</table>
<?
		}else{
?>
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
                <td align="center" valign="top">
				  <table width="461" height="129"  border="0" cellpadding="0" cellspacing="0" style="margin-top:16px;">
                    <tr> 
                      <td align="right" valign="top" background="img/login_bg_m.gif"><table width="319" height="87" border="0" cellpadding="0" cellspacing="0" style="margin-top:23px;">
                          <tr> 
                            <td valign="top">
							<?= "잘못된 로그인입니다.<br>" ?><br>
							<a href=javascript:history.back()>뒤로</a>
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
	</td>
  </tr>
</table>
<?
		}
?>
</body>
</html>