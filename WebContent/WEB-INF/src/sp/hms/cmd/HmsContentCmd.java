package sp.hms.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.hms.HmsParam;

/***************************************************************************
 * <p>Title       : HmsContentCmd Class</p>
 * <p>Description : HTML 코드 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : HTML 코드 처리를 한다. 
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class HmsContentCmd implements KJFCommand {
    
    public HmsContentCmd() {        
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception { 
             
        // 검색조건 설정및 체크
        HmsParam pm = checkPm(request, form);               
        
        ReportEntity rEntity = loadContent(request, pm);
               
        String next = "/hms/HmsK.jsp";
        
        request.setAttribute("rEntity", rEntity);     
        request.setAttribute("pm", pm);
        
        return next;
    }
    
    
    /**
     * HTML 컨텐츠 정보를 불러온다
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     */
    private ReportEntity loadContent(HttpServletRequest request, HmsParam form) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();       
        
        ReportEntity rEntity = null;
        
        int i = 1;
        
        String MENU_ID = KJFUtil.print(request.getParameter("menu_id"));
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" SELECT               \n");
        sbSQL.append("        A.MENU_ID,    \n");
        sbSQL.append("        A.URL,        \n");
        sbSQL.append("        B.SEQ,        \n");
        sbSQL.append("        B.CONTENT,    \n");
        sbSQL.append("        B.VERSION     \n");
        sbSQL.append("   FROM PT_HMS_MST A, PT_HMS_HISTORY B    \n");
        sbSQL.append("  WHERE A.MENU_ID = ?                     \n");
        sbSQL.append("    AND A.MENU_ID = B.MENU_ID             \n");
        sbSQL.append("    AND B.USE_YN = ?                      \n");
        
        rDAO.setValue(i++, MENU_ID); 
        rDAO.setValue(i++, "Y"); 
        
        rEntity = rDAO.select(sbSQL.toString());
        
        return rEntity;
    }
    
    /**
     * 검색조건 초기값 설정및 체크
     * 
     * @param request
     * @param form
     * @return BbsParam
     * @throws Exception
     */
    private HmsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        HmsParam pm = (HmsParam) form;

        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));

        return pm;
    }    
}
