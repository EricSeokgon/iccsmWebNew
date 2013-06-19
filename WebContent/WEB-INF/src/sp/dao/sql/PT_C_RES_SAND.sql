
create table PT_C_RES_SAND(
    SEQ NUMBER(4) NOT NULL , /* */
    ORG_NM VARCHAR2(52)  , /* */
    SIDO_CODE VARCHAR2(5)  , /* */
    ITEM_NM VARCHAR2(100)  , /* */
    QTT NUMBER(10)  , /* */
    SAND_SPD VARCHAR2(20)  , /* */
    INSTAL_NAME VARCHAR2(50)  , /* */
    USE VARCHAR2(12)  , /* */
    REMARK VARCHAR2(125)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(12)  , /* */
    SIGUNGU_CODE VARCHAR2(5)  , /* */
    PRIMARY KEY(SEQ)
   );
