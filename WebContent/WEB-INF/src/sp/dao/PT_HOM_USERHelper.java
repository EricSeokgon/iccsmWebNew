

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_HOM_USER
*  테이블 설명 :
*  테이블 PK   :  
*               USER_ID
*  테이블 컬럼 :  
*               USER_ID:VARCHAR2(16):  
*               USER_NAME:VARCHAR2(64):  
*               USER_PASSWD:VARCHAR2(64):  
*               USER_NAT_NUM1:VARCHAR2(16):  
*               USER_NAT_NUM2:VARCHAR2(50):  
*               USER_EMAIL:VARCHAR2(128):  
*               USER_ZIPCODE:VARCHAR2(8):  
*               USER_ADDR:VARCHAR2(128):  
*               USER_ADDR_ETC:VARCHAR2(128):  
*               USER_TEL:VARCHAR2(16):  
*               USER_MOBILE:VARCHAR2(16):  
*               USER_SEX:VARCHAR2(16):  
*               INP_SITE:VARCHAR2(50):  
*               SC_CD:VARCHAR2(4):  
*               SGG_CD:VARCHAR2(4):  
*               CAPITAL:VARCHAR2(2):  
*               BIGO:VARCHAR2(200):  
*               SMS_YN:VARCHAR2(2):  
*               NEWS_YN:VARCHAR2(2):  
*               USE_CODE:VARCHAR2(1):  
*               INS_DT:DATE:  
*               UPD_DT:DATE:
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_HOM_USERHelper{

  final static public String USER_ID = "USER_ID";
  final static public String USER_NAME = "USER_NAME";
  final static public String USER_PASSWD = "USER_PASSWD";
  final static public String USER_NAT_NUM1 = "USER_NAT_NUM1";
  final static public String USER_NAT_NUM2 = "USER_NAT_NUM2";
  final static public String USER_EMAIL = "USER_EMAIL";
  final static public String USER_ZIPCODE = "USER_ZIPCODE";
  final static public String USER_ADDR = "USER_ADDR";
  final static public String USER_ADDR_ETC = "USER_ADDR_ETC";
  final static public String USER_TEL = "USER_TEL";
  final static public String USER_MOBILE = "USER_MOBILE";
  final static public String USER_SEX = "USER_SEX";
  final static public String INP_SITE = "INP_SITE";
  final static public String SC_CD = "SC_CD";
  final static public String SGG_CD = "SGG_CD";
  final static public String CAPITAL = "CAPITAL";
  final static public String BIGO = "BIGO";
  final static public String SMS_YN = "SMS_YN";
  final static public String NEWS_YN = "NEWS_YN";
  final static public String USE_CODE = "USE_CODE";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  


  public static HashMap fieldMap = new HashMap(22);
  static{
  fieldMap.put(USER_ID,new Integer(1) );
  fieldMap.put(USER_NAME,new Integer(2) );
  fieldMap.put(USER_PASSWD,new Integer(3) );
  fieldMap.put(USER_NAT_NUM1,new Integer(4) );
  fieldMap.put(USER_NAT_NUM2,new Integer(5) );
  fieldMap.put(USER_EMAIL,new Integer(6) );
  fieldMap.put(USER_ZIPCODE,new Integer(7) );
  fieldMap.put(USER_ADDR,new Integer(8) );
  fieldMap.put(USER_ADDR_ETC,new Integer(9) );
  fieldMap.put(USER_TEL,new Integer(10) );
  fieldMap.put(USER_MOBILE,new Integer(11) );
  fieldMap.put(USER_SEX,new Integer(12) );
  fieldMap.put(INP_SITE,new Integer(13) );
  fieldMap.put(SC_CD,new Integer(14) );
  fieldMap.put(SGG_CD,new Integer(15) );
  fieldMap.put(CAPITAL,new Integer(16) );
  fieldMap.put(BIGO,new Integer(17) );
  fieldMap.put(SMS_YN,new Integer(18) );
  fieldMap.put(NEWS_YN,new Integer(19) );
  fieldMap.put(USE_CODE,new Integer(20) );
  fieldMap.put(INS_DT,new Integer(21) );
  fieldMap.put(UPD_DT,new Integer(22) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_HOM_USER";
     final public static String PREFIX = "sp.dao.PT_HOM_USER";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       USER_ID };
     final public static String FIELD_LIST[] = { 
       USER_ID,USER_NAME,USER_PASSWD,USER_NAT_NUM1,USER_NAT_NUM2,USER_EMAIL,USER_ZIPCODE,USER_ADDR,USER_ADDR_ETC,USER_TEL,USER_MOBILE,USER_SEX,INP_SITE,SC_CD,SGG_CD,CAPITAL,BIGO,SMS_YN,NEWS_YN,USE_CODE,INS_DT,UPD_DT };
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
             case 22 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_HOM_USEREntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_ID").append("'")
            .append(" value='").append(""+ent.getUSER_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_NAME").append("'")
            .append(" value='").append(""+ent.getUSER_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_PASSWD").append("'")
            .append(" value='").append(""+ent.getUSER_PASSWD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_NAT_NUM1").append("'")
            .append(" value='").append(""+ent.getUSER_NAT_NUM1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_NAT_NUM2").append("'")
            .append(" value='").append(""+ent.getUSER_NAT_NUM2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_EMAIL").append("'")
            .append(" value='").append(""+ent.getUSER_EMAIL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_ZIPCODE").append("'")
            .append(" value='").append(""+ent.getUSER_ZIPCODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_ADDR").append("'")
            .append(" value='").append(""+ent.getUSER_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_ADDR_ETC").append("'")
            .append(" value='").append(""+ent.getUSER_ADDR_ETC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_TEL").append("'")
            .append(" value='").append(""+ent.getUSER_TEL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_MOBILE").append("'")
            .append(" value='").append(""+ent.getUSER_MOBILE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_SEX").append("'")
            .append(" value='").append(""+ent.getUSER_SEX()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INP_SITE").append("'")
            .append(" value='").append(""+ent.getINP_SITE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SC_CD").append("'")
            .append(" value='").append(""+ent.getSC_CD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SGG_CD").append("'")
            .append(" value='").append(""+ent.getSGG_CD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CAPITAL").append("'")
            .append(" value='").append(""+ent.getCAPITAL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BIGO").append("'")
            .append(" value='").append(""+ent.getBIGO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SMS_YN").append("'")
            .append(" value='").append(""+ent.getSMS_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NEWS_YN").append("'")
            .append(" value='").append(""+ent.getNEWS_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_CODE").append("'")
            .append(" value='").append(""+ent.getUSE_CODE()).append("' />\n");
        
         xml.append("<field type='").append("Date").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("Date").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
