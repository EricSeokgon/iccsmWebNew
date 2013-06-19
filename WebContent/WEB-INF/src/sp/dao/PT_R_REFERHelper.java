

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REFER
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_REG_NUM
*  테이블 컬럼 :  
*               SD_CODE:VARCHAR2(4):  
*               SEQ:NUMBER(11):  
*               SGG_CODE:VARCHAR2(4):  
*               GUBUN:VARCHAR2(20):  
*               WRT_ID:VARCHAR2(16):  
*               UDP_DT:VARCHAR2(24):  
*               NAME_HANJA:VARCHAR2(20):  
*               INS_DT:VARCHAR2(24):  
*               SSN1:NUMBER(6):  
*               NOTE:VARCHAR2(128):  
*               ADDR:VARCHAR2(128):  
*               FAMILY_HEAD:VARCHAR2(20):  
*               SSN2:NUMBER(7):  
*               FAMILY_HEAD_RELATION:VARCHAR2(20):  
*               NAME_KOR:VARCHAR2(18):  
*               ORIGIN:VARCHAR2(128):  
*               TMP_REG_NUM:CHAR(18):  
*               ENTER_DATE:VARCHAR2(8):  
*               RETIRE_DATE:VARCHAR2(8):  
*               REFER_YN:VARCHAR2(1):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_REFERHelper{

  final static public String SD_CODE = "SD_CODE";
  final static public String SEQ = "SEQ";
  final static public String SGG_CODE = "SGG_CODE";
  final static public String GUBUN = "GUBUN";
  final static public String WRT_ID = "WRT_ID";
  final static public String UDP_DT = "UDP_DT";
  final static public String NAME_HANJA = "NAME_HANJA";
  final static public String INS_DT = "INS_DT";
  final static public String SSN1 = "SSN1";
  final static public String NOTE = "NOTE";
  final static public String ADDR = "ADDR";
  final static public String FAMILY_HEAD = "FAMILY_HEAD";
  final static public String SSN2 = "SSN2";
  final static public String FAMILY_HEAD_RELATION = "FAMILY_HEAD_RELATION";
  final static public String NAME_KOR = "NAME_KOR";
  final static public String ORIGIN = "ORIGIN";
  final static public String TMP_REG_NUM = "TMP_REG_NUM";
  final static public String ENTER_DATE = "ENTER_DATE";
  final static public String RETIRE_DATE = "RETIRE_DATE";
  final static public String REFER_YN = "REFER_YN";
  


  public static HashMap fieldMap = new HashMap(20);
  static{
  fieldMap.put(SD_CODE,new Integer(1) );
  fieldMap.put(SEQ,new Integer(2) );
  fieldMap.put(SGG_CODE,new Integer(3) );
  fieldMap.put(GUBUN,new Integer(4) );
  fieldMap.put(WRT_ID,new Integer(5) );
  fieldMap.put(UDP_DT,new Integer(6) );
  fieldMap.put(NAME_HANJA,new Integer(7) );
  fieldMap.put(INS_DT,new Integer(8) );
  fieldMap.put(SSN1,new Integer(9) );
  fieldMap.put(NOTE,new Integer(10) );
  fieldMap.put(ADDR,new Integer(11) );
  fieldMap.put(FAMILY_HEAD,new Integer(12) );
  fieldMap.put(SSN2,new Integer(13) );
  fieldMap.put(FAMILY_HEAD_RELATION,new Integer(14) );
  fieldMap.put(NAME_KOR,new Integer(15) );
  fieldMap.put(ORIGIN,new Integer(16) );
  fieldMap.put(TMP_REG_NUM,new Integer(17) );
  fieldMap.put(ENTER_DATE,new Integer(18) );
  fieldMap.put(RETIRE_DATE,new Integer(19) );
  fieldMap.put(REFER_YN,new Integer(20) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_REFER";
     final public static String PREFIX = "sp.dao.PT_R_REFER";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,TMP_REG_NUM };
     final public static String FIELD_LIST[] = { 
       SD_CODE,SEQ,SGG_CODE,GUBUN,WRT_ID,UDP_DT,NAME_HANJA,INS_DT,SSN1,NOTE,ADDR,FAMILY_HEAD,SSN2,FAMILY_HEAD_RELATION,NAME_KOR,ORIGIN,TMP_REG_NUM,ENTER_DATE,RETIRE_DATE,REFER_YN };
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
	    }

         return null;
    }

   public static String toXML(PT_R_REFEREntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SD_CODE").append("'")
            .append(" value='").append(""+ent.getSD_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SGG_CODE").append("'")
            .append(" value='").append(""+ent.getSGG_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("GUBUN").append("'")
            .append(" value='").append(""+ent.getGUBUN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UDP_DT").append("'")
            .append(" value='").append(""+ent.getUDP_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NAME_HANJA").append("'")
            .append(" value='").append(""+ent.getNAME_HANJA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SSN1").append("'")
            .append(" value='").append(""+ent.getSSN1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NOTE").append("'")
            .append(" value='").append(""+ent.getNOTE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR").append("'")
            .append(" value='").append(""+ent.getADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FAMILY_HEAD").append("'")
            .append(" value='").append(""+ent.getFAMILY_HEAD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SSN2").append("'")
            .append(" value='").append(""+ent.getSSN2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FAMILY_HEAD_RELATION").append("'")
            .append(" value='").append(""+ent.getFAMILY_HEAD_RELATION()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NAME_KOR").append("'")
            .append(" value='").append(""+ent.getNAME_KOR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORIGIN").append("'")
            .append(" value='").append(""+ent.getORIGIN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_REG_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_REG_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ENTER_DATE").append("'")
            .append(" value='").append(""+ent.getENTER_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RETIRE_DATE").append("'")
            .append(" value='").append(""+ent.getRETIRE_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REFER_YN").append("'")
            .append(" value='").append(""+ent.getREFER_YN()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
