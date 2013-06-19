


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :P_S_MASTER
*  테이블 설명 :
*  테이블 PK   :
*               TMP_WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               WRT_NUM:VARCHAR2(12):
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_DT:VARCHAR2(8):
*               INV_EXPC_DT:VARCHAR2(8):
*               INV_DT:VARCHAR2(8):
*               PROC_STE:VARCHAR2(6):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               MOT_STE:VARCHAR2(6):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class P_S_MASTERDAO  extends SuperToDB{

  private String default_fields[]={ "WRT_NUM" , "TMP_WRT_NUM" , "WRT_DT" , "INV_EXPC_DT" , "INV_DT" , "PROC_STE" , "INS_DT" , "UPD_DT" , "WRT_ID" , "MOT_STE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof P_S_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): P_S_MASTER : insert() ");
    }
    P_S_MASTEREntity entity = (P_S_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into P_S_MASTER ")
    .append(" ( WRT_NUM,TMP_WRT_NUM,WRT_DT,INV_EXPC_DT,INV_DT,PROC_STE,INS_DT,UPD_DT,WRT_ID,MOT_STE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_DT()))
			.append(",")
           .append(toDB(entity.getINV_EXPC_DT()))
			.append(",")
           .append(toDB(entity.getINV_DT()))
			.append(",")
           .append(toDB(entity.getPROC_STE()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			
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


    if((obj instanceof P_S_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): P_S_MASTER : update() ");
    }
    P_S_MASTEREntity entity = (P_S_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update P_S_MASTER  set ")
       
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT())).append(",")
        .append("INV_EXPC_DT = ")
        .append(toDB(entity.getINV_EXPC_DT())).append(",")
        .append("INV_DT = ")
        .append(toDB(entity.getINV_DT())).append(",")
        .append("PROC_STE = ")
        .append(toDB(entity.getPROC_STE())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE()))
        .append(" where  1=1 ");
       
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         

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



    if((obj instanceof P_S_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): P_S_MASTER : updateModifiedOnly() ");
    }
    P_S_MASTEREntity entity = (P_S_MASTEREntity)obj;

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
    sb.append("update P_S_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     

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

    if((obj instanceof P_S_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): P_S_MASTER : updateModifiedOnly() ");
    }
    P_S_MASTEREntity entity = (P_S_MASTEREntity)obj;

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
    sb.append("update P_S_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     

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

    if((obj instanceof P_S_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): P_S_MASTER : delete() ");
    }
    P_S_MASTEREntity entity = (P_S_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from P_S_MASTER  where  1=1")
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
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
