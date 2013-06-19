<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>

<link rel="stylesheet" href="../css/style_new.css" type="text/css">

<%
	ReportEntity engineerEntity = (ReportEntity)request.getAttribute("engineerEntity");  
	ReportEntity countEntity = (ReportEntity)request.getAttribute("countEntity");  
	String p_page	= (String)request.getAttribute("page");
	
	/*
		추가 기술자가 있을경우 출력을 위한 옵션이다.
		t_page(템프페이지에 담아서.. 추가 기술자 15쪽은 -11 해서 4쪽으로 만들어서 출력하기 위해서..
	*/
	int t_page = KJFUtil.str2int(p_page);
	if(t_page >=15) { 
		t_page= t_page-11;
		p_page= Integer.toString(t_page);
	}
	
	String gubun = KJFUtil.print(request.getParameter("gubun"),"");
	String p_sido_num = (String)request.getAttribute("p_sido_num");  //시도 SEQ  (대구:3, 충남:11)
	
	int print_type = KJFUtil.str2int(p_page) %2;
%>

<script type="text/javascript" src="../republish/printJs/<%=p_sido_num%>/engineer_new.js"></script>

<SCRIPT language=VBScript>
<!--
 
function getMyObject
	getMyObject = null
 on error resume next
	set getMyObject = sscControl
end function
//-->
</SCRIPT>

 
<%if("print".equals(gubun)) {%>
	<%if(print_type == 0) { %>
		<body onload="StartUp();PrintPage();">
	<%} else { %>
		<body onload="StartUp();PrintPage2();">
	<%} %>
<%} else { %><body><%} %>
 
<OBJECT ID='sscControl' height=0 width=0 CLASSID='clsid:E83541DD-07B8-11D7-88FC-0048546CF9FE' codebase="http://99.1.5.76/republish/sscControl.cab#version=1,0,0,36">
<PARAM name="prop_width" value = "100 width">
<PARAM name="prop_cpi" value = "200 cpi">
<PARAM name="prop_lpi" value = "300 lpi">
<PARAM name="prop_horizontal_tab" value = "400 tab">
<PARAM name="prop_vertical_line" value = "500 vert">
<PARAM name="prop_skip_line" value = "600 skip">
</OBJECT> 
 
<form name=frm method=post>

<input type="hidden" name=count value="<%=countEntity.getRowCnt() %>">
<input type="hidden" name=number value="<%=engineerEntity.getRowCnt() %>">
<input type="hidden" name=add value="0">
<input type="hidden" name=check value="0">

<table width="98%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="kica_border eng_border01">
				<tr>
					<td colspan="2" align="center" class="eng_p_title01">정보통신기술자사항</td>
				</tr>
				<tr>
					<td width="99%" align="right">( 제<%=p_page %>쪽 ) </td>
					<td width="1%" align="right">&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="600"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
				<tr>
					<td width="15%" class="kica_title_txt" rowspan="2" >성 명 </td>
					<td width="20%" class="kica_title_txt" rowspan="2" >자격종목 및 등급 <br> (등록번호 또는 <br> 경력수첩번호) </td>
                	<td width="15%" class="kica_title_txt" rowspan="2" >자격유효기간 <br><span  style='font-size:10px;font-weight:normal;' >(유효기간이 있는<br> 경우에 한함)</span> </td>
                 	<td width="10%" class="kica_title_txt" rowspan="2" >교 육<br>이 수<br>연월일 </td>
                 	<td width="20%" class="kica_title_txt" colspan="2" >입사 </td>
                 	<td width="20%" class="kica_title_txt" colspan="2" >퇴사 </td>
                </tr>
               	<tr>
                	<td width="12%" class="kica_title_txt">연월일</td>
                 	<td width="8%" class="kica_title_txt">확인</td>
                 	<td width="12%" class="kica_title_txt">연월일</td>
                 	<td width="8%" class="kica_title_txt">확인</td>
                 </tr>
                 <!-- 
			                 성명 NM_KOR
					 등급 TMP_FIELD
					 경력수첩번호 CARE_BOOK_ISSUE_NUM
					 교육이수연월일: EMPL_YMD
                  -->

			<% 
				int cnt = engineerEntity.getRowCnt();
		
				if(cnt > 0){ 
					for(int i = 0; i < cnt; i++){
			%>

   				<tr align="center" >
             		<td class="kica_border01"><%=KJFUtil.print(engineerEntity.getValue(i,"NM_KOR"),"&nbsp;") %></td>
                 	<td class="kica_border01">
                 		<%=KJFUtil.print(engineerEntity.getValue(i,"TMP_FIELD"),"&nbsp;") %><br>
                 		<%=KJFUtil.print("("+engineerEntity.getValue(i,"CARE_BOOK_ISSUE_NUM")+")","&nbsp;") %>
                 	</td>
                 	<td class="kica_border01">&nbsp; </td>
                 	<td class="kica_border01">&nbsp;</td>
                 	<td class="kica_border01"><%=KJFUtil.print(KJFDate.getDateForm2(engineerEntity.getValue(i,"EMPL_YMD")),"&nbsp;") %></td>
                 	<td class="kica_border01">&nbsp;</td>
                 	<td class="kica_border01">&nbsp;</td>
                    <td class="kica_border01">&nbsp;</td>
        		</tr>
        		
				<input type="hidden" name=NM_KOR<%=i %> value="<%=KJFUtil.print(engineerEntity.getValue(i,"NM_KOR"),"") %>">
				<input type="hidden" name=TECH_GRADE_NM<%=i %> value="<%=KJFUtil.print(engineerEntity.getValue(i,"TMP_FIELD"),"") %>">
				<input type="hidden" name=CAREER_NOTE_NO<%=i %> value="<%=KJFUtil.print("("+engineerEntity.getValue(i,"CARE_BOOK_ISSUE_NUM")+")","") %>">
				<input type="hidden" name=VLID_YMD_FR<%=i %> value="">
				<input type="hidden" name=VLID_YMD_TO<%=i %> value="">
				<input type="hidden" name=EDU_FINISH_YMD<%=i %> value="">
				<input type="hidden" name=AFTER_JOIN_COMP_YMD_Y<%=i %> value="<%=KJFUtil.getDateSubstring(engineerEntity.getValue(i,"EMPL_YMD"),"yyyy") %>">
				<input type="hidden" name=AFTER_JOIN_COMP_YMD_M<%=i %> value="<%=KJFUtil.getDateSubstring(engineerEntity.getValue(i,"EMPL_YMD"),"mm") %>">
				<input type="hidden" name=AFTER_JOIN_COMP_YMD_D<%=i %> value="<%=KJFUtil.getDateSubstring(engineerEntity.getValue(i,"EMPL_YMD"),"dd") %>">
				<input type="hidden" name=AFTER_RETIRE_YMD_Y<%=i %> value="">
				<input type="hidden" name=AFTER_RETIRE_YMD_M<%=i %> value="">
				<input type="hidden" name=AFTER_RETIRE_YMD_D<%=i %> value="">
				<input type="hidden" name=IN_WRITE_YN<%=i %> value="Y">

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
		</td>
	</tr>
</table>



</form>
</body>
</html>