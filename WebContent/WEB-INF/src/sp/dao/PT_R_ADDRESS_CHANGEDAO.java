


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_ADDRESS_CHANGE
*  테이블 설명 :
*  테이블 PK   :
*               CHGBRE_SEQ
*               TMP_WRT_NUM
*  테이블 컬럼 :
*               CHGBRE_SEQ:VARCHAR2(10):
*               TMP_WRT_NUM:VARCHAR2(12):
*               SIDO_CODE:VARCHAR2(3):
*               POST_NUM:VARCHAR2(6):
*               ADDR:VARCHAR2(100):
*               DETAIL_ADDR:VARCHAR2(100):
*               OFFICE_AREA:VARCHAR2(10):
*               TEL_NUM:VARCHAR2(20):
*               FAX_NUM:VARCHAR2(20):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               ETC1:VARCHAR2(30):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_ADDRESS_CHANGEDAO  extends SuperToDB{

  private String default_fields[]={ "CHGBRE_SEQ" , "TMP_WRT_NUM" , "SIDO_CODE" , "POST_NUM" , "ADDR" , "DETAIL_ADDR" , "OFFICE_AREA" , "TEL_NUM" , "FAX_NUM" , "WRT_ID" , "UPD_DT" , "INS_DT" , "ETC1" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_ADDRESS_CHANGEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ADDRESS_CHANGE : insert() ");
    }
    PT_R_ADDRESS_CHANGEEntity entity = (PT_R_ADDRESS_CHANGEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_ADDRESS_CHANGE ")
    .append(" ( CHGBRE_SEQ,TMP_WRT_NUM,SIDO_CODE,POST_NUM,ADDR,DETAIL_ADDR,OFFICE_AREA,TEL_NUM,FAX_NUM,WRT_ID,UPD_DT,INS_DT,ETC1 ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getPOST_NUM()))
			.append(",")
           .append(toDB(entity.getADDR()))
			.append(",")
           .append(toDB(entity.getDETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getOFFICE_AREA()))
			.append(",")
           .append(toDB(entity.getTEL_NUM()))
			.append(",")
           .append(toDB(entity.getFAX_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getETC1()))
			
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


    if((obj instanceof PT_R_ADDRESS_CHANGEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ADDRESS_CHANGE : update() ");
    }
    PT_R_ADDRESS_CHANGEEntity entity = (PT_R_ADDRESS_CHANGEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_ADDRESS_CHANGE  set ")
       
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("POST_NUM = ")
        .append(toDB(entity.getPOST_NUM())).append(",")
        .append("ADDR = ")
        .append(toDB(entity.getADDR())).append(",")
        .append("DETAIL_ADDR = ")
        .append(toDB(entity.getDETAIL_ADDR())).append(",")
        .append("OFFICE_AREA = ")
        .append(toDB(entity.getOFFICE_AREA())).append(",")
        .append("TEL_NUM = ")
        .append(toDB(entity.getTEL_NUM())).append(",")
        .append("FAX_NUM = ")
        .append(toDB(entity.getFAX_NUM())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("ETC1 = ")
        .append(toDB(entity.getETC1()))
        .append(" where  1=1 ");
       
         sb.append(" and CHGBRE_SEQ = ").append( toDB(entity.getCHGBRE_SEQ()));
         
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



    if((obj instanceof PT_R_ADDRESS_CHANGEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ADDRESS_CHANGE : updateModifiedOnly() ");
    }
    PT_R_ADDRESS_CHANGEEntity entity = (PT_R_ADDRESS_CHANGEEntity)obj;

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
    sb.append("update PT_R_ADDRESS_CHANGE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
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

    if((obj instanceof PT_R_ADDRESS_CHANGEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ADDRESS_CHANGE : updateModifiedOnly() ");
    }
    PT_R_ADDRESS_CHANGEEntity entity = (PT_R_ADDRESS_CHANGEEntity)obj;

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
    sb.append("update PT_R_ADDRESS_CHANGE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()));
     
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

    if((obj instanceof PT_R_ADDRESS_CHANGEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_ADDRESS_CHANGE : delete() ");
    }
    PT_R_ADDRESS_CHANGEEntity entity = (PT_R_ADDRESS_CHANGEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_ADDRESS_CHANGE  where  1=1")
      
	  .append(" and CHGBRE_SEQ = ").append(toDB(entity.getCHGBRE_SEQ()))
      
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
