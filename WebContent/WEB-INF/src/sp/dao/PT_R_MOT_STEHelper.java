

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_MOT_STE
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               CHGBRE_SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DETAILWORK1:VARCHAR2(1):  
*               DETAILWORK2:VARCHAR2(1):  
*               DETAILWORK3:VARCHAR2(1):  
*               DETAILWORK4:VARCHAR2(1):  
*               DETAILWORK5:VARCHAR2(1):  
*               DETAILWORK6:VARCHAR2(1):  
*               DETAILWORK7:VARCHAR2(1):  
*               DETAILWORK8:VARCHAR2(1):  
*               DETAILWORK9:VARCHAR2(1):  
*               DETAILWORK10:VARCHAR2(1):  
*               DETAILWORK11:VARCHAR2(1):  
*               DETAILWORK12:VARCHAR2(1):  
*               DETAILWORK13:VARCHAR2(1):  
*               DETAILWORK14:VARCHAR2(1):  
*               DETAILWORK15:VARCHAR2(1):  
*               DETAILWORK16:VARCHAR2(1):  
*               RECV_NUM:VARCHAR2(20):  
*               MOT_PROC:VARCHAR2(2):  
*               SIDO_CODE:VARCHAR2(4):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_MOT_STEHelper{

  final static public String CHGBRE_SEQ = "CHGBRE_SEQ";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String DETAILWORK1 = "DETAILWORK1";
  final static public String DETAILWORK2 = "DETAILWORK2";
  final static public String DETAILWORK3 = "DETAILWORK3";
  final static public String DETAILWORK4 = "DETAILWORK4";
  final static public String DETAILWORK5 = "DETAILWORK5";
  final static public String DETAILWORK6 = "DETAILWORK6";
  final static public String DETAILWORK7 = "DETAILWORK7";
  final static public String DETAILWORK8 = "DETAILWORK8";
  final static public String DETAILWORK9 = "DETAILWORK9";
  final static public String DETAILWORK10 = "DETAILWORK10";
  final static public String DETAILWORK11 = "DETAILWORK11";
  final static public String DETAILWORK12 = "DETAILWORK12";
  final static public String DETAILWORK13 = "DETAILWORK13";
  final static public String DETAILWORK14 = "DETAILWORK14";
  final static public String DETAILWORK15 = "DETAILWORK15";
  final static public String DETAILWORK16 = "DETAILWORK16";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String MOT_PROC = "MOT_PROC";
  final static public String SIDO_CODE = "SIDO_CODE";
  


  public static HashMap fieldMap = new HashMap(21);
  static{
  fieldMap.put(CHGBRE_SEQ,new Integer(1) );
  fieldMap.put(TMP_WRT_NUM,new Integer(2) );
  fieldMap.put(DETAILWORK1,new Integer(3) );
  fieldMap.put(DETAILWORK2,new Integer(4) );
  fieldMap.put(DETAILWORK3,new Integer(5) );
  fieldMap.put(DETAILWORK4,new Integer(6) );
  fieldMap.put(DETAILWORK5,new Integer(7) );
  fieldMap.put(DETAILWORK6,new Integer(8) );
  fieldMap.put(DETAILWORK7,new Integer(9) );
  fieldMap.put(DETAILWORK8,new Integer(10) );
  fieldMap.put(DETAILWORK9,new Integer(11) );
  fieldMap.put(DETAILWORK10,new Integer(12) );
  fieldMap.put(DETAILWORK11,new Integer(13) );
  fieldMap.put(DETAILWORK12,new Integer(14) );
  fieldMap.put(DETAILWORK13,new Integer(15) );
  fieldMap.put(DETAILWORK14,new Integer(16) );
  fieldMap.put(DETAILWORK15,new Integer(17) );
  fieldMap.put(DETAILWORK16,new Integer(18) );
  fieldMap.put(RECV_NUM,new Integer(19) );
  fieldMap.put(MOT_PROC,new Integer(20) );
  fieldMap.put(SIDO_CODE,new Integer(21) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_MOT_STE";
     final public static String PREFIX = "sp.dao.PT_R_MOT_STE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CHGBRE_SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       CHGBRE_SEQ,TMP_WRT_NUM,DETAILWORK1,DETAILWORK2,DETAILWORK3,DETAILWORK4,DETAILWORK5,DETAILWORK6,DETAILWORK7,DETAILWORK8,DETAILWORK9,DETAILWORK10,DETAILWORK11,DETAILWORK12,DETAILWORK13,DETAILWORK14,DETAILWORK15,DETAILWORK16,RECV_NUM,MOT_PROC,SIDO_CODE };
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
	    }

         return null;
    }

   public static String toXML(PT_R_MOT_STEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHGBRE_SEQ").append("'")
            .append(" value='").append(""+ent.getCHGBRE_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK1").append("'")
            .append(" value='").append(""+ent.getDETAILWORK1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK2").append("'")
            .append(" value='").append(""+ent.getDETAILWORK2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK3").append("'")
            .append(" value='").append(""+ent.getDETAILWORK3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK4").append("'")
            .append(" value='").append(""+ent.getDETAILWORK4()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK5").append("'")
            .append(" value='").append(""+ent.getDETAILWORK5()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK6").append("'")
            .append(" value='").append(""+ent.getDETAILWORK6()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK7").append("'")
            .append(" value='").append(""+ent.getDETAILWORK7()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK8").append("'")
            .append(" value='").append(""+ent.getDETAILWORK8()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK9").append("'")
            .append(" value='").append(""+ent.getDETAILWORK9()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK10").append("'")
            .append(" value='").append(""+ent.getDETAILWORK10()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK11").append("'")
            .append(" value='").append(""+ent.getDETAILWORK11()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK12").append("'")
            .append(" value='").append(""+ent.getDETAILWORK12()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK13").append("'")
            .append(" value='").append(""+ent.getDETAILWORK13()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK14").append("'")
            .append(" value='").append(""+ent.getDETAILWORK14()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK15").append("'")
            .append(" value='").append(""+ent.getDETAILWORK15()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DETAILWORK16").append("'")
            .append(" value='").append(""+ent.getDETAILWORK16()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOT_PROC").append("'")
            .append(" value='").append(""+ent.getMOT_PROC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
