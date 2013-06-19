<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="kjf.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="sp.uent.*" %>

<%

	UserEnt  user=(UserEnt)session.getAttribute("user");

	Vector v_menuEntList= null;

	if(user != null){
		v_menuEntList = user.getMenuEntList();
	}

	String PG_GROUP_ID = KJFUtil.print(request.getParameter("PG_GROUP_ID"));
%>


<html>
<head>
<title>::: SUB MENU :::</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../com/css/styleOld.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="../com/js/tree.js"></script>
<script>

<%
 	boolean b_flag = false;
 	boolean isTree = false;

	if (v_menuEntList != null){

		int cnt = v_menuEntList.size();
		for (int i = cnt - 2; i + 1 > 0; i--) {
			MenuEnt menuEnt = (MenuEnt)v_menuEntList.get(i);

			if(menuEnt.getDEPTH() == 1){
				b_flag = false;
			}
			if(menuEnt.getPG_GROUP_ID().equals(PG_GROUP_ID)  &&  menuEnt.getDEPTH() == 1){
				b_flag = true;
			}

			if(b_flag ){
				isTree = true;

				ReportEntity rEntity = (ReportEntity)menuEnt.getPT_PGEnt();
				if("0".equals(menuEnt.getP_PG_GROUP_ID())) {
					out.println("foldersTree = gFld('"+menuEnt.getGROUP_NAME()+"',  '');");
				}else{
					if(PG_GROUP_ID.equals(menuEnt.getP_PG_GROUP_ID())){
						out.println("sub_" + menuEnt.getPG_GROUP_ID() + "=insFld(foldersTree, gFld('" + menuEnt.getGROUP_NAME() + "',''));");
					}else{
						out.println("sub_" + menuEnt.getPG_GROUP_ID() + "=insFld(sub_" + menuEnt.getP_PG_GROUP_ID() + ", gFld('" + menuEnt.getGROUP_NAME() + "',''));");
					}
				}

				if(rEntity!=null){
					for(int j = 0; j < rEntity.getRowCnt(); j++){
						if(PG_GROUP_ID.equals(menuEnt.getPG_GROUP_ID())){
							out.println("insDoc(foldersTree, gLnk(0, '" + rEntity.getValue(j,"PG_NAME") + "', '../" + rEntity.getValue(j,"PG_URL") + "&titPgId=" + rEntity.getValue(j,"PG_ID") + "'));");
						}else{
							out.println("insDoc(sub_" + menuEnt.getPG_GROUP_ID() + ", gLnk(0, '" + rEntity.getValue(j,"PG_NAME") + "', '../" + rEntity.getValue(j,"PG_URL") + "&titPgId=" + rEntity.getValue(j,"PG_ID") + "'));");
						}
					}
				}
			}
		}
	}
%>

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">


<table height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="20" rowspan="2"></td>
		<td height="15" valign="top"></td>
	</tr>
	<tr>
		<td height="100%" valign="top"  background="../images/left/left_bg2.gif" >
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-------------<td><img src="../images/left/left_top<%=PG_GROUP_ID %>.gif"></td>------------->
					<td width="199" height="81" valign="top" background="../images/left/left_top33.gif" class="left_top_bg">
					<!-- 로그인 시작 -->
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="200">안녕하세요.<br><b><%=user.getUSER_NAME()%></b>님<br>
							<img src="../images/login/btn_logout.gif" onclick="parent.parent.location.href='../login/LoginAction.do?cmd=LogOut';" style="cursor:hand"></td>
							
						</tr>
					</table>
					<!-- 로그인 끝 -->
					</td>
				</tr>
				<tr>
					<td align="left" valign="top"  background="../images/left/left_bg.gif"   >
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="17"></td>
								<td align="left"  height="300"  valign="top" >
									<!-------------left menu start-------------------------->
										<%if (isTree){%>
				                        <script language="JavaScript">initializeDocument();</script>
				                        <%}%>          	
								    <!-------------left menu end-------------------------->								
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td><img src="../images/left/left_foot.gif"></td>
				</tr>
				<tr>
					<td height="20"></td>
				</tr>
		  </table>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><img src="../images/left/left_foot2.gif"></td>
	</tr>
</table>

</body>
</html>
