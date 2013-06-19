

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_SUSPENSION
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               BUSISUSP_START_DT:VARCHAR2(8):  
*               BUSISUSP_END_DT:VARCHAR2(8):  
*               OPIN_COLL_DT:VARCHAR2(8):  
*               OPIN_COLL_CONT:VARCHAR2(1024):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               LIS_END_DATE:VARCHAR2(8):  
*               BEFORE_DISPO:VARCHAR2(1):  
*               OPINI_SUBMIT_DATE:VARCHAR2(8):  
*               OPINI_SUBMIT:VARCHAR2(1):  
*               DECISION_DATE:VARCHAR2(8):  
*               DISPO_PERIOD:VARCHAR2(6):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_M_SUSPENSIONHelper{

  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String BUSISUSP_START_DT = "BUSISUSP_START_DT";
  final static public String BUSISUSP_END_DT = "BUSISUSP_END_DT";
  final static public String OPIN_COLL_DT = "OPIN_COLL_DT";
  final static public String OPIN_COLL_CONT = "OPIN_COLL_CONT";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String LIS_END_DATE = "LIS_END_DATE";
  final static public String BEFORE_DISPO = "BEFORE_DISPO";
  final static public String OPINI_SUBMIT_DATE = "OPINI_SUBMIT_DATE";
  final static public String OPINI_SUBMIT = "OPINI_SUBMIT";
  final static public String DECISION_DATE = "DECISION_DATE";
  final static public String DISPO_PERIOD = "DISPO_PERIOD";
  


  public static HashMap fieldMap = new HashMap(15);
  static{
  fieldMap.put(TMP_WRT_NUM,new Integer(1) );
  fieldMap.put(WRT_NUM,new Integer(2) );
  fieldMap.put(BUSISUSP_START_DT,new Integer(3) );
  fieldMap.put(BUSISUSP_END_DT,new Integer(4) );
  fieldMap.put(OPIN_COLL_DT,new Integer(5) );
  fieldMap.put(OPIN_COLL_CONT,new Integer(6) );
  fieldMap.put(INS_DT,new Integer(7) );
  fieldMap.put(UPD_DT,new Integer(8) );
  fieldMap.put(WRT_ID,new Integer(9) );
  fieldMap.put(LIS_END_DATE,new Integer(10) );
  fieldMap.put(BEFORE_DISPO,new Integer(11) );
  fieldMap.put(OPINI_SUBMIT_DATE,new Integer(12) );
  fieldMap.put(OPINI_SUBMIT,new Integer(13) );
  fieldMap.put(DECISION_DATE,new Integer(14) );
  fieldMap.put(DISPO_PERIOD,new Integer(15) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_M_SUSPENSION";
     final public static String PREFIX = "sp.dao.PT_M_SUSPENSION";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM };
     final public static String FIELD_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM,BUSISUSP_START_DT,BUSISUSP_END_DT,OPIN_COLL_DT,OPIN_COLL_CONT,INS_DT,UPD_DT,WRT_ID,LIS_END_DATE,BEFORE_DISPO,OPINI_SUBMIT_DATE,OPINI_SUBMIT,DECISION_DATE,DISPO_PERIOD };
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
             case 14 : 
	                  return  "";
             case 15 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_M_SUSPENSIONEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BUSISUSP_START_DT").append("'")
            .append(" value='").append(""+ent.getBUSISUSP_START_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BUSISUSP_END_DT").append("'")
            .append(" value='").append(""+ent.getBUSISUSP_END_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPIN_COLL_DT").append("'")
            .append(" value='").append(""+ent.getOPIN_COLL_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPIN_COLL_CONT").append("'")
            .append(" value='").append(""+ent.getOPIN_COLL_CONT()).append("' />\n");
        
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
            .append(" name='").append("LIS_END_DATE").append("'")
            .append(" value='").append(""+ent.getLIS_END_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BEFORE_DISPO").append("'")
            .append(" value='").append(""+ent.getBEFORE_DISPO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPINI_SUBMIT_DATE").append("'")
            .append(" value='").append(""+ent.getOPINI_SUBMIT_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPINI_SUBMIT").append("'")
            .append(" value='").append(""+ent.getOPINI_SUBMIT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DECISION_DATE").append("'")
            .append(" value='").append(""+ent.getDECISION_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DISPO_PERIOD").append("'")
            .append(" value='").append(""+ent.getDISPO_PERIOD()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
