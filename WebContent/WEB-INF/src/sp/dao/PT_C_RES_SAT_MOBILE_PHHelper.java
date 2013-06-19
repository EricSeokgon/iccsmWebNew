

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_SAT_MOBILE_PH
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               ITEM_NM:VARCHAR2(100):  
*               QTT:NUMBER(10):  
*               LINE_AOM:NUMBER(20):  
*               PDT:VARCHAR2(50):  
*               REMARK:VARCHAR2(125):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               INSTAL_DT:CHAR(18):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_C_RES_SAT_MOBILE_PHHelper{

  final static public String SEQ = "SEQ";
  final static public String ORG_NM = "ORG_NM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String ITEM_NM = "ITEM_NM";
  final static public String QTT = "QTT";
  final static public String LINE_AOM = "LINE_AOM";
  final static public String PDT = "PDT";
  final static public String REMARK = "REMARK";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String INSTAL_DT = "INSTAL_DT";
  


  public static HashMap fieldMap = new HashMap(13);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(ORG_NM,new Integer(2) );
  fieldMap.put(SIDO_CODE,new Integer(3) );
  fieldMap.put(ITEM_NM,new Integer(4) );
  fieldMap.put(QTT,new Integer(5) );
  fieldMap.put(LINE_AOM,new Integer(6) );
  fieldMap.put(PDT,new Integer(7) );
  fieldMap.put(REMARK,new Integer(8) );
  fieldMap.put(INS_DT,new Integer(9) );
  fieldMap.put(UPD_DT,new Integer(10) );
  fieldMap.put(WRT_ID,new Integer(11) );
  fieldMap.put(SIGUNGU_CODE,new Integer(12) );
  fieldMap.put(INSTAL_DT,new Integer(13) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_C_RES_SAT_MOBILE_PH";
     final public static String PREFIX = "sp.dao.PT_C_RES_SAT_MOBILE_PH";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,ORG_NM,SIDO_CODE,ITEM_NM,QTT,LINE_AOM,PDT,REMARK,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE,INSTAL_DT };
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

   public static String toXML(PT_C_RES_SAT_MOBILE_PHEntity ent){

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
            .append(" name='").append("LINE_AOM").append("'")
            .append(" value='").append(""+ent.getLINE_AOM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PDT").append("'")
            .append(" value='").append(""+ent.getPDT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REMARK").append("'")
            .append(" value='").append(""+ent.getREMARK()).append("' />\n");
        
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
            .append(" name='").append("INSTAL_DT").append("'")
            .append(" value='").append(""+ent.getINSTAL_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
