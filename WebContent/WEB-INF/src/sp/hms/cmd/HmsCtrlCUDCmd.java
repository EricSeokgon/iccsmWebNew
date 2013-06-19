package sp.hms.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;

import org.apache.struts.action.ActionForm;

import sp.uent.UserEnt;

public class HmsCtrlCUDCmd implements KJFCommand {
    
    private String next;
    
    public HmsCtrlCUDCmd() {
    }
    
    public HmsCtrlCUDCmd(String next_url) {
        next = next_url; 
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {       
        
        String cmd = request.getParameter("cmd");     
        
        if (cmd.equals("HmsCtrlC")) {          // HTML ����
            insertExe(request);
            
        } else if (cmd.equals("HmsCtrlU")) {   // HTML ����
            updateExe(request);
            
        } else if (cmd.equals("HmsCtrlD")) {   // HTML ����
            deleteExe(request); 
            
        } else if (cmd.equals("HmsHistoryD")) { // HTML �����丮 ����
            deleteHistoryExe(request);
        
        } else if (cmd.equals("HmsHistoryU")) { // HTML �����丮 ������� ����            
            changeAllHistoruUseCode(request);
            changeHistoruUseCode(request);
        }

        return next;
    }
    
    
    /************************************************************************
     * HTML ��� ó�� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     ***********************************************************************/
    private void insertExe(HttpServletRequest request) throws Exception {    
        
        insertHms_MstExe(request); // HTML������ ���
        insertHistoryExe(request); // HTML�����丮 ���
    }
    
    
    /************************************************************************
     * HTML������ ��� ó�� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     ***********************************************************************/
    private void insertHms_MstExe(HttpServletRequest request) throws Exception {
        ReportDAO rDAO = new ReportDAO();
        
        UserEnt userEnt = (UserEnt)request.getSession().getAttribute("user");        
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" INSERT INTO PT_HMS_MST   (   \n");
        sbSQL.append("       MENU_ID,               \n");
        sbSQL.append("       L_MENU,                \n");
        sbSQL.append("       M_MENU,                \n");
        sbSQL.append("       S_MENU,                \n");
        sbSQL.append("       TITLE,                 \n");
        
        sbSQL.append("       URL,                   \n");
        sbSQL.append("       WRT_ID,                \n");
        sbSQL.append("       WRT_NM,                \n");
        sbSQL.append("       UPD_DT,                \n");
        sbSQL.append("       INS_DT                 \n");
        sbSQL.append("       )                      \n");
        
        sbSQL.append("   values (                   \n");
        sbSQL.append("            ?,?,?,?,?,        \n");
        sbSQL.append("            ?,?,?,?,?         \n");
        sbSQL.append("          )                   \n");   

        int i = 0;
    
        rDAO.setValue(++i, request.getParameter("MENU_ID"));
        rDAO.setValue(++i, request.getParameter("L_MENU"));
        rDAO.setValue(++i, request.getParameter("M_MENU"));
        rDAO.setValue(++i, request.getParameter("S_MENU"));
        rDAO.setValue(++i, request.getParameter("TITLE"));
        
        rDAO.setValue(++i, request.getParameter("URL"));        
        rDAO.setValue(++i, userEnt.getUSER_ID());
        rDAO.setValue(++i, userEnt.getUSER_NAME());
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));

        rDAO.execute(sbSQL.toString());
    }  
    
    
    /************************************************************************
     * HTML ���� ó�� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     ***********************************************************************/
    private void updateExe(HttpServletRequest request) throws Exception {
        
        
        String CHANGE_MODE = request.getParameter("CHANGE_MODE");
        
        // �⺻���� ����
        if (CHANGE_MODE.equals("B")) {
            updateHms_MstExe(request);          // HTML������ ����
            
        //  HTML ���� 
        } else if (CHANGE_MODE.equals("H")) {
            changeAllHistoruUseCode(request);   // HTML�����丮 ������� ����
            insertHistoryExe(request);          // HTML�����丮 ���
            
        // �⺻���� + HTML ���� 
        } else if(CHANGE_MODE.equals("ALL")) {
            updateHms_MstExe(request);          // HTML������ ����
            changeAllHistoruUseCode(request);   // HTML�����丮 ������� ����
            insertHistoryExe(request);          // HTML�����丮 ���
        }
        
    }
    
    
    /************************************************************************
     * HTML������ ���� ó�� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     ***********************************************************************/
    private void updateHms_MstExe(HttpServletRequest request) throws Exception {
        
        String MENU_ID = request.getParameter("MENU_ID");
        
        ReportDAO rDAO = new ReportDAO();
                
        UserEnt userEnt = (UserEnt)request.getSession().getAttribute("user");
        
        StringBuffer sbSQL = new StringBuffer();         
        sbSQL.append(" UPDATE PT_HMS_MST SET    \n");
        
        sbSQL.append("        L_MENU = ?,       \n");
        sbSQL.append("        M_MENU = ?,       \n");      
        sbSQL.append("        S_MENU = ?,       \n"); 
        sbSQL.append("        TITLE = ?,        \n");                
        sbSQL.append("        URL = ?,          \n");
        
        sbSQL.append("        WRT_ID = ?,       \n");
        sbSQL.append("        WRT_NM = ?,       \n");
        sbSQL.append("        UPD_DT = ?        \n");
        
        sbSQL.append("  WHERE MENU_ID = ?       \n");

        int i = 0;

        rDAO.setValue(++i, request.getParameter("L_MENU"));
        rDAO.setValue(++i, request.getParameter("M_MENU"));
        rDAO.setValue(++i, request.getParameter("S_MENU"));
        rDAO.setValue(++i, request.getParameter("TITLE"));
        rDAO.setValue(++i, request.getParameter("URL"));
        
        rDAO.setValue(++i, userEnt.getUSER_ID());
        rDAO.setValue(++i, userEnt.getUSER_NAME());
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));
        
        rDAO.setValue(++i, MENU_ID);

        rDAO.execute(sbSQL.toString());
    }
    
    
    /**
     * HTML �����丮 ��� ó�� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     */
    private void insertHistoryExe(HttpServletRequest request) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        UserEnt userEnt = (UserEnt)request.getSession().getAttribute("user");        

        String MENU_ID = request.getParameter("MENU_ID");        
        String SEQ     = KJFDBUtil.getMaxID("SEQ", "PT_HMS_HISTORY");       
        String Version = getVersion(MENU_ID);
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" INSERT INTO PT_HMS_HISTORY (     \n");
        sbSQL.append("       MENU_ID,                   \n");
        sbSQL.append("       SEQ,                       \n");
        sbSQL.append("       VERSION,                   \n");        
        sbSQL.append("       CONTENT,                   \n");
        
        sbSQL.append("       USE_YN,                    \n");
        sbSQL.append("       WRT_ID,                    \n");
        sbSQL.append("       WRT_NM,                    \n");
        sbSQL.append("       INS_DT                     \n");
        sbSQL.append("       )                          \n");
        
        sbSQL.append("   values (                       \n");
        sbSQL.append("            ?,?,?,?,              \n");
        sbSQL.append("            ?,?,?,?               \n");
        sbSQL.append("          )                       \n");   

        int i = 0;
    
        rDAO.setValue(++i, MENU_ID);
        rDAO.setValue(++i, SEQ);        
        rDAO.setValue(++i, Version);
        rDAO.setValue(++i, request.getParameter("CONTENT"));      
        
        rDAO.setValue(++i, "Y");
        rDAO.setValue(++i, userEnt.getUSER_ID());
        rDAO.setValue(++i, userEnt.getUSER_NAME());
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));

        rDAO.execute(sbSQL.toString());
    }
    
    
    /**
     * HTML ���� ó�� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     */
    private void deleteExe(HttpServletRequest request) throws Exception {
        
        String chk[] = request.getParameterValues("chk");        
        
        for (int i = 0; i < chk.length; i++) {
            deleteHistoryAll(chk[i]);  // HTML�����丮 ����
            deleteHms_Mst(chk[i]);     // HTML������ ����
        }
    }
    
    
    /**
     * HTML ������ ���� ó�� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     */
    private void deleteHms_Mst(String menu_id) throws Exception {      
        
        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("  DELETE                      \n");
        sbSQL.append("    FROM PT_HMS_MST           \n");
        sbSQL.append("   WHERE MENU_ID = ?          \n");
       
        rDAO.setValue(1, menu_id);
        
        rDAO.execute(sbSQL.toString());
    }
    
    
    /**
     * HTML �����丮 ���� ó�� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     */
    private void deleteHistoryExe(HttpServletRequest request) throws Exception {
        
        String MENU_ID = request.getParameter("MENU_ID");    
        String chk[] = request.getParameterValues("chk");        
        
        for (int i = 0; i < chk.length; i++) {
            deleteHistory(MENU_ID, chk[i]);       // �����丮 ����
        }        
    }
    
    
    
    /**
     * HTML �����丮 ����
     * @param menu_id
     * @param seq
     * @throws Exception
     */
    private void deleteHistory(String menu_id, String seq) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("  DELETE                      \n");
        sbSQL.append("    FROM PT_HMS_HISTORY       \n");
        sbSQL.append("   WHERE MENU_ID = ?          \n");
        sbSQL.append("     AND SEQ = ?          \n");  
       
        rDAO.setValue(1, menu_id);
        rDAO.setValue(2, seq);       
        
        rDAO.execute(sbSQL.toString());
    }
    
    
    /**
     * HTML �����丮 ����
     * 
     * @param request
     * @throws Exception
     */
    private void deleteHistoryAll(String menu_id) throws Exception {
                
        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("  DELETE                      \n");
        sbSQL.append("    FROM PT_HMS_HISTORY       \n");
        sbSQL.append("   WHERE MENU_ID = ?          \n");
       
        rDAO.setValue(1, menu_id);
        
        rDAO.execute(sbSQL.toString());
    }
    
    
    /**
     * HTML �����丮 ���������� �������� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     */
    private String getVersion(String MENU_ID) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        ReportEntity rEntity = null;
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("  SELECT NVL( MAX( to_number(VERSION) ), 1 ) + 0.1 MAX_ID    \n");
        sbSQL.append("    FROM PT_HMS_HISTORY       \n");
        sbSQL.append("   WHERE MENU_ID = ?          \n");
        
        rDAO.setValue(1, MENU_ID);
        
        rEntity = rDAO.select(sbSQL.toString());

        return rEntity.getValue(0, "MAX_ID");
    }
    
    
    /**
     * HTML �����丮 ��ü ������ ���� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     */
    private void changeAllHistoruUseCode(HttpServletRequest request) throws Exception {
        
        String MENU_ID = request.getParameter("MENU_ID");
        
        ReportDAO rDAO = new ReportDAO();
      
        StringBuffer sbSQL = new StringBuffer();         
        sbSQL.append(" UPDATE PT_HMS_HISTORY SET    \n");        
        sbSQL.append("        USE_YN  = ?           \n");        
        sbSQL.append("  WHERE MENU_ID = ?           \n");

        int i = 0;

        rDAO.setValue(++i, "N");
        rDAO.setValue(++i, MENU_ID);
        
        rDAO.execute(sbSQL.toString());
    }   
    
    
    /**
     * HTML �����丮 ��ü ������ ���� �޼ҵ� 
     * 
     * @param HttpServletRequest
     * @return done
     */
    private void changeHistoruUseCode(HttpServletRequest request) throws Exception {
        ReportDAO rDAO = new ReportDAO();
        
        String MENU_ID = request.getParameter("MENU_ID");     
        String SEQ     = request.getParameter("SEQ");  
      
        StringBuffer sbSQL = new StringBuffer();         
        sbSQL.append(" UPDATE PT_HMS_HISTORY SET    \n");        
        sbSQL.append("        USE_YN  = ?           \n");        
        sbSQL.append("  WHERE MENU_ID = ?           \n");
        sbSQL.append("    AND SEQ = ?               \n");

        int i = 0;

        rDAO.setValue(++i, "Y");
        rDAO.setValue(++i, MENU_ID);
        rDAO.setValue(++i, SEQ);
        
        rDAO.execute(sbSQL.toString());
    }  
    
}
