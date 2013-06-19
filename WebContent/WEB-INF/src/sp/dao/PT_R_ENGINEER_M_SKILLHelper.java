

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_M_SKILL
*  테이블 설명 :
*  테이블 PK   :  
*               CARE_BOOK_ISSUE_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):  
*               ITEM_GRADE:VARCHAR2(10):  
*               WRT_NUM:VARCHAR2(12):  
*               PAS_YMD:VARCHAR2(8):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(20):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_ENGINEER_M_SKILLHelper{

  final static public String SEQ = "SEQ";
  final static public String CARE_BOOK_ISSUE_NUM = "CARE_BOOK_ISSUE_NUM";
  final static public String ITEM_GRADE = "ITEM_GRADE";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String PAS_YMD = "PAS_YMD";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String ETC1 = "ETC1";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(CARE_BOOK_ISSUE_NUM,new Integer(2) );
  fieldMap.put(ITEM_GRADE,new Integer(3) );
  fieldMap.put(WRT_NUM,new Integer(4) );
  fieldMap.put(PAS_YMD,new Integer(5) );
  fieldMap.put(WRT_ID,new Integer(6) );
  fieldMap.put(UPD_DT,new Integer(7) );
  fieldMap.put(INS_DT,new Integer(8) );
  fieldMap.put(ETC1,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_ENGINEER_M_SKILL";
     final public static String PREFIX = "sp.dao.PT_R_ENGINEER_M_SKILL";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CARE_BOOK_ISSUE_NUM,SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,CARE_BOOK_ISSUE_NUM,ITEM_GRADE,WRT_NUM,PAS_YMD,WRT_ID,UPD_DT,INS_DT,ETC1 };
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
	    }

         return null;
    }

   public static String toXML(PT_R_ENGINEER_M_SKILLEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARE_BOOK_ISSUE_NUM").append("'")
            .append(" value='").append(""+ent.getCARE_BOOK_ISSUE_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ITEM_GRADE").append("'")
            .append(" value='").append(""+ent.getITEM_GRADE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PAS_YMD").append("'")
            .append(" value='").append(""+ent.getPAS_YMD()).append("' />\n");
        
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
