<%--
*************************************************************************************************
* 파  일  명 : AuthPgMgrL.jsp
* 설      명 : 권한그룹별 프로그램 관리화면
* 
* 이력사항 :
* 2006/09/15  양석환  최초작성
*************************************************************************************************
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Vector" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.uent.*" %>
<%@ page import="sp.sys.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%
	//초기 변수 들 선언
	ReportEntity rEntity =(ReportEntity)request.getAttribute("rEntity");

	Vector v_menuEntList= (Vector)request.getAttribute("v_menuEntList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>프로그램 관리</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../com/css/styleOld.css" rel="stylesheet" type="text/css">
<link href="../com/css/skin/blue.css" rel="stylesheet" type="text/css">
<link href="../com/css/styleAdmin.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/javascript" src="../com/js/kjs.js"></script>
<script language="javascript" type="text/javascript" src="../com/js/usertree.js"></script>
<script>
TFRAME="_self";

<%
 	boolean isTree = false;


	if (v_menuEntList != null  ){
		int cnt = v_menuEntList.size();

		if(cnt > 0){
			out.println("foldersTree = gFld('프로그램',  '');");
	
			for (int i = cnt-2 ; i+1 >  0  ; i--) {
				MenuEnt menuEnt = (MenuEnt)v_menuEntList.get(i);
	
				isTree = true;
	
				rEntity = (ReportEntity)menuEnt.getPT_PGEnt();
				if("0".equals(menuEnt.getP_PG_GROUP_ID())) {
					if(!KJFUtil.isEmpty(menuEnt.getGR_AND_PG_LOW_IDS())){
					    out.println("sub_" + menuEnt.getPG_GROUP_ID() + "=insFld(foldersTree, gFld('" + menuEnt.getGROUP_NAME() 
					            + "','javascript:f_gr_del(\"" + menuEnt.getGR_AND_PG_LOW_IDS() + "\");'));");
					}	
				}else{
	
					if(!KJFUtil.isEmpty(menuEnt.getGR_AND_PG_LOW_IDS())){
					    out.println("sub_" + menuEnt.getPG_GROUP_ID() + "=insFld(sub_" + menuEnt.getP_PG_GROUP_ID() 
					            + ", gFld('" + menuEnt.getGROUP_NAME() + "','javascript:f_gr_del(\"" + menuEnt.getGR_AND_PG_LOW_IDS() + "\");'));");
					}
				}
	
				if(rEntity!=null){
					for(int j=0; j < rEntity.getRowCnt(); j++){
						out.println("insDoc(sub_" + menuEnt.getPG_GROUP_ID() + ", gScript(1, '" + rEntity.getValue(j,"PG_NAME") 
						        + "', 'f_del(\"" + rEntity.getValue(j,"PG_ID") + "\",\"" + rEntity.getValue(j,"PG_GROUP_ID")+ "\")'));");
					}
				}
			}
		} else {
			out.println("foldersTree = gFld('등록된 프로그램이 없습니다.',  '');");
			isTree = true;
		}
	}
%>




//한줄삭제
function f_del(PG_ID, PG_GROUP_ID) {
	var fm = document.fmParam;

    if (!confirm("선택된 항목을 삭제 하시겠습니까?")){
        return;
    }

    fm.AUTH_GROUP_CODE.value = parent.document.fmSearch.scAUTH_GROUP_CODE.value;
    fm.scAUTH_GROUP_CODE.value = parent.document.fmSearch.scAUTH_GROUP_CODE.value;
    fm.PG_ID.value = PG_ID;
    fm.PG_GROUP_ID.value = PG_GROUP_ID;
    fm.READ_FLAG.value = "";
    fm.WRITE_FLAG.value = "";
    fm.COM_FLAG.value = "";

	fm.cmd.value = "AuthPgMgrCUD";
    fm.mode.value="D";

    fm.submit();
}

//전체삭제
function f_gr_del(GR_ADN_PG_IDS) {

    if (!confirm("선택한 메뉴 하위 프로그램들을 모두 삭제 하시겠습니까?")){
        return;
    }
	var fm = document.fmParam;
	fm.AUTH_GROUP_CODE.value = parent.document.fmSearch.scAUTH_GROUP_CODE.value;
    fm.scAUTH_GROUP_CODE.value = parent.document.fmSearch.scAUTH_GROUP_CODE.value;
	fm.GR_ADN_PG_IDS.value = GR_ADN_PG_IDS;	

	fm.cmd.value = "AuthPgMgrCUD";
    fm.mode.value="GD";

    fm.submit();
}

</script>
</head>

<body leftmargin="0" topmargin="0">
<form name="fmParam" method="post" action="SysAction.do" target="ListFrame">
<input type="hidden" name="cmd" value="">
<input type="hidden" name="mode" value="">
<input type="hidden" name="scAUTH_GROUP_CODE" value="">
<input type="hidden" name="SEQ" value="">
<input type="hidden" name="AUTH_GROUP_CODE" value="">
<input type="hidden" name="PG_ID" value="">
<input type="hidden" name="PG_GROUP_ID" value="">
<input type="hidden" name="READ_FLAG" value="">
<input type="hidden" name="WRITE_FLAG" value="">
<input type="hidden" name="COM_FLAG" value="">
<input type="hidden" name="GR_ADN_PG_IDS"   value="">

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td valign="top" align="center">
			<table width="100%" border="0" cellspacing="0" cellpadding="5">
				<tr>
					<td valign="top" height="100%">
						<%
						if (isTree){
							%>
							<script language="JavaScript">
							ISFULLOPEN=1;//전체 폴더 오픈
							initializeDocument(foldersTree);
							ISFULLOPEN=0;//원상 복귀
							</script>
							<%
						}
						%>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
