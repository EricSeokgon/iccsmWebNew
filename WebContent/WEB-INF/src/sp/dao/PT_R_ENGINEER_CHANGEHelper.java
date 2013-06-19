

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_CHANGE
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               ENGINEER_NM:VARCHAR2(20):  
*               ENGINEER_SSN1:VARCHAR2(18):  
*               ENGINEER_SSN2:VARCHAR2(21):  
*               EMPL_YMD:VARCHAR2(8):  
*               RET_YMD:VARCHAR2(8):  
*               REMARK:VARCHAR2(256):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               TMP_FIELD:VARCHAR2(20):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_ENGINEER_CHANGEHelper{

  final static public String ENGINEER_NM = "ENGINEER_NM";
  final static public String ENGINEER_SSN1 = "ENGINEER_SSN1";
  final static public String ENGINEER_SSN2 = "ENGINEER_SSN2";
  final static public String EMPL_YMD = "EMPL_YMD";
  final static public String RET_YMD = "RET_YMD";
  final static public String REMARK = "REMARK";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String SEQ = "SEQ";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String TMP_FIELD = "TMP_FIELD";
  final static public String CARE_BOOK_VAL_START_DT = "CARE_BOOK_VAL_START_DT";
  final static public String CARE_BOOK_VAL_END_DT = "CARE_BOOK_VAL_END_DT";
  final static public String ISSUE_DT = "ISSUE_DT";
  final static public String CARE_BOOK_ISSUE_NUM = "CARE_BOOK_ISSUE_NUM";
  


  public static HashMap fieldMap = new HashMap(12);
  static{
  fieldMap.put(ENGINEER_NM,new Integer(1) );
  fieldMap.put(ENGINEER_SSN1,new Integer(2) );
  fieldMap.put(ENGINEER_SSN2,new Integer(3) );
  fieldMap.put(EMPL_YMD,new Integer(4) );
  fieldMap.put(RET_YMD,new Integer(5) );
  fieldMap.put(REMARK,new Integer(6) );
  fieldMap.put(WRT_ID,new Integer(7) );
  fieldMap.put(UPD_DT,new Integer(8) );
  fieldMap.put(INS_DT,new Integer(9) );
  fieldMap.put(SEQ,new Integer(10) );
  fieldMap.put(TMP_WRT_NUM,new Integer(11) );
  fieldMap.put(TMP_FIELD,new Integer(12) );
  fieldMap.put(CARE_BOOK_VAL_START_DT,new Integer(13) );
  fieldMap.put(CARE_BOOK_VAL_END_DT,new Integer(14) );
  fieldMap.put(ISSUE_DT,new Integer(15) );
  fieldMap.put(CARE_BOOK_ISSUE_NUM,new Integer(16) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_ENGINEER_CHANGE";
     final public static String PREFIX = "sp.dao.PT_R_ENGINEER_CHANGE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       ENGINEER_NM,ENGINEER_SSN1,ENGINEER_SSN2,EMPL_YMD,RET_YMD,REMARK,WRT_ID,UPD_DT,INS_DT,SEQ,TMP_WRT_NUM,TMP_FIELD,CARE_BOOK_VAL_START_DT,CARE_BOOK_VAL_END_DT,ISSUE_DT,CARE_BOOK_ISSUE_NUM };
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
	    }

         return null;
    }

   public static String toXML(PT_R_ENGINEER_CHANGEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ENGINEER_NM").append("'")
            .append(" value='").append(""+ent.getENGINEER_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ENGINEER_SSN1").append("'")
            .append(" value='").append(""+ent.getENGINEER_SSN1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ENGINEER_SSN2").append("'")
            .append(" value='").append(""+ent.getENGINEER_SSN2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EMPL_YMD").append("'")
            .append(" value='").append(""+ent.getEMPL_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RET_YMD").append("'")
            .append(" value='").append(""+ent.getRET_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REMARK").append("'")
            .append(" value='").append(""+ent.getREMARK()).append("' />\n");
        
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
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_FIELD").append("'")
            .append(" value='").append(""+ent.getTMP_FIELD()).append("' />\n");
         
         xml.append("<field type='").append("String").append("' ")
         .append(" name='").append("CARE_BOOK_VAL_START_DT").append("'")
         .append(" value='").append(""+ent.getCARE_BOOK_VAL_START_DT()).append("' />\n");
         
         xml.append("<field type='").append("String").append("' ")
         .append(" name='").append("CARE_BOOK_VAL_END_DT").append("'")
         .append(" value='").append(""+ent.getCARE_BOOK_VAL_END_DT()).append("' />\n");
         
         xml.append("<field type='").append("String").append("' ")
         .append(" name='").append("ISSUE_DT").append("'")
         .append(" value='").append(""+ent.getISSUE_DT()).append("' />\n");
         
         xml.append("<field type='").append("String").append("' ")
         .append(" name='").append("CARE_BOOK_ISSUE_NUM").append("'")
         .append(" value='").append(""+ent.getCARE_BOOK_ISSUE_NUM()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
