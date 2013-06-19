


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_USER
*  테이블 설명 :
*  테이블 PK   :
*               USER_CODE
*  테이블 컬럼 :
*               USER_CODE:VARCHAR2(10):
*               USER_NAME:VARCHAR2(40):
*               USER_ID:VARCHAR2(12):
*               USER_PASSWD:VARCHAR2(12):
*               USER_EMAIL:VARCHAR2(60):
*               USER_TEL:VARCHAR2(14):
*               USER_MOBILE:VARCHAR2(14):
*               USER_NAT_NUM:VARCHAR2(14):
*               POST:VARCHAR2(40):
*               EMAIL:VARCHAR2(50):
*               CAPITAL:VARCHAR2(20):
*               USE_YN:VARCHAR2(1):
*               REG_DATE:VARCHAR2(30):
*               MOD_DATE:VARCHAR2(10):
*               LAST_CONN:VARCHAR2(20):
*               ORGANIZATION:VARCHAR2(40):
*               POSITION:VARCHAR2(50):
*               STAFF_SYSTEM:VARCHAR2(40):
*               STAFF_LEVEL:VARCHAR2(40):
*               USER_AUTH:VARCHAR2(20):
*               USER_LEVEL:NUMBER(22):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_USERDAO  extends SuperToDB{

  private String default_fields[]={ "USER_CODE" , "USER_NAME" , "USER_ID" , "USER_PASSWD" , "USER_EMAIL" , "USER_TEL" , "USER_MOBILE" , "USER_NAT_NUM" , "POST" , "EMAIL" , "CAPITAL" , "USE_YN" , "REG_DATE" , "MOD_DATE" , "LAST_CONN" , "ORGANIZATION" , "POSITION" , "STAFF_SYSTEM" , "STAFF_LEVEL" , "USER_AUTH" , "USER_LEVEL" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_USER : insert() ");
    }
    PT_USEREntity entity = (PT_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_USER ")
    .append(" ( USER_CODE,USER_NAME,USER_ID,USER_PASSWD,USER_EMAIL,USER_TEL,USER_MOBILE,USER_NAT_NUM,POST,EMAIL,CAPITAL,USE_YN,REG_DATE,MOD_DATE,LAST_CONN,ORGANIZATION,POSITION,STAFF_SYSTEM,STAFF_LEVEL,USER_AUTH,USER_LEVEL ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUSER_CODE()))
			.append(",")
           .append(toDB(entity.getUSER_NAME()))
			.append(",")
           .append(toDB(entity.getUSER_ID()))
			.append(",")
           .append(toDB(entity.getUSER_PASSWD()))
			.append(",")
           .append(toDB(entity.getUSER_EMAIL()))
			.append(",")
           .append(toDB(entity.getUSER_TEL()))
			.append(",")
           .append(toDB(entity.getUSER_MOBILE()))
			.append(",")
           .append(toDB(entity.getUSER_NAT_NUM()))
			.append(",")
           .append(toDB(entity.getPOST()))
			.append(",")
           .append(toDB(entity.getEMAIL()))
			.append(",")
           .append(toDB(entity.getCAPITAL()))
			.append(",")
           .append(toDB(entity.getUSE_YN()))
			.append(",")
           .append(toDB(entity.getREG_DATE()))
			.append(",")
           .append(toDB(entity.getMOD_DATE()))
			.append(",")
           .append(toDB(entity.getLAST_CONN()))
			.append(",")
           .append(toDB(entity.getORGANIZATION()))
			.append(",")
           .append(toDB(entity.getPOSITION()))
			.append(",")
           .append(toDB(entity.getSTAFF_SYSTEM()))
			.append(",")
           .append(toDB(entity.getSTAFF_LEVEL()))
			.append(",")
           .append(toDB(entity.getUSER_AUTH()))
			.append(",")
           .append(toDB(entity.getUSER_LEVEL()))
			
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


    if((obj instanceof PT_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_USER : update() ");
    }
    PT_USEREntity entity = (PT_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_USER  set ")
       
        .append("USER_NAME = ")
        .append(toDB(entity.getUSER_NAME())).append(",")
        .append("USER_ID = ")
        .append(toDB(entity.getUSER_ID())).append(",")
        .append("USER_PASSWD = ")
        .append(toDB(entity.getUSER_PASSWD())).append(",")
        .append("USER_EMAIL = ")
        .append(toDB(entity.getUSER_EMAIL())).append(",")
        .append("USER_TEL = ")
        .append(toDB(entity.getUSER_TEL())).append(",")
        .append("USER_MOBILE = ")
        .append(toDB(entity.getUSER_MOBILE())).append(",")
        .append("USER_NAT_NUM = ")
        .append(toDB(entity.getUSER_NAT_NUM())).append(",")
        .append("POST = ")
        .append(toDB(entity.getPOST())).append(",")
        .append("EMAIL = ")
        .append(toDB(entity.getEMAIL())).append(",")
        .append("CAPITAL = ")
        .append(toDB(entity.getCAPITAL())).append(",")
        .append("USE_YN = ")
        .append(toDB(entity.getUSE_YN())).append(",")
        .append("REG_DATE = ")
        .append(toDB(entity.getREG_DATE())).append(",")
        .append("MOD_DATE = ")
        .append(toDB(entity.getMOD_DATE())).append(",")
        .append("LAST_CONN = ")
        .append(toDB(entity.getLAST_CONN())).append(",")
        .append("ORGANIZATION = ")
        .append(toDB(entity.getORGANIZATION())).append(",")
        .append("POSITION = ")
        .append(toDB(entity.getPOSITION())).append(",")
        .append("STAFF_SYSTEM = ")
        .append(toDB(entity.getSTAFF_SYSTEM())).append(",")
        .append("STAFF_LEVEL = ")
        .append(toDB(entity.getSTAFF_LEVEL())).append(",")
        .append("USER_AUTH = ")
        .append(toDB(entity.getUSER_AUTH())).append(",")
        .append("USER_LEVEL = ")
        .append(toDB(entity.getUSER_LEVEL()))
        .append(" where  1=1 ");
       
         sb.append(" and USER_CODE = ").append( toDB(entity.getUSER_CODE()));
         

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



    if((obj instanceof PT_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_USER : updateModifiedOnly() ");
    }
    PT_USEREntity entity = (PT_USEREntity)obj;

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
    sb.append("update PT_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and USER_CODE = ").append(toDB(entity.getUSER_CODE()));
     

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

    if((obj instanceof PT_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_USER : updateModifiedOnly() ");
    }
    PT_USEREntity entity = (PT_USEREntity)obj;

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
    sb.append("update PT_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and USER_CODE = ").append(toDB(entity.getUSER_CODE()));
     

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

    if((obj instanceof PT_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_USER : delete() ");
    }
    PT_USEREntity entity = (PT_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_USER  where  1=1")
      
	  .append(" and USER_CODE = ").append(toDB(entity.getUSER_CODE()))
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
