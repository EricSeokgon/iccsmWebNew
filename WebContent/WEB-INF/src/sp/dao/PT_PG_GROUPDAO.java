


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_PG_GROUP
*  테이블 설명 :
*  테이블 PK   :
*               PG_GROUP_ID
*  테이블 컬럼 :
*               PG_GROUP_ID:VARCHAR2(5):
*               P_PG_GROUP_ID:VARCHAR2(5):
*               GROUP_NAME:VARCHAR2(100):
*               UPD_DT:DATE:
*               PG_GROUP_URL:VARCHAR2(100):
*               USE_YN:VARCHAR2(1):
*               ORDER_SEQ:NUMBER(11):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_PG_GROUPDAO  extends SuperToDB{

  private String default_fields[]={ "PG_GROUP_ID" , "P_PG_GROUP_ID" , "GROUP_NAME" , "UPD_DT" , "PG_GROUP_URL" , "USE_YN" , "ORDER_SEQ" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_PG_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG_GROUP : insert() ");
    }
    PT_PG_GROUPEntity entity = (PT_PG_GROUPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_PG_GROUP ")
    .append(" ( PG_GROUP_ID,P_PG_GROUP_ID,GROUP_NAME,UPD_DT,PG_GROUP_URL,USE_YN,ORDER_SEQ ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getPG_GROUP_ID()))
			.append(",")
           .append(toDB(entity.getP_PG_GROUP_ID()))
			.append(",")
           .append(toDB(entity.getGROUP_NAME()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getPG_GROUP_URL()))
			.append(",")
           .append(toDB(entity.getUSE_YN()))
			.append(",")
           .append(toDB(entity.getORDER_SEQ()))
			
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


    if((obj instanceof PT_PG_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG_GROUP : update() ");
    }
    PT_PG_GROUPEntity entity = (PT_PG_GROUPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_PG_GROUP  set ")
       
        .append("P_PG_GROUP_ID = ")
        .append(toDB(entity.getP_PG_GROUP_ID())).append(",")
        .append("GROUP_NAME = ")
        .append(toDB(entity.getGROUP_NAME())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("PG_GROUP_URL = ")
        .append(toDB(entity.getPG_GROUP_URL())).append(",")
        .append("USE_YN = ")
        .append(toDB(entity.getUSE_YN())).append(",")
        .append("ORDER_SEQ = ")
        .append(toDB(entity.getORDER_SEQ()))
        .append(" where  1=1 ");
       
         sb.append(" and PG_GROUP_ID = ").append( toDB(entity.getPG_GROUP_ID()));
         

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



    if((obj instanceof PT_PG_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG_GROUP : updateModifiedOnly() ");
    }
    PT_PG_GROUPEntity entity = (PT_PG_GROUPEntity)obj;

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
    sb.append("update PT_PG_GROUP  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and PG_GROUP_ID = ").append(toDB(entity.getPG_GROUP_ID()));
     

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

    if((obj instanceof PT_PG_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG_GROUP : updateModifiedOnly() ");
    }
    PT_PG_GROUPEntity entity = (PT_PG_GROUPEntity)obj;

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
    sb.append("update PT_PG_GROUP  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and PG_GROUP_ID = ").append(toDB(entity.getPG_GROUP_ID()));
     

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

    if((obj instanceof PT_PG_GROUPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PG_GROUP : delete() ");
    }
    PT_PG_GROUPEntity entity = (PT_PG_GROUPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_PG_GROUP  where  1=1")
      
	  .append(" and PG_GROUP_ID = ").append(toDB(entity.getPG_GROUP_ID()))
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
