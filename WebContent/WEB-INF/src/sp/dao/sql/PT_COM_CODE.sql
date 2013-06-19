
create table PT_COM_CODE(
    SEQ NUMBER(11) NOT NULL , /* */
    CODE VARCHAR2(32)  , /* */
    P_CODE VARCHAR2(32)  , /* */
    CODE_NAME VARCHAR2(128)  , /* */
    ORDER_SEQ NUMBER(13)  , /* */
    USE_YN VARCHAR2(1)  , /* */
    BIGO VARCHAR2(200)  , /* */
    REG_DATE VARCHAR2(20)  , /* */
    MOD_DATE VARCHAR2(20)  , /* */
    P_CODE_NAME VARCHAR2(128)  , /* */
    PRIMARY KEY(SEQ)
   );
