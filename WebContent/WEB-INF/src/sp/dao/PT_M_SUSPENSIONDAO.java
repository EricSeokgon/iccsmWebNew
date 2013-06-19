


/*
*  Automatic generated  source
*  ��  ��  �� : ����
*
*  ���̺� ��   :PT_M_SUSPENSION
*  ���̺� ���� :
*  ���̺� PK   :
*               TMP_WRT_NUM
*               WRT_NUM
*  ���̺� �÷� :
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_NUM:VARCHAR2(12):
*               BUSISUSP_START_DT:VARCHAR2(8):
*               BUSISUSP_END_DT:VARCHAR2(8):
*               OPIN_COLL_DT:VARCHAR2(8):
*               OPIN_COLL_CONT:VARCHAR2(1024):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               LIS_END_DATE:VARCHAR2(8):
*               BEFORE_DISPO:VARCHAR2(1):
*               OPINI_SUBMIT_DATE:VARCHAR2(8):
*               OPINI_SUBMIT:VARCHAR2(1):
*               DECISION_DATE:VARCHAR2(8):
*               DISPO_PERIOD:VARCHAR2(6):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_M_SUSPENSIONDAO  extends SuperToDB{

  private String default_fields[]={ "TMP_WRT_NUM" , "WRT_NUM" , "BUSISUSP_START_DT" , "BUSISUSP_END_DT" , "OPIN_COLL_DT" , "OPIN_COLL_CONT" , "INS_DT" , "UPD_DT" , "WRT_ID" , "LIS_END_DATE" , "BEFORE_DISPO" , "OPINI_SUBMIT_DATE" , "OPINI_SUBMIT" , "DECISION_DATE" , "DISPO_PERIOD" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : insert() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_SUSPENSION ")
    .append(" ( TMP_WRT_NUM,WRT_NUM,BUSISUSP_START_DT,BUSISUSP_END_DT,OPIN_COLL_DT,OPIN_COLL_CONT,INS_DT,UPD_DT,WRT_ID,LIS_END_DATE,BEFORE_DISPO,OPINI_SUBMIT_DATE,OPINI_SUBMIT,DECISION_DATE,DISPO_PERIOD ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_START_DT()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_END_DT()))
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
           .append(toDB(entity.getLIS_END_DATE()))
			.append(",")
           .append(toDB(entity.getBEFORE_DISPO()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT_DATE()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT()))
			.append(",")
           .append(toDB(entity.getDECISION_DATE()))
			.append(",")
           .append(toDB(entity.getDISPO_PERIOD()))
			
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

    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : insert() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_SUSPENSION ")
    .append(" ( TMP_WRT_NUM,WRT_NUM,BUSISUSP_START_DT,BUSISUSP_END_DT,OPIN_COLL_DT,OPIN_COLL_CONT,INS_DT,UPD_DT,WRT_ID,LIS_END_DATE,BEFORE_DISPO,OPINI_SUBMIT_DATE,OPINI_SUBMIT,DECISION_DATE,DISPO_PERIOD ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_START_DT()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_END_DT()))
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
           .append(toDB(entity.getLIS_END_DATE()))
			.append(",")
           .append(toDB(entity.getBEFORE_DISPO()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT_DATE()))
			.append(",")
           .append(toDB(entity.getOPINI_SUBMIT()))
			.append(",")
           .append(toDB(entity.getDECISION_DATE()))
			.append(",")
           .append(toDB(entity.getDISPO_PERIOD()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : update() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_SUSPENSION  set ")
       
        .append("BUSISUSP_START_DT = ")
        .append(toDB(entity.getBUSISUSP_START_DT())).append(",")
        .append("BUSISUSP_END_DT = ")
        .append(toDB(entity.getBUSISUSP_END_DT())).append(",")
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
        .append("LIS_END_DATE = ")
        .append(toDB(entity.getLIS_END_DATE())).append(",")
        .append("BEFORE_DISPO = ")
        .append(toDB(entity.getBEFORE_DISPO())).append(",")
        .append("OPINI_SUBMIT_DATE = ")
        .append(toDB(entity.getOPINI_SUBMIT_DATE())).append(",")
        .append("OPINI_SUBMIT = ")
        .append(toDB(entity.getOPINI_SUBMIT())).append(",")
        .append("DECISION_DATE = ")
        .append(toDB(entity.getDECISION_DATE())).append(",")
        .append("DISPO_PERIOD = ")
        .append(toDB(entity.getDISPO_PERIOD()))
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


    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : update() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_SUSPENSION  set ")
       
        .append("BUSISUSP_START_DT = ")
        .append(toDB(entity.getBUSISUSP_START_DT())).append(",")
        .append("BUSISUSP_END_DT = ")
        .append(toDB(entity.getBUSISUSP_END_DT())).append(",")
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
        .append("LIS_END_DATE = ")
        .append(toDB(entity.getLIS_END_DATE())).append(",")
        .append("BEFORE_DISPO = ")
        .append(toDB(entity.getBEFORE_DISPO())).append(",")
        .append("OPINI_SUBMIT_DATE = ")
        .append(toDB(entity.getOPINI_SUBMIT_DATE())).append(",")
        .append("OPINI_SUBMIT = ")
        .append(toDB(entity.getOPINI_SUBMIT())).append(",")
        .append("DECISION_DATE = ")
        .append(toDB(entity.getDECISION_DATE())).append(",")
        .append("DISPO_PERIOD = ")
        .append(toDB(entity.getDISPO_PERIOD()))
        .append(" where  1=1 ");
       
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //������ �ʵ常�� �����Ѵ�.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : updateModifiedOnly() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;

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
    sb.append("update PT_M_SUSPENSION  set " )
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



    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : updateModifiedOnly() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;


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
    sb.append("update PT_M_SUSPENSION  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //Ư���ʵ带 ������ ��ü �ʵ带 �����Ѵ�.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : updateModifiedOnly() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;

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
    sb.append("update PT_M_SUSPENSION  set " )
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

    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : updateModifiedOnly() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;


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
    sb.append("update PT_M_SUSPENSION  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : delete() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_SUSPENSION  where  1=1")
      
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

    if((obj instanceof PT_M_SUSPENSIONEntity) == false){
        throw new  SQLException("DAO ����(1): PT_M_SUSPENSION : delete() ");
    }
    PT_M_SUSPENSIONEntity entity = (PT_M_SUSPENSIONEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_SUSPENSION  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
