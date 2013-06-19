
create table PT_UB_CONSTRUCTION_DETAIL(
    EX_SEQ NUMBER(22) NOT NULL , /* */
    EX_RES VARCHAR2(4)  , /* */
    WRT_ID VARCHAR2(16)  , /* */
    INS_DT VARCHAR2(24)  , /* */
    UPD_DT VARCHAR2(24)  , /* */
    PEQ_NO VARCHAR2(20) NOT NULL , /* */
    SD_CD VARCHAR2(4) NOT NULL , /* */
    SGG_CD VARCHAR2(4) NOT NULL , /* */
    EX_CON VARCHAR2(100)  , /* */
    PRIMARY KEY(EX_SEQ,PEQ_NO,SD_CD,SGG_CD)
   );
