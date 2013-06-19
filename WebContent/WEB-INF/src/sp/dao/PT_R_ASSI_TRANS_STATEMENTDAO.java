


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_ASSI_TRANS_STATEMENT
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SIDO_CODE
*  테이블 컬럼 :
*               RECV_NUM:VARCHAR2(12):
*               SIDO_CODE:VARCHAR2(4):
*               COI_WRT_NUM:VARCHAR2(6):
*               MOT_STE:VARCHAR2(6):
*               DEFI_STE:VARCHAR2(1):
*               RECV_DT:VARCHAR2(8):
*               RECV_TIME:VARCHAR2(6):
*               PROC_LIM:VARCHAR2(8):
*               PROC_TIME:VARCHAR2(4):
*               CHG_DT:VARCHAR2(24):
*               COMMANA_CLASS:VARCHAR2(1):
*               MANA_NUM:VARCHAR2(18):
*               NAME:VARCHAR2(50):
*               REP_SSN1:VARCHAR2(18):
*               REP_SSN2:VARCHAR2(21):
*               REP_NM_KOR:VARCHAR2(20):
*               REP_NM_HAN:VARCHAR2(20):
*               REP_TEL_NUM:VARCHAR2(17):
*               ADDR_POST_NUM:VARCHAR2(6):
*               ADDR_ADDR:VARCHAR2(120):
*               ADDR_DETAIL_ADDR:VARCHAR2(120):
*               ADDR_TEL_NUM:VARCHAR2(17):
*               ADDR_FAX_NUM:VARCHAR2(17):
*               EMAIL_ADDR:VARCHAR2(30):
*               OFFICE_AREA:VARCHAR2(10):
*               OFFICE_USE_CODE:VARCHAR2(6):
*               COMPANY_DIAG_CLASS_CODE:VARCHAR2(6):
*               COMPANY_DIAG_BAS_DT:VARCHAR2(8):
*               COMPANY_DIAG_ISSUE_DT:VARCHAR2(8):
*               DIAG_ORG_CODE:VARCHAR2(6):
*               DIAG_NM_NM:VARCHAR2(50):
*               DIAG_NM_WRT_NUM:VARCHAR2(50):
*               PAY_CAP:VARCHAR2(15):
*               REA_CAP:VARCHAR2(15):
*               TUP_AOM:VARCHAR2(15):
*               TUP_CLASS_CODE:VARCHAR2(6):
*               COM_COV_DT:VARCHAR2(8):
*               BAS_STA_DT:VARCHAR2(8):
*               OFFICE_OWN_CLASS:VARCHAR2(1):
*               REP_MOBILE:VARCHAR2(17):
*               LICTAX:VARCHAR2(1):
*               HOSCRE:VARCHAR2(1):
*               COM_NUM:VARCHAR2(13):
*               GUBUN:VARCHAR2(25):
*               DOC_CODE:VARCHAR2(30):
*               OFFICE_USE_NAME:VARCHAR2(20):
*               MEMO_CONT:VARCHAR2(256):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               ASSI_TMP_WRT_NUM:VARCHAR2(12):
*               ASSI_COI_WRT_NUM:VARCHAR2(6):
*               ASSI_COMMANA_CLASS:VARCHAR2(4):
*               ASSI_MANA_NUM:VARCHAR2(18):
*               ASSI_STE:VARCHAR2(1):
*               ASSI_NAME:VARCHAR2(50):
*               ASSI_TELNUM:VARCHAR2(17):
*               ASSI_REP:VARCHAR2(20):
*               ASSI_COMNUM:VARCHAR2(13):
*               ASSI_ADDR:VARCHAR2(120):
*               ASSI_POST_NUM:VARCHAR2(120):
*               ASSI_DETAIL_ADDR:VARCHAR2(120):
*               ASSI_GUBUN:VARCHAR2(1):
*               ASSI_WRT_DT:VARCHAR2(24):
*               ASSI_CHGBRE_SEQ:VARCHAR2(4):
*               TRAN_TMP_WRT_NUM:VARCHAR2(12):
*               TRAN_COI_WRT_NUM:VARCHAR2(6):
*               TRAN_COMMANA_CLASS:VARCHAR2(4):
*               TRAN_MANA_NUM:VARCHAR2(18):
*               TRAN_NAME:VARCHAR2(50):
*               TRAN_TELNUM:VARCHAR2(17):
*               TRAN_REP:VARCHAR2(20):
*               TRAN_COMNUM:VARCHAR2(13):
*               TRAN_ADDR:VARCHAR2(120):
*               TRAN_POST_NUM:VARCHAR2(6):
*               TRAN_DETAIL_ADDR:VARCHAR2(120):
*               TRAN_GUBUN:VARCHAR2(1):
*               TRAN_WRT_DT:VARCHAR2(24):
*               TRAN_CHGBRE_SEQ:VARCHAR2(4):
*               COMPANY_DIAG_BAS_DT2:VARCHAR2(4):
*               BUSS_YMD:VARCHAR2(8):
*               FOREIGN_YN:VARCHAR2(1):
*               REGIST_YMD:VARCHAR2(8):
*               ASSI_BUSS_YMD:VARCHAR2(8):
*               ASSI_FOREIGN_YN:VARCHAR2(1):
*               ASSI_REGIST_YMD:VARCHAR2(8):
*               TRAN_BUSS_YMD:VARCHAR2(8):
*               TRAN_FOREIGN_YN:VARCHAR2(1):
*               TRAN_REGIST_YMD:VARCHAR2(8):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_ASSI_TRANS_STATEMENTDAO  extends SuperToDB{

  private String default_fields[]={ "RECV_NUM" , "SIDO_CODE" , "COI_WRT_NUM" , "MOT_STE" , "DEFI_STE" , "RECV_DT" , "RECV_TIME" , "PROC_LIM" , "PROC_TIME" , "CHG_DT" , "COMMANA_CLASS" , "MANA_NUM" , "NAME" , "REP_SSN1" , "REP_SSN2" , "REP_NM_KOR" , "REP_NM_HAN" , "REP_TEL_NUM" , "ADDR_POST_NUM" , "ADDR_ADDR" , "ADDR_DETAIL_ADDR" , "ADDR_TEL_NUM" , "ADDR_FAX_NUM" , "EMAIL_ADDR" , "OFFICE_AREA" , "OFFICE_USE_CODE" , "COMPANY_DIAG_CLASS_CODE" , "COMPANY_DIAG_BAS_DT" , "COMPANY_DIAG_ISSUE_DT" , "DIAG_ORG_CODE" , "DIAG_NM_NM" , "DIAG_NM_WRT_NUM" , "PAY_CAP" , "REA_CAP" , "TUP_AOM" , "TUP_CLASS_CODE" , "COM_COV_DT" , "BAS_STA_DT" , "OFFICE_OWN_CLASS" , "REP_MOBILE" , "LICTAX" , "HOSCRE" , "COM_NUM" , "GUBUN" , "DOC_CODE" , "OFFICE_USE_NAME" , "MEMO_CONT" , "WRT_ID" , "INS_DT" , "UPD_DT" , "ASSI_TMP_WRT_NUM" , "ASSI_COI_WRT_NUM" , "ASSI_COMMANA_CLASS" , "ASSI_MANA_NUM" , "ASSI_STE" , "ASSI_NAME" , "ASSI_TELNUM" , "ASSI_REP" , "ASSI_COMNUM" , "ASSI_ADDR" , "ASSI_POST_NUM" , "ASSI_DETAIL_ADDR" , "ASSI_GUBUN" , "ASSI_WRT_DT" , "ASSI_CHGBRE_SEQ" , "TRAN_TMP_WRT_NUM" , "TRAN_COI_WRT_NUM" , "TRAN_COMMANA_CLASS" , "TRAN_MANA_NUM" , "TRAN_NAME" , "TRAN_TELNUM" , "TRAN_REP" , "TRAN_COMNUM" , "TRAN_ADDR" , "TRAN_POST_NUM" , "TRAN_DETAIL_ADDR" , "TRAN_GUBUN" , "TRAN_WRT_DT" , "TRAN_CHGBRE_SEQ" , "COMPANY_DIAG_BAS_DT2" , "BUSS_YMD" , "FOREIGN_YN" , "REGIST_YMD" , "ASSI_BUSS_YMD" , "ASSI_FOREIGN_YN" , "ASSI_REGIST_YMD" , "TRAN_BUSS_YMD" , "TRAN_FOREIGN_YN" , "TRAN_REGIST_YMD" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : insert() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_ASSI_TRANS_STATEMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,COI_WRT_NUM,MOT_STE,DEFI_STE,RECV_DT,RECV_TIME,PROC_LIM,PROC_TIME,CHG_DT,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,COM_COV_DT,BAS_STA_DT,OFFICE_OWN_CLASS,REP_MOBILE,LICTAX,HOSCRE,COM_NUM,GUBUN,DOC_CODE,OFFICE_USE_NAME,MEMO_CONT,WRT_ID,INS_DT,UPD_DT,ASSI_TMP_WRT_NUM,ASSI_COI_WRT_NUM,ASSI_COMMANA_CLASS,ASSI_MANA_NUM,ASSI_STE,ASSI_NAME,ASSI_TELNUM,ASSI_REP,ASSI_COMNUM,ASSI_ADDR,ASSI_POST_NUM,ASSI_DETAIL_ADDR,ASSI_GUBUN,ASSI_WRT_DT,ASSI_CHGBRE_SEQ,TRAN_TMP_WRT_NUM,TRAN_COI_WRT_NUM,TRAN_COMMANA_CLASS,TRAN_MANA_NUM,TRAN_NAME,TRAN_TELNUM,TRAN_REP,TRAN_COMNUM,TRAN_ADDR,TRAN_POST_NUM,TRAN_DETAIL_ADDR,TRAN_GUBUN,TRAN_WRT_DT,TRAN_CHGBRE_SEQ,COMPANY_DIAG_BAS_DT2,BUSS_YMD,FOREIGN_YN,REGIST_YMD,ASSI_BUSS_YMD,ASSI_FOREIGN_YN,ASSI_REGIST_YMD,TRAN_BUSS_YMD,TRAN_FOREIGN_YN,TRAN_REGIST_YMD ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getDEFI_STE()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getRECV_TIME()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getPROC_TIME()))
			.append(",")
           .append(toDB(entity.getCHG_DT()))
			.append(",")
           .append(toDB(entity.getCOMMANA_CLASS()))
			.append(",")
           .append(toDB(entity.getMANA_NUM()))
			.append(",")
           .append(toDB(entity.getNAME()))
			.append(",")
           .append(toDB(entity.getREP_SSN1()))
			.append(",")
           .append(toDB(entity.getREP_SSN2()))
			.append(",")
           .append(toDB(entity.getREP_NM_KOR()))
			.append(",")
           .append(toDB(entity.getREP_NM_HAN()))
			.append(",")
           .append(toDB(entity.getREP_TEL_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_POST_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_ADDR()))
			.append(",")
           .append(toDB(entity.getADDR_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM()))
			.append(",")
           .append(toDB(entity.getEMAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getOFFICE_AREA()))
			.append(",")
           .append(toDB(entity.getOFFICE_USE_CODE()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BAS_DT()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_ISSUE_DT()))
			.append(",")
           .append(toDB(entity.getDIAG_ORG_CODE()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_NM()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getPAY_CAP()))
			.append(",")
           .append(toDB(entity.getREA_CAP()))
			.append(",")
           .append(toDB(entity.getTUP_AOM()))
			.append(",")
           .append(toDB(entity.getTUP_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getCOM_COV_DT()))
			.append(",")
           .append(toDB(entity.getBAS_STA_DT()))
			.append(",")
           .append(toDB(entity.getOFFICE_OWN_CLASS()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE()))
			.append(",")
           .append(toDB(entity.getLICTAX()))
			.append(",")
           .append(toDB(entity.getHOSCRE()))
			.append(",")
           .append(toDB(entity.getCOM_NUM()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getOFFICE_USE_NAME()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getASSI_TMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getASSI_COI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getASSI_COMMANA_CLASS()))
			.append(",")
           .append(toDB(entity.getASSI_MANA_NUM()))
			.append(",")
           .append(toDB(entity.getASSI_STE()))
			.append(",")
           .append(toDB(entity.getASSI_NAME()))
			.append(",")
           .append(toDB(entity.getASSI_TELNUM()))
			.append(",")
           .append(toDB(entity.getASSI_REP()))
			.append(",")
           .append(toDB(entity.getASSI_COMNUM()))
			.append(",")
           .append(toDB(entity.getASSI_ADDR()))
			.append(",")
           .append(toDB(entity.getASSI_POST_NUM()))
			.append(",")
           .append(toDB(entity.getASSI_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getASSI_GUBUN()))
			.append(",")
           .append(toDB(entity.getASSI_WRT_DT()))
			.append(",")
           .append(toDB(entity.getASSI_CHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getTRAN_TMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getTRAN_COI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getTRAN_COMMANA_CLASS()))
			.append(",")
           .append(toDB(entity.getTRAN_MANA_NUM()))
			.append(",")
           .append(toDB(entity.getTRAN_NAME()))
			.append(",")
           .append(toDB(entity.getTRAN_TELNUM()))
			.append(",")
           .append(toDB(entity.getTRAN_REP()))
			.append(",")
           .append(toDB(entity.getTRAN_COMNUM()))
			.append(",")
           .append(toDB(entity.getTRAN_ADDR()))
			.append(",")
           .append(toDB(entity.getTRAN_POST_NUM()))
			.append(",")
           .append(toDB(entity.getTRAN_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getTRAN_GUBUN()))
			.append(",")
           .append(toDB(entity.getTRAN_WRT_DT()))
			.append(",")
           .append(toDB(entity.getTRAN_CHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BAS_DT2()))
			.append(",")
           .append(toDB(entity.getBUSS_YMD()))
			.append(",")
           .append(toDB(entity.getFOREIGN_YN()))
			.append(",")
           .append(toDB(entity.getREGIST_YMD()))
			.append(",")
           .append(toDB(entity.getASSI_BUSS_YMD()))
			.append(",")
           .append(toDB(entity.getASSI_FOREIGN_YN()))
			.append(",")
           .append(toDB(entity.getASSI_REGIST_YMD()))
			.append(",")
           .append(toDB(entity.getTRAN_BUSS_YMD()))
			.append(",")
           .append(toDB(entity.getTRAN_FOREIGN_YN()))
			.append(",")
           .append(toDB(entity.getTRAN_REGIST_YMD()))
			
    .append(" ) ");

   KJFLog.sql(sb.toString());


   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

    int i=1;
	
    result = ps.executeUpdate();

   } catch (SQLException e) {
           throw e;

   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }
    return result ;
  }



  public String insertSql( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : insert() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_ASSI_TRANS_STATEMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,COI_WRT_NUM,MOT_STE,DEFI_STE,RECV_DT,RECV_TIME,PROC_LIM,PROC_TIME,CHG_DT,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,COM_COV_DT,BAS_STA_DT,OFFICE_OWN_CLASS,REP_MOBILE,LICTAX,HOSCRE,COM_NUM,GUBUN,DOC_CODE,OFFICE_USE_NAME,MEMO_CONT,WRT_ID,INS_DT,UPD_DT,ASSI_TMP_WRT_NUM,ASSI_COI_WRT_NUM,ASSI_COMMANA_CLASS,ASSI_MANA_NUM,ASSI_STE,ASSI_NAME,ASSI_TELNUM,ASSI_REP,ASSI_COMNUM,ASSI_ADDR,ASSI_POST_NUM,ASSI_DETAIL_ADDR,ASSI_GUBUN,ASSI_WRT_DT,ASSI_CHGBRE_SEQ,TRAN_TMP_WRT_NUM,TRAN_COI_WRT_NUM,TRAN_COMMANA_CLASS,TRAN_MANA_NUM,TRAN_NAME,TRAN_TELNUM,TRAN_REP,TRAN_COMNUM,TRAN_ADDR,TRAN_POST_NUM,TRAN_DETAIL_ADDR,TRAN_GUBUN,TRAN_WRT_DT,TRAN_CHGBRE_SEQ,COMPANY_DIAG_BAS_DT2,BUSS_YMD,FOREIGN_YN,REGIST_YMD,ASSI_BUSS_YMD,ASSI_FOREIGN_YN,ASSI_REGIST_YMD,TRAN_BUSS_YMD,TRAN_FOREIGN_YN,TRAN_REGIST_YMD ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getDEFI_STE()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getRECV_TIME()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getPROC_TIME()))
			.append(",")
           .append(toDB(entity.getCHG_DT()))
			.append(",")
           .append(toDB(entity.getCOMMANA_CLASS()))
			.append(",")
           .append(toDB(entity.getMANA_NUM()))
			.append(",")
           .append(toDB(entity.getNAME()))
			.append(",")
           .append(toDB(entity.getREP_SSN1()))
			.append(",")
           .append(toDB(entity.getREP_SSN2()))
			.append(",")
           .append(toDB(entity.getREP_NM_KOR()))
			.append(",")
           .append(toDB(entity.getREP_NM_HAN()))
			.append(",")
           .append(toDB(entity.getREP_TEL_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_POST_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_ADDR()))
			.append(",")
           .append(toDB(entity.getADDR_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM()))
			.append(",")
           .append(toDB(entity.getEMAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getOFFICE_AREA()))
			.append(",")
           .append(toDB(entity.getOFFICE_USE_CODE()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BAS_DT()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_ISSUE_DT()))
			.append(",")
           .append(toDB(entity.getDIAG_ORG_CODE()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_NM()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getPAY_CAP()))
			.append(",")
           .append(toDB(entity.getREA_CAP()))
			.append(",")
           .append(toDB(entity.getTUP_AOM()))
			.append(",")
           .append(toDB(entity.getTUP_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getCOM_COV_DT()))
			.append(",")
           .append(toDB(entity.getBAS_STA_DT()))
			.append(",")
           .append(toDB(entity.getOFFICE_OWN_CLASS()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE()))
			.append(",")
           .append(toDB(entity.getLICTAX()))
			.append(",")
           .append(toDB(entity.getHOSCRE()))
			.append(",")
           .append(toDB(entity.getCOM_NUM()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getOFFICE_USE_NAME()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getASSI_TMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getASSI_COI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getASSI_COMMANA_CLASS()))
			.append(",")
           .append(toDB(entity.getASSI_MANA_NUM()))
			.append(",")
           .append(toDB(entity.getASSI_STE()))
			.append(",")
           .append(toDB(entity.getASSI_NAME()))
			.append(",")
           .append(toDB(entity.getASSI_TELNUM()))
			.append(",")
           .append(toDB(entity.getASSI_REP()))
			.append(",")
           .append(toDB(entity.getASSI_COMNUM()))
			.append(",")
           .append(toDB(entity.getASSI_ADDR()))
			.append(",")
           .append(toDB(entity.getASSI_POST_NUM()))
			.append(",")
           .append(toDB(entity.getASSI_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getASSI_GUBUN()))
			.append(",")
           .append(toDB(entity.getASSI_WRT_DT()))
			.append(",")
           .append(toDB(entity.getASSI_CHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getTRAN_TMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getTRAN_COI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getTRAN_COMMANA_CLASS()))
			.append(",")
           .append(toDB(entity.getTRAN_MANA_NUM()))
			.append(",")
           .append(toDB(entity.getTRAN_NAME()))
			.append(",")
           .append(toDB(entity.getTRAN_TELNUM()))
			.append(",")
           .append(toDB(entity.getTRAN_REP()))
			.append(",")
           .append(toDB(entity.getTRAN_COMNUM()))
			.append(",")
           .append(toDB(entity.getTRAN_ADDR()))
			.append(",")
           .append(toDB(entity.getTRAN_POST_NUM()))
			.append(",")
           .append(toDB(entity.getTRAN_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getTRAN_GUBUN()))
			.append(",")
           .append(toDB(entity.getTRAN_WRT_DT()))
			.append(",")
           .append(toDB(entity.getTRAN_CHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BAS_DT2()))
			.append(",")
           .append(toDB(entity.getBUSS_YMD()))
			.append(",")
           .append(toDB(entity.getFOREIGN_YN()))
			.append(",")
           .append(toDB(entity.getREGIST_YMD()))
			.append(",")
           .append(toDB(entity.getASSI_BUSS_YMD()))
			.append(",")
           .append(toDB(entity.getASSI_FOREIGN_YN()))
			.append(",")
           .append(toDB(entity.getASSI_REGIST_YMD()))
			.append(",")
           .append(toDB(entity.getTRAN_BUSS_YMD()))
			.append(",")
           .append(toDB(entity.getTRAN_FOREIGN_YN()))
			.append(",")
           .append(toDB(entity.getTRAN_REGIST_YMD()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : update() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ASSI_TRANS_STATEMENT  set ")
       
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("DEFI_STE = ")
        .append(toDB(entity.getDEFI_STE())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("RECV_TIME = ")
        .append(toDB(entity.getRECV_TIME())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("PROC_TIME = ")
        .append(toDB(entity.getPROC_TIME())).append(",")
        .append("CHG_DT = ")
        .append(toDB(entity.getCHG_DT())).append(",")
        .append("COMMANA_CLASS = ")
        .append(toDB(entity.getCOMMANA_CLASS())).append(",")
        .append("MANA_NUM = ")
        .append(toDB(entity.getMANA_NUM())).append(",")
        .append("NAME = ")
        .append(toDB(entity.getNAME())).append(",")
        .append("REP_SSN1 = ")
        .append(toDB(entity.getREP_SSN1())).append(",")
        .append("REP_SSN2 = ")
        .append(toDB(entity.getREP_SSN2())).append(",")
        .append("REP_NM_KOR = ")
        .append(toDB(entity.getREP_NM_KOR())).append(",")
        .append("REP_NM_HAN = ")
        .append(toDB(entity.getREP_NM_HAN())).append(",")
        .append("REP_TEL_NUM = ")
        .append(toDB(entity.getREP_TEL_NUM())).append(",")
        .append("ADDR_POST_NUM = ")
        .append(toDB(entity.getADDR_POST_NUM())).append(",")
        .append("ADDR_ADDR = ")
        .append(toDB(entity.getADDR_ADDR())).append(",")
        .append("ADDR_DETAIL_ADDR = ")
        .append(toDB(entity.getADDR_DETAIL_ADDR())).append(",")
        .append("ADDR_TEL_NUM = ")
        .append(toDB(entity.getADDR_TEL_NUM())).append(",")
        .append("ADDR_FAX_NUM = ")
        .append(toDB(entity.getADDR_FAX_NUM())).append(",")
        .append("EMAIL_ADDR = ")
        .append(toDB(entity.getEMAIL_ADDR())).append(",")
        .append("OFFICE_AREA = ")
        .append(toDB(entity.getOFFICE_AREA())).append(",")
        .append("OFFICE_USE_CODE = ")
        .append(toDB(entity.getOFFICE_USE_CODE())).append(",")
        .append("COMPANY_DIAG_CLASS_CODE = ")
        .append(toDB(entity.getCOMPANY_DIAG_CLASS_CODE())).append(",")
        .append("COMPANY_DIAG_BAS_DT = ")
        .append(toDB(entity.getCOMPANY_DIAG_BAS_DT())).append(",")
        .append("COMPANY_DIAG_ISSUE_DT = ")
        .append(toDB(entity.getCOMPANY_DIAG_ISSUE_DT())).append(",")
        .append("DIAG_ORG_CODE = ")
        .append(toDB(entity.getDIAG_ORG_CODE())).append(",")
        .append("DIAG_NM_NM = ")
        .append(toDB(entity.getDIAG_NM_NM())).append(",")
        .append("DIAG_NM_WRT_NUM = ")
        .append(toDB(entity.getDIAG_NM_WRT_NUM())).append(",")
        .append("PAY_CAP = ")
        .append(toDB(entity.getPAY_CAP())).append(",")
        .append("REA_CAP = ")
        .append(toDB(entity.getREA_CAP())).append(",")
        .append("TUP_AOM = ")
        .append(toDB(entity.getTUP_AOM())).append(",")
        .append("TUP_CLASS_CODE = ")
        .append(toDB(entity.getTUP_CLASS_CODE())).append(",")
        .append("COM_COV_DT = ")
        .append(toDB(entity.getCOM_COV_DT())).append(",")
        .append("BAS_STA_DT = ")
        .append(toDB(entity.getBAS_STA_DT())).append(",")
        .append("OFFICE_OWN_CLASS = ")
        .append(toDB(entity.getOFFICE_OWN_CLASS())).append(",")
        .append("REP_MOBILE = ")
        .append(toDB(entity.getREP_MOBILE())).append(",")
        .append("LICTAX = ")
        .append(toDB(entity.getLICTAX())).append(",")
        .append("HOSCRE = ")
        .append(toDB(entity.getHOSCRE())).append(",")
        .append("COM_NUM = ")
        .append(toDB(entity.getCOM_NUM())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("OFFICE_USE_NAME = ")
        .append(toDB(entity.getOFFICE_USE_NAME())).append(",")
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("ASSI_TMP_WRT_NUM = ")
        .append(toDB(entity.getASSI_TMP_WRT_NUM())).append(",")
        .append("ASSI_COI_WRT_NUM = ")
        .append(toDB(entity.getASSI_COI_WRT_NUM())).append(",")
        .append("ASSI_COMMANA_CLASS = ")
        .append(toDB(entity.getASSI_COMMANA_CLASS())).append(",")
        .append("ASSI_MANA_NUM = ")
        .append(toDB(entity.getASSI_MANA_NUM())).append(",")
        .append("ASSI_STE = ")
        .append(toDB(entity.getASSI_STE())).append(",")
        .append("ASSI_NAME = ")
        .append(toDB(entity.getASSI_NAME())).append(",")
        .append("ASSI_TELNUM = ")
        .append(toDB(entity.getASSI_TELNUM())).append(",")
        .append("ASSI_REP = ")
        .append(toDB(entity.getASSI_REP())).append(",")
        .append("ASSI_COMNUM = ")
        .append(toDB(entity.getASSI_COMNUM())).append(",")
        .append("ASSI_ADDR = ")
        .append(toDB(entity.getASSI_ADDR())).append(",")
        .append("ASSI_POST_NUM = ")
        .append(toDB(entity.getASSI_POST_NUM())).append(",")
        .append("ASSI_DETAIL_ADDR = ")
        .append(toDB(entity.getASSI_DETAIL_ADDR())).append(",")
        .append("ASSI_GUBUN = ")
        .append(toDB(entity.getASSI_GUBUN())).append(",")
        .append("ASSI_WRT_DT = ")
        .append(toDB(entity.getASSI_WRT_DT())).append(",")
        .append("ASSI_CHGBRE_SEQ = ")
        .append(toDB(entity.getASSI_CHGBRE_SEQ())).append(",")
        .append("TRAN_TMP_WRT_NUM = ")
        .append(toDB(entity.getTRAN_TMP_WRT_NUM())).append(",")
        .append("TRAN_COI_WRT_NUM = ")
        .append(toDB(entity.getTRAN_COI_WRT_NUM())).append(",")
        .append("TRAN_COMMANA_CLASS = ")
        .append(toDB(entity.getTRAN_COMMANA_CLASS())).append(",")
        .append("TRAN_MANA_NUM = ")
        .append(toDB(entity.getTRAN_MANA_NUM())).append(",")
        .append("TRAN_NAME = ")
        .append(toDB(entity.getTRAN_NAME())).append(",")
        .append("TRAN_TELNUM = ")
        .append(toDB(entity.getTRAN_TELNUM())).append(",")
        .append("TRAN_REP = ")
        .append(toDB(entity.getTRAN_REP())).append(",")
        .append("TRAN_COMNUM = ")
        .append(toDB(entity.getTRAN_COMNUM())).append(",")
        .append("TRAN_ADDR = ")
        .append(toDB(entity.getTRAN_ADDR())).append(",")
        .append("TRAN_POST_NUM = ")
        .append(toDB(entity.getTRAN_POST_NUM())).append(",")
        .append("TRAN_DETAIL_ADDR = ")
        .append(toDB(entity.getTRAN_DETAIL_ADDR())).append(",")
        .append("TRAN_GUBUN = ")
        .append(toDB(entity.getTRAN_GUBUN())).append(",")
        .append("TRAN_WRT_DT = ")
        .append(toDB(entity.getTRAN_WRT_DT())).append(",")
        .append("TRAN_CHGBRE_SEQ = ")
        .append(toDB(entity.getTRAN_CHGBRE_SEQ())).append(",")
        .append("COMPANY_DIAG_BAS_DT2 = ")
        .append(toDB(entity.getCOMPANY_DIAG_BAS_DT2())).append(",")
        .append("BUSS_YMD = ")
        .append(toDB(entity.getBUSS_YMD())).append(",")
        .append("FOREIGN_YN = ")
        .append(toDB(entity.getFOREIGN_YN())).append(",")
        .append("REGIST_YMD = ")
        .append(toDB(entity.getREGIST_YMD())).append(",")
        .append("ASSI_BUSS_YMD = ")
        .append(toDB(entity.getASSI_BUSS_YMD())).append(",")
        .append("ASSI_FOREIGN_YN = ")
        .append(toDB(entity.getASSI_FOREIGN_YN())).append(",")
        .append("ASSI_REGIST_YMD = ")
        .append(toDB(entity.getASSI_REGIST_YMD())).append(",")
        .append("TRAN_BUSS_YMD = ")
        .append(toDB(entity.getTRAN_BUSS_YMD())).append(",")
        .append("TRAN_FOREIGN_YN = ")
        .append(toDB(entity.getTRAN_FOREIGN_YN())).append(",")
        .append("TRAN_REGIST_YMD = ")
        .append(toDB(entity.getTRAN_REGIST_YMD()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         

   KJFLog.sql(sb.toString());

   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int i=1;
	
    result =ps.executeUpdate();

   } catch (SQLException e) {
           throw e;
   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }

    return result ;
  }


  public String  updateSql( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : update() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ASSI_TRANS_STATEMENT  set ")
       
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("DEFI_STE = ")
        .append(toDB(entity.getDEFI_STE())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("RECV_TIME = ")
        .append(toDB(entity.getRECV_TIME())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("PROC_TIME = ")
        .append(toDB(entity.getPROC_TIME())).append(",")
        .append("CHG_DT = ")
        .append(toDB(entity.getCHG_DT())).append(",")
        .append("COMMANA_CLASS = ")
        .append(toDB(entity.getCOMMANA_CLASS())).append(",")
        .append("MANA_NUM = ")
        .append(toDB(entity.getMANA_NUM())).append(",")
        .append("NAME = ")
        .append(toDB(entity.getNAME())).append(",")
        .append("REP_SSN1 = ")
        .append(toDB(entity.getREP_SSN1())).append(",")
        .append("REP_SSN2 = ")
        .append(toDB(entity.getREP_SSN2())).append(",")
        .append("REP_NM_KOR = ")
        .append(toDB(entity.getREP_NM_KOR())).append(",")
        .append("REP_NM_HAN = ")
        .append(toDB(entity.getREP_NM_HAN())).append(",")
        .append("REP_TEL_NUM = ")
        .append(toDB(entity.getREP_TEL_NUM())).append(",")
        .append("ADDR_POST_NUM = ")
        .append(toDB(entity.getADDR_POST_NUM())).append(",")
        .append("ADDR_ADDR = ")
        .append(toDB(entity.getADDR_ADDR())).append(",")
        .append("ADDR_DETAIL_ADDR = ")
        .append(toDB(entity.getADDR_DETAIL_ADDR())).append(",")
        .append("ADDR_TEL_NUM = ")
        .append(toDB(entity.getADDR_TEL_NUM())).append(",")
        .append("ADDR_FAX_NUM = ")
        .append(toDB(entity.getADDR_FAX_NUM())).append(",")
        .append("EMAIL_ADDR = ")
        .append(toDB(entity.getEMAIL_ADDR())).append(",")
        .append("OFFICE_AREA = ")
        .append(toDB(entity.getOFFICE_AREA())).append(",")
        .append("OFFICE_USE_CODE = ")
        .append(toDB(entity.getOFFICE_USE_CODE())).append(",")
        .append("COMPANY_DIAG_CLASS_CODE = ")
        .append(toDB(entity.getCOMPANY_DIAG_CLASS_CODE())).append(",")
        .append("COMPANY_DIAG_BAS_DT = ")
        .append(toDB(entity.getCOMPANY_DIAG_BAS_DT())).append(",")
        .append("COMPANY_DIAG_ISSUE_DT = ")
        .append(toDB(entity.getCOMPANY_DIAG_ISSUE_DT())).append(",")
        .append("DIAG_ORG_CODE = ")
        .append(toDB(entity.getDIAG_ORG_CODE())).append(",")
        .append("DIAG_NM_NM = ")
        .append(toDB(entity.getDIAG_NM_NM())).append(",")
        .append("DIAG_NM_WRT_NUM = ")
        .append(toDB(entity.getDIAG_NM_WRT_NUM())).append(",")
        .append("PAY_CAP = ")
        .append(toDB(entity.getPAY_CAP())).append(",")
        .append("REA_CAP = ")
        .append(toDB(entity.getREA_CAP())).append(",")
        .append("TUP_AOM = ")
        .append(toDB(entity.getTUP_AOM())).append(",")
        .append("TUP_CLASS_CODE = ")
        .append(toDB(entity.getTUP_CLASS_CODE())).append(",")
        .append("COM_COV_DT = ")
        .append(toDB(entity.getCOM_COV_DT())).append(",")
        .append("BAS_STA_DT = ")
        .append(toDB(entity.getBAS_STA_DT())).append(",")
        .append("OFFICE_OWN_CLASS = ")
        .append(toDB(entity.getOFFICE_OWN_CLASS())).append(",")
        .append("REP_MOBILE = ")
        .append(toDB(entity.getREP_MOBILE())).append(",")
        .append("LICTAX = ")
        .append(toDB(entity.getLICTAX())).append(",")
        .append("HOSCRE = ")
        .append(toDB(entity.getHOSCRE())).append(",")
        .append("COM_NUM = ")
        .append(toDB(entity.getCOM_NUM())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("OFFICE_USE_NAME = ")
        .append(toDB(entity.getOFFICE_USE_NAME())).append(",")
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("ASSI_TMP_WRT_NUM = ")
        .append(toDB(entity.getASSI_TMP_WRT_NUM())).append(",")
        .append("ASSI_COI_WRT_NUM = ")
        .append(toDB(entity.getASSI_COI_WRT_NUM())).append(",")
        .append("ASSI_COMMANA_CLASS = ")
        .append(toDB(entity.getASSI_COMMANA_CLASS())).append(",")
        .append("ASSI_MANA_NUM = ")
        .append(toDB(entity.getASSI_MANA_NUM())).append(",")
        .append("ASSI_STE = ")
        .append(toDB(entity.getASSI_STE())).append(",")
        .append("ASSI_NAME = ")
        .append(toDB(entity.getASSI_NAME())).append(",")
        .append("ASSI_TELNUM = ")
        .append(toDB(entity.getASSI_TELNUM())).append(",")
        .append("ASSI_REP = ")
        .append(toDB(entity.getASSI_REP())).append(",")
        .append("ASSI_COMNUM = ")
        .append(toDB(entity.getASSI_COMNUM())).append(",")
        .append("ASSI_ADDR = ")
        .append(toDB(entity.getASSI_ADDR())).append(",")
        .append("ASSI_POST_NUM = ")
        .append(toDB(entity.getASSI_POST_NUM())).append(",")
        .append("ASSI_DETAIL_ADDR = ")
        .append(toDB(entity.getASSI_DETAIL_ADDR())).append(",")
        .append("ASSI_GUBUN = ")
        .append(toDB(entity.getASSI_GUBUN())).append(",")
        .append("ASSI_WRT_DT = ")
        .append(toDB(entity.getASSI_WRT_DT())).append(",")
        .append("ASSI_CHGBRE_SEQ = ")
        .append(toDB(entity.getASSI_CHGBRE_SEQ())).append(",")
        .append("TRAN_TMP_WRT_NUM = ")
        .append(toDB(entity.getTRAN_TMP_WRT_NUM())).append(",")
        .append("TRAN_COI_WRT_NUM = ")
        .append(toDB(entity.getTRAN_COI_WRT_NUM())).append(",")
        .append("TRAN_COMMANA_CLASS = ")
        .append(toDB(entity.getTRAN_COMMANA_CLASS())).append(",")
        .append("TRAN_MANA_NUM = ")
        .append(toDB(entity.getTRAN_MANA_NUM())).append(",")
        .append("TRAN_NAME = ")
        .append(toDB(entity.getTRAN_NAME())).append(",")
        .append("TRAN_TELNUM = ")
        .append(toDB(entity.getTRAN_TELNUM())).append(",")
        .append("TRAN_REP = ")
        .append(toDB(entity.getTRAN_REP())).append(",")
        .append("TRAN_COMNUM = ")
        .append(toDB(entity.getTRAN_COMNUM())).append(",")
        .append("TRAN_ADDR = ")
        .append(toDB(entity.getTRAN_ADDR())).append(",")
        .append("TRAN_POST_NUM = ")
        .append(toDB(entity.getTRAN_POST_NUM())).append(",")
        .append("TRAN_DETAIL_ADDR = ")
        .append(toDB(entity.getTRAN_DETAIL_ADDR())).append(",")
        .append("TRAN_GUBUN = ")
        .append(toDB(entity.getTRAN_GUBUN())).append(",")
        .append("TRAN_WRT_DT = ")
        .append(toDB(entity.getTRAN_WRT_DT())).append(",")
        .append("TRAN_CHGBRE_SEQ = ")
        .append(toDB(entity.getTRAN_CHGBRE_SEQ())).append(",")
        .append("COMPANY_DIAG_BAS_DT2 = ")
        .append(toDB(entity.getCOMPANY_DIAG_BAS_DT2())).append(",")
        .append("BUSS_YMD = ")
        .append(toDB(entity.getBUSS_YMD())).append(",")
        .append("FOREIGN_YN = ")
        .append(toDB(entity.getFOREIGN_YN())).append(",")
        .append("REGIST_YMD = ")
        .append(toDB(entity.getREGIST_YMD())).append(",")
        .append("ASSI_BUSS_YMD = ")
        .append(toDB(entity.getASSI_BUSS_YMD())).append(",")
        .append("ASSI_FOREIGN_YN = ")
        .append(toDB(entity.getASSI_FOREIGN_YN())).append(",")
        .append("ASSI_REGIST_YMD = ")
        .append(toDB(entity.getASSI_REGIST_YMD())).append(",")
        .append("TRAN_BUSS_YMD = ")
        .append(toDB(entity.getTRAN_BUSS_YMD())).append(",")
        .append("TRAN_FOREIGN_YN = ")
        .append(toDB(entity.getTRAN_FOREIGN_YN())).append(",")
        .append("TRAN_REGIST_YMD = ")
        .append(toDB(entity.getTRAN_REGIST_YMD()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;

	HashMap clobs = new HashMap();
	

	Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i < fields.length ; i++){
        if(fields[i] == null) throw new  SQLException("Field Name can not be Null");
        if(default_update_field.containsKey(fields[i]) == false){
           if(flag)
               setString.append(",");
           flag = true;
           if(clobs.containsKey(fields[i])){
        	   setString.append(fields[i]).append("=?") ;
           }else{
        	   setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
           }
        }
    }
    if(flag = false)
       throw new  SQLException("Nothing to update");

    

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ASSI_TRANS_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

   KJFLog.sql( sb.toString());

    try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int k=1;
    for(int i=0 ; i < fields.length ; i++){
       if(clobs.containsKey(fields[i])){
    	   
    	   ps.setString(k++,(entity.getByName(fields[i])).toString() );
       }
    }

    result = ps.executeUpdate();

   } catch (SQLException e) {
           throw e;
   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }

	return result ;
  }




  public String updateModifiedOnlySql(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;


	HashMap clobs = new HashMap();
	

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i < fields.length ; i++){
        if(fields[i] == null) throw new  SQLException("Field Name can not be Null");
        if(default_update_field.containsKey(fields[i]) == false){
           if(flag)
               setString.append(",");
           flag = true;
           if(clobs.containsKey(fields[i])){
        	   setString.append(fields[i]).append("=?") ;
           }else{
        	   setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
           }
        }
    }
    if(flag = false)
       throw new  SQLException("Nothing to update");

    

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ASSI_TRANS_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;

	HashMap clobs = new HashMap();
	

	Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i < fields.length ; i++){
        if(fields[i] == null) throw new  SQLException("Field Name can not be Null");
        if(default_update_field.containsKey(fields[i]) == false){
           if(flag)
               setString.append(",");
           flag = true;
           if(clobs.containsKey(fields[i])){
        	   setString.append(fields[i]).append("=?") ;
           }else{
        	   setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
           }
        }
    }
    if(flag = false)
       throw new  SQLException("Nothing to update");

    

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ASSI_TRANS_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

   KJFLog.sql( sb.toString());

    try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int k=1;
    for(int i=0 ; i < fields.length ; i++){
       if(clobs.containsKey(fields[i])){
    	   
    	   ps.setString(k++,(entity.getByName(fields[i])).toString() );
       }
    }

    result = ps.executeUpdate();

   } catch (SQLException e) {
           throw e;
   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }

	return result ;
  }
  
  
   public String updateExcludeOnlySql(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;


	HashMap clobs = new HashMap();
	


    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i < fields.length ; i++){
        if(fields[i] == null) throw new  SQLException("Field Name can not be Null");
        if(default_update_field.containsKey(fields[i]) == false){
           if(flag)
               setString.append(",");
           flag = true;
           if(clobs.containsKey(fields[i])){
        	   setString.append(fields[i]).append("=?") ;
           }else{
        	   setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
           }
        }
    }
    if(flag = false)
       throw new  SQLException("Nothing to update");

    

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ASSI_TRANS_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : delete() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_ASSI_TRANS_STATEMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
       ;

   KJFLog.sql(sb.toString());


   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

    result = ps.executeUpdate();

   } catch (SQLException e) {
           throw e;
   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }

   return result;
  }

  public String deleteSql(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_ASSI_TRANS_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ASSI_TRANS_STATEMENT : delete() ");
    }
    PT_R_ASSI_TRANS_STATEMENTEntity entity = (PT_R_ASSI_TRANS_STATEMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_ASSI_TRANS_STATEMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
       ;


   return sb.toString();
  }


}//Class End
