package sp.bbs.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import kjf.util.LoginException;

import org.apache.struts.action.ActionForm;

import sp.bbs.BbsParam;
import sp.bbs.BbsSetConf;
import sp.bbs.StatusEnt;

/**
 * <p>Title       : BbsKViewCmd Class</p>
 * <p>Description : 게시판 상세정보 Load 처리 한다.</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판 상세정보를 Load 한다. 
 * 
 * @version 1.0
 * @author  PKT
 */
public class BbsKViewCmd implements KJFCommand {
    
    /** 게시판 정보 */
    private StatusEnt status;
    
    public BbsKViewCmd() {        
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        // 게시판 초기 값들 세팅 및 점검.
        BbsSetConf.check(request);       

        status = (StatusEnt)request.getSession().getAttribute("status");
        
        String next = "/bbs/BbsK.jsp";               
        
        // 검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);
        request.setAttribute("pm", pm);        
        
        //  게시판 상세보기 데이터 load
        LoadData(request, pm);       
        
        return next;
    }
    
    
    /**
     * 게시판 상세보기 데이터 load
     * 
     * @param request
     * @param pm
     * @throws Exception
     */
    private void LoadData(HttpServletRequest request, BbsParam pm) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = null;
        
        String CT_ID     = status.getCT_ID();
        String BOARD_SEQ = request.getParameter("BOARD_SEQ");
        
        int intCNT = 1;
        
        // Select Query
        StringBuffer sbSelectSQL = new StringBuffer();        
        sbSelectSQL.append("SELECT                 \n");
        sbSelectSQL.append("       CT_ID,          \n");
        sbSelectSQL.append("       BOARD_SEQ,      \n");
        sbSelectSQL.append("       INDEX1,         \n");
        sbSelectSQL.append("       INDEX2,         \n");
        sbSelectSQL.append("       DEPTH,          \n");
        sbSelectSQL.append("       SIDO_CODE,      \n");
        sbSelectSQL.append("       SIGUNGU_CODE,   \n");
        
        if(status.isSD_DIV_YN()) {            
            sbSelectSQL.append("       (SELECT SIDO_NM FROM PT_SIDO_CODE WHERE AREA_CODE = A.SIDO_CODE) AS SD_NM,      \n");
        }
        
        if(status.isSGG_DIV_YN()) {
            sbSelectSQL.append("       (SELECT SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE = A.SIGUNGU_CODE) AS SGG_NM,  \n");
        }
        
        sbSelectSQL.append("       USER_ID,        \n");
        sbSelectSQL.append("       USER_NAME,      \n");
        sbSelectSQL.append("       USER_EMAIL,     \n");
        sbSelectSQL.append("       USER_PASS,      \n");
        sbSelectSQL.append("       USER_IP,        \n");
        sbSelectSQL.append("       USER_TEL,       \n");
        sbSelectSQL.append("       USER_HOMEPAGE,  \n");
        sbSelectSQL.append("       SUBJECT,        \n");
        sbSelectSQL.append("       CONTENT,        \n");
        sbSelectSQL.append("       REPLIED_YN,     \n");
        sbSelectSQL.append("       SECRET_YN,      \n");
        sbSelectSQL.append("       NOTICE_YN,      \n");
        sbSelectSQL.append("       READ_NUM,       \n");
        sbSelectSQL.append("       UPD_DT,         \n");
        sbSelectSQL.append("       INS_DT,         \n");
        sbSelectSQL.append("       WRT_ID,         \n");
        sbSelectSQL.append("       ETC_1,          \n");
        sbSelectSQL.append("       ETC_2,          \n");
        sbSelectSQL.append("       ETC_3,          \n");
        sbSelectSQL.append("       ETC_4,          \n");
        sbSelectSQL.append("       ETC_5,          \n");
        sbSelectSQL.append("       ETC_6,          \n");
        sbSelectSQL.append("       ETC_7,          \n");
        sbSelectSQL.append("       ETC_8,          \n");
        sbSelectSQL.append("       ETC_9,          \n");
        sbSelectSQL.append("       ETC_10          \n");
        
        // From Query
        StringBuffer sbFromSQL = new StringBuffer();
        sbFromSQL.append("  FROM    \n");
        
        if ("Y".equals(status.getTABLE_ONE_YN())) {
            sbFromSQL.append(" PT_BBS_BOARD A         \n");
        } else {
            sbFromSQL.append(" PT_BBS_" + CT_ID + " A \n");
        }        

        // Where Query
        StringBuffer sbWhereSQL = new StringBuffer();        
        sbWhereSQL.append(" WHERE 1=1               \n");  
        sbWhereSQL.append("   AND BOARD_SEQ = ?     \n");

        rDAO.setValue(intCNT++, BOARD_SEQ);   
        
        if ("Y".equals(status.getTABLE_ONE_YN())) { 
            sbWhereSQL.append("   AND CT_ID = ?     \n");            
            rDAO.setValue(intCNT++, CT_ID);      
        }

        rEntity = rDAO.select(sbSelectSQL.toString() + sbFromSQL.toString() + sbWhereSQL.toString());

        request.setAttribute("rEntity", rEntity);   
        
        // 댓글 가져오기
        if (status.isONE_LINE()) {            
            LoadCommentData(request);
        }

        // 첨부파일을 가져온다
        if (status.getATT_NUM() > 0 ) {
            LoadFileData(request);
        }

        // 조횟수 카운트
        setLeadCnt(request);
        
    }
    
    
    /*********************************************************************
     * 댓글 글을 load하는 메소드 
     * 
     * @param HttpServletRequest
     * @return
     *********************************************************************/
    private void LoadCommentData(HttpServletRequest request) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = null;
        
        String CT_ID     = status.getCT_ID();
        String BOARD_SEQ = request.getParameter("BOARD_SEQ");
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("  SELECT *                    \n");
        sbSQL.append("    FROM PT_BBS_COM_COMMENT   \n");
        sbSQL.append("   WHERE CT_ID = ?            \n");
        sbSQL.append("     AND BOARD_SEQ = ?        \n");
       
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, BOARD_SEQ);
        
        rEntity = rDAO.select(sbSQL.toString());

        request.setAttribute("cEntity", rEntity);
    }
    
    
    
    /*********************************************************************
     * 첨부파일을 load하는 메소드 
     * 
     * @param HttpServletRequest
     * @return
     *********************************************************************/
    private void LoadFileData(HttpServletRequest request) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = null;
        
        String CT_ID     = status.getCT_ID();
        String BOARD_SEQ = request.getParameter("BOARD_SEQ");      
                
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" SELECT                   \n");
        sbSQL.append("        SYS_FILE_NAME,    \n");
        sbSQL.append("        CT_ID,            \n");
        sbSQL.append("        BOARD_SEQ,        \n");
        sbSQL.append("        FILE_REAL_NAME,   \n");
        sbSQL.append("        FILE_SIZE,        \n");
        sbSQL.append("        UPD_DT,           \n");
        sbSQL.append("        DOWN_HIT          \n");
        sbSQL.append("   FROM PT_BBS_COM_FILES  \n");
        sbSQL.append("  WHERE CT_ID = ?         \n");
        sbSQL.append("    AND BOARD_SEQ = ?     \n");
       
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, BOARD_SEQ);
        
        rEntity = rDAO.select(sbSQL.toString());

        request.setAttribute("FileEntity", rEntity);
    }
    
    
    /**
     * 게시물 보기시 조회횟수 추가 메소드 
     * 
     * @param request
     * @throws Exception
     */
    private void setLeadCnt(HttpServletRequest request) throws Exception {       
        
        ReportDAO rDAO = new ReportDAO();
        
        String CT_ID     = request.getParameter("CT_ID");
        String BOARD_ID  = "PT_BBS_BOARD";
        String BOARD_SEQ = request.getParameter("BOARD_SEQ");        

        // 통합 게시판
        if (!"Y".equals(status.getTABLE_ONE_YN())) {
            BOARD_ID = "PT_BBS_" + CT_ID;
        }        
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" UPDATE " + BOARD_ID + "  \n");
        sbSQL.append("    SET READ_NUM = (      \n");        
     
        sbSQL.append("      SELECT NVL( MAX( READ_NUM), 0 ) + 1  MAXREAD    \n");
        sbSQL.append("        FROM " + BOARD_ID + " B                       \n");
        sbSQL.append("       WHERE B.BOARD_SEQ = " + BOARD_ID + ".BOARD_SEQ \n");
        sbSQL.append("         AND B.CT_ID = " + BOARD_ID + ".CT_ID         \n");
        sbSQL.append("    )                                                 \n");        
        
        
        sbSQL.append("  WHERE BOARD_SEQ = ?     \n");
        sbSQL.append("    AND CT_ID = ?         \n");
       
        rDAO.setValue(1, BOARD_SEQ);
        rDAO.setValue(2, CT_ID);

        rDAO.execute(sbSQL.toString());
    }  
    
    
    /**
     * 검색조건 초기값 설정및 체크
     * 
     * @param request
     * @param form
     * @return BbsParam
     * @throws Exception
     */
    private BbsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        BbsParam pm = (BbsParam)form;

        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));

        // 페이징 라인
        if (KJFUtil.isEmpty(pm.getRowPerPage())) {
            pm.setRowPerPage(Integer.toString(status.getROWPERPAGE()));
        }

        return pm;
    }
}
