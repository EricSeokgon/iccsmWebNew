<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.popup.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%

	PopUpParam pm = (PopUpParam)request.getAttribute("pm");

	String seq = KJFUtil.print(pm.getP_SEQ());
	String body = KJFUtil.print(pm.getP_BODY());
	String title = KJFUtil.print(pm.getP_TITEL());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<title>::대한주택관리사::</title>
<script language="JavaScript">
	function notice_setCookie( name, value, expiredays )
	{
	    var todayDate = new Date();
	    todayDate.setDate( todayDate.getDate() + expiredays );
	    document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
	}
	function notice_closeWin()
	{
	   	notice_setCookie( "PopId_<%=seq%>", "done" , 1); // 1=하룻동안 공지창 열지 않음
	    self.close();
	}


	function resizeWin(){
	
		var sHeight = 0;
		if(navigator.appName.indexOf("Microsoft") > -1){ 
			if(navigator.appVersion.indexOf("MSIE 6") > -1){ 
				sHeight = document.body.scrollHeight+70;
			}else if(navigator.appVersion.indexOf("MSIE 7.0") > -1){
			  	sHeight = document.body.scrollHeight+70;
			}
		}else{
			sHeight = document.body.scrollHeight+55;
		}
		
		var sWidth = document.body.scrollWidth+10;
		window.resizeTo(sWidth,sHeight);
		
	}
</script>
</head>

<body leftmargin="0" topmargin="0" onload="resizeWin()">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#F1F6F1">
  <tr>
    <td style="padding-left:10; padding-right:10; padding-bottom:10; padding-top:10;">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="124"><img src="../../images/popup/popup_t_1.gif"></td>
		<td width="100%" bgcolor="#33A134">&nbsp;</td>
		<td  width="171" align="right"><img src="../../images/popup/popup_t_2.gif"></td>
		</tr>
    </table>
	</td>
  </tr>
  <tr><td height="42" align="center" style="font-size:15px; color:#000000;"><b><%=title%></b></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#ffffff">
	  <table width="96%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="20"></td></tr>
  <tr><td><%=KJFUtil.FCKeditorView2(body)%></td></tr> 
  <tr><td height="20"></td></tr>

</table></td>
  </tr>
</table>
</td>
  </tr>
</table>
</td>
  </tr>
<tr>
    <td height="30" align="center" bgcolor="#C0DBC0">
    <input type="checkbox" name="cbk" onclick="notice_closeWin()">오늘 하루만 이 창을 열지않음
	<input type=button value="닫기" onclick="self.close()"> </td>
  </tr>
</table>
</body>
</html>
