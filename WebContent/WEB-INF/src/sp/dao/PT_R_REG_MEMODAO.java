


/*
*  Automatic generated  source
*  ��  ��  �� : ����
*
*  ���̺� ��   :PT_R_REG_MEMO
*  ���̺� ���� :
*  ���̺� PK   :
*               CHGBRE_SEQ
*               MEMO_SEQ
*               TMP_WRT_NUM
*  ���̺� �÷� :
*               MEMO_SEQ:NUMBER(4):
*               MEMO_CONT:VARCHAR2(512):
*               WRT_DT:VARCHAR2(8):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               CHGBRE_SEQ:NUMBER(4):
*               TMP_WRT_NUM:VARCHAR2(12):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_REG_MEMODAO  extends SuperToDB{

  private String default_fields[]={ "MEMO_SEQ" , "MEMO_CONT" , "WRT_DT" , "UPD_DT" , "INS_DT" , "CHGBRE_SEQ" , "TMP_WRT_NUM" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_REG_MEMOEntity) == false){
        throw new  SQLException("DAO ����(1): PT_R_REG_MEMO : insert() ");
    }
    PT_R_REG_MEMOEntity entity = (PT_R_REG_MEMOEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_REG_MEMO ")
    .append(" ( MEMO_SEQ,MEMO_CONT,WRT_DT,UPD_DT,INS_DT,CHGBRE_SEQ,TMP_WRT_NUM ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getMEMO_SEQ()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			.append(",")
           .append(toDB(entity.getWRT_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getCHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			
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


    if((obj instanceof PT_R_REG_MEMOEntity) == false){
        throw new  SQLException("DAO ����(1): PT_R_REG_MEMO : update() ");
    }
    PT_R_REG_MEMOEntity entity = (PT_R_REG_MEMOEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_REG_MEMO  set ")
       
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT())).append(",")
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and MEMO_SEQ = ").append( toDB(entity.getMEMO_SEQ()));
         
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
  //������ �ʵ常�� �����Ѵ�.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_REG_MEMOEntity) == false){
        throw new  SQLException("DAO ����(1): PT_R_REG_MEMO : updateModifiedOnly() ");
    }
    PT_R_REG_MEMOEntity entity = (PT_R_REG_MEMOEntity)obj;

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
    sb.append("update PT_R_REG_MEMO  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and MEMO_SEQ = ").append(toDB(entity.getMEMO_SEQ()));
     
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
  //Ư���ʵ带 ������ ��ü �ʵ带 �����Ѵ�.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_REG_MEMOEntity) == false){
        throw new  SQLException("DAO ����(1): PT_R_REG_MEMO : updateModifiedOnly() ");
    }
    PT_R_REG_MEMOEntity entity = (PT_R_REG_MEMOEntity)obj;

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
    sb.append("update PT_R_REG_MEMO  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and MEMO_SEQ = ").append(toDB(entity.getMEMO_SEQ()));
     
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

    if((obj instanceof PT_R_REG_MEMOEntity) == false){
        throw new  SQLException("DAO ����(1): PT_R_REG_MEMO : delete() ");
    }
    PT_R_REG_MEMOEntity entity = (PT_R_REG_MEMOEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_REG_MEMO  where  1=1")
      
	  .append(" and MEMO_SEQ = ").append(toDB(entity.getMEMO_SEQ()))
      
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
