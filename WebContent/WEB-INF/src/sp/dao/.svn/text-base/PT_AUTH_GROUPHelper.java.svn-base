

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_AUTH_GROUP
*  테이블 설명 :
*  테이블 PK   :  
*               AUTH_GROUP_CODE
*  테이블 컬럼 :  
*               AUTH_GROUP_CODE:VARCHAR2(5):  
*               AUTH_GROUP_NAME:VARCHAR2(30):  
*               ORDER_SEQ:NUMBER(11):  
*               UPD_DT:VARCHAR2(24):  
*               USE_YN:VARCHAR2(1):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_AUTH_GROUPHelper{

  final static public String AUTH_GROUP_CODE = "AUTH_GROUP_CODE";
  final static public String AUTH_GROUP_NAME = "AUTH_GROUP_NAME";
  final static public String ORDER_SEQ = "ORDER_SEQ";
  final static public String UPD_DT = "UPD_DT";
  final static public String USE_YN = "USE_YN";
  


  public static HashMap fieldMap = new HashMap(5);
  static{
  fieldMap.put(AUTH_GROUP_CODE,new Integer(1) );
  fieldMap.put(AUTH_GROUP_NAME,new Integer(2) );
  fieldMap.put(ORDER_SEQ,new Integer(3) );
  fieldMap.put(UPD_DT,new Integer(4) );
  fieldMap.put(USE_YN,new Integer(5) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_AUTH_GROUP";
     final public static String PREFIX = "sp.dao.PT_AUTH_GROUP";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       AUTH_GROUP_CODE };
     final public static String FIELD_LIST[] = { 
       AUTH_GROUP_CODE,AUTH_GROUP_NAME,ORDER_SEQ,UPD_DT,USE_YN };
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
	    }

         return null;
    }

   public static String toXML(PT_AUTH_GROUPEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUTH_GROUP_CODE").append("'")
            .append(" value='").append(""+ent.getAUTH_GROUP_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUTH_GROUP_NAME").append("'")
            .append(" value='").append(""+ent.getAUTH_GROUP_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORDER_SEQ").append("'")
            .append(" value='").append(""+ent.getORDER_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_YN").append("'")
            .append(" value='").append(""+ent.getUSE_YN()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
