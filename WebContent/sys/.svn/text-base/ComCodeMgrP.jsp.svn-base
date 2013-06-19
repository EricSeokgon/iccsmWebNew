<%@ page contentType="text/html;charset=ksc5601"%>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.sys.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%

	SysParam pm = (SysParam)request.getAttribute("pm");
	
	//필수 변수 (검색창 상태)
	//String isSearch      	 	= KJFUtil.print(pm.getIsSearch());
	
	
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../../com/css/styleOld.css" rel="stylesheet" type="text/css">
<link href="../../com/css/skin/brown.css" rel="stylesheet" type="text/css">
<link href="../../com/css/styleAdmin.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../../com/js/kjs.js" type="text/javascript"></script>

<script>
// 신규 등록 폼 초기화
function fn_new(){
	var fm = document.fmParam;
}

// 내용 저장
function fn_save(){

}

// 선택 삭제
function fn_delete(){

}

// 검색 창 처리
function fn_search(){
	args = new Array();
	
	var fm = document.fmParam;
	
	var ozFile 		= "sys/sys/ComCodeMgrP.ozr";
	var ozOdiname 	= "ComCodeMgrP";
	
	args[0] = "SC_P_CODE=" + fm.SC_P_CODE.value;
	args[1] = "SC_GROUP_NAME=" + fm.SC_P_CODE.options[fm.SC_P_CODE.selectedIndex].text;
	
	//args[4] = "scGisu=" + fm.scGisu.value;
	
	ozViewerCreate(ozFile,ozOdiname,args);

}

// 츨력 처리
function fn_print(){

}

// 엑셀 츨력 처리
function fn_excel(){

}


</script>
<style type="text/css">
<!--
.style1 {font-weight: bold}
.style2 {
	color: #336699;
	font-style: italic;
	font-weight: bold;
	font-size: 12pt;
	font-family: Arial, Helvetica, sans-serif;
}
-->
</style>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"> 
<form name=fmParam method="post" action="../blank/BlankAction.do" >
<!-- CUD 모드-->  
<INPUT type="hidden" name="cmd" value="Blank">
<INPUT type="hidden" name="mode">

<!-- 타이틀 시작--> 
<jsp:include page="../../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
        <jsp:param name="ButtonType" value=""/>
</jsp:include>
<!-- 타이틀 끝 -->            


<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
	<tr> 
		<td>

						
			<jsp:include page="../../com/inc/bgBox_top_inc.jsp" flush="true"/>
<!-- 검색부 디자인 부분 시작 -->
			<table class='table_hide' width="100%" border="0" cellspacing="0" cellpadding="0" id="searchTable" >
              <tr>
                <td><table width="100%" border="0" align="center" cellpadding="3" cellspacing="0"  >
                  <tr>
                    <td width="77" align="right"><div align="center"><strong><span class="style2">Search</span> 
                    </strong></div></td>
                    <td width="732" align="right"><input type=image src="../images/bt_close.gif" width="41" height="17" onClick="tableHide();"></td>
                  </tr>
                  <tr>
                    <td colspan="2" align="center"><!-- 검색부 디자인 부분 시작 -->
                        <!---------------------------------- 검색영역 라인 --------------------------------------------->
                        <!-- 공간은 &nbsp; 로 처리한다. -->
                        <table width="100%"  border="0" cellspacing="0" cellpadding="0" >
                          <tr>
                            <td width='120'><div align="left"><strong>코드그룹선택</strong>                              </div></td>
                            <td><KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_sc_code_group")%>" 
		  						name="SC_P_CODE" 
		  						value="" 
		  						script="class='input_combobox2' "/>                            </td>                            
                          </tr>
                        </table>
                        <!---------------------------------- 검색영역 라인 --------------------------------------------->
                        
                        <!-- 검색부 디자인 부분 끝 -->                    </td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="61">
				   <!-- 검색버튼 -->
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" id="searchButton">
                          <tr>
                            <td  align ="right"  height="28" ><a href='#' onclick='fn_search();'><img src="../images/bt_search.gif" border="0"></a></td>
                          </tr>
                        </table>						
                   <!-- 검색버튼 -->			    </td>
              </tr>
            </table>
			<!-- 검색부 디자인 부분 끝 -->	
<jsp:include page="../../com/inc/bgBox_bottom_inc.jsp" flush="true"/>			


			<!-- 레포트 삽입 시작-->
			<script src="../../com/js/ozViewer.js"></script>
			<!-- 레포트 삽입 끝 --></td>
	</tr> 
</table>

<!-- copyright End -->
<jsp:include page="../../com/inc/foot_inc.jsp" flush="true"/>

</form>
</body>
</html>
