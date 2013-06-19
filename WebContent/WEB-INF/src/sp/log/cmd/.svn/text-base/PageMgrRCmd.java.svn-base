/*
2006. 8. 4오후 6:03:17
*/

package sp.log.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import sp.log.PageParam;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;


public class PageMgrRCmd implements KJFCommand{

	private String next;
	
    public PageMgrRCmd() {
    }
    
    public PageMgrRCmd(String next_url) {
    	next = next_url; 
    }
	
	public String execute(HttpServletRequest req, ActionForm form) throws Exception {
		
		PageParam pm = checkFrm(form);
		loadCondition(req);
		loadDetail(req,pm);
		
		return next;
	}
	
	private PageParam checkFrm(ActionForm form)throws Exception{
		
		PageParam frm = (PageParam)form;

        /*페이징 라인*/
        if (KJFUtil.isEmpty(frm.getRowPerPage())){
        	
        	frm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
		return frm;
		
	}
	
	private void loadCondition(HttpServletRequest request)throws Exception{
		
		String query = "SELECT CODE_GROUP, CODE_NAME FROM PT_PAGE_CODE WHERE CODE = '000' ORDER BY CODE_GROUP ASC";
		Vector v_code_group = KJFSelectOPS.getSel(query);
		request.setAttribute("v_code_group",v_code_group);
		
	}
	
	private void loadDetail(HttpServletRequest request, PageParam pm)throws Exception{
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        String selectSQL = "\n" +

        		"select \n" +
        		"				CODE_GROUP_ID, CODE_GROUP, CODE, CODE_NAME, CODE_URL,\n" +
        		"				ORDER_NUM, USE_YN \n";
        
        String fromSQL ="FROM PT_PAGE_CODE \n";
        
        String whereSQL = 
        	"WHERE	1=1						\n";
        
        whereSQL += "" +
        		"	AND CODE_GROUP_ID = '"+KJFUtil.print(request.getParameter("CODE_GROUP_ID"))+"' \n";
        
        String orderSQL="";
        
        rEntity = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
        
        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);       
        request.setAttribute("rEntity", rEntity);

		
	}
	
}
