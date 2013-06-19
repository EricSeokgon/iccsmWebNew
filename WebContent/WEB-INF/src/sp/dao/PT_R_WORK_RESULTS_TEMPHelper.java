

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_WORK_RESULTS_TEMP
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(4):  
*               RECV_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               WORK_PROC:VARCHAR2(2):  
*               YEAR:VARCHAR2(4):  
*               WORK_ROM:VARCHAR2(15):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_WORK_RESULTS_TEMPHelper{

  final static public String SEQ = "SEQ";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String WORK_PROC = "WORK_PROC";
  final static public String YEAR = "YEAR";
  final static public String WORK_ROM = "WORK_ROM";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  


  public static HashMap fieldMap = new HashMap(10);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(RECV_NUM,new Integer(2) );
  fieldMap.put(TMP_WRT_NUM,new Integer(3) );
  fieldMap.put(SIDO_CODE,new Integer(4) );
  fieldMap.put(WORK_PROC,new Integer(5) );
  fieldMap.put(YEAR,new Integer(6) );
  fieldMap.put(WORK_ROM,new Integer(7) );
  fieldMap.put(WRT_ID,new Integer(8) );
  fieldMap.put(UPD_DT,new Integer(9) );
  fieldMap.put(INS_DT,new Integer(10) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_WORK_RESULTS_TEMP";
     final public static String PREFIX = "sp.dao.PT_R_WORK_RESULTS_TEMP";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       SEQ,RECV_NUM,TMP_WRT_NUM,SIDO_CODE,WORK_PROC,YEAR,WORK_ROM,WRT_ID,UPD_DT,INS_DT };
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

   public static String toXML(PT_R_WORK_RESULTS_TEMPEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WORK_PROC").append("'")
            .append(" value='").append(""+ent.getWORK_PROC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("YEAR").append("'")
            .append(" value='").append(""+ent.getYEAR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WORK_ROM").append("'")
            .append(" value='").append(""+ent.getWORK_ROM()).append("' />\n");
        
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
