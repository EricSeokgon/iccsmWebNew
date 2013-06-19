


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_MODIFY_REQ
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*  테이블 컬럼 :
*               SEQ:VARCHAR2(6):
*               RECV_NAME:VARCHAR2(20):
*               RECV_PART_SIDO:VARCHAR2(20):
*               RECV_PART_SIGUNGU:VARCHAR2(30):
*               RECV_POS:VARCHAR2(20):
*               CONSULT_NAME:VARCHAR2(20):
*               CONSULT_PART_SIDO:VARCHAR2(20):
*               CONSULT_PART_SIGUNGU:VARCHAR2(30):
*               CONSULT_POS:VARCHAR2(20):
*               RECV_DT:VARCHAR2(8):
*               RECV_METHOD:VARCHAR2(30):
*               DEMAND_CONTENTS:VARCHAR2(500):
*               REMARK:VARCHAR2(256):
*               PROC_OUT:VARCHAR2(20):
*               PROC_DT:VARCHAR2(8):
*               PROC_TIME:VARCHAR2(6):
*               RECV_AREA:VARCHAR2(4):
*               CONSULT_AREA:VARCHAR2(4):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_MODIFY_REQDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "RECV_NAME" , "RECV_PART_SIDO" , "RECV_PART_SIGUNGU" , "RECV_POS" , "CONSULT_NAME" , "CONSULT_PART_SIDO" , "CONSULT_PART_SIGUNGU" , "CONSULT_POS" , "RECV_DT" , "RECV_METHOD" , "DEMAND_CONTENTS" , "REMARK" , "PROC_OUT" , "PROC_DT" , "PROC_TIME" , "RECV_AREA" , "CONSULT_AREA" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : insert() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_MODIFY_REQ ")
    .append(" ( SEQ,RECV_NAME,RECV_PART_SIDO,RECV_PART_SIGUNGU,RECV_POS,CONSULT_NAME,CONSULT_PART_SIDO,CONSULT_PART_SIGUNGU,CONSULT_POS,RECV_DT,RECV_METHOD,DEMAND_CONTENTS,REMARK,PROC_OUT,PROC_DT,PROC_TIME,RECV_AREA,CONSULT_AREA ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getRECV_NAME()))
			.append(",")
           .append(toDB(entity.getRECV_PART_SIDO()))
			.append(",")
           .append(toDB(entity.getRECV_PART_SIGUNGU()))
			.append(",")
           .append(toDB(entity.getRECV_POS()))
			.append(",")
           .append(toDB(entity.getCONSULT_NAME()))
			.append(",")
           .append(toDB(entity.getCONSULT_PART_SIDO()))
			.append(",")
           .append(toDB(entity.getCONSULT_PART_SIGUNGU()))
			.append(",")
           .append(toDB(entity.getCONSULT_POS()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getRECV_METHOD()))
			.append(",")
           .append(toDB(entity.getDEMAND_CONTENTS()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getPROC_OUT()))
			.append(",")
           .append(toDB(entity.getPROC_DT()))
			.append(",")
           .append(toDB(entity.getPROC_TIME()))
			.append(",")
           .append(toDB(entity.getRECV_AREA()))
			.append(",")
           .append(toDB(entity.getCONSULT_AREA()))
			
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

    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : insert() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_MODIFY_REQ ")
    .append(" ( SEQ,RECV_NAME,RECV_PART_SIDO,RECV_PART_SIGUNGU,RECV_POS,CONSULT_NAME,CONSULT_PART_SIDO,CONSULT_PART_SIGUNGU,CONSULT_POS,RECV_DT,RECV_METHOD,DEMAND_CONTENTS,REMARK,PROC_OUT,PROC_DT,PROC_TIME,RECV_AREA,CONSULT_AREA ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getRECV_NAME()))
			.append(",")
           .append(toDB(entity.getRECV_PART_SIDO()))
			.append(",")
           .append(toDB(entity.getRECV_PART_SIGUNGU()))
			.append(",")
           .append(toDB(entity.getRECV_POS()))
			.append(",")
           .append(toDB(entity.getCONSULT_NAME()))
			.append(",")
           .append(toDB(entity.getCONSULT_PART_SIDO()))
			.append(",")
           .append(toDB(entity.getCONSULT_PART_SIGUNGU()))
			.append(",")
           .append(toDB(entity.getCONSULT_POS()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getRECV_METHOD()))
			.append(",")
           .append(toDB(entity.getDEMAND_CONTENTS()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getPROC_OUT()))
			.append(",")
           .append(toDB(entity.getPROC_DT()))
			.append(",")
           .append(toDB(entity.getPROC_TIME()))
			.append(",")
           .append(toDB(entity.getRECV_AREA()))
			.append(",")
           .append(toDB(entity.getCONSULT_AREA()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : update() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_MODIFY_REQ  set ")
       
        .append("RECV_NAME = ")
        .append(toDB(entity.getRECV_NAME())).append(",")
        .append("RECV_PART_SIDO = ")
        .append(toDB(entity.getRECV_PART_SIDO())).append(",")
        .append("RECV_PART_SIGUNGU = ")
        .append(toDB(entity.getRECV_PART_SIGUNGU())).append(",")
        .append("RECV_POS = ")
        .append(toDB(entity.getRECV_POS())).append(",")
        .append("CONSULT_NAME = ")
        .append(toDB(entity.getCONSULT_NAME())).append(",")
        .append("CONSULT_PART_SIDO = ")
        .append(toDB(entity.getCONSULT_PART_SIDO())).append(",")
        .append("CONSULT_PART_SIGUNGU = ")
        .append(toDB(entity.getCONSULT_PART_SIGUNGU())).append(",")
        .append("CONSULT_POS = ")
        .append(toDB(entity.getCONSULT_POS())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("RECV_METHOD = ")
        .append(toDB(entity.getRECV_METHOD())).append(",")
        .append("DEMAND_CONTENTS = ")
        .append(toDB(entity.getDEMAND_CONTENTS())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("PROC_OUT = ")
        .append(toDB(entity.getPROC_OUT())).append(",")
        .append("PROC_DT = ")
        .append(toDB(entity.getPROC_DT())).append(",")
        .append("PROC_TIME = ")
        .append(toDB(entity.getPROC_TIME())).append(",")
        .append("RECV_AREA = ")
        .append(toDB(entity.getRECV_AREA())).append(",")
        .append("CONSULT_AREA = ")
        .append(toDB(entity.getCONSULT_AREA()))
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


  public String  updateSql( ValueObject obj) throws SQLException{


    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : update() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_MODIFY_REQ  set ")
       
        .append("RECV_NAME = ")
        .append(toDB(entity.getRECV_NAME())).append(",")
        .append("RECV_PART_SIDO = ")
        .append(toDB(entity.getRECV_PART_SIDO())).append(",")
        .append("RECV_PART_SIGUNGU = ")
        .append(toDB(entity.getRECV_PART_SIGUNGU())).append(",")
        .append("RECV_POS = ")
        .append(toDB(entity.getRECV_POS())).append(",")
        .append("CONSULT_NAME = ")
        .append(toDB(entity.getCONSULT_NAME())).append(",")
        .append("CONSULT_PART_SIDO = ")
        .append(toDB(entity.getCONSULT_PART_SIDO())).append(",")
        .append("CONSULT_PART_SIGUNGU = ")
        .append(toDB(entity.getCONSULT_PART_SIGUNGU())).append(",")
        .append("CONSULT_POS = ")
        .append(toDB(entity.getCONSULT_POS())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("RECV_METHOD = ")
        .append(toDB(entity.getRECV_METHOD())).append(",")
        .append("DEMAND_CONTENTS = ")
        .append(toDB(entity.getDEMAND_CONTENTS())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("PROC_OUT = ")
        .append(toDB(entity.getPROC_OUT())).append(",")
        .append("PROC_DT = ")
        .append(toDB(entity.getPROC_DT())).append(",")
        .append("PROC_TIME = ")
        .append(toDB(entity.getPROC_TIME())).append(",")
        .append("RECV_AREA = ")
        .append(toDB(entity.getRECV_AREA())).append(",")
        .append("CONSULT_AREA = ")
        .append(toDB(entity.getCONSULT_AREA()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : updateModifiedOnly() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;

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
    sb.append("update PT_MODIFY_REQ  set " )
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




  public String updateModifiedOnlySql(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : updateModifiedOnly() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;


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
    sb.append("update PT_MODIFY_REQ  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : updateModifiedOnly() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;

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
    sb.append("update PT_MODIFY_REQ  set " )
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
  
  
   public String updateExcludeOnlySql(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : updateModifiedOnly() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;


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
    sb.append("update PT_MODIFY_REQ  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : delete() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_MODIFY_REQ  where  1=1")
      
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

  public String deleteSql(ValueObject obj) throws SQLException{

    if((obj instanceof PT_MODIFY_REQEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MODIFY_REQ : delete() ");
    }
    PT_MODIFY_REQEntity entity = (PT_MODIFY_REQEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_MODIFY_REQ  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
       ;


   return sb.toString();
  }


}//Class End
