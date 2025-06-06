


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_TRANS_STATEMENT_BEFORE
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :
*               TMP_WRT_NUM:VARCHAR2(12):
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
*               COI_WRT_NUM:VARCHAR2(12):
*               REP_MOBILE:VARCHAR2(17):
*               LICTAX:VARCHAR2(1):
*               HOSCRE:VARCHAR2(1):
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
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_TRANS_STATEMENT_BEFOREDAO  extends SuperToDB{

  private String default_fields[]={ "TMP_WRT_NUM" , "SIDO_CODE" , "COMMANA_CLASS" , "MANA_NUM" , "NAME" , "REP_SSN1" , "REP_SSN2" , "REP_NM_KOR" , "REP_NM_HAN" , "REP_TEL_NUM" , "ADDR_POST_NUM" , "ADDR_ADDR" , "ADDR_DETAIL_ADDR" , "ADDR_TEL_NUM" , "ADDR_FAX_NUM" , "EMAIL_ADDR" , "OFFICE_AREA" , "OFFICE_USE_CODE" , "COMPANY_DIAG_CLASS_CODE" , "COMPANY_DIAG_BAS_DT" , "COMPANY_DIAG_ISSUE_DT" , "DIAG_ORG_CODE" , "DIAG_NM_NM" , "DIAG_NM_WRT_NUM" , "PAY_CAP" , "REA_CAP" , "TUP_AOM" , "TUP_CLASS_CODE" , "C_COM_DT" , "C_COM_CAUSE_CODE" , "COM_COV_DT" , "WRT_ID" , "UPD_DT" , "INS_DT" , "WRT_DT" , "BAS_STA_DT" , "OFFICE_OWN_CLASS" , "COI_WRT_NUM" , "REP_MOBILE" , "LICTAX" , "HOSCRE" , "SND_DT" , "SND_STE" , "COM_NUM" , "ADDR_TEL_NUM1" , "ADDR_TEL_NUM2" , "ADDR_TEL_NUM3" , "ADDR_FAX_NUM1" , "ADDR_FAX_NUM2" , "ADDR_FAX_NUM3" , "REP_MOBILE1" , "REP_MOBILE2" , "REP_MOBILE3" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : insert() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_TRANS_STATEMENT_BEFORE ")
    .append(" ( TMP_WRT_NUM,SIDO_CODE,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,C_COM_DT,C_COM_CAUSE_CODE,COM_COV_DT,WRT_ID,UPD_DT,INS_DT,WRT_DT,BAS_STA_DT,OFFICE_OWN_CLASS,COI_WRT_NUM,REP_MOBILE,LICTAX,HOSCRE,SND_DT,SND_STE,COM_NUM,ADDR_TEL_NUM1,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM1,ADDR_FAX_NUM2,ADDR_FAX_NUM3,REP_MOBILE1,REP_MOBILE2,REP_MOBILE3 ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
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
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE()))
			.append(",")
           .append(toDB(entity.getLICTAX()))
			.append(",")
           .append(toDB(entity.getHOSCRE()))
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

    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : insert() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_TRANS_STATEMENT_BEFORE ")
    .append(" ( TMP_WRT_NUM,SIDO_CODE,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,C_COM_DT,C_COM_CAUSE_CODE,COM_COV_DT,WRT_ID,UPD_DT,INS_DT,WRT_DT,BAS_STA_DT,OFFICE_OWN_CLASS,COI_WRT_NUM,REP_MOBILE,LICTAX,HOSCRE,SND_DT,SND_STE,COM_NUM,ADDR_TEL_NUM1,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM1,ADDR_FAX_NUM2,ADDR_FAX_NUM3,REP_MOBILE1,REP_MOBILE2,REP_MOBILE3 ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
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
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE()))
			.append(",")
           .append(toDB(entity.getLICTAX()))
			.append(",")
           .append(toDB(entity.getHOSCRE()))
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
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : update() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_TRANS_STATEMENT_BEFORE  set ")
       
        .append("TMP_WRT_NUM = ")
        .append(toDB(entity.getTMP_WRT_NUM())).append(",")
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
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("REP_MOBILE = ")
        .append(toDB(entity.getREP_MOBILE())).append(",")
        .append("LICTAX = ")
        .append(toDB(entity.getLICTAX())).append(",")
        .append("HOSCRE = ")
        .append(toDB(entity.getHOSCRE())).append(",")
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
        .append(toDB(entity.getREP_MOBILE3()))
        .append(" where  1=1 ");
       

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


    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : update() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_TRANS_STATEMENT_BEFORE  set ")
       
        .append("TMP_WRT_NUM = ")
        .append(toDB(entity.getTMP_WRT_NUM())).append(",")
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
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("REP_MOBILE = ")
        .append(toDB(entity.getREP_MOBILE())).append(",")
        .append("LICTAX = ")
        .append(toDB(entity.getLICTAX())).append(",")
        .append("HOSCRE = ")
        .append(toDB(entity.getHOSCRE())).append(",")
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
        .append(toDB(entity.getREP_MOBILE3()))
        .append(" where  1=1 ");
       

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : updateModifiedOnly() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;

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
    sb.append("update PT_R_TRANS_STATEMENT_BEFORE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     

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



    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : updateModifiedOnly() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;


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
    sb.append("update PT_R_TRANS_STATEMENT_BEFORE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : updateModifiedOnly() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;

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
    sb.append("update PT_R_TRANS_STATEMENT_BEFORE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     

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

    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : updateModifiedOnly() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;


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
    sb.append("update PT_R_TRANS_STATEMENT_BEFORE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : delete() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_TRANS_STATEMENT_BEFORE  where  1=1")
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

    if((obj instanceof PT_R_TRANS_STATEMENT_BEFOREEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_STATEMENT_BEFORE : delete() ");
    }
    PT_R_TRANS_STATEMENT_BEFOREEntity entity = (PT_R_TRANS_STATEMENT_BEFOREEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_TRANS_STATEMENT_BEFORE  where  1=1")
       ;


   return sb.toString();
  }


}//Class End
