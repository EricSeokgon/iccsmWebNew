

/*
*  Automatic generated  source
*  ��  ��  �� : ���� 
*
*  ���̺� ��   :PT_R_BASIC_CHANGE_HISTORY
*  ���̺� ���� :
*  ���̺� PK   :  
*               CHGBRE_SEQ  
*               TMP_WRT_NUM
*  ���̺� �÷� :  
*               SIDO_CODE:VARCHAR2(4):  
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
*               C_COM_DT:VARCHAR2(8):  
*               C_COM_CAUSE_CODE:VARCHAR2(6):  
*               COM_COV_DT:VARCHAR2(8):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(8):  
*               BAS_STA_DT:VARCHAR2(8):  
*               OFFICE_OWN_CLASS:VARCHAR2(1):  
*               CHGBRE_SEQ:NUMBER(4):  
*               STA_CHG_CLASS_CODE:VARCHAR2(6):  
*               RECV_NUM:VARCHAR2(100):  
*               CHG_DT:VARCHAR2(8):  
*               MOT_STE:VARCHAR2(6):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               COI_WRT_NUM:VARCHAR2(12):  
*               REP_MOBILE:VARCHAR2(17):  
*               HOSCRE:VARCHAR2(1):  
*               LICTAX:VARCHAR2(1):  
*               SND_DT:VARCHAR2(8):  
*               SND_STE:VARCHAR2(1):  
*               COM_NUM:VARCHAR2(13):  
*               ADDR_TEL_NUM1:VARCHAR2(4):  
*               ADDR_TEL_NUM2:VARCHAR2(4):  
*               ADDR_TEL_NUM3:VARCHAR2(4):  
*               ADDR_FAX_NUM1:VARCHAR2(4):  
*               ADDR_FAX_NUM2:VARCHAR2(4):  
*               ADDR_FAX_NUM3:VARCHAR2(4):  
*               REP_MOBILE1:VARCHAR2(4):  
*               REP_MOBILE2:VARCHAR2(4):  
*               REP_MOBILE3:VARCHAR2(4):  
*               COMPANY_DIAG_BAS_DT2:VARCHAR2(4):  
*               EXT_CHG_CLASS_CODE:VARCHAR2(4):  
*               REC_DT:VARCHAR2(10):  
*               SEQ_LINK_ADDR:VARCHAR2(30):  
*               SEQ_LINK_CAPITAL:VARCHAR2(30):  
*               SEQ_LINK_NAME:VARCHAR2(30):  
*               SEQ_LINK_REP:VARCHAR2(30):  
*               RECV_NUM2:VARCHAR2(12):  
*               DOC_CODE:VARCHAR2(50):  
*               GUBUN:VARCHAR2(25):  
*               MEMO_CONT:VARCHAR2(256):  
*               BUSS_YMD:VARCHAR2(8):  
*               FOREIGN_YN:VARCHAR2(4):  
*               REGIST_YMD:VARCHAR2(8):  
*               MIDAL_YN:VARCHAR2(1):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_BASIC_CHANGE_HISTORYHelper{

  final static public String SIDO_CODE = "SIDO_CODE";
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
  final static public String C_COM_DT = "C_COM_DT";
  final static public String C_COM_CAUSE_CODE = "C_COM_CAUSE_CODE";
  final static public String COM_COV_DT = "COM_COV_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String WRT_DT = "WRT_DT";
  final static public String BAS_STA_DT = "BAS_STA_DT";
  final static public String OFFICE_OWN_CLASS = "OFFICE_OWN_CLASS";
  final static public String CHGBRE_SEQ = "CHGBRE_SEQ";
  final static public String STA_CHG_CLASS_CODE = "STA_CHG_CLASS_CODE";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String CHG_DT = "CHG_DT";
  final static public String MOT_STE = "MOT_STE";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String COI_WRT_NUM = "COI_WRT_NUM";
  final static public String REP_MOBILE = "REP_MOBILE";
  final static public String HOSCRE = "HOSCRE";
  final static public String LICTAX = "LICTAX";
  final static public String SND_DT = "SND_DT";
  final static public String SND_STE = "SND_STE";
  final static public String COM_NUM = "COM_NUM";
  final static public String ADDR_TEL_NUM1 = "ADDR_TEL_NUM1";
  final static public String ADDR_TEL_NUM2 = "ADDR_TEL_NUM2";
  final static public String ADDR_TEL_NUM3 = "ADDR_TEL_NUM3";
  final static public String ADDR_FAX_NUM1 = "ADDR_FAX_NUM1";
  final static public String ADDR_FAX_NUM2 = "ADDR_FAX_NUM2";
  final static public String ADDR_FAX_NUM3 = "ADDR_FAX_NUM3";
  final static public String REP_MOBILE1 = "REP_MOBILE1";
  final static public String REP_MOBILE2 = "REP_MOBILE2";
  final static public String REP_MOBILE3 = "REP_MOBILE3";
  final static public String COMPANY_DIAG_BAS_DT2 = "COMPANY_DIAG_BAS_DT2";
  final static public String EXT_CHG_CLASS_CODE = "EXT_CHG_CLASS_CODE";
  final static public String REC_DT = "REC_DT";
  final static public String SEQ_LINK_ADDR = "SEQ_LINK_ADDR";
  final static public String SEQ_LINK_CAPITAL = "SEQ_LINK_CAPITAL";
  final static public String SEQ_LINK_NAME = "SEQ_LINK_NAME";
  final static public String SEQ_LINK_REP = "SEQ_LINK_REP";
  final static public String RECV_NUM2 = "RECV_NUM2";
  final static public String DOC_CODE = "DOC_CODE";
  final static public String GUBUN = "GUBUN";
  final static public String MEMO_CONT = "MEMO_CONT";
  final static public String BUSS_YMD = "BUSS_YMD";
  final static public String FOREIGN_YN = "FOREIGN_YN";
  final static public String REGIST_YMD = "REGIST_YMD";
  final static public String MIDAL_YN = "MIDAL_YN";
  


  public static HashMap fieldMap = new HashMap(73);
  static{
  fieldMap.put(SIDO_CODE,new Integer(1) );
  fieldMap.put(COMMANA_CLASS,new Integer(2) );
  fieldMap.put(MANA_NUM,new Integer(3) );
  fieldMap.put(NAME,new Integer(4) );
  fieldMap.put(REP_SSN1,new Integer(5) );
  fieldMap.put(REP_SSN2,new Integer(6) );
  fieldMap.put(REP_NM_KOR,new Integer(7) );
  fieldMap.put(REP_NM_HAN,new Integer(8) );
  fieldMap.put(REP_TEL_NUM,new Integer(9) );
  fieldMap.put(ADDR_POST_NUM,new Integer(10) );
  fieldMap.put(ADDR_ADDR,new Integer(11) );
  fieldMap.put(ADDR_DETAIL_ADDR,new Integer(12) );
  fieldMap.put(ADDR_TEL_NUM,new Integer(13) );
  fieldMap.put(ADDR_FAX_NUM,new Integer(14) );
  fieldMap.put(EMAIL_ADDR,new Integer(15) );
  fieldMap.put(OFFICE_AREA,new Integer(16) );
  fieldMap.put(OFFICE_USE_CODE,new Integer(17) );
  fieldMap.put(COMPANY_DIAG_CLASS_CODE,new Integer(18) );
  fieldMap.put(COMPANY_DIAG_BAS_DT,new Integer(19) );
  fieldMap.put(COMPANY_DIAG_ISSUE_DT,new Integer(20) );
  fieldMap.put(DIAG_ORG_CODE,new Integer(21) );
  fieldMap.put(DIAG_NM_NM,new Integer(22) );
  fieldMap.put(DIAG_NM_WRT_NUM,new Integer(23) );
  fieldMap.put(PAY_CAP,new Integer(24) );
  fieldMap.put(REA_CAP,new Integer(25) );
  fieldMap.put(TUP_AOM,new Integer(26) );
  fieldMap.put(TUP_CLASS_CODE,new Integer(27) );
  fieldMap.put(C_COM_DT,new Integer(28) );
  fieldMap.put(C_COM_CAUSE_CODE,new Integer(29) );
  fieldMap.put(COM_COV_DT,new Integer(30) );
  fieldMap.put(WRT_ID,new Integer(31) );
  fieldMap.put(UPD_DT,new Integer(32) );
  fieldMap.put(INS_DT,new Integer(33) );
  fieldMap.put(WRT_DT,new Integer(34) );
  fieldMap.put(BAS_STA_DT,new Integer(35) );
  fieldMap.put(OFFICE_OWN_CLASS,new Integer(36) );
  fieldMap.put(CHGBRE_SEQ,new Integer(37) );
  fieldMap.put(STA_CHG_CLASS_CODE,new Integer(38) );
  fieldMap.put(RECV_NUM,new Integer(39) );
  fieldMap.put(CHG_DT,new Integer(40) );
  fieldMap.put(MOT_STE,new Integer(41) );
  fieldMap.put(TMP_WRT_NUM,new Integer(42) );
  fieldMap.put(COI_WRT_NUM,new Integer(43) );
  fieldMap.put(REP_MOBILE,new Integer(44) );
  fieldMap.put(HOSCRE,new Integer(45) );
  fieldMap.put(LICTAX,new Integer(46) );
  fieldMap.put(SND_DT,new Integer(47) );
  fieldMap.put(SND_STE,new Integer(48) );
  fieldMap.put(COM_NUM,new Integer(49) );
  fieldMap.put(ADDR_TEL_NUM1,new Integer(50) );
  fieldMap.put(ADDR_TEL_NUM2,new Integer(51) );
  fieldMap.put(ADDR_TEL_NUM3,new Integer(52) );
  fieldMap.put(ADDR_FAX_NUM1,new Integer(53) );
  fieldMap.put(ADDR_FAX_NUM2,new Integer(54) );
  fieldMap.put(ADDR_FAX_NUM3,new Integer(55) );
  fieldMap.put(REP_MOBILE1,new Integer(56) );
  fieldMap.put(REP_MOBILE2,new Integer(57) );
  fieldMap.put(REP_MOBILE3,new Integer(58) );
  fieldMap.put(COMPANY_DIAG_BAS_DT2,new Integer(59) );
  fieldMap.put(EXT_CHG_CLASS_CODE,new Integer(60) );
  fieldMap.put(REC_DT,new Integer(61) );
  fieldMap.put(SEQ_LINK_ADDR,new Integer(62) );
  fieldMap.put(SEQ_LINK_CAPITAL,new Integer(63) );
  fieldMap.put(SEQ_LINK_NAME,new Integer(64) );
  fieldMap.put(SEQ_LINK_REP,new Integer(65) );
  fieldMap.put(RECV_NUM2,new Integer(66) );
  fieldMap.put(DOC_CODE,new Integer(67) );
  fieldMap.put(GUBUN,new Integer(68) );
  fieldMap.put(MEMO_CONT,new Integer(69) );
  fieldMap.put(BUSS_YMD,new Integer(70) );
  fieldMap.put(FOREIGN_YN,new Integer(71) );
  fieldMap.put(REGIST_YMD,new Integer(72) );
  fieldMap.put(MIDAL_YN,new Integer(73) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_BASIC_CHANGE_HISTORY";
     final public static String PREFIX = "sp.dao.PT_R_BASIC_CHANGE_HISTORY";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CHGBRE_SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       SIDO_CODE,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,C_COM_DT,C_COM_CAUSE_CODE,COM_COV_DT,WRT_ID,UPD_DT,INS_DT,WRT_DT,BAS_STA_DT,OFFICE_OWN_CLASS,CHGBRE_SEQ,STA_CHG_CLASS_CODE,RECV_NUM,CHG_DT,MOT_STE,TMP_WRT_NUM,COI_WRT_NUM,REP_MOBILE,HOSCRE,LICTAX,SND_DT,SND_STE,COM_NUM,ADDR_TEL_NUM1,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM1,ADDR_FAX_NUM2,ADDR_FAX_NUM3,REP_MOBILE1,REP_MOBILE2,REP_MOBILE3,COMPANY_DIAG_BAS_DT2,EXT_CHG_CLASS_CODE,REC_DT,SEQ_LINK_ADDR,SEQ_LINK_CAPITAL,SEQ_LINK_NAME,SEQ_LINK_REP,RECV_NUM2,DOC_CODE,GUBUN,MEMO_CONT,BUSS_YMD,FOREIGN_YN,REGIST_YMD,MIDAL_YN };
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
	    }

         return null;
    }

   public static String toXML(PT_R_BASIC_CHANGE_HISTORYEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
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
            .append(" name='").append("C_COM_DT").append("'")
            .append(" value='").append(""+ent.getC_COM_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("C_COM_CAUSE_CODE").append("'")
            .append(" value='").append(""+ent.getC_COM_CAUSE_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COM_COV_DT").append("'")
            .append(" value='").append(""+ent.getCOM_COV_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_DT").append("'")
            .append(" value='").append(""+ent.getWRT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BAS_STA_DT").append("'")
            .append(" value='").append(""+ent.getBAS_STA_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFICE_OWN_CLASS").append("'")
            .append(" value='").append(""+ent.getOFFICE_OWN_CLASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHGBRE_SEQ").append("'")
            .append(" value='").append(""+ent.getCHGBRE_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STA_CHG_CLASS_CODE").append("'")
            .append(" value='").append(""+ent.getSTA_CHG_CLASS_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHG_DT").append("'")
            .append(" value='").append(""+ent.getCHG_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOT_STE").append("'")
            .append(" value='").append(""+ent.getMOT_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COI_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getCOI_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_MOBILE").append("'")
            .append(" value='").append(""+ent.getREP_MOBILE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("HOSCRE").append("'")
            .append(" value='").append(""+ent.getHOSCRE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LICTAX").append("'")
            .append(" value='").append(""+ent.getLICTAX()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SND_DT").append("'")
            .append(" value='").append(""+ent.getSND_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SND_STE").append("'")
            .append(" value='").append(""+ent.getSND_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COM_NUM").append("'")
            .append(" value='").append(""+ent.getCOM_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_TEL_NUM1").append("'")
            .append(" value='").append(""+ent.getADDR_TEL_NUM1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_TEL_NUM2").append("'")
            .append(" value='").append(""+ent.getADDR_TEL_NUM2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_TEL_NUM3").append("'")
            .append(" value='").append(""+ent.getADDR_TEL_NUM3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_FAX_NUM1").append("'")
            .append(" value='").append(""+ent.getADDR_FAX_NUM1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_FAX_NUM2").append("'")
            .append(" value='").append(""+ent.getADDR_FAX_NUM2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_FAX_NUM3").append("'")
            .append(" value='").append(""+ent.getADDR_FAX_NUM3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_MOBILE1").append("'")
            .append(" value='").append(""+ent.getREP_MOBILE1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_MOBILE2").append("'")
            .append(" value='").append(""+ent.getREP_MOBILE2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_MOBILE3").append("'")
            .append(" value='").append(""+ent.getREP_MOBILE3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMPANY_DIAG_BAS_DT2").append("'")
            .append(" value='").append(""+ent.getCOMPANY_DIAG_BAS_DT2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EXT_CHG_CLASS_CODE").append("'")
            .append(" value='").append(""+ent.getEXT_CHG_CLASS_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REC_DT").append("'")
            .append(" value='").append(""+ent.getREC_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ_LINK_ADDR").append("'")
            .append(" value='").append(""+ent.getSEQ_LINK_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ_LINK_CAPITAL").append("'")
            .append(" value='").append(""+ent.getSEQ_LINK_CAPITAL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ_LINK_NAME").append("'")
            .append(" value='").append(""+ent.getSEQ_LINK_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ_LINK_REP").append("'")
            .append(" value='").append(""+ent.getSEQ_LINK_REP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM2").append("'")
            .append(" value='").append(""+ent.getRECV_NUM2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_CODE").append("'")
            .append(" value='").append(""+ent.getDOC_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("GUBUN").append("'")
            .append(" value='").append(""+ent.getGUBUN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MEMO_CONT").append("'")
            .append(" value='").append(""+ent.getMEMO_CONT()).append("' />\n");
        
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
            .append(" name='").append("MIDAL_YN").append("'")
            .append(" value='").append(""+ent.getMIDAL_YN()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
