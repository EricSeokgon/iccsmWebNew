<%@ page contentType="text/html; charset=utf-8" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="/css/style.css" type="text/css">
<title>::::한국정보통신공사협회::::</title>
<style> 
.sdmenu {
    width: 169px;
    font-family: 돋움;
    font-size: 12px;
    background: #eee  no-repeat  right bottom;
    color: #FFF;
}
 
.sdmenu .title, .sdmenu .titlehidden{
    display: block;
    font-weight: bold;
    color: white;
    background: #FFF repeat-x;
}
/*
.sdmenu .title {
    border-bottom: 1px solid #DDD;
}
 
 
.sdmenu .arrow {
        margin-left:5 px;
    margin-right:5 px;
}
 
*/
 
/*.sdmenu #top {
    background: url(http://www.blueb.co.kr/SRC/javascript/image5/toptitle.gif) no-repeat;
}
*/
.sdmenu .submenu {
    overflow: hidden;
}
 
.sdmenu .submenu a {
    padding:5 px;
    text-indent:15px;
    background: #F5F5F5;
    display:block;
    border-bottom: 1px solid #DDD;
    color: #0251A1;
    text-decoration: none;
}
 
.sdmenu .submenu a:hover {
    background :#3873AE  no-repeat right center;
    color: #FFF;
}
 
</style>
<script src="menu_css.js"></script>
<script src="/js/QuickMenu.js"></script>
<script language="javascript"> 
<!--
function check() {
 
	
	document.frm.submit();
}
function na_print(vf){
	var st = "";
	if( document.frm.PPrint.length){
		st = document.frm.selPrint[vf].value
	}else{
		st = document.frm.selPrint.value
	}
	var arrstr= eval(st.split("|"));
	eval("na_custom_print_"+arrstr[0]+"('"+arrstr[1]+"')");
}
function change(page) {
	document.frm.radiovalue.value = page;
	var regist_no = document.frm.regist_no.value;
	var pgubun = document.frm.pgubun.value;
	if(page == '2') {
		document.frm.target = "Display";
		document.frm.method="post";
		document.frm.action = "regist02_detail_02.jsp?regist_no="+regist_no+"&pgubun="+pgubun;
		document.frm.submit();
	} else if(page == '3') {
		document.frm.target = "Display";
		document.frm.method="post";
		//document.frm.action = "CO603.jsp?regist_no="+regist_no+"&pgubun="+pgubun;
		document.frm.action = "regist02_detail_03.jsp?regist_no="+regist_no+"&pgubun="+pgubun;
		document.frm.submit();
	} else if((page == '4') || (page == '5') || (page == '6') || (page == '7') || 
			  (page == '8') || (page == '9') || (page == '10')|| (page == '11')){
		document.frm.target = "Display";
		document.frm.method="post";
		document.frm.action = "regist02_detail_04.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&page_no="+page;
		document.frm.submit();
	} else if(page == '12') {
		document.frm.target = "Display";
		document.frm.method="post";
		document.frm.action = "CO612.jsp?regist_no="+regist_no+"&pgubun="+pgubun;
		document.frm.submit();
	} else if(page == '13') {
		document.frm.target = "Display";
		document.frm.method="post";
		document.frm.action = "CO613.jsp?regist_no="+regist_no+"&pgubun="+pgubun;
		document.frm.submit();
	} else if(page == '14') {
		document.frm.target = "Display";
		document.frm.method="post";
		document.frm.action = "regist02_detail_14.jsp?regist_no="+regist_no+"&pgubun="+pgubun;
		document.frm.submit();
	} else if(page == '15') {
		document.frm.target = "Display";
		document.frm.method="post";
		document.frm.action = "CO615.jsp?regist_no="+regist_no+"&pgubun="+pgubun;
		document.frm.submit();
	}
}
function print1() {
	var regist_no = document.frm.regist_no.value;
	var pgubun = document.frm.pgubun.value;
	var page = document.frm.radiovalue.value;
	//alert(document.frm.chkNEW.checked);
	if(  (pgubun == '1') || (pgubun == '2') || (pgubun == '3') )
	{
		if(page == '2') {
			document.frm.target = "printframe";
			document.frm.method="post";
			
			
			if (document.frm.chkNEW.checked){
				if(confirm("새 양식으로 출력합니다.")) {
					document.frm.chkNEW.enabled = false
					document.frm.action = "regist02_detail_02_new.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print"; 
					document.frm.submit();
 
				}
			}else {
				if(confirm("구 양식으로 출력합니다.")) {
					document.frm.chkNEW.enabled = false
					document.frm.action = "regist02_detail_02.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print";
					document.frm.submit();
				}
 
			}
			
			
		} else if(page == '3') {
			document.frm.target = "printframe";
			document.frm.method="post";
			if (document.frm.chkNEW.checked)
				document.frm.action = "regist02_detail_03_new.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print";
			else
				document.frm.action = "regist02_detail_03.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print";
			document.frm.submit();
		} else if((page == '4') || (page == '5') || (page == '6') || (page == '7') || 
				  (page == '8') || (page == '9') || (page == '10')|| (page == '11')){
				  
					
			document.frm.target = "printframe";
			document.frm.method="post";
			if (document.frm.chkNEW.checked)
				document.frm.action = "regist02_detail_04_new.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print&page_no="+page;
			else
				document.frm.action = "regist02_detail_04.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print&page_no="+page;
			document.frm.submit();
		} else if(page == '12') {
			document.frm.target = "printframe";
			document.frm.method="post";
			document.frm.action = "CO612.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print";
			document.frm.submit();
		} else if(page == '13') {
			document.frm.target = "printframe";
			document.frm.method="post";
			document.frm.action = "CO613.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print";
			document.frm.submit();
		} else if(page == '14') {
			document.frm.target = "printframe";
			document.frm.method="post";
			if (document.frm.chkNEW.checked)
				document.frm.action = "CO614_new.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print";
			else
				document.frm.action = "CO614.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print";
			document.frm.submit();
		} else if(page == '15') {
			document.frm.target = "printframe";
			document.frm.method="post";
			document.frm.action = "CO615.jsp?regist_no="+regist_no+"&pgubun="+pgubun+"&gubun=print";
			document.frm.submit();
		}	
	}	
}
function cgubun() {
	var val = document.frm.pgubun.value;
	if(val == 4) {
		eval('document.frm').all["schange"].innerHTML = "<input type=radio name=page onClick='change(2)'><font color=red>HEAD출력(2쪽)</font>";
	} else {
		eval('document.frm').all["schange"].innerHTML = "<input type=radio name=page onClick='change(2)'><font color=black>HEAD출력(2쪽)</font>";
	}
}
function fSave(){
	var regist_no = document.frm.regist_no.value;
	var pgubun    = document.frm.pgubun.value;
	var page      = Number(document.frm.radiovalue.value);
 
    if (pgubun!="4"){
    	alert("출력구분은 기재사항변경이어야 합니다."); return;
    }
 
	if(page< 4 || 11< page) {
    	alert("현재 페이지가 정보통신기술자사항이 아닙니다."); return;
    }
 
    if (Display.frm.bln_ISRESULT.value!="true"){
    	alert("현재 페이지내용이 없습니다."); return;
    }
 
    if (confirm("저장하시겠습니까")){
        document.frm.target = "updateframe";
        document.frm.method = "POST";
        document.frm.action = "CO601_update.jsp?regist_no="+regist_no+"&PAGE="+page;
        document.frm.submit();
    }
 
    return;
}
function fSave2(){
	var regist_no = document.frm.regist_no.value;
	var pgubun    = document.frm.pgubun.value;
	var page      = Number(document.frm.radiovalue.value);
	
		
        document.frm.target = "updateframe";
        document.frm.method = "POST";
        document.frm.action = "CO601_update.jsp?regist_no="+regist_no+"&PAGE="+page+"&pgubun="+pgubun;
        document.frm.submit();
	return;
}
function change_gubun(){
	var pgubun = document.frm.pgubun.value;
	var page = document.frm.radiovalue.value;
	change(page);
	
}
//-->
</script>
</head>
<script language="JavaScript" src="/AIViewer_Ocx/AIScript.js"></script>
<!-- body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad=' QuickMenuLoad();  change(2);setAIOcx()' -->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad=' QuickMenuLoad();  change(2);' >
 
<!--topmenu 시작--> 
 
	
<script src="/js/flash.js"></script>
<form name=top_logo method=post>
 
<input type=hidden name=logo value="">
</form>
<form name=form2 method=post> 
  <input type="hidden" name="gubun" value="zmail">
  <input type="hidden" name="lang" value="kr">
  <input type="hidden" name="url" value="@kica.or.kr">
  <input type="hidden" name="eid" value="pumgh">
  <input type="hidden" name="pwd" value="8264bs">
</form>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" background="/images/bg.jpg"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td  valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td height="61">&nbsp;</td>
              </tr>
              <tr> 
                <td width="100%" height="34" bgcolor="216BB9"></td>
              </tr>
            </table></td>
          <td width="990"  valign="top"  08998C > 
            <!--메뉴들어가는  테이블부분 시작-->
            <table width="990" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="190" rowspan="2"><a href="/" target="_top" ><img src="/images/logo.gif" width="190" height="34"></a></td>
                <td width="800" height="30" colspan="2" align="left" valign="bottom">
				<!-- 로그인,마이키카,사이트맵,찾아오시는길 시작-->
				
 
<script type="text/javascript"> 
function logout(){	
	location.href = "/logout_main.jsp";	
}
function kika_logout(){	
	location.href = "/logout_main.jsp";	
}
function kika_login(){	
	location.href = "/login_main.jsp";	
}
</script>
<table width="86%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	  <td align="right">
	  
	  <a href="javascript:kika_logout();"><img src="/images/logout.gif" alt="로그아웃" border="0"></a>
	  
	  <a href="/web_app/mykica/mykica.jsp"><img src="/images/mykica.gif" alt="MyKica" width="49" height="23" border="0"></a><a href="/web_app/sitemap/sitemap.jsp"><img src="/images/sitemap.gif" alt="sitemap" width="50" height="23"></a><a href="/web_app/Kica/kica_map.jsp?&menuNum=6"><img src="/images/map.gif" alt="찾아오시는길" width="68" height="23"></a></td>
	</tr>
</table>
				<!-- 로그인,마이키카,사이트맵,찾아오시는길 끝--></td>
              </tr>
              <tr> 
                <td height="31" colspan="2" valign="top">
					<table width="514" border="0" cellspacing="0" cellpadding="0">
						<tr>
						  <td><a href="/web_app/cyberbiz/cyberbiz.jsp"><img src="/images/main/topmenu_01.gif" width="93" height="30"></a></td>
						  <td><a href="/web_app/TE/tender.jsp"><img src="/images/main/topmenu_02.gif" width="54" height="30" border="0"></a></td>
						  <td><a href="/web_app/CA/engine.jsp"><img src="/images/main/topmenu_03.gif" width="80" height="30" border="0"></a></td>
						  <td><a href="/web_app/Tech/tech.jsp"><img src="/images/main/topmenu_04.gif" width="101" height="30" border="0"></a></td>
						  <td><a href="/web_app/Law/law.jsp?kind=1"><img src="/images/main/topmenu_05.gif" width="69" height="30" border="0"></a></td>
						  <td><a href="/web_app/Cyber/customer.jsp"><img src="/images/main/topmenu_06.gif" width="59" height="30" border="0"></a></td>
						  <td><a href="/web_app/Kica/kica_ceo.jsp?&menuNum=0&div="><img src="/images/main/topmenu_07.gif"  height="30" border="0"></a></td>
 
						
						  <td><a href="/web_app/LocalAutonomy/regist01.jsp"><img src="/images/main/topmenuover_08.gif" width="44" height="30" border="0"></a></td>
						
 
						</tr>
                  </table></td>
              </tr>
              <tr> 
                <!--플래시 2 depth시작-->
                <td colspan="3" background="/images/kica/bgbar.gif">
					<script>ShowFlash('/images/flash/member_menu.swf?PageNum=1', '880', '61');</script></td>
                <!--플래시메뉴끝-->
              </tr>
            </table>
            <!--메뉴테이블들어가는 부분 끝-->
          </td>
          <td valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td height="61">&nbsp;</td>
              </tr>
              <tr> 
                <td width="100%" height="34" bgcolor="216BB9"></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
            <td height="1" colspan="3" background="/images/line_bg.gif"></td>
        </tr>
      </table></td>
  </tr>
</table>
 
<!--topmenu 끝--> 
 
 
<script>document.write(tagAIGeneratorOcx);</script><!--span id="aiocx"></span-->
 
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
<form name=frm method=post action="regist02_view_detail02.jsp">
<input type=hidden name=regist_no value='120010'>
<input type=hidden name=radiovalue value='2'>
  <tr> 
    <td align="center" valign="top"><table  height="100%"  width="995" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="880" valign="top" ><table height="100%" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="1" bgcolor="D3D3D3"></td>
                <td align="center" valign="top">
					<!--leftmenu 시작--> 
					
 
 
 
 
<script type="text/javascript"> 
<!--
/*
* psHref : 이동 시킬 url get방식으로 넘겨 준다.
* poMenuNum 이미지 번호로 over가 된 이미지에 대해서 이미지를 변경 시켜 준다.
* psDiv : '' div가 없는 경우(하위 메뉴가 없는경우)
* psOption : 직접 href
*/
function goMenu(psHref , poMenuNum, psDiv, psOption, psSubMenu)
{		
	if(psHref != '')
	{
		if(psOption == 'N' )
		{
			
			var tsHref = '';
			if(psSubMenu != '')
				tsHref = '&subMenu=' + psSubMenu;
			
			window.location.href = psHref+'&menuNum='+poMenuNum+'&div='+psDiv + tsHref	;		
		}
		else 
		{
			window.open(psHref, '', '');	
		}
 
		if(psSubMenu != '')
		{
			
			var toSubMneu = document.getElementsByName('subMenu');
			
			// 바탕화면 및 글자 색 변경하기
			for(var  i = 0 ;i < toSubMneu.length ;i++)
			{
				toSubMneu[i].style.background = 'F5F5F5';
				toSubMneu[i].style.color = '#3873AE';	
			}
 
			toSubMneu[psSubMenu].style.background = '#3873AE';
			toSubMneu[psSubMenu].style.color = '#FFF';	
		}
	}
}
 
 
var tsMenuOpen = 'N';
var tsMenuDiv = '';
function openMenu2(psImageNum, psDiv, psSubMenu)
{	
	//subMenu
	if(psSubMenu != '')
	{
		var toSubMneu = document.getElementsByName('subMenu');
		toSubMneu[psSubMenu].style.background = '#3873AE';
		toSubMneu[psSubMenu].style.color = '#FFF';	
	}
 
	var tempSubMenu_1 = document.getElementById('subMenu_1');
	var tempSubMenu_2 = document.getElementById('subMenu_2');
	var tempSubMenu_3 = document.getElementById('subMenu_3');
	var tempSubMenu_4 = document.getElementById('subMenu_4');
 
	tempSubMenu_1.style.display = 'none';
	tempSubMenu_2.style.display = 'none';
	tempSubMenu_3.style.display = 'none';
	tempSubMenu_4.style.display = 'none';
 
 
	if(psDiv == tsMenuDiv)
	{
		if(tsMenuOpen == 'N')
			tsMenuOpen = 'Y';
		else
		{
			tsMenuOpen = 'N';
			return;
		}	
	}
	else 
	{
		tsMenuOpen = 'Y';
	}
 
 
	tsMenuDiv = psDiv;
 
 
	//Div Change
	if(psDiv != '')
		document.getElementById(psDiv).style.display = 'inline';
 
	//Image 변경
	var tempImage = document.getElementsByName('menuImg');
 
	for(var i = 0 ;i < tempImage.length;i ++)
	{
		var tempImageSrc = tempImage[i].src;
		if(tempImageSrc.substring(tempImageSrc.length-8, tempImageSrc.length-4) == 'over')
		{
			tempImage[i].src = tempImageSrc.substring(0, tempImageSrc.length-8) + '.gif'
		}
	}
 
	if(psImageNum != '')
	{
		var tsImageSrc = tempImage[psImageNum].src;
		tsImageSrc = tsImageSrc.substring(0, tsImageSrc.length-4) + 'over.gif';
		tempImage[psImageNum].src = tsImageSrc;
	}
}
 
 
function openMenu21(psImageNum, psDiv, psSubMenu)
{	
	//subMenu
	if(psSubMenu != '')
	{
		var toSubMneu = document.getElementsByName('subMenu');
		toSubMneu[psSubMenu].style.background = '#3873AE';
		toSubMneu[psSubMenu].style.color = '#FFF';	
	}
 
 
	var tempSubMenu_3 = document.getElementById('subMenu_3');
	var tempSubMenu_4 = document.getElementById('subMenu_4');
 
 
	tempSubMenu_3.style.display = 'none';
	tempSubMenu_4.style.display = 'none';
 
 
	if(psDiv == tsMenuDiv)
	{
		if(tsMenuOpen == 'N')
			tsMenuOpen = 'Y';
		else
		{
			tsMenuOpen = 'N';
			return;
		}	
	}
	else 
	{
		tsMenuOpen = 'Y';
	}
 
 
	tsMenuDiv = psDiv;
 
 
	//Div Change
	if(psDiv != '')
		document.getElementById(psDiv).style.display = 'inline';
 
	//Image 변경
	var tempImage = document.getElementsByName('menuImg');
 
	for(var i = 0 ;i < tempImage.length;i ++)
	{
		var tempImageSrc = tempImage[i].src;
		if(tempImageSrc.substring(tempImageSrc.length-8, tempImageSrc.length-4) == 'over')
		{
			tempImage[i].src = tempImageSrc.substring(0, tempImageSrc.length-8) + '.gif'
		}
	}
 
	if(psImageNum != '')
	{
		var tsImageSrc = tempImage[psImageNum].src;
		tsImageSrc = tsImageSrc.substring(0, tsImageSrc.length-4) + 'over.gif';
		tempImage[psImageNum].src = tsImageSrc;
	}
}
 
-->
</script>
 
 
 
 
 
 
 
				<table width="187" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td><img src="/images/kica/top_leftimg.gif" width="187" height="116"></td>
                    </tr>
                  </table>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="14"></td>
                    </tr>
                    <tr>
                      <!--leftmenu-->
 
                      <td style="padding-left:10">
						<div class="sdmenu"> 
							
							<span class="title" style="cursor:hand">
								<a href="javaScript:openMenu2('0', 'subMenu_1', '')"><img name="menuImg" src="/images/local_autonomy/left_menu01.gif" width="169" height="26" border=0 ></a></span>
                              <div id="subMenu_1" class="submenu" style="display:none;"> 
								  <a href="javaScript:goMenu('regist01.jsp?', '0', 'subMenu_1', 'N', '0')"  name="subMenu">- 등록 · 신고· 행정처분 </a>
								  <a href="javaScript:goMenu('regist02_list.jsp?', '0', 'subMenu_1', 'N', '1')"  name="subMenu">- 등록수첩인쇄</a>
								  <a href="javaScript:goMenu('regist05.jsp?', '0', 'subMenu_1', 'N', '2')" name="subMenu">- 기술자경력수첩인쇄</a>
								  <a href="javaScript:goMenu('regist03.jsp?', '0', 'subMenu_1', 'N', '3')" name="subMenu">- 등록대장 · 등록증인쇄</a>
								  <a href="javaScript:goMenu('regist04.jsp?', '0', 'subMenu_1', 'N', '4')" name="subMenu">- 등록업무처리현황</a>
							  </div>
                            
							
							
							<span class="title" style="cursor:hand">
								<a href="javaScript:openMenu2('1', 'subMenu_2', '')" ><img name="menuImg" src="/images/local_autonomy/left_menu02.gif"  width="169" height="26" border="0"></a></span>
                              <div id="subMenu_2" class="submenu" style="display:none;"> 
								  <a href="javaScript:goMenu('report01.jsp?', '1', 'subMenu_2', 'N', '5')" name="subMenu">- 세부사항조회 </a>
								  <a href="javaScript:goMenu('report02.jsp?', '1', 'subMenu_2', 'N', '6')" name="subMenu">- 변경신고수리현황</a>
							  </div>
							
							
							
							<span class="title" style="cursor:hand">
								<a href="javaScript:openMenu2('2', 'subMenu_3', '')" ><img name="menuImg" src="/images/local_autonomy/left_menu03.gif"  width="169" height="26" border="0"></a></span>
                              <div id="subMenu_3"  class="submenu"  style="display:none;"> 
								  <a href="javaScript:goMenu('con01.jsp?', '2', 'subMenu_3', 'N', '7')" name="subMenu">- 공사업자(현등록자정보)</a> 
								  <a href="javaScript:goMenu('con02.jsp?', '2', 'subMenu_3', 'N', '8')" name="subMenu">- 공사업자(폐업업자정보)</a>
								  <a href="javaScript:goMenu('con03.jsp?', '2', 'subMenu_3', 'N', '9')" name="subMenu">- 등록기준 신고정보 </a>
								  <a href="javaScript:goMenu('con04.jsp?', '2', 'subMenu_3', 'N', '10')" name="subMenu">- 신고정보 예정업체 </a>
								  <a href="javaScript:goMenu('con05.jsp?', '2', 'subMenu_3', 'N', '11')" name="subMenu">- 신고정보 미달업체</a>
								  <a href="javaScript:goMenu('con06.jsp?', '2', 'subMenu_3', 'N', '12')" name="subMenu">- 시공능력평가 </a>
								  <a href="javaScript:goMenu('con07.jsp?', '2', 'subMenu_3', 'N', '13')" name="subMenu">- 행정처분 </a>
							  </div>
                              
							  
							  <span class="title" style="cursor:hand">
							  <a href="javaScript:openMenu2('3', 'subMenu_4', '')" ><img name="menuImg" src="/images/local_autonomy/left_menu04.gif"  width="169" height="26" border="0" ></a></span>
                              
							  <div id="subMenu_4"  class="submenu"  style="display:none;"> 
								  <a href="javaScript:goMenu('engineer01.jsp?', '3', 'subMenu_4', 'N', '14')" name="subMenu">- 정보통신 기술자관리 </a>
								  <a href="javaScript:goMenu('engineer02.jsp?', '3', 'subMenu_4', 'N', '15')" name="subMenu">- 업무정지 </a>
							  </div>
						 </div></td>
 
                      <!--leftmenu 끝-->
                    </tr>
                  </table>
                  <!--leftmenu 시작-->
                  <br>
                  <br>
				  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td align="center"><img src="/images/banner01.gif" width="150" height="61"></td>
                    </tr>
                    <tr> 
                      <td height="1" bgcolor="D3D3D3"></td>
                    </tr>
                    <tr>
                      <td valign="top"><img src="/images/banner02.gif" width="178"></td>
                    </tr>
                  </table>
				  
				  <input type="hidden" name="menuNum" value="0">
				  <input type="hidden" name="div" value="subMenu_1">
 
 
<script>  
<!--
 
 
var tsMenuNum = '0';
var tsDiv = 'subMenu_1';
var tsSubMenu = '';
 
 
openMenu2(tsMenuNum,tsDiv, tsSubMenu);
//-->
</script>
 
 
                  <!--leftmenu끝--> 
			    </td>
                <td width="1" bgcolor="D3D3D3"></td>
                <td width="20"></td>
                <td valign="top">
				
				<table width="672" border="0" align="right" cellpadding="0" cellspacing="0">
                  <tr>
                    <td colspan="2"><img src="/images/local_autonomy/top_img01.gif" width="672" height="116"></td>
                  </tr>
                  <tr>
                    <td><table width="672" height="31" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="31" style="padding-right:5;"><table width="328" border="0" align="right" cellpadding="0" cellspacing="0">
                              <tr>
                                <td width="37" align="right"><img src="/images/local_autonomy/home.gif" width="37" height="11"></td>
                                <td width="9">&nbsp;</td>
                                <td width="282" class="c808080"> 지자체 업무 &gt; 공사업등록업무처리 &gt; <strong>등록수첩인쇄</strong></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="1" background="../images/line_bg.gif"></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="30" colspan="2"><table width="672"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="14"></td>
                        </tr>
                        <tr>
                          <td style="padding-bottom:10;"><img src="/images/local_autonomy/regist_title.gif" width="242" height="17"></td>
                        </tr>
                    </table></td>
                  </tr>
                  
                  <tr>
                    <td colspan="2"></td>
					<tr>
					  <td class="space02"><img src="/images/local_autonomy/regist_s_tit02.gif" width="163" height="14">
					  &nbsp;&nbsp;<input type="checkbox" name="chkNEW" value='yes' checked ><b><font color=blue>새 양식으로 출력</font></b>
					  </td>
					  
					</tr>
                  <tr>
                    <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
                      <tr class="bg03">
                        <td width="11" height="30">&nbsp;</td>
                        <td width="56">출력구분:</td>
                        <td width="127">
						
						<select name=pgubun  style="width:120;" onChange='change_gubun()'>
							<option value=1 selected>신규</option>
							<option value=2 >재발급</option>
							<option value=3 >분실/훼손</option>	
						</select>
						      
						</td>
                        <td width="465"><img src="/images/local_autonomy/icon_print.gif" alt="출력"  border="0" align="absmiddle" onclick="javaScript:print1();" style="cursor:hand;"></td>
						
 
                      </tr>
                      <tr>
                        <td height="14" colspan="4"></td>
                      </tr>
                      <tr>
                        <td colspan="4"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
                            <tr>
                              <td width="10%" class="kica_border01">
								<span id='schange'>
											<input type=radio name=page onClick='change(2)' checked='on' >공사업자 기본사항(2쪽)
								</span></td>
                              <td width="10%" class="kica_border01"><input type=radio name=page onClick='change(3)'  > 시공능력평가사항(3쪽) </td>
                              <td width="10%" class="kica_border01"><input type=radio name=page onClick='change(4)'   > 정보통신기술자사항(4쪽)</td>
                              </tr>
                            <tr>
                              <td class="kica_border01"><input type=radio name=page onClick='change(5)'  disabled> 정보통신기술자사항(5쪽)</td>
                              <td class="kica_border01"><input type=radio name=page onClick='change(6)'  disabled> 정보통신기술자사항(6쪽) </td>
                              <td class="kica_border01"><input type=radio name=page onClick='change(7)'  disabled> 정보통신기술자사항(7쪽) </td>
                              </tr>
                            <tr>
                              <td class="kica_border01"><input type=radio name=page onClick='change(8)'  disabled> 정보통신기술자사항(8쪽) </td>
                              <td class="kica_border01"><input type=radio name=page onClick='change(9)'  disabled> 정보통신기술자사항(9쪽) </td>
                              <td class="kica_border01"><input type=radio name=page onClick='change(10)'  disabled> 정보통신기술자사항(10쪽) </td>
                              </tr>
                            <tr>
                              <td class="kica_border01"><input type=radio name=page onClick='change(11)'  disabled> 정보통신기술자사항(11쪽) </td>
                              <td class="kica_border01"><input type=radio name=page onClick='change(12)' disabled> 변경사항(12쪽) </td>
                              <td class="kica_border01"><input type=radio name=page onClick='change(13)' disabled>변경사항(13쪽) </td>
                              </tr>
                            <tr>
                              <td class="kica_border01"><input type=radio name=page onClick='change(14)'  > 행정처분사항(14쪽)</td>
                              <td class="kica_border01">&nbsp;</td>
                              <td class="kica_border01">&nbsp;</td>
                              </tr>
                        </table></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="30"></td>
                  </tr>
                  <tr>
                    <td align="center">
					
						<iframe name="Display" WIDTH="610" height="400" frameborder="0" scrolling=no  marginwidth=0 marginheight=0></iframe>
						<iframe name="printframe" WIDTH="0" height="0" marginwidth=0 marginheight=0></iframe>
						<iframe name="updateframe" WIDTH="0" height="0" frameborder="0" marginwidth=0 marginheight=0></iframe>
 
					</td>
                  </tr>
                  <tr>
                    <td height="100" colspan="2"></td>
                  </tr>
                </table></td>
              </tr>
            </table>
			
</form>
            <map name="Map">
              <area shape="rect" coords="196,58,278,84" href="#">
            </map></td>
			<!--퀵메뉴-->
          <td width="110" align="right" valign="top" style="padding-top:10px">
				  
<script language="javascript"> 
function goMenu_popup_quick(psHref , poMenuNum, psDiv, psOption, psSubMenu)
{	
	if(psHref != '')
	{
		if(psOption == 'N' )
		{
			
			var tsHref = '';
			if(psSubMenu != '')
				tsHref = '&subMenu=' + psSubMenu;
			
			window.location.href = psHref+'&menuNum='+poMenuNum+'&div='+psDiv + tsHref;	
		}
		else 
		{
 
			window.open(psHref, '', 'left=100,top=100,Width=1200,height=1000,scrollbars=yes,resizable=yes,toolbar=no');	
		}
 
		if(psSubMenu != '')
		{
			
			var toSubMneu = document.getElementsByName('subMenu');
			
			// 바탕화면 및 글자 색 변경하기
			for(var  i = 0 ;i < toSubMneu.length ;i++)
			{
				toSubMneu[i].style.background = 'F5F5F5';
				toSubMneu[i].style.color = '#498BD6';	
			}
 
			toSubMneu[psSubMenu].style.background = '#498BD6';
			toSubMneu[psSubMenu].style.color = '#FFF';	
		}
 
	}
 
}
 
</script>
<script> 
function MsgSingo()
{
alert("개발중입니다.");
}
function MsgSingo1()
{
alert("접수시간은 근무일 9시 부터 18시까지입니다.");
}
 
function MsgSingo2()
{
alert("시범운용기간이므로 대구·경북도회, 전북도회업체만 가능합니다");
}
 
function MsgSingo3()
{
alert("로그인 후 사용하세요");
}
 
function BalgubQuick()
{
	window.open("/web_app/order/order_main.jsp", "WOrder", "width=400,height=210, toolbar=no,status=yes,location=no");
}
</script>
<!--quick-->
<div id="quick" style="position:absolute; top:220px; left:900px; width:25px; height:26px;">
	<table width="93" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td><a href="/member/member_join.jsp"><img src="/images/main/quick_img01.gif" alt="회원가입안내" /></a></td>
		</tr>
		<tr>
			<td><a href="/web_app/cyberbiz/cyberbiz.jsp"><img src="/images/main/quick_img02.gif" alt="회원정보" /></a></td>
		</tr>
		<tr>
			<td><a href="/web_app/TE/tender.jsp"><img src="/images/main/quick_img03.gif" alt="입찰정보" /></a></td>
		</tr>
        <tr>
			<td><a href="/web_app/cyberbiz/alibi03.jsp"><img src="/images/main/quick_img04.gif" alt="제증명서발급" /></a></td>
		</tr>
        <tr>
			<td><a href="/web_app/cyberbiz/kongsach01.jsp?&amp;menuNum=0&amp;div=subMenu_1?Menu=0"><img src="/images/main/quick_img05.gif" alt="공사업변경신고" /></a></td>
		</tr>
        <tr>
			<td><a href="/web_app/Law/law01.jsp?&amp;menuNum=0&amp;div=subMenu_1?Menu=0"><img src="/images/main/quick_img06.gif" alt="법령정보" /></a></td>
		</tr>
        <tr>
			<td><a href="javaScript:goMenu_popup_quick('/web_app/cyberbiz/result02_1.jsp?', '2', 'subMenu_3', 'Y', '7')"  name="subMenu"><img src="/images/main/quick_img07.gif" alt="공사실적신고" /></a></td>
		</tr>
        <tr>
			<td><a href="/web_app/cyberbiz/sikong01.jsp?&amp;menuNum=3&amp;div=subMenu_4&amp;subMenu=8"><img src="/images/main/quick_img08.gif" alt="시공능력평가" /></a></td>
		</tr>
<!-- 추가 2011. 3. 15 --> 
        <tr>
			<td><a href="#none" onClick="BalgubQuick();" onKeyPress="if(event.keyCode == 13) this.click();"><img src="/images/main/quick_img10.gif" alt="제증명원본확인" /></a></td>
		</tr> 
<!-- -->		
		<tr>
			<td><a href="/web_app/mykica/mykica.jsp"><img src="/images/main/quick_img09.gif" alt="MY KICA" /></a></td>
		</tr>
 
 
</table>
</div>
		  </td>
			<!--퀵메뉴 끝-->
        </tr>
    </table></td>
  </tr>
  <tr> 
    <td height="1" colspan="3" background="../images/line_bg.gif"></td>
  </tr>
  <tr> 
    <td height="5"></td>
  </tr>
  <tr> 
    <td align="center">
   <!--footer 시작-->
	
	<!--footer 시작-->
	<div id="footer">
	<div id="footer-main">
<style> 
.bottomImg{
	position:absolute;
	cursor:hand;
}
</style>
 
<script language="JavaScript"> 
 
var RollImage = new Array();
RollImage[0] = "/images/main/banner01_kcc2.gif";
RollImage[1] = "/images/main/banner04.gif";
RollImage[2] = "/images/main/banner03.gif";
RollImage[3] = "/images/main/banner02.gif";
RollImage[4] = "/images/main/banner01_acrc.gif";
RollImage[5] = "/images/main/banner_kipo.gif";
RollImage[6] = "/images/main/banner01_news.gif";
RollImage[7] = "/images/main/banner07_conex.gif";
RollImage[8] = "/images/main/banner08_kosha.JPG";
 
var RollHref = new Array();
RollHref[0] = "http://www.kcc.go.kr";
RollHref[1] = "http://www.pps.go.kr";
RollHref[2] = "http://www.icpc.ac.kr";  
RollHref[3] = "http://www.icfc.or.kr";
RollHref[4] = "http://www.acrc.go.kr/acrc/index.jsp?menuID=010501";
RollHref[5] = "http://www.kipo.go.kr/kpo/user.tdf?a=user.main.MainApp";
RollHref[6] = "http://www.etnews.co.kr";
RollHref[7] = "http://www.conex.or.kr";
RollHref[8] = "http://www.kosha.or.kr";
 
 
function createImage(id){
 
	var tDiv = document.getElementById(id);
	var tHref = "";
	for( var i = 0 ; i < RollImage.length ; i++ ){
		var tempImg =  new Image();
		tempImg.src = RollImage[i];
		tempImg.link = RollHref[i];
		tempImg.onclick = moveBSite;
		tDiv.appendChild(tempImg);
		tempImg.className = "bottomImg";
	}
}
function ftn_rolling_bottom(id, intervalTime){
	
	createImage(id);
	createImage(id);
	var tDiv = document.getElementById(id);
	var tnTotalLength =  parseInt(tDiv.style.width);
	var aImg = tDiv.getElementsByTagName("IMG");
	var tnChildTotalLength = 0;
	var iLeft = 0 ;
	var speed=1;
	
	for( var tI = 0 ; tI < aImg.length ; tI++ ){
 
		if(tI==2){	
			aImg[tI].style.width='130';
			aImg[tI].style.height='29';
		}
		
		aImg[tI].style.left = iLeft;
		tnChildTotalLength += aImg[tI].width;
		iLeft = tnChildTotalLength;
		
	}
	
	var rollInterval = setInterval(
	function()
	{	
		
		var min = 0;
		var max = 0;
		var minI = 0;
		var maxI = 0;
 
 
		tDiv.onmouseover = function(){
			speed = 0;
		}
		tDiv.onmouseout = function(){
			speed = 1;
		}
		for( var tI = 0 ; tI < aImg.length ; tI++ ){
			
			 if(min > parseInt(aImg[tI].style.left) ){
				minI = tI;
				min = parseInt(aImg[tI].style.left);
			 }
			  if(max < parseInt(aImg[tI].style.left) ){
				maxI = tI;
				max = parseInt(aImg[tI].style.left);
			 }
 
			aImg[tI].style.left = parseInt(aImg[tI].style.left)-speed +"px";
			
		}
		
		if( (parseInt(aImg[minI].style.left) +aImg[minI].width ) < -10 ){
			aImg[minI].style.left = (parseInt(aImg[maxI].style.left) +aImg[maxI].width ) +"px";
		}
 
	}
	,intervalTime);
	
 
 
}
function moveBSite(){
	document.frm_bottom.action = this.link;
	document.frm_bottom.submit();
}
</script>
 
<script language="JavaScript"> 
 function MM_jumpMenu1(targ,selObj,restore){ 
	if(selObj.selectedIndex!=0){
		eval("window.open('"+selObj.options[selObj.selectedIndex].value+"','','')"); if (restore) selObj.selectedIndex=0; } 
	}
</script>
		<form name="frm_bottom" method="post" target="_blank" >
		</form>
		<table width="821" border="0" cellpadding="0" cellspacing="0">			
			<tr>
				<td width="4" valign="top" >&nbsp;</td>
				<td width="821" valign="top"><table width="821" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="184"><img src="/images/main/footerlogo.gif" alt="한국정보통신공사협회" width="184"></td>
							<td width="500" align="center" valign="top">
							<div id="rolling_bottom" style="width:500px; height:36px;position:relative;overflow:hidden;white-space:nowrap;" > </div>
							<script type="text/javascript">
								ftn_rolling_bottom("rolling_bottom",30);
							</script></td>
							<td width="126" valign="middle" ><select name="menu1" onChange="MM_jumpMenu1('parent',this,0)">
									<option selected>광역지방자치단체</option>
									<option value="http://info.seoul.go.kr" >서울특별시청</option>
									<option value="http://www.incheon.go.kr" >인천광역시청</option>
									<option value="http://www.minwon.gg.go.kr" >경기본청</option>
									<option value="http://north.gyeonggi.go.kr">경기2청</option>
									<option value="http://www.busan.go.kr">부산광역시청</option>
									<option value="http://www.ulsan.go.kr">울산광역시청 </option>
									<option value="http://www.gyeongbuk.go.kr">경상남도청 </option>
									<option value="http://www.daegu.go.kr">대구광역시청</option>
									<option value="http://www.gyeongbuk.go.kr">경상북도청</option>
									<option value="http://www.metro.gwangju.kr">광주광역시청</option>
									<option value="http://www.provin.jeonnam.kr">전라남도청</option>
									<option value="http://www.daejeon.go.kr">대전광역시청</option>
									<option value="http://www.chungnam.net" >충청남도청</option>
									<option value="http://www.jeonbuk.go.kr" >전라북도청</option>
									<option value="http://www.provin.gangwon.kr" >강원도청</option>
									<option value="http://www.cb21.net" >충청북도청</option>
									<option value="http://www.jeju.go.kr" >제주특별자치도청</option>
								</select></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<!-- 변경전 <td><img src="/images/main/main/bottomtxt.gif" width="436" height="50" border="0" usemap="#Map2"></td> -->
							<td><img src="/images/main/bottom_copyright.gif" alt="단체:한국정보통신공사협회 대표자:김일수 고유번호:102-82-04064 연락처:02-3488-6000 단체:한국정보통신공사협회 대표자:김일수 고유번호:102-82-04064 연락처:02-3488-6000" width="447" height="47" border="0" usemap="#Map" /></td>
							<!--
			  <td><img src="/images/main/main/info_b.gif"  border="0" usemap="#Map3"></td>       
			  
			  <td><img src="/images/main/main/info_b.gif" width="86" height="20" border="0" usemap="#NewMap101"></td>      
			  <td><img src="/images/main/main/info_b.gif" width="86" height="20" border="0" usemap="#NewMap101"></td>      
			  <td>  <a href="http://www.kica.or.kr/web_app/Cyber/privacy01.jsp?bid_gb=A&menuNum=0&div=subMenu_0&subMenu=0" ><font color="darkgreen">개인정보보호방침</font></a></td>
			  -->
							<td><a href="http://www.kica.or.kr/web_app/Cyber/privacy01.jsp?bid_gb=A&menuNum=0&div=subMenu_0&subMenu=0" > </a></td>
						</tr>
					</table>
					<!--메뉴들어가는  테이블부분 시작-->
					<!--메뉴테이블들어가는 부분 끝--></td>
				<td width="4" valign="top" >&nbsp;</td>
			</tr>
			<tr>
				<td height="1" colspan="3" background="/images/main/line_bg.gif"></td>
			</tr>
		</table>
	</div>
	</div>
	<map name="Map" id="Map"><area shape="rect" coords="274,16,354,33" href="http://www.kica.or.kr/web_app/Cyber/privacy01.jsp?bid_gb=A&amp;menuNum=0&amp;div=subMenu_0&amp;subMenu=0" />
	</map>
	<!--footer end-->
    <!-- footer 끝-->
	</td>
  </tr>
  <tr>
     <td height="1" colspan="3" background="../images/line_bg.gif"></td>
  </tr>
</table>
<!-- ### AIReport 기존 Applet 소스 주석처리
<APPLET  CODE = WebnaraReport.class CODEBASE = "http://www.kica.or.kr/AIReport/generator" ARCHIVE = WebnaraReport.jar WIDTH = 0 HEIGHT = 0 NAME = WebnaraReport>
<PARAM NAME = bgcolor VALUE ="00008B">
<PARAM NAME = cabinets VALUE ="WebnaraReport.cab">
<PARAM NAME = reload VALUE =true>
<PARAM NAME = Download VALUE ="http://www.kica.or.kr/AIReport/generator/AIViewer.exe">
</APPLET>
-->
</body>
</html>
 

