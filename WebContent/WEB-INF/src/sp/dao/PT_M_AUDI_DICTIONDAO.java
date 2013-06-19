


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_M_AUDI_DICTION
*  테이블 설명 :
*  테이블 PK   :
*               TMP_WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_NUM:VARCHAR2(12):
*               AUDI_SUBJ:VARCHAR2(50):
*               AUDI_SUPINT_PART:VARCHAR2(50):
*               AUDI_SUPINT_POS:VARCHAR2(50):
*               AUDI_SUPINT_NM:VARCHAR2(20):
*               AUDI_ATTEND_PERSON_NM:VARCHAR2(20):
*               AUDI_ATTEND_PERSON_PART:VARCHAR2(50):
*               AUDI_PER_ATTE_YN:VARCHAR2(1):
*               AUDI_PER_NATTE_CAUSE:VARCHAR2(512):
*               AUDI_OPN_YN:VARCHAR2(1):
*               AUDI_NOPN_CAUSE:VARCHAR2(512):
*               PER_STAT_CONT:VARCHAR2(1024):
*               PER_PRES_EVID:VARCHAR2(512):
*               EVID_INV_EVID:VARCHAR2(512):
*               ETC:VARCHAR2(256):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               EVID_INV_POIN:VARCHAR2(1024):
*               AUDI_ATTEND_PERSON_POS:VARCHAR2(50):
*               AUDI_EXEC_DT:VARCHAR2(8):
*               AUDI_EXEC_TIME:VARCHAR2(4):
*               AUDI_EXEC_LOC:VARCHAR2(256):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_M_AUDI_DICTIONDAO  extends SuperToDB{

  private String default_fields[]={ "TMP_WRT_NUM" , "WRT_NUM" , "AUDI_SUBJ" , "AUDI_SUPINT_PART" , "AUDI_SUPINT_POS" , "AUDI_SUPINT_NM" , "AUDI_ATTEND_PERSON_NM" , "AUDI_ATTEND_PERSON_PART" , "AUDI_PER_ATTE_YN" , "AUDI_PER_NATTE_CAUSE" , "AUDI_OPN_YN" , "AUDI_NOPN_CAUSE" , "PER_STAT_CONT" , "PER_PRES_EVID" , "EVID_INV_EVID" , "ETC" , "INS_DT" , "UPD_DT" , "WRT_ID" , "EVID_INV_POIN" , "AUDI_ATTEND_PERSON_POS" , "AUDI_EXEC_DT" , "AUDI_EXEC_TIME" , "AUDI_EXEC_LOC" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_M_AUDI_DICTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_DICTION : insert() ");
    }
    PT_M_AUDI_DICTIONEntity entity = (PT_M_AUDI_DICTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_AUDI_DICTION ")
    .append(" ( TMP_WRT_NUM,WRT_NUM,AUDI_SUBJ,AUDI_SUPINT_PART,AUDI_SUPINT_POS,AUDI_SUPINT_NM,AUDI_ATTEND_PERSON_NM,AUDI_ATTEND_PERSON_PART,AUDI_PER_ATTE_YN,AUDI_PER_NATTE_CAUSE,AUDI_OPN_YN,AUDI_NOPN_CAUSE,PER_STAT_CONT,PER_PRES_EVID,EVID_INV_EVID,ETC,INS_DT,UPD_DT,WRT_ID,EVID_INV_POIN,AUDI_ATTEND_PERSON_POS,AUDI_EXEC_DT,AUDI_EXEC_TIME,AUDI_EXEC_LOC ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getAUDI_SUBJ()))
			.append(",")
           .append(toDB(entity.getAUDI_SUPINT_PART()))
			.append(",")
           .append(toDB(entity.getAUDI_SUPINT_POS()))
			.append(",")
           .append(toDB(entity.getAUDI_SUPINT_NM()))
			.append(",")
           .append(toDB(entity.getAUDI_ATTEND_PERSON_NM()))
			.append(",")
           .append(toDB(entity.getAUDI_ATTEND_PERSON_PART()))
			.append(",")
           .append(toDB(entity.getAUDI_PER_ATTE_YN()))
			.append(",")
           .append(toDB(entity.getAUDI_PER_NATTE_CAUSE()))
			.append(",")
           .append(toDB(entity.getAUDI_OPN_YN()))
			.append(",")
           .append(toDB(entity.getAUDI_NOPN_CAUSE()))
			.append(",")
           .append(toDB(entity.getPER_STAT_CONT()))
			.append(",")
           .append(toDB(entity.getPER_PRES_EVID()))
			.append(",")
           .append(toDB(entity.getEVID_INV_EVID()))
			.append(",")
           .append(toDB(entity.getETC()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getEVID_INV_POIN()))
			.append(",")
           .append(toDB(entity.getAUDI_ATTEND_PERSON_POS()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_DT()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_TIME()))
			.append(",")
           .append(toDB(entity.getAUDI_EXEC_LOC()))
			
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


    if((obj instanceof PT_M_AUDI_DICTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_DICTION : update() ");
    }
    PT_M_AUDI_DICTIONEntity entity = (PT_M_AUDI_DICTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_AUDI_DICTION  set ")
       
        .append("AUDI_SUBJ = ")
        .append(toDB(entity.getAUDI_SUBJ())).append(",")
        .append("AUDI_SUPINT_PART = ")
        .append(toDB(entity.getAUDI_SUPINT_PART())).append(",")
        .append("AUDI_SUPINT_POS = ")
        .append(toDB(entity.getAUDI_SUPINT_POS())).append(",")
        .append("AUDI_SUPINT_NM = ")
        .append(toDB(entity.getAUDI_SUPINT_NM())).append(",")
        .append("AUDI_ATTEND_PERSON_NM = ")
        .append(toDB(entity.getAUDI_ATTEND_PERSON_NM())).append(",")
        .append("AUDI_ATTEND_PERSON_PART = ")
        .append(toDB(entity.getAUDI_ATTEND_PERSON_PART())).append(",")
        .append("AUDI_PER_ATTE_YN = ")
        .append(toDB(entity.getAUDI_PER_ATTE_YN())).append(",")
        .append("AUDI_PER_NATTE_CAUSE = ")
        .append(toDB(entity.getAUDI_PER_NATTE_CAUSE())).append(",")
        .append("AUDI_OPN_YN = ")
        .append(toDB(entity.getAUDI_OPN_YN())).append(",")
        .append("AUDI_NOPN_CAUSE = ")
        .append(toDB(entity.getAUDI_NOPN_CAUSE())).append(",")
        .append("PER_STAT_CONT = ")
        .append(toDB(entity.getPER_STAT_CONT())).append(",")
        .append("PER_PRES_EVID = ")
        .append(toDB(entity.getPER_PRES_EVID())).append(",")
        .append("EVID_INV_EVID = ")
        .append(toDB(entity.getEVID_INV_EVID())).append(",")
        .append("ETC = ")
        .append(toDB(entity.getETC())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("EVID_INV_POIN = ")
        .append(toDB(entity.getEVID_INV_POIN())).append(",")
        .append("AUDI_ATTEND_PERSON_POS = ")
        .append(toDB(entity.getAUDI_ATTEND_PERSON_POS())).append(",")
        .append("AUDI_EXEC_DT = ")
        .append(toDB(entity.getAUDI_EXEC_DT())).append(",")
        .append("AUDI_EXEC_TIME = ")
        .append(toDB(entity.getAUDI_EXEC_TIME())).append(",")
        .append("AUDI_EXEC_LOC = ")
        .append(toDB(entity.getAUDI_EXEC_LOC()))
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



    if((obj instanceof PT_M_AUDI_DICTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_DICTION : updateModifiedOnly() ");
    }
    PT_M_AUDI_DICTIONEntity entity = (PT_M_AUDI_DICTIONEntity)obj;

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
    sb.append("update PT_M_AUDI_DICTION  set " )
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

    if((obj instanceof PT_M_AUDI_DICTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_DICTION : updateModifiedOnly() ");
    }
    PT_M_AUDI_DICTIONEntity entity = (PT_M_AUDI_DICTIONEntity)obj;

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
    sb.append("update PT_M_AUDI_DICTION  set " )
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

    if((obj instanceof PT_M_AUDI_DICTIONEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_DICTION : delete() ");
    }
    PT_M_AUDI_DICTIONEntity entity = (PT_M_AUDI_DICTIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_AUDI_DICTION  where  1=1")
      
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
