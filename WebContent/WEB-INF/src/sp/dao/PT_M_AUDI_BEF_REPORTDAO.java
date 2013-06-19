


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_M_AUDI_BEF_REPORT
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*               TMP_WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               SEQ:VARCHAR2(4):
*               NOTE_CLASS_CODE:VARCHAR2(6):
*               SEND_DT:VARCHAR2(8):
*               S_PER:VARCHAR2(16):
*               RECV_YN:VARCHAR2(6):
*               REMARK:VARCHAR2(256):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_NUM:VARCHAR2(12):
*               NOTE_NAME:VARCHAR2(50):
*               NOTE_METHOD_CLASS:VARCHAR2(6):
*               RECV_LOC:VARCHAR2(100):
*               GUBUN:VARCHAR2(6):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_M_AUDI_BEF_REPORTDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "NOTE_CLASS_CODE" , "SEND_DT" , "S_PER" , "RECV_YN" , "REMARK" , "INS_DT" , "UPD_DT" , "WRT_ID" , "TMP_WRT_NUM" , "WRT_NUM" , "NOTE_NAME" , "NOTE_METHOD_CLASS" , "RECV_LOC" , "GUBUN" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : insert() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_AUDI_BEF_REPORT ")
    .append(" ( SEQ,NOTE_CLASS_CODE,SEND_DT,S_PER,RECV_YN,REMARK,INS_DT,UPD_DT,WRT_ID,TMP_WRT_NUM,WRT_NUM,NOTE_NAME,NOTE_METHOD_CLASS,RECV_LOC,GUBUN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getNOTE_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getSEND_DT()))
			.append(",")
           .append(toDB(entity.getS_PER()))
			.append(",")
           .append(toDB(entity.getRECV_YN()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getNOTE_NAME()))
			.append(",")
           .append(toDB(entity.getNOTE_METHOD_CLASS()))
			.append(",")
           .append(toDB(entity.getRECV_LOC()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			
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

    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : insert() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_AUDI_BEF_REPORT ")
    .append(" ( SEQ,NOTE_CLASS_CODE,SEND_DT,S_PER,RECV_YN,REMARK,INS_DT,UPD_DT,WRT_ID,TMP_WRT_NUM,WRT_NUM,NOTE_NAME,NOTE_METHOD_CLASS,RECV_LOC,GUBUN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getNOTE_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getSEND_DT()))
			.append(",")
           .append(toDB(entity.getS_PER()))
			.append(",")
           .append(toDB(entity.getRECV_YN()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getNOTE_NAME()))
			.append(",")
           .append(toDB(entity.getNOTE_METHOD_CLASS()))
			.append(",")
           .append(toDB(entity.getRECV_LOC()))
			.append(",")
           .append(toDB(entity.getGUBUN()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : update() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_AUDI_BEF_REPORT  set ")
       
        .append("NOTE_CLASS_CODE = ")
        .append(toDB(entity.getNOTE_CLASS_CODE())).append(",")
        .append("SEND_DT = ")
        .append(toDB(entity.getSEND_DT())).append(",")
        .append("S_PER = ")
        .append(toDB(entity.getS_PER())).append(",")
        .append("RECV_YN = ")
        .append(toDB(entity.getRECV_YN())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("NOTE_NAME = ")
        .append(toDB(entity.getNOTE_NAME())).append(",")
        .append("NOTE_METHOD_CLASS = ")
        .append(toDB(entity.getNOTE_METHOD_CLASS())).append(",")
        .append("RECV_LOC = ")
        .append(toDB(entity.getRECV_LOC())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
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


  public String  updateSql( ValueObject obj) throws SQLException{


    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : update() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_AUDI_BEF_REPORT  set ")
       
        .append("NOTE_CLASS_CODE = ")
        .append(toDB(entity.getNOTE_CLASS_CODE())).append(",")
        .append("SEND_DT = ")
        .append(toDB(entity.getSEND_DT())).append(",")
        .append("S_PER = ")
        .append(toDB(entity.getS_PER())).append(",")
        .append("RECV_YN = ")
        .append(toDB(entity.getRECV_YN())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("NOTE_NAME = ")
        .append(toDB(entity.getNOTE_NAME())).append(",")
        .append("NOTE_METHOD_CLASS = ")
        .append(toDB(entity.getNOTE_METHOD_CLASS())).append(",")
        .append("RECV_LOC = ")
        .append(toDB(entity.getRECV_LOC())).append(",")
        .append("GUBUN = ")
        .append(toDB(entity.getGUBUN()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : updateModifiedOnly() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;

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
    sb.append("update PT_M_AUDI_BEF_REPORT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
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




  public String updateModifiedOnlySql(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : updateModifiedOnly() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;


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
    sb.append("update PT_M_AUDI_BEF_REPORT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : updateModifiedOnly() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;

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
    sb.append("update PT_M_AUDI_BEF_REPORT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
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
  
  
   public String updateExcludeOnlySql(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : updateModifiedOnly() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;


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
    sb.append("update PT_M_AUDI_BEF_REPORT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : delete() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_AUDI_BEF_REPORT  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
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

  public String deleteSql(ValueObject obj) throws SQLException{

    if((obj instanceof PT_M_AUDI_BEF_REPORTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_AUDI_BEF_REPORT : delete() ");
    }
    PT_M_AUDI_BEF_REPORTEntity entity = (PT_M_AUDI_BEF_REPORTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_AUDI_BEF_REPORT  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
