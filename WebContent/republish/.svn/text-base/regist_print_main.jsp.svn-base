<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.util.*" %>

<%
	String coi_wrt_num  = KJFUtil.print(request.getParameter("coi_wrt_num"));
	String scSD_CD = KJFUtil.print(request.getParameter("scSD_CD"),"");
	
	String p_name = (String)request.getAttribute("p_name");
	
%>

<html>
<head>
<link rel="stylesheet" href="../css/style_new.css" type="text/css">
<title>정보통신 행정시스템 - 등록수첩 인쇄</title>
<meta http-equiv="imagetoolbar" content="no" />
<meta name="author" content="정보통신 행정시스템" />

<script language="javascript">
	function fn_goUrl(gubun,cmd){
		var fm = document.frm;
	
		var url = "../republish/RepublishAction.do?cmd="+cmd+"&p_gubun="+gubun+"&scSD_CD=<%=scSD_CD %>&type=_new&coi_wrt_num=<%=coi_wrt_num %>";

		var result = window.open(url, "view_info" , "width=720,height=800,scrollbars=yes,toolbar=no,location=no, top=0,left="+(screen.availWidth/2-100)+"");

		result.focus();
			
	}

</script>



</head>

<body>


<body>
<form name="frm" method="post" action="../republish/RepublishAction.do">

<input type="hidden" name="cmd" value="" />
<input type="hidden" name="coi_wrt_num" value="<%=coi_wrt_num %>" />
<input type="hidden" name="type" value="_new" />
<input type="hidden" name="p_gubun" value="" />
<input type="hidden" name="scSD_CD" value="<%=scSD_CD %>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0">

	<tr>
		<td height="10" colspan="2">
			<table width="100%"  border="0" cellspacing="0" cellpadding="0">
				<tr><td style="padding-bottom:10;">
					<h4><font size="3">&nbsp;&nbsp;<%=p_name %>   등록수첩인쇄</font></h4></td></tr>
			</table>
		</td>
	</tr>

  	<tr>
		<td align="center"><img src="../images/republish/regist_img01.jpg" width="600" height="203" border="0" usemap="#Map"></td>
  	</tr>
  	<tr>
    	<td height="30">&nbsp;</td>
  	</tr>
  	<tr>
    	<td align="center"><img src="../images/republish/regist_img02.jpg" width="600" height="185" border="0" usemap="#Map2"></td>
  	</tr>
</table>
<map name="Map"><area shape="rect" coords="185,150,433,182" href="javascript:fn_goUrl('register','RegisterView');"></map>
<map name="Map2"><area shape="rect" coords="184,125,433,159" href="javascript:fn_goUrl('afresh','RepublishView');"></map>
</form>
</body>
</html>


