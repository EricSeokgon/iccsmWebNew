

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_DOC_NUM
*  테이블 설명 :
*  테이블 PK   :  
*               DOC_CLASS  
*               SD_CODE
*  테이블 컬럼 :  
*               DOC_CLASS:VARCHAR2(20):  
*               SD_CODE:VARCHAR2(3):  
*               SGG_CODE:VARCHAR2(4):  
*               DOC_NUM1:VARCHAR2(4):  
*               DOC_NUM2:VARCHAR2(4):  
*               DOC_NUM3:VARCHAR2(4):  
*               DOC_NUM4:VARCHAR2(4):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_R_DOC_NUMHelper{

  final static public String DOC_CLASS = "DOC_CLASS";
  final static public String SD_CODE = "SD_CODE";
  final static public String SGG_CODE = "SGG_CODE";
  final static public String DOC_NUM1 = "DOC_NUM1";
  final static public String DOC_NUM2 = "DOC_NUM2";
  final static public String DOC_NUM3 = "DOC_NUM3";
  final static public String DOC_NUM4 = "DOC_NUM4";
  


  public static HashMap fieldMap = new HashMap(7);
  static{
  fieldMap.put(DOC_CLASS,new Integer(1) );
  fieldMap.put(SD_CODE,new Integer(2) );
  fieldMap.put(SGG_CODE,new Integer(3) );
  fieldMap.put(DOC_NUM1,new Integer(4) );
  fieldMap.put(DOC_NUM2,new Integer(5) );
  fieldMap.put(DOC_NUM3,new Integer(6) );
  fieldMap.put(DOC_NUM4,new Integer(7) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_R_DOC_NUM";
     final public static String PREFIX = "sp.dao.PT_R_DOC_NUM";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       DOC_CLASS,SD_CODE };
     final public static String FIELD_LIST[] = { 
       DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2,DOC_NUM3,DOC_NUM4 };
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
	    }

         return null;
    }

   public static String toXML(PT_R_DOC_NUMEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_CLASS").append("'")
            .append(" value='").append(""+ent.getDOC_CLASS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SD_CODE").append("'")
            .append(" value='").append(""+ent.getSD_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SGG_CODE").append("'")
            .append(" value='").append(""+ent.getSGG_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_NUM1").append("'")
            .append(" value='").append(""+ent.getDOC_NUM1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_NUM2").append("'")
            .append(" value='").append(""+ent.getDOC_NUM2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_NUM3").append("'")
            .append(" value='").append(""+ent.getDOC_NUM3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_NUM4").append("'")
            .append(" value='").append(""+ent.getDOC_NUM4()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
