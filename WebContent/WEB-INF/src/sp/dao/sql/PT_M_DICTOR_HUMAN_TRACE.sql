
create table PT_M_DICTOR_HUMAN_TRACE(
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    OFFI_CODE VARCHAR2(16)  , /* */
    INVER_PART VARCHAR2(50)  , /* */
    INVER_POS VARCHAR2(50)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    SEQ NUMBER(4) NOT NULL , /* */
    PRIMARY KEY(SEQ,TMP_WRT_NUM,WRT_NUM)
   );
