<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.user.*" %>
<%@ page import="sp.uent.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%
	UserParam pm = (UserParam)request.getAttribute("pm");
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");
	
	UserEnt user = (UserEnt) request.getSession().getAttribute("user");
	
	//필수 변수 (페이징 처리)
	String nowPage          	= KJFUtil.print(pm.getNowPage());
	String rowPerPage       	= KJFUtil.print(pm.getRowPerPage());
	String totalCount      	 	= KJFUtil.print(pm.getTotalCount());
	
	//필수 변수 (검색창 상태)
	String isSearch      	 	= KJFUtil.print(pm.getIsSearch());
	
	int int_rnum= KJFUtil.str2int(totalCount)-(KJFUtil.str2int(nowPage) *KJFUtil.str2int(rowPerPage) - KJFUtil.str2int(rowPerPage));
	
	
	
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>

<script language="JavaScript">
// 신규 등록 폼 초기화
function fn_new(){
	var fm = document.fmParam;
	
    fm.cmd.value="UserMgrW";
    fm.submit();
}

// 보기
function fn_view(USER_CODE) {

 	var fm = document.fmParam;
 	
    fm.USER_CODE.value = USER_CODE;
    fm.cmd.value="UserMgrV";
    fm.submit();

}

// 수정
function fn_modify(USER_CODE) {

 	var fm = document.fmParam;
 	
    fm.USER_CODE.value = USER_CODE;
    fm.cmd.value="UserMgrW";
    fm.mode.value="M";
    fm.submit();

}

// 내용 저장
function fn_save(){

}

// 선택 삭제
function fn_delete(){
	var fm = document.fmParam;
	
	if(chkBoxCheck('chk')){ // 선택된 항목이 있는지 체크
	
		var isOK = confirm('선택한 항목을 삭제하시겠습니까?');
		
		if(isOK){
			//삭제 처리
			fm.mode.value="D";
			fm.cmd.value="UserMgrD";
    		fm.submit();
		}					
	}
}

// 검색 창 처리
function fn_search(){
	var fm = document.fmParam;
	
	if(fm.scFIELD.options.selectedIndex == 0){
		alert("검색조건을 선택해 주십시오");
		fm.scFIELD.focus();
		return false;
	}
	fm.cmd.value="UserMgr";
    fm.submit();
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
<form name=fmParam method="post" action="../user/UserAction.do" >
<input type=hidden name="isSearch"       value="<%=isSearch%>">
<!-- CUD 모드-->  
<INPUT type="hidden" name="cmd" value="UserMgr">
<INPUT type="hidden" name="mode">

<!-- 페이징 관련(필수)-->       
<input type=hidden name="nowPage"       value="<%=nowPage%>">
<INPUT type="hidden" name="USER_CODE">

<!-- 타이틀 시작--> 
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
        <jsp:param name="ButtonType" value="N,D"/>
</jsp:include>
<!-- 타이틀 끝 -->            
<br>

<!-- 검색부 디자인 부분 시작 -->
<table width="100%" border="0"  cellspacing="0" cellpadding="1">
	<tr>
	
		<td align="left">
        	<table border="0" cellspacing="0" cellpadding="0">
            	<tr>					  		
                	<td>
                   		<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_sc_order")%>'
										name="scORDER" 
										value="<%=KJFUtil.print(pm.getScORDER()) %>" 
										script="class='input_combobox' "/>&nbsp;</td>
					<td>
                   		<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_sc_condition")%>' 
										name="scCONDITION" 
										value="<%=KJFUtil.print(pm.getScCONDITION()) %>" 
										script="class='input_combobox' "/></td>
           		</tr>
			</table>
		</td>
		
		<td align="right">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>					
						<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_sc_field")%>'
										name="scFIELD" 
										value="<%=KJFUtil.print(pm.getScFIELD()) %>" 
										script="class='input_combobox' "/>&nbsp;</td>
					<td>
						<input type=text name=scTEXT value="<%=KJFUtil.print(pm.getScTEXT()) %>"
								class="input_textfield2"
								entSubmit='fmParam' onkeyup ="ee_on_keyup(this)">&nbsp;</td>
		        	<td>                        
	        		<td  align ="right"  height="28" ><a href='#' onclick='fn_search();'><img src="../images/bt_search.gif" border="0"></a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 검색부 디자인 부분 끝 -->
			
<!-- 리스트 테이블 시작-->			 
<table width="100%" border="0"  cellspacing="0" cellpadding="0" class="listTable">
	<tr>
		<td  class="listTable_header" width="5%" onClick="selectAll('chk')" style="cursor:hand">선택</td>
		<td  class="listTable_header_section" width="5%">번호</td>
		<td  class="listTable_header_section" >성명</td>
		<td  class="listTable_header_section" >ID</td>
		<td  class="listTable_header_section" >부서 </td>
		<td  class="listTable_header_section" width="100" >담당</td>
		<td  class="listTable_header_section" >그룹</td>
		<td  class="listTable_header_section" width="110" >최근 접속일</td>
		<td  class="listTable_header_section" width="50">보기</td>
		<td  class="listTable_header_section" width="50">수정</td>
	</tr>
	
 	<%
		for (int i=0;i< rEntity.getRowCnt();i++ ){               
			String USER_CODE 			= KJFUtil.print(rEntity.getValue(i,"USER_CODE"),"&nbsp;");
			String USER_ID 				= KJFUtil.print(rEntity.getValue(i,"USER_ID"),"&nbsp;");
			String USER_NAME 			= KJFUtil.print(rEntity.getValue(i,"USER_NAME"),"&nbsp;");
			String USER_NAT_NUM 		= KJFUtil.print(rEntity.getValue(i,"USER_NAT_NUM"),"");
			String POSITION				= KJFUtil.print(rEntity.getValue(i,"POSITION"),"&nbsp;");
			String POST					= KJFUtil.print(rEntity.getValue(i,"POST"),"&nbsp;");
			String CAPITAL			    = KJFUtil.print(rEntity.getValue(i,"CAPITAL"),"&nbsp;");
			String LAST_CONN 			= KJFUtil.print(rEntity.getValue(i,"LAST_CONN"),"&nbsp;");
			if(!KJFUtil.isEmpty(USER_NAT_NUM)){
				String[] str = USER_NAT_NUM.split("-");
				
				USER_NAT_NUM = str[0] + "-*******";			
			}
	%>
	<tr> 
		<td class="listTable_td" align="center">
			<input type="checkbox" style="border:0px;" name="chk" value="<%=USER_CODE%>"></td>
		<td class="listTable_td" align="center">
			<%=int_rnum--%>&nbsp;</td>
		<td class="listTable_td" align="center">
			<%=USER_NAME%>&nbsp;</td>
		<td class="listTable_td" align="center"> 
			<%=USER_ID%></td>
		<td class="listTable_td" align="center"> 
			&nbsp;<%=POSITION%></td>
		<td class="listTable_td" align="center"> 
			&nbsp;<%=POST%></td>
		<td class="listTable_td" align="center"> 
			&nbsp;<%=CAPITAL%></td>
		<td class="listTable_td" align="center"> 
			&nbsp;<%=LAST_CONN%></td>													
		<td class="listTable_td" align="center">
			<a href="javascript:fn_view( '<%=USER_CODE%>');"><img src="../images/modifyicon.gif" border="0" align="absmiddle"></a>									
		</td>
		<td class="listTable_td" align="center">
			<a href="javascript:fn_modify( '<%=USER_CODE%>');"><img src="../images/modifyicon.gif" border="0" align="absmiddle"></a>								
		</td>
	</tr>

	<%
		} 
 	
	if (rEntity.getRowCnt() == 0) {
	%>
	<tr>
		<td class="listTable_td" align="center" colspan="10">등록된 사용자가  없습니다.</td>
	</tr>
	<%  } %>   
</table>    	
<br>

<!-- 페이징 -->
<jsp:include page="../com/inc/paging_ad.jsp" flush="true">
	<jsp:param name="pagePerScreen" value="10"/>
	<jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
	<jsp:param name="totalCount" value="<%=totalCount%>"/>
	<jsp:param name="nowPage" value="<%=nowPage %>"/>
</jsp:include>
<!-- 페이징 -->

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>
 
</form>
</body>
</html>
