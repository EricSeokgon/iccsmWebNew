


/*
*  Automatic generated  source
*  ��  ��  �� : ����
*
*  ���̺� ��   :PT_C_RES_MOBILE_PHONE
*  ���̺� ���� :
*  ���̺� PK   :
*               SEQ
*  ���̺� �÷� :
*               SEQ:NUMBER(4):
*               ORG_NM:VARCHAR2(52):
*               SIDO_CODE:VARCHAR2(5):
*               SKT_QTT:NUMBER(10):
*               SKT_AOM:NUMBER(20):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(12):
*               SIGUNGU_CODE:VARCHAR2(5):
*               KTF_QTT:NUMBER(10):
*               KTF_AOM:NUMBER(20):
*               LGT_QTT:NUMBER(10):
*               LGT_AOM:NUMBER(20):
*               QTT_010:NUMBER(10):
*               AOM_010:NUMBER(20):
*               WATT:VARCHAR2(12):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_C_RES_MOBILE_PHONEDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "ORG_NM" , "SIDO_CODE" , "SKT_QTT" , "SKT_AOM" , "INS_DT" , "UPD_DT" , "WRT_ID" , "SIGUNGU_CODE" , "KTF_QTT" , "KTF_AOM" , "LGT_QTT" , "LGT_AOM" , "QTT_010" , "AOM_010" , "WATT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_C_RES_MOBILE_PHONEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_C_RES_MOBILE_PHONE : insert() ");
    }
    PT_C_RES_MOBILE_PHONEEntity entity = (PT_C_RES_MOBILE_PHONEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_C_RES_MOBILE_PHONE ")
    .append(" ( SEQ,ORG_NM,SIDO_CODE,SKT_QTT,SKT_AOM,INS_DT,UPD_DT,WRT_ID,SIGUNGU_CODE,KTF_QTT,KTF_AOM,LGT_QTT,LGT_AOM,QTT_010,AOM_010,WATT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getORG_NM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSKT_QTT()))
			.append(",")
           .append(toDB(entity.getSKT_AOM()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getKTF_QTT()))
			.append(",")
           .append(toDB(entity.getKTF_AOM()))
			.append(",")
           .append(toDB(entity.getLGT_QTT()))
			.append(",")
           .append(toDB(entity.getLGT_AOM()))
			.append(",")
           .append(toDB(entity.getQTT_010()))
			.append(",")
           .append(toDB(entity.getAOM_010()))
			.append(",")
           .append(toDB(entity.getWATT()))
			
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


    if((obj instanceof PT_C_RES_MOBILE_PHONEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_C_RES_MOBILE_PHONE : update() ");
    }
    PT_C_RES_MOBILE_PHONEEntity entity = (PT_C_RES_MOBILE_PHONEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_C_RES_MOBILE_PHONE  set ")
       
        .append("ORG_NM = ")
        .append(toDB(entity.getORG_NM())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("SKT_QTT = ")
        .append(toDB(entity.getSKT_QTT())).append(",")
        .append("SKT_AOM = ")
        .append(toDB(entity.getSKT_AOM())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE())).append(",")
        .append("KTF_QTT = ")
        .append(toDB(entity.getKTF_QTT())).append(",")
        .append("KTF_AOM = ")
        .append(toDB(entity.getKTF_AOM())).append(",")
        .append("LGT_QTT = ")
        .append(toDB(entity.getLGT_QTT())).append(",")
        .append("LGT_AOM = ")
        .append(toDB(entity.getLGT_AOM())).append(",")
        .append("QTT_010 = ")
        .append(toDB(entity.getQTT_010())).append(",")
        .append("AOM_010 = ")
        .append(toDB(entity.getAOM_010())).append(",")
        .append("WATT = ")
        .append(toDB(entity.getWATT()))
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



    if((obj instanceof PT_C_RES_MOBILE_PHONEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_C_RES_MOBILE_PHONE : updateModifiedOnly() ");
    }
    PT_C_RES_MOBILE_PHONEEntity entity = (PT_C_RES_MOBILE_PHONEEntity)obj;

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
    sb.append("update PT_C_RES_MOBILE_PHONE  set " )
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

    if((obj instanceof PT_C_RES_MOBILE_PHONEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_C_RES_MOBILE_PHONE : updateModifiedOnly() ");
    }
    PT_C_RES_MOBILE_PHONEEntity entity = (PT_C_RES_MOBILE_PHONEEntity)obj;

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
    sb.append("update PT_C_RES_MOBILE_PHONE  set " )
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

    if((obj instanceof PT_C_RES_MOBILE_PHONEEntity) == false){
        throw new  SQLException("DAO ����(1): PT_C_RES_MOBILE_PHONE : delete() ");
    }
    PT_C_RES_MOBILE_PHONEEntity entity = (PT_C_RES_MOBILE_PHONEEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_C_RES_MOBILE_PHONE  where  1=1")
      
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
