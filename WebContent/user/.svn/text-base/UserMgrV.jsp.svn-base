<%@ page contentType="text/html;charset=ksc5601"%>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.user.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%

	UserParam pm = (UserParam)request.getAttribute("pm");
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");
	
	String USER_CODE			= "";
	String USER_ID 				= "";
	String USER_PASSWD 			= "";
	String USER_NAME 			= "";
	String USER_TEL 			= "";
	String USER_EMAIL 			= "";
	String USER_MOBILE 			= "";
	String USER_NAT_NUM 		= "";
	String ORGANIZATION			= "";
	String POSITION				= "";
	String POST					= "";
	String STAFF_LEVEL			= "";
	String STAFF_SYSTEM			= "";
	String CAPITAL			= "";
	//String USER_AUTH			= "";
	String REG_DATE 			= "";
	String MOD_DATE 			= "";
	String LAST_CONN 			= ""; 
	String USE_YN	 			= "";
	
	String USER_NAT_NUM1		= "";
	String USER_NAT_NUM2		= "";
	
	
	if(rEntity != null && rEntity.getRowCnt() != 0){
		USER_CODE 			= KJFUtil.print(rEntity.getValue(0,"USER_CODE"),"&nbsp;");
		USER_ID 			= KJFUtil.print(rEntity.getValue(0,"USER_ID"),"&nbsp;");
		USER_PASSWD 		= KJFUtil.print(rEntity.getValue(0,"USER_PASSWD"),"&nbsp;");
		USER_NAME 			= KJFUtil.print(rEntity.getValue(0,"USER_NAME"),"&nbsp;");
		USER_TEL 			= KJFUtil.print(rEntity.getValue(0,"USER_TEL"),"&nbsp;");
		USER_EMAIL 			= KJFUtil.print(rEntity.getValue(0,"USER_EMAIL"),"&nbsp;");
		USER_MOBILE 		= KJFUtil.print(rEntity.getValue(0,"USER_MOBILE"),"&nbsp;");
		USER_NAT_NUM 		= KJFUtil.print(rEntity.getValue(0,"USER_NAT_NUM"),"&nbsp;");
		ORGANIZATION		= KJFUtil.print(rEntity.getValue(0,"ORGANIZATION"),"&nbsp;");
		POSITION			= KJFUtil.print(rEntity.getValue(0,"POSITION"),"&nbsp;");
		POST				= KJFUtil.print(rEntity.getValue(0,"POST"),"&nbsp;");
		STAFF_LEVEL			= KJFUtil.print(rEntity.getValue(0,"STAFF_LEVEL"),"&nbsp;");
		STAFF_SYSTEM		= KJFUtil.print(rEntity.getValue(0,"STAFF_SYSTEM"),"&nbsp;");
		CAPITAL			= KJFUtil.print(rEntity.getValue(0,"CAPITAL"),"&nbsp;");
		//USER_AUTH			= KJFUtil.print(rEntity.getValue(0,"USER_AUTH"));
		REG_DATE 			= KJFUtil.print(rEntity.getValue(0,"REG_DATE"),"&nbsp;");
		MOD_DATE 			= KJFUtil.print(rEntity.getValue(0,"MOD_DATE"),"&nbsp;");
		LAST_CONN 			= KJFUtil.print(rEntity.getValue(0,"LAST_CONN"),"&nbsp;");
		USE_YN 				= KJFUtil.print(rEntity.getValue(0,"USE_YN"),"&nbsp;");
		String[] str = USER_NAT_NUM.split("-");
		if(str.length==2){
			USER_NAT_NUM1 = str[0];
			USER_NAT_NUM2 = str[1];
			
			USER_NAT_NUM = str[0] + "-*******";
		}
	}
	
	//필수 변수 (페이징 처리)
	String nowPage          	= KJFUtil.print(pm.getNowPage());
	String rowPerPage       	= KJFUtil.print(pm.getRowPerPage());
	String totalCount      	 	= KJFUtil.print(pm.getTotalCount());
	
	//필수 변수 (검색창 상태)
	String isSearch      	 	= KJFUtil.print(pm.getIsSearch());

	int int_rnum= KJFUtil.str2int(totalCount)-(KJFUtil.str2int(nowPage) *KJFUtil.str2int(rowPerPage) - KJFUtil.str2int(rowPerPage));

	KJFDate dt = new KJFDate();
	String now_year = dt.getCurTime("yyyy");
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<link href="../../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<link href="../../com/css/styleAdmin.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../../com/js/kjs.js" type="text/javascript"></script>

<script>

//신규 등록
function fn_new(){
	var fm = document.fmParam;
	
    fm.cmd.value="UserMgrW";
    fm.submit();
}

// 내용 저장
function fn_save(){
	
}

// 선택 삭제
function fn_delete(){

}

// 검색 창 처리
function fn_search(){

}

// 츨력 처리
function fn_print(){
	
}

// 엑셀 츨력 처리
function fn_excel(){
	
}


// 취소
function fn_cancel( ) {

	var fm = document.fmParam;
	
    fm.cmd.value="UserMgr";
    fm.method = "post";
    fm.submit();
}

// 수정
function fn_modyfy() {

	var fm = document.fmParam;
	
    fm.cmd.value="UserMgrW";
    fm.mode.value="M";
    fm.method = "post";
    fm.submit();
}

</script>
<style type="text/css">
<!--
.style1 {font-weight: bold}
-->
</style>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"> 
<form name=fmParam method="post" action="../user/UserAction.do" >
<!-- CUD 모드-->  
<INPUT type="hidden" name="cmd" value="UserMgr">
<INPUT type="hidden" name="mode">
<!-- 검색창 상태 처리(필수)-->   
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">
<!-- 페이징 관련(필수)-->       
<input type=hidden name="nowPage"       value="<%=nowPage%>">

<input type=hidden name="saveUserID" value="">
<input type=hidden name="isIDCheck" value="">
<input type=hidden name="USER_NAT_NUM">
<input type=hidden name="USER_CODE" value="<%=USER_CODE%>">

<!-- 타이틀 시작--> 
<jsp:include page="../../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
        <jsp:param name="ButtonType" value="N,M,C"/>
</jsp:include>
<!-- 타이틀 끝 -->            

<table width="100%" border="0" cellspacing="0" cellpadding="5" class="inputTable">
	<tr>
		<td class="inputTable_header_td" width="20%">이름</td>
		<td class="inputTable_td" colspan="3"><%=USER_NAME%></td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">사용자  ID</td>
		<td class="inputTable_td" colspan="3"><%=USER_ID%></td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">패스워드 </td>
		<td class="inputTable_td" colspan="3"><%=USER_PASSWD%></td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">이 메 일</td>
		<td class="inputTable_td" colspan="3"><%=USER_EMAIL%></td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">전 화 번 호</td>
		<td class="inputTable_td" colspan="3"><%=USER_TEL%></td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">핸 드 폰</td>
		<td class="inputTable_td" colspan="3"><%=USER_MOBILE%></td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">주민등록 번호</td>
		<td class="inputTable_td" colspan="3"><%=USER_NAT_NUM1%> - <%=USER_NAT_NUM2%></td>
	</tr>	
	
	<tr>
       	<td class="inputTable_header_td" width="20%">소 속 (부서)</td>
       	<td class="inputTable_td" colspan="3"><%=POSITION%></td>
     </tr>
     
	<tr>
       	<td class="inputTable_header_td" width="20%">담 당</td>
       	<td class="inputTable_td" colspan="3"><%=POST%></td>
     </tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">사 용 자 그 룹</td>
		<td class="inputTable_td" colspan="3"><%=CAPITAL%></td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">사용여부</td>
		<td class="inputTable_td" colspan="3"><%=USE_YN%></td>
	</tr>	
	
	<tr>
        <td class="inputTable_header_td">등 록 일</td>
        <td class="inputTable_td" colspan="3"><%=REG_DATE%></td>
    </tr>
    
    <tr>
      <td class="inputTable_header_td">수 정 일</td>
      <td class="inputTable_td" colspan="3"><%=MOD_DATE%></td>
    </tr>
    
    <tr>
      <td class="inputTable_header_td">마지막 접속일</td>
      <td class="inputTable_td" colspan="3"><%=LAST_CONN%></td>
    </tr>                          
</table>
<br>


<!-- copyright End -->
<jsp:include page="../../com/inc/foot_inc.jsp" flush="true"/>

</body>
</html>
