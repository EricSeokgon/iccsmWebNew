
create table P_S_MASTER(
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    WRT_DT VARCHAR2(8)  , /* */
    INV_EXPC_DT VARCHAR2(8)  , /* */
    INV_DT VARCHAR2(8)  , /* */
    PROC_STE VARCHAR2(6)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    MOT_STE VARCHAR2(6)  , /* */
    PRIMARY KEY(TMP_WRT_NUM,WRT_NUM)
   );
