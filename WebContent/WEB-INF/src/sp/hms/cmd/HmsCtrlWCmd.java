package sp.hms.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.hms.HmsParam;

public class HmsCtrlWCmd implements KJFCommand {
    
    private String next;
    
    public HmsCtrlWCmd() {
        
    }
    
    public HmsCtrlWCmd(String next_url) {
        next = next_url;
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        // ���  ��
        String mode = request.getParameter("mode");       
        
        
        
        // �˻����� ������ üũ
        HmsParam pm = checkPm(request, form);
        request.setAttribute("pm", pm); 
        
        // ���� ���� �̸� ������  �ε�
        if ("M".equals(mode)) {
            loadDetail(request, pm);
            loadHistoryInfo(request, pm);
            loadHistoryList(request, pm);
            
        } 
        
        return next;
    }  
    
    
    /***************************************************************************
     * Data�� load
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadDetail(HttpServletRequest request, HmsParam pm) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = new ReportEntity();
        
        String MENU_ID = request.getParameter("MENU_ID");        
        
        //SELECT �׸� SQL...
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT               \n");
        sbSQL.append("        MENU_ID,      \n");
        sbSQL.append("        L_MENU,       \n");
        sbSQL.append("        M_MENU,       \n");
        sbSQL.append("        S_MENU,       \n");
        sbSQL.append("        TITLE,        \n");
        sbSQL.append("        URL,          \n");
        sbSQL.append("        WRT_ID,       \n");
        sbSQL.append("        WRT_NM,       \n");
        sbSQL.append("        UPD_DT,       \n");
        sbSQL.append("        INS_DT        \n");
        sbSQL.append("   FROM PT_HMS_MST    \n");
        sbSQL.append("  WHERE MENU_ID = ?   \n");

        rDAO.setValue(1, MENU_ID);
        
        rEntity = rDAO.select(sbSQL.toString());
        
        request.setAttribute("rEntity", rEntity);
    }    
    
    /***************************************************************************
     * Data�� load
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadHistoryInfo(HttpServletRequest request, HmsParam pm) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity hEntity = new ReportEntity();
        
        String MENU_ID = request.getParameter("MENU_ID");        
    
        //SELECT �׸� SQL...
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT                   \n");
        sbSQL.append("        MENU_ID,          \n");
        sbSQL.append("        SEQ,              \n");
        sbSQL.append("        VERSION,          \n");
        sbSQL.append("        CONTENT,          \n");
        sbSQL.append("        USE_YN,           \n");
        sbSQL.append("        WRT_ID,           \n");
        sbSQL.append("        WRT_NM,           \n");
        sbSQL.append("        INS_DT            \n");
        sbSQL.append("   FROM PT_HMS_HISTORY    \n");
        sbSQL.append("  WHERE MENU_ID = ?       \n");
        sbSQL.append("    AND USE_YN  = ?       \n");
        sbSQL.append("  ORDER BY INS_DT DESC    \n");
        
        rDAO.setValue(1, MENU_ID);
        rDAO.setValue(2, "Y");
        
        hEntity = rDAO.select(sbSQL.toString());

        request.setAttribute("hEntity", hEntity);
    }
    
    
    /***************************************************************************
     * Data�� load
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadHistoryList(HttpServletRequest request, HmsParam pm) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity hlstEntity = new ReportEntity();
        
        String MENU_ID = request.getParameter("MENU_ID");        
    
        //SELECT �׸� SQL...
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT                   \n");
        sbSQL.append("        MENU_ID,          \n");
        sbSQL.append("        SEQ,              \n");
        sbSQL.append("        VERSION,          \n");
        sbSQL.append("        USE_YN,           \n");
        sbSQL.append("        WRT_ID,           \n");
        sbSQL.append("        WRT_NM,           \n");
        sbSQL.append("        INS_DT            \n");
        sbSQL.append("   FROM PT_HMS_HISTORY    \n");
        sbSQL.append("  WHERE MENU_ID = ?       \n");
        sbSQL.append("  ORDER BY INS_DT DESC    \n");
        
        rDAO.setValue(1, MENU_ID);
        
        hlstEntity = rDAO.select(sbSQL.toString());

        request.setAttribute("hlstEntity", hlstEntity);
    }
 
    
    /**
     * �� üũ �޼ҵ�
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     */
    private HmsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        HmsParam pm = (HmsParam)form;

        // �Ķ���� �����
        KJFLog.debug(pm.toString(request));
        
        // ����¡ ����
        if (KJFUtil.isEmpty(pm.getRowPerPage())) {            
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }

        return pm;
    }
}
