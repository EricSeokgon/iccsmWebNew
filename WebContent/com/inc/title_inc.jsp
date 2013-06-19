<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="kjf.util.*" %>

<%
	String newBtn 		= "N"; //신규-N
	String finderBtn 	= "N"; //조회-F
	String saveBtn 		= "N"; //저장-S
	String modyfyBtn 	= "N"; //수정-M
	String transBtn 	= "N"; //이동-T
	String deleteBtn 	= "N"; //삭제-D
	String deleteBbsBtn = "N"; //게시판 상세화면  삭제 - BD
	String printBtn 	= "N"; //출력-P
	String excelBtn 	= "N"; //엑셀-E
	String cancelBtn 	= "N"; //취소-C
	String replyBtn		= "N"; //답글-RPL
	String listBtn      = "N"; //리스트-GL

	String titleNavi    = KJFUtil.print( (String)request.getAttribute("titleNavi")  );
	String menuTitle    = KJFUtil.print( (String)request.getAttribute("menuTitle"), KJFUtil.print(request.getParameter("repTitle")));
	String ButtonType[] = KJFUtil.str2strs(KJFUtil.print( request.getParameter("ButtonType")),",");
	
	if (ButtonType != null) {
		for(int i = 0; i < ButtonType.length ; i++) {
			if(ButtonType[i].equalsIgnoreCase("N")) newBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("F")) finderBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("S")) saveBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("M")) modyfyBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("T")) transBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("D")) deleteBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("BD")) deleteBbsBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("P")) printBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("E")) excelBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("C")) cancelBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("RPL")) replyBtn="Y";
			if(ButtonType[i].equalsIgnoreCase("GL")) listBtn="Y";
		}
	}
	
	String rootPath = "..";
%>
<!--  공통 스크립트 -->
<script>
function searchTableTogle(){
	var fm = document.fmParam
	if(searchTable.style.display != 'block'){
		searchTable.style.display = 'block';
		fm.isSearch.value = "show";
	}else{
		searchTable.style.display = 'none';
		fm.isSearch.value = "hide";
	}
	return false;
}

function tableHide(){
	var fm = document.fmParam
	if(searchTable.style.display != 'block'){
		searchTable.style.display = 'block';
		fm.isSearch.value = "show";
	}else{
		searchTable.style.display = 'none';
		fm.isSearch.value = "hide";
	}
	return false;
}

//컨트롤 엔터키를 치면 호출된다. 저장 호출
function clickKey() {
	var key = event.keyCode;
	var ENTER_KEY = 13;
	var ctrlKey = event.ctrlKey;

	if(ctrlKey){
		if(key == ENTER_KEY) {
		 	fn_save();
		}
	}
}

//컨트롤 엔터키를 치면 호출된다. 저장 호출 안하려면 주석 처리
document.onkeydown = clickKey;
</script>
<!--  공통 스크립트 -->


<!--  페이지 로딩 표시 -->
<script  type="text/javascript">
function fn_closeMsgPop(){
	var msgPopID =document.getElementById('msgPopup');

   msgPopID.style.display="none";
}

function loading_ed(){
    var ta =document.getElementById('loading_layer');
    showSelect();
    ta.style.display='none';
}

function loading_st(str){
    var ct_left = (parseInt(window.screen.width)-450)/3;
    var ct_top = (parseInt(window.screen.height))/3;

    var msg = "데이터를 읽고 있습니다.";

    if(str!=null) msg = str;


	layer_str = "<div id='loading_layer' onclick='this.style.display=\"none\";' style='position:absolute; width:100%; height:100%; top:0; left:0; background-color:#FFFFFF; filter:Alpha(opacity=90); opacity:0.8; -moz-opacity:0.8; z-index:99998; ' align=center>";
	layer_str += "<table border=0 height=100%>";
	layer_str += "<tr>";
	layer_str += "<td align=center><p style= 'font-family:   dotum, Verdana, Arial, Helvetica, sans-serif;font-size: 13px;color: 7d7766; font-weight:bold; line-height:20px'>" + msg + "<br>잠시만 기다려 주십시오.</p><img name='loadingBar' src='<%=rootPath%>/images/prog_bar.gif'></td>";
	layer_str += "</tr> ";
	layer_str += "</table>";
	layer_str += "</div>";	

	document.write(layer_str);
}

function hideSelect() {
    var windows = window.frames.length;
    var selects = document.getElementsByTagName("SELECT");
    for (i=0;i < selects.length ;i++ )
    {
        selects[i].style.visibility = "hidden";
    }

    if (windows > 0) {
        for(i=0; i < windows; i++) {
            try {
                var selects = window.frames[i].document.getElementsByTagName("SELECT");
                for (j=0;j<selects.length ;j++ )
                {
                    selects[j].style.visibility = "hidden";
                }
            } catch (e) {}
        }
    }
}

function showSelect() {
    var windows = window.frames.length;
    var selects = document.getElementsByTagName("SELECT");
    for (i=0;i < selects.length ;i++ )
    {
        selects[i].style.visibility = "visible";
    }

    if (windows > 0) {
        for(i=0; i < windows; i++) {
            try {
                var selects = window.frames[i].document.getElementsByTagName("SELECT");
                for (j=0;j<selects.length ;j++ )
                {
                    selects[j].style.visibility = "visible";
                }
            } catch (e) {}
        }
    }
}
function setTime(){
	hideSelect();
	setTimeout( "loading_ed()", 100 );
}

loading_st();
window.onload = setTime;


</script>
<!--  페이지 로딩 표시 -->


<!--  테두리 테이블 시작 -->
<table width="750" border="0" cellpadding="0" cellspacing="0">
	
	<td>
<!--  테두리 테이블 끝 -->


<!------box start-------->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="6" height="6"><img src="<%=rootPath%>/images/box/box01_1.gif"></td>
		<td background="<%=rootPath%>/images/box/box01_2.gif"></td>
		<td width="6"><img src="<%=rootPath%>/images/box/box01_3.gif"></td>
	</tr>
	<tr>
		<td background="<%=rootPath%>/images/box/box01_8.gif"></td>
		<td height="20">
		
			<!------box table start-------->		
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20"></td>
							<td class="top_title"><%=menuTitle%></td>
							<td width="15"></td>
							<td></td>
						</tr>
					</table>
				</td>
				<td align="right">
	
					<% if(newBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_new.gif" alt="신규"  style="cursor:hand" onClick="fn_new()">
					<% }%>
					<% if(finderBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_search.gif" alt="조회"  style="cursor:hand" onClick="searchTableTogle()">
					<% }%>
					<% if(saveBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_save.gif" alt="저장"  style="cursor:hand" onClick="fn_save()">
					<% }%>
					<% if(modyfyBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_modify.gif" alt="수정"  style="cursor:hand" onClick="fn_modify()">
					<% }%>
					<% if(transBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_move.gif" alt="이동"  style="cursor:hand" onClick="fn_trans()">
					<% }%>
					<% if(replyBtn.equals("Y")) { %>
		            <img src="<%=rootPath%>/images/title_button/bt_reply.gif" alt="답글"  style="cursor:hand" onClick="fn_reply()">
		            <% }%>
					<% if(deleteBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_del.gif" alt="삭제"  style="cursor:hand" onClick="fn_delete()">
					<% }%>
					<% if(deleteBbsBtn.equals("Y")) { %>
		            <img src="<%=rootPath%>/images/title_button/bt_del.gif" alt="삭제"  style="cursor:hand" onClick="fn_del()">
		            <% }%>
					<% if(printBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_print.gif" alt="출력"   style="cursor:hand" onClick="fn_print()">
					<% }%>
					<% if(excelBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_excel.gif" alt="엑셀"  style="cursor:hand" onClick="fn_excel()">
					<% }%>
					<% if(cancelBtn.equals("Y")) { %>
					<img src="<%=rootPath%>/images/title_button/bt_cancel.gif" alt="취소"  style="cursor:hand" onClick="fn_cancel()">
					<% }%>
					<% if(listBtn.equals("Y")) { %>
		            <img src="<%=rootPath%>/images/title_button/bt_list.gif" alt="리스트"  style="cursor:hand" onClick="fn_list()">
		            <% }%>
	
					</td>
				</tr>
			</table>

		<!------box table end--------->
		</td>
		<td background="<%=rootPath%>/images/box/box01_4.gif"></td>
	</tr>

	<tr>
		<td width="6" height="6"><img src="<%=rootPath%>/images/box/box01_7.gif"></td>
		<td background="<%=rootPath%>/images/box/box01_6.gif"></td>
		<td width="6"><img src="<%=rootPath%>/images/box/box01_5.gif"></td>
	</tr>
</table>


<!------box end--------->

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="8"></td>
	</tr>
</table>
<!------높이 조절용 end --------->

<input type="hidden" name="titPgId"   value="<%= KJFUtil.print(request.getParameter("titPgId")) %>" >
<input type="hidden" name="titPgGrId" value="<%= KJFUtil.print(request.getParameter("titPgGrId")) %>" >
<!-- 타이틀  끝 -->



