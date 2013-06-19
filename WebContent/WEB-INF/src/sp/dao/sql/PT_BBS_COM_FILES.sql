
create table PT_BBS_COM_FILES(
    CT_ID VARCHAR2(30)  , /* */
    BOARD_SEQ VARCHAR2(10)  , /* */
    FILE_REAL_NAME VARCHAR2(250)  , /* */
    SYS_FILE_NAME VARCHAR2(281) NOT NULL , /* */
    FILE_SIZE VARCHAR2(20)  , /* */
    UPD_DT VARCHAR2(20)  , /* */
    DOWN_HIT NUMBER(22)  , /* */
    PRIMARY KEY(SYS_FILE_NAME)
   );
