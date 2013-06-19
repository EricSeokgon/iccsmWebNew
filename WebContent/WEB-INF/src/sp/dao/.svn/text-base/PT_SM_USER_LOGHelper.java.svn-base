

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_SM_USER_LOG
*  테이블 설명 :
*  테이블 PK   :  
*               LOG_NUM
*  테이블 컬럼 :  
*               LOG_NUM:NUMBER(11):  
*               USER_ID:VARCHAR2(16):  
*               ACCESS_TIME:VARCHAR2(20):  
*               END_TIME:VARCHAR2(20):  
*               ACCESS_IP:VARCHAR2(15):  
*               BROWSER:VARCHAR2(128):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_SM_USER_LOGHelper{

  final static public String LOG_NUM = "LOG_NUM";
  final static public String USER_ID = "USER_ID";
  final static public String ACCESS_TIME = "ACCESS_TIME";
  final static public String END_TIME = "END_TIME";
  final static public String ACCESS_IP = "ACCESS_IP";
  final static public String BROWSER = "BROWSER";
  


  public static HashMap fieldMap = new HashMap(6);
  static{
  fieldMap.put(LOG_NUM,new Integer(1) );
  fieldMap.put(USER_ID,new Integer(2) );
  fieldMap.put(ACCESS_TIME,new Integer(3) );
  fieldMap.put(END_TIME,new Integer(4) );
  fieldMap.put(ACCESS_IP,new Integer(5) );
  fieldMap.put(BROWSER,new Integer(6) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_SM_USER_LOG";
     final public static String PREFIX = "sp.dao.PT_SM_USER_LOG";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       LOG_NUM };
     final public static String FIELD_LIST[] = { 
       LOG_NUM,USER_ID,ACCESS_TIME,END_TIME,ACCESS_IP,BROWSER };
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

   public static String toXML(PT_SM_USER_LOGEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LOG_NUM").append("'")
            .append(" value='").append(""+ent.getLOG_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_ID").append("'")
            .append(" value='").append(""+ent.getUSER_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ACCESS_TIME").append("'")
            .append(" value='").append(""+ent.getACCESS_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("END_TIME").append("'")
            .append(" value='").append(""+ent.getEND_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ACCESS_IP").append("'")
            .append(" value='").append(""+ent.getACCESS_IP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BROWSER").append("'")
            .append(" value='").append(""+ent.getBROWSER()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
