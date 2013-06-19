


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_WORK_CAPABILLITY
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*               TMP_REG_NUM
*  테이블 컬럼 :
*               SEQ:NUMBER(11):
*               RC_REGIST_NUM:VARCHAR2(20):
*               ASSESSMENT_DATE:VARCHAR2(20):
*               ASSESSMENT_MONEY:VARCHAR2(20):
*               ASSESSMENT_APPL_DATE:VARCHAR2(20):
*               CONFIRM:VARCHAR2(20):
*               TMP_REG_NUM:CHAR(18):
*               WRT_ID:VARCHAR2(16):
*               UDP_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_WORK_CAPABILLITYDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "RC_REGIST_NUM" , "ASSESSMENT_DATE" , "ASSESSMENT_MONEY" , "ASSESSMENT_APPL_DATE" , "CONFIRM" , "TMP_REG_NUM" , "WRT_ID" , "UDP_DT" , "INS_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_WORK_CAPABILLITYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILLITY : insert() ");
    }
    PT_R_WORK_CAPABILLITYEntity entity = (PT_R_WORK_CAPABILLITYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_WORK_CAPABILLITY ")
    .append(" ( SEQ,RC_REGIST_NUM,ASSESSMENT_DATE,ASSESSMENT_MONEY,ASSESSMENT_APPL_DATE,CONFIRM,TMP_REG_NUM,WRT_ID,UDP_DT,INS_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getRC_REGIST_NUM()))
			.append(",")
           .append(toDB(entity.getASSESSMENT_DATE()))
			.append(",")
           .append(toDB(entity.getASSESSMENT_MONEY()))
			.append(",")
           .append(toDB(entity.getASSESSMENT_APPL_DATE()))
			.append(",")
           .append(toDB(entity.getCONFIRM()))
			.append(",")
           .append(toDB(entity.getTMP_REG_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUDP_DT()))
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


    if((obj instanceof PT_R_WORK_CAPABILLITYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILLITY : update() ");
    }
    PT_R_WORK_CAPABILLITYEntity entity = (PT_R_WORK_CAPABILLITYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_WORK_CAPABILLITY  set ")
       
        .append("RC_REGIST_NUM = ")
        .append(toDB(entity.getRC_REGIST_NUM())).append(",")
        .append("ASSESSMENT_DATE = ")
        .append(toDB(entity.getASSESSMENT_DATE())).append(",")
        .append("ASSESSMENT_MONEY = ")
        .append(toDB(entity.getASSESSMENT_MONEY())).append(",")
        .append("ASSESSMENT_APPL_DATE = ")
        .append(toDB(entity.getASSESSMENT_APPL_DATE())).append(",")
        .append("CONFIRM = ")
        .append(toDB(entity.getCONFIRM())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UDP_DT = ")
        .append(toDB(entity.getUDP_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
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



    if((obj instanceof PT_R_WORK_CAPABILLITYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILLITY : updateModifiedOnly() ");
    }
    PT_R_WORK_CAPABILLITYEntity entity = (PT_R_WORK_CAPABILLITYEntity)obj;

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
    sb.append("update PT_R_WORK_CAPABILLITY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
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

    if((obj instanceof PT_R_WORK_CAPABILLITYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILLITY : updateModifiedOnly() ");
    }
    PT_R_WORK_CAPABILLITYEntity entity = (PT_R_WORK_CAPABILLITYEntity)obj;

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
    sb.append("update PT_R_WORK_CAPABILLITY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
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

    if((obj instanceof PT_R_WORK_CAPABILLITYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILLITY : delete() ");
    }
    PT_R_WORK_CAPABILLITYEntity entity = (PT_R_WORK_CAPABILLITYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_WORK_CAPABILLITY  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
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
