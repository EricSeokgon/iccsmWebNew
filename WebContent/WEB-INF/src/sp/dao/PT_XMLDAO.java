


/*
*  Automatic generated  source
*  ��  ��  �� : ����
*
*  ���̺� ��   :PT_XML
*  ���̺� ���� :
*  ���̺� PK   :
*               DSNAME
*               FORMID
*               SAMPLENAME
*               USERID
*  ���̺� �÷� :
*               USERID:VARCHAR2(50):
*               FORMID:VARCHAR2(50):
*               SAMPLENAME:VARCHAR2(50):
*               XML:VARCHAR2(4000):
*               DSNAME:VARCHAR2(50):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_XMLDAO  extends SuperToDB{

  private String default_fields[]={ "USERID" , "FORMID" , "SAMPLENAME" , "XML" , "DSNAME" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_XMLEntity) == false){
        throw new  SQLException("DAO ����(1): PT_XML : insert() ");
    }
    PT_XMLEntity entity = (PT_XMLEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_XML ")
    .append(" ( USERID,FORMID,SAMPLENAME,XML,DSNAME ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUSERID()))
			.append(",")
           .append(toDB(entity.getFORMID()))
			.append(",")
           .append(toDB(entity.getSAMPLENAME()))
			.append(",")
           .append(toDB(entity.getXML()))
			.append(",")
           .append(toDB(entity.getDSNAME()))
			
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


    if((obj instanceof PT_XMLEntity) == false){
        throw new  SQLException("DAO ����(1): PT_XML : update() ");
    }
    PT_XMLEntity entity = (PT_XMLEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_XML  set ")
       
        .append("XML = ")
        .append(toDB(entity.getXML())).append(",")
        .append(" where  1=1 ");
       
         sb.append(" and USERID = ").append( toDB(entity.getUSERID()));
         
         sb.append(" and FORMID = ").append( toDB(entity.getFORMID()));
         
         sb.append(" and SAMPLENAME = ").append( toDB(entity.getSAMPLENAME()));
         
         sb.append(" and DSNAME = ").append( toDB(entity.getDSNAME()));
         

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



    if((obj instanceof PT_XMLEntity) == false){
        throw new  SQLException("DAO ����(1): PT_XML : updateModifiedOnly() ");
    }
    PT_XMLEntity entity = (PT_XMLEntity)obj;

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
    sb.append("update PT_XML  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and USERID = ").append(toDB(entity.getUSERID()));
     
	  sb.append(" and FORMID = ").append(toDB(entity.getFORMID()));
     
	  sb.append(" and SAMPLENAME = ").append(toDB(entity.getSAMPLENAME()));
     
	  sb.append(" and DSNAME = ").append(toDB(entity.getDSNAME()));
     

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

    if((obj instanceof PT_XMLEntity) == false){
        throw new  SQLException("DAO ����(1): PT_XML : updateModifiedOnly() ");
    }
    PT_XMLEntity entity = (PT_XMLEntity)obj;

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
    sb.append("update PT_XML  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and USERID = ").append(toDB(entity.getUSERID()));
     
	  sb.append(" and FORMID = ").append(toDB(entity.getFORMID()));
     
	  sb.append(" and SAMPLENAME = ").append(toDB(entity.getSAMPLENAME()));
     
	  sb.append(" and DSNAME = ").append(toDB(entity.getDSNAME()));
     

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

    if((obj instanceof PT_XMLEntity) == false){
        throw new  SQLException("DAO ����(1): PT_XML : delete() ");
    }
    PT_XMLEntity entity = (PT_XMLEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_XML  where  1=1")
      
	  .append(" and USERID = ").append(toDB(entity.getUSERID()))
      
	  .append(" and FORMID = ").append(toDB(entity.getFORMID()))
      
	  .append(" and SAMPLENAME = ").append(toDB(entity.getSAMPLENAME()))
      
	  .append(" and DSNAME = ").append(toDB(entity.getDSNAME()))
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
