
create table PT_R_SUBSIDIARY_TEMP(
    SEQ VARCHAR2(3) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    RECV_NUM VARCHAR2(20) NOT NULL , /* */
    SUB_WRT_NUM VARCHAR2(50)  , /* */
    SUB_CODE VARCHAR2(6)  , /* */
    SUB_PROC VARCHAR2(2)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    PRIMARY KEY(RECV_NUM,SEQ,TMP_WRT_NUM)
   );
