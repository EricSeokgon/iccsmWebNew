


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_PAGE_CODE
*  테이블 설명 :
*  테이블 PK   :
*               CODE_GROUP_ID
*  테이블 컬럼 :
*               CODE_GROUP_ID:NUMBER(22):
*               CODE_GROUP:VARCHAR2(4):
*               CODE:VARCHAR2(16):
*               CODE_NAME:VARCHAR2(50):
*               CODE_URL:VARCHAR2(100):
*               ORDER_NUM:NUMBER(22):
*               USE_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_PAGE_CODEDAO  extends SuperToDB{

  private String default_fields[]={ "CODE_GROUP_ID" , "CODE_GROUP" , "CODE" , "CODE_NAME" , "CODE_URL" , "ORDER_NUM" , "USE_YN" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_PAGE_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PAGE_CODE : insert() ");
    }
    PT_PAGE_CODEEntity entity = (PT_PAGE_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_PAGE_CODE ")
    .append(" ( CODE_GROUP_ID,CODE_GROUP,CODE,CODE_NAME,CODE_URL,ORDER_NUM,USE_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCODE_GROUP_ID()))
			.append(",")
           .append(toDB(entity.getCODE_GROUP()))
			.append(",")
           .append(toDB(entity.getCODE()))
			.append(",")
           .append(toDB(entity.getCODE_NAME()))
			.append(",")
           .append(toDB(entity.getCODE_URL()))
			.append(",")
           .append(toDB(entity.getORDER_NUM()))
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


    if((obj instanceof PT_PAGE_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PAGE_CODE : update() ");
    }
    PT_PAGE_CODEEntity entity = (PT_PAGE_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_PAGE_CODE  set ")
       
        .append("CODE_NAME = ")
        .append(toDB(entity.getCODE_NAME())).append(",")
        .append("CODE_URL = ")
        .append(toDB(entity.getCODE_URL())).append(",")
        .append("ORDER_NUM = ")
        .append(toDB(entity.getORDER_NUM())).append(",")
        .append("USE_YN = ")
        .append(toDB(entity.getUSE_YN()))
        .append(" where  1=1 ");
       
         sb.append(" and CODE_GROUP_ID = ").append( toDB(entity.getCODE_GROUP_ID()));
         
         sb.append(" and CODE_GROUP = ").append( toDB(entity.getCODE_GROUP()));
         
         sb.append(" and CODE = ").append( toDB(entity.getCODE()));
         

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



    if((obj instanceof PT_PAGE_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PAGE_CODE : updateModifiedOnly() ");
    }
    PT_PAGE_CODEEntity entity = (PT_PAGE_CODEEntity)obj;

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
    sb.append("update PT_PAGE_CODE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CODE_GROUP_ID = ").append(toDB(entity.getCODE_GROUP_ID()));
     
	  sb.append(" and CODE_GROUP = ").append(toDB(entity.getCODE_GROUP()));
     
	  sb.append(" and CODE = ").append(toDB(entity.getCODE()));
     

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

    if((obj instanceof PT_PAGE_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PAGE_CODE : updateModifiedOnly() ");
    }
    PT_PAGE_CODEEntity entity = (PT_PAGE_CODEEntity)obj;

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
    sb.append("update PT_PAGE_CODE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CODE_GROUP_ID = ").append(toDB(entity.getCODE_GROUP_ID()));
     
	  sb.append(" and CODE_GROUP = ").append(toDB(entity.getCODE_GROUP()));
     
	  sb.append(" and CODE = ").append(toDB(entity.getCODE()));
     

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

    if((obj instanceof PT_PAGE_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_PAGE_CODE : delete() ");
    }
    PT_PAGE_CODEEntity entity = (PT_PAGE_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_PAGE_CODE  where  1=1")
      
	  .append(" and CODE_GROUP_ID = ").append(toDB(entity.getCODE_GROUP_ID()))
      
	  .append(" and CODE_GROUP = ").append(toDB(entity.getCODE_GROUP()))
      
	  .append(" and CODE = ").append(toDB(entity.getCODE()))
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
