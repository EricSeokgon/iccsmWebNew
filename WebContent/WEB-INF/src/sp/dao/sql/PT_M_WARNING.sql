
create table PT_M_WARNING(
    WARN_CONT VARCHAR2(1024)  , /* */
    WARN_DT VARCHAR2(8)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    OPIN_COLL_CONT VARCHAR2(500)  , /* */
    DECISION_DATE VARCHAR2(8)  , /* */
    LIS_END_DATE VARCHAR2(8)  , /* */
    OPINI_SUBMIT VARCHAR2(1)  , /* */
    OPINI_SUBMIT_DATE VARCHAR2(8)  , /* */
    BEFORE_DISPO VARCHAR2(1)  , /* */
    PRIMARY KEY(TMP_WRT_NUM,WRT_NUM)
   );
