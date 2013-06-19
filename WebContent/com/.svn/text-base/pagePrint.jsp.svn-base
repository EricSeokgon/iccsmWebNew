<%--
*************************************************************************************************
* 파  일  명 : pagePrint.jsp
* 설      명 : 프린트 출력 화면
*
* 이력사항 :
* 2006/09/14  오두식   최초작성
* 2007/07/03  오두식  수정
* 기타 설명은 저한테 물어 주십시오.
*************************************************************************************************
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="imagetoolbar" content="no">
<meta http-equiv=Cache-Control content=No-Cache>
<meta http-equiv=Pragma content=No-Cache>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>::Page Print::</title>



<!-- 공퉁 부분 -->
<script language="JavaScript" type="text/javascript">
this.name = "PrintScreen";
document.title = opener.window.document.title;

function init() {
	try{
		var opendiv = opener.document.getElementById("PrintDiv");
		var opendivifrm = opendiv.getElementsByTagName("iframe");
		var html = "";

		for(i=0; i<opendivifrm.length; i++){
			if(opendivifrm[i].name == "FCKviewFrame"){
				html = opener.FCKviewFrame.document.body.innerHTML;
				break;
			}
		}
		if(html == "")	html = opener.document.getElementById("PrintDiv").innerHTML;

		//document.getElementById("printFrame").innerHTML+=html;
		html +='<link href="../com/css/style.css" rel="stylesheet" type="text/css">';
		html +='<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">';

		document.body.innerHTML+=html;
		window.print();
	}catch(e){
		alert('프린트를 할 수 없는 페이지입니다.');
		self.close();
		return;
	}
}

//프린팅 함수
//이 개체를 쓰려면 신뢰할 수 있는 사이트에 현재 사이트가 추가 되어 있어야 한다.
function Print_Sche(intOLEcmd, intOLEparam){
/*
	try{
	   //웹 브라우저 컨트롤 생성
	   var WebBrowser = '<object ID="WebPrint" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';

	   //웹 페이지에 객체 삽입
	   document.body.insertAdjacentHTML('beforeEnd', WebBrowser);

	   //if intOLEparam이 정의되어 있지 않으면 디폴트 값 설정
	   if ( ( ! intOLEparam ) || ( intOLEparam < -1 )  || (intOLEparam > 1 ) )
	      intOLEparam = 1;

	   //ExexWB 메쏘드 실행
	   WebPrint.ExecWB(intOLEcmd, intOLEparam );

	   //객체 해제
	   WebPrint.outerHTML = "";
	   self.close();
	}catch(e){
		try{
			alert("화면 출력을 위하여 신뢰할 수 있는 사이트에 본 사이트 주소를 추가하여 주십시오");
			document.location.href="../com/security.html";
		}catch(ea){
			alert("신뢰할 수 있는 사이트에 본 사이트 주소를 추가하여 주십시오");
			self.close();
		}

		return;
	}
*/	
}

//인쇄 미리보기가 닫히면 팝업창도 같이 닫히도록 한다.
function fn_checkOpener(){
	self.close();
	opener.status=new Date();
}
//setInterval(fn_checkOpener,100);
</script>
</head>
<body onLoad="init();Print_Sche(7);" style="margin:0px">
</body>
</html>