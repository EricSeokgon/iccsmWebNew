
create table PT_PG(
    PG_ID NUMBER(10) NOT NULL , /* */
    PG_NAME VARCHAR2(100)  , /* */
    PG_URL VARCHAR2(200)  , /* */
    UPD_DT DATE  , /* */
    USE_YN VARCHAR2(1)  , /* */
    ORDER_SEQ NUMBER(22)  , /* */
    PG_GROUP_ID VARCHAR2(5)  , /* */
    PRIMARY KEY(PG_ID)
   );
