<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="com.fredck.FCKeditor.*" %>

<%
	ReportEntity rEntity = (ReportEntity)request.getAttribute("rEntity");

	String CONTENT  = rEntity.getValue(0, "CONTENT");
%>

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<script language="javascript" src="../com/js/httpRequest.js" type="text/javascript"></script>
<!-- 공퉁 부분 -->

<SCRIPT LANGUAGE="JavaScript">
<!--

/***************************************************************************
* Title   : 신규
* Content : 신규 처리를 한다.  
****************************************************************************/
function fn_close() {
	self.close();
}

//-->
</SCRIPT>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<!-- 폼은 가능한 하나로 처리한다. -->
<form name=fmParam method="post" action="../hms/HmsAction.do" >

<table width="100%" border="0" cellspacing="0" cellpadding="5">
    <tr>
        <td class="inputTable_header_td" width="10%">메뉴ID</td>
      	<td align="center" height="25" class="inputTable_td" width="10%"><%= rEntity.getValue(0, "SEQ") %>&nbsp;</td>
		<td class="inputTable_header_td" width="10%">버전</td>
      	<td align="center" height="25" class="inputTable_td" width="10%"><%= rEntity.getValue(0, "VERSION") %></td>
		<td class="inputTable_header_td" width="10%">사용유무</td>
      	<td align="center" height="25" class="inputTable_td" width="10%"><%= rEntity.getValue(0, "USE_YN") %></td>
		<td class="inputTable_header_td" width="10%">등록일</td>
      	<td align="center" height="25" class="inputTable_td"><%= rEntity.getValue(0, "INS_DT") %></td>
    </tr>
</table>
<br/>

<table width="100%" border="0" cellspacing="0" cellpadding="0" >
    <tr>
        <td>
			<%
				FCKeditor oFCKeditor;
				oFCKeditor = new FCKeditor( request, "EditorDefault" );
				oFCKeditor.setHeight("600");
				oFCKeditor.setBasePath( "../com/FCKeditor/" ) ;
				oFCKeditor.setToolbarSet("HmsPreview");
				oFCKeditor.setValue(CONTENT);
				oFCKeditor.setInstanceName("CONTENT");
				out.println( oFCKeditor.create() ) ;
			%> 
		</td>
    </tr>
</table>
<br/>

<table align="center" border="0" cellspacing="0" cellpadding="5">
    <tr>
        <td><img src="../images/html/bt_cancel.gif" border="0" alt="취소" onClick="fn_close()" style="cursor:hand"></td>
    </tr>
</table>

</form>
</body>
</html>