

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_SUBSIDIARY_TEMP
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(3):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               RECV_NUM:VARCHAR2(20):  
*               SUB_WRT_NUM:VARCHAR2(50):  
*               SUB_CODE:VARCHAR2(6):  
*               SUB_PROC:VARCHAR2(2):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_SUBSIDIARY_TEMPHelper{

  final static public String SEQ = "SEQ";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String SUB_WRT_NUM = "SUB_WRT_NUM";
  final static public String SUB_CODE = "SUB_CODE";
  final static public String SUB_PROC = "SUB_PROC";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(TMP_WRT_NUM,new Integer(2) );
  fieldMap.put(RECV_NUM,new Integer(3) );
  fieldMap.put(SUB_WRT_NUM,new Integer(4) );
  fieldMap.put(SUB_CODE,new Integer(5) );
  fieldMap.put(SUB_PROC,new Integer(6) );
  fieldMap.put(WRT_ID,new Integer(7) );
  fieldMap.put(UPD_DT,new Integer(8) );
  fieldMap.put(INS_DT,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_SUBSIDIARY_TEMP";
     final public static String PREFIX = "sp.dao.PT_R_SUBSIDIARY_TEMP";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       SEQ,TMP_WRT_NUM,RECV_NUM,SUB_WRT_NUM,SUB_CODE,SUB_PROC,WRT_ID,UPD_DT,INS_DT };
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

   public static String toXML(PT_R_SUBSIDIARY_TEMPEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUB_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getSUB_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUB_CODE").append("'")
            .append(" value='").append(""+ent.getSUB_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUB_PROC").append("'")
            .append(" value='").append(""+ent.getSUB_PROC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
