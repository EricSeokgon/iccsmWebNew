


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_UB_SUVSPOT
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               RECV_NUM
*               SIDO_CODE
*               SIDO_CODE
*               SIGUNGU_CODE
*               SIGUNGU_CODE
*  테이블 컬럼 :
*               RECV_NUM:VARCHAR2(30):
*               SUV_NAME:VARCHAR2(100):
*               SUV_STANUM:VARCHAR2(24):
*               SUV_NM:VARCHAR2(26):
*               SUV_TELNUM:VARCHAR2(24):
*               SUV_POSTNUM:VARCHAR2(6):
*               SUV_ADDR:VARCHAR2(64):
*               SUV_DETAILADDR:VARCHAR2(128):
*               SIWORK_NAME:VARCHAR2(100):
*               SIWORK_REP:VARCHAR2(25):
*               COI_WRT_NUM:VARCHAR2(26):
*               SIWORK_POSTNUM:VARCHAR2(6):
*               SIWORK_ADDR:VARCHAR2(64):
*               SIWORK_DETAILADDR:VARCHAR2(128):
*               SPOTNM:VARCHAR2(125):
*               SPOT_POSTNUM:VARCHAR2(6):
*               SPOT_ADDR:VARCHAR2(64):
*               SPOT_DETAILADDR:VARCHAR2(128):
*               WORK_ITEM:VARCHAR2(128):
*               USE:VARCHAR2(128):
*               STRU_AREA:VARCHAR2(250):
*               AREA:VARCHAR2(12):
*               SW_DT:VARCHAR2(24):
*               EW_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               SIDO_CODE:VARCHAR2(4):
*               SIGUNGU_CODE:VARCHAR2(6):
*               SUV_MOBILE:VARCHAR2(24):
*               SIWORK_TELNUM:VARCHAR2(24):
*               SIWORK_MOBILE:VARCHAR2(24):
*               DOC_YN:VARCHAR2(5):
*               PROC_LIM:VARCHAR2(24):
*               ORPE_NM:VARCHAR2(50):
*               WORK_ITEM_ETC:VARCHAR2(128):
*               UPD_DT_OLD:VARCHAR2(24):
*               BACKUP_TRANS_DT:VARCHAR2(24):
*               CIV_RECV_NUM:VARCHAR2(50):
*               USE_ETC:VARCHAR2(256):
*               RECV_NUM:VARCHAR2(30):
*               SUV_NAME:VARCHAR2(100):
*               SUV_STANUM:VARCHAR2(24):
*               SUV_NM:VARCHAR2(26):
*               SUV_TELNUM:VARCHAR2(24):
*               SUV_POSTNUM:VARCHAR2(6):
*               SUV_ADDR:VARCHAR2(64):
*               SUV_DETAILADDR:VARCHAR2(128):
*               SIWORK_NAME:VARCHAR2(100):
*               SIWORK_REP:VARCHAR2(25):
*               COI_WRT_NUM:VARCHAR2(26):
*               SIWORK_POSTNUM:VARCHAR2(6):
*               SIWORK_ADDR:VARCHAR2(64):
*               SIWORK_DETAILADDR:VARCHAR2(128):
*               SPOTNM:VARCHAR2(125):
*               SPOT_POSTNUM:VARCHAR2(6):
*               SPOT_ADDR:VARCHAR2(64):
*               SPOT_DETAILADDR:VARCHAR2(128):
*               WORK_ITEM:VARCHAR2(128):
*               USE:VARCHAR2(128):
*               STRU_AREA:VARCHAR2(250):
*               AREA:VARCHAR2(12):
*               SW_DT:VARCHAR2(24):
*               EW_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               SIDO_CODE:VARCHAR2(4):
*               SIGUNGU_CODE:VARCHAR2(6):
*               SUV_MOBILE:VARCHAR2(24):
*               SIWORK_TELNUM:VARCHAR2(24):
*               SIWORK_MOBILE:VARCHAR2(24):
*               DOC_YN:VARCHAR2(5):
*               PROC_LIM:VARCHAR2(24):
*               ORPE_NM:VARCHAR2(50):
*               WORK_ITEM_ETC:VARCHAR2(128):
*               UPD_DT_OLD:VARCHAR2(24):
*               BACKUP_TRANS_DT:VARCHAR2(24):
*               CIV_RECV_NUM:VARCHAR2(50):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_UB_SUVSPOTDAO  extends SuperToDB{

  private String default_fields[]={ "RECV_NUM" , "SUV_NAME" , "SUV_STANUM" , "SUV_NM" , "SUV_TELNUM" , "SUV_POSTNUM" , "SUV_ADDR" , "SUV_DETAILADDR" , "SIWORK_NAME" , "SIWORK_REP" , "COI_WRT_NUM" , "SIWORK_POSTNUM" , "SIWORK_ADDR" , "SIWORK_DETAILADDR" , "SPOTNM" , "SPOT_POSTNUM" , "SPOT_ADDR" , "SPOT_DETAILADDR" , "WORK_ITEM" , "USE" , "STRU_AREA" , "AREA" , "SW_DT" , "EW_DT" , "WRT_ID" , "INS_DT" , "UPD_DT" , "SIDO_CODE" , "SIGUNGU_CODE" , "SUV_MOBILE" , "SIWORK_TELNUM" , "SIWORK_MOBILE" , "DOC_YN" , "PROC_LIM" , "ORPE_NM" , "WORK_ITEM_ETC" , "UPD_DT_OLD" , "BACKUP_TRANS_DT" , "CIV_RECV_NUM" , "USE_ETC" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : insert() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_SUVSPOT ")
    .append(" ( RECV_NUM,SUV_NAME,SUV_STANUM,SUV_NM,SUV_TELNUM,SUV_POSTNUM,SUV_ADDR,SUV_DETAILADDR,SIWORK_NAME,SIWORK_REP,COI_WRT_NUM,SIWORK_POSTNUM,SIWORK_ADDR,SIWORK_DETAILADDR,SPOTNM,SPOT_POSTNUM,SPOT_ADDR,SPOT_DETAILADDR,WORK_ITEM,USE,STRU_AREA,AREA,SW_DT,EW_DT,WRT_ID,INS_DT,UPD_DT,SIDO_CODE,SIGUNGU_CODE,SUV_MOBILE,SIWORK_TELNUM,SIWORK_MOBILE,DOC_YN,PROC_LIM,ORPE_NM,WORK_ITEM_ETC,UPD_DT_OLD,BACKUP_TRANS_DT,CIV_RECV_NUM,USE_ETC ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSUV_NAME()))
			.append(",")
           .append(toDB(entity.getSUV_STANUM()))
			.append(",")
           .append(toDB(entity.getSUV_NM()))
			.append(",")
           .append(toDB(entity.getSUV_TELNUM()))
			.append(",")
           .append(toDB(entity.getSUV_POSTNUM()))
			.append(",")
           .append(toDB(entity.getSUV_ADDR()))
			.append(",")
           .append(toDB(entity.getSUV_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getSIWORK_NAME()))
			.append(",")
           .append(toDB(entity.getSIWORK_REP()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getSIWORK_POSTNUM()))
			.append(",")
           .append(toDB(entity.getSIWORK_ADDR()))
			.append(",")
           .append(toDB(entity.getSIWORK_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getSPOTNM()))
			.append(",")
           .append(toDB(entity.getSPOT_POSTNUM()))
			.append(",")
           .append(toDB(entity.getSPOT_ADDR()))
			.append(",")
           .append(toDB(entity.getSPOT_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getWORK_ITEM()))
			.append(",")
           .append(toDB(entity.getUSE()))
			.append(",")
           .append(toDB(entity.getSTRU_AREA()))
			.append(",")
           .append(toDB(entity.getAREA()))
			.append(",")
           .append(toDB(entity.getSW_DT()))
			.append(",")
           .append(toDB(entity.getEW_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getSUV_MOBILE()))
			.append(",")
           .append(toDB(entity.getSIWORK_TELNUM()))
			.append(",")
           .append(toDB(entity.getSIWORK_MOBILE()))
			.append(",")
           .append(toDB(entity.getDOC_YN()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getORPE_NM()))
			.append(",")
           .append(toDB(entity.getWORK_ITEM_ETC()))
			.append(",")
           .append(toDB(entity.getUPD_DT_OLD()))
			.append(",")
           .append(toDB(entity.getBACKUP_TRANS_DT()))
			.append(",")
           .append(toDB(entity.getCIV_RECV_NUM()))
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

    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : insert() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_SUVSPOT ")
    .append(" ( RECV_NUM,SUV_NAME,SUV_STANUM,SUV_NM,SUV_TELNUM,SUV_POSTNUM,SUV_ADDR,SUV_DETAILADDR,SIWORK_NAME,SIWORK_REP,COI_WRT_NUM,SIWORK_POSTNUM,SIWORK_ADDR,SIWORK_DETAILADDR,SPOTNM,SPOT_POSTNUM,SPOT_ADDR,SPOT_DETAILADDR,WORK_ITEM,USE,STRU_AREA,AREA,SW_DT,EW_DT,WRT_ID,INS_DT,UPD_DT,SIDO_CODE,SIGUNGU_CODE,SUV_MOBILE,SIWORK_TELNUM,SIWORK_MOBILE,DOC_YN,PROC_LIM,ORPE_NM,WORK_ITEM_ETC,UPD_DT_OLD,BACKUP_TRANS_DT,CIV_RECV_NUM,USE_ETC ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSUV_NAME()))
			.append(",")
           .append(toDB(entity.getSUV_STANUM()))
			.append(",")
           .append(toDB(entity.getSUV_NM()))
			.append(",")
           .append(toDB(entity.getSUV_TELNUM()))
			.append(",")
           .append(toDB(entity.getSUV_POSTNUM()))
			.append(",")
           .append(toDB(entity.getSUV_ADDR()))
			.append(",")
           .append(toDB(entity.getSUV_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getSIWORK_NAME()))
			.append(",")
           .append(toDB(entity.getSIWORK_REP()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getSIWORK_POSTNUM()))
			.append(",")
           .append(toDB(entity.getSIWORK_ADDR()))
			.append(",")
           .append(toDB(entity.getSIWORK_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getSPOTNM()))
			.append(",")
           .append(toDB(entity.getSPOT_POSTNUM()))
			.append(",")
           .append(toDB(entity.getSPOT_ADDR()))
			.append(",")
           .append(toDB(entity.getSPOT_DETAILADDR()))
			.append(",")
           .append(toDB(entity.getWORK_ITEM()))
			.append(",")
           .append(toDB(entity.getUSE()))
			.append(",")
           .append(toDB(entity.getSTRU_AREA()))
			.append(",")
           .append(toDB(entity.getAREA()))
			.append(",")
           .append(toDB(entity.getSW_DT()))
			.append(",")
           .append(toDB(entity.getEW_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getSUV_MOBILE()))
			.append(",")
           .append(toDB(entity.getSIWORK_TELNUM()))
			.append(",")
           .append(toDB(entity.getSIWORK_MOBILE()))
			.append(",")
           .append(toDB(entity.getDOC_YN()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getORPE_NM()))
			.append(",")
           .append(toDB(entity.getWORK_ITEM_ETC()))
			.append(",")
           .append(toDB(entity.getUPD_DT_OLD()))
			.append(",")
           .append(toDB(entity.getBACKUP_TRANS_DT()))
			.append(",")
           .append(toDB(entity.getCIV_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getUSE_ETC()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : update() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_SUVSPOT  set ")
       
        .append("SUV_NAME = ")
        .append(toDB(entity.getSUV_NAME())).append(",")
        .append("SUV_STANUM = ")
        .append(toDB(entity.getSUV_STANUM())).append(",")
        .append("SUV_NM = ")
        .append(toDB(entity.getSUV_NM())).append(",")
        .append("SUV_TELNUM = ")
        .append(toDB(entity.getSUV_TELNUM())).append(",")
        .append("SUV_POSTNUM = ")
        .append(toDB(entity.getSUV_POSTNUM())).append(",")
        .append("SUV_ADDR = ")
        .append(toDB(entity.getSUV_ADDR())).append(",")
        .append("SUV_DETAILADDR = ")
        .append(toDB(entity.getSUV_DETAILADDR())).append(",")
        .append("SIWORK_NAME = ")
        .append(toDB(entity.getSIWORK_NAME())).append(",")
        .append("SIWORK_REP = ")
        .append(toDB(entity.getSIWORK_REP())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("SIWORK_POSTNUM = ")
        .append(toDB(entity.getSIWORK_POSTNUM())).append(",")
        .append("SIWORK_ADDR = ")
        .append(toDB(entity.getSIWORK_ADDR())).append(",")
        .append("SIWORK_DETAILADDR = ")
        .append(toDB(entity.getSIWORK_DETAILADDR())).append(",")
        .append("SPOTNM = ")
        .append(toDB(entity.getSPOTNM())).append(",")
        .append("SPOT_POSTNUM = ")
        .append(toDB(entity.getSPOT_POSTNUM())).append(",")
        .append("SPOT_ADDR = ")
        .append(toDB(entity.getSPOT_ADDR())).append(",")
        .append("SPOT_DETAILADDR = ")
        .append(toDB(entity.getSPOT_DETAILADDR())).append(",")
        .append("WORK_ITEM = ")
        .append(toDB(entity.getWORK_ITEM())).append(",")
        .append("USE = ")
        .append(toDB(entity.getUSE())).append(",")
        .append("STRU_AREA = ")
        .append(toDB(entity.getSTRU_AREA())).append(",")
        .append("AREA = ")
        .append(toDB(entity.getAREA())).append(",")
        .append("SW_DT = ")
        .append(toDB(entity.getSW_DT())).append(",")
        .append("EW_DT = ")
        .append(toDB(entity.getEW_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("SUV_MOBILE = ")
        .append(toDB(entity.getSUV_MOBILE())).append(",")
        .append("SIWORK_TELNUM = ")
        .append(toDB(entity.getSIWORK_TELNUM())).append(",")
        .append("SIWORK_MOBILE = ")
        .append(toDB(entity.getSIWORK_MOBILE())).append(",")
        .append("DOC_YN = ")
        .append(toDB(entity.getDOC_YN())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("ORPE_NM = ")
        .append(toDB(entity.getORPE_NM())).append(",")
        .append("WORK_ITEM_ETC = ")
        .append(toDB(entity.getWORK_ITEM_ETC())).append(",")
        .append("UPD_DT_OLD = ")
        .append(toDB(entity.getUPD_DT_OLD())).append(",")
        .append("BACKUP_TRANS_DT = ")
        .append(toDB(entity.getBACKUP_TRANS_DT())).append(",")
        .append("CIV_RECV_NUM = ")
        .append(toDB(entity.getCIV_RECV_NUM())).append(",")
        .append("USE_ETC = ")
        .append(toDB(entity.getUSE_ETC()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and SIGUNGU_CODE = ").append( toDB(entity.getSIGUNGU_CODE()));
         
         

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


    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : update() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_SUVSPOT  set ")
       
        .append("SUV_NAME = ")
        .append(toDB(entity.getSUV_NAME())).append(",")
        .append("SUV_STANUM = ")
        .append(toDB(entity.getSUV_STANUM())).append(",")
        .append("SUV_NM = ")
        .append(toDB(entity.getSUV_NM())).append(",")
        .append("SUV_TELNUM = ")
        .append(toDB(entity.getSUV_TELNUM())).append(",")
        .append("SUV_POSTNUM = ")
        .append(toDB(entity.getSUV_POSTNUM())).append(",")
        .append("SUV_ADDR = ")
        .append(toDB(entity.getSUV_ADDR())).append(",")
        .append("SUV_DETAILADDR = ")
        .append(toDB(entity.getSUV_DETAILADDR())).append(",")
        .append("SIWORK_NAME = ")
        .append(toDB(entity.getSIWORK_NAME())).append(",")
        .append("SIWORK_REP = ")
        .append(toDB(entity.getSIWORK_REP())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("SIWORK_POSTNUM = ")
        .append(toDB(entity.getSIWORK_POSTNUM())).append(",")
        .append("SIWORK_ADDR = ")
        .append(toDB(entity.getSIWORK_ADDR())).append(",")
        .append("SIWORK_DETAILADDR = ")
        .append(toDB(entity.getSIWORK_DETAILADDR())).append(",")
        .append("SPOTNM = ")
        .append(toDB(entity.getSPOTNM())).append(",")
        .append("SPOT_POSTNUM = ")
        .append(toDB(entity.getSPOT_POSTNUM())).append(",")
        .append("SPOT_ADDR = ")
        .append(toDB(entity.getSPOT_ADDR())).append(",")
        .append("SPOT_DETAILADDR = ")
        .append(toDB(entity.getSPOT_DETAILADDR())).append(",")
        .append("WORK_ITEM = ")
        .append(toDB(entity.getWORK_ITEM())).append(",")
        .append("USE = ")
        .append(toDB(entity.getUSE())).append(",")
        .append("STRU_AREA = ")
        .append(toDB(entity.getSTRU_AREA())).append(",")
        .append("AREA = ")
        .append(toDB(entity.getAREA())).append(",")
        .append("SW_DT = ")
        .append(toDB(entity.getSW_DT())).append(",")
        .append("EW_DT = ")
        .append(toDB(entity.getEW_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("SUV_MOBILE = ")
        .append(toDB(entity.getSUV_MOBILE())).append(",")
        .append("SIWORK_TELNUM = ")
        .append(toDB(entity.getSIWORK_TELNUM())).append(",")
        .append("SIWORK_MOBILE = ")
        .append(toDB(entity.getSIWORK_MOBILE())).append(",")
        .append("DOC_YN = ")
        .append(toDB(entity.getDOC_YN())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("ORPE_NM = ")
        .append(toDB(entity.getORPE_NM())).append(",")
        .append("WORK_ITEM_ETC = ")
        .append(toDB(entity.getWORK_ITEM_ETC())).append(",")
        .append("UPD_DT_OLD = ")
        .append(toDB(entity.getUPD_DT_OLD())).append(",")
        .append("BACKUP_TRANS_DT = ")
        .append(toDB(entity.getBACKUP_TRANS_DT())).append(",")
        .append("CIV_RECV_NUM = ")
        .append(toDB(entity.getCIV_RECV_NUM())).append(",")
        .append("USE_ETC = ")
        .append(toDB(entity.getUSE_ETC()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and SIGUNGU_CODE = ").append( toDB(entity.getSIGUNGU_CODE()));
         
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : updateModifiedOnly() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;

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
    sb.append("update PT_UB_SUVSPOT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
	

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



    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : updateModifiedOnly() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;


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
    sb.append("update PT_UB_SUVSPOT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
	 

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : updateModifiedOnly() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;

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
    sb.append("update PT_UB_SUVSPOT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
	

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

    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : updateModifiedOnly() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;


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
    sb.append("update PT_UB_SUVSPOT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
	  
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : delete() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_SUVSPOT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
      
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

    if((obj instanceof PT_UB_SUVSPOTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT : delete() ");
    }
    PT_UB_SUVSPOTEntity entity = (PT_UB_SUVSPOTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_SUVSPOT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
      
	   ;


   return sb.toString();
  }


}//Class End
