

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_COM_CODE
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(11):  
*               CODE:VARCHAR2(32):  
*               P_CODE:VARCHAR2(32):  
*               CODE_NAME:VARCHAR2(128):  
*               ORDER_SEQ:NUMBER(13):  
*               USE_YN:VARCHAR2(1):  
*               BIGO:VARCHAR2(200):  
*               REG_DATE:VARCHAR2(20):  
*               MOD_DATE:VARCHAR2(20):  
*               P_CODE_NAME:VARCHAR2(128):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_COM_CODEHelper{

  final static public String SEQ = "SEQ";
  final static public String CODE = "CODE";
  final static public String P_CODE = "P_CODE";
  final static public String CODE_NAME = "CODE_NAME";
  final static public String ORDER_SEQ = "ORDER_SEQ";
  final static public String USE_YN = "USE_YN";
  final static public String BIGO = "BIGO";
  final static public String REG_DATE = "REG_DATE";
  final static public String MOD_DATE = "MOD_DATE";
  final static public String P_CODE_NAME = "P_CODE_NAME";
  


  public static HashMap fieldMap = new HashMap(10);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(CODE,new Integer(2) );
  fieldMap.put(P_CODE,new Integer(3) );
  fieldMap.put(CODE_NAME,new Integer(4) );
  fieldMap.put(ORDER_SEQ,new Integer(5) );
  fieldMap.put(USE_YN,new Integer(6) );
  fieldMap.put(BIGO,new Integer(7) );
  fieldMap.put(REG_DATE,new Integer(8) );
  fieldMap.put(MOD_DATE,new Integer(9) );
  fieldMap.put(P_CODE_NAME,new Integer(10) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_COM_CODE";
     final public static String PREFIX = "sp.dao.PT_COM_CODE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,CODE,P_CODE,CODE_NAME,ORDER_SEQ,USE_YN,BIGO,REG_DATE,MOD_DATE,P_CODE_NAME };
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
	    }

         return null;
    }

   public static String toXML(PT_COM_CODEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CODE").append("'")
            .append(" value='").append(""+ent.getCODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("P_CODE").append("'")
            .append(" value='").append(""+ent.getP_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CODE_NAME").append("'")
            .append(" value='").append(""+ent.getCODE_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORDER_SEQ").append("'")
            .append(" value='").append(""+ent.getORDER_SEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_YN").append("'")
            .append(" value='").append(""+ent.getUSE_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BIGO").append("'")
            .append(" value='").append(""+ent.getBIGO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REG_DATE").append("'")
            .append(" value='").append(""+ent.getREG_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOD_DATE").append("'")
            .append(" value='").append(""+ent.getMOD_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("P_CODE_NAME").append("'")
            .append(" value='").append(""+ent.getP_CODE_NAME()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
