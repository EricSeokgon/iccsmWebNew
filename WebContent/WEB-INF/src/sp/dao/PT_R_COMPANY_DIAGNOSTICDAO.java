


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_COMPANY_DIAGNOSTIC
*  테이블 설명 :
*  테이블 PK   :
*               CHGBRE_SEQ
*               TMP_WRT_NUM
*  테이블 컬럼 :
*               CHGBRE_SEQ:VARCHAR2(4):
*               TMP_WRT_NUM:VARCHAR2(12):
*               DIAG_ORG_CODE:VARCHAR2(6):
*               PAY_CAP:VARCHAR2(15):
*               REA_CAP:VARCHAR2(15):
*               TUP_AOM:VARCHAR2(15):
*               TUP_CLASS_CODE:VARCHAR2(6):
*               COMPANY_DIAG_CLASS_CODE:VARCHAR2(6):
*               COMPANY_DIAG_BASDT:VARCHAR2(8):
*               COMPANY_DIAG_ISSUEDT:VARCHAR2(8):
*               DIAG_NM_NM:VARCHAR2(20):
*               DIAG_NM_WRT_NUM:VARCHAR2(12):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_COMPANY_DIAGNOSTICDAO  extends SuperToDB{

  private String default_fields[]={ "CHGBRE_SEQ" , "TMP_WRT_NUM" , "DIAG_ORG_CODE" , "PAY_CAP" , "REA_CAP" , "TUP_AOM" , "TUP_CLASS_CODE" , "COMPANY_DIAG_CLASS_CODE" , "COMPANY_DIAG_BASDT" , "COMPANY_DIAG_ISSUEDT" , "DIAG_NM_NM" , "DIAG_NM_WRT_NUM" , "WRT_ID" , "UPD_DT" , "INS_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_COMPANY_DIAGNOSTICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_COMPANY_DIAGNOSTIC : insert() ");
    }
    PT_R_COMPANY_DIAGNOSTICEntity entity = (PT_R_COMPANY_DIAGNOSTICEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_COMPANY_DIAGNOSTIC ")
    .append(" ( CHGBRE_SEQ,TMP_WRT_NUM,DIAG_ORG_CODE,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BASDT,COMPANY_DIAG_ISSUEDT,DIAG_NM_NM,DIAG_NM_WRT_NUM,WRT_ID,UPD_DT,INS_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCHGBRE_SEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getDIAG_ORG_CODE()))
			.append(",")
           .append(toDB(entity.getPAY_CAP()))
			.append(",")
           .append(toDB(entity.getREA_CAP()))
			.append(",")
           .append(toDB(entity.getTUP_AOM()))
			.append(",")
           .append(toDB(entity.getTUP_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_CLASS_CODE()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_BASDT()))
			.append(",")
           .append(toDB(entity.getCOMPANY_DIAG_ISSUEDT()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_NM()))
			.append(",")
           .append(toDB(entity.getDIAG_NM_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
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


    if((obj instanceof PT_R_COMPANY_DIAGNOSTICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_COMPANY_DIAGNOSTIC : update() ");
    }
    PT_R_COMPANY_DIAGNOSTICEntity entity = (PT_R_COMPANY_DIAGNOSTICEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_COMPANY_DIAGNOSTIC  set ")
       
        .append("DIAG_ORG_CODE = ")
        .append(toDB(entity.getDIAG_ORG_CODE())).append(",")
        .append("PAY_CAP = ")
        .append(toDB(entity.getPAY_CAP())).append(",")
        .append("REA_CAP = ")
        .append(toDB(entity.getREA_CAP())).append(",")
        .append("TUP_AOM = ")
        .append(toDB(entity.getTUP_AOM())).append(",")
        .append("TUP_CLASS_CODE = ")
        .append(toDB(entity.getTUP_CLASS_CODE())).append(",")
        .append("COMPANY_DIAG_CLASS_CODE = ")
        .append(toDB(entity.getCOMPANY_DIAG_CLASS_CODE())).append(",")
        .append("COMPANY_DIAG_BASDT = ")
        .append(toDB(entity.getCOMPANY_DIAG_BASDT())).append(",")
        .append("COMPANY_DIAG_ISSUEDT = ")
        .append(toDB(entity.getCOMPANY_DIAG_ISSUEDT())).append(",")
        .append("DIAG_NM_NM = ")
        .append(toDB(entity.getDIAG_NM_NM())).append(",")
        .append("DIAG_NM_WRT_NUM = ")
        .append(toDB(entity.getDIAG_NM_WRT_NUM())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT()))
        .append(" where  1=1 ");
       
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
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_COMPANY_DIAGNOSTICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_COMPANY_DIAGNOSTIC : updateModifiedOnly() ");
    }
    PT_R_COMPANY_DIAGNOSTICEntity entity = (PT_R_COMPANY_DIAGNOSTICEntity)obj;

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
    sb.append("update PT_R_COMPANY_DIAGNOSTIC  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_COMPANY_DIAGNOSTICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_COMPANY_DIAGNOSTIC : updateModifiedOnly() ");
    }
    PT_R_COMPANY_DIAGNOSTICEntity entity = (PT_R_COMPANY_DIAGNOSTICEntity)obj;

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
    sb.append("update PT_R_COMPANY_DIAGNOSTIC  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
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

    if((obj instanceof PT_R_COMPANY_DIAGNOSTICEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_COMPANY_DIAGNOSTIC : delete() ");
    }
    PT_R_COMPANY_DIAGNOSTICEntity entity = (PT_R_COMPANY_DIAGNOSTICEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_COMPANY_DIAGNOSTIC  where  1=1")
      
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
