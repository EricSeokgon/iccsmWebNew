

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_CLOSE_STATEMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               COI_WRT_NUM:VARCHAR2(12):  
*               RECV_DT:VARCHAR2(8):  
*               OFFI_PART:VARCHAR2(50):  
*               OFFI_PART_REBO_WRT_NUM:VARCHAR2(12):  
*               NAME:VARCHAR2(50):  
*               WRT_NUM:VARCHAR2(12):  
*               REP_NM_KOR:VARCHAR2(20):  
*               REP_NM_HAN:VARCHAR2(20):  
*               OFF_ADDR:VARCHAR2(200):  
*               TEL_NUM:VARCHAR2(17):  
*               C_COM_DT:VARCHAR2(8):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               C_COM_CAUSE:VARCHAR2(256):  
*               DEFI_STE:VARCHAR2(1):  
*               ADDR_ADDR:VARCHAR2(120):  
*               ADDR_POST_NUM:VARCHAR2(6):  
*               ADDR_DETAIL_ADDR:VARCHAR2(129):  
*               PROC_LIM:VARCHAR2(8):  
*               MEMO_CONT:VARCHAR2(256):  
*               MOT_STE:VARCHAR2(20):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DOC_CODE:VARCHAR2(50):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_CLOSE_STATEMENTHelper{

  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String COI_WRT_NUM = "COI_WRT_NUM";
  final static public String RECV_DT = "RECV_DT";
  final static public String OFFI_PART = "OFFI_PART";
  final static public String OFFI_PART_REBO_WRT_NUM = "OFFI_PART_REBO_WRT_NUM";
  final static public String NAME = "NAME";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String REP_NM_KOR = "REP_NM_KOR";
  final static public String REP_NM_HAN = "REP_NM_HAN";
  final static public String OFF_ADDR = "OFF_ADDR";
  final static public String TEL_NUM = "TEL_NUM";
  final static public String C_COM_DT = "C_COM_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String C_COM_CAUSE = "C_COM_CAUSE";
  final static public String DEFI_STE = "DEFI_STE";
  final static public String ADDR_ADDR = "ADDR_ADDR";
  final static public String ADDR_POST_NUM = "ADDR_POST_NUM";
  final static public String ADDR_DETAIL_ADDR = "ADDR_DETAIL_ADDR";
  final static public String PROC_LIM = "PROC_LIM";
  final static public String MEMO_CONT = "MEMO_CONT";
  final static public String MOT_STE = "MOT_STE";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String DOC_CODE = "DOC_CODE";
  


  public static HashMap fieldMap = new HashMap(26);
  static{
  fieldMap.put(RECV_NUM,new Integer(1) );
  fieldMap.put(SIDO_CODE,new Integer(2) );
  fieldMap.put(COI_WRT_NUM,new Integer(3) );
  fieldMap.put(RECV_DT,new Integer(4) );
  fieldMap.put(OFFI_PART,new Integer(5) );
  fieldMap.put(OFFI_PART_REBO_WRT_NUM,new Integer(6) );
  fieldMap.put(NAME,new Integer(7) );
  fieldMap.put(WRT_NUM,new Integer(8) );
  fieldMap.put(REP_NM_KOR,new Integer(9) );
  fieldMap.put(REP_NM_HAN,new Integer(10) );
  fieldMap.put(OFF_ADDR,new Integer(11) );
  fieldMap.put(TEL_NUM,new Integer(12) );
  fieldMap.put(C_COM_DT,new Integer(13) );
  fieldMap.put(WRT_ID,new Integer(14) );
  fieldMap.put(UPD_DT,new Integer(15) );
  fieldMap.put(INS_DT,new Integer(16) );
  fieldMap.put(C_COM_CAUSE,new Integer(17) );
  fieldMap.put(DEFI_STE,new Integer(18) );
  fieldMap.put(ADDR_ADDR,new Integer(19) );
  fieldMap.put(ADDR_POST_NUM,new Integer(20) );
  fieldMap.put(ADDR_DETAIL_ADDR,new Integer(21) );
  fieldMap.put(PROC_LIM,new Integer(22) );
  fieldMap.put(MEMO_CONT,new Integer(23) );
  fieldMap.put(MOT_STE,new Integer(24) );
  fieldMap.put(TMP_WRT_NUM,new Integer(25) );
  fieldMap.put(DOC_CODE,new Integer(26) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_CLOSE_STATEMENT";
     final public static String PREFIX = "sp.dao.PT_R_CLOSE_STATEMENT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SIDO_CODE };
     final public static String FIELD_LIST[] = { 
       RECV_NUM,SIDO_CODE,COI_WRT_NUM,RECV_DT,OFFI_PART,OFFI_PART_REBO_WRT_NUM,NAME,WRT_NUM,REP_NM_KOR,REP_NM_HAN,OFF_ADDR,TEL_NUM,C_COM_DT,WRT_ID,UPD_DT,INS_DT,C_COM_CAUSE,DEFI_STE,ADDR_ADDR,ADDR_POST_NUM,ADDR_DETAIL_ADDR,PROC_LIM,MEMO_CONT,MOT_STE,TMP_WRT_NUM,DOC_CODE };
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

   public static String toXML(PT_R_CLOSE_STATEMENTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COI_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getCOI_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_DT").append("'")
            .append(" value='").append(""+ent.getRECV_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFI_PART").append("'")
            .append(" value='").append(""+ent.getOFFI_PART()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFI_PART_REBO_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getOFFI_PART_REBO_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NAME").append("'")
            .append(" value='").append(""+ent.getNAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_NM_KOR").append("'")
            .append(" value='").append(""+ent.getREP_NM_KOR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REP_NM_HAN").append("'")
            .append(" value='").append(""+ent.getREP_NM_HAN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFF_ADDR").append("'")
            .append(" value='").append(""+ent.getOFF_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TEL_NUM").append("'")
            .append(" value='").append(""+ent.getTEL_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("C_COM_DT").append("'")
            .append(" value='").append(""+ent.getC_COM_DT()).append("' />\n");
        
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
            .append(" name='").append("C_COM_CAUSE").append("'")
            .append(" value='").append(""+ent.getC_COM_CAUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFI_STE").append("'")
            .append(" value='").append(""+ent.getDEFI_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_ADDR").append("'")
            .append(" value='").append(""+ent.getADDR_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_POST_NUM").append("'")
            .append(" value='").append(""+ent.getADDR_POST_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADDR_DETAIL_ADDR").append("'")
            .append(" value='").append(""+ent.getADDR_DETAIL_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_LIM").append("'")
            .append(" value='").append(""+ent.getPROC_LIM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MEMO_CONT").append("'")
            .append(" value='").append(""+ent.getMEMO_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOT_STE").append("'")
            .append(" value='").append(""+ent.getMOT_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_CODE").append("'")
            .append(" value='").append(""+ent.getDOC_CODE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
