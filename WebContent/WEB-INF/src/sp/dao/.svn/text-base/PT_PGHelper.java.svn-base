

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_PG
*  테이블 설명 :
*  테이블 PK   :  
*               PG_ID
*  테이블 컬럼 :  
*               PG_ID:NUMBER(10):  
*               PG_NAME:VARCHAR2(100):  
*               PG_URL:VARCHAR2(200):  
*               UPD_DT:DATE:  
*               USE_YN:VARCHAR2(1):  
*               ORDER_SEQ:NUMBER(22):  
*               PG_GROUP_ID:VARCHAR2(5):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_PGHelper{

  final static public String PG_ID = "PG_ID";
  final static public String PG_NAME = "PG_NAME";
  final static public String PG_URL = "PG_URL";
  final static public String UPD_DT = "UPD_DT";
  final static public String USE_YN = "USE_YN";
  final static public String ORDER_SEQ = "ORDER_SEQ";
  final static public String PG_GROUP_ID = "PG_GROUP_ID";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(PG_ID,new Integer(1) );
  fieldMap.put(PG_NAME,new Integer(2) );
  fieldMap.put(PG_URL,new Integer(3) );
  fieldMap.put(UPD_DT,new Integer(4) );
  fieldMap.put(USE_YN,new Integer(5) );
  fieldMap.put(ORDER_SEQ,new Integer(6) );
  fieldMap.put(PG_GROUP_ID,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_PG";
     final public static String PREFIX = "sp.dao.PT_PG";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       PG_ID };
     final public static String FIELD_LIST[] = { 
       PG_ID,PG_NAME,PG_URL,UPD_DT,USE_YN,ORDER_SEQ,PG_GROUP_ID };
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
	    }

         return null;
    }

   public static String toXML(PT_PGEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PG_ID").append("'")
            .append(" value='").append(""+ent.getPG_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PG_NAME").append("'")
            .append(" value='").append(""+ent.getPG_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PG_URL").append("'")
            .append(" value='").append(""+ent.getPG_URL()).append("' />\n");
        
         xml.append("<field type='").append("Date").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_YN").append("'")
            .append(" value='").append(""+ent.getUSE_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORDER_SEQ").append("'")
            .append(" value='").append(""+ent.getORDER_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PG_GROUP_ID").append("'")
            .append(" value='").append(""+ent.getPG_GROUP_ID()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
