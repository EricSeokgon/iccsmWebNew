


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_M_NEGLIGENCE
*  테이블 설명 :
*  테이블 PK   :
*               TMP_WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_NUM:VARCHAR2(12):
*               OPIN_COLL_DT:VARCHAR2(8):
*               OPIN_COLL_CONT:VARCHAR2(1024):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               NEFI:NUMBER(14):
*               PAY_LIM:VARCHAR2(8):
*               PAY_DT:VARCHAR2(8):
*               PAY_YN:VARCHAR2(1):
*               REMARK:VARCHAR2(512):
*               DESION_DATE:VARCHAR2(8):
*               LIS_END_DATE:VARCHAR2(8):
*               OPINI_SUBMIT:VARCHAR2(1):
*               BEFORE_DISPO:VARCHAR2(1):
*               OPINI_SUBMIT_DATE:VARCHAR2(8):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_M_NEGLIGENCEDAO  extends SuperToDB{

  private String default_fields[]={ "TMP_WRT_NUM" , "WRT_NUM" , "OPIN_COLL_DT" , "OPIN_COLL_CONT" , "INS_DT" , "UPD_DT" , "WRT_ID" , "NEFI" , "PAY_LIM" , "PAY_DT" , "PAY_YN" , "REMARK" , "DESION_DATE" , "LIS_END_DATE" , "OPINI_SUBMIT" , "BEFORE_DISPO" , "OPINI_SUBMIT_DATE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : insert() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_NEGLIGENCE ")
    .append(" ( TMP_WRT_NUM,WRT_NUM,OPIN_COLL_DT,OPIN_COLL_CONT,INS_DT,UPD_DT,WRT_ID,NEFI,PAY_LIM,PAY_DT,PAY_YN,REMARK,DESION_DATE,LIS_END_DATE,OPINI_SUBMIT,BEFORE_DISPO,OPINI_SUBMIT_DATE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getOPIN_COLL_DT()))
			.append(",")
           .append(toDB(entity.getOPIN_COLL_CONT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getNEFI()))
			.append(",")
           .append(toDB(entity.getPAY_LIM()))
			.append(",")
           .append(toDB(entity.getPAY_DT()))
			.append(",")
           .append(toDB(entity.getPAY_YN()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getDESION_DATE()))
			.append(",")
           .append(toDB(entity.getLIS_END_DATE()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT()))
			.append(",")
           .append(toDB(entity.getBEFORE_DISPO()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT_DATE()))
			
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

    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : insert() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_NEGLIGENCE ")
    .append(" ( TMP_WRT_NUM,WRT_NUM,OPIN_COLL_DT,OPIN_COLL_CONT,INS_DT,UPD_DT,WRT_ID,NEFI,PAY_LIM,PAY_DT,PAY_YN,REMARK,DESION_DATE,LIS_END_DATE,OPINI_SUBMIT,BEFORE_DISPO,OPINI_SUBMIT_DATE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getOPIN_COLL_DT()))
			.append(",")
           .append(toDB(entity.getOPIN_COLL_CONT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getNEFI()))
			.append(",")
           .append(toDB(entity.getPAY_LIM()))
			.append(",")
           .append(toDB(entity.getPAY_DT()))
			.append(",")
           .append(toDB(entity.getPAY_YN()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getDESION_DATE()))
			.append(",")
           .append(toDB(entity.getLIS_END_DATE()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT()))
			.append(",")
           .append(toDB(entity.getBEFORE_DISPO()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT_DATE()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : update() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_NEGLIGENCE  set ")
       
        .append("OPIN_COLL_DT = ")
        .append(toDB(entity.getOPIN_COLL_DT())).append(",")
        .append("OPIN_COLL_CONT = ")
        .append(toDB(entity.getOPIN_COLL_CONT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("NEFI = ")
        .append(toDB(entity.getNEFI())).append(",")
        .append("PAY_LIM = ")
        .append(toDB(entity.getPAY_LIM())).append(",")
        .append("PAY_DT = ")
        .append(toDB(entity.getPAY_DT())).append(",")
        .append("PAY_YN = ")
        .append(toDB(entity.getPAY_YN())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("DESION_DATE = ")
        .append(toDB(entity.getDESION_DATE())).append(",")
        .append("LIS_END_DATE = ")
        .append(toDB(entity.getLIS_END_DATE())).append(",")
        .append("OPINI_SUBMIT = ")
        .append(toDB(entity.getOPINI_SUBMIT())).append(",")
        .append("BEFORE_DISPO = ")
        .append(toDB(entity.getBEFORE_DISPO())).append(",")
        .append("OPINI_SUBMIT_DATE = ")
        .append(toDB(entity.getOPINI_SUBMIT_DATE()))
        .append(" where  1=1 ");
       
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


    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : update() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_NEGLIGENCE  set ")
       
        .append("OPIN_COLL_DT = ")
        .append(toDB(entity.getOPIN_COLL_DT())).append(",")
        .append("OPIN_COLL_CONT = ")
        .append(toDB(entity.getOPIN_COLL_CONT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("NEFI = ")
        .append(toDB(entity.getNEFI())).append(",")
        .append("PAY_LIM = ")
        .append(toDB(entity.getPAY_LIM())).append(",")
        .append("PAY_DT = ")
        .append(toDB(entity.getPAY_DT())).append(",")
        .append("PAY_YN = ")
        .append(toDB(entity.getPAY_YN())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("DESION_DATE = ")
        .append(toDB(entity.getDESION_DATE())).append(",")
        .append("LIS_END_DATE = ")
        .append(toDB(entity.getLIS_END_DATE())).append(",")
        .append("OPINI_SUBMIT = ")
        .append(toDB(entity.getOPINI_SUBMIT())).append(",")
        .append("BEFORE_DISPO = ")
        .append(toDB(entity.getBEFORE_DISPO())).append(",")
        .append("OPINI_SUBMIT_DATE = ")
        .append(toDB(entity.getOPINI_SUBMIT_DATE()))
        .append(" where  1=1 ");
       
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



    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : updateModifiedOnly() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;

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
    sb.append("update PT_M_NEGLIGENCE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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



    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : updateModifiedOnly() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;


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
    sb.append("update PT_M_NEGLIGENCE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : updateModifiedOnly() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;

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
    sb.append("update PT_M_NEGLIGENCE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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

    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : updateModifiedOnly() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;


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
    sb.append("update PT_M_NEGLIGENCE  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : delete() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_NEGLIGENCE  where  1=1")
      
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

    if((obj instanceof PT_M_NEGLIGENCEEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_NEGLIGENCE : delete() ");
    }
    PT_M_NEGLIGENCEEntity entity = (PT_M_NEGLIGENCEEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_NEGLIGENCE  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
