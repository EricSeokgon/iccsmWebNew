
create table PT_SAMPLE(
    REC_NUM VARCHAR2(32) NOT NULL , /* */
    REG_NUM VARCHAR2(32) NOT NULL , /* */
    SC_CODE VARCHAR2(2)  , /* */
    SGG_CODE VARCHAR2(2)  , /* */
    REC_DATE VARCHAR2(24)  , /* */
    PRO_PERIOD VARCHAR2(24)  , /* */
    PRO_DUTY VARCHAR2(16)  , /* */
    PRO_REC_NUM VARCHAR2(16)  , /* */
    COMPANY_NM VARCHAR2(32)  , /* */
    APPLICANT VARCHAR2(24)  , /* */
    TEL VARCHAR2(16)  , /* */
    FAX VARCHAR2(16)  , /* */
    REMEMBRANCER VARCHAR2(24)  , /* */
    SSN1 NUMBER(6)  , /* */
    SSN2 NUMBER(7)  , /* */
    POST_CODE VARCHAR2(8)  , /* */
    ADDR VARCHAR2(64)  , /* */
    ADDR_ETC VARCHAR2(64)  , /* */
    PUBLIC_WORK VARCHAR2(8)  , /* */
    REP_NUM VARCHAR2(32)  , /* */
    REC_DUTY VARCHAR2(24)  , /* */
    REC_WRITE VARCHAR2(16)  , /* */
    REC_INS_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UDP_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    NOTE VARCHAR2(128)  , /* */
    PRIMARY KEY(REC_NUM,REG_NUM)
   );
