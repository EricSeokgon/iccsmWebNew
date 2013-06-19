

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_USEBEFORE
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               RECV_NUM  
*               SIDO_CODE  
*               SIDO_CODE  
*               SIGUNGU_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               SIDO_CODE:VARCHAR2(5):  
*               SIGUNGU_CODE:VARCHAR2(6):  
*               APPLPER_NM:VARCHAR2(50):  
*               APPLPER_REP:VARCHAR2(50):  
*               APPLPER_POSTNUM:VARCHAR2(16):  
*               APPLPER_ADDR:VARCHAR2(100):  
*               APPLPER_DETAILADDR:VARCHAR2(128):  
*               APPLPER_TELNUM:VARCHAR2(24):  
*               OPE_NAME:VARCHAR2(100):  
*               OPE_REP:VARCHAR2(24):  
*               OPE_TELNUM:VARCHAR2(24):  
*               COI_WRT_NUM:VARCHAR2(24):  
*               OPE_POSTNUM:VARCHAR2(16):  
*               OPE_ADDR:VARCHAR2(100):  
*               OPE_DETAILADDR:VARCHAR2(128):  
*               INSP_SPOT_NM:VARCHAR2(100):  
*               INSP_SPOT_POSTNUM:VARCHAR2(16):  
*               INSP_SPOT_ADDR:VARCHAR2(100):  
*               INSP_SPOT_DETAILADDR:VARCHAR2(128):  
*               PLANER_NM:VARCHAR2(26):  
*               WORK_ITEM:VARCHAR2(250):  
*               AREA:VARCHAR2(10):  
*               NUM_FL:VARCHAR2(200):  
*               USE:VARCHAR2(100):  
*               INSP_APPL_WORK:VARCHAR2(200):  
*               INSP_APPL_DT:VARCHAR2(24):  
*               INSP_DT:VARCHAR2(24):  
*               INSP_FEE:VARCHAR2(26):  
*               INSPER_NM:VARCHAR2(50):  
*               INSPER_POSI:VARCHAR2(50):  
*               JUDGM:VARCHAR2(255):  
*               PLAN_CONFIRM_YN:VARCHAR2(5):  
*               SW_BEF_REPO_DELINUM:VARCHAR2(50):  
*               SW_DT:VARCHAR2(24):  
*               EW_DT:VARCHAR2(24):  
*               INSP_WISH_YMD:VARCHAR2(24):  
*               OFFI_TELNUM:VARCHAR2(26):  
*               OFFI_NM:VARCHAR2(60):  
*               USEBEFINSP_DELINUM:VARCHAR2(50):  
*               SUV:VARCHAR2(100):  
*               REMARK:VARCHAR2(255):  
*               CER_DELI_YN:VARCHAR2(5):  
*               PLAN_CONFIRM_REMARK:VARCHAR2(255):  
*               NAPPL_YN:VARCHAR2(20):  
*               NAPPL_CAUSE:VARCHAR2(100):  
*               DOC_INSP_REMARK:VARCHAR2(255):  
*               WRT_ID:VARCHAR2(50):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               CIV_RECV_NUM:VARCHAR2(100):  
*               RECV_DT:VARCHAR2(8):  
*               PLAN_CONFIRM_PER_YN:VARCHAR2(100):  
*               PLAN_ENT_CHG_YN:VARCHAR2(200):  
*               PLAN_CONT_CHG_YN:VARCHAR2(200):  
*               RECV_NUM:VARCHAR2(100):  
*               ATT_DOC:VARCHAR2(250):  
*               DELI_DT:VARCHAR2(24):  
*               DEFI_YN:VARCHAR2(4):  
*               PROC_STE:VARCHAR2(4):  
*               ISSUE_ITEM:VARCHAR2(4):  
*               NET_RECV_YN:VARCHAR2(4):  
*               PROC_LIM:VARCHAR2(24):  
*               INSP_NUM:VARCHAR2(20):  
*               PROC_OFFI:VARCHAR2(20):  
*               PLAN_CONFIRM_PER_YN_CONT:VARCHAR2(200):  
*               PLAN_ENT_CHG_YN_CONT:VARCHAR2(200):  
*               PLAN_CONT_CHG_YN_CONT:VARCHAR2(200):  
*               CHG_INSP:VARCHAR2(10):  
*               INSP_ITEM:VARCHAR2(5):  
*               ETC_INSP_BAS:VARCHAR2(200):  
*               WORK_ITEM_ETC:VARCHAR2(200):  
*               UPD_DT_OLD:VARCHAR2(24):  
*               BACKUP_TRANS_DT:VARCHAR2(24):  
*               TAKE_TM:VARCHAR2(24):  
*               USER_NAME:VARCHAR2(255):  
*               MW_PPS_GETR_ID:VARCHAR2(255):  
*               OUTVARS:VARCHAR2(255):  
*               MW_AFR_SHTNM:VARCHAR2(255):  
*               MW_SE:VARCHAR2(255):  
*               MW_CODE_CN:VARCHAR2(255):  
*               TAKE_CONFRM_CODE:VARCHAR2(255):  
*               DEAL_SE:VARCHAR2(255):  
*               DEAL_CODE_CN:VARCHAR2(255):  
*               TAKE_SE:VARCHAR2(255):  
*               TAKE_CODE_CN:VARCHAR2(255):  
*               REAL_DEAL_YMD:VARCHAR2(255):  
*               MW_TAKE_NO:VARCHAR2(30):  
*               ETC1:VARCHAR2(50):  
*               ETC2:VARCHAR2(50):  
*               ETC3:VARCHAR2(50):  
*               BEF_PLANER_NAME:VARCHAR2(50):  
*               PROC_OFFI_ID:VARCHAR2(20):  
*               ADMIT_DT:VARCHAR2(8):  
*               USE_ETC:VARCHAR2(256):  
*               SIDO_CODE:VARCHAR2(5):  
*               SIGUNGU_CODE:VARCHAR2(6):  
*               APPLPER_NM:VARCHAR2(50):  
*               APPLPER_REP:VARCHAR2(24):  
*               APPLPER_POSTNUM:VARCHAR2(16):  
*               APPLPER_ADDR:VARCHAR2(100):  
*               APPLPER_DETAILADDR:VARCHAR2(128):  
*               APPLPER_TELNUM:VARCHAR2(24):  
*               OPE_NAME:VARCHAR2(100):  
*               OPE_REP:VARCHAR2(24):  
*               OPE_TELNUM:VARCHAR2(24):  
*               COI_WRT_NUM:VARCHAR2(24):  
*               OPE_POSTNUM:VARCHAR2(16):  
*               OPE_ADDR:VARCHAR2(100):  
*               OPE_DETAILADDR:VARCHAR2(128):  
*               INSP_SPOT_NM:VARCHAR2(100):  
*               INSP_SPOT_POSTNUM:VARCHAR2(16):  
*               INSP_SPOT_ADDR:VARCHAR2(100):  
*               INSP_SPOT_DETAILADDR:VARCHAR2(128):  
*               PLANER_NM:VARCHAR2(26):  
*               WORK_ITEM:VARCHAR2(250):  
*               AREA:VARCHAR2(10):  
*               NUM_FL:VARCHAR2(200):  
*               USE:VARCHAR2(100):  
*               INSP_APPL_WORK:VARCHAR2(200):  
*               INSP_APPL_DT:VARCHAR2(24):  
*               INSP_DT:VARCHAR2(24):  
*               INSP_FEE:VARCHAR2(26):  
*               INSPER_NM:VARCHAR2(50):  
*               INSPER_POSI:VARCHAR2(50):  
*               JUDGM:VARCHAR2(255):  
*               PLAN_CONFIRM_YN:VARCHAR2(5):  
*               SW_BEF_REPO_DELINUM:VARCHAR2(50):  
*               SW_DT:VARCHAR2(24):  
*               EW_DT:VARCHAR2(24):  
*               INSP_WISH_YMD:VARCHAR2(24):  
*               OFFI_TELNUM:VARCHAR2(26):  
*               OFFI_NM:VARCHAR2(60):  
*               USEBEFINSP_DELINUM:VARCHAR2(50):  
*               SUV:VARCHAR2(100):  
*               REMARK:VARCHAR2(255):  
*               CER_DELI_YN:VARCHAR2(5):  
*               PLAN_CONFIRM_REMARK:VARCHAR2(255):  
*               NAPPL_YN:VARCHAR2(20):  
*               NAPPL_CAUSE:VARCHAR2(100):  
*               DOC_INSP_REMARK:VARCHAR2(255):  
*               WRT_ID:VARCHAR2(50):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               CIV_RECV_NUM:VARCHAR2(100):  
*               RECV_DT:VARCHAR2(8):  
*               PLAN_CONFIRM_PER_YN:VARCHAR2(100):  
*               PLAN_ENT_CHG_YN:VARCHAR2(200):  
*               PLAN_CONT_CHG_YN:VARCHAR2(200):  
*               RECV_NUM:VARCHAR2(30):  
*               ATT_DOC:VARCHAR2(250):  
*               DELI_DT:VARCHAR2(24):  
*               DEFI_YN:VARCHAR2(4):  
*               PROC_STE:VARCHAR2(4):  
*               ISSUE_ITEM:VARCHAR2(4):  
*               NET_RECV_YN:VARCHAR2(4):  
*               PROC_LIM:VARCHAR2(24):  
*               INSP_NUM:VARCHAR2(20):  
*               PROC_OFFI:VARCHAR2(20):  
*               PLAN_CONFIRM_PER_YN_CONT:VARCHAR2(200):  
*               PLAN_ENT_CHG_YN_CONT:VARCHAR2(200):  
*               PLAN_CONT_CHG_YN_CONT:VARCHAR2(200):  
*               CHG_INSP:VARCHAR2(10):  
*               INSP_ITEM:VARCHAR2(5):  
*               ETC_INSP_BAS:VARCHAR2(200):  
*               WORK_ITEM_ETC:VARCHAR2(200):  
*               UPD_DT_OLD:VARCHAR2(24):  
*               BACKUP_TRANS_DT:VARCHAR2(24):  
*               TAKE_TM:VARCHAR2(24):  
*               USER_NAME:VARCHAR2(255):  
*               MW_PPS_GETR_ID:VARCHAR2(255):  
*               OUTVARS:VARCHAR2(255):  
*               MW_AFR_SHTNM:VARCHAR2(255):  
*               MW_SE:VARCHAR2(255):  
*               MW_CODE_CN:VARCHAR2(255):  
*               TAKE_CONFRM_CODE:VARCHAR2(255):  
*               DEAL_SE:VARCHAR2(255):  
*               DEAL_CODE_CN:VARCHAR2(255):  
*               TAKE_SE:VARCHAR2(255):  
*               TAKE_CODE_CN:VARCHAR2(255):  
*               REAL_DEAL_YMD:VARCHAR2(255):  
*               MW_TAKE_NO:VARCHAR2(30):  
*               ETC1:VARCHAR2(50):  
*               ETC2:VARCHAR2(50):  
*               ETC3:VARCHAR2(50):  
*               BEF_PLANER_NAME:VARCHAR2(50):  
*               PROC_OFFI_ID:VARCHAR2(20):  
*               ADMIT_DT:VARCHAR2(8):
*/
package sp.dao;


import kjf.ops.*;

import java.util.*;

public class PT_UB_USEBEFOREHelper{

  final static public String SIDO_CODE = "SIDO_CODE";
  final static public String SIGUNGU_CODE = "SIGUNGU_CODE";
  final static public String APPLPER_NM = "APPLPER_NM";
  final static public String APPLPER_REP = "APPLPER_REP";
  final static public String APPLPER_POSTNUM = "APPLPER_POSTNUM";
  final static public String APPLPER_ADDR = "APPLPER_ADDR";
  final static public String APPLPER_DETAILADDR = "APPLPER_DETAILADDR";
  final static public String APPLPER_TELNUM = "APPLPER_TELNUM";
  final static public String OPE_NAME = "OPE_NAME";
  final static public String OPE_REP = "OPE_REP";
  final static public String OPE_TELNUM = "OPE_TELNUM";
  final static public String COI_WRT_NUM = "COI_WRT_NUM";
  final static public String OPE_POSTNUM = "OPE_POSTNUM";
  final static public String OPE_ADDR = "OPE_ADDR";
  final static public String OPE_DETAILADDR = "OPE_DETAILADDR";
  final static public String INSP_SPOT_NM = "INSP_SPOT_NM";
  final static public String INSP_SPOT_POSTNUM = "INSP_SPOT_POSTNUM";
  final static public String INSP_SPOT_ADDR = "INSP_SPOT_ADDR";
  final static public String INSP_SPOT_DETAILADDR = "INSP_SPOT_DETAILADDR";
  final static public String PLANER_NM = "PLANER_NM";
  final static public String WORK_ITEM = "WORK_ITEM";
  final static public String AREA = "AREA";
  final static public String NUM_FL = "NUM_FL";
  final static public String USE = "USE";
  final static public String INSP_APPL_WORK = "INSP_APPL_WORK";
  final static public String INSP_APPL_DT = "INSP_APPL_DT";
  final static public String INSP_DT = "INSP_DT";
  final static public String INSP_FEE = "INSP_FEE";
  final static public String INSPER_NM = "INSPER_NM";
  final static public String INSPER_POSI = "INSPER_POSI";
  final static public String JUDGM = "JUDGM";
  final static public String PLAN_CONFIRM_YN = "PLAN_CONFIRM_YN";
  final static public String SW_BEF_REPO_DELINUM = "SW_BEF_REPO_DELINUM";
  final static public String SW_DT = "SW_DT";
  final static public String EW_DT = "EW_DT";
  final static public String INSP_WISH_YMD = "INSP_WISH_YMD";
  final static public String OFFI_TELNUM = "OFFI_TELNUM";
  final static public String OFFI_NM = "OFFI_NM";
  final static public String USEBEFINSP_DELINUM = "USEBEFINSP_DELINUM";
  final static public String SUV = "SUV";
  final static public String REMARK = "REMARK";
  final static public String CER_DELI_YN = "CER_DELI_YN";
  final static public String PLAN_CONFIRM_REMARK = "PLAN_CONFIRM_REMARK";
  final static public String NAPPL_YN = "NAPPL_YN";
  final static public String NAPPL_CAUSE = "NAPPL_CAUSE";
  final static public String DOC_INSP_REMARK = "DOC_INSP_REMARK";
  final static public String WRT_ID = "WRT_ID";
  final static public String INS_DT = "INS_DT";
  final static public String UPD_DT = "UPD_DT";
  final static public String CIV_RECV_NUM = "CIV_RECV_NUM";
  final static public String RECV_DT = "RECV_DT";
  final static public String PLAN_CONFIRM_PER_YN = "PLAN_CONFIRM_PER_YN";
  final static public String PLAN_ENT_CHG_YN = "PLAN_ENT_CHG_YN";
  final static public String PLAN_CONT_CHG_YN = "PLAN_CONT_CHG_YN";
  final static public String RECV_NUM = "RECV_NUM";
  final static public String ATT_DOC = "ATT_DOC";
  final static public String DELI_DT = "DELI_DT";
  final static public String DEFI_YN = "DEFI_YN";
  final static public String PROC_STE = "PROC_STE";
  final static public String ISSUE_ITEM = "ISSUE_ITEM";
  final static public String NET_RECV_YN = "NET_RECV_YN";
  final static public String PROC_LIM = "PROC_LIM";
  final static public String INSP_NUM = "INSP_NUM";
  final static public String PROC_OFFI = "PROC_OFFI";
  final static public String PLAN_CONFIRM_PER_YN_CONT = "PLAN_CONFIRM_PER_YN_CONT";
  final static public String PLAN_ENT_CHG_YN_CONT = "PLAN_ENT_CHG_YN_CONT";
  final static public String PLAN_CONT_CHG_YN_CONT = "PLAN_CONT_CHG_YN_CONT";
  final static public String CHG_INSP = "CHG_INSP";
  final static public String INSP_ITEM = "INSP_ITEM";
  final static public String ETC_INSP_BAS = "ETC_INSP_BAS";
  final static public String WORK_ITEM_ETC = "WORK_ITEM_ETC";
  final static public String UPD_DT_OLD = "UPD_DT_OLD";
  final static public String BACKUP_TRANS_DT = "BACKUP_TRANS_DT";
  final static public String TAKE_TM = "TAKE_TM";
  final static public String USER_NAME = "USER_NAME";
  final static public String MW_PPS_GETR_ID = "MW_PPS_GETR_ID";
  final static public String OUTVARS = "OUTVARS";
  final static public String MW_AFR_SHTNM = "MW_AFR_SHTNM";
  final static public String MW_SE = "MW_SE";
  final static public String MW_CODE_CN = "MW_CODE_CN";
  final static public String TAKE_CONFRM_CODE = "TAKE_CONFRM_CODE";
  final static public String DEAL_SE = "DEAL_SE";
  final static public String DEAL_CODE_CN = "DEAL_CODE_CN";
  final static public String TAKE_SE = "TAKE_SE";
  final static public String TAKE_CODE_CN = "TAKE_CODE_CN";
  final static public String REAL_DEAL_YMD = "REAL_DEAL_YMD";
  final static public String MW_TAKE_NO = "MW_TAKE_NO";
  final static public String ETC1 = "ETC1";
  final static public String ETC2 = "ETC2";
  final static public String ETC3 = "ETC3";
  final static public String BEF_PLANER_NAME = "BEF_PLANER_NAME";
  final static public String PROC_OFFI_ID = "PROC_OFFI_ID";
  final static public String ADMIT_DT = "ADMIT_DT";
  final static public String USE_ETC = "USE_ETC";
    


  public static HashMap fieldMap = new HashMap(187);
  static{
  fieldMap.put(SIDO_CODE,new Integer(1) );
  fieldMap.put(SIGUNGU_CODE,new Integer(2) );
  fieldMap.put(APPLPER_NM,new Integer(3) );
  fieldMap.put(APPLPER_REP,new Integer(4) );
  fieldMap.put(APPLPER_POSTNUM,new Integer(5) );
  fieldMap.put(APPLPER_ADDR,new Integer(6) );
  fieldMap.put(APPLPER_DETAILADDR,new Integer(7) );
  fieldMap.put(APPLPER_TELNUM,new Integer(8) );
  fieldMap.put(OPE_NAME,new Integer(9) );
  fieldMap.put(OPE_REP,new Integer(10) );
  fieldMap.put(OPE_TELNUM,new Integer(11) );
  fieldMap.put(COI_WRT_NUM,new Integer(12) );
  fieldMap.put(OPE_POSTNUM,new Integer(13) );
  fieldMap.put(OPE_ADDR,new Integer(14) );
  fieldMap.put(OPE_DETAILADDR,new Integer(15) );
  fieldMap.put(INSP_SPOT_NM,new Integer(16) );
  fieldMap.put(INSP_SPOT_POSTNUM,new Integer(17) );
  fieldMap.put(INSP_SPOT_ADDR,new Integer(18) );
  fieldMap.put(INSP_SPOT_DETAILADDR,new Integer(19) );
  fieldMap.put(PLANER_NM,new Integer(20) );
  fieldMap.put(WORK_ITEM,new Integer(21) );
  fieldMap.put(AREA,new Integer(22) );
  fieldMap.put(NUM_FL,new Integer(23) );
  fieldMap.put(USE,new Integer(24) );
  fieldMap.put(INSP_APPL_WORK,new Integer(25) );
  fieldMap.put(INSP_APPL_DT,new Integer(26) );
  fieldMap.put(INSP_DT,new Integer(27) );
  fieldMap.put(INSP_FEE,new Integer(28) );
  fieldMap.put(INSPER_NM,new Integer(29) );
  fieldMap.put(INSPER_POSI,new Integer(30) );
  fieldMap.put(JUDGM,new Integer(31) );
  fieldMap.put(PLAN_CONFIRM_YN,new Integer(32) );
  fieldMap.put(SW_BEF_REPO_DELINUM,new Integer(33) );
  fieldMap.put(SW_DT,new Integer(34) );
  fieldMap.put(EW_DT,new Integer(35) );
  fieldMap.put(INSP_WISH_YMD,new Integer(36) );
  fieldMap.put(OFFI_TELNUM,new Integer(37) );
  fieldMap.put(OFFI_NM,new Integer(38) );
  fieldMap.put(USEBEFINSP_DELINUM,new Integer(39) );
  fieldMap.put(SUV,new Integer(40) );
  fieldMap.put(REMARK,new Integer(41) );
  fieldMap.put(CER_DELI_YN,new Integer(42) );
  fieldMap.put(PLAN_CONFIRM_REMARK,new Integer(43) );
  fieldMap.put(NAPPL_YN,new Integer(44) );
  fieldMap.put(NAPPL_CAUSE,new Integer(45) );
  fieldMap.put(DOC_INSP_REMARK,new Integer(46) );
  fieldMap.put(WRT_ID,new Integer(47) );
  fieldMap.put(INS_DT,new Integer(48) );
  fieldMap.put(UPD_DT,new Integer(49) );
  fieldMap.put(CIV_RECV_NUM,new Integer(50) );
  fieldMap.put(RECV_DT,new Integer(51) );
  fieldMap.put(PLAN_CONFIRM_PER_YN,new Integer(52) );
  fieldMap.put(PLAN_ENT_CHG_YN,new Integer(53) );
  fieldMap.put(PLAN_CONT_CHG_YN,new Integer(54) );
  fieldMap.put(RECV_NUM,new Integer(55) );
  fieldMap.put(ATT_DOC,new Integer(56) );
  fieldMap.put(DELI_DT,new Integer(57) );
  fieldMap.put(DEFI_YN,new Integer(58) );
  fieldMap.put(PROC_STE,new Integer(59) );
  fieldMap.put(ISSUE_ITEM,new Integer(60) );
  fieldMap.put(NET_RECV_YN,new Integer(61) );
  fieldMap.put(PROC_LIM,new Integer(62) );
  fieldMap.put(INSP_NUM,new Integer(63) );
  fieldMap.put(PROC_OFFI,new Integer(64) );
  fieldMap.put(PLAN_CONFIRM_PER_YN_CONT,new Integer(65) );
  fieldMap.put(PLAN_ENT_CHG_YN_CONT,new Integer(66) );
  fieldMap.put(PLAN_CONT_CHG_YN_CONT,new Integer(67) );
  fieldMap.put(CHG_INSP,new Integer(68) );
  fieldMap.put(INSP_ITEM,new Integer(69) );
  fieldMap.put(ETC_INSP_BAS,new Integer(70) );
  fieldMap.put(WORK_ITEM_ETC,new Integer(71) );
  fieldMap.put(UPD_DT_OLD,new Integer(72) );
  fieldMap.put(BACKUP_TRANS_DT,new Integer(73) );
  fieldMap.put(TAKE_TM,new Integer(74) );
  fieldMap.put(USER_NAME,new Integer(75) );
  fieldMap.put(MW_PPS_GETR_ID,new Integer(76) );
  fieldMap.put(OUTVARS,new Integer(77) );
  fieldMap.put(MW_AFR_SHTNM,new Integer(78) );
  fieldMap.put(MW_SE,new Integer(79) );
  fieldMap.put(MW_CODE_CN,new Integer(80) );
  fieldMap.put(TAKE_CONFRM_CODE,new Integer(81) );
  fieldMap.put(DEAL_SE,new Integer(82) );
  fieldMap.put(DEAL_CODE_CN,new Integer(83) );
  fieldMap.put(TAKE_SE,new Integer(84) );
  fieldMap.put(TAKE_CODE_CN,new Integer(85) );
  fieldMap.put(REAL_DEAL_YMD,new Integer(86) );
  fieldMap.put(MW_TAKE_NO,new Integer(87) );
  fieldMap.put(ETC1,new Integer(88) );
  fieldMap.put(ETC2,new Integer(89) );
  fieldMap.put(ETC3,new Integer(90) );
  fieldMap.put(BEF_PLANER_NAME,new Integer(91) );
  fieldMap.put(PROC_OFFI_ID,new Integer(92) );
  fieldMap.put(ADMIT_DT,new Integer(93) );
  fieldMap.put(USE_ETC,new Integer(94) );
  
  
  }

     final public static String PACKAGE = "sp.dao";
     final public static String TABLE = "PT_UB_USEBEFORE";
     final public static String PREFIX = "sp.dao.PT_UB_USEBEFORE";
     final public static String TABLE_DESC = "";
  
     final public static String PRIMARYKEY_LIST[] = { 
       RECV_NUM,SIDO_CODE,SIGUNGU_CODE };
     final public static String FIELD_LIST[] = { 
       SIDO_CODE,SIGUNGU_CODE,APPLPER_NM,APPLPER_REP,APPLPER_POSTNUM,APPLPER_ADDR,APPLPER_DETAILADDR,APPLPER_TELNUM,OPE_NAME,OPE_REP,OPE_TELNUM,COI_WRT_NUM,OPE_POSTNUM,OPE_ADDR,OPE_DETAILADDR,INSP_SPOT_NM,INSP_SPOT_POSTNUM,INSP_SPOT_ADDR,INSP_SPOT_DETAILADDR,PLANER_NM,WORK_ITEM,AREA,NUM_FL,USE,INSP_APPL_WORK,INSP_APPL_DT,INSP_DT,INSP_FEE,INSPER_NM,INSPER_POSI,JUDGM,PLAN_CONFIRM_YN,SW_BEF_REPO_DELINUM,SW_DT,EW_DT,INSP_WISH_YMD,OFFI_TELNUM,OFFI_NM,USEBEFINSP_DELINUM,SUV,REMARK,CER_DELI_YN,PLAN_CONFIRM_REMARK,NAPPL_YN,NAPPL_CAUSE,DOC_INSP_REMARK,WRT_ID,INS_DT,UPD_DT,CIV_RECV_NUM,RECV_DT,PLAN_CONFIRM_PER_YN,PLAN_ENT_CHG_YN,PLAN_CONT_CHG_YN,RECV_NUM,ATT_DOC,DELI_DT,DEFI_YN,PROC_STE,ISSUE_ITEM,NET_RECV_YN,PROC_LIM,INSP_NUM,PROC_OFFI,PLAN_CONFIRM_PER_YN_CONT,PLAN_ENT_CHG_YN_CONT,PLAN_CONT_CHG_YN_CONT,CHG_INSP,INSP_ITEM,ETC_INSP_BAS,WORK_ITEM_ETC,UPD_DT_OLD,BACKUP_TRANS_DT,TAKE_TM,USER_NAME,MW_PPS_GETR_ID,OUTVARS,MW_AFR_SHTNM,MW_SE,MW_CODE_CN,TAKE_CONFRM_CODE,DEAL_SE,DEAL_CODE_CN,TAKE_SE,TAKE_CODE_CN,REAL_DEAL_YMD,MW_TAKE_NO,ETC1,ETC2,ETC3,BEF_PLANER_NAME,PROC_OFFI_ID,ADMIT_DT,USE_ETC };
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
             case 52 : 
	                  return  "";
             case 53 : 
	                  return  "";
             case 54 : 
	                  return  "";
             case 55 : 
	                  return  "";
             case 56 : 
	                  return  "";
             case 57 : 
	                  return  "";
             case 58 : 
	                  return  "";
             case 59 : 
	                  return  "";
             case 60 : 
	                  return  "";
             case 61 : 
	                  return  "";
             case 62 : 
	                  return  "";
             case 63 : 
	                  return  "";
             case 64 : 
	                  return  "";
             case 65 : 
	                  return  "";
             case 66 : 
	                  return  "";
             case 67 : 
	                  return  "";
             case 68 : 
	                  return  "";
             case 69 : 
	                  return  "";
             case 70 : 
	                  return  "";
             case 71 : 
	                  return  "";
             case 72 : 
	                  return  "";
             case 73 : 
	                  return  "";
             case 74 : 
	                  return  "";
             case 75 : 
	                  return  "";
             case 76 : 
	                  return  "";
             case 77 : 
	                  return  "";
             case 78 : 
	                  return  "";
             case 79 : 
	                  return  "";
             case 80 : 
	                  return  "";
             case 81 : 
	                  return  "";
             case 82 : 
	                  return  "";
             case 83 : 
	                  return  "";
             case 84 : 
	                  return  "";
             case 85 : 
	                  return  "";
             case 86 : 
	                  return  "";
             case 87 : 
	                  return  "";
             case 88 : 
	                  return  "";
             case 89 : 
	                  return  "";
             case 90 : 
	                  return  "";
             case 91 : 
	                  return  "";
             case 92 : 
	                  return  "";
             case 93 : 
	                  return  "";
             case 94 : 
	                  return  "";
           }

         return null;
    }

   public static String toXML(PT_UB_USEBEFOREEntity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("<object type='object' name='").append(ent.getClass().getName()).append("' >\n");
        
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIDO_CODE").append("'")
            .append(" value='").append(""+ent.getSIDO_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SIGUNGU_CODE").append("'")
            .append(" value='").append(""+ent.getSIGUNGU_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("APPLPER_NM").append("'")
            .append(" value='").append(""+ent.getAPPLPER_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("APPLPER_REP").append("'")
            .append(" value='").append(""+ent.getAPPLPER_REP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("APPLPER_POSTNUM").append("'")
            .append(" value='").append(""+ent.getAPPLPER_POSTNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("APPLPER_ADDR").append("'")
            .append(" value='").append(""+ent.getAPPLPER_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("APPLPER_DETAILADDR").append("'")
            .append(" value='").append(""+ent.getAPPLPER_DETAILADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("APPLPER_TELNUM").append("'")
            .append(" value='").append(""+ent.getAPPLPER_TELNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPE_NAME").append("'")
            .append(" value='").append(""+ent.getOPE_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPE_REP").append("'")
            .append(" value='").append(""+ent.getOPE_REP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPE_TELNUM").append("'")
            .append(" value='").append(""+ent.getOPE_TELNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("COI_WRT_NUM").append("'")
            .append(" value='").append(""+ent.getCOI_WRT_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPE_POSTNUM").append("'")
            .append(" value='").append(""+ent.getOPE_POSTNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPE_ADDR").append("'")
            .append(" value='").append(""+ent.getOPE_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OPE_DETAILADDR").append("'")
            .append(" value='").append(""+ent.getOPE_DETAILADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_SPOT_NM").append("'")
            .append(" value='").append(""+ent.getINSP_SPOT_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_SPOT_POSTNUM").append("'")
            .append(" value='").append(""+ent.getINSP_SPOT_POSTNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_SPOT_ADDR").append("'")
            .append(" value='").append(""+ent.getINSP_SPOT_ADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_SPOT_DETAILADDR").append("'")
            .append(" value='").append(""+ent.getINSP_SPOT_DETAILADDR()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLANER_NM").append("'")
            .append(" value='").append(""+ent.getPLANER_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WORK_ITEM").append("'")
            .append(" value='").append(""+ent.getWORK_ITEM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("AREA").append("'")
            .append(" value='").append(""+ent.getAREA()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NUM_FL").append("'")
            .append(" value='").append(""+ent.getNUM_FL()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE").append("'")
            .append(" value='").append(""+ent.getUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_APPL_WORK").append("'")
            .append(" value='").append(""+ent.getINSP_APPL_WORK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_APPL_DT").append("'")
            .append(" value='").append(""+ent.getINSP_APPL_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_DT").append("'")
            .append(" value='").append(""+ent.getINSP_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_FEE").append("'")
            .append(" value='").append(""+ent.getINSP_FEE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSPER_NM").append("'")
            .append(" value='").append(""+ent.getINSPER_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSPER_POSI").append("'")
            .append(" value='").append(""+ent.getINSPER_POSI()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("JUDGM").append("'")
            .append(" value='").append(""+ent.getJUDGM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLAN_CONFIRM_YN").append("'")
            .append(" value='").append(""+ent.getPLAN_CONFIRM_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SW_BEF_REPO_DELINUM").append("'")
            .append(" value='").append(""+ent.getSW_BEF_REPO_DELINUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SW_DT").append("'")
            .append(" value='").append(""+ent.getSW_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("EW_DT").append("'")
            .append(" value='").append(""+ent.getEW_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_WISH_YMD").append("'")
            .append(" value='").append(""+ent.getINSP_WISH_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFI_TELNUM").append("'")
            .append(" value='").append(""+ent.getOFFI_TELNUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OFFI_NM").append("'")
            .append(" value='").append(""+ent.getOFFI_NM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USEBEFINSP_DELINUM").append("'")
            .append(" value='").append(""+ent.getUSEBEFINSP_DELINUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("SUV").append("'")
            .append(" value='").append(""+ent.getSUV()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REMARK").append("'")
            .append(" value='").append(""+ent.getREMARK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CER_DELI_YN").append("'")
            .append(" value='").append(""+ent.getCER_DELI_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLAN_CONFIRM_REMARK").append("'")
            .append(" value='").append(""+ent.getPLAN_CONFIRM_REMARK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NAPPL_YN").append("'")
            .append(" value='").append(""+ent.getNAPPL_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NAPPL_CAUSE").append("'")
            .append(" value='").append(""+ent.getNAPPL_CAUSE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DOC_INSP_REMARK").append("'")
            .append(" value='").append(""+ent.getDOC_INSP_REMARK()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WRT_ID").append("'")
            .append(" value='").append(""+ent.getWRT_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INS_DT").append("'")
            .append(" value='").append(""+ent.getINS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT").append("'")
            .append(" value='").append(""+ent.getUPD_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CIV_RECV_NUM").append("'")
            .append(" value='").append(""+ent.getCIV_RECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_DT").append("'")
            .append(" value='").append(""+ent.getRECV_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLAN_CONFIRM_PER_YN").append("'")
            .append(" value='").append(""+ent.getPLAN_CONFIRM_PER_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLAN_ENT_CHG_YN").append("'")
            .append(" value='").append(""+ent.getPLAN_ENT_CHG_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLAN_CONT_CHG_YN").append("'")
            .append(" value='").append(""+ent.getPLAN_CONT_CHG_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("RECV_NUM").append("'")
            .append(" value='").append(""+ent.getRECV_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ATT_DOC").append("'")
            .append(" value='").append(""+ent.getATT_DOC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DELI_DT").append("'")
            .append(" value='").append(""+ent.getDELI_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEFI_YN").append("'")
            .append(" value='").append(""+ent.getDEFI_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_STE").append("'")
            .append(" value='").append(""+ent.getPROC_STE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ISSUE_ITEM").append("'")
            .append(" value='").append(""+ent.getISSUE_ITEM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("NET_RECV_YN").append("'")
            .append(" value='").append(""+ent.getNET_RECV_YN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_LIM").append("'")
            .append(" value='").append(""+ent.getPROC_LIM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_NUM").append("'")
            .append(" value='").append(""+ent.getINSP_NUM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_OFFI").append("'")
            .append(" value='").append(""+ent.getPROC_OFFI()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLAN_CONFIRM_PER_YN_CONT").append("'")
            .append(" value='").append(""+ent.getPLAN_CONFIRM_PER_YN_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLAN_ENT_CHG_YN_CONT").append("'")
            .append(" value='").append(""+ent.getPLAN_ENT_CHG_YN_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PLAN_CONT_CHG_YN_CONT").append("'")
            .append(" value='").append(""+ent.getPLAN_CONT_CHG_YN_CONT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("CHG_INSP").append("'")
            .append(" value='").append(""+ent.getCHG_INSP()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("INSP_ITEM").append("'")
            .append(" value='").append(""+ent.getINSP_ITEM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC_INSP_BAS").append("'")
            .append(" value='").append(""+ent.getETC_INSP_BAS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("WORK_ITEM_ETC").append("'")
            .append(" value='").append(""+ent.getWORK_ITEM_ETC()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("UPD_DT_OLD").append("'")
            .append(" value='").append(""+ent.getUPD_DT_OLD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BACKUP_TRANS_DT").append("'")
            .append(" value='").append(""+ent.getBACKUP_TRANS_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TAKE_TM").append("'")
            .append(" value='").append(""+ent.getTAKE_TM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USER_NAME").append("'")
            .append(" value='").append(""+ent.getUSER_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MW_PPS_GETR_ID").append("'")
            .append(" value='").append(""+ent.getMW_PPS_GETR_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("OUTVARS").append("'")
            .append(" value='").append(""+ent.getOUTVARS()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MW_AFR_SHTNM").append("'")
            .append(" value='").append(""+ent.getMW_AFR_SHTNM()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MW_SE").append("'")
            .append(" value='").append(""+ent.getMW_SE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MW_CODE_CN").append("'")
            .append(" value='").append(""+ent.getMW_CODE_CN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TAKE_CONFRM_CODE").append("'")
            .append(" value='").append(""+ent.getTAKE_CONFRM_CODE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEAL_SE").append("'")
            .append(" value='").append(""+ent.getDEAL_SE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("DEAL_CODE_CN").append("'")
            .append(" value='").append(""+ent.getDEAL_CODE_CN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TAKE_SE").append("'")
            .append(" value='").append(""+ent.getTAKE_SE()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("TAKE_CODE_CN").append("'")
            .append(" value='").append(""+ent.getTAKE_CODE_CN()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("REAL_DEAL_YMD").append("'")
            .append(" value='").append(""+ent.getREAL_DEAL_YMD()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("MW_TAKE_NO").append("'")
            .append(" value='").append(""+ent.getMW_TAKE_NO()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC1").append("'")
            .append(" value='").append(""+ent.getETC1()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC2").append("'")
            .append(" value='").append(""+ent.getETC2()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ETC3").append("'")
            .append(" value='").append(""+ent.getETC3()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("BEF_PLANER_NAME").append("'")
            .append(" value='").append(""+ent.getBEF_PLANER_NAME()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("PROC_OFFI_ID").append("'")
            .append(" value='").append(""+ent.getPROC_OFFI_ID()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("ADMIT_DT").append("'")
            .append(" value='").append(""+ent.getADMIT_DT()).append("' />\n");
        
         xml.append("<field type='").append("String").append("' ")
            .append(" name='").append("USE_ETC").append("'")
            .append(" value='").append(""+ent.getUSE_ETC()).append("' />\n");
        
                

         xml.append("</object>\n");
         
         return xml.toString();
  }

}
