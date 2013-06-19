
create table PT_PERMISSION_TARGET(
    TARGET_SEQ INT(11) NOT NULL , /* */
    URL VARCHAR(200)  , /* */
    DESCRIPTION TEXT(65535)  , /* */
    CMD VARCHAR(100)  , /* */
    INP_DT VARCHAR(30)  , /* */
    CT_ID VARCHAR(100)  , /* */
    PRIMARY KEY(TARGET_SEQ)
   );
