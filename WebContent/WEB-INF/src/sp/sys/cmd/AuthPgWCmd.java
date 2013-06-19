package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.SuperToDB;

import org.apache.struts.action.ActionForm;

public class AuthPgWCmd extends SuperToDB  implements KJFCommand {

	private String next;
	
    public AuthPgWCmd() {
    }
    
    public AuthPgWCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

    	// ���Ѻ� ���α׷� �� ����ڰ��� �ӽ����̺� �����͸� ���� ������̺� ����
    	setRealTable(request);
        return next;
        
    }
    
    /**
     * ���Ѻ� ���α׷����� �ӽ����̺� �����͸� ���� ������̺� ����
     * @param HttpServletRequest
     * @return
     */
    public void setRealTable(HttpServletRequest request ) throws Exception{

	    ReportDAO    rDAO        = new ReportDAO();	    
    	String sql = null;
		
		sql = "DELETE FROM PT_AUTH_PG";
		rDAO.execute(sql);
		
		sql = "INSERT INTO PT_AUTH_PG SELECT * FROM PT_AUTH_PG_TEMP";  			
		rDAO.execute(sql);

    }
}
