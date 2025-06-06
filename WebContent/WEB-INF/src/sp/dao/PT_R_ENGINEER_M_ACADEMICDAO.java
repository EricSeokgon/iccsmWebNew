


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_ENGINEER_M_ACADEMIC
*  테이블 설명 :
*  테이블 PK   :
*               CARE_BOOK_ISSUE_NUM
*               SEQ
*  테이블 컬럼 :
*               SEQ:VARCHAR2(12):
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(15):
*               SCHNM:VARCHAR2(50):
*               SUBJ_MAJ:VARCHAR2(50):
*               GRA_YMD:VARCHAR2(12):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               WRT_DT:VARCHAR2(24):
*               ETC1:VARCHAR2(20):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_ENGINEER_M_ACADEMICDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "CARE_BOOK_ISSUE_NUM" , "SCHNM" , "SUBJ_MAJ" , "GRA_YMD" , "WRT_ID" , "UPD_DT" , "WRT_DT" , "ETC1" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_ENGINEER_M_ACADEMICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_ACADEMIC : insert() ");
    }
    PT_R_ENGINEER_M_ACADEMICEntity entity = (PT_R_ENGINEER_M_ACADEMICEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_ENGINEER_M_ACADEMIC ")
    .append(" ( SEQ,CARE_BOOK_ISSUE_NUM,SCHNM,SUBJ_MAJ,GRA_YMD,WRT_ID,UPD_DT,WRT_DT,ETC1 ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getCARE_BOOK_ISSUE_NUM()))
			.append(",")
           .append(toDB(entity.getSCHNM()))
			.append(",")
           .append(toDB(entity.getSUBJ_MAJ()))
			.append(",")
           .append(toDB(entity.getGRA_YMD()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_DT()))
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


    if((obj instanceof PT_R_ENGINEER_M_ACADEMICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_ACADEMIC : update() ");
    }
    PT_R_ENGINEER_M_ACADEMICEntity entity = (PT_R_ENGINEER_M_ACADEMICEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ENGINEER_M_ACADEMIC  set ")
       
        .append("SCHNM = ")
        .append(toDB(entity.getSCHNM())).append(",")
        .append("SUBJ_MAJ = ")
        .append(toDB(entity.getSUBJ_MAJ())).append(",")
        .append("GRA_YMD = ")
        .append(toDB(entity.getGRA_YMD())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT())).append(",")
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



    if((obj instanceof PT_R_ENGINEER_M_ACADEMICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_ACADEMIC : updateModifiedOnly() ");
    }
    PT_R_ENGINEER_M_ACADEMICEntity entity = (PT_R_ENGINEER_M_ACADEMICEntity)obj;

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
    sb.append("update PT_R_ENGINEER_M_ACADEMIC  set " )
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

    if((obj instanceof PT_R_ENGINEER_M_ACADEMICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_ACADEMIC : updateModifiedOnly() ");
    }
    PT_R_ENGINEER_M_ACADEMICEntity entity = (PT_R_ENGINEER_M_ACADEMICEntity)obj;

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
    sb.append("update PT_R_ENGINEER_M_ACADEMIC  set " )
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

    if((obj instanceof PT_R_ENGINEER_M_ACADEMICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ENGINEER_M_ACADEMIC : delete() ");
    }
    PT_R_ENGINEER_M_ACADEMICEntity entity = (PT_R_ENGINEER_M_ACADEMICEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_ENGINEER_M_ACADEMIC  where  1=1")
      
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
