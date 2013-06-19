

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_SYSVAR_PDA
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               PDA_MAC_ADDR:VARCHAR2(125):  
*               PDA_NUM:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SIDO_CODE:VARCHAR2(4):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               SEQ:NUMBER(4):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_S_SYSVAR_PDAHelper{

  final static public String PDA_MAC_ADDR = "PDA_MAC_ADDR";
  final static public String PDA_NUM = "PDA_NUM";
  final static public String WRT_ID = "WRT_ID";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String SEQ = "SEQ";
  


  public static HashMap fieldMap = new HashMap(8);
  static{
  fieldMap.put(PDA_MAC_ADDR,new Integer(1) );
  fieldMap.put(PDA_NUM,new Integer(2) );
  fieldMap.put(WRT_ID,new Integer(3) );
  fieldMap.put(INS_DT,new Integer(4) );
  fieldMap.put(UPD_DT,new Integer(5) );
  fieldMap.put(SIDO_CODE,new Integer(6) );
  fieldMap.put(SIGUNGU_CODE,new Integer(7) );
  fieldMap.put(SEQ,new Integer(8) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_S_SYSVAR_PDA";
     final public static String PREFIX = "sp.dao.PT_S_SYSVAR_PDA";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,SIDO_CODE,SIGUNGU_CODE };
     final public static String FIELD_LIST[] = { 
       PDA_MAC_ADDR,PDA_NUM,WRT_ID,INS_DT,UPD_DT,SIDO_CODE,SIGUNGU_CODE,SEQ };
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
	    }

         return null;
    }

   public static String toXML(PT_S_SYSVAR_PDAEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PDA_MAC_ADDR").append("'")
            .append(" value='").append(""+ent.getPDA_MAC_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PDA_NUM").append("'")
            .append(" value='").append(""+ent.getPDA_NUM()).append("' />\n");
        
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
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
