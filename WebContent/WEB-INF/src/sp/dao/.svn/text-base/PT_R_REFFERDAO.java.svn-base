


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_REFFER
*  테이블 설명 :
*  테이블 PK   :
*               SEQ
*               TMP_WRT_NUM
*  테이블 컬럼 :
*               SEQ:VARCHAR2(3):
*               TMP_WRT_NUM:VARCHAR2(12):
*               SI_DO_CODE:VARCHAR2(4):
*               SI_GUN_GU_CODE:VARCHAR2(4):
*               POS_CLASS:VARCHAR2(6):
*               ENT_DT:VARCHAR2(8):
*               RET_DT:VARCHAR2(8):
*               NM_KOR:VARCHAR2(20):
*               NM_HAN:VARCHAR2(20):
*               ORI:VARCHAR2(200):
*               ADDR:VARCHAR2(200):
*               SSN1:VARCHAR2(18):
*               SSN2:VARCHAR2(21):
*               HEFA:VARCHAR2(10):
*               HEFA_RELA:VARCHAR2(10):
*               REMARK:VARCHAR2(256):
*               CHAR_REF_YN:VARCHAR2(2):
*               WRT_ID:VARCHAR2(16):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               SEND_YN:VARCHAR2(1):
*               FOREIGN_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_REFFERDAO  extends SuperToDB{

  private String default_fields[]={ "SEQ" , "TMP_WRT_NUM" , "SI_DO_CODE" , "SI_GUN_GU_CODE" , "POS_CLASS" , "ENT_DT" , "RET_DT" , "NM_KOR" , "NM_HAN" , "ORI" , "ADDR" , "SSN1" , "SSN2" , "HEFA" , "HEFA_RELA" , "REMARK" , "CHAR_REF_YN" , "WRT_ID" , "INS_DT" , "UPD_DT" , "SEND_YN" , "FOREIGN_YN" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : insert() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_REFFER ")
    .append(" ( SEQ,TMP_WRT_NUM,SI_DO_CODE,SI_GUN_GU_CODE,POS_CLASS,ENT_DT,RET_DT,NM_KOR,NM_HAN,ORI,ADDR,SSN1,SSN2,HEFA,HEFA_RELA,REMARK,CHAR_REF_YN,WRT_ID,INS_DT,UPD_DT,SEND_YN,FOREIGN_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getSI_DO_CODE()))
			.append(",")
           .append(toDB(entity.getSI_GUN_GU_CODE()))
			.append(",")
           .append(toDB(entity.getPOS_CLASS()))
			.append(",")
           .append(toDB(entity.getENT_DT()))
			.append(",")
           .append(toDB(entity.getRET_DT()))
			.append(",")
           .append(toDB(entity.getNM_KOR()))
			.append(",")
           .append(toDB(entity.getNM_HAN()))
			.append(",")
           .append(toDB(entity.getORI()))
			.append(",")
           .append(toDB(entity.getADDR()))
			.append(",")
           .append(toDB(entity.getSSN1()))
			.append(",")
           .append(toDB(entity.getSSN2()))
			.append(",")
           .append(toDB(entity.getHEFA()))
			.append(",")
           .append(toDB(entity.getHEFA_RELA()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getCHAR_REF_YN()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSEND_YN()))
			.append(",")
           .append(toDB(entity.getFOREIGN_YN()))
			
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

    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : insert() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_REFFER ")
    .append(" ( SEQ,TMP_WRT_NUM,SI_DO_CODE,SI_GUN_GU_CODE,POS_CLASS,ENT_DT,RET_DT,NM_KOR,NM_HAN,ORI,ADDR,SSN1,SSN2,HEFA,HEFA_RELA,REMARK,CHAR_REF_YN,WRT_ID,INS_DT,UPD_DT,SEND_YN,FOREIGN_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getSEQ()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getSI_DO_CODE()))
			.append(",")
           .append(toDB(entity.getSI_GUN_GU_CODE()))
			.append(",")
           .append(toDB(entity.getPOS_CLASS()))
			.append(",")
           .append(toDB(entity.getENT_DT()))
			.append(",")
           .append(toDB(entity.getRET_DT()))
			.append(",")
           .append(toDB(entity.getNM_KOR()))
			.append(",")
           .append(toDB(entity.getNM_HAN()))
			.append(",")
           .append(toDB(entity.getORI()))
			.append(",")
           .append(toDB(entity.getADDR()))
			.append(",")
           .append(toDB(entity.getSSN1()))
			.append(",")
           .append(toDB(entity.getSSN2()))
			.append(",")
           .append(toDB(entity.getHEFA()))
			.append(",")
           .append(toDB(entity.getHEFA_RELA()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getCHAR_REF_YN()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getSEND_YN()))
			.append(",")
           .append(toDB(entity.getFOREIGN_YN()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : update() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_REFFER  set ")
       
        .append("SI_DO_CODE = ")
        .append(toDB(entity.getSI_DO_CODE())).append(",")
        .append("SI_GUN_GU_CODE = ")
        .append(toDB(entity.getSI_GUN_GU_CODE())).append(",")
        .append("POS_CLASS = ")
        .append(toDB(entity.getPOS_CLASS())).append(",")
        .append("ENT_DT = ")
        .append(toDB(entity.getENT_DT())).append(",")
        .append("RET_DT = ")
        .append(toDB(entity.getRET_DT())).append(",")
        .append("NM_KOR = ")
        .append(toDB(entity.getNM_KOR())).append(",")
        .append("NM_HAN = ")
        .append(toDB(entity.getNM_HAN())).append(",")
        .append("ORI = ")
        .append(toDB(entity.getORI())).append(",")
        .append("ADDR = ")
        .append(toDB(entity.getADDR())).append(",")
        .append("SSN1 = ")
        .append(toDB(entity.getSSN1())).append(",")
        .append("SSN2 = ")
        .append(toDB(entity.getSSN2())).append(",")
        .append("HEFA = ")
        .append(toDB(entity.getHEFA())).append(",")
        .append("HEFA_RELA = ")
        .append(toDB(entity.getHEFA_RELA())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("CHAR_REF_YN = ")
        .append(toDB(entity.getCHAR_REF_YN())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("SEND_YN = ")
        .append(toDB(entity.getSEND_YN())).append(",")
        .append("FOREIGN_YN = ")
        .append(toDB(entity.getFOREIGN_YN()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
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


  public String  updateSql( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : update() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_REFFER  set ")
       
        .append("SI_DO_CODE = ")
        .append(toDB(entity.getSI_DO_CODE())).append(",")
        .append("SI_GUN_GU_CODE = ")
        .append(toDB(entity.getSI_GUN_GU_CODE())).append(",")
        .append("POS_CLASS = ")
        .append(toDB(entity.getPOS_CLASS())).append(",")
        .append("ENT_DT = ")
        .append(toDB(entity.getENT_DT())).append(",")
        .append("RET_DT = ")
        .append(toDB(entity.getRET_DT())).append(",")
        .append("NM_KOR = ")
        .append(toDB(entity.getNM_KOR())).append(",")
        .append("NM_HAN = ")
        .append(toDB(entity.getNM_HAN())).append(",")
        .append("ORI = ")
        .append(toDB(entity.getORI())).append(",")
        .append("ADDR = ")
        .append(toDB(entity.getADDR())).append(",")
        .append("SSN1 = ")
        .append(toDB(entity.getSSN1())).append(",")
        .append("SSN2 = ")
        .append(toDB(entity.getSSN2())).append(",")
        .append("HEFA = ")
        .append(toDB(entity.getHEFA())).append(",")
        .append("HEFA_RELA = ")
        .append(toDB(entity.getHEFA_RELA())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("CHAR_REF_YN = ")
        .append(toDB(entity.getCHAR_REF_YN())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("SEND_YN = ")
        .append(toDB(entity.getSEND_YN())).append(",")
        .append("FOREIGN_YN = ")
        .append(toDB(entity.getFOREIGN_YN()))
        .append(" where  1=1 ");
       
         sb.append(" and SEQ = ").append( toDB(entity.getSEQ()));
         
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : updateModifiedOnly() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;

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
    sb.append("update PT_R_REFFER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
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




  public String updateModifiedOnlySql(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : updateModifiedOnly() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;


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
    sb.append("update PT_R_REFFER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : updateModifiedOnly() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;

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
    sb.append("update PT_R_REFFER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
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
  
  
   public String updateExcludeOnlySql(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : updateModifiedOnly() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;


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
    sb.append("update PT_R_REFFER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and SEQ = ").append(toDB(entity.getSEQ()));
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : delete() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_REFFER  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
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

  public String deleteSql(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_REFFEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_REFFER : delete() ");
    }
    PT_R_REFFEREntity entity = (PT_R_REFFEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_REFFER  where  1=1")
      
	  .append(" and SEQ = ").append(toDB(entity.getSEQ()))
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
