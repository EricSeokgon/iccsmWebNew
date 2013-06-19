<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>세션키 암호화</title>

<script language='javascript' src='.\gpkisecureweb\var.js'></script>
<script language='javascript' src='.\gpkisecureweb\GPKIFunc.js'></script>
<script language='javascript' src='.\gpkisecureweb\object.js'></script>
</head>	

<body background="img/login_bg.gif">
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

				<!-- 세션키 암호화 -->
			  <tr>

<!--Php Test 를 위한 폼-->
<form name='EncDataPhp' action='EncData_S.php' method="post">

<!-- Test -->
 <TABLE style="MARGIN-TOP: 5px" cellSpacing=0 cellPadding=0 
                  width=699 border=0>
                    <TBODY>
                    <TR>
                      <TD class="tDb tb" vAlign=top height=22>
                        <TABLE width="100%">
                          <TBODY>
                          <TR>
                            <TD class="tDb tb" align=left><IMG height=11 
                              src="test_files/bul_arrow.gif" width=18 
                              align=absMiddle>이름/주민등록번호</TD>
                            <TD class=tb align=right><FONT 
                              color=red><B>*</B></FONT>표시는 
                          필수입력사항입니다.</TD></TR></TBODY></TABLE></TD></TR>
                    <TR>
                      <TD vAlign=top>
                        <TABLE cellSpacing=1 cellPadding=0 width=699 
                        bgColor=#cccccc border=0>
                          <TBODY>
      
                          <TR bgColor=white>
                            <TD class="tb pL10" bgColor=#daeef0 
                              height=28>이<FONT color=#daeef0>....</FONT>름 <FONT 
                              color=red><STRONG>*</STRONG></FONT></TD>
                            <TD class=pL10 width=240 bgColor=#fffff7><INPUT 
                              class=box_1c3 style="WIDTH: 157px" name=name></TD>
                              
                            <TD class="tb pL10" width=107 
                              bgColor=#daeef0>주민등록번호 <FONT 
                              color=red><STRONG>*</STRONG></FONT></TD>
                            <TD class=pL10 bgColor=#fffff7><INPUT 
                              class=box_1c3 style="WIDTH: 50px" maxLength=6 name=ssn1> - 
                              <INPUT class=box_1c3 style="WIDTH: 50px" maxLength=7 
                   name=ssn2></TD>

                   </TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
                   <!--Test2 -->
                       <!--   <TABLE cellSpacing=0 cellPadding=0 width=699 border=0> -->
                    <TBODY>
                    <TR>
                      <TD vAlign=top height=22><IMG height=11 
                        src="test_files/bul_arrow.gif" width=18 
                        align=absMiddle><SPAN class="tDb tb">일반사항입력</SPAN> <SPAN 
                        class=pL10><INPUT type=checkbox CHECKED value=sent 
                        name=sendmail>인증정보 E-mail 발송</SPAN> </TD></TR>
                   <TR>
                        <TABLE cellSpacing=1 cellPadding=0 width=699 
                        bgColor=#cccccc border=0>
                          <TBODY>
                         
                          <TR bgColor=white>
                           <TD class="tb pL10" width=107 bgColor=#daeef0 
                            height=28>부서명 <FONT 
                              color=red><STRONG>*</STRONG></FONT></TD>
                            <TD class=pL10 bgColor=#fffff7 colSpan=3><INPUT 
                              class=box_1c3 style="WIDTH: 480px" 
                               name=depart></TD></TR>
                          
                           <TR bgColor=white>
                            <TD class="tb pL10" width=107 bgColor=#daeef0 
                            height=28>회사주소 <FONT 
                              color=red><STRONG>*</STRONG></FONT></TD>
                            <TD class=pL10 bgColor=#fffff7 colSpan=3><INPUT 
                              class=box_1c3 style="WIDTH: 480px"  
                               name=address></TD></TR>
							   
                            <TD class="tb pL10" width=107 
                              bgColor=#daeef0>E-mail <FONT 
                              color=red><STRONG>*</STRONG></FONT>
                              <DIV></DIV></TD>
                            <TD class=pL10 bgColor=#fffff7><INPUT 
                              class=box_1c3 style="WIDTH: 157px" 
                          name=email></TD></TR>
                          <TR bgColor=white>
                            <TD class="tb pL10" bgColor=#daeef0 
                            height=28>연락처</TD>
                            <TD class=pL10 bgColor=#fffff7><INPUT 
                              class=box_1c3 style="WIDTH: 157px" 
                            name=homephone></TD>
                            <TD class="tb pL10" bgColor=#daeef0>휴대폰</TD>
                            <TD class=pL10 bgColor=#fffff7><INPUT 
                              class=box_1c3 style="WIDTH: 157px" name=mobile> </TD></TR>
                          <TR bgColor=white>
                            <TD class="tb pL10" bgColor=#daeef0 
                              height=28>직<FONT color=#daeef0>....</FONT>급</TD>
                            <TD class=pL10 bgColor=#fffff7><INPUT 
                              class=box_1c3 style="WIDTH: 157px" 
name=emptype></TD>
                            <TD class="tb pL10" bgColor=#daeef0>직<FONT 
                              color=#daeef0>....</FONT>위</TD>
                            <TD class=pL10 bgColor=#fffff7><INPUT 
                              class=box_1c3 style="WIDTH: 157px"
                          name=title></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
<br><br>
    	<Center>	
	
		 <input type="button" name="btn" value="EncryptData(JSP)" onClick="Encrypt(EncDataJsp)"> 
		 <a href="/EncData_S.jsp?id=gpkisecureweb&pwd=12345678" onclick="EncryptLink(this)"> Encrypt Link</a></center>
										</td>
									</tr>
								</table>
							</td> 
						</tr>
					</table>

				</td>
</form>

</body>
</html>
