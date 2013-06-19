

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_RE_DERIVERY_STATEMENT
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
*               REP:VARCHAR2(20):  
*               TEL_NUM:VARCHAR2(17):  
*               FAX_NUM:VARCHAR2(17):  
*               OFF_ADDR:VARCHAR2(200):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               MOT_STE:VARCHAR2(6):  
*               DEFI_STE:VARCHAR2(1):  
*               COI:VARCHAR2(1):  
*               WRTBOOK:VARCHAR2(1):  
*               APPL_CAUSE:VARCHAR2(256):  
*               TMP_WRT_NUM:VARCHAR2(32):  
*               DOC_CODE:VARCHAR2(50):  
*               SND_STE:VARCHAR2(4):  
*               SND_DT:VARCHAR2(8):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_RE_DERIVERY_STATEMENTHelper{

  final static public String RECV_NUM = "RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String COI_WRT_NUM = "COI_WRT_NUM";
  final static public String RECV_DT = "RECV_DT";
  final static public String OFFI_PART = "OFFI_PART";
  final static public String OFFI_PART_REBO_WRT_NUM = "OFFI_PART_REBO_WRT_NUM";
  final static public String NAME = "NAME";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String REP = "REP";
  final static public String TEL_NUM = "TEL_NUM";
  final static public String FAX_NUM = "FAX_NUM";
  final static public String OFF_ADDR = "OFF_ADDR";
  final static public String WRT_ID = "WRT_ID";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  final static public String MOT_STE = "MOT_STE";
  final static public String DEFI_STE = "DEFI_STE";
  final static public String COI = "COI";
  final static public String WRTBOOK = "WRTBOOK";
  final static public String APPL_CAUSE = "APPL_CAUSE";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String DOC_CODE = "DOC_CODE";
  final static public String SND_STE = "SND_STE";
  final static public String SND_DT = "SND_DT";
  


  public static HashMap fieldMap = new HashMap(24);
  static{
  fieldMap.put(RECV_NUM,new Integer(1) );
  fieldMap.put(SIDO_CODE,new Integer(2) );
  fieldMap.put(COI_WRT_NUM,new Integer(3) );
  fieldMap.put(RECV_DT,new Integer(4) );
  fieldMap.put(OFFI_PART,new Integer(5) );
  fieldMap.put(OFFI_PART_REBO_WRT_NUM,new Integer(6) );
  fieldMap.put(NAME,new Integer(7) );
  fieldMap.put(WRT_NUM,new Integer(8) );
  fieldMap.put(REP,new Integer(9) );
  fieldMap.put(TEL_NUM,new Integer(10) );
  fieldMap.put(FAX_NUM,new Integer(11) );
  fieldMap.put(OFF_ADDR,new Integer(12) );
  fieldMap.put(WRT_ID,new Integer(13) );
  fieldMap.put(UPD_DT,new Integer(14) );
  fieldMap.put(INS_DT,new Integer(15) );
  fieldMap.put(MOT_STE,new Integer(16) );
  fieldMap.put(DEFI_STE,new Integer(17) );
  fieldMap.put(COI,new Integer(18) );
  fieldMap.put(WRTBOOK,new Integer(19) );
  fieldMap.put(APPL_CAUSE,new Integer(20) );
  fieldMap.put(TMP_WRT_NUM,new Integer(21) );
  fieldMap.put(DOC_CODE,new Integer(22) );
  fieldMap.put(SND_STE,new Integer(23) );
  fieldMap.put(SND_DT,new Integer(24) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_RE_DERIVERY_STATEMENT";
     final public static String PREFIX = "sp.dao.PT_R_RE_DERIVERY_STATEMENT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SIDO_CODE };
     final public static String FIELD_LIST[] = { 
       RECV_NUM,SIDO_CODE,COI_WRT_NUM,RECV_DT,OFFI_PART,OFFI_PART_REBO_WRT_NUM,NAME,WRT_NUM,REP,TEL_NUM,FAX_NUM,OFF_ADDR,WRT_ID,UPD_DT,INS_DT,MOT_STE,DEFI_STE,COI,WRTBOOK,APPL_CAUSE,TMP_WRT_NUM,DOC_CODE,SND_STE,SND_DT };
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

   public static String toXML(PT_R_RE_DERIVERY_STATEMENTEntity ent){

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
            .append(" name='").append("REP").append("'")
            .append(" value='").append(""+ent.getREP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TEL_NUM").append("'")
            .append(" value='").append(""+ent.getTEL_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FAX_NUM").append("'")
            .append(" value='").append(""+ent.getFAX_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFF_ADDR").append("'")
            .append(" value='").append(""+ent.getOFF_ADDR()).append("' />\n");
        
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
            .append(" name='").append("MOT_STE").append("'")
            .append(" value='").append(""+ent.getMOT_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFI_STE").append("'")
            .append(" value='").append(""+ent.getDEFI_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COI").append("'")
            .append(" value='").append(""+ent.getCOI()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRTBOOK").append("'")
            .append(" value='").append(""+ent.getWRTBOOK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("APPL_CAUSE").append("'")
            .append(" value='").append(""+ent.getAPPL_CAUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_CODE").append("'")
            .append(" value='").append(""+ent.getDOC_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SND_STE").append("'")
            .append(" value='").append(""+ent.getSND_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SND_DT").append("'")
            .append(" value='").append(""+ent.getSND_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
