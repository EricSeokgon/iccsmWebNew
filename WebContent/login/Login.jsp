<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url();
	background-color: #6aa9e7;
}
-->
</style>
<script language="JavaScript">

function login(){

	var fm = document.fmParam;

	// 아이디 저장
	if (fm.idSave.checked==true){
		var expDays = 365; // number of days the cookie should last
		var expDate = new Date();
		expDate.setTime(expDate.getTime() +  (24 * 60 * 60 * 1000 * expDays));

		setCookie('bcrc_admin_id', fm.id.value, expDate);

	} else {

		var expDays = 365; // number of days the cookie should last
		var expDate = new Date();
		expDate.setTime(expDate.getTime() +  (24 * 60 * 60 * 1000 * expDays));

		setCookie('bcrc_admin_id', 'no id', expDate);
	}


	fm.action="../login/LoginAction.do?cmd=LoginAdmin";
	fm.target = "_self";
	fm.submit();
}


function readID() {
	var expDays = 365; // number of days the cookie should last
	var expDate = new Date();
	expDate.setTime(expDate.getTime() +  (24 * 60 * 60 * 1000 * expDays));
	var id = getCookie('bcrc_user_id');

	var fm = document.fmParam;

	if(id == "no id" || id==null) {
		fm.USER_ID.value = "";
		fm.USER_PASSWD.value="";
		fm.idSave.checked=false;
	}else{

		fm.USER_ID.value = id;
		fm.USER_PASSWD.value="";

		fm.idSave.checked=true;
	}
}

function onKeyPressEnter () {
	var keycode;
	if (window.event) keycode = window.event.keyCode;
	else if (e) keycode = e.which;
	else return false;

	if (keycode == 13) {    //엔터키를 눌렀을때
		var fm = document.fmParam;
		fm.USER_PASSWD.focus();
	return false
	}
}

//-->
</script>
</head>

<body leftmargin="0" topmargin="0" onload="readID();document.fmParam.USER_ID.focus()" oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
<FORM name="fmParam"  METHOD=POST ACTION="../login/LoginAction.do?cmd=LoginAdmin" onSubmit='return false'>

<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="980" height="600" valign="top" background="../images/login/login_main.jpg">
	    <table width="587" border="0" cellpadding="0" cellspacing="0">
	      <tr>
            <td width="822" height="365">
	            <div align="center"> 
	                <p><strong><font size="5"><br>
	                  <br>
	                  </font></strong></p>
	                <p>&nbsp;</p>
	            </div>
            </td>
	      </tr>
	      
	      <tr>
	        <td valign="top">
		        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td width="270">&nbsp;</td>
		            <td>
			            <table  border="0" cellspacing="0" cellpadding="0">
			              <tr>
			                <td><img src="../images/login/id.gif" width="92" height="18"></td>
			                <td width="120"><input name="USER_ID" type="text"  class="input_login"  style="width:110px;" required="아이디를 입력 하세요." value="" onKeydown="onKeyPressEnter()" tabindex='1' autocomplete="off"></td>
			                <td rowspan="2"><img src="../images/login/btn_login.gif" width="45" height="45" onclick="kjsSubmit('fmParam');" onfocus='this.blur()' style='cursor:hand'></td>
			              </tr>
			              <tr>
			                <td><img src="../images/login/password.gif" width="92" height="18"></td>
			                <td><input name="USER_PASSWD" type="password" class="input_login"  style="width:110px;" required="비밀 번호를 입력 하세요." value="" onKeyDown="execFuncOnEnt('login')" tabindex='2' autocomplete="off"></td>
			              </tr>
			              <tr>
			                <td colspan="3" align="right" style="font-size:11px;"><input name="idSave" type="checkbox" tabindex='3'> 아이디저장</td>
			              </tr>
			            </table>
		            </td>
		          </tr>
		        </table>
	        </td>
	      </tr>
	      
	    </table>
    </td>
    
    <td background="../images/login/login_main_bg.jpg">&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>
