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

public class BbsKWriteCmd implements KJFCommand {
    
    /** 게시판 정보 */
    private StatusEnt status;
       
    public BbsKWriteCmd() {        
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        // 게시판 초기 값들 세팅 및 점검.
        BbsSetConf.check(request);       

        status = (StatusEnt)request.getSession().getAttribute("status");
               
        String mode = KJFUtil.print(request.getParameter("mode"));
        String next = "/bbs/BbsK.jsp";
        
        // 검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);
        request.setAttribute("pm", pm);        
            
        //수정일때 - modify  , 답변-reply일때.   
        if (mode.equals("modify") || mode.equals("reply")) {
            
            // 게시판 상세 데이터 load
            LoadData(request, pm);                
         
        } else {    // 신규 입력 일때.          
        	
        	String FAQ_L_CATE =	KJFUtil.print(pm.getScFAQ_L_CATE(),"ALL"); //질의회신 (faq_basic_pub)
        	
            loadCondition(request, status.getSIDO_CODE(),FAQ_L_CATE);
            
        }        
        
        return next;
    }
    
    
    /**
     * 검색조건 및 초기데이타 로드
     * 
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request, String sido_code, String FAQ_L_CATE) throws Exception {
        
        // 게시판 검색 코드  시작
        StringBuffer sbSQL;

        // 시.도(시.군.구) 구분을 사용할 시
        if (status.isSD_DIV_YN()) {            
            
            // 시.도 코드
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT AREA_CODE, SIDO_NM    \n");
            sbSQL.append("   FROM PT_SIDO_CODE          \n");
            sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR(AREA_CODE, 3, 4)    \n");
            sbSQL.append("  ORDER BY SIDO_NM     \n");        
            
            Vector<KJFSelect> v_SD_CD = KJFSelectOPS.getSel(sbSQL.toString(), "", "시.도 선택");
            request.setAttribute("v_SD_CD", v_SD_CD);
        }
            
        // 시.군.구 구분           
        if (status.isSGG_DIV_YN()) {  
            sbSQL = new StringBuffer();
            
            sbSQL.append(" SELECT AREA_CODE, RTRIM(SIGUNGU_NM, '본청')   \n");
            sbSQL.append("   FROM PT_SIDO_CODE                           \n");
            sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR('" + sido_code + "', 1, 2) \n");
            sbSQL.append("    AND SUBSTR(AREA_CODE, 1, 2) != SUBSTR(AREA_CODE, 3, 4)                \n");
            sbSQL.append("  ORDER BY SIGUNGU_NM      \n");
        
            Vector<KJFSelect> v_scSGG_CD = KJFSelectOPS.getSel(sbSQL.toString(), "", "시.군.구 선택");
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
            sbSQL.append(" WHERE CODE_GROUP ='004' AND BIGO ='"+ FAQ_L_CATE +"'  \n");
            sbSQL.append(" ORDER BY ORDER_NUM ASC 	    			\n");           
            
            Vector<KJFSelect> v_scFAQ_S_CATE = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "소분류");
            request.setAttribute("v_scFAQ_S_CATE", v_scFAQ_S_CATE);

        }
        
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
        sbSelectSQL.append("       USER_ID,        \n");
        sbSelectSQL.append("       USER_NAME,      \n");
        sbSelectSQL.append("       USER_EMAIL,     \n");
        sbSelectSQL.append("       USER_PASS,      \n");
        sbSelectSQL.append("       USER_IP,        \n");
        sbSelectSQL.append("       USER_TEL,       \n");
        sbSelectSQL.append("       USER_HOMEPAGE,  \n");
        sbSelectSQL.append("       SUBJECT,        \n");
        sbSelectSQL.append("       CONTENT,        \n");        
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
            sbFromSQL.append(" PT_BBS_BOARD         \n");
        } else {
            sbFromSQL.append(" PT_BBS_" + CT_ID + " \n");
        }        

        // Where Query
        StringBuffer sbWhereSQL = new StringBuffer();        
        sbWhereSQL.append(" WHERE 1=1               \n");  
        sbWhereSQL.append("   AND BOARD_SEQ = ?     \n");
        sbWhereSQL.append("   AND CT_ID = ?         \n");

        rDAO.setValue(intCNT++, BOARD_SEQ);    
        rDAO.setValue(intCNT++, CT_ID);        

        rEntity = rDAO.select(sbSelectSQL.toString() + sbFromSQL.toString() + sbWhereSQL.toString());

        request.setAttribute("rEntity", rEntity);   
        
        // 첨부파일을 가져온다
        if (status.isATTACH() && status.getATT_NUM() > 0) {
            LoadFileData(request);
        }
        
        // 리스트에서 수정버튼 클릭시 리스트에 있는 분류값이 리턴되어 결과가 다르게 나타나므로 쿼리값으로 재세팅
        if ("faq_basic_pub".equals(status.getTYPE())){
        	pm.setScFAQ_L_CATE(rEntity.getValue(0,"ETC_2"));
        	pm.setScFAQ_S_CATE(rEntity.getValue(0,"ETC_3"));
        	request.setAttribute("pm", pm); 
        	loadCondition(request, rEntity.getValue(0, "SIDO_CODE"), rEntity.getValue(0, "ETC_2"));
        } else {
        	loadCondition(request, rEntity.getValue(0, "SIDO_CODE"), "");
        }
       
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
