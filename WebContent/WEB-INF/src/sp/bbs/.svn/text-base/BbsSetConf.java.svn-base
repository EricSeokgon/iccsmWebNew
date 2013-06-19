package sp.bbs;

import javax.servlet.http.HttpServletRequest;

import kjf.ops.ReportEntity;
import kjf.util.KJFUtil;
import sp.uent.UserEnt;

/**
 * <p>Title       : BbsSetConf Class</p>
 * <p>Description : bbs 모듈환경 세팅 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 *
 * NOTE : bbs 모듈환경 세팅된 정보 처리를 한다.
 *
 * @version 1.0
 * @author PKT
 */
public class BbsSetConf {

    private static boolean IsboardAdmin;
    private static String boardUserLevel;
    
    public static void check(HttpServletRequest request) throws  Exception {

        /*
         * 개별 시스템에 맞게 적절한 값을 여기에서만  변경해서 세팅을 한다.
         * 
         * 권한 Level
         * S : Super      - 시스템 관리자
         * A : Admin      - 홈페이지 관리자
         * M : Manager    - 시도 관리자
         * C : Control    - 시군구 관리자
         * U : User       - 개인회원
         * UE : enterprise - 기업회원
         * G : Guest      - 게스트 
         */
        StatusEnt status = (StatusEnt) request.getSession().getAttribute("status"); 
        
        UserEnt user = (UserEnt) request.getSession().getAttribute("user");
        
        String CT_ID = request.getParameter("CT_ID");
      
        IsboardAdmin  = false;
        boardUserLevel = "G";
        
        // 사용자 세션 정보 설정
        if ( !KJFUtil.isEmpty(user) ) {
            boardUserLevel  = KJFUtil.print(user.getCAPITAL(), "U");    // 사용자 권한 레벨
        }
        // 사용자 레벨 검사
        if ("A".equals(boardUserLevel) || "S".equals(boardUserLevel)) {            
            IsboardAdmin = true;
        }        
        
        // 게시판 정보 세팅 검색
        if ( 
        		(status == null || !KJFUtil.print(status.getCT_ID()).equals(CT_ID)) || (!KJFUtil.isEmpty(user) )
        		
            )  {
            status = new StatusEnt();
            
            status.setCT_ID(CT_ID);                 
            
            // DB에서 가져 와야 할 부분들을 세팅 한다.
            BbsWorker worker = new BbsWorker();
            
            // 게시판 정보 Load
            ReportEntity rEntity = worker.loadStatusFromDB(CT_ID);            
            
            // 게시판 세션정보 세팅
            status = setBasicSatatus(status, rEntity, user);  // 기본정보 세팅           
  
            // 리스트,읽기,쓰기 권한설정
            if (IsboardAdmin) {             
                status.setVIEW_LIST(true);
                status.setWRITE(true);
                status.setREAD(true);
            
            } else {               
                status.setVIEW_LIST(getLevelChk(rEntity.getValue(0, "LIST_LEVEL")));   // LIST_LEVEL : 리스트 권한
                status.setWRITE(getLevelChk(rEntity.getValue(0, "WRITE_LEVEL")));      // READ_LEVEL : 읽기권한
                status.setREAD(getLevelChk(rEntity.getValue(0, "READ_LEVEL")));        // WRITE_LEVEL : 쓰기권한
            }

            request.getSession().setAttribute("status", status);
        }       
    }
    
    
    /**
     * 게시판 기본정보 설정
     * 
     * @param rEntity
     * @return
     * @throws Exception
     */
    public static StatusEnt setBasicSatatus(StatusEnt status, ReportEntity rEntity, UserEnt user) throws Exception {
                
        // 사용자 정보 등록
        if ( !KJFUtil.isEmpty(user) ) {
            
            status.setUSER_ID(user.getUSER_ID());           // 사용자 ID
            status.setUSER_NAME(user.getUSER_NAME());       // 사용자 이름
            status.setUSER_EMAIL(user.getUSER_EMAIL());     // 사용자 E-Mail
            status.setUSER_Tel(user.getUSER_TEL());         // 사용자 전화번호
            
            status.setSIDO_CODE(user.getSIDO_CODE());       // 시.도 코드
            status.setSIGUNGU_CODE(user.getSIGUNGU_CODE()); // 시.구.군 코드
            
            status.setLOGIN(true);                          // 로그인 유무 
            status.setADMIN(IsboardAdmin);                  // 관리자 권한 유무
        }
        
        status.setTABLE_ONE_YN(rEntity.getValue(0, "TABLE_ONE_YN"));                // 게시판 DB타입
        status.setURL(rEntity.getValue(0, "BOARD_URL"));                            // 게시판 URL
        status.setBOARD_NAME(rEntity.getValue(0, "BOARD_NAME"));                    // 게시판 명
        status.setTYPE(rEntity.getValue(0, "BOARD_TYPE"));                          // 게시판 타입
        status.setSKIN(rEntity.getValue(0, "BOARD_SKIN"));                          // 게시판 스킨
        status.setBOARD_WIDTH(rEntity.getValue(0, "BOARD_WIDTH"));                  // 게시판 넓이
        status.setBOARD_ALIGN(rEntity.getValue(0, "BOARD_ALIGN"));                  // 게시판 정렬
        status.setCUT_TITLE(rEntity.getValue(0, "CUT_TITLE"));                      // 타이틀 길이

        status.setATTACH(KJFUtil.yn2Boolean(rEntity.getValue(0, "ATTACH_YN")));     // 첨부파일 사용여부
        status.setSECRET_YN(KJFUtil.yn2Boolean(rEntity.getValue(0, "SECRET_YN")));  // 비밀글 사용여부
        status.setREPLY(KJFUtil.yn2Boolean(rEntity.getValue(0, "REPLY_YN")));       // 답글 사용 여부
        status.setONE_LINE(KJFUtil.yn2Boolean(rEntity.getValue(0, "ONE_LINE_YN"))); // 댓글 사용 여부

        status.setTITLE_WRT_YN(KJFUtil.yn2Boolean(rEntity.getValue(0, "TITLE_WRT_YN")));  // 작성자 보이기
        status.setTITLE_DATE_YN(KJFUtil.yn2Boolean(rEntity.getValue(0, "TITLE_DATE_YN")));  // 리스트 날짜보이기
        status.setTITLE_HIT_YN(KJFUtil.yn2Boolean(rEntity.getValue(0, "TITLE_HIT_YN")));    // 히트수 보이기
        status.setTITLE_IP_YN(KJFUtil.yn2Boolean(rEntity.getValue(0, "TITLE_IP_YN")));      // 아이피 보이기

        /*
         * 게시판 외부 스킨 사용시
         * 글쓰기 본문에 특정 양식 사용시
         */
        status.setHEADER_HTML(KJFUtil.print(rEntity.getValue(0, "HEADER_HTML")));   // 상의
        status.setMAIN_HTML(KJFUtil.print(rEntity.getValue(0, "MAIN_HTML")));       // 메인
        status.setBOTTOM_HTML(KJFUtil.print(rEntity.getValue(0, "BOTTOM_HTML")));   // 아래

        status.setFILTER(rEntity.getValue(0, "FILTER"));                            // 필터
        
        status.setATT_NUM(KJFUtil.str2int(rEntity.getValue(0, "ATT_NUM")));         // 첨부파일
        status.setROWPERPAGE(KJFUtil.str2int(rEntity.getValue(0, "ROWPERPAGE")));   // 페이징 갯수
        status.setNEW_DAY(KJFUtil.str2int(rEntity.getValue(0, "NEW_DAY")));         // 발광표시일
        status.setFILE_SIZE(KJFUtil.str2int(rEntity.getValue(0, "FILE_SIZE")));     // 파일 사이즈
        status.setONE_ONE(KJFUtil.yn2Boolean(rEntity.getValue(0, "ONE_ONE_YN")));   // 1대1 게시판
        status.setDIV_USE(KJFUtil.yn2Boolean(rEntity.getValue(0, "DIV_USE_YN")));   // 분류사용여부
        status.setSD_DIV_YN(KJFUtil.yn2Boolean(rEntity.getValue(0, "SD_DIV_YN")));   // 시도 분류사용여부
        status.setSGG_DIV_YN(KJFUtil.yn2Boolean(rEntity.getValue(0, "SGG_DIV_YN"))); // 시군구 분류사용여부
        

        // 게시판 필드 항목 추가
        status.setSUBJ_1(KJFUtil.print(rEntity.getValue(0, "SUBJ_1")));
        status.setSUBJ_2(KJFUtil.print(rEntity.getValue(0, "SUBJ_2")));
        status.setSUBJ_3(KJFUtil.print(rEntity.getValue(0, "SUBJ_3")));
        status.setSUBJ_4(KJFUtil.print(rEntity.getValue(0, "SUBJ_4")));
        status.setSUBJ_5(KJFUtil.print(rEntity.getValue(0, "SUBJ_5")));
        status.setSUBJ_6(KJFUtil.print(rEntity.getValue(0, "SUBJ_6")));
        status.setSUBJ_7(KJFUtil.print(rEntity.getValue(0, "SUBJ_7")));
        status.setSUBJ_8(KJFUtil.print(rEntity.getValue(0, "SUBJ_8")));
        status.setSUBJ_9(KJFUtil.print(rEntity.getValue(0, "SUBJ_9")));
        status.setSUBJ_10(KJFUtil.print(rEntity.getValue(0, "SUBJ_10")));       
            
        return status;
    }   
   
    
    /**
     * 리스트, 읽기, 쓰기 권한 세팅
     * 
     * @param status
     * @param rEntity
     * @return
     * @throws Exception
     */
    public static boolean getLevelChk(String level) throws Exception {        
             
        // 전체 허용 : Guest
        if (level.equals("G")) {
            return true;
            
        // 회원만 허용 : User
        } else if(level.equals("U")) {
            
            if ( !"G".equals(boardUserLevel) ) {
                return true;
            }            
            
        // 시도관리자만 허용 : Manager
        } else if (level.equals("M")) {
            if ( "M".equals(boardUserLevel) ) {
                return true;
            }
        
        // 시.군.구 관리자만 허용 : Control
        } else if (level.equals("C")) {
            if ( "C".equals(boardUserLevel) ) {
                return true;
            }
        
        // 시도/시.군.구 관리자만 허용 : Manager,Control
        } else if (level.equals("MC")) {
            if ( "M".equals(boardUserLevel) || "C".equals(boardUserLevel) ) {
                return true;
            }
        }
        
        return false;
    }
}
