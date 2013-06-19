
create table PT_S_CAPABILLITY_ASSESSMENT(
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    CARE_BOOK_ISSUE_NUM VARCHAR2(12)  , /* */
    ADDR VARCHAR2(200)  , /* */
    QUAL_NUM VARCHAR2(12)  , /* */
    PAY VARCHAR2(10)  , /* */
    ARR_SPOT VARCHAR2(200)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    SEQ NUMBER(4) NOT NULL , /* */
    PRIMARY KEY(SEQ,TMP_WRT_NUM,WRT_NUM)
   );
