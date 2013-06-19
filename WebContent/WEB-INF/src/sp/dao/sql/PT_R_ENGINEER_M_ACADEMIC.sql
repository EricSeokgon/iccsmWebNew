
create table PT_R_ENGINEER_M_ACADEMIC(
    SEQ VARCHAR2(12) NOT NULL , /* */
    CARE_BOOK_ISSUE_NUM VARCHAR2(15) NOT NULL , /* */
    SCHNM VARCHAR2(50)  , /* */
    SUBJ_MAJ VARCHAR2(50)  , /* */
    GRA_YMD VARCHAR2(12)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_DT VARCHAR2(24)  , /* */
    ETC1 VARCHAR2(20)  , /* */
    PRIMARY KEY(CARE_BOOK_ISSUE_NUM,SEQ)
   );
