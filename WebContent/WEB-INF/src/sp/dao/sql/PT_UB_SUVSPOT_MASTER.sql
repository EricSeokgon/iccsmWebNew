
create table PT_UB_SUVSPOT_MASTER(
    SEQ NUMBER(4) NOT NULL , /* */
    SUV_NAME VARCHAR2(100)  , /* */
    SUV_STANUM VARCHAR2(24)  , /* */
    SUV_NM VARCHAR2(26)  , /* */
    SUV_TELNUM VARCHAR2(24)  , /* */
    SUV_POSTNUM VARCHAR2(6)  , /* */
    SUV_ADDR VARCHAR2(64)  , /* */
    SUV_DETAILADDR VARCHAR2(128)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    SUV_MOBILE VARCHAR2(24)  , /* */
    PRIMARY KEY(SEQ)
   );
