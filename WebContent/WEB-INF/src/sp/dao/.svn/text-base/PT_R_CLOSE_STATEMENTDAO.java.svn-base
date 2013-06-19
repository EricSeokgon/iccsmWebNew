


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_R_CLOSE_STATEMENT
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SIDO_CODE
*  테이블 컬럼 :
*               RECV_NUM:VARCHAR2(12):
*               SIDO_CODE:VARCHAR2(4):
*               COI_WRT_NUM:VARCHAR2(12):
*               RECV_DT:VARCHAR2(8):
*               OFFI_PART:VARCHAR2(50):
*               OFFI_PART_REBO_WRT_NUM:VARCHAR2(12):
*               NAME:VARCHAR2(50):
*               WRT_NUM:VARCHAR2(12):
*               REP_NM_KOR:VARCHAR2(20):
*               REP_NM_HAN:VARCHAR2(20):
*               OFF_ADDR:VARCHAR2(200):
*               TEL_NUM:VARCHAR2(17):
*               C_COM_DT:VARCHAR2(8):
*               WRT_ID:VARCHAR2(16):
*               UPD_DT:VARCHAR2(24):
*               INS_DT:VARCHAR2(24):
*               C_COM_CAUSE:VARCHAR2(256):
*               DEFI_STE:VARCHAR2(1):
*               ADDR_ADDR:VARCHAR2(120):
*               ADDR_POST_NUM:VARCHAR2(6):
*               ADDR_DETAIL_ADDR:VARCHAR2(129):
*               PROC_LIM:VARCHAR2(8):
*               MEMO_CONT:VARCHAR2(256):
*               MOT_STE:VARCHAR2(20):
*               TMP_WRT_NUM:VARCHAR2(12):
*               DOC_CODE:VARCHAR2(50):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_R_CLOSE_STATEMENTDAO  extends SuperToDB{

  private String default_fields[]={ "RECV_NUM" , "SIDO_CODE" , "COI_WRT_NUM" , "RECV_DT" , "OFFI_PART" , "OFFI_PART_REBO_WRT_NUM" , "NAME" , "WRT_NUM" , "REP_NM_KOR" , "REP_NM_HAN" , "OFF_ADDR" , "TEL_NUM" , "C_COM_DT" , "WRT_ID" , "UPD_DT" , "INS_DT" , "C_COM_CAUSE" , "DEFI_STE" , "ADDR_ADDR" , "ADDR_POST_NUM" , "ADDR_DETAIL_ADDR" , "PROC_LIM" , "MEMO_CONT" , "MOT_STE" , "TMP_WRT_NUM" , "DOC_CODE" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : insert() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_CLOSE_STATEMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,COI_WRT_NUM,RECV_DT,OFFI_PART,OFFI_PART_REBO_WRT_NUM,NAME,WRT_NUM,REP_NM_KOR,REP_NM_HAN,OFF_ADDR,TEL_NUM,C_COM_DT,WRT_ID,UPD_DT,INS_DT,C_COM_CAUSE,DEFI_STE,ADDR_ADDR,ADDR_POST_NUM,ADDR_DETAIL_ADDR,PROC_LIM,MEMO_CONT,MOT_STE,TMP_WRT_NUM,DOC_CODE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getOFFI_PART()))
			.append(",")
           .append(toDB(entity.getOFFI_PART_REBO_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getNAME()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getREP_NM_KOR()))
			.append(",")
           .append(toDB(entity.getREP_NM_HAN()))
			.append(",")
           .append(toDB(entity.getOFF_ADDR()))
			.append(",")
           .append(toDB(entity.getTEL_NUM()))
			.append(",")
           .append(toDB(entity.getC_COM_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getC_COM_CAUSE()))
			.append(",")
           .append(toDB(entity.getDEFI_STE()))
			.append(",")
           .append(toDB(entity.getADDR_ADDR()))
			.append(",")
           .append(toDB(entity.getADDR_POST_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			
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

    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : insert() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_R_CLOSE_STATEMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,COI_WRT_NUM,RECV_DT,OFFI_PART,OFFI_PART_REBO_WRT_NUM,NAME,WRT_NUM,REP_NM_KOR,REP_NM_HAN,OFF_ADDR,TEL_NUM,C_COM_DT,WRT_ID,UPD_DT,INS_DT,C_COM_CAUSE,DEFI_STE,ADDR_ADDR,ADDR_POST_NUM,ADDR_DETAIL_ADDR,PROC_LIM,MEMO_CONT,MOT_STE,TMP_WRT_NUM,DOC_CODE ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getRECV_DT()))
			.append(",")
           .append(toDB(entity.getOFFI_PART()))
			.append(",")
           .append(toDB(entity.getOFFI_PART_REBO_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getNAME()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getREP_NM_KOR()))
			.append(",")
           .append(toDB(entity.getREP_NM_HAN()))
			.append(",")
           .append(toDB(entity.getOFF_ADDR()))
			.append(",")
           .append(toDB(entity.getTEL_NUM()))
			.append(",")
           .append(toDB(entity.getC_COM_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getC_COM_CAUSE()))
			.append(",")
           .append(toDB(entity.getDEFI_STE()))
			.append(",")
           .append(toDB(entity.getADDR_ADDR()))
			.append(",")
           .append(toDB(entity.getADDR_POST_NUM()))
			.append(",")
           .append(toDB(entity.getADDR_DETAIL_ADDR()))
			.append(",")
           .append(toDB(entity.getPROC_LIM()))
			.append(",")
           .append(toDB(entity.getMEMO_CONT()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : update() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_CLOSE_STATEMENT  set ")
       
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("OFFI_PART = ")
        .append(toDB(entity.getOFFI_PART())).append(",")
        .append("OFFI_PART_REBO_WRT_NUM = ")
        .append(toDB(entity.getOFFI_PART_REBO_WRT_NUM())).append(",")
        .append("NAME = ")
        .append(toDB(entity.getNAME())).append(",")
        .append("WRT_NUM = ")
        .append(toDB(entity.getWRT_NUM())).append(",")
        .append("REP_NM_KOR = ")
        .append(toDB(entity.getREP_NM_KOR())).append(",")
        .append("REP_NM_HAN = ")
        .append(toDB(entity.getREP_NM_HAN())).append(",")
        .append("OFF_ADDR = ")
        .append(toDB(entity.getOFF_ADDR())).append(",")
        .append("TEL_NUM = ")
        .append(toDB(entity.getTEL_NUM())).append(",")
        .append("C_COM_DT = ")
        .append(toDB(entity.getC_COM_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("C_COM_CAUSE = ")
        .append(toDB(entity.getC_COM_CAUSE())).append(",")
        .append("DEFI_STE = ")
        .append(toDB(entity.getDEFI_STE())).append(",")
        .append("ADDR_ADDR = ")
        .append(toDB(entity.getADDR_ADDR())).append(",")
        .append("ADDR_POST_NUM = ")
        .append(toDB(entity.getADDR_POST_NUM())).append(",")
        .append("ADDR_DETAIL_ADDR = ")
        .append(toDB(entity.getADDR_DETAIL_ADDR())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("TMP_WRT_NUM = ")
        .append(toDB(entity.getTMP_WRT_NUM())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         

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


    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : update() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_R_CLOSE_STATEMENT  set ")
       
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM())).append(",")
        .append("RECV_DT = ")
        .append(toDB(entity.getRECV_DT())).append(",")
        .append("OFFI_PART = ")
        .append(toDB(entity.getOFFI_PART())).append(",")
        .append("OFFI_PART_REBO_WRT_NUM = ")
        .append(toDB(entity.getOFFI_PART_REBO_WRT_NUM())).append(",")
        .append("NAME = ")
        .append(toDB(entity.getNAME())).append(",")
        .append("WRT_NUM = ")
        .append(toDB(entity.getWRT_NUM())).append(",")
        .append("REP_NM_KOR = ")
        .append(toDB(entity.getREP_NM_KOR())).append(",")
        .append("REP_NM_HAN = ")
        .append(toDB(entity.getREP_NM_HAN())).append(",")
        .append("OFF_ADDR = ")
        .append(toDB(entity.getOFF_ADDR())).append(",")
        .append("TEL_NUM = ")
        .append(toDB(entity.getTEL_NUM())).append(",")
        .append("C_COM_DT = ")
        .append(toDB(entity.getC_COM_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("C_COM_CAUSE = ")
        .append(toDB(entity.getC_COM_CAUSE())).append(",")
        .append("DEFI_STE = ")
        .append(toDB(entity.getDEFI_STE())).append(",")
        .append("ADDR_ADDR = ")
        .append(toDB(entity.getADDR_ADDR())).append(",")
        .append("ADDR_POST_NUM = ")
        .append(toDB(entity.getADDR_POST_NUM())).append(",")
        .append("ADDR_DETAIL_ADDR = ")
        .append(toDB(entity.getADDR_DETAIL_ADDR())).append(",")
        .append("PROC_LIM = ")
        .append(toDB(entity.getPROC_LIM())).append(",")
        .append("MEMO_CONT = ")
        .append(toDB(entity.getMEMO_CONT())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("TMP_WRT_NUM = ")
        .append(toDB(entity.getTMP_WRT_NUM())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;

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
    sb.append("update PT_R_CLOSE_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

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



    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;


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
    sb.append("update PT_R_CLOSE_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;

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
    sb.append("update PT_R_CLOSE_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     

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

    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : updateModifiedOnly() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;


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
    sb.append("update PT_R_CLOSE_STATEMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : delete() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_CLOSE_STATEMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
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

    if((obj instanceof PT_R_CLOSE_STATEMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_R_CLOSE_STATEMENT : delete() ");
    }
    PT_R_CLOSE_STATEMENTEntity entity = (PT_R_CLOSE_STATEMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_R_CLOSE_STATEMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
       ;


   return sb.toString();
  }


}//Class End
