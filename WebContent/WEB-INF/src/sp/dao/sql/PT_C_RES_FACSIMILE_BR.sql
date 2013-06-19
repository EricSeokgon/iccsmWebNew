
create table PT_C_RES_FACSIMILE_BR(
    SEQ NUMBER(4) NOT NULL , /* */
    ORG_NM VARCHAR2(52)  , /* */
    SIDO_CODE VARCHAR2(5)  , /* */
    ITEM_NM VARCHAR2(100)  , /* */
    LINK_ORG NUMBER(10)  , /* */
    BUY_AOM NUMBER(20)  , /* */
    PDT VARCHAR2(50)  , /* */
    REMARK VARCHAR2(125)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(12)  , /* */
    SIGUNGU_CODE VARCHAR2(5)  , /* */
    INSTAL_DT VARCHAR2(24)  , /* */
    QTT NUMBER(10)  , /* */
    PRIMARY KEY(SEQ)
   );
