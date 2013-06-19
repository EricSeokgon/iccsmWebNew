


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_ENGINEER_M_CAREER
*  테이블 설명 :
*  테이블 PK   :
*               CARE_BOOK_ISSUE_NUM
*               SEQ
*  테이블 컬럼 :
*               SEQ:VARCHAR2(12):
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):
*               POW:VARCHAR2(10):
*               CARETERM_START_DT:VARCHAR2(8):
*               CARETERM_END_DT:VARCHAR2(8):
*               OFF_WORK:VARCHAR2(20):
*               EXCH_CARE:VARCHAR2(6):
*               CARE_TOT:VARCHAR2(6):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               ETC1:VARCHAR2(30):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_ENGINEER_M_CAREERDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "CARE_BOOK_ISSUE_NUM" , "POW" , "CARETERM_START_DT" , "CARETERM_END_DT" , "OFF_WORK" , "EXCH_CARE" , "CARE_TOT" , "WRT_ID" , "UPD_DT" , "INS_DT" , "ETC1" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_ENGINEER_M_CAREEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_CAREER : insert() ");
    }
    PT_R_ENGINEER_M_CAREEREntity entity = (PT_R_ENGINEER_M_CAREEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_ENGINEER_M_CAREER ")
    .append(" ( SEQ,CARE_BOOK_ISSUE_NUM,POW,CARETERM_START_DT,CARETERM_END_DT,OFF_WORK,EXCH_CARE,CARE_TOT,WRT_ID,UPD_DT,INS_DT,ETC1 ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getCARE_BOOK_ISSUE_NUM()))
			.append(",")
           .append(toDB(entity.getPOW()))
			.append(",")
           .append(toDB(entity.getCARETERM_START_DT()))
			.append(",")
           .append(toDB(entity.getCARETERM_END_DT()))
			.append(",")
           .append(toDB(entity.getOFF_WORK()))
			.append(",")
           .append(toDB(entity.getEXCH_CARE()))
			.append(",")
           .append(toDB(entity.getCARE_TOT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getETC1()))
			
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


    if((obj instanceof PT_R_ENGINEER_M_CAREEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_CAREER : update() ");
    }
    PT_R_ENGINEER_M_CAREEREntity entity = (PT_R_ENGINEER_M_CAREEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ENGINEER_M_CAREER  set ")
       
        .append("POW = ")
        .append(toDB(entity.getPOW())).append(",")
        .append("CARETERM_START_DT = ")
        .append(toDB(entity.getCARETERM_START_DT())).append(",")
        .append("CARETERM_END_DT = ")
        .append(toDB(entity.getCARETERM_END_DT())).append(",")
        .append("OFF_WORK = ")
        .append(toDB(entity.getOFF_WORK())).append(",")
        .append("EXCH_CARE = ")
        .append(toDB(entity.getEXCH_CARE())).append(",")
        .append("CARE_TOT = ")
        .append(toDB(entity.getCARE_TOT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("ETC1 = ")
        .append(toDB(entity.getETC1()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and CARE_BOOK_ISSUE_NUM = ").append( toDB(entity.getCARE_BOOK_ISSUE_NUM()));
         

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



    if((obj instanceof PT_R_ENGINEER_M_CAREEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_CAREER : updateModifiedOnly() ");
    }
    PT_R_ENGINEER_M_CAREEREntity entity = (PT_R_ENGINEER_M_CAREEREntity)obj;

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
    sb.append("update PT_R_ENGINEER_M_CAREER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and CARE_BOOK_ISSUE_NUM = ").append(toDB(entity.getCARE_BOOK_ISSUE_NUM()));
     

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

    if((obj instanceof PT_R_ENGINEER_M_CAREEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_CAREER : updateModifiedOnly() ");
    }
    PT_R_ENGINEER_M_CAREEREntity entity = (PT_R_ENGINEER_M_CAREEREntity)obj;

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
    sb.append("update PT_R_ENGINEER_M_CAREER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and CARE_BOOK_ISSUE_NUM = ").append(toDB(entity.getCARE_BOOK_ISSUE_NUM()));
     

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

    if((obj instanceof PT_R_ENGINEER_M_CAREEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_CAREER : delete() ");
    }
    PT_R_ENGINEER_M_CAREEREntity entity = (PT_R_ENGINEER_M_CAREEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_ENGINEER_M_CAREER  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and CARE_BOOK_ISSUE_NUM = ").append(toDB(entity.getCARE_BOOK_ISSUE_NUM()))
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
