


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_UB_FILE
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SEQ
*               SIDO_CODE
*               SIGUNGU_CODE
*  테이블 컬럼 :
*               FILE_NM:VARCHAR2(100):
*               FILE_SIZE:VARCHAR2(10):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               SEQ:NUMBER(22):
*               RECV_NUM:VARCHAR2(30):
*               SIDO_CODE:VARCHAR2(5):
*               SIGUNGU_CODE:VARCHAR2(4):
*               UPD_DT_OLD:VARCHAR2(24):
*               BACKUP_TRANS_DT:VARCHAR2(24):
*               SYS_FILE_NAME:VARCHAR2(281):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_UB_FILEDAO  extends SuperToDB{

  private String default_fields[]={ "FILE_NM" , "FILE_SIZE" , "WRT_ID" , "INS_DT" , "UPD_DT" , "SEQ" , "RECV_NUM" , "SIDO_CODE" , "SIGUNGU_CODE" , "UPD_DT_OLD" , "BACKUP_TRANS_DT" , "SYS_FILE_NAME" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : insert() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_FILE ")
    .append(" ( FILE_NM,FILE_SIZE,WRT_ID,INS_DT,UPD_DT,SEQ,RECV_NUM,SIDO_CODE,SIGUNGU_CODE,UPD_DT_OLD,BACKUP_TRANS_DT,SYS_FILE_NAME ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getFILE_NM()))
			.append(",")
           .append(toDB(entity.getFILE_SIZE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getUPD_DT_OLD()))
			.append(",")
           .append(toDB(entity.getBACKUP_TRANS_DT()))
			.append(",")
           .append(toDB(entity.getSYS_FILE_NAME()))
			
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

    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : insert() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_FILE ")
    .append(" ( FILE_NM,FILE_SIZE,WRT_ID,INS_DT,UPD_DT,SEQ,RECV_NUM,SIDO_CODE,SIGUNGU_CODE,UPD_DT_OLD,BACKUP_TRANS_DT,SYS_FILE_NAME ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getFILE_NM()))
			.append(",")
           .append(toDB(entity.getFILE_SIZE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getUPD_DT_OLD()))
			.append(",")
           .append(toDB(entity.getBACKUP_TRANS_DT()))
			.append(",")
           .append(toDB(entity.getSYS_FILE_NAME()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : update() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_FILE  set ")
       
        .append("FILE_NM = ")
        .append(toDB(entity.getFILE_NM())).append(",")
        .append("FILE_SIZE = ")
        .append(toDB(entity.getFILE_SIZE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("UPD_DT_OLD = ")
        .append(toDB(entity.getUPD_DT_OLD())).append(",")
        .append("BACKUP_TRANS_DT = ")
        .append(toDB(entity.getBACKUP_TRANS_DT())).append(",")
        .append("SYS_FILE_NAME = ")
        .append(toDB(entity.getSYS_FILE_NAME()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and SIGUNGU_CODE = ").append( toDB(entity.getSIGUNGU_CODE()));
         

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


    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : update() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_FILE  set ")
       
        .append("FILE_NM = ")
        .append(toDB(entity.getFILE_NM())).append(",")
        .append("FILE_SIZE = ")
        .append(toDB(entity.getFILE_SIZE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("UPD_DT_OLD = ")
        .append(toDB(entity.getUPD_DT_OLD())).append(",")
        .append("BACKUP_TRANS_DT = ")
        .append(toDB(entity.getBACKUP_TRANS_DT())).append(",")
        .append("SYS_FILE_NAME = ")
        .append(toDB(entity.getSYS_FILE_NAME()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and SIGUNGU_CODE = ").append( toDB(entity.getSIGUNGU_CODE()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : updateModifiedOnly() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;

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
    sb.append("update PT_UB_FILE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     

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



    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : updateModifiedOnly() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;


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
    sb.append("update PT_UB_FILE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : updateModifiedOnly() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;

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
    sb.append("update PT_UB_FILE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     

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

    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : updateModifiedOnly() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;


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
    sb.append("update PT_UB_FILE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : delete() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_FILE  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
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

    if((obj instanceof PT_UB_FILEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_FILE : delete() ");
    }
    PT_UB_FILEEntity entity = (PT_UB_FILEEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_FILE  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
       ;


   return sb.toString();
  }


}//Class End
