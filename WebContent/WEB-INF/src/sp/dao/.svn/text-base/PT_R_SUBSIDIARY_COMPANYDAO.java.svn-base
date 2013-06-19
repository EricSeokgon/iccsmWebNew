


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_SUBSIDIARY_COMPANY
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SEQ
*  테이블 컬럼 :
*               SEQ:NUMBER(4):
*               OTOB_COM_NUM:VARCHAR2(12):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               RECV_NUM:VARCHAR2(12):
*               OTOB_COM_CODE:VARCHAR2(6):
*               SIDO_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_SUBSIDIARY_COMPANYDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "OTOB_COM_NUM" , "WRT_ID" , "UPD_DT" , "INS_DT" , "RECV_NUM" , "OTOB_COM_CODE" , "SIDO_CODE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_SUBSIDIARY_COMPANYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_SUBSIDIARY_COMPANY : insert() ");
    }
    PT_R_SUBSIDIARY_COMPANYEntity entity = (PT_R_SUBSIDIARY_COMPANYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_SUBSIDIARY_COMPANY ")
    .append(" ( SEQ,OTOB_COM_NUM,WRT_ID,UPD_DT,INS_DT,RECV_NUM,OTOB_COM_CODE,SIDO_CODE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getOTOB_COM_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getOTOB_COM_CODE()))
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

  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_SUBSIDIARY_COMPANYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_SUBSIDIARY_COMPANY : update() ");
    }
    PT_R_SUBSIDIARY_COMPANYEntity entity = (PT_R_SUBSIDIARY_COMPANYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_SUBSIDIARY_COMPANY  set ")
       
        .append("OTOB_COM_NUM = ")
        .append(toDB(entity.getOTOB_COM_NUM())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("OTOB_COM_CODE = ")
        .append(toDB(entity.getOTOB_COM_CODE())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         

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



    if((obj instanceof PT_R_SUBSIDIARY_COMPANYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_SUBSIDIARY_COMPANY : updateModifiedOnly() ");
    }
    PT_R_SUBSIDIARY_COMPANYEntity entity = (PT_R_SUBSIDIARY_COMPANYEntity)obj;

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
    sb.append("update PT_R_SUBSIDIARY_COMPANY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     

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

    if((obj instanceof PT_R_SUBSIDIARY_COMPANYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_SUBSIDIARY_COMPANY : updateModifiedOnly() ");
    }
    PT_R_SUBSIDIARY_COMPANYEntity entity = (PT_R_SUBSIDIARY_COMPANYEntity)obj;

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
    sb.append("update PT_R_SUBSIDIARY_COMPANY  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     

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

    if((obj instanceof PT_R_SUBSIDIARY_COMPANYEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_SUBSIDIARY_COMPANY : delete() ");
    }
    PT_R_SUBSIDIARY_COMPANYEntity entity = (PT_R_SUBSIDIARY_COMPANYEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_SUBSIDIARY_COMPANY  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
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
