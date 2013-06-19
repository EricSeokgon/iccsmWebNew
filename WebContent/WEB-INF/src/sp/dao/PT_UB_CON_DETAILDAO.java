


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_UB_CON_DETAIL
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SEQ
*               SIDO_CODE
*               SIGUNGU_CODE
*               SRL
*  테이블 컬럼 :
*               DETAIL_CONT:VARCHAR2(100):
*               ITEM_OUT:VARCHAR2(4):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               SRL:NUMBER(4):
*               SEQ:NUMBER(22):
*               SIDO_CODE:VARCHAR2(5):
*               RECV_NUM:VARCHAR2(12):
*               SIGUNGU_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_UB_CON_DETAILDAO  extends SuperToDB{

  private String default_fields[]={ "DETAIL_CONT" , "ITEM_OUT" , "WRT_ID" , "INS_DT" , "UPD_DT" , "SRL" , "SEQ" , "SIDO_CODE" , "RECV_NUM" , "SIGUNGU_CODE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_UB_CON_DETAILEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CON_DETAIL : insert() ");
    }
    PT_UB_CON_DETAILEntity entity = (PT_UB_CON_DETAILEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_CON_DETAIL ")
    .append(" ( DETAIL_CONT,ITEM_OUT,WRT_ID,INS_DT,UPD_DT,SRL,SEQ,SIDO_CODE,RECV_NUM,SIGUNGU_CODE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getDETAIL_CONT()))
			.append(",")
           .append(toDB(entity.getITEM_OUT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSRL()))
			.append(",")
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			
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


    if((obj instanceof PT_UB_CON_DETAILEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CON_DETAIL : update() ");
    }
    PT_UB_CON_DETAILEntity entity = (PT_UB_CON_DETAILEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_CON_DETAIL  set ")
       
        .append("DETAIL_CONT = ")
        .append(toDB(entity.getDETAIL_CONT())).append(",")
        .append("ITEM_OUT = ")
        .append(toDB(entity.getITEM_OUT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append(" where  1=1 ");
       
         sb.append(" and SRL = ").append( toDB(entity.getSRL()));
         
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
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

  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_CON_DETAILEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CON_DETAIL : updateModifiedOnly() ");
    }
    PT_UB_CON_DETAILEntity entity = (PT_UB_CON_DETAILEntity)obj;

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
    sb.append("update PT_UB_CON_DETAIL  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SRL = ").append(toDB(entity.getSRL()));
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
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


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_CON_DETAILEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CON_DETAIL : updateModifiedOnly() ");
    }
    PT_UB_CON_DETAILEntity entity = (PT_UB_CON_DETAILEntity)obj;

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
    sb.append("update PT_UB_CON_DETAIL  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SRL = ").append(toDB(entity.getSRL()));
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
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
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_CON_DETAILEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_CON_DETAIL : delete() ");
    }
    PT_UB_CON_DETAILEntity entity = (PT_UB_CON_DETAILEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_CON_DETAIL  where  1=1")
      
	  .append(" and SRL = ").append(toDB(entity.getSRL()))
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
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



}//Class End
