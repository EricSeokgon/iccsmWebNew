
create table PT_R_REGMGR_ENG_DEFICIT(
    TMP_REG_NUM CHAR(18) NOT NULL , /* */
    SEQ NUMBER(11) NOT NULL , /* */
    DEFICIT_CODE VARCHAR2(6)  , /* */
    DEFICIT_RESULT VARCHAR2(1)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    PRIMARY KEY(SEQ,TMP_REG_NUM)
   );
