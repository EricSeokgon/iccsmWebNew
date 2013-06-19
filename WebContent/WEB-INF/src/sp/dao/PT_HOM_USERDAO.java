


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_HOM_USER
*  테이블 설명 :
*  테이블 PK   :
*               USER_ID
*  테이블 컬럼 :
*               USER_ID:VARCHAR2(16):
*               USER_NAME:VARCHAR2(64):
*               USER_PASSWD:VARCHAR2(64):
*               USER_NAT_NUM1:VARCHAR2(16):
*               USER_NAT_NUM2:VARCHAR2(50):
*               USER_EMAIL:VARCHAR2(128):
*               USER_ZIPCODE:VARCHAR2(8):
*               USER_ADDR:VARCHAR2(128):
*               USER_ADDR_ETC:VARCHAR2(128):
*               USER_TEL:VARCHAR2(16):
*               USER_MOBILE:VARCHAR2(16):
*               USER_SEX:VARCHAR2(16):
*               INP_SITE:VARCHAR2(50):
*               SC_CD:VARCHAR2(4):
*               SGG_CD:VARCHAR2(4):
*               CAPITAL:VARCHAR2(2):
*               BIGO:VARCHAR2(200):
*               SMS_YN:VARCHAR2(2):
*               NEWS_YN:VARCHAR2(2):
*               USE_CODE:VARCHAR2(1):
*               INS_DT:DATE:
*               UPD_DT:DATE:
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_HOM_USERDAO  extends SuperToDB{

  private String default_fields[]={ "USER_ID" , "USER_NAME" , "USER_PASSWD" , "USER_NAT_NUM1" , "USER_NAT_NUM2" , "USER_EMAIL" , "USER_ZIPCODE" , "USER_ADDR" , "USER_ADDR_ETC" , "USER_TEL" , "USER_MOBILE" , "USER_SEX" , "INP_SITE" , "SC_CD" , "SGG_CD" , "CAPITAL" , "BIGO" , "SMS_YN" , "NEWS_YN" , "USE_CODE" , "INS_DT" , "UPD_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_HOM_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_USER : insert() ");
    }
    PT_HOM_USEREntity entity = (PT_HOM_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_HOM_USER ")
    .append(" ( USER_ID,USER_NAME,USER_PASSWD,USER_NAT_NUM1,USER_NAT_NUM2,USER_EMAIL,USER_ZIPCODE,USER_ADDR,USER_ADDR_ETC,USER_TEL,USER_MOBILE,USER_SEX,INP_SITE,SC_CD,SGG_CD,CAPITAL,BIGO,SMS_YN,NEWS_YN,USE_CODE,INS_DT,UPD_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUSER_ID()))
			.append(",")
           .append(toDB(entity.getUSER_NAME()))
			.append(",")
           .append(toDB(entity.getUSER_PASSWD()))
			.append(",")
           .append(toDB(entity.getUSER_NAT_NUM1()))
			.append(",")
           .append(toDB(entity.getUSER_NAT_NUM2()))
			.append(",")
           .append(toDB(entity.getUSER_EMAIL()))
			.append(",")
           .append(toDB(entity.getUSER_ZIPCODE()))
			.append(",")
           .append(toDB(entity.getUSER_ADDR()))
			.append(",")
           .append(toDB(entity.getUSER_ADDR_ETC()))
			.append(",")
           .append(toDB(entity.getUSER_TEL()))
			.append(",")
           .append(toDB(entity.getUSER_MOBILE()))
			.append(",")
           .append(toDB(entity.getUSER_SEX()))
			.append(",")
           .append(toDB(entity.getINP_SITE()))
			.append(",")
           .append(toDB(entity.getSC_CD()))
			.append(",")
           .append(toDB(entity.getSGG_CD()))
			.append(",")
           .append(toDB(entity.getCAPITAL()))
			.append(",")
           .append(toDB(entity.getBIGO()))
			.append(",")
           .append(toDB(entity.getSMS_YN()))
			.append(",")
           .append(toDB(entity.getNEWS_YN()))
			.append(",")
           .append(toDB(entity.getUSE_CODE()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
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


    if((obj instanceof PT_HOM_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_USER : update() ");
    }
    PT_HOM_USEREntity entity = (PT_HOM_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_HOM_USER  set ")
       
        .append("USER_NAME = ")
        .append(toDB(entity.getUSER_NAME())).append(",")
        .append("USER_PASSWD = ")
        .append(toDB(entity.getUSER_PASSWD())).append(",")
        .append("USER_NAT_NUM1 = ")
        .append(toDB(entity.getUSER_NAT_NUM1())).append(",")
        .append("USER_NAT_NUM2 = ")
        .append(toDB(entity.getUSER_NAT_NUM2())).append(",")
        .append("USER_EMAIL = ")
        .append(toDB(entity.getUSER_EMAIL())).append(",")
        .append("USER_ZIPCODE = ")
        .append(toDB(entity.getUSER_ZIPCODE())).append(",")
        .append("USER_ADDR = ")
        .append(toDB(entity.getUSER_ADDR())).append(",")
        .append("USER_ADDR_ETC = ")
        .append(toDB(entity.getUSER_ADDR_ETC())).append(",")
        .append("USER_TEL = ")
        .append(toDB(entity.getUSER_TEL())).append(",")
        .append("USER_MOBILE = ")
        .append(toDB(entity.getUSER_MOBILE())).append(",")
        .append("USER_SEX = ")
        .append(toDB(entity.getUSER_SEX())).append(",")
        .append("INP_SITE = ")
        .append(toDB(entity.getINP_SITE())).append(",")
        .append("SC_CD = ")
        .append(toDB(entity.getSC_CD())).append(",")
        .append("SGG_CD = ")
        .append(toDB(entity.getSGG_CD())).append(",")
        .append("CAPITAL = ")
        .append(toDB(entity.getCAPITAL())).append(",")
        .append("BIGO = ")
        .append(toDB(entity.getBIGO())).append(",")
        .append("SMS_YN = ")
        .append(toDB(entity.getSMS_YN())).append(",")
        .append("NEWS_YN = ")
        .append(toDB(entity.getNEWS_YN())).append(",")
        .append("USE_CODE = ")
        .append(toDB(entity.getUSE_CODE())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and USER_ID = ").append( toDB(entity.getUSER_ID()));
         

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



    if((obj instanceof PT_HOM_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_USER : updateModifiedOnly() ");
    }
    PT_HOM_USEREntity entity = (PT_HOM_USEREntity)obj;

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
    sb.append("update PT_HOM_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and USER_ID = ").append(toDB(entity.getUSER_ID()));
     

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

    if((obj instanceof PT_HOM_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_USER : updateModifiedOnly() ");
    }
    PT_HOM_USEREntity entity = (PT_HOM_USEREntity)obj;

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
    sb.append("update PT_HOM_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and USER_ID = ").append(toDB(entity.getUSER_ID()));
     

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

    if((obj instanceof PT_HOM_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_USER : delete() ");
    }
    PT_HOM_USEREntity entity = (PT_HOM_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_HOM_USER  where  1=1")
      
	  .append(" and USER_ID = ").append(toDB(entity.getUSER_ID()))
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
