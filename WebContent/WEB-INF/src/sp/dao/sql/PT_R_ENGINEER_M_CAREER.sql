
create table PT_R_ENGINEER_M_CAREER(
    SEQ VARCHAR2(12) NOT NULL , /* */
    CARE_BOOK_ISSUE_NUM VARCHAR2(12) NOT NULL , /* */
    POW VARCHAR2(10)  , /* */
    CARETERM_START_DT VARCHAR2(8)  , /* */
    CARETERM_END_DT VARCHAR2(8)  , /* */
    OFF_WORK VARCHAR2(20)  , /* */
    EXCH_CARE VARCHAR2(6)  , /* */
    CARE_TOT VARCHAR2(6)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    ETC1 VARCHAR2(30)  , /* */
    PRIMARY KEY(CARE_BOOK_ISSUE_NUM,SEQ)
   );
