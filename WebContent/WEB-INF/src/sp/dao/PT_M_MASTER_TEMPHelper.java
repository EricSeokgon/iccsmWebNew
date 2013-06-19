

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_MASTER_TEMP
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               WRT_DT:VARCHAR2(8):  
*               REGR:VARCHAR2(16):  
*               VIOL_CONT_CODE:VARCHAR2(50):  
*               VIOL_DT:VARCHAR2(8):  
*               D_PER_CODE:VARCHAR2(6):  
*               DISPO_CONT:VARCHAR2(6):  
*               DISPO_CAUSE:VARCHAR2(512):  
*               DISPO_DT:VARCHAR2(8):  
*               MOT_STE:VARCHAR2(6):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               SIDO_CODE:VARCHAR2(4):  
*               REMARK:VARCHAR2(256):  
*               LEG_BAS:VARCHAR2(256):  
*               SND_STE:VARCHAR2(1):  
*               SND_DT:VARCHAR2(8):  
*               HOME_NOTE:VARCHAR2(8):  
*               NOTE_GUID_DT:VARCHAR2(8):  
*               OFFI_REPORT_DT:VARCHAR2(8):  
*               ASSO_GUILD_DT:VARCHAR2(8):  
*               RECV_NUM:VARCHAR2(24):  
*               DISPO_CONT2:VARCHAR2(6):  
*               AT_RECV_NUM:VARCHAR2(12):  
*               MAST_PROC:VARCHAR2(2):  
*               BUSISUSP_START_DT:VARCHAR2(12):  
*               BUSISUSP_END_DT:VARCHAR2(8):  
*               DOC_CODE:VARCHAR2(50):  
*               PUNISHMENT_AGENCY:VARCHAR2(30):  
*               DISPO_CONT_NM:VARCHAR2(50):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_M_MASTER_TEMPHelper{

  final static public String TMP_WRT_NUM = "TMP_WRT_NUM";
  final static public String WRT_NUM = "WRT_NUM";
  final static public String WRT_DT = "WRT_DT";
  final static public String REGR = "REGR";
  final static public String VIOL_CONT_CODE = "VIOL_CONT_CODE";
  final static public String VIOL_DT = "VIOL_DT";
  final static public String D_PER_CODE = "D_PER_CODE";
  final static public String DISPO_CONT = "DISPO_CONT";
  final static public String DISPO_CAUSE = "DISPO_CAUSE";
  final static public String DISPO_DT = "DISPO_DT";
  final static public String MOT_STE = "MOT_STE";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String REMARK = "REMARK";
  final static public String LEG_BAS = "LEG_BAS";
  final static public String SND_STE = "SND_STE";
  final static public String SND_DT = "SND_DT";
  final static public String HOME_NOTE = "HOME_NOTE";
  final static public String NOTE_GUID_DT = "NOTE_GUID_DT";
  final static public String OFFI_REPORT_DT = "OFFI_REPORT_DT";
  final static public String ASSO_GUILD_DT = "ASSO_GUILD_DT";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String DISPO_CONT2 = "DISPO_CONT2";
  final static public String AT_RECV_NUM = "AT_RECV_NUM";
  final static public String MAST_PROC = "MAST_PROC";
  final static public String BUSISUSP_START_DT = "BUSISUSP_START_DT";
  final static public String BUSISUSP_END_DT = "BUSISUSP_END_DT";
  final static public String DOC_CODE = "DOC_CODE";
  final static public String PUNISHMENT_AGENCY = "PUNISHMENT_AGENCY";
  final static public String DISPO_CONT_NM = "DISPO_CONT_NM";
  


  public static HashMap fieldMap = new HashMap(32);
  static{
  fieldMap.put(TMP_WRT_NUM,new Integer(1) );
  fieldMap.put(WRT_NUM,new Integer(2) );
  fieldMap.put(WRT_DT,new Integer(3) );
  fieldMap.put(REGR,new Integer(4) );
  fieldMap.put(VIOL_CONT_CODE,new Integer(5) );
  fieldMap.put(VIOL_DT,new Integer(6) );
  fieldMap.put(D_PER_CODE,new Integer(7) );
  fieldMap.put(DISPO_CONT,new Integer(8) );
  fieldMap.put(DISPO_CAUSE,new Integer(9) );
  fieldMap.put(DISPO_DT,new Integer(10) );
  fieldMap.put(MOT_STE,new Integer(11) );
  fieldMap.put(INS_DT,new Integer(12) );
  fieldMap.put(UPD_DT,new Integer(13) );
  fieldMap.put(WRT_ID,new Integer(14) );
  fieldMap.put(SIDO_CODE,new Integer(15) );
  fieldMap.put(REMARK,new Integer(16) );
  fieldMap.put(LEG_BAS,new Integer(17) );
  fieldMap.put(SND_STE,new Integer(18) );
  fieldMap.put(SND_DT,new Integer(19) );
  fieldMap.put(HOME_NOTE,new Integer(20) );
  fieldMap.put(NOTE_GUID_DT,new Integer(21) );
  fieldMap.put(OFFI_REPORT_DT,new Integer(22) );
  fieldMap.put(ASSO_GUILD_DT,new Integer(23) );
  fieldMap.put(RECV_NUM,new Integer(24) );
  fieldMap.put(DISPO_CONT2,new Integer(25) );
  fieldMap.put(AT_RECV_NUM,new Integer(26) );
  fieldMap.put(MAST_PROC,new Integer(27) );
  fieldMap.put(BUSISUSP_START_DT,new Integer(28) );
  fieldMap.put(BUSISUSP_END_DT,new Integer(29) );
  fieldMap.put(DOC_CODE,new Integer(30) );
  fieldMap.put(PUNISHMENT_AGENCY,new Integer(31) );
  fieldMap.put(DISPO_CONT_NM,new Integer(32) );
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_M_MASTER_TEMP";
     final public static String PREFIX = "sp.dao.PT_M_MASTER_TEMP";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
        };
     final public static String FIELD_LIST[] = { 
       TMP_WRT_NUM,WRT_NUM,WRT_DT,REGR,VIOL_CONT_CODE,VIOL_DT,D_PER_CODE,DISPO_CONT,DISPO_CAUSE,DISPO_DT,MOT_STE,INS_DT,UPD_DT,WRT_ID,SIDO_CODE,REMARK,LEG_BAS,SND_STE,SND_DT,HOME_NOTE,NOTE_GUID_DT,OFFI_REPORT_DT,ASSO_GUILD_DT,RECV_NUM,DISPO_CONT2,AT_RECV_NUM,MAST_PROC,BUSISUSP_START_DT,BUSISUSP_END_DT,DOC_CODE,PUNISHMENT_AGENCY,DISPO_CONT_NM };
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
             case 27 : 
	                  return  "";
             case 28 : 
	                  return  "";
             case 29 : 
	                  return  "";
             case 30 : 
	                  return  "";
             case 31 : 
	                  return  "";
             case 32 : 
	                  return  "";
	    }

         return null;
    }

   public static String toXML(PT_M_MASTER_TEMPEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TMP_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getTMP_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_NUM").append("'")
            .append(" value='").append(""+ent.getWRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_DT").append("'")
            .append(" value='").append(""+ent.getWRT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REGR").append("'")
            .append(" value='").append(""+ent.getREGR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("VIOL_CONT_CODE").append("'")
            .append(" value='").append(""+ent.getVIOL_CONT_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("VIOL_DT").append("'")
            .append(" value='").append(""+ent.getVIOL_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("D_PER_CODE").append("'")
            .append(" value='").append(""+ent.getD_PER_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DISPO_CONT").append("'")
            .append(" value='").append(""+ent.getDISPO_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DISPO_CAUSE").append("'")
            .append(" value='").append(""+ent.getDISPO_CAUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DISPO_DT").append("'")
            .append(" value='").append(""+ent.getDISPO_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MOT_STE").append("'")
            .append(" value='").append(""+ent.getMOT_STE()).append("' />\n");
        
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
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REMARK").append("'")
            .append(" value='").append(""+ent.getREMARK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("LEG_BAS").append("'")
            .append(" value='").append(""+ent.getLEG_BAS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SND_STE").append("'")
            .append(" value='").append(""+ent.getSND_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SND_DT").append("'")
            .append(" value='").append(""+ent.getSND_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("HOME_NOTE").append("'")
            .append(" value='").append(""+ent.getHOME_NOTE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NOTE_GUID_DT").append("'")
            .append(" value='").append(""+ent.getNOTE_GUID_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFI_REPORT_DT").append("'")
            .append(" value='").append(""+ent.getOFFI_REPORT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ASSO_GUILD_DT").append("'")
            .append(" value='").append(""+ent.getASSO_GUILD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DISPO_CONT2").append("'")
            .append(" value='").append(""+ent.getDISPO_CONT2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AT_RECV_NUM").append("'")
            .append(" value='").append(""+ent.getAT_RECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MAST_PROC").append("'")
            .append(" value='").append(""+ent.getMAST_PROC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BUSISUSP_START_DT").append("'")
            .append(" value='").append(""+ent.getBUSISUSP_START_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BUSISUSP_END_DT").append("'")
            .append(" value='").append(""+ent.getBUSISUSP_END_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_CODE").append("'")
            .append(" value='").append(""+ent.getDOC_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PUNISHMENT_AGENCY").append("'")
            .append(" value='").append(""+ent.getPUNISHMENT_AGENCY()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DISPO_CONT_NM").append("'")
            .append(" value='").append(""+ent.getDISPO_CONT_NM()).append("' />\n");
        

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
