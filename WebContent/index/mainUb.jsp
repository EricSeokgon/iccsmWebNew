<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="sp.index.IndexParam" %>
<%@ page import="kjf.util.*" %>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>



<%

	ReportEntity ListEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("ListEntity") );	// 공무원센터 커뮤니티
	ReportEntity rEtcEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("ListEtcEntity") );	// 공무원센터 커뮤니티
	String go_url = "";

	ReportEntity rEntity = (ReportEntity)request.getAttribute("CrEntity");//착공전
	
	String C1, C2, C3, C4 , Ct;
	C1 = KJFUtil.print(rEntity.getValue(0,"ONE_QUARTER"),"0");
	C2 = KJFUtil.print(rEntity.getValue(0,"TOW_QUARTER"),"0");
	C3 = KJFUtil.print(rEntity.getValue(0,"TUR_QUARTER"),"0");
	C4 = KJFUtil.print(rEntity.getValue(0,"FOR_QUARTER"),"0");
	Ct = KJFUtil.print(rEntity.getValue(0,"TOAL_COUNT"),"0");
	
	
	rEntity = (ReportEntity)request.getAttribute("UrEntity");//사용전
	
	String U1, U2, U3, U4 , Ut;
	U1 = KJFUtil.print(rEntity.getValue(0,"ONE_QUARTER"),"0");
	U2 = KJFUtil.print(rEntity.getValue(0,"TOW_QUARTER"),"0");
	U3 = KJFUtil.print(rEntity.getValue(0,"TUR_QUARTER"),"0");
	U4 = KJFUtil.print(rEntity.getValue(0,"FOR_QUARTER"),"0");
	Ut = KJFUtil.print(rEntity.getValue(0,"TOAL_COUNT"),"0");
	
	rEntity = (ReportEntity)request.getAttribute("SrEntity");//감리

	String S1, S2, S3, S4 , St;
	S1 = KJFUtil.print(rEntity.getValue(0,"ONE_QUARTER"),"0");
	S2 = KJFUtil.print(rEntity.getValue(0,"TOW_QUARTER"),"0");
	S3 = KJFUtil.print(rEntity.getValue(0,"TUR_QUARTER"),"0");
	S4 = KJFUtil.print(rEntity.getValue(0,"FOR_QUARTER"),"0");
	St = KJFUtil.print(rEntity.getValue(0,"TOAL_COUNT"),"0");
	
	
	int T1 = KJFUtil.str2int(C1)+KJFUtil.str2int(U1)+KJFUtil.str2int(S1);
	int T2 = KJFUtil.str2int(C2)+KJFUtil.str2int(U2)+KJFUtil.str2int(S2);
	int T3 = KJFUtil.str2int(C3)+KJFUtil.str2int(U3)+KJFUtil.str2int(S3);
	int T4 = KJFUtil.str2int(C4)+KJFUtil.str2int(U4)+KJFUtil.str2int(S4);
	int Tt = KJFUtil.str2int(Ct)+KJFUtil.str2int(Ut)+KJFUtil.str2int(St);
	
	ReportEntity sidoEntity = (ReportEntity)request.getAttribute("sidoEntity");  //시도명
	String sggNm = sidoEntity.getValue(0,"SIGUNGU_NM");
	
	String addurl=	"&C1="+C1+
					"&C2="+C2+
					"&C3="+C3+
					"&C4="+C4+
					"&U1="+U1+
					"&U2="+U2+
					"&U3="+U3+
					"&U4="+U4+
					"&S1="+S1+
					"&S2="+S2+
					"&S3="+S3+
					"&S4="+S4;					

	String p_user_id			= (String)request.getAttribute("p_user_id");
	String p_user_pw			= (String)request.getAttribute("p_user_pw");
	
	
	
	
	String scYear			= (String)request.getAttribute("scYear");

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

<script language="javascript">

</script>

</head>
<body scrool="no">
<br>
<br>

<OBJECT width = "0" height = "0" ID="ZTransferX" CLASSID="CLSID:C7C7225A-9476-47AC-B0B0-FF3B79D55E67" codebase="http://www.net.go.kr/oz/ozviewer/ZTransferX.cab#version=2,2,0,8">
<PARAM NAME="download.Server" VALUE="http://www.net.go.kr/oz/ozviewer">
<PARAM NAME="download.Port" VALUE="80">
<PARAM NAME="download.Instruction" VALUE="ozrviewer.idf">
<PARAM NAME="install.Base" VALUE="<PROGRAMS>/Forcs">
<PARAM NAME="install.Namespace" VALUE="OzViewerSetUp">
</OBJECT>

<form name="searchfrm" action="../index/IndexAction.do?cmd=MainIndex" method="post">
<input type=hidden name="scUSER_ID" value="<%=KJFUtil.print(request.getParameter("scUSER_ID"))%>">
<input type=hidden name="scUSER_PW" value="<%=KJFUtil.print(request.getParameter("scUSER_PW"))%>">
<input type=hidden name="scSD_CD" value="<%=KJFUtil.print(request.getParameter("scSD_CD"))%>">
<input type=hidden name="scSGG_CD" value="<%=KJFUtil.print(request.getParameter("scSGG_CD"))%>">
<input type=hidden name="scCAPITAL" value="<%=KJFUtil.print(request.getParameter("scCAPITAL"))%>">

			<!-- 중간컨텐츠 : S -->
	   			<div id="contents2"  >
	   				<table  cellspacing="0" cellpadding="0" border="0" >
	   					<tr valign="top">
	   						<td valign="top"  width="470">
				   				<h4><%=sggNm %>&nbsp;&nbsp;분기별 업무 처리 현황&nbsp;&nbsp;&nbsp;		
				   					<KTags:KJFSelect item='<%=(Vector)request.getAttribute("v_scYear")%>'
											 name='scYear'
											 value='<%=KJFUtil.print(scYear) %>'
											 script="onchange='javascript:searchfrm.submit();' "/></h4>
											 
								<table class="t5" cellspacing="0" cellpadding="0" border="0" summary="분기별 업무 처리 현황">
								    <caption>분기별 업무 처리 현황</caption>
								    <thead>
								        <tr>
								            <th>업무구분</th>
								            <th>1분기</th>
								            <th>2분기</th>	
								            <th>3분기</th>
								            <th>4분기</th>
								            <th>총합계</th>
								        </tr>
								    </thead>
								    <tbody>
								        <tr>
											<th>착공전설계검토</th>
								            <td class="letter1" align="center"><%=C1 %>건</td>
								            <td class="letter1" align="center"><%=C2 %>건</td>
								            <td class="letter1" align="center"><%=C3 %>건</td>
								            <td class="letter1" align="center"><%=C4 %>건</td>
								            <td class="letter1" align="center"><%=Ct %>건</td>
								        </tr>
								        <tr>
											<th>사용전검사</th>
								            <td class="letter1" align="center"><%=U1 %>건</td>
								            <td class="letter1" align="center"><%=U2 %>건</td>
								            <td class="letter1" align="center"><%=U3 %>건</td>
								            <td class="letter1" align="center"><%=U4 %>건</td>
								            <td class="letter1" align="center"><%=Ut %>건</td>

								        </tr>
								        <tr>
											<th>감리결과보고서접수</th>
								            <td class="letter1" align="center"><%=S1 %>건</td>
								            <td class="letter1" align="center"><%=S2 %>건</td>
								            <td class="letter1" align="center"><%=S3 %>건</td>
								            <td class="letter1" align="center"><%=S4 %>건</td>
								            <td class="letter1" align="center"><%=St %>건</td>

								        </tr>
								        <tr>
											<th>총계</th>
								            <td class="letter1" align="center"><%=T1 %>건</td>
								            <td class="letter1" align="center"><%=T2 %>건</td>
								            <td class="letter1" align="center"><%=T3 %>건</td>
								            <td class="letter1" align="center"><%=T4 %>건</td>
								            <td class="letter1" align="center"><%=Tt %>건</td>

								        </tr>								        								        								        
								    </tbody>
								</table>
								<br>
								<img src="../chart/ChartAction.do?cmd=ChartUb<%=addurl %>>" width="470"/>

							</td>
							<td><table width="50"><tr><td></td></tr></table></td>
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
															<span class="subject2">
						 										 <%=KJFUtil.java2html(KJFUtil.getTitleLimit(rEtcEntity.getValue(i, "SUBJECT"), 34))%>
																<%if (KJFDate.isNew(3, rEtcEntity.getValue(i,"INS_DT")) ) { %>
																	<img src='../images/bbs/ico_new.gif' alt="새 글">
																<% } %>	
															</span></a>														
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
							</td>
						</tr>
					</table>
					
					
					
					
				</div>
</form>

</body>
</html>

