

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_PAGE_CODE
*  테이블 설명 :
*  테이블 PK   :  
*               CODE_GROUP_ID
*  테이블 컬럼 :  
*               CODE_GROUP_ID:NUMBER(22):  
*               CODE_GROUP:VARCHAR2(4):  
*               CODE:VARCHAR2(16):  
*               CODE_NAME:VARCHAR2(50):  
*               CODE_URL:VARCHAR2(100):  
*               ORDER_NUM:NUMBER(22):  
*               USE_YN:VARCHAR2(1):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_PAGE_CODEHelper{

  final static public String CODE_GROUP_ID = "CODE_GROUP_ID";
  final static public String CODE_GROUP = "CODE_GROUP";
  final static public String CODE = "CODE";
  final static public String CODE_NAME = "CODE_NAME";
  final static public String CODE_URL = "CODE_URL";
  final static public String ORDER_NUM = "ORDER_NUM";
  final static public String USE_YN = "USE_YN";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(CODE_GROUP_ID,new Integer(1) );
  fieldMap.put(CODE_GROUP,new Integer(2) );
  fieldMap.put(CODE,new Integer(3) );
  fieldMap.put(CODE_NAME,new Integer(4) );
  fieldMap.put(CODE_URL,new Integer(5) );
  fieldMap.put(ORDER_NUM,new Integer(6) );
  fieldMap.put(USE_YN,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_PAGE_CODE";
     final public static String PREFIX = "sp.dao.PT_PAGE_CODE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CODE_GROUP_ID };
     final public static String FIELD_LIST[] = { 
       CODE_GROUP_ID,CODE_GROUP,CODE,CODE_NAME,CODE_URL,ORDER_NUM,USE_YN };
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

   public static String toXML(PT_PAGE_CODEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CODE_GROUP_ID").append("'")
            .append(" value='").append(""+ent.getCODE_GROUP_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CODE_GROUP").append("'")
            .append(" value='").append(""+ent.getCODE_GROUP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CODE").append("'")
            .append(" value='").append(""+ent.getCODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CODE_NAME").append("'")
            .append(" value='").append(""+ent.getCODE_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CODE_URL").append("'")
            .append(" value='").append(""+ent.getCODE_URL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORDER_NUM").append("'")
            .append(" value='").append(""+ent.getORDER_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_YN").append("'")
            .append(" value='").append(""+ent.getUSE_YN()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
