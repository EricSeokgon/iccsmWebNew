<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>

<link rel="stylesheet" href="../css/style_new.css" type="text/css">

<%
	ReportEntity changeEntity = (ReportEntity)request.getAttribute("changeEntity");  
	String p_page	= (String)request.getAttribute("page");
	

	String gubun = KJFUtil.print(request.getParameter("gubun"),"");

	String p_sido_num = (String)request.getAttribute("p_sido_num");  //시도 SEQ  (대구:3, 충남:11)
	
	int cnt = changeEntity.getRowCnt();
	if(cnt > 12) {cnt = cnt%12;}
	
	
	String change_date = "";
	String change_subject = "";
	String change_content = "";
	int cnt_num =  changeEntity.getRowCnt();
	
	if(changeEntity.getRowCnt() > 0) {
		cnt_num = cnt_num-1;
		change_date = changeEntity.getValue(cnt_num,"CHG_DT");
		change_date = KJFDate.getDateForm2(change_date);
		change_subject = changeEntity.getValue(cnt_num,"CODE_NAME");
		change_content = changeEntity.getValue(cnt_num,"VALUE");
	}
	
%>

<script type="text/javascript" src="../republish/printJs/<%=p_sido_num%>/change_new.js"></script>

<SCRIPT language=VBScript>
<!--
function getMyObject
	getMyObject = null
 on error resume next
	set getMyObject = sscControl
end function
//-->
</SCRIPT>

<script language="javascript">
	function fn_view() {

		document.getElementById("change_date<%=cnt%>").innerHTML = "<%=change_date%>";
		document.getElementById("change_subject<%=cnt%>").innerHTML = "<%=change_subject%>";
		document.getElementById("change_content<%=cnt%>").innerHTML = "<%=change_content%>";

		parent.searchfrm.printNum.value = document.frm.view_ch.value;

	}

	function fn_change_view() {

		var cnt = document.frm.view_ch.value;

		clear();
		
		document.getElementById("change_date"+cnt).innerHTML = "<%=change_date%>";
		document.getElementById("change_subject"+cnt).innerHTML = "<%=change_subject%>";
		document.getElementById("change_content"+cnt).innerHTML = "<%=change_content%>";

	}

	function clear() {

		for(var i=1; i<=12; i++) {
			document.getElementById("change_date"+i).innerHTML = "&nbsp;";
			document.getElementById("change_subject"+i).innerHTML = "&nbsp;";
			document.getElementById("change_content"+i).innerHTML = "&nbsp;";
		}
	}

	
	function checkView(objEv) {
	
        if(!isNumber(objEv)){
            alert("숫자만 입력가능합니다.");
            objEv.value = "";
            objEv.focus();
            return;
        }

		if(objEv.value==0 || objEv.value >12 ) {
			alert("1 ~ 12 까지의 숫자만 허용합니다.");
            objEv.value = "";
            objEv.focus();
            return;
		}
        
		parent.searchfrm.printNum.value = document.frm.view_ch.value;
        fn_change_view();
    }	

	function isNumber(input) {
        var chars = "0123456789";
        return containsCharsOnly(input,chars);
    }
		
	function containsCharsOnly(input,chars) {
        for (var inx = 0; inx < input.value.length; inx++) {
            if (chars.indexOf(input.value.charAt(inx)) == -1)
                return false;
        }
        return true;
    }
	

</SCRIPT>

<%if("print".equals(gubun)) {%><body onload="StartUp();PrintPage('<%=cnt%>');"><%} else { %><body onload="fn_view();"><%} %>
 
<OBJECT ID='sscControl' height=0 width=0 CLASSID='clsid:E83541DD-07B8-11D7-88FC-0048546CF9FE' codebase="http://99.1.5.76/republish/sscControl.cab#version=1,0,0,36">
<PARAM name="prop_width" value = "100 width">
<PARAM name="prop_cpi" value = "200 cpi">
<PARAM name="prop_lpi" value = "300 lpi">
<PARAM name="prop_horizontal_tab" value = "400 tab">
<PARAM name="prop_vertical_line" value = "500 vert">
<PARAM name="prop_skip_line" value = "600 skip">
</OBJECT>
 
<form name=frm method=post>

<input type=hidden name=change_ymd value="<%=change_date %>">
<input type=hidden name=d_name value="<%=change_subject %>">
<input type=hidden name=chg_story1 value="<%=change_content %>">
<input type=hidden name=chg_story2 value="">
<input type=hidden name=regist_write_yn value="Y">


<input type="hidden" name=count value="<%=changeEntity.getRowCnt() %>">

<table width="98%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="kica_border eng_border01">
 				<tr>
					<td colspan="2" align="center" class="eng_p_title01">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td width="55%" align="right">변경사항</td>
								<td width="45%" align="right">
									<input type="text" name="view_ch" size="1" value="<%=cnt%>" onkeyup="checkView(this);" />
									행&nbsp;
								</td>
							</tr>
						</table>
						
						
					</td>
				</tr>
				<tr>
					<td width="99%" align="right"><b>( 제12쪽 )</b> </td>
					<td width="1%" align="right">&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
				<tr>
					<td width="10%" class="kica_title_txt"  >행 </td>
					<td width="12%" class="kica_title_txt"  >변경연월일 </td>
					<td width="26%" class="kica_title_txt"  >변경항목 </td>
					<td width="42%" class="kica_title_txt"  >변경된 내용 </td>
					<td width="10%" class="kica_title_txt"  >확인 </td>
				</tr>
			<% 
				
			 
				for(int i = 1; i < 7; i++){
			%>				
				
				<tr align="center" >
					<td class="kica_border01"><%=i%> 행</td>
					<td class="kica_border01"><div id="change_date<%=i%>">&nbsp;</div></td>
					<td class="kica_border01"><div id="change_subject<%=i%>">&nbsp;</div></td>
					<td class="kica_border01"><div id="change_content<%=i%>">&nbsp;</div></td>
					<td class="kica_border01">&nbsp;</td>
				</tr>

			<%			
				}
			%>
				
			</table>
		</td>	
	</tr>
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="kica_border eng_border01">
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td width="99%" align="right"><b>( 제13쪽 )</b> </td>
					<td width="1%" align="right">&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
				<tr>
					<td width="10%" class="kica_title_txt"  >행 </td>
					<td width="12%" class="kica_title_txt"  >변경연월일 </td>
					<td width="26%" class="kica_title_txt"  >변경항목 </td>
					<td width="42%" class="kica_title_txt"  >변경된 내용 </td>
					<td width="10%" class="kica_title_txt"  >확인 </td>
				</tr>
			<% 
				
			 
				for(int i = 7; i < 13; i++){
			%>				
				
				<tr align="center" >
					<td class="kica_border01"><%=i%> 행</td>
					<td class="kica_border01"><div id="change_date<%=i%>">&nbsp;</div></td>
					<td class="kica_border01"><div id="change_subject<%=i%>">&nbsp;</div></td>
					<td class="kica_border01"><div id="change_content<%=i%>">&nbsp;</div></td>
					<td class="kica_border01">&nbsp;</td>
				</tr>

			<%			
				}
			%>
				
			</table>
		</td>	
	</tr>
	
</table>
</form>
