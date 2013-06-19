

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_COM_NAME_CHANGE
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               CHGBRE_SEQ:VARCHAR2(10):  
*               TMP_WRT_NUM:VARCHAR2(20):  
*               NAME_KOR:VARCHAR2(50):  
*               NAME_HAN:VARCHAR2(50):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(50):  
*               ETC2:VARCHAR2(50):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_COM_NAME_CHANGEHelper{

  final static public String CHGBRE_SEQ = "CHGBRE_SEQ";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String NAME_KOR = "NAME_KOR";
  final static public String NAME_HAN = "NAME_HAN";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String ETC1 = "ETC1";
  final static public String ETC2 = "ETC2";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(CHGBRE_SEQ,new Integer(1) );
  fieldMap.put(TMP_WRT_NUM,new Integer(2) );
  fieldMap.put(NAME_KOR,new Integer(3) );
  fieldMap.put(NAME_HAN,new Integer(4) );
  fieldMap.put(WRT_ID,new Integer(5) );
  fieldMap.put(UPD_DT,new Integer(6) );
  fieldMap.put(INS_DT,new Integer(7) );
  fieldMap.put(ETC1,new Integer(8) );
  fieldMap.put(ETC2,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_COM_NAME_CHANGE";
     final public static String PREFIX = "sp.dao.PT_R_COM_NAME_CHANGE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CHGBRE_SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       CHGBRE_SEQ,TMP_WRT_NUM,NAME_KOR,NAME_HAN,WRT_ID,UPD_DT,INS_DT,ETC1,ETC2 };
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
	    }

         return null;
    }

   public static String toXML(PT_R_COM_NAME_CHANGEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHGBRE_SEQ").append("'")
            .append(" value='").append(""+ent.getCHGBRE_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NAME_KOR").append("'")
            .append(" value='").append(""+ent.getNAME_KOR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NAME_HAN").append("'")
            .append(" value='").append(""+ent.getNAME_HAN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC1").append("'")
            .append(" value='").append(""+ent.getETC1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC2").append("'")
            .append(" value='").append(""+ent.getETC2()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
