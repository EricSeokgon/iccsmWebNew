


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_COM_ZIPCODE
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :
*               SEQ:VARCHAR2(5):
*               ZIPCODE:VARCHAR2(7):
*               SIDO:VARCHAR2(6):
*               GUGUN:VARCHAR2(30):
*               DONG:VARCHAR2(100):
*               BUNJI:VARCHAR2(30):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_COM_ZIPCODEDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "ZIPCODE" , "SIDO" , "GUGUN" , "DONG" , "BUNJI" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_COM_ZIPCODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_COM_ZIPCODE : insert() ");
    }
    PT_COM_ZIPCODEEntity entity = (PT_COM_ZIPCODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_COM_ZIPCODE ")
    .append(" ( SEQ,ZIPCODE,SIDO,GUGUN,DONG,BUNJI ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getZIPCODE()))
			.append(",")
           .append(toDB(entity.getSIDO()))
			.append(",")
           .append(toDB(entity.getGUGUN()))
			.append(",")
           .append(toDB(entity.getDONG()))
			.append(",")
           .append(toDB(entity.getBUNJI()))
			
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


    if((obj instanceof PT_COM_ZIPCODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_COM_ZIPCODE : update() ");
    }
    PT_COM_ZIPCODEEntity entity = (PT_COM_ZIPCODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_COM_ZIPCODE  set ")
       
        .append("SEQ = ")
        .append(toDB(entity.getSEQ())).append(",")
        .append("ZIPCODE = ")
        .append(toDB(entity.getZIPCODE())).append(",")
        .append("SIDO = ")
        .append(toDB(entity.getSIDO())).append(",")
        .append("GUGUN = ")
        .append(toDB(entity.getGUGUN())).append(",")
        .append("DONG = ")
        .append(toDB(entity.getDONG())).append(",")
        .append("BUNJI = ")
        .append(toDB(entity.getBUNJI()))
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

  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_COM_ZIPCODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_COM_ZIPCODE : updateModifiedOnly() ");
    }
    PT_COM_ZIPCODEEntity entity = (PT_COM_ZIPCODEEntity)obj;

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
    sb.append("update PT_COM_ZIPCODE  set " )
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


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_COM_ZIPCODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_COM_ZIPCODE : updateModifiedOnly() ");
    }
    PT_COM_ZIPCODEEntity entity = (PT_COM_ZIPCODEEntity)obj;

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
    sb.append("update PT_COM_ZIPCODE  set " )
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
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_COM_ZIPCODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_COM_ZIPCODE : delete() ");
    }
    PT_COM_ZIPCODEEntity entity = (PT_COM_ZIPCODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_COM_ZIPCODE  where  1=1")
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
