


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_CREDIT
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*               TMP_WRT_NUM
*  테이블 컬럼 :
*               SEQ:NUMBER(4):
*               TMP_WRT_NUM:VARCHAR2(12):
*               LICTAX_PAYAOM:VARCHAR2(12):
*               LICTAX_PAY_CO_DT:VARCHAR2(8):
*               HOS_CRE_AOM:VARCHAR2(12):
*               HOS_CRE_PAY_CO_DT:VARCHAR2(8):
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


public class PT_R_CREDITDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "TMP_WRT_NUM" , "LICTAX_PAYAOM" , "LICTAX_PAY_CO_DT" , "HOS_CRE_AOM" , "HOS_CRE_PAY_CO_DT" , "WRT_ID" , "UPD_DT" , "WRT_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_CREDITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CREDIT : insert() ");
    }
    PT_R_CREDITEntity entity = (PT_R_CREDITEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_CREDIT ")
    .append(" ( SEQ,TMP_WRT_NUM,LICTAX_PAYAOM,LICTAX_PAY_CO_DT,HOS_CRE_AOM,HOS_CRE_PAY_CO_DT,WRT_ID,UPD_DT,WRT_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getLICTAX_PAYAOM()))
			.append(",")
           .append(toDB(entity.getLICTAX_PAY_CO_DT()))
			.append(",")
           .append(toDB(entity.getHOS_CRE_AOM()))
			.append(",")
           .append(toDB(entity.getHOS_CRE_PAY_CO_DT()))
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


    if((obj instanceof PT_R_CREDITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CREDIT : update() ");
    }
    PT_R_CREDITEntity entity = (PT_R_CREDITEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_CREDIT  set ")
       
        .append("LICTAX_PAYAOM = ")
        .append(toDB(entity.getLICTAX_PAYAOM())).append(",")
        .append("LICTAX_PAY_CO_DT = ")
        .append(toDB(entity.getLICTAX_PAY_CO_DT())).append(",")
        .append("HOS_CRE_AOM = ")
        .append(toDB(entity.getHOS_CRE_AOM())).append(",")
        .append("HOS_CRE_PAY_CO_DT = ")
        .append(toDB(entity.getHOS_CRE_PAY_CO_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         

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



    if((obj instanceof PT_R_CREDITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CREDIT : updateModifiedOnly() ");
    }
    PT_R_CREDITEntity entity = (PT_R_CREDITEntity)obj;

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
    sb.append("update PT_R_CREDIT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
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


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_CREDITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CREDIT : updateModifiedOnly() ");
    }
    PT_R_CREDITEntity entity = (PT_R_CREDITEntity)obj;

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
    sb.append("update PT_R_CREDIT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
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
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_CREDITEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CREDIT : delete() ");
    }
    PT_R_CREDITEntity entity = (PT_R_CREDITEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_CREDIT  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
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



}//Class End
