

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_XML
*  테이블 설명 :
*  테이블 PK   :  
*               DSNAME  
*               FORMID  
*               SAMPLENAME  
*               USERID
*  테이블 컬럼 :  
*               USERID:VARCHAR2(50):  
*               FORMID:VARCHAR2(50):  
*               SAMPLENAME:VARCHAR2(50):  
*               XML:VARCHAR2(4000):  
*               DSNAME:VARCHAR2(50):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_XMLHelper{

  final static public String USERID = "USERID";
  final static public String FORMID = "FORMID";
  final static public String SAMPLENAME = "SAMPLENAME";
  final static public String XML = "XML";
  final static public String DSNAME = "DSNAME";
  


  public static HashMap fieldMap = new HashMap(5);
  static{
  fieldMap.put(USERID,new Integer(1) );
  fieldMap.put(FORMID,new Integer(2) );
  fieldMap.put(SAMPLENAME,new Integer(3) );
  fieldMap.put(XML,new Integer(4) );
  fieldMap.put(DSNAME,new Integer(5) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_XML";
     final public static String PREFIX = "sp.dao.PT_XML";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       DSNAME,FORMID,SAMPLENAME,USERID };
     final public static String FIELD_LIST[] = { 
       USERID,FORMID,SAMPLENAME,XML,DSNAME };
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
	    }

         return null;
    }

   public static String toXML(PT_XMLEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USERID").append("'")
            .append(" value='").append(""+ent.getUSERID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("FORMID").append("'")
            .append(" value='").append(""+ent.getFORMID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SAMPLENAME").append("'")
            .append(" value='").append(""+ent.getSAMPLENAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("XML").append("'")
            .append(" value='").append(""+ent.getXML()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DSNAME").append("'")
            .append(" value='").append(""+ent.getDSNAME()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
