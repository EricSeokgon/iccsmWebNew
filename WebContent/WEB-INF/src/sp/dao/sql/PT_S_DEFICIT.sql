
create table PT_S_DEFICIT(
    WRT_NUM VARCHAR2(12) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    SEQ CHAR(18) NOT NULL , /* */
    DEFI_CODE CHAR(18)  , /* */
    DEFI_OUT CHAR(18)  , /* */
    INS_DT CHAR(18)  , /* */
    UPD_DT CHAR(18)  , /* */
    WRT_ID CHAR(18)  , /* */
    PRIMARY KEY(SEQ,TMP_WRT_NUM,WRT_NUM)
   );
