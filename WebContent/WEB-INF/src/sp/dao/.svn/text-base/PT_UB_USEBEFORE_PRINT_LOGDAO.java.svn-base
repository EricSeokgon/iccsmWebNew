


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_UB_USEBEFORE_PRINT_LOG
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :
*               UB_LOG_SEQ:NUMBER(22):
*               USER_NAME:VARCHAR2(200):
*               CIV_RECV_NUM:VARCHAR2(100):
*               USER_NAT_NUM:VARCHAR2(32):
*               SIGUNGU_CODE:VARCHAR2(4):
*               USER_IP:VARCHAR2(18):
*               INSP_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_UB_USEBEFORE_PRINT_LOGDAO  extends SuperToDB{

  private String default_fields[]={ "UB_LOG_SEQ" , "USER_NAME" , "CIV_RECV_NUM" , "USER_NAT_NUM" , "SIGUNGU_CODE" , "USER_IP" , "INSP_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : insert() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_USEBEFORE_PRINT_LOG ")
    .append(" ( UB_LOG_SEQ,USER_NAME,CIV_RECV_NUM,USER_NAT_NUM,SIGUNGU_CODE,USER_IP,INSP_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUB_LOG_SEQ()))
			.append(",")
           .append(toDB(entity.getUSER_NAME()))
			.append(",")
           .append(toDB(entity.getCIV_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getUSER_NAT_NUM()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getUSER_IP()))
			.append(",")
           .append(toDB(entity.getINSP_DT()))
			
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

    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : insert() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_USEBEFORE_PRINT_LOG ")
    .append(" ( UB_LOG_SEQ,USER_NAME,CIV_RECV_NUM,USER_NAT_NUM,SIGUNGU_CODE,USER_IP,INSP_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUB_LOG_SEQ()))
			.append(",")
           .append(toDB(entity.getUSER_NAME()))
			.append(",")
           .append(toDB(entity.getCIV_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getUSER_NAT_NUM()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getUSER_IP()))
			.append(",")
           .append(toDB(entity.getINSP_DT()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : update() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_USEBEFORE_PRINT_LOG  set ")
       
        .append("UB_LOG_SEQ = ")
        .append(toDB(entity.getUB_LOG_SEQ())).append(",")
        .append("USER_NAME = ")
        .append(toDB(entity.getUSER_NAME())).append(",")
        .append("CIV_RECV_NUM = ")
        .append(toDB(entity.getCIV_RECV_NUM())).append(",")
        .append("USER_NAT_NUM = ")
        .append(toDB(entity.getUSER_NAT_NUM())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE())).append(",")
        .append("USER_IP = ")
        .append(toDB(entity.getUSER_IP())).append(",")
        .append("INSP_DT = ")
        .append(toDB(entity.getINSP_DT()))
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


    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : update() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_USEBEFORE_PRINT_LOG  set ")
       
        .append("UB_LOG_SEQ = ")
        .append(toDB(entity.getUB_LOG_SEQ())).append(",")
        .append("USER_NAME = ")
        .append(toDB(entity.getUSER_NAME())).append(",")
        .append("CIV_RECV_NUM = ")
        .append(toDB(entity.getCIV_RECV_NUM())).append(",")
        .append("USER_NAT_NUM = ")
        .append(toDB(entity.getUSER_NAT_NUM())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE())).append(",")
        .append("USER_IP = ")
        .append(toDB(entity.getUSER_IP())).append(",")
        .append("INSP_DT = ")
        .append(toDB(entity.getINSP_DT()))
        .append(" where  1=1 ");
       

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : updateModifiedOnly() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;

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
    sb.append("update PT_UB_USEBEFORE_PRINT_LOG  set " )
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



    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : updateModifiedOnly() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;


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
    sb.append("update PT_UB_USEBEFORE_PRINT_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : updateModifiedOnly() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;

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
    sb.append("update PT_UB_USEBEFORE_PRINT_LOG  set " )
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

    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : updateModifiedOnly() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;


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
    sb.append("update PT_UB_USEBEFORE_PRINT_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : delete() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_USEBEFORE_PRINT_LOG  where  1=1")
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

    if((obj instanceof PT_UB_USEBEFORE_PRINT_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_USEBEFORE_PRINT_LOG : delete() ");
    }
    PT_UB_USEBEFORE_PRINT_LOGEntity entity = (PT_UB_USEBEFORE_PRINT_LOGEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_USEBEFORE_PRINT_LOG  where  1=1")
       ;


   return sb.toString();
  }


}//Class End
