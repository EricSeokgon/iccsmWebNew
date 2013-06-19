


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_C_RES_ONLY_LINE
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*  테이블 컬럼 :
*               SEQ:NUMBER(4):
*               ORG_NM:VARCHAR2(52):
*               SIDO_CODE:VARCHAR2(5):
*               ITEM_NM:VARCHAR2(100):
*               LINE_QTT:NUMBER(20):
*               JOINT_CIR:VARCHAR2(50):
*               JOINT_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(12):
*               SIGUNGU_CODE:VARCHAR2(5):
*               JOINT_ORG_NUM:VARCHAR2(20):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_C_RES_ONLY_LINEDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "ORG_NM" , "SIDO_CODE" , "ITEM_NM" , "LINE_QTT" , "JOINT_CIR" , "JOINT_DT" , "INS_DT" , "UPD_DT" , "WRT_ID" , "SIGUNGU_CODE" , "JOINT_ORG_NUM" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_C_RES_ONLY_LINEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_ONLY_LINE : insert() ");
    }
    PT_C_RES_ONLY_LINEEntity entity = (PT_C_RES_ONLY_LINEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_C_RES_ONLY_LINE ")
    .append(" ( SEQ,ORG_NM,SIDO_CODE,ITEM_NM,LINE_QTT,JOINT_CIR,JOINT_DT,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE,JOINT_ORG_NUM ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getORG_NM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getITEM_NM()))
			.append(",")
           .append(toDB(entity.getLINE_QTT()))
			.append(",")
           .append(toDB(entity.getJOINT_CIR()))
			.append(",")
           .append(toDB(entity.getJOINT_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getJOINT_ORG_NUM()))
			
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


    if((obj instanceof PT_C_RES_ONLY_LINEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_ONLY_LINE : update() ");
    }
    PT_C_RES_ONLY_LINEEntity entity = (PT_C_RES_ONLY_LINEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_C_RES_ONLY_LINE  set ")
       
        .append("ORG_NM = ")
        .append(toDB(entity.getORG_NM())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("ITEM_NM = ")
        .append(toDB(entity.getITEM_NM())).append(",")
        .append("LINE_QTT = ")
        .append(toDB(entity.getLINE_QTT())).append(",")
        .append("JOINT_CIR = ")
        .append(toDB(entity.getJOINT_CIR())).append(",")
        .append("JOINT_DT = ")
        .append(toDB(entity.getJOINT_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE())).append(",")
        .append("JOINT_ORG_NUM = ")
        .append(toDB(entity.getJOINT_ORG_NUM()))
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



    if((obj instanceof PT_C_RES_ONLY_LINEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_ONLY_LINE : updateModifiedOnly() ");
    }
    PT_C_RES_ONLY_LINEEntity entity = (PT_C_RES_ONLY_LINEEntity)obj;

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
    sb.append("update PT_C_RES_ONLY_LINE  set " )
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

    if((obj instanceof PT_C_RES_ONLY_LINEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_ONLY_LINE : updateModifiedOnly() ");
    }
    PT_C_RES_ONLY_LINEEntity entity = (PT_C_RES_ONLY_LINEEntity)obj;

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
    sb.append("update PT_C_RES_ONLY_LINE  set " )
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

    if((obj instanceof PT_C_RES_ONLY_LINEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_ONLY_LINE : delete() ");
    }
    PT_C_RES_ONLY_LINEEntity entity = (PT_C_RES_ONLY_LINEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_C_RES_ONLY_LINE  where  1=1")
      
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
