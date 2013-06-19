


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_C_RES_FIXING_FLAG
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*  테이블 컬럼 :
*               SEQ:NUMBER(4):
*               ORG_NM:VARCHAR2(52):
*               SIDO_CODE:VARCHAR2(5):
*               FIR_COMMIT_DT:VARCHAR2(24):
*               USE:VARCHAR2(50):
*               REMARK:VARCHAR2(125):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(12):
*               SIGUNGU_CODE:VARCHAR2(5):
*               WATT:VARCHAR2(12):
*               RE_ST_QTT:NUMBER(10):
*               MO_ST_QTT:NUMBER(10):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_C_RES_FIXING_FLAGDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "ORG_NM" , "SIDO_CODE" , "FIR_COMMIT_DT" , "USE" , "REMARK" , "INS_DT" , "UPD_DT" , "WRT_ID" , "SIGUNGU_CODE" , "WATT" , "RE_ST_QTT" , "MO_ST_QTT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_C_RES_FIXING_FLAGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_FIXING_FLAG : insert() ");
    }
    PT_C_RES_FIXING_FLAGEntity entity = (PT_C_RES_FIXING_FLAGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_C_RES_FIXING_FLAG ")
    .append(" ( SEQ,ORG_NM,SIDO_CODE,FIR_COMMIT_DT,USE,REMARK,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE,WATT,RE_ST_QTT,MO_ST_QTT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getORG_NM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getFIR_COMMIT_DT()))
			.append(",")
           .append(toDB(entity.getUSE()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getWATT()))
			.append(",")
           .append(toDB(entity.getRE_ST_QTT()))
			.append(",")
           .append(toDB(entity.getMO_ST_QTT()))
			
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


    if((obj instanceof PT_C_RES_FIXING_FLAGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_FIXING_FLAG : update() ");
    }
    PT_C_RES_FIXING_FLAGEntity entity = (PT_C_RES_FIXING_FLAGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_C_RES_FIXING_FLAG  set ")
       
        .append("ORG_NM = ")
        .append(toDB(entity.getORG_NM())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("FIR_COMMIT_DT = ")
        .append(toDB(entity.getFIR_COMMIT_DT())).append(",")
        .append("USE = ")
        .append(toDB(entity.getUSE())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE())).append(",")
        .append("WATT = ")
        .append(toDB(entity.getWATT())).append(",")
        .append("RE_ST_QTT = ")
        .append(toDB(entity.getRE_ST_QTT())).append(",")
        .append("MO_ST_QTT = ")
        .append(toDB(entity.getMO_ST_QTT()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         

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



    if((obj instanceof PT_C_RES_FIXING_FLAGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_FIXING_FLAG : updateModifiedOnly() ");
    }
    PT_C_RES_FIXING_FLAGEntity entity = (PT_C_RES_FIXING_FLAGEntity)obj;

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
    sb.append("update PT_C_RES_FIXING_FLAG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

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

    if((obj instanceof PT_C_RES_FIXING_FLAGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_FIXING_FLAG : updateModifiedOnly() ");
    }
    PT_C_RES_FIXING_FLAGEntity entity = (PT_C_RES_FIXING_FLAGEntity)obj;

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
    sb.append("update PT_C_RES_FIXING_FLAG  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

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

    if((obj instanceof PT_C_RES_FIXING_FLAGEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_FIXING_FLAG : delete() ");
    }
    PT_C_RES_FIXING_FLAGEntity entity = (PT_C_RES_FIXING_FLAGEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_C_RES_FIXING_FLAG  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
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
