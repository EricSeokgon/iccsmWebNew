

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REFFER
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(3):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               SI_DO_CODE:VARCHAR2(4):  
*               SI_GUN_GU_CODE:VARCHAR2(4):  
*               POS_CLASS:VARCHAR2(6):  
*               ENT_DT:VARCHAR2(8):  
*               RET_DT:VARCHAR2(8):  
*               NM_KOR:VARCHAR2(20):  
*               NM_HAN:VARCHAR2(20):  
*               ORI:VARCHAR2(200):  
*               ADDR:VARCHAR2(200):  
*               SSN1:VARCHAR2(18):  
*               SSN2:VARCHAR2(21):  
*               HEFA:VARCHAR2(10):  
*               HEFA_RELA:VARCHAR2(10):  
*               REMARK:VARCHAR2(256):  
*               CHAR_REF_YN:VARCHAR2(2):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SEND_YN:VARCHAR2(1):  
*               FOREIGN_YN:VARCHAR2(1):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_REFFERHelper{

  final static public String SEQ = "SEQ";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String SI_DO_CODE = "SI_DO_CODE";
  final static public String SI_GUN_GU_CODE = "SI_GUN_GU_CODE";
  final static public String POS_CLASS = "POS_CLASS";
  final static public String ENT_DT = "ENT_DT";
  final static public String RET_DT = "RET_DT";
  final static public String NM_KOR = "NM_KOR";
  final static public String NM_HAN = "NM_HAN";
  final static public String ORI = "ORI";
  final static public String ADDR = "ADDR";
  final static public String SSN1 = "SSN1";
  final static public String SSN2 = "SSN2";
  final static public String HEFA = "HEFA";
  final static public String HEFA_RELA = "HEFA_RELA";
  final static public String REMARK = "REMARK";
  final static public String CHAR_REF_YN = "CHAR_REF_YN";
  final static public String WRT_ID = "WRT_ID";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String SEND_YN = "SEND_YN";
  final static public String FOREIGN_YN = "FOREIGN_YN";
  


  public static HashMap fieldMap = new HashMap(22);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(TMP_WRT_NUM,new Integer(2) );
  fieldMap.put(SI_DO_CODE,new Integer(3) );
  fieldMap.put(SI_GUN_GU_CODE,new Integer(4) );
  fieldMap.put(POS_CLASS,new Integer(5) );
  fieldMap.put(ENT_DT,new Integer(6) );
  fieldMap.put(RET_DT,new Integer(7) );
  fieldMap.put(NM_KOR,new Integer(8) );
  fieldMap.put(NM_HAN,new Integer(9) );
  fieldMap.put(ORI,new Integer(10) );
  fieldMap.put(ADDR,new Integer(11) );
  fieldMap.put(SSN1,new Integer(12) );
  fieldMap.put(SSN2,new Integer(13) );
  fieldMap.put(HEFA,new Integer(14) );
  fieldMap.put(HEFA_RELA,new Integer(15) );
  fieldMap.put(REMARK,new Integer(16) );
  fieldMap.put(CHAR_REF_YN,new Integer(17) );
  fieldMap.put(WRT_ID,new Integer(18) );
  fieldMap.put(INS_DT,new Integer(19) );
  fieldMap.put(UPD_DT,new Integer(20) );
  fieldMap.put(SEND_YN,new Integer(21) );
  fieldMap.put(FOREIGN_YN,new Integer(22) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_REFFER";
     final public static String PREFIX = "sp.dao.PT_R_REFFER";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ,TMP_WRT_NUM };
     final public static String FIELD_LIST[] = { 
       SEQ,TMP_WRT_NUM,SI_DO_CODE,SI_GUN_GU_CODE,POS_CLASS,ENT_DT,RET_DT,NM_KOR,NM_HAN,ORI,ADDR,SSN1,SSN2,HEFA,HEFA_RELA,REMARK,CHAR_REF_YN,WRT_ID,INS_DT,UPD_DT,SEND_YN,FOREIGN_YN };
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
	    }

         return null;
    }

   public static String toXML(PT_R_REFFEREntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SI_DO_CODE").append("'")
            .append(" value='").append(""+ent.getSI_DO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SI_GUN_GU_CODE").append("'")
            .append(" value='").append(""+ent.getSI_GUN_GU_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("POS_CLASS").append("'")
            .append(" value='").append(""+ent.getPOS_CLASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ENT_DT").append("'")
            .append(" value='").append(""+ent.getENT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RET_DT").append("'")
            .append(" value='").append(""+ent.getRET_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NM_KOR").append("'")
            .append(" value='").append(""+ent.getNM_KOR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NM_HAN").append("'")
            .append(" value='").append(""+ent.getNM_HAN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORI").append("'")
            .append(" value='").append(""+ent.getORI()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR").append("'")
            .append(" value='").append(""+ent.getADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SSN1").append("'")
            .append(" value='").append(""+ent.getSSN1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SSN2").append("'")
            .append(" value='").append(""+ent.getSSN2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("HEFA").append("'")
            .append(" value='").append(""+ent.getHEFA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("HEFA_RELA").append("'")
            .append(" value='").append(""+ent.getHEFA_RELA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REMARK").append("'")
            .append(" value='").append(""+ent.getREMARK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHAR_REF_YN").append("'")
            .append(" value='").append(""+ent.getCHAR_REF_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEND_YN").append("'")
            .append(" value='").append(""+ent.getSEND_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FOREIGN_YN").append("'")
            .append(" value='").append(""+ent.getFOREIGN_YN()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
