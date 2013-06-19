

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_1
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(4):  
*               SIDO_NM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               ITEM_NM:VARCHAR2(50):  
*               LINE_NUM:NUMBER(10):  
*               LINE_CH_NUM:NUMBER(10):  
*               LINE_E1_NUM:NUMBER(10):  
*               SET_DT:VARCHAR2(24):  
*               EQU_COST:VARCHAR2(12):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ETC:VARCHAR2(50):  
*               SIGUNGU_CODE:VARCHAR2(4):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_C_RES_1Helper{

  final static public String SEQ = "SEQ";
  final static public String SIDO_NM = "SIDO_NM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String ITEM_NM = "ITEM_NM";
  final static public String LINE_NUM = "LINE_NUM";
  final static public String LINE_CH_NUM = "LINE_CH_NUM";
  final static public String LINE_E1_NUM = "LINE_E1_NUM";
  final static public String SET_DT = "SET_DT";
  final static public String EQU_COST = "EQU_COST";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String ETC = "ETC";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  


  public static HashMap fieldMap = new HashMap(13);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(SIDO_NM,new Integer(2) );
  fieldMap.put(SIDO_CODE,new Integer(3) );
  fieldMap.put(ITEM_NM,new Integer(4) );
  fieldMap.put(LINE_NUM,new Integer(5) );
  fieldMap.put(LINE_CH_NUM,new Integer(6) );
  fieldMap.put(LINE_E1_NUM,new Integer(7) );
  fieldMap.put(SET_DT,new Integer(8) );
  fieldMap.put(EQU_COST,new Integer(9) );
  fieldMap.put(UPD_DT,new Integer(10) );
  fieldMap.put(INS_DT,new Integer(11) );
  fieldMap.put(ETC,new Integer(12) );
  fieldMap.put(SIGUNGU_CODE,new Integer(13) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_C_RES_1";
     final public static String PREFIX = "sp.dao.PT_C_RES_1";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
        };
     final public static String FIELD_LIST[] = { 
       SEQ,SIDO_NM,SIDO_CODE,ITEM_NM,LINE_NUM,LINE_CH_NUM,LINE_E1_NUM,SET_DT,EQU_COST,UPD_DT,INS_DT,ETC,SIGUNGU_CODE };
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
	    }

         return null;
    }

   public static String toXML(PT_C_RES_1Entity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_NM").append("'")
            .append(" value='").append(""+ent.getSIDO_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ITEM_NM").append("'")
            .append(" value='").append(""+ent.getITEM_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LINE_NUM").append("'")
            .append(" value='").append(""+ent.getLINE_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LINE_CH_NUM").append("'")
            .append(" value='").append(""+ent.getLINE_CH_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LINE_E1_NUM").append("'")
            .append(" value='").append(""+ent.getLINE_E1_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SET_DT").append("'")
            .append(" value='").append(""+ent.getSET_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EQU_COST").append("'")
            .append(" value='").append(""+ent.getEQU_COST()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC").append("'")
            .append(" value='").append(""+ent.getETC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
