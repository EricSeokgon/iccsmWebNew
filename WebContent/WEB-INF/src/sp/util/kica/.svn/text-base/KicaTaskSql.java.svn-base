package sp.util.kica;

import kjf.util.KJFUtil;

public  class KicaTaskSql  {
	
	
	private String WORK_CLASS_CODE;
	private String KEY1;
	private String KEY2;
	private String KEY3;
	private String CUD_FLAG;
	
	
	public KicaTaskSql(String v_WORK_CLASS_CODE, 
						String v_KEY1,
						String v_KEY2,
						String v_KEY3,
						String v_CUD_FLAG ){
		
		this.WORK_CLASS_CODE = v_WORK_CLASS_CODE;
		this.KEY1 = v_KEY1;
		this.KEY2 = v_KEY2;
		this.KEY3 = v_KEY3;
		this.CUD_FLAG = v_CUD_FLAG;
		
	}
    
    public  String  getTB_TMP_COMM_ACCEPT_MT()throws Exception {
    	
    	String Accept_tb_nm="PT_R_REGIST_STATEMENT";
    	String change_ymd ="A.WRT_DT ";
    	
    	
    	
    	if(WORK_CLASS_CODE.equals("R00001")){
    		Accept_tb_nm="PT_R_REGIST_STATEMENT";   		
    	} else if(WORK_CLASS_CODE.equals("R00006") ){ // 합병(R00006)
    		Accept_tb_nm="PT_R_M_UNION_STATEMENT"; 
    	} else if(WORK_CLASS_CODE.equals("R00004")||WORK_CLASS_CODE.equals("R00005")|| WORK_CLASS_CODE.equals("R00011") ){ // 양도양수,분할합병,법인전환 
    		Accept_tb_nm="PT_R_ASSI_TRANS_STATEMENT";                                   
    	}else if(WORK_CLASS_CODE.equals("R00002") ){ // 기준신고 (R00002)
    		Accept_tb_nm="PT_R_BASIC_STATEMENT"; 
    	}else if(WORK_CLASS_CODE.equals("R00003") ){ // 폐업 (R00003)
    		Accept_tb_nm="PT_R_CLOSE_STATEMENT"; 
    		change_ymd ="A.C_COM_DT ";
    	}
    	
    	//지자체 접수(신규)
    	String TB_TMP_COMM_ACCEPT_MT_SQL=
	    	" SELECT  TMP_TB_SEQ.NEXTVAL SEQ,										\n" +
	    	"         FNGETKICACODE('SIDO',A.SIDO_CODE) COMM_OFFICE,				\n" +
	    	//"         TRIM(A.RECV_NUM) ACCEPT_NO,										\n" +//접수번호가 입력이 시도별로 입력이 되므로 다수가  될수 있음  협회 전송테이블에 시도코드가 입력되게 수정해야함
	    	"         SUBSTRB('"+KEY3+"',0,2)|| TRIM(A.RECV_NUM) as ACCEPT_NO,		\n" +//접수번호 타시도 중복으로 시도코드+접수번호로 수정
	    	"         B.RECV_DT ACCEPT_YMD,											\n" +
	    	"         FNGetKicaCode('REGDIV','"+WORK_CLASS_CODE+"') JOB_GB,         \n" +
	    	"         FNGetKicaCodeName('REGDIV','"+WORK_CLASS_CODE+"') JOB_GB_NM,      \n"+	    	
    		//"         REPLACE(SUBSTR(NVL( A.UPD_DT, A.INS_DT ),0,10),'-','') CHANGE_YMD,		\n" + //변경일자- 공사업체 마스터의 최종일
    		"         "+change_ymd+" CHANGE_YMD,												\n" + //변경일자- 공사업체 마스터의 최종일
	    	"         SUBSTR(C.NM,0,12) COMM_WORKER_NO,											\n" +
	    	"         REPLACE(SUBSTR(NVL( A.UPD_DT, A.INS_DT ),0,10),'-','') COMM_WORK_YMD,		\n" +//지자체최종작업일- 공사업체 마스터의 최종일 
	    	"         A.COI_WRT_NUM REGIST_NO,										\n" +
	    	"         fn_report_no(A.DOC_CODE) REPORT_NO,										    \n" +
	    	"         '"+CUD_FLAG+"' CUD_FLAG,										\n" +
	    	"         '' ICS_TRANS_DT												\n" +
	    	" FROM PT_R_COMPANY_MASTER A,											\n" +
	    	"      "+Accept_tb_nm+" B,												\n" +
	    	"      PT_MI_USER C														\n" +
	    	" WHERE 1=1																\n" +
	    	"  AND A.RECV_NUM = B.RECV_NUM											\n" +
	    	"  AND A.SIDO_CODE = B.SIDO_CODE										\n" +
	    	"  AND A.WRT_ID = C.OFFI_ID(+)											\n" +
	    	"  AND A.TMP_WRT_NUM = '"+KEY1+"'										\n" +
    	    "  AND B.RECV_NUM = '"+KEY2+"'											\n" +
	    	"  AND A.SIDO_CODE = '"+KEY3+"'											\n" ;
    	
    	
    	if(WORK_CLASS_CODE.equals("R00012")){ //행정처분일경우
    		
        	//지자체 접수
        	TB_TMP_COMM_ACCEPT_MT_SQL=
    	    	" SELECT  TMP_TB_SEQ.NEXTVAL SEQ,										\n" +
    	    	"         FNGETKICACODE('SIDO',A.SIDO_CODE) COMM_OFFICE,				\n" +
    	    	"         B.WRT_NUM  ACCEPT_NO,										\n" +
    	    	"         B.WRT_DT ACCEPT_YMD,											\n" +
    	    	"         FNGetKicaCode('REGDIV','"+WORK_CLASS_CODE+"') JOB_GB,         \n" +
    	    	"         FNGetKicaCodeName('REGDIV','"+WORK_CLASS_CODE+"') JOB_GB_NM,      \n" +
    	    	//"         REPLACE(SUBSTR(A.UPD_DT,0,10),'-','') CHANGE_YMD,				\n" +
    	    	//"         REPLACE(SUBSTR(NVL( B.UPD_DT, B.INS_DT ),0,10),'-','') CHANGE_YMD,		\n" + //변경일자- 공사업체 마스터의 최종일	
    	    	"         B.DISPO_DT CHANGE_YMD,		\n" + //변경일자- 공사업체 마스터의 최종일
    	    	"         C.NM COMM_WORKER_NO,											\n" +
    	    	"         REPLACE(SUBSTR(NVL( B.UPD_DT, B.INS_DT ),0,10),'-','') COMM_WORK_YMD,		\n" +//지자체최종작업일- 공사업체 마스터의 최종일 
    	    	"         A.COI_WRT_NUM REGIST_NO,										\n" +
    	    	"         fn_report_no(B.DOC_CODE) REPORT_NO,										    \n" +
    	    	"         '"+CUD_FLAG+"' CUD_FLAG,										\n" +
    	    	"         '' ICS_TRANS_DT												\n" +
    	    	" FROM PT_R_COMPANY_MASTER A,										    \n" +
    	    	"      PT_M_MASTER B,											\n" +
    	    	"      PT_MI_USER C														\n" +
    	    	" WHERE 1=1																\n" +
    	    	"  AND B.WRT_ID = C.OFFI_ID(+)											\n" +
    	    	"  AND A.TMP_WRT_NUM = B.TMP_WRT_NUM									\n" +
    	    	"  AND A.TMP_WRT_NUM = '"+KEY1+"'										\n" +
        		"  AND B.WRT_NUM = '"+KEY2+"'											\n" ;
    	}
    	
    	
    	return TB_TMP_COMM_ACCEPT_MT_SQL;
    }
    	
    public  String  getTB_TMP_COMM_SAUPJA_MT()throws Exception {    
    	
    	//지자체접수 사업자
    	String TB_TMP_COMM_SAUPJA_MT_SQL=
	    	" SELECT  TMP_TB_SEQ.NEXTVAL  SEQ,                                         \n" +
	    	"         FNGetKicaCode('SIDO',A.SIDO_CODE) COMM_OFFICE,                   \n" +
	    	//"         TRIM(A.RECV_NUM)  ACCEPT_NO,                                           \n" +
	    	"         SUBSTRB('"+KEY3+"',0,2)|| TRIM(A.RECV_NUM) as ACCEPT_NO,		\n" +//접수번호 타시도 중복으로 시도코드+접수번호로 수정
	    	"         A.COI_WRT_NUM REGIST_NO,                                         \n" +
	    	"         A.REGIST_YMD REGIST_YMD,                                             \n" +
	    	"         '' INDUSTRY_CLASS_CD,                                            \n" +
	    	"         A.NAME FIRM_NM_KOR,                                              \n" +
	    	"         A.REP_SSN1|| A.REP_SSN2 REP_CERTI_RESI_NO,                       \n" +
	    	"         A.REP_NM_KOR REP_NM_KOR,                                         \n" +
	    	"         A.REP_NM_HAN REP_NM_CHI,                                         \n" +
	    	"         A.REP_TEL_NUM  REP_PHONE_OFFICE,                                 \n" +
	    	"         FN_ssnToBirth(A.REP_SSN1|| A.REP_SSN2) REP_BIRTH_YMD,                                                \n" +
	    	"         '1' LUNAR_GB,                                                     \n" +
	    	"         A.ADDR_POST_NUM SITE_ZIP_CD,                                     \n" +
	    	"         A.ADDR_ADDR SITE_ADDR_1,                                         \n" +
	    	"         A.ADDR_DETAIL_ADDR SITE_ADDR_2,                                  \n" +
	    	"         A.ADDR_TEL_NUM PHONE_NO_OFFICE,                                  \n" +
	    	"         A.ADDR_FAX_NUM FAX_NO_OFFICE,                                    \n" +
	    	"         A.OFFICE_AREA OFFICE_SPACE,                                      \n" +
	    	"         A.PAY_CAP PAY_IN_CAPITAL_AMT_K,                                  \n" +
	    	"         A.REA_CAP REAL_CAPITAL_AMT_K,                                    \n" +
	    	"         FNGetKicaCode('DIGDIV',A.DIAG_ORG_CODE) DIAGNOS_AGENCY_GB,       \n" +
	    	"         FNGetKicaCodeName('DIGDIV',A.DIAG_ORG_CODE) DIAGNOS_AGENCY_GB_NM,    \n" +
	    	"         SUBSTRB(A.DIAG_NM_NM||' '||A.DIAG_NM_WRT_NUM, 1, 30) DIAGNOS_AGENCY,             \n" +
	    	"         A.COMPANY_DIAG_BAS_DT DIAGNOS_YMD,                               \n" +
	    	"         A.C_COM_DT CLOSE_YMD,                                            \n" +
	    	"         FNGetCodeName('CLODIV',A.C_COM_CAUSE_CODE) CLOSE_REASON,         \n" +
	    	"         FNDeliYMD(A.TMP_WRT_NUM) CERTI_ISSUE_YN,                         \n" +
	    	"         A.FOREIGN_YN REP_FOREIGNER_YN,                                   \n" +     //대표자 외국인 여부  향후 조정 필요
	    	"         A.TUP_AOM  UNION_INVEST_AMT_K,                                   \n" +
	    	"         FNGetKicaCode('SITE_AREA', decode( A.GUBUN, '2', 'gggg2', A.SIDO_CODE ))  SITE_AREA_CD,             \n" +
	    	"         FNGetKicaCodeName('SITE_AREA', decode( A.GUBUN, '2', 'gggg2', A.SIDO_CODE ))  SITE_AREA_NM,         \n" +
	    	"         FNKum_YN(A.TMP_WRT_NUM) KUM_YN,                      				\n" +
	    	"         A.MANA_NUM VAT_NO,                                               \n" +
	    	"         A.COM_NUM JURIDICAL_NO,                                          \n" +
	    	"         A.BUSS_YMD BUSS_YMD,                                               \n" +       //영위일자  향후 조정 필요
	    	"         '"+CUD_FLAG+"' CUD_FLAG,										\n" +
	    	"         A.COMMANA_CLASS JURIDICAL_PERSON_GB,										\n" +
	    	//"         A.UNION_INVEST_NUM UNION_INVEST_NUM,										\n" +
	    	"         '' ICS_TRANS_DT                                                  \n" +
	    	" FROM PT_R_COMPANY_MASTER A                                        \n" +
	    	" WHERE 1=1                                                                \n" +
	    	"  AND A.TMP_WRT_NUM = '"+KEY1+"'											\n" ;
    	

    	
    	if(WORK_CLASS_CODE.equals("R00012")){ //행정처분일경우
    		   		
    		
        	//지자체접수 사업자
        	TB_TMP_COMM_SAUPJA_MT_SQL=
    	    	" SELECT  TMP_TB_SEQ.NEXTVAL  SEQ,                                         \n" +
    	    	"         FNGetKicaCode('SIDO',A.SIDO_CODE) COMM_OFFICE,                   \n" +
    	    	"         C.WRT_NUM  ACCEPT_NO,                                           \n" +
    	    	"         A.COI_WRT_NUM REGIST_NO,                                         \n" +
    	    	"         A.REGIST_YMD REGIST_YMD,                                             \n" +
    	    	"         '' INDUSTRY_CLASS_CD,                                            \n" +
    	    	"         A.NAME FIRM_NM_KOR,                                              \n" +
    	    	"         A.REP_SSN1|| A.REP_SSN2 REP_CERTI_RESI_NO,                       \n" +
    	    	"         A.REP_NM_KOR REP_NM_KOR,                                         \n" +
    	    	"         A.REP_NM_HAN REP_NM_CHI,                                         \n" +
    	    	"         A.REP_TEL_NUM  REP_PHONE_OFFICE,                                 \n" +
    	    	"         FN_ssnToBirth(A.REP_SSN1|| A.REP_SSN2) REP_BIRTH_YMD,                                                \n" +
    	    	"         '1' LUNAR_GB,                                                     \n" +
    	    	"         A.ADDR_POST_NUM SITE_ZIP_CD,                                     \n" +
    	    	"         A.ADDR_ADDR SITE_ADDR_1,                                         \n" +
    	    	"         A.ADDR_DETAIL_ADDR SITE_ADDR_2,                                  \n" +
    	    	"         A.ADDR_TEL_NUM PHONE_NO_OFFICE,                                  \n" +
    	    	"         A.ADDR_FAX_NUM FAX_NO_OFFICE,                                    \n" +
    	    	"         A.OFFICE_AREA OFFICE_SPACE,                                      \n" +
    	    	"         A.PAY_CAP PAY_IN_CAPITAL_AMT_K,                                  \n" +
    	    	"         A.REA_CAP REAL_CAPITAL_AMT_K,                                    \n" +
    	    	"         FNGetKicaCode('DIGDIV',A.DIAG_ORG_CODE) DIAGNOS_AGENCY_GB,       \n" +
    	    	"         FNGetKicaCodeName('DIGDIV',A.DIAG_ORG_CODE) DIAGNOS_AGENCY_GB_NM,    \n" +
    	    	"         SUBSTRB(A.DIAG_NM_NM||' '||A.DIAG_NM_WRT_NUM, 1, 30) DIAGNOS_AGENCY,             \n" +
    	    	"         A.COMPANY_DIAG_BAS_DT DIAGNOS_YMD,                               \n" +
    	    	"         A.C_COM_DT CLOSE_YMD,                                            \n" +
    	    	"         FNGetCodeName('CLODIV',A.C_COM_CAUSE_CODE) CLOSE_REASON,         \n" +
    	    	"         FNDeliYMD(A.TMP_WRT_NUM) CERTI_ISSUE_YN,                         \n" +
    	    	"         A.FOREIGN_YN REP_FOREIGNER_YN,                                   \n" +     //대표자 외국인 여부  향후 조정 필요
    	    	"         A.TUP_AOM  UNION_INVEST_AMT_K,                                   \n" +
    	    	"         FNGetKicaCode('SITE_AREA', decode( A.GUBUN, '2', 'gggg2', A.SIDO_CODE ))  SITE_AREA_CD,             \n" +
    	    	"         FNGetKicaCodeName('SITE_AREA', decode( A.GUBUN, '2', 'gggg2', A.SIDO_CODE ))  SITE_AREA_NM,         \n" +
    	    	"         FNKum_YN(A.TMP_WRT_NUM) KUM_YN,                      				\n" +
    	    	"         A.MANA_NUM VAT_NO,                                               \n" +
    	    	"         A.COM_NUM JURIDICAL_NO,                                          \n" +
    	    	"         A.BUSS_YMD BUSS_YMD,                                               \n" +       //영위일자  향후 조정 필요
    	    	"         A.COMMANA_CLASS JURIDICAL_PERSON_GB,										\n" +
    	    	//"         A.UNION_INVEST_NUM UNION_INVEST_NUM,										\n" +    	    	
    	    	"         '"+CUD_FLAG+"' CUD_FLAG,										\n" +    	    	
    	    	"         '' ICS_TRANS_DT                                                  \n" +
    	    	" FROM PT_R_COMPANY_MASTER A,                                        \n" +
    	    	"     PT_M_MASTER C                                                        \n" +    	    	
    	    	" WHERE 1=1                                                                \n" +
    	    	"  AND A.TMP_WRT_NUM = C.TMP_WRT_NUM									\n" +
    	    	"  AND A.TMP_WRT_NUM = '"+KEY1+"'										\n" +
        		"  AND C.WRT_NUM = '"+KEY2+"'											\n" ;
        	
        	
    		
    	}
    	    	
    	return TB_TMP_COMM_SAUPJA_MT_SQL;
    }
										    	   	   
    public  String  getTB_TMP_COMM_KEEPTECH_DT()throws Exception {    
    
    	
    	//보유기술자
    	String TB_TMP_COMM_KEEPTECH_DT_SQL=    	
	    	" SELECT                                                                 \n" +
	    	"     TMP_TB_SEQ.NEXTVAL SEQ,                                            \n" +
	    	"     FNGetKicaCode('SIDO',A.SIDO_CODE) COMM_OFFICE,                     \n" +
	    	//"     TRIM(A.RECV_NUM)  ACCEPT_NO,                                             \n" +
	    	"     SUBSTRB('"+KEY3+"',0,2)|| TRIM(A.RECV_NUM) as ACCEPT_NO,	         \n" +//접수번호 타시도 중복으로 시도코드+접수번호로 수정
	    	"     B.ENGINEER_SSN1||B.ENGINEER_SSN2 CERTI_RESI_NO,                    \n" +
	    	"     B.CARE_BOOK_ISSUE_NUM CAREER_NOTE_NO,                              \n" +
	    	"     A.COI_WRT_NUM REGIST_NO,                                           \n" +
	    	"     B.ENGINEER_NM NM_KOR,                                                   \n" +
	    	"     NULL NM_CHI,                                                   \n" +
	    	"     FNGetKicaCode('ENGCLASS',B.TMP_FIELD) TECH_EMP_GRAD,          \n" +
	    	"     TMP_FIELD TECH_EMP_GRAD_NM,       \n" +
	    	"     NULL VLID_YMD_FR,                              \n" +
	    	"     NULL VLID_YMD_TO,                                \n" +
	    	"     B.EMPL_YMD JOIN_COMP_YMD,                                          \n" +
	    	"     B.RET_YMD RETIRE_YMD,                                              \n" +
	    	"     '"+CUD_FLAG+"' CUD_FLAG,											\n" +	    	
	    	"     '' ICS_TRANS_DT                                                    \n" +
	    	" FROM PT_R_COMPANY_MASTER A,                                      \n" +
	    	"     PT_R_ENGINEER_CHANGE  B                                           \n" +
	    	" WHERE 1=1                                                              \n" +
	    	" AND A.TMP_WRT_NUM =B.TMP_WRT_NUM                                       \n" +
	    	" AND B.RET_YMD is null                                       \n" +
	    	"  AND A.TMP_WRT_NUM = '"+KEY1+"'										\n" ;
    	
    	//	    	"  AND A.RECV_NUM = '"+KEY2+"'										\n" +  
    	
    	
    	return TB_TMP_COMM_KEEPTECH_DT_SQL;
    }   	
    	  	
    public  String  getTB_TMP_REP_MT()throws Exception {      	
    	//공동대표
    	String TB_TMP_REP_MT_SQL=   
        	" SELECT                                                \n" +
	    	"     TMP_TB_SEQ.NEXTVAL SEQ,                           \n" +
	    	"     FNGetKicaCode('SIDO',A.SIDO_CODE) COMM_OFFICE,    \n" +
	    	//"     TRIM(A.RECV_NUM)  ACCEPT_NO,                            \n" +
	    	"     SUBSTRB('"+KEY3+"',0,2)|| TRIM(A.RECV_NUM) as ACCEPT_NO,		\n" +//접수번호 타시도 중복으로 시도코드+접수번호로 수정
	    	"     B.SSN1||B.SSN2 JUMIN_NO,                          \n" +
	    	"     A.COI_WRT_NUM REGIST_NO,                          \n" +
	    	"     B.NM_KOR NM_KOR,                                  \n" +
	    	"     B.NM_HAN NM_CHI,                                  \n" +
	    	"     FN_ssnToBirth(B.SSN1||B.SSN2) BIRTH_YMD,                                     \n" +
	    	"     '1' LUNAR_GB,                                      \n" +
	    	"     B.FOREIGN_YN FOREINER_YN,                         \n" +
	    	"     '"+CUD_FLAG+"' CUD_FLAG,							\n" +
	    	"     '' ICS_TRANS_DT                                   \n" +
	    	" FROM PT_R_COMPANY_MASTER A,                     \n" +
	    	"     PT_R_REFFER  B                                    \n" +
	    	" WHERE 1=1                                             \n" +
	    	" AND A.TMP_WRT_NUM =B.TMP_WRT_NUM                      \n" +
	    	" AND B.POS_CLASS IN ('P1','P4')                      \n" +
	    	" AND trim(B.NM_KOR) != trim(A.REP_NM_KOR)         \n" +
	    	"  AND A.TMP_WRT_NUM = '"+KEY1+"'						\n" ;
    	
    	//	    	"  AND A.RECV_NUM = '"+KEY2+"'						\n" +
    	
    	return TB_TMP_REP_MT_SQL;
	}   	
	    	
    public  String  getTB_TMP_KYUMUP_DT()throws Exception {    	
    	//보유기술자
    	String TB_TMP_KYUMUP_DT_SQL=   
    		" SELECT                                                           \n" +
	    	"     TMP_TB_SEQ.NEXTVAL SEQ,                                      \n" +
	    	"     FNGetKicaCode('SIDO',A.SIDO_CODE) COMM_OFFICE,               \n" +
	    	//"     TRIM(A.RECV_NUM)  ACCEPT_NO,                                       \n" +
	    	"     SUBSTRB('"+KEY3+"',0,2)|| TRIM(A.RECV_NUM) as ACCEPT_NO,		\n" +//접수번호 타시도 중복으로 시도코드+접수번호로 수정
	    	"     A.COI_WRT_NUM REGIST_NO,                                     \n" +
	    	"     '' KYUMUP_SEQ,                                       \n" +
	    	"     FNGETKICACODE('SUBSIDIARY',B.SUB_CODE) SIDE_JOB_GB,          \n" +
	    	"     FNGETCODENAME('SUBSIDIARY',B.SUB_CODE) SIDE_JOB_GB_NM,       \n" +
	    	"     B.SUB_WRT_NUM SIDE_REGIST_NO,                                \n" +
	    	"     '"+CUD_FLAG+"' CUD_FLAG,                                     \n" +
	    	"     '' ICS_TRANS_DT                                              \n" +
	    	" FROM PT_R_COMPANY_MASTER A,                                \n" +
	    	"     PT_R_SUBSIDIARY  B                                           \n" +
	    	" WHERE 1=1                                                        \n" +
	    	" AND A.TMP_WRT_NUM =B.TMP_WRT_NUM                                 \n" +
	    	"  AND A.TMP_WRT_NUM = '"+KEY1+"'						\n" ;
    	
    	//	    	"  AND A.RECV_NUM = '"+KEY2+"'						\n" +
    	
    	return TB_TMP_KYUMUP_DT_SQL;
	}   	
    	 	
    public  String  getTB_TMP_COMM_BEFORE_DT( String tmp_wrt_num, String recv_num, String tb_nm )throws Exception {
    	
    
    	    
    	// 접수번호는 12자리가를 넘길 수 없다.
    	
		//접수이전기본정보
		String TB_TMP_COMM_BEFORE_DT_SQL=
				" SELECT                                                                       \n" +
				"         TMP_TB_SEQ.NEXTVAL  SEQ,                                             \n" +
				"         FNGetKicaCode('SIDO','"+KEY3+"') COMM_OFFICE,                       \n" +
				//"         TRIM(A.RECV_NUM)  ACCEPT_NO,                                         \n" +
				"         SUBSTRB('"+KEY3+"',0,2)|| TRIM(A.RECV_NUM) as ACCEPT_NO,		\n" +//접수번호 타시도 중복으로 시도코드+접수번호로 수정
				"         NVL(A.COI_WRT_NUM,'000000') REGIST_NO,                               \n" + //공사업 등록번호가 없을 경우 '000000'
				"         A.MANA_NUM VAT_NO,                                                   \n" +
				"         A.COM_NUM JURIDICAL_NO,                                              \n" +
				"         A.REGIST_YMD REGIST_YMD,                                             \n" +
				"         A.NAME FIRM_NM_KOR,                                                  \n" +
				"         A.REP_SSN1|| A.REP_SSN2 REP_CERTI_RESI_NO,                           \n" +
				"         A.REP_NM_KOR REP_NM_KOR,                                             \n" +
				"         A.REP_NM_HAN REP_NM_CHI,                                             \n" +
				"         A.ADDR_POST_NUM SITE_ZIP_CD,                                         \n" +
				"         A.ADDR_ADDR SITE_ADDR_1,                                             \n" +
				"         A.ADDR_DETAIL_ADDR SITE_ADDR_2,                                      \n" +
				"         A.ADDR_TEL_NUM PHONE_NO_OFFICE,                                      \n" +
				"         A.ADDR_FAX_NUM FAX_NO_OFFICE,                                        \n" +
				"         A.OFFICE_AREA OFFICE_SPACE,                                          \n" +
				"         A.PAY_CAP PAY_IN_CAPITAL_AMT_K,                                      \n" +
				"         A.REA_CAP REAL_CAPITAL_AMT_K,                                        \n" +
				"         FNGetKicaCode('DIGDIV',A.DIAG_ORG_CODE) DIAGNOS_AGENCY_GB,           \n" +
				"         FNGetKicaCodeName('DIGDIV',A.DIAG_ORG_CODE) DIAGNOS_AGENCY_GB_NM,        \n" +
				"         SUBSTRB(NULL, 1, 30) DIAGNOS_AGENCY,                 \n" +
				"         A.COMPANY_DIAG_BAS_DT DIAGNOS_YMD,                                   \n" +
				"         A.BUSS_YMD BUSS_YMD,                                               \n" +       //영위일자  향후 조정 필요
				"         '"+CUD_FLAG+"' CUD_FLAG,                                             \n" +
				"         '' ICS_TRANS_DT                                                      \n" +
				" FROM "+tb_nm+" A                                            \n" +
				" WHERE 1=1                                                                    \n" +
				"  AND A.RECV_NUM = '"+recv_num+"'                                              \n" +
				"  AND A.TMP_WRT_NUM = '"+tmp_wrt_num+"'                                        \n" ;

		return TB_TMP_COMM_BEFORE_DT_SQL;
	}   
    

    
    
    
    public  String  getTB_TMP_COMM_RENEW_DT()throws Exception {

    	
		//접수이전기본정보
		String TB_TMP_COMM_RENEW_DT_SQL=   
			" SELECT  TMP_TB_SEQ.NEXTVAL SEQ,                                                   \n" +
			"         FNGETKICACODE('SIDO',A.SIDO_CODE) COMM_OFFICE,                            \n" +
			//"         TRIM(A.RECV_NUM)  ACCEPT_NO,                                                    \n" +
			"         SUBSTRB('"+KEY3+"',0,2)|| TRIM(A.RECV_NUM) as ACCEPT_NO,		\n" +//접수번호 타시도 중복으로 시도코드+접수번호로 수정
			"         A.COI_WRT_NUM REGIST_NO,                                                  \n" +
			"         A.BAS_STA_DT REG_RENEW_YMD,                                                 \n" +
			"         TO_CHAR(ADD_MONTHS(A.BAS_STA_DT, 36), 'yyyymmdd') AS REG_PLAN_YMD,          \n" +
			"         'N' MIDAL_YN,                                                  \n" +
			"         (SELECT COUNT(*)                                                          \n" +
			"             FROM PT_R_ENGINEER_CHANGE                                             \n" +
			"             WHERE TMP_WRT_NUM= A.TMP_WRT_NUM                                      \n" +
			"             and RET_YMD is null) TECH_NUM,                                        \n" +
			"         B.REA_CAP CAPITAL_AMT_K,                                           		\n" +
			"         B.OFFICE_AREA OFFICE_SPACE,                                               \n" +
			"         DECODE(B.COMPANY_DIAG_CLASS_CODE, 'DIM001','2','DIM002','1', '1') SINGO_GB, \n" + //재무재표 1, 기업진단보고서2
			"         FNGetKicaCode('DIGDIV',B.DIAG_ORG_CODE) DIAGNOS_AGENCY_GB,                \n" +
			"         FNGetKicaCodeName('DIGDIV',B.DIAG_ORG_CODE) DIAGNOS_AGENCY_GB_NM,             \n" +
			"         SUBSTRB(B.DIAG_NM_NM||' '||B.DIAG_NM_WRT_NUM, 1, 30) DIAGNOS_AGENCY,      \n" +
			"         B.UNION_INVEST_NUM UNION_INVEST_NUM,                                      \n" +
			"         B.TUP_AOM UNION_INVEST_AMT_K,                                             \n" +
			"         '"+CUD_FLAG+"' CUD_FLAG,                                                  \n" +
			"         '' ICS_TRANS_DT                                                           \n" +
			" FROM PT_R_COMPANY_MASTER A,                                                 \n" +
			"      PT_R_BASIC_STATEMENT B,                                                      \n" +
			"      PT_MI_USER C                                                                 \n" +
			" WHERE 1=1                                                                         \n" +
			//"  AND A.RECV_NUM = B.RECV_NUM                                                      \n" +
			"  AND A.COI_WRT_NUM = B.COI_WRT_NUM                                                      \n" +
			"  AND A.WRT_ID = C.OFFI_ID(+)                                                      \n" +
			"  AND A.TMP_WRT_NUM = '"+KEY1+"'                                                   \n" +
		    "  AND B.RECV_NUM = '"+KEY2+"'											\n" +
	    	"  AND A.SIDO_CODE = '"+KEY3+"'											\n" ;		
		
		
		return TB_TMP_COMM_RENEW_DT_SQL;
	}  
    
    
    public  String  getTB_TMP_REISSUE_DT()throws Exception {
       	
		//접수이전기본정보
		String TB_TMP_REISSUE_DT_SQL=   
			" SELECT  TMP_TB_SEQ.NEXTVAL SEQ,                                               \n" +
			"         FNGETKICACODE('SIDO',B.SIDO_CODE) COMM_OFFICE,                        \n" +
			//"         TRIM(B.RECV_NUM)  ACCEPT_NO,                                                \n" +
			"         SUBSTRB('"+KEY3+"',0,2)|| TRIM(B.RECV_NUM) as ACCEPT_NO,		\n" +//접수번호 타시도 중복으로 시도코드+접수번호로 수정
			"         A.COI_WRT_NUM REGIST_NO,                                              \n" +
			"         B.RECV_DT ACCEPT_YMD,                                                 \n" +
			"         B.RECV_DT REISSUE_YMD,                                                \n" +
			"         case  when  b.coi ='1'  and b.wrtbook = '1' then '3'                  \n" +
			"         when b.coi='1' and b.wrtbook is null or  b.wrtbook ='0' then '1'      \n" +
			"         when b.coi is null or b.coi='0' and b.wrtbook='1' then '2'            \n" +
			"         end as ISSUE_GB,                                                      \n" +
			"         '"+CUD_FLAG+"' CUD_FLAG,                                              \n" +
			"         '' ICS_TRANS_DT                                                       \n" +
			" FROM PT_R_COMPANY_MASTER A,                                                   \n" +
			"      PT_R_RE_DERIVERY_STATEMENT B,                                            \n" + 
			"      PT_MI_USER C                                                             \n" +
			" WHERE 1=1                                                                     \n" +
			"  AND A.TMP_WRT_NUM = B.TMP_WRT_NUM                                            \n" +
			"  AND A.WRT_ID = C.OFFI_ID(+)                                                  \n" +
			"  AND A.TMP_WRT_NUM = '"+KEY1+"'                                               \n" +
			"  AND B.RECV_NUM = '"+KEY2+"'                                               \n" +
	    	"  AND B.SIDO_CODE = '"+KEY3+"'											\n" ;
		
		return TB_TMP_REISSUE_DT_SQL;
	}
    
    
    public  String  getTB_TMP_COMM_PUNISH_DT()throws Exception {
    
    // 2010.07.22. PT_M_SUSPENSION 은 영업정지/과태료 관련 테이블이다. 조인을 해야만 하는지 확인 필요.
    //======================수정해야 함=====ㅡ.ㅡ;	
    	
		//접수이전기본정보
		String getTB_TMP_COMM_PUNISH_DT_SQL=   
	    	"         SELECT  TMP_TB_SEQ.NEXTVAL SEQ,                                                      \n" +
	    	"         	FNGETKICACODE('SIDO',A.SIDO_CODE) COMM_OFFICE,                                     \n" +
	    	"         	B.WRT_NUM  ACCEPT_NO,                                                              \n" +
	    	"         	A.COI_WRT_NUM REGIST_NO,                                                           \n" +
	    	"         	(SELECT SIDO_NM                                                                    \n" +
	    	"         	FROM PT_SIDO_CODE                                                                  \n" +
	    	"         	WHERE AREA_CODE=A.SIDO_CODE) PUNISHMENT_AGENCY,                                    \n" +
	    	"         	FNGETKICACODE('STADIV',B.DISPO_CONT) PUNISHMENT_LIST,                              \n" +
	    	"         	FNGetKicaCodeName('STADIV',B.DISPO_CONT) PUNISHMENT_LIST_NM,                           \n" +
	    	"         	DECODE(B.BUSISUSP_START_DT,NULL,B.DISPO_DT,B.BUSISUSP_START_DT) STOP_YMD_FM,       \n" +
	    	"         	DECODE(B.BUSISUSP_END_DT,NULL,B.DISPO_DT,B.BUSISUSP_END_DT) STOP_YMD_TO,           \n" +
	    	"         	B.DISPO_CAUSE PUNISHMENT_REASON,                                                   \n" +
	    	"         	'"+CUD_FLAG+"' CUD_FLAG,                                                           \n" +
	    	"         	'' ICS_TRANS_DT                                                                    \n" +
	    	"         FROM PT_R_COMPANY_MASTER A,                                                          \n" +
	    	"              PT_M_MASTER B                                                                   \n" +
	    	"         WHERE 1=1                                                                            \n" +
	    	"         AND A.TMP_WRT_NUM = B.TMP_WRT_NUM                                                    \n" +
	    	"	  AND A.TMP_WRT_NUM = '"+KEY1+"'															\n" +
	"	  AND B.WRT_NUM = '"+KEY2+"'																		\n" ;  
		
		
		return getTB_TMP_COMM_PUNISH_DT_SQL;
	}  
    
    
    
}

		 


