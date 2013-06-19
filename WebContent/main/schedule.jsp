<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="kjf.util.KJFUtil" %>
<%@ page import="kjf.util.KJFDate" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="sp.main.*" %>
<%
MainParam pm = (MainParam)request.getAttribute("pm");
ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>부산 공무원 교육원</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<meta http-equiv="imagetoolbar" content="no">
<link href="../com/css/styleAdmin.css" rel="stylesheet" type="text/css">
<style>
body, table, tr, td, select, input,div,form,textarea
{font-family:돋움;font-size:12px;color:#000000;line-height:18px} 
A:link { color:#000000; text-decoration:none;line-height:18px} 
A:visited {color:#000000; text-decoration:none;line-height:18px} 
A:active {color:#000000;  text-decoration:none;line-height:18px} 
A:hover { color:#272727; text-decoration:none;line-height:18px} 

input,select,textarea{
font-family:돋움; font-size:9pt; color:#353535; line-height:150%;
border-width:1px; border-color:rgb(197,197,197); border-style:solid;}
</style>



<SCRIPT LANGUAGE="JavaScript">
function verScroll__(dir, spd, loop) {
	loop = true;
	direction = "up";
	speed = 10;
	scrolltimer = null;
	
	if (document.layers) {
		var page = eval(document.contentLayer);
	}else {
		if (document.getElementById) {
			var page= eval("document.getElementById('contentLayer').style");
		}else {
			if (document.all) {
				var page = eval(document.all.contentLayer.style);
	      	}
	   	}
	}
	
	direction = dir;
	speed = parseInt(spd);
	var y_pos = parseInt(page.top);

	if (loop == true) {
		if (direction == "dn") {
			page.top = (y_pos - (speed));
		} else {
			if (direction == "up" && y_pos < 10) {
				page.top = (y_pos + (speed));
			} else {
				if (direction == "top") {
					page.top = 10;
	      		}
	   		}
		}
		scrolltimer = setTimeout("verScroll(direction,speed)", 50);
	}
}

function verScroll(dir, spd, loop) {
loop = true;
direction = "up";
speed = 10;
scrolltimer = null;
if (document.layers) {
var page = eval(document.contentLayer);
}
else {
if (document.getElementById) {
var page= eval("document.getElementById('contentLayer').style");
}
else {
if (document.all) {
var page = eval(document.all.contentLayer.style);
      }
   }
}
direction = dir;
speed = parseInt(spd);
var y_pos = parseInt(page.top);
if (loop == true) {
if (direction == "dn") {
page.top = (y_pos - (speed));
} else {
if (direction == "up" && y_pos < 10) {
page.top = (y_pos + (speed));
} else {
if (direction == "top") {
page.top = 10;
      }
   }
}
scrolltimer = setTimeout("verScroll(direction,speed)", 1);
   }
}

function stopScroll() {
	loop = false;
	clearTimeout(scrolltimer);
}
</script>

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="">
<!--  <div id="contentLayer" style="position:absolute;width:100%;height:120px;z-index:1; left:0px; top: 50px">
-->
<marquee id="scroller" scrollAmount=2 direction=up width=150 height=120 style="text-align:center">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
<%
if(rEntity != null && rEntity.getRowCnt()!=0){
	for(int i=0;i<rEntity.getRowCnt();i++){
%>
  <tr> 
	<td width="18" height="40" valign="top"><img src="images/cal_icon.gif"></td>
	<td><a href="#"><b><%=rEntity.getValue(i,"COUR_NAME") %><br>
	  <%=rEntity.getValue(i,"PERIOD") %></b></a></td>
  </tr>
  <tr><td height="1" colspan="2" bgcolor=E4E4E2></td></tr>
<%		
	}
}else{
%>
	<tr> 
	<td width="18" height="40" valign="top"><img src="images/cal_icon.gif"></td>
	<td><b>해당 교육 과정이 없습니다.</b></td>
  </tr>
  <tr><td height="1" colspan="2" bgcolor=E4E4E2></td></tr>
<%	
}
%>
</table>
</marquee>
<!--  </div>-->
</body>
</html>										
										
										