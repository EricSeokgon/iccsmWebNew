<%@ page contentType="text/html;charset=ksc5601"%>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.blank.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%

	BlankParam pm = (BlankParam)request.getAttribute("pm");
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

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
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="../../com/css/style.css" rel="stylesheet" type="text/css">
<link href="../../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<link href="../../com/css/styleAdmin.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="JavaScript" src="../com/js/kjs.js" type="text/javascript"></script>

<script>
// 신규 등록 폼 초기화
function fn_new(){
	var fm = document.fmParam;
}

// 내용 저장
function fn_save(){
	var fm = document.fmParam;
	
	fm.cmd.value="Blank";
    fm.submit();
}

// 선택 삭제
function fn_delete(){
	if(chkBoxCheck('chk')){ // 선택된 항목이 있는지 체크
	
		var isOK = confirm('선택한 항목을 삭제하시겠습니까?');
		
		if(isOK){
			//삭제 처리
			fm.mode.value="D";
			fm.cmd.value="Blank";
    		fm.submit();
		}					
	}
}

// 검색 창 처리
function fn_search(){
	var fm = document.fmParam;
	
	fm.cmd.value="Blank";
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

//체크 박스 전체 선택 및 전체 해제
function selectAll(chkName) {

        var fm = document.fmParam;
        
		for(i = 0;i < fm.elements.length;i++){
			if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName){
	        	fm.elements[i].checked = !fm.elements[i].checked;
	        }
	    }       
	      
}

//선택된 항목이 있는지 검사.
function chkBoxCheck(chkName){
	var fm = document.fmParam;
	
	chkCount = 0;
	
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

.list_header_center2 {                                                                                                   
height: 27px; background-color: #F5F5F5; text-align: center; font-famlily:'Verdana', '돋움'; font-size:9pt;color:#000000;font-weight:bold;     
 BORDER-BOTTOM: #3d6191 2pt solid;  BORDER-RIGHT: #E5E5E5 0.5pt solid; BORDER-TOP: none;  BORDER-LEFT: none;
}

-->
</style>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"> 
<form name=fmParam method="post" action="../blank/BlankAction.do" >
<!-- CUD 모드-->  
<INPUT type="hidden" name="cmd" value="Blank">
<INPUT type="hidden" name="mode">
<!-- 검색창 상태 처리(필수)-->   
<INPUT type="hidden" name="isSearch" value="<%=isSearch%>">
<!-- 페이징 관련(필수)-->       
<input type=hidden name="nowPage"       value="<%=nowPage%>">


<!-- 타이틀 시작--> 
<jsp:include page="../com/title_inc2.jsp" flush="true">
	<jsp:param name="repTitle" value=""/>
</jsp:include>
<!-- 타이틀 끝 -->            


<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
	<tr> 
		<td width="20">
		</td>
		<td   width="820" align="center">

						
			<!-- 검색부 디자인 부분 시작 -->
			<table class='table_hide' width="100%" border="0" cellspacing="0" cellpadding="0" id="searchTable" >
              <tr>
                <td><table width="100%" border="0" align="center" cellpadding="3" cellspacing="0" bgcolor="#E5E5E5"  >
                  <tr>
                    <td width="77" align="right" bgcolor="#D8D8D8"><div align="center"><strong><span class="style2">Search</span> 
                    </strong></div></td>
                    <td width="732" align="right" bgcolor="#D8D8D8"><input type=image src="../images/bt_close.gif" width="41" height="17" onClick="tableHide();"></td>
                  </tr>
                  <tr>
                    <td colspan="2" align="center" bgcolor="#F5F5F5"><!-- 검색부 디자인 부분 시작 -->
                        <!---------------------------------- 검색영역 라인 --------------------------------------------->
                        <!-- 공간은 &nbsp; 로 처리한다. -->
                        <table width="100%"  border="0" cellspacing="0" cellpadding="3" >
                          <tr>
                            <td width="60"><div align="left"><strong>소속</strong></div></td>
                            <td align="left">
							<select style="width:100pt">
                              <option value=""></option>
                            </select></td>
                            <td width="60"><div align="left"><strong>이름</strong></div></td>
                            <td align="left"><input type=text value="" size="12"></td>
							<td width="60"><div align="left"><strong>ID</strong></div></td>
                            <td align="left"><input type=text value="" size="12"></td>
                          </tr>
                        </table>
                        <!---------------------------------- 검색영역 라인 --------------------------------------------->
                        
                        <!-- 검색부 디자인 부분 끝 -->
                    </td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td>
				   <!-- 검색버튼 -->
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" id="searchButton">
                          <tr>
                            <td  align ="right"  height="28" ><img src="../images/bt_search.gif" style="cursor:pointer" onclick='fn_search();'></td>
                          </tr>
                        </table>
						<br> 
                   <!-- 검색버튼 -->
			    </td>
              </tr>
            </table>
			<!-- 검색부 디자인 부분 끝 -->			



			<!-- 입력부 디자인 부분 시작 -->
			<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
				<tr> 
					<td width="5"><img src="../images/board_table_01.gif" width="5" height="4"></td> 
					<td background="../images/board_table_02.gif"><img src="../images/board_table_02.gif" width="3" height="4"></td> 
					<td width="5"><img src="../images/board_table_03.gif" width="5" height="4"></td> 
				</tr> 
				<tr> 
					<td width="5" background="../images/board_table_08.gif"><img src="../images/board_table_08.gif" width="5" height="2"></td> 
				  <td height="80" bgcolor="#F1F1F1">
			<!-- 입력부 디자인 부분 시작 -->


						<!---------------------------------- 입력영역 라인  &nbsp; 로 공간 조절---------------------------------------------> 
				    <table width="100%"  border="0" cellspacing="0" cellpadding="3"> 
						<tr>
							<td width="60"><div align="left"><strong>소속</strong></div></td>
							<td align="left">
							<select style="width:100pt">
							  <option value=""></option>
							</select></td>
							<td width="60"><div align="left"><strong>이름</strong></div></td>
							<td align="left"><input type=text value="" size="12"></td>
							<td width="60"><div align="left"><strong>ID</strong></div></td>
							<td align="left"><input type=text value="" size="12"></td>
							<td width="60"><div align="left"><strong>비밀번호</strong></div></td>
							<td align="left"><input type=text value="" size="12"></td>
						</tr>
					</table>
					  <!---------------------------------- 입력영역 라인 ---------------------------------------------> 



			<!-- 입력부 디자인 부분 끝 -->
				  </td> 
					<td width="5" background="../images/board_table_04.gif"><img src="../images/board_table_04.gif" width="5" height="2"></td> 
				</tr> 
				<tr> 
					<td width="5"><img src="../images/board_table_07.gif" width="5" height="4"></td> 
					<td background="../images/board_table_06.gif"><img src="../images/board_table_06.gif" width="3" height="4"></td> 
					<td width="5"><img src="../images/board_table_05.gif" width="5" height="4"></td> 
				</tr> 
			</table>
			<!-- 입력부 디자인 부분 끝 -->




			
            <!-- page state 테이블 시작-->
            <br>
            <table width="100%" border="0">
                <tr>
                                    
                    <td  align="right">                                      
                       <jsp:include page="../com/inc/pageState.jsp" flush="true">
                        <jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
                        <jsp:param name="totalCount" value="<%=totalCount%>"/>
                        <jsp:param name="nowPage" value="<%=nowPage %>"/>
                      </jsp:include>
                                                              
                    </td>
                </tr>
            </table>
            <!-- page state 테이블 끝-->

             <!-- 리스트 테이블 시작-->
            <table width="100%" border="1"  cellspacing="0" cellpadding="0" class="table_line">
                <tr>
					<td  class="list_header_center">소속</td>
                    <td  class="list_header_center" width="160">이름</td>
					<td  class="list_header_center" width="160">ID</td>
					<td  class="list_header_center_end" width="160">비밀번호</td>
                </tr>
				<tr>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>		  
				</tr>
				<tr>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>		  
				</tr>
				<tr>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>		  
				</tr>
				<tr>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>		  
				</tr>
				<tr>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>
				  <td class="list_td"><div align="center">&nbsp;</div></td>		  
				</tr>


<%

    if (rEntity!=null){
        for (int i=0;i< rEntity.getRowCnt();i++ ){               
%>


<%
        }//end for (int i=0;i< rEntity.getRowCnt();i++ )
    }
    if (rEntity==null || rEntity.getRowCnt()==0){

%>
                <!--tr>
                    <td class="list_td" align="center" colspan="9">등록된 자료가 없습니다.</td>
                </tr-->
<%  } %>   
            </table>		        		        
            <!-- 리스트  테이블 끝-->
            
            <!-- 페이징 --> 
            <jsp:include page="../com/inc/paging.jsp" flush="true">
              <jsp:param name="pagePerScreen" value="10"/>
              <jsp:param name="rowPerPage" value="<%=rowPerPage%>"/>
              <jsp:param name="totalCount" value="<%=totalCount%>"/>
              <jsp:param name="nowPage" value="<%=nowPage %>"/>
            </jsp:include>            
            <br>
            <!-- 페이징-->



	  </td> 
	</tr> 
</table>

<!-- copyright End -->
<jsp:include page="../../com/inc/foot_inc.jsp" flush="true"/>
 
</form>
</body>
</html>
