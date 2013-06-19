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
    	
    	if (cmd.equals("MemHomePageSecedeU")) {    // 회원 강제탈퇴
    	    updateSecedeExe(request,pm);
    		
    	} else if (cmd.equals("MemHomePageUseU")) { // 회원 정보수정(사용유무)
    		updateUseExe(request,pm);
    		
    	} else if (cmd.equals("MemHomePageMgrD")) { // 회원 정보 영구삭제
    		deleteExe(request);
    	}

        return next;
    }



    /**
     *  회원 강제탈퇴
     * @param HttpServletRequest
     * @return
     */
    private void updateSecedeExe(HttpServletRequest request, MemParam pm) throws Exception {

        String user_id = request.getParameter("USER_ID");
        
        if (!KJFUtil.isEmpty(user_id)) {
            updateUserInfoExe(request, user_id);     // 사용자 강제탈퇴 처리
            deleteConstructionExe(request, user_id); // 착공전 정보 삭제
            deleteUseBeforeExe(request, user_id);    // 사용전 정보 삭제
            deleteFavorite(request, user_id);        // 자주가는 창고 삭제
        }
    }


    /**
     * 회원 정보수정
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
     * 회원 정보 영구삭제
     * @param HttpServletRequest
     * @return
     * */
    private void deleteExe(HttpServletRequest request) throws Exception {
        
        String user_id = request.getParameter("USER_ID");
        
        if (!KJFUtil.isEmpty(user_id)) {
            deleteUserInfoExe(request, user_id);     // 사용자 정보 삭제
            deleteConstructionExe(request, user_id); // 착공전 정보 삭제
            deleteUseBeforeExe(request, user_id);    // 사용전 정보 삭제
            deleteFavorite(request, user_id);        // 자주가는 창고 삭제
        }
    }
    
    /**
     * 회원 강제 탈퇴
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
     * 회원 정보 삭제
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
     * 사용자 착공전등록 정보 삭제
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
      * 사용자 사용전검사등록 정보 삭제
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
       * 사용자 사용전검사등록 정보 삭제
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