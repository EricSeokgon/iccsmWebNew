

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_AUTH_USER
*  테이블 설명 :
*  테이블 PK   :  
*               PG_ID  
*               USER_ID
*  테이블 컬럼 :  
*               USER_ID:VARCHAR2(30):  
*               PG_ID:VARCHAR2(5):  
*               PG_GROUP_ID:VARCHAR2(5):  
*               READ_FLAG:VARCHAR2(1):  
*               WRITE_FLAG:VARCHAR2(1):  
*               COM_FLAG:VARCHAR2(1):  
*               UPD_DT:DATE:
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_AUTH_USERHelper{

  final static public String USER_ID = "USER_ID";
  final static public String PG_ID = "PG_ID";
  final static public String PG_GROUP_ID = "PG_GROUP_ID";
  final static public String READ_FLAG = "READ_FLAG";
  final static public String WRITE_FLAG = "WRITE_FLAG";
  final static public String COM_FLAG = "COM_FLAG";
  final static public String UPD_DT = "UPD_DT";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(USER_ID,new Integer(1) );
  fieldMap.put(PG_ID,new Integer(2) );
  fieldMap.put(PG_GROUP_ID,new Integer(3) );
  fieldMap.put(READ_FLAG,new Integer(4) );
  fieldMap.put(WRITE_FLAG,new Integer(5) );
  fieldMap.put(COM_FLAG,new Integer(6) );
  fieldMap.put(UPD_DT,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_AUTH_USER";
     final public static String PREFIX = "sp.dao.PT_AUTH_USER";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       PG_ID,USER_ID };
     final public static String FIELD_LIST[] = { 
       USER_ID,PG_ID,PG_GROUP_ID,READ_FLAG,WRITE_FLAG,COM_FLAG,UPD_DT };
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

   public static String toXML(PT_AUTH_USEREntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_ID").append("'")
            .append(" value='").append(""+ent.getUSER_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PG_ID").append("'")
            .append(" value='").append(""+ent.getPG_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PG_GROUP_ID").append("'")
            .append(" value='").append(""+ent.getPG_GROUP_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("READ_FLAG").append("'")
            .append(" value='").append(""+ent.getREAD_FLAG()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRITE_FLAG").append("'")
            .append(" value='").append(""+ent.getWRITE_FLAG()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COM_FLAG").append("'")
            .append(" value='").append(""+ent.getCOM_FLAG()).append("' />\n");
        
         xml.append("<field type='").append("Date").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
