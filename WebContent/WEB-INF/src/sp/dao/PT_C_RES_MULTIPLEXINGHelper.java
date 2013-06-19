

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_MULTIPLEXING
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               ITEM_NM:VARCHAR2(100):  
*               QTT:NUMBER(10):  
*               INSTAL_DT:VARCHAR2(24):  
*               PDT:VARCHAR2(100):  
*               USE:VARCHAR2(12):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               ESTAB_AOM:VARCHAR2(12):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_C_RES_MULTIPLEXINGHelper{

  final static public String SEQ = "SEQ";
  final static public String ORG_NM = "ORG_NM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String ITEM_NM = "ITEM_NM";
  final static public String QTT = "QTT";
  final static public String INSTAL_DT = "INSTAL_DT";
  final static public String PDT = "PDT";
  final static public String USE = "USE";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String ESTAB_AOM = "ESTAB_AOM";
  


  public static HashMap fieldMap = new HashMap(13);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(ORG_NM,new Integer(2) );
  fieldMap.put(SIDO_CODE,new Integer(3) );
  fieldMap.put(ITEM_NM,new Integer(4) );
  fieldMap.put(QTT,new Integer(5) );
  fieldMap.put(INSTAL_DT,new Integer(6) );
  fieldMap.put(PDT,new Integer(7) );
  fieldMap.put(USE,new Integer(8) );
  fieldMap.put(INS_DT,new Integer(9) );
  fieldMap.put(UPD_DT,new Integer(10) );
  fieldMap.put(WRT_ID,new Integer(11) );
  fieldMap.put(SIGUNGU_CODE,new Integer(12) );
  fieldMap.put(ESTAB_AOM,new Integer(13) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_C_RES_MULTIPLEXING";
     final public static String PREFIX = "sp.dao.PT_C_RES_MULTIPLEXING";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,ORG_NM,SIDO_CODE,ITEM_NM,QTT,INSTAL_DT,PDT,USE,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE,ESTAB_AOM };
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
	    }

         return null;
    }

   public static String toXML(PT_C_RES_MULTIPLEXINGEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORG_NM").append("'")
            .append(" value='").append(""+ent.getORG_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ITEM_NM").append("'")
            .append(" value='").append(""+ent.getITEM_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("QTT").append("'")
            .append(" value='").append(""+ent.getQTT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSTAL_DT").append("'")
            .append(" value='").append(""+ent.getINSTAL_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PDT").append("'")
            .append(" value='").append(""+ent.getPDT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE").append("'")
            .append(" value='").append(""+ent.getUSE()).append("' />\n");
        
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
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTAB_AOM").append("'")
            .append(" value='").append(""+ent.getESTAB_AOM()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
