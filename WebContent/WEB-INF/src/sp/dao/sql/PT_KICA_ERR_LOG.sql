
create table PT_KICA_ERR_LOG(
    SEQ NUMBER(11) NOT NULL , /* */
    U_D_FLAG CHAR(1)  , /* */
    YYYYMMDD VARCHAR2(8)  , /* */
    TRANSHOUR VARCHAR2(2)  , /* */
    FILENAME VARCHAR2(60)  , /* */
    ERRLOG VARCHAR2(1000)  , /* */
    RESULT_FLAG CHAR(1)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    PRIMARY KEY(SEQ)
   );
