/*
2006. 12. 20오전 11:35:16
*/

package sp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sp.filter.LogWorker;

import kjf.db.TX_MGR;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;


public class LogFilter implements Filter {
	
	private LogWorker LogMgr = new LogWorker();
	/*======================================================================================================*/
	public void init(FilterConfig filter) throws ServletException {	
		
	}
	/*======================================================================================================*/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httprequest = (HttpServletRequest)request;	

		/*페이지 VIEW 통계*/
		viewLog(httprequest);
		
		/*방문자 통계*/
		visitLog(httprequest);

		chain.doFilter(request,response);
		
	}
	/*======================================================================================================*/
	public void destroy() {
	}
	/*======================================================================================================*/
	public void viewLog(HttpServletRequest request){
		
		String URL = KJFUtil.print(request.getRequestURI());	
		String IndexOfURL = URL.substring(URL.indexOf(".")+1, URL.length());
		String Parameters = request.getQueryString();
		
		/*.do, .html, .htm, .jsp 파일만 로그를 처리한다.*/
		if(URL.substring(URL.lastIndexOf("/")+1,URL.length()).equals("tail_log.jsp") || URL.substring(URL.lastIndexOf("/")+1,URL.length()).equals("tail_log_ajax.jsp")){

		}else if(IndexOfURL.equals("do")||IndexOfURL.equals("htm")||IndexOfURL.equals("jsp")||IndexOfURL.equals("html")){
			
			String codeFlag = "";
			
			if(Parameters != null){
				URL = URL+"?"+Parameters;
			}
			
				/*해당 페이지를 로그로 기록하는지 
				 * 또 로그를 기록하면 해당 페이지 코드를 조회한다.*/
				codeFlag = KJFUtil.print(LogMgr.SearchCODE(URL));
				
				/*코드가 존재하면 로그를 기록한다.*/
				if(!KJFUtil.isEmpty(codeFlag)){
					
					KJFLog.log("\n\n\n\n");
					
					try {
						
						TX_MGR.begin("KJF");

						KJFLog.log("=====================================================");
						KJFLog.log("VIEW 페이지 로그 기록 시작");
						LogMgr.viewMgr(codeFlag);
						KJFLog.log("=====================================================");
						
						TX_MGR.commit();
						
					} catch (Exception e) {
						
						TX_MGR.rollback();
						request.setAttribute("ex", e.getMessage());
						KJFLog.log(e.toString());
						e.printStackTrace();
						
					}
				}
				
			
		}
		
	}
	/*======================================================================================================*/
	public void visitLog(HttpServletRequest request){
		
		String URL = KJFUtil.print(request.getRequestURI());	
		String IndexOfURL = URL.substring(URL.indexOf(".")+1, URL.length());
		
		/*관리자는 로그에 기록하지 않는다*/
		if(!URL.startsWith("/minAD/")){
		
			/*.do, .html, .htm, .jsp 파일만 로그를 처리한다.*/
			if(URL.substring(URL.lastIndexOf("/")+1,URL.length()).equals("tail_log.jsp") || URL.substring(URL.lastIndexOf("/")+1,URL.length()).equals("tail_log_ajax.jsp")){

			}else if(IndexOfURL.equals("do")||IndexOfURL.equals("htm")||IndexOfURL.equals("jsp")||IndexOfURL.equals("html")){
	
				/*
				 * 방문자는 하나의 explorer창에 하나의 사용자로 본다
				 * 세션을 이용하여 한번 이상 로그를 기록하지 않게 한다.
				 * */
				HttpSession session = request.getSession(true);
				String checkLogSession = KJFUtil.print(session.getAttribute("CheckFilterLog"));
	
				/*세션이 존재 하지 않으면 기록*/
				if(KJFUtil.isEmpty(checkLogSession)){
								
					try {
						
						TX_MGR.begin("KJF");
						
						/*세션 등록한다.*/
						session.setAttribute("CheckFilterLog","true");
						/*로그기록*/
						KJFLog.log("=====================================================");
						KJFLog.log("방문자 로그 기록 시작");
						LogMgr.insertVisit();
						KJFLog.log("=====================================================");
						
						TX_MGR.commit();
						
					} catch (Exception e) {
						
						TX_MGR.rollback();
						request.setAttribute("ex", e.getMessage());
						KJFLog.log(e.toString());
						e.printStackTrace();
						
					}
					
				}
			}
		
		}else{
			/*관리자 접속에 대한 로그를 남긴다*/
		}
		
		
	}
	/*======================================================================================================*/
}
