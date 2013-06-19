package sp.log.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.log.LogParam;

public class LogMgr implements KJFCommandResp {
	
	private String next;
	
    public LogMgr() {
    }
    
    public LogMgr(String next_url) {
    	next = next_url; 
    }
	
	public String execute(HttpServletRequest request, HttpServletResponse resp, ActionForm form) throws Exception {
		
		String cmd = request.getParameter("cmd");
		LogParam pm = checkFrm(form);
		request.setAttribute("pm",pm);
		
		if(cmd.equals("PageDAY")){
			loadConditionPageDAY(request);
		}else if(cmd.equals("UserDAY")){
			loadConditionUserDAY(request);
		}else if(cmd.equals("PageHOUR")){
			loadConditionPageHOUR(request);
		}
		
		return next;
	}
	
	private void loadConditionPageHOUR(HttpServletRequest request)throws Exception{
		String query_page = "SELECT CODE_GROUP + '-' + CODE AS PAGE_ID, CODE_NAME FROM PT_PAGE_CODE WHERE CODE != '000'";
		Vector v_page = KJFSelectOPS.getSel(query_page, "","페이지선택");
		request.setAttribute("v_page", v_page);
	}
	
	private void loadConditionPageDAY(HttpServletRequest request)throws Exception{
		
		String query_page = "SELECT CODE_GROUP+'-'+CODE AS PAGE_ID, CODE_NAME FROM PT_PAGE_CODE WHERE CODE != '000'";
		Vector v_page = KJFSelectOPS.getSel(query_page, "","페이지선택");
		request.setAttribute("v_page", v_page);
		
		String query_year = "\n"+
		"SELECT YEAR(GETDATE())-3 YEAR1, RTRIM(CONVERT(CHAR, YEAR(GETDATE())-3))+'년' YEAR2 UNION ALL \n"+ 
		"SELECT YEAR(GETDATE())-2 YEAR1, RTRIM(CONVERT(CHAR, YEAR(GETDATE())-2))+'년' YEAR2 UNION ALL \n"+
		"SELECT YEAR(GETDATE())-1 YEAR1, RTRIM(CONVERT(CHAR, YEAR(GETDATE())-1))+'년' YEAR2 UNION ALL \n"+ 
		"SELECT YEAR(GETDATE())-0 YEAR1, RTRIM(CONVERT(CHAR, YEAR(GETDATE())-0))+'년' YEAR2 ";
		Vector v_year = KJFSelectOPS.getSel(query_year);
		request.setAttribute("v_year", v_year);
		
	}
	
	private void loadConditionUserDAY(HttpServletRequest request)throws Exception{
		
		String query_year = "\n"+
		"SELECT YEAR(GETDATE())-3 YEAR1, RTRIM(CONVERT(CHAR, YEAR(GETDATE())-3))+'년' YEAR2 UNION ALL \n"+ 
		"SELECT YEAR(GETDATE())-2 YEAR1, RTRIM(CONVERT(CHAR, YEAR(GETDATE())-2))+'년' YEAR2 UNION ALL \n"+
		"SELECT YEAR(GETDATE())-1 YEAR1, RTRIM(CONVERT(CHAR, YEAR(GETDATE())-1))+'년' YEAR2 UNION ALL \n"+ 
		"SELECT YEAR(GETDATE())-0 YEAR1, RTRIM(CONVERT(CHAR, YEAR(GETDATE())-0))+'년' YEAR2 ";
		Vector v_year = KJFSelectOPS.getSel(query_year);
		request.setAttribute("v_year", v_year);
		
	}
	
	private LogParam checkFrm(ActionForm form)throws Exception{
		
		LogParam pm = (LogParam)form;
        if (KJFUtil.isEmpty(pm.getChartHeight()))
        	pm.setChartHeight("400");
        
        if (KJFUtil.isEmpty(pm.getChartWidth()))
        	pm.setChartWidth("700");
        
        if (KJFUtil.isEmpty(pm.getChartAxis()))
        	pm.setChartAxis("Y");
        
        if (KJFUtil.isEmpty(pm.getFontAxis()))
        	pm.setFontAxis("Y");       
        	pm.setChartTitle(pm.getChartTitle()); // get 방식으로 넘어온 타이틀 한글 처리

		return pm;
		
	}

}
