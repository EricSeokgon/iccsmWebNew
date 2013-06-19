


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :TEST_TB
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :
*               JUMIN:VARCHAR2(32):
*               JUMIN_ENCODE:VARCHAR2(50):
*               JUMIN_JAVA:VARCHAR2(50):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class TEST_TBDAO  extends SuperToDB{

  private String default_fields[]={ "JUMIN" , "JUMIN_ENCODE" , "JUMIN_JAVA" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : insert() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into TEST_TB ")
    .append(" ( JUMIN,JUMIN_ENCODE,JUMIN_JAVA ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getJUMIN()))
			.append(",")
           .append(toDB(entity.getJUMIN_ENCODE()))
			.append(",")
           .append(toDB(entity.getJUMIN_JAVA()))
			
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

    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : insert() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into TEST_TB ")
    .append(" ( JUMIN,JUMIN_ENCODE,JUMIN_JAVA ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getJUMIN()))
			.append(",")
           .append(toDB(entity.getJUMIN_ENCODE()))
			.append(",")
           .append(toDB(entity.getJUMIN_JAVA()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : update() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update TEST_TB  set ")
       
        .append("JUMIN = ")
        .append(toDB(entity.getJUMIN())).append(",")
        .append("JUMIN_ENCODE = ")
        .append(toDB(entity.getJUMIN_ENCODE())).append(",")
        .append("JUMIN_JAVA = ")
        .append(toDB(entity.getJUMIN_JAVA()))
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


    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : update() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update TEST_TB  set ")
       
        .append("JUMIN = ")
        .append(toDB(entity.getJUMIN())).append(",")
        .append("JUMIN_ENCODE = ")
        .append(toDB(entity.getJUMIN_ENCODE())).append(",")
        .append("JUMIN_JAVA = ")
        .append(toDB(entity.getJUMIN_JAVA()))
        .append(" where  1=1 ");
       

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : updateModifiedOnly() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;

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
    sb.append("update TEST_TB  set " )
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



    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : updateModifiedOnly() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;


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
    sb.append("update TEST_TB  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : updateModifiedOnly() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;

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
    sb.append("update TEST_TB  set " )
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

    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : updateModifiedOnly() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;


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
    sb.append("update TEST_TB  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : delete() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from TEST_TB  where  1=1")
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

    if((obj instanceof TEST_TBEntity) == false){
        throw new  SQLException("DAO 에러(1): TEST_TB : delete() ");
    }
    TEST_TBEntity entity = (TEST_TBEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from TEST_TB  where  1=1")
       ;


   return sb.toString();
  }


}//Class End
