
create table PT_C_RES_FACSIMILE(
    SEQ NUMBER(4) NOT NULL , /* */
    ORG_NM VARCHAR2(52)  , /* */
    SIDO_CODE VARCHAR2(5)  , /* */
    REMARK VARCHAR2(125)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    WRT_ID VARCHAR2(12)  , /* */
    SIGUNGU_CODE VARCHAR2(5)  , /* */
    ADMI_NUM NUMBER(10)  , /* */
    ADMI_QTT NUMBER(10)  , /* */
    CIV_NUM NUMBER(10)  , /* */
    CIV_QTT NUMBER(10)  , /* */
    PRIMARY KEY(SEQ)
   );
