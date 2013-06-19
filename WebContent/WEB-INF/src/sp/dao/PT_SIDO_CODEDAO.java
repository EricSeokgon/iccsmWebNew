


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_SIDO_CODE
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*  테이블 컬럼 :
*               SEQ:NUMBER(4):
*               SIDO_NM:VARCHAR2(20):
*               SIGUNGU_NM:VARCHAR2(40):
*               TEL:VARCHAR2(24):
*               OFFPART:VARCHAR2(100):
*               AREA_CODE:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               REMARK:VARCHAR2(255):
*               HOME:VARCHAR2(128):
*               ADDR:VARCHAR2(128):
*               SIDO_CAPTAIN:VARCHAR2(40):
*               SIDO_FULL_NM:VARCHAR2(50):
*               SIDO_NM_CUT:VARCHAR2(10):
*               SIGUNGU_NM_CUT:VARCHAR2(30):
*               COI_WRT_NUM:VARCHAR2(4):
*               NUM2:VARCHAR2(4):
*               SIDO_SEQ:VARCHAR2(4):
*               SIGUNGU_SEQ:VARCHAR2(5):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_SIDO_CODEDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "SIDO_NM" , "SIGUNGU_NM" , "TEL" , "OFFPART" , "AREA_CODE" , "WRT_ID" , "INS_DT" , "UPD_DT" , "REMARK" , "HOME" , "ADDR" , "SIDO_CAPTAIN" , "SIDO_FULL_NM" , "SIDO_NM_CUT" , "SIGUNGU_NM_CUT" , "COI_WRT_NUM" , "NUM2" , "SIDO_SEQ" , "SIGUNGU_SEQ" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : insert() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_SIDO_CODE ")
    .append(" ( SEQ,SIDO_NM,SIGUNGU_NM,TEL,OFFPART,AREA_CODE,WRT_ID,INS_DT,UPD_DT,REMARK,HOME,ADDR,SIDO_CAPTAIN,SIDO_FULL_NM,SIDO_NM_CUT,SIGUNGU_NM_CUT,COI_WRT_NUM,NUM2,SIDO_SEQ,SIGUNGU_SEQ ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getSIDO_NM()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_NM()))
			.append(",")
           .append(toDB(entity.getTEL()))
			.append(",")
           .append(toDB(entity.getOFFPART()))
			.append(",")
           .append(toDB(entity.getAREA_CODE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getHOME()))
			.append(",")
           .append(toDB(entity.getADDR()))
			.append(",")
           .append(toDB(entity.getSIDO_CAPTAIN()))
			.append(",")
           .append(toDB(entity.getSIDO_FULL_NM()))
			.append(",")
           .append(toDB(entity.getSIDO_NM_CUT()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_NM_CUT()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getNUM2()))
			.append(",")
           .append(toDB(entity.getSIDO_SEQ()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_SEQ()))
			
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

    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : insert() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_SIDO_CODE ")
    .append(" ( SEQ,SIDO_NM,SIGUNGU_NM,TEL,OFFPART,AREA_CODE,WRT_ID,INS_DT,UPD_DT,REMARK,HOME,ADDR,SIDO_CAPTAIN,SIDO_FULL_NM,SIDO_NM_CUT,SIGUNGU_NM_CUT,COI_WRT_NUM,NUM2,SIDO_SEQ,SIGUNGU_SEQ ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getSIDO_NM()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_NM()))
			.append(",")
           .append(toDB(entity.getTEL()))
			.append(",")
           .append(toDB(entity.getOFFPART()))
			.append(",")
           .append(toDB(entity.getAREA_CODE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getHOME()))
			.append(",")
           .append(toDB(entity.getADDR()))
			.append(",")
           .append(toDB(entity.getSIDO_CAPTAIN()))
			.append(",")
           .append(toDB(entity.getSIDO_FULL_NM()))
			.append(",")
           .append(toDB(entity.getSIDO_NM_CUT()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_NM_CUT()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getNUM2()))
			.append(",")
           .append(toDB(entity.getSIDO_SEQ()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_SEQ()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : update() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_SIDO_CODE  set ")
       
        .append("SIDO_NM = ")
        .append(toDB(entity.getSIDO_NM())).append(",")
        .append("SIGUNGU_NM = ")
        .append(toDB(entity.getSIGUNGU_NM())).append(",")
        .append("TEL = ")
        .append(toDB(entity.getTEL())).append(",")
        .append("OFFPART = ")
        .append(toDB(entity.getOFFPART())).append(",")
        .append("AREA_CODE = ")
        .append(toDB(entity.getAREA_CODE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("HOME = ")
        .append(toDB(entity.getHOME())).append(",")
        .append("ADDR = ")
        .append(toDB(entity.getADDR())).append(",")
        .append("SIDO_CAPTAIN = ")
        .append(toDB(entity.getSIDO_CAPTAIN())).append(",")
        .append("SIDO_FULL_NM = ")
        .append(toDB(entity.getSIDO_FULL_NM())).append(",")
        .append("SIDO_NM_CUT = ")
        .append(toDB(entity.getSIDO_NM_CUT())).append(",")
        .append("SIGUNGU_NM_CUT = ")
        .append(toDB(entity.getSIGUNGU_NM_CUT())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("NUM2 = ")
        .append(toDB(entity.getNUM2())).append(",")
        .append("SIDO_SEQ = ")
        .append(toDB(entity.getSIDO_SEQ())).append(",")
        .append("SIGUNGU_SEQ = ")
        .append(toDB(entity.getSIGUNGU_SEQ()))
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


    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : update() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_SIDO_CODE  set ")
       
        .append("SIDO_NM = ")
        .append(toDB(entity.getSIDO_NM())).append(",")
        .append("SIGUNGU_NM = ")
        .append(toDB(entity.getSIGUNGU_NM())).append(",")
        .append("TEL = ")
        .append(toDB(entity.getTEL())).append(",")
        .append("OFFPART = ")
        .append(toDB(entity.getOFFPART())).append(",")
        .append("AREA_CODE = ")
        .append(toDB(entity.getAREA_CODE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("HOME = ")
        .append(toDB(entity.getHOME())).append(",")
        .append("ADDR = ")
        .append(toDB(entity.getADDR())).append(",")
        .append("SIDO_CAPTAIN = ")
        .append(toDB(entity.getSIDO_CAPTAIN())).append(",")
        .append("SIDO_FULL_NM = ")
        .append(toDB(entity.getSIDO_FULL_NM())).append(",")
        .append("SIDO_NM_CUT = ")
        .append(toDB(entity.getSIDO_NM_CUT())).append(",")
        .append("SIGUNGU_NM_CUT = ")
        .append(toDB(entity.getSIGUNGU_NM_CUT())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("NUM2 = ")
        .append(toDB(entity.getNUM2())).append(",")
        .append("SIDO_SEQ = ")
        .append(toDB(entity.getSIDO_SEQ())).append(",")
        .append("SIGUNGU_SEQ = ")
        .append(toDB(entity.getSIGUNGU_SEQ()))
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



    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : updateModifiedOnly() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;

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
    sb.append("update PT_SIDO_CODE  set " )
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



    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : updateModifiedOnly() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;


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
    sb.append("update PT_SIDO_CODE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : updateModifiedOnly() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;

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
    sb.append("update PT_SIDO_CODE  set " )
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

    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : updateModifiedOnly() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;


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
    sb.append("update PT_SIDO_CODE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : delete() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_SIDO_CODE  where  1=1")
      
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

    if((obj instanceof PT_SIDO_CODEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_SIDO_CODE : delete() ");
    }
    PT_SIDO_CODEEntity entity = (PT_SIDO_CODEEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_SIDO_CODE  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
       ;


   return sb.toString();
  }


}//Class End
