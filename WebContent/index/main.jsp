<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="sp.index.IndexParam" %>
<%@ page import="kjf.util.*" %>
<%@ page import="java.net.URLEncoder" %>

<%

	ReportEntity ListEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("ListEntity") );	// 공무원센터 커뮤니티
	ReportEntity rEtcEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("ListEtcEntity") );	// 공무원센터 커뮤니티
	String go_url = "";


	ReportEntity completionEntity = (ReportEntity)request.getAttribute("completionEntity");  //공사업등록 업무 처리 완료 현황
	ReportEntity ongoingEntity = (ReportEntity)request.getAttribute("ongoingEntity");  //공사업등록 업무 처리중 현황
	ReportEntity regCntEntity = (ReportEntity)request.getAttribute("regCntEntity");  //정보통신공사업 등록현황
	ReportEntity sidoEntity = (ReportEntity)request.getAttribute("sidoEntity");  //시도명
	
	String sidoNm = sidoEntity.getValue(0,"SIDO_NM");
	
	 
	String sdate			= (String)request.getAttribute("sdate");
	String edate			= (String)request.getAttribute("edate");
	String p_user_id			= (String)request.getAttribute("p_user_id");
	String p_user_pw			= (String)request.getAttribute("p_user_pw");
	
	
	String completion_r01 = completionEntity.getValue(0,"R01");		//완료 신규등록
	String completion_r02 = completionEntity.getValue(0,"R02");		//완료 기준신고
	String completion_r04 = completionEntity.getValue(0,"R04");		//완료 양도양수
	String completion_r06 = completionEntity.getValue(0,"R06");		//완료 합병
	String completion_r13 = completionEntity.getValue(0,"R13");		//완료 재교부
	String completion_r03 = completionEntity.getValue(0,"R03");		//완료 폐업
	String completion_r12 = completionEntity.getValue(0,"R12");		//완료 행정처분
	
	//합계
	int completion_sum = 
		KJFUtil.str2int(completion_r01) +
		KJFUtil.str2int(completion_r02) +
		KJFUtil.str2int(completion_r04) +
		KJFUtil.str2int(completion_r06) +
		KJFUtil.str2int(completion_r13) +
		KJFUtil.str2int(completion_r03) +
		KJFUtil.str2int(completion_r12);
	
	
	
	String ongoing_r01 = ongoingEntity.getValue(0,"R01");		//처리중 신규등록
	String ongoing_r02 = ongoingEntity.getValue(0,"R02");		//처리중 기준신고
	String ongoing_r04 = ongoingEntity.getValue(0,"R04");		//처리중 양도양수
	String ongoing_r06 = ongoingEntity.getValue(0,"R06");		//처리중 합병
	String ongoing_r13 = ongoingEntity.getValue(0,"R13");		//처리중 재교부
	String ongoing_r03 = ongoingEntity.getValue(0,"R03");		//처리중 폐업
	String ongoing_r12 = ongoingEntity.getValue(0,"R012");		//처리중 행정처분
	
	int ongoing_sum = 
		KJFUtil.str2int(ongoing_r01) +
		KJFUtil.str2int(ongoing_r02) +
		KJFUtil.str2int(ongoing_r04) +
		KJFUtil.str2int(ongoing_r06) +
		KJFUtil.str2int(ongoing_r13) +
		KJFUtil.str2int(ongoing_r03) +
		KJFUtil.str2int(ongoing_r12) ;
		
	
	 
	//전체 정보통신공사업 등록현황 수
	int totalRegCount = 0;
	for (int j = 0; j < regCntEntity.getRowCnt(); j++) {
		totalRegCount = totalRegCount + KJFUtil.str2int(KJFUtil.print(regCntEntity.getValue(j, "CNT"),"0"));
	}
	
	String go_bbs_url = URLEncoder.encode("/bbs/BbsAction.do?cmd=BbsKList&CT_ID=DATA_CHANGE");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">

<link href="../css/web_layout.css" rel="stylesheet" type="text/css" />
<link href="../css/web_style.css" rel="stylesheet" type="text/css" />
<link href="../css/web_form.css" rel="stylesheet" type="text/css" />


<title>정보통신 행정시스템</title>
<meta http-equiv="imagetoolbar" content="no" />
<meta name="author" content="정보통신 행정시스템" />
<head>

<script language="JavaScript" src="../com/js/com.js" type="text/javascript"></script>
<script language="javascript" src="../com/js/httpRequest.js" type="text/javascript"></script>

<script language="javascript">
	//게시판 관리자 등록
	function fn_bbsView() {
	
		//스크린의 크기
		sw = screen.availWidth;
		sh = screen.availHeight;
		
		cw = 700;
		ch = 450;
		
		//열 창의 포지션
		px = (sw - cw) / 2;
		py = (sh - ch) / 2;

		//var url = "http://localhost:8080/iccs/login/LoginAction.do?cmd=Login&id=<%=p_user_id %>&password=<%=p_user_pw %>&encoding=Y&beforeURL=<%=go_bbs_url %>";
		var url = "http://www.net.go.kr/login/LoginAction.do?cmd=Login&id=<%=p_user_id %>&password=<%=p_user_pw %>&encoding=Y&beforeURL=<%=go_bbs_url %>";

		
		result = window.open(url, "view_info" , "width="+cw+" , height="+ch+",left="+px+",top="+py+",toolbar=no, scrollbars=yes");
		result.focus();
		
	}

	function fn_search() {

		var fm = document.fmParam;
		
		var scSD_CD = '<%=KJFUtil.print(request.getParameter("scSD_CD"),"") %>';
		var scSGG_CD = '<%=KJFUtil.print(request.getParameter("scSGG_CD"),"") %>';
		var CAPITAL = '<%=KJFUtil.print(request.getParameter("scCAPITAL"),"") %>';

		var SDATE = fm.S_DATE.value;
		var EDATE = fm.E_DATE.value;

		//alert("scSD_CD :"+scSD_CD+"\n scSGG_CD :"+scSGG_CD+"\n CAPITAL :"+CAPITAL+"\n SDATE :"+SDATE+"\n EDATE :"+EDATE);
		
		sendRequest("../index/IndexAction.do?cmd=MainAjaxSearch", "scSD_CD="+scSD_CD+"&scSGG_CD="+scSGG_CD+"&CAPITAL="+CAPITAL+"&SDATE="+SDATE+"&EDATE="+EDATE, MainSearchRs, "POST");
	}
 
	function MainSearchRs() {
		
		var xmlObj = httpRequest.responseXML;

		
		var datas = xmlObj.getElementsByTagName("data");

		var spot = datas[0];

		var completion_r01 = spot.getElementsByTagName("completion_r01")[0].firstChild.nodeValue;
		var completion_r02 = spot.getElementsByTagName("completion_r02")[0].firstChild.nodeValue;
		var completion_r04 = spot.getElementsByTagName("completion_r04")[0].firstChild.nodeValue;
		var completion_r06 = spot.getElementsByTagName("completion_r06")[0].firstChild.nodeValue;
		var completion_r13 = spot.getElementsByTagName("completion_r13")[0].firstChild.nodeValue;
		var completion_r03 = spot.getElementsByTagName("completion_r03")[0].firstChild.nodeValue;
		var completion_r12 = spot.getElementsByTagName("completion_r12")[0].firstChild.nodeValue;
		
		var completion_sum = Number(completion_r01) + 
							 Number(completion_r02) + 
							 Number(completion_r04) + 
							 Number(completion_r06) + 
							 Number(completion_r13) + 
							 Number(completion_r03) + 
							 Number(completion_r12);

		
		document.getElementById("completion_r01").innerHTML=completion_r01;
		document.getElementById("completion_r02").innerHTML=completion_r02;
		document.getElementById("completion_r04").innerHTML=completion_r04;
		document.getElementById("completion_r06").innerHTML=completion_r06;
		document.getElementById("completion_r13").innerHTML=completion_r13;
		document.getElementById("completion_r03").innerHTML=completion_r03;
		document.getElementById("completion_r12").innerHTML=completion_r12;
		document.getElementById("completion_sum").innerHTML=completion_sum;

		
		var ongoing_r01 = spot.getElementsByTagName("ongoing_r01")[0].firstChild.nodeValue;
		var ongoing_r02 = spot.getElementsByTagName("ongoing_r02")[0].firstChild.nodeValue;
		var ongoing_r04 = spot.getElementsByTagName("ongoing_r04")[0].firstChild.nodeValue;
		var ongoing_r06 = spot.getElementsByTagName("ongoing_r06")[0].firstChild.nodeValue;
		var ongoing_r13 = spot.getElementsByTagName("ongoing_r13")[0].firstChild.nodeValue;
		var ongoing_r03 = spot.getElementsByTagName("ongoing_r03")[0].firstChild.nodeValue;
		var ongoing_r12 = spot.getElementsByTagName("ongoing_r12")[0].firstChild.nodeValue;

		var ongoing_sum = Number(ongoing_r01) + 
		 				  Number(ongoing_r02) + 
		 				  Number(ongoing_r04) + 
						  Number(ongoing_r06) + 
		 				  Number(ongoing_r13) + 
		 				  Number(ongoing_r03) + 
		 				  Number(ongoing_r12);

		document.getElementById("ongoing_r01").innerHTML=ongoing_r01;
		document.getElementById("ongoing_r02").innerHTML=ongoing_r02;
		document.getElementById("ongoing_r04").innerHTML=ongoing_r04;
		document.getElementById("ongoing_r06").innerHTML=ongoing_r06;
		document.getElementById("ongoing_r13").innerHTML=ongoing_r13;
		document.getElementById("ongoing_r03").innerHTML=ongoing_r03;
		document.getElementById("ongoing_r12").innerHTML=ongoing_r12;
		document.getElementById("ongoing_sum").innerHTML=ongoing_sum;
		 
	}
	
	
</script>

</head>

<body scrool="no">

<OBJECT width = "0" height = "0" ID="ZTransferX" CLASSID="CLSID:C7C7225A-9476-47AC-B0B0-FF3B79D55E67" codebase="http://www.net.go.kr/oz/ozviewer/ZTransferX.cab#version=2,2,0,8">
<PARAM NAME="download.Server" VALUE="http://www.net.go.kr/oz/ozviewer">
<PARAM NAME="download.Port" VALUE="80">
<PARAM NAME="download.Instruction" VALUE="ozrviewer.idf">
<PARAM NAME="install.Base" VALUE="<PROGRAMS>/Forcs">
<PARAM NAME="install.Namespace" VALUE="OzViewerSetUp">
</OBJECT>


<br>
<br>
<form name="fmParam" method="post">

			<!-- 중간컨텐츠 : S -->
	   			<div id="contents2" >
	   				<table  cellspacing="0" cellpadding="0" border="0">
	   					<tr valign="top">
	   						<td valign="top">
				   				<h4><%=sidoNm %>&nbsp;&nbsp;공사업등록 업무 처리 현황</h4>
				   				<table width="100%">
				   					<tr>
				   						<td align="right" width="85%">
											<input name="S_DATE" type=text id="scStartDate" value="<%=sdate%>" size="10" required="시작일자를 입력하세요" readonly>
											<div id="div_start" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; " >
												<iframe src='../com/calander.jsp?frm=fmParam&fName=S_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
											</div>
											<img src="../images/cal.gif" onclick="MM_showHideLayers('div_start','','show')" align="absmiddle" style="cursor:hand" >
											~
											<input name="E_DATE" type=text id="scEndDate" value="<%=edate%>" size="10" required="종료일자를 입력하세요" readonly>
											<div id="div_end" style="position:absolute;  width:167px; height:187px; z-index:1; visibility: hidden; ">
												<iframe src='../com/calander.jsp?frm=fmParam&fName=E_DATE' scrolling="no" frameborder="0" width="160" height="190"></iframe>
											</div>
											<img src="../images/cal.gif" onclick="MM_showHideLayers('div_end','','show')" align="absmiddle" style="cursor:hand" >
										</td>
										<td align="right">	
											<a href="javascript:fn_search();"><img src="../images/bt_search.gif" border="0" alt="검색" style="cursor:hand"></a>
                   						</td>
				   					</tr>
				   				</table>
								<table class="t5" cellspacing="0" cellpadding="0" border="0" summary="공사업등록 업무 처리 현황">
								    <caption>공사업등록 업무 처리 현황</caption>
								    <thead>
								        <tr>
								            <th class="letter0">구분</th>
								            <th class="letter0">신규등록</th>
								            <th class="letter0">기준신고</th>
								            <th class="letter0">양도양수</th>
								            <th class="letter0">합병</th>
								            <th class="letter0">재교부</th>
								            <th class="letter0">폐업</th>
								            <th class="letter0">행정처분</th>
								            <th class="letter0">합계</th>
								        </tr>
								    </thead>
								    <tbody>
								        <tr>
								            <td>처리완료</td>
								            <td class="letter1" align="center"><div id="completion_r01"><%=completion_r01 %></div></td>
								            <td class="letter1" align="center"><div id="completion_r02"><%=completion_r02 %></div></td>
								            <td class="letter1" align="center"><div id="completion_r04"><%=completion_r04 %></div></td>
								            <td class="letter1" align="center"><div id="completion_r06"><%=completion_r06 %></div></td>
								            <td class="letter1" align="center"><div id="completion_r13"><%=completion_r13 %></div></td>
								            <td class="letter1" align="center"><div id="completion_r03"><%=completion_r03 %></div></td>
								            <td class="letter1" align="center"><div id="completion_r12"><%=completion_r12 %></div></td>
								            <td class="letter1" align="center"><div id="completion_sum"><%=completion_sum %></div></td>
								        </tr>
								        <tr>
								            <td>진행중</td>
								            <td class="letter1" align="center"><div id="ongoing_r01"><%=ongoing_r01 %></div></td>
								            <td class="letter1" align="center"><div id="ongoing_r02"><%=ongoing_r02 %></div></td>
								            <td class="letter1" align="center"><div id="ongoing_r04"><%=ongoing_r04 %></div></td>
								            <td class="letter1" align="center"><div id="ongoing_r06"><%=ongoing_r06 %></div></td>
								            <td class="letter1" align="center"><div id="ongoing_r13"><%=ongoing_r13 %></div></td>
								            <td class="letter1" align="center"><div id="ongoing_r03"><%=ongoing_r03 %></div></td>
								            <td class="letter1" align="center"><div id="ongoing_r12"><%=ongoing_r12 %></div></td>
								            <td class="letter1" align="center"><div id="ongoing_sum"><%=ongoing_sum %></div></td>
								        </tr>
								    </tbody>
								</table>
								
								<h4>정보통신공사업 등록현황 ( 전체 : <%=totalRegCount %>)</h4>
								<img src="../chart/ChartAction.do?cmd=ChartArea" width="470"/>
							  <table class="t5" summary="표 보기">
								<thead>
								  <tr>						
									<% if (regCntEntity.getRowCnt() >= 17 ) {%>
										<% for (int i = 0; i < 9; i++) { %>
										<th scope="col"><%=KJFArea.getSido_Name(KJFUtil.print(regCntEntity.getValue(i, "SIDO_CODE"))) %></th>
										<% } %>
			
									<% } else { %>
										<th scope="col" class="letter0">강원</th>
										<th scope="col" class="letter0">경기</th>
										<th scope="col" class="letter0">경남</th>
										<th scope="col" class="letter0">경북</th>
										<th scope="col" class="letter0">광주</th>
										<th scope="col" class="letter0">대구</th>
										<th scope="col" class="letter0">대전</th>
										<th scope="col" class="letter0">부산</th>
										<th scope="col" class="letter0">서울</th>
									<% } %>
								  </tr>
								</thead>
								<tbody>
								  <tr>
									<% if (regCntEntity.getRowCnt() >= 17 ) {%>
										<% for (int i = 0; i < 9; i++) { %>
										<td align="center" class="letter1"><%=KJFUtil.print(regCntEntity.getValue(i, "CNT")) %></th>
										<% } %>
			
									<% } else { %>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
									<% } %>
								  </tr>
								</tbody>
								<thead>
								  <tr>
									<% if (regCntEntity.getRowCnt() >= 17 ) {%>
										<% for (int i = 9; i < 17; i++) { %>
										<th scope="col" class="letter1"><%=KJFArea.getSido_Name(KJFUtil.print(regCntEntity.getValue(i, "SIDO_CODE"))) %></th>
										<% } %>
			
									<% } else { %>
										<th scope="col" class="letter0">세종</th>
										<th scope="col" class="letter0">울산</th>
										<th scope="col" class="letter0">인천</th>
										<th scope="col" class="letter0">전남</th>
										<th scope="col" class="letter0">전북</th>
										<th scope="col" class="letter0">제주</th>
										<th scope="col" class="letter0">충남</th>
										<th scope="col" class="letter0">충북</th>
									<% } %>
								  </tr>
								</thead>
								<tbody>
								  <tr>
									<% if (regCntEntity.getRowCnt() >= 17 ) {%>
										<% for (int j = 9; j < 17; j++) { %>
										<td align="center" class="letter1"><%=KJFUtil.print(regCntEntity.getValue(j, "CNT")) %></th>
										<% } %>
			
									<% } else { %>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
										<td align="center">&nbsp;</td>
									<% } %>
								  </tr>
								</tbody>
							  </table>
							</td>
							<td><table width="50"><tr><td>&nbsp;</td></tr></table></td>
							<td valign="top">
																			  	<!-- 컨텐츠 : S -->

										<h4>센터커뮤니티</h4>
										<table class="t5" cellspacing="0" cellpadding="0" border="0" summary="센터커뮤니티">
										    <caption>센터커뮤니티</caption>
										    <thead>
										        <tr>
										            <th>게시판 구분</th>
										            <th width="260">내용</th>
										            <th>&nbsp;</th>
										        </tr>
										    </thead>
										    <tbody>
											<% if ( ListEntity != null && ListEntity.getRowCnt() != 0) { %>
												<% for (int i = 0; i < ListEntity.getRowCnt(); i++ ) { 
														go_url = "/bbs/BbsAction.do?cmd=BbsKView&CT_ID="+ListEntity.getValue(i, "CT_ID")+"&BOARD_SEQ="+ListEntity.getValue(i, "BOARD_SEQ");
														go_url = URLEncoder.encode(go_url);
														
												%>
													<tr>
														<td>
															<%="<span class='t_name'>["+KJFUtil.getTitleLimit(ListEntity.getValue(i, "TITLE_HEADER"),8)+"]</span>" %>
														</td>
														<td>
															<a href="http://www.net.go.kr/login/LoginAction.do?cmd=Login&id=<%=p_user_id %>&password=<%=p_user_pw %>&encoding=Y&beforeURL=<%=go_url %>" target="_blank">
															<span class="subject2">
																 <%=KJFUtil.java2html(KJFUtil.getTitleLimit(ListEntity.getValue(i, "SUBJECT"), 34))%>
																<%if (KJFDate.isNew(3, ListEntity.getValue(i,"INS_DT")) ) { %>
																	<img src='../images/bbs/ico_new.gif' alt="새 글">
																<% } %>	
															</span></a>
															
														</td>
														<td class="letter0">	
															<%=KJFDate.getTimeAsPattern(KJFDate.str2date(ListEntity.getValue(i, "INS_DT"), ""), "yyyy.MM.dd")%>
														</td>	
													</tr>
						    					
										        							
												<% } %>
												
											<% } else { %>
						    					<tr>
													<td collspan="3">등록된 글이 없습니다.</td>
										        </tr>						
											<% } %>				    
						
											</tbody>
										</table>        
								
										<h4>법·제도</h4>
										

										<table class="t5" cellspacing="0" cellpadding="0" border="0" summary="법·제도">
										    <caption>법·제도</caption>
										    <thead>
										        <tr>
										            <th>게시판 구분</th>
										            <th>내용</th>
										            <th>&nbsp;</th>
										        </tr>
										    </thead>
										    <tbody>										
				
											<% if ( rEtcEntity != null && rEtcEntity.getRowCnt() != 0) { %>
												<% for (int i = 0; i < rEtcEntity.getRowCnt(); i++ ) { 
														go_url = "/bbs/BbsAction.do?cmd=BbsKView&CT_ID="+rEtcEntity.getValue(i, "CT_ID")+"&BOARD_SEQ="+rEtcEntity.getValue(i, "BOARD_SEQ");
														go_url = URLEncoder.encode(go_url);
												%>
													<tr>
														<td>
															<%="<span class='t_name'>["+rEtcEntity.getValue(i, "TITLE_HEADER")+"]</span>" %>
														</td>
														<td>
															<a href="http://www.net.go.kr/login/LoginAction.do?cmd=Login&id=<%=p_user_id %>&password=<%=p_user_pw %>&encoding=Y&beforeURL=<%=go_url %>" target="_blank">
															
																 <%=KJFUtil.java2html(KJFUtil.getTitleLimit(rEtcEntity.getValue(i, "SUBJECT"), 34))%>
																<%if (KJFDate.isNew(3, rEtcEntity.getValue(i,"INS_DT")) ) { %>
																	<img src='../images/bbs/ico_new.gif' alt="새 글">
																<% } %>	
															</a>														
														</td>
														<td class="letter0">
															<%=KJFDate.getTimeAsPattern(KJFDate.str2date(rEtcEntity.getValue(i, "INS_DT"), ""), "yyyy.MM.dd")%>
														</td>
													</tr>
												<% } %>
												
											<% } else { %>
						    					<tr>
													<td collspan="3">등록된 글이 없습니다.</td>
										        </tr>
											<% } %>
											</tbody>
										</table>
										<table align="right">
											<tr>
												<td>
													<a href="javascript:fn_bbsView();"><img src='../images/btn_data.gif' alt="데이터변경"/></a>
												</td>
											</tr>
										</table>
							</td>
						</tr>
					</table>
				</div>
</form>

</body>
</html>

