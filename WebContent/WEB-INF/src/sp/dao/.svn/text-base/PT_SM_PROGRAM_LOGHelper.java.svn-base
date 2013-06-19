

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_SM_PROGRAM_LOG
*  테이블 설명 :
*  테이블 PK   :  
*               LOG_NUM  
*               USER_CODE
*  테이블 컬럼 :  
*               LOG_NUM:NUMBER(22):  
*               USER_CODE:VARCHAR2(10):  
*               ACCESS_TIME:VARCHAR2(20):  
*               PROGRAM_ID:VARCHAR2(20):  
*               USER_ACTION:VARCHAR2(4):  
*               REQ_URI:VARCHAR2(128):  
*               USER_DATA:VARCHAR2(500):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_SM_PROGRAM_LOGHelper{

  final static public String LOG_NUM = "LOG_NUM";
  final static public String USER_CODE = "USER_CODE";
  final static public String ACCESS_TIME = "ACCESS_TIME";
  final static public String PROGRAM_ID = "PROGRAM_ID";
  final static public String USER_ACTION = "USER_ACTION";
  final static public String REQ_URI = "REQ_URI";
  final static public String USER_DATA = "USER_DATA";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(LOG_NUM,new Integer(1) );
  fieldMap.put(USER_CODE,new Integer(2) );
  fieldMap.put(ACCESS_TIME,new Integer(3) );
  fieldMap.put(PROGRAM_ID,new Integer(4) );
  fieldMap.put(USER_ACTION,new Integer(5) );
  fieldMap.put(REQ_URI,new Integer(6) );
  fieldMap.put(USER_DATA,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_SM_PROGRAM_LOG";
     final public static String PREFIX = "sp.dao.PT_SM_PROGRAM_LOG";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       LOG_NUM,USER_CODE };
     final public static String FIELD_LIST[] = { 
       LOG_NUM,USER_CODE,ACCESS_TIME,PROGRAM_ID,USER_ACTION,REQ_URI,USER_DATA };
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

   public static String toXML(PT_SM_PROGRAM_LOGEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LOG_NUM").append("'")
            .append(" value='").append(""+ent.getLOG_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_CODE").append("'")
            .append(" value='").append(""+ent.getUSER_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ACCESS_TIME").append("'")
            .append(" value='").append(""+ent.getACCESS_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROGRAM_ID").append("'")
            .append(" value='").append(""+ent.getPROGRAM_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_ACTION").append("'")
            .append(" value='").append(""+ent.getUSER_ACTION()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REQ_URI").append("'")
            .append(" value='").append(""+ent.getREQ_URI()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_DATA").append("'")
            .append(" value='").append(""+ent.getUSER_DATA()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
