

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_PROSECUTION
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               PRSEC_DT:VARCHAR2(8):  
*               PRSEC_CONT:VARCHAR2(1024):  
*               PRSEC_PERSON_ID:VARCHAR2(16):  
*               PRSEC_PART:VARCHAR2(100):  
*               PRSEC_PART_TELNUM:VARCHAR2(17):  
*               PRSEC_PART_OFFI:VARCHAR2(20):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_M_PROSECUTIONHelper{

  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String PRSEC_DT = "PRSEC_DT";
  final static public String PRSEC_CONT = "PRSEC_CONT";
  final static public String PRSEC_PERSON_ID = "PRSEC_PERSON_ID";
  final static public String PRSEC_PART = "PRSEC_PART";
  final static public String PRSEC_PART_TELNUM = "PRSEC_PART_TELNUM";
  final static public String PRSEC_PART_OFFI = "PRSEC_PART_OFFI";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  


  public static HashMap fieldMap = new HashMap(11);
  static{
  fieldMap.put(TMP_WRT_NUM,new Integer(1) );
  fieldMap.put(WRT_NUM,new Integer(2) );
  fieldMap.put(PRSEC_DT,new Integer(3) );
  fieldMap.put(PRSEC_CONT,new Integer(4) );
  fieldMap.put(PRSEC_PERSON_ID,new Integer(5) );
  fieldMap.put(PRSEC_PART,new Integer(6) );
  fieldMap.put(PRSEC_PART_TELNUM,new Integer(7) );
  fieldMap.put(PRSEC_PART_OFFI,new Integer(8) );
  fieldMap.put(INS_DT,new Integer(9) );
  fieldMap.put(UPD_DT,new Integer(10) );
  fieldMap.put(WRT_ID,new Integer(11) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_M_PROSECUTION";
     final public static String PREFIX = "sp.dao.PT_M_PROSECUTION";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM };
     final public static String FIELD_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM,PRSEC_DT,PRSEC_CONT,PRSEC_PERSON_ID,PRSEC_PART,PRSEC_PART_TELNUM,PRSEC_PART_OFFI,INS_DT,UPD_DT,WRT_ID };
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
	    }

         return null;
    }

   public static String toXML(PT_M_PROSECUTIONEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PRSEC_DT").append("'")
            .append(" value='").append(""+ent.getPRSEC_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PRSEC_CONT").append("'")
            .append(" value='").append(""+ent.getPRSEC_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PRSEC_PERSON_ID").append("'")
            .append(" value='").append(""+ent.getPRSEC_PERSON_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PRSEC_PART").append("'")
            .append(" value='").append(""+ent.getPRSEC_PART()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PRSEC_PART_TELNUM").append("'")
            .append(" value='").append(""+ent.getPRSEC_PART_TELNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PRSEC_PART_OFFI").append("'")
            .append(" value='").append(""+ent.getPRSEC_PART_OFFI()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
