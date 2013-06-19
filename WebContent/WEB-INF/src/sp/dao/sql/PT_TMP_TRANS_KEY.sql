
create table PT_TMP_TRANS_KEY(
    WORK_CLASS_CODE VARCHAR2(18)  , /* */
    KEY1 VARCHAR2(20)  , /* */
    KEY2 VARCHAR2(20)  , /* */
    KEY3 VARCHAR2(20)  , /* */
    KEY4 VARCHAR2(20)  , /* */
    KEY5 VARCHAR2(20)  , /* */
    CUD_FLAG VARCHAR2(1)  , /* */
    SEQ VARCHAR2(18) NOT NULL , /* */
    INS_DT VARCHAR2(24)  , /* */
    PRIMARY KEY(SEQ)
   );
