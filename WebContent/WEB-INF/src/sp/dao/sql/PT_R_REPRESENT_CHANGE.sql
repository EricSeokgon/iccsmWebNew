
create table PT_R_REPRESENT_CHANGE(
    CHGBRE_SEQ VARCHAR2(4) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    REP_SSN1 VARCHAR2(18)  , /* */
    REP_SSN2 VARCHAR2(21)  , /* */
    REP_NM_KOR VARCHAR2(20)  , /* */
    REP_NM_HAN VARCHAR2(20)  , /* */
    CHAR_REF_YN VARCHAR2(1)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    PRIMARY KEY(CHGBRE_SEQ,TMP_WRT_NUM)
   );
