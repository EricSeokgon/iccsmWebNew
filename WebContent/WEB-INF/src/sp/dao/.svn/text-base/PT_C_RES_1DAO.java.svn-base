


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_C_RES_1
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :
*               SEQ:VARCHAR2(4):
*               SIDO_NM:VARCHAR2(12):
*               SIDO_CODE:VARCHAR2(4):
*               ITEM_NM:VARCHAR2(50):
*               LINE_NUM:NUMBER(10):
*               LINE_CH_NUM:NUMBER(10):
*               LINE_E1_NUM:NUMBER(10):
*               SET_DT:VARCHAR2(24):
*               EQU_COST:VARCHAR2(12):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               ETC:VARCHAR2(50):
*               SIGUNGU_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_C_RES_1DAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "SIDO_NM" , "SIDO_CODE" , "ITEM_NM" , "LINE_NUM" , "LINE_CH_NUM" , "LINE_E1_NUM" , "SET_DT" , "EQU_COST" , "UPD_DT" , "INS_DT" , "ETC" , "SIGUNGU_CODE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_C_RES_1Entity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_1 : insert() ");
    }
    PT_C_RES_1Entity entity = (PT_C_RES_1Entity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_C_RES_1 ")
    .append(" ( SEQ,SIDO_NM,SIDO_CODE,ITEM_NM,LINE_NUM,LINE_CH_NUM,LINE_E1_NUM,SET_DT,EQU_COST,UPD_DT,INS_DT,ETC,SIGUNGU_CODE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getSIDO_NM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getITEM_NM()))
			.append(",")
           .append(toDB(entity.getLINE_NUM()))
			.append(",")
           .append(toDB(entity.getLINE_CH_NUM()))
			.append(",")
           .append(toDB(entity.getLINE_E1_NUM()))
			.append(",")
           .append(toDB(entity.getSET_DT()))
			.append(",")
           .append(toDB(entity.getEQU_COST()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getETC()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			
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


    if((obj instanceof PT_C_RES_1Entity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_1 : update() ");
    }
    PT_C_RES_1Entity entity = (PT_C_RES_1Entity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_C_RES_1  set ")
       
        .append("SEQ = ")
        .append(toDB(entity.getSEQ())).append(",")
        .append("SIDO_NM = ")
        .append(toDB(entity.getSIDO_NM())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("ITEM_NM = ")
        .append(toDB(entity.getITEM_NM())).append(",")
        .append("LINE_NUM = ")
        .append(toDB(entity.getLINE_NUM())).append(",")
        .append("LINE_CH_NUM = ")
        .append(toDB(entity.getLINE_CH_NUM())).append(",")
        .append("LINE_E1_NUM = ")
        .append(toDB(entity.getLINE_E1_NUM())).append(",")
        .append("SET_DT = ")
        .append(toDB(entity.getSET_DT())).append(",")
        .append("EQU_COST = ")
        .append(toDB(entity.getEQU_COST())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("ETC = ")
        .append(toDB(entity.getETC())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE()))
        .append(" where  1=1 ");
       

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



    if((obj instanceof PT_C_RES_1Entity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_1 : updateModifiedOnly() ");
    }
    PT_C_RES_1Entity entity = (PT_C_RES_1Entity)obj;

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
    sb.append("update PT_C_RES_1  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     

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

    if((obj instanceof PT_C_RES_1Entity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_1 : updateModifiedOnly() ");
    }
    PT_C_RES_1Entity entity = (PT_C_RES_1Entity)obj;

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
    sb.append("update PT_C_RES_1  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     

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

    if((obj instanceof PT_C_RES_1Entity) == false){
        throw new  SQLException("DAO 에러(1): PT_C_RES_1 : delete() ");
    }
    PT_C_RES_1Entity entity = (PT_C_RES_1Entity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_C_RES_1  where  1=1")
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
