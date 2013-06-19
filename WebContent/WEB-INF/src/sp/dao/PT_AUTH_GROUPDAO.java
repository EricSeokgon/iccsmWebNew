


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_AUTH_GROUP
*  테이블 설명 :
*  테이블 PK   :
*               AUTH_GROUP_CODE
*  테이블 컬럼 :
*               AUTH_GROUP_CODE:VARCHAR2(5):
*               AUTH_GROUP_NAME:VARCHAR2(30):
*               ORDER_SEQ:NUMBER(11):
*               UPD_DT:VARCHAR2(24):
*               USE_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_AUTH_GROUPDAO  extends SuperToDB{

  private String default_fields[]={ "AUTH_GROUP_CODE" , "AUTH_GROUP_NAME" , "ORDER_SEQ" , "UPD_DT" , "USE_YN" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_AUTH_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_GROUP : insert() ");
    }
    PT_AUTH_GROUPEntity entity = (PT_AUTH_GROUPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_AUTH_GROUP ")
    .append(" ( AUTH_GROUP_CODE,AUTH_GROUP_NAME,ORDER_SEQ,UPD_DT,USE_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getAUTH_GROUP_CODE()))
			.append(",")
           .append(toDB(entity.getAUTH_GROUP_NAME()))
			.append(",")
           .append(toDB(entity.getORDER_SEQ()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getUSE_YN()))
			
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


    if((obj instanceof PT_AUTH_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_GROUP : update() ");
    }
    PT_AUTH_GROUPEntity entity = (PT_AUTH_GROUPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_AUTH_GROUP  set ")
       
        .append("AUTH_GROUP_NAME = ")
        .append(toDB(entity.getAUTH_GROUP_NAME())).append(",")
        .append("ORDER_SEQ = ")
        .append(toDB(entity.getORDER_SEQ())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("USE_YN = ")
        .append(toDB(entity.getUSE_YN()))
        .append(" where  1=1 ");
       
         sb.append(" and AUTH_GROUP_CODE = ").append( toDB(entity.getAUTH_GROUP_CODE()));
         

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



    if((obj instanceof PT_AUTH_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_GROUP : updateModifiedOnly() ");
    }
    PT_AUTH_GROUPEntity entity = (PT_AUTH_GROUPEntity)obj;

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
    sb.append("update PT_AUTH_GROUP  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and AUTH_GROUP_CODE = ").append(toDB(entity.getAUTH_GROUP_CODE()));
     

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

    if((obj instanceof PT_AUTH_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_GROUP : updateModifiedOnly() ");
    }
    PT_AUTH_GROUPEntity entity = (PT_AUTH_GROUPEntity)obj;

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
    sb.append("update PT_AUTH_GROUP  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and AUTH_GROUP_CODE = ").append(toDB(entity.getAUTH_GROUP_CODE()));
     

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

    if((obj instanceof PT_AUTH_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_AUTH_GROUP : delete() ");
    }
    PT_AUTH_GROUPEntity entity = (PT_AUTH_GROUPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_AUTH_GROUP  where  1=1")
      
	  .append(" and AUTH_GROUP_CODE = ").append(toDB(entity.getAUTH_GROUP_CODE()))
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
