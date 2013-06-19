package sp.hms.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import org.apache.struts.action.ActionForm;

public class HmsPreviewCmd implements KJFCommand {
    
    private String next;
    
    public HmsPreviewCmd() {        
    }
    
    public HmsPreviewCmd(String next_url) {
        next = next_url;
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        loadHmsContent(request);
        
        return next;
    }    
    
    /***************************************************************************
     * Data¸¦ load
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadHmsContent(HttpServletRequest request) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = new ReportEntity();
        
        String MENU_ID = request.getParameter("MENU_ID");   
        String SEQ     = request.getParameter("SEQ");
    
        int i = 1;
        
        //SELECT Ç×¸ñ SQL...
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT                   \n");
        sbSQL.append("        MENU_ID,          \n");
        sbSQL.append("        SEQ,              \n");
        sbSQL.append("        VERSION,          \n");
        sbSQL.append("        USE_YN,           \n");
        sbSQL.append("        CONTENT,          \n");
        sbSQL.append("        WRT_ID,           \n");
        sbSQL.append("        INS_DT            \n");
        sbSQL.append("   FROM PT_HMS_HISTORY    \n");
        sbSQL.append("  WHERE MENU_ID = ?       \n");
        sbSQL.append("    AND SEQ = ?           \n");
        
        rDAO.setValue(i++, MENU_ID);
        rDAO.setValue(i++, SEQ);
        
        rEntity = rDAO.select(sbSQL.toString());

        request.setAttribute("rEntity", rEntity);
    }
}
