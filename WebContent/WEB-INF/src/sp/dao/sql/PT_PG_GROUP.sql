
create table PT_PG_GROUP(
    PG_GROUP_ID VARCHAR2(5) NOT NULL , /* */
    P_PG_GROUP_ID VARCHAR2(5)  , /* */
    GROUP_NAME VARCHAR2(100)  , /* */
    UPD_DT DATE  , /* */
    PG_GROUP_URL VARCHAR2(100)  , /* */
    USE_YN VARCHAR2(1)  , /* */
    ORDER_SEQ NUMBER(11)  , /* */
    PRIMARY KEY(PG_GROUP_ID)
   );
