<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.console.*" %>

<%
	ReportEntity rEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("rEntity") );	// 공사업 등록현황
	ReportEntity mEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("mEntity") );	// 위법현황
	ReportEntity sEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("sEntity") );	// 착공전 설계도
	ReportEntity uEntity = KJFUtil.REntPrint( (ReportEntity)request.getAttribute("uEntity") );	// 사용전검사
	
	ConsoleParam pm = (ConsoleParam)request.getAttribute("pm");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>정보통신공사업 시스템 종합상황표</title>
<link href="../console/css/css.css" rel="stylesheet" type="text/css" />
</head>

<script language="javascript">

function Lpad(str, len) {
 	str = str + "";
 	
	while(str.length < len) {
  		str = "0" + str;
 	}
 	
 	return str;
}

var iMinute = 1;	// 시간 지정 분
var iSecond = iMinute * 60 ;
var timerchecker = null;

initTimer = function() {
	
 	rMinute = parseInt(iSecond / 60);
 	rSecond = iSecond % 60;
 	
 	if(iSecond > 0) {
  		iSecond--;
  		timerchecker = setTimeout("initTimer()", 1000); // 1초 간격으로 체크
  		
 	} else {
  		clearTimeout(timerchecker);
  		
  		var fm = document.fmParam;
		fm.action = "../console/ConsoleAction.do?cmd=ConsoleStatus";
		fm.submit();
 	}
}
</script>

<body id="sub">

	<form name="fmParam" method="post">
		<input type="hidden" name="sido_code" value="<%=pm.getSido_code()%>">
	</form>

	<div id="top">
		<div id="region"><%=KJFArea.getSido_Name(KJFUtil.print(pm.getSido_code()))%></div>
		<div id="Clock"></div>
		<script>
			 function time() {
			  myDate = new Date();
			  Clock.innerHTML = myDate.toLocaleString();
			  setTimeout("time()", 1000);
			 }
			 onload = time;
			 initTimer();
		</script>
	</div>
	<!--컨텐츠 : S -->
	<div id="contents_all">
		<!-- 등록 누적현황 : S -->
		<div id="contents">
			<div id="contents_title"><img src="../console/images/sub_title1.gif" alt="등록 누적현황" /></div>
			<div id="graph"><img src="../chart/ChartAction.do?cmd=ChartRegister"/></div>
		</div>
		<!-- 등록 누적현황 : E -->
		
		<!-- 연간 누적현황 : S -->
		<div id="contents_right">
			<div id="contents_title"><img src="../console/images/sub_title2.gif" alt="연간 누적현황" /></div>
			<div id="graph"><img src="../chart/ChartAction.do?cmd=ChartYear&sido_code=<%=pm.getSido_code()%>"/></div>
		</div>
		<!-- 연간 누적현황 : E -->
		
		<!-- 사업자 유형별 통계 : S -->
		<div id="contents">
			<div id="contents_title"><img src="../console/images/sub_title3.gif" alt="사업자 유형별 통계" /></div>
			<div id="graph"><img src="../chart/ChartAction.do?cmd=ChartBusiness&sido_code=<%=KJFUtil.print(pm.getSido_code())%>"/></div>
		</div>
		<!-- 사업자 유형별 통계 : E -->
		
		<!-- 월간 통계 : S -->
		<div id="contents_right">
			<div id="contents_title"><img src="../console/images/sub_title4.gif" alt="월간 통계" /></div>
			<div id="graph"><img src="../chart/ChartAction.do?cmd=ChartMonth&sido_code=<%=KJFUtil.print(pm.getSido_code())%>"/></div>
		</div>
		<!-- 월간 통계 : E -->
		
		<!-- 민원 업무처리 현황 : S -->
		<div id="contents_5">
			<div id="contents_title"><img src="../console/images/sub_title5.gif" alt="민원 업무처리 현황" /></div>
			<div id="table">
				<!--1라인 : S -->
				<div class="txt">
					<ul><p>신규등록</p>
						<li><%=KJFUtil.print(rEntity.getValue(0, "REGIST_CNT")) %>건</li>
						<li><%=KJFUtil.print(rEntity.getValue(1, "REGIST_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>등록기준건수</p>
						<li><%=KJFUtil.print(rEntity.getValue(0, "BASIC_CNT")) %>건</li>
						<li><%=KJFUtil.print(rEntity.getValue(1, "BASIC_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>양도양수</p>
						<li><%=KJFUtil.print(rEntity.getValue(0, "ASSI_CNT")) %>건</li>
						<li><%=KJFUtil.print(rEntity.getValue(1, "ASSI_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>법인합병</p>
						<li><%=KJFUtil.print(rEntity.getValue(0, "UNION_CNT")) %>건</li>
						<li><%=KJFUtil.print(rEntity.getValue(1, "UNION_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>변경신고</p>
						<li>0건</li>
						<li>0건</li>
					</ul>
				</div>
				
				<div class="txt" style="margin-right:20px;">
					<ul><p>폐업처리</p>
						<li><%=KJFUtil.print(rEntity.getValue(0, "CLOSE_CNT")) %>건</li>
						<li><%=KJFUtil.print(rEntity.getValue(1, "CLOSE_CNT")) %>건</li>
					</ul>
				</div>
				<!--1라인 : E -->
				
				<!--2라인 : S -->
				<div class="txt">
					<ul><p>영업정지</p>
						<li><%=KJFUtil.print(mEntity.getValue(0, "PT_M_SUS_CNT")) %>건</li>
						<li><%=KJFUtil.print(mEntity.getValue(1, "PT_M_SUS_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>등록취소</p>
						<li><%=KJFUtil.print(mEntity.getValue(0, "PT_M_CAN_CNT")) %>건</li>
						<li><%=KJFUtil.print(mEntity.getValue(1, "PT_M_CAN_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>과태료부과</p>
						<li><%=KJFUtil.print(mEntity.getValue(0, "PT_M_NEG_CNT")) %>건</li>
						<li><%=KJFUtil.print(mEntity.getValue(1, "PT_M_NEG_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>경고조치</p>
						<li><%=KJFUtil.print(mEntity.getValue(0, "PT_M_WAR_CNT")) %>건</li>
						<li><%=KJFUtil.print(mEntity.getValue(1, "PT_M_WAR_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>시정명령</p>
						<li><%=KJFUtil.print(mEntity.getValue(0, "PT_M_COR_CNT")) %>건</li>
						<li><%=KJFUtil.print(mEntity.getValue(1, "PT_M_COR_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt" style="margin-right:20px;">
					<ul><p>형사고발</p>
						<li><%=KJFUtil.print(mEntity.getValue(0, "PT_M_PRO_CNT")) %>건</li>
						<li><%=KJFUtil.print(mEntity.getValue(1, "PT_M_PRO_CNT")) %>건</li>
					</ul>
				</div>
				<!--2라인 : E -->
				<!--3라인 : S -->
				<div class="txt">
					<ul><p>착공전설계</p>
						<li><%=KJFUtil.print(sEntity.getValue(0, "PT_UB_CON_CNT")) %>건</li>
						<li><%=KJFUtil.print(sEntity.getValue(1, "PT_UB_CON_CNT")) %>건</li>
					</ul>
				</div>
				
				<div class="txt">
					<ul><p>사용전검사</p>
						<li><%=KJFUtil.print(uEntity.getValue(0, "PT_UB_USE_CNT")) %>건</li>
						<li><%=KJFUtil.print(uEntity.getValue(1, "PT_UB_USE_CNT")) %>건</li>
					</ul>
				</div>
				<!--3라인 : E -->
			</div>
		</div>
	</div>

</body>
</html>
