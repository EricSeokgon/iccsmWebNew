
create table PT_R_UNION_STATEMENT(
    RECV_NUM VARCHAR2(12) NOT NULL , /* */
    SIDO_CODE VARCHAR2(4) NOT NULL , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    ASC_TMP_WRT_NUM VARCHAR2(12)  , /* */
    HANDED_TMP_WRT_NUM VARCHAR2(12)  , /* */
    MOT_STE VARCHAR2(6)  , /* */
    ESTA_TMP_WRT_NUM VARCHAR2(12)  , /* */
    ESTA_ADDR_TEL_NUM VARCHAR2(17)  , /* */
    ESTA_NAME VARCHAR2(50)  , /* */
    ESTA_REP_NM_KOR VARCHAR2(20)  , /* */
    ESTA_REP_NM_HAN VARCHAR2(20)  , /* */
    ESTA_MANA_NUM VARCHAR2(13)  , /* */
    ESTA_ADDR_ADDR VARCHAR2(120)  , /* */
    ESTA_ADDR_POST_NUM VARCHAR2(6)  , /* */
    ESTA_ADDR_DETAIL_ADDR VARCHAR2(120)  , /* */
    ESTA_WRT_NUM VARCHAR2(12)  , /* */
    DEFI_STE VARCHAR2(1)  , /* */
    PROC_LIM VARCHAR2(8)  , /* */
    PROC_TIME VARCHAR2(6)  , /* */
    RECV_DT VARCHAR2(8)  , /* */
    RECV_TIME VARCHAR2(6)  , /* */
    BUSS_YMD VARCHAR2(8)  , /* */
    FOREIGN VARCHAR2(1)  , /* */
    REGIST_YMD VARCHAR2(8)  , /* */
    PRIMARY KEY(RECV_NUM,SIDO_CODE)
   );
