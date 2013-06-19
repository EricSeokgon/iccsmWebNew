


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_CHANGE_STATEMENT
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SIDO_CODE
*  테이블 컬럼 :
*               RECV_NUM:VARCHAR2(12):
*               SIDO_CODE:VARCHAR2(4):
*               RECV_DT:VARCHAR2(8):
*               RECV_TIME:VARCHAR2(4):
*               PROC_LIM:VARCHAR2(8):
*               TMP_WRT_NUM:VARCHAR2(12):
*               COV_DT:VARCHAR2(8):
*               COM_NUM:VARCHAR2(13):
*               DEFI_STE:VARCHAR2(1):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_CHANGE_STATEMENTDAO  extends SuperToDB{

  private String default_fields[]={ "RECV_NUM" , "SIDO_CODE" , "RECV_DT" , "RECV_TIME" , "PROC_LIM" , "TMP_WRT_NUM" , "COV_DT" , "COM_NUM" , "DEFI_STE" , "WRT_ID" , "INS_DT" , "UPD_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : insert() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_CHANGE_STATEMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,RECV_DT,RECV_TIME,PROC_LIM,TMP_WRT_NUM,COV_DT,COM_NUM,DEFI_STE,WRT_ID,INS_DT,UPD_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getRECV_TIME()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getCOV_DT()))
			.append(",")
           .append(toDB(entity.getCOM_NUM()))
			.append(",")
           .append(toDB(entity.getDEFI_STE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			
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

    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : insert() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_CHANGE_STATEMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,RECV_DT,RECV_TIME,PROC_LIM,TMP_WRT_NUM,COV_DT,COM_NUM,DEFI_STE,WRT_ID,INS_DT,UPD_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getRECV_TIME()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getCOV_DT()))
			.append(",")
           .append(toDB(entity.getCOM_NUM()))
			.append(",")
           .append(toDB(entity.getDEFI_STE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : update() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_CHANGE_STATEMENT  set ")
       
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("RECV_TIME = ")
        .append(toDB(entity.getRECV_TIME())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("TMP_WRT_NUM = ")
        .append(toDB(entity.getTMP_WRT_NUM())).append(",")
        .append("COV_DT = ")
        .append(toDB(entity.getCOV_DT())).append(",")
        .append("COM_NUM = ")
        .append(toDB(entity.getCOM_NUM())).append(",")
        .append("DEFI_STE = ")
        .append(toDB(entity.getDEFI_STE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         

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


    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : update() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_CHANGE_STATEMENT  set ")
       
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("RECV_TIME = ")
        .append(toDB(entity.getRECV_TIME())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("TMP_WRT_NUM = ")
        .append(toDB(entity.getTMP_WRT_NUM())).append(",")
        .append("COV_DT = ")
        .append(toDB(entity.getCOV_DT())).append(",")
        .append("COM_NUM = ")
        .append(toDB(entity.getCOM_NUM())).append(",")
        .append("DEFI_STE = ")
        .append(toDB(entity.getDEFI_STE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;

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
    sb.append("update PT_R_CHANGE_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

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



    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;


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
    sb.append("update PT_R_CHANGE_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;

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
    sb.append("update PT_R_CHANGE_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

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

    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;


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
    sb.append("update PT_R_CHANGE_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : delete() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_CHANGE_STATEMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
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

    if((obj instanceof PT_R_CHANGE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_STATEMENT : delete() ");
    }
    PT_R_CHANGE_STATEMENTEntity entity = (PT_R_CHANGE_STATEMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_CHANGE_STATEMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
       ;


   return sb.toString();
  }


}//Class End
