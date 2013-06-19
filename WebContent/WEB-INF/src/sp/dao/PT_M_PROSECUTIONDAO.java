


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_M_PROSECUTION
*  테이블 설명 :
*  테이블 PK   :
*               TMP_WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_NUM:VARCHAR2(12):
*               PRSEC_DT:VARCHAR2(8):
*               PRSEC_CONT:VARCHAR2(1024):
*               PRSEC_PERSON_ID:VARCHAR2(16):
*               PRSEC_PART:VARCHAR2(100):
*               PRSEC_PART_TELNUM:VARCHAR2(17):
*               PRSEC_PART_OFFI:VARCHAR2(20):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_M_PROSECUTIONDAO  extends SuperToDB{

  private String default_fields[]={ "TMP_WRT_NUM" , "WRT_NUM" , "PRSEC_DT" , "PRSEC_CONT" , "PRSEC_PERSON_ID" , "PRSEC_PART" , "PRSEC_PART_TELNUM" , "PRSEC_PART_OFFI" , "INS_DT" , "UPD_DT" , "WRT_ID" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_M_PROSECUTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_PROSECUTION : insert() ");
    }
    PT_M_PROSECUTIONEntity entity = (PT_M_PROSECUTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_PROSECUTION ")
    .append(" ( TMP_WRT_NUM,WRT_NUM,PRSEC_DT,PRSEC_CONT,PRSEC_PERSON_ID,PRSEC_PART,PRSEC_PART_TELNUM,PRSEC_PART_OFFI,INS_DT,UPD_DT,WRT_ID ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getPRSEC_DT()))
			.append(",")
           .append(toDB(entity.getPRSEC_CONT()))
			.append(",")
           .append(toDB(entity.getPRSEC_PERSON_ID()))
			.append(",")
           .append(toDB(entity.getPRSEC_PART()))
			.append(",")
           .append(toDB(entity.getPRSEC_PART_TELNUM()))
			.append(",")
           .append(toDB(entity.getPRSEC_PART_OFFI()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			
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


    if((obj instanceof PT_M_PROSECUTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_PROSECUTION : update() ");
    }
    PT_M_PROSECUTIONEntity entity = (PT_M_PROSECUTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_PROSECUTION  set ")
       
        .append("PRSEC_DT = ")
        .append(toDB(entity.getPRSEC_DT())).append(",")
        .append("PRSEC_CONT = ")
        .append(toDB(entity.getPRSEC_CONT())).append(",")
        .append("PRSEC_PERSON_ID = ")
        .append(toDB(entity.getPRSEC_PERSON_ID())).append(",")
        .append("PRSEC_PART = ")
        .append(toDB(entity.getPRSEC_PART())).append(",")
        .append("PRSEC_PART_TELNUM = ")
        .append(toDB(entity.getPRSEC_PART_TELNUM())).append(",")
        .append("PRSEC_PART_OFFI = ")
        .append(toDB(entity.getPRSEC_PART_OFFI())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID()))
        .append(" where  1=1 ");
       
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         

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



    if((obj instanceof PT_M_PROSECUTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_PROSECUTION : updateModifiedOnly() ");
    }
    PT_M_PROSECUTIONEntity entity = (PT_M_PROSECUTIONEntity)obj;

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
    sb.append("update PT_M_PROSECUTION  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

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

    if((obj instanceof PT_M_PROSECUTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_PROSECUTION : updateModifiedOnly() ");
    }
    PT_M_PROSECUTIONEntity entity = (PT_M_PROSECUTIONEntity)obj;

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
    sb.append("update PT_M_PROSECUTION  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

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

    if((obj instanceof PT_M_PROSECUTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_PROSECUTION : delete() ");
    }
    PT_M_PROSECUTIONEntity entity = (PT_M_PROSECUTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_PROSECUTION  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
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
