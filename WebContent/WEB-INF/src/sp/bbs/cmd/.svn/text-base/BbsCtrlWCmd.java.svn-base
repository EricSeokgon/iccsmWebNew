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
 * <p>Title       : BbsCtrlWCmd Class</p>
 * <p>Description : 게시판 관리 등록,수정 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE :  게시판 관리 등록,수정 처리를 한다.
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class BbsCtrlWCmd implements KJFCommand {

	private String next;

    public BbsCtrlWCmd() {
    }
    
    public BbsCtrlWCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

    	// 모드  값
    	String mode = request.getParameter("mode");

        // 검색조건 및 초기데이타 로드
        loadCondition(request);

        // 검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);
        
        request.setAttribute("pm", pm);

        // 수정 상태 이면 데이터  로드
        if ("M".equals(mode)) {
        	loadDetail(request);
        }

        return next;
    }


   /***************************************************************************
    * 검색조건 및 초기데이타 로드
    * 
    * @param request
    * @throws Exception
    **************************************************************************/
    private void loadCondition(HttpServletRequest request) throws Exception {

    	String sql = 
             " SELECT CODE, CODE_NAME        \n" +
			 "   FROM PT_BBS_COM_CODE        \n" +
			 "  WHERE CODE_GROUP = '001'     \n" +
			 "  ORDER BY ORDER_NUM";

    	String sql1 = 
             " SELECT CODE, CODE_NAME       \n" +
             "   FROM PT_BBS_COM_CODE       \n" +
             "  WHERE CODE_GROUP = '002'    \n" +
             "    AND CODE != '000'         \n" +
             "  ORDER BY ORDER_NUM";

		Vector v_sc_type = KJFSelectOPS.getSel(sql);
		request.setAttribute("v_sc_type", v_sc_type);

		Vector v_sc_use_yn = KJFSelectOPS.getSel(sql1);
		request.setAttribute("v_sc_use_yn", v_sc_use_yn);
    }
    

    /***************************************************************************
     * Data를 load
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadDetail(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = new ReportEntity();
        
        String CT_ID = request.getParameter("CT_ID");

        //SELECT 항목 SQL...
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT                       \n");
        sbSQL.append("        CT_ID,                \n");
        sbSQL.append("        BOARD_NAME,           \n");
        sbSQL.append("        BOARD_URL,            \n");
        sbSQL.append("        BOARD_CATEGORY,       \n");        
        sbSQL.append("        BOARD_TYPE,           \n");
        sbSQL.append("        BOARD_SKIN,           \n");
        sbSQL.append("        BOARD_WIDTH,          \n");
        sbSQL.append("        BOARD_ALIGN,          \n");
        sbSQL.append("        BBS_OWNER,            \n");
        sbSQL.append("        BBS_GROUP,            \n");
        sbSQL.append("        BBS_DEPTH,            \n");
        sbSQL.append("        CUT_TITLE,            \n");
        sbSQL.append("        ROWPERPAGE,           \n");
        sbSQL.append("        NEW_DAY,              \n");
        sbSQL.append("        TITLE_WRT_YN,         \n");
        sbSQL.append("        TITLE_DATE_YN,        \n");
        sbSQL.append("        TITLE_HIT_YN,         \n");
        sbSQL.append("        TITLE_IP_YN,          \n");
        sbSQL.append("        HEADER_HTML,          \n");
        sbSQL.append("        MAIN_HTML,            \n");
        sbSQL.append("        BOTTOM_HTML,          \n");
        sbSQL.append("        LIST_LEVEL,           \n");
        sbSQL.append("        READ_LEVEL,           \n");
        sbSQL.append("        WRITE_LEVEL,          \n");
        sbSQL.append("        ATTACH_YN,            \n");
        sbSQL.append("        FILE_SIZE,            \n");
        sbSQL.append("        ATT_NUM,              \n");
        sbSQL.append("        REPLY_YN,             \n");
        sbSQL.append("        ONE_LINE_YN,          \n");
        sbSQL.append("        SECRET_YN,            \n");
        sbSQL.append("        USE_YN,               \n");
        sbSQL.append("        DIV_USE_YN,           \n");
        sbSQL.append("        SD_DIV_YN,            \n");
        sbSQL.append("        SGG_DIV_YN,           \n");
        sbSQL.append("        VIEW_LIST_YN,         \n");
        sbSQL.append("        ONE_ONE_YN,           \n");
        sbSQL.append("        FILTER,               \n");
        sbSQL.append("        TABLE_ONE_YN,         \n");
        sbSQL.append("        SUBJ_1,               \n");
        sbSQL.append("        SUBJ_2,               \n");
        sbSQL.append("        SUBJ_3,               \n");
        sbSQL.append("        SUBJ_4,               \n");
        sbSQL.append("        SUBJ_5,               \n");
        sbSQL.append("        SUBJ_6,               \n");
        sbSQL.append("        SUBJ_7,               \n");
        sbSQL.append("        SUBJ_8,               \n");
        sbSQL.append("        SUBJ_9,               \n");
        sbSQL.append("        SUBJ_10,              \n");
        sbSQL.append("        UPD_DT,               \n");
        sbSQL.append("        WRT_ID,               \n");
        sbSQL.append("        PUBLIC_DIV_YN,        \n");
        sbSQL.append("        INS_DT                \n");        
        sbSQL.append("   FROM PT_BBS_COM_CT         \n");
        sbSQL.append("  WHERE CT_ID = ?             \n");

        rDAO.setValue(1, CT_ID);
        
        rEntity = rDAO.select(sbSQL.toString());

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
        if (KJFUtil.isEmpty(pm.getRowPerPage())){

            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }

        return pm;
    }
}