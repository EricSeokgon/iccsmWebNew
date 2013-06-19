


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_DOC_NUM
*  테이블 설명 :
*  테이블 PK   :
*               DOC_CLASS
*               SD_CODE
*  테이블 컬럼 :
*               DOC_CLASS:VARCHAR2(20):
*               SD_CODE:VARCHAR2(3):
*               SGG_CODE:VARCHAR2(4):
*               DOC_NUM1:VARCHAR2(4):
*               DOC_NUM2:VARCHAR2(4):
*               DOC_NUM3:VARCHAR2(4):
*               DOC_NUM4:VARCHAR2(4):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_DOC_NUMDAO  extends SuperToDB{

  private String default_fields[]={ "DOC_CLASS" , "SD_CODE" , "SGG_CODE" , "DOC_NUM1" , "DOC_NUM2" , "DOC_NUM3" , "DOC_NUM4" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_DOC_NUMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_DOC_NUM : insert() ");
    }
    PT_R_DOC_NUMEntity entity = (PT_R_DOC_NUMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_DOC_NUM ")
    .append(" ( DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2,DOC_NUM3,DOC_NUM4 ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getDOC_CLASS()))
			.append(",")
           .append(toDB(entity.getSD_CODE()))
			.append(",")
           .append(toDB(entity.getSGG_CODE()))
			.append(",")
           .append(toDB(entity.getDOC_NUM1()))
			.append(",")
           .append(toDB(entity.getDOC_NUM2()))
			.append(",")
           .append(toDB(entity.getDOC_NUM3()))
			.append(",")
           .append(toDB(entity.getDOC_NUM4()))
			
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


    if((obj instanceof PT_R_DOC_NUMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_DOC_NUM : update() ");
    }
    PT_R_DOC_NUMEntity entity = (PT_R_DOC_NUMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_DOC_NUM  set ")
       
        .append("SGG_CODE = ")
        .append(toDB(entity.getSGG_CODE())).append(",")
        .append("DOC_NUM1 = ")
        .append(toDB(entity.getDOC_NUM1())).append(",")
        .append("DOC_NUM2 = ")
        .append(toDB(entity.getDOC_NUM2())).append(",")
        .append("DOC_NUM3 = ")
        .append(toDB(entity.getDOC_NUM3())).append(",")
        .append("DOC_NUM4 = ")
        .append(toDB(entity.getDOC_NUM4()))
        .append(" where  1=1 ");
       
         sb.append(" and DOC_CLASS = ").append( toDB(entity.getDOC_CLASS()));
         
         sb.append(" and SD_CODE = ").append( toDB(entity.getSD_CODE()));
         

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



    if((obj instanceof PT_R_DOC_NUMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_DOC_NUM : updateModifiedOnly() ");
    }
    PT_R_DOC_NUMEntity entity = (PT_R_DOC_NUMEntity)obj;

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
    sb.append("update PT_R_DOC_NUM  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and DOC_CLASS = ").append(toDB(entity.getDOC_CLASS()));
     
	  sb.append(" and SD_CODE = ").append(toDB(entity.getSD_CODE()));
     

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

    if((obj instanceof PT_R_DOC_NUMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_DOC_NUM : updateModifiedOnly() ");
    }
    PT_R_DOC_NUMEntity entity = (PT_R_DOC_NUMEntity)obj;

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
    sb.append("update PT_R_DOC_NUM  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and DOC_CLASS = ").append(toDB(entity.getDOC_CLASS()));
     
	  sb.append(" and SD_CODE = ").append(toDB(entity.getSD_CODE()));
     

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

    if((obj instanceof PT_R_DOC_NUMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_DOC_NUM : delete() ");
    }
    PT_R_DOC_NUMEntity entity = (PT_R_DOC_NUMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_DOC_NUM  where  1=1")
      
	  .append(" and DOC_CLASS = ").append(toDB(entity.getDOC_CLASS()))
      
	  .append(" and SD_CODE = ").append(toDB(entity.getSD_CODE()))
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
