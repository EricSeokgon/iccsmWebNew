package sp.bbs.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFFile;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import kjf.util.LoginException;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_BBS_COM_CTDAO;
import sp.dao.PT_BBS_COM_CTEntity;
import sp.uent.UserEnt;

/***************************************************************************
 * <p>Title       : BbsCtrlCUDCmd Class</p>
 * <p>Description : 게시판관리의 등록, 수정, 삭제 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판관리의 등록, 수정, 삭제 처리를 한다. 
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class BbsCtrlCUDCmd implements KJFCommand {
    
	private String next;
	
	private UserEnt user;
	
	private PT_BBS_COM_CTDAO  	PT_BBS_COM_CTdao = new PT_BBS_COM_CTDAO();
	private PT_BBS_COM_CTEntity PT_BBS_COM_CTent = new PT_BBS_COM_CTEntity();	

    public BbsCtrlCUDCmd() {
    }
    
    public BbsCtrlCUDCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	
               
    	String cmd = request.getParameter("cmd");
    	    	
    	user = (UserEnt)request.getSession().getAttribute("user");
    	
        PT_BBS_COM_CTent.setRequestOnlyString(request); // request 값들 자동 세팅
    	KJFLog.debug(PT_BBS_COM_CTent.toString());      // 세팅된 값들 확인

    	if (cmd.equals("BbsCtrlC")) {          // 게시판  생성
    	    createExe(request);
    	    
    	} else if (cmd.equals("BbsCtrlU")) {   // 게시판 수정
    		updateExe(request);
    		
    	} else if (cmd.equals("BbsCtrlD")) {   // 게시판 삭제
    	    dropExe(request);
    	    
    	} else if (cmd.equals("BbsCtrlTD")) {  // 게시판 초기화
    		deleteDataExe(request);
    	}

        return next;
    }


    /************************************************************************
     * 게시판 등록 처리 메소드 
     * 
     * @param HttpServletRequest
     * @return done
     ***********************************************************************/
    private void createExe(HttpServletRequest request) throws Exception {

    	ReportDAO rDAO = new ReportDAO();
    	
    	if("N".equals(request.getParameter("TABLE_ONE_YN"))) {
            
    	    StringBuffer sbSQL = new StringBuffer(); 
    	    sbSQL.append(" CREATE TABLE PT_BBS_" + PT_BBS_COM_CTent.getCT_ID() + " ( \n");
    	    
    	    sbSQL.append("     CT_ID           varchar (16) NOT NULL,  \n");   // 게시판 ID
    	    sbSQL.append("     BOARD_SEQ       int NOT NULL ,          \n");   // 게시판 SEQ
    	    sbSQL.append("     INDEX1          INTEGER NOT NULL,       \n");   // 인덱스1
    	    sbSQL.append("     INDEX2          INTEGER NOT NULL,       \n");   // 인덱스 2
    	    sbSQL.append("     DEPTH           INTEGER,                \n");   // Depth
    	    
    	    sbSQL.append("     SIDO_CODE       VARCHAR(4),             \n");   // 시도 코드
    	    sbSQL.append("     SIGUNGU_CODE    VARCHAR(4),             \n");   // 시군구 코드
    	    
    	    sbSQL.append("     USER_ID         VARCHAR (16) NULL,      \n");   // 사용자ID
    	    sbSQL.append("     USER_NAME       VARCHAR (50) NULL,      \n");   // 사용자명
    	    sbSQL.append("     USER_EMAIL      VARCHAR (100) NULL,     \n");   // 사용자 E-Mail
    	    sbSQL.append("     USER_PASS       VARCHAR (16) NULL,      \n");   // 게시물 암호
    	    sbSQL.append("     USER_IP         VARCHAR (18) NULL,      \n");   // 사용자 IP
    	    sbSQL.append("     USER_TEL        VARCHAR (14) NULL,      \n");   // 사용자 전화번호
    	    sbSQL.append("     USER_HOMEPAGE   VARCHAR (255) NULL,     \n");   // 사용자 홈페이지

    	    sbSQL.append("     SUBJECT         VARCHAR (200) NULL,     \n");   // 제목
    	    sbSQL.append("     CONTENT         CLOB,                   \n");   // 내용

    	    sbSQL.append("     REPLIED_YN      VARCHAR (1) NULL,       \n");   // 답글 여부 체크
    	    sbSQL.append("     SECRET_YN       VARCHAR (1) NULL,       \n");   // 비밀글 여부 체크
    	    sbSQL.append("     NOTICE_YN       VARCHAR (1) NULL,       \n");   // 공지사항 여부 체크
    	    
    	    sbSQL.append("     READ_NUM        INT NULL,               \n");   // 조회수
    	    sbSQL.append("     UPD_DT          VARCHAR (23) NULL,      \n");   // 수정일
    	    sbSQL.append("     INS_DT          VARCHAR (23) NULL,      \n");   // 등록일
    	    sbSQL.append("     WRT_ID          VARCHAR (16) NULL,      \n");   // 등록인

    	    sbSQL.append("     ETC_1           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_2           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_3           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_4           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_5           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_6           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_7           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_8           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_9           VARCHAR (255) NULL,     \n");
    	    sbSQL.append("     ETC_10          VARCHAR (255) NULL,     \n");
    	    
    	    sbSQL.append("     PRIMARY KEY(INDEX1, INDEX2)             \n");
    	    sbSQL.append(" )                                           \n");            
          
	    	rDAO.execute(sbSQL.toString());
    	}

    	PT_BBS_COM_CTent.setINS_DT(KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss")); // 현재 시간.
    	PT_BBS_COM_CTent.setUPD_DT(KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss")); // 수정 시간.       
    	PT_BBS_COM_CTent.setWRT_ID(user.getUSER_ID());
    	
    	PT_BBS_COM_CTdao.insert(PT_BBS_COM_CTent);
    }


    /************************************************************************
     * 게시판 수정 메소드 
     * 
     * @param HttpServletRequest
     * @return done
     ***********************************************************************/
    private void updateExe(HttpServletRequest request) throws Exception {
                
    	PT_BBS_COM_CTent.setUPD_DT(KJFDate.getCurTime("yyyy-MM-dd HH:mm:ss")); // 수정 시간.
    	PT_BBS_COM_CTent.setWRT_ID(user.getUSER_ID());

    	PT_BBS_COM_CTdao.update(PT_BBS_COM_CTent);
    }


    /************************************************************************
     * 게시판 삭제
     * 
     * @param HttpServletRequest
     * @return done
     ***********************************************************************/
    private void dropExe(HttpServletRequest request) throws Exception {

        String CT_ID = PT_BBS_COM_CTent.getCT_ID();
        
        
        deleteAttachFile(CT_ID);  // 첨부파일 삭제        
       
        deleteBbsComFile(CT_ID);  // 첨부파일 데이타 삭제        
        
        deleteBbsComment(CT_ID);  // 댓글 삭제

    	if (!"Y".equals(PT_BBS_COM_CTent.getTABLE_ONE_YN())) {	    	
	    	dropBbsTable(CT_ID);  // 테이블 삭제
    	}

    	PT_BBS_COM_CTdao.delete(PT_BBS_COM_CTent);
    }

    
    /************************************************************************
     * 게시판 게시물 삭제
     * 
     * @param HttpServletRequest
     ***********************************************************************/
    private void deleteDataExe(HttpServletRequest request) throws Exception {

    	String CT_ID = PT_BBS_COM_CTent.getCT_ID();
    	
    	deleteAttachFile(CT_ID); // 첨부파일 삭제          
        deleteBbsComFile(CT_ID); // 첨부파일 데이타 삭제            
        deleteBbsComment(CT_ID); // 댓글 삭제
        
    	if ("Y".equals(PT_BBS_COM_CTent.getTABLE_ONE_YN())) {            
    	    deleteComBoard(CT_ID);   // 통합 테이블 초기화
    		
    	} else {
    	    deleteEachBoards(CT_ID); // 단독 테이블 초기화   
    	}
    }
    
    /************************************************************************
     * 첨부파일 게시물 삭제
     * 
     * @param HttpServletRequest
     ***********************************************************************/
    private void deleteBbsComFile(String CT_ID) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" DELETE                       \n");
        sbSQL.append("   FROM PT_BBS_COM_FILES      \n");
        sbSQL.append("  WHERE CT_ID = ?             \n");
        
        rDAO.setValue(1, CT_ID);
        
        rDAO.execute(sbSQL.toString());
    }
    
    /***************************************************************************
     * 첨부파일 삭제 
     * 
     * @param CT_ID
     * @param BOARD_SEQ
     * @throws Exception
     **************************************************************************/
    private void deleteAttachFile(String CT_ID) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = null;

        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" SELECT SYS_FILE_NAME         \n");
        sbSQL.append("   FROM PT_BBS_COM_FILES      \n");
        sbSQL.append("  WHERE CT_ID = ?             \n");
        
        rDAO.setValue(1, CT_ID);

        rEntity = rDAO.select(sbSQL.toString());

        if (rEntity != null || rEntity.getRowCnt() > 0 ) { //없어도 에러는 안나나 속도 향상을 위해..

            String[] fileNames = new String[rEntity.getRowCnt()];

            for (int i = 0; i < rEntity.getRowCnt(); i++){
                fileNames[i] = rEntity.getValue(i, "SYS_FILE_NAME");
            }

            // 실제 시스템 파일 삭제
            deleteAttachFiles(CT_ID, fileNames);
        }
    }
    
    
    /***************************************************************************
     * 첨부파일DB 삭제 메소드
     *
     * @param CT_ID
     * @param BOARD_SEQ
     * @throws Exception
     **************************************************************************/
    private void deleteAttachFiles(String CT_ID, String[] fileNames) throws Exception {
        
        // 실제 시스템 파일 삭제
        KJFFile.deleteFile(Config.props.get("BBS_FILE_DIR") + CT_ID + KJFFile.FILE_S, fileNames); // dir에서 파일을 삭제한다.
        KJFFile.deleteFile(Config.props.get("BBS_FILE_IMG") + CT_ID + KJFFile.FILE_S, fileNames); // dir에서 파일을 삭제한다.
    }
    
    
    /************************************************************************
     * 첨부파일 게시물 삭제
     * 
     * @param HttpServletRequest
     ***********************************************************************/
    private void deleteBbsComment(String CT_ID) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" DELETE                       \n");
        sbSQL.append("   FROM PT_BBS_COM_COMMENT    \n");
        sbSQL.append("  WHERE CT_ID = ?             \n");
        
        rDAO.setValue(1, CT_ID);
        
        rDAO.execute(sbSQL.toString());
    }
    
    
    /************************************************************************
     * 게시판 테이블 삭제
     * 
     * @param HttpServletRequest
     ***********************************************************************/
    private void dropBbsTable(String CT_ID) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        String strSQL = " DROP TABLE PT_BBS_" + CT_ID;

        rDAO.execute(strSQL);
    }
    
    
    /************************************************************************
     * 통합 테이블 초기화
     * 
     * @param HttpServletRequest
     ***********************************************************************/
    private void deleteComBoard(String CT_ID) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" DELETE                   \n");
        sbSQL.append("   FROM PT_BBS_BOARD      \n");
        sbSQL.append("  WHERE CT_ID = ?         \n");
        
        rDAO.setValue(1, CT_ID);
        
        rDAO.execute(sbSQL.toString());
    }
    
    
    /************************************************************************
     * 단독 테이블 초기화
     * 
     * @param HttpServletRequest
     ***********************************************************************/
    private void deleteEachBoards(String CT_ID) throws Exception {
        
        ReportDAO rDAO = new ReportDAO();
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append(" DELETE                       \n");
        sbSQL.append("   FROM PT_BBS_" + CT_ID + "  \n");
        
        rDAO.execute(sbSQL.toString());
    }
    
}