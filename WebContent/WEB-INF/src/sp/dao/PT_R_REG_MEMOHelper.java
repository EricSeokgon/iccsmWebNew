

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REG_MEMO
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               MEMO_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               MEMO_SEQ:NUMBER(4):  
*               MEMO_CONT:VARCHAR2(512):  
*               WRT_DT:VARCHAR2(8):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               CHGBRE_SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_REG_MEMOHelper{

  final static public String MEMO_SEQ = "MEMO_SEQ";
  final static public String MEMO_CONT = "MEMO_CONT";
  final static public String WRT_DT = "WRT_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String CHGBRE_SEQ = "CHGBRE_SEQ";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(MEMO_SEQ,new Integer(1) );
  fieldMap.put(MEMO_CONT,new Integer(2) );
  fieldMap.put(WRT_DT,new Integer(3) );
  fieldMap.put(UPD_DT,new Integer(4) );
  fieldMap.put(INS_DT,new Integer(5) );
  fieldMap.put(CHGBRE_SEQ,new Integer(6) );
  fieldMap.put(TMP_WRT_NUM,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_REG_MEMO";
     final public static String PREFIX = "sp.dao.PT_R_REG_MEMO";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CHGBRE_SEQ,MEMO_SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       MEMO_SEQ,MEMO_CONT,WRT_DT,UPD_DT,INS_DT,CHGBRE_SEQ,TMP_WRT_NUM };
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

   public static String toXML(PT_R_REG_MEMOEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MEMO_SEQ").append("'")
            .append(" value='").append(""+ent.getMEMO_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MEMO_CONT").append("'")
            .append(" value='").append(""+ent.getMEMO_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_DT").append("'")
            .append(" value='").append(""+ent.getWRT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHGBRE_SEQ").append("'")
            .append(" value='").append(""+ent.getCHGBRE_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
