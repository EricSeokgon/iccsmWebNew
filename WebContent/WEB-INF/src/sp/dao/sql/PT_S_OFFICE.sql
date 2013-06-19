
create table PT_S_OFFICE(
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    AREA VARCHAR2(6)  , /* */
    OWN_POSS_YN VARCHAR2(1)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    PRIMARY KEY(TMP_WRT_NUM,WRT_NUM)
   );
