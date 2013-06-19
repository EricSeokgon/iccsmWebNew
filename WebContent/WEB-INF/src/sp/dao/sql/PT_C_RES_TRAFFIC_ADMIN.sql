
create table PT_C_RES_TRAFFIC_ADMIN(
    SEQ NUMBER(4) NOT NULL , /* */
    ORG_NM VARCHAR2(52)  , /* */
    SIDO_CODE VARCHAR2(5)  , /* */
    LINE_QTT NUMBER(10)  , /* */
    REMARK VARCHAR2(125)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(12)  , /* */
    SIGUNGU_CODE VARCHAR2(5)  , /* */
    SIDO NUMBER(10)  , /* */
    POS NUMBER(10)  , /* */
    FINISH NUMBER(10)  , /* */
    TIME VARCHAR2(12)  , /* */
    TRAFFIC_ERL VARCHAR2(12)  , /* */
    TRAFFIC_LINE VARCHAR2(12)  , /* */
    PRIMARY KEY(SEQ)
   );
