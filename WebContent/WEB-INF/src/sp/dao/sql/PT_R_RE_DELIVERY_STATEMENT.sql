
create table PT_R_RE_DELIVERY_STATEMENT(
    REC_NUM VARCHAR2(32) NOT NULL , /* */
    SD_CODE VARCHAR2(2)  , /* */
    RC_REGIST_NUM VARCHAR2(20)  , /* */
    COM_NAME VARCHAR2(36)  , /* */
    REC_DATE VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    STATE_PERIOD VARCHAR2(24)  , /* */
    REGIST_NUM VARCHAR2(20)  , /* */
    STATE_ORGAN VARCHAR2(16)  , /* */
    OFFICE_TEL VARCHAR2(20)  , /* */
    STATE_RECORD_NUM VARCHAR2(16)  , /* */
    OFFICE_FAX VARCHAR2(20)  , /* */
    UDP_DT VARCHAR2(24)  , /* */
    REP_NAME VARCHAR2(20)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    OFFICE_ADDR VARCHAR2(20)  , /* */
    PRIMARY KEY(REC_NUM)
   );
