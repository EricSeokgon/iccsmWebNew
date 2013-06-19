<%@ page contentType="text/html;charset=euc-kr" %>
<%@ 
page import="java.sql.*, java.io.*, java.net.*, java.util.*" 
%>
<%@ page import="com.gpki.servlet.GPKIHttpServletResponse" %>

<%@include file="/gpkisecureweb.jsp"%>
<%
String challenge =((GPKIHttpServletResponse)gpkiresponse).getChallenge();
%>

<html>
<head>
<link href="/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>로그인01</title>

<script language='javascript' src='./gpkisecureweb/var.js'></script>
<script language='javascript' src='./gpkisecureweb/GPKIFunc.js'></script>
<script language='javascript' src='./gpkisecureweb/object.js'></script>

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
									
				<form name='envSign' action='/servlet/EnvSign' method='post'>
                <td align="center" valign="top">
				  <table width="461" height="129"  border="0" cellpadding="0" cellspacing="0" style="margin-top:16px;">
                    <tr> 
                      <td align="right" valign="top" background="img/login_bg_m.gif"><table width="319" height="87" border="0" cellpadding="0" cellspacing="0" style="margin-top:23px;">
                          <tr> 
                            <td valign="top"><strong>[SERVLET]로그인 버튼</strong><font size="2">을 클릭 하시면 원하시는 
                              항목을 선택하여 통합 관리도구로 입장하실 수 있습니다.</font></td>
                          </tr>
                          <tr> 
                            <td valign="bottom">
                            <input type="hidden" name="challenge" value=<%=challenge%>><BR>
							<img src="img/btn_login.gif" width="178" height="36" hspace="48" border="0" style="cursor: hand" onClick="EnvelopedSignData(envSign)">
							</td>
                          </tr>
                        </table>
					  </td>
                    </tr>
             <!--     </table> -->
          		        </td>
			  </form>
			  <form name='envSignJsp' action='/EnvSign_S.jsp' method='post'>
                <td align="center" valign="top">
				  <table width="461" height="129"  border="0" cellpadding="0" cellspacing="0" style="margin-top:16px;">
                    <tr> 
                      <td align="right" valign="top" background="img/login_bg_m.gif"><table width="319" height="87" border="0" cellpadding="0" cellspacing="0" style="margin-top:23px;">
                          <tr> 
                            <td valign="top"><strong>[JSP]로그인 버튼</strong><font size="2">을 클릭 하시면 원하시는 
                              항목을 선택하여 통합 관리도구로 입장하실 수 있습니다.</font></td>
                          </tr>
                          <tr> 
                            <td valign="bottom">
                            <input type="hidden" name="challenge" value=<%=challenge%>><BR>
							<img src="img/btn_login.gif" width="178" height="36" hspace="48" border="0" style="cursor: hand" onClick="EnvelopedSignData(envSignJsp)">
							</td>
                          </tr>
                        </table>
					  </td>
                    </tr>
                  </table>
          		        </td>
			  </form>
              </tr>
			</table>
		  </td>
        </tr>
	</td>
  </tr>
</table>
</body>
</html>
