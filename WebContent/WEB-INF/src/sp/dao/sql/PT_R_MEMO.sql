
create table PT_R_MEMO(
    MEMO_SEQ NUMBER(4) NOT NULL , /* */
    MEMO_CONT VARCHAR2(256)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    RECV_NUM VARCHAR2(12) NOT NULL , /* */
    SIDO_CODE VARCHAR2(4) NOT NULL , /* */
    INS_DT VARCHAR2(24)  , /* */
    WRT_DT VARCHAR2(8)  , /* */
    PRIMARY KEY(MEMO_SEQ,RECV_NUM,SIDO_CODE)
   );
