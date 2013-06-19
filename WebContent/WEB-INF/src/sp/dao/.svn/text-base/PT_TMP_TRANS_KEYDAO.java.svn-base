


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_TMP_TRANS_KEY
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*  테이블 컬럼 :
*               WORK_CLASS_CODE:VARCHAR2(18):
*               KEY1:VARCHAR2(20):
*               KEY2:VARCHAR2(20):
*               KEY3:VARCHAR2(20):
*               KEY4:VARCHAR2(20):
*               KEY5:VARCHAR2(20):
*               CUD_FLAG:VARCHAR2(1):
*               SEQ:VARCHAR2(18):
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_TMP_TRANS_KEYDAO  extends SuperToDB{

  private String default_fields[]={ "WORK_CLASS_CODE" , "KEY1" , "KEY2" , "KEY3" , "KEY4" , "KEY5" , "CUD_FLAG" , "SEQ" , "INS_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : insert() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_TMP_TRANS_KEY ")
    .append(" ( WORK_CLASS_CODE,KEY1,KEY2,KEY3,KEY4,KEY5,CUD_FLAG,SEQ,INS_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getWORK_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getKEY1()))
			.append(",")
           .append(toDB(entity.getKEY2()))
			.append(",")
           .append(toDB(entity.getKEY3()))
			.append(",")
           .append(toDB(entity.getKEY4()))
			.append(",")
           .append(toDB(entity.getKEY5()))
			.append(",")
           .append(toDB(entity.getCUD_FLAG()))
			.append(",")
           .append(toDB(entity.getSEQ()))
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

    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : insert() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_TMP_TRANS_KEY ")
    .append(" ( WORK_CLASS_CODE,KEY1,KEY2,KEY3,KEY4,KEY5,CUD_FLAG,SEQ,INS_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getWORK_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getKEY1()))
			.append(",")
           .append(toDB(entity.getKEY2()))
			.append(",")
           .append(toDB(entity.getKEY3()))
			.append(",")
           .append(toDB(entity.getKEY4()))
			.append(",")
           .append(toDB(entity.getKEY5()))
			.append(",")
           .append(toDB(entity.getCUD_FLAG()))
			.append(",")
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : update() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_TMP_TRANS_KEY  set ")
       
        .append("WORK_CLASS_CODE = ")
        .append(toDB(entity.getWORK_CLASS_CODE())).append(",")
        .append("KEY1 = ")
        .append(toDB(entity.getKEY1())).append(",")
        .append("KEY2 = ")
        .append(toDB(entity.getKEY2())).append(",")
        .append("KEY3 = ")
        .append(toDB(entity.getKEY3())).append(",")
        .append("KEY4 = ")
        .append(toDB(entity.getKEY4())).append(",")
        .append("KEY5 = ")
        .append(toDB(entity.getKEY5())).append(",")
        .append("CUD_FLAG = ")
        .append(toDB(entity.getCUD_FLAG())).append(",")
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


    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : update() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_TMP_TRANS_KEY  set ")
       
        .append("WORK_CLASS_CODE = ")
        .append(toDB(entity.getWORK_CLASS_CODE())).append(",")
        .append("KEY1 = ")
        .append(toDB(entity.getKEY1())).append(",")
        .append("KEY2 = ")
        .append(toDB(entity.getKEY2())).append(",")
        .append("KEY3 = ")
        .append(toDB(entity.getKEY3())).append(",")
        .append("KEY4 = ")
        .append(toDB(entity.getKEY4())).append(",")
        .append("KEY5 = ")
        .append(toDB(entity.getKEY5())).append(",")
        .append("CUD_FLAG = ")
        .append(toDB(entity.getCUD_FLAG())).append(",")
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
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : updateModifiedOnly() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;

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
    sb.append("update PT_TMP_TRANS_KEY  set " )
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



    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : updateModifiedOnly() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;


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
    sb.append("update PT_TMP_TRANS_KEY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : updateModifiedOnly() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;

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
    sb.append("update PT_TMP_TRANS_KEY  set " )
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

    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : updateModifiedOnly() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;


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
    sb.append("update PT_TMP_TRANS_KEY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : delete() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_TMP_TRANS_KEY  where  1=1")
      
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

    if((obj instanceof PT_TMP_TRANS_KEYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_TMP_TRANS_KEY : delete() ");
    }
    PT_TMP_TRANS_KEYEntity entity = (PT_TMP_TRANS_KEYEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_TMP_TRANS_KEY  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
       ;


   return sb.toString();
  }


}//Class End
