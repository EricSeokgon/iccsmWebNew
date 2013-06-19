

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_MI_USER
*  테이블 설명 :
*  테이블 PK   :  
*               OFFI_ID
*  테이블 컬럼 :  
*               OFFI_ID:VARCHAR2(16):  
*               NM:VARCHAR2(40):  
*               TEL:VARCHAR2(16):  
*               SIDO_CODE:VARCHAR2(10):  
*               SIGUNGU_CODE:VARCHAR2(10):  
*               PART:VARCHAR2(50):  
*               POS:VARCHAR2(20):  
*               GROUP_CODE:VARCHAR2(5):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               PASS:VARCHAR2(16):  
*               HOME_GROUP:VARCHAR2(5):  
*               MOBILE:VARCHAR2(16):  
*               E_MAIL:VARCHAR2(128):  
*               OFFSEAL:VARCHAR2(26):  
*               TEL1:VARCHAR2(20):  
*               TEL2:VARCHAR2(20):  
*               TEL3:VARCHAR2(20):  
*               MOBILE1:VARCHAR2(20):  
*               MOBILE2:VARCHAR2(20):  
*               MOBILE3:VARCHAR2(20):  
*               PHOTO:VARCHAR2(26):  
*               FAX1:VARCHAR2(20):  
*               FAX2:VARCHAR2(20):  
*               FAX3:VARCHAR2(20):  
*               FAX:VARCHAR2(20):  
*               RECV_ID:VARCHAR2(40):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_MI_USERHelper{

  final static public String OFFI_ID = "OFFI_ID";
  final static public String NM = "NM";
  final static public String TEL = "TEL";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String PART = "PART";
  final static public String POS = "POS";
  final static public String GROUP_CODE = "GROUP_CODE";
  final static public String WRT_ID = "WRT_ID";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String PASS = "PASS";
  final static public String HOME_GROUP = "HOME_GROUP";
  final static public String MOBILE = "MOBILE";
  final static public String E_MAIL = "E_MAIL";
  final static public String OFFSEAL = "OFFSEAL";
  final static public String TEL1 = "TEL1";
  final static public String TEL2 = "TEL2";
  final static public String TEL3 = "TEL3";
  final static public String MOBILE1 = "MOBILE1";
  final static public String MOBILE2 = "MOBILE2";
  final static public String MOBILE3 = "MOBILE3";
  final static public String PHOTO = "PHOTO";
  final static public String FAX1 = "FAX1";
  final static public String FAX2 = "FAX2";
  final static public String FAX3 = "FAX3";
  final static public String FAX = "FAX";
  final static public String RECV_ID = "RECV_ID";
  


  public static HashMap fieldMap = new HashMap(28);
  static{
  fieldMap.put(OFFI_ID,new Integer(1) );
  fieldMap.put(NM,new Integer(2) );
  fieldMap.put(TEL,new Integer(3) );
  fieldMap.put(SIDO_CODE,new Integer(4) );
  fieldMap.put(SIGUNGU_CODE,new Integer(5) );
  fieldMap.put(PART,new Integer(6) );
  fieldMap.put(POS,new Integer(7) );
  fieldMap.put(GROUP_CODE,new Integer(8) );
  fieldMap.put(WRT_ID,new Integer(9) );
  fieldMap.put(INS_DT,new Integer(10) );
  fieldMap.put(UPD_DT,new Integer(11) );
  fieldMap.put(PASS,new Integer(12) );
  fieldMap.put(HOME_GROUP,new Integer(13) );
  fieldMap.put(MOBILE,new Integer(14) );
  fieldMap.put(E_MAIL,new Integer(15) );
  fieldMap.put(OFFSEAL,new Integer(16) );
  fieldMap.put(TEL1,new Integer(17) );
  fieldMap.put(TEL2,new Integer(18) );
  fieldMap.put(TEL3,new Integer(19) );
  fieldMap.put(MOBILE1,new Integer(20) );
  fieldMap.put(MOBILE2,new Integer(21) );
  fieldMap.put(MOBILE3,new Integer(22) );
  fieldMap.put(PHOTO,new Integer(23) );
  fieldMap.put(FAX1,new Integer(24) );
  fieldMap.put(FAX2,new Integer(25) );
  fieldMap.put(FAX3,new Integer(26) );
  fieldMap.put(FAX,new Integer(27) );
  fieldMap.put(RECV_ID,new Integer(28) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_MI_USER";
     final public static String PREFIX = "sp.dao.PT_MI_USER";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       OFFI_ID };
     final public static String FIELD_LIST[] = { 
       OFFI_ID,NM,TEL,SIDO_CODE,SIGUNGU_CODE,PART,POS,GROUP_CODE,WRT_ID,INS_DT,UPD_DT,PASS,HOME_GROUP,MOBILE,E_MAIL,OFFSEAL,TEL1,TEL2,TEL3,MOBILE1,MOBILE2,MOBILE3,PHOTO,FAX1,FAX2,FAX3,FAX,RECV_ID };
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
             case 27 : 
	                  return  "";
             case 28 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_MI_USEREntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFI_ID").append("'")
            .append(" value='").append(""+ent.getOFFI_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NM").append("'")
            .append(" value='").append(""+ent.getNM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TEL").append("'")
            .append(" value='").append(""+ent.getTEL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PART").append("'")
            .append(" value='").append(""+ent.getPART()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("POS").append("'")
            .append(" value='").append(""+ent.getPOS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("GROUP_CODE").append("'")
            .append(" value='").append(""+ent.getGROUP_CODE()).append("' />\n");
        
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
            .append(" name='").append("PASS").append("'")
            .append(" value='").append(""+ent.getPASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("HOME_GROUP").append("'")
            .append(" value='").append(""+ent.getHOME_GROUP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOBILE").append("'")
            .append(" value='").append(""+ent.getMOBILE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("E_MAIL").append("'")
            .append(" value='").append(""+ent.getE_MAIL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFSEAL").append("'")
            .append(" value='").append(""+ent.getOFFSEAL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TEL1").append("'")
            .append(" value='").append(""+ent.getTEL1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TEL2").append("'")
            .append(" value='").append(""+ent.getTEL2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TEL3").append("'")
            .append(" value='").append(""+ent.getTEL3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOBILE1").append("'")
            .append(" value='").append(""+ent.getMOBILE1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOBILE2").append("'")
            .append(" value='").append(""+ent.getMOBILE2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOBILE3").append("'")
            .append(" value='").append(""+ent.getMOBILE3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PHOTO").append("'")
            .append(" value='").append(""+ent.getPHOTO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FAX1").append("'")
            .append(" value='").append(""+ent.getFAX1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FAX2").append("'")
            .append(" value='").append(""+ent.getFAX2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FAX3").append("'")
            .append(" value='").append(""+ent.getFAX3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FAX").append("'")
            .append(" value='").append(""+ent.getFAX()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_ID").append("'")
            .append(" value='").append(""+ent.getRECV_ID()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
