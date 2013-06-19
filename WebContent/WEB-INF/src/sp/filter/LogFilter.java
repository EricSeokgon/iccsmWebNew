/*
2006. 12. 20���� 11:35:16
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

		/*������ VIEW ���*/
		viewLog(httprequest);
		
		/*�湮�� ���*/
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
		
		/*.do, .html, .htm, .jsp ���ϸ� �α׸� ó���Ѵ�.*/
		if(URL.substring(URL.lastIndexOf("/")+1,URL.length()).equals("tail_log.jsp") || URL.substring(URL.lastIndexOf("/")+1,URL.length()).equals("tail_log_ajax.jsp")){

		}else if(IndexOfURL.equals("do")||IndexOfURL.equals("htm")||IndexOfURL.equals("jsp")||IndexOfURL.equals("html")){
			
			String codeFlag = "";
			
			if(Parameters != null){
				URL = URL+"?"+Parameters;
			}
			
				/*�ش� �������� �α׷� ����ϴ��� 
				 * �� �α׸� ����ϸ� �ش� ������ �ڵ带 ��ȸ�Ѵ�.*/
				codeFlag = KJFUtil.print(LogMgr.SearchCODE(URL));
				
				/*�ڵ尡 �����ϸ� �α׸� ����Ѵ�.*/
				if(!KJFUtil.isEmpty(codeFlag)){
					
					KJFLog.log("\n\n\n\n");
					
					try {
						
						TX_MGR.begin("KJF");

						KJFLog.log("=====================================================");
						KJFLog.log("VIEW ������ �α� ��� ����");
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
		
		/*�����ڴ� �α׿� ������� �ʴ´�*/
		if(!URL.startsWith("/minAD/")){
		
			/*.do, .html, .htm, .jsp ���ϸ� �α׸� ó���Ѵ�.*/
			if(URL.substring(URL.lastIndexOf("/")+1,URL.length()).equals("tail_log.jsp") || URL.substring(URL.lastIndexOf("/")+1,URL.length()).equals("tail_log_ajax.jsp")){

			}else if(IndexOfURL.equals("do")||IndexOfURL.equals("htm")||IndexOfURL.equals("jsp")||IndexOfURL.equals("html")){
	
				/*
				 * �湮�ڴ� �ϳ��� explorerâ�� �ϳ��� ����ڷ� ����
				 * ������ �̿��Ͽ� �ѹ� �̻� �α׸� ������� �ʰ� �Ѵ�.
				 * */
				HttpSession session = request.getSession(true);
				String checkLogSession = KJFUtil.print(session.getAttribute("CheckFilterLog"));
	
				/*������ ���� ���� ������ ���*/
				if(KJFUtil.isEmpty(checkLogSession)){
								
					try {
						
						TX_MGR.begin("KJF");
						
						/*���� ����Ѵ�.*/
						session.setAttribute("CheckFilterLog","true");
						/*�αױ��*/
						KJFLog.log("=====================================================");
						KJFLog.log("�湮�� �α� ��� ����");
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
			/*������ ���ӿ� ���� �α׸� �����*/
		}
		
		
	}
	/*======================================================================================================*/
}
