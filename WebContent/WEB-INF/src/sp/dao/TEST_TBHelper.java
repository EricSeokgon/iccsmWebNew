

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :TEST_TB
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               JUMIN:VARCHAR2(32):  
*               JUMIN_ENCODE:VARCHAR2(50):  
*               JUMIN_JAVA:VARCHAR2(50):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class TEST_TBHelper{

  final static public String JUMIN = "JUMIN";
  final static public String JUMIN_ENCODE = "JUMIN_ENCODE";
  final static public String JUMIN_JAVA = "JUMIN_JAVA";
  


  public static HashMap fieldMap = new HashMap(3);
  static{
  fieldMap.put(JUMIN,new Integer(1) );
  fieldMap.put(JUMIN_ENCODE,new Integer(2) );
  fieldMap.put(JUMIN_JAVA,new Integer(3) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "TEST_TB";
     final public static String PREFIX = "sp.dao.TEST_TB";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
        };
     final public static String FIELD_LIST[] = { 
       JUMIN,JUMIN_ENCODE,JUMIN_JAVA };
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
	    }

         return null;
    }

   public static String toXML(TEST_TBEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("JUMIN").append("'")
            .append(" value='").append(""+ent.getJUMIN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("JUMIN_ENCODE").append("'")
            .append(" value='").append(""+ent.getJUMIN_ENCODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("JUMIN_JAVA").append("'")
            .append(" value='").append(""+ent.getJUMIN_JAVA()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
