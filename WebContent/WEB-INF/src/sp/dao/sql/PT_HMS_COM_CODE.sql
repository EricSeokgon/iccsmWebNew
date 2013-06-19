
create table PT_HMS_COM_CODE(
    CODE_GROUP VARCHAR2(16) NOT NULL , /* */
    CODE VARCHAR2(16) NOT NULL , /* */
    CODE_NAME VARCHAR2(50)  , /* */
    BIGO VARCHAR2(100)  , /* */
    ORDER_NUM NUMBER(22)  , /* */
    USE_YN VARCHAR2(1)  , /* */
    PRIMARY KEY(CODE,CODE_GROUP)
   );
