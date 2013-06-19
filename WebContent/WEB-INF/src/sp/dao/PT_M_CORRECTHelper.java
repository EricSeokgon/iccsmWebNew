

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_CORRECT
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               CORRECT_ORDER_CONT:VARCHAR2(1024):  
*               CORRECT_ORDER_START_DT:VARCHAR2(8):  
*               CORRECT_ORDER_END_DT:VARCHAR2(8):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               DECISION_DATE:VARCHAR2(8):  
*               LIS_END_DATE:VARCHAR2(8):  
*               BEFORE_DISPO:VARCHAR2(1):  
*               OPINI_SUBMIT:VARCHAR2(1):  
*               OPINI_SUBMIT_DATE:VARCHAR2(8):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_M_CORRECTHelper{

  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String CORRECT_ORDER_CONT = "CORRECT_ORDER_CONT";
  final static public String CORRECT_ORDER_START_DT = "CORRECT_ORDER_START_DT";
  final static public String CORRECT_ORDER_END_DT = "CORRECT_ORDER_END_DT";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String DECISION_DATE = "DECISION_DATE";
  final static public String LIS_END_DATE = "LIS_END_DATE";
  final static public String BEFORE_DISPO = "BEFORE_DISPO";
  final static public String OPINI_SUBMIT = "OPINI_SUBMIT";
  final static public String OPINI_SUBMIT_DATE = "OPINI_SUBMIT_DATE";
  


  public static HashMap fieldMap = new HashMap(13);
  static{
  fieldMap.put(TMP_WRT_NUM,new Integer(1) );
  fieldMap.put(WRT_NUM,new Integer(2) );
  fieldMap.put(CORRECT_ORDER_CONT,new Integer(3) );
  fieldMap.put(CORRECT_ORDER_START_DT,new Integer(4) );
  fieldMap.put(CORRECT_ORDER_END_DT,new Integer(5) );
  fieldMap.put(INS_DT,new Integer(6) );
  fieldMap.put(UPD_DT,new Integer(7) );
  fieldMap.put(WRT_ID,new Integer(8) );
  fieldMap.put(DECISION_DATE,new Integer(9) );
  fieldMap.put(LIS_END_DATE,new Integer(10) );
  fieldMap.put(BEFORE_DISPO,new Integer(11) );
  fieldMap.put(OPINI_SUBMIT,new Integer(12) );
  fieldMap.put(OPINI_SUBMIT_DATE,new Integer(13) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_M_CORRECT";
     final public static String PREFIX = "sp.dao.PT_M_CORRECT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM };
     final public static String FIELD_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM,CORRECT_ORDER_CONT,CORRECT_ORDER_START_DT,CORRECT_ORDER_END_DT,INS_DT,UPD_DT,WRT_ID,DECISION_DATE,LIS_END_DATE,BEFORE_DISPO,OPINI_SUBMIT,OPINI_SUBMIT_DATE };
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

   public static String toXML(PT_M_CORRECTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CORRECT_ORDER_CONT").append("'")
            .append(" value='").append(""+ent.getCORRECT_ORDER_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CORRECT_ORDER_START_DT").append("'")
            .append(" value='").append(""+ent.getCORRECT_ORDER_START_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CORRECT_ORDER_END_DT").append("'")
            .append(" value='").append(""+ent.getCORRECT_ORDER_END_DT()).append("' />\n");
        
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
            .append(" name='").append("DECISION_DATE").append("'")
            .append(" value='").append(""+ent.getDECISION_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LIS_END_DATE").append("'")
            .append(" value='").append(""+ent.getLIS_END_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BEFORE_DISPO").append("'")
            .append(" value='").append(""+ent.getBEFORE_DISPO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPINI_SUBMIT").append("'")
            .append(" value='").append(""+ent.getOPINI_SUBMIT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPINI_SUBMIT_DATE").append("'")
            .append(" value='").append(""+ent.getOPINI_SUBMIT_DATE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
