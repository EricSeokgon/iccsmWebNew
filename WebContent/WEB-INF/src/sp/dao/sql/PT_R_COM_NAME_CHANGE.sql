
create table PT_R_COM_NAME_CHANGE(
    CHGBRE_SEQ VARCHAR2(10) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(20) NOT NULL , /* */
    NAME_KOR VARCHAR2(50)  , /* */
    NAME_HAN VARCHAR2(50)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    ETC1 VARCHAR2(50)  , /* */
    ETC2 VARCHAR2(50)  , /* */
    PRIMARY KEY(CHGBRE_SEQ,TMP_WRT_NUM)
   );
