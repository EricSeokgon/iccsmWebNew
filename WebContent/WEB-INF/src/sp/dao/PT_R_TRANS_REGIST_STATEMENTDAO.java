


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_TRANS_REGIST_STATEMENT
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SIDO_CODE
*  테이블 컬럼 :
*               RECV_NUM:VARCHAR2(12):
*               SIDO_CODE:VARCHAR2(4):
*               RECV_DT:VARCHAR2(8):
*               RECV_TIME:VARCHAR2(4):
*               PROC_LIM:VARCHAR2(8):
*               OFFI_PART:VARCHAR2(50):
*               OFFI_PART_REBO_WRT_NUM:VARCHAR2(12):
*               NAME:VARCHAR2(50):
*               MANA_NUM:VARCHAR2(18):
*               COM_NUM:VARCHAR2(18):
*               REP_NM_KOR:VARCHAR2(20):
*               REP_NM_HAN:VARCHAR2(20):
*               ADDR_POST_NUM:VARCHAR2(6):
*               ADDR_DETAIL_ADDR:VARCHAR2(200):
*               ADDR_TEL_NUM:VARCHAR2(17):
*               ADDR_FAX_NUM:VARCHAR2(17):
*               DEFI_STE:VARCHAR2(1):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               ADDR_ADDR:VARCHAR2(100):
*               PROC_TIME:VARCHAR2(6):
*               REP_MOBILE:VARCHAR2(17):
*               REP_MOBILE2:VARCHAR2(4):
*               REP_MOBILE3:VARCHAR2(4):
*               ADDR_TEL_NUM2:VARCHAR2(4):
*               ADDR_TEL_NUM3:VARCHAR2(4):
*               ADDR_FAX_NUM2:VARCHAR2(4):
*               ADDR_FAX_NUM3:VARCHAR2(4):
*               ADDR_TEL_NUM1:VARCHAR2(4):
*               ADDR_FAX_NUM1:VARCHAR2(4):
*               REP_MOBILE1:VARCHAR2(4):
*               REP_SSN1:VARCHAR2(18):
*               REP_SSN2:VARCHAR2(21):
*               GUBUN:VARCHAR2(25):
*               COI_WRT_NUM:VARCHAR2(12):
*               MOT_STE:VARCHAR2(6):
*               DOC_CODE:VARCHAR2(50):
*               COMMANA_CLASS:VARCHAR2(3):
*               OFFICE_AREA:VARCHAR2(10):
*               DIAG_ORG_CODE:VARCHAR2(6):
*               DIAG_NM_NM:VARCHAR2(20):
*               COMPANY_DIAG_BAS_DT:VARCHAR2(8):
*               PAY_CAP:VARCHAR2(15):
*               DIAG_NM_WRT_NUM:VARCHAR2(12):
*               COMPANY_DIAG_ISSUE_DT:VARCHAR2(24):
*               REA_CAP:VARCHAR2(15):
*               TUP_CLASS_CODE:VARCHAR2(6):
*               TUP_AOM:VARCHAR2(15):
*               OFFICE_USE_NAME:VARCHAR2(50):
*               OFFICE_OWN_CLASS:VARCHAR2(1):
*               LICTAX:VARCHAR2(1):
*               HOSCRE:VARCHAR2(1):
*               MEMO_CONT:VARCHAR2(256):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_TRANS_REGIST_STATEMENTDAO  extends SuperToDB{

  private String default_fields[]={ "RECV_NUM" , "SIDO_CODE" , "RECV_DT" , "RECV_TIME" , "PROC_LIM" , "OFFI_PART" , "OFFI_PART_REBO_WRT_NUM" , "NAME" , "MANA_NUM" , "COM_NUM" , "REP_NM_KOR" , "REP_NM_HAN" , "ADDR_POST_NUM" , "ADDR_DETAIL_ADDR" , "ADDR_TEL_NUM" , "ADDR_FAX_NUM" , "DEFI_STE" , "WRT_ID" , "UPD_DT" , "INS_DT" , "ADDR_ADDR" , "PROC_TIME" , "REP_MOBILE" , "REP_MOBILE2" , "REP_MOBILE3" , "ADDR_TEL_NUM2" , "ADDR_TEL_NUM3" , "ADDR_FAX_NUM2" , "ADDR_FAX_NUM3" , "ADDR_TEL_NUM1" , "ADDR_FAX_NUM1" , "REP_MOBILE1" , "REP_SSN1" , "REP_SSN2" , "GUBUN" , "COI_WRT_NUM" , "MOT_STE" , "DOC_CODE" , "COMMANA_CLASS" , "OFFICE_AREA" , "DIAG_ORG_CODE" , "DIAG_NM_NM" , "COMPANY_DIAG_BAS_DT" , "PAY_CAP" , "DIAG_NM_WRT_NUM" , "COMPANY_DIAG_ISSUE_DT" , "REA_CAP" , "TUP_CLASS_CODE" , "TUP_AOM" , "OFFICE_USE_NAME" , "OFFICE_OWN_CLASS" , "LICTAX" , "HOSCRE" , "MEMO_CONT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : insert() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_TRANS_REGIST_STATEMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,RECV_DT,RECV_TIME,PROC_LIM,OFFI_PART,OFFI_PART_REBO_WRT_NUM,NAME,MANA_NUM,COM_NUM,REP_NM_KOR,REP_NM_HAN,ADDR_POST_NUM,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,DEFI_STE,WRT_ID,UPD_DT,INS_DT,ADDR_ADDR,PROC_TIME,REP_MOBILE,REP_MOBILE2,REP_MOBILE3,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM2,ADDR_FAX_NUM3,ADDR_TEL_NUM1,ADDR_FAX_NUM1,REP_MOBILE1,REP_SSN1,REP_SSN2,GUBUN,COI_WRT_NUM,MOT_STE,DOC_CODE,COMMANA_CLASS,OFFICE_AREA,DIAG_ORG_CODE,DIAG_NM_NM,COMPANY_DIAG_BAS_DT,PAY_CAP,DIAG_NM_WRT_NUM,COMPANY_DIAG_ISSUE_DT,REA_CAP,TUP_CLASS_CODE,TUP_AOM,OFFICE_USE_NAME,OFFICE_OWN_CLASS,LICTAX,HOSCRE,MEMO_CONT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getRECV_TIME()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getOFFI_PART()))
			.append(",")
           .append(toDB(entity.getOFFI_PART_REBO_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getNAME()))
			.append(",")
           .append(toDB(entity.getMANA_NUM()))
			.append(",")
           .append(toDB(entity.getCOM_NUM()))
			.append(",")
           .append(toDB(entity.getREP_NM_KOR()))
			.append(",")
           .append(toDB(entity.getREP_NM_HAN()))
			.append(",")
           .append(toDB(entity.getADDR_POST_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM()))
			.append(",")
           .append(toDB(entity.getDEFI_STE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getADDR_ADDR()))
			.append(",")
           .append(toDB(entity.getPROC_TIME()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE2()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE3()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM2()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM3()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM2()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM3()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM1()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM1()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE1()))
			.append(",")
           .append(toDB(entity.getREP_SSN1()))
			.append(",")
           .append(toDB(entity.getREP_SSN2()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getCOMMANA_CLASS()))
			.append(",")
           .append(toDB(entity.getOFFICE_AREA()))
			.append(",")
           .append(toDB(entity.getDIAG_ORG_CODE()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_NM()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BAS_DT()))
			.append(",")
           .append(toDB(entity.getPAY_CAP()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_ISSUE_DT()))
			.append(",")
           .append(toDB(entity.getREA_CAP()))
			.append(",")
           .append(toDB(entity.getTUP_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getTUP_AOM()))
			.append(",")
           .append(toDB(entity.getOFFICE_USE_NAME()))
			.append(",")
           .append(toDB(entity.getOFFICE_OWN_CLASS()))
			.append(",")
           .append(toDB(entity.getLICTAX()))
			.append(",")
           .append(toDB(entity.getHOSCRE()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			
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

    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : insert() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_TRANS_REGIST_STATEMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,RECV_DT,RECV_TIME,PROC_LIM,OFFI_PART,OFFI_PART_REBO_WRT_NUM,NAME,MANA_NUM,COM_NUM,REP_NM_KOR,REP_NM_HAN,ADDR_POST_NUM,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,DEFI_STE,WRT_ID,UPD_DT,INS_DT,ADDR_ADDR,PROC_TIME,REP_MOBILE,REP_MOBILE2,REP_MOBILE3,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM2,ADDR_FAX_NUM3,ADDR_TEL_NUM1,ADDR_FAX_NUM1,REP_MOBILE1,REP_SSN1,REP_SSN2,GUBUN,COI_WRT_NUM,MOT_STE,DOC_CODE,COMMANA_CLASS,OFFICE_AREA,DIAG_ORG_CODE,DIAG_NM_NM,COMPANY_DIAG_BAS_DT,PAY_CAP,DIAG_NM_WRT_NUM,COMPANY_DIAG_ISSUE_DT,REA_CAP,TUP_CLASS_CODE,TUP_AOM,OFFICE_USE_NAME,OFFICE_OWN_CLASS,LICTAX,HOSCRE,MEMO_CONT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getRECV_TIME()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getOFFI_PART()))
			.append(",")
           .append(toDB(entity.getOFFI_PART_REBO_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getNAME()))
			.append(",")
           .append(toDB(entity.getMANA_NUM()))
			.append(",")
           .append(toDB(entity.getCOM_NUM()))
			.append(",")
           .append(toDB(entity.getREP_NM_KOR()))
			.append(",")
           .append(toDB(entity.getREP_NM_HAN()))
			.append(",")
           .append(toDB(entity.getADDR_POST_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM()))
			.append(",")
           .append(toDB(entity.getDEFI_STE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getADDR_ADDR()))
			.append(",")
           .append(toDB(entity.getPROC_TIME()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE2()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE3()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM2()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM3()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM2()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM3()))
			.append(",")
           .append(toDB(entity.getADDR_TEL_NUM1()))
			.append(",")
           .append(toDB(entity.getADDR_FAX_NUM1()))
			.append(",")
           .append(toDB(entity.getREP_MOBILE1()))
			.append(",")
           .append(toDB(entity.getREP_SSN1()))
			.append(",")
           .append(toDB(entity.getREP_SSN2()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getCOMMANA_CLASS()))
			.append(",")
           .append(toDB(entity.getOFFICE_AREA()))
			.append(",")
           .append(toDB(entity.getDIAG_ORG_CODE()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_NM()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BAS_DT()))
			.append(",")
           .append(toDB(entity.getPAY_CAP()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_ISSUE_DT()))
			.append(",")
           .append(toDB(entity.getREA_CAP()))
			.append(",")
           .append(toDB(entity.getTUP_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getTUP_AOM()))
			.append(",")
           .append(toDB(entity.getOFFICE_USE_NAME()))
			.append(",")
           .append(toDB(entity.getOFFICE_OWN_CLASS()))
			.append(",")
           .append(toDB(entity.getLICTAX()))
			.append(",")
           .append(toDB(entity.getHOSCRE()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : update() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_TRANS_REGIST_STATEMENT  set ")
       
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("RECV_TIME = ")
        .append(toDB(entity.getRECV_TIME())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("OFFI_PART = ")
        .append(toDB(entity.getOFFI_PART())).append(",")
        .append("OFFI_PART_REBO_WRT_NUM = ")
        .append(toDB(entity.getOFFI_PART_REBO_WRT_NUM())).append(",")
        .append("NAME = ")
        .append(toDB(entity.getNAME())).append(",")
        .append("MANA_NUM = ")
        .append(toDB(entity.getMANA_NUM())).append(",")
        .append("COM_NUM = ")
        .append(toDB(entity.getCOM_NUM())).append(",")
        .append("REP_NM_KOR = ")
        .append(toDB(entity.getREP_NM_KOR())).append(",")
        .append("REP_NM_HAN = ")
        .append(toDB(entity.getREP_NM_HAN())).append(",")
        .append("ADDR_POST_NUM = ")
        .append(toDB(entity.getADDR_POST_NUM())).append(",")
        .append("ADDR_DETAIL_ADDR = ")
        .append(toDB(entity.getADDR_DETAIL_ADDR())).append(",")
        .append("ADDR_TEL_NUM = ")
        .append(toDB(entity.getADDR_TEL_NUM())).append(",")
        .append("ADDR_FAX_NUM = ")
        .append(toDB(entity.getADDR_FAX_NUM())).append(",")
        .append("DEFI_STE = ")
        .append(toDB(entity.getDEFI_STE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("ADDR_ADDR = ")
        .append(toDB(entity.getADDR_ADDR())).append(",")
        .append("PROC_TIME = ")
        .append(toDB(entity.getPROC_TIME())).append(",")
        .append("REP_MOBILE = ")
        .append(toDB(entity.getREP_MOBILE())).append(",")
        .append("REP_MOBILE2 = ")
        .append(toDB(entity.getREP_MOBILE2())).append(",")
        .append("REP_MOBILE3 = ")
        .append(toDB(entity.getREP_MOBILE3())).append(",")
        .append("ADDR_TEL_NUM2 = ")
        .append(toDB(entity.getADDR_TEL_NUM2())).append(",")
        .append("ADDR_TEL_NUM3 = ")
        .append(toDB(entity.getADDR_TEL_NUM3())).append(",")
        .append("ADDR_FAX_NUM2 = ")
        .append(toDB(entity.getADDR_FAX_NUM2())).append(",")
        .append("ADDR_FAX_NUM3 = ")
        .append(toDB(entity.getADDR_FAX_NUM3())).append(",")
        .append("ADDR_TEL_NUM1 = ")
        .append(toDB(entity.getADDR_TEL_NUM1())).append(",")
        .append("ADDR_FAX_NUM1 = ")
        .append(toDB(entity.getADDR_FAX_NUM1())).append(",")
        .append("REP_MOBILE1 = ")
        .append(toDB(entity.getREP_MOBILE1())).append(",")
        .append("REP_SSN1 = ")
        .append(toDB(entity.getREP_SSN1())).append(",")
        .append("REP_SSN2 = ")
        .append(toDB(entity.getREP_SSN2())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("COMMANA_CLASS = ")
        .append(toDB(entity.getCOMMANA_CLASS())).append(",")
        .append("OFFICE_AREA = ")
        .append(toDB(entity.getOFFICE_AREA())).append(",")
        .append("DIAG_ORG_CODE = ")
        .append(toDB(entity.getDIAG_ORG_CODE())).append(",")
        .append("DIAG_NM_NM = ")
        .append(toDB(entity.getDIAG_NM_NM())).append(",")
        .append("COMPANY_DIAG_BAS_DT = ")
        .append(toDB(entity.getCOMPANY_DIAG_BAS_DT())).append(",")
        .append("PAY_CAP = ")
        .append(toDB(entity.getPAY_CAP())).append(",")
        .append("DIAG_NM_WRT_NUM = ")
        .append(toDB(entity.getDIAG_NM_WRT_NUM())).append(",")
        .append("COMPANY_DIAG_ISSUE_DT = ")
        .append(toDB(entity.getCOMPANY_DIAG_ISSUE_DT())).append(",")
        .append("REA_CAP = ")
        .append(toDB(entity.getREA_CAP())).append(",")
        .append("TUP_CLASS_CODE = ")
        .append(toDB(entity.getTUP_CLASS_CODE())).append(",")
        .append("TUP_AOM = ")
        .append(toDB(entity.getTUP_AOM())).append(",")
        .append("OFFICE_USE_NAME = ")
        .append(toDB(entity.getOFFICE_USE_NAME())).append(",")
        .append("OFFICE_OWN_CLASS = ")
        .append(toDB(entity.getOFFICE_OWN_CLASS())).append(",")
        .append("LICTAX = ")
        .append(toDB(entity.getLICTAX())).append(",")
        .append("HOSCRE = ")
        .append(toDB(entity.getHOSCRE())).append(",")
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT()))
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


    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : update() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_TRANS_REGIST_STATEMENT  set ")
       
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("RECV_TIME = ")
        .append(toDB(entity.getRECV_TIME())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("OFFI_PART = ")
        .append(toDB(entity.getOFFI_PART())).append(",")
        .append("OFFI_PART_REBO_WRT_NUM = ")
        .append(toDB(entity.getOFFI_PART_REBO_WRT_NUM())).append(",")
        .append("NAME = ")
        .append(toDB(entity.getNAME())).append(",")
        .append("MANA_NUM = ")
        .append(toDB(entity.getMANA_NUM())).append(",")
        .append("COM_NUM = ")
        .append(toDB(entity.getCOM_NUM())).append(",")
        .append("REP_NM_KOR = ")
        .append(toDB(entity.getREP_NM_KOR())).append(",")
        .append("REP_NM_HAN = ")
        .append(toDB(entity.getREP_NM_HAN())).append(",")
        .append("ADDR_POST_NUM = ")
        .append(toDB(entity.getADDR_POST_NUM())).append(",")
        .append("ADDR_DETAIL_ADDR = ")
        .append(toDB(entity.getADDR_DETAIL_ADDR())).append(",")
        .append("ADDR_TEL_NUM = ")
        .append(toDB(entity.getADDR_TEL_NUM())).append(",")
        .append("ADDR_FAX_NUM = ")
        .append(toDB(entity.getADDR_FAX_NUM())).append(",")
        .append("DEFI_STE = ")
        .append(toDB(entity.getDEFI_STE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("ADDR_ADDR = ")
        .append(toDB(entity.getADDR_ADDR())).append(",")
        .append("PROC_TIME = ")
        .append(toDB(entity.getPROC_TIME())).append(",")
        .append("REP_MOBILE = ")
        .append(toDB(entity.getREP_MOBILE())).append(",")
        .append("REP_MOBILE2 = ")
        .append(toDB(entity.getREP_MOBILE2())).append(",")
        .append("REP_MOBILE3 = ")
        .append(toDB(entity.getREP_MOBILE3())).append(",")
        .append("ADDR_TEL_NUM2 = ")
        .append(toDB(entity.getADDR_TEL_NUM2())).append(",")
        .append("ADDR_TEL_NUM3 = ")
        .append(toDB(entity.getADDR_TEL_NUM3())).append(",")
        .append("ADDR_FAX_NUM2 = ")
        .append(toDB(entity.getADDR_FAX_NUM2())).append(",")
        .append("ADDR_FAX_NUM3 = ")
        .append(toDB(entity.getADDR_FAX_NUM3())).append(",")
        .append("ADDR_TEL_NUM1 = ")
        .append(toDB(entity.getADDR_TEL_NUM1())).append(",")
        .append("ADDR_FAX_NUM1 = ")
        .append(toDB(entity.getADDR_FAX_NUM1())).append(",")
        .append("REP_MOBILE1 = ")
        .append(toDB(entity.getREP_MOBILE1())).append(",")
        .append("REP_SSN1 = ")
        .append(toDB(entity.getREP_SSN1())).append(",")
        .append("REP_SSN2 = ")
        .append(toDB(entity.getREP_SSN2())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("COMMANA_CLASS = ")
        .append(toDB(entity.getCOMMANA_CLASS())).append(",")
        .append("OFFICE_AREA = ")
        .append(toDB(entity.getOFFICE_AREA())).append(",")
        .append("DIAG_ORG_CODE = ")
        .append(toDB(entity.getDIAG_ORG_CODE())).append(",")
        .append("DIAG_NM_NM = ")
        .append(toDB(entity.getDIAG_NM_NM())).append(",")
        .append("COMPANY_DIAG_BAS_DT = ")
        .append(toDB(entity.getCOMPANY_DIAG_BAS_DT())).append(",")
        .append("PAY_CAP = ")
        .append(toDB(entity.getPAY_CAP())).append(",")
        .append("DIAG_NM_WRT_NUM = ")
        .append(toDB(entity.getDIAG_NM_WRT_NUM())).append(",")
        .append("COMPANY_DIAG_ISSUE_DT = ")
        .append(toDB(entity.getCOMPANY_DIAG_ISSUE_DT())).append(",")
        .append("REA_CAP = ")
        .append(toDB(entity.getREA_CAP())).append(",")
        .append("TUP_CLASS_CODE = ")
        .append(toDB(entity.getTUP_CLASS_CODE())).append(",")
        .append("TUP_AOM = ")
        .append(toDB(entity.getTUP_AOM())).append(",")
        .append("OFFICE_USE_NAME = ")
        .append(toDB(entity.getOFFICE_USE_NAME())).append(",")
        .append("OFFICE_OWN_CLASS = ")
        .append(toDB(entity.getOFFICE_OWN_CLASS())).append(",")
        .append("LICTAX = ")
        .append(toDB(entity.getLICTAX())).append(",")
        .append("HOSCRE = ")
        .append(toDB(entity.getHOSCRE())).append(",")
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT()))
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



    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;

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
    sb.append("update PT_R_TRANS_REGIST_STATEMENT  set " )
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



    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;


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
    sb.append("update PT_R_TRANS_REGIST_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;

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
    sb.append("update PT_R_TRANS_REGIST_STATEMENT  set " )
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

    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;


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
    sb.append("update PT_R_TRANS_REGIST_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : delete() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_TRANS_REGIST_STATEMENT  where  1=1")
      
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

    if((obj instanceof PT_R_TRANS_REGIST_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_TRANS_REGIST_STATEMENT : delete() ");
    }
    PT_R_TRANS_REGIST_STATEMENTEntity entity = (PT_R_TRANS_REGIST_STATEMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_TRANS_REGIST_STATEMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
       ;


   return sb.toString();
  }


}//Class End
