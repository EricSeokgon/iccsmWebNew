


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_HMS_MST
*  테이블 설명 :
*  테이블 PK   :
*               MENU_ID
*  테이블 컬럼 :
*               MENU_ID:VARCHAR2(32):
*               L_MENU_CD:VARCHAR2(64):
*               M_MENU_CD:VARCHAR2(64):
*               S_MENU_CD:VARCHAR2(64):
*               TITLE:VARCHAR2(32):
*               URL:VARCHAR2(64):
*               WRT_ID:VARCHAR2(16):
*               WRT_NM:VARCHAR2(16):
*               UDP_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_HMS_MSTDAO  extends SuperToDB{

  private String default_fields[]={ "MENU_ID" , "L_MENU_CD" , "M_MENU_CD" , "S_MENU_CD" , "TITLE" , "URL" , "WRT_ID" , "WRT_NM" , "UDP_DT" , "INS_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_HMS_MSTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HMS_MST : insert() ");
    }
    PT_HMS_MSTEntity entity = (PT_HMS_MSTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_HMS_MST ")
    .append(" ( MENU_ID,L_MENU_CD,M_MENU_CD,S_MENU_CD,TITLE,URL,WRT_ID,WRT_NM,UDP_DT,INS_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getMENU_ID()))
			.append(",")
           .append(toDB(entity.getL_MENU_CD()))
			.append(",")
           .append(toDB(entity.getM_MENU_CD()))
			.append(",")
           .append(toDB(entity.getS_MENU_CD()))
			.append(",")
           .append(toDB(entity.getTITLE()))
			.append(",")
           .append(toDB(entity.getURL()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getWRT_NM()))
			.append(",")
           .append(toDB(entity.getUDP_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			
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


    if((obj instanceof PT_HMS_MSTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HMS_MST : update() ");
    }
    PT_HMS_MSTEntity entity = (PT_HMS_MSTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_HMS_MST  set ")
       
        .append("L_MENU_CD = ")
        .append(toDB(entity.getL_MENU_CD())).append(",")
        .append("M_MENU_CD = ")
        .append(toDB(entity.getM_MENU_CD())).append(",")
        .append("S_MENU_CD = ")
        .append(toDB(entity.getS_MENU_CD())).append(",")
        .append("TITLE = ")
        .append(toDB(entity.getTITLE())).append(",")
        .append("URL = ")
        .append(toDB(entity.getURL())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("WRT_NM = ")
        .append(toDB(entity.getWRT_NM())).append(",")
        .append("UDP_DT = ")
        .append(toDB(entity.getUDP_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and MENU_ID = ").append( toDB(entity.getMENU_ID()));
         

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



    if((obj instanceof PT_HMS_MSTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HMS_MST : updateModifiedOnly() ");
    }
    PT_HMS_MSTEntity entity = (PT_HMS_MSTEntity)obj;

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
    sb.append("update PT_HMS_MST  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and MENU_ID = ").append(toDB(entity.getMENU_ID()));
     

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

    if((obj instanceof PT_HMS_MSTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HMS_MST : updateModifiedOnly() ");
    }
    PT_HMS_MSTEntity entity = (PT_HMS_MSTEntity)obj;

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
    sb.append("update PT_HMS_MST  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and MENU_ID = ").append(toDB(entity.getMENU_ID()));
     

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

    if((obj instanceof PT_HMS_MSTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HMS_MST : delete() ");
    }
    PT_HMS_MSTEntity entity = (PT_HMS_MSTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_HMS_MST  where  1=1")
      
	  .append(" and MENU_ID = ").append(toDB(entity.getMENU_ID()))
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
