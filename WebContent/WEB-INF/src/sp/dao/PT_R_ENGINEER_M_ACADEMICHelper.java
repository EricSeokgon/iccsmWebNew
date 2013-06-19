

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_M_ACADEMIC
*  테이블 설명 :
*  테이블 PK   :  
*               CARE_BOOK_ISSUE_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(15):  
*               SCHNM:VARCHAR2(50):  
*               SUBJ_MAJ:VARCHAR2(50):  
*               GRA_YMD:VARCHAR2(12):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(20):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_ENGINEER_M_ACADEMICHelper{

  final static public String SEQ = "SEQ";
  final static public String CARE_BOOK_ISSUE_NUM = "CARE_BOOK_ISSUE_NUM";
  final static public String SCHNM = "SCHNM";
  final static public String SUBJ_MAJ = "SUBJ_MAJ";
  final static public String GRA_YMD = "GRA_YMD";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_DT = "WRT_DT";
  final static public String ETC1 = "ETC1";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(CARE_BOOK_ISSUE_NUM,new Integer(2) );
  fieldMap.put(SCHNM,new Integer(3) );
  fieldMap.put(SUBJ_MAJ,new Integer(4) );
  fieldMap.put(GRA_YMD,new Integer(5) );
  fieldMap.put(WRT_ID,new Integer(6) );
  fieldMap.put(UPD_DT,new Integer(7) );
  fieldMap.put(WRT_DT,new Integer(8) );
  fieldMap.put(ETC1,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_ENGINEER_M_ACADEMIC";
     final public static String PREFIX = "sp.dao.PT_R_ENGINEER_M_ACADEMIC";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       CARE_BOOK_ISSUE_NUM,SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,CARE_BOOK_ISSUE_NUM,SCHNM,SUBJ_MAJ,GRA_YMD,WRT_ID,UPD_DT,WRT_DT,ETC1 };
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
	    }

         return null;
    }

   public static String toXML(PT_R_ENGINEER_M_ACADEMICEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CARE_BOOK_ISSUE_NUM").append("'")
            .append(" value='").append(""+ent.getCARE_BOOK_ISSUE_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SCHNM").append("'")
            .append(" value='").append(""+ent.getSCHNM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUBJ_MAJ").append("'")
            .append(" value='").append(""+ent.getSUBJ_MAJ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("GRA_YMD").append("'")
            .append(" value='").append(""+ent.getGRA_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_DT").append("'")
            .append(" value='").append(""+ent.getWRT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC1").append("'")
            .append(" value='").append(""+ent.getETC1()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
