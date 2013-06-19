<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>

<link rel="stylesheet" href="../css/style_new.css" type="text/css">

<%
	ReportEntity adm_disEntity = (ReportEntity)request.getAttribute("adm_disEntity");  


	String gubun = KJFUtil.print(request.getParameter("gubun"),"");

	String p_sido_num = (String)request.getAttribute("p_sido_num");  //시도 SEQ  (대구:3, 충남:11)
%>

<script type="text/javascript" src="../republish/printJs/<%=p_sido_num%>/adm_dis.js"></script>

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

<input type=hidden name=count value="<%=adm_disEntity.getRowCnt() %>">


<table width="98%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="kica_border eng_border01">
 				<tr>
					<td colspan="2" align="center" class="eng_p_title01">행정처분사항</td>
				</tr>
				<tr>
					<td width="99%" align="right">( 제14쪽 ) </td>
					<td width="1%" align="right">&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
				<tr>
					<td width="15%" class="kica_title_txt"  >연월일 </td>
					<td width="30%" class="kica_title_txt"  >내용 </td>
					<td width="45%" class="kica_title_txt"  >사유 </td>
					<td width="10%" class="kica_title_txt"  >확인 </td>
				</tr>
				
			<% 
				String reason1 = "";
				String reason2 = "";
				int cnt = adm_disEntity.getRowCnt();
				
				if(cnt > 0){ 
					for(int i = 0; i < cnt; i++){
						
						reason1 = KJFUtil.print(adm_disEntity.getValue(i,"DISPO_CAUSE"),"");
						reason2 = KJFUtil.print(adm_disEntity.getValue(i,"DISPO_CAUSE"),"");
						
						if(reason1.length() > 18) {
							reason1 = reason1.substring(0,18);
							reason2 = reason2.substring(18,reason2.length());
						} else {
							reason2 = "";
						}
						
						
			%>				
				<!-- 
					연월일 WRT_NUM
					내용  DISPO_CONT_NM
					사유  DISPO_CAUSE
				 -->
				<tr align="center" >
					<td class="kica_border01"><%=KJFUtil.print(KJFDate.getDateForm2(adm_disEntity.getValue(i,"DISPO_DT")),"&nbsp;") %></td>
					<td class="kica_border01"><%=KJFUtil.print(adm_disEntity.getValue(i,"DISPO_CONT_NM"),"&nbsp;") %></td>
 					<td class="kica_border01"><%=KJFUtil.print(adm_disEntity.getValue(i,"DISPO_CAUSE"),"&nbsp;") %></td>
					<td class="kica_border01">&nbsp;</td>
				</tr>
				<input type=hidden name=STOP_YMD_FM<%=i %> value="<%=KJFUtil.print(KJFDate.getDateForm2(adm_disEntity.getValue(i,"WRT_NUM")),"") %>">
				<input type=hidden name=REGIST_WRITE_YN<%=i %> value="<%=KJFUtil.print(adm_disEntity.getValue(i,"DISPO_CONT_NM"),"") %>">
				<input type=hidden name=PUNISHMENT_REASON1<%=i %> value="<%=reason1 %>">
				<input type=hidden name=PUNISHMENT_REASON2<%=i %> value="<%=reason2 %>">
				<input type=hidden name=RREGIST_WRITE_YN<%=i %> value="Y">
				
			<%			
					}
				}
			%>
			<%
				int nullCnt = 6 - cnt;
				if(nullCnt > 0){ 
					for(int j = 0; j < nullCnt; j++) {
			%>
       			<tr align="center" >
					<td class="kica_border01">&nbsp;</td>
					<td class="kica_border01">&nbsp;</td>
					<td class="kica_border01">&nbsp;</td>
					<td class="kica_border01">&nbsp;</td>
				</tr>
			<%
					}
				}
			%>				
				
 		
 
</table>

</form>
