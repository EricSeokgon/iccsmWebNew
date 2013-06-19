

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_TRAFFIC_OUT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               LINE_QTT:NUMBER(10):  
*               REMARK:VARCHAR2(125):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               SIDO:NUMBER(10):  
*               POS:NUMBER(10):  
*               FINISH:NUMBER(10):  
*               TIME:NUMBER(10):  
*               TRAFFIC_ERL:NUMBER(10):  
*               TRAFFIC_LINE:NUMBER(10):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_C_RES_TRAFFIC_OUTHelper{

  final static public String SEQ = "SEQ";
  final static public String ORG_NM = "ORG_NM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String LINE_QTT = "LINE_QTT";
  final static public String REMARK = "REMARK";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String SIDO = "SIDO";
  final static public String POS = "POS";
  final static public String FINISH = "FINISH";
  final static public String TIME = "TIME";
  final static public String TRAFFIC_ERL = "TRAFFIC_ERL";
  final static public String TRAFFIC_LINE = "TRAFFIC_LINE";
  


  public static HashMap fieldMap = new HashMap(15);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(ORG_NM,new Integer(2) );
  fieldMap.put(SIDO_CODE,new Integer(3) );
  fieldMap.put(LINE_QTT,new Integer(4) );
  fieldMap.put(REMARK,new Integer(5) );
  fieldMap.put(INS_DT,new Integer(6) );
  fieldMap.put(UPD_DT,new Integer(7) );
  fieldMap.put(WRT_ID,new Integer(8) );
  fieldMap.put(SIGUNGU_CODE,new Integer(9) );
  fieldMap.put(SIDO,new Integer(10) );
  fieldMap.put(POS,new Integer(11) );
  fieldMap.put(FINISH,new Integer(12) );
  fieldMap.put(TIME,new Integer(13) );
  fieldMap.put(TRAFFIC_ERL,new Integer(14) );
  fieldMap.put(TRAFFIC_LINE,new Integer(15) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_C_RES_TRAFFIC_OUT";
     final public static String PREFIX = "sp.dao.PT_C_RES_TRAFFIC_OUT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,ORG_NM,SIDO_CODE,LINE_QTT,REMARK,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE,SIDO,POS,FINISH,TIME,TRAFFIC_ERL,TRAFFIC_LINE };
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
             case 14 : 
	                  return  "";
             case 15 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_C_RES_TRAFFIC_OUTEntity ent){

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
            .append(" name='").append("LINE_QTT").append("'")
            .append(" value='").append(""+ent.getLINE_QTT()).append("' />\n");
        
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
            .append(" name='").append("SIDO").append("'")
            .append(" value='").append(""+ent.getSIDO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("POS").append("'")
            .append(" value='").append(""+ent.getPOS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FINISH").append("'")
            .append(" value='").append(""+ent.getFINISH()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TIME").append("'")
            .append(" value='").append(""+ent.getTIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAFFIC_ERL").append("'")
            .append(" value='").append(""+ent.getTRAFFIC_ERL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TRAFFIC_LINE").append("'")
            .append(" value='").append(""+ent.getTRAFFIC_LINE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
