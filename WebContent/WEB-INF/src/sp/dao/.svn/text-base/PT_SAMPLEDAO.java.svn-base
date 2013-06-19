


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_SAMPLE
*  테이블 설명 :
*  테이블 PK   :
*               REC_NUM
*               REG_NUM
*  테이블 컬럼 :
*               REC_NUM:VARCHAR2(32):
*               REG_NUM:VARCHAR2(32):
*               SC_CODE:VARCHAR2(2):
*               SGG_CODE:VARCHAR2(2):
*               REC_DATE:VARCHAR2(24):
*               PRO_PERIOD:VARCHAR2(24):
*               PRO_DUTY:VARCHAR2(16):
*               PRO_REC_NUM:VARCHAR2(16):
*               COMPANY_NM:VARCHAR2(32):
*               APPLICANT:VARCHAR2(24):
*               TEL:VARCHAR2(16):
*               FAX:VARCHAR2(16):
*               REMEMBRANCER:VARCHAR2(24):
*               SSN1:NUMBER(6):
*               SSN2:NUMBER(7):
*               POST_CODE:VARCHAR2(8):
*               ADDR:VARCHAR2(64):
*               ADDR_ETC:VARCHAR2(64):
*               PUBLIC_WORK:VARCHAR2(8):
*               REP_NUM:VARCHAR2(32):
*               REC_DUTY:VARCHAR2(24):
*               REC_WRITE:VARCHAR2(16):
*               REC_INS_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               UDP_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               NOTE:VARCHAR2(128):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_SAMPLEDAO  extends SuperToDB{

  private String default_fields[]={ "REC_NUM" , "REG_NUM" , "SC_CODE" , "SGG_CODE" , "REC_DATE" , "PRO_PERIOD" , "PRO_DUTY" , "PRO_REC_NUM" , "COMPANY_NM" , "APPLICANT" , "TEL" , "FAX" , "REMEMBRANCER" , "SSN1" , "SSN2" , "POST_CODE" , "ADDR" , "ADDR_ETC" , "PUBLIC_WORK" , "REP_NUM" , "REC_DUTY" , "REC_WRITE" , "REC_INS_DT" , "WRT_ID" , "UDP_DT" , "INS_DT" , "NOTE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_SAMPLEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SAMPLE : insert() ");
    }
    PT_SAMPLEEntity entity = (PT_SAMPLEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_SAMPLE ")
    .append(" ( REC_NUM,REG_NUM,SC_CODE,SGG_CODE,REC_DATE,PRO_PERIOD,PRO_DUTY,PRO_REC_NUM,COMPANY_NM,APPLICANT,TEL,FAX,REMEMBRANCER,SSN1,SSN2,POST_CODE,ADDR,ADDR_ETC,PUBLIC_WORK,REP_NUM,REC_DUTY,REC_WRITE,REC_INS_DT,WRT_ID,UDP_DT,INS_DT,NOTE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getREC_NUM()))
			.append(",")
           .append(toDB(entity.getREG_NUM()))
			.append(",")
           .append(toDB(entity.getSC_CODE()))
			.append(",")
           .append(toDB(entity.getSGG_CODE()))
			.append(",")
           .append(toDB(entity.getREC_DATE()))
			.append(",")
           .append(toDB(entity.getPRO_PERIOD()))
			.append(",")
           .append(toDB(entity.getPRO_DUTY()))
			.append(",")
           .append(toDB(entity.getPRO_REC_NUM()))
			.append(",")
           .append(toDB(entity.getCOMPANY_NM()))
			.append(",")
           .append(toDB(entity.getAPPLICANT()))
			.append(",")
           .append(toDB(entity.getTEL()))
			.append(",")
           .append(toDB(entity.getFAX()))
			.append(",")
           .append(toDB(entity.getREMEMBRANCER()))
			.append(",")
           .append(toDB(entity.getSSN1()))
			.append(",")
           .append(toDB(entity.getSSN2()))
			.append(",")
           .append(toDB(entity.getPOST_CODE()))
			.append(",")
           .append(toDB(entity.getADDR()))
			.append(",")
           .append(toDB(entity.getADDR_ETC()))
			.append(",")
           .append(toDB(entity.getPUBLIC_WORK()))
			.append(",")
           .append(toDB(entity.getREP_NUM()))
			.append(",")
           .append(toDB(entity.getREC_DUTY()))
			.append(",")
           .append(toDB(entity.getREC_WRITE()))
			.append(",")
           .append(toDB(entity.getREC_INS_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUDP_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getNOTE()))
			
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

  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_SAMPLEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SAMPLE : update() ");
    }
    PT_SAMPLEEntity entity = (PT_SAMPLEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_SAMPLE  set ")
       
        .append("SC_CODE = ")
        .append(toDB(entity.getSC_CODE())).append(",")
        .append("SGG_CODE = ")
        .append(toDB(entity.getSGG_CODE())).append(",")
        .append("REC_DATE = ")
        .append(toDB(entity.getREC_DATE())).append(",")
        .append("PRO_PERIOD = ")
        .append(toDB(entity.getPRO_PERIOD())).append(",")
        .append("PRO_DUTY = ")
        .append(toDB(entity.getPRO_DUTY())).append(",")
        .append("PRO_REC_NUM = ")
        .append(toDB(entity.getPRO_REC_NUM())).append(",")
        .append("COMPANY_NM = ")
        .append(toDB(entity.getCOMPANY_NM())).append(",")
        .append("APPLICANT = ")
        .append(toDB(entity.getAPPLICANT())).append(",")
        .append("TEL = ")
        .append(toDB(entity.getTEL())).append(",")
        .append("FAX = ")
        .append(toDB(entity.getFAX())).append(",")
        .append("REMEMBRANCER = ")
        .append(toDB(entity.getREMEMBRANCER())).append(",")
        .append("SSN1 = ")
        .append(toDB(entity.getSSN1())).append(",")
        .append("SSN2 = ")
        .append(toDB(entity.getSSN2())).append(",")
        .append("POST_CODE = ")
        .append(toDB(entity.getPOST_CODE())).append(",")
        .append("ADDR = ")
        .append(toDB(entity.getADDR())).append(",")
        .append("ADDR_ETC = ")
        .append(toDB(entity.getADDR_ETC())).append(",")
        .append("PUBLIC_WORK = ")
        .append(toDB(entity.getPUBLIC_WORK())).append(",")
        .append("REP_NUM = ")
        .append(toDB(entity.getREP_NUM())).append(",")
        .append("REC_DUTY = ")
        .append(toDB(entity.getREC_DUTY())).append(",")
        .append("REC_WRITE = ")
        .append(toDB(entity.getREC_WRITE())).append(",")
        .append("REC_INS_DT = ")
        .append(toDB(entity.getREC_INS_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UDP_DT = ")
        .append(toDB(entity.getUDP_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("NOTE = ")
        .append(toDB(entity.getNOTE()))
        .append(" where  1=1 ");
       
         sb.append(" and REC_NUM = ").append( toDB(entity.getREC_NUM()));
         
         sb.append(" and REG_NUM = ").append( toDB(entity.getREG_NUM()));
         

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

  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_SAMPLEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SAMPLE : updateModifiedOnly() ");
    }
    PT_SAMPLEEntity entity = (PT_SAMPLEEntity)obj;

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
    sb.append("update PT_SAMPLE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and REC_NUM = ").append(toDB(entity.getREC_NUM()));
     
	  sb.append(" and REG_NUM = ").append(toDB(entity.getREG_NUM()));
     

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


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_SAMPLEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SAMPLE : updateModifiedOnly() ");
    }
    PT_SAMPLEEntity entity = (PT_SAMPLEEntity)obj;

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
    sb.append("update PT_SAMPLE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and REC_NUM = ").append(toDB(entity.getREC_NUM()));
     
	  sb.append(" and REG_NUM = ").append(toDB(entity.getREG_NUM()));
     

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
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_SAMPLEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SAMPLE : delete() ");
    }
    PT_SAMPLEEntity entity = (PT_SAMPLEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_SAMPLE  where  1=1")
      
	  .append(" and REC_NUM = ").append(toDB(entity.getREC_NUM()))
      
	  .append(" and REG_NUM = ").append(toDB(entity.getREG_NUM()))
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



}//Class End
