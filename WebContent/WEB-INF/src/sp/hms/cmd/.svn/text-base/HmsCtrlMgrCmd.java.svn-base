package sp.hms.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.hms.HmsParam;

/***************************************************************************
 * <p>Title       : 컨텐츠관리 Class</p>
 * <p>Description : 컨텐츠관리 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 컨텐츠 관리 처리한다. 
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class HmsCtrlMgrCmd implements KJFCommand {
    
    private String next;
    
    public HmsCtrlMgrCmd() {        
    }
    
    public HmsCtrlMgrCmd(String next_url) {
        next = next_url;
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        // 검색조건 설정및 체크
        HmsParam pm = checkPm(request, form);
        
        loadCondition(request, pm);
        
        loadList(request, pm);
        
        request.setAttribute("pm", pm); 
        
        return next;
    }
    
    
    /***************************************************************************
     * 검색조건 및 초기데이타 로드
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadCondition(HttpServletRequest request, HmsParam pm) throws Exception {        
        
        // 검색 코드  시작
        String sql = 
            " SELECT CODE, CODE_NAME " +
            "   FROM PT_HMS_COM_CODE " +
            "  WHERE CODE_GROUP = '999'" +
            "    AND CODE <> '000'" +
            "  ORDER BY ORDER_NUM";

        Vector v_scSLCT_GUBUN   = KJFSelectOPS.getSel(sql);
        request.setAttribute("v_scSLCT_GUBUN", v_scSLCT_GUBUN);
    }
    
    
    private void loadList(HttpServletRequest request, HmsParam pm) throws Exception {   
        
        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        String scSLCT_GUBUN = KJFUtil.print(pm.getScSLCT_GUBUN());
        String scTEXTVALUE  = KJFUtil.print(pm.getScTEXTVALUE());
        
        int intCNT = 1;
        
        StringBuffer selectSQL = new StringBuffer();
        selectSQL.append(" SELECT                   \n");
        selectSQL.append("        MENU_ID,          \n");
        selectSQL.append("        L_MENU,           \n"); 
        selectSQL.append("        M_MENU,           \n");
        selectSQL.append("        S_MENU,           \n");
        selectSQL.append("        TITLE,            \n");
        selectSQL.append("        URL,              \n");
        selectSQL.append("        WRT_ID,           \n");
        selectSQL.append("        UPD_DT,           \n");
        selectSQL.append("        INS_DT            \n");
        selectSQL.append("   FROM PT_HMS_MST        \n");        
        
        // ****** 페이징 관련 cnt SQL... *******
        StringBuffer cntSQL = new StringBuffer();
        cntSQL.append(" SELECT COUNT(*)  CNT    \n");
        cntSQL.append("   FROM PT_HMS_MST       \n");
        // ****** 페이징 관련 cnt SQL... 끝 ******* 

        StringBuffer whereSQL = new StringBuffer();
        whereSQL.append("  WHERE    1=1  \n");

        
        // 검색 조건 처리
        if ( !KJFUtil.isEmpty(scSLCT_GUBUN) && !KJFUtil.isEmpty(scTEXTVALUE)  ){
            
            if (scSLCT_GUBUN.equals("001")) {
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                whereSQL.append(" AND L_MENU Like ?    \n") ;
                
            } else if (scSLCT_GUBUN.equals("002")) {
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                whereSQL.append(" AND M_MENU like ?     \n") ;
                
            } else if (scSLCT_GUBUN.equals("003")) {
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                whereSQL.append(" AND TITLE like ?     \n") ;
            }
        }

        String orderSQL = " ORDER BY MENU_ID    \n";

        /* ************************* 페이징 관련 ******************************* */
        
        // 전체 목록 수
        String totalCount="";

        // 페이지별 목록 수
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        // 현재 페이지 번호
        int nowPage = 1;
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(cntSQL.toString() + whereSQL.toString());
        totalCount=rEntity.getValue(0, "CNT");

        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);

        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* ************************* 페이징 관련 끝 **************************** */

        rEntity = rDAO.select(selectSQL.toString() + whereSQL.toString() + orderSQL, nowPage, rowPerPage);

        // 검색조건 초기값 
        request.setAttribute("pm", pm);
        request.setAttribute("rEntity", rEntity);
    }
    
    
    /**
     * 폼 체크 메소드
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     */
    private HmsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        HmsParam pm = (HmsParam)form;

        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));
        
        // 페이징 라인
        if (KJFUtil.isEmpty(pm.getRowPerPage())) {            
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }

        return pm;
    }
    
}
