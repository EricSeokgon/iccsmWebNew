


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_REFUSAL_REASON
*  테이블 설명 :
*  테이블 PK   :
*               CHGBRE_SEQ
*               SEQ
*               TMP_WRT_NUM
*  테이블 컬럼 :
*               SEQ:VARCHAR2(3):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               REFS_ITEM:VARCHAR2(6):
*               REFS_CAUSE:VARCHAR2(256):
*               CHGBRE_SEQ:NUMBER(4):
*               TMP_WRT_NUM:VARCHAR2(12):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_REFUSAL_REASONDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "WRT_ID" , "UPD_DT" , "INS_DT" , "REFS_ITEM" , "REFS_CAUSE" , "CHGBRE_SEQ" , "TMP_WRT_NUM" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_REFUSAL_REASONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFUSAL_REASON : insert() ");
    }
    PT_R_REFUSAL_REASONEntity entity = (PT_R_REFUSAL_REASONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_REFUSAL_REASON ")
    .append(" ( SEQ,WRT_ID,UPD_DT,INS_DT,REFS_ITEM,REFS_CAUSE,CHGBRE_SEQ,TMP_WRT_NUM ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getREFS_ITEM()))
			.append(",")
           .append(toDB(entity.getREFS_CAUSE()))
			.append(",")
           .append(toDB(entity.getCHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			
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


    if((obj instanceof PT_R_REFUSAL_REASONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFUSAL_REASON : update() ");
    }
    PT_R_REFUSAL_REASONEntity entity = (PT_R_REFUSAL_REASONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_REFUSAL_REASON  set ")
       
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("REFS_ITEM = ")
        .append(toDB(entity.getREFS_ITEM())).append(",")
        .append("REFS_CAUSE = ")
        .append(toDB(entity.getREFS_CAUSE())).append(",")
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and CHGBRE_SEQ = ").append( toDB(entity.getCHGBRE_SEQ()));
         
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



    if((obj instanceof PT_R_REFUSAL_REASONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFUSAL_REASON : updateModifiedOnly() ");
    }
    PT_R_REFUSAL_REASONEntity entity = (PT_R_REFUSAL_REASONEntity)obj;

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
    sb.append("update PT_R_REFUSAL_REASON  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
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

    if((obj instanceof PT_R_REFUSAL_REASONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFUSAL_REASON : updateModifiedOnly() ");
    }
    PT_R_REFUSAL_REASONEntity entity = (PT_R_REFUSAL_REASONEntity)obj;

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
    sb.append("update PT_R_REFUSAL_REASON  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
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

    if((obj instanceof PT_R_REFUSAL_REASONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFUSAL_REASON : delete() ");
    }
    PT_R_REFUSAL_REASONEntity entity = (PT_R_REFUSAL_REASONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_REFUSAL_REASON  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()))
      
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
