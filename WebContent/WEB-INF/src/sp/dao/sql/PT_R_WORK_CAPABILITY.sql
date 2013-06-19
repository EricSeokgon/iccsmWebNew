
create table PT_R_WORK_CAPABILITY(
    SEQ NUMBER(4) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    COI_WRT_NUM VARCHAR2(12)  , /* */
    ASSE_DT VARCHAR2(8)  , /* */
    ASSE_AOM VARCHAR2(15)  , /* */
    APPL_TERM_START_DT VARCHAR2(8)  , /* */
    CONFIRM VARCHAR2(1)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    APPL_TERM_END_DT VARCHAR2(8)  , /* */
    PRIMARY KEY(SEQ,TMP_WRT_NUM)
   );
