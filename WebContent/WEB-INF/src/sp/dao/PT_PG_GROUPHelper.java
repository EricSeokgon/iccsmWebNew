

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_PG_GROUP
*  테이블 설명 :
*  테이블 PK   :  
*               PG_GROUP_ID
*  테이블 컬럼 :  
*               PG_GROUP_ID:VARCHAR2(5):  
*               P_PG_GROUP_ID:VARCHAR2(5):  
*               GROUP_NAME:VARCHAR2(100):  
*               UPD_DT:DATE:  
*               PG_GROUP_URL:VARCHAR2(100):  
*               USE_YN:VARCHAR2(1):  
*               ORDER_SEQ:NUMBER(11):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_PG_GROUPHelper{

  final static public String PG_GROUP_ID = "PG_GROUP_ID";
  final static public String P_PG_GROUP_ID = "P_PG_GROUP_ID";
  final static public String GROUP_NAME = "GROUP_NAME";
  final static public String UPD_DT = "UPD_DT";
  final static public String PG_GROUP_URL = "PG_GROUP_URL";
  final static public String USE_YN = "USE_YN";
  final static public String ORDER_SEQ = "ORDER_SEQ";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(PG_GROUP_ID,new Integer(1) );
  fieldMap.put(P_PG_GROUP_ID,new Integer(2) );
  fieldMap.put(GROUP_NAME,new Integer(3) );
  fieldMap.put(UPD_DT,new Integer(4) );
  fieldMap.put(PG_GROUP_URL,new Integer(5) );
  fieldMap.put(USE_YN,new Integer(6) );
  fieldMap.put(ORDER_SEQ,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_PG_GROUP";
     final public static String PREFIX = "sp.dao.PT_PG_GROUP";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       PG_GROUP_ID };
     final public static String FIELD_LIST[] = { 
       PG_GROUP_ID,P_PG_GROUP_ID,GROUP_NAME,UPD_DT,PG_GROUP_URL,USE_YN,ORDER_SEQ };
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

   public static String toXML(PT_PG_GROUPEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PG_GROUP_ID").append("'")
            .append(" value='").append(""+ent.getPG_GROUP_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("P_PG_GROUP_ID").append("'")
            .append(" value='").append(""+ent.getP_PG_GROUP_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("GROUP_NAME").append("'")
            .append(" value='").append(""+ent.getGROUP_NAME()).append("' />\n");
        
         xml.append("<field type='").append("Date").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PG_GROUP_URL").append("'")
            .append(" value='").append(""+ent.getPG_GROUP_URL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_YN").append("'")
            .append(" value='").append(""+ent.getUSE_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORDER_SEQ").append("'")
            .append(" value='").append(""+ent.getORDER_SEQ()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
