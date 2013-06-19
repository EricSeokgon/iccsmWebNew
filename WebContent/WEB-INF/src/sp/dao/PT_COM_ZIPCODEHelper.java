

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_COM_ZIPCODE
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(5):  
*               ZIPCODE:VARCHAR2(7):  
*               SIDO:VARCHAR2(6):  
*               GUGUN:VARCHAR2(30):  
*               DONG:VARCHAR2(100):  
*               BUNJI:VARCHAR2(30):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_COM_ZIPCODEHelper{

  final static public String SEQ = "SEQ";
  final static public String ZIPCODE = "ZIPCODE";
  final static public String SIDO = "SIDO";
  final static public String GUGUN = "GUGUN";
  final static public String DONG = "DONG";
  final static public String BUNJI = "BUNJI";
  


  public static HashMap fieldMap = new HashMap(6);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(ZIPCODE,new Integer(2) );
  fieldMap.put(SIDO,new Integer(3) );
  fieldMap.put(GUGUN,new Integer(4) );
  fieldMap.put(DONG,new Integer(5) );
  fieldMap.put(BUNJI,new Integer(6) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_COM_ZIPCODE";
     final public static String PREFIX = "sp.dao.PT_COM_ZIPCODE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
        };
     final public static String FIELD_LIST[] = { 
       SEQ,ZIPCODE,SIDO,GUGUN,DONG,BUNJI };
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
	    }

         return null;
    }

   public static String toXML(PT_COM_ZIPCODEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ZIPCODE").append("'")
            .append(" value='").append(""+ent.getZIPCODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO").append("'")
            .append(" value='").append(""+ent.getSIDO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("GUGUN").append("'")
            .append(" value='").append(""+ent.getGUGUN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DONG").append("'")
            .append(" value='").append(""+ent.getDONG()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BUNJI").append("'")
            .append(" value='").append(""+ent.getBUNJI()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
