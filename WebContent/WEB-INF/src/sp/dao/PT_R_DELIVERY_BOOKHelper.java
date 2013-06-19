

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_DELIVERY_BOOK
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DELI_CAUSE:VARCHAR2(256):  
*               DELI_YMD:VARCHAR2(8):  
*               REMARK:VARCHAR2(256):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               DELI_CLASS:VARCHAR2(6):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_DELIVERY_BOOKHelper{

  final static public String SEQ = "SEQ";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String DELI_CAUSE = "DELI_CAUSE";
  final static public String DELI_YMD = "DELI_YMD";
  final static public String REMARK = "REMARK";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String DELI_CLASS = "DELI_CLASS";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(TMP_WRT_NUM,new Integer(2) );
  fieldMap.put(DELI_CAUSE,new Integer(3) );
  fieldMap.put(DELI_YMD,new Integer(4) );
  fieldMap.put(REMARK,new Integer(5) );
  fieldMap.put(WRT_ID,new Integer(6) );
  fieldMap.put(UPD_DT,new Integer(7) );
  fieldMap.put(INS_DT,new Integer(8) );
  fieldMap.put(DELI_CLASS,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_DELIVERY_BOOK";
     final public static String PREFIX = "sp.dao.PT_R_DELIVERY_BOOK";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       SEQ,TMP_WRT_NUM,DELI_CAUSE,DELI_YMD,REMARK,WRT_ID,UPD_DT,INS_DT,DELI_CLASS };
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

   public static String toXML(PT_R_DELIVERY_BOOKEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DELI_CAUSE").append("'")
            .append(" value='").append(""+ent.getDELI_CAUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DELI_YMD").append("'")
            .append(" value='").append(""+ent.getDELI_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REMARK").append("'")
            .append(" value='").append(""+ent.getREMARK()).append("' />\n");
        
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
            .append(" name='").append("DELI_CLASS").append("'")
            .append(" value='").append(""+ent.getDELI_CLASS()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
