
create table PT_UB_DETAIL_MASTER(
    SEQ NUMBER(22) NOT NULL , /* */
    ITEM VARCHAR2(4)  , /* */
    LARCLAS VARCHAR2(255)  , /* */
    SMACLAS VARCHAR2(255)  , /* */
    CONT VARCHAR2(255)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    MIDCLAS VARCHAR2(255)  , /* */
    BAS VARCHAR2(200)  , /* */
    CONT_YN VARCHAR2(10)  , /* */
    ORDER_SEQ NUMBER(4)  , /* */
    DETAIL_CONT VARCHAR2(255)  , /* */
    PRIMARY KEY(SEQ)
   );
