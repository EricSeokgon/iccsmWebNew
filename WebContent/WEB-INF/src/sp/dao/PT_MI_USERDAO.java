


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_MI_USER
*  테이블 설명 :
*  테이블 PK   :
*               OFFI_ID
*  테이블 컬럼 :
*               OFFI_ID:VARCHAR2(16):
*               NM:VARCHAR2(40):
*               TEL:VARCHAR2(16):
*               SIDO_CODE:VARCHAR2(10):
*               SIGUNGU_CODE:VARCHAR2(10):
*               PART:VARCHAR2(50):
*               POS:VARCHAR2(20):
*               GROUP_CODE:VARCHAR2(5):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               PASS:VARCHAR2(16):
*               HOME_GROUP:VARCHAR2(5):
*               MOBILE:VARCHAR2(16):
*               E_MAIL:VARCHAR2(128):
*               OFFSEAL:VARCHAR2(26):
*               TEL1:VARCHAR2(20):
*               TEL2:VARCHAR2(20):
*               TEL3:VARCHAR2(20):
*               MOBILE1:VARCHAR2(20):
*               MOBILE2:VARCHAR2(20):
*               MOBILE3:VARCHAR2(20):
*               PHOTO:VARCHAR2(26):
*               FAX1:VARCHAR2(20):
*               FAX2:VARCHAR2(20):
*               FAX3:VARCHAR2(20):
*               FAX:VARCHAR2(20):
*               RECV_ID:VARCHAR2(40):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_MI_USERDAO  extends SuperToDB{

  private String default_fields[]={ "OFFI_ID" , "NM" , "TEL" , "SIDO_CODE" , "SIGUNGU_CODE" , "PART" , "POS" , "GROUP_CODE" , "WRT_ID" , "INS_DT" , "UPD_DT" , "PASS" , "HOME_GROUP" , "MOBILE" , "E_MAIL" , "OFFSEAL" , "TEL1" , "TEL2" , "TEL3" , "MOBILE1" , "MOBILE2" , "MOBILE3" , "PHOTO" , "FAX1" , "FAX2" , "FAX3" , "FAX" , "RECV_ID" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : insert() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_MI_USER ")
    .append(" ( OFFI_ID,NM,TEL,SIDO_CODE,SIGUNGU_CODE,PART,POS,GROUP_CODE,WRT_ID,INS_DT,UPD_DT,PASS,HOME_GROUP,MOBILE,E_MAIL,OFFSEAL,TEL1,TEL2,TEL3,MOBILE1,MOBILE2,MOBILE3,PHOTO,FAX1,FAX2,FAX3,FAX,RECV_ID ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getOFFI_ID()))
			.append(",")
           .append(toDB(entity.getNM()))
			.append(",")
           .append(toDB(entity.getTEL()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getPART()))
			.append(",")
           .append(toDB(entity.getPOS()))
			.append(",")
           .append(toDB(entity.getGROUP_CODE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getPASS()))
			.append(",")
           .append(toDB(entity.getHOME_GROUP()))
			.append(",")
           .append(toDB(entity.getMOBILE()))
			.append(",")
           .append(toDB(entity.getE_MAIL()))
			.append(",")
           .append(toDB(entity.getOFFSEAL()))
			.append(",")
           .append(toDB(entity.getTEL1()))
			.append(",")
           .append(toDB(entity.getTEL2()))
			.append(",")
           .append(toDB(entity.getTEL3()))
			.append(",")
           .append(toDB(entity.getMOBILE1()))
			.append(",")
           .append(toDB(entity.getMOBILE2()))
			.append(",")
           .append(toDB(entity.getMOBILE3()))
			.append(",")
           .append(toDB(entity.getPHOTO()))
			.append(",")
           .append(toDB(entity.getFAX1()))
			.append(",")
           .append(toDB(entity.getFAX2()))
			.append(",")
           .append(toDB(entity.getFAX3()))
			.append(",")
           .append(toDB(entity.getFAX()))
			.append(",")
           .append(toDB(entity.getRECV_ID()))
			
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

    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : insert() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_MI_USER ")
    .append(" ( OFFI_ID,NM,TEL,SIDO_CODE,SIGUNGU_CODE,PART,POS,GROUP_CODE,WRT_ID,INS_DT,UPD_DT,PASS,HOME_GROUP,MOBILE,E_MAIL,OFFSEAL,TEL1,TEL2,TEL3,MOBILE1,MOBILE2,MOBILE3,PHOTO,FAX1,FAX2,FAX3,FAX,RECV_ID ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getOFFI_ID()))
			.append(",")
           .append(toDB(entity.getNM()))
			.append(",")
           .append(toDB(entity.getTEL()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getPART()))
			.append(",")
           .append(toDB(entity.getPOS()))
			.append(",")
           .append(toDB(entity.getGROUP_CODE()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getPASS()))
			.append(",")
           .append(toDB(entity.getHOME_GROUP()))
			.append(",")
           .append(toDB(entity.getMOBILE()))
			.append(",")
           .append(toDB(entity.getE_MAIL()))
			.append(",")
           .append(toDB(entity.getOFFSEAL()))
			.append(",")
           .append(toDB(entity.getTEL1()))
			.append(",")
           .append(toDB(entity.getTEL2()))
			.append(",")
           .append(toDB(entity.getTEL3()))
			.append(",")
           .append(toDB(entity.getMOBILE1()))
			.append(",")
           .append(toDB(entity.getMOBILE2()))
			.append(",")
           .append(toDB(entity.getMOBILE3()))
			.append(",")
           .append(toDB(entity.getPHOTO()))
			.append(",")
           .append(toDB(entity.getFAX1()))
			.append(",")
           .append(toDB(entity.getFAX2()))
			.append(",")
           .append(toDB(entity.getFAX3()))
			.append(",")
           .append(toDB(entity.getFAX()))
			.append(",")
           .append(toDB(entity.getRECV_ID()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : update() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_MI_USER  set ")
       
        .append("NM = ")
        .append(toDB(entity.getNM())).append(",")
        .append("TEL = ")
        .append(toDB(entity.getTEL())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE())).append(",")
        .append("PART = ")
        .append(toDB(entity.getPART())).append(",")
        .append("POS = ")
        .append(toDB(entity.getPOS())).append(",")
        .append("GROUP_CODE = ")
        .append(toDB(entity.getGROUP_CODE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("PASS = ")
        .append(toDB(entity.getPASS())).append(",")
        .append("HOME_GROUP = ")
        .append(toDB(entity.getHOME_GROUP())).append(",")
        .append("MOBILE = ")
        .append(toDB(entity.getMOBILE())).append(",")
        .append("E_MAIL = ")
        .append(toDB(entity.getE_MAIL())).append(",")
        .append("OFFSEAL = ")
        .append(toDB(entity.getOFFSEAL())).append(",")
        .append("TEL1 = ")
        .append(toDB(entity.getTEL1())).append(",")
        .append("TEL2 = ")
        .append(toDB(entity.getTEL2())).append(",")
        .append("TEL3 = ")
        .append(toDB(entity.getTEL3())).append(",")
        .append("MOBILE1 = ")
        .append(toDB(entity.getMOBILE1())).append(",")
        .append("MOBILE2 = ")
        .append(toDB(entity.getMOBILE2())).append(",")
        .append("MOBILE3 = ")
        .append(toDB(entity.getMOBILE3())).append(",")
        .append("PHOTO = ")
        .append(toDB(entity.getPHOTO())).append(",")
        .append("FAX1 = ")
        .append(toDB(entity.getFAX1())).append(",")
        .append("FAX2 = ")
        .append(toDB(entity.getFAX2())).append(",")
        .append("FAX3 = ")
        .append(toDB(entity.getFAX3())).append(",")
        .append("FAX = ")
        .append(toDB(entity.getFAX())).append(",")
        .append("RECV_ID = ")
        .append(toDB(entity.getRECV_ID()))
        .append(" where  1=1 ");
       
         sb.append(" and OFFI_ID = ").append( toDB(entity.getOFFI_ID()));
         

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


    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : update() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_MI_USER  set ")
       
        .append("NM = ")
        .append(toDB(entity.getNM())).append(",")
        .append("TEL = ")
        .append(toDB(entity.getTEL())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("SIGUNGU_CODE = ")
        .append(toDB(entity.getSIGUNGU_CODE())).append(",")
        .append("PART = ")
        .append(toDB(entity.getPART())).append(",")
        .append("POS = ")
        .append(toDB(entity.getPOS())).append(",")
        .append("GROUP_CODE = ")
        .append(toDB(entity.getGROUP_CODE())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("PASS = ")
        .append(toDB(entity.getPASS())).append(",")
        .append("HOME_GROUP = ")
        .append(toDB(entity.getHOME_GROUP())).append(",")
        .append("MOBILE = ")
        .append(toDB(entity.getMOBILE())).append(",")
        .append("E_MAIL = ")
        .append(toDB(entity.getE_MAIL())).append(",")
        .append("OFFSEAL = ")
        .append(toDB(entity.getOFFSEAL())).append(",")
        .append("TEL1 = ")
        .append(toDB(entity.getTEL1())).append(",")
        .append("TEL2 = ")
        .append(toDB(entity.getTEL2())).append(",")
        .append("TEL3 = ")
        .append(toDB(entity.getTEL3())).append(",")
        .append("MOBILE1 = ")
        .append(toDB(entity.getMOBILE1())).append(",")
        .append("MOBILE2 = ")
        .append(toDB(entity.getMOBILE2())).append(",")
        .append("MOBILE3 = ")
        .append(toDB(entity.getMOBILE3())).append(",")
        .append("PHOTO = ")
        .append(toDB(entity.getPHOTO())).append(",")
        .append("FAX1 = ")
        .append(toDB(entity.getFAX1())).append(",")
        .append("FAX2 = ")
        .append(toDB(entity.getFAX2())).append(",")
        .append("FAX3 = ")
        .append(toDB(entity.getFAX3())).append(",")
        .append("FAX = ")
        .append(toDB(entity.getFAX())).append(",")
        .append("RECV_ID = ")
        .append(toDB(entity.getRECV_ID()))
        .append(" where  1=1 ");
       
         sb.append(" and OFFI_ID = ").append( toDB(entity.getOFFI_ID()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : updateModifiedOnly() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;

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
    sb.append("update PT_MI_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and OFFI_ID = ").append(toDB(entity.getOFFI_ID()));
     

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



    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : updateModifiedOnly() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;


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
    sb.append("update PT_MI_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and OFFI_ID = ").append(toDB(entity.getOFFI_ID()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : updateModifiedOnly() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;

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
    sb.append("update PT_MI_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and OFFI_ID = ").append(toDB(entity.getOFFI_ID()));
     

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

    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : updateModifiedOnly() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;


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
    sb.append("update PT_MI_USER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and OFFI_ID = ").append(toDB(entity.getOFFI_ID()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : delete() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_MI_USER  where  1=1")
      
	  .append(" and OFFI_ID = ").append(toDB(entity.getOFFI_ID()))
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

    if((obj instanceof PT_MI_USEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_MI_USER : delete() ");
    }
    PT_MI_USEREntity entity = (PT_MI_USEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_MI_USER  where  1=1")
      
	  .append(" and OFFI_ID = ").append(toDB(entity.getOFFI_ID()))
       ;


   return sb.toString();
  }


}//Class End
