
create table PT_R_ADDRESS_CHANGE(
    CHGBRE_SEQ VARCHAR2(10) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    SIDO_CODE VARCHAR2(3)  , /* */
    POST_NUM VARCHAR2(6)  , /* */
    ADDR VARCHAR2(100)  , /* */
    DETAIL_ADDR VARCHAR2(100)  , /* */
    OFFICE_AREA VARCHAR2(10)  , /* */
    TEL_NUM VARCHAR2(20)  , /* */
    FAX_NUM VARCHAR2(20)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    ETC1 VARCHAR2(30)  , /* */
    PRIMARY KEY(CHGBRE_SEQ,TMP_WRT_NUM)
   );
