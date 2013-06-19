

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_SUVSPOT_MASTER
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               SUV_NAME:VARCHAR2(100):  
*               SUV_STANUM:VARCHAR2(24):  
*               SUV_NM:VARCHAR2(26):  
*               SUV_TELNUM:VARCHAR2(24):  
*               SUV_POSTNUM:VARCHAR2(6):  
*               SUV_ADDR:VARCHAR2(64):  
*               SUV_DETAILADDR:VARCHAR2(128):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SUV_MOBILE:VARCHAR2(24):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_UB_SUVSPOT_MASTERHelper{

  final static public String SEQ = "SEQ";
  final static public String SUV_NAME = "SUV_NAME";
  final static public String SUV_STANUM = "SUV_STANUM";
  final static public String SUV_NM = "SUV_NM";
  final static public String SUV_TELNUM = "SUV_TELNUM";
  final static public String SUV_POSTNUM = "SUV_POSTNUM";
  final static public String SUV_ADDR = "SUV_ADDR";
  final static public String SUV_DETAILADDR = "SUV_DETAILADDR";
  final static public String WRT_ID = "WRT_ID";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String SUV_MOBILE = "SUV_MOBILE";
  


  public static HashMap fieldMap = new HashMap(12);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(SUV_NAME,new Integer(2) );
  fieldMap.put(SUV_STANUM,new Integer(3) );
  fieldMap.put(SUV_NM,new Integer(4) );
  fieldMap.put(SUV_TELNUM,new Integer(5) );
  fieldMap.put(SUV_POSTNUM,new Integer(6) );
  fieldMap.put(SUV_ADDR,new Integer(7) );
  fieldMap.put(SUV_DETAILADDR,new Integer(8) );
  fieldMap.put(WRT_ID,new Integer(9) );
  fieldMap.put(INS_DT,new Integer(10) );
  fieldMap.put(UPD_DT,new Integer(11) );
  fieldMap.put(SUV_MOBILE,new Integer(12) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_UB_SUVSPOT_MASTER";
     final public static String PREFIX = "sp.dao.PT_UB_SUVSPOT_MASTER";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,SUV_NAME,SUV_STANUM,SUV_NM,SUV_TELNUM,SUV_POSTNUM,SUV_ADDR,SUV_DETAILADDR,WRT_ID,INS_DT,UPD_DT,SUV_MOBILE };
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
	    }

         return null;
    }

   public static String toXML(PT_UB_SUVSPOT_MASTEREntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_NAME").append("'")
            .append(" value='").append(""+ent.getSUV_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_STANUM").append("'")
            .append(" value='").append(""+ent.getSUV_STANUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_NM").append("'")
            .append(" value='").append(""+ent.getSUV_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_TELNUM").append("'")
            .append(" value='").append(""+ent.getSUV_TELNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_POSTNUM").append("'")
            .append(" value='").append(""+ent.getSUV_POSTNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_ADDR").append("'")
            .append(" value='").append(""+ent.getSUV_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_DETAILADDR").append("'")
            .append(" value='").append(""+ent.getSUV_DETAILADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_MOBILE").append("'")
            .append(" value='").append(""+ent.getSUV_MOBILE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
