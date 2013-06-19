
create table PT_BBS_COM_CT(
    CT_ID VARCHAR2(30) NOT NULL , /* */
    BOARD_NAME VARCHAR2(50)  , /* */
    BOARD_URL VARCHAR2(128)  , /* */
    BOARD_CATEGORY VARCHAR2(128)  , /* */
    BOARD_TYPE VARCHAR2(64)  , /* */
    BOARD_SKIN VARCHAR2(64)  , /* */
    BOARD_WIDTH VARCHAR2(10)  , /* */
    BOARD_ALIGN VARCHAR2(20)  , /* */
    BBS_OWNER VARCHAR2(16)  , /* */
    BBS_GROUP VARCHAR2(32)  , /* */
    BBS_DEPTH NUMBER(5)  , /* */
    CUT_TITLE NUMBER(5)  , /* */
    ROWPERPAGE NUMBER(5)  , /* */
    NEW_DAY NUMBER(5)  , /* */
    TITLE_WRT_YN VARCHAR2(1)  , /* */
    TITLE_DATE_YN VARCHAR2(1)  , /* */
    TITLE_HIT_YN VARCHAR2(1)  , /* */
    TITLE_IP_YN VARCHAR2(1)  , /* */
    HEADER_HTML CLOB  , /* */
    MAIN_HTML CLOB  , /* */
    BOTTOM_HTML CLOB  , /* */
    LIST_LEVEL VARCHAR2(36)  , /* */
    READ_LEVEL VARCHAR2(36)  , /* */
    WRITE_LEVEL VARCHAR2(36)  , /* */
    ATTACH_YN VARCHAR2(1)  , /* */
    FILE_SIZE NUMBER(5)  , /* */
    ATT_NUM NUMBER(5)  , /* */
    REPLY_YN VARCHAR2(1)  , /* */
    ONE_LINE_YN VARCHAR2(1)  , /* */
    SECRET_YN VARCHAR2(1)  , /* */
    USE_YN VARCHAR2(1)  , /* */
    DIV_USE_YN VARCHAR2(1)  , /* */
    SD_DIV_YN VARCHAR2(1)  , /* */
    SGG_DIV_YN VARCHAR2(1)  , /* */
    VIEW_LIST_YN VARCHAR2(1)  , /* */
    ONE_ONE_YN VARCHAR2(1)  , /* */
    FILTER VARCHAR2(50)  , /* */
    TABLE_ONE_YN VARCHAR2(1)  , /* */
    SUBJ_1 VARCHAR2(50)  , /* */
    SUBJ_2 VARCHAR2(50)  , /* */
    SUBJ_3 VARCHAR2(50)  , /* */
    SUBJ_4 VARCHAR2(50)  , /* */
    SUBJ_5 VARCHAR2(50)  , /* */
    SUBJ_6 VARCHAR2(50)  , /* */
    SUBJ_7 VARCHAR2(50)  , /* */
    SUBJ_8 VARCHAR2(50)  , /* */
    SUBJ_9 VARCHAR2(50)  , /* */
    SUBJ_10 VARCHAR2(50)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    PUBLIC_DIV_YN VARCHAR2(1)  , /* */
    PRIMARY KEY(CT_ID)
   );
