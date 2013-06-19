<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>

<link rel="stylesheet" href="../css/style_new.css" type="text/css">

<%
	ReportEntity valuationEntity = (ReportEntity)request.getAttribute("valuationEntity");

	String asse_dt = KJFUtil.print(valuationEntity.getValue(0,"ASSE_DT"),"&nbsp;");		//평가일
	String asse_aom = KJFUtil.print(valuationEntity.getValue(0,"ASSE_AOM"),"&nbsp;");	//평가금액
	String appl_term_start_dt = KJFUtil.print(valuationEntity.getValue(0,"APPL_TERM_START_DT"),"&nbsp;");	//평가액 적용기간 시작일
	String appl_term_end_dt = KJFUtil.print(valuationEntity.getValue(0,"APPL_TERM_END_DT"),"&nbsp;");	//평가액 적용기간 종료일
	
	String gubun = KJFUtil.print(request.getParameter("gubun"),"");
	String p_sido_num = (String)request.getAttribute("p_sido_num");  //시도 SEQ  (대구:3, 충남:11)
%>

<script type="text/javascript" src="../republish/printJs/<%=p_sido_num%>/valuation.js"></script>

<SCRIPT language=VBScript>
<!--
function getMyObject
	getMyObject = null
 on error resume next
	set getMyObject = sscControl
end function
//-->
</SCRIPT>



<%if("print".equals(gubun)) {%><body onload="StartUp();PrintPage();"><%} else { %><body><%} %>
 
<OBJECT ID='sscControl' height=0 width=0 CLASSID='clsid:E83541DD-07B8-11D7-88FC-0048546CF9FE' codebase="http://99.1.5.76/republish/sscControl.cab#version=1,0,0,36">
<PARAM name="prop_width" value = "100 width">
<PARAM name="prop_cpi" value = "200 cpi">
<PARAM name="prop_lpi" value = "300 lpi">
<PARAM name="prop_horizontal_tab" value = "400 tab">
<PARAM name="prop_vertical_line" value = "500 vert">
<PARAM name="prop_skip_line" value = "600 skip">
</OBJECT>
 
<form name=frm method=post>

<table width="98%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table width="98%"  border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0" class="kica_border eng_border01">
							<tr><td colspan="2" align="center" class="eng_p_title01">시공능력평가사항</td></tr>
           					<tr>
                          		<td width="99%" align="right">( 제3쪽 ) </td>
                        		<td width="1%" align="right">&nbsp;</td>
                      		</tr>
      					</table>
      				</td>
             	</tr>
             	<tr>
           			<td>
           				<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
                     		<tr align="center">
                      			<td width="100%" class="kica_border01" style="padding:5 5 5 5">
                      				<table width="100%"  border="0" cellspacing="0" cellpadding="0">
                         				<tr>
                                      		<td width="49%">
                                      			<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
                                          			<tr>
                                            			<td width="25%" class="kica_title_txt">평가일</td>
                                            			<td width="24%" class="kica_title_txt">평가금액<br>(천원)</td>
                                            			<td width="25%" class="kica_title_txt">평가액<br> 적용기간</td>
                                            			<td width="24%" class="kica_title_txt">확인</td>
                                          			</tr>
                                          			<tr>
                                            			<td align="center" class="kica_border01"><%=KJFUtil.print(KJFDate.getDateForm2(asse_dt),"&nbsp;") %></td>
                                            			<td align="center" class="kica_border01"><%=KJFUtil.money(KJFUtil.str2long(asse_aom)) %></td>
                                            			<td align="center" class="kica_border01">
                                            				<%=KJFUtil.print(KJFDate.getDateForm2(appl_term_start_dt),"&nbsp;") %><br/>
                                            				<%=KJFUtil.print(KJFDate.getDateForm2(appl_term_end_dt),"&nbsp;") %></td>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
                                          			</tr>	
                                          			<tr>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
                                          			</tr>
                                          			<tr>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
                                            			<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
                                      			</table>
	                                      	</td>
	                                      	<td width="2%">&nbsp;</td>
	                                      	<td width="49%" align="top" >
	                                      		<table width="100%"  height="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
	                                  				<tr>
	                                            		<td width="25%" class="kica_title_txt">평가일</td>
	                                            		<td width="24%" class="kica_title_txt">평가금액<br>(천원)</td>
	                                           			<td width="25%" class="kica_title_txt">평가액<br>적용기간</td>
	                                            		<td width="24%" class="kica_title_txt">확인</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                           		 	<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                           		 	<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                                          		<tr>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                            		<td align="center" class="kica_border01">&nbsp;</td>
	                                          		</tr>
	                  							</table>
                  							</td>
                       					</tr>
                      				</table>
                      			</td>
	                      	</tr>
	                	</table>
	                </td>
	   			</tr>
	 		</table>
	 	</td>
	</tr>
    <tr>
       	<td>&nbsp;</td>
	</tr>
</table>



<%
	String pnt_end_dt = KJFUtil.getDateSubstring(appl_term_end_dt,"yy") +"/"+ KJFUtil.getDateSubstring(appl_term_end_dt,"mm") +"/"+ KJFUtil.getDateSubstring(appl_term_end_dt,"dd");
%>
<input type=hidden name=EVAL_Y0 value="<%=KJFUtil.getDateSubstring(asse_dt,"yyyy") %>">
<input type=hidden name=EVAL_M0 value="<%=KJFUtil.getDateSubstring(asse_dt,"mm") %>">
<input type=hidden name=EVAL_D0 value="<%=KJFUtil.getDateSubstring(asse_dt,"dd") %>">
<input type=hidden name=ABILITY_EVAL_AMT0 value="     <%=KJFUtil.money(KJFUtil.str2long(asse_aom)) %>">
<input type=hidden name=APPLY_Y0 value="<%=KJFUtil.getDateSubstring(appl_term_start_dt,"yy") %>">
<input type=hidden name=APPLY_M0 value="<%=KJFUtil.getDateSubstring(appl_term_start_dt,"mm") %>">
<input type=hidden name=APPLY_D0 value="<%=KJFUtil.getDateSubstring(appl_term_start_dt,"dd") %>">
<input type=hidden name=TO_GIGAN0 value="<%=KJFUtil.print(pnt_end_dt,"&nbsp;") %>">
<input type=hidden name=count value="1">


</form>
</body>
</html>
 



