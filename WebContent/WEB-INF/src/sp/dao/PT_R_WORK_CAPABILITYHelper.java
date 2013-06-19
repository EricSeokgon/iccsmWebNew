

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_WORK_CAPABILITY
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               COI_WRT_NUM:VARCHAR2(12):  
*               ASSE_DT:VARCHAR2(8):  
*               ASSE_AOM:VARCHAR2(15):  
*               APPL_TERM_START_DT:VARCHAR2(8):  
*               CONFIRM:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               APPL_TERM_END_DT:VARCHAR2(8):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_WORK_CAPABILITYHelper{

  final static public String SEQ = "SEQ";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String COI_WRT_NUM = "COI_WRT_NUM";
  final static public String ASSE_DT = "ASSE_DT";
  final static public String ASSE_AOM = "ASSE_AOM";
  final static public String APPL_TERM_START_DT = "APPL_TERM_START_DT";
  final static public String CONFIRM = "CONFIRM";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String APPL_TERM_END_DT = "APPL_TERM_END_DT";
  


  public static HashMap fieldMap = new HashMap(11);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(TMP_WRT_NUM,new Integer(2) );
  fieldMap.put(COI_WRT_NUM,new Integer(3) );
  fieldMap.put(ASSE_DT,new Integer(4) );
  fieldMap.put(ASSE_AOM,new Integer(5) );
  fieldMap.put(APPL_TERM_START_DT,new Integer(6) );
  fieldMap.put(CONFIRM,new Integer(7) );
  fieldMap.put(WRT_ID,new Integer(8) );
  fieldMap.put(UPD_DT,new Integer(9) );
  fieldMap.put(INS_DT,new Integer(10) );
  fieldMap.put(APPL_TERM_END_DT,new Integer(11) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_WORK_CAPABILITY";
     final public static String PREFIX = "sp.dao.PT_R_WORK_CAPABILITY";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       SEQ,TMP_WRT_NUM,COI_WRT_NUM,ASSE_DT,ASSE_AOM,APPL_TERM_START_DT,CONFIRM,WRT_ID,UPD_DT,INS_DT,APPL_TERM_END_DT };
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

   public static String toXML(PT_R_WORK_CAPABILITYEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COI_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getCOI_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSE_DT").append("'")
            .append(" value='").append(""+ent.getASSE_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSE_AOM").append("'")
            .append(" value='").append(""+ent.getASSE_AOM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("APPL_TERM_START_DT").append("'")
            .append(" value='").append(""+ent.getAPPL_TERM_START_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONFIRM").append("'")
            .append(" value='").append(""+ent.getCONFIRM()).append("' />\n");
        
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
            .append(" name='").append("APPL_TERM_END_DT").append("'")
            .append(" value='").append(""+ent.getAPPL_TERM_END_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
