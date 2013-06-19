<%@ page contentType="text/html; charset=utf-8" %>
 
<html>
<head>
	<style  type="text/css"> 
A:link {color:#FF862D;font-size:12px;text-decoration:none;line-height:140%;}
A:visited {color:#FF862D;font-size:12px;text-decoration:none;line-height:140%;}
A:active {color:#1C9FB0;font-size:12px;text-decoration:none;line-height:140%;}
A:hover {color:0066cc;font-size:12px;text-decoration:none;line-height:140%;}
table.table_line{font-family: "굴림"; font-size: 12px; line-height:140%; background-color:#6A9ACA; cell-spacing:1; cell-padding:2; border:0; }
td.menu_title
{
	font-weight: bold;
	font-size: 12px;
	color: #000000;
	line-height: 140%;
	font-family: "굴림" , "돋움";
	height: 22px;
	background-color: #f5f5f5;
	text-align: center;
}
td.in
{
	font-size: 12px;
	color: #000000;
	line-height: 140%;
	font-family: "굴림" , "돋움";
	height: 18px;
	background-color: #f5f5f5;
	text-align: left;
}
td.in1
{
	font-size: 12px;
	color: #000000;
	line-height: 140%;
	font-family: "굴림" , "돋움";
	height: 18px;
	background-color: #f5f5f5;
	text-align: center;
}
td.in2
{
	font-size: 12px;
	color: #000000;
	line-height: 140%;
	font-family: "굴림" , "돋움";
	background-color: #f5f5f5;
	text-align: center;
}
td.in3
{
	font-size: 12px;
	color: #000000;
	line-height: 140%;
	font-family: "굴림" , "돋움";
	background-color: #f5f5f5;
	text-align: right;
}
</style>
</head>
<script language="JavaScript" src="/AIViewer_Ocx/AIScript.js"></script>
<SCRIPT language=JavaScript> 
var myControl;
function StartUp() {
	myControl = GetMyObject();
}
function PrintPage() {
	var count = document.frm.count.value;	
	var pgubun = "1";
	if( myControl == null || !myControl ){ 
		alert('ACTIVE X를 완전히 다운 받으셔야 됩니다.');
		location.reload();
		return;
	}	
	var ret = myControl.ex_port_1_open();	
	if(ret == 0){
		alert("시리얼 1포트를 열 수 없습니다.");
		myControl.ex_port_1_terminate();
		return;	
	}	
	var status;
	status = myControl.ex_check_status();
	if( status == 64)
	{
		alert("용지를 넣으세요.");
		myControl.ex_port_1_terminate();
		return;
	}			
	myControl.ex_insert_paper();
	myControl.prop_cpi = 15;
	myControl.ex_set_cpi();
	myControl.prop_lpi = 6;
	myControl.ex_set_lpi();
	var vertical = 27;
	if(count > 0) {
		for(i=0;i<count;i++) {			
			if( (pgubun == "4") && (eval("document.frm.regist_write_yn"+i).value == "Y") ){
				vertical += 2;
				continue;
			}			
			myControl.prop_vertical_line = vertical;
			myControl.ex_set_vertical_line();
			myControl.prop_horizontal_tab = 3;
			myControl.ex_set_horizontal_tab();			
			myControl.prop_stringToSend = eval("document.frm.CHANGE_YMD"+i).value+" ";
			myControl.ex_send_1_string();    		
			myControl.prop_horizontal_tab = 15;
			myControl.ex_set_horizontal_tab();    		
			myControl.prop_stringToSend = eval("document.frm.d_name"+i).value+" ";
			myControl.ex_send_1_string();	    		
			myControl.prop_horizontal_tab = 34;
			myControl.ex_set_horizontal_tab();    		
			myControl.prop_stringToSend = eval("document.frm.chg_story1"+i).value+" "+"\r\n";
			myControl.ex_send_1_string();					
			myControl.prop_horizontal_tab = 34;
			myControl.ex_set_horizontal_tab();				
			myControl.prop_stringToSend = eval("document.frm.chg_story2"+i).value+" ";
			myControl.ex_send_1_string();	
			vertical += 2;
		}
	} else {
		alert("인쇄할 내용이 없습니다.");
	}
	myControl.ex_eject_paper();	
	myControl.ex_port_1_terminate();	
	parent.fSave2();	
}
</script>
<SCRIPT language=VBScript>
<!--
function getMyObject
	getMyObject = null
 on error resume next
	set getMyObject = sscControl
end function
//-->
</SCRIPT>
 
<!--  BODY onload='StartUp();PrintPage();setAIOcx()'-->
<BODY onload='StartUp();PrintPage();'>

<script>document.write(tagAIGeneratorOcx);</script><!--span id="aiocx"></span-->
<OBJECT ID='sscControl' height=0 width=0 CLASSID='clsid:E83541DD-07B8-11D7-88FC-0048546CF9FE' codebase="../cab/sscControl.cab#version=1,0,0,36">
<PARAM name="prop_width" value = "100 width">
<PARAM name="prop_cpi" value = "200 cpi">
<PARAM name="prop_lpi" value = "300 lpi">
<PARAM name="prop_horizontal_tab" value = "400 tab">
<PARAM name="prop_vertical_line" value = "500 vert">
<PARAM name="prop_skip_line" value = "600 skip">
</OBJECT>
<form name=frm method=post action="./CO612.jsp">
<input type=hidden name=regist_no value='110196'>
 
<table width="600" border="0">
	<tr>
		<td>
			<P class="a2"><B><SPAN lang="EN-US"><font size="3">▲변경사항</font></SPAN></B></P>
		</td>
		<td align=right>
			(제12쪽)
		</td>
	</tr>
</table>
<table width="600" border="0" cellspacing="1" class="table_line">
	<tr>
		<TD class=in2 height="30" width="80" valign="middle">
			<SPAN lang="EN-US"><font size="2">변경연월일</font></SPAN>
		</TD>
		<TD class=in1 width="80" valign="middle">
			<SPAN lang="EN-US"><font size="2">변경항목</font></SPAN>
		</TD>
		<TD class=in1 width="400" valign="middle">
			<SPAN lang="EN-US"><font size="2">변&nbsp;&nbsp;경&nbsp;&nbsp;된&nbsp;&nbsp;내&nbsp;&nbsp;용</font></SPAN>
		</TD>
		<TD class=in1 width="40" valign="middle">
			<SPAN lang="EN-US"><font size="2">확인</font></SPAN>
		</TD>
	</tr>
 
 
	<tr>
		<TD class=in2 height=30 width="80" valign="middle">		</TD>
		<TD class=in1 width="80" valign="middle">		</TD>
		<TD class=in1 width="400" valign="middle">		</TD>
		<TD class=in1 width="40" valign="middle">		</TD>
	</tr>
 
	<tr>
		<TD class=in2 height=30 width="80" valign="middle">		</TD>
		<TD class=in1 width="80" valign="middle">		</TD>
		<TD class=in1 width="400" valign="middle">		</TD>
		<TD class=in1 width="40" valign="middle">		</TD>
	</tr>
 
	<tr>
		<TD class=in2 height=30 width="80" valign="middle">		</TD>
		<TD class=in1 width="80" valign="middle">		</TD>
		<TD class=in1 width="400" valign="middle">		</TD>
		<TD class=in1 width="40" valign="middle">		</TD>
	</tr>
 
	<tr>
		<TD class=in2 height=30 width="80" valign="middle">		</TD>
		<TD class=in1 width="80" valign="middle">		</TD>
		<TD class=in1 width="400" valign="middle">		</TD>
		<TD class=in1 width="40" valign="middle">		</TD>
	</tr>
 
	<tr>
		<TD class=in2 height=30 width="80" valign="middle">		</TD>
		<TD class=in1 width="80" valign="middle">		</TD>
		<TD class=in1 width="400" valign="middle">		</TD>
		<TD class=in1 width="40" valign="middle">		</TD>
	</tr>
 
	<tr>
		<TD class=in2 height=30 width="80" valign="middle">		</TD>
		<TD class=in1 width="80" valign="middle">		</TD>
		<TD class=in1 width="400" valign="middle">		</TD>
		<TD class=in1 width="40" valign="middle">		</TD>
	</tr>
 
</table>
<input type=hidden name=count value="0">
<!-- ### AIReport 기존 Applet 소스 주석처리
<APPLET  CODE = WebnaraReport.class CODEBASE = "http://www.kica.or.kr/AIReport/generator" ARCHIVE = WebnaraReport.jar WIDTH = 0 HEIGHT = 0 NAME = WebnaraReport>
<PARAM NAME = bgcolor VALUE ="00008B">
<PARAM NAME = cabinets VALUE ="WebnaraReport.cab">
<PARAM NAME = reload VALUE =true>
<PARAM NAME = Download VALUE ="http://www.kica.or.kr/AIReport/generator/AIViewer.exe">
</APPLET>
-->
</form>
</body>
</html>
 

