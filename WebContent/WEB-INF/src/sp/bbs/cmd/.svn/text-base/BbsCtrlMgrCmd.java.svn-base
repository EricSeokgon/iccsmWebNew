package sp.bbs.cmd;

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

import sp.bbs.BbsParam;

/***************************************************************************
 * <p>Title       : BbsCtrlMgrCmd Class</p>
 * <p>Description : 게시판관리 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판 관리 처리한다. 
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class BbsCtrlMgrCmd implements KJFCommand {
	
	private String next;

    public BbsCtrlMgrCmd() {
    }
    
    public BbsCtrlMgrCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

        // 검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);
        
        // 검색조건 및 초기데이타 로드
        loadCondition(request);        

        // 리스트 로드
        loadList(request, pm);

        return next;
    }


    /***************************************************************************
     * 검색조건 및 초기데이타 로드
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadCondition(HttpServletRequest request) throws Exception {

    	// 게시판 타입추가
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT CODE, CODE_NAME       \n");
        sbSQL.append("   FROM PT_BBS_COM_CODE       \n");
        sbSQL.append("  WHERE CODE_GROUP = '001'    \n");
        sbSQL.append("  ORDER BY ORDER_NUM          \n");
      
		Vector v_sc_type = KJFSelectOPS.getSel(sbSQL.toString());
		
		request.setAttribute("v_sc_type", v_sc_type);
    }   
    

    /***************************************************************************
     * 조건에 따른 list를 load
     * 
     * @param request
     * @param pm
     * @throws Exception
     **************************************************************************/
    private void loadList(HttpServletRequest request, BbsParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;

        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT                   \n");
        sbSQL.append("        CT_ID,            \n");
        sbSQL.append("        BOARD_NAME,       \n");
        sbSQL.append("        TABLE_ONE_YN,     \n");
        sbSQL.append("        (SELECT CODE_NAME FROM PT_BBS_COM_CODE WHERE CODE_GROUP = '001' AND CODE =  BOARD_TYPE) TYPE,         \n");
        sbSQL.append("        (SELECT CODE_NAME FROM PT_BBS_COM_CODE WHERE CODE_GROUP = '002' AND CODE = LIST_LEVEL)  LOGIN_YN,     \n");
        sbSQL.append("        (SELECT CODE_NAME FROM PT_BBS_COM_CODE WHERE CODE_GROUP = '002' AND CODE = WRITE_LEVEL) WRITE_YN,     \n");
        sbSQL.append("        (SELECT CODE_NAME FROM PT_BBS_COM_CODE WHERE CODE_GROUP = '002' AND CODE = ATTACH_YN)   ATTACH_YN,    \n");
        sbSQL.append("        (SELECT CODE_NAME FROM PT_BBS_COM_CODE WHERE CODE_GROUP = '002' AND CODE = REPLY_YN)    REPLY_YN,     \n");
        sbSQL.append("        (SELECT CODE_NAME FROM PT_BBS_COM_CODE WHERE CODE_GROUP = '002' AND CODE = ONE_LINE_YN) ONE_LINE_YN,  \n");
        sbSQL.append("        (SELECT CODE_NAME FROM PT_BBS_COM_CODE WHERE CODE_GROUP = '002' AND CODE = USE_YN)      USE_YN,       \n");
        sbSQL.append("        UPD_DT,           \n");
        sbSQL.append("        WRT_ID,           \n");
        sbSQL.append("        INS_DT            \n");
        sbSQL.append("   FROM PT_BBS_COM_CT     \n");        
        
        // ****** 페이징 관련 cnt SQL... *******
        StringBuffer cntSQL = new StringBuffer();
        cntSQL.append(" SELECT COUNT(*)  CNT  \n");
        cntSQL.append("   FROM PT_BBS_COM_CT  \n");
        // ****** 페이징 관련 cnt SQL... 끝 ******* 

        StringBuffer whereSQL = new StringBuffer();
        whereSQL.append("  WHERE    1=1  \n");

        if (!KJFUtil.isEmpty(pm.getScBOARD_NAME())) {
            whereSQL.append("   AND BOARD_NAME LIKE '%" + pm.getScBOARD_NAME() + "%'    \n");
        }
        
        if (!KJFUtil.isEmpty(pm.getScTYPE()) && !"000".equals(pm.getScTYPE())) {
            whereSQL.append("   AND BOARD_TYPE = '" + pm.getScTYPE()+ "'    \n");
        }

        String orderSQL = " ORDER BY  BOARD_NAME   \n";

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

        rEntity = rDAO.select(sbSQL.toString() + whereSQL.toString() + orderSQL, nowPage, rowPerPage);

        // 검색조건 초기값 
        request.setAttribute("pm", pm);
        request.setAttribute("rEntity", rEntity);
    }
    
    
    /***************************************************************************
     * 검색조건 초기값 설정및 체크
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     **************************************************************************/
    private BbsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        BbsParam pm = (BbsParam)form;

        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));

        // 페이징 라인
        if (KJFUtil.isEmpty(pm.getRowPerPage())) {
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }

        return pm;
    }
}