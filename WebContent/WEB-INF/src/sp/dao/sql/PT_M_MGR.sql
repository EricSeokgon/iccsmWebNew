
create table PT_M_MGR(
    M_SEQ VARCHAR2(6)  , /* */
    COI_WRT_NUM VARCHAR2(12)  , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    DISPO_CLASS VARCHAR2(1)  , /* */
    VIOL_DT VARCHAR2(8)  , /* */
    DISPO_CAUSE VARCHAR2(512)  , /* */
    NOTE_DT VARCHAR2(8)  , /* */
    NOTE_RECV_YN VARCHAR2(1)  , /* */
    NOTE_OPIN_PRES_LIM_DT VARCHAR2(8)  , /* */
    DEL_NOTE_DT VARCHAR2(8)  , /* */
    DEL_OPIN_PRES_LIM_DT VARCHAR2(8)  , /* */
    DISPO_CONT VARCHAR2(6)  , /* */
    DISPO_DT VARCHAR2(8)  , /* */
    BUSISUSP_START_DT VARCHAR2(8)  , /* */
    BUSISUSP_END_DT VARCHAR2(8)  , /* */
    REMARK VARCHAR2(256)  , /* */
    RECV_DT VARCHAR2(8)  , /* */
    MOT_STE VARCHAR2(6)  , /* */
    DOC_CODE VARCHAR2(50)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(30)  , /* */
    REGSTD_START_DT VARCHAR2(8)  , /* */
    REGSTD_END_DT VARCHAR2(8)  , /* */
    FINE VARCHAR2(30)  , /* */
    PAY_NOTI_DT VARCHAR2(8)  , /* */
    PAY_TERM VARCHAR2(8)  , /* */
    PAY_DT VARCHAR2(8)  , /* */
    DEL_RECV_YN VARCHAR2(1)  , /* */
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    SIDO_CODE VARCHAR2(6)  , /* */
    SND_STE VARCHAR2(1)  , /* */
    SND_DT VARCHAR2(8)  , /* */
    PUNISHMENT_AGENCY VARCHAR2(50)  , /* */
    DISPO_CONT_NM VARCHAR2(30)  , /* */
    AUDI_EXEC_ADDR VARCHAR2(120)  , /* */
    AUDI_EXEC_DT VARCHAR2(8)  , /* */
    AUDI_EXEC_START_TIME VARCHAR2(4)  , /* */
    AUDI_EXEC_END_TIME VARCHAR2(4)  , /* */
    AUDI_SUPINT_NM VARCHAR2(20)  , /* */
    AUDI_SUPINT_POS VARCHAR2(50)  , /* */
    PRIMARY KEY(TMP_WRT_NUM,WRT_NUM)
   );
