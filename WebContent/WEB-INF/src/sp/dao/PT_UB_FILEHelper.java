

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_FILE
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               FILE_NM:VARCHAR2(100):  
*               FILE_SIZE:VARCHAR2(10):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SEQ:NUMBER(22):  
*               RECV_NUM:VARCHAR2(30):  
*               SIDO_CODE:VARCHAR2(5):  
*               SIGUNGU_CODE:VARCHAR2(4):  
*               UPD_DT_OLD:VARCHAR2(24):  
*               BACKUP_TRANS_DT:VARCHAR2(24):  
*               SYS_FILE_NAME:VARCHAR2(281):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_UB_FILEHelper{

  final static public String FILE_NM = "FILE_NM";
  final static public String FILE_SIZE = "FILE_SIZE";
  final static public String WRT_ID = "WRT_ID";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String SEQ = "SEQ";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String UPD_DT_OLD = "UPD_DT_OLD";
  final static public String BACKUP_TRANS_DT = "BACKUP_TRANS_DT";
  final static public String SYS_FILE_NAME = "SYS_FILE_NAME";
  


  public static HashMap fieldMap = new HashMap(12);
  static{
  fieldMap.put(FILE_NM,new Integer(1) );
  fieldMap.put(FILE_SIZE,new Integer(2) );
  fieldMap.put(WRT_ID,new Integer(3) );
  fieldMap.put(INS_DT,new Integer(4) );
  fieldMap.put(UPD_DT,new Integer(5) );
  fieldMap.put(SEQ,new Integer(6) );
  fieldMap.put(RECV_NUM,new Integer(7) );
  fieldMap.put(SIDO_CODE,new Integer(8) );
  fieldMap.put(SIGUNGU_CODE,new Integer(9) );
  fieldMap.put(UPD_DT_OLD,new Integer(10) );
  fieldMap.put(BACKUP_TRANS_DT,new Integer(11) );
  fieldMap.put(SYS_FILE_NAME,new Integer(12) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_UB_FILE";
     final public static String PREFIX = "sp.dao.PT_UB_FILE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SEQ,SIDO_CODE,SIGUNGU_CODE };
     final public static String FIELD_LIST[] = { 
       FILE_NM,FILE_SIZE,WRT_ID,INS_DT,UPD_DT,SEQ,RECV_NUM,SIDO_CODE,SIGUNGU_CODE,UPD_DT_OLD,BACKUP_TRANS_DT,SYS_FILE_NAME };
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
	    }

         return null;
    }

   public static String toXML(PT_UB_FILEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FILE_NM").append("'")
            .append(" value='").append(""+ent.getFILE_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FILE_SIZE").append("'")
            .append(" value='").append(""+ent.getFILE_SIZE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
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
            .append(" name='").append("UPD_DT_OLD").append("'")
            .append(" value='").append(""+ent.getUPD_DT_OLD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BACKUP_TRANS_DT").append("'")
            .append(" value='").append(""+ent.getBACKUP_TRANS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SYS_FILE_NAME").append("'")
            .append(" value='").append(""+ent.getSYS_FILE_NAME()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
