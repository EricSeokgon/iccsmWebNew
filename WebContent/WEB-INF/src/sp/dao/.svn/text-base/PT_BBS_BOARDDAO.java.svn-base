


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_BBS_BOARD
*  테이블 설명 :
*  테이블 PK   :
*               INDEX1
*               INDEX2
*  테이블 컬럼 :
*               CT_ID:VARCHAR2(16):
*               BOARD_SEQ:NUMBER(22):
*               INDEX1:NUMBER(22):
*               INDEX2:NUMBER(22):
*               DEPTH:NUMBER(22):
*               SD_CD:VARCHAR2(4):
*               SGG_CD:VARCHAR2(4):
*               USER_ID:VARCHAR2(16):
*               USER_NAME:VARCHAR2(50):
*               USER_EMAIL:VARCHAR2(100):
*               USER_PASS:VARCHAR2(16):
*               USER_IP:VARCHAR2(18):
*               USER_TEL:VARCHAR2(14):
*               USER_HOMEPAGE:VARCHAR2(255):
*               SUBJECT:VARCHAR2(200):
*               CONTENT:CLOB:
*               REPLIED_YN:VARCHAR2(1):
*               SECRET_YN:VARCHAR2(1):
*               NOTICE_YN:VARCHAR2(1):
*               READ_NUM:NUMBER(22):
*               UPD_DT:VARCHAR2(23):
*               INS_DT:VARCHAR2(23):
*               WRT_ID:VARCHAR2(16):
*               ETC_1:VARCHAR2(255):
*               ETC_2:VARCHAR2(255):
*               ETC_3:VARCHAR2(255):
*               ETC_4:VARCHAR2(255):
*               ETC_5:VARCHAR2(255):
*               ETC_6:VARCHAR2(255):
*               ETC_7:VARCHAR2(255):
*               ETC_8:VARCHAR2(255):
*               ETC_9:VARCHAR2(255):
*               ETC_10:VARCHAR2(255):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_BBS_BOARDDAO  extends SuperToDB{

  private String default_fields[]={ "CT_ID" , "BOARD_SEQ" , "INDEX1" , "INDEX2" , "DEPTH" , "SD_CD" , "SGG_CD" , "USER_ID" , "USER_NAME" , "USER_EMAIL" , "USER_PASS" , "USER_IP" , "USER_TEL" , "USER_HOMEPAGE" , "SUBJECT" , "CONTENT" , "REPLIED_YN" , "SECRET_YN" , "NOTICE_YN" , "READ_NUM" , "UPD_DT" , "INS_DT" , "WRT_ID" , "ETC_1" , "ETC_2" , "ETC_3" , "ETC_4" , "ETC_5" , "ETC_6" , "ETC_7" , "ETC_8" , "ETC_9" , "ETC_10" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_BBS_BOARDEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_BOARD : insert() ");
    }
    PT_BBS_BOARDEntity entity = (PT_BBS_BOARDEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_BBS_BOARD ")
    .append(" ( CT_ID,BOARD_SEQ,INDEX1,INDEX2,DEPTH,SD_CD,SGG_CD,USER_ID,USER_NAME,USER_EMAIL,USER_PASS,USER_IP,USER_TEL,USER_HOMEPAGE,SUBJECT,CONTENT,REPLIED_YN,SECRET_YN,NOTICE_YN,READ_NUM,UPD_DT,INS_DT,WRT_ID,ETC_1,ETC_2,ETC_3,ETC_4,ETC_5,ETC_6,ETC_7,ETC_8,ETC_9,ETC_10 ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCT_ID()))
			.append(",")
           .append(toDB(entity.getBOARD_SEQ()))
			.append(",")
           .append(toDB(entity.getINDEX1()))
			.append(",")
           .append(toDB(entity.getINDEX2()))
			.append(",")
           .append(toDB(entity.getDEPTH()))
			.append(",")
           .append(toDB(entity.getSD_CD()))
			.append(",")
           .append(toDB(entity.getSGG_CD()))
			.append(",")
           .append(toDB(entity.getUSER_ID()))
			.append(",")
           .append(toDB(entity.getUSER_NAME()))
			.append(",")
           .append(toDB(entity.getUSER_EMAIL()))
			.append(",")
           .append(toDB(entity.getUSER_PASS()))
			.append(",")
           .append(toDB(entity.getUSER_IP()))
			.append(",")
           .append(toDB(entity.getUSER_TEL()))
			.append(",")
           .append(toDB(entity.getUSER_HOMEPAGE()))
			.append(",")
           .append(toDB(entity.getSUBJECT()))
			.append(",")
		   .append("?")
			.append(",")
           .append(toDB(entity.getREPLIED_YN()))
			.append(",")
           .append(toDB(entity.getSECRET_YN()))
			.append(",")
           .append(toDB(entity.getNOTICE_YN()))
			.append(",")
           .append(toDB(entity.getREAD_NUM()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getETC_1()))
			.append(",")
           .append(toDB(entity.getETC_2()))
			.append(",")
           .append(toDB(entity.getETC_3()))
			.append(",")
           .append(toDB(entity.getETC_4()))
			.append(",")
           .append(toDB(entity.getETC_5()))
			.append(",")
           .append(toDB(entity.getETC_6()))
			.append(",")
           .append(toDB(entity.getETC_7()))
			.append(",")
           .append(toDB(entity.getETC_8()))
			.append(",")
           .append(toDB(entity.getETC_9()))
			.append(",")
           .append(toDB(entity.getETC_10()))
			
    .append(" ) ");

   KJFLog.sql(sb.toString());


   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

    int i=1;
	
	
	ps.setString(i++,entity.getCONTENT());
		
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


    if((obj instanceof PT_BBS_BOARDEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_BOARD : update() ");
    }
    PT_BBS_BOARDEntity entity = (PT_BBS_BOARDEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_BOARD  set ")
       
        .append("CT_ID = ")
        .append(toDB(entity.getCT_ID())).append(",")
        .append("BOARD_SEQ = ")
        .append(toDB(entity.getBOARD_SEQ())).append(",")
        .append("DEPTH = ")
        .append(toDB(entity.getDEPTH())).append(",")
        .append("SD_CD = ")
        .append(toDB(entity.getSD_CD())).append(",")
        .append("SGG_CD = ")
        .append(toDB(entity.getSGG_CD())).append(",")
        .append("USER_ID = ")
        .append(toDB(entity.getUSER_ID())).append(",")
        .append("USER_NAME = ")
        .append(toDB(entity.getUSER_NAME())).append(",")
        .append("USER_EMAIL = ")
        .append(toDB(entity.getUSER_EMAIL())).append(",")
        .append("USER_PASS = ")
        .append(toDB(entity.getUSER_PASS())).append(",")
        .append("USER_IP = ")
        .append(toDB(entity.getUSER_IP())).append(",")
        .append("USER_TEL = ")
        .append(toDB(entity.getUSER_TEL())).append(",")
        .append("USER_HOMEPAGE = ")
        .append(toDB(entity.getUSER_HOMEPAGE())).append(",")
        .append("SUBJECT = ")
        .append(toDB(entity.getSUBJECT())).append(",")
        .append("CONTENT = ")
        .append("?").append(",")
        .append("REPLIED_YN = ")
        .append(toDB(entity.getREPLIED_YN())).append(",")
        .append("SECRET_YN = ")
        .append(toDB(entity.getSECRET_YN())).append(",")
        .append("NOTICE_YN = ")
        .append(toDB(entity.getNOTICE_YN())).append(",")
        .append("READ_NUM = ")
        .append(toDB(entity.getREAD_NUM())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("ETC_1 = ")
        .append(toDB(entity.getETC_1())).append(",")
        .append("ETC_2 = ")
        .append(toDB(entity.getETC_2())).append(",")
        .append("ETC_3 = ")
        .append(toDB(entity.getETC_3())).append(",")
        .append("ETC_4 = ")
        .append(toDB(entity.getETC_4())).append(",")
        .append("ETC_5 = ")
        .append(toDB(entity.getETC_5())).append(",")
        .append("ETC_6 = ")
        .append(toDB(entity.getETC_6())).append(",")
        .append("ETC_7 = ")
        .append(toDB(entity.getETC_7())).append(",")
        .append("ETC_8 = ")
        .append(toDB(entity.getETC_8())).append(",")
        .append("ETC_9 = ")
        .append(toDB(entity.getETC_9())).append(",")
        .append("ETC_10 = ")
        .append(toDB(entity.getETC_10()))
        .append(" where  1=1 ");
       
         sb.append(" and INDEX1 = ").append( toDB(entity.getINDEX1()));
         
         sb.append(" and INDEX2 = ").append( toDB(entity.getINDEX2()));
         

   KJFLog.sql(sb.toString());

   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int i=1;
	
	
	ps.setString(i++,entity.getCONTENT());
		
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



    if((obj instanceof PT_BBS_BOARDEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_BOARD : updateModifiedOnly() ");
    }
    PT_BBS_BOARDEntity entity = (PT_BBS_BOARDEntity)obj;

	HashMap clobs = new HashMap();
	clobs.put("CONTENT","1");

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
    sb.append("update PT_BBS_BOARD  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and INDEX1 = ").append(toDB(entity.getINDEX1()));
     
	  sb.append(" and INDEX2 = ").append(toDB(entity.getINDEX2()));
     

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

    if((obj instanceof PT_BBS_BOARDEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_BOARD : updateModifiedOnly() ");
    }
    PT_BBS_BOARDEntity entity = (PT_BBS_BOARDEntity)obj;

	HashMap clobs = new HashMap();
	clobs.put("CONTENT","1");

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
    sb.append("update PT_BBS_BOARD  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and INDEX1 = ").append(toDB(entity.getINDEX1()));
     
	  sb.append(" and INDEX2 = ").append(toDB(entity.getINDEX2()));
     

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

    if((obj instanceof PT_BBS_BOARDEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_BOARD : delete() ");
    }
    PT_BBS_BOARDEntity entity = (PT_BBS_BOARDEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_BBS_BOARD  where  1=1")
      
	  .append(" and INDEX1 = ").append(toDB(entity.getINDEX1()))
      
	  .append(" and INDEX2 = ").append(toDB(entity.getINDEX2()))
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
