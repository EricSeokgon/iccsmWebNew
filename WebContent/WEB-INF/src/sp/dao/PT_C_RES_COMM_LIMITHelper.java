

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_COMM_LIMIT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               PGP_CAF:NUMBER(10):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               PGP_PMS:NUMBER(10):  
*               NBS_4_CAF:NUMBER(10):  
*               NBS_4_PMS:NUMBER(10):  
*               NBS_6_CAF:NUMBER(10):  
*               NBS_6_PMS:NUMBER(10):  
*               NBS_7_CAF:NUMBER(10):  
*               NBS_7_PMS:NUMBER(10):  
*               NBS_8_CAF:NUMBER(10):  
*               NBS_9_PMS:NUMBER(10):  
*               NBS_9_CAF:NUMBER(10):  
*               NBS_8_PMS:NUMBER(10):  
*               TBS_TECOM_CAF:NUMBER(10):  
*               TBS_TECOM_PMS:NUMBER(10):  
*               TBS_EXCH_CAF:NUMBER(10):  
*               TBS_EXCH_PMS:NUMBER(10):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_C_RES_COMM_LIMITHelper{

  final static public String SEQ = "SEQ";
  final static public String ORG_NM = "ORG_NM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String PGP_CAF = "PGP_CAF";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String PGP_PMS = "PGP_PMS";
  final static public String NBS_4_CAF = "NBS_4_CAF";
  final static public String NBS_4_PMS = "NBS_4_PMS";
  final static public String NBS_6_CAF = "NBS_6_CAF";
  final static public String NBS_6_PMS = "NBS_6_PMS";
  final static public String NBS_7_CAF = "NBS_7_CAF";
  final static public String NBS_7_PMS = "NBS_7_PMS";
  final static public String NBS_8_CAF = "NBS_8_CAF";
  final static public String NBS_9_PMS = "NBS_9_PMS";
  final static public String NBS_9_CAF = "NBS_9_CAF";
  final static public String NBS_8_PMS = "NBS_8_PMS";
  final static public String TBS_TECOM_CAF = "TBS_TECOM_CAF";
  final static public String TBS_TECOM_PMS = "TBS_TECOM_PMS";
  final static public String TBS_EXCH_CAF = "TBS_EXCH_CAF";
  final static public String TBS_EXCH_PMS = "TBS_EXCH_PMS";
  


  public static HashMap fieldMap = new HashMap(23);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(ORG_NM,new Integer(2) );
  fieldMap.put(SIDO_CODE,new Integer(3) );
  fieldMap.put(PGP_CAF,new Integer(4) );
  fieldMap.put(INS_DT,new Integer(5) );
  fieldMap.put(UPD_DT,new Integer(6) );
  fieldMap.put(WRT_ID,new Integer(7) );
  fieldMap.put(SIGUNGU_CODE,new Integer(8) );
  fieldMap.put(PGP_PMS,new Integer(9) );
  fieldMap.put(NBS_4_CAF,new Integer(10) );
  fieldMap.put(NBS_4_PMS,new Integer(11) );
  fieldMap.put(NBS_6_CAF,new Integer(12) );
  fieldMap.put(NBS_6_PMS,new Integer(13) );
  fieldMap.put(NBS_7_CAF,new Integer(14) );
  fieldMap.put(NBS_7_PMS,new Integer(15) );
  fieldMap.put(NBS_8_CAF,new Integer(16) );
  fieldMap.put(NBS_9_PMS,new Integer(17) );
  fieldMap.put(NBS_9_CAF,new Integer(18) );
  fieldMap.put(NBS_8_PMS,new Integer(19) );
  fieldMap.put(TBS_TECOM_CAF,new Integer(20) );
  fieldMap.put(TBS_TECOM_PMS,new Integer(21) );
  fieldMap.put(TBS_EXCH_CAF,new Integer(22) );
  fieldMap.put(TBS_EXCH_PMS,new Integer(23) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_C_RES_COMM_LIMIT";
     final public static String PREFIX = "sp.dao.PT_C_RES_COMM_LIMIT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,ORG_NM,SIDO_CODE,PGP_CAF,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE,PGP_PMS,NBS_4_CAF,NBS_4_PMS,NBS_6_CAF,NBS_6_PMS,NBS_7_CAF,NBS_7_PMS,NBS_8_CAF,NBS_9_PMS,NBS_9_CAF,NBS_8_PMS,TBS_TECOM_CAF,TBS_TECOM_PMS,TBS_EXCH_CAF,TBS_EXCH_PMS };
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
             case 16 : 
	                  return  "";
             case 17 : 
	                  return  "";
             case 18 : 
	                  return  "";
             case 19 : 
	                  return  "";
             case 20 : 
	                  return  "";
             case 21 : 
	                  return  "";
             case 22 : 
	                  return  "";
             case 23 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_C_RES_COMM_LIMITEntity ent){

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
            .append(" name='").append("PGP_CAF").append("'")
            .append(" value='").append(""+ent.getPGP_CAF()).append("' />\n");
        
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
            .append(" name='").append("PGP_PMS").append("'")
            .append(" value='").append(""+ent.getPGP_PMS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_4_CAF").append("'")
            .append(" value='").append(""+ent.getNBS_4_CAF()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_4_PMS").append("'")
            .append(" value='").append(""+ent.getNBS_4_PMS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_6_CAF").append("'")
            .append(" value='").append(""+ent.getNBS_6_CAF()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_6_PMS").append("'")
            .append(" value='").append(""+ent.getNBS_6_PMS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_7_CAF").append("'")
            .append(" value='").append(""+ent.getNBS_7_CAF()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_7_PMS").append("'")
            .append(" value='").append(""+ent.getNBS_7_PMS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_8_CAF").append("'")
            .append(" value='").append(""+ent.getNBS_8_CAF()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_9_PMS").append("'")
            .append(" value='").append(""+ent.getNBS_9_PMS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_9_CAF").append("'")
            .append(" value='").append(""+ent.getNBS_9_CAF()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NBS_8_PMS").append("'")
            .append(" value='").append(""+ent.getNBS_8_PMS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TBS_TECOM_CAF").append("'")
            .append(" value='").append(""+ent.getTBS_TECOM_CAF()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TBS_TECOM_PMS").append("'")
            .append(" value='").append(""+ent.getTBS_TECOM_PMS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TBS_EXCH_CAF").append("'")
            .append(" value='").append(""+ent.getTBS_EXCH_CAF()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TBS_EXCH_PMS").append("'")
            .append(" value='").append(""+ent.getTBS_EXCH_PMS()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
