
create table PT_R_WORK_RESULTS_TEMP(
    SEQ VARCHAR2(4) NOT NULL , /* */
    RECV_NUM VARCHAR2(12) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    SIDO_CODE VARCHAR2(4)  , /* */
    WORK_PROC VARCHAR2(2)  , /* */
    YEAR VARCHAR2(4)  , /* */
    WORK_ROM VARCHAR2(15)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    PRIMARY KEY(RECV_NUM,SEQ,TMP_WRT_NUM)
   );
