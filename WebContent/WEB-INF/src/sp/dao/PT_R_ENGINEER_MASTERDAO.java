


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_ENGINEER_MASTER
*  테이블 설명 :
*  테이블 PK   :
*               CARE_BOOK_ISSUE_NUM
*  테이블 컬럼 :
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):
*               ENGINEER_SSN1:VARCHAR2(18):
*               ENGINEER_SSN2:VARCHAR2(21):
*               WRT_NUM:VARCHAR2(12):
*               ENGINEER_GRADE:VARCHAR2(10):
*               ENGINEER_CLASS:VARCHAR2(10):
*               QUAL_ITEM:VARCHAR2(15):
*               NM_KOR:VARCHAR2(20):
*               NM_HAN:VARCHAR2(20):
*               CARE_BOOK_VAL_START_DT:VARCHAR2(24):
*               CARE_BOOK_VAL_END_DT:VARCHAR2(24):
*               EDU_COMP_DT:VARCHAR2(24):
*               POST_NUM:VARCHAR2(7):
*               ADDR:VARCHAR2(20):
*               DETAIL_ADDR:VARCHAR2(20):
*               GROUP_CODE:VARCHAR2(10):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               WRT_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_ENGINEER_MASTERDAO  extends SuperToDB{

  private String default_fields[]={ "CARE_BOOK_ISSUE_NUM" , "ENGINEER_SSN1" , "ENGINEER_SSN2" , "WRT_NUM" , "ENGINEER_GRADE" , "ENGINEER_CLASS" , "QUAL_ITEM" , "NM_KOR" , "NM_HAN" , "CARE_BOOK_VAL_START_DT" , "CARE_BOOK_VAL_END_DT" , "EDU_COMP_DT" , "POST_NUM" , "ADDR" , "DETAIL_ADDR" , "GROUP_CODE" , "WRT_ID" , "UPD_DT" , "WRT_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_ENGINEER_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_MASTER : insert() ");
    }
    PT_R_ENGINEER_MASTEREntity entity = (PT_R_ENGINEER_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_ENGINEER_MASTER ")
    .append(" ( CARE_BOOK_ISSUE_NUM,ENGINEER_SSN1,ENGINEER_SSN2,WRT_NUM,ENGINEER_GRADE,ENGINEER_CLASS,QUAL_ITEM,NM_KOR,NM_HAN,CARE_BOOK_VAL_START_DT,CARE_BOOK_VAL_END_DT,EDU_COMP_DT,POST_NUM,ADDR,DETAIL_ADDR,GROUP_CODE,WRT_ID,UPD_DT,WRT_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCARE_BOOK_ISSUE_NUM()))
			.append(",")
           .append(toDB(entity.getENGINEER_SSN1()))
			.append(",")
           .append(toDB(entity.getENGINEER_SSN2()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getENGINEER_GRADE()))
			.append(",")
           .append(toDB(entity.getENGINEER_CLASS()))
			.append(",")
           .append(toDB(entity.getQUAL_ITEM()))
			.append(",")
           .append(toDB(entity.getNM_KOR()))
			.append(",")
           .append(toDB(entity.getNM_HAN()))
			.append(",")
           .append(toDB(entity.getCARE_BOOK_VAL_START_DT()))
			.append(",")
           .append(toDB(entity.getCARE_BOOK_VAL_END_DT()))
			.append(",")
           .append(toDB(entity.getEDU_COMP_DT()))
			.append(",")
           .append(toDB(entity.getPOST_NUM()))
			.append(",")
           .append(toDB(entity.getADDR()))
			.append(",")
           .append(toDB(entity.getDETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getGROUP_CODE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_DT()))
			
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


    if((obj instanceof PT_R_ENGINEER_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_MASTER : update() ");
    }
    PT_R_ENGINEER_MASTEREntity entity = (PT_R_ENGINEER_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ENGINEER_MASTER  set ")
       
        .append("ENGINEER_SSN1 = ")
        .append(toDB(entity.getENGINEER_SSN1())).append(",")
        .append("ENGINEER_SSN2 = ")
        .append(toDB(entity.getENGINEER_SSN2())).append(",")
        .append("WRT_NUM = ")
        .append(toDB(entity.getWRT_NUM())).append(",")
        .append("ENGINEER_GRADE = ")
        .append(toDB(entity.getENGINEER_GRADE())).append(",")
        .append("ENGINEER_CLASS = ")
        .append(toDB(entity.getENGINEER_CLASS())).append(",")
        .append("QUAL_ITEM = ")
        .append(toDB(entity.getQUAL_ITEM())).append(",")
        .append("NM_KOR = ")
        .append(toDB(entity.getNM_KOR())).append(",")
        .append("NM_HAN = ")
        .append(toDB(entity.getNM_HAN())).append(",")
        .append("CARE_BOOK_VAL_START_DT = ")
        .append(toDB(entity.getCARE_BOOK_VAL_START_DT())).append(",")
        .append("CARE_BOOK_VAL_END_DT = ")
        .append(toDB(entity.getCARE_BOOK_VAL_END_DT())).append(",")
        .append("EDU_COMP_DT = ")
        .append(toDB(entity.getEDU_COMP_DT())).append(",")
        .append("POST_NUM = ")
        .append(toDB(entity.getPOST_NUM())).append(",")
        .append("ADDR = ")
        .append(toDB(entity.getADDR())).append(",")
        .append("DETAIL_ADDR = ")
        .append(toDB(entity.getDETAIL_ADDR())).append(",")
        .append("GROUP_CODE = ")
        .append(toDB(entity.getGROUP_CODE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT()))
        .append(" where  1=1 ");
       
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



    if((obj instanceof PT_R_ENGINEER_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_MASTER : updateModifiedOnly() ");
    }
    PT_R_ENGINEER_MASTEREntity entity = (PT_R_ENGINEER_MASTEREntity)obj;

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
    sb.append("update PT_R_ENGINEER_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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

    if((obj instanceof PT_R_ENGINEER_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_MASTER : updateModifiedOnly() ");
    }
    PT_R_ENGINEER_MASTEREntity entity = (PT_R_ENGINEER_MASTEREntity)obj;

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
    sb.append("update PT_R_ENGINEER_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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

    if((obj instanceof PT_R_ENGINEER_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_MASTER : delete() ");
    }
    PT_R_ENGINEER_MASTEREntity entity = (PT_R_ENGINEER_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_ENGINEER_MASTER  where  1=1")
      
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
