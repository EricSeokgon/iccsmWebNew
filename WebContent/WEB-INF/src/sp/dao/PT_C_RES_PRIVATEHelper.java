

/*
*  Automatic generated  source
*  ��  ��  �� : ���� 
*
*  ���̺� ��   :PT_C_RES_PRIVATE
*  ���̺� ���� :
*  ���̺� PK   :  
*               ORG_NM  
*               SEQ
*  ���̺� �÷� :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               TEL_TD:NUMBER(10):  
*               M_BELOW:NUMBER(10):  
*               USE:VARCHAR2(50):  
*               REMARK:VARCHAR2(125):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_C_RES_PRIVATEHelper{

  final static public String SEQ = "SEQ";
  final static public String ORG_NM = "ORG_NM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String TEL_TD = "TEL_TD";
  final static public String M_BELOW = "M_BELOW";
  final static public String USE = "USE";
  final static public String REMARK = "REMARK";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  


  public static HashMap fieldMap = new HashMap(11);
  static{
  fieldMap.put(SEQ,new Integer(1) );
  fieldMap.put(ORG_NM,new Integer(2) );
  fieldMap.put(SIDO_CODE,new Integer(3) );
  fieldMap.put(TEL_TD,new Integer(4) );
  fieldMap.put(M_BELOW,new Integer(5) );
  fieldMap.put(USE,new Integer(6) );
  fieldMap.put(REMARK,new Integer(7) );
  fieldMap.put(INS_DT,new Integer(8) );
  fieldMap.put(UPD_DT,new Integer(9) );
  fieldMap.put(WRT_ID,new Integer(10) );
  fieldMap.put(SIGUNGU_CODE,new Integer(11) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_C_RES_PRIVATE";
     final public static String PREFIX = "sp.dao.PT_C_RES_PRIVATE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       ORG_NM,SEQ };
     final public static String FIELD_LIST[] = { 
       SEQ,ORG_NM,SIDO_CODE,TEL_TD,M_BELOW,USE,REMARK,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE };
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
	    }

         return null;
    }

   public static String toXML(PT_C_RES_PRIVATEEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SEQ").append("'")
            .append(" value='").append(""+ent.getSEQ()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORG_NM").append("'")
            .append(" value='").append(""+ent.getORG_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TEL_TD").append("'")
            .append(" value='").append(""+ent.getTEL_TD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("M_BELOW").append("'")
            .append(" value='").append(""+ent.getM_BELOW()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE").append("'")
            .append(" value='").append(""+ent.getUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REMARK").append("'")
            .append(" value='").append(""+ent.getREMARK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}