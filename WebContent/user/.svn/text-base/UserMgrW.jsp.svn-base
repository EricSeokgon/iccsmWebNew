<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.user.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%

	UserParam pm = (UserParam)request.getAttribute("pm");
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");
	String mode = KJFUtil.print(request.getParameter("mode"));
	
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
		USER_CODE 			= KJFUtil.print(rEntity.getValue(0,"USER_CODE"));
		USER_ID 			= KJFUtil.print(rEntity.getValue(0,"USER_ID"));
		USER_PASSWD 		= KJFUtil.print(rEntity.getValue(0,"USER_PASSWD"));
		USER_NAME 			= KJFUtil.print(rEntity.getValue(0,"USER_NAME"));
		USER_TEL 			= KJFUtil.print(rEntity.getValue(0,"USER_TEL"));
		USER_EMAIL 			= KJFUtil.print(rEntity.getValue(0,"USER_EMAIL"));
		USER_MOBILE 		= KJFUtil.print(rEntity.getValue(0,"USER_MOBILE"));
		USER_NAT_NUM 		= KJFUtil.print(rEntity.getValue(0,"USER_NAT_NUM"));
		ORGANIZATION		= KJFUtil.print(rEntity.getValue(0,"ORGANIZATION"));
		POSITION			= KJFUtil.print(rEntity.getValue(0,"POSITION"));
		POST				= KJFUtil.print(rEntity.getValue(0,"POST"));
		STAFF_LEVEL			= KJFUtil.print(rEntity.getValue(0,"STAFF_LEVEL"));
		STAFF_SYSTEM		= KJFUtil.print(rEntity.getValue(0,"STAFF_SYSTEM"));
		CAPITAL			= KJFUtil.print(rEntity.getValue(0,"CAPITAL"));
		//USER_AUTH			= KJFUtil.print(rEntity.getValue(0,"USER_AUTH"));
		REG_DATE 			= KJFUtil.print(rEntity.getValue(0,"REG_DATE"));
		MOD_DATE 			= KJFUtil.print(rEntity.getValue(0,"MOD_DATE"));
		LAST_CONN 			= KJFUtil.print(rEntity.getValue(0,"LAST_CONN"));
		USE_YN 				= KJFUtil.print(rEntity.getValue(0,"USE_YN"));
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>

<script>

function beforeKjs(){
	var fm = document.fmParam;

	var isConfirm  	= fm.isConfirm;
	
	var email  		= fm.USER_EMAIL;
	var tel  		= fm.USER_TEL;
	var hp  		= fm.USER_MOBILE;
	
	
	var juminNum1  	= fm.USER_NAT_NUM1.value;
	var juminNum2  	= fm.USER_NAT_NUM2.value;
	var juminNum	= juminNum1 + "-" + juminNum2;
	
//	var email1		= fm.USER_EMAIL1.value;
//	var email2		= fm.USER_EMAIL2.value;
//	var email		= email1+"@"+email2;
	
	var passwd		= fm.USER_PASSWD.value;
	var passwd1		= fm.USER_PASSWD1.value;
	
	if(fm.mode.value != "M"){
		if(fm.USER_ID.value != fm.saveUserID.value){
			fm.isIDCheck.value = "false";
			msg("아이디 중복 확인을 해주십시오.");
			return false;
		}
	
		if(!fm.isIDCheck.value || (fm.isIDCheck.value == "false")){
			msg("아이디 중복 확인을 해주십시오.");
			return false;
		}
	}

	if(!isEngNumCheck(fm.USER_PASSWD)){
		msg("비밀번호는 영문, 숫자로 입력하십시오");
		USER_PASSWD.select();
		return false;
	}
	
	if(passwd != passwd1){
		msg("비밀번호가 틀립니다.");
		fm.USER_PASSWD.value = "";
		fm.USER_PASSWD1.value = "";
		return false;
	}

	
	if(tel.value.length>0){
		if(!isValidPhone(fm.USER_TEL))
			return errMsg("전화번호",fm.USER_TEL);
	}else{
		fm.USER_TEL.value = "";
	}
	
	if(hp.value.length>0 ){
		if(!isValidPhone(fm.USER_MOBILE))
			return errMsg("핸드폰",fm.USER_MOBILE);			
	}else{
		fm.USER_MOBILE.value = "";
	}

	if((getByteLen(email)) > 127){
		msg("이메일은 128자 이내로 입력하십시오");
		fm.USER_EMAIL.select();
		return false;
	}

	if(email.value.length>0 ){
		if(!isValidEmail(fm.USER_EMAIL))
			return errMsg("이메일",fm.USER_EMAIL);			
	}else{
		fm.USER_EMAIL.value = "";
	}
	
	fm.USER_NAT_NUM.value = juminNum;

	return true;
}
//신규 등록
function fn_new(){
	var fm = document.fmParam;
	
    fm.cmd.value="UserMgrW";
    fm.mode.value="C";
    fm.submit();
}

// 내용 저장
function fn_save(){
	var fm = document.fmParam;
	
	if(fm.mode.value == "M")
		fm.cmd.value = "UserMgrU";
		
	kjsSubmit('fmParam');
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

function fn_IDCheck(){
	var fm = document.fmParam;
	var userID = fm.USER_ID.value;
	if(!isEngNumCheck(fm.USER_ID)){
		msg("아이디는 영문, 숫자로 입력하십시오");
		fm.USER_ID.select();
		return false;
	}	
	if(!userID) errMsg("아이디",fm.USER_ID);
	else centerwin('../user/UserAction.do?cmd=UserIDCheck&USER_ID='+userID,'newWin','400','225');
}

//주민번호 입력시 자릿수 확인하여 자동으로 다음 필드로 넘김.
function jumin_check(){
	var fm = document.fmParam;
    var str = fm.USER_NAT_NUM1.value.length;
    if(str == 6)
    	fm.USER_NAT_NUM2.focus();
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
<INPUT type="hidden" name="cmd" value="UserMgrC">
<INPUT type="hidden" name="mode" value="<%=mode%>">
<!-- 검색창 상태 처리(필수)-->   
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">
<!-- 페이징 관련(필수)-->       
<input type=hidden name="nowPage"       value="<%=nowPage%>">

<input type=hidden name="saveUserID" value="">
<input type=hidden name="isIDCheck" value="">
<input type=hidden name="USER_NAT_NUM">
<input type=hidden name="USER_CODE" value="<%=USER_CODE%>">
<input type=hidden name="REG_DATE" value="<%=REG_DATE%>">

<!-- 타이틀 시작--> 
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
        <jsp:param name="ButtonType" value="S,C"/>
</jsp:include>
<!-- 타이틀 끝 -->            


<table width="100%" border="0" cellspacing="0" cellpadding="5" class="inputTable">
	<tr>
		<td class="inputTable_header_td" width="20%">이름</td>
		<td class="inputTable_td" colspan="3">
			<input type=text class="input_01"  name="USER_NAME" value='<%=USER_NAME%>' maxlength="64"  required="이름을 입력해 주십시오">
		</td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">사용자  ID</td>
		<td class="inputTable_td" colspan="3">
			<input type=text class="input_01" name="USER_ID" value="<%=USER_ID%>" maxlength="16" minlength="4" required="사용자 ID을(를) 입력해 주십시오" >
            <a href="javascript:"><img src="images/btn_idsearch.gif" border="0" align="absmiddle" onClick="fn_IDCheck()"></a> </td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">패스워드 </td>
		<td class="inputTable_td">
			<INPUT NAME="USER_PASSWD" class="input_01" type="PASSWORD" maxlength="16" minlength="4" value="<%=USER_PASSWD%>" required="패스워드을(를) 입력해 주십시오">
		</td>
		<td class="inputTable_header_td" width="20%">패스워드 확인</td>
		<td class="inputTable_td">
			<INPUT NAME="USER_PASSWD1" class="input_01" type="PASSWORD" maxlength="16" minlength="4" value="<%=USER_PASSWD%>" required="패스워드 확인을(를) 입력해 주십시오">
		</td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">이 메 일</td>
		<td class="inputTable_td" colspan="3">
			<INPUT NAME="USER_EMAIL" size="30" type="text" maxlength="30" value="<%=USER_EMAIL%>">
		</td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">전 화 번 호</td>
		<td class="inputTable_td" colspan="3">
			<INPUT NAME="USER_TEL" class="input_01" type="text" maxlength="16" value="<%=USER_TEL%>">
		</td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">핸 드 폰</td>
		<td class="inputTable_td" colspan="3">
			<INPUT NAME="USER_MOBILE" class="input_01" type="text" maxlength="16" value="<%=USER_MOBILE%>">
		</td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">주민등록 번호</td>
		<td class="inputTable_td" colspan="3">
			<INPUT NAME="USER_NAT_NUM1" mask="999999" class="input_01" type="text" maxlength="6" value="<%=USER_NAT_NUM1%>"  onKeyUp="jumin_check()">
      		-
        	<INPUT NAME="USER_NAT_NUM2" mask="9999999" class="input_01"type="password" maxlength="7" value="<%=USER_NAT_NUM2%>" >
		</td>
	</tr>	
	
	<tr>
       	<td class="inputTable_header_td" width="20%">소속</td>
       	<td class="inputTable_td" colspan="3">
			<INPUT NAME="ORGANIZATION" size="30" type="text" maxlength="30" id="ORGANIZATION" value="<%=ORGANIZATION%>">
       	</td>
     </tr>
     
	<tr>
       	<td class="inputTable_header_td" width="20%">담 당</td>
       	<td class="inputTable_td" colspan="3">
			<INPUT NAME="POST" size="30" type="text" maxlength="30" id="POST" value="<%=POST%>">
       	</td>
     </tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">사 용 자 그 룹</td>
		<td class="inputTable_td" colspan="3">
			<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_sc_group_code")%>'
											 name="CAPITAL"
											 value="<%=CAPITAL %>"
											 script="class='input_combobox'"/>
		</td>
	</tr>
	
	<tr>
		<td class="inputTable_header_td" width="20%">사용여부</td>
		<td class="inputTable_td" colspan="3">
			<input name="USE_YN" type="radio" style="border:0" value="Y" checked>사용
			<input type="radio" name="USE_YN" style="border:0" value="N">미사용
		</td>
	</tr>	
</table>
<br>

<!-- copyright End -->
<jsp:include page="../com/inc/foot_inc.jsp" flush="true"/>

</form>
</body>
</html>
