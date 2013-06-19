


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_S_SYSVAR_MASTER
*  테이블 설명 :
*  테이블 PK   :
*               SIDO_CODE
*               SIGUNGU_CODE
*  테이블 컬럼 :
*               SIDO_CODE:VARCHAR2(4):
*               SIGUNGU_CODE:VARCHAR2(5):
*               NEW_WRT:NUMBER(3):
*               BAS_STA:NUMBER(3):
*               AFF:NUMBER(3):
*               ASSI_TRAN:NUMBER(3):
*               USEBEF_INSP:NUMBER(3):
*               CYTYSEAL:VARCHAR2(26):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               SERVER_ADDR:VARCHAR2(100):
*               SERVER_YN:VARCHAR2(1):
*               SEND_SYS_ID:VARCHAR2(40):
*               RECV_SYS_ID:VARCHAR2(40):
*               CITYSEAL_USE_YN:CHAR(1):
*               CITYSEAL_WIDTH:VARCHAR2(5):
*               CITYSEAL_HEIGHT:VARCHAR2(5):
*               GROUPWARE_MODULE_TYPE:VARCHAR2(20):
*               ONLINE_CERT_USE_YN:CHAR(1):
*               APPL_GUBUN:CHAR(1):
*               WEEKCHK:VARCHAR2(2):
*               INSTODAY:VARCHAR2(3):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_S_SYSVAR_MASTERDAO  extends SuperToDB{

  private String default_fields[]={ "SIDO_CODE" , "SIGUNGU_CODE" , "NEW_WRT" , "BAS_STA" , "AFF" , "ASSI_TRAN" , "USEBEF_INSP" , "CYTYSEAL" , "WRT_ID" , "INS_DT" , "UPD_DT" , "SERVER_ADDR" , "SERVER_YN" , "SEND_SYS_ID" , "RECV_SYS_ID" , "CITYSEAL_USE_YN" , "CITYSEAL_WIDTH" , "CITYSEAL_HEIGHT" , "GROUPWARE_MODULE_TYPE" , "ONLINE_CERT_USE_YN" , "APPL_GUBUN" , "WEEKCHK" , "INSTODAY" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : insert() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_S_SYSVAR_MASTER ")
    .append(" ( SIDO_CODE,SIGUNGU_CODE,NEW_WRT,BAS_STA,AFF,ASSI_TRAN,USEBEF_INSP,CYTYSEAL,WRT_ID,INS_DT,UPD_DT,SERVER_ADDR,SERVER_YN,SEND_SYS_ID,RECV_SYS_ID,CITYSEAL_USE_YN,CITYSEAL_WIDTH,CITYSEAL_HEIGHT,GROUPWARE_MODULE_TYPE,ONLINE_CERT_USE_YN,APPL_GUBUN,WEEKCHK,INSTODAY ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getNEW_WRT()))
			.append(",")
           .append(toDB(entity.getBAS_STA()))
			.append(",")
           .append(toDB(entity.getAFF()))
			.append(",")
           .append(toDB(entity.getASSI_TRAN()))
			.append(",")
           .append(toDB(entity.getUSEBEF_INSP()))
			.append(",")
           .append(toDB(entity.getCYTYSEAL()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSERVER_ADDR()))
			.append(",")
           .append(toDB(entity.getSERVER_YN()))
			.append(",")
           .append(toDB(entity.getSEND_SYS_ID()))
			.append(",")
           .append(toDB(entity.getRECV_SYS_ID()))
			.append(",")
           .append(toDB(entity.getCITYSEAL_USE_YN()))
			.append(",")
           .append(toDB(entity.getCITYSEAL_WIDTH()))
			.append(",")
           .append(toDB(entity.getCITYSEAL_HEIGHT()))
			.append(",")
           .append(toDB(entity.getGROUPWARE_MODULE_TYPE()))
			.append(",")
           .append(toDB(entity.getONLINE_CERT_USE_YN()))
			.append(",")
           .append(toDB(entity.getAPPL_GUBUN()))
			.append(",")
           .append(toDB(entity.getWEEKCHK()))
			.append(",")
           .append(toDB(entity.getINSTODAY()))
			
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

    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : insert() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_S_SYSVAR_MASTER ")
    .append(" ( SIDO_CODE,SIGUNGU_CODE,NEW_WRT,BAS_STA,AFF,ASSI_TRAN,USEBEF_INSP,CYTYSEAL,WRT_ID,INS_DT,UPD_DT,SERVER_ADDR,SERVER_YN,SEND_SYS_ID,RECV_SYS_ID,CITYSEAL_USE_YN,CITYSEAL_WIDTH,CITYSEAL_HEIGHT,GROUPWARE_MODULE_TYPE,ONLINE_CERT_USE_YN,APPL_GUBUN,WEEKCHK,INSTODAY ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getNEW_WRT()))
			.append(",")
           .append(toDB(entity.getBAS_STA()))
			.append(",")
           .append(toDB(entity.getAFF()))
			.append(",")
           .append(toDB(entity.getASSI_TRAN()))
			.append(",")
           .append(toDB(entity.getUSEBEF_INSP()))
			.append(",")
           .append(toDB(entity.getCYTYSEAL()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSERVER_ADDR()))
			.append(",")
           .append(toDB(entity.getSERVER_YN()))
			.append(",")
           .append(toDB(entity.getSEND_SYS_ID()))
			.append(",")
           .append(toDB(entity.getRECV_SYS_ID()))
			.append(",")
           .append(toDB(entity.getCITYSEAL_USE_YN()))
			.append(",")
           .append(toDB(entity.getCITYSEAL_WIDTH()))
			.append(",")
           .append(toDB(entity.getCITYSEAL_HEIGHT()))
			.append(",")
           .append(toDB(entity.getGROUPWARE_MODULE_TYPE()))
			.append(",")
           .append(toDB(entity.getONLINE_CERT_USE_YN()))
			.append(",")
           .append(toDB(entity.getAPPL_GUBUN()))
			.append(",")
           .append(toDB(entity.getWEEKCHK()))
			.append(",")
           .append(toDB(entity.getINSTODAY()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : update() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_S_SYSVAR_MASTER  set ")
       
        .append("NEW_WRT = ")
        .append(toDB(entity.getNEW_WRT())).append(",")
        .append("BAS_STA = ")
        .append(toDB(entity.getBAS_STA())).append(",")
        .append("AFF = ")
        .append(toDB(entity.getAFF())).append(",")
        .append("ASSI_TRAN = ")
        .append(toDB(entity.getASSI_TRAN())).append(",")
        .append("USEBEF_INSP = ")
        .append(toDB(entity.getUSEBEF_INSP())).append(",")
        .append("CYTYSEAL = ")
        .append(toDB(entity.getCYTYSEAL())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("SERVER_ADDR = ")
        .append(toDB(entity.getSERVER_ADDR())).append(",")
        .append("SERVER_YN = ")
        .append(toDB(entity.getSERVER_YN())).append(",")
        .append("SEND_SYS_ID = ")
        .append(toDB(entity.getSEND_SYS_ID())).append(",")
        .append("RECV_SYS_ID = ")
        .append(toDB(entity.getRECV_SYS_ID())).append(",")
        .append("CITYSEAL_USE_YN = ")
        .append(toDB(entity.getCITYSEAL_USE_YN())).append(",")
        .append("CITYSEAL_WIDTH = ")
        .append(toDB(entity.getCITYSEAL_WIDTH())).append(",")
        .append("CITYSEAL_HEIGHT = ")
        .append(toDB(entity.getCITYSEAL_HEIGHT())).append(",")
        .append("GROUPWARE_MODULE_TYPE = ")
        .append(toDB(entity.getGROUPWARE_MODULE_TYPE())).append(",")
        .append("ONLINE_CERT_USE_YN = ")
        .append(toDB(entity.getONLINE_CERT_USE_YN())).append(",")
        .append("APPL_GUBUN = ")
        .append(toDB(entity.getAPPL_GUBUN())).append(",")
        .append("WEEKCHK = ")
        .append(toDB(entity.getWEEKCHK())).append(",")
        .append("INSTODAY = ")
        .append(toDB(entity.getINSTODAY()))
        .append(" where  1=1 ");
       
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


    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : update() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_S_SYSVAR_MASTER  set ")
       
        .append("NEW_WRT = ")
        .append(toDB(entity.getNEW_WRT())).append(",")
        .append("BAS_STA = ")
        .append(toDB(entity.getBAS_STA())).append(",")
        .append("AFF = ")
        .append(toDB(entity.getAFF())).append(",")
        .append("ASSI_TRAN = ")
        .append(toDB(entity.getASSI_TRAN())).append(",")
        .append("USEBEF_INSP = ")
        .append(toDB(entity.getUSEBEF_INSP())).append(",")
        .append("CYTYSEAL = ")
        .append(toDB(entity.getCYTYSEAL())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("SERVER_ADDR = ")
        .append(toDB(entity.getSERVER_ADDR())).append(",")
        .append("SERVER_YN = ")
        .append(toDB(entity.getSERVER_YN())).append(",")
        .append("SEND_SYS_ID = ")
        .append(toDB(entity.getSEND_SYS_ID())).append(",")
        .append("RECV_SYS_ID = ")
        .append(toDB(entity.getRECV_SYS_ID())).append(",")
        .append("CITYSEAL_USE_YN = ")
        .append(toDB(entity.getCITYSEAL_USE_YN())).append(",")
        .append("CITYSEAL_WIDTH = ")
        .append(toDB(entity.getCITYSEAL_WIDTH())).append(",")
        .append("CITYSEAL_HEIGHT = ")
        .append(toDB(entity.getCITYSEAL_HEIGHT())).append(",")
        .append("GROUPWARE_MODULE_TYPE = ")
        .append(toDB(entity.getGROUPWARE_MODULE_TYPE())).append(",")
        .append("ONLINE_CERT_USE_YN = ")
        .append(toDB(entity.getONLINE_CERT_USE_YN())).append(",")
        .append("APPL_GUBUN = ")
        .append(toDB(entity.getAPPL_GUBUN())).append(",")
        .append("WEEKCHK = ")
        .append(toDB(entity.getWEEKCHK())).append(",")
        .append("INSTODAY = ")
        .append(toDB(entity.getINSTODAY()))
        .append(" where  1=1 ");
       
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



    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : updateModifiedOnly() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;

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
    sb.append("update PT_S_SYSVAR_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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



    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : updateModifiedOnly() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;


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
    sb.append("update PT_S_SYSVAR_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : updateModifiedOnly() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;

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
    sb.append("update PT_S_SYSVAR_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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

    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : updateModifiedOnly() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;


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
    sb.append("update PT_S_SYSVAR_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : delete() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_S_SYSVAR_MASTER  where  1=1")
      
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

    if((obj instanceof PT_S_SYSVAR_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_SYSVAR_MASTER : delete() ");
    }
    PT_S_SYSVAR_MASTEREntity entity = (PT_S_SYSVAR_MASTEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_S_SYSVAR_MASTER  where  1=1")
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
       ;


   return sb.toString();
  }


}//Class End
