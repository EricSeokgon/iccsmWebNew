
create table PT_S_SYSVAR_MASTER(
    SIDO_CODE VARCHAR2(4) NOT NULL , /* */
    SIGUNGU_CODE VARCHAR2(5) NOT NULL , /* */
    NEW_WRT NUMBER(3)  , /* */
    BAS_STA NUMBER(3)  , /* */
    AFF NUMBER(3)  , /* */
    ASSI_TRAN NUMBER(3)  , /* */
    USEBEF_INSP NUMBER(3)  , /* */
    CYTYSEAL VARCHAR2(26)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    SERVER_ADDR VARCHAR2(100)  , /* */
    SERVER_YN VARCHAR2(1)  , /* */
    SEND_SYS_ID VARCHAR2(40)  , /* */
    RECV_SYS_ID VARCHAR2(40)  , /* */
    CITYSEAL_USE_YN CHAR(1)  , /* */
    CITYSEAL_WIDTH VARCHAR2(5)  , /* */
    CITYSEAL_HEIGHT VARCHAR2(5)  , /* */
    GROUPWARE_MODULE_TYPE VARCHAR2(20)  , /* */
    ONLINE_CERT_USE_YN CHAR(1)  , /* */
    APPL_GUBUN CHAR(1)  , /* */
    WEEKCHK VARCHAR2(2)  , /* */
    INSTODAY VARCHAR2(3)  , /* */
    PRIMARY KEY(SIDO_CODE,SIGUNGU_CODE)
   );
