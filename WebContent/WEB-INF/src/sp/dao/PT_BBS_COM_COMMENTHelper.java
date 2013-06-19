

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_COM_COMMENT
*  테이블 설명 :
*  테이블 PK   :  
*               COMMENT_SEQ
*  테이블 컬럼 :  
*               COMMENT_SEQ:NUMBER(10):  
*               CT_ID:VARCHAR2(30):  
*               BOARD_SEQ:VARCHAR2(10):  
*               PASS:VARCHAR2(10):  
*               WRT_NM:NVARCHAR2(100):  
*               WRT_ID:VARCHAR2(20):  
*               COMMET:NVARCHAR2(4000):  
*               UPD_DT:VARCHAR2(23):  
*               INS_DT:VARCHAR2(23):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_BBS_COM_COMMENTHelper{

  final static public String COMMENT_SEQ = "COMMENT_SEQ";
  final static public String CT_ID = "CT_ID";
  final static public String BOARD_SEQ = "BOARD_SEQ";
  final static public String PASS = "PASS";
  final static public String WRT_NM = "WRT_NM";
  final static public String WRT_ID = "WRT_ID";
  final static public String COMMET = "COMMET";
  final static public String UPD_DT = "UPD_DT";
  final static public String INS_DT = "INS_DT";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(COMMENT_SEQ,new Integer(1) );
  fieldMap.put(CT_ID,new Integer(2) );
  fieldMap.put(BOARD_SEQ,new Integer(3) );
  fieldMap.put(PASS,new Integer(4) );
  fieldMap.put(WRT_NM,new Integer(5) );
  fieldMap.put(WRT_ID,new Integer(6) );
  fieldMap.put(COMMET,new Integer(7) );
  fieldMap.put(UPD_DT,new Integer(8) );
  fieldMap.put(INS_DT,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_BBS_COM_COMMENT";
     final public static String PREFIX = "sp.dao.PT_BBS_COM_COMMENT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       COMMENT_SEQ };
     final public static String FIELD_LIST[] = { 
       COMMENT_SEQ,CT_ID,BOARD_SEQ,PASS,WRT_NM,WRT_ID,COMMET,UPD_DT,INS_DT };
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

   public static String toXML(PT_BBS_COM_COMMENTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMMENT_SEQ").append("'")
            .append(" value='").append(""+ent.getCOMMENT_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CT_ID").append("'")
            .append(" value='").append(""+ent.getCT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BOARD_SEQ").append("'")
            .append(" value='").append(""+ent.getBOARD_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PASS").append("'")
            .append(" value='").append(""+ent.getPASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NM").append("'")
            .append(" value='").append(""+ent.getWRT_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COMMET").append("'")
            .append(" value='").append(""+ent.getCOMMET()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
