


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_AUTH_USER
*  테이블 설명 :
*  테이블 PK   :
*               PG_ID
*               USER_ID
*  테이블 컬럼 :
*               USER_ID:VARCHAR2(30):
*               PG_ID:VARCHAR2(5):
*               PG_GROUP_ID:VARCHAR2(5):
*               READ_FLAG:VARCHAR2(1):
*               WRITE_FLAG:VARCHAR2(1):
*               COM_FLAG:VARCHAR2(1):
*               UPD_DT:DATE:
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_AUTH_USERDAO  extends SuperToDB{

  private String default_fields[]={ "USER_ID" , "PG_ID" , "PG_GROUP_ID" , "READ_FLAG" , "WRITE_FLAG" , "COM_FLAG" , "UPD_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_AUTH_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_USER : insert() ");
    }
    PT_AUTH_USEREntity entity = (PT_AUTH_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_AUTH_USER ")
    .append(" ( USER_ID,PG_ID,PG_GROUP_ID,READ_FLAG,WRITE_FLAG,COM_FLAG,UPD_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUSER_ID()))
			.append(",")
           .append(toDB(entity.getPG_ID()))
			.append(",")
           .append(toDB(entity.getPG_GROUP_ID()))
			.append(",")
           .append(toDB(entity.getREAD_FLAG()))
			.append(",")
           .append(toDB(entity.getWRITE_FLAG()))
			.append(",")
           .append(toDB(entity.getCOM_FLAG()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			
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


    if((obj instanceof PT_AUTH_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_USER : update() ");
    }
    PT_AUTH_USEREntity entity = (PT_AUTH_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_AUTH_USER  set ")
       
        .append("PG_GROUP_ID = ")
        .append(toDB(entity.getPG_GROUP_ID())).append(",")
        .append("READ_FLAG = ")
        .append(toDB(entity.getREAD_FLAG())).append(",")
        .append("WRITE_FLAG = ")
        .append(toDB(entity.getWRITE_FLAG())).append(",")
        .append("COM_FLAG = ")
        .append(toDB(entity.getCOM_FLAG())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and USER_ID = ").append( toDB(entity.getUSER_ID()));
         
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



    if((obj instanceof PT_AUTH_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_USER : updateModifiedOnly() ");
    }
    PT_AUTH_USEREntity entity = (PT_AUTH_USEREntity)obj;

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
    sb.append("update PT_AUTH_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and USER_ID = ").append(toDB(entity.getUSER_ID()));
     
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

    if((obj instanceof PT_AUTH_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_USER : updateModifiedOnly() ");
    }
    PT_AUTH_USEREntity entity = (PT_AUTH_USEREntity)obj;

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
    sb.append("update PT_AUTH_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and USER_ID = ").append(toDB(entity.getUSER_ID()));
     
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

    if((obj instanceof PT_AUTH_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_USER : delete() ");
    }
    PT_AUTH_USEREntity entity = (PT_AUTH_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_AUTH_USER  where  1=1")
      
	  .append(" and USER_ID = ").append(toDB(entity.getUSER_ID()))
      
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
