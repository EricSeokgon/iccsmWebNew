
create table PT_R_CLOSE_STATEMENT(
    RECV_NUM VARCHAR2(12) NOT NULL , /* */
    SIDO_CODE VARCHAR2(4) NOT NULL , /* */
    COI_WRT_NUM VARCHAR2(12)  , /* */
    RECV_DT VARCHAR2(8)  , /* */
    OFFI_PART VARCHAR2(50)  , /* */
    OFFI_PART_REBO_WRT_NUM VARCHAR2(12)  , /* */
    NAME VARCHAR2(50)  , /* */
    WRT_NUM VARCHAR2(12)  , /* */
    REP_NM_KOR VARCHAR2(20)  , /* */
    REP_NM_HAN VARCHAR2(20)  , /* */
    OFF_ADDR VARCHAR2(200)  , /* */
    TEL_NUM VARCHAR2(17)  , /* */
    C_COM_DT VARCHAR2(8)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    C_COM_CAUSE VARCHAR2(256)  , /* */
    DEFI_STE VARCHAR2(1)  , /* */
    ADDR_ADDR VARCHAR2(120)  , /* */
    ADDR_POST_NUM VARCHAR2(6)  , /* */
    ADDR_DETAIL_ADDR VARCHAR2(129)  , /* */
    PROC_LIM VARCHAR2(8)  , /* */
    MEMO_CONT VARCHAR2(256)  , /* */
    MOT_STE VARCHAR2(20)  , /* */
    TMP_WRT_NUM VARCHAR2(12)  , /* */
    DOC_CODE VARCHAR2(50)  , /* */
    PRIMARY KEY(RECV_NUM,SIDO_CODE)
   );
