
create table PT_PAGE_CODE(
    CODE_GROUP_ID NUMBER(22) NOT NULL , /* */
    CODE_GROUP VARCHAR2(4) NOT NULL , /* */
    CODE VARCHAR2(16) NOT NULL , /* */
    CODE_NAME VARCHAR2(50)  , /* */
    CODE_URL VARCHAR2(100)  , /* */
    ORDER_NUM NUMBER(22)  , /* */
    USE_YN VARCHAR2(1)  , /* */
    PRIMARY KEY(CODE_GROUP_ID)
   );
