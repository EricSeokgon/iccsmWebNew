

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_CONFIRM
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               VIOL_DT:VARCHAR2(8):  
*               VIOL_ITEM:VARCHAR2(512):  
*               VIOL_CONT:VARCHAR2(2048):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_S_CONFIRMHelper{

  final static public String WRT_NUM = "WRT_NUM";
  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String VIOL_DT = "VIOL_DT";
  final static public String VIOL_ITEM = "VIOL_ITEM";
  final static public String VIOL_CONT = "VIOL_CONT";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  


  public static HashMap fieldMap = new HashMap(8);
  static{
  fieldMap.put(WRT_NUM,new Integer(1) );
  fieldMap.put(TMP_WRT_NUM,new Integer(2) );
  fieldMap.put(VIOL_DT,new Integer(3) );
  fieldMap.put(VIOL_ITEM,new Integer(4) );
  fieldMap.put(VIOL_CONT,new Integer(5) );
  fieldMap.put(INS_DT,new Integer(6) );
  fieldMap.put(UPD_DT,new Integer(7) );
  fieldMap.put(WRT_ID,new Integer(8) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_S_CONFIRM";
     final public static String PREFIX = "sp.dao.PT_S_CONFIRM";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM };
     final public static String FIELD_LIST[] = { 
       WRT_NUM,TMP_WRT_NUM,VIOL_DT,VIOL_ITEM,VIOL_CONT,INS_DT,UPD_DT,WRT_ID };
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
	    }

         return null;
    }

   public static String toXML(PT_S_CONFIRMEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("VIOL_DT").append("'")
            .append(" value='").append(""+ent.getVIOL_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("VIOL_ITEM").append("'")
            .append(" value='").append(""+ent.getVIOL_ITEM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("VIOL_CONT").append("'")
            .append(" value='").append(""+ent.getVIOL_CONT()).append("' />\n");
        
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
