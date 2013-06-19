<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.user.UserParam" %>
<%

	//초기 변수 들 선언
	UserParam pm			=(UserParam)request.getAttribute("pm");
	String userID			= pm.getScUSER_ID();
	String isUserID			= (String)request.getAttribute("isUserID");
	String id_img			= "images/id_check01.gif";
	
	if("Y".equals(isUserID)) id_img = "images/id_check02.gif"; 
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>아이디 검색</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="../com/js/kjs.js"></script>
<script>
<!--
function beforeKjs(){
	var fm = document.fmParam;
	
	return true;
}

function closeWin(){
	var fm = document.fmParam;
	if(fm.USER_ID.value != fm.saveUserID.value){
		alert("중복검사를 하십시오");
		fm.isUserID.value="";
		fm.USER_ID.focus();
		return;
	}

	if(fm.isUserID.value == "Y"){
		var isOk = confirm("등록된 아이디 입니다.\n\r \n\r다시 검색하여 주십시오.");
		
		if(isOk){
			fm.USER_ID.value = "";
			fm.USER_ID.focus();
		}else{
			this.close();
		}
	}else if(fm.isUserID.value == "N"){
		opener.document.fmParam.USER_ID.value = fm.USER_ID.value;
		opener.document.fmParam.saveUserID.value = fm.USER_ID.value;
		opener.document.fmParam.isIDCheck.value = true;
		this.close();
	}
}
-->
</script>
</head>

<body leftmargin="0" topmargin="0">
<form name="fmParam" method="post"  action="../user/UserAction.do?cmd=UserIDCheck" >
<input type=hidden name="isUserID" value="<%=isUserID%>" >
<input type=hidden name="saveUserID" value="<%=userID%>">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="images/id_check_top01.gif" width="400" height="86"></td>
  </tr>
  <tr>
    <td height="80" align="center" background="images/id_check_bg.gif"><table border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="<%=id_img%>" width="279" height="38"></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><table border="0" cellspacing="0" cellpadding="3">
          <tr>
            <td><img src="images/id.gif" width="46" height="12"></td>
            <td>
            	<input type=text 
            	class=input 
            	size=21 
            	name="USER_ID" 
            	value="<%=userID%>"
            	required="아이디"
            	maxLength=16
            	minLength=4>
            </td>
            <td><a href="javascript:kjsSubmit('fmParam');"><img src="images/btn_dup.gif" width="80" height="18"  border="0"></a></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign=bottom><img src="images/close.gif" width="400" height="60" border="0" usemap="#Map"></td>
  </tr>
</table>

<map name="Map"><area shape="rect" coords="164,35,237,61" href="javascript:closeWin();">
</map>
</form>
</body>
</html>
