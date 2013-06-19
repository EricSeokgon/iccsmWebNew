


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_UB_SUVSPOT_MASTER
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*  테이블 컬럼 :
*               SEQ:NUMBER(4):
*               SUV_NAME:VARCHAR2(100):
*               SUV_STANUM:VARCHAR2(24):
*               SUV_NM:VARCHAR2(26):
*               SUV_TELNUM:VARCHAR2(24):
*               SUV_POSTNUM:VARCHAR2(6):
*               SUV_ADDR:VARCHAR2(64):
*               SUV_DETAILADDR:VARCHAR2(128):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               SUV_MOBILE:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_UB_SUVSPOT_MASTERDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "SUV_NAME" , "SUV_STANUM" , "SUV_NM" , "SUV_TELNUM" , "SUV_POSTNUM" , "SUV_ADDR" , "SUV_DETAILADDR" , "WRT_ID" , "INS_DT" , "UPD_DT" , "SUV_MOBILE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : insert() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_SUVSPOT_MASTER ")
    .append(" ( SEQ,SUV_NAME,SUV_STANUM,SUV_NM,SUV_TELNUM,SUV_POSTNUM,SUV_ADDR,SUV_DETAILADDR,WRT_ID,INS_DT,UPD_DT,SUV_MOBILE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
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
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSUV_MOBILE()))
			
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

    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : insert() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_SUVSPOT_MASTER ")
    .append(" ( SEQ,SUV_NAME,SUV_STANUM,SUV_NM,SUV_TELNUM,SUV_POSTNUM,SUV_ADDR,SUV_DETAILADDR,WRT_ID,INS_DT,UPD_DT,SUV_MOBILE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
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
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSUV_MOBILE()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : update() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_SUVSPOT_MASTER  set ")
       
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
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("SUV_MOBILE = ")
        .append(toDB(entity.getSUV_MOBILE()))
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


  public String  updateSql( ValueObject obj) throws SQLException{


    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : update() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_SUVSPOT_MASTER  set ")
       
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
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("SUV_MOBILE = ")
        .append(toDB(entity.getSUV_MOBILE()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : updateModifiedOnly() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;

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
    sb.append("update PT_UB_SUVSPOT_MASTER  set " )
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




  public String updateModifiedOnlySql(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : updateModifiedOnly() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;


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
    sb.append("update PT_UB_SUVSPOT_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : updateModifiedOnly() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;

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
    sb.append("update PT_UB_SUVSPOT_MASTER  set " )
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
  
  
   public String updateExcludeOnlySql(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : updateModifiedOnly() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;


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
    sb.append("update PT_UB_SUVSPOT_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : delete() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_SUVSPOT_MASTER  where  1=1")
      
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

  public String deleteSql(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_SUVSPOT_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_SUVSPOT_MASTER : delete() ");
    }
    PT_UB_SUVSPOT_MASTEREntity entity = (PT_UB_SUVSPOT_MASTEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_SUVSPOT_MASTER  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
       ;


   return sb.toString();
  }


}//Class End
