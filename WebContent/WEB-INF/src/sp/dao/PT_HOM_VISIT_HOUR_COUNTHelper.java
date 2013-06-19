

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_HOM_VISIT_HOUR_COUNT
*  테이블 설명 :
*  테이블 PK   :  
*               REG_DATE
*  테이블 컬럼 :  
*               REG_DATE:VARCHAR2(12):  
*               H_01:NUMBER(22):  
*               H_02:NUMBER(22):  
*               H_03:NUMBER(22):  
*               H_04:NUMBER(22):  
*               H_05:NUMBER(22):  
*               H_06:NUMBER(22):  
*               H_07:NUMBER(22):  
*               H_08:NUMBER(22):  
*               H_09:NUMBER(22):  
*               H_10:NUMBER(22):  
*               H_11:NUMBER(22):  
*               H_12:NUMBER(22):  
*               H_13:NUMBER(22):  
*               H_14:NUMBER(22):  
*               H_15:NUMBER(22):  
*               H_16:NUMBER(22):  
*               H_17:NUMBER(22):  
*               H_18:NUMBER(22):  
*               H_19:NUMBER(22):  
*               H_20:NUMBER(22):  
*               H_21:NUMBER(22):  
*               H_22:NUMBER(22):  
*               H_23:NUMBER(22):  
*               H_24:NUMBER(22):  
*               DAY_TOTAL:NUMBER(22):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_HOM_VISIT_HOUR_COUNTHelper{

  final static public String REG_DATE = "REG_DATE";
  final static public String H_01 = "H_01";
  final static public String H_02 = "H_02";
  final static public String H_03 = "H_03";
  final static public String H_04 = "H_04";
  final static public String H_05 = "H_05";
  final static public String H_06 = "H_06";
  final static public String H_07 = "H_07";
  final static public String H_08 = "H_08";
  final static public String H_09 = "H_09";
  final static public String H_10 = "H_10";
  final static public String H_11 = "H_11";
  final static public String H_12 = "H_12";
  final static public String H_13 = "H_13";
  final static public String H_14 = "H_14";
  final static public String H_15 = "H_15";
  final static public String H_16 = "H_16";
  final static public String H_17 = "H_17";
  final static public String H_18 = "H_18";
  final static public String H_19 = "H_19";
  final static public String H_20 = "H_20";
  final static public String H_21 = "H_21";
  final static public String H_22 = "H_22";
  final static public String H_23 = "H_23";
  final static public String H_24 = "H_24";
  final static public String DAY_TOTAL = "DAY_TOTAL";
  


  public static HashMap fieldMap = new HashMap(26);
  static{
  fieldMap.put(REG_DATE,new Integer(1) );
  fieldMap.put(H_01,new Integer(2) );
  fieldMap.put(H_02,new Integer(3) );
  fieldMap.put(H_03,new Integer(4) );
  fieldMap.put(H_04,new Integer(5) );
  fieldMap.put(H_05,new Integer(6) );
  fieldMap.put(H_06,new Integer(7) );
  fieldMap.put(H_07,new Integer(8) );
  fieldMap.put(H_08,new Integer(9) );
  fieldMap.put(H_09,new Integer(10) );
  fieldMap.put(H_10,new Integer(11) );
  fieldMap.put(H_11,new Integer(12) );
  fieldMap.put(H_12,new Integer(13) );
  fieldMap.put(H_13,new Integer(14) );
  fieldMap.put(H_14,new Integer(15) );
  fieldMap.put(H_15,new Integer(16) );
  fieldMap.put(H_16,new Integer(17) );
  fieldMap.put(H_17,new Integer(18) );
  fieldMap.put(H_18,new Integer(19) );
  fieldMap.put(H_19,new Integer(20) );
  fieldMap.put(H_20,new Integer(21) );
  fieldMap.put(H_21,new Integer(22) );
  fieldMap.put(H_22,new Integer(23) );
  fieldMap.put(H_23,new Integer(24) );
  fieldMap.put(H_24,new Integer(25) );
  fieldMap.put(DAY_TOTAL,new Integer(26) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_HOM_VISIT_HOUR_COUNT";
     final public static String PREFIX = "sp.dao.PT_HOM_VISIT_HOUR_COUNT";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       REG_DATE };
     final public static String FIELD_LIST[] = { 
       REG_DATE,H_01,H_02,H_03,H_04,H_05,H_06,H_07,H_08,H_09,H_10,H_11,H_12,H_13,H_14,H_15,H_16,H_17,H_18,H_19,H_20,H_21,H_22,H_23,H_24,DAY_TOTAL };
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
	    }

         return null;
    }

   public static String toXML(PT_HOM_VISIT_HOUR_COUNTEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REG_DATE").append("'")
            .append(" value='").append(""+ent.getREG_DATE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_01").append("'")
            .append(" value='").append(""+ent.getH_01()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_02").append("'")
            .append(" value='").append(""+ent.getH_02()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_03").append("'")
            .append(" value='").append(""+ent.getH_03()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_04").append("'")
            .append(" value='").append(""+ent.getH_04()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_05").append("'")
            .append(" value='").append(""+ent.getH_05()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_06").append("'")
            .append(" value='").append(""+ent.getH_06()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_07").append("'")
            .append(" value='").append(""+ent.getH_07()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_08").append("'")
            .append(" value='").append(""+ent.getH_08()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_09").append("'")
            .append(" value='").append(""+ent.getH_09()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_10").append("'")
            .append(" value='").append(""+ent.getH_10()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_11").append("'")
            .append(" value='").append(""+ent.getH_11()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_12").append("'")
            .append(" value='").append(""+ent.getH_12()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_13").append("'")
            .append(" value='").append(""+ent.getH_13()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_14").append("'")
            .append(" value='").append(""+ent.getH_14()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_15").append("'")
            .append(" value='").append(""+ent.getH_15()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_16").append("'")
            .append(" value='").append(""+ent.getH_16()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_17").append("'")
            .append(" value='").append(""+ent.getH_17()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_18").append("'")
            .append(" value='").append(""+ent.getH_18()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_19").append("'")
            .append(" value='").append(""+ent.getH_19()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_20").append("'")
            .append(" value='").append(""+ent.getH_20()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_21").append("'")
            .append(" value='").append(""+ent.getH_21()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_22").append("'")
            .append(" value='").append(""+ent.getH_22()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_23").append("'")
            .append(" value='").append(""+ent.getH_23()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("H_24").append("'")
            .append(" value='").append(""+ent.getH_24()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DAY_TOTAL").append("'")
            .append(" value='").append(""+ent.getDAY_TOTAL()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
