    package sp.bbs.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelect;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.LoginException;

import org.apache.struts.action.ActionForm;

import sp.bbs.BbsParam;
import sp.bbs.BbsSetConf;
import sp.bbs.StatusEnt;

/**
 * <p>Title       : BbsKListCmd Class</p>
 * <p>Description : 게시판 List를 Load 처리 한다.</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판 List 정보를 처리를 한다. 
 * 
 * @version 1.0
 * @author  PKT
 */
public class BbsKListCmd implements KJFCommand {
    
    /** 게시판 정보 */
    private StatusEnt status;
  
    public BbsKListCmd() {        
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        // 게시판 초기 값들 세팅 및 점검.
        BbsSetConf.check(request);       

        status = (StatusEnt)request.getSession().getAttribute("status");
        
        String next = "/bbs/BbsK.jsp";        
        request.setAttribute("url_us", next);     
        
        // 검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);
        request.setAttribute("pm", pm);
        
        // 검색조건 및 초기데이타 로드
        loadCondition(request, pm);
        
        // 게시판 List Load
        loadList(request, pm);       
        
        return next;
    }
    
    
    /**
     * 검색조건 및 초기데이타 로드
     * 
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request, BbsParam pm) throws Exception {
        
     // 게시판 검색 코드        
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT CODE, CODE_NAME       \n");
        sbSQL.append("   FROM PT_BBS_COM_CODE       \n");
        sbSQL.append("  WHERE CODE_GROUP = '003'    \n");
        sbSQL.append("    AND CODE <> '000'         \n");
        sbSQL.append("  ORDER BY ORDER_NUM          \n");            

        Vector<KJFSelect> v_scSLCT_GUBUN = KJFSelectOPS.getSel(sbSQL.toString());
        request.setAttribute("v_scSLCT_GUBUN", v_scSLCT_GUBUN);


        // 시.도 구분을 사용할 시
        if (status.isSD_DIV_YN()) {
            
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT AREA_CODE, SIDO_NM    \n");
            sbSQL.append("   FROM PT_SIDO_CODE          \n");
            sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR(AREA_CODE, 3, 4)    \n");
            sbSQL.append("  ORDER BY SIDO_NM     \n");           
            
            Vector<KJFSelect> v_scSD_CD = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "시.도 선택");
            request.setAttribute("v_scSD_CD", v_scSD_CD);
        }
        
        // 시.군.구 구분을 사용할 시
        if (status.isSGG_DIV_YN()) {
            
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT AREA_CODE, RTRIM(SIGUNGU_NM, '본청')   \n");
            sbSQL.append("   FROM PT_SIDO_CODE                           \n");
            sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR('" + pm.getScSD_CD() + "', 1, 2) \n");
            sbSQL.append("    AND SUBSTR(AREA_CODE, 1, 2) != SUBSTR(AREA_CODE, 3, 4)                \n");
            sbSQL.append("  ORDER BY SIGUNGU_NM      \n");
                    
            Vector<KJFSelect> v_scSGG_CD = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "시.군.구 선택");
            request.setAttribute("v_scSGG_CD", v_scSGG_CD);            
        }
        
        // 질의회신용
        if ("faq_basic_pub".equals(status.getTYPE())) {
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT CODE,CODE_NAME 		 			\n");
            sbSQL.append(" FROM PT_BBS_COM_CODE          			\n");
            sbSQL.append(" WHERE CODE_GROUP ='004' AND BIGO ='000'  \n");
            sbSQL.append(" ORDER BY ORDER_NUM ASC 	    			\n");           
            
            Vector<KJFSelect> v_scFAQ_L_CATE = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "대분류");
            request.setAttribute("v_scFAQ_L_CATE", v_scFAQ_L_CATE);
            
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT CODE,CODE_NAME 		 			\n");
            sbSQL.append(" FROM PT_BBS_COM_CODE          			\n");
            sbSQL.append(" WHERE CODE_GROUP ='004' AND BIGO ='"+ KJFUtil.print(pm.getScFAQ_L_CATE(),"ALL")+"'  \n");
            sbSQL.append(" ORDER BY ORDER_NUM ASC 	    			\n");           
            
            Vector<KJFSelect> v_scFAQ_S_CATE = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "소분류");
            request.setAttribute("v_scFAQ_S_CATE", v_scFAQ_S_CATE);
            
        }
    }
    
    
    /**
     * 게시판 List Load
     * 
     * @param request
     * @param pm
     * @throws Exception
     */
    private void loadList(HttpServletRequest request, BbsParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();        
        ReportEntity rEntity = null;
        
        int intCNT = 1;
        
        String CT_ID        = status.getCT_ID();        
        String scSD_CD      = KJFUtil.print(pm.getScSD_CD());       
        String scSGG_CD     = KJFUtil.print(pm.getScSGG_CD());        
        String scSLCT_GUBUN = KJFUtil.print(pm.getScSLCT_GUBUN());
        String scTEXTVALUE  = KJFUtil.print(pm.getScTEXTVALUE());
        String tableName    = "";  
        String scFAQ_L_CATE = KJFUtil.print(pm.getScFAQ_L_CATE());       
        String scFAQ_S_CATE = KJFUtil.print(pm.getScFAQ_S_CATE());
        if ("Y".equals(status.getTABLE_ONE_YN())) {
            tableName = "PT_BBS_BOARD";
            
        } else {
            tableName = "PT_BBS_" + CT_ID;
        }        
        
        // Select Query
        StringBuffer sbSelectSQL = new StringBuffer();        
        sbSelectSQL.append("SELECT                 \n");
        sbSelectSQL.append("       BOARD_SEQ,      \n");
        sbSelectSQL.append("       INDEX1,         \n");
        sbSelectSQL.append("       INDEX2,         \n");
        sbSelectSQL.append("       DEPTH,          \n");
        sbSelectSQL.append("       SIDO_CODE,      \n");
        sbSelectSQL.append("       SIGUNGU_CODE,   \n");
    
        // 시.군.구 코드 사용
        if (status.isSGG_DIV_YN()) {    
            sbSelectSQL.append("       (SELECT SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE = A.SIGUNGU_CODE) AS SGG_NM,        \n");
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
        
        // 첨부파일 사용
        if (status.isATTACH() && status.getATT_NUM() > 0) {
            sbSelectSQL.append("       (SELECT COUNT(*) CNT FROM PT_BBS_COM_FILES WHERE CT_ID = A.CT_ID AND BOARD_SEQ = A.BOARD_SEQ) AS FILE_CNT,  \n");
        }
        
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
        sbFromSQL.append("  FROM " + tableName + " A  \n");

        // Where Query
        StringBuffer sbWhereSQL = new StringBuffer();        
        sbWhereSQL.append(" WHERE 1=1               \n");        
        sbWhereSQL.append(" AND NOTICE_YN = 'N'     \n");

        if ("Y".equals(status.getTABLE_ONE_YN())) {            
            rDAO.setValue(intCNT++, CT_ID);            
            sbWhereSQL.append(" AND CT_ID = ?   \n");
        }

        // 관리자이면 일대일 게시판이라도 전체를 나타 낸다.
        if ( !status.isADMIN() && status.isONE_ONE()){
            rDAO.setValue(intCNT++, status.getUSER_ID());
            sbWhereSQL.append(" AND USER_ID = ? \n") ;
        }
        
     // 시.도  검색 처리 조건
        if (status.isSD_DIV_YN()) {
            
            if ( !scSD_CD.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scSD_CD)) {
                rDAO.setValue(intCNT++, scSD_CD);
                sbWhereSQL.append(" AND SIDO_CODE = ?       \n") ;
            } 
        }
        
        // 시.군.구 구분           
        if (status.isSGG_DIV_YN()) {            
            
            if ( !scSD_CD.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scSD_CD) 
                    && !scSGG_CD.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scSGG_CD) ) {
               rDAO.setValue(intCNT++, scSGG_CD);
               sbWhereSQL.append(" AND SIGUNGU_CODE = ?      \n") ;
            }
        }     

        // 질의회신사례집 대분류 구분           
        if ("faq_basic_pub".equals(status.getTYPE())) {            
            if ( !scFAQ_L_CATE.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scFAQ_L_CATE) 
                    && !scFAQ_L_CATE.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scFAQ_L_CATE) ) {
               rDAO.setValue(intCNT++, scFAQ_L_CATE);
               sbWhereSQL.append(" AND ETC_2 = ?      \n") ;
            }
            
            if ( !scFAQ_S_CATE.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scFAQ_S_CATE) 
                    && !scFAQ_S_CATE.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scFAQ_S_CATE) ) {
               rDAO.setValue(intCNT++, scFAQ_S_CATE);
               sbWhereSQL.append(" AND ETC_3 = ?      \n") ;
            }
        }    
        
        // 검색 조건 처리
        if ( !KJFUtil.isEmpty(scSLCT_GUBUN) && !KJFUtil.isEmpty(scTEXTVALUE)  ) {
            
            if (scSLCT_GUBUN.equals("001")) {           // 제목
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                sbWhereSQL.append(" AND SUBJECT Like ?    \n") ;
                
            } else if (scSLCT_GUBUN.equals("002")) {    // 내용
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                sbWhereSQL.append(" AND CONTENT like ?     \n") ;
                
            } else if (scSLCT_GUBUN.equals("003")) {    // 제목 + 내용
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");                
                sbWhereSQL.append(" AND (SUBJECT Like ? OR CONTENT like ?)   \n") ;
                
            } else if (scSLCT_GUBUN.equals("004")) {    // 작성자
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                sbWhereSQL.append(" AND USER_NAME Like ?    \n") ;
            }
        }
        
        // ORDER BY Query
        String orderSQL = " ORDER BY INDEX1 DESC, INDEX2 ASC  \n";
        
        /* ************************** 페이징 관련 START **************************/
        StringBuffer sbCntSQL = new StringBuffer();
        sbCntSQL.append(" SELECT COUNT(*)  CNT  \n");
        sbCntSQL.append(sbFromSQL.toString());
        sbCntSQL.append(sbWhereSQL.toString());        
        
        //전체 목록 수
        String totalCount="";

        //페이지별 목록 수
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        //현재 페이지 번호
        int nowPage = 1;
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(sbCntSQL.toString());
        
        totalCount = rEntity.getValue(0, "CNT");
        
        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);//추가
        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* *************************** 페이징 관련  END **************************/

        rEntity = rDAO.select(sbSelectSQL.toString() + sbFromSQL.toString() + sbWhereSQL.toString() + orderSQL, nowPage, rowPerPage);

        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);
        request.setAttribute("ListEntity", rEntity);
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
        
        // 시도 코드
        if (KJFUtil.isEmpty(pm.getScSD_CD()) ) {
            pm.setScSD_CD(status.getSIDO_CODE());
        }
        
        // 시군구 코드
        if (KJFUtil.isEmpty(pm.getScSGG_CD()) ) {
            pm.setScSGG_CD(status.getSIGUNGU_CODE());
        }

        return pm;
    }
}
