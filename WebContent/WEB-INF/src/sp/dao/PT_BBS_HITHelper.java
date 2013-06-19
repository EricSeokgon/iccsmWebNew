

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_HIT
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               CT_ID:VARCHAR2(16):  
*               BOARD_SEQ:NUMBER(22):  
*               IPADDR:VARCHAR2(100):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_BBS_HITHelper{

  final static public String CT_ID = "CT_ID";
  final static public String BOARD_SEQ = "BOARD_SEQ";
  final static public String IPADDR = "IPADDR";
  


  public static HashMap fieldMap = new HashMap(3);
  static{
  fieldMap.put(CT_ID,new Integer(1) );
  fieldMap.put(BOARD_SEQ,new Integer(2) );
  fieldMap.put(IPADDR,new Integer(3) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_BBS_HIT";
     final public static String PREFIX = "sp.dao.PT_BBS_HIT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
        };
     final public static String FIELD_LIST[] = { 
       CT_ID,BOARD_SEQ,IPADDR };
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
	    }

         return null;
    }

   public static String toXML(PT_BBS_HITEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CT_ID").append("'")
            .append(" value='").append(""+ent.getCT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BOARD_SEQ").append("'")
            .append(" value='").append(""+ent.getBOARD_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("IPADDR").append("'")
            .append(" value='").append(""+ent.getIPADDR()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
