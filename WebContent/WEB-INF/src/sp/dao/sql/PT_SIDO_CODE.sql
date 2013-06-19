
create table PT_SIDO_CODE(
    SEQ NUMBER(4) NOT NULL , /* */
    SIDO_NM VARCHAR2(20)  , /* */
    SIGUNGU_NM VARCHAR2(40)  , /* */
    TEL VARCHAR2(24)  , /* */
    OFFPART VARCHAR2(100)  , /* */
    AREA_CODE VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    REMARK VARCHAR2(255)  , /* */
    HOME VARCHAR2(128)  , /* */
    ADDR VARCHAR2(128)  , /* */
    SIDO_CAPTAIN VARCHAR2(40)  , /* */
    SIDO_FULL_NM VARCHAR2(50)  , /* */
    SIDO_NM_CUT VARCHAR2(10)  , /* */
    SIGUNGU_NM_CUT VARCHAR2(30)  , /* */
    COI_WRT_NUM VARCHAR2(4)  , /* */
    NUM2 VARCHAR2(4)  , /* */
    SIDO_SEQ VARCHAR2(4)  , /* */
    SIGUNGU_SEQ VARCHAR2(5)  , /* */
    PRIMARY KEY(SEQ)
   );
