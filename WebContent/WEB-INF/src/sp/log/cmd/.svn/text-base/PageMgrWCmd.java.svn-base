/*
2006. 8. 4오후 4:40:39
*/

package sp.log.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.log.PageParam;


public class PageMgrWCmd implements KJFCommand {
	
	private String next;
	
    public PageMgrWCmd() {
    }
    
    public PageMgrWCmd(String next_url) {
    	next = next_url; 
    }
	
	public String execute(HttpServletRequest req, ActionForm form) throws Exception {

		PageParam pm = checkFrm(form);
		loadCondition(req);

		req.setAttribute("pm",pm);
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
		
		String query = "SELECT CODE_GROUP, CODE_NAME FROM PT_PAGE_CODE WHERE CODE = 000 UNION SELECT '0000', '신규그룹코드' FROM DUAL ORDER BY CODE_GROUP ASC";
		Vector v_code_group = KJFSelectOPS.getSel(query);
		request.setAttribute("v_code_group",v_code_group);
		
	}

}
