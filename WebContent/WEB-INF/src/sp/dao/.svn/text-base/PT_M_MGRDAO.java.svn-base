


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_M_MGR
*  테이블 설명 :
*  테이블 PK   :
*               TMP_WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               M_SEQ:VARCHAR2(6):
*               COI_WRT_NUM:VARCHAR2(12):
*               TMP_WRT_NUM:VARCHAR2(12):
*               DISPO_CLASS:VARCHAR2(1):
*               VIOL_DT:VARCHAR2(8):
*               DISPO_CAUSE:VARCHAR2(512):
*               NOTE_DT:VARCHAR2(8):
*               NOTE_RECV_YN:VARCHAR2(1):
*               NOTE_OPIN_PRES_LIM_DT:VARCHAR2(8):
*               DEL_NOTE_DT:VARCHAR2(8):
*               DEL_OPIN_PRES_LIM_DT:VARCHAR2(8):
*               DISPO_CONT:VARCHAR2(6):
*               DISPO_DT:VARCHAR2(8):
*               BUSISUSP_START_DT:VARCHAR2(8):
*               BUSISUSP_END_DT:VARCHAR2(8):
*               REMARK:VARCHAR2(256):
*               RECV_DT:VARCHAR2(8):
*               MOT_STE:VARCHAR2(6):
*               DOC_CODE:VARCHAR2(50):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(30):
*               REGSTD_START_DT:VARCHAR2(8):
*               REGSTD_END_DT:VARCHAR2(8):
*               FINE:VARCHAR2(30):
*               PAY_NOTI_DT:VARCHAR2(8):
*               PAY_TERM:VARCHAR2(8):
*               PAY_DT:VARCHAR2(8):
*               DEL_RECV_YN:VARCHAR2(1):
*               WRT_NUM:VARCHAR2(12):
*               SIDO_CODE:VARCHAR2(6):
*               SND_STE:VARCHAR2(1):
*               SND_DT:VARCHAR2(8):
*               PUNISHMENT_AGENCY:VARCHAR2(50):
*               DISPO_CONT_NM:VARCHAR2(30):
*               AUDI_EXEC_ADDR:VARCHAR2(120):
*               AUDI_EXEC_DT:VARCHAR2(8):
*               AUDI_EXEC_START_TIME:VARCHAR2(4):
*               AUDI_EXEC_END_TIME:VARCHAR2(4):
*               AUDI_SUPINT_NM:VARCHAR2(20):
*               AUDI_SUPINT_POS:VARCHAR2(50):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_M_MGRDAO  extends SuperToDB{

  private String default_fields[]={ "M_SEQ" , "COI_WRT_NUM" , "TMP_WRT_NUM" , "DISPO_CLASS" , "VIOL_DT" , "DISPO_CAUSE" , "NOTE_DT" , "NOTE_RECV_YN" , "NOTE_OPIN_PRES_LIM_DT" , "DEL_NOTE_DT" , "DEL_OPIN_PRES_LIM_DT" , "DISPO_CONT" , "DISPO_DT" , "BUSISUSP_START_DT" , "BUSISUSP_END_DT" , "REMARK" , "RECV_DT" , "MOT_STE" , "DOC_CODE" , "INS_DT" , "UPD_DT" , "WRT_ID" , "REGSTD_START_DT" , "REGSTD_END_DT" , "FINE" , "PAY_NOTI_DT" , "PAY_TERM" , "PAY_DT" , "DEL_RECV_YN" , "WRT_NUM" , "SIDO_CODE" , "SND_STE" , "SND_DT" , "PUNISHMENT_AGENCY" , "DISPO_CONT_NM" , "AUDI_EXEC_ADDR" , "AUDI_EXEC_DT" , "AUDI_EXEC_START_TIME" , "AUDI_EXEC_END_TIME" , "AUDI_SUPINT_NM" , "AUDI_SUPINT_POS" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : insert() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_MGR ")
    .append(" ( M_SEQ,COI_WRT_NUM,TMP_WRT_NUM,DISPO_CLASS,VIOL_DT,DISPO_CAUSE,NOTE_DT,NOTE_RECV_YN,NOTE_OPIN_PRES_LIM_DT,DEL_NOTE_DT,DEL_OPIN_PRES_LIM_DT,DISPO_CONT,DISPO_DT,BUSISUSP_START_DT,BUSISUSP_END_DT,REMARK,RECV_DT,MOT_STE,DOC_CODE,INS_DT,UPD_DT,WRT_ID,REGSTD_START_DT,REGSTD_END_DT,FINE,PAY_NOTI_DT,PAY_TERM,PAY_DT,DEL_RECV_YN,WRT_NUM,SIDO_CODE,SND_STE,SND_DT,PUNISHMENT_AGENCY,DISPO_CONT_NM,AUDI_EXEC_ADDR,AUDI_EXEC_DT,AUDI_EXEC_START_TIME,AUDI_EXEC_END_TIME,AUDI_SUPINT_NM,AUDI_SUPINT_POS ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getM_SEQ()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getDISPO_CLASS()))
			.append(",")
           .append(toDB(entity.getVIOL_DT()))
			.append(",")
           .append(toDB(entity.getDISPO_CAUSE()))
			.append(",")
           .append(toDB(entity.getNOTE_DT()))
			.append(",")
           .append(toDB(entity.getNOTE_RECV_YN()))
			.append(",")
           .append(toDB(entity.getNOTE_OPIN_PRES_LIM_DT()))
			.append(",")
           .append(toDB(entity.getDEL_NOTE_DT()))
			.append(",")
           .append(toDB(entity.getDEL_OPIN_PRES_LIM_DT()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT()))
			.append(",")
           .append(toDB(entity.getDISPO_DT()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_START_DT()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_END_DT()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getREGSTD_START_DT()))
			.append(",")
           .append(toDB(entity.getREGSTD_END_DT()))
			.append(",")
           .append(toDB(entity.getFINE()))
			.append(",")
           .append(toDB(entity.getPAY_NOTI_DT()))
			.append(",")
           .append(toDB(entity.getPAY_TERM()))
			.append(",")
           .append(toDB(entity.getPAY_DT()))
			.append(",")
           .append(toDB(entity.getDEL_RECV_YN()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSND_STE()))
			.append(",")
           .append(toDB(entity.getSND_DT()))
			.append(",")
           .append(toDB(entity.getPUNISHMENT_AGENCY()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT_NM()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_ADDR()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_DT()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_START_TIME()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_END_TIME()))
			.append(",")
           .append(toDB(entity.getAUDI_SUPINT_NM()))
			.append(",")
           .append(toDB(entity.getAUDI_SUPINT_POS()))
			
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

    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : insert() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_MGR ")
    .append(" ( M_SEQ,COI_WRT_NUM,TMP_WRT_NUM,DISPO_CLASS,VIOL_DT,DISPO_CAUSE,NOTE_DT,NOTE_RECV_YN,NOTE_OPIN_PRES_LIM_DT,DEL_NOTE_DT,DEL_OPIN_PRES_LIM_DT,DISPO_CONT,DISPO_DT,BUSISUSP_START_DT,BUSISUSP_END_DT,REMARK,RECV_DT,MOT_STE,DOC_CODE,INS_DT,UPD_DT,WRT_ID,REGSTD_START_DT,REGSTD_END_DT,FINE,PAY_NOTI_DT,PAY_TERM,PAY_DT,DEL_RECV_YN,WRT_NUM,SIDO_CODE,SND_STE,SND_DT,PUNISHMENT_AGENCY,DISPO_CONT_NM,AUDI_EXEC_ADDR,AUDI_EXEC_DT,AUDI_EXEC_START_TIME,AUDI_EXEC_END_TIME,AUDI_SUPINT_NM,AUDI_SUPINT_POS ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getM_SEQ()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getDISPO_CLASS()))
			.append(",")
           .append(toDB(entity.getVIOL_DT()))
			.append(",")
           .append(toDB(entity.getDISPO_CAUSE()))
			.append(",")
           .append(toDB(entity.getNOTE_DT()))
			.append(",")
           .append(toDB(entity.getNOTE_RECV_YN()))
			.append(",")
           .append(toDB(entity.getNOTE_OPIN_PRES_LIM_DT()))
			.append(",")
           .append(toDB(entity.getDEL_NOTE_DT()))
			.append(",")
           .append(toDB(entity.getDEL_OPIN_PRES_LIM_DT()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT()))
			.append(",")
           .append(toDB(entity.getDISPO_DT()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_START_DT()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_END_DT()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getREGSTD_START_DT()))
			.append(",")
           .append(toDB(entity.getREGSTD_END_DT()))
			.append(",")
           .append(toDB(entity.getFINE()))
			.append(",")
           .append(toDB(entity.getPAY_NOTI_DT()))
			.append(",")
           .append(toDB(entity.getPAY_TERM()))
			.append(",")
           .append(toDB(entity.getPAY_DT()))
			.append(",")
           .append(toDB(entity.getDEL_RECV_YN()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSND_STE()))
			.append(",")
           .append(toDB(entity.getSND_DT()))
			.append(",")
           .append(toDB(entity.getPUNISHMENT_AGENCY()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT_NM()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_ADDR()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_DT()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_START_TIME()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_END_TIME()))
			.append(",")
           .append(toDB(entity.getAUDI_SUPINT_NM()))
			.append(",")
           .append(toDB(entity.getAUDI_SUPINT_POS()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : update() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_MGR  set ")
       
        .append("M_SEQ = ")
        .append(toDB(entity.getM_SEQ())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("DISPO_CLASS = ")
        .append(toDB(entity.getDISPO_CLASS())).append(",")
        .append("VIOL_DT = ")
        .append(toDB(entity.getVIOL_DT())).append(",")
        .append("DISPO_CAUSE = ")
        .append(toDB(entity.getDISPO_CAUSE())).append(",")
        .append("NOTE_DT = ")
        .append(toDB(entity.getNOTE_DT())).append(",")
        .append("NOTE_RECV_YN = ")
        .append(toDB(entity.getNOTE_RECV_YN())).append(",")
        .append("NOTE_OPIN_PRES_LIM_DT = ")
        .append(toDB(entity.getNOTE_OPIN_PRES_LIM_DT())).append(",")
        .append("DEL_NOTE_DT = ")
        .append(toDB(entity.getDEL_NOTE_DT())).append(",")
        .append("DEL_OPIN_PRES_LIM_DT = ")
        .append(toDB(entity.getDEL_OPIN_PRES_LIM_DT())).append(",")
        .append("DISPO_CONT = ")
        .append(toDB(entity.getDISPO_CONT())).append(",")
        .append("DISPO_DT = ")
        .append(toDB(entity.getDISPO_DT())).append(",")
        .append("BUSISUSP_START_DT = ")
        .append(toDB(entity.getBUSISUSP_START_DT())).append(",")
        .append("BUSISUSP_END_DT = ")
        .append(toDB(entity.getBUSISUSP_END_DT())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("REGSTD_START_DT = ")
        .append(toDB(entity.getREGSTD_START_DT())).append(",")
        .append("REGSTD_END_DT = ")
        .append(toDB(entity.getREGSTD_END_DT())).append(",")
        .append("FINE = ")
        .append(toDB(entity.getFINE())).append(",")
        .append("PAY_NOTI_DT = ")
        .append(toDB(entity.getPAY_NOTI_DT())).append(",")
        .append("PAY_TERM = ")
        .append(toDB(entity.getPAY_TERM())).append(",")
        .append("PAY_DT = ")
        .append(toDB(entity.getPAY_DT())).append(",")
        .append("DEL_RECV_YN = ")
        .append(toDB(entity.getDEL_RECV_YN())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("SND_STE = ")
        .append(toDB(entity.getSND_STE())).append(",")
        .append("SND_DT = ")
        .append(toDB(entity.getSND_DT())).append(",")
        .append("PUNISHMENT_AGENCY = ")
        .append(toDB(entity.getPUNISHMENT_AGENCY())).append(",")
        .append("DISPO_CONT_NM = ")
        .append(toDB(entity.getDISPO_CONT_NM())).append(",")
        .append("AUDI_EXEC_ADDR = ")
        .append(toDB(entity.getAUDI_EXEC_ADDR())).append(",")
        .append("AUDI_EXEC_DT = ")
        .append(toDB(entity.getAUDI_EXEC_DT())).append(",")
        .append("AUDI_EXEC_START_TIME = ")
        .append(toDB(entity.getAUDI_EXEC_START_TIME())).append(",")
        .append("AUDI_EXEC_END_TIME = ")
        .append(toDB(entity.getAUDI_EXEC_END_TIME())).append(",")
        .append("AUDI_SUPINT_NM = ")
        .append(toDB(entity.getAUDI_SUPINT_NM())).append(",")
        .append("AUDI_SUPINT_POS = ")
        .append(toDB(entity.getAUDI_SUPINT_POS()))
        .append(" where  1=1 ");
       
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         

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


    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : update() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_MGR  set ")
       
        .append("M_SEQ = ")
        .append(toDB(entity.getM_SEQ())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("DISPO_CLASS = ")
        .append(toDB(entity.getDISPO_CLASS())).append(",")
        .append("VIOL_DT = ")
        .append(toDB(entity.getVIOL_DT())).append(",")
        .append("DISPO_CAUSE = ")
        .append(toDB(entity.getDISPO_CAUSE())).append(",")
        .append("NOTE_DT = ")
        .append(toDB(entity.getNOTE_DT())).append(",")
        .append("NOTE_RECV_YN = ")
        .append(toDB(entity.getNOTE_RECV_YN())).append(",")
        .append("NOTE_OPIN_PRES_LIM_DT = ")
        .append(toDB(entity.getNOTE_OPIN_PRES_LIM_DT())).append(",")
        .append("DEL_NOTE_DT = ")
        .append(toDB(entity.getDEL_NOTE_DT())).append(",")
        .append("DEL_OPIN_PRES_LIM_DT = ")
        .append(toDB(entity.getDEL_OPIN_PRES_LIM_DT())).append(",")
        .append("DISPO_CONT = ")
        .append(toDB(entity.getDISPO_CONT())).append(",")
        .append("DISPO_DT = ")
        .append(toDB(entity.getDISPO_DT())).append(",")
        .append("BUSISUSP_START_DT = ")
        .append(toDB(entity.getBUSISUSP_START_DT())).append(",")
        .append("BUSISUSP_END_DT = ")
        .append(toDB(entity.getBUSISUSP_END_DT())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("REGSTD_START_DT = ")
        .append(toDB(entity.getREGSTD_START_DT())).append(",")
        .append("REGSTD_END_DT = ")
        .append(toDB(entity.getREGSTD_END_DT())).append(",")
        .append("FINE = ")
        .append(toDB(entity.getFINE())).append(",")
        .append("PAY_NOTI_DT = ")
        .append(toDB(entity.getPAY_NOTI_DT())).append(",")
        .append("PAY_TERM = ")
        .append(toDB(entity.getPAY_TERM())).append(",")
        .append("PAY_DT = ")
        .append(toDB(entity.getPAY_DT())).append(",")
        .append("DEL_RECV_YN = ")
        .append(toDB(entity.getDEL_RECV_YN())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("SND_STE = ")
        .append(toDB(entity.getSND_STE())).append(",")
        .append("SND_DT = ")
        .append(toDB(entity.getSND_DT())).append(",")
        .append("PUNISHMENT_AGENCY = ")
        .append(toDB(entity.getPUNISHMENT_AGENCY())).append(",")
        .append("DISPO_CONT_NM = ")
        .append(toDB(entity.getDISPO_CONT_NM())).append(",")
        .append("AUDI_EXEC_ADDR = ")
        .append(toDB(entity.getAUDI_EXEC_ADDR())).append(",")
        .append("AUDI_EXEC_DT = ")
        .append(toDB(entity.getAUDI_EXEC_DT())).append(",")
        .append("AUDI_EXEC_START_TIME = ")
        .append(toDB(entity.getAUDI_EXEC_START_TIME())).append(",")
        .append("AUDI_EXEC_END_TIME = ")
        .append(toDB(entity.getAUDI_EXEC_END_TIME())).append(",")
        .append("AUDI_SUPINT_NM = ")
        .append(toDB(entity.getAUDI_SUPINT_NM())).append(",")
        .append("AUDI_SUPINT_POS = ")
        .append(toDB(entity.getAUDI_SUPINT_POS()))
        .append(" where  1=1 ");
       
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : updateModifiedOnly() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;

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
    sb.append("update PT_M_MGR  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

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



    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : updateModifiedOnly() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;


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
    sb.append("update PT_M_MGR  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : updateModifiedOnly() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;

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
    sb.append("update PT_M_MGR  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

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

    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : updateModifiedOnly() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;


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
    sb.append("update PT_M_MGR  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : delete() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_MGR  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
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

    if((obj instanceof PT_M_MGREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MGR : delete() ");
    }
    PT_M_MGREntity entity = (PT_M_MGREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_MGR  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
