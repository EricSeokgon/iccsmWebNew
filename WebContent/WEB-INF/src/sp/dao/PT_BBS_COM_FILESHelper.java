

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_COM_FILES
*  테이블 설명 :
*  테이블 PK   :  
*               SYS_FILE_NAME
*  테이블 컬럼 :  
*               CT_ID:VARCHAR2(30):  
*               BOARD_SEQ:VARCHAR2(10):  
*               FILE_REAL_NAME:VARCHAR2(250):  
*               SYS_FILE_NAME:VARCHAR2(281):  
*               FILE_SIZE:VARCHAR2(20):  
*               UPD_DT:VARCHAR2(20):  
*               DOWN_HIT:NUMBER(22):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_BBS_COM_FILESHelper{

  final static public String CT_ID = "CT_ID";
  final static public String BOARD_SEQ = "BOARD_SEQ";
  final static public String FILE_REAL_NAME = "FILE_REAL_NAME";
  final static public String SYS_FILE_NAME = "SYS_FILE_NAME";
  final static public String FILE_SIZE = "FILE_SIZE";
  final static public String UPD_DT = "UPD_DT";
  final static public String DOWN_HIT = "DOWN_HIT";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(CT_ID,new Integer(1) );
  fieldMap.put(BOARD_SEQ,new Integer(2) );
  fieldMap.put(FILE_REAL_NAME,new Integer(3) );
  fieldMap.put(SYS_FILE_NAME,new Integer(4) );
  fieldMap.put(FILE_SIZE,new Integer(5) );
  fieldMap.put(UPD_DT,new Integer(6) );
  fieldMap.put(DOWN_HIT,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_BBS_COM_FILES";
     final public static String PREFIX = "sp.dao.PT_BBS_COM_FILES";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SYS_FILE_NAME };
     final public static String FIELD_LIST[] = { 
       CT_ID,BOARD_SEQ,FILE_REAL_NAME,SYS_FILE_NAME,FILE_SIZE,UPD_DT,DOWN_HIT };
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

   public static String toXML(PT_BBS_COM_FILESEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CT_ID").append("'")
            .append(" value='").append(""+ent.getCT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BOARD_SEQ").append("'")
            .append(" value='").append(""+ent.getBOARD_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FILE_REAL_NAME").append("'")
            .append(" value='").append(""+ent.getFILE_REAL_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SYS_FILE_NAME").append("'")
            .append(" value='").append(""+ent.getSYS_FILE_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FILE_SIZE").append("'")
            .append(" value='").append(""+ent.getFILE_SIZE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOWN_HIT").append("'")
            .append(" value='").append(""+ent.getDOWN_HIT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
