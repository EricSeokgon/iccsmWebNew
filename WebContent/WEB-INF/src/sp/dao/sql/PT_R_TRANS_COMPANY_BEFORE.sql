
create table PT_R_TRANS_COMPANY_BEFORE(
    TMP_WRT_NUM VARCHAR2(12) NOT NULL , /* */
    SIDO_CODE VARCHAR2(4)  , /* */
    COMMANA_CLASS VARCHAR2(1)  , /* */
    MANA_NUM VARCHAR2(18)  , /* */
    NAME VARCHAR2(50)  , /* */
    REP_SSN1 VARCHAR2(18)  , /* */
    REP_SSN2 VARCHAR2(21)  , /* */
    REP_NM_KOR VARCHAR2(20)  , /* */
    REP_NM_HAN VARCHAR2(20)  , /* */
    REP_TEL_NUM VARCHAR2(17)  , /* */
    ADDR_POST_NUM VARCHAR2(6)  , /* */
    ADDR_ADDR VARCHAR2(120)  , /* */
    ADDR_DETAIL_ADDR VARCHAR2(120)  , /* */
    ADDR_TEL_NUM VARCHAR2(17)  , /* */
    ADDR_FAX_NUM VARCHAR2(17)  , /* */
    EMAIL_ADDR VARCHAR2(30)  , /* */
    OFFICE_AREA VARCHAR2(10)  , /* */
    OFFICE_USE_CODE VARCHAR2(6)  , /* */
    COMPANY_DIAG_CLASS_CODE VARCHAR2(6)  , /* */
    COMPANY_DIAG_BAS_DT VARCHAR2(8)  , /* */
    COMPANY_DIAG_ISSUE_DT VARCHAR2(8)  , /* */
    DIAG_ORG_CODE VARCHAR2(6)  , /* */
    DIAG_NM_NM VARCHAR2(50)  , /* */
    DIAG_NM_WRT_NUM VARCHAR2(50)  , /* */
    PAY_CAP VARCHAR2(15)  , /* */
    REA_CAP VARCHAR2(15)  , /* */
    TUP_AOM VARCHAR2(15)  , /* */
    TUP_CLASS_CODE VARCHAR2(6)  , /* */
    C_COM_DT VARCHAR2(8)  , /* */
    C_COM_CAUSE_CODE VARCHAR2(6)  , /* */
    COM_COV_DT VARCHAR2(8)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    WRT_DT VARCHAR2(8)  , /* */
    BAS_STA_DT VARCHAR2(8)  , /* */
    OFFICE_OWN_CLASS VARCHAR2(1)  , /* */
    COI_WRT_NUM VARCHAR2(12)  , /* */
    REP_MOBILE VARCHAR2(17)  , /* */
    LICTAX VARCHAR2(1)  , /* */
    HOSCRE VARCHAR2(1)  , /* */
    SND_DT VARCHAR2(8)  , /* */
    SND_STE VARCHAR2(1)  , /* */
    COM_NUM VARCHAR2(13)  , /* */
    ADDR_TEL_NUM1 VARCHAR2(4)  , /* */
    ADDR_TEL_NUM2 VARCHAR2(4)  , /* */
    ADDR_TEL_NUM3 VARCHAR2(4)  , /* */
    ADDR_FAX_NUM1 VARCHAR2(4)  , /* */
    ADDR_FAX_NUM2 VARCHAR2(4)  , /* */
    ADDR_FAX_NUM3 VARCHAR2(4)  , /* */
    REP_MOBILE1 VARCHAR2(4)  , /* */
    REP_MOBILE2 VARCHAR2(4)  , /* */
    REP_MOBILE3 VARCHAR2(4)  , /* */
    RECV_NUM VARCHAR2(20) NOT NULL , /* */
    BUSS_YMD VARCHAR2(8)  , /* */
    FOREIGN_YN VARCHAR2(4)  , /* */
    REGIST_YMD VARCHAR2(8)  , /* */
    PRIMARY KEY(RECV_NUM,TMP_WRT_NUM)
   );
