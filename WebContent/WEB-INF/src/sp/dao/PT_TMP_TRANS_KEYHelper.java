

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_TMP_TRANS_KEY
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               WORK_CLASS_CODE:VARCHAR2(18):  
*               KEY1:VARCHAR2(20):  
*               KEY2:VARCHAR2(20):  
*               KEY3:VARCHAR2(20):  
*               KEY4:VARCHAR2(20):  
*               KEY5:VARCHAR2(20):  
*               CUD_FLAG:VARCHAR2(1):  
*               SEQ:VARCHAR2(18):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_TMP_TRANS_KEYHelper{

  final static public String WORK_CLASS_CODE = "WORK_CLASS_CODE";
  final static public String KEY1 = "KEY1";
  final static public String KEY2 = "KEY2";
  final static public String KEY3 = "KEY3";
  final static public String KEY4 = "KEY4";
  final static public String KEY5 = "KEY5";
  final static public String CUD_FLAG = "CUD_FLAG";
  final static public String SEQ = "SEQ";
  final static public String INS_DT = "INS_DT";
  


  public static HashMap fieldMap = new HashMap(9);
  static{
  fieldMap.put(WORK_CLASS_CODE,new Integer(1) );
  fieldMap.put(KEY1,new Integer(2) );
  fieldMap.put(KEY2,new Integer(3) );
  fieldMap.put(KEY3,new Integer(4) );
  fieldMap.put(KEY4,new Integer(5) );
  fieldMap.put(KEY5,new Integer(6) );
  fieldMap.put(CUD_FLAG,new Integer(7) );
  fieldMap.put(SEQ,new Integer(8) );
  fieldMap.put(INS_DT,new Integer(9) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_TMP_TRANS_KEY";
     final public static String PREFIX = "sp.dao.PT_TMP_TRANS_KEY";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       WORK_CLASS_CODE,KEY1,KEY2,KEY3,KEY4,KEY5,CUD_FLAG,SEQ,INS_DT };
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

   public static String toXML(PT_TMP_TRANS_KEYEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WORK_CLASS_CODE").append("'")
            .append(" value='").append(""+ent.getWORK_CLASS_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("KEY1").append("'")
            .append(" value='").append(""+ent.getKEY1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("KEY2").append("'")
            .append(" value='").append(""+ent.getKEY2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("KEY3").append("'")
            .append(" value='").append(""+ent.getKEY3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("KEY4").append("'")
            .append(" value='").append(""+ent.getKEY4()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("KEY5").append("'")
            .append(" value='").append(""+ent.getKEY5()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CUD_FLAG").append("'")
            .append(" value='").append(""+ent.getCUD_FLAG()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
