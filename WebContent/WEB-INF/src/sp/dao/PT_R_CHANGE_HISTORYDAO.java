


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_CHANGE_HISTORY
*  테이블 설명 :
*  테이블 PK   :
*               CHANGE_SEQ
*               TMP_REG_NUM
*  테이블 컬럼 :
*               CHANGE_SEQ:VARCHAR2(20):
*               CHANGE_DIV:VARCHAR2(20):
*               RC_REGIST_NUM:VARCHAR2(20):
*               REC_NUM:VARCHAR2(24):
*               REC_ORGAN:VARCHAR2(20):
*               SD_CODE:VARCHAR2(20):
*               REC_PERIOD:VARCHAR2(20):
*               MEMO:VARCHAR2(20):
*               WRT_ID:VARCHAR2(16):
*               UDP_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               TMP_REG_NUM:CHAR(18):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_CHANGE_HISTORYDAO  extends SuperToDB{

  private String default_fields[]={ "CHANGE_SEQ" , "CHANGE_DIV" , "RC_REGIST_NUM" , "REC_NUM" , "REC_ORGAN" , "SD_CODE" , "REC_PERIOD" , "MEMO" , "WRT_ID" , "UDP_DT" , "INS_DT" , "TMP_REG_NUM" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_HISTORY : insert() ");
    }
    PT_R_CHANGE_HISTORYEntity entity = (PT_R_CHANGE_HISTORYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_CHANGE_HISTORY ")
    .append(" ( CHANGE_SEQ,CHANGE_DIV,RC_REGIST_NUM,REC_NUM,REC_ORGAN,SD_CODE,REC_PERIOD,MEMO,WRT_ID,UDP_DT,INS_DT,TMP_REG_NUM ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCHANGE_SEQ()))
			.append(",")
           .append(toDB(entity.getCHANGE_DIV()))
			.append(",")
           .append(toDB(entity.getRC_REGIST_NUM()))
			.append(",")
           .append(toDB(entity.getREC_NUM()))
			.append(",")
           .append(toDB(entity.getREC_ORGAN()))
			.append(",")
           .append(toDB(entity.getSD_CODE()))
			.append(",")
           .append(toDB(entity.getREC_PERIOD()))
			.append(",")
           .append(toDB(entity.getMEMO()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUDP_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getTMP_REG_NUM()))
			
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


    if((obj instanceof PT_R_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_HISTORY : update() ");
    }
    PT_R_CHANGE_HISTORYEntity entity = (PT_R_CHANGE_HISTORYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_CHANGE_HISTORY  set ")
       
        .append("CHANGE_DIV = ")
        .append(toDB(entity.getCHANGE_DIV())).append(",")
        .append("RC_REGIST_NUM = ")
        .append(toDB(entity.getRC_REGIST_NUM())).append(",")
        .append("REC_NUM = ")
        .append(toDB(entity.getREC_NUM())).append(",")
        .append("REC_ORGAN = ")
        .append(toDB(entity.getREC_ORGAN())).append(",")
        .append("SD_CODE = ")
        .append(toDB(entity.getSD_CODE())).append(",")
        .append("REC_PERIOD = ")
        .append(toDB(entity.getREC_PERIOD())).append(",")
        .append("MEMO = ")
        .append(toDB(entity.getMEMO())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UDP_DT = ")
        .append(toDB(entity.getUDP_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append(" where  1=1 ");
       
         sb.append(" and CHANGE_SEQ = ").append( toDB(entity.getCHANGE_SEQ()));
         
         sb.append(" and TMP_REG_NUM = ").append( toDB(entity.getTMP_REG_NUM()));
         

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



    if((obj instanceof PT_R_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_HISTORY : updateModifiedOnly() ");
    }
    PT_R_CHANGE_HISTORYEntity entity = (PT_R_CHANGE_HISTORYEntity)obj;

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
    sb.append("update PT_R_CHANGE_HISTORY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHANGE_SEQ = ").append(toDB(entity.getCHANGE_SEQ()));
     
	  sb.append(" and TMP_REG_NUM = ").append(toDB(entity.getTMP_REG_NUM()));
     

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

    if((obj instanceof PT_R_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_HISTORY : updateModifiedOnly() ");
    }
    PT_R_CHANGE_HISTORYEntity entity = (PT_R_CHANGE_HISTORYEntity)obj;

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
    sb.append("update PT_R_CHANGE_HISTORY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHANGE_SEQ = ").append(toDB(entity.getCHANGE_SEQ()));
     
	  sb.append(" and TMP_REG_NUM = ").append(toDB(entity.getTMP_REG_NUM()));
     

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

    if((obj instanceof PT_R_CHANGE_HISTORYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CHANGE_HISTORY : delete() ");
    }
    PT_R_CHANGE_HISTORYEntity entity = (PT_R_CHANGE_HISTORYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_CHANGE_HISTORY  where  1=1")
      
	  .append(" and CHANGE_SEQ = ").append(toDB(entity.getCHANGE_SEQ()))
      
	  .append(" and TMP_REG_NUM = ").append(toDB(entity.getTMP_REG_NUM()))
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
