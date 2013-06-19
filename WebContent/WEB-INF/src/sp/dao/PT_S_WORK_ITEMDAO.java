


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_S_WORK_ITEM
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*               TMP_WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               WRT_NUM:VARCHAR2(12):
*               TMP_WRT_NUM:VARCHAR2(12):
*               WORKNM:VARCHAR2(200):
*               SPOT_ADDR:VARCHAR2(200):
*               CONT_WRT_YN:VARCHAR2(1):
*               ENGINEER_ARR_NOTE:VARCHAR2(1):
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):
*               SPOT_TEL:VARCHAR2(17):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               SEQ:NUMBER(4):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_S_WORK_ITEMDAO  extends SuperToDB{

  private String default_fields[]={ "WRT_NUM" , "TMP_WRT_NUM" , "WORKNM" , "SPOT_ADDR" , "CONT_WRT_YN" , "ENGINEER_ARR_NOTE" , "CARE_BOOK_ISSUE_NUM" , "SPOT_TEL" , "INS_DT" , "UPD_DT" , "WRT_ID" , "SEQ" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_S_WORK_ITEMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_WORK_ITEM : insert() ");
    }
    PT_S_WORK_ITEMEntity entity = (PT_S_WORK_ITEMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_S_WORK_ITEM ")
    .append(" ( WRT_NUM,TMP_WRT_NUM,WORKNM,SPOT_ADDR,CONT_WRT_YN,ENGINEER_ARR_NOTE,CARE_BOOK_ISSUE_NUM,SPOT_TEL,INS_DT,UPD_DT,WRT_ID,SEQ ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWORKNM()))
			.append(",")
           .append(toDB(entity.getSPOT_ADDR()))
			.append(",")
           .append(toDB(entity.getCONT_WRT_YN()))
			.append(",")
           .append(toDB(entity.getENGINEER_ARR_NOTE()))
			.append(",")
           .append(toDB(entity.getCARE_BOOK_ISSUE_NUM()))
			.append(",")
           .append(toDB(entity.getSPOT_TEL()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getSEQ()))
			
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


    if((obj instanceof PT_S_WORK_ITEMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_WORK_ITEM : update() ");
    }
    PT_S_WORK_ITEMEntity entity = (PT_S_WORK_ITEMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_S_WORK_ITEM  set ")
       
        .append("WORKNM = ")
        .append(toDB(entity.getWORKNM())).append(",")
        .append("SPOT_ADDR = ")
        .append(toDB(entity.getSPOT_ADDR())).append(",")
        .append("CONT_WRT_YN = ")
        .append(toDB(entity.getCONT_WRT_YN())).append(",")
        .append("ENGINEER_ARR_NOTE = ")
        .append(toDB(entity.getENGINEER_ARR_NOTE())).append(",")
        .append("CARE_BOOK_ISSUE_NUM = ")
        .append(toDB(entity.getCARE_BOOK_ISSUE_NUM())).append(",")
        .append("SPOT_TEL = ")
        .append(toDB(entity.getSPOT_TEL())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append(" where  1=1 ");
       
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
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



    if((obj instanceof PT_S_WORK_ITEMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_WORK_ITEM : updateModifiedOnly() ");
    }
    PT_S_WORK_ITEMEntity entity = (PT_S_WORK_ITEMEntity)obj;

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
    sb.append("update PT_S_WORK_ITEM  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
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

    if((obj instanceof PT_S_WORK_ITEMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_WORK_ITEM : updateModifiedOnly() ");
    }
    PT_S_WORK_ITEMEntity entity = (PT_S_WORK_ITEMEntity)obj;

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
    sb.append("update PT_S_WORK_ITEM  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
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

    if((obj instanceof PT_S_WORK_ITEMEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_S_WORK_ITEM : delete() ");
    }
    PT_S_WORK_ITEMEntity entity = (PT_S_WORK_ITEMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_S_WORK_ITEM  where  1=1")
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
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
