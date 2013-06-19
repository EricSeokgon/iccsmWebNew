
create table PT_R_ENGINEER_M_CHANGE(
    SEQ VARCHAR2(12) NOT NULL , /* */
    CARE_BOOK_ISSUE_NUM VARCHAR2(12) NOT NULL , /* */
    DT VARCHAR2(24)  , /* */
    CHG_ITEM VARCHAR2(10)  , /* */
    CHG_ITEMS VARCHAR2(20)  , /* */
    CONFIRM VARCHAR2(1)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_DT VARCHAR2(24)  , /* */
    ETC1 VARCHAR2(20)  , /* */
    PRIMARY KEY(CARE_BOOK_ISSUE_NUM,SEQ)
   );
