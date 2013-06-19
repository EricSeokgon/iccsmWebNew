

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REGMGR_ENG_DEFICIT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_REG_NUM
*  테이블 컬럼 :  
*               TMP_REG_NUM:CHAR(18):  
*               SEQ:NUMBER(11):  
*               DEFICIT_CODE:VARCHAR2(6):  
*               DEFICIT_RESULT:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_REGMGR_ENG_DEFICITHelper{

  final static public String TMP_REG_NUM = "TMP_REG_NUM";
  final static public String SEQ = "SEQ";
  final static public String DEFICIT_CODE = "DEFICIT_CODE";
  final static public String DEFICIT_RESULT = "DEFICIT_RESULT";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(TMP_REG_NUM,new Integer(1) );
  fieldMap.put(SEQ,new Integer(2) );
  fieldMap.put(DEFICIT_CODE,new Integer(3) );
  fieldMap.put(DEFICIT_RESULT,new Integer(4) );
  fieldMap.put(WRT_ID,new Integer(5) );
  fieldMap.put(UPD_DT,new Integer(6) );
  fieldMap.put(INS_DT,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_REGMGR_ENG_DEFICIT";
     final public static String PREFIX = "sp.dao.PT_R_REGMGR_ENG_DEFICIT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,TMP_REG_NUM };
     final public static String FIELD_LIST[] = { 
       TMP_REG_NUM,SEQ,DEFICIT_CODE,DEFICIT_RESULT,WRT_ID,UPD_DT,INS_DT };
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

   public static String toXML(PT_R_REGMGR_ENG_DEFICITEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_REG_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_REG_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFICIT_CODE").append("'")
            .append(" value='").append(""+ent.getDEFICIT_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFICIT_RESULT").append("'")
            .append(" value='").append(""+ent.getDEFICIT_RESULT()).append("' />\n");
        
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
