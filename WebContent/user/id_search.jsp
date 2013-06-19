<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.mem.MemParam" %>
<%
String isMember = "";
String USER_ID = "";
String USER_PASSWD = "";

if(request.getAttribute("isMember") != null){
	isMember = (String)request.getAttribute("isMember");
}

if("Y".equals(isMember)){
	ReportEntity rEntity 	= KJFUtil.REntPrint((ReportEntity)request.getAttribute("rEntity"));

	USER_ID 				= rEntity.getValue(0,"USER_ID");
	USER_PASSWD 			= rEntity.getValue(0,"USER_PASSWD");
}

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>Untitled Document</title>
<link href="../css/styleAdmin.css" rel="stylesheet" type="text/css">
<script type="text/JavaScript">
<!--
function frmSubmit(){
	var frm = document.fmParam;
	frm.USER_NAT_NUM.value = frm.NAT_NUM1.value + "-" + frm.NAT_NUM2.value;
	frm.submit();
}
//-->
</script>
</head>

<body leftmargin="0" topmargin="0">
<table border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td><img src="images/id_search_top01.gif"></td>
  </tr>
  <tr>
    <td height="100%" align="center" background="images/id_check_bg.gif"><table border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="center">
<%
if("Y".equals(isMember)){
%>
			<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<Td>
						<table border="0" cellspacing="0" cellpadding="3">
						  <tr>
							<td>아이디</td>
							<td><%=USER_ID%></td>
						  </tr>
						  <tr>
							<td>주민번호</td>
							<td><%=USER_PASSWD%></td>
						  </tr>
						</table>
					</td>
				</tr>
			</table>
<%
}else{
%>
			<form name="fmParam" method="post"  action="../07_member/MemAction.do?cmd=MemFind" >
			<input type="hidden" name="USER_NAT_NUM">
			<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<Td>
						<table border="0" cellspacing="0" cellpadding="3">
						  <tr>
							<td><img src="images/id_search_name.gif"></td>
							<td><input type=text class=input size=21 name="USER_NAME"></td>
						  </tr>
						  <tr>
							<td><img src="images/id_search_no.gif"></td>
							<td><input type="text" class="input" size="8" maxlength="6" name="NAT_NUM1">&nbsp;-&nbsp;<input type="password" class="input" size="9" maxlength="7" name="NAT_NUM2">
							</td>
						  </tr>
						</table>
					</td>
					<td width=90 align=center><a href="javascript:frmSubmit();"><Img src=images/btn_id_search.gif border=0></a></td>
				</tr>
			</table>
			</form>
<%
}
%>
		</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign=bottom><img src="images/close.gif" width="400" height="60" border="0" usemap="#Map"></td>
  </tr>
</table>

<map name="Map"><area shape="rect" coords="164,35,237,61" href="javascript:close();">
</map>
</body>
</html>
