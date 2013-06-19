<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>

<link rel="stylesheet" href="../css/style_new.css" type="text/css">

<%
	ReportEntity basicsEntity = (ReportEntity)request.getAttribute("basicsEntity");

	String rep_nm_kor = (String)request.getAttribute("ceo_nm"); //대표자 공동대표 포함하여 가져온다.

	String name = KJFUtil.print(basicsEntity.getValue(0,"NAME"),"&nbsp;");  //상호
	String coi_wrt_num = KJFUtil.print(basicsEntity.getValue(0,"COI_WRT_NUM"),"&nbsp;"); //등록번호
	//String rep_nm_kor = KJFUtil.print(basicsEntity.getValue(0,"REP_NM_KOR"),"&nbsp;");	//대표자
	String commana_class = KJFUtil.print(basicsEntity.getValue(0,"COMMANA_CLASS"),"");	
	
	String com_num = KJFUtil.print(basicsEntity.getValue(0,"COM_NUM"));
	String rep_ssn1 = basicsEntity.getValue(0,"REP_SSN1");
	
	String p_sido_num = (String)request.getAttribute("p_sido_num");  //시도 SEQ  (대구:3, 충남:11)
	
	if("1".equals(commana_class)) {
		com_num = KJFUtil.getStrForm(com_num,6);
	} else {
		if(rep_ssn1.length() >= 6) {
			rep_ssn1 = rep_ssn1.substring(0,2) + "." + rep_ssn1.substring(2,4) + "." + rep_ssn1.substring(4,6);
			rep_ssn1 = "19"+rep_ssn1;
			com_num = rep_ssn1;
		}
	} 
	com_num = KJFUtil.print(com_num,"&nbsp;");

	
	String buss_ymd = KJFUtil.print(basicsEntity.getValue(0,"BUSS_YMD"),"&nbsp;");	//등록연월일
	String rea_cap = KJFUtil.print(basicsEntity.getValue(0,"REA_CAP"),"&nbsp;");	//자본금
	String addr = KJFUtil.print(basicsEntity.getValue(0,"ADDR_ADDR"),"&nbsp;")+basicsEntity.getValue(0,"ADDR_DETAIL_ADDR");	//영업소재지

	
	String gubun = KJFUtil.print(request.getParameter("gubun"),"");
	
%>

<script type="text/javascript" src="../republish/printJs/<%=p_sido_num%>/basics.js"></script>

<SCRIPT language="VBScript">
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

<table width="100%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="kica_border eng_border01">
				<tr>
					<td colspan="2" align="center" class="eng_p_title01">정보통신공사업등록수첩</td>
				</tr>
				<tr>
					<td width="99%" align="right">( 제2쪽 )</td>
					<td width="1%" align="right">&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
				<tr>
					<td width="18%" class="kica_title_txt">상 호 </td>
					<td width="32%" class="kica_border01"><%=name %></td>
					<td width="18%" class="kica_title_txt">등록번호</td>
					<td width="32%" class="kica_border01"><%=coi_wrt_num %></td>
				</tr>
				<tr>
					<td width="18%" class="kica_title_txt">대표자</td>
					<td width="32%" class="kica_border01"><%=rep_nm_kor %></td>
					<td width="18%" class="kica_title_txt">생년월일<br>(법인등록번호)</td>
					<td width="32%" class="kica_border01"><%=com_num %></td>
				</tr>
				<tr>
					<td width="18%" class="kica_title_txt">등록연월일</td>
					<td width="32%" class="kica_border01"><%=KJFUtil.print(KJFDate.getDateForm2(buss_ymd),"&nbsp;") %></td>
					<td width="18%" class="kica_title_txt">자본금</td>
					<td width="32%" class="kica_border01"><%=KJFUtil.money(KJFUtil.str2long(rea_cap)) %> (천원)</td>
				</tr>
				<tr>
					<td width="18%" class="kica_title_txt">영업소소재지</td>
					<td colspan="3" class="kica_border01"><%=addr %></td>
				</tr>
				<tr align="center">
					<td colspan="4" class="kica_border01" style="padding:20 0 35 0">
						<table width="92%"  border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
                         		<td>정보통신공사업법 제 14조의 규정에 의하여 위와 같이 등록하였음을 확인합니다.</td>
       						</tr>
                  			<tr>
                          		<td height="40" align="right" style="padding-right:40px;" ><%=KJFDate.dateType(KJFDate.getCurTime()) %></td>
                   			</tr>
                    		<tr>
                     			<td height="30" align="right" valign="bottom" style="padding-right:40px;" ><span class="style1"> 인</span></td>
                    		</tr>
               			</table>
               		</td>
       			</tr>
			</table>
		</td>
	</tr>
</table>


<% 
	String s = KJFDate.dateOnly(KJFDate.getCurTime());

	String yyyy="";
	String mm="";
	String dd="";

	if(s.length() == 10 ) {
		yyyy = 	s.substring(0, 4);
		mm = 	s.substring(5, 7);
		dd = 	s.substring(8, 10);
	}

%>

<input type=hidden name=NAME value="<%=name %>">
<input type=hidden name=COI_WRT_NUM value="<%=coi_wrt_num %>">
<input type=hidden name=REP_NM_KOR value="<%=rep_nm_kor %>">
<input type=hidden name=REP_CERTI_RESI_NO1 value="<%=com_num %>">
<input type=hidden name=REP_CERTI_RESI_NO2 value="">
<input type=hidden name=REGIST_YMD value="<%=KJFUtil.print(KJFDate.getDateForm2(buss_ymd),"&nbsp;") %>">
<input type=hidden name=PAY_IN_CAPITAL_AMT_K value="<%=KJFUtil.money(KJFUtil.str2long(rea_cap)) %>">
<input type=hidden name=SITE_ADDR value="<%=addr %>">
<input type=hidden name=FIRST_ISSUE_Y value="<%=yyyy %>">
<input type=hidden name=FIRST_ISSUE_M value="<%=mm %>">
<input type=hidden name=FIRST_ISSUE_D value="<%=dd %>">
</form>
</body>
</html>
 



