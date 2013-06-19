


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_BBS_COM_FILES
*  테이블 설명 :
*  테이블 PK   :
*               SYS_FILE_NAME
*  테이블 컬럼 :
*               CT_ID:VARCHAR2(30):
*               BOARD_SEQ:VARCHAR2(10):
*               FILE_REAL_NAME:VARCHAR2(250):
*               SYS_FILE_NAME:VARCHAR2(281):
*               FILE_SIZE:VARCHAR2(20):
*               UPD_DT:VARCHAR2(20):
*               DOWN_HIT:NUMBER(22):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_BBS_COM_FILESDAO  extends SuperToDB{

  private String default_fields[]={ "CT_ID" , "BOARD_SEQ" , "FILE_REAL_NAME" , "SYS_FILE_NAME" , "FILE_SIZE" , "UPD_DT" , "DOWN_HIT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_BBS_COM_FILESEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_FILES : insert() ");
    }
    PT_BBS_COM_FILESEntity entity = (PT_BBS_COM_FILESEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_BBS_COM_FILES ")
    .append(" ( CT_ID,BOARD_SEQ,FILE_REAL_NAME,SYS_FILE_NAME,FILE_SIZE,UPD_DT,DOWN_HIT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCT_ID()))
			.append(",")
           .append(toDB(entity.getBOARD_SEQ()))
			.append(",")
           .append(toDB(entity.getFILE_REAL_NAME()))
			.append(",")
           .append(toDB(entity.getSYS_FILE_NAME()))
			.append(",")
           .append(toDB(entity.getFILE_SIZE()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getDOWN_HIT()))
			
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


    if((obj instanceof PT_BBS_COM_FILESEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_FILES : update() ");
    }
    PT_BBS_COM_FILESEntity entity = (PT_BBS_COM_FILESEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_COM_FILES  set ")
       
        .append("CT_ID = ")
        .append(toDB(entity.getCT_ID())).append(",")
        .append("BOARD_SEQ = ")
        .append(toDB(entity.getBOARD_SEQ())).append(",")
        .append("FILE_REAL_NAME = ")
        .append(toDB(entity.getFILE_REAL_NAME())).append(",")
        .append("FILE_SIZE = ")
        .append(toDB(entity.getFILE_SIZE())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("DOWN_HIT = ")
        .append(toDB(entity.getDOWN_HIT()))
        .append(" where  1=1 ");
       
         sb.append(" and SYS_FILE_NAME = ").append( toDB(entity.getSYS_FILE_NAME()));
         

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



    if((obj instanceof PT_BBS_COM_FILESEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_FILES : updateModifiedOnly() ");
    }
    PT_BBS_COM_FILESEntity entity = (PT_BBS_COM_FILESEntity)obj;

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
    sb.append("update PT_BBS_COM_FILES  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SYS_FILE_NAME = ").append(toDB(entity.getSYS_FILE_NAME()));
     

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

    if((obj instanceof PT_BBS_COM_FILESEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_FILES : updateModifiedOnly() ");
    }
    PT_BBS_COM_FILESEntity entity = (PT_BBS_COM_FILESEntity)obj;

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
    sb.append("update PT_BBS_COM_FILES  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SYS_FILE_NAME = ").append(toDB(entity.getSYS_FILE_NAME()));
     

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

    if((obj instanceof PT_BBS_COM_FILESEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_FILES : delete() ");
    }
    PT_BBS_COM_FILESEntity entity = (PT_BBS_COM_FILESEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_BBS_COM_FILES  where  1=1")
      
	  .append(" and SYS_FILE_NAME = ").append(toDB(entity.getSYS_FILE_NAME()))
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
