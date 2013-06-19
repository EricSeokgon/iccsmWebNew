


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_BBS_COM_COMMENT
*  테이블 설명 :
*  테이블 PK   :
*               COMMENT_SEQ
*  테이블 컬럼 :
*               COMMENT_SEQ:NUMBER(10):
*               CT_ID:VARCHAR2(30):
*               BOARD_SEQ:VARCHAR2(10):
*               PASS:VARCHAR2(10):
*               WRT_NM:NVARCHAR2(100):
*               WRT_ID:VARCHAR2(20):
*               COMMET:NVARCHAR2(4000):
*               UPD_DT:VARCHAR2(23):
*               INS_DT:VARCHAR2(23):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_BBS_COM_COMMENTDAO  extends SuperToDB{

  private String default_fields[]={ "COMMENT_SEQ" , "CT_ID" , "BOARD_SEQ" , "PASS" , "WRT_NM" , "WRT_ID" , "COMMET" , "UPD_DT" , "INS_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_BBS_COM_COMMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_COMMENT : insert() ");
    }
    PT_BBS_COM_COMMENTEntity entity = (PT_BBS_COM_COMMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_BBS_COM_COMMENT ")
    .append(" ( COMMENT_SEQ,CT_ID,BOARD_SEQ,PASS,WRT_NM,WRT_ID,COMMET,UPD_DT,INS_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCOMMENT_SEQ()))
			.append(",")
           .append(toDB(entity.getCT_ID()))
			.append(",")
           .append(toDB(entity.getBOARD_SEQ()))
			.append(",")
           .append(toDB(entity.getPASS()))
			.append(",")
           .append(toDB(entity.getWRT_NM()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getCOMMET()))
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

  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_BBS_COM_COMMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_COMMENT : update() ");
    }
    PT_BBS_COM_COMMENTEntity entity = (PT_BBS_COM_COMMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_COM_COMMENT  set ")
       
        .append("CT_ID = ")
        .append(toDB(entity.getCT_ID())).append(",")
        .append("BOARD_SEQ = ")
        .append(toDB(entity.getBOARD_SEQ())).append(",")
        .append("PASS = ")
        .append(toDB(entity.getPASS())).append(",")
        .append("WRT_NM = ")
        .append(toDB(entity.getWRT_NM())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("COMMET = ")
        .append(toDB(entity.getCOMMET())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and COMMENT_SEQ = ").append( toDB(entity.getCOMMENT_SEQ()));
         

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



    if((obj instanceof PT_BBS_COM_COMMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_COMMENT : updateModifiedOnly() ");
    }
    PT_BBS_COM_COMMENTEntity entity = (PT_BBS_COM_COMMENTEntity)obj;

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
    sb.append("update PT_BBS_COM_COMMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and COMMENT_SEQ = ").append(toDB(entity.getCOMMENT_SEQ()));
     

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

    if((obj instanceof PT_BBS_COM_COMMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_COMMENT : updateModifiedOnly() ");
    }
    PT_BBS_COM_COMMENTEntity entity = (PT_BBS_COM_COMMENTEntity)obj;

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
    sb.append("update PT_BBS_COM_COMMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and COMMENT_SEQ = ").append(toDB(entity.getCOMMENT_SEQ()));
     

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

    if((obj instanceof PT_BBS_COM_COMMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_COMMENT : delete() ");
    }
    PT_BBS_COM_COMMENTEntity entity = (PT_BBS_COM_COMMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_BBS_COM_COMMENT  where  1=1")
      
	  .append(" and COMMENT_SEQ = ").append(toDB(entity.getCOMMENT_SEQ()))
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
