

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_M_PRIZE
*  테이블 설명 :
*  테이블 PK   :  
*               CARE_BOOK_ISSUE_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(20):  
*               YMD:VARCHAR2(20):  
*               ITEM:VARCHAR2(30):  
*               PAD_REST_TERM:VARCHAR2(30):  
*               BAS:VARCHAR2(30):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(30):  
*               ETC2:VARCHAR2(50):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_ENGINEER_M_PRIZEHelper{

  final static public String SEQ = "SEQ";
  final static public String CARE_BOOK_ISSUE_NUM = "CARE_BOOK_ISSUE_NUM";
  final static public String YMD = "YMD";
  final static public String ITEM = "ITEM";
  final static public String PAD_REST_TERM = "PAD_REST_TERM";
  final static public String BAS = "BAS";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_DT = "WRT_DT";
  final static public String ETC1 = "ETC1";
  final static public String ETC2 = "ETC2";
  


  public static HashMap fieldMap = new HashMap(11);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(CARE_BOOK_ISSUE_NUM,new Integer(2) );
  fieldMap.put(YMD,new Integer(3) );
  fieldMap.put(ITEM,new Integer(4) );
  fieldMap.put(PAD_REST_TERM,new Integer(5) );
  fieldMap.put(BAS,new Integer(6) );
  fieldMap.put(WRT_ID,new Integer(7) );
  fieldMap.put(UPD_DT,new Integer(8) );
  fieldMap.put(WRT_DT,new Integer(9) );
  fieldMap.put(ETC1,new Integer(10) );
  fieldMap.put(ETC2,new Integer(11) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_ENGINEER_M_PRIZE";
     final public static String PREFIX = "sp.dao.PT_R_ENGINEER_M_PRIZE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CARE_BOOK_ISSUE_NUM,SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,CARE_BOOK_ISSUE_NUM,YMD,ITEM,PAD_REST_TERM,BAS,WRT_ID,UPD_DT,WRT_DT,ETC1,ETC2 };
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

   public static String toXML(PT_R_ENGINEER_M_PRIZEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARE_BOOK_ISSUE_NUM").append("'")
            .append(" value='").append(""+ent.getCARE_BOOK_ISSUE_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("YMD").append("'")
            .append(" value='").append(""+ent.getYMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ITEM").append("'")
            .append(" value='").append(""+ent.getITEM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PAD_REST_TERM").append("'")
            .append(" value='").append(""+ent.getPAD_REST_TERM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BAS").append("'")
            .append(" value='").append(""+ent.getBAS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_DT").append("'")
            .append(" value='").append(""+ent.getWRT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC1").append("'")
            .append(" value='").append(""+ent.getETC1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC2").append("'")
            .append(" value='").append(""+ent.getETC2()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
