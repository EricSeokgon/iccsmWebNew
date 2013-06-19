

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_WORK_RESULTS
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(4):  
*               YEAR:VARCHAR2(4):  
*               WORK_ROM:VARCHAR2(15):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               TMP_WRT_NUM:VARCHAR2(12):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_WORK_RESULTSHelper{

  final static public String SEQ = "SEQ";
  final static public String YEAR = "YEAR";
  final static public String WORK_ROM = "WORK_ROM";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(YEAR,new Integer(2) );
  fieldMap.put(WORK_ROM,new Integer(3) );
  fieldMap.put(WRT_ID,new Integer(4) );
  fieldMap.put(UPD_DT,new Integer(5) );
  fieldMap.put(INS_DT,new Integer(6) );
  fieldMap.put(TMP_WRT_NUM,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_WORK_RESULTS";
     final public static String PREFIX = "sp.dao.PT_R_WORK_RESULTS";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       SEQ,YEAR,WORK_ROM,WRT_ID,UPD_DT,INS_DT,TMP_WRT_NUM };
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

   public static String toXML(PT_R_WORK_RESULTSEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
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
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
