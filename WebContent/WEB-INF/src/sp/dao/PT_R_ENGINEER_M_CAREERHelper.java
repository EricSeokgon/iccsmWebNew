

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_M_CAREER
*  테이블 설명 :
*  테이블 PK   :  
*               CARE_BOOK_ISSUE_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):  
*               POW:VARCHAR2(10):  
*               CARETERM_START_DT:VARCHAR2(8):  
*               CARETERM_END_DT:VARCHAR2(8):  
*               OFF_WORK:VARCHAR2(20):  
*               EXCH_CARE:VARCHAR2(6):  
*               CARE_TOT:VARCHAR2(6):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(30):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_ENGINEER_M_CAREERHelper{

  final static public String SEQ = "SEQ";
  final static public String CARE_BOOK_ISSUE_NUM = "CARE_BOOK_ISSUE_NUM";
  final static public String POW = "POW";
  final static public String CARETERM_START_DT = "CARETERM_START_DT";
  final static public String CARETERM_END_DT = "CARETERM_END_DT";
  final static public String OFF_WORK = "OFF_WORK";
  final static public String EXCH_CARE = "EXCH_CARE";
  final static public String CARE_TOT = "CARE_TOT";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String ETC1 = "ETC1";
  


  public static HashMap fieldMap = new HashMap(12);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(CARE_BOOK_ISSUE_NUM,new Integer(2) );
  fieldMap.put(POW,new Integer(3) );
  fieldMap.put(CARETERM_START_DT,new Integer(4) );
  fieldMap.put(CARETERM_END_DT,new Integer(5) );
  fieldMap.put(OFF_WORK,new Integer(6) );
  fieldMap.put(EXCH_CARE,new Integer(7) );
  fieldMap.put(CARE_TOT,new Integer(8) );
  fieldMap.put(WRT_ID,new Integer(9) );
  fieldMap.put(UPD_DT,new Integer(10) );
  fieldMap.put(INS_DT,new Integer(11) );
  fieldMap.put(ETC1,new Integer(12) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_ENGINEER_M_CAREER";
     final public static String PREFIX = "sp.dao.PT_R_ENGINEER_M_CAREER";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CARE_BOOK_ISSUE_NUM,SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,CARE_BOOK_ISSUE_NUM,POW,CARETERM_START_DT,CARETERM_END_DT,OFF_WORK,EXCH_CARE,CARE_TOT,WRT_ID,UPD_DT,INS_DT,ETC1 };
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
	    }

         return null;
    }

   public static String toXML(PT_R_ENGINEER_M_CAREEREntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARE_BOOK_ISSUE_NUM").append("'")
            .append(" value='").append(""+ent.getCARE_BOOK_ISSUE_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("POW").append("'")
            .append(" value='").append(""+ent.getPOW()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARETERM_START_DT").append("'")
            .append(" value='").append(""+ent.getCARETERM_START_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARETERM_END_DT").append("'")
            .append(" value='").append(""+ent.getCARETERM_END_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFF_WORK").append("'")
            .append(" value='").append(""+ent.getOFF_WORK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EXCH_CARE").append("'")
            .append(" value='").append(""+ent.getEXCH_CARE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARE_TOT").append("'")
            .append(" value='").append(""+ent.getCARE_TOT()).append("' />\n");
        
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
            .append(" name='").append("ETC1").append("'")
            .append(" value='").append(""+ent.getETC1()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
