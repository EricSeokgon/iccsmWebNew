package sp.mem.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.mem.MemParam;

public class MemHomePageMgrCUDCmd implements KJFCommand {
	
	private String next;

    public MemHomePageMgrCUDCmd() {
    }
    
    public MemHomePageMgrCUDCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

    	MemParam pm = checkFrm(form);
    	
    	String cmd = request.getParameter("cmd");
    	
    	if (cmd.equals("MemHomePageSecedeU")) {    // ȸ�� ����Ż��
    	    updateSecedeExe(request,pm);
    		
    	} else if (cmd.equals("MemHomePageUseU")) { // ȸ�� ��������(�������)
    		updateUseExe(request,pm);
    		
    	} else if (cmd.equals("MemHomePageMgrD")) { // ȸ�� ���� ��������
    		deleteExe(request);
    	}

        return next;
    }



    /**
     *  ȸ�� ����Ż��
     * @param HttpServletRequest
     * @return
     */
    private void updateSecedeExe(HttpServletRequest request, MemParam pm) throws Exception {

        String user_id = request.getParameter("USER_ID");
        
        if (!KJFUtil.isEmpty(user_id)) {
            updateUserInfoExe(request, user_id);     // ����� ����Ż�� ó��
            deleteConstructionExe(request, user_id); // ������ ���� ����
            deleteUseBeforeExe(request, user_id);    // ����� ���� ����
            deleteFavorite(request, user_id);        // ���ְ��� â�� ����
        }
    }


    /**
     * ȸ�� ��������
     * @param HttpServletRequest
     * @return
     */
    private void updateUseExe(HttpServletRequest request,MemParam pm) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        String user_id = request.getParameter("USER_ID");
        
        int i = 1;
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" UPDATE PT_HOM_USER       \n");
        sbSQL.append("    SET USE_YN = ?        \n");
        sbSQL.append("  WHERE USER_ID = ?       \n");
       
        rDAO.setValue(i++, "Y");
        rDAO.setValue(i++, user_id);

        rDAO.execute(sbSQL.toString());
     
    }


    /**
     * ȸ�� ���� ��������
     * @param HttpServletRequest
     * @return
     * */
    private void deleteExe(HttpServletRequest request) throws Exception {
        
        String user_id = request.getParameter("USER_ID");
        
        if (!KJFUtil.isEmpty(user_id)) {
            deleteUserInfoExe(request, user_id);     // ����� ���� ����
            deleteConstructionExe(request, user_id); // ������ ���� ����
            deleteUseBeforeExe(request, user_id);    // ����� ���� ����
            deleteFavorite(request, user_id);        // ���ְ��� â�� ����
        }
    }
    
    /**
     * ȸ�� ���� Ż��
     * 
     * @param request
     * @throws Exception
     */
     private void updateUserInfoExe(HttpServletRequest request, String user_id) throws Exception {
         
         ReportDAO rDAO = new ReportDAO();
         
         int i = 1;
         
         StringBuffer sbSQL = new StringBuffer();        
         sbSQL.append(" UPDATE PT_HOM_USER       \n");
         sbSQL.append("    SET USE_YN = ?        \n");
         sbSQL.append("  WHERE USER_ID = ?       \n");
        
         rDAO.setValue(i++, "C");
         rDAO.setValue(i++, user_id);

         rDAO.execute(sbSQL.toString());    
     }
     
     
    /**
     * ȸ�� ���� ����
     * 
     * @param request
     * @throws Exception
     */
     private void deleteUserInfoExe(HttpServletRequest request, String user_id) throws Exception {
         
         ReportDAO rDAO = new ReportDAO();
         
         int i = 1;
         
         StringBuffer sbSQL = new StringBuffer();        
         sbSQL.append(" DELETE                  \n");
         sbSQL.append("   FROM PT_HOM_USER      \n");
         sbSQL.append("  WHERE USER_ID = ?      \n");
        
         rDAO.setValue(i++, user_id);

         rDAO.execute(sbSQL.toString());     
     }
    
    
    /**
     * ����� ��������� ���� ����
     * 
     * @param request
     * @throws Exception
     */
     private void deleteConstructionExe(HttpServletRequest request, String user_id) throws Exception {
         
         ReportDAO rDAO = new ReportDAO();
         
         int i = 1;
         
         StringBuffer sbSQL = new StringBuffer();        
         sbSQL.append("  DELETE                         \n");
         sbSQL.append("    FROM PT_HOME_CONSTRUCTION    \n");
         sbSQL.append("   WHERE USER_ID = ?             \n");
       
         rDAO.setValue(i++, user_id);

         rDAO.execute(sbSQL.toString());     
     }
     
     
     /**
      * ����� ������˻��� ���� ����
      * 
      * @param request
      * @throws Exception
      */
      private void deleteUseBeforeExe(HttpServletRequest request, String user_id) throws Exception {
          
          ReportDAO rDAO = new ReportDAO();
          
          int i = 1;
          
          StringBuffer sbSQL = new StringBuffer();        
          sbSQL.append("  DELETE                         \n");
          sbSQL.append("    FROM PT_HOME_USEBEFORE       \n");
          sbSQL.append("   WHERE USER_ID = ?             \n");
        
          rDAO.setValue(i++, user_id);

          rDAO.execute(sbSQL.toString());     
      }
      
      
      /**
       * ����� ������˻��� ���� ����
       * 
       * @param request
       * @throws Exception
       */
      private void deleteFavorite(HttpServletRequest request, String user_id) throws Exception {
           
           ReportDAO rDAO = new ReportDAO();
           
           int i = 1;
           
           StringBuffer sbSQL = new StringBuffer();        
           sbSQL.append("  DELETE                       \n");
           sbSQL.append("    FROM PT_HOM_FAVORITE       \n");
           sbSQL.append("   WHERE USER_ID = ?           \n");
         
           rDAO.setValue(i++, user_id);

           rDAO.execute(sbSQL.toString());     
      }
 
      
      private MemParam checkFrm(ActionForm form) throws Exception {

          MemParam frm = (MemParam)form;

          return frm;
      }

}