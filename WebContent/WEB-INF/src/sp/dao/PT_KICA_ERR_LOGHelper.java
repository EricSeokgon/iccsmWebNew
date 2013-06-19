

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_KICA_ERR_LOG
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(11):  
*               U_D_FLAG:CHAR(1):  
*               YYYYMMDD:VARCHAR2(8):  
*               TRANSHOUR:VARCHAR2(2):  
*               FILENAME:VARCHAR2(60):  
*               ERRLOG:VARCHAR2(1000):  
*               RESULT_FLAG:CHAR(1):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_KICA_ERR_LOGHelper{

  final static public String SEQ = "SEQ";
  final static public String U_D_FLAG = "U_D_FLAG";
  final static public String YYYYMMDD = "YYYYMMDD";
  final static public String TRANSHOUR = "TRANSHOUR";
  final static public String FILENAME = "FILENAME";
  final static public String ERRLOG = "ERRLOG";
  final static public String RESULT_FLAG = "RESULT_FLAG";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(U_D_FLAG,new Integer(2) );
  fieldMap.put(YYYYMMDD,new Integer(3) );
  fieldMap.put(TRANSHOUR,new Integer(4) );
  fieldMap.put(FILENAME,new Integer(5) );
  fieldMap.put(ERRLOG,new Integer(6) );
  fieldMap.put(RESULT_FLAG,new Integer(7) );
  fieldMap.put(UPD_DT,new Integer(8) );
  fieldMap.put(INS_DT,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_KICA_ERR_LOG";
     final public static String PREFIX = "sp.dao.PT_KICA_ERR_LOG";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,U_D_FLAG,YYYYMMDD,TRANSHOUR,FILENAME,ERRLOG,RESULT_FLAG,UPD_DT,INS_DT };
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

   public static String toXML(PT_KICA_ERR_LOGEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("U_D_FLAG").append("'")
            .append(" value='").append(""+ent.getU_D_FLAG()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("YYYYMMDD").append("'")
            .append(" value='").append(""+ent.getYYYYMMDD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRANSHOUR").append("'")
            .append(" value='").append(""+ent.getTRANSHOUR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FILENAME").append("'")
            .append(" value='").append(""+ent.getFILENAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ERRLOG").append("'")
            .append(" value='").append(""+ent.getERRLOG()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RESULT_FLAG").append("'")
            .append(" value='").append(""+ent.getRESULT_FLAG()).append("' />\n");
        
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
