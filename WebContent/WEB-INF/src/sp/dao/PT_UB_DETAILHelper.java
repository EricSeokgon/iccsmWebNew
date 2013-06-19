

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_DETAIL
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               SIDO_CODE  
*               SIGUNGU_CODE  
*               SRL
*  테이블 컬럼 :  
*               DETAIL_CONT:VARCHAR2(100):  
*               ITEM_OUT:VARCHAR2(4):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SRL:NUMBER(4):  
*               SEQ:NUMBER(22):  
*               SIDO_CODE:VARCHAR2(5):  
*               RECV_NUM:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(4):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_UB_DETAILHelper{

  final static public String DETAIL_CONT = "DETAIL_CONT";
  final static public String ITEM_OUT = "ITEM_OUT";
  final static public String WRT_ID = "WRT_ID";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String SRL = "SRL";
  final static public String SEQ = "SEQ";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  


  public static HashMap fieldMap = new HashMap(10);
  static{
  fieldMap.put(DETAIL_CONT,new Integer(1) );
  fieldMap.put(ITEM_OUT,new Integer(2) );
  fieldMap.put(WRT_ID,new Integer(3) );
  fieldMap.put(INS_DT,new Integer(4) );
  fieldMap.put(UPD_DT,new Integer(5) );
  fieldMap.put(SRL,new Integer(6) );
  fieldMap.put(SEQ,new Integer(7) );
  fieldMap.put(SIDO_CODE,new Integer(8) );
  fieldMap.put(RECV_NUM,new Integer(9) );
  fieldMap.put(SIGUNGU_CODE,new Integer(10) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_UB_DETAIL";
     final public static String PREFIX = "sp.dao.PT_UB_DETAIL";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SEQ,SIDO_CODE,SIGUNGU_CODE,SRL };
     final public static String FIELD_LIST[] = { 
       DETAIL_CONT,ITEM_OUT,WRT_ID,INS_DT,UPD_DT,SRL,SEQ,SIDO_CODE,RECV_NUM,SIGUNGU_CODE };
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
	    }

         return null;
    }

   public static String toXML(PT_UB_DETAILEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAIL_CONT").append("'")
            .append(" value='").append(""+ent.getDETAIL_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ITEM_OUT").append("'")
            .append(" value='").append(""+ent.getITEM_OUT()).append("' />\n");
        
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
            .append(" name='").append("SRL").append("'")
            .append(" value='").append(""+ent.getSRL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
