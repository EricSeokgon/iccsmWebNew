<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>정보통신공사업 시스템 종합상황표</title>

<link href="../console/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">
<!--

// 콘솔 현황
function fn_ConsoleStatus(sido_code) {
	var fm = document.fmParam;

    fm.sido_code.value = sido_code; 
    
    fm.submit();
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>

</head>

<body id="main" onload="MM_preloadImages('images/menu01_on.gif','images/menu02_on.gif','images/menu03_on.gif','images/menu04_on.gif','images/menu05_on.gif','images/menu06_on.gif','images/menu07_on.gif','images/menu08_on.gif','images/menu09_on.gif','images/menu10_on.gif','images/menu11_on.gif','images/menu12_on.gif','images/menu13_on.gif','images/menu14_on.gif','images/menu15_on.gif','images/menu16_on.gif')">
	<div id="top">
		<div id="region">전국</div>
		<div id="Clock"></div>
		<script>
			 function time() {
			  myDate = new Date();
			  Clock.innerHTML = myDate.toLocaleString();
			  setTimeout("time()", 1000);
			 }
			 onload = time;
		</script>
	</div>
	
	<form name=fmParam method="post" action="../console/ConsoleAction.do?cmd=ConsoleStatus" >
	<input type="hidden" name="sido_code" >

	<div id="menu">
		<div id="">
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('gwgw')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image4','','images/menu04_on.gif',1)">
				<img src="images/menu04.gif" name="Image4" id="Image4" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('gggg')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image3','','images/menu03_on.gif',1)">
				<img src="images/menu03.gif" name="Image3" id="Image3" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('gngn')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image10','','images/menu10_on.gif',1)">
				<img src="images/menu10.gif" name="Image10" id="Image10" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('gbgb')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image12','','images/menu12_on.gif',1)">
				<img src="images/menu12.gif" name="Image12" id="Image12" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('gjgj')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image13','','images/menu13_on.gif',1)">
				<img src="images/menu13.gif" name="Image13" id="Image13" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('dgdg')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image11','','images/menu11_on.gif',1)">
				<img src="images/menu11.gif" name="Image11" id="Image11" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('djdj')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image5','','images/menu05_on.gif',1)">
				<img src="images/menu05.gif" name="Image5" id="Image5" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('bsbs')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image8','','images/menu08_on.gif',1)">
				<img src="images/menu08.gif" name="Image8" id="Image8" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('susu')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image1','','images/menu01_on.gif',1)">
				<img src="images/menu01.gif" name="Image1" id="Image1" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('usus')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image9','','images/menu09_on.gif',1)">
				<img src="images/menu09.gif" name="Image9" id="Image9" /></a></div>
			
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('icic')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image2','','images/menu02_on.gif',1)">
				<img src="images/menu02.gif" name="Image2" id="Image2" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('cncn')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image6','','images/menu06_on.gif',1)">
				<img src="images/menu06.gif" name="Image6" id="Image6" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('cbcb')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image7','','images/menu07_on.gif',1)">
				<img src="images/menu07.gif" name="Image7" id="Image7" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('jnjn')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image14','','images/menu14_on.gif',1)">
				<img src="images/menu14.gif" name="Image14" id="Image14" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('jbjb')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image15','','images/menu15_on.gif',1)">
				<img src="images/menu15.gif" name="Image15" id="Image15" /></a></div>
			<div id="btn">
				<a href="javascript:fn_ConsoleStatus('jjjj')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image16','','images/menu16_on.gif',1)">
				<img src="images/menu16.gif" name="Image16" id="Image16" /></a></div>
		</div>
	</div>

	</form>

</body>
</html>
