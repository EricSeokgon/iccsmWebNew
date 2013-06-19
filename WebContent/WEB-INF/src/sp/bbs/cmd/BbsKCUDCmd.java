package sp.bbs.cmd;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFFile;
import kjf.util.KJFUtil;
import kjf.util.LoginException;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import sp.bbs.BbsParam;
import sp.bbs.BbsSetConf;
import sp.bbs.StatusEnt;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * <p>Title       : BbsKCUDCmd Class</p>
 * <p>Description : 게시글 등록, 수정, 삭제 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판의 등록, 수정, 삭제 처리를 한다.
 * 
 * @version 1.0
 * @author  PKT
 */
public class BbsKCUDCmd implements KJFCommand {

    private StatusEnt status;
    private String BOARD_SEQ;
    private String next;

    public BbsKCUDCmd() {
    }
    
    public BbsKCUDCmd(String next_url) {
        next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

        // 게시판 초기 값들 세팅 및 점검.
        BbsSetConf.check(request);

        status = (StatusEnt) request.getSession().getAttribute("status");

        String cmd = request.getParameter("cmd");       
       
        request.setAttribute("url_us", "/bbs/BbsK.jsp");     
        
        // 삭제 모듈이 아니고, 첨부 파일이 있을경우만
        if (!cmd.equals("BbsKD") && status.getATT_NUM() > 0) {
            checkBBS_FILE(request, form);
        }
        
        if(cmd.equals("BbsKC")) {           // 게시글 등록
            insertBbsKC(request);
               
        } else if (cmd.equals("BbsKU")) {   // 게시글 수정
            updateBbsKU(request);

        } else if (cmd.equals("BbsKD")) {   // 게시글 삭제           
            deleteBbsKD(request);    
            
        } else if (cmd.equals("BbsLD")) {   // 리스트 선택 게시글 삭제    
            deleteBbsLD(request);
            
        } else if(cmd.equals("BbsKR")) {    // 답변일때
            insertBbsKR(request);

        } else if(cmd.equals("BbsKFileDel")) {          
            deleteComFiles(request);   
            
            request.setAttribute("cmdA", "BbsKWrite");
            request.setAttribute("mode", "modify");
            
            return  new BbsKWriteCmd().execute(request,form);
        }

        // 삭제 모듈이 아니고, 첨부 파일이 있을경우만
        if (!cmd.equals("BbsKD") && status.getATT_NUM() > 0) {
            
            setBBS_FILE(request, form);
            
            /* 파일 업로드 (multipart/form-data) 일경우  다음 cmd 로 넘길때 모든 값들이
             * null로 초기 화 되기 때문에 cmd를  "cmdA"로 다시 재설정 하여 넘겨야 제대로 넘어간다.
             * 받는 쪽은 역시 getAttribute로 처리 해 줘야 한다.
             */
            if (cmd.equals("BbsKC")|| cmd.equals("BbsKR") || cmd.equals("BbsKD")) {
                request.setAttribute("cmdA", "BbsKList");
                return  new BbsKListCmd().execute(request,form);
            
            } else if (cmd.equals("BbsKU")) {
                request.setAttribute("cmdA", "BbsKView");
                return  new BbsKViewCmd().execute(request,form);
            }            
        }
        
        return next;
    }

    
    /**
     * 게시판 신규등록 메소드
     *
     * @param request
     * @throws Exception
     */
    private void insertBbsKC(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();

        String CT_ID    = request.getParameter("CT_ID");
        String BOARD_ID = "PT_BBS_BOARD";

        if ("N".equals(status.getTABLE_ONE_YN())) { // 통합 게시판이 아니면
            BOARD_ID = "PT_BBS_" + CT_ID;
        }

        String INDEX1 = getMaxIndex1(BOARD_ID, CT_ID);
        String INDEX2 = "0";
        String DEPTH  = "0";

        BOARD_SEQ  = getMaxSeq(BOARD_ID, CT_ID);
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" INSERT INTO " + BOARD_ID + " (   \n");
        sbSQL.append("        CT_ID,                    \n");
        sbSQL.append("        BOARD_SEQ,                \n");
        sbSQL.append("        INDEX1,                   \n");
        sbSQL.append("        INDEX2,                   \n");
        sbSQL.append("        DEPTH,                    \n");
        
        sbSQL.append("        SIDO_CODE,                \n");
        sbSQL.append("        SIGUNGU_CODE,             \n");

        sbSQL.append("        USER_ID,                  \n");
        sbSQL.append("        USER_NAME,                \n");
        sbSQL.append("        USER_EMAIL,               \n");
        sbSQL.append("        USER_PASS,                \n");
        sbSQL.append("        USER_IP,                  \n");
        sbSQL.append("        USER_TEL,                 \n");
        sbSQL.append("        USER_HOMEPAGE,            \n");
        
        sbSQL.append("        SUBJECT,                  \n");
        sbSQL.append("        CONTENT,                  \n");
        sbSQL.append("        REPLIED_YN,               \n");
        sbSQL.append("        SECRET_YN,                \n");
        sbSQL.append("        NOTICE_YN,                \n");
        
        sbSQL.append("        READ_NUM,                 \n");
        sbSQL.append("        UPD_DT,                   \n");
        sbSQL.append("        INS_DT,                   \n");
        sbSQL.append("        WRT_ID,                   \n");

        sbSQL.append("        ETC_1,                    \n");
        sbSQL.append("        ETC_2,                    \n");
        sbSQL.append("        ETC_3,                    \n");
        sbSQL.append("        ETC_4,                    \n");
        sbSQL.append("        ETC_5,                    \n");

        sbSQL.append("        ETC_6,                    \n");
        sbSQL.append("        ETC_7,                    \n");
        sbSQL.append("        ETC_8,                    \n");
        sbSQL.append("        ETC_9,                    \n");
        sbSQL.append("        ETC_10                    \n");
        sbSQL.append("       )                          \n");
        sbSQL.append("   values (                       \n");
        sbSQL.append("            ?,?,?,?,?,            \n");
        sbSQL.append("            ?,?,                  \n");
        sbSQL.append("            ?,?,?,?,?,?,?,        \n");
        sbSQL.append("            ?,?,?,?,?,            \n");
        sbSQL.append("            ?,?,?,?,              \n");
        sbSQL.append("            ?,?,?,?,?,            \n");
        sbSQL.append("            ?,?,?,?,?             \n");
        sbSQL.append("          )                       \n");   

        int i = 0;

        rDAO.setValue(++i, CT_ID);
        rDAO.setValue(++i, BOARD_SEQ);
        rDAO.setValue(++i, INDEX1);
        rDAO.setValue(++i, INDEX2);
        rDAO.setValue(++i, DEPTH);
        
        rDAO.setValue(++i, request.getParameter("SIDO_CODE"));
        rDAO.setValue(++i, request.getParameter("SIGUNGU_CODE"));
        
        rDAO.setValue(++i, status.getUSER_ID());
        rDAO.setValue(++i, request.getParameter("USER_NAME"));
        rDAO.setValue(++i, request.getParameter("USER_EMAIL"));
        rDAO.setValue(++i, request.getParameter("USER_PASS"));
        rDAO.setValue(++i, request.getRemoteHost());
        rDAO.setValue(++i, request.getParameter("USER_TEL"));        
        rDAO.setValue(++i, request.getParameter("USER_HOMEPAGE"));        
        
        rDAO.setValue(++i, request.getParameter("SUBJECT"));
        rDAO.setValue(++i, request.getParameter("CONTENT"));
        rDAO.setValue(++i, "N");
        rDAO.setValue(++i, KJFUtil.print(request.getParameter("SECRET_YN"), "N"));
        rDAO.setValue(++i, KJFUtil.print(request.getParameter("NOTICE_YN"), "N"));
        
        rDAO.setValue(++i, 0);                
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));
        rDAO.setValue(++i, status.getUSER_ID());
        
        rDAO.setValue(++i, request.getParameter("ETC_1"));
        rDAO.setValue(++i, request.getParameter("ETC_2"));
        rDAO.setValue(++i, request.getParameter("ETC_3"));
        rDAO.setValue(++i, request.getParameter("ETC_4"));
        rDAO.setValue(++i, request.getParameter("ETC_5"));
        
        rDAO.setValue(++i, request.getParameter("ETC_6"));
        rDAO.setValue(++i, request.getParameter("ETC_7"));
        rDAO.setValue(++i, request.getParameter("ETC_8"));
        rDAO.setValue(++i, request.getParameter("ETC_9"));
        rDAO.setValue(++i, request.getParameter("ETC_10"));

        rDAO.execute(sbSQL.toString());
    }
    
    
    /**
     * 게시판 답변등록 메소드
     *
     * @param request
     * @throws Exception
     */
    private void insertBbsKR(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();

        String CT_ID    = request.getParameter("CT_ID");
        String BOARD_ID = "PT_BBS_BOARD";
        String INDEX1   = request.getParameter("INDEX1"); // reply 용
        String INDEX2   = request.getParameter("INDEX2"); // reply 용
        String DEPTH    = request.getParameter("DEPTH");  // reply 용

        if ("N".equals(status.getTABLE_ONE_YN())) { // 통합 게시판이 아니면
            BOARD_ID = "PT_BBS_" + CT_ID;
        }

        String BOARD_SEQ = getMaxSeq(BOARD_ID, CT_ID);
        String maxIndex2 = getSavingIndex2(BOARD_ID, CT_ID, INDEX1, INDEX2, DEPTH);  // 바뀌어질 INDEX2

        DEPTH = (KJFUtil.str2int(DEPTH) + 1) + ""; // 답변되어지는 DEPTH +1 -저장될 DEPTH

        // 답글 등록시 인덱스 수정
        updateINDEX2(CT_ID, BOARD_ID, INDEX1, maxIndex2);

        StringBuffer sbSQL = new StringBuffer();    
        sbSQL.append("   INSERT INTO " + BOARD_ID + " (  \n");
        sbSQL.append("       CT_ID,                      \n");
        sbSQL.append("       BOARD_SEQ,                  \n");
        sbSQL.append("       INDEX1,                     \n");
        sbSQL.append("       INDEX2,                     \n");
        sbSQL.append("       DEPTH,                      \n");
        
        sbSQL.append("       SIDO_CODE,                  \n");
        sbSQL.append("       SIGUNGU_CODE,               \n");

        sbSQL.append("       USER_ID,                    \n");
        sbSQL.append("       USER_NAME,                  \n");
        sbSQL.append("       USER_EMAIL,                 \n");
        sbSQL.append("       USER_PASS,                  \n");
        sbSQL.append("       USER_IP,                    \n");
        sbSQL.append("       USER_TEL,                   \n");
        sbSQL.append("       USER_HOMEPAGE,              \n");
        
        sbSQL.append("       SUBJECT,                    \n");
        sbSQL.append("       CONTENT,                    \n");
        sbSQL.append("       REPLIED_YN,                 \n");
        sbSQL.append("       SECRET_YN,                  \n");
        sbSQL.append("       NOTICE_YN,                  \n");
        
        sbSQL.append("       READ_NUM,                   \n");        
        sbSQL.append("       UPD_DT,                     \n");
        sbSQL.append("       INS_DT,                     \n");
        sbSQL.append("       WRT_ID,                     \n");

        sbSQL.append("       ETC_1,                      \n");
        sbSQL.append("       ETC_2,                      \n");
        sbSQL.append("       ETC_3,                      \n");
        sbSQL.append("       ETC_4,                      \n");
        sbSQL.append("       ETC_5,                      \n");

        sbSQL.append("       ETC_6,                      \n");
        sbSQL.append("       ETC_7,                      \n");
        sbSQL.append("       ETC_8,                      \n");
        sbSQL.append("       ETC_9,                      \n");
        sbSQL.append("       ETC_10                      \n");
        sbSQL.append("       )                           \n");
        sbSQL.append("   values (                        \n");
        sbSQL.append("            ?,?,?,?,?,             \n");
        sbSQL.append("            ?,?,                   \n");
        sbSQL.append("            ?,?,?,?,?,?,?,         \n");
        sbSQL.append("            ?,?,?,?,?,             \n");
        sbSQL.append("            ?,?,?,?,               \n");
        sbSQL.append("            ?,?,?,?,?,             \n");
        sbSQL.append("            ?,?,?,?,?              \n");
        sbSQL.append("          )                        \n");   

        int i = 0;
        
        rDAO.setValue(++i, CT_ID);
        rDAO.setValue(++i, BOARD_SEQ);
        rDAO.setValue(++i, INDEX1);
        rDAO.setValue(++i, maxIndex2);
        rDAO.setValue(++i, DEPTH);
        
        rDAO.setValue(++i, request.getParameter("SIDO_CODE"));
        rDAO.setValue(++i, request.getParameter("SIGUNGU_CODE"));
        
        rDAO.setValue(++i, status.getUSER_ID());
        rDAO.setValue(++i, request.getParameter("USER_NAME"));
        rDAO.setValue(++i, request.getParameter("USER_EMAIL"));
        rDAO.setValue(++i, request.getParameter("USER_PASS"));
        rDAO.setValue(++i, request.getParameter("USER_IP"));
        rDAO.setValue(++i, request.getParameter("USER_TEL"));        
        rDAO.setValue(++i, request.getParameter("USER_HOMEPAGE"));        
        
        rDAO.setValue(++i, request.getParameter("SUBJECT"));
        rDAO.setValue(++i, request.getParameter("CONTENT"));
        rDAO.setValue(++i, "Y");
        rDAO.setValue(++i, KJFUtil.print(request.getParameter("SECRET_YN"), "N"));
        rDAO.setValue(++i, KJFUtil.print(request.getParameter("NOTICE_YN"), "N"));
        
        rDAO.setValue(++i, 0);        
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));
        rDAO.setValue(++i, status.getUSER_ID());
        
        rDAO.setValue(++i, request.getParameter("ETC_1"));
        rDAO.setValue(++i, request.getParameter("ETC_2"));
        rDAO.setValue(++i, request.getParameter("ETC_3"));
        rDAO.setValue(++i, request.getParameter("ETC_4"));
        rDAO.setValue(++i, request.getParameter("ETC_5"));
        
        rDAO.setValue(++i, request.getParameter("ETC_6"));
        rDAO.setValue(++i, request.getParameter("ETC_7"));
        rDAO.setValue(++i, request.getParameter("ETC_8"));
        rDAO.setValue(++i, request.getParameter("ETC_9"));
        rDAO.setValue(++i, request.getParameter("ETC_10"));
        
        rDAO.execute(sbSQL.toString());     
    }
    
    
    /**
     * 게시판 데이트 수정처리 메소드
     *
     * @param request
     * @throws Exception
     */
    private void updateBbsKU(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();

        String BOARD_ID = "PT_BBS_BOARD";
        String CT_ID    = request.getParameter("CT_ID");
        BOARD_SEQ       = request.getParameter("BOARD_SEQ");
                
        // 통합 게시판이 아니면
        if ("N".equals(status.getTABLE_ONE_YN())) { 
            BOARD_ID = "PT_BBS_" + CT_ID;
        }        
        
        StringBuffer sbSQL = new StringBuffer();         
        sbSQL.append(" UPDATE " + BOARD_ID + " SET    \n");
        
        sbSQL.append("        SIDO_CODE = ?,          \n");
        sbSQL.append("        SIGUNGU_CODE = ?,       \n");
                
        sbSQL.append("        USER_ID = ?,            \n");
        sbSQL.append("        USER_NAME = ?,          \n");
        sbSQL.append("        USER_EMAIL = ?,         \n");
        sbSQL.append("        USER_PASS = ?,          \n");
        sbSQL.append("        USER_IP = ?,            \n");
        sbSQL.append("        USER_TEL = ?,           \n");
        sbSQL.append("        USER_HOMEPAGE = ?,      \n");        
        
        sbSQL.append("        SUBJECT = ?,            \n");
        sbSQL.append("        CONTENT = ?,            \n");
        sbSQL.append("        REPLIED_YN = ?,         \n");   
        sbSQL.append("        SECRET_YN = ?,          \n");    
        sbSQL.append("        NOTICE_YN = ?,          \n");        
        sbSQL.append("        UPD_DT = ?,             \n");
        
        sbSQL.append("        ETC_1 = ?,              \n");
        sbSQL.append("        ETC_2 = ?,              \n");
        sbSQL.append("        ETC_3 = ?,              \n");
        sbSQL.append("        ETC_4 = ?,              \n");
        sbSQL.append("        ETC_5 = ?,              \n");
        
        sbSQL.append("        ETC_6 = ?,              \n");
        sbSQL.append("        ETC_7 = ?,              \n");
        sbSQL.append("        ETC_8 = ?,              \n");
        sbSQL.append("        ETC_9 = ?,              \n");
        sbSQL.append("        ETC_10 = ?              \n");
        
        sbSQL.append("  WHERE CT_ID = ?               \n");
        sbSQL.append("    AND BOARD_SEQ = ?           \n");

        int i = 0;

        rDAO.setValue(++i, request.getParameter("SIDO_CODE"));
        rDAO.setValue(++i, request.getParameter("SIGUNGU_CODE"));
        
        rDAO.setValue(++i, status.getUSER_ID());
        rDAO.setValue(++i, request.getParameter("USER_NAME"));
        rDAO.setValue(++i, request.getParameter("USER_EMAIL"));
        rDAO.setValue(++i, request.getParameter("USER_PASS"));
        rDAO.setValue(++i, request.getParameter("USER_IP"));
        rDAO.setValue(++i, request.getParameter("USER_TEL"));     
        rDAO.setValue(++i, request.getParameter("USER_HOMEPAGE"));
        
        rDAO.setValue(++i, request.getParameter("SUBJECT"));
        rDAO.setValue(++i, request.getParameter("CONTENT"));
        rDAO.setValue(++i, KJFUtil.print(request.getParameter("REPLIED_YN"), "N"));
        rDAO.setValue(++i, KJFUtil.print(request.getParameter("SECRET_YN"), "N"));
        rDAO.setValue(++i, KJFUtil.print(request.getParameter("NOTICE_YN"), "N"));
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));
        
        rDAO.setValue(++i, request.getParameter("ETC_1"));
        rDAO.setValue(++i, request.getParameter("ETC_2"));
        rDAO.setValue(++i, request.getParameter("ETC_3"));
        rDAO.setValue(++i, request.getParameter("ETC_4"));
        rDAO.setValue(++i, request.getParameter("ETC_5"));
        
        rDAO.setValue(++i, request.getParameter("ETC_6"));
        rDAO.setValue(++i, request.getParameter("ETC_7"));
        rDAO.setValue(++i, request.getParameter("ETC_8"));
        rDAO.setValue(++i, request.getParameter("ETC_9"));
        rDAO.setValue(++i, request.getParameter("ETC_10"));
        
        rDAO.setValue(++i, CT_ID);
        rDAO.setValue(++i, BOARD_SEQ);

        rDAO.execute(sbSQL.toString());
        
        if("qna_basic".equals(status.getTYPE())){
        	updateBbsKuQna(request);
        }
    }
    
    /**
     * 게시판 데이트 수정처리 메소드 (QNA 응답문서가 있을경우 SIDO_CODE/SIGUNGU_CODE 일괄 변경) 
     *
     * @param request
     * @throws Exception
     */
    private void updateBbsKuQna(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        ReportEntity rEnt = new ReportEntity();
        
        String BOARD_ID = "PT_BBS_BOARD";
        String CT_ID    = request.getParameter("CT_ID");
        BOARD_SEQ       = request.getParameter("BOARD_SEQ");
                
        // 통합 게시판이 아니면
        if ("N".equals(status.getTABLE_ONE_YN())) { 
            BOARD_ID = "PT_BBS_" + CT_ID;
        }        
        
        String selectSQL = " SELECT INDEX1 FROM "+BOARD_ID+" WHERE CT_ID = ? AND BOARD_SEQ = ?";
        
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, BOARD_SEQ);
        
        rEnt = rDAO.select(selectSQL);
 
        if (rEnt != null || rEnt.getRowCnt() != 0 ){
	        StringBuffer sbSQL = new StringBuffer();         
	        sbSQL.append(" UPDATE " + BOARD_ID + " SET    \n");
	        
	        sbSQL.append("        SIDO_CODE = ?,          \n");
	        sbSQL.append("        SIGUNGU_CODE = ?       \n");
	                
	        sbSQL.append("  WHERE CT_ID = ?               \n");
	        sbSQL.append("    AND INDEX1 = ?           \n");
	
	        int i = 0;
	
	        rDAO.setValue(++i, request.getParameter("SIDO_CODE"));
	        rDAO.setValue(++i, request.getParameter("SIGUNGU_CODE"));
	        
	        rDAO.setValue(++i, CT_ID);
	        rDAO.setValue(++i, rEnt.getValue(0,"INDEX1"));
	        rDAO.execute(sbSQL.toString());
        }
    }
      
    /**
     * 게시판 게시물 삭제
     *
     * @param request
     * @throws Exception
     */
    private void deleteBbsKD(HttpServletRequest request) throws Exception {
        
        String chk[] = request.getParameterValues("chk");
        String seq[] = request.getParameterValues("BOARD_SEQ");

        String CT_ID    = request.getParameter("CT_ID");
        String BOARD_ID = "PT_BBS_BOARD";

        if ("N".equals(status.getTABLE_ONE_YN())) { // 통합 게시판이 아니면
            BOARD_ID = "PT_BBS_" + CT_ID;
        }        
        
        for (int i = 0; i < chk.length; i++) {

            int rowNum = KJFUtil.str2int(chk[i]);
            
            // 답글기능 사용이면,
            if ( status.isREPLY()) {
                
                if (checkBbsReply(BOARD_ID, CT_ID, seq[rowNum])) {
                    deleteBbsBoard(BOARD_ID, CT_ID, seq[rowNum]);  // 게시글 삭제
                }
                
            // 답글 기능 사용이 아니면
            } else {
                deleteBbsBoard(BOARD_ID, CT_ID, seq[rowNum]);       // 게시글 삭제
            }
            
            // 첨부파일 기능 사용이면
            if ( status.getATT_NUM() > 0 ) {
                deleteAttachFeil(CT_ID, seq[rowNum]);      // 첨부파일을 삭제한다.
            }
        }
    }
    
    /************************************************************************
     * 게시판 게시물 삭제
     *
     * @param request
     * @throws Exception
     ***********************************************************************/
    private void deleteBbsLD(HttpServletRequest request) throws Exception {

        String chk[] = request.getParameterValues("chk");

        String CT_ID    = request.getParameter("CT_ID");
        String BOARD_ID = "PT_BBS_BOARD";

        if ("N".equals(status.getTABLE_ONE_YN())) { // 통합 게시판이 아니면
            BOARD_ID = "PT_BBS_" + CT_ID;
        }

        for (int i = 0; i < chk.length; i++) {
         
            // 답글기능 사용이면,
            if (status.isREPLY()) {
                
                if (checkBbsReply(BOARD_ID, CT_ID, chk[i])) {
                    deleteBbsBoard(BOARD_ID, CT_ID, chk[i]);  // 게시글 삭제
                }
                
            // 답글 기능 사용이 아니면
            } else {
                deleteBbsBoard(BOARD_ID, CT_ID, chk[i]);  // 게시글 삭제
            }
     
            
            // 첨부파일 기능 사용이면
            if ( status.getATT_NUM() > 0 ) {
                deleteAttachFeil(CT_ID, chk[i]);      // 첨부파일을 삭제한다.
            }            
        }
    }   
    
    
    /**
     * 게시판 글 삭제
     *
     * @param CT_ID
     * @param BOARD_SEQ
     * @throws Exception
     */
    private void deleteBbsBoard(String BOARD_ID, String CT_ID, String BOARD_SEQ) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("  DELETE                      \n");
        sbSQL.append("    FROM " + BOARD_ID + "     \n");
        sbSQL.append("   WHERE CT_ID = ?            \n");
        sbSQL.append("     AND BOARD_SEQ = ?        \n");
       
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, BOARD_SEQ);
        
        rDAO.execute(sbSQL.toString());
    }
    
    
    /**
     * 답글여부 체크
     * 
     * @param BOARD_ID
     * @param CT_ID
     * @param BOARD_SEQ
     * @return boolean
     * @throws Exception
     */
    private boolean checkBbsReply(String BOARD_ID, String CT_ID, String BOARD_SEQ) throws Exception {
        
        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        boolean result = false;        
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" SELECT REPLIED_YN,               \n");
        sbSQL.append("        (SELECT COUNT(INDEX1)     \n");
        sbSQL.append("           FROM " + BOARD_ID + "  \n");
        sbSQL.append("           WHERE CT_ID = ?        \n");
        sbSQL.append("           AND INDEX1 = A.INDEX1  \n");
        sbSQL.append("        ) AS CNT                  \n");
        sbSQL.append("   FROM " + BOARD_ID + " A        \n");
        sbSQL.append("  WHERE CT_ID = ?                 \n");
        sbSQL.append("    AND BOARD_SEQ = ?             \n");
        
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, CT_ID);
        rDAO.setValue(3, BOARD_SEQ);

        rEntity = rDAO.select(sbSQL.toString());
        
        String REPLIED_YN = rEntity.getValue(0, "REPLIED_YN");
        
        int cnt = KJFUtil.str2int(rEntity.getValue(0, "CNT"));
        
        // 답글이면 삭제
        if(REPLIED_YN.equals("Y")) {
            result = true;
            
        } else {
            
           // 답글이 아니고, 답글이 있다면
           if (cnt > 1) {
               throw new MsgException(" 답글이 있습니다. 답글을 삭제해주세요.");
           
           // 답글이 아니고, 답글이 없다면
           } else {
               result = true;
           }
        }
        
        return result;
    } 
    
    
    /**
     * 답글 등록시 인덱스 수정 메소드
     *
     * @param CT_ID
     * @param BOARD_ID
     * @param INDEX1
     * @param maxIndex2
     * @throws Exception
     */
    private void updateINDEX2(String CT_ID, String BOARD_ID, String INDEX1, String maxIndex2) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
       
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" UPDATE " + BOARD_ID + "      \n");
        sbSQL.append("    SET INDEX2 = INDEX2+1     \n");
        sbSQL.append("  WHERE INDEX1 = ?            \n");
        sbSQL.append("    AND INDEX2 >= ?           \n");
        sbSQL.append("    AND CT_ID = ?             \n");
       
        rDAO.setValue(1, INDEX1);
        rDAO.setValue(2, maxIndex2);
        rDAO.setValue(3, CT_ID);

        rDAO.execute(sbSQL.toString());
    }

    
    /**
     * 첨부파일 저장
     * 
     * @param CT_ID
     * @param BOARD_SEQ
     * @param  formFile
     * @throws Exception
     */
    private void saveAttachFeil(String CT_ID, String BOARD_SEQ, FormFile formFile ) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        String FILE_REAL_NAME = formFile.getFileName();                                     // 파일 실명
        String str            = FILE_REAL_NAME.substring(FILE_REAL_NAME.lastIndexOf("."));  // 파일 확장명
        String SYS_FILE_NAME  = BOARD_SEQ + "_" + new Date().getTime()+ str ;               // 현재이름을 바꾼다.파일을 현재시간 + 파일이름
        String FILE_SIZE      = formFile.getFileSize() + "";                                // 파일 사이즈

        StringBuffer sbSQL = new StringBuffer();         
        sbSQL.append(" INSERT INTO PT_BBS_COM_FILES  (  \n");
        sbSQL.append("        SYS_FILE_NAME,            \n");
        sbSQL.append("        CT_ID,                    \n");
        sbSQL.append("        BOARD_SEQ,                \n");
        sbSQL.append("        FILE_REAL_NAME,           \n");
        sbSQL.append("        FILE_SIZE,                \n");
        sbSQL.append("        DOWN_HIT,                 \n");
        sbSQL.append("        UPD_DT  )                 \n");
        sbSQL.append(" VALUES (                         \n");
        sbSQL.append("          ?,?,?,?,?,?,?           \n");
        sbSQL.append("         )                        \n");
     
        int i = 0;

        rDAO.setValue(++i, SYS_FILE_NAME);
        rDAO.setValue(++i, CT_ID);
        rDAO.setValue(++i, BOARD_SEQ);
        rDAO.setValue(++i, FILE_REAL_NAME);
        rDAO.setValue(++i, FILE_SIZE);
        rDAO.setValue(++i, 0);
        rDAO.setValue(++i, KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss"));
        
        rDAO.execute(sbSQL.toString());

        String CT_Dir = Config.props.get("BBS_FILE_DIR") + CT_ID;
        
        // 파일이 저장 될 디렉토리 생성
        KJFFile.dirMake(CT_Dir);

        // 실제 시스템 저장
        KJFFile.saveFile(CT_Dir + KJFFile.FILE_S, SYS_FILE_NAME, formFile.getInputStream());
    }
    
    
   /**
    * 작은 이미지를 만든다.(파일이저장된 실제경로, 새로운이름, 가로사이즈)
    * 
    * @param orig
    * @param thumb
    * @param maxDim
    * @throws Exception
    */
    public void createThumbnail(String orig, String thumb, int maxDim) throws Exception {
        
        Image inImage = new ImageIcon(orig).getImage();

        double scale = (double)maxDim/(double)inImage.getHeight(null);
        
        if (inImage.getWidth(null) > inImage.getHeight(null)) {
            scale = (double)maxDim/(double)inImage.getWidth(null);
        }
        
        int scaledW = (int)(scale*inImage.getWidth(null));
        int scaledH = (int)(scale*inImage.getHeight(null));
    
        BufferedImage outImage = new BufferedImage(scaledW, scaledH, BufferedImage.TYPE_INT_RGB);
        
        AffineTransform tx = new AffineTransform();
        
        if (scale < 1.0d) { tx.scale(scale, scale);}
        
        Graphics2D g2d =  outImage.createGraphics();
        g2d.drawImage(inImage, tx, null);
        g2d.dispose();
        
        OutputStream os =  new FileOutputStream(thumb);
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        encoder.encode(outImage);
        
        os.close();
    }
    

    /**
     * 첨부파일 삭제 
     * 
     * @param CT_ID
     * @param BOARD_SEQ
     * @throws Exception
     */
    private void deleteAttachFeil(String CT_ID, String BOARD_SEQ) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();        
        ReportEntity rEntity = null;

        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" SELECT SYS_FILE_NAME         \n");
        sbSQL.append("   FROM PT_BBS_COM_FILES      \n");
        sbSQL.append("  WHERE CT_ID = ?             \n");
        sbSQL.append("    AND BOARD_SEQ = ?         \n");
        
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, BOARD_SEQ);
        
        rEntity = rDAO.select(sbSQL.toString());

        if (rEntity != null) {

            String[] fileNames = new String[rEntity.getRowCnt()];

            for (int i = 0; i < rEntity.getRowCnt(); i++) {
                fileNames[i] = rEntity.getValue(i,"SYS_FILE_NAME");
            }

            deleteComFiles(CT_ID, BOARD_SEQ, fileNames);
        }
    }
    
    
    /**
     * 첨부파일DB 삭제 메소드
     *
     * @param CT_ID
     * @param BOARD_SEQ
     * @throws Exception
     */
    private void deleteComFiles(String CT_ID, String BOARD_SEQ, String[] fileNames) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" DELETE                     \n");
        sbSQL.append("   FROM PT_BBS_COM_FILES    \n");
        sbSQL.append("  WHERE 1=1                 \n");
        sbSQL.append("    AND CT_ID = ?           \n");
        sbSQL.append("    AND BOARD_SEQ = ?       \n");
        
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, BOARD_SEQ.trim());

        rDAO.execute(sbSQL.toString());
        
        // 실제 시스템 파일 삭제
        KJFFile.deleteFile(Config.props.get("BBS_FILE_DIR") + CT_ID + KJFFile.FILE_S, fileNames); // dir에서 파일을 삭제한다.
    }
    
    
    /**
     * 첨부파일DB 삭제 메소드
     *
     * @param CT_ID
     * @param BOARD_SEQ
     * @throws Exception
     */
    private void deleteComFiles(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();

        String CT_ID         = request.getParameter("CT_ID");         // 게시판 ID
        String BOARD_SEQ     = request.getParameter("BOARD_SEQ");     // 게시판 SEQ
        String SYS_FILE_NAME = request.getParameter("SYS_FILE_NAME"); // 지울 파일이름...
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" DELETE                     \n");
        sbSQL.append("   FROM PT_BBS_COM_FILES    \n");
        sbSQL.append("  WHERE 1=1                 \n");
        sbSQL.append("    AND CT_ID = ?           \n");
        sbSQL.append("    AND BOARD_SEQ = ?       \n");
        sbSQL.append("    AND SYS_FILE_NAME = ?   \n");
        
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, BOARD_SEQ.trim());
        rDAO.setValue(3, SYS_FILE_NAME.trim());

        rDAO.execute(sbSQL.toString());
        
        // 실제 시스템 파일 삭제
        KJFFile.deleteFile(Config.props.get("BBS_FILE_DIR") + CT_ID + KJFFile.FILE_S, SYS_FILE_NAME); // dir에서 파일을 삭제한다.
    }
    
    
    /**
     * 첨부파일 업로드
     *
     * @param request
     * @param form
     * @throws Exception
     */
    private void setBBS_FILE(HttpServletRequest request, ActionForm form) throws Exception {
        
        String CT_ID = request.getParameter("CT_ID");
     
        FormFile[] BBS_FILE = ((BbsParam)form).getBBS_FILE();

        for (int i = 0; i < status.getATT_NUM(); i++) {

            if ( BBS_FILE[i] != null  && !KJFUtil.isEmpty(BBS_FILE[i].getFileName()) ) {
                saveAttachFeil(CT_ID, BOARD_SEQ, BBS_FILE[i]);
            }
        }
    }
    
    
    /**
     * 사이즈 체크 및 금지 파일 업로드 체크
     * 
     * @param request
     * @param form
     * @throws Exception
     */
    private void checkBBS_FILE(HttpServletRequest request, ActionForm form) throws Exception {
        
        FormFile[] BBS_FILE = ((BbsParam)form).getBBS_FILE();

        int fileSize = 2;   // default 2M

        if (status.getFILE_SIZE() != 0) {
            fileSize = status.getFILE_SIZE();
        }

        int sizeOfFiles = 0;

        // 전체 사이즈 체크
        for (int i = 0; i < status.getATT_NUM(); i++) {

            if ( BBS_FILE[i] != null  && !KJFUtil.isEmpty(BBS_FILE[i].getFileName()) ) {

                sizeOfFiles += BBS_FILE[i].getFileSize();

                // 금지파일 체크
                KJFFile.checkNotFile(BBS_FILE[i].getFileName());
            }
        }

        if ( sizeOfFiles  > 1024 * 1024 * fileSize) {
             throw new MsgException("파일 용량이 " + fileSize + "M 를 초과 하였습니다.");
        }       
    }

    
   /**
    * BOARD_SEQ 최대값을 가져오는 메소드 
    * 
    * @param BOARD_ID
    * @param CT_ID
    * @return String 
    * @throws Exception
    */
    private String getMaxSeq(String BOARD_ID, String CT_ID) throws Exception {
        
        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" SELECT " + KJFDBUtil.makeSql_nullFunc() + "  \n");
        sbSQL.append("        ( MAX( BOARD_SEQ), 0 ) + 1  MAXSEQ    \n");
        sbSQL.append("   FROM " + BOARD_ID + "                      \n");
        sbSQL.append("  WHERE CT_ID = ?                             \n");
        
        rDAO.setValue(1, CT_ID);     

        rEntity = rDAO.select(sbSQL.toString());

        return rEntity.getValue(0, "MAXSEQ");
    }
    

   /**
    * 인덱스1의 최대값을 구하는 메소드 
    * 
    * @param BOARD_ID
    * @param CT_ID
    * @return
    * @throws Exception
    */
    private String getMaxIndex1(String BOARD_ID,String CT_ID) throws Exception {
        
        ReportDAO       rDAO = new ReportDAO();        
        ReportEntity rEntity = null;
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" SELECT " + KJFDBUtil.makeSql_nullFunc() + "  \n");
        sbSQL.append("        ( MAX( INDEX1), 0 ) + 1 AS MAXINDEX1  \n");
        sbSQL.append("   FROM " + BOARD_ID + "                      \n");
        sbSQL.append("  WHERE CT_ID = ?                             \n");

        rDAO.setValue(1, CT_ID);     

        rEntity = rDAO.select(sbSQL.toString());

        return rEntity.getValue(0, "MAXINDEX1");
    }


    /**
     * 인덱스2의 최대값을 구하는 메소드 
     * 
     * @param BOARD_ID
     * @param CT_ID
     * @param INDEX1
     * @param INDEX2
     * @param DEPTH
     * @return
     * @throws Exception
     */
    private String getSavingIndex2(String BOARD_ID, String CT_ID, String INDEX1 , String INDEX2 , String DEPTH) throws Exception {
        
        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" SELECT MIN(INDEX2)  SAVINGINDEX2 \n");
        sbSQL.append("   FROM " + BOARD_ID + "          \n");
        sbSQL.append("  WHERE CT_ID = ?                 \n");
        sbSQL.append("    AND INDEX1 = ?                \n");
        sbSQL.append("    AND INDEX2 > ?                \n");
        sbSQL.append("    AND DEPTH <= ?                \n");
        
        rDAO.setValue(1, CT_ID);
        rDAO.setValue(2, INDEX1);
        rDAO.setValue(3, INDEX2);
        rDAO.setValue(4, DEPTH);

        rEntity = rDAO.select(sbSQL.toString());

        String SAVINGINDEX2 = rEntity.getValue(0, "SAVINGINDEX2");

        // 값이 없다는 말은 마지막에 들어가야 할 row이기때문에 가장 마지막(큰) INDEX2를 찾는다.
        if (KJFUtil.isEmpty(SAVINGINDEX2)) {
            
            rDAO = new ReportDAO();
            
            StringBuffer sbSQL2 = new StringBuffer();            
            sbSQL2.append(" SELECT MAX(INDEX2) + 1  SAVINGINDEX2    \n");
            sbSQL2.append("   FROM " + BOARD_ID + "                 \n");
            sbSQL2.append("  WHERE CT_ID = ?                        \n");
            sbSQL2.append("    AND INDEX1 = ?                       \n");
            
            rDAO.setValue(1, CT_ID);
            rDAO.setValue(2, INDEX1);
           
            rEntity = rDAO.select(sbSQL2.toString());
            
            SAVINGINDEX2= rEntity.getValue(0, "SAVINGINDEX2");
        }

        return SAVINGINDEX2;
    }

}