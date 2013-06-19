


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_REFER
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*               TMP_REG_NUM
*  테이블 컬럼 :
*               SD_CODE:VARCHAR2(4):
*               SEQ:NUMBER(11):
*               SGG_CODE:VARCHAR2(4):
*               GUBUN:VARCHAR2(20):
*               WRT_ID:VARCHAR2(16):
*               UDP_DT:VARCHAR2(24):
*               NAME_HANJA:VARCHAR2(20):
*               INS_DT:VARCHAR2(24):
*               SSN1:NUMBER(6):
*               NOTE:VARCHAR2(128):
*               ADDR:VARCHAR2(128):
*               FAMILY_HEAD:VARCHAR2(20):
*               SSN2:NUMBER(7):
*               FAMILY_HEAD_RELATION:VARCHAR2(20):
*               NAME_KOR:VARCHAR2(18):
*               ORIGIN:VARCHAR2(128):
*               TMP_REG_NUM:CHAR(18):
*               ENTER_DATE:VARCHAR2(8):
*               RETIRE_DATE:VARCHAR2(8):
*               REFER_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_REFERDAO  extends SuperToDB{

  private String default_fields[]={ "SD_CODE" , "SEQ" , "SGG_CODE" , "GUBUN" , "WRT_ID" , "UDP_DT" , "NAME_HANJA" , "INS_DT" , "SSN1" , "NOTE" , "ADDR" , "FAMILY_HEAD" , "SSN2" , "FAMILY_HEAD_RELATION" , "NAME_KOR" , "ORIGIN" , "TMP_REG_NUM" , "ENTER_DATE" , "RETIRE_DATE" , "REFER_YN" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_REFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFER : insert() ");
    }
    PT_R_REFEREntity entity = (PT_R_REFEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_REFER ")
    .append(" ( SD_CODE,SEQ,SGG_CODE,GUBUN,WRT_ID,UDP_DT,NAME_HANJA,INS_DT,SSN1,NOTE,ADDR,FAMILY_HEAD,SSN2,FAMILY_HEAD_RELATION,NAME_KOR,ORIGIN,TMP_REG_NUM,ENTER_DATE,RETIRE_DATE,REFER_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSD_CODE()))
			.append(",")
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getSGG_CODE()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUDP_DT()))
			.append(",")
           .append(toDB(entity.getNAME_HANJA()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getSSN1()))
			.append(",")
           .append(toDB(entity.getNOTE()))
			.append(",")
           .append(toDB(entity.getADDR()))
			.append(",")
           .append(toDB(entity.getFAMILY_HEAD()))
			.append(",")
           .append(toDB(entity.getSSN2()))
			.append(",")
           .append(toDB(entity.getFAMILY_HEAD_RELATION()))
			.append(",")
           .append(toDB(entity.getNAME_KOR()))
			.append(",")
           .append(toDB(entity.getORIGIN()))
			.append(",")
           .append(toDB(entity.getTMP_REG_NUM()))
			.append(",")
           .append(toDB(entity.getENTER_DATE()))
			.append(",")
           .append(toDB(entity.getRETIRE_DATE()))
			.append(",")
           .append(toDB(entity.getREFER_YN()))
			
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


    if((obj instanceof PT_R_REFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFER : update() ");
    }
    PT_R_REFEREntity entity = (PT_R_REFEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_REFER  set ")
       
        .append("SD_CODE = ")
        .append(toDB(entity.getSD_CODE())).append(",")
        .append("SGG_CODE = ")
        .append(toDB(entity.getSGG_CODE())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UDP_DT = ")
        .append(toDB(entity.getUDP_DT())).append(",")
        .append("NAME_HANJA = ")
        .append(toDB(entity.getNAME_HANJA())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("SSN1 = ")
        .append(toDB(entity.getSSN1())).append(",")
        .append("NOTE = ")
        .append(toDB(entity.getNOTE())).append(",")
        .append("ADDR = ")
        .append(toDB(entity.getADDR())).append(",")
        .append("FAMILY_HEAD = ")
        .append(toDB(entity.getFAMILY_HEAD())).append(",")
        .append("SSN2 = ")
        .append(toDB(entity.getSSN2())).append(",")
        .append("FAMILY_HEAD_RELATION = ")
        .append(toDB(entity.getFAMILY_HEAD_RELATION())).append(",")
        .append("NAME_KOR = ")
        .append(toDB(entity.getNAME_KOR())).append(",")
        .append("ORIGIN = ")
        .append(toDB(entity.getORIGIN())).append(",")
        .append("ENTER_DATE = ")
        .append(toDB(entity.getENTER_DATE())).append(",")
        .append("RETIRE_DATE = ")
        .append(toDB(entity.getRETIRE_DATE())).append(",")
        .append("REFER_YN = ")
        .append(toDB(entity.getREFER_YN()))
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



    if((obj instanceof PT_R_REFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFER : updateModifiedOnly() ");
    }
    PT_R_REFEREntity entity = (PT_R_REFEREntity)obj;

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
    sb.append("update PT_R_REFER  set " )
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

    if((obj instanceof PT_R_REFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFER : updateModifiedOnly() ");
    }
    PT_R_REFEREntity entity = (PT_R_REFEREntity)obj;

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
    sb.append("update PT_R_REFER  set " )
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

    if((obj instanceof PT_R_REFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFER : delete() ");
    }
    PT_R_REFEREntity entity = (PT_R_REFEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_REFER  where  1=1")
      
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
