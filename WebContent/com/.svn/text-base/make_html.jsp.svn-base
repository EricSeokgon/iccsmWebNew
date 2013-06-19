<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import = "sp.util.MakeHTML" %>
<%@ page import = "kjf.util.KJFDate" %>
<%@ page import = "java.util.Date" %>

<%
	String scRECV_NUM = request.getParameter("scRECV_NUM");
	String scTYPE = request.getParameter("scTYPE");
	String SIDO_CODE = request.getParameter("SIDO_CODE");
	String SIGUNGU_CODE = request.getParameter("SIGUNGU_CODE");
	String TO_DATE = request.getParameter("TO_DATE");
	
	
	// 로컬 테스트용
	String from = "";      
	String to = "";  
	
	if("UBInvestInner".equals(scTYPE)){//사용전검사 내부보고서
		from = "http://localhost/iccsm/oz/UBInvestInner.jsp?scRECV_NUM="+scRECV_NUM+"&SIDO_CODE="+SIDO_CODE+"&SIGUNGU_CODE="+SIGUNGU_CODE+"&scTYPE="+scTYPE;      
		to = "D:\\work\\Jsp_Project\\iccsm\\oz\\"+TO_DATE+"_UBInvestInner.html"; 
	}else if("UBInvestResultNotiR".equals(scTYPE)){//사용전검사 결과 보고서
		from = "http://localhost/iccsm/oz/UBInvestResultNotiR.jsp?scRECV_NUM="+scRECV_NUM+"&SIDO_CODE="+SIDO_CODE+"&SIGUNGU_CODE="+SIGUNGU_CODE+"&scTYPE="+scTYPE;      
		to = "D:\\work\\Jsp_Project\\iccsm\\oz\\"+TO_DATE+"_UBInvestResultNotiR.html";  
	}
	
	// 서버용
	
	//if("UBInvestInner".equals(scTYPE)){//사용전검사 내부보고서
	//	from = "http://99.1.5.83/oz/UBInvestInner.jsp?scRECV_NUM="+scRECV_NUM+"&SIDO_CODE="+SIDO_CODE+"&SIGUNGU_CODE="+SIGUNGU_CODE+"&scTYPE="+scTYPE;      
	//	to = "/data/webroot/ICCSM/oz/"+TO_DATE+"_UBInvestInner.html"; 
	//}else if("UBInvestResultNotiR".equals(scTYPE)){//사용전검사 결과 보고서
	//	from = "http://99.1.5.83/oz/UBInvestResultNotiR.jsp?scRECV_NUM="+scRECV_NUM+"&SIDO_CODE="+SIDO_CODE+"&SIGUNGU_CODE="+SIGUNGU_CODE+"&scTYPE="+scTYPE;      
	//	to = "/data/webroot/ICCSM/oz/"+TO_DATE+"_UBInvestResultNotiR.html";  
	//}
	
	
	 
		MakeHTML mgr = new MakeHTML(from, to);
		mgr.makeByJAVA_NET_URL();

%>