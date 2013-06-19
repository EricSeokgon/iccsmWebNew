

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_AUDI_REPORT
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               AUDI_SUBJ:VARCHAR2(50):  
*               ADMI_DISPO_CAUSE:VARCHAR2(1024):  
*               ADMI_DISPO_CONT:VARCHAR2(6):  
*               AUDI_SUPINT_PART:VARCHAR2(50):  
*               AUDI_SUPINT_POS:VARCHAR2(50):  
*               AUDI_SUPINT_NM:VARCHAR2(20):  
*               AUDI_PER_NM:VARCHAR2(60):  
*               AUDI_PER_ADDR:VARCHAR2(200):  
*               LEG_BAS:VARCHAR2(6):  
*               AUDI_EXEC_ORG:VARCHAR2(40):  
*               AUDI_EXEC_PART:VARCHAR2(50):  
*               AUDI_EXEC_ADDR:VARCHAR2(100):  
*               AUDI_EXEC_DETAILADDR:VARCHAR2(100):  
*               AUDI_EXEC_DT:VARCHAR2(8):  
*               AUDI_EXEC_TIME:VARCHAR2(4):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_M_AUDI_REPORTHelper{

  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String AUDI_SUBJ = "AUDI_SUBJ";
  final static public String ADMI_DISPO_CAUSE = "ADMI_DISPO_CAUSE";
  final static public String ADMI_DISPO_CONT = "ADMI_DISPO_CONT";
  final static public String AUDI_SUPINT_PART = "AUDI_SUPINT_PART";
  final static public String AUDI_SUPINT_POS = "AUDI_SUPINT_POS";
  final static public String AUDI_SUPINT_NM = "AUDI_SUPINT_NM";
  final static public String AUDI_PER_NM = "AUDI_PER_NM";
  final static public String AUDI_PER_ADDR = "AUDI_PER_ADDR";
  final static public String LEG_BAS = "LEG_BAS";
  final static public String AUDI_EXEC_ORG = "AUDI_EXEC_ORG";
  final static public String AUDI_EXEC_PART = "AUDI_EXEC_PART";
  final static public String AUDI_EXEC_ADDR = "AUDI_EXEC_ADDR";
  final static public String AUDI_EXEC_DETAILADDR = "AUDI_EXEC_DETAILADDR";
  final static public String AUDI_EXEC_DT = "AUDI_EXEC_DT";
  final static public String AUDI_EXEC_TIME = "AUDI_EXEC_TIME";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  


  public static HashMap fieldMap = new HashMap(20);
  static{
  fieldMap.put(TMP_WRT_NUM,new Integer(1) );
  fieldMap.put(WRT_NUM,new Integer(2) );
  fieldMap.put(AUDI_SUBJ,new Integer(3) );
  fieldMap.put(ADMI_DISPO_CAUSE,new Integer(4) );
  fieldMap.put(ADMI_DISPO_CONT,new Integer(5) );
  fieldMap.put(AUDI_SUPINT_PART,new Integer(6) );
  fieldMap.put(AUDI_SUPINT_POS,new Integer(7) );
  fieldMap.put(AUDI_SUPINT_NM,new Integer(8) );
  fieldMap.put(AUDI_PER_NM,new Integer(9) );
  fieldMap.put(AUDI_PER_ADDR,new Integer(10) );
  fieldMap.put(LEG_BAS,new Integer(11) );
  fieldMap.put(AUDI_EXEC_ORG,new Integer(12) );
  fieldMap.put(AUDI_EXEC_PART,new Integer(13) );
  fieldMap.put(AUDI_EXEC_ADDR,new Integer(14) );
  fieldMap.put(AUDI_EXEC_DETAILADDR,new Integer(15) );
  fieldMap.put(AUDI_EXEC_DT,new Integer(16) );
  fieldMap.put(AUDI_EXEC_TIME,new Integer(17) );
  fieldMap.put(INS_DT,new Integer(18) );
  fieldMap.put(UPD_DT,new Integer(19) );
  fieldMap.put(WRT_ID,new Integer(20) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_M_AUDI_REPORT";
     final public static String PREFIX = "sp.dao.PT_M_AUDI_REPORT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM };
     final public static String FIELD_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM,AUDI_SUBJ,ADMI_DISPO_CAUSE,ADMI_DISPO_CONT,AUDI_SUPINT_PART,AUDI_SUPINT_POS,AUDI_SUPINT_NM,AUDI_PER_NM,AUDI_PER_ADDR,LEG_BAS,AUDI_EXEC_ORG,AUDI_EXEC_PART,AUDI_EXEC_ADDR,AUDI_EXEC_DETAILADDR,AUDI_EXEC_DT,AUDI_EXEC_TIME,INS_DT,UPD_DT,WRT_ID };
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

   public static String toXML(PT_M_AUDI_REPORTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_SUBJ").append("'")
            .append(" value='").append(""+ent.getAUDI_SUBJ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADMI_DISPO_CAUSE").append("'")
            .append(" value='").append(""+ent.getADMI_DISPO_CAUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADMI_DISPO_CONT").append("'")
            .append(" value='").append(""+ent.getADMI_DISPO_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_SUPINT_PART").append("'")
            .append(" value='").append(""+ent.getAUDI_SUPINT_PART()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_SUPINT_POS").append("'")
            .append(" value='").append(""+ent.getAUDI_SUPINT_POS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_SUPINT_NM").append("'")
            .append(" value='").append(""+ent.getAUDI_SUPINT_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_PER_NM").append("'")
            .append(" value='").append(""+ent.getAUDI_PER_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_PER_ADDR").append("'")
            .append(" value='").append(""+ent.getAUDI_PER_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LEG_BAS").append("'")
            .append(" value='").append(""+ent.getLEG_BAS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_ORG").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_ORG()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_PART").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_PART()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_ADDR").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_DETAILADDR").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_DETAILADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_DT").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_TIME").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
