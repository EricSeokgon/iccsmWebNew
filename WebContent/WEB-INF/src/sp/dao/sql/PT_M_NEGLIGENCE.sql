
create table PT_M_NEGLIGENCE(
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    OPIN_COLL_DT VARCHAR2(8)  , /* */
    OPIN_COLL_CONT VARCHAR2(1024)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    NEFI NUMBER(14)  , /* */
    PAY_LIM VARCHAR2(8)  , /* */
    PAY_DT VARCHAR2(8)  , /* */
    PAY_YN VARCHAR2(1)  , /* */
    REMARK VARCHAR2(512)  , /* */
    DESION_DATE VARCHAR2(8)  , /* */
    LIS_END_DATE VARCHAR2(8)  , /* */
    OPINI_SUBMIT VARCHAR2(1)  , /* */
    BEFORE_DISPO VARCHAR2(1)  , /* */
    OPINI_SUBMIT_DATE VARCHAR2(8)  , /* */
    PRIMARY KEY(TMP_WRT_NUM,WRT_NUM)
   );
