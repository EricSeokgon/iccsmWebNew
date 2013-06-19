
create table PT_M_MEMO(
    MEMO_DT VARCHAR2(8)  , /* */
    MEMO_CONT VARCHAR2(512)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    SEQ NUMBER(4) NOT NULL , /* */
    WRT_TIME VARCHAR2(4)  , /* */
    WRT_NAME VARCHAR2(20)  , /* */
    PRIMARY KEY(SEQ,TMP_WRT_NUM,WRT_NUM)
   );
