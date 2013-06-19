
create table PT_KICA_TRANS_LOG(
    SEQ NUMBER(11) NOT NULL , /* */
    U_D_FLAG CHAR(1)  , /* */
    TABLE_NAME VARCHAR2(60)  , /* */
    LOG VARCHAR2(2000)  , /* */
    ERR_YN CHAR(1)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    PRIMARY KEY(SEQ)
   );
