<%@page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.ChartUtilities" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.chart.*" %>

<%
	ChartParam pm = (ChartParam)request.getAttribute("pm");

	response.setContentType("image/jpeg"); 
	ServletOutputStream objSos = response.getOutputStream();
	
	JFreeChart chart = (JFreeChart) request.getAttribute("chart");
	
	ChartUtilities.writeChartAsJPEG(objSos, chart, KJFUtil.str2int(pm.getChartWidth()), KJFUtil.str2int(pm.getChartHeight()));
	
	out.clear();
	out = pageContext.pushBody();
%>