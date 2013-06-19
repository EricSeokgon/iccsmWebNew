

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_CONSTRUCTION
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               RECV_NUM  
*               SIDO_CODE  
*               SIDO_CODE  
*               SIGUNGU_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               ORPE_NM:VARCHAR2(50):  
*               ORPE_TEL:VARCHAR2(24):  
*               ORPE_POSTNUM:VARCHAR2(16):  
*               ORPE_ADDR:VARCHAR2(64):  
*               ORPE_DETAILADDR:VARCHAR2(128):  
*               PLANER_NAME:VARCHAR2(100):  
*               PLANER_NM:VARCHAR2(50):  
*               PLANER_TEL:VARCHAR2(24):  
*               PLANER_POSTNUM:VARCHAR2(16):  
*               PLANER_ADDR:VARCHAR2(64):  
*               PLANER_DETAILADDR:VARCHAR2(128):  
*               RECV_DT:VARCHAR2(24):  
*               STRU_COMMIT_NUM:VARCHAR2(50):  
*               STRU_ADDR_POSTNUM:VARCHAR2(16):  
*               STRU_ADDR_ADDR:VARCHAR2(64):  
*               STRU_ADDR_DETAILADDR:VARCHAR2(128):  
*               USE:VARCHAR2(100):  
*               AREA:VARCHAR2(10):  
*               NUM_FL:VARCHAR2(200):  
*               WORK_ITEM:VARCHAR2(250):  
*               STE:VARCHAR2(5):  
*               SUV_APPL:VARCHAR2(25):  
*               CONFIRMER_NM:VARCHAR2(25):  
*               CONFIRMER_POSI:VARCHAR2(50):  
*               CONFIRMER_TEL:VARCHAR2(24):  
*               INSP_OPIN:VARCHAR2(200):  
*               PRE_ITEM:VARCHAR2(500):  
*               SW_BEF_REPO_DELINUM:VARCHAR2(40):  
*               REPO_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               CIV_RECV_NUM:VARCHAR2(20):  
*               SIDO_CODE:VARCHAR2(5):  
*               SIGUNGU_CODE:VARCHAR2(6):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               RECV_NUM:VARCHAR2(12):  
*               INSP_BAS:VARCHAR2(255):  
*               CER_DELI_NUM:VARCHAR2(26):  
*               CER_DELI_CONFIRM:VARCHAR2(15):  
*               INSP_APPL_DT:VARCHAR2(24):  
*               PROC_STE:VARCHAR2(4):  
*               CER_DELI_YN:VARCHAR2(4):  
*               PROC_OFFI_NM:VARCHAR2(20):  
*               WORK_ITEM_ETC:VARCHAR2(200):  
*               ETC_INSP_BAS:VARCHAR2(200):  
*               UPD_DT_OLD:VARCHAR2(24):  
*               BACKUP_TRANS_DT:VARCHAR2(24):  
*               CONFIRMER_OFFI_ID:VARCHAR2(20):  
*               CHG_INSP:VARCHAR2(4):  
*               STRU_INFO_BIGO:VARCHAR2(4):  
*               USE_ETC:VARCHAR2(256):  
*               ORPE_NM:VARCHAR2(50):  
*               ORPE_TEL:VARCHAR2(24):  
*               ORPE_POSTNUM:VARCHAR2(16):  
*               ORPE_ADDR:VARCHAR2(64):  
*               ORPE_DETAILADDR:VARCHAR2(128):  
*               PLANER_NAME:VARCHAR2(100):  
*               PLANER_NM:VARCHAR2(50):  
*               PLANER_TEL:VARCHAR2(24):  
*               PLANER_POSTNUM:VARCHAR2(16):  
*               PLANER_ADDR:VARCHAR2(64):  
*               PLANER_DETAILADDR:VARCHAR2(128):  
*               RECV_DT:VARCHAR2(24):  
*               STRU_COMMIT_NUM:VARCHAR2(50):  
*               STRU_ADDR_POSTNUM:VARCHAR2(16):  
*               STRU_ADDR_ADDR:VARCHAR2(64):  
*               STRU_ADDR_DETAILADDR:VARCHAR2(128):  
*               USE:VARCHAR2(100):  
*               AREA:VARCHAR2(10):  
*               NUM_FL:VARCHAR2(200):  
*               WORK_ITEM:VARCHAR2(250):  
*               STE:VARCHAR2(5):  
*               SUV_APPL:VARCHAR2(25):  
*               CONFIRMER_NM:VARCHAR2(25):  
*               CONFIRMER_POSI:VARCHAR2(50):  
*               CONFIRMER_TEL:VARCHAR2(24):  
*               INSP_OPIN:VARCHAR2(200):  
*               PRE_ITEM:VARCHAR2(500):  
*               SW_BEF_REPO_DELINUM:VARCHAR2(40):  
*               REPO_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               CIV_RECV_NUM:VARCHAR2(20):  
*               SIDO_CODE:VARCHAR2(5):  
*               SIGUNGU_CODE:VARCHAR2(6):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               RECV_NUM:VARCHAR2(12):  
*               INSP_BAS:VARCHAR2(255):  
*               CER_DELI_NUM:VARCHAR2(26):  
*               CER_DELI_CONFIRM:VARCHAR2(15):  
*               INSP_APPL_DT:VARCHAR2(24):  
*               PROC_STE:VARCHAR2(4):  
*               CER_DELI_YN:VARCHAR2(4):  
*               PROC_OFFI_NM:VARCHAR2(20):  
*               WORK_ITEM_ETC:VARCHAR2(200):  
*               ETC_INSP_BAS:VARCHAR2(200):  
*               UPD_DT_OLD:VARCHAR2(24):  
*               BACKUP_TRANS_DT:VARCHAR2(24):  
*               CONFIRMER_OFFI_ID:VARCHAR2(20):  
*               CHG_INSP:VARCHAR2(1):  
*               STRU_INFO_BIGO:VARCHAR2(1):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_UB_CONSTRUCTIONHelper{

  final static public String ORPE_NM = "ORPE_NM";
  final static public String ORPE_TEL = "ORPE_TEL";
  final static public String ORPE_POSTNUM = "ORPE_POSTNUM";
  final static public String ORPE_ADDR = "ORPE_ADDR";
  final static public String ORPE_DETAILADDR = "ORPE_DETAILADDR";
  final static public String PLANER_NAME = "PLANER_NAME";
  final static public String PLANER_NM = "PLANER_NM";
  final static public String PLANER_TEL = "PLANER_TEL";
  final static public String PLANER_POSTNUM = "PLANER_POSTNUM";
  final static public String PLANER_ADDR = "PLANER_ADDR";
  final static public String PLANER_DETAILADDR = "PLANER_DETAILADDR";
  final static public String RECV_DT = "RECV_DT";
  final static public String STRU_COMMIT_NUM = "STRU_COMMIT_NUM";
  final static public String STRU_ADDR_POSTNUM = "STRU_ADDR_POSTNUM";
  final static public String STRU_ADDR_ADDR = "STRU_ADDR_ADDR";
  final static public String STRU_ADDR_DETAILADDR = "STRU_ADDR_DETAILADDR";
  final static public String USE = "USE";
  final static public String AREA = "AREA";
  final static public String NUM_FL = "NUM_FL";
  final static public String WORK_ITEM = "WORK_ITEM";
  final static public String STE = "STE";
  final static public String SUV_APPL = "SUV_APPL";
  final static public String CONFIRMER_NM = "CONFIRMER_NM";
  final static public String CONFIRMER_POSI = "CONFIRMER_POSI";
  final static public String CONFIRMER_TEL = "CONFIRMER_TEL";
  final static public String INSP_OPIN = "INSP_OPIN";
  final static public String PRE_ITEM = "PRE_ITEM";
  final static public String SW_BEF_REPO_DELINUM = "SW_BEF_REPO_DELINUM";
  final static public String REPO_DT = "REPO_DT";
  final static public String WRT_ID = "WRT_ID";
  final static public String CIV_RECV_NUM = "CIV_RECV_NUM";
  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String INSP_BAS = "INSP_BAS";
  final static public String CER_DELI_NUM = "CER_DELI_NUM";
  final static public String CER_DELI_CONFIRM = "CER_DELI_CONFIRM";
  final static public String INSP_APPL_DT = "INSP_APPL_DT";
  final static public String PROC_STE = "PROC_STE";
  final static public String CER_DELI_YN = "CER_DELI_YN";
  final static public String PROC_OFFI_NM = "PROC_OFFI_NM";
  final static public String WORK_ITEM_ETC = "WORK_ITEM_ETC";
  final static public String ETC_INSP_BAS = "ETC_INSP_BAS";
  final static public String UPD_DT_OLD = "UPD_DT_OLD";
  final static public String BACKUP_TRANS_DT = "BACKUP_TRANS_DT";
  final static public String CONFIRMER_OFFI_ID = "CONFIRMER_OFFI_ID";
  final static public String CHG_INSP = "CHG_INSP";
  final static public String STRU_INFO_BIGO = "STRU_INFO_BIGO";
  final static public String USE_ETC = "USE_ETC";
    


  public static HashMap fieldMap = new HashMap(101);
  static{
  fieldMap.put(ORPE_NM,new Integer(1) );
  fieldMap.put(ORPE_TEL,new Integer(2) );
  fieldMap.put(ORPE_POSTNUM,new Integer(3) );
  fieldMap.put(ORPE_ADDR,new Integer(4) );
  fieldMap.put(ORPE_DETAILADDR,new Integer(5) );
  fieldMap.put(PLANER_NAME,new Integer(6) );
  fieldMap.put(PLANER_NM,new Integer(7) );
  fieldMap.put(PLANER_TEL,new Integer(8) );
  fieldMap.put(PLANER_POSTNUM,new Integer(9) );
  fieldMap.put(PLANER_ADDR,new Integer(10) );
  fieldMap.put(PLANER_DETAILADDR,new Integer(11) );
  fieldMap.put(RECV_DT,new Integer(12) );
  fieldMap.put(STRU_COMMIT_NUM,new Integer(13) );
  fieldMap.put(STRU_ADDR_POSTNUM,new Integer(14) );
  fieldMap.put(STRU_ADDR_ADDR,new Integer(15) );
  fieldMap.put(STRU_ADDR_DETAILADDR,new Integer(16) );
  fieldMap.put(USE,new Integer(17) );
  fieldMap.put(AREA,new Integer(18) );
  fieldMap.put(NUM_FL,new Integer(19) );
  fieldMap.put(WORK_ITEM,new Integer(20) );
  fieldMap.put(STE,new Integer(21) );
  fieldMap.put(SUV_APPL,new Integer(22) );
  fieldMap.put(CONFIRMER_NM,new Integer(23) );
  fieldMap.put(CONFIRMER_POSI,new Integer(24) );
  fieldMap.put(CONFIRMER_TEL,new Integer(25) );
  fieldMap.put(INSP_OPIN,new Integer(26) );
  fieldMap.put(PRE_ITEM,new Integer(27) );
  fieldMap.put(SW_BEF_REPO_DELINUM,new Integer(28) );
  fieldMap.put(REPO_DT,new Integer(29) );
  fieldMap.put(WRT_ID,new Integer(30) );
  fieldMap.put(CIV_RECV_NUM,new Integer(31) );
  fieldMap.put(SIDO_CODE,new Integer(32) );
  fieldMap.put(SIGUNGU_CODE,new Integer(33) );
  fieldMap.put(INS_DT,new Integer(34) );
  fieldMap.put(UPD_DT,new Integer(35) );
  fieldMap.put(RECV_NUM,new Integer(36) );
  fieldMap.put(INSP_BAS,new Integer(37) );
  fieldMap.put(CER_DELI_NUM,new Integer(38) );
  fieldMap.put(CER_DELI_CONFIRM,new Integer(39) );
  fieldMap.put(INSP_APPL_DT,new Integer(40) );
  fieldMap.put(PROC_STE,new Integer(41) );
  fieldMap.put(CER_DELI_YN,new Integer(42) );
  fieldMap.put(PROC_OFFI_NM,new Integer(43) );
  fieldMap.put(WORK_ITEM_ETC,new Integer(44) );
  fieldMap.put(ETC_INSP_BAS,new Integer(45) );
  fieldMap.put(UPD_DT_OLD,new Integer(46) );
  fieldMap.put(BACKUP_TRANS_DT,new Integer(47) );
  fieldMap.put(CONFIRMER_OFFI_ID,new Integer(48) );
  fieldMap.put(CHG_INSP,new Integer(49) );
  fieldMap.put(STRU_INFO_BIGO,new Integer(50) );
  fieldMap.put(USE_ETC,new Integer(51) );
    
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_UB_CONSTRUCTION";
     final public static String PREFIX = "sp.dao.PT_UB_CONSTRUCTION";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SIDO_CODE,SIGUNGU_CODE };
     final public static String FIELD_LIST[] = { 
       ORPE_NM,ORPE_TEL,ORPE_POSTNUM,ORPE_ADDR,ORPE_DETAILADDR,PLANER_NAME,PLANER_NM,PLANER_TEL,PLANER_POSTNUM,PLANER_ADDR,PLANER_DETAILADDR,RECV_DT,STRU_COMMIT_NUM,STRU_ADDR_POSTNUM,STRU_ADDR_ADDR,STRU_ADDR_DETAILADDR,USE,AREA,NUM_FL,WORK_ITEM,STE,SUV_APPL,CONFIRMER_NM,CONFIRMER_POSI,CONFIRMER_TEL,INSP_OPIN,PRE_ITEM,SW_BEF_REPO_DELINUM,REPO_DT,WRT_ID,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,INS_DT,UPD_DT,RECV_NUM,INSP_BAS,CER_DELI_NUM,CER_DELI_CONFIRM,INSP_APPL_DT,PROC_STE,CER_DELI_YN,PROC_OFFI_NM,WORK_ITEM_ETC,ETC_INSP_BAS,UPD_DT_OLD,BACKUP_TRANS_DT,CONFIRMER_OFFI_ID,CHG_INSP,STRU_INFO_BIGO,USE_ETC };
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
             case 33 : 
	                  return  "";
             case 34 : 
	                  return  "";
             case 35 : 
	                  return  "";
             case 36 : 
	                  return  "";
             case 37 : 
	                  return  "";
             case 38 : 
	                  return  "";
             case 39 : 
	                  return  "";
             case 40 : 
	                  return  "";
             case 41 : 
	                  return  "";
             case 42 : 
	                  return  "";
             case 43 : 
	                  return  "";
             case 44 : 
	                  return  "";
             case 45 : 
	                  return  "";
             case 46 : 
	                  return  "";
             case 47 : 
	                  return  "";
             case 48 : 
	                  return  "";
             case 49 : 
	                  return  "";
             case 50 : 
	                  return  "";
             case 51 : 
	                  return  "";
        	    }

         return null;
    }

   public static String toXML(PT_UB_CONSTRUCTIONEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORPE_NM").append("'")
            .append(" value='").append(""+ent.getORPE_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORPE_TEL").append("'")
            .append(" value='").append(""+ent.getORPE_TEL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORPE_POSTNUM").append("'")
            .append(" value='").append(""+ent.getORPE_POSTNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORPE_ADDR").append("'")
            .append(" value='").append(""+ent.getORPE_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ORPE_DETAILADDR").append("'")
            .append(" value='").append(""+ent.getORPE_DETAILADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLANER_NAME").append("'")
            .append(" value='").append(""+ent.getPLANER_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLANER_NM").append("'")
            .append(" value='").append(""+ent.getPLANER_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLANER_TEL").append("'")
            .append(" value='").append(""+ent.getPLANER_TEL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLANER_POSTNUM").append("'")
            .append(" value='").append(""+ent.getPLANER_POSTNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLANER_ADDR").append("'")
            .append(" value='").append(""+ent.getPLANER_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLANER_DETAILADDR").append("'")
            .append(" value='").append(""+ent.getPLANER_DETAILADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_DT").append("'")
            .append(" value='").append(""+ent.getRECV_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STRU_COMMIT_NUM").append("'")
            .append(" value='").append(""+ent.getSTRU_COMMIT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STRU_ADDR_POSTNUM").append("'")
            .append(" value='").append(""+ent.getSTRU_ADDR_POSTNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STRU_ADDR_ADDR").append("'")
            .append(" value='").append(""+ent.getSTRU_ADDR_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STRU_ADDR_DETAILADDR").append("'")
            .append(" value='").append(""+ent.getSTRU_ADDR_DETAILADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE").append("'")
            .append(" value='").append(""+ent.getUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AREA").append("'")
            .append(" value='").append(""+ent.getAREA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NUM_FL").append("'")
            .append(" value='").append(""+ent.getNUM_FL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WORK_ITEM").append("'")
            .append(" value='").append(""+ent.getWORK_ITEM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STE").append("'")
            .append(" value='").append(""+ent.getSTE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV_APPL").append("'")
            .append(" value='").append(""+ent.getSUV_APPL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONFIRMER_NM").append("'")
            .append(" value='").append(""+ent.getCONFIRMER_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONFIRMER_POSI").append("'")
            .append(" value='").append(""+ent.getCONFIRMER_POSI()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONFIRMER_TEL").append("'")
            .append(" value='").append(""+ent.getCONFIRMER_TEL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_OPIN").append("'")
            .append(" value='").append(""+ent.getINSP_OPIN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PRE_ITEM").append("'")
            .append(" value='").append(""+ent.getPRE_ITEM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SW_BEF_REPO_DELINUM").append("'")
            .append(" value='").append(""+ent.getSW_BEF_REPO_DELINUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REPO_DT").append("'")
            .append(" value='").append(""+ent.getREPO_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CIV_RECV_NUM").append("'")
            .append(" value='").append(""+ent.getCIV_RECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_BAS").append("'")
            .append(" value='").append(""+ent.getINSP_BAS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CER_DELI_NUM").append("'")
            .append(" value='").append(""+ent.getCER_DELI_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CER_DELI_CONFIRM").append("'")
            .append(" value='").append(""+ent.getCER_DELI_CONFIRM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_APPL_DT").append("'")
            .append(" value='").append(""+ent.getINSP_APPL_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_STE").append("'")
            .append(" value='").append(""+ent.getPROC_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CER_DELI_YN").append("'")
            .append(" value='").append(""+ent.getCER_DELI_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_OFFI_NM").append("'")
            .append(" value='").append(""+ent.getPROC_OFFI_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WORK_ITEM_ETC").append("'")
            .append(" value='").append(""+ent.getWORK_ITEM_ETC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC_INSP_BAS").append("'")
            .append(" value='").append(""+ent.getETC_INSP_BAS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT_OLD").append("'")
            .append(" value='").append(""+ent.getUPD_DT_OLD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BACKUP_TRANS_DT").append("'")
            .append(" value='").append(""+ent.getBACKUP_TRANS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CONFIRMER_OFFI_ID").append("'")
            .append(" value='").append(""+ent.getCONFIRMER_OFFI_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHG_INSP").append("'")
            .append(" value='").append(""+ent.getCHG_INSP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("STRU_INFO_BIGO").append("'")
            .append(" value='").append(""+ent.getSTRU_INFO_BIGO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_ETC").append("'")
            .append(" value='").append(""+ent.getUSE_ETC()).append("' />\n");

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
