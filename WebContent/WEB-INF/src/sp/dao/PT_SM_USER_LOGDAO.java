


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_SM_USER_LOG
*  테이블 설명 :
*  테이블 PK   :
*               LOG_NUM
*  테이블 컬럼 :
*               LOG_NUM:NUMBER(11):
*               USER_ID:VARCHAR2(16):
*               ACCESS_TIME:VARCHAR2(20):
*               END_TIME:VARCHAR2(20):
*               ACCESS_IP:VARCHAR2(15):
*               BROWSER:VARCHAR2(128):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_SM_USER_LOGDAO  extends SuperToDB{

  private String default_fields[]={ "LOG_NUM" , "USER_ID" , "ACCESS_TIME" , "END_TIME" , "ACCESS_IP" , "BROWSER" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_SM_USER_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_USER_LOG : insert() ");
    }
    PT_SM_USER_LOGEntity entity = (PT_SM_USER_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_SM_USER_LOG ")
    .append(" ( LOG_NUM,USER_ID,ACCESS_TIME,END_TIME,ACCESS_IP,BROWSER ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getLOG_NUM()))
			.append(",")
           .append(toDB(entity.getUSER_ID()))
			.append(",")
           .append(toDB(entity.getACCESS_TIME()))
			.append(",")
           .append(toDB(entity.getEND_TIME()))
			.append(",")
           .append(toDB(entity.getACCESS_IP()))
			.append(",")
           .append(toDB(entity.getBROWSER()))
			
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


    if((obj instanceof PT_SM_USER_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_USER_LOG : update() ");
    }
    PT_SM_USER_LOGEntity entity = (PT_SM_USER_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_SM_USER_LOG  set ")
       
        .append("USER_ID = ")
        .append(toDB(entity.getUSER_ID())).append(",")
        .append("ACCESS_TIME = ")
        .append(toDB(entity.getACCESS_TIME())).append(",")
        .append("END_TIME = ")
        .append(toDB(entity.getEND_TIME())).append(",")
        .append("ACCESS_IP = ")
        .append(toDB(entity.getACCESS_IP())).append(",")
        .append("BROWSER = ")
        .append(toDB(entity.getBROWSER()))
        .append(" where  1=1 ");
       
         sb.append(" and LOG_NUM = ").append( toDB(entity.getLOG_NUM()));
         

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



    if((obj instanceof PT_SM_USER_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_USER_LOG : updateModifiedOnly() ");
    }
    PT_SM_USER_LOGEntity entity = (PT_SM_USER_LOGEntity)obj;

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
    sb.append("update PT_SM_USER_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and LOG_NUM = ").append(toDB(entity.getLOG_NUM()));
     

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

    if((obj instanceof PT_SM_USER_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_USER_LOG : updateModifiedOnly() ");
    }
    PT_SM_USER_LOGEntity entity = (PT_SM_USER_LOGEntity)obj;

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
    sb.append("update PT_SM_USER_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and LOG_NUM = ").append(toDB(entity.getLOG_NUM()));
     

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

    if((obj instanceof PT_SM_USER_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_USER_LOG : delete() ");
    }
    PT_SM_USER_LOGEntity entity = (PT_SM_USER_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_SM_USER_LOG  where  1=1")
      
	  .append(" and LOG_NUM = ").append(toDB(entity.getLOG_NUM()))
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
