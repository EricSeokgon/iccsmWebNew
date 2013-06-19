<%@ page contentType="text/xml; charset=utf-8"%>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="sp.sys.SysWorker" %>
<%@ page import="java.util.Vector" %>
<%@ page import=" sp.uent.MenuEnt" %>
<%@ page import="com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>
<%
 request.setCharacterEncoding("UTF-8");
 String user_id = request.getParameter("scUSER_ID");
 String capitel = request.getParameter("scCAPITAL");
 
 SysWorker sysworker = new SysWorker();
 ReportEntity rEntity     = null;
 Vector v_menuEntList; //사용자 메뉴
 
 v_menuEntList = sysworker.getUserMenuEntList(user_id, capitel);	


%>
<?xml version="1.0" encoding="utf-8"?>
<Menu>
<%
int row = 0;
int next_cnt = 0;
if (v_menuEntList != null  ){
	int cnt = v_menuEntList.size();
	int cnts = 0;
	int cntsub = 0;
	for (int i = cnt-2 ; i+1 >  0  ; i--) {

		MenuEnt menuEnt = (MenuEnt)v_menuEntList.get(i);

		rEntity = (ReportEntity)menuEnt.getPT_PGEnt();
		
		if("0".equals(menuEnt.getP_PG_GROUP_ID())) {
			
    		if(!KJFUtil.isEmpty(menuEnt.getGR_AND_PG_LOW_IDS())){
    			if(cnts > 0){
    			//System.out.println("</Item>1");
    			
    			%>
    				</Item>
    			<%}%>
    			<Item Enable="true" Id="999" Separator="false" Text="<%=menuEnt.getGROUP_NAME()%>">
    		<%
    		//System.out.println("<Item Enable='true' Id='999' Separator='false' Text='"+menuEnt.getGROUP_NAME()+"'>");
    		cnts++;
    		}
    		
		}else{ 				
			if(!KJFUtil.isEmpty(menuEnt.getGR_AND_PG_LOW_IDS())){%>
				<Item Enable="true" Id="999" Separator="false" Text="<%=menuEnt.getGROUP_NAME()%>" url="<%=menuEnt.getPG_GROUP_URL()%>">
			<%
			//System.out.println("<Item Enable='true' Id='999' Separator='false' Text='"+menuEnt.getGROUP_NAME()+"' url='"+menuEnt.getPG_GROUP_URL()+"'>");
			next_cnt ++;
			}
		}
		
		if(rEntity!=null){
			for(int j=0; j < rEntity.getRowCnt(); j++){
				String url = rEntity.getValue(j,"PG_URL");
				String type = "";
				if(url.indexOf("cmd") > 0){
					type = "EXP";
				}
			%>
					<Item Enable="true" Id="999" Separator="false" Text="<%=rEntity.getValue(j,"PG_NAME")%>" url="script:gfn_newWindow('<%=rEntity.getValue(j,"PG_ID")%>','<%=rEntity.getValue(j,"PG_GROUP_ID")%>','<%=rEntity.getValue(j,"PG_URL")%>','<%=rEntity.getValue(j,"PG_NAME")%>')" />	
				<%
				//System.out.println("<Item Enable='true' Id='999' Separator='false' Text='"+menuEnt.getGROUP_NAME()+"' url='script:gfn_newWindow('"+rEntity.getValue(j,"PG_ID")+"','"+rEntity.getValue(j,"PG_GROUP_ID")+"','"+rEntity.getValue(j,"PG_URL")+"','"+type+"'/>");
				cntsub++;
			}
			if(cntsub > 0 && !(next_cnt == 0)){%>
				</Item>
				<%//System.out.println("</Item>2:"+next_cnt);
				cntsub = 0;
				next_cnt = 0;
			}
		}
		
	}
}
//System.out.println("</Item>3"); 
%>


</Item>
</Menu>