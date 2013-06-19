
create table PT_R_ENGINEER_M_SKILL(
    SEQ VARCHAR2(12) NOT NULL , /* */
    CARE_BOOK_ISSUE_NUM VARCHAR2(12) NOT NULL , /* */
    ITEM_GRADE VARCHAR2(10)  , /* */
    WRT_NUM VARCHAR2(12)  , /* */
    PAS_YMD VARCHAR2(8)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    ETC1 VARCHAR2(20)  , /* */
    PRIMARY KEY(CARE_BOOK_ISSUE_NUM,SEQ)
   );
