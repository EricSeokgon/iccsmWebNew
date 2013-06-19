


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_C_RES_COMM_LIMIT
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*  테이블 컬럼 :
*               SEQ:NUMBER(4):
*               ORG_NM:VARCHAR2(52):
*               SIDO_CODE:VARCHAR2(5):
*               PGP_CAF:NUMBER(10):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(12):
*               SIGUNGU_CODE:VARCHAR2(5):
*               PGP_PMS:NUMBER(10):
*               NBS_4_CAF:NUMBER(10):
*               NBS_4_PMS:NUMBER(10):
*               NBS_6_CAF:NUMBER(10):
*               NBS_6_PMS:NUMBER(10):
*               NBS_7_CAF:NUMBER(10):
*               NBS_7_PMS:NUMBER(10):
*               NBS_8_CAF:NUMBER(10):
*               NBS_9_PMS:NUMBER(10):
*               NBS_9_CAF:NUMBER(10):
*               NBS_8_PMS:NUMBER(10):
*               TBS_TECOM_CAF:NUMBER(10):
*               TBS_TECOM_PMS:NUMBER(10):
*               TBS_EXCH_CAF:NUMBER(10):
*               TBS_EXCH_PMS:NUMBER(10):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_C_RES_COMM_LIMITDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "ORG_NM" , "SIDO_CODE" , "PGP_CAF" , "INS_DT" , "UPD_DT" , "WRT_ID" , "SIGUNGU_CODE" , "PGP_PMS" , "NBS_4_CAF" , "NBS_4_PMS" , "NBS_6_CAF" , "NBS_6_PMS" , "NBS_7_CAF" , "NBS_7_PMS" , "NBS_8_CAF" , "NBS_9_PMS" , "NBS_9_CAF" , "NBS_8_PMS" , "TBS_TECOM_CAF" , "TBS_TECOM_PMS" , "TBS_EXCH_CAF" , "TBS_EXCH_PMS" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_C_RES_COMM_LIMITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_COMM_LIMIT : insert() ");
    }
    PT_C_RES_COMM_LIMITEntity entity = (PT_C_RES_COMM_LIMITEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_C_RES_COMM_LIMIT ")
    .append(" ( SEQ,ORG_NM,SIDO_CODE,PGP_CAF,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE,PGP_PMS,NBS_4_CAF,NBS_4_PMS,NBS_6_CAF,NBS_6_PMS,NBS_7_CAF,NBS_7_PMS,NBS_8_CAF,NBS_9_PMS,NBS_9_CAF,NBS_8_PMS,TBS_TECOM_CAF,TBS_TECOM_PMS,TBS_EXCH_CAF,TBS_EXCH_PMS ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getORG_NM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getPGP_CAF()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getPGP_PMS()))
			.append(",")
           .append(toDB(entity.getNBS_4_CAF()))
			.append(",")
           .append(toDB(entity.getNBS_4_PMS()))
			.append(",")
           .append(toDB(entity.getNBS_6_CAF()))
			.append(",")
           .append(toDB(entity.getNBS_6_PMS()))
			.append(",")
           .append(toDB(entity.getNBS_7_CAF()))
			.append(",")
           .append(toDB(entity.getNBS_7_PMS()))
			.append(",")
           .append(toDB(entity.getNBS_8_CAF()))
			.append(",")
           .append(toDB(entity.getNBS_9_PMS()))
			.append(",")
           .append(toDB(entity.getNBS_9_CAF()))
			.append(",")
           .append(toDB(entity.getNBS_8_PMS()))
			.append(",")
           .append(toDB(entity.getTBS_TECOM_CAF()))
			.append(",")
           .append(toDB(entity.getTBS_TECOM_PMS()))
			.append(",")
           .append(toDB(entity.getTBS_EXCH_CAF()))
			.append(",")
           .append(toDB(entity.getTBS_EXCH_PMS()))
			
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


    if((obj instanceof PT_C_RES_COMM_LIMITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_COMM_LIMIT : update() ");
    }
    PT_C_RES_COMM_LIMITEntity entity = (PT_C_RES_COMM_LIMITEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_C_RES_COMM_LIMIT  set ")
       
        .append("ORG_NM = ")
        .append(toDB(entity.getORG_NM())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("PGP_CAF = ")
        .append(toDB(entity.getPGP_CAF())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE())).append(",")
        .append("PGP_PMS = ")
        .append(toDB(entity.getPGP_PMS())).append(",")
        .append("NBS_4_CAF = ")
        .append(toDB(entity.getNBS_4_CAF())).append(",")
        .append("NBS_4_PMS = ")
        .append(toDB(entity.getNBS_4_PMS())).append(",")
        .append("NBS_6_CAF = ")
        .append(toDB(entity.getNBS_6_CAF())).append(",")
        .append("NBS_6_PMS = ")
        .append(toDB(entity.getNBS_6_PMS())).append(",")
        .append("NBS_7_CAF = ")
        .append(toDB(entity.getNBS_7_CAF())).append(",")
        .append("NBS_7_PMS = ")
        .append(toDB(entity.getNBS_7_PMS())).append(",")
        .append("NBS_8_CAF = ")
        .append(toDB(entity.getNBS_8_CAF())).append(",")
        .append("NBS_9_PMS = ")
        .append(toDB(entity.getNBS_9_PMS())).append(",")
        .append("NBS_9_CAF = ")
        .append(toDB(entity.getNBS_9_CAF())).append(",")
        .append("NBS_8_PMS = ")
        .append(toDB(entity.getNBS_8_PMS())).append(",")
        .append("TBS_TECOM_CAF = ")
        .append(toDB(entity.getTBS_TECOM_CAF())).append(",")
        .append("TBS_TECOM_PMS = ")
        .append(toDB(entity.getTBS_TECOM_PMS())).append(",")
        .append("TBS_EXCH_CAF = ")
        .append(toDB(entity.getTBS_EXCH_CAF())).append(",")
        .append("TBS_EXCH_PMS = ")
        .append(toDB(entity.getTBS_EXCH_PMS()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         

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



    if((obj instanceof PT_C_RES_COMM_LIMITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_COMM_LIMIT : updateModifiedOnly() ");
    }
    PT_C_RES_COMM_LIMITEntity entity = (PT_C_RES_COMM_LIMITEntity)obj;

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
    sb.append("update PT_C_RES_COMM_LIMIT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

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

    if((obj instanceof PT_C_RES_COMM_LIMITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_COMM_LIMIT : updateModifiedOnly() ");
    }
    PT_C_RES_COMM_LIMITEntity entity = (PT_C_RES_COMM_LIMITEntity)obj;

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
    sb.append("update PT_C_RES_COMM_LIMIT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

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

    if((obj instanceof PT_C_RES_COMM_LIMITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_COMM_LIMIT : delete() ");
    }
    PT_C_RES_COMM_LIMITEntity entity = (PT_C_RES_COMM_LIMITEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_C_RES_COMM_LIMIT  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
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
