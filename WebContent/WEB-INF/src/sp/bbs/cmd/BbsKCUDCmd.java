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
 * <p>Description : �Խñ� ���, ����, ���� ó�� Ŭ����</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : �Խ����� ���, ����, ���� ó���� �Ѵ�.
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

        // �Խ��� �ʱ� ���� ���� �� ����.
        BbsSetConf.check(request);

        status = (StatusEnt) request.getSession().getAttribute("status");

        String cmd = request.getParameter("cmd");       
       
        request.setAttribute("url_us", "/bbs/BbsK.jsp");     
        
        // ���� ����� �ƴϰ�, ÷�� ������ ������츸
        if (!cmd.equals("BbsKD") && status.getATT_NUM() > 0) {
            checkBBS_FILE(request, form);
        }
        
        if(cmd.equals("BbsKC")) {           // �Խñ� ���
            insertBbsKC(request);
               
        } else if (cmd.equals("BbsKU")) {   // �Խñ� ����
            updateBbsKU(request);

        } else if (cmd.equals("BbsKD")) {   // �Խñ� ����           
            deleteBbsKD(request);    
            
        } else if (cmd.equals("BbsLD")) {   // ����Ʈ ���� �Խñ� ����    
            deleteBbsLD(request);
            
        } else if(cmd.equals("BbsKR")) {    // �亯�϶�
            insertBbsKR(request);

        } else if(cmd.equals("BbsKFileDel")) {          
            deleteComFiles(request);   
            
            request.setAttribute("cmdA", "BbsKWrite");
            request.setAttribute("mode", "modify");
            
            return  new BbsKWriteCmd().execute(request,form);
        }

        // ���� ����� �ƴϰ�, ÷�� ������ ������츸
        if (!cmd.equals("BbsKD") && status.getATT_NUM() > 0) {
            
            setBBS_FILE(request, form);
            
            /* ���� ���ε� (multipart/form-data) �ϰ��  ���� cmd �� �ѱ涧 ��� ������
             * null�� �ʱ� ȭ �Ǳ� ������ cmd��  "cmdA"�� �ٽ� �缳�� �Ͽ� �Ѱܾ� ����� �Ѿ��.
             * �޴� ���� ���� getAttribute�� ó�� �� ��� �Ѵ�.
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
     * �Խ��� �űԵ�� �޼ҵ�
     *
     * @param request
     * @throws Exception
     */
    private void insertBbsKC(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();

        String CT_ID    = request.getParameter("CT_ID");
        String BOARD_ID = "PT_BBS_BOARD";

        if ("N".equals(status.getTABLE_ONE_YN())) { // ���� �Խ����� �ƴϸ�
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
     * �Խ��� �亯��� �޼ҵ�
     *
     * @param request
     * @throws Exception
     */
    private void insertBbsKR(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();

        String CT_ID    = request.getParameter("CT_ID");
        String BOARD_ID = "PT_BBS_BOARD";
        String INDEX1   = request.getParameter("INDEX1"); // reply ��
        String INDEX2   = request.getParameter("INDEX2"); // reply ��
        String DEPTH    = request.getParameter("DEPTH");  // reply ��

        if ("N".equals(status.getTABLE_ONE_YN())) { // ���� �Խ����� �ƴϸ�
            BOARD_ID = "PT_BBS_" + CT_ID;
        }

        String BOARD_SEQ = getMaxSeq(BOARD_ID, CT_ID);
        String maxIndex2 = getSavingIndex2(BOARD_ID, CT_ID, INDEX1, INDEX2, DEPTH);  // �ٲ���� INDEX2

        DEPTH = (KJFUtil.str2int(DEPTH) + 1) + ""; // �亯�Ǿ����� DEPTH +1 -����� DEPTH

        // ��� ��Ͻ� �ε��� ����
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
     * �Խ��� ����Ʈ ����ó�� �޼ҵ�
     *
     * @param request
     * @throws Exception
     */
    private void updateBbsKU(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();

        String BOARD_ID = "PT_BBS_BOARD";
        String CT_ID    = request.getParameter("CT_ID");
        BOARD_SEQ       = request.getParameter("BOARD_SEQ");
                
        // ���� �Խ����� �ƴϸ�
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
     * �Խ��� ����Ʈ ����ó�� �޼ҵ� (QNA ���乮���� ������� SIDO_CODE/SIGUNGU_CODE �ϰ� ����) 
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
                
        // ���� �Խ����� �ƴϸ�
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
     * �Խ��� �Խù� ����
     *
     * @param request
     * @throws Exception
     */
    private void deleteBbsKD(HttpServletRequest request) throws Exception {
        
        String chk[] = request.getParameterValues("chk");
        String seq[] = request.getParameterValues("BOARD_SEQ");

        String CT_ID    = request.getParameter("CT_ID");
        String BOARD_ID = "PT_BBS_BOARD";

        if ("N".equals(status.getTABLE_ONE_YN())) { // ���� �Խ����� �ƴϸ�
            BOARD_ID = "PT_BBS_" + CT_ID;
        }        
        
        for (int i = 0; i < chk.length; i++) {

            int rowNum = KJFUtil.str2int(chk[i]);
            
            // ��۱�� ����̸�,
            if ( status.isREPLY()) {
                
                if (checkBbsReply(BOARD_ID, CT_ID, seq[rowNum])) {
                    deleteBbsBoard(BOARD_ID, CT_ID, seq[rowNum]);  // �Խñ� ����
                }
                
            // ��� ��� ����� �ƴϸ�
            } else {
                deleteBbsBoard(BOARD_ID, CT_ID, seq[rowNum]);       // �Խñ� ����
            }
            
            // ÷������ ��� ����̸�
            if ( status.getATT_NUM() > 0 ) {
                deleteAttachFeil(CT_ID, seq[rowNum]);      // ÷�������� �����Ѵ�.
            }
        }
    }
    
    /************************************************************************
     * �Խ��� �Խù� ����
     *
     * @param request
     * @throws Exception
     ***********************************************************************/
    private void deleteBbsLD(HttpServletRequest request) throws Exception {

        String chk[] = request.getParameterValues("chk");

        String CT_ID    = request.getParameter("CT_ID");
        String BOARD_ID = "PT_BBS_BOARD";

        if ("N".equals(status.getTABLE_ONE_YN())) { // ���� �Խ����� �ƴϸ�
            BOARD_ID = "PT_BBS_" + CT_ID;
        }

        for (int i = 0; i < chk.length; i++) {
         
            // ��۱�� ����̸�,
            if (status.isREPLY()) {
                
                if (checkBbsReply(BOARD_ID, CT_ID, chk[i])) {
                    deleteBbsBoard(BOARD_ID, CT_ID, chk[i]);  // �Խñ� ����
                }
                
            // ��� ��� ����� �ƴϸ�
            } else {
                deleteBbsBoard(BOARD_ID, CT_ID, chk[i]);  // �Խñ� ����
            }
     
            
            // ÷������ ��� ����̸�
            if ( status.getATT_NUM() > 0 ) {
                deleteAttachFeil(CT_ID, chk[i]);      // ÷�������� �����Ѵ�.
            }            
        }
    }   
    
    
    /**
     * �Խ��� �� ����
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
     * ��ۿ��� üũ
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
        
        // ����̸� ����
        if(REPLIED_YN.equals("Y")) {
            result = true;
            
        } else {
            
           // ����� �ƴϰ�, ����� �ִٸ�
           if (cnt > 1) {
               throw new MsgException(" ����� �ֽ��ϴ�. ����� �������ּ���.");
           
           // ����� �ƴϰ�, ����� ���ٸ�
           } else {
               result = true;
           }
        }
        
        return result;
    } 
    
    
    /**
     * ��� ��Ͻ� �ε��� ���� �޼ҵ�
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
     * ÷������ ����
     * 
     * @param CT_ID
     * @param BOARD_SEQ
     * @param  formFile
     * @throws Exception
     */
    private void saveAttachFeil(String CT_ID, String BOARD_SEQ, FormFile formFile ) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        String FILE_REAL_NAME = formFile.getFileName();                                     // ���� �Ǹ�
        String str            = FILE_REAL_NAME.substring(FILE_REAL_NAME.lastIndexOf("."));  // ���� Ȯ���
        String SYS_FILE_NAME  = BOARD_SEQ + "_" + new Date().getTime()+ str ;               // �����̸��� �ٲ۴�.������ ����ð� + �����̸�
        String FILE_SIZE      = formFile.getFileSize() + "";                                // ���� ������

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
        
        // ������ ���� �� ���丮 ����
        KJFFile.dirMake(CT_Dir);

        // ���� �ý��� ����
        KJFFile.saveFile(CT_Dir + KJFFile.FILE_S, SYS_FILE_NAME, formFile.getInputStream());
    }
    
    
   /**
    * ���� �̹����� �����.(����������� �������, ���ο��̸�, ���λ�����)
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
     * ÷������ ���� 
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
     * ÷������DB ���� �޼ҵ�
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
        
        // ���� �ý��� ���� ����
        KJFFile.deleteFile(Config.props.get("BBS_FILE_DIR") + CT_ID + KJFFile.FILE_S, fileNames); // dir���� ������ �����Ѵ�.
    }
    
    
    /**
     * ÷������DB ���� �޼ҵ�
     *
     * @param CT_ID
     * @param BOARD_SEQ
     * @throws Exception
     */
    private void deleteComFiles(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();

        String CT_ID         = request.getParameter("CT_ID");         // �Խ��� ID
        String BOARD_SEQ     = request.getParameter("BOARD_SEQ");     // �Խ��� SEQ
        String SYS_FILE_NAME = request.getParameter("SYS_FILE_NAME"); // ���� �����̸�...
        
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
        
        // ���� �ý��� ���� ����
        KJFFile.deleteFile(Config.props.get("BBS_FILE_DIR") + CT_ID + KJFFile.FILE_S, SYS_FILE_NAME); // dir���� ������ �����Ѵ�.
    }
    
    
    /**
     * ÷������ ���ε�
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
     * ������ üũ �� ���� ���� ���ε� üũ
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

        // ��ü ������ üũ
        for (int i = 0; i < status.getATT_NUM(); i++) {

            if ( BBS_FILE[i] != null  && !KJFUtil.isEmpty(BBS_FILE[i].getFileName()) ) {

                sizeOfFiles += BBS_FILE[i].getFileSize();

                // �������� üũ
                KJFFile.checkNotFile(BBS_FILE[i].getFileName());
            }
        }

        if ( sizeOfFiles  > 1024 * 1024 * fileSize) {
             throw new MsgException("���� �뷮�� " + fileSize + "M �� �ʰ� �Ͽ����ϴ�.");
        }       
    }

    
   /**
    * BOARD_SEQ �ִ밪�� �������� �޼ҵ� 
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
    * �ε���1�� �ִ밪�� ���ϴ� �޼ҵ� 
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
     * �ε���2�� �ִ밪�� ���ϴ� �޼ҵ� 
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

        // ���� ���ٴ� ���� �������� ���� �� row�̱⶧���� ���� ������(ū) INDEX2�� ã�´�.
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