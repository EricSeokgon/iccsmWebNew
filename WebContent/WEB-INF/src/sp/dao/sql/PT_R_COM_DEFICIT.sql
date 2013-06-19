
create table PT_R_COM_DEFICIT(
    SEQ NUMBER(4) NOT NULL , /* */
    DEFI_CODE VARCHAR2(6)  , /* */
    DEFI_OUT VARCHAR2(1)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    CHGBRE_SEQ NUMBER(4) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    DEFI_GROUP VARCHAR2(6)  , /* */
    PRIMARY KEY(CHGBRE_SEQ,SEQ,TMP_WRT_NUM)
   );
