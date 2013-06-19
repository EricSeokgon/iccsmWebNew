

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_UNION_STATEMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ASC_TMP_WRT_NUM:VARCHAR2(12):  
*               HANDED_TMP_WRT_NUM:VARCHAR2(12):  
*               MOT_STE:VARCHAR2(6):  
*               ESTA_TMP_WRT_NUM:VARCHAR2(12):  
*               ESTA_ADDR_TEL_NUM:VARCHAR2(17):  
*               ESTA_NAME:VARCHAR2(50):  
*               ESTA_REP_NM_KOR:VARCHAR2(20):  
*               ESTA_REP_NM_HAN:VARCHAR2(20):  
*               ESTA_MANA_NUM:VARCHAR2(13):  
*               ESTA_ADDR_ADDR:VARCHAR2(120):  
*               ESTA_ADDR_POST_NUM:VARCHAR2(6):  
*               ESTA_ADDR_DETAIL_ADDR:VARCHAR2(120):  
*               ESTA_WRT_NUM:VARCHAR2(12):  
*               DEFI_STE:VARCHAR2(1):  
*               PROC_LIM:VARCHAR2(8):  
*               PROC_TIME:VARCHAR2(6):  
*               RECV_DT:VARCHAR2(8):  
*               RECV_TIME:VARCHAR2(6):  
*               BUSS_YMD:VARCHAR2(8):  
*               FOREIGN:VARCHAR2(1):  
*               REGIST_YMD:VARCHAR2(8):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_UNION_STATEMENTHelper{

  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String ASC_TMP_WRT_NUM = "ASC_TMP_WRT_NUM";
  final static public String HANDED_TMP_WRT_NUM = "HANDED_TMP_WRT_NUM";
  final static public String MOT_STE = "MOT_STE";
  final static public String ESTA_TMP_WRT_NUM = "ESTA_TMP_WRT_NUM";
  final static public String ESTA_ADDR_TEL_NUM = "ESTA_ADDR_TEL_NUM";
  final static public String ESTA_NAME = "ESTA_NAME";
  final static public String ESTA_REP_NM_KOR = "ESTA_REP_NM_KOR";
  final static public String ESTA_REP_NM_HAN = "ESTA_REP_NM_HAN";
  final static public String ESTA_MANA_NUM = "ESTA_MANA_NUM";
  final static public String ESTA_ADDR_ADDR = "ESTA_ADDR_ADDR";
  final static public String ESTA_ADDR_POST_NUM = "ESTA_ADDR_POST_NUM";
  final static public String ESTA_ADDR_DETAIL_ADDR = "ESTA_ADDR_DETAIL_ADDR";
  final static public String ESTA_WRT_NUM = "ESTA_WRT_NUM";
  final static public String DEFI_STE = "DEFI_STE";
  final static public String PROC_LIM = "PROC_LIM";
  final static public String PROC_TIME = "PROC_TIME";
  final static public String RECV_DT = "RECV_DT";
  final static public String RECV_TIME = "RECV_TIME";
  final static public String BUSS_YMD = "BUSS_YMD";
  final static public String FOREIGN = "FOREIGN";
  final static public String REGIST_YMD = "REGIST_YMD";
  


  public static HashMap fieldMap = new HashMap(26);
  static{
  fieldMap.put(RECV_NUM,new Integer(1) );
  fieldMap.put(SIDO_CODE,new Integer(2) );
  fieldMap.put(WRT_ID,new Integer(3) );
  fieldMap.put(UPD_DT,new Integer(4) );
  fieldMap.put(INS_DT,new Integer(5) );
  fieldMap.put(ASC_TMP_WRT_NUM,new Integer(6) );
  fieldMap.put(HANDED_TMP_WRT_NUM,new Integer(7) );
  fieldMap.put(MOT_STE,new Integer(8) );
  fieldMap.put(ESTA_TMP_WRT_NUM,new Integer(9) );
  fieldMap.put(ESTA_ADDR_TEL_NUM,new Integer(10) );
  fieldMap.put(ESTA_NAME,new Integer(11) );
  fieldMap.put(ESTA_REP_NM_KOR,new Integer(12) );
  fieldMap.put(ESTA_REP_NM_HAN,new Integer(13) );
  fieldMap.put(ESTA_MANA_NUM,new Integer(14) );
  fieldMap.put(ESTA_ADDR_ADDR,new Integer(15) );
  fieldMap.put(ESTA_ADDR_POST_NUM,new Integer(16) );
  fieldMap.put(ESTA_ADDR_DETAIL_ADDR,new Integer(17) );
  fieldMap.put(ESTA_WRT_NUM,new Integer(18) );
  fieldMap.put(DEFI_STE,new Integer(19) );
  fieldMap.put(PROC_LIM,new Integer(20) );
  fieldMap.put(PROC_TIME,new Integer(21) );
  fieldMap.put(RECV_DT,new Integer(22) );
  fieldMap.put(RECV_TIME,new Integer(23) );
  fieldMap.put(BUSS_YMD,new Integer(24) );
  fieldMap.put(FOREIGN,new Integer(25) );
  fieldMap.put(REGIST_YMD,new Integer(26) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_UNION_STATEMENT";
     final public static String PREFIX = "sp.dao.PT_R_UNION_STATEMENT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SIDO_CODE };
     final public static String FIELD_LIST[] = { 
       RECV_NUM,SIDO_CODE,WRT_ID,UPD_DT,INS_DT,ASC_TMP_WRT_NUM,HANDED_TMP_WRT_NUM,MOT_STE,ESTA_TMP_WRT_NUM,ESTA_ADDR_TEL_NUM,ESTA_NAME,ESTA_REP_NM_KOR,ESTA_REP_NM_HAN,ESTA_MANA_NUM,ESTA_ADDR_ADDR,ESTA_ADDR_POST_NUM,ESTA_ADDR_DETAIL_ADDR,ESTA_WRT_NUM,DEFI_STE,PROC_LIM,PROC_TIME,RECV_DT,RECV_TIME,BUSS_YMD,FOREIGN,REGIST_YMD };
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
             case 25 : 
	                  return  "";
             case 26 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_R_UNION_STATEMENTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASC_TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getASC_TMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("HANDED_TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getHANDED_TMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOT_STE").append("'")
            .append(" value='").append(""+ent.getMOT_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getESTA_TMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_ADDR_TEL_NUM").append("'")
            .append(" value='").append(""+ent.getESTA_ADDR_TEL_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_NAME").append("'")
            .append(" value='").append(""+ent.getESTA_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_REP_NM_KOR").append("'")
            .append(" value='").append(""+ent.getESTA_REP_NM_KOR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_REP_NM_HAN").append("'")
            .append(" value='").append(""+ent.getESTA_REP_NM_HAN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_MANA_NUM").append("'")
            .append(" value='").append(""+ent.getESTA_MANA_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_ADDR_ADDR").append("'")
            .append(" value='").append(""+ent.getESTA_ADDR_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_ADDR_POST_NUM").append("'")
            .append(" value='").append(""+ent.getESTA_ADDR_POST_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_ADDR_DETAIL_ADDR").append("'")
            .append(" value='").append(""+ent.getESTA_ADDR_DETAIL_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ESTA_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getESTA_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFI_STE").append("'")
            .append(" value='").append(""+ent.getDEFI_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_LIM").append("'")
            .append(" value='").append(""+ent.getPROC_LIM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_TIME").append("'")
            .append(" value='").append(""+ent.getPROC_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_DT").append("'")
            .append(" value='").append(""+ent.getRECV_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_TIME").append("'")
            .append(" value='").append(""+ent.getRECV_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BUSS_YMD").append("'")
            .append(" value='").append(""+ent.getBUSS_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FOREIGN").append("'")
            .append(" value='").append(""+ent.getFOREIGN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REGIST_YMD").append("'")
            .append(" value='").append(""+ent.getREGIST_YMD()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
