
create table PT_C_RES_TRAFFIC_OUT(
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
    TIME NUMBER(10)  , /* */
    TRAFFIC_ERL NUMBER(10)  , /* */
    TRAFFIC_LINE NUMBER(10)  , /* */
    PRIMARY KEY(SEQ)
   );
