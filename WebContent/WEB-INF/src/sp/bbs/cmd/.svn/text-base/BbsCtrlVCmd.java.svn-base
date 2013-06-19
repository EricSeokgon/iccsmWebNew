package sp.bbs.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.bbs.BbsParam;

/***************************************************************************
 * <p>Title       : BbsCtrlVCmd Class</p>
 * <p>Description : 게시판 관리 상세 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판의 상세내용 처리를 한다.
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class BbsCtrlVCmd implements KJFCommand {
	
	private String next;

    public BbsCtrlVCmd() {
    }
    
    public BbsCtrlVCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

        // 검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);
        
        request.setAttribute("pm", pm);

        // 수정 상태 이면 데이터  로드
        loadDetail(request);

        return next;
    }
  

    /************************************************************************
     * 상세 Data를 load
     * 
     * @param request
     * @throws Exception
     ***********************************************************************/
    private void loadDetail(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = null;
        
        String CT_ID = KJFUtil.print(request.getParameter("CT_ID"));
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" SELECT *                 \n");
        sbSQL.append("   FROM PT_BBS_COM_CT     \n");
        sbSQL.append("  WHERE CT_ID = ?         \n");
        
        rDAO.setValue(1, CT_ID);

        rEntity = rDAO.select(sbSQL.toString());

        request.setAttribute("rEntity", rEntity);
    }
    
    
    /************************************************************************
     * 검색조건 초기값 설정및 체크
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     ***********************************************************************/
    private BbsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        BbsParam pm = (BbsParam)form;
        BbsCtrlWCmd tsete = new BbsCtrlWCmd();
        tsete.execute(request, form).length();
        
        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));

        return pm;
    }

}