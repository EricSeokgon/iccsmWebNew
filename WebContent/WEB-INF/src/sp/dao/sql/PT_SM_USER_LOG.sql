
create table PT_SM_USER_LOG(
    LOG_NUM NUMBER(11) NOT NULL , /* */
    USER_ID VARCHAR2(16)  , /* */
    ACCESS_TIME VARCHAR2(20)  , /* */
    END_TIME VARCHAR2(20)  , /* */
    ACCESS_IP VARCHAR2(15)  , /* */
    BROWSER VARCHAR2(128)  , /* */
    PRIMARY KEY(LOG_NUM)
   );
