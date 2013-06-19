


/*
*  Automatic generated  source
*  ��  ��  �� : ����
*
*  ���̺� ��   :PT_COM_CODE
*  ���̺� ���� :
*  ���̺� PK   :
*               SEQ
*  ���̺� �÷� :
*               SEQ:NUMBER(11):
*               CODE:VARCHAR2(32):
*               P_CODE:VARCHAR2(32):
*               CODE_NAME:VARCHAR2(128):
*               ORDER_SEQ:NUMBER(13):
*               USE_YN:VARCHAR2(1):
*               BIGO:VARCHAR2(200):
*               REG_DATE:VARCHAR2(20):
*               MOD_DATE:VARCHAR2(20):
*               P_CODE_NAME:VARCHAR2(128):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_COM_CODEDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "CODE" , "P_CODE" , "CODE_NAME" , "ORDER_SEQ" , "USE_YN" , "BIGO" , "REG_DATE" , "MOD_DATE" , "P_CODE_NAME" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_COM_CODEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_COM_CODE : insert() ");
    }
    PT_COM_CODEEntity entity = (PT_COM_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_COM_CODE ")
    .append(" ( SEQ,CODE,P_CODE,CODE_NAME,P_CODE_NAME ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getCODE()))
			.append(",")
           .append(toDB(entity.getP_CODE()))
			.append(",")
           .append(toDB(entity.getCODE_NAME()))
			.append(",")
           .append(toDB(entity.getP_CODE_NAME()))			           
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


    if((obj instanceof PT_COM_CODEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_COM_CODE : update() ");
    }
    PT_COM_CODEEntity entity = (PT_COM_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_COM_CODE  set ")
       
        .append("CODE = ")
        .append(toDB(entity.getCODE())).append(",")
        .append("P_CODE = ")
        .append(toDB(entity.getP_CODE())).append(",")
        .append("CODE_NAME = ")
        .append(toDB(entity.getCODE_NAME())).append(",")
        .append("P_CODE_NAME = ")
        .append(toDB(entity.getP_CODE_NAME()))
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

  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //������ �ʵ常�� �����Ѵ�.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_COM_CODEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_COM_CODE : updateModifiedOnly() ");
    }
    PT_COM_CODEEntity entity = (PT_COM_CODEEntity)obj;

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
    sb.append("update PT_COM_CODE  set " )
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


  ///////////////////////////////////////////////////////////////////////////////////
  //Ư���ʵ带 ������ ��ü �ʵ带 �����Ѵ�.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_COM_CODEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_COM_CODE : updateModifiedOnly() ");
    }
    PT_COM_CODEEntity entity = (PT_COM_CODEEntity)obj;

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
    sb.append("update PT_COM_CODE  set " )
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
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_COM_CODEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_COM_CODE : delete() ");
    }
    PT_COM_CODEEntity entity = (PT_COM_CODEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_COM_CODE  where  1=1")
      
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
