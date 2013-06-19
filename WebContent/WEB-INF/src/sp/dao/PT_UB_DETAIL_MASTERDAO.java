


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_UB_DETAIL_MASTER
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*  테이블 컬럼 :
*               SEQ:NUMBER(22):
*               ITEM:VARCHAR2(4):
*               LARCLAS:VARCHAR2(255):
*               SMACLAS:VARCHAR2(255):
*               CONT:VARCHAR2(255):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               MIDCLAS:VARCHAR2(255):
*               BAS:VARCHAR2(200):
*               CONT_YN:VARCHAR2(10):
*               ORDER_SEQ:NUMBER(4):
*               DETAIL_CONT:VARCHAR2(255):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_UB_DETAIL_MASTERDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "ITEM" , "LARCLAS" , "SMACLAS" , "CONT" , "WRT_ID" , "INS_DT" , "UPD_DT" , "MIDCLAS" , "BAS" , "CONT_YN" , "ORDER_SEQ" , "DETAIL_CONT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : insert() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_DETAIL_MASTER ")
    .append(" ( SEQ,ITEM,LARCLAS,SMACLAS,CONT,WRT_ID,INS_DT,UPD_DT,MIDCLAS,BAS,CONT_YN,ORDER_SEQ,DETAIL_CONT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getITEM()))
			.append(",")
           .append(toDB(entity.getLARCLAS()))
			.append(",")
           .append(toDB(entity.getSMACLAS()))
			.append(",")
           .append(toDB(entity.getCONT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getMIDCLAS()))
			.append(",")
           .append(toDB(entity.getBAS()))
			.append(",")
           .append(toDB(entity.getCONT_YN()))
			.append(",")
           .append(toDB(entity.getORDER_SEQ()))
			.append(",")
           .append(toDB(entity.getDETAIL_CONT()))
			
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

    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : insert() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_DETAIL_MASTER ")
    .append(" ( SEQ,ITEM,LARCLAS,SMACLAS,CONT,WRT_ID,INS_DT,UPD_DT,MIDCLAS,BAS,CONT_YN,ORDER_SEQ,DETAIL_CONT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getITEM()))
			.append(",")
           .append(toDB(entity.getLARCLAS()))
			.append(",")
           .append(toDB(entity.getSMACLAS()))
			.append(",")
           .append(toDB(entity.getCONT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getMIDCLAS()))
			.append(",")
           .append(toDB(entity.getBAS()))
			.append(",")
           .append(toDB(entity.getCONT_YN()))
			.append(",")
           .append(toDB(entity.getORDER_SEQ()))
			.append(",")
           .append(toDB(entity.getDETAIL_CONT()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : update() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_DETAIL_MASTER  set ")
       
        .append("ITEM = ")
        .append(toDB(entity.getITEM())).append(",")
        .append("LARCLAS = ")
        .append(toDB(entity.getLARCLAS())).append(",")
        .append("SMACLAS = ")
        .append(toDB(entity.getSMACLAS())).append(",")
        .append("CONT = ")
        .append(toDB(entity.getCONT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("MIDCLAS = ")
        .append(toDB(entity.getMIDCLAS())).append(",")
        .append("BAS = ")
        .append(toDB(entity.getBAS())).append(",")
        .append("CONT_YN = ")
        .append(toDB(entity.getCONT_YN())).append(",")
        .append("ORDER_SEQ = ")
        .append(toDB(entity.getORDER_SEQ())).append(",")
        .append("DETAIL_CONT = ")
        .append(toDB(entity.getDETAIL_CONT()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         

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


    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : update() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_DETAIL_MASTER  set ")
       
        .append("ITEM = ")
        .append(toDB(entity.getITEM())).append(",")
        .append("LARCLAS = ")
        .append(toDB(entity.getLARCLAS())).append(",")
        .append("SMACLAS = ")
        .append(toDB(entity.getSMACLAS())).append(",")
        .append("CONT = ")
        .append(toDB(entity.getCONT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("MIDCLAS = ")
        .append(toDB(entity.getMIDCLAS())).append(",")
        .append("BAS = ")
        .append(toDB(entity.getBAS())).append(",")
        .append("CONT_YN = ")
        .append(toDB(entity.getCONT_YN())).append(",")
        .append("ORDER_SEQ = ")
        .append(toDB(entity.getORDER_SEQ())).append(",")
        .append("DETAIL_CONT = ")
        .append(toDB(entity.getDETAIL_CONT()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : updateModifiedOnly() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;

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
    sb.append("update PT_UB_DETAIL_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

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



    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : updateModifiedOnly() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;


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
    sb.append("update PT_UB_DETAIL_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : updateModifiedOnly() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;

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
    sb.append("update PT_UB_DETAIL_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

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

    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : updateModifiedOnly() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;


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
    sb.append("update PT_UB_DETAIL_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : delete() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_DETAIL_MASTER  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
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

    if((obj instanceof PT_UB_DETAIL_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_DETAIL_MASTER : delete() ");
    }
    PT_UB_DETAIL_MASTEREntity entity = (PT_UB_DETAIL_MASTEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_DETAIL_MASTER  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
       ;


   return sb.toString();
  }


}//Class End
