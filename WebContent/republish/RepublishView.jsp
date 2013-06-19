<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));
	String p_type = (String)request.getAttribute("p_type");
	String p_gubun = (String)request.getAttribute("p_gubun");
	p_gubun = KJFUtil.print(p_gubun,"afresh");
	
	String scSD_CD = KJFUtil.print(request.getParameter("scSD_CD"),"bsbs");
	
	String p_num[] = (String[])request.getAttribute("p_num"); //등록수첩 각 항목별 데이터 유무를 체크 배열
	
	
	String etc_engineer_display = KJFUtil.print((String)request.getAttribute("etc_engineer_display"),"N"); //기술자 48명 이상일 경우 활성
	

%>
<html>
<head>
<link rel="stylesheet" href="../css/style_new.css" type="text/css">
<title>정보통신 행정시스템 - 등록수첩 인쇄</title>
<meta http-equiv="imagetoolbar" content="no" />
<meta name="author" content="정보통신 행정시스템" />


<script language="javascript">
	function fn_change(mode, page){
		var fm = document.searchfrm;
		var url = "";

		if (fm.chkNEW.checked == true){
			url = "../republish/RepublishAction.do?cmd=RepublishDetail&mode="+mode+"&page="+page+"&coi_wrt_num=<%=p_coi_wrt_num %>&scSD_CD=<%=scSD_CD%>&type=_new";
		} else {
			url = "../republish/RepublishAction.do?cmd=RepublishDetail&mode="+mode+"&page="+page+"&coi_wrt_num=<%=p_coi_wrt_num %>&scSD_CD=<%=scSD_CD%>";
		}
		
		fm.tmp_mode.value = mode;
		fm.tmp_page.value = page;
		
		document.getElementById("DetailView").src=url;
	}

	function fn_print() {
		var fm = document.searchfrm;
		var mode = fm.tmp_mode.value;
		var page = fm.tmp_page.value;
		var url = "";
		
		if (fm.chkNEW.checked == true){
			//if(confirm("새 양식으로 출력합니다.")) 
			{
				url = "../republish/RepublishAction.do?cmd=RepublishDetail&mode="+mode+"&page="+page+"&coi_wrt_num=<%=p_coi_wrt_num %>&scSD_CD=<%=scSD_CD%>&gubun=print&type=_new";
				document.getElementById("printframe").src=url;
			}
		}else {
			//if(confirm("구 양식으로 출력합니다.")) 
			{
				url = "../republish/RepublishAction.do?cmd=RepublishDetail&mode="+mode+"&page="+page+"&coi_wrt_num=<%=p_coi_wrt_num %>&scSD_CD=<%=scSD_CD%>&gubun=print";
				document.getElementById("printframe").src=url;
			}

		}
	}

	function fn_search() {

		var fm = document.searchfrm;
		fm.cmd.value="RepublishView";
		
		if (fm.chkNEW.checked == true){
			fm.type.value="_new";
		} else {
			fm.type.value="";
		}
		
		fm.submit();
	}
	
	
</script>
</head>

<body>



<form name="searchfrm" action="../republish/RepublishAction.do?cmd=RepublishView" method="post">
<input type="hidden" name="cmd" />
<input type="hidden" name="coi_wrt_num" value="<%=p_coi_wrt_num %>" />
<input type="hidden" name="type" value="<%=p_type %>" />

<table width="678" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="30" colspan="2">
			<table width="678"  border="0" cellspacing="0" cellpadding="0">
				<tr><td height="14"></td></tr>
				<tr>
					<td style="padding-bottom:10;">
						<table width="100%"  border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="60%"><h4>등록수첩인쇄</h4></td>
								<td><input type="checkbox" name="chkNEW" <%="_new".equals(p_type)?"checked":"" %>><b><font color=blue>새 양식으로 출력</font></td>
								<td><KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scSD_CD")%>'
												 name='scSD_CD'
												 value='<%=scSD_CD %>'
												 script=" onChange='fn_search()' "/></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			<table width="98%" border="0" cellspacing="0" cellpadding="0">
				<tr class="bg03">
					<td width="11" height="30">&nbsp;</td>
					<td width="56">출력구분:</td>
					<td width="127">
						<select name="p_gubun"  style="width:120;" onChange='fn_search()'>
							<option value="afresh" <%="afresh".equals(p_gubun) ? "selected":"" %>>신규</option>
							<option value="reissue" <%="reissue".equals(p_gubun) ? "selected":"" %>>재발급</option>
						</select>
					</td>
					<td width="465"><img src="../images/icon_print.gif" alt="출력"  border="0" align="absmiddle" onclick="javaScript:fn_print();" style="cursor:hand;"></td>
				</tr>
				<tr>
					<td height="14" colspan="4"></td>
				</tr>
				<tr>
					<td colspan="4">
						<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
							<tr>
								<td width="10%" class="kica_border01">
									<span id='schange'>
										<input type=radio name=mode onClick="fn_change('basics','2')" checked="on" >공사업자 기본사항(2쪽)
									</span>
								</td>
                              	<td width="10%" class="kica_border01"><input type=radio name=mode onClick="fn_change('valuation','3')"  <%=p_num[3]%>> 시공능력평가사항(3쪽) </td>
                              	<td width="10%" class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','4')"   <%=p_num[4]%>> 정보통신기술자사항(4쪽)</td>
							</tr>
                            <tr>
              					<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','5')"  <%=p_num[5]%>> 정보통신기술자사항(5쪽)</td>
                              	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','6')"  <%=p_num[6]%>> 정보통신기술자사항(6쪽) </td>
                              	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','7')"  <%=p_num[7]%>> 정보통신기술자사항(7쪽) </td>
                  			</tr>
                            <tr>
                 				<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','8')"  <%=p_num[8]%>> 정보통신기술자사항(8쪽) </td>
                             	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','9')"  <%=p_num[9]%>> 정보통신기술자사항(9쪽) </td>
                              	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','10')" <%=p_num[10]%>> 정보통신기술자사항(10쪽) </td>
                   			</tr>
                            <tr>
                    			<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','11')"  <%=p_num[11]%>> 정보통신기술자사항(11쪽) </td>
                              	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('change','12')" <%=p_num[12]%>> 변경사항(12쪽~13쪽) </td>
                              	<td class="kica_border01">&nbsp;</td>
                   			</tr>
                   			<tr>
                    			<td class="kica_border01"><input type=radio name=mode onClick="fn_change('adm_dis','14')"  <%=p_num[14]%>> 행정처분사항(14쪽)</td>
                              	<td class="kica_border01">&nbsp;</td>
                              	<td class="kica_border01">&nbsp;</td>
                   			</tr>
    					</table>
    				</td>
          		</tr>
      		</table>
      	</td>
	</tr>
	<tr>
		<td height="30"></td>
	</tr>
	
	
	<%if("YES".equals(etc_engineer_display)) { %>
	
	<tr>
		<td align="center">
			<table width="98%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td colspan="4">
						<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="kica_border">
						<%if("".equals(p_num[15])){ %>
                            <tr>
              					<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','15')"  <%=p_num[15]%>> 정보통신기술자 추가 사항(4쪽)</td>
                              	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','16')"  <%=p_num[16]%>> 정보통신기술자 추가 사항(5쪽) </td>
                              	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','17')"  <%=p_num[17]%>> 정보통신기술자 추가 사항(6쪽) </td>
                  			</tr>
                  		<%} %>
                  		<%if("".equals(p_num[18])){ %>
                            <tr>
                 				<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','18')"  <%=p_num[18]%>> 정보통신기술자 추가 사항(7쪽) </td>
                             	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','19')"  <%=p_num[19]%>> 정보통신기술자 추가 사항(8쪽) </td>
                              	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','20')" <%=p_num[20]%>> 정보통신기술자 추가 사항(9쪽) </td>
                   			</tr>
                   		<%} %>
                   		<%if("".equals(p_num[21])){ %>
                            <tr>
                    			<td class="kica_border01"><input type=radio name=mode onClick="fn_change('engineer','21')"  <%=p_num[21]%>> 정보통신기술자 추가 사항(10쪽) </td>
                              	<td class="kica_border01"><input type=radio name=mode onClick="fn_change('change','22')" <%=p_num[22]%>> 정보통신기술자 추가 사항(11쪽) </td>
                              	<td class="kica_border01">&nbsp;</td>
                   			</tr>
                   		<%} %>
    					</table>
    				</td>
          		</tr>
      		</table>
      	</td>
	</tr>
	
	<%} %>
	
	<tr>
		<td height="30"></td>
	</tr>
	
	
	<tr>
		<td align="center">
			<iframe name="DetailView" src="../republish/RepublishAction.do?cmd=RepublishDetail&mode=basics&coi_wrt_num=<%=p_coi_wrt_num %>&type=<%=p_type %>&scSD_CD=<%=scSD_CD%>" WIDTH="90%" height="450" frameborder="0" scrolling=no  marginwidth=0 marginheight=0></iframe>
			<iframe name="printframe" WIDTH="0" height="0" marginwidth=0 marginheight=0 frameborder="no"></iframe>
		</td>
	</tr>	
	<tr>
		<td height="100" colspan="2"></td>
	</tr>
</table>

<input type="hidden" name="tmp_mode" value="basics" />
<input type="hidden" name="tmp_page" value="2" />

</form>
</body>
</html>


