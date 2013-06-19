

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_AUDI_DICTION
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               AUDI_SUBJ:VARCHAR2(50):  
*               AUDI_SUPINT_PART:VARCHAR2(50):  
*               AUDI_SUPINT_POS:VARCHAR2(50):  
*               AUDI_SUPINT_NM:VARCHAR2(20):  
*               AUDI_ATTEND_PERSON_NM:VARCHAR2(20):  
*               AUDI_ATTEND_PERSON_PART:VARCHAR2(50):  
*               AUDI_PER_ATTE_YN:VARCHAR2(1):  
*               AUDI_PER_NATTE_CAUSE:VARCHAR2(512):  
*               AUDI_OPN_YN:VARCHAR2(1):  
*               AUDI_NOPN_CAUSE:VARCHAR2(512):  
*               PER_STAT_CONT:VARCHAR2(1024):  
*               PER_PRES_EVID:VARCHAR2(512):  
*               EVID_INV_EVID:VARCHAR2(512):  
*               ETC:VARCHAR2(256):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               EVID_INV_POIN:VARCHAR2(1024):  
*               AUDI_ATTEND_PERSON_POS:VARCHAR2(50):  
*               AUDI_EXEC_DT:VARCHAR2(8):  
*               AUDI_EXEC_TIME:VARCHAR2(4):  
*               AUDI_EXEC_LOC:VARCHAR2(256):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_M_AUDI_DICTIONHelper{

  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String AUDI_SUBJ = "AUDI_SUBJ";
  final static public String AUDI_SUPINT_PART = "AUDI_SUPINT_PART";
  final static public String AUDI_SUPINT_POS = "AUDI_SUPINT_POS";
  final static public String AUDI_SUPINT_NM = "AUDI_SUPINT_NM";
  final static public String AUDI_ATTEND_PERSON_NM = "AUDI_ATTEND_PERSON_NM";
  final static public String AUDI_ATTEND_PERSON_PART = "AUDI_ATTEND_PERSON_PART";
  final static public String AUDI_PER_ATTE_YN = "AUDI_PER_ATTE_YN";
  final static public String AUDI_PER_NATTE_CAUSE = "AUDI_PER_NATTE_CAUSE";
  final static public String AUDI_OPN_YN = "AUDI_OPN_YN";
  final static public String AUDI_NOPN_CAUSE = "AUDI_NOPN_CAUSE";
  final static public String PER_STAT_CONT = "PER_STAT_CONT";
  final static public String PER_PRES_EVID = "PER_PRES_EVID";
  final static public String EVID_INV_EVID = "EVID_INV_EVID";
  final static public String ETC = "ETC";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String EVID_INV_POIN = "EVID_INV_POIN";
  final static public String AUDI_ATTEND_PERSON_POS = "AUDI_ATTEND_PERSON_POS";
  final static public String AUDI_EXEC_DT = "AUDI_EXEC_DT";
  final static public String AUDI_EXEC_TIME = "AUDI_EXEC_TIME";
  final static public String AUDI_EXEC_LOC = "AUDI_EXEC_LOC";
  


  public static HashMap fieldMap = new HashMap(24);
  static{
  fieldMap.put(TMP_WRT_NUM,new Integer(1) );
  fieldMap.put(WRT_NUM,new Integer(2) );
  fieldMap.put(AUDI_SUBJ,new Integer(3) );
  fieldMap.put(AUDI_SUPINT_PART,new Integer(4) );
  fieldMap.put(AUDI_SUPINT_POS,new Integer(5) );
  fieldMap.put(AUDI_SUPINT_NM,new Integer(6) );
  fieldMap.put(AUDI_ATTEND_PERSON_NM,new Integer(7) );
  fieldMap.put(AUDI_ATTEND_PERSON_PART,new Integer(8) );
  fieldMap.put(AUDI_PER_ATTE_YN,new Integer(9) );
  fieldMap.put(AUDI_PER_NATTE_CAUSE,new Integer(10) );
  fieldMap.put(AUDI_OPN_YN,new Integer(11) );
  fieldMap.put(AUDI_NOPN_CAUSE,new Integer(12) );
  fieldMap.put(PER_STAT_CONT,new Integer(13) );
  fieldMap.put(PER_PRES_EVID,new Integer(14) );
  fieldMap.put(EVID_INV_EVID,new Integer(15) );
  fieldMap.put(ETC,new Integer(16) );
  fieldMap.put(INS_DT,new Integer(17) );
  fieldMap.put(UPD_DT,new Integer(18) );
  fieldMap.put(WRT_ID,new Integer(19) );
  fieldMap.put(EVID_INV_POIN,new Integer(20) );
  fieldMap.put(AUDI_ATTEND_PERSON_POS,new Integer(21) );
  fieldMap.put(AUDI_EXEC_DT,new Integer(22) );
  fieldMap.put(AUDI_EXEC_TIME,new Integer(23) );
  fieldMap.put(AUDI_EXEC_LOC,new Integer(24) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_M_AUDI_DICTION";
     final public static String PREFIX = "sp.dao.PT_M_AUDI_DICTION";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM };
     final public static String FIELD_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM,AUDI_SUBJ,AUDI_SUPINT_PART,AUDI_SUPINT_POS,AUDI_SUPINT_NM,AUDI_ATTEND_PERSON_NM,AUDI_ATTEND_PERSON_PART,AUDI_PER_ATTE_YN,AUDI_PER_NATTE_CAUSE,AUDI_OPN_YN,AUDI_NOPN_CAUSE,PER_STAT_CONT,PER_PRES_EVID,EVID_INV_EVID,ETC,INS_DT,UPD_DT,WRT_ID,EVID_INV_POIN,AUDI_ATTEND_PERSON_POS,AUDI_EXEC_DT,AUDI_EXEC_TIME,AUDI_EXEC_LOC };
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
             case 24 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_M_AUDI_DICTIONEntity ent){

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
            .append(" name='").append("AUDI_SUPINT_PART").append("'")
            .append(" value='").append(""+ent.getAUDI_SUPINT_PART()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_SUPINT_POS").append("'")
            .append(" value='").append(""+ent.getAUDI_SUPINT_POS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_SUPINT_NM").append("'")
            .append(" value='").append(""+ent.getAUDI_SUPINT_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_ATTEND_PERSON_NM").append("'")
            .append(" value='").append(""+ent.getAUDI_ATTEND_PERSON_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_ATTEND_PERSON_PART").append("'")
            .append(" value='").append(""+ent.getAUDI_ATTEND_PERSON_PART()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_PER_ATTE_YN").append("'")
            .append(" value='").append(""+ent.getAUDI_PER_ATTE_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_PER_NATTE_CAUSE").append("'")
            .append(" value='").append(""+ent.getAUDI_PER_NATTE_CAUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_OPN_YN").append("'")
            .append(" value='").append(""+ent.getAUDI_OPN_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_NOPN_CAUSE").append("'")
            .append(" value='").append(""+ent.getAUDI_NOPN_CAUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PER_STAT_CONT").append("'")
            .append(" value='").append(""+ent.getPER_STAT_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PER_PRES_EVID").append("'")
            .append(" value='").append(""+ent.getPER_PRES_EVID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EVID_INV_EVID").append("'")
            .append(" value='").append(""+ent.getEVID_INV_EVID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC").append("'")
            .append(" value='").append(""+ent.getETC()).append("' />\n");
        
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
            .append(" name='").append("EVID_INV_POIN").append("'")
            .append(" value='").append(""+ent.getEVID_INV_POIN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_ATTEND_PERSON_POS").append("'")
            .append(" value='").append(""+ent.getAUDI_ATTEND_PERSON_POS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_DT").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_TIME").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AUDI_EXEC_LOC").append("'")
            .append(" value='").append(""+ent.getAUDI_EXEC_LOC()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
