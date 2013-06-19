


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_PG
*  테이블 설명 :
*  테이블 PK   :
*               PG_ID
*  테이블 컬럼 :
*               PG_ID:NUMBER(10):
*               PG_NAME:VARCHAR2(100):
*               PG_URL:VARCHAR2(200):
*               UPD_DT:DATE:
*               USE_YN:VARCHAR2(1):
*               ORDER_SEQ:NUMBER(22):
*               PG_GROUP_ID:VARCHAR2(5):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_PGDAO  extends SuperToDB{

  private String default_fields[]={ "PG_ID" , "PG_NAME" , "PG_URL" , "UPD_DT" , "USE_YN" , "ORDER_SEQ" , "PG_GROUP_ID" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_PGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG : insert() ");
    }
    PT_PGEntity entity = (PT_PGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_PG ")
    .append(" ( PG_ID,PG_NAME,PG_URL,UPD_DT,USE_YN,ORDER_SEQ,PG_GROUP_ID ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getPG_ID()))
			.append(",")
           .append(toDB(entity.getPG_NAME()))
			.append(",")
           .append(toDB(entity.getPG_URL()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getUSE_YN()))
			.append(",")
           .append(toDB(entity.getORDER_SEQ()))
			.append(",")
           .append(toDB(entity.getPG_GROUP_ID()))
			
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


    if((obj instanceof PT_PGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG : update() ");
    }
    PT_PGEntity entity = (PT_PGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_PG  set ")
       
        .append("PG_NAME = ")
        .append(toDB(entity.getPG_NAME())).append(",")
        .append("PG_URL = ")
        .append(toDB(entity.getPG_URL())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("USE_YN = ")
        .append(toDB(entity.getUSE_YN())).append(",")
        .append("ORDER_SEQ = ")
        .append(toDB(entity.getORDER_SEQ())).append(",")
        .append("PG_GROUP_ID = ")
        .append(toDB(entity.getPG_GROUP_ID()))
        .append(" where  1=1 ");
       
         sb.append(" and PG_ID = ").append( toDB(entity.getPG_ID()));
         

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



    if((obj instanceof PT_PGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG : updateModifiedOnly() ");
    }
    PT_PGEntity entity = (PT_PGEntity)obj;

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
    sb.append("update PT_PG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and PG_ID = ").append(toDB(entity.getPG_ID()));
     

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

    if((obj instanceof PT_PGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG : updateModifiedOnly() ");
    }
    PT_PGEntity entity = (PT_PGEntity)obj;

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
    sb.append("update PT_PG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and PG_ID = ").append(toDB(entity.getPG_ID()));
     

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

    if((obj instanceof PT_PGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG : delete() ");
    }
    PT_PGEntity entity = (PT_PGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_PG  where  1=1")
      
	  .append(" and PG_ID = ").append(toDB(entity.getPG_ID()))
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
