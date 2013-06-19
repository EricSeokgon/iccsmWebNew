

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ASSI_TRANS_STATEMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               COI_WRT_NUM:VARCHAR2(6):  
*               MOT_STE:VARCHAR2(6):  
*               DEFI_STE:VARCHAR2(1):  
*               RECV_DT:VARCHAR2(8):  
*               RECV_TIME:VARCHAR2(6):  
*               PROC_LIM:VARCHAR2(8):  
*               PROC_TIME:VARCHAR2(4):  
*               CHG_DT:VARCHAR2(24):  
*               COMMANA_CLASS:VARCHAR2(1):  
*               MANA_NUM:VARCHAR2(18):  
*               NAME:VARCHAR2(50):  
*               REP_SSN1:VARCHAR2(18):  
*               REP_SSN2:VARCHAR2(21):  
*               REP_NM_KOR:VARCHAR2(20):  
*               REP_NM_HAN:VARCHAR2(20):  
*               REP_TEL_NUM:VARCHAR2(17):  
*               ADDR_POST_NUM:VARCHAR2(6):  
*               ADDR_ADDR:VARCHAR2(120):  
*               ADDR_DETAIL_ADDR:VARCHAR2(120):  
*               ADDR_TEL_NUM:VARCHAR2(17):  
*               ADDR_FAX_NUM:VARCHAR2(17):  
*               EMAIL_ADDR:VARCHAR2(30):  
*               OFFICE_AREA:VARCHAR2(10):  
*               OFFICE_USE_CODE:VARCHAR2(6):  
*               COMPANY_DIAG_CLASS_CODE:VARCHAR2(6):  
*               COMPANY_DIAG_BAS_DT:VARCHAR2(8):  
*               COMPANY_DIAG_ISSUE_DT:VARCHAR2(8):  
*               DIAG_ORG_CODE:VARCHAR2(6):  
*               DIAG_NM_NM:VARCHAR2(50):  
*               DIAG_NM_WRT_NUM:VARCHAR2(50):  
*               PAY_CAP:VARCHAR2(15):  
*               REA_CAP:VARCHAR2(15):  
*               TUP_AOM:VARCHAR2(15):  
*               TUP_CLASS_CODE:VARCHAR2(6):  
*               COM_COV_DT:VARCHAR2(8):  
*               BAS_STA_DT:VARCHAR2(8):  
*               OFFICE_OWN_CLASS:VARCHAR2(1):  
*               REP_MOBILE:VARCHAR2(17):  
*               LICTAX:VARCHAR2(1):  
*               HOSCRE:VARCHAR2(1):  
*               COM_NUM:VARCHAR2(13):  
*               GUBUN:VARCHAR2(25):  
*               DOC_CODE:VARCHAR2(30):  
*               OFFICE_USE_NAME:VARCHAR2(20):  
*               MEMO_CONT:VARCHAR2(256):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               ASSI_TMP_WRT_NUM:VARCHAR2(12):  
*               ASSI_COI_WRT_NUM:VARCHAR2(6):  
*               ASSI_COMMANA_CLASS:VARCHAR2(4):  
*               ASSI_MANA_NUM:VARCHAR2(18):  
*               ASSI_STE:VARCHAR2(1):  
*               ASSI_NAME:VARCHAR2(50):  
*               ASSI_TELNUM:VARCHAR2(17):  
*               ASSI_REP:VARCHAR2(20):  
*               ASSI_COMNUM:VARCHAR2(13):  
*               ASSI_ADDR:VARCHAR2(120):  
*               ASSI_POST_NUM:VARCHAR2(120):  
*               ASSI_DETAIL_ADDR:VARCHAR2(120):  
*               ASSI_GUBUN:VARCHAR2(1):  
*               ASSI_WRT_DT:VARCHAR2(24):  
*               ASSI_CHGBRE_SEQ:VARCHAR2(4):  
*               TRAN_TMP_WRT_NUM:VARCHAR2(12):  
*               TRAN_COI_WRT_NUM:VARCHAR2(6):  
*               TRAN_COMMANA_CLASS:VARCHAR2(4):  
*               TRAN_MANA_NUM:VARCHAR2(18):  
*               TRAN_NAME:VARCHAR2(50):  
*               TRAN_TELNUM:VARCHAR2(17):  
*               TRAN_REP:VARCHAR2(20):  
*               TRAN_COMNUM:VARCHAR2(13):  
*               TRAN_ADDR:VARCHAR2(120):  
*               TRAN_POST_NUM:VARCHAR2(6):  
*               TRAN_DETAIL_ADDR:VARCHAR2(120):  
*               TRAN_GUBUN:VARCHAR2(1):  
*               TRAN_WRT_DT:VARCHAR2(24):  
*               TRAN_CHGBRE_SEQ:VARCHAR2(4):  
*               COMPANY_DIAG_BAS_DT2:VARCHAR2(4):  
*               BUSS_YMD:VARCHAR2(8):  
*               FOREIGN_YN:VARCHAR2(1):  
*               REGIST_YMD:VARCHAR2(8):  
*               ASSI_BUSS_YMD:VARCHAR2(8):  
*               ASSI_FOREIGN_YN:VARCHAR2(1):  
*               ASSI_REGIST_YMD:VARCHAR2(8):  
*               TRAN_BUSS_YMD:VARCHAR2(8):  
*               TRAN_FOREIGN_YN:VARCHAR2(1):  
*               TRAN_REGIST_YMD:VARCHAR2(8):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_ASSI_TRANS_STATEMENTHelper{

  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String COI_WRT_NUM = "COI_WRT_NUM";
  final static public String MOT_STE = "MOT_STE";
  final static public String DEFI_STE = "DEFI_STE";
  final static public String RECV_DT = "RECV_DT";
  final static public String RECV_TIME = "RECV_TIME";
  final static public String PROC_LIM = "PROC_LIM";
  final static public String PROC_TIME = "PROC_TIME";
  final static public String CHG_DT = "CHG_DT";
  final static public String COMMANA_CLASS = "COMMANA_CLASS";
  final static public String MANA_NUM = "MANA_NUM";
  final static public String NAME = "NAME";
  final static public String REP_SSN1 = "REP_SSN1";
  final static public String REP_SSN2 = "REP_SSN2";
  final static public String REP_NM_KOR = "REP_NM_KOR";
  final static public String REP_NM_HAN = "REP_NM_HAN";
  final static public String REP_TEL_NUM = "REP_TEL_NUM";
  final static public String ADDR_POST_NUM = "ADDR_POST_NUM";
  final static public String ADDR_ADDR = "ADDR_ADDR";
  final static public String ADDR_DETAIL_ADDR = "ADDR_DETAIL_ADDR";
  final static public String ADDR_TEL_NUM = "ADDR_TEL_NUM";
  final static public String ADDR_FAX_NUM = "ADDR_FAX_NUM";
  final static public String EMAIL_ADDR = "EMAIL_ADDR";
  final static public String OFFICE_AREA = "OFFICE_AREA";
  final static public String OFFICE_USE_CODE = "OFFICE_USE_CODE";
  final static public String COMPANY_DIAG_CLASS_CODE = "COMPANY_DIAG_CLASS_CODE";
  final static public String COMPANY_DIAG_BAS_DT = "COMPANY_DIAG_BAS_DT";
  final static public String COMPANY_DIAG_ISSUE_DT = "COMPANY_DIAG_ISSUE_DT";
  final static public String DIAG_ORG_CODE = "DIAG_ORG_CODE";
  final static public String DIAG_NM_NM = "DIAG_NM_NM";
  final static public String DIAG_NM_WRT_NUM = "DIAG_NM_WRT_NUM";
  final static public String PAY_CAP = "PAY_CAP";
  final static public String REA_CAP = "REA_CAP";
  final static public String TUP_AOM = "TUP_AOM";
  final static public String TUP_CLASS_CODE = "TUP_CLASS_CODE";
  final static public String COM_COV_DT = "COM_COV_DT";
  final static public String BAS_STA_DT = "BAS_STA_DT";
  final static public String OFFICE_OWN_CLASS = "OFFICE_OWN_CLASS";
  final static public String REP_MOBILE = "REP_MOBILE";
  final static public String LICTAX = "LICTAX";
  final static public String HOSCRE = "HOSCRE";
  final static public String COM_NUM = "COM_NUM";
  final static public String GUBUN = "GUBUN";
  final static public String DOC_CODE = "DOC_CODE";
  final static public String OFFICE_USE_NAME = "OFFICE_USE_NAME";
  final static public String MEMO_CONT = "MEMO_CONT";
  final static public String WRT_ID = "WRT_ID";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String ASSI_TMP_WRT_NUM = "ASSI_TMP_WRT_NUM";
  final static public String ASSI_COI_WRT_NUM = "ASSI_COI_WRT_NUM";
  final static public String ASSI_COMMANA_CLASS = "ASSI_COMMANA_CLASS";
  final static public String ASSI_MANA_NUM = "ASSI_MANA_NUM";
  final static public String ASSI_STE = "ASSI_STE";
  final static public String ASSI_NAME = "ASSI_NAME";
  final static public String ASSI_TELNUM = "ASSI_TELNUM";
  final static public String ASSI_REP = "ASSI_REP";
  final static public String ASSI_COMNUM = "ASSI_COMNUM";
  final static public String ASSI_ADDR = "ASSI_ADDR";
  final static public String ASSI_POST_NUM = "ASSI_POST_NUM";
  final static public String ASSI_DETAIL_ADDR = "ASSI_DETAIL_ADDR";
  final static public String ASSI_GUBUN = "ASSI_GUBUN";
  final static public String ASSI_WRT_DT = "ASSI_WRT_DT";
  final static public String ASSI_CHGBRE_SEQ = "ASSI_CHGBRE_SEQ";
  final static public String TRAN_TMP_WRT_NUM = "TRAN_TMP_WRT_NUM";
  final static public String TRAN_COI_WRT_NUM = "TRAN_COI_WRT_NUM";
  final static public String TRAN_COMMANA_CLASS = "TRAN_COMMANA_CLASS";
  final static public String TRAN_MANA_NUM = "TRAN_MANA_NUM";
  final static public String TRAN_NAME = "TRAN_NAME";
  final static public String TRAN_TELNUM = "TRAN_TELNUM";
  final static public String TRAN_REP = "TRAN_REP";
  final static public String TRAN_COMNUM = "TRAN_COMNUM";
  final static public String TRAN_ADDR = "TRAN_ADDR";
  final static public String TRAN_POST_NUM = "TRAN_POST_NUM";
  final static public String TRAN_DETAIL_ADDR = "TRAN_DETAIL_ADDR";
  final static public String TRAN_GUBUN = "TRAN_GUBUN";
  final static public String TRAN_WRT_DT = "TRAN_WRT_DT";
  final static public String TRAN_CHGBRE_SEQ = "TRAN_CHGBRE_SEQ";
  final static public String COMPANY_DIAG_BAS_DT2 = "COMPANY_DIAG_BAS_DT2";
  final static public String BUSS_YMD = "BUSS_YMD";
  final static public String FOREIGN_YN = "FOREIGN_YN";
  final static public String REGIST_YMD = "REGIST_YMD";
  final static public String ASSI_BUSS_YMD = "ASSI_BUSS_YMD";
  final static public String ASSI_FOREIGN_YN = "ASSI_FOREIGN_YN";
  final static public String ASSI_REGIST_YMD = "ASSI_REGIST_YMD";
  final static public String TRAN_BUSS_YMD = "TRAN_BUSS_YMD";
  final static public String TRAN_FOREIGN_YN = "TRAN_FOREIGN_YN";
  final static public String TRAN_REGIST_YMD = "TRAN_REGIST_YMD";
  


  public static HashMap fieldMap = new HashMap(89);
  static{
  fieldMap.put(RECV_NUM,new Integer(1) );
  fieldMap.put(SIDO_CODE,new Integer(2) );
  fieldMap.put(COI_WRT_NUM,new Integer(3) );
  fieldMap.put(MOT_STE,new Integer(4) );
  fieldMap.put(DEFI_STE,new Integer(5) );
  fieldMap.put(RECV_DT,new Integer(6) );
  fieldMap.put(RECV_TIME,new Integer(7) );
  fieldMap.put(PROC_LIM,new Integer(8) );
  fieldMap.put(PROC_TIME,new Integer(9) );
  fieldMap.put(CHG_DT,new Integer(10) );
  fieldMap.put(COMMANA_CLASS,new Integer(11) );
  fieldMap.put(MANA_NUM,new Integer(12) );
  fieldMap.put(NAME,new Integer(13) );
  fieldMap.put(REP_SSN1,new Integer(14) );
  fieldMap.put(REP_SSN2,new Integer(15) );
  fieldMap.put(REP_NM_KOR,new Integer(16) );
  fieldMap.put(REP_NM_HAN,new Integer(17) );
  fieldMap.put(REP_TEL_NUM,new Integer(18) );
  fieldMap.put(ADDR_POST_NUM,new Integer(19) );
  fieldMap.put(ADDR_ADDR,new Integer(20) );
  fieldMap.put(ADDR_DETAIL_ADDR,new Integer(21) );
  fieldMap.put(ADDR_TEL_NUM,new Integer(22) );
  fieldMap.put(ADDR_FAX_NUM,new Integer(23) );
  fieldMap.put(EMAIL_ADDR,new Integer(24) );
  fieldMap.put(OFFICE_AREA,new Integer(25) );
  fieldMap.put(OFFICE_USE_CODE,new Integer(26) );
  fieldMap.put(COMPANY_DIAG_CLASS_CODE,new Integer(27) );
  fieldMap.put(COMPANY_DIAG_BAS_DT,new Integer(28) );
  fieldMap.put(COMPANY_DIAG_ISSUE_DT,new Integer(29) );
  fieldMap.put(DIAG_ORG_CODE,new Integer(30) );
  fieldMap.put(DIAG_NM_NM,new Integer(31) );
  fieldMap.put(DIAG_NM_WRT_NUM,new Integer(32) );
  fieldMap.put(PAY_CAP,new Integer(33) );
  fieldMap.put(REA_CAP,new Integer(34) );
  fieldMap.put(TUP_AOM,new Integer(35) );
  fieldMap.put(TUP_CLASS_CODE,new Integer(36) );
  fieldMap.put(COM_COV_DT,new Integer(37) );
  fieldMap.put(BAS_STA_DT,new Integer(38) );
  fieldMap.put(OFFICE_OWN_CLASS,new Integer(39) );
  fieldMap.put(REP_MOBILE,new Integer(40) );
  fieldMap.put(LICTAX,new Integer(41) );
  fieldMap.put(HOSCRE,new Integer(42) );
  fieldMap.put(COM_NUM,new Integer(43) );
  fieldMap.put(GUBUN,new Integer(44) );
  fieldMap.put(DOC_CODE,new Integer(45) );
  fieldMap.put(OFFICE_USE_NAME,new Integer(46) );
  fieldMap.put(MEMO_CONT,new Integer(47) );
  fieldMap.put(WRT_ID,new Integer(48) );
  fieldMap.put(INS_DT,new Integer(49) );
  fieldMap.put(UPD_DT,new Integer(50) );
  fieldMap.put(ASSI_TMP_WRT_NUM,new Integer(51) );
  fieldMap.put(ASSI_COI_WRT_NUM,new Integer(52) );
  fieldMap.put(ASSI_COMMANA_CLASS,new Integer(53) );
  fieldMap.put(ASSI_MANA_NUM,new Integer(54) );
  fieldMap.put(ASSI_STE,new Integer(55) );
  fieldMap.put(ASSI_NAME,new Integer(56) );
  fieldMap.put(ASSI_TELNUM,new Integer(57) );
  fieldMap.put(ASSI_REP,new Integer(58) );
  fieldMap.put(ASSI_COMNUM,new Integer(59) );
  fieldMap.put(ASSI_ADDR,new Integer(60) );
  fieldMap.put(ASSI_POST_NUM,new Integer(61) );
  fieldMap.put(ASSI_DETAIL_ADDR,new Integer(62) );
  fieldMap.put(ASSI_GUBUN,new Integer(63) );
  fieldMap.put(ASSI_WRT_DT,new Integer(64) );
  fieldMap.put(ASSI_CHGBRE_SEQ,new Integer(65) );
  fieldMap.put(TRAN_TMP_WRT_NUM,new Integer(66) );
  fieldMap.put(TRAN_COI_WRT_NUM,new Integer(67) );
  fieldMap.put(TRAN_COMMANA_CLASS,new Integer(68) );
  fieldMap.put(TRAN_MANA_NUM,new Integer(69) );
  fieldMap.put(TRAN_NAME,new Integer(70) );
  fieldMap.put(TRAN_TELNUM,new Integer(71) );
  fieldMap.put(TRAN_REP,new Integer(72) );
  fieldMap.put(TRAN_COMNUM,new Integer(73) );
  fieldMap.put(TRAN_ADDR,new Integer(74) );
  fieldMap.put(TRAN_POST_NUM,new Integer(75) );
  fieldMap.put(TRAN_DETAIL_ADDR,new Integer(76) );
  fieldMap.put(TRAN_GUBUN,new Integer(77) );
  fieldMap.put(TRAN_WRT_DT,new Integer(78) );
  fieldMap.put(TRAN_CHGBRE_SEQ,new Integer(79) );
  fieldMap.put(COMPANY_DIAG_BAS_DT2,new Integer(80) );
  fieldMap.put(BUSS_YMD,new Integer(81) );
  fieldMap.put(FOREIGN_YN,new Integer(82) );
  fieldMap.put(REGIST_YMD,new Integer(83) );
  fieldMap.put(ASSI_BUSS_YMD,new Integer(84) );
  fieldMap.put(ASSI_FOREIGN_YN,new Integer(85) );
  fieldMap.put(ASSI_REGIST_YMD,new Integer(86) );
  fieldMap.put(TRAN_BUSS_YMD,new Integer(87) );
  fieldMap.put(TRAN_FOREIGN_YN,new Integer(88) );
  fieldMap.put(TRAN_REGIST_YMD,new Integer(89) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_ASSI_TRANS_STATEMENT";
     final public static String PREFIX = "sp.dao.PT_R_ASSI_TRANS_STATEMENT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SIDO_CODE };
     final public static String FIELD_LIST[] = { 
       RECV_NUM,SIDO_CODE,COI_WRT_NUM,MOT_STE,DEFI_STE,RECV_DT,RECV_TIME,PROC_LIM,PROC_TIME,CHG_DT,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,COM_COV_DT,BAS_STA_DT,OFFICE_OWN_CLASS,REP_MOBILE,LICTAX,HOSCRE,COM_NUM,GUBUN,DOC_CODE,OFFICE_USE_NAME,MEMO_CONT,WRT_ID,INS_DT,UPD_DT,ASSI_TMP_WRT_NUM,ASSI_COI_WRT_NUM,ASSI_COMMANA_CLASS,ASSI_MANA_NUM,ASSI_STE,ASSI_NAME,ASSI_TELNUM,ASSI_REP,ASSI_COMNUM,ASSI_ADDR,ASSI_POST_NUM,ASSI_DETAIL_ADDR,ASSI_GUBUN,ASSI_WRT_DT,ASSI_CHGBRE_SEQ,TRAN_TMP_WRT_NUM,TRAN_COI_WRT_NUM,TRAN_COMMANA_CLASS,TRAN_MANA_NUM,TRAN_NAME,TRAN_TELNUM,TRAN_REP,TRAN_COMNUM,TRAN_ADDR,TRAN_POST_NUM,TRAN_DETAIL_ADDR,TRAN_GUBUN,TRAN_WRT_DT,TRAN_CHGBRE_SEQ,COMPANY_DIAG_BAS_DT2,BUSS_YMD,FOREIGN_YN,REGIST_YMD,ASSI_BUSS_YMD,ASSI_FOREIGN_YN,ASSI_REGIST_YMD,TRAN_BUSS_YMD,TRAN_FOREIGN_YN,TRAN_REGIST_YMD };
     public static String getFieldDesc(String key){
         Integer idx = (Integer)fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 : 
	                  return  "";
             case 2 : 
	                  return  "";
             case 3 : 
	                  return  "";
             case 4 : 
	                  return  "";
             case 5 : 
	                  return  "";
             case 6 : 
	                  return  "";
             case 7 : 
	                  return  "";
             case 8 : 
	                  return  "";
             case 9 : 
	                  return  "";
             case 10 : 
	                  return  "";
             case 11 : 
	                  return  "";
             case 12 : 
	                  return  "";
             case 13 : 
	                  return  "";
             case 14 : 
	                  return  "";
             case 15 : 
	                  return  "";
             case 16 : 
	                  return  "";
             case 17 : 
	                  return  "";
             case 18 : 
	                  return  "";
             case 19 : 
	                  return  "";
             case 20 : 
	                  return  "";
             case 21 : 
	                  return  "";
             case 22 : 
	                  return  "";
             case 23 : 
	                  return  "";
             case 24 : 
	                  return  "";
             case 25 : 
	                  return  "";
             case 26 : 
	                  return  "";
             case 27 : 
	                  return  "";
             case 28 : 
	                  return  "";
             case 29 : 
	                  return  "";
             case 30 : 
	                  return  "";
             case 31 : 
	                  return  "";
             case 32 : 
	                  return  "";
             case 33 : 
	                  return  "";
             case 34 : 
	                  return  "";
             case 35 : 
	                  return  "";
             case 36 : 
	                  return  "";
             case 37 : 
	                  return  "";
             case 38 : 
	                  return  "";
             case 39 : 
	                  return  "";
             case 40 : 
	                  return  "";
             case 41 : 
	                  return  "";
             case 42 : 
	                  return  "";
             case 43 : 
	                  return  "";
             case 44 : 
	                  return  "";
             case 45 : 
	                  return  "";
             case 46 : 
	                  return  "";
             case 47 : 
	                  return  "";
             case 48 : 
	                  return  "";
             case 49 : 
	                  return  "";
             case 50 : 
	                  return  "";
             case 51 : 
	                  return  "";
             case 52 : 
	                  return  "";
             case 53 : 
	                  return  "";
             case 54 : 
	                  return  "";
             case 55 : 
	                  return  "";
             case 56 : 
	                  return  "";
             case 57 : 
	                  return  "";
             case 58 : 
	                  return  "";
             case 59 : 
	                  return  "";
             case 60 : 
	                  return  "";
             case 61 : 
	                  return  "";
             case 62 : 
	                  return  "";
             case 63 : 
	                  return  "";
             case 64 : 
	                  return  "";
             case 65 : 
	                  return  "";
             case 66 : 
	                  return  "";
             case 67 : 
	                  return  "";
             case 68 : 
	                  return  "";
             case 69 : 
	                  return  "";
             case 70 : 
	                  return  "";
             case 71 : 
	                  return  "";
             case 72 : 
	                  return  "";
             case 73 : 
	                  return  "";
             case 74 : 
	                  return  "";
             case 75 : 
	                  return  "";
             case 76 : 
	                  return  "";
             case 77 : 
	                  return  "";
             case 78 : 
	                  return  "";
             case 79 : 
	                  return  "";
             case 80 : 
	                  return  "";
             case 81 : 
	                  return  "";
             case 82 : 
	                  return  "";
             case 83 : 
	                  return  "";
             case 84 : 
	                  return  "";
             case 85 : 
	                  return  "";
             case 86 : 
	                  return  "";
             case 87 : 
	                  return  "";
             case 88 : 
	                  return  "";
             case 89 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_R_ASSI_TRANS_STATEMENTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COI_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getCOI_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOT_STE").append("'")
            .append(" value='").append(""+ent.getMOT_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFI_STE").append("'")
            .append(" value='").append(""+ent.getDEFI_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_DT").append("'")
            .append(" value='").append(""+ent.getRECV_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_TIME").append("'")
            .append(" value='").append(""+ent.getRECV_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_LIM").append("'")
            .append(" value='").append(""+ent.getPROC_LIM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_TIME").append("'")
            .append(" value='").append(""+ent.getPROC_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHG_DT").append("'")
            .append(" value='").append(""+ent.getCHG_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMMANA_CLASS").append("'")
            .append(" value='").append(""+ent.getCOMMANA_CLASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MANA_NUM").append("'")
            .append(" value='").append(""+ent.getMANA_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NAME").append("'")
            .append(" value='").append(""+ent.getNAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_SSN1").append("'")
            .append(" value='").append(""+ent.getREP_SSN1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_SSN2").append("'")
            .append(" value='").append(""+ent.getREP_SSN2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_NM_KOR").append("'")
            .append(" value='").append(""+ent.getREP_NM_KOR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_NM_HAN").append("'")
            .append(" value='").append(""+ent.getREP_NM_HAN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_TEL_NUM").append("'")
            .append(" value='").append(""+ent.getREP_TEL_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_POST_NUM").append("'")
            .append(" value='").append(""+ent.getADDR_POST_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_ADDR").append("'")
            .append(" value='").append(""+ent.getADDR_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_DETAIL_ADDR").append("'")
            .append(" value='").append(""+ent.getADDR_DETAIL_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_TEL_NUM").append("'")
            .append(" value='").append(""+ent.getADDR_TEL_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_FAX_NUM").append("'")
            .append(" value='").append(""+ent.getADDR_FAX_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EMAIL_ADDR").append("'")
            .append(" value='").append(""+ent.getEMAIL_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFICE_AREA").append("'")
            .append(" value='").append(""+ent.getOFFICE_AREA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFICE_USE_CODE").append("'")
            .append(" value='").append(""+ent.getOFFICE_USE_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMPANY_DIAG_CLASS_CODE").append("'")
            .append(" value='").append(""+ent.getCOMPANY_DIAG_CLASS_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMPANY_DIAG_BAS_DT").append("'")
            .append(" value='").append(""+ent.getCOMPANY_DIAG_BAS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMPANY_DIAG_ISSUE_DT").append("'")
            .append(" value='").append(""+ent.getCOMPANY_DIAG_ISSUE_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DIAG_ORG_CODE").append("'")
            .append(" value='").append(""+ent.getDIAG_ORG_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DIAG_NM_NM").append("'")
            .append(" value='").append(""+ent.getDIAG_NM_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DIAG_NM_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getDIAG_NM_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PAY_CAP").append("'")
            .append(" value='").append(""+ent.getPAY_CAP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REA_CAP").append("'")
            .append(" value='").append(""+ent.getREA_CAP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TUP_AOM").append("'")
            .append(" value='").append(""+ent.getTUP_AOM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TUP_CLASS_CODE").append("'")
            .append(" value='").append(""+ent.getTUP_CLASS_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COM_COV_DT").append("'")
            .append(" value='").append(""+ent.getCOM_COV_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BAS_STA_DT").append("'")
            .append(" value='").append(""+ent.getBAS_STA_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFICE_OWN_CLASS").append("'")
            .append(" value='").append(""+ent.getOFFICE_OWN_CLASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_MOBILE").append("'")
            .append(" value='").append(""+ent.getREP_MOBILE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LICTAX").append("'")
            .append(" value='").append(""+ent.getLICTAX()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("HOSCRE").append("'")
            .append(" value='").append(""+ent.getHOSCRE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COM_NUM").append("'")
            .append(" value='").append(""+ent.getCOM_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("GUBUN").append("'")
            .append(" value='").append(""+ent.getGUBUN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_CODE").append("'")
            .append(" value='").append(""+ent.getDOC_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFICE_USE_NAME").append("'")
            .append(" value='").append(""+ent.getOFFICE_USE_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MEMO_CONT").append("'")
            .append(" value='").append(""+ent.getMEMO_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getASSI_TMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_COI_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getASSI_COI_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_COMMANA_CLASS").append("'")
            .append(" value='").append(""+ent.getASSI_COMMANA_CLASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_MANA_NUM").append("'")
            .append(" value='").append(""+ent.getASSI_MANA_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_STE").append("'")
            .append(" value='").append(""+ent.getASSI_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_NAME").append("'")
            .append(" value='").append(""+ent.getASSI_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_TELNUM").append("'")
            .append(" value='").append(""+ent.getASSI_TELNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_REP").append("'")
            .append(" value='").append(""+ent.getASSI_REP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_COMNUM").append("'")
            .append(" value='").append(""+ent.getASSI_COMNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_ADDR").append("'")
            .append(" value='").append(""+ent.getASSI_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_POST_NUM").append("'")
            .append(" value='").append(""+ent.getASSI_POST_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_DETAIL_ADDR").append("'")
            .append(" value='").append(""+ent.getASSI_DETAIL_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_GUBUN").append("'")
            .append(" value='").append(""+ent.getASSI_GUBUN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_WRT_DT").append("'")
            .append(" value='").append(""+ent.getASSI_WRT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_CHGBRE_SEQ").append("'")
            .append(" value='").append(""+ent.getASSI_CHGBRE_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTRAN_TMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_COI_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTRAN_COI_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_COMMANA_CLASS").append("'")
            .append(" value='").append(""+ent.getTRAN_COMMANA_CLASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_MANA_NUM").append("'")
            .append(" value='").append(""+ent.getTRAN_MANA_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_NAME").append("'")
            .append(" value='").append(""+ent.getTRAN_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_TELNUM").append("'")
            .append(" value='").append(""+ent.getTRAN_TELNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_REP").append("'")
            .append(" value='").append(""+ent.getTRAN_REP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_COMNUM").append("'")
            .append(" value='").append(""+ent.getTRAN_COMNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_ADDR").append("'")
            .append(" value='").append(""+ent.getTRAN_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_POST_NUM").append("'")
            .append(" value='").append(""+ent.getTRAN_POST_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_DETAIL_ADDR").append("'")
            .append(" value='").append(""+ent.getTRAN_DETAIL_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_GUBUN").append("'")
            .append(" value='").append(""+ent.getTRAN_GUBUN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_WRT_DT").append("'")
            .append(" value='").append(""+ent.getTRAN_WRT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_CHGBRE_SEQ").append("'")
            .append(" value='").append(""+ent.getTRAN_CHGBRE_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMPANY_DIAG_BAS_DT2").append("'")
            .append(" value='").append(""+ent.getCOMPANY_DIAG_BAS_DT2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BUSS_YMD").append("'")
            .append(" value='").append(""+ent.getBUSS_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FOREIGN_YN").append("'")
            .append(" value='").append(""+ent.getFOREIGN_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REGIST_YMD").append("'")
            .append(" value='").append(""+ent.getREGIST_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_BUSS_YMD").append("'")
            .append(" value='").append(""+ent.getASSI_BUSS_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_FOREIGN_YN").append("'")
            .append(" value='").append(""+ent.getASSI_FOREIGN_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSI_REGIST_YMD").append("'")
            .append(" value='").append(""+ent.getASSI_REGIST_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_BUSS_YMD").append("'")
            .append(" value='").append(""+ent.getTRAN_BUSS_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_FOREIGN_YN").append("'")
            .append(" value='").append(""+ent.getTRAN_FOREIGN_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAN_REGIST_YMD").append("'")
            .append(" value='").append(""+ent.getTRAN_REGIST_YMD()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
