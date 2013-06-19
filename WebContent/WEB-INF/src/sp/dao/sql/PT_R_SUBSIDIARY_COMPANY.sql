
create table PT_R_SUBSIDIARY_COMPANY(
    SEQ NUMBER(4) NOT NULL , /* */
    OTOB_COM_NUM VARCHAR2(12)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    RECV_NUM VARCHAR2(12) NOT NULL , /* */
    OTOB_COM_CODE VARCHAR2(6)  , /* */
    SIDO_CODE VARCHAR2(4)  , /* */
    PRIMARY KEY(RECV_NUM,SEQ)
   );
