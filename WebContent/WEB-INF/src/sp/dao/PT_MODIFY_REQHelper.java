

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_MODIFY_REQ
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(6):  
*               RECV_NAME:VARCHAR2(20):  
*               RECV_PART_SIDO:VARCHAR2(20):  
*               RECV_PART_SIGUNGU:VARCHAR2(30):  
*               RECV_POS:VARCHAR2(20):  
*               CONSULT_NAME:VARCHAR2(20):  
*               CONSULT_PART_SIDO:VARCHAR2(20):  
*               CONSULT_PART_SIGUNGU:VARCHAR2(30):  
*               CONSULT_POS:VARCHAR2(20):  
*               RECV_DT:VARCHAR2(8):  
*               RECV_METHOD:VARCHAR2(30):  
*               DEMAND_CONTENTS:VARCHAR2(500):  
*               REMARK:VARCHAR2(256):  
*               PROC_OUT:VARCHAR2(20):  
*               PROC_DT:VARCHAR2(8):  
*               PROC_TIME:VARCHAR2(6):  
*               RECV_AREA:VARCHAR2(4):  
*               CONSULT_AREA:VARCHAR2(4):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_MODIFY_REQHelper{

  final static public String SEQ = "SEQ";
  final static public String RECV_NAME = "RECV_NAME";
  final static public String RECV_PART_SIDO = "RECV_PART_SIDO";
  final static public String RECV_PART_SIGUNGU = "RECV_PART_SIGUNGU";
  final static public String RECV_POS = "RECV_POS";
  final static public String CONSULT_NAME = "CONSULT_NAME";
  final static public String CONSULT_PART_SIDO = "CONSULT_PART_SIDO";
  final static public String CONSULT_PART_SIGUNGU = "CONSULT_PART_SIGUNGU";
  final static public String CONSULT_POS = "CONSULT_POS";
  final static public String RECV_DT = "RECV_DT";
  final static public String RECV_METHOD = "RECV_METHOD";
  final static public String DEMAND_CONTENTS = "DEMAND_CONTENTS";
  final static public String REMARK = "REMARK";
  final static public String PROC_OUT = "PROC_OUT";
  final static public String PROC_DT = "PROC_DT";
  final static public String PROC_TIME = "PROC_TIME";
  final static public String RECV_AREA = "RECV_AREA";
  final static public String CONSULT_AREA = "CONSULT_AREA";
  


  public static HashMap fieldMap = new HashMap(18);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(RECV_NAME,new Integer(2) );
  fieldMap.put(RECV_PART_SIDO,new Integer(3) );
  fieldMap.put(RECV_PART_SIGUNGU,new Integer(4) );
  fieldMap.put(RECV_POS,new Integer(5) );
  fieldMap.put(CONSULT_NAME,new Integer(6) );
  fieldMap.put(CONSULT_PART_SIDO,new Integer(7) );
  fieldMap.put(CONSULT_PART_SIGUNGU,new Integer(8) );
  fieldMap.put(CONSULT_POS,new Integer(9) );
  fieldMap.put(RECV_DT,new Integer(10) );
  fieldMap.put(RECV_METHOD,new Integer(11) );
  fieldMap.put(DEMAND_CONTENTS,new Integer(12) );
  fieldMap.put(REMARK,new Integer(13) );
  fieldMap.put(PROC_OUT,new Integer(14) );
  fieldMap.put(PROC_DT,new Integer(15) );
  fieldMap.put(PROC_TIME,new Integer(16) );
  fieldMap.put(RECV_AREA,new Integer(17) );
  fieldMap.put(CONSULT_AREA,new Integer(18) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_MODIFY_REQ";
     final public static String PREFIX = "sp.dao.PT_MODIFY_REQ";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,RECV_NAME,RECV_PART_SIDO,RECV_PART_SIGUNGU,RECV_POS,CONSULT_NAME,CONSULT_PART_SIDO,CONSULT_PART_SIGUNGU,CONSULT_POS,RECV_DT,RECV_METHOD,DEMAND_CONTENTS,REMARK,PROC_OUT,PROC_DT,PROC_TIME,RECV_AREA,CONSULT_AREA };
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
	    }

         return null;
    }

   public static String toXML(PT_MODIFY_REQEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NAME").append("'")
            .append(" value='").append(""+ent.getRECV_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_PART_SIDO").append("'")
            .append(" value='").append(""+ent.getRECV_PART_SIDO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_PART_SIGUNGU").append("'")
            .append(" value='").append(""+ent.getRECV_PART_SIGUNGU()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_POS").append("'")
            .append(" value='").append(""+ent.getRECV_POS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONSULT_NAME").append("'")
            .append(" value='").append(""+ent.getCONSULT_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONSULT_PART_SIDO").append("'")
            .append(" value='").append(""+ent.getCONSULT_PART_SIDO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONSULT_PART_SIGUNGU").append("'")
            .append(" value='").append(""+ent.getCONSULT_PART_SIGUNGU()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONSULT_POS").append("'")
            .append(" value='").append(""+ent.getCONSULT_POS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_DT").append("'")
            .append(" value='").append(""+ent.getRECV_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_METHOD").append("'")
            .append(" value='").append(""+ent.getRECV_METHOD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEMAND_CONTENTS").append("'")
            .append(" value='").append(""+ent.getDEMAND_CONTENTS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REMARK").append("'")
            .append(" value='").append(""+ent.getREMARK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_OUT").append("'")
            .append(" value='").append(""+ent.getPROC_OUT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_DT").append("'")
            .append(" value='").append(""+ent.getPROC_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_TIME").append("'")
            .append(" value='").append(""+ent.getPROC_TIME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_AREA").append("'")
            .append(" value='").append(""+ent.getRECV_AREA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONSULT_AREA").append("'")
            .append(" value='").append(""+ent.getCONSULT_AREA()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
