


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

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_UB_CONSTRUCTIONDAO  extends SuperToDB{

  private String default_fields[]={ "ORPE_NM" , "ORPE_TEL" , "ORPE_POSTNUM" , "ORPE_ADDR" , "ORPE_DETAILADDR" , "PLANER_NAME" , "PLANER_NM" , "PLANER_TEL" , "PLANER_POSTNUM" , "PLANER_ADDR" , "PLANER_DETAILADDR" , "RECV_DT" , "STRU_COMMIT_NUM" , "STRU_ADDR_POSTNUM" , "STRU_ADDR_ADDR" , "STRU_ADDR_DETAILADDR" , "USE" , "AREA" , "NUM_FL" , "WORK_ITEM" , "STE" , "SUV_APPL" , "CONFIRMER_NM" , "CONFIRMER_POSI" , "CONFIRMER_TEL" , "INSP_OPIN" , "PRE_ITEM" , "SW_BEF_REPO_DELINUM" , "REPO_DT" , "WRT_ID" , "CIV_RECV_NUM" , "SIDO_CODE" , "SIGUNGU_CODE" , "INS_DT" , "UPD_DT" , "RECV_NUM" , "INSP_BAS" , "CER_DELI_NUM" , "CER_DELI_CONFIRM" , "INSP_APPL_DT" , "PROC_STE" , "CER_DELI_YN" , "PROC_OFFI_NM" , "WORK_ITEM_ETC" , "ETC_INSP_BAS" , "UPD_DT_OLD" , "BACKUP_TRANS_DT" , "CONFIRMER_OFFI_ID" , "CHG_INSP" , "STRU_INFO_BIGO" , "USE_ETC" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : insert() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_CONSTRUCTION ")
    .append(" ( ORPE_NM,ORPE_TEL,ORPE_POSTNUM,ORPE_ADDR,ORPE_DETAILADDR,PLANER_NAME,PLANER_NM,PLANER_TEL,PLANER_POSTNUM,PLANER_ADDR,PLANER_DETAILADDR,RECV_DT,STRU_COMMIT_NUM,STRU_ADDR_POSTNUM,STRU_ADDR_ADDR,STRU_ADDR_DETAILADDR,USE,AREA,NUM_FL,WORK_ITEM,STE,SUV_APPL,CONFIRMER_NM,CONFIRMER_POSI,CONFIRMER_TEL,INSP_OPIN,PRE_ITEM,SW_BEF_REPO_DELINUM,REPO_DT,WRT_ID,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,INS_DT,UPD_DT,RECV_NUM,INSP_BAS,CER_DELI_NUM,CER_DELI_CONFIRM,INSP_APPL_DT,PROC_STE,CER_DELI_YN,PROC_OFFI_NM,WORK_ITEM_ETC,ETC_INSP_BAS,UPD_DT_OLD,BACKUP_TRANS_DT,CONFIRMER_OFFI_ID,CHG_INSP,STRU_INFO_BIGO,USE_ETC ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getORPE_NM()))
			.append(",")
           .append(toDB(entity.getORPE_TEL()))
			.append(",")
           .append(toDB(entity.getORPE_POSTNUM()))
			.append(",")
           .append(toDB(entity.getORPE_ADDR()))
			.append(",")
           .append(toDB(entity.getORPE_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getPLANER_NAME()))
			.append(",")
           .append(toDB(entity.getPLANER_NM()))
			.append(",")
           .append(toDB(entity.getPLANER_TEL()))
			.append(",")
           .append(toDB(entity.getPLANER_POSTNUM()))
			.append(",")
           .append(toDB(entity.getPLANER_ADDR()))
			.append(",")
           .append(toDB(entity.getPLANER_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getSTRU_COMMIT_NUM()))
			.append(",")
           .append(toDB(entity.getSTRU_ADDR_POSTNUM()))
			.append(",")
           .append(toDB(entity.getSTRU_ADDR_ADDR()))
			.append(",")
           .append(toDB(entity.getSTRU_ADDR_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getUSE()))
			.append(",")
           .append(toDB(entity.getAREA()))
			.append(",")
           .append(toDB(entity.getNUM_FL()))
			.append(",")
           .append(toDB(entity.getWORK_ITEM()))
			.append(",")
           .append(toDB(entity.getSTE()))
			.append(",")
           .append(toDB(entity.getSUV_APPL()))
			.append(",")
           .append(toDB(entity.getCONFIRMER_NM()))
			.append(",")
           .append(toDB(entity.getCONFIRMER_POSI()))
			.append(",")
           .append(toDB(entity.getCONFIRMER_TEL()))
			.append(",")
           .append(toDB(entity.getINSP_OPIN()))
			.append(",")
           .append(toDB(entity.getPRE_ITEM()))
			.append(",")
           .append(toDB(entity.getSW_BEF_REPO_DELINUM()))
			.append(",")
           .append(toDB(entity.getREPO_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getCIV_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getINSP_BAS()))
			.append(",")
           .append(toDB(entity.getCER_DELI_NUM()))
			.append(",")
           .append(toDB(entity.getCER_DELI_CONFIRM()))
			.append(",")
           .append(toDB(entity.getINSP_APPL_DT()))
			.append(",")
           .append(toDB(entity.getPROC_STE()))
			.append(",")
           .append(toDB(entity.getCER_DELI_YN()))
			.append(",")
           .append(toDB(entity.getPROC_OFFI_NM()))
			.append(",")
           .append(toDB(entity.getWORK_ITEM_ETC()))
			.append(",")
           .append(toDB(entity.getETC_INSP_BAS()))
			.append(",")
           .append(toDB(entity.getUPD_DT_OLD()))
			.append(",")
           .append(toDB(entity.getBACKUP_TRANS_DT()))
			.append(",")
           .append(toDB(entity.getCONFIRMER_OFFI_ID()))
			.append(",")
           .append(toDB(entity.getCHG_INSP()))
			.append(",")
           .append(toDB(entity.getSTRU_INFO_BIGO()))
			.append(",")
           .append(toDB(entity.getUSE_ETC()))
			
          			
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

    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : insert() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_CONSTRUCTION ")
    .append(" ( ORPE_NM,ORPE_TEL,ORPE_POSTNUM,ORPE_ADDR,ORPE_DETAILADDR,PLANER_NAME,PLANER_NM,PLANER_TEL,PLANER_POSTNUM,PLANER_ADDR,PLANER_DETAILADDR,RECV_DT,STRU_COMMIT_NUM,STRU_ADDR_POSTNUM,STRU_ADDR_ADDR,STRU_ADDR_DETAILADDR,USE,AREA,NUM_FL,WORK_ITEM,STE,SUV_APPL,CONFIRMER_NM,CONFIRMER_POSI,CONFIRMER_TEL,INSP_OPIN,PRE_ITEM,SW_BEF_REPO_DELINUM,REPO_DT,WRT_ID,CIV_RECV_NUM,SIDO_CODE,SIGUNGU_CODE,INS_DT,UPD_DT,RECV_NUM,INSP_BAS,CER_DELI_NUM,CER_DELI_CONFIRM,INSP_APPL_DT,PROC_STE,CER_DELI_YN,PROC_OFFI_NM,WORK_ITEM_ETC,ETC_INSP_BAS,UPD_DT_OLD,BACKUP_TRANS_DT,CONFIRMER_OFFI_ID,CHG_INSP,STRU_INFO_BIGO,USE_ETC ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getORPE_NM()))
			.append(",")
           .append(toDB(entity.getORPE_TEL()))
			.append(",")
           .append(toDB(entity.getORPE_POSTNUM()))
			.append(",")
           .append(toDB(entity.getORPE_ADDR()))
			.append(",")
           .append(toDB(entity.getORPE_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getPLANER_NAME()))
			.append(",")
           .append(toDB(entity.getPLANER_NM()))
			.append(",")
           .append(toDB(entity.getPLANER_TEL()))
			.append(",")
           .append(toDB(entity.getPLANER_POSTNUM()))
			.append(",")
           .append(toDB(entity.getPLANER_ADDR()))
			.append(",")
           .append(toDB(entity.getPLANER_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getSTRU_COMMIT_NUM()))
			.append(",")
           .append(toDB(entity.getSTRU_ADDR_POSTNUM()))
			.append(",")
           .append(toDB(entity.getSTRU_ADDR_ADDR()))
			.append(",")
           .append(toDB(entity.getSTRU_ADDR_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getUSE()))
			.append(",")
           .append(toDB(entity.getAREA()))
			.append(",")
           .append(toDB(entity.getNUM_FL()))
			.append(",")
           .append(toDB(entity.getWORK_ITEM()))
			.append(",")
           .append(toDB(entity.getSTE()))
			.append(",")
           .append(toDB(entity.getSUV_APPL()))
			.append(",")
           .append(toDB(entity.getCONFIRMER_NM()))
			.append(",")
           .append(toDB(entity.getCONFIRMER_POSI()))
			.append(",")
           .append(toDB(entity.getCONFIRMER_TEL()))
			.append(",")
           .append(toDB(entity.getINSP_OPIN()))
			.append(",")
           .append(toDB(entity.getPRE_ITEM()))
			.append(",")
           .append(toDB(entity.getSW_BEF_REPO_DELINUM()))
			.append(",")
           .append(toDB(entity.getREPO_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getCIV_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getINSP_BAS()))
			.append(",")
           .append(toDB(entity.getCER_DELI_NUM()))
			.append(",")
           .append(toDB(entity.getCER_DELI_CONFIRM()))
			.append(",")
           .append(toDB(entity.getINSP_APPL_DT()))
			.append(",")
           .append(toDB(entity.getPROC_STE()))
			.append(",")
           .append(toDB(entity.getCER_DELI_YN()))
			.append(",")
           .append(toDB(entity.getPROC_OFFI_NM()))
			.append(",")
           .append(toDB(entity.getWORK_ITEM_ETC()))
			.append(",")
           .append(toDB(entity.getETC_INSP_BAS()))
			.append(",")
           .append(toDB(entity.getUPD_DT_OLD()))
			.append(",")
           .append(toDB(entity.getBACKUP_TRANS_DT()))
			.append(",")
           .append(toDB(entity.getCONFIRMER_OFFI_ID()))
			.append(",")
           .append(toDB(entity.getCHG_INSP()))
			.append(",")
           .append(toDB(entity.getSTRU_INFO_BIGO()))
			.append(",")
           .append(toDB(entity.getUSE_ETC()))
			
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : update() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_CONSTRUCTION  set ")
       
        .append("ORPE_NM = ")
        .append(toDB(entity.getORPE_NM())).append(",")
        .append("ORPE_TEL = ")
        .append(toDB(entity.getORPE_TEL())).append(",")
        .append("ORPE_POSTNUM = ")
        .append(toDB(entity.getORPE_POSTNUM())).append(",")
        .append("ORPE_ADDR = ")
        .append(toDB(entity.getORPE_ADDR())).append(",")
        .append("ORPE_DETAILADDR = ")
        .append(toDB(entity.getORPE_DETAILADDR())).append(",")
        .append("PLANER_NAME = ")
        .append(toDB(entity.getPLANER_NAME())).append(",")
        .append("PLANER_NM = ")
        .append(toDB(entity.getPLANER_NM())).append(",")
        .append("PLANER_TEL = ")
        .append(toDB(entity.getPLANER_TEL())).append(",")
        .append("PLANER_POSTNUM = ")
        .append(toDB(entity.getPLANER_POSTNUM())).append(",")
        .append("PLANER_ADDR = ")
        .append(toDB(entity.getPLANER_ADDR())).append(",")
        .append("PLANER_DETAILADDR = ")
        .append(toDB(entity.getPLANER_DETAILADDR())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("STRU_COMMIT_NUM = ")
        .append(toDB(entity.getSTRU_COMMIT_NUM())).append(",")
        .append("STRU_ADDR_POSTNUM = ")
        .append(toDB(entity.getSTRU_ADDR_POSTNUM())).append(",")
        .append("STRU_ADDR_ADDR = ")
        .append(toDB(entity.getSTRU_ADDR_ADDR())).append(",")
        .append("STRU_ADDR_DETAILADDR = ")
        .append(toDB(entity.getSTRU_ADDR_DETAILADDR())).append(",")
        .append("USE = ")
        .append(toDB(entity.getUSE())).append(",")
        .append("AREA = ")
        .append(toDB(entity.getAREA())).append(",")
        .append("NUM_FL = ")
        .append(toDB(entity.getNUM_FL())).append(",")
        .append("WORK_ITEM = ")
        .append(toDB(entity.getWORK_ITEM())).append(",")
        .append("STE = ")
        .append(toDB(entity.getSTE())).append(",")
        .append("SUV_APPL = ")
        .append(toDB(entity.getSUV_APPL())).append(",")
        .append("CONFIRMER_NM = ")
        .append(toDB(entity.getCONFIRMER_NM())).append(",")
        .append("CONFIRMER_POSI = ")
        .append(toDB(entity.getCONFIRMER_POSI())).append(",")
        .append("CONFIRMER_TEL = ")
        .append(toDB(entity.getCONFIRMER_TEL())).append(",")
        .append("INSP_OPIN = ")
        .append(toDB(entity.getINSP_OPIN())).append(",")
        .append("PRE_ITEM = ")
        .append(toDB(entity.getPRE_ITEM())).append(",")
        .append("SW_BEF_REPO_DELINUM = ")
        .append(toDB(entity.getSW_BEF_REPO_DELINUM())).append(",")
        .append("REPO_DT = ")
        .append(toDB(entity.getREPO_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("CIV_RECV_NUM = ")
        .append(toDB(entity.getCIV_RECV_NUM())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INSP_BAS = ")
        .append(toDB(entity.getINSP_BAS())).append(",")
        .append("CER_DELI_NUM = ")
        .append(toDB(entity.getCER_DELI_NUM())).append(",")
        .append("CER_DELI_CONFIRM = ")
        .append(toDB(entity.getCER_DELI_CONFIRM())).append(",")
        .append("INSP_APPL_DT = ")
        .append(toDB(entity.getINSP_APPL_DT())).append(",")
        .append("PROC_STE = ")
        .append(toDB(entity.getPROC_STE())).append(",")
        .append("CER_DELI_YN = ")
        .append(toDB(entity.getCER_DELI_YN())).append(",")
        .append("PROC_OFFI_NM = ")
        .append(toDB(entity.getPROC_OFFI_NM())).append(",")
        .append("WORK_ITEM_ETC = ")
        .append(toDB(entity.getWORK_ITEM_ETC())).append(",")
        .append("ETC_INSP_BAS = ")
        .append(toDB(entity.getETC_INSP_BAS())).append(",")
        .append("UPD_DT_OLD = ")
        .append(toDB(entity.getUPD_DT_OLD())).append(",")
        .append("BACKUP_TRANS_DT = ")
        .append(toDB(entity.getBACKUP_TRANS_DT())).append(",")
        .append("CONFIRMER_OFFI_ID = ")
        .append(toDB(entity.getCONFIRMER_OFFI_ID())).append(",")
        .append("CHG_INSP = ")
        .append(toDB(entity.getCHG_INSP())).append(",")
        .append("STRU_INFO_BIGO = ")
        .append(toDB(entity.getSTRU_INFO_BIGO())).append(",")
        .append("USE_ETC = ")
        .append(toDB(entity.getUSE_ETC()))
            .append(" where  1=1 ");
       
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and SIGUNGU_CODE = ").append( toDB(entity.getSIGUNGU_CODE()));
         
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         


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


    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : update() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_CONSTRUCTION  set ")
       
        .append("ORPE_NM = ")
        .append(toDB(entity.getORPE_NM())).append(",")
        .append("ORPE_TEL = ")
        .append(toDB(entity.getORPE_TEL())).append(",")
        .append("ORPE_POSTNUM = ")
        .append(toDB(entity.getORPE_POSTNUM())).append(",")
        .append("ORPE_ADDR = ")
        .append(toDB(entity.getORPE_ADDR())).append(",")
        .append("ORPE_DETAILADDR = ")
        .append(toDB(entity.getORPE_DETAILADDR())).append(",")
        .append("PLANER_NAME = ")
        .append(toDB(entity.getPLANER_NAME())).append(",")
        .append("PLANER_NM = ")
        .append(toDB(entity.getPLANER_NM())).append(",")
        .append("PLANER_TEL = ")
        .append(toDB(entity.getPLANER_TEL())).append(",")
        .append("PLANER_POSTNUM = ")
        .append(toDB(entity.getPLANER_POSTNUM())).append(",")
        .append("PLANER_ADDR = ")
        .append(toDB(entity.getPLANER_ADDR())).append(",")
        .append("PLANER_DETAILADDR = ")
        .append(toDB(entity.getPLANER_DETAILADDR())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("STRU_COMMIT_NUM = ")
        .append(toDB(entity.getSTRU_COMMIT_NUM())).append(",")
        .append("STRU_ADDR_POSTNUM = ")
        .append(toDB(entity.getSTRU_ADDR_POSTNUM())).append(",")
        .append("STRU_ADDR_ADDR = ")
        .append(toDB(entity.getSTRU_ADDR_ADDR())).append(",")
        .append("STRU_ADDR_DETAILADDR = ")
        .append(toDB(entity.getSTRU_ADDR_DETAILADDR())).append(",")
        .append("USE = ")
        .append(toDB(entity.getUSE())).append(",")
        .append("AREA = ")
        .append(toDB(entity.getAREA())).append(",")
        .append("NUM_FL = ")
        .append(toDB(entity.getNUM_FL())).append(",")
        .append("WORK_ITEM = ")
        .append(toDB(entity.getWORK_ITEM())).append(",")
        .append("STE = ")
        .append(toDB(entity.getSTE())).append(",")
        .append("SUV_APPL = ")
        .append(toDB(entity.getSUV_APPL())).append(",")
        .append("CONFIRMER_NM = ")
        .append(toDB(entity.getCONFIRMER_NM())).append(",")
        .append("CONFIRMER_POSI = ")
        .append(toDB(entity.getCONFIRMER_POSI())).append(",")
        .append("CONFIRMER_TEL = ")
        .append(toDB(entity.getCONFIRMER_TEL())).append(",")
        .append("INSP_OPIN = ")
        .append(toDB(entity.getINSP_OPIN())).append(",")
        .append("PRE_ITEM = ")
        .append(toDB(entity.getPRE_ITEM())).append(",")
        .append("SW_BEF_REPO_DELINUM = ")
        .append(toDB(entity.getSW_BEF_REPO_DELINUM())).append(",")
        .append("REPO_DT = ")
        .append(toDB(entity.getREPO_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("CIV_RECV_NUM = ")
        .append(toDB(entity.getCIV_RECV_NUM())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INSP_BAS = ")
        .append(toDB(entity.getINSP_BAS())).append(",")
        .append("CER_DELI_NUM = ")
        .append(toDB(entity.getCER_DELI_NUM())).append(",")
        .append("CER_DELI_CONFIRM = ")
        .append(toDB(entity.getCER_DELI_CONFIRM())).append(",")
        .append("INSP_APPL_DT = ")
        .append(toDB(entity.getINSP_APPL_DT())).append(",")
        .append("PROC_STE = ")
        .append(toDB(entity.getPROC_STE())).append(",")
        .append("CER_DELI_YN = ")
        .append(toDB(entity.getCER_DELI_YN())).append(",")
        .append("PROC_OFFI_NM = ")
        .append(toDB(entity.getPROC_OFFI_NM())).append(",")
        .append("WORK_ITEM_ETC = ")
        .append(toDB(entity.getWORK_ITEM_ETC())).append(",")
        .append("ETC_INSP_BAS = ")
        .append(toDB(entity.getETC_INSP_BAS())).append(",")
        .append("UPD_DT_OLD = ")
        .append(toDB(entity.getUPD_DT_OLD())).append(",")
        .append("BACKUP_TRANS_DT = ")
        .append(toDB(entity.getBACKUP_TRANS_DT())).append(",")
        .append("CONFIRMER_OFFI_ID = ")
        .append(toDB(entity.getCONFIRMER_OFFI_ID())).append(",")
        .append("CHG_INSP = ")
        .append(toDB(entity.getCHG_INSP())).append(",")
        .append("STRU_INFO_BIGO = ")
        .append(toDB(entity.getSTRU_INFO_BIGO())).append(",")
        .append("USE_ETC = ")
        .append(toDB(entity.getUSE_ETC()))
        .append(" where  1=1 ");
       
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and SIGUNGU_CODE = ").append( toDB(entity.getSIGUNGU_CODE()));
         
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
      
    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : updateModifiedOnly() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;

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
    sb.append("update PT_UB_CONSTRUCTION  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	

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



    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : updateModifiedOnly() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;


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
    sb.append("update PT_UB_CONSTRUCTION  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	 

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : updateModifiedOnly() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;

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
    sb.append("update PT_UB_CONSTRUCTION  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	 

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

    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : updateModifiedOnly() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;


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
    sb.append("update PT_UB_CONSTRUCTION  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : delete() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_CONSTRUCTION  where  1=1")
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
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

    if((obj instanceof PT_UB_CONSTRUCTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CONSTRUCTION : delete() ");
    }
    PT_UB_CONSTRUCTIONEntity entity = (PT_UB_CONSTRUCTIONEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_CONSTRUCTION  where  1=1")
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	    ;


   return sb.toString();
  }


}//Class End
