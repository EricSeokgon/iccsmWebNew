
create table PT_M_BEF_REPORT(
    SEQ NUMBER(4) NOT NULL , /* */
    NOTE_CLASS_CODE VARCHAR2(6)  , /* */
    SEND_DT VARCHAR2(8)  , /* */
    S_PER VARCHAR2(16)  , /* */
    PROC_LIM VARCHAR2(8)  , /* */
    RECV_YN VARCHAR2(1)  , /* */
    REMARK VARCHAR2(256)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    RECV_LOC VARCHAR2(100)  , /* */
    NOTE_METHOD_CLASS VARCHAR2(6)  , /* */
    GUBUN VARCHAR2(1)  , /* */
    PRIMARY KEY(SEQ,TMP_WRT_NUM,WRT_NUM)
   );
