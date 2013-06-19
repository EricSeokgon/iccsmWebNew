

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_EQUIPMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(30):  
*               SIDO_CODE:VARCHAR2(5):  
*               SIGUNGU_CODE:VARCHAR2(4):  
*               CIV_RECV_NUM:VARCHAR2(100):  
*               TYPE_PROC_NO_CA:VARCHAR2(50):  
*               TYPE_PROC_NM_CA:VARCHAR2(100):  
*               FREQUENCY_SCOPE_CA:VARCHAR2(20):  
*               WIRE_TYPE_CA:VARCHAR2(100):  
*               TYPE_PROC_NO_MA:VARCHAR2(50):  
*               TYPE_PROC_NM_MA:VARCHAR2(100):  
*               FREQUENCY_SCOPE_MA:VARCHAR2(20):  
*               WIRE_TYPE_MA:VARCHAR2(100):  
*               TYPE_PROC_NO_SMA:VARCHAR2(50):  
*               TYPE_PROC_NM_SMA:VARCHAR2(100):  
*               FREQUENCY_SCOPE_SMA:VARCHAR2(20):  
*               WIRE_TYPE_SMA:VARCHAR2(100):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_UB_EQUIPMENTHelper{

  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String CIV_RECV_NUM = "CIV_RECV_NUM";
  final static public String TYPE_PROC_NO_CA = "TYPE_PROC_NO_CA";
  final static public String TYPE_PROC_NM_CA = "TYPE_PROC_NM_CA";
  final static public String FREQUENCY_SCOPE_CA = "FREQUENCY_SCOPE_CA";
  final static public String WIRE_TYPE_CA = "WIRE_TYPE_CA";
  final static public String TYPE_PROC_NO_MA = "TYPE_PROC_NO_MA";
  final static public String TYPE_PROC_NM_MA = "TYPE_PROC_NM_MA";
  final static public String FREQUENCY_SCOPE_MA = "FREQUENCY_SCOPE_MA";
  final static public String WIRE_TYPE_MA = "WIRE_TYPE_MA";
  final static public String TYPE_PROC_NO_SMA = "TYPE_PROC_NO_SMA";
  final static public String TYPE_PROC_NM_SMA = "TYPE_PROC_NM_SMA";
  final static public String FREQUENCY_SCOPE_SMA = "FREQUENCY_SCOPE_SMA";
  final static public String WIRE_TYPE_SMA = "WIRE_TYPE_SMA";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  


  public static HashMap fieldMap = new HashMap(18);
  static{
  fieldMap.put(RECV_NUM,new Integer(1) );
  fieldMap.put(SIDO_CODE,new Integer(2) );
  fieldMap.put(SIGUNGU_CODE,new Integer(3) );
  fieldMap.put(CIV_RECV_NUM,new Integer(4) );
  fieldMap.put(TYPE_PROC_NO_CA,new Integer(5) );
  fieldMap.put(TYPE_PROC_NM_CA,new Integer(6) );
  fieldMap.put(FREQUENCY_SCOPE_CA,new Integer(7) );
  fieldMap.put(WIRE_TYPE_CA,new Integer(8) );
  fieldMap.put(TYPE_PROC_NO_MA,new Integer(9) );
  fieldMap.put(TYPE_PROC_NM_MA,new Integer(10) );
  fieldMap.put(FREQUENCY_SCOPE_MA,new Integer(11) );
  fieldMap.put(WIRE_TYPE_MA,new Integer(12) );
  fieldMap.put(TYPE_PROC_NO_SMA,new Integer(13) );
  fieldMap.put(TYPE_PROC_NM_SMA,new Integer(14) );
  fieldMap.put(FREQUENCY_SCOPE_SMA,new Integer(15) );
  fieldMap.put(WIRE_TYPE_SMA,new Integer(16) );
  fieldMap.put(INS_DT,new Integer(17) );
  fieldMap.put(UPD_DT,new Integer(18) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_UB_EQUIPMENT";
     final public static String PREFIX = "sp.dao.PT_UB_EQUIPMENT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SIDO_CODE,SIGUNGU_CODE };
     final public static String FIELD_LIST[] = { 
       RECV_NUM,SIDO_CODE,SIGUNGU_CODE,CIV_RECV_NUM,TYPE_PROC_NO_CA,TYPE_PROC_NM_CA,FREQUENCY_SCOPE_CA,WIRE_TYPE_CA,TYPE_PROC_NO_MA,TYPE_PROC_NM_MA,FREQUENCY_SCOPE_MA,WIRE_TYPE_MA,TYPE_PROC_NO_SMA,TYPE_PROC_NM_SMA,FREQUENCY_SCOPE_SMA,WIRE_TYPE_SMA,INS_DT,UPD_DT };
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
	    }

         return null;
    }

   public static String toXML(PT_UB_EQUIPMENTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
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
            .append(" name='").append("CIV_RECV_NUM").append("'")
            .append(" value='").append(""+ent.getCIV_RECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TYPE_PROC_NO_CA").append("'")
            .append(" value='").append(""+ent.getTYPE_PROC_NO_CA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TYPE_PROC_NM_CA").append("'")
            .append(" value='").append(""+ent.getTYPE_PROC_NM_CA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FREQUENCY_SCOPE_CA").append("'")
            .append(" value='").append(""+ent.getFREQUENCY_SCOPE_CA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WIRE_TYPE_CA").append("'")
            .append(" value='").append(""+ent.getWIRE_TYPE_CA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TYPE_PROC_NO_MA").append("'")
            .append(" value='").append(""+ent.getTYPE_PROC_NO_MA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TYPE_PROC_NM_MA").append("'")
            .append(" value='").append(""+ent.getTYPE_PROC_NM_MA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FREQUENCY_SCOPE_MA").append("'")
            .append(" value='").append(""+ent.getFREQUENCY_SCOPE_MA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WIRE_TYPE_MA").append("'")
            .append(" value='").append(""+ent.getWIRE_TYPE_MA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TYPE_PROC_NO_SMA").append("'")
            .append(" value='").append(""+ent.getTYPE_PROC_NO_SMA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TYPE_PROC_NM_SMA").append("'")
            .append(" value='").append(""+ent.getTYPE_PROC_NM_SMA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FREQUENCY_SCOPE_SMA").append("'")
            .append(" value='").append(""+ent.getFREQUENCY_SCOPE_SMA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WIRE_TYPE_SMA").append("'")
            .append(" value='").append(""+ent.getWIRE_TYPE_SMA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
