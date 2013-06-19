package sp.bbs;

public class StatusEnt {

    private String USER_ID      = "";     // 사용자ID
    private String USER_NAME    = "";     // 사용자명
    private String USER_EMAIL   = "";     // 사용자E-mail
    private String USER_Tel     = "";     // 사용자 전화번호
    private String SIDO_CODE    = "";     // 시도 코드
    private String SIGUNGU_CODE = "";     // 시군구 코드

    private String TABLE_ONE_YN = "";
    private String CT_ID        = "";
    private String BOARD_NAME   = "";
    private String TYPE         = "";
    private String URL          = "";

    private int NEW_DAY    = 0;  // 발광표시 일자
    private int ROWPERPAGE = 0;  // 리스트 목록갯수
    private int FILE_SIZE  = 0;  // 파일사이즈
    private int ATT_NUM    = 0;  // 파일첨부

    private boolean ADMIN      = false;  // 관리자 유무
    private boolean REPLY      = false;  // 답변허용
    private boolean LOGIN      = false;  // 로긴(회원제 사용)
    private boolean WRITE      = false;  // 쓰기권한이 없으면 관리자만 쓰기 가능함.
    private boolean READ       = false;  // 읽기권한이 없으면 관리자만 읽기 가능함.
    private boolean ATTACH     = false;  // 첨부파일

    private boolean ONE_LINE   = false;  // 한줄답변
    private boolean ONE_ONE    = false;  // 일대일 여부.
    private boolean VIEW_LIST  = false;  // 상세보기 + 목록
    private boolean DIV_USE    = false;  // 분류 사용 유무
    private boolean SD_DIV_YN  = false;  // 시도 분류 사용 유무
    private boolean SGG_DIV_YN = false;  // 시군구 분류 사용 유무


    /* 기타 항목 추가 */
    private String SKIN        = "";
    private String BOARD_WIDTH = ""; // 게시판 폰
    private String BOARD_ALIGN = ""; // 게시판 정렬
    private String CUT_TITLE   = ""; // 제목 길이
    private String HEADER_HTML = ""; // 헤더 HTML
    private String MAIN_HTML   = ""; // 본문 HTML
    private String BOTTOM_HTML = ""; // 풋터 HTML
    private String FILTER      = ""; // 필터

    private String SUBJ_1  = ""; // 추가항목1
    private String SUBJ_2  = ""; // 추가항목2
    private String SUBJ_3  = ""; // 추가항목3
    private String SUBJ_4  = ""; // 추가항목4
    private String SUBJ_5  = ""; // 추가항목5
    private String SUBJ_6  = ""; // 추가항목6
    private String SUBJ_7  = ""; // 추가항목7
    private String SUBJ_8  = ""; // 추가항목8
    private String SUBJ_9  = ""; // 추가항목9
    private String SUBJ_10 = ""; // 추가항목10

    private boolean TITLE_WRT_YN  = false;  // 작성자 표시 유무
    private boolean TITLE_DATE_YN = false;  // 날자 표시 유무
    private boolean TITLE_HIT_YN  = false;  // 히트수 유무
    private boolean TITLE_IP_YN   = false;  // 아이피 표시 유무
    private boolean SECRET_YN     = false;  // 비밀글  유무

    public StatusEnt()  {
    }
    

    public String getBOARD_NAME() {
        return BOARD_NAME;
    }


    public void setBOARD_NAME(String board_name) {
        BOARD_NAME = board_name;
    }

    
    public String getURL() {
        return URL;
    }


    public void setURL(String url) {
        URL = url;
    }


    public String getCT_ID() {
        return CT_ID;
    }


    public void setCT_ID(String ct_id) {
        CT_ID = ct_id;
    }
    

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }


    public void setUSER_EMAIL(String user_email) {
        USER_EMAIL = user_email;
    }


    public String getUSER_ID() {
        return USER_ID;
    }


    public void setUSER_ID(String user_id) {
        USER_ID = user_id;
    }


    public String getUSER_NAME() {
        return USER_NAME;
    }


    public void setUSER_NAME(String user_name) {
        USER_NAME = user_name;
    }


    public boolean isADMIN() {
        return ADMIN;
    }


    public void setADMIN(boolean admin) {
        ADMIN = admin;
    }
    

    public int getATT_NUM() {
        return ATT_NUM;
    }


    public void setATT_NUM(int att_num) {
        ATT_NUM = att_num;
    }


    public boolean isLOGIN() {
        return LOGIN;
    }


    public void setLOGIN(boolean login) {
        LOGIN = login;
    }


    public boolean isONE_LINE() {
        return ONE_LINE;
    }


    public void setONE_LINE(boolean one_line) {
        ONE_LINE = one_line;
    }


    public boolean isREAD() {
        return READ;
    }


    public void setREAD(boolean read) {
        READ = read;
    }


    public boolean isREPLY() {
        return REPLY;
    }


    public void setREPLY(boolean reply) {
        REPLY = reply;
    }


    public boolean isWRITE() {
        return WRITE;
    }


    public void setWRITE(boolean write) {
        WRITE = write;
    }


    public String getTYPE() {
        return TYPE;
    }


    public void setTYPE(String type) {
        TYPE = type;
    }


    public int getFILE_SIZE() {
        return FILE_SIZE;
    }


    public void setFILE_SIZE(int file_size) {
        FILE_SIZE = file_size;
    }


    public int getROWPERPAGE() {
        return ROWPERPAGE;
    }


    public void setROWPERPAGE(int rowperpage) {
        ROWPERPAGE = rowperpage;
    }
    
    
    public int getNEW_DAY() {
        return NEW_DAY;
    }


    public void setNEW_DAY(int new_day) {
        NEW_DAY = new_day;
    }
    
    
    public String getSIDO_CODE() {
        return SIDO_CODE;
    }


    public void setSIDO_CODE(String sido_code) {
        SIDO_CODE = sido_code;
    }


    public String getSIGUNGU_CODE() {
        return SIGUNGU_CODE;
    }


    public void setSIGUNGU_CODE(String sigungu_code) {
        SIGUNGU_CODE = sigungu_code;
    }



    public boolean isONE_ONE() {
        return ONE_ONE;
    }


    public void setONE_ONE(boolean one_one) {
        ONE_ONE = one_one;
    }


    public boolean isVIEW_LIST() {
        return VIEW_LIST;
    }


    public void setVIEW_LIST(boolean view_list) {
        VIEW_LIST = view_list;
    }


    public boolean isDIV_USE() {
        return DIV_USE;
    }


    public void setDIV_USE(boolean div_use) {
        DIV_USE = div_use;
    }


    public String getUSER_Tel() {
        return USER_Tel;
    }


    public void setUSER_Tel(String tel) {
        USER_Tel = tel;
    }


    public String getBOARD_ALIGN() {
        return BOARD_ALIGN;
    }


    public void setBOARD_ALIGN(String board_align) {
        BOARD_ALIGN = board_align;
    }


    public String getBOARD_WIDTH() {
        return BOARD_WIDTH;
    }


    public void setBOARD_WIDTH(String board_width) {
        BOARD_WIDTH = board_width;
    }


    public String getBOTTOM_HTML() {
        return BOTTOM_HTML;
    }


    public void setBOTTOM_HTML(String bottom_html) {
        BOTTOM_HTML = bottom_html;
    }


    public String getCUT_TITLE() {
        return CUT_TITLE;
    }


    public void setCUT_TITLE(String cut_title) {
        CUT_TITLE = cut_title;
    }


    public String getFILTER() {
        return FILTER;
    }


    public void setFILTER(String filter) {
        FILTER = filter;
    }


    public String getHEADER_HTML() {
        return HEADER_HTML;
    }


    public void setHEADER_HTML(String header_html) {
        HEADER_HTML = header_html;
    }


    public String getMAIN_HTML() {
        return MAIN_HTML;
    }


    public void setMAIN_HTML(String main_html) {
        MAIN_HTML = main_html;
    }
    
    
    public boolean isATTACH() {
        return ATTACH;
    }


    public void setATTACH(boolean attach) {
        ATTACH = attach;
    }


    public boolean isSECRET_YN() {
        return SECRET_YN;
    }


    public void setSECRET_YN(boolean secret_yn) {
        SECRET_YN = secret_yn;
    }


    public String getSKIN() {
        return SKIN;
    }


    public void setSKIN(String skin) {
        SKIN = skin;
    }


    public boolean isTITLE_DATE_YN() {
        return TITLE_DATE_YN;
    }


    public void setTITLE_DATE_YN(boolean title_date) {
        TITLE_DATE_YN = title_date;
    }
    

    public boolean isTITLE_HIT_YN() {
        return TITLE_HIT_YN;
    }


    public void setTITLE_HIT_YN(boolean title_hit) {
        TITLE_HIT_YN = title_hit;
    }


    public boolean isTITLE_IP_YN() {
        return TITLE_IP_YN;
    }


    public void setTITLE_IP_YN(boolean title_ip) {
        TITLE_IP_YN = title_ip;
    }


    public String getTABLE_ONE_YN() {
        return TABLE_ONE_YN;
    }


    public void setTABLE_ONE_YN(String table_one_yn) {
        TABLE_ONE_YN = table_one_yn;
    }
    
    public boolean isSD_DIV_YN() {
        return SD_DIV_YN;
    }


    public void setSD_DIV_YN(boolean sd_div_yn) {
        SD_DIV_YN = sd_div_yn;
    }


    public boolean isSGG_DIV_YN() {
        return SGG_DIV_YN;
    }


    public void setSGG_DIV_YN(boolean sgg_div_yn) {
        SGG_DIV_YN = sgg_div_yn;
    }


    public boolean isTITLE_WRT_YN() {
        return TITLE_WRT_YN;
    }


    public void setTITLE_WRT_YN(boolean title_wrt_yn) {
        TITLE_WRT_YN = title_wrt_yn;
    }


    public String getSUBJ_1() {
        return SUBJ_1;
    }


    public void setSUBJ_1(String subj_1) {
        SUBJ_1 = subj_1;
    }


    public String getSUBJ_10() {
        return SUBJ_10;
    }


    public void setSUBJ_10(String subj_10) {
        SUBJ_10 = subj_10;
    }


    public String getSUBJ_2() {
        return SUBJ_2;
    }


    public void setSUBJ_2(String subj_2) {
        SUBJ_2 = subj_2;
    }


    public String getSUBJ_3() {
        return SUBJ_3;
    }


    public void setSUBJ_3(String subj_3) {
        SUBJ_3 = subj_3;
    }


    public String getSUBJ_4() {
        return SUBJ_4;
    }


    public void setSUBJ_4(String subj_4) {
        SUBJ_4 = subj_4;
    }


    public String getSUBJ_5() {
        return SUBJ_5;
    }


    public void setSUBJ_5(String subj_5) {
        SUBJ_5 = subj_5;
    }


    public String getSUBJ_6() {
        return SUBJ_6;
    }


    public void setSUBJ_6(String subj_6) {
        SUBJ_6 = subj_6;
    }


    public String getSUBJ_7() {
        return SUBJ_7;
    }


    public void setSUBJ_7(String subj_7) {
        SUBJ_7 = subj_7;
    }


    public String getSUBJ_8() {
        return SUBJ_8;
    }


    public void setSUBJ_8(String subj_8) {
        SUBJ_8 = subj_8;
    }


    public String getSUBJ_9() {
        return SUBJ_9;
    }


    public void setSUBJ_9(String subj_9) {
        SUBJ_9 = subj_9;
    }

}
