


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_MOT_STE
*  테이블 설명 :
*  테이블 PK   :
*               CHGBRE_SEQ
*               TMP_WRT_NUM
*  테이블 컬럼 :
*               CHGBRE_SEQ:NUMBER(4):
*               TMP_WRT_NUM:VARCHAR2(12):
*               DETAILWORK1:VARCHAR2(1):
*               DETAILWORK2:VARCHAR2(1):
*               DETAILWORK3:VARCHAR2(1):
*               DETAILWORK4:VARCHAR2(1):
*               DETAILWORK5:VARCHAR2(1):
*               DETAILWORK6:VARCHAR2(1):
*               DETAILWORK7:VARCHAR2(1):
*               DETAILWORK8:VARCHAR2(1):
*               DETAILWORK9:VARCHAR2(1):
*               DETAILWORK10:VARCHAR2(1):
*               DETAILWORK11:VARCHAR2(1):
*               DETAILWORK12:VARCHAR2(1):
*               DETAILWORK13:VARCHAR2(1):
*               DETAILWORK14:VARCHAR2(1):
*               DETAILWORK15:VARCHAR2(1):
*               DETAILWORK16:VARCHAR2(1):
*               RECV_NUM:VARCHAR2(20):
*               MOT_PROC:VARCHAR2(2):
*               SIDO_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_MOT_STEDAO  extends SuperToDB{

  private String default_fields[]={ "CHGBRE_SEQ" , "TMP_WRT_NUM" , "DETAILWORK1" , "DETAILWORK2" , "DETAILWORK3" , "DETAILWORK4" , "DETAILWORK5" , "DETAILWORK6" , "DETAILWORK7" , "DETAILWORK8" , "DETAILWORK9" , "DETAILWORK10" , "DETAILWORK11" , "DETAILWORK12" , "DETAILWORK13" , "DETAILWORK14" , "DETAILWORK15" , "DETAILWORK16" , "RECV_NUM" , "MOT_PROC" , "SIDO_CODE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : insert() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_MOT_STE ")
    .append(" ( CHGBRE_SEQ,TMP_WRT_NUM,DETAILWORK1,DETAILWORK2,DETAILWORK3,DETAILWORK4,DETAILWORK5,DETAILWORK6,DETAILWORK7,DETAILWORK8,DETAILWORK9,DETAILWORK10,DETAILWORK11,DETAILWORK12,DETAILWORK13,DETAILWORK14,DETAILWORK15,DETAILWORK16,RECV_NUM,MOT_PROC,SIDO_CODE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getDETAILWORK1()))
			.append(",")
           .append(toDB(entity.getDETAILWORK2()))
			.append(",")
           .append(toDB(entity.getDETAILWORK3()))
			.append(",")
           .append(toDB(entity.getDETAILWORK4()))
			.append(",")
           .append(toDB(entity.getDETAILWORK5()))
			.append(",")
           .append(toDB(entity.getDETAILWORK6()))
			.append(",")
           .append(toDB(entity.getDETAILWORK7()))
			.append(",")
           .append(toDB(entity.getDETAILWORK8()))
			.append(",")
           .append(toDB(entity.getDETAILWORK9()))
			.append(",")
           .append(toDB(entity.getDETAILWORK10()))
			.append(",")
           .append(toDB(entity.getDETAILWORK11()))
			.append(",")
           .append(toDB(entity.getDETAILWORK12()))
			.append(",")
           .append(toDB(entity.getDETAILWORK13()))
			.append(",")
           .append(toDB(entity.getDETAILWORK14()))
			.append(",")
           .append(toDB(entity.getDETAILWORK15()))
			.append(",")
           .append(toDB(entity.getDETAILWORK16()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getMOT_PROC()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			
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

    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : insert() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_MOT_STE ")
    .append(" ( CHGBRE_SEQ,TMP_WRT_NUM,DETAILWORK1,DETAILWORK2,DETAILWORK3,DETAILWORK4,DETAILWORK5,DETAILWORK6,DETAILWORK7,DETAILWORK8,DETAILWORK9,DETAILWORK10,DETAILWORK11,DETAILWORK12,DETAILWORK13,DETAILWORK14,DETAILWORK15,DETAILWORK16,RECV_NUM,MOT_PROC,SIDO_CODE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getDETAILWORK1()))
			.append(",")
           .append(toDB(entity.getDETAILWORK2()))
			.append(",")
           .append(toDB(entity.getDETAILWORK3()))
			.append(",")
           .append(toDB(entity.getDETAILWORK4()))
			.append(",")
           .append(toDB(entity.getDETAILWORK5()))
			.append(",")
           .append(toDB(entity.getDETAILWORK6()))
			.append(",")
           .append(toDB(entity.getDETAILWORK7()))
			.append(",")
           .append(toDB(entity.getDETAILWORK8()))
			.append(",")
           .append(toDB(entity.getDETAILWORK9()))
			.append(",")
           .append(toDB(entity.getDETAILWORK10()))
			.append(",")
           .append(toDB(entity.getDETAILWORK11()))
			.append(",")
           .append(toDB(entity.getDETAILWORK12()))
			.append(",")
           .append(toDB(entity.getDETAILWORK13()))
			.append(",")
           .append(toDB(entity.getDETAILWORK14()))
			.append(",")
           .append(toDB(entity.getDETAILWORK15()))
			.append(",")
           .append(toDB(entity.getDETAILWORK16()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getMOT_PROC()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : update() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_MOT_STE  set ")
       
        .append("DETAILWORK1 = ")
        .append(toDB(entity.getDETAILWORK1())).append(",")
        .append("DETAILWORK2 = ")
        .append(toDB(entity.getDETAILWORK2())).append(",")
        .append("DETAILWORK3 = ")
        .append(toDB(entity.getDETAILWORK3())).append(",")
        .append("DETAILWORK4 = ")
        .append(toDB(entity.getDETAILWORK4())).append(",")
        .append("DETAILWORK5 = ")
        .append(toDB(entity.getDETAILWORK5())).append(",")
        .append("DETAILWORK6 = ")
        .append(toDB(entity.getDETAILWORK6())).append(",")
        .append("DETAILWORK7 = ")
        .append(toDB(entity.getDETAILWORK7())).append(",")
        .append("DETAILWORK8 = ")
        .append(toDB(entity.getDETAILWORK8())).append(",")
        .append("DETAILWORK9 = ")
        .append(toDB(entity.getDETAILWORK9())).append(",")
        .append("DETAILWORK10 = ")
        .append(toDB(entity.getDETAILWORK10())).append(",")
        .append("DETAILWORK11 = ")
        .append(toDB(entity.getDETAILWORK11())).append(",")
        .append("DETAILWORK12 = ")
        .append(toDB(entity.getDETAILWORK12())).append(",")
        .append("DETAILWORK13 = ")
        .append(toDB(entity.getDETAILWORK13())).append(",")
        .append("DETAILWORK14 = ")
        .append(toDB(entity.getDETAILWORK14())).append(",")
        .append("DETAILWORK15 = ")
        .append(toDB(entity.getDETAILWORK15())).append(",")
        .append("DETAILWORK16 = ")
        .append(toDB(entity.getDETAILWORK16())).append(",")
        .append("RECV_NUM = ")
        .append(toDB(entity.getRECV_NUM())).append(",")
        .append("MOT_PROC = ")
        .append(toDB(entity.getMOT_PROC())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE()))
        .append(" where  1=1 ");
       
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and MOT_PROC = ").append( toDB(entity.getMOT_PROC()));
         

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


    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : update() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_MOT_STE  set ")
       
        .append("DETAILWORK1 = ")
        .append(toDB(entity.getDETAILWORK1())).append(",")
        .append("DETAILWORK2 = ")
        .append(toDB(entity.getDETAILWORK2())).append(",")
        .append("DETAILWORK3 = ")
        .append(toDB(entity.getDETAILWORK3())).append(",")
        .append("DETAILWORK4 = ")
        .append(toDB(entity.getDETAILWORK4())).append(",")
        .append("DETAILWORK5 = ")
        .append(toDB(entity.getDETAILWORK5())).append(",")
        .append("DETAILWORK6 = ")
        .append(toDB(entity.getDETAILWORK6())).append(",")
        .append("DETAILWORK7 = ")
        .append(toDB(entity.getDETAILWORK7())).append(",")
        .append("DETAILWORK8 = ")
        .append(toDB(entity.getDETAILWORK8())).append(",")
        .append("DETAILWORK9 = ")
        .append(toDB(entity.getDETAILWORK9())).append(",")
        .append("DETAILWORK10 = ")
        .append(toDB(entity.getDETAILWORK10())).append(",")
        .append("DETAILWORK11 = ")
        .append(toDB(entity.getDETAILWORK11())).append(",")
        .append("DETAILWORK12 = ")
        .append(toDB(entity.getDETAILWORK12())).append(",")
        .append("DETAILWORK13 = ")
        .append(toDB(entity.getDETAILWORK13())).append(",")
        .append("DETAILWORK14 = ")
        .append(toDB(entity.getDETAILWORK14())).append(",")
        .append("DETAILWORK15 = ")
        .append(toDB(entity.getDETAILWORK15())).append(",")
        .append("DETAILWORK16 = ")
        .append(toDB(entity.getDETAILWORK16())).append(",")
        .append("RECV_NUM = ")
        .append(toDB(entity.getRECV_NUM())).append(",")
        .append("MOT_PROC = ")
        .append(toDB(entity.getMOT_PROC())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE()))
        .append(" where  1=1 ");
       
         sb.append(" and CHGBRE_SEQ = ").append( toDB(entity.getCHGBRE_SEQ()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : updateModifiedOnly() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;

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
    sb.append("update PT_R_MOT_STE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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




  public String updateModifiedOnlySql(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : updateModifiedOnly() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;


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
    sb.append("update PT_R_MOT_STE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : updateModifiedOnly() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;

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
    sb.append("update PT_R_MOT_STE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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
  
  
   public String updateExcludeOnlySql(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : updateModifiedOnly() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;


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
    sb.append("update PT_R_MOT_STE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : delete() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_MOT_STE  where  1=1")
      
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

  public String deleteSql(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_MOT_STEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_MOT_STE : delete() ");
    }
    PT_R_MOT_STEEntity entity = (PT_R_MOT_STEEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_MOT_STE  where  1=1")
      
	  .append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
