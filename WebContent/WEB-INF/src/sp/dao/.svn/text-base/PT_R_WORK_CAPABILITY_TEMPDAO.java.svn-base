


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_WORK_CAPABILITY_TEMP
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SEQ
*               TMP_WRT_NUM
*  테이블 컬럼 :
*               SEQ:VARCHAR2(4):
*               TMP_WRT_NUM:VARCHAR2(12):
*               RECV_NUM:VARCHAR2(12):
*               SIDO_CODE:VARCHAR2(4):
*               CAP_PROC:VARCHAR2(2):
*               COI_WRT_NUM:VARCHAR2(12):
*               ASSE_DT:VARCHAR2(8):
*               ASSE_AOM:VARCHAR2(15):
*               APPL_TERM_START_DT:VARCHAR2(8):
*               CONFIRM:VARCHAR2(1):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               APPL_TERM_END_DT:VARCHAR2(8):
*               SEQ_LINK_CAPABILITY:VARCHAR2(30):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_WORK_CAPABILITY_TEMPDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "TMP_WRT_NUM" , "RECV_NUM" , "SIDO_CODE" , "CAP_PROC" , "COI_WRT_NUM" , "ASSE_DT" , "ASSE_AOM" , "APPL_TERM_START_DT" , "CONFIRM" , "WRT_ID" , "UPD_DT" , "INS_DT" , "APPL_TERM_END_DT" , "SEQ_LINK_CAPABILITY" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : insert() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_WORK_CAPABILITY_TEMP ")
    .append(" ( SEQ,TMP_WRT_NUM,RECV_NUM,SIDO_CODE,CAP_PROC,COI_WRT_NUM,ASSE_DT,ASSE_AOM,APPL_TERM_START_DT,CONFIRM,WRT_ID,UPD_DT,INS_DT,APPL_TERM_END_DT,SEQ_LINK_CAPABILITY ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getCAP_PROC()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getASSE_DT()))
			.append(",")
           .append(toDB(entity.getASSE_AOM()))
			.append(",")
           .append(toDB(entity.getAPPL_TERM_START_DT()))
			.append(",")
           .append(toDB(entity.getCONFIRM()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getAPPL_TERM_END_DT()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_CAPABILITY()))
			
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

    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : insert() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_WORK_CAPABILITY_TEMP ")
    .append(" ( SEQ,TMP_WRT_NUM,RECV_NUM,SIDO_CODE,CAP_PROC,COI_WRT_NUM,ASSE_DT,ASSE_AOM,APPL_TERM_START_DT,CONFIRM,WRT_ID,UPD_DT,INS_DT,APPL_TERM_END_DT,SEQ_LINK_CAPABILITY ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getCAP_PROC()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getASSE_DT()))
			.append(",")
           .append(toDB(entity.getASSE_AOM()))
			.append(",")
           .append(toDB(entity.getAPPL_TERM_START_DT()))
			.append(",")
           .append(toDB(entity.getCONFIRM()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getAPPL_TERM_END_DT()))
			.append(",")
           .append(toDB(entity.getSEQ_LINK_CAPABILITY()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : update() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_WORK_CAPABILITY_TEMP  set ")
       
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("CAP_PROC = ")
        .append(toDB(entity.getCAP_PROC())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("ASSE_DT = ")
        .append(toDB(entity.getASSE_DT())).append(",")
        .append("ASSE_AOM = ")
        .append(toDB(entity.getASSE_AOM())).append(",")
        .append("APPL_TERM_START_DT = ")
        .append(toDB(entity.getAPPL_TERM_START_DT())).append(",")
        .append("CONFIRM = ")
        .append(toDB(entity.getCONFIRM())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("APPL_TERM_END_DT = ")
        .append(toDB(entity.getAPPL_TERM_END_DT())).append(",")
        .append("SEQ_LINK_CAPABILITY = ")
        .append(toDB(entity.getSEQ_LINK_CAPABILITY()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
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


  public String  updateSql( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : update() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_WORK_CAPABILITY_TEMP  set ")
       
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("CAP_PROC = ")
        .append(toDB(entity.getCAP_PROC())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("ASSE_DT = ")
        .append(toDB(entity.getASSE_DT())).append(",")
        .append("ASSE_AOM = ")
        .append(toDB(entity.getASSE_AOM())).append(",")
        .append("APPL_TERM_START_DT = ")
        .append(toDB(entity.getAPPL_TERM_START_DT())).append(",")
        .append("CONFIRM = ")
        .append(toDB(entity.getCONFIRM())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("APPL_TERM_END_DT = ")
        .append(toDB(entity.getAPPL_TERM_END_DT())).append(",")
        .append("SEQ_LINK_CAPABILITY = ")
        .append(toDB(entity.getSEQ_LINK_CAPABILITY()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : updateModifiedOnly() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;

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
    sb.append("update PT_R_WORK_CAPABILITY_TEMP  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
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




  public String updateModifiedOnlySql(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : updateModifiedOnly() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;


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
    sb.append("update PT_R_WORK_CAPABILITY_TEMP  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : updateModifiedOnly() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;

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
    sb.append("update PT_R_WORK_CAPABILITY_TEMP  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
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
  
  
   public String updateExcludeOnlySql(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : updateModifiedOnly() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;


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
    sb.append("update PT_R_WORK_CAPABILITY_TEMP  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : delete() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_WORK_CAPABILITY_TEMP  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
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

  public String deleteSql(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_WORK_CAPABILITY_TEMPEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_WORK_CAPABILITY_TEMP : delete() ");
    }
    PT_R_WORK_CAPABILITY_TEMPEntity entity = (PT_R_WORK_CAPABILITY_TEMPEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_WORK_CAPABILITY_TEMP  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
       ;


   return sb.toString();
  }


}//Class End
