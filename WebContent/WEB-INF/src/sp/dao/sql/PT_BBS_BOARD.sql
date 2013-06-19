
create table PT_BBS_BOARD(
    CT_ID VARCHAR2(16)  , /* */
    BOARD_SEQ NUMBER(22)  , /* */
    INDEX1 NUMBER(22) NOT NULL , /* */
    INDEX2 NUMBER(22) NOT NULL , /* */
    DEPTH NUMBER(22)  , /* */
    SD_CD VARCHAR2(4)  , /* */
    SGG_CD VARCHAR2(4)  , /* */
    USER_ID VARCHAR2(16)  , /* */
    USER_NAME VARCHAR2(50)  , /* */
    USER_EMAIL VARCHAR2(100)  , /* */
    USER_PASS VARCHAR2(16)  , /* */
    USER_IP VARCHAR2(18)  , /* */
    USER_TEL VARCHAR2(14)  , /* */
    USER_HOMEPAGE VARCHAR2(255)  , /* */
    SUBJECT VARCHAR2(200)  , /* */
    CONTENT CLOB  , /* */
    REPLIED_YN VARCHAR2(1)  , /* */
    SECRET_YN VARCHAR2(1)  , /* */
    NOTICE_YN VARCHAR2(1)  , /* */
    READ_NUM NUMBER(22)  , /* */
    UPD_DT VARCHAR2(23)  , /* */
    INS_DT VARCHAR2(23)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    ETC_1 VARCHAR2(255)  , /* */
    ETC_2 VARCHAR2(255)  , /* */
    ETC_3 VARCHAR2(255)  , /* */
    ETC_4 VARCHAR2(255)  , /* */
    ETC_5 VARCHAR2(255)  , /* */
    ETC_6 VARCHAR2(255)  , /* */
    ETC_7 VARCHAR2(255)  , /* */
    ETC_8 VARCHAR2(255)  , /* */
    ETC_9 VARCHAR2(255)  , /* */
    ETC_10 VARCHAR2(255)  , /* */
    PRIMARY KEY(INDEX1,INDEX2)
   );
