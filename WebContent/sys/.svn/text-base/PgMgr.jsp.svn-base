<%--
*************************************************************************************************
* 파  일  명 : PgMgr.jsp
* 설      명 : 프로그램 관리화면
*
* 이력사항 :
* 2006/09/07  양석환  최초작성 - 프로그램 화면구조 변경에 따라 새로 작성.
* 2007/04/18  오두식  수정 - 프로그램 화면구조 변경에 따라 새로 작성.
*************************************************************************************************
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.uent.*" %>
<%@ page import="sp.sys.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	//초기 변수 들 선언
	SysParam pm=(SysParam)request.getAttribute("pm");
	Vector v_menuEntList = (Vector)request.getAttribute("v_menuEntList");

	String PG_GROUP_ID = KJFUtil.print(request.getParameter("PG_GROUP_ID"));

	//필수 변수 (검색창 상태)
	String isSearch   = KJFUtil.print(pm.getIsSearch());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- 공퉁 부분 -->
<link href="../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>
<!-- 공퉁 부분 -->

<script language="javascript" type="text/javascript" src="../com/js/tree.js"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
<%
 	boolean isTree = false;

	if (v_menuEntList!=null  ){
		int cnt = v_menuEntList.size();

		out.println("foldersTree = gFld('프로그램 그룹 선택',  'javascript:fn_select_group(\"\")');");
		for (int i = cnt-2 ; i+1 >  0  ; i--) {
			MenuEnt menuEnt = (MenuEnt)v_menuEntList.get(i);

			isTree = true;

			if("0".equals(menuEnt.getP_PG_GROUP_ID())) {
				out.println("sub_" + menuEnt.getPG_GROUP_ID() + "=insFld(foldersTree, gFld('" + menuEnt.getGROUP_NAME() + "','javascript:fn_select_group(\""+menuEnt.getPG_GROUP_ID()+"\")'));");
			}else{

				if(PG_GROUP_ID.equals(menuEnt.getP_PG_GROUP_ID())){
					out.println("sub_" + menuEnt.getPG_GROUP_ID() + "=insFld(foldersTree, gFld('" + menuEnt.getGROUP_NAME() + "','javascript:fn_select_group(\""+menuEnt.getPG_GROUP_ID()+"\")'));");
				}else{
					out.println("sub_" + menuEnt.getPG_GROUP_ID() + "=insFld(sub_" + menuEnt.getP_PG_GROUP_ID() + ", gFld('" + menuEnt.getGROUP_NAME() + "','javascript:fn_select_group(\""+menuEnt.getPG_GROUP_ID()+"\")'));");
				}
			}
		}
	}
%>

function fn_select_group(group_id){
	var fm = document.fmParam;

    fm.scP_CODE.value = group_id;
    fm.action = "SysAction.do?cmd=PgMgrL";
    fm.target = "ListFrame";
    fm.submit();
}

// 신규 등록 폼 초기화
function fn_new() {
	var fm = document.fmParam;
    //fm.PG_GROUP_ID[0].selected = true;
    fm.PG_ID.value     = "";
    fm.PG_NAME.value   = "";
    fm.PG_URL.value    = "";
    fm.ORDER_SEQ.value = "";
    fm.USE_YN[0].selected = true;
    fm.mode.value="C";
    fm.PG_NAME.focus();
}

function fn_save(){
	isSubmit = false;
	var fm = document.fmParam;

	fm.action="SysAction.do";
	fm.cmd.value = "PgMgrCUD";
	fm.target = "ListFrame";
	kjsSubmit('fmParam');
}

// 선택 삭제
function fn_delete() {
	var fm = parent.SubMain.ListFrame.fmParam;

	if(chkBoxCheck('chk')){ // 선택된 항목이 있는지 체크
		var isOK = confirm('선택한 항목을 삭제하시겠습니까?');

		if(isOK){
			//삭제 처리
			fm.cmd.value  = "PgMgrCUD";
			fm.mode.value = "D";
			fm.submit();
		}
    }
}

function chkBoxCheck(chkName){
	var fm = parent.SubMain.ListFrame.fmParam;

	chkCount = 0;
	chkBoxNums = 0;

	for(i = 0;i < fm.elements.length;i++){
		if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName){
        	chkBoxNums ++;
        }
	}

	if(chkBoxNums == 0){
		alert("삭제 할 항목이 없습니다.");
		return false;
	}

	for(i = 0;i < fm.elements.length;i++){
		if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName && fm.elements[i].checked == true){
	       	chkCount ++;
	    }
	}

	if(chkCount == 0){
		alert("삭제 할 항목을 선택해 주십시오");
		return false;
	}
	return true;
}



// 검색 창 처리
function fn_search(){
	var fm = document.fmParam;

	fm.isSearch.value = "show";
	fm.cmd.value="PgMgr";
    fm.submit();
}

// 츨력 처리
function fn_print(){
	var fm = document.fmParam;

	fm.cmd.value="Blank";
    fm.submit();
}

// 엑셀 츨력 처리
function fn_excel(){
	var fm = document.fmParam;

	fm.cmd.value="Blank";
    fm.submit();
}

//-->
</script>

<script>
function frameResize(fr)
{

	try {
		var h = fr.contentWindow.document.body.scrollHeight;
		var w = fr.contentWindow.document.body.scrollWidth;

		fr.style.height = h;
		fr.scrolling = "no";


	} catch (e) {
		fr.style.height= 300;
		fr.scrolling = "auto";
	}
}
</script>
</head>

<body>


<div id='log'></div>


<form name=fmParam method="post" action="SysAction.do"  >
<!-- CUD 모드-->
<input type="hidden" name="cmd"  value="PgMgr">
<input type="hidden" name="mode" value="C">
<!-- 검색창 상태 처리(필수)-->
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">


<!-- 타이틀 시작-->
<jsp:include page="../com/inc/title_inc.jsp" flush="true">
<jsp:param name="repTitle" value=""/>
<jsp:param name="ButtonType" value="N,S,D"/>
</jsp:include>
<!-- 타이틀 끝 -->


<!-- 입력부 디자인 부분 START -->
<table width="100%" height="85%" border="0" cellspacing="0" cellpadding="0">
    
    <tr>
		<td width="170" height="100%" align="center">
			<table width="168" height="100%" valign="top" border="0" cellspacing="0" cellpadding="0">
				<tr	>
					<td valign="top">
						<%if (isTree){%>
						<script language="JavaScript">initializeDocument(foldersTree);</script>
						<%}%>
                    </td>
				</tr>
			</table>
        </td>
        
		<td width="660" height="100%" valign="top">
			<table class="table_hide" width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="150" valign="top" id="userArea">
						<!-- 검색 테이블  START -->
						<jsp:include page="../com/inc/bgBox_top_inc.jsp" flush="true"/>
								<table width="100%" border="0" cellspacing="0" cellpadding="0" >
									<tr>
										<td width="90"  class="searchTable_td">프로그램그룹&nbsp;&nbsp;&nbsp;</td>
										<td width="250" class="searchTable_td" colspan="3">
											<KTags:KJFSelect	item='<%=(Vector)request.getAttribute("v_sc_pg_group_id")%>'
																name="scP_CODE"
																value="<%=KJFUtil.print(pm.getScP_CODE()) %>"
																script="class='input_combobox' onChange='fn_select_group(this.options.value)'"/>											</td>
										<td>&nbsp;</td>
										<td width="80"  class="searchTable_td">프로그램명&nbsp;&nbsp;&nbsp;</td>
										<td width="250" class="searchTable_td" colspan="3">
											<input type="text" name="scCODE_NAME" value="<%=KJFUtil.print(pm.getScCODE_NAME()) %>" class="input_textfield">											</td>
										<td align="right" ><img src="../images/bt_search.gif" border="0" align="absmiddle"></td>
									</tr>
								</table>
						<jsp:include page="../com/inc/bgBox_bottom_inc.jsp" flush="true"/>
						<!-- 검색 테이블  END -->


						<!-- 입력부 디자인 부분 시작 -->
						<jsp:include page="../com/inc/bgBox_top_inc.jsp" flush="true"/>

							<!---------------------------------- 입력영역 라인  --------------------------------------------->
							<!-- 공간은 &nbsp; 로 처리한다. -->
							<table width="100%"  border="0" cellspacing="0" cellpadding="3" class="inputTable">
								
								<tr>
									<td class="inputTable_header_td" width="20%">프로그램그룹</td>
									<td class="inputTable_td">
										<table border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<input type="hidden" name="SEQ"   value="">
													<input type="hidden" name="PG_ID" value="">
													<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_pg_group_id")%>'
																		name="PG_GROUP_ID"
																		value="<%=KJFUtil.print(pm.getScP_CODE()) %>"
																		script="class='input_combobox'"/>			
												</td>
											</tr>
										</table>								
									</td>
								</tr>
								
								<tr>
									<td class="inputTable_header_td">프로그램명</td>
									<td class="inputTable_td">
										<table width="200" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td><input type="text" name=PG_NAME   value="" class="input_textfield" maxlength="50" required></td>
											</tr>
										</table>
									</td>
								</tr>
								
								<tr>
									<td class="inputTable_header_td" >경로</td>
									<td class="inputTable_td">
										<table width="90%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td><input name=PG_URL type="text" class="input_textfield" value="" size="70" maxlength="100" required></td>
											</tr>
										</table>
									</td>
								</tr>
								
								<tr>
									<td class="inputTable_header_td" >이미지ID</td>
									<td class="inputTable_td">
										<table width="50" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td><input name=PG_IMG type="text" class="input_textfield" value="" size="30" number ></td>
											</tr>
										</table>
                                    </td>
								</tr>
								
								<tr>
									<td class="inputTable_header_td" >정렬</td>
									<td class="inputTable_td">
										<table width="50" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td><input name=ORDER_SEQ type="text" class="input_textfield" onKeyUp="ee_on_keyup(this)" value="" size="4" number required></td>
											</tr>
										</table>
                                    </td>
								</tr>
								
								
								<tr>
                                  	<td class="inputTable_header_td" >사용</td>
                                  	<td class="inputTable_td">
                                  		<table border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<SELECT NAME="USE_YN" class="input_combobox">
														<option value="Y">Y</option>
														<option value="N">N</option>
													</SELECT>
												</td>
											</tr>
										</table>										
									</td>
								</tr>
								
							</table>
							<!---------------------------------- 입력영역 라인 --------------------------------------------->
						<jsp:include page="../com/inc/bgBox_bottom_inc.jsp" flush="true"/>
						<!-- 입력부 디자인 부분 끝 -->					
					</td>
				</tr>
				
				<tr>
					<td>
						<!-- 리스트 프레임 시작 -->
						<iframe width="100%" height="100%" name="ListFrame" src="SysAction.do?cmd=PgMgrL" marginheight="0" marginwidth="0" frameborder="0" valign="top" scrolling="no" onload="frameResize(this)"></iframe>
						<!-- 리스트 프레임 끝 -->					
					</td>
				</tr>
				
			</table>		
		</td>
	</tr>
</table>

</form>
</body>

</html>
