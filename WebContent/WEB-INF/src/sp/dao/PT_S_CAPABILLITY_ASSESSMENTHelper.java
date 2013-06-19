

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_CAPABILLITY_ASSESSMENT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):  
*               ADDR:VARCHAR2(200):  
*               QUAL_NUM:VARCHAR2(12):  
*               PAY:VARCHAR2(10):  
*               ARR_SPOT:VARCHAR2(200):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               SEQ:NUMBER(4):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_S_CAPABILLITY_ASSESSMENTHelper{

  final static public String WRT_NUM = "WRT_NUM";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String CARE_BOOK_ISSUE_NUM = "CARE_BOOK_ISSUE_NUM";
  final static public String ADDR = "ADDR";
  final static public String QUAL_NUM = "QUAL_NUM";
  final static public String PAY = "PAY";
  final static public String ARR_SPOT = "ARR_SPOT";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String SEQ = "SEQ";
  


  public static HashMap fieldMap = new HashMap(11);
  static{
  fieldMap.put(WRT_NUM,new Integer(1) );
  fieldMap.put(TMP_WRT_NUM,new Integer(2) );
  fieldMap.put(CARE_BOOK_ISSUE_NUM,new Integer(3) );
  fieldMap.put(ADDR,new Integer(4) );
  fieldMap.put(QUAL_NUM,new Integer(5) );
  fieldMap.put(PAY,new Integer(6) );
  fieldMap.put(ARR_SPOT,new Integer(7) );
  fieldMap.put(INS_DT,new Integer(8) );
  fieldMap.put(UPD_DT,new Integer(9) );
  fieldMap.put(WRT_ID,new Integer(10) );
  fieldMap.put(SEQ,new Integer(11) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_S_CAPABILLITY_ASSESSMENT";
     final public static String PREFIX = "sp.dao.PT_S_CAPABILLITY_ASSESSMENT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,TMP_WRT_NUM,WRT_NUM };
     final public static String FIELD_LIST[] = { 
       WRT_NUM,TMP_WRT_NUM,CARE_BOOK_ISSUE_NUM,ADDR,QUAL_NUM,PAY,ARR_SPOT,INS_DT,UPD_DT,WRT_ID,SEQ };
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

   public static String toXML(PT_S_CAPABILLITY_ASSESSMENTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARE_BOOK_ISSUE_NUM").append("'")
            .append(" value='").append(""+ent.getCARE_BOOK_ISSUE_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR").append("'")
            .append(" value='").append(""+ent.getADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("QUAL_NUM").append("'")
            .append(" value='").append(""+ent.getQUAL_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PAY").append("'")
            .append(" value='").append(""+ent.getPAY()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ARR_SPOT").append("'")
            .append(" value='").append(""+ent.getARR_SPOT()).append("' />\n");
        
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
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
