

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_USER
*  테이블 설명 :
*  테이블 PK   :  
*               USER_CODE
*  테이블 컬럼 :  
*               USER_CODE:VARCHAR2(10):  
*               USER_NAME:VARCHAR2(40):  
*               USER_ID:VARCHAR2(12):  
*               USER_PASSWD:VARCHAR2(12):  
*               USER_EMAIL:VARCHAR2(60):  
*               USER_TEL:VARCHAR2(14):  
*               USER_MOBILE:VARCHAR2(14):  
*               USER_NAT_NUM:VARCHAR2(14):  
*               POST:VARCHAR2(40):  
*               EMAIL:VARCHAR2(50):  
*               CAPITAL:VARCHAR2(20):  
*               USE_YN:VARCHAR2(1):  
*               REG_DATE:VARCHAR2(30):  
*               MOD_DATE:VARCHAR2(10):  
*               LAST_CONN:VARCHAR2(20):  
*               ORGANIZATION:VARCHAR2(40):  
*               POSITION:VARCHAR2(50):  
*               STAFF_SYSTEM:VARCHAR2(40):  
*               STAFF_LEVEL:VARCHAR2(40):  
*               USER_AUTH:VARCHAR2(20):  
*               USER_LEVEL:NUMBER(22):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_USERHelper{

  final static public String USER_CODE = "USER_CODE";
  final static public String USER_NAME = "USER_NAME";
  final static public String USER_ID = "USER_ID";
  final static public String USER_PASSWD = "USER_PASSWD";
  final static public String USER_EMAIL = "USER_EMAIL";
  final static public String USER_TEL = "USER_TEL";
  final static public String USER_MOBILE = "USER_MOBILE";
  final static public String USER_NAT_NUM = "USER_NAT_NUM";
  final static public String POST = "POST";
  final static public String EMAIL = "EMAIL";
  final static public String CAPITAL = "CAPITAL";
  final static public String USE_YN = "USE_YN";
  final static public String REG_DATE = "REG_DATE";
  final static public String MOD_DATE = "MOD_DATE";
  final static public String LAST_CONN = "LAST_CONN";
  final static public String ORGANIZATION = "ORGANIZATION";
  final static public String POSITION = "POSITION";
  final static public String STAFF_SYSTEM = "STAFF_SYSTEM";
  final static public String STAFF_LEVEL = "STAFF_LEVEL";
  final static public String USER_AUTH = "USER_AUTH";
  final static public String USER_LEVEL = "USER_LEVEL";
  


  public static HashMap fieldMap = new HashMap(21);
  static{
  fieldMap.put(USER_CODE,new Integer(1) );
  fieldMap.put(USER_NAME,new Integer(2) );
  fieldMap.put(USER_ID,new Integer(3) );
  fieldMap.put(USER_PASSWD,new Integer(4) );
  fieldMap.put(USER_EMAIL,new Integer(5) );
  fieldMap.put(USER_TEL,new Integer(6) );
  fieldMap.put(USER_MOBILE,new Integer(7) );
  fieldMap.put(USER_NAT_NUM,new Integer(8) );
  fieldMap.put(POST,new Integer(9) );
  fieldMap.put(EMAIL,new Integer(10) );
  fieldMap.put(CAPITAL,new Integer(11) );
  fieldMap.put(USE_YN,new Integer(12) );
  fieldMap.put(REG_DATE,new Integer(13) );
  fieldMap.put(MOD_DATE,new Integer(14) );
  fieldMap.put(LAST_CONN,new Integer(15) );
  fieldMap.put(ORGANIZATION,new Integer(16) );
  fieldMap.put(POSITION,new Integer(17) );
  fieldMap.put(STAFF_SYSTEM,new Integer(18) );
  fieldMap.put(STAFF_LEVEL,new Integer(19) );
  fieldMap.put(USER_AUTH,new Integer(20) );
  fieldMap.put(USER_LEVEL,new Integer(21) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_USER";
     final public static String PREFIX = "sp.dao.PT_USER";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       USER_CODE };
     final public static String FIELD_LIST[] = { 
       USER_CODE,USER_NAME,USER_ID,USER_PASSWD,USER_EMAIL,USER_TEL,USER_MOBILE,USER_NAT_NUM,POST,EMAIL,CAPITAL,USE_YN,REG_DATE,MOD_DATE,LAST_CONN,ORGANIZATION,POSITION,STAFF_SYSTEM,STAFF_LEVEL,USER_AUTH,USER_LEVEL };
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
             case 10 : 
	                  return  "";
             case 11 : 
	                  return  "";
             case 12 : 
	                  return  "";
             case 13 : 
	                  return  "";
             case 14 : 
	                  return  "";
             case 15 : 
	                  return  "";
             case 16 : 
	                  return  "";
             case 17 : 
	                  return  "";
             case 18 : 
	                  return  "";
             case 19 : 
	                  return  "";
             case 20 : 
	                  return  "";
             case 21 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_USEREntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_CODE").append("'")
            .append(" value='").append(""+ent.getUSER_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_NAME").append("'")
            .append(" value='").append(""+ent.getUSER_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_ID").append("'")
            .append(" value='").append(""+ent.getUSER_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_PASSWD").append("'")
            .append(" value='").append(""+ent.getUSER_PASSWD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_EMAIL").append("'")
            .append(" value='").append(""+ent.getUSER_EMAIL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_TEL").append("'")
            .append(" value='").append(""+ent.getUSER_TEL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_MOBILE").append("'")
            .append(" value='").append(""+ent.getUSER_MOBILE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_NAT_NUM").append("'")
            .append(" value='").append(""+ent.getUSER_NAT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("POST").append("'")
            .append(" value='").append(""+ent.getPOST()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EMAIL").append("'")
            .append(" value='").append(""+ent.getEMAIL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CAPITAL").append("'")
            .append(" value='").append(""+ent.getCAPITAL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_YN").append("'")
            .append(" value='").append(""+ent.getUSE_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REG_DATE").append("'")
            .append(" value='").append(""+ent.getREG_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOD_DATE").append("'")
            .append(" value='").append(""+ent.getMOD_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LAST_CONN").append("'")
            .append(" value='").append(""+ent.getLAST_CONN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORGANIZATION").append("'")
            .append(" value='").append(""+ent.getORGANIZATION()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("POSITION").append("'")
            .append(" value='").append(""+ent.getPOSITION()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STAFF_SYSTEM").append("'")
            .append(" value='").append(""+ent.getSTAFF_SYSTEM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STAFF_LEVEL").append("'")
            .append(" value='").append(""+ent.getSTAFF_LEVEL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_AUTH").append("'")
            .append(" value='").append(""+ent.getUSER_AUTH()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_LEVEL").append("'")
            .append(" value='").append(""+ent.getUSER_LEVEL()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
