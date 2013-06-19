<%@ page contentType="text/xml; charset=utf-8"
	import="kjf.ops.ReportEntity"
%><%
	response.setHeader ("Pragma", "No-cache");
	response.setDateHeader ("Expires", 0);
	response.setHeader ("Cache-Control", "no-cache");

	ReportEntity completionEntity = (ReportEntity)request.getAttribute("completionEntity");  //공사업등록 업무 처리 완료 현황
	ReportEntity ongoingEntity = (ReportEntity)request.getAttribute("ongoingEntity");  //공사업등록 업무 처리중 현황
	
%><?xml version="1.0"  encoding="euc-kr"?>
<data-set>
<%
	for(int i=0;i<completionEntity.getRowCnt();i++){
%>
	<data> 
		<completion_r01><%=completionEntity.getValue(i, "R01") %></completion_r01>
		<completion_r02><%=completionEntity.getValue(i, "R02") %></completion_r02>
		<completion_r04><%=completionEntity.getValue(i, "R04") %></completion_r04>
		<completion_r06><%=completionEntity.getValue(i, "R06") %></completion_r06>
		<completion_r13><%=completionEntity.getValue(i, "R13") %></completion_r13>
		<completion_r03><%=completionEntity.getValue(i, "R03") %></completion_r03>
		<completion_r12><%=completionEntity.getValue(i, "R12") %></completion_r12>
		<ongoing_r01><%=ongoingEntity.getValue(i, "R01") %></ongoing_r01>
		<ongoing_r02><%=ongoingEntity.getValue(i, "R02") %></ongoing_r02>
		<ongoing_r04><%=ongoingEntity.getValue(i, "R04") %></ongoing_r04>
		<ongoing_r06><%=ongoingEntity.getValue(i, "R06") %></ongoing_r06>
		<ongoing_r13><%=ongoingEntity.getValue(i, "R13") %></ongoing_r13>
		<ongoing_r03><%=ongoingEntity.getValue(i, "R03") %></ongoing_r03>
		<ongoing_r12><%=ongoingEntity.getValue(i, "R012") %></ongoing_r12>
	</data>
<%
	}
%>

</data-set>