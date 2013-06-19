

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_SUVDEFICIT
*  테이블 설명 :
*  테이블 PK   :  
*               DEFI_SEQ  
*               RECV_NUM  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               DEFI_SEQ:NUMBER(4):  
*               DEFI_CODE:VARCHAR2(6):  
*               DEFI_OUT:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               RECV_NUM:VARCHAR2(16):  
*               SIDO_CODE:VARCHAR2(20):  
*               SIGUNGU_CODE:VARCHAR2(5):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_UB_SUVDEFICITHelper{

  final static public String DEFI_SEQ = "DEFI_SEQ";
  final static public String DEFI_CODE = "DEFI_CODE";
  final static public String DEFI_OUT = "DEFI_OUT";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(DEFI_SEQ,new Integer(1) );
  fieldMap.put(DEFI_CODE,new Integer(2) );
  fieldMap.put(DEFI_OUT,new Integer(3) );
  fieldMap.put(WRT_ID,new Integer(4) );
  fieldMap.put(UPD_DT,new Integer(5) );
  fieldMap.put(INS_DT,new Integer(6) );
  fieldMap.put(RECV_NUM,new Integer(7) );
  fieldMap.put(SIDO_CODE,new Integer(8) );
  fieldMap.put(SIGUNGU_CODE,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_UB_SUVDEFICIT";
     final public static String PREFIX = "sp.dao.PT_UB_SUVDEFICIT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       DEFI_SEQ,RECV_NUM,SIDO_CODE,SIGUNGU_CODE };
     final public static String FIELD_LIST[] = { 
       DEFI_SEQ,DEFI_CODE,DEFI_OUT,WRT_ID,UPD_DT,INS_DT,RECV_NUM,SIDO_CODE,SIGUNGU_CODE };
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

   public static String toXML(PT_UB_SUVDEFICITEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFI_SEQ").append("'")
            .append(" value='").append(""+ent.getDEFI_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFI_CODE").append("'")
            .append(" value='").append(""+ent.getDEFI_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFI_OUT").append("'")
            .append(" value='").append(""+ent.getDEFI_OUT()).append("' />\n");
        
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
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
