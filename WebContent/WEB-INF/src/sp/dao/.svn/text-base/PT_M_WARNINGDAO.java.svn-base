


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_M_WARNING
*  테이블 설명 :
*  테이블 PK   :
*               TMP_WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               WARN_CONT:VARCHAR2(1024):
*               WARN_DT:VARCHAR2(8):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_NUM:VARCHAR2(12):
*               OPIN_COLL_CONT:VARCHAR2(500):
*               DECISION_DATE:VARCHAR2(8):
*               LIS_END_DATE:VARCHAR2(8):
*               OPINI_SUBMIT:VARCHAR2(1):
*               OPINI_SUBMIT_DATE:VARCHAR2(8):
*               BEFORE_DISPO:VARCHAR2(1):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_M_WARNINGDAO  extends SuperToDB{

  private String default_fields[]={ "WARN_CONT" , "WARN_DT" , "WRT_ID" , "INS_DT" , "UPD_DT" , "TMP_WRT_NUM" , "WRT_NUM" , "OPIN_COLL_CONT" , "DECISION_DATE" , "LIS_END_DATE" , "OPINI_SUBMIT" , "OPINI_SUBMIT_DATE" , "BEFORE_DISPO" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : insert() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_WARNING ")
    .append(" ( WARN_CONT,WARN_DT,WRT_ID,INS_DT,UPD_DT,TMP_WRT_NUM,WRT_NUM,OPIN_COLL_CONT,DECISION_DATE,LIS_END_DATE,OPINI_SUBMIT,OPINI_SUBMIT_DATE,BEFORE_DISPO ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getWARN_CONT()))
			.append(",")
           .append(toDB(entity.getWARN_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getOPIN_COLL_CONT()))
			.append(",")
           .append(toDB(entity.getDECISION_DATE()))
			.append(",")
           .append(toDB(entity.getLIS_END_DATE()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT_DATE()))
			.append(",")
           .append(toDB(entity.getBEFORE_DISPO()))
			
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

    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : insert() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_WARNING ")
    .append(" ( WARN_CONT,WARN_DT,WRT_ID,INS_DT,UPD_DT,TMP_WRT_NUM,WRT_NUM,OPIN_COLL_CONT,DECISION_DATE,LIS_END_DATE,OPINI_SUBMIT,OPINI_SUBMIT_DATE,BEFORE_DISPO ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getWARN_CONT()))
			.append(",")
           .append(toDB(entity.getWARN_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getOPIN_COLL_CONT()))
			.append(",")
           .append(toDB(entity.getDECISION_DATE()))
			.append(",")
           .append(toDB(entity.getLIS_END_DATE()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT_DATE()))
			.append(",")
           .append(toDB(entity.getBEFORE_DISPO()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : update() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_WARNING  set ")
       
        .append("WARN_CONT = ")
        .append(toDB(entity.getWARN_CONT())).append(",")
        .append("WARN_DT = ")
        .append(toDB(entity.getWARN_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("OPIN_COLL_CONT = ")
        .append(toDB(entity.getOPIN_COLL_CONT())).append(",")
        .append("DECISION_DATE = ")
        .append(toDB(entity.getDECISION_DATE())).append(",")
        .append("LIS_END_DATE = ")
        .append(toDB(entity.getLIS_END_DATE())).append(",")
        .append("OPINI_SUBMIT = ")
        .append(toDB(entity.getOPINI_SUBMIT())).append(",")
        .append("OPINI_SUBMIT_DATE = ")
        .append(toDB(entity.getOPINI_SUBMIT_DATE())).append(",")
        .append("BEFORE_DISPO = ")
        .append(toDB(entity.getBEFORE_DISPO()))
        .append(" where  1=1 ");
       
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         

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


    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : update() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_WARNING  set ")
       
        .append("WARN_CONT = ")
        .append(toDB(entity.getWARN_CONT())).append(",")
        .append("WARN_DT = ")
        .append(toDB(entity.getWARN_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("OPIN_COLL_CONT = ")
        .append(toDB(entity.getOPIN_COLL_CONT())).append(",")
        .append("DECISION_DATE = ")
        .append(toDB(entity.getDECISION_DATE())).append(",")
        .append("LIS_END_DATE = ")
        .append(toDB(entity.getLIS_END_DATE())).append(",")
        .append("OPINI_SUBMIT = ")
        .append(toDB(entity.getOPINI_SUBMIT())).append(",")
        .append("OPINI_SUBMIT_DATE = ")
        .append(toDB(entity.getOPINI_SUBMIT_DATE())).append(",")
        .append("BEFORE_DISPO = ")
        .append(toDB(entity.getBEFORE_DISPO()))
        .append(" where  1=1 ");
       
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : updateModifiedOnly() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;

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
    sb.append("update PT_M_WARNING  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

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



    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : updateModifiedOnly() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;


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
    sb.append("update PT_M_WARNING  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : updateModifiedOnly() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;

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
    sb.append("update PT_M_WARNING  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

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

    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : updateModifiedOnly() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;


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
    sb.append("update PT_M_WARNING  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : delete() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_WARNING  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
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

    if((obj instanceof PT_M_WARNINGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_WARNING : delete() ");
    }
    PT_M_WARNINGEntity entity = (PT_M_WARNINGEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_WARNING  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
