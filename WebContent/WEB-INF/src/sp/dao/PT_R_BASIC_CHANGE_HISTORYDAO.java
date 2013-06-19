


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_BASIC_CHANGE_HISTORY
*  테이블 설명 :
*  테이블 PK   :
*               CHGBRE_SEQ
*               TMP_WRT_NUM
*  테이블 컬럼 :
*               SIDO_CODE:VARCHAR2(4):
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
*               C_COM_DT:VARCHAR2(8):
*               C_COM_CAUSE_CODE:VARCHAR2(6):
*               COM_COV_DT:VARCHAR2(8):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               WRT_DT:VARCHAR2(8):
*               BAS_STA_DT:VARCHAR2(8):
*               OFFICE_OWN_CLASS:VARCHAR2(1):
*               CHGBRE_SEQ:NUMBER(4):
*               STA_CHG_CLASS_CODE:VARCHAR2(6):
*               RECV_NUM:VARCHAR2(100):
*               CHG_DT:VARCHAR2(8):
*               MOT_STE:VARCHAR2(6):
*               TMP_WRT_NUM:VARCHAR2(12):
*               COI_WRT_NUM:VARCHAR2(12):
*               REP_MOBILE:VARCHAR2(17):
*               HOSCRE:VARCHAR2(1):
*               LICTAX:VARCHAR2(1):
*               SND_DT:VARCHAR2(8):
*               SND_STE:VARCHAR2(1):
*               COM_NUM:VARCHAR2(13):
*               ADDR_TEL_NUM1:VARCHAR2(4):
*               ADDR_TEL_NUM2:VARCHAR2(4):
*               ADDR_TEL_NUM3:VARCHAR2(4):
*               ADDR_FAX_NUM1:VARCHAR2(4):
*               ADDR_FAX_NUM2:VARCHAR2(4):
*               ADDR_FAX_NUM3:VARCHAR2(4):
*               REP_MOBILE1:VARCHAR2(4):
*               REP_MOBILE2:VARCHAR2(4):
*               REP_MOBILE3:VARCHAR2(4):
*               COMPANY_DIAG_BAS_DT2:VARCHAR2(4):
*               EXT_CHG_CLASS_CODE:VARCHAR2(4):
*               REC_DT:VARCHAR2(10):
*               SEQ_LINK_ADDR:VARCHAR2(30):
*               SEQ_LINK_CAPITAL:VARCHAR2(30):
*               SEQ_LINK_NAME:VARCHAR2(30):
*               SEQ_LINK_REP:VARCHAR2(30):
*               RECV_NUM2:VARCHAR2(12):
*               DOC_CODE:VARCHAR2(50):
*               GUBUN:VARCHAR2(25):
*               MEMO_CONT:VARCHAR2(256):
*               BUSS_YMD:VARCHAR2(8):
*               FOREIGN_YN:VARCHAR2(4):
*               REGIST_YMD:VARCHAR2(8):
*               MIDAL_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_BASIC_CHANGE_HISTORYDAO  extends SuperToDB{

  private String default_fields[]={ "SIDO_CODE" , "COMMANA_CLASS" , "MANA_NUM" , "NAME" , "REP_SSN1" , "REP_SSN2" , "REP_NM_KOR" , "REP_NM_HAN" , "REP_TEL_NUM" , "ADDR_POST_NUM" , "ADDR_ADDR" , "ADDR_DETAIL_ADDR" , "ADDR_TEL_NUM" , "ADDR_FAX_NUM" , "EMAIL_ADDR" , "OFFICE_AREA" , "OFFICE_USE_CODE" , "COMPANY_DIAG_CLASS_CODE" , "COMPANY_DIAG_BAS_DT" , "COMPANY_DIAG_ISSUE_DT" , "DIAG_ORG_CODE" , "DIAG_NM_NM" , "DIAG_NM_WRT_NUM" , "PAY_CAP" , "REA_CAP" , "TUP_AOM" , "TUP_CLASS_CODE" , "C_COM_DT" , "C_COM_CAUSE_CODE" , "COM_COV_DT" , "WRT_ID" , "UPD_DT" , "INS_DT" , "WRT_DT" , "BAS_STA_DT" , "OFFICE_OWN_CLASS" , "CHGBRE_SEQ" , "STA_CHG_CLASS_CODE" , "RECV_NUM" , "CHG_DT" , "MOT_STE" , "TMP_WRT_NUM" , "COI_WRT_NUM" , "REP_MOBILE" , "HOSCRE" , "LICTAX" , "SND_DT" , "SND_STE" , "COM_NUM" , "ADDR_TEL_NUM1" , "ADDR_TEL_NUM2" , "ADDR_TEL_NUM3" , "ADDR_FAX_NUM1" , "ADDR_FAX_NUM2" , "ADDR_FAX_NUM3" , "REP_MOBILE1" , "REP_MOBILE2" , "REP_MOBILE3" , "COMPANY_DIAG_BAS_DT2" , "EXT_CHG_CLASS_CODE" , "REC_DT" , "SEQ_LINK_ADDR" , "SEQ_LINK_CAPITAL" , "SEQ_LINK_NAME" , "SEQ_LINK_REP" , "RECV_NUM2" , "DOC_CODE" , "GUBUN" , "MEMO_CONT" , "BUSS_YMD" , "FOREIGN_YN" , "REGIST_YMD" , "MIDAL_YN" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : insert() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_BASIC_CHANGE_HISTORY ")
    .append(" ( SIDO_CODE,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,C_COM_DT,C_COM_CAUSE_CODE,COM_COV_DT,WRT_ID,UPD_DT,INS_DT,WRT_DT,BAS_STA_DT,OFFICE_OWN_CLASS,CHGBRE_SEQ,STA_CHG_CLASS_CODE,RECV_NUM,CHG_DT,MOT_STE,TMP_WRT_NUM,COI_WRT_NUM,REP_MOBILE,HOSCRE,LICTAX,SND_DT,SND_STE,COM_NUM,ADDR_TEL_NUM1,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM1,ADDR_FAX_NUM2,ADDR_FAX_NUM3,REP_MOBILE1,REP_MOBILE2,REP_MOBILE3,COMPANY_DIAG_BAS_DT2,EXT_CHG_CLASS_CODE,REC_DT,SEQ_LINK_ADDR,SEQ_LINK_CAPITAL,SEQ_LINK_NAME,SEQ_LINK_REP,RECV_NUM2,DOC_CODE,GUBUN,MEMO_CONT,BUSS_YMD,FOREIGN_YN,REGIST_YMD,MIDAL_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSIDO_CODE()))
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
           .append(toDB(entity.getC_COM_DT()))
			.append(",")
           .append(toDB(entity.getC_COM_CAUSE_CODE()))
			.append(",")
           .append(toDB(entity.getCOM_COV_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getWRT_DT()))
			.append(",")
           .append(toDB(entity.getBAS_STA_DT()))
			.append(",")
           .append(toDB(entity.getOFFICE_OWN_CLASS()))
			.append(",")
           .append(toDB(entity.getCHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getSTA_CHG_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getCHG_DT()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE()))
			.append(",")
           .append(toDB(entity.getHOSCRE()))
			.append(",")
           .append(toDB(entity.getLICTAX()))
			.append(",")
           .append(toDB(entity.getSND_DT()))
			.append(",")
           .append(toDB(entity.getSND_STE()))
			.append(",")
           .append(toDB(entity.getCOM_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM1()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM2()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM3()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM1()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM2()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM3()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE1()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE2()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE3()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BAS_DT2()))
			.append(",")
           .append(toDB(entity.getEXT_CHG_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getREC_DT()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_ADDR()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_CAPITAL()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_NAME()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_REP()))
			.append(",")
           .append(toDB(entity.getRECV_NUM2()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			.append(",")
           .append(toDB(entity.getBUSS_YMD()))
			.append(",")
           .append(toDB(entity.getFOREIGN_YN()))
			.append(",")
           .append(toDB(entity.getREGIST_YMD()))
			.append(",")
           .append(toDB(entity.getMIDAL_YN()))
			
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

    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : insert() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_BASIC_CHANGE_HISTORY ")
    .append(" ( SIDO_CODE,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,C_COM_DT,C_COM_CAUSE_CODE,COM_COV_DT,WRT_ID,UPD_DT,INS_DT,WRT_DT,BAS_STA_DT,OFFICE_OWN_CLASS,CHGBRE_SEQ,STA_CHG_CLASS_CODE,RECV_NUM,CHG_DT,MOT_STE,TMP_WRT_NUM,COI_WRT_NUM,REP_MOBILE,HOSCRE,LICTAX,SND_DT,SND_STE,COM_NUM,ADDR_TEL_NUM1,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM1,ADDR_FAX_NUM2,ADDR_FAX_NUM3,REP_MOBILE1,REP_MOBILE2,REP_MOBILE3,COMPANY_DIAG_BAS_DT2,EXT_CHG_CLASS_CODE,REC_DT,SEQ_LINK_ADDR,SEQ_LINK_CAPITAL,SEQ_LINK_NAME,SEQ_LINK_REP,RECV_NUM2,DOC_CODE,GUBUN,MEMO_CONT,BUSS_YMD,FOREIGN_YN,REGIST_YMD,MIDAL_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSIDO_CODE()))
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
           .append(toDB(entity.getC_COM_DT()))
			.append(",")
           .append(toDB(entity.getC_COM_CAUSE_CODE()))
			.append(",")
           .append(toDB(entity.getCOM_COV_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getWRT_DT()))
			.append(",")
           .append(toDB(entity.getBAS_STA_DT()))
			.append(",")
           .append(toDB(entity.getOFFICE_OWN_CLASS()))
			.append(",")
           .append(toDB(entity.getCHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getSTA_CHG_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getCHG_DT()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE()))
			.append(",")
           .append(toDB(entity.getHOSCRE()))
			.append(",")
           .append(toDB(entity.getLICTAX()))
			.append(",")
           .append(toDB(entity.getSND_DT()))
			.append(",")
           .append(toDB(entity.getSND_STE()))
			.append(",")
           .append(toDB(entity.getCOM_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM1()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM2()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM3()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM1()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM2()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM3()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE1()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE2()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE3()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BAS_DT2()))
			.append(",")
           .append(toDB(entity.getEXT_CHG_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getREC_DT()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_ADDR()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_CAPITAL()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_NAME()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_REP()))
			.append(",")
           .append(toDB(entity.getRECV_NUM2()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			.append(",")
           .append(toDB(entity.getBUSS_YMD()))
			.append(",")
           .append(toDB(entity.getFOREIGN_YN()))
			.append(",")
           .append(toDB(entity.getREGIST_YMD()))
			.append(",")
           .append(toDB(entity.getMIDAL_YN()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : update() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_BASIC_CHANGE_HISTORY  set ")
       
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
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
        .append("C_COM_DT = ")
        .append(toDB(entity.getC_COM_DT())).append(",")
        .append("C_COM_CAUSE_CODE = ")
        .append(toDB(entity.getC_COM_CAUSE_CODE())).append(",")
        .append("COM_COV_DT = ")
        .append(toDB(entity.getCOM_COV_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT())).append(",")
        .append("BAS_STA_DT = ")
        .append(toDB(entity.getBAS_STA_DT())).append(",")
        .append("OFFICE_OWN_CLASS = ")
        .append(toDB(entity.getOFFICE_OWN_CLASS())).append(",")
        .append("STA_CHG_CLASS_CODE = ")
        .append(toDB(entity.getSTA_CHG_CLASS_CODE())).append(",")
        .append("RECV_NUM = ")
        .append(toDB(entity.getRECV_NUM())).append(",")
        .append("CHG_DT = ")
        .append(toDB(entity.getCHG_DT())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("REP_MOBILE = ")
        .append(toDB(entity.getREP_MOBILE())).append(",")
        .append("HOSCRE = ")
        .append(toDB(entity.getHOSCRE())).append(",")
        .append("LICTAX = ")
        .append(toDB(entity.getLICTAX())).append(",")
        .append("SND_DT = ")
        .append(toDB(entity.getSND_DT())).append(",")
        .append("SND_STE = ")
        .append(toDB(entity.getSND_STE())).append(",")
        .append("COM_NUM = ")
        .append(toDB(entity.getCOM_NUM())).append(",")
        .append("ADDR_TEL_NUM1 = ")
        .append(toDB(entity.getADDR_TEL_NUM1())).append(",")
        .append("ADDR_TEL_NUM2 = ")
        .append(toDB(entity.getADDR_TEL_NUM2())).append(",")
        .append("ADDR_TEL_NUM3 = ")
        .append(toDB(entity.getADDR_TEL_NUM3())).append(",")
        .append("ADDR_FAX_NUM1 = ")
        .append(toDB(entity.getADDR_FAX_NUM1())).append(",")
        .append("ADDR_FAX_NUM2 = ")
        .append(toDB(entity.getADDR_FAX_NUM2())).append(",")
        .append("ADDR_FAX_NUM3 = ")
        .append(toDB(entity.getADDR_FAX_NUM3())).append(",")
        .append("REP_MOBILE1 = ")
        .append(toDB(entity.getREP_MOBILE1())).append(",")
        .append("REP_MOBILE2 = ")
        .append(toDB(entity.getREP_MOBILE2())).append(",")
        .append("REP_MOBILE3 = ")
        .append(toDB(entity.getREP_MOBILE3())).append(",")
        .append("COMPANY_DIAG_BAS_DT2 = ")
        .append(toDB(entity.getCOMPANY_DIAG_BAS_DT2())).append(",")
        .append("EXT_CHG_CLASS_CODE = ")
        .append(toDB(entity.getEXT_CHG_CLASS_CODE())).append(",")
        .append("REC_DT = ")
        .append(toDB(entity.getREC_DT())).append(",")
        .append("SEQ_LINK_ADDR = ")
        .append(toDB(entity.getSEQ_LINK_ADDR())).append(",")
        .append("SEQ_LINK_CAPITAL = ")
        .append(toDB(entity.getSEQ_LINK_CAPITAL())).append(",")
        .append("SEQ_LINK_NAME = ")
        .append(toDB(entity.getSEQ_LINK_NAME())).append(",")
        .append("SEQ_LINK_REP = ")
        .append(toDB(entity.getSEQ_LINK_REP())).append(",")
        .append("RECV_NUM2 = ")
        .append(toDB(entity.getRECV_NUM2())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN())).append(",")
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT())).append(",")
        .append("BUSS_YMD = ")
        .append(toDB(entity.getBUSS_YMD())).append(",")
        .append("FOREIGN_YN = ")
        .append(toDB(entity.getFOREIGN_YN())).append(",")
        .append("REGIST_YMD = ")
        .append(toDB(entity.getREGIST_YMD())).append(",")
        .append("MIDAL_YN = ")
        .append(toDB(entity.getMIDAL_YN()))
        .append(" where  1=1 ");
       
         sb.append(" and CHGBRE_SEQ = ").append( toDB(entity.getCHGBRE_SEQ()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         

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


    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : update() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_BASIC_CHANGE_HISTORY  set ")
       
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
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
        .append("C_COM_DT = ")
        .append(toDB(entity.getC_COM_DT())).append(",")
        .append("C_COM_CAUSE_CODE = ")
        .append(toDB(entity.getC_COM_CAUSE_CODE())).append(",")
        .append("COM_COV_DT = ")
        .append(toDB(entity.getCOM_COV_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT())).append(",")
        .append("BAS_STA_DT = ")
        .append(toDB(entity.getBAS_STA_DT())).append(",")
        .append("OFFICE_OWN_CLASS = ")
        .append(toDB(entity.getOFFICE_OWN_CLASS())).append(",")
        .append("STA_CHG_CLASS_CODE = ")
        .append(toDB(entity.getSTA_CHG_CLASS_CODE())).append(",")
        .append("RECV_NUM = ")
        .append(toDB(entity.getRECV_NUM())).append(",")
        .append("CHG_DT = ")
        .append(toDB(entity.getCHG_DT())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("REP_MOBILE = ")
        .append(toDB(entity.getREP_MOBILE())).append(",")
        .append("HOSCRE = ")
        .append(toDB(entity.getHOSCRE())).append(",")
        .append("LICTAX = ")
        .append(toDB(entity.getLICTAX())).append(",")
        .append("SND_DT = ")
        .append(toDB(entity.getSND_DT())).append(",")
        .append("SND_STE = ")
        .append(toDB(entity.getSND_STE())).append(",")
        .append("COM_NUM = ")
        .append(toDB(entity.getCOM_NUM())).append(",")
        .append("ADDR_TEL_NUM1 = ")
        .append(toDB(entity.getADDR_TEL_NUM1())).append(",")
        .append("ADDR_TEL_NUM2 = ")
        .append(toDB(entity.getADDR_TEL_NUM2())).append(",")
        .append("ADDR_TEL_NUM3 = ")
        .append(toDB(entity.getADDR_TEL_NUM3())).append(",")
        .append("ADDR_FAX_NUM1 = ")
        .append(toDB(entity.getADDR_FAX_NUM1())).append(",")
        .append("ADDR_FAX_NUM2 = ")
        .append(toDB(entity.getADDR_FAX_NUM2())).append(",")
        .append("ADDR_FAX_NUM3 = ")
        .append(toDB(entity.getADDR_FAX_NUM3())).append(",")
        .append("REP_MOBILE1 = ")
        .append(toDB(entity.getREP_MOBILE1())).append(",")
        .append("REP_MOBILE2 = ")
        .append(toDB(entity.getREP_MOBILE2())).append(",")
        .append("REP_MOBILE3 = ")
        .append(toDB(entity.getREP_MOBILE3())).append(",")
        .append("COMPANY_DIAG_BAS_DT2 = ")
        .append(toDB(entity.getCOMPANY_DIAG_BAS_DT2())).append(",")
        .append("EXT_CHG_CLASS_CODE = ")
        .append(toDB(entity.getEXT_CHG_CLASS_CODE())).append(",")
        .append("REC_DT = ")
        .append(toDB(entity.getREC_DT())).append(",")
        .append("SEQ_LINK_ADDR = ")
        .append(toDB(entity.getSEQ_LINK_ADDR())).append(",")
        .append("SEQ_LINK_CAPITAL = ")
        .append(toDB(entity.getSEQ_LINK_CAPITAL())).append(",")
        .append("SEQ_LINK_NAME = ")
        .append(toDB(entity.getSEQ_LINK_NAME())).append(",")
        .append("SEQ_LINK_REP = ")
        .append(toDB(entity.getSEQ_LINK_REP())).append(",")
        .append("RECV_NUM2 = ")
        .append(toDB(entity.getRECV_NUM2())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN())).append(",")
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT())).append(",")
        .append("BUSS_YMD = ")
        .append(toDB(entity.getBUSS_YMD())).append(",")
        .append("FOREIGN_YN = ")
        .append(toDB(entity.getFOREIGN_YN())).append(",")
        .append("REGIST_YMD = ")
        .append(toDB(entity.getREGIST_YMD())).append(",")
        .append("MIDAL_YN = ")
        .append(toDB(entity.getMIDAL_YN()))
        .append(" where  1=1 ");
       
         sb.append(" and CHGBRE_SEQ = ").append( toDB(entity.getCHGBRE_SEQ()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : updateModifiedOnly() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;

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
    sb.append("update PT_R_BASIC_CHANGE_HISTORY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     

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



    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : updateModifiedOnly() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;


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
    sb.append("update PT_R_BASIC_CHANGE_HISTORY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : updateModifiedOnly() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;

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
    sb.append("update PT_R_BASIC_CHANGE_HISTORY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     

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

    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : updateModifiedOnly() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;


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
    sb.append("update PT_R_BASIC_CHANGE_HISTORY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : delete() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_BASIC_CHANGE_HISTORY  where  1=1")
      
	  .append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
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

    if((obj instanceof PT_R_BASIC_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_BASIC_CHANGE_HISTORY : delete() ");
    }
    PT_R_BASIC_CHANGE_HISTORYEntity entity = (PT_R_BASIC_CHANGE_HISTORYEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_BASIC_CHANGE_HISTORY  where  1=1")
      
	  .append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
