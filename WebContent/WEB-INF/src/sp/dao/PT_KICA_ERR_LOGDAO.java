


/*
*  Automatic generated  source
*  ��  ��  �� : ����
*
*  ���̺� ��   :PT_KICA_ERR_LOG
*  ���̺� ���� :
*  ���̺� PK   :
*               SEQ
*  ���̺� �÷� :
*               SEQ:NUMBER(11):
*               U_D_FLAG:CHAR(1):
*               YYYYMMDD:VARCHAR2(8):
*               TRANSHOUR:VARCHAR2(2):
*               FILENAME:VARCHAR2(60):
*               ERRLOG:VARCHAR2(1000):
*               RESULT_FLAG:CHAR(1):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_KICA_ERR_LOGDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "U_D_FLAG" , "YYYYMMDD" , "TRANSHOUR" , "FILENAME" , "ERRLOG" , "RESULT_FLAG" , "UPD_DT" , "INS_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : insert() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_KICA_ERR_LOG ")
    .append(" ( SEQ,U_D_FLAG,YYYYMMDD,TRANSHOUR,FILENAME,ERRLOG,RESULT_FLAG,UPD_DT,INS_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getU_D_FLAG()))
			.append(",")
           .append(toDB(entity.getYYYYMMDD()))
			.append(",")
           .append(toDB(entity.getTRANSHOUR()))
			.append(",")
           .append(toDB(entity.getFILENAME()))
			.append(",")
           .append(toDB(entity.getERRLOG()))
			.append(",")
           .append(toDB(entity.getRESULT_FLAG()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			
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

    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : insert() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_KICA_ERR_LOG ")
    .append(" ( SEQ,U_D_FLAG,YYYYMMDD,TRANSHOUR,FILENAME,ERRLOG,RESULT_FLAG,UPD_DT,INS_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getU_D_FLAG()))
			.append(",")
           .append(toDB(entity.getYYYYMMDD()))
			.append(",")
           .append(toDB(entity.getTRANSHOUR()))
			.append(",")
           .append(toDB(entity.getFILENAME()))
			.append(",")
           .append(toDB(entity.getERRLOG()))
			.append(",")
           .append(toDB(entity.getRESULT_FLAG()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : update() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_KICA_ERR_LOG  set ")
       
        .append("U_D_FLAG = ")
        .append(toDB(entity.getU_D_FLAG())).append(",")
        .append("YYYYMMDD = ")
        .append(toDB(entity.getYYYYMMDD())).append(",")
        .append("TRANSHOUR = ")
        .append(toDB(entity.getTRANSHOUR())).append(",")
        .append("FILENAME = ")
        .append(toDB(entity.getFILENAME())).append(",")
        .append("ERRLOG = ")
        .append(toDB(entity.getERRLOG())).append(",")
        .append("RESULT_FLAG = ")
        .append(toDB(entity.getRESULT_FLAG())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT()))
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


    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : update() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_KICA_ERR_LOG  set ")
       
        .append("U_D_FLAG = ")
        .append(toDB(entity.getU_D_FLAG())).append(",")
        .append("YYYYMMDD = ")
        .append(toDB(entity.getYYYYMMDD())).append(",")
        .append("TRANSHOUR = ")
        .append(toDB(entity.getTRANSHOUR())).append(",")
        .append("FILENAME = ")
        .append(toDB(entity.getFILENAME())).append(",")
        .append("ERRLOG = ")
        .append(toDB(entity.getERRLOG())).append(",")
        .append("RESULT_FLAG = ")
        .append(toDB(entity.getRESULT_FLAG())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //������ �ʵ常�� �����Ѵ�.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : updateModifiedOnly() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;

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
    sb.append("update PT_KICA_ERR_LOG  set " )
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



    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : updateModifiedOnly() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;


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
    sb.append("update PT_KICA_ERR_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //Ư���ʵ带 ������ ��ü �ʵ带 �����Ѵ�.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : updateModifiedOnly() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;

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
    sb.append("update PT_KICA_ERR_LOG  set " )
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

    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : updateModifiedOnly() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;


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
    sb.append("update PT_KICA_ERR_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : delete() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_KICA_ERR_LOG  where  1=1")
      
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

    if((obj instanceof PT_KICA_ERR_LOGEntity) == false){
        throw new  SQLException("DAO ����(1): PT_KICA_ERR_LOG : delete() ");
    }
    PT_KICA_ERR_LOGEntity entity = (PT_KICA_ERR_LOGEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_KICA_ERR_LOG  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
       ;


   return sb.toString();
  }


}//Class End
