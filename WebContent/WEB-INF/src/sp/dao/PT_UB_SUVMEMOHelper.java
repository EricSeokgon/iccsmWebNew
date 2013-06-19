

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_SUVMEMO
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               MEMO_DT:VARCHAR2(8):  
*               MEMO_CONT:VARCHAR2(512):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               SEQ:NUMBER(4):  
*               RECV_NUM:VARCHAR2(16):  
*               SIDO_CODE:VARCHAR2(4):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               WRT_TIME:VARCHAR2(5):  
*               WRT_NAME:VARCHAR2(25):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_UB_SUVMEMOHelper{

  final static public String MEMO_DT = "MEMO_DT";
  final static public String MEMO_CONT = "MEMO_CONT";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String SEQ = "SEQ";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String WRT_TIME = "WRT_TIME";
  final static public String WRT_NAME = "WRT_NAME";
  


  public static HashMap fieldMap = new HashMap(11);
  static{
  fieldMap.put(MEMO_DT,new Integer(1) );
  fieldMap.put(MEMO_CONT,new Integer(2) );
  fieldMap.put(INS_DT,new Integer(3) );
  fieldMap.put(UPD_DT,new Integer(4) );
  fieldMap.put(WRT_ID,new Integer(5) );
  fieldMap.put(SEQ,new Integer(6) );
  fieldMap.put(RECV_NUM,new Integer(7) );
  fieldMap.put(SIDO_CODE,new Integer(8) );
  fieldMap.put(SIGUNGU_CODE,new Integer(9) );
  fieldMap.put(WRT_TIME,new Integer(10) );
  fieldMap.put(WRT_NAME,new Integer(11) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_UB_SUVMEMO";
     final public static String PREFIX = "sp.dao.PT_UB_SUVMEMO";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SEQ,SIDO_CODE,SIGUNGU_CODE };
     final public static String FIELD_LIST[] = { 
       MEMO_DT,MEMO_CONT,INS_DT,UPD_DT,WRT_ID,SEQ,RECV_NUM,SIDO_CODE,SIGUNGU_CODE,WRT_TIME,WRT_NAME };
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

   public static String toXML(PT_UB_SUVMEMOEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MEMO_DT").append("'")
            .append(" value='").append(""+ent.getMEMO_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MEMO_CONT").append("'")
            .append(" value='").append(""+ent.getMEMO_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_TIME").append("'")
            .append(" value='").append(""+ent.getWRT_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NAME").append("'")
            .append(" value='").append(""+ent.getWRT_NAME()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
