
create table PT_AUTH_GROUP(
    AUTH_GROUP_CODE VARCHAR2(5) NOT NULL , /* */
    AUTH_GROUP_NAME VARCHAR2(30)  , /* */
    ORDER_SEQ NUMBER(11)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    USE_YN VARCHAR2(1)  , /* */
    PRIMARY KEY(AUTH_GROUP_CODE)
   );
