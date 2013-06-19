


/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_SM_PROGRAM_LOG
*  테이블 설명 :
*  테이블 PK   :  
*               LOG_NUM  
*               USER_CODE
*  테이블 컬럼 :  
*               LOG_NUM:NUMBER(22):  
*               USER_CODE:VARCHAR2(10):  
*               ACCESS_TIME:VARCHAR2(20):  
*               PROGRAM_ID:VARCHAR2(20):  
*               USER_ACTION:VARCHAR2(4):  
*               REQ_URI:VARCHAR2(128):  
*               USER_DATA:VARCHAR2(500):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;

public class PT_SM_PROGRAM_LOGDAO  extends SuperToDB{

  public int insert( ValueObject  obj) throws SQLException{
   
    if((obj instanceof PT_SM_PROGRAM_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_PROGRAM_LOG : insert() ");
    }
    PT_SM_PROGRAM_LOGEntity entity = (PT_SM_PROGRAM_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_SM_PROGRAM_LOG ")
    .append(" ( LOG_NUM,USER_CODE,ACCESS_TIME,PROGRAM_ID,USER_ACTION,REQ_URI,USER_DATA ) ")
    .append(" values ( ") 
      
           .append(toDB(entity.getLOG_NUM()))
        .append(",")
           .append(toDB(entity.getUSER_CODE()))
        .append(",")
           .append(toDB(entity.getACCESS_TIME()))
        .append(",")
           .append(toDB(entity.getPROGRAM_ID()))
        .append(",")
           .append(toDB(entity.getUSER_ACTION()))
        .append(",")
           .append(toDB(entity.getREQ_URI()))
        .append(",")
           .append(toDB(entity.getUSER_DATA()))
        
    .append(" ) ");

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
    return result ;  
  }

  public int  update( ValueObject obj) throws SQLException{
    
  
    if((obj instanceof PT_SM_PROGRAM_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_PROGRAM_LOG : update() ");
    }
    PT_SM_PROGRAM_LOGEntity entity = (PT_SM_PROGRAM_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_SM_PROGRAM_LOG  set ")
       
        .append("ACCESS_TIME = ")
        .append(toDB(entity.getACCESS_TIME()) )    .append(",")
        .append("PROGRAM_ID = ")
        .append(toDB(entity.getPROGRAM_ID()) )    .append(",")
        .append("USER_ACTION = ")
        .append(toDB(entity.getUSER_ACTION()) )    .append(",")
        .append("REQ_URI = ")
        .append(toDB(entity.getREQ_URI()) )    .append(",")
        .append("USER_DATA = ")
        .append(toDB(entity.getUSER_DATA()) )    
       .append(" where  1=1 ");
        
         sb.append(" and LOG_NUM = ").append( toDB(entity.getLOG_NUM()));
          
         sb.append(" and USER_CODE = ").append( toDB(entity.getUSER_CODE()));
         

   KJFLog.sql(sb.toString());

   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());
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

    
  
    if((obj instanceof PT_SM_PROGRAM_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_PROGRAM_LOG : updateModifiedOnly() ");
    }
    PT_SM_PROGRAM_LOGEntity entity = (PT_SM_PROGRAM_LOGEntity)obj;

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
           setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
        } 
    }
    if(flag = false)
       throw new  SQLException("Nothing to update"); 
       
     
  
    StringBuffer sb = new StringBuffer();
    sb.append("update PT_SM_PROGRAM_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
      
	  sb.append(" and LOG_NUM = ").append(toDB(entity.getLOG_NUM()));
      
	  sb.append(" and USER_CODE = ").append(toDB(entity.getUSER_CODE()));
     

   KJFLog.sql( sb.toString());

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

	return result ;  
  }

  public int delete(ValueObject obj) throws SQLException{
  
    if((obj instanceof PT_SM_PROGRAM_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SM_PROGRAM_LOG : delete() ");
    }
    PT_SM_PROGRAM_LOGEntity entity = (PT_SM_PROGRAM_LOGEntity)obj;
    
    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_SM_PROGRAM_LOG  where  1=1")
       
	  .append(" and LOG_NUM = ").append(toDB(entity.getLOG_NUM()))
       
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
