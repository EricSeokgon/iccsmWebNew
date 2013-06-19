<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="kjf.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="sp.uent.*" %>
<%
	UserEnt  user=(UserEnt)session.getAttribute("user");
	Vector v_menuEntList=user.getMenuEntList();
	
	
	if (user != null) {
	
%>
<html>
<head>
<title> IPARK 관리자 </title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../com/css/styleOld.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="../inc/js/flash.js"></script>
<style>
<!--
table, tr, td
{	font-family:dotum;font-size:12px;color:#2B3363;}
A:link { color:#2B3363; text-decoration:none;}
A:visited {color:#2B3363; text-decoration:none; }
A:active { color:#2B3363; text-decoration:none; }
A:hover { color:#66CCCC; text-decoration:none; }




.tm_bg { background:#fff url(../images/top/tm_bg.gif) repeat-x;} 
-->
</style>

</head>
<body topmargin="0" leftmargin="0">
<!------높이 조절용 start --------->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10"></td></tr>
</table>
<!------높이 조절용 end --------->

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="218" align="center" valign="top">
			<!-- 왼쪽 시작 -->
			<table border="0" cellpadding="0" cellspacing="0" valign="top">
				<tr>
					<td><!--<script>flash('../images/logo.swf','190','50');</script>-->
					 <a href="../" target="_top"><img src="../images/logo/logo.gif" border="0"></a></td>
				</tr>

			</table>
			<!-- 왼쪽 끝 -->	  </td>
		<td>
			<!-- 오른쪽 시작 -->
			<table width="770" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="5"><img src="../images/top/tm_head.gif"></td>
					<td align="center" class="tm_bg" width="760">
						<table cellspacing="0" cellPadding="0" border="0" width="100%">
							<tr>
								<%
								int cnt = v_menuEntList.size();
								for (int i = cnt - 2; i + 1 > 0; i--){

									MenuEnt menuEnt = (MenuEnt)v_menuEntList.get(i);

									StringBuffer TD = new StringBuffer();

									if("0".equals(menuEnt.getP_PG_GROUP_ID())) {

										//String ls_Link="javascript:alert('사용 권한이  없습니다!')";
										String PG_GROUP_ID = menuEnt.getPG_GROUP_ID();

										if(!KJFUtil.isEmpty(menuEnt.getFIRST_PG_URL())){ //하위의  프로그램 있다면 첫번째
											String titPgId=menuEnt.getFIRST_PG_CD();

											TD.append("<td align='center'>");
											TD.append("<a href=\"");
											TD.append("../main/SubFrame.jsp?go_url="+URLEncoder.encode(menuEnt.getFIRST_PG_URL()+"&titPgId="+titPgId , "UTF-8")+"&PG_GROUP_ID="+PG_GROUP_ID);
											TD.append("\" target=SubFrame>");
											TD.append("<font color='#ffffff'><b>"+menuEnt.getGROUP_NAME()+"</b></font>");
											TD.append("</a>");
											TD.append("</td>");
											if(i < cnt-1){
												TD.append("<td align='center'>");
												TD.append("<img src='../images/top/tm_line.gif'>");
												TD.append("</td>");
												
											}
											
										}
										out.println(TD.toString());
									}
								}
								%>
							</tr>
				  </table>				  </td>
					<td width="5"><img src="../images/top/tm_foot.gif"></td>
				</tr>
				<tr><td colspan="3"><img src="../images/top/tm_bottom.gif"></td></tr>
		  </table>
	  <!-- 오른쪽 끝 -->	  </td>
	</tr>
</table>

</body>
</html>
<%
	} else {
%>
<script>
	alert("세션타임이 종료하였습니다.\n다시 로그인 해주십시오");
	parent.location.href = "../login/Login.jsp";
</script>
<%
	}
%>