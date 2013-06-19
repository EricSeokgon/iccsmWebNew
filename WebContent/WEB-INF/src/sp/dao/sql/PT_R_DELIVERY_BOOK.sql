
create table PT_R_DELIVERY_BOOK(
    SEQ NUMBER(4) NOT NULL , /* */
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    DELI_CAUSE VARCHAR2(256)  , /* */
    DELI_YMD VARCHAR2(8)  , /* */
    REMARK VARCHAR2(256)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    DELI_CLASS VARCHAR2(6)  , /* */
    PRIMARY KEY(SEQ,TMP_WRT_NUM)
   );
