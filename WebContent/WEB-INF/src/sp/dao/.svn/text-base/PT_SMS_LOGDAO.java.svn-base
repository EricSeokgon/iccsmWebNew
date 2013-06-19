


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_SMS_LOG
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :
*               USER_ID:VARCHAR2(12):
*               LOCAL_CD:VARCHAR2(4):
*               AREA_CD:VARCHAR2(5):
*               FROM_TEL:VARCHAR2(14):
*               TO_TEL:VARCHAR2(14):
*               MSG:VARCHAR2(82):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               RESULT:CHAR(1):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_SMS_LOGDAO  extends SuperToDB{

  private String default_fields[]={ "USER_ID" , "LOCAL_CD" , "AREA_CD" , "FROM_TEL" , "TO_TEL" , "MSG" , "INS_DT" , "UPD_DT" , "RESULT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : insert() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_SMS_LOG ")
    .append(" ( USER_ID,LOCAL_CD,AREA_CD,FROM_TEL,TO_TEL,MSG,INS_DT,UPD_DT,RESULT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUSER_ID()))
			.append(",")
           .append(toDB(entity.getLOCAL_CD()))
			.append(",")
           .append(toDB(entity.getAREA_CD()))
			.append(",")
           .append(toDB(entity.getFROM_TEL()))
			.append(",")
           .append(toDB(entity.getTO_TEL()))
			.append(",")
           .append(toDB(entity.getMSG()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getRESULT()))
			
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

    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : insert() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_SMS_LOG ")
    .append(" ( USER_ID,LOCAL_CD,AREA_CD,FROM_TEL,TO_TEL,MSG,INS_DT,UPD_DT,RESULT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUSER_ID()))
			.append(",")
           .append(toDB(entity.getLOCAL_CD()))
			.append(",")
           .append(toDB(entity.getAREA_CD()))
			.append(",")
           .append(toDB(entity.getFROM_TEL()))
			.append(",")
           .append(toDB(entity.getTO_TEL()))
			.append(",")
           .append(toDB(entity.getMSG()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getRESULT()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : update() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_SMS_LOG  set ")
       
        .append("USER_ID = ")
        .append(toDB(entity.getUSER_ID())).append(",")
        .append("LOCAL_CD = ")
        .append(toDB(entity.getLOCAL_CD())).append(",")
        .append("AREA_CD = ")
        .append(toDB(entity.getAREA_CD())).append(",")
        .append("FROM_TEL = ")
        .append(toDB(entity.getFROM_TEL())).append(",")
        .append("TO_TEL = ")
        .append(toDB(entity.getTO_TEL())).append(",")
        .append("MSG = ")
        .append(toDB(entity.getMSG())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("RESULT = ")
        .append(toDB(entity.getRESULT()))
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


    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : update() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_SMS_LOG  set ")
       
        .append("USER_ID = ")
        .append(toDB(entity.getUSER_ID())).append(",")
        .append("LOCAL_CD = ")
        .append(toDB(entity.getLOCAL_CD())).append(",")
        .append("AREA_CD = ")
        .append(toDB(entity.getAREA_CD())).append(",")
        .append("FROM_TEL = ")
        .append(toDB(entity.getFROM_TEL())).append(",")
        .append("TO_TEL = ")
        .append(toDB(entity.getTO_TEL())).append(",")
        .append("MSG = ")
        .append(toDB(entity.getMSG())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("RESULT = ")
        .append(toDB(entity.getRESULT()))
        .append(" where  1=1 ");
       

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : updateModifiedOnly() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;

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
    sb.append("update PT_SMS_LOG  set " )
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



    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : updateModifiedOnly() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;


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
    sb.append("update PT_SMS_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : updateModifiedOnly() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;

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
    sb.append("update PT_SMS_LOG  set " )
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

    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : updateModifiedOnly() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;


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
    sb.append("update PT_SMS_LOG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : delete() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_SMS_LOG  where  1=1")
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

    if((obj instanceof PT_SMS_LOGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SMS_LOG : delete() ");
    }
    PT_SMS_LOGEntity entity = (PT_SMS_LOGEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_SMS_LOG  where  1=1")
       ;


   return sb.toString();
  }


}//Class End
