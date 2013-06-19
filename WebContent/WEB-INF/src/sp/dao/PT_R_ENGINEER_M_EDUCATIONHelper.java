

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_M_EDUCATION
*  테이블 설명 :
*  테이블 PK   :  
*               CARE_BOOK_ISSUE_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(15):  
*               TERM:VARCHAR2(3):  
*               EDU_PROCNM:VARCHAR2(30):  
*               COMPLETION_NUM:VARCHAR2(10):  
*               EDU_ORGNM:VARCHAR2(30):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(20):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_ENGINEER_M_EDUCATIONHelper{

  final static public String SEQ = "SEQ";
  final static public String CARE_BOOK_ISSUE_NUM = "CARE_BOOK_ISSUE_NUM";
  final static public String TERM = "TERM";
  final static public String EDU_PROCNM = "EDU_PROCNM";
  final static public String COMPLETION_NUM = "COMPLETION_NUM";
  final static public String EDU_ORGNM = "EDU_ORGNM";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_DT = "WRT_DT";
  final static public String ETC1 = "ETC1";
  


  public static HashMap fieldMap = new HashMap(10);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(CARE_BOOK_ISSUE_NUM,new Integer(2) );
  fieldMap.put(TERM,new Integer(3) );
  fieldMap.put(EDU_PROCNM,new Integer(4) );
  fieldMap.put(COMPLETION_NUM,new Integer(5) );
  fieldMap.put(EDU_ORGNM,new Integer(6) );
  fieldMap.put(WRT_ID,new Integer(7) );
  fieldMap.put(UPD_DT,new Integer(8) );
  fieldMap.put(WRT_DT,new Integer(9) );
  fieldMap.put(ETC1,new Integer(10) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_ENGINEER_M_EDUCATION";
     final public static String PREFIX = "sp.dao.PT_R_ENGINEER_M_EDUCATION";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CARE_BOOK_ISSUE_NUM,SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,CARE_BOOK_ISSUE_NUM,TERM,EDU_PROCNM,COMPLETION_NUM,EDU_ORGNM,WRT_ID,UPD_DT,WRT_DT,ETC1 };
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
	    }

         return null;
    }

   public static String toXML(PT_R_ENGINEER_M_EDUCATIONEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARE_BOOK_ISSUE_NUM").append("'")
            .append(" value='").append(""+ent.getCARE_BOOK_ISSUE_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TERM").append("'")
            .append(" value='").append(""+ent.getTERM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EDU_PROCNM").append("'")
            .append(" value='").append(""+ent.getEDU_PROCNM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMPLETION_NUM").append("'")
            .append(" value='").append(""+ent.getCOMPLETION_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EDU_ORGNM").append("'")
            .append(" value='").append(""+ent.getEDU_ORGNM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_DT").append("'")
            .append(" value='").append(""+ent.getWRT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC1").append("'")
            .append(" value='").append(""+ent.getETC1()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
