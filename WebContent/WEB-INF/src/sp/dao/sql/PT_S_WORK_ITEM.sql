
create table PT_S_WORK_ITEM(
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    WORKNM VARCHAR2(200)  , /* */
    SPOT_ADDR VARCHAR2(200)  , /* */
    CONT_WRT_YN VARCHAR2(1)  , /* */
    ENGINEER_ARR_NOTE VARCHAR2(1)  , /* */
    CARE_BOOK_ISSUE_NUM VARCHAR2(12)  , /* */
    SPOT_TEL VARCHAR2(17)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    SEQ NUMBER(4) NOT NULL , /* */
    PRIMARY KEY(SEQ,TMP_WRT_NUM,WRT_NUM)
   );
