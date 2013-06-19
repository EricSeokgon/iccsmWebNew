


/*
*  Automatic generated  source
*  ��  ��  �� : ����
*
*  ���̺� ��   :PT_S_CONFIRM
*  ���̺� ���� :
*  ���̺� PK   :
*               TMP_WRT_NUM
*               WRT_NUM
*  ���̺� �÷� :
*               WRT_NUM:VARCHAR2(12):
*               TMP_WRT_NUM:VARCHAR2(12):
*               VIOL_DT:VARCHAR2(8):
*               VIOL_ITEM:VARCHAR2(512):
*               VIOL_CONT:VARCHAR2(2048):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_S_CONFIRMDAO  extends SuperToDB{

  private String default_fields[]={ "WRT_NUM" , "TMP_WRT_NUM" , "VIOL_DT" , "VIOL_ITEM" , "VIOL_CONT" , "INS_DT" , "UPD_DT" , "WRT_ID" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_S_CONFIRMEntity) == false){
        throw new  SQLException("DAO ����(1): PT_S_CONFIRM : insert() ");
    }
    PT_S_CONFIRMEntity entity = (PT_S_CONFIRMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_S_CONFIRM ")
    .append(" ( WRT_NUM,TMP_WRT_NUM,VIOL_DT,VIOL_ITEM,VIOL_CONT,INS_DT,UPD_DT,WRT_ID ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getVIOL_DT()))
			.append(",")
           .append(toDB(entity.getVIOL_ITEM()))
			.append(",")
           .append(toDB(entity.getVIOL_CONT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			
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


    if((obj instanceof PT_S_CONFIRMEntity) == false){
        throw new  SQLException("DAO ����(1): PT_S_CONFIRM : update() ");
    }
    PT_S_CONFIRMEntity entity = (PT_S_CONFIRMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_S_CONFIRM  set ")
       
        .append("VIOL_DT = ")
        .append(toDB(entity.getVIOL_DT())).append(",")
        .append("VIOL_ITEM = ")
        .append(toDB(entity.getVIOL_ITEM())).append(",")
        .append("VIOL_CONT = ")
        .append(toDB(entity.getVIOL_CONT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID()))
        .append(" where  1=1 ");
       
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         
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
  //������ �ʵ常�� �����Ѵ�.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_S_CONFIRMEntity) == false){
        throw new  SQLException("DAO ����(1): PT_S_CONFIRM : updateModifiedOnly() ");
    }
    PT_S_CONFIRMEntity entity = (PT_S_CONFIRMEntity)obj;

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
    sb.append("update PT_S_CONFIRM  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
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
  //Ư���ʵ带 ������ ��ü �ʵ带 �����Ѵ�.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_S_CONFIRMEntity) == false){
        throw new  SQLException("DAO ����(1): PT_S_CONFIRM : updateModifiedOnly() ");
    }
    PT_S_CONFIRMEntity entity = (PT_S_CONFIRMEntity)obj;

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
    sb.append("update PT_S_CONFIRM  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
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

    if((obj instanceof PT_S_CONFIRMEntity) == false){
        throw new  SQLException("DAO ����(1): PT_S_CONFIRM : delete() ");
    }
    PT_S_CONFIRMEntity entity = (PT_S_CONFIRMEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_S_CONFIRM  where  1=1")
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
      
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
