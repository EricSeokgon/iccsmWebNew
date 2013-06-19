


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_UB_EQUIPMENT
*  테이블 설명 :
*  테이블 PK   :
*               RECV_NUM
*               SIDO_CODE
*               SIGUNGU_CODE
*  테이블 컬럼 :
*               RECV_NUM:VARCHAR2(30):
*               SIDO_CODE:VARCHAR2(5):
*               SIGUNGU_CODE:VARCHAR2(4):
*               CIV_RECV_NUM:VARCHAR2(100):
*               TYPE_PROC_NO_CA:VARCHAR2(50):
*               TYPE_PROC_NM_CA:VARCHAR2(100):
*               FREQUENCY_SCOPE_CA:VARCHAR2(20):
*               WIRE_TYPE_CA:VARCHAR2(100):
*               TYPE_PROC_NO_MA:VARCHAR2(50):
*               TYPE_PROC_NM_MA:VARCHAR2(100):
*               FREQUENCY_SCOPE_MA:VARCHAR2(20):
*               WIRE_TYPE_MA:VARCHAR2(100):
*               TYPE_PROC_NO_SMA:VARCHAR2(50):
*               TYPE_PROC_NM_SMA:VARCHAR2(100):
*               FREQUENCY_SCOPE_SMA:VARCHAR2(20):
*               WIRE_TYPE_SMA:VARCHAR2(100):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_UB_EQUIPMENTDAO  extends SuperToDB{

  private String default_fields[]={ "RECV_NUM" , "SIDO_CODE" , "SIGUNGU_CODE" , "CIV_RECV_NUM" , "TYPE_PROC_NO_CA" , "TYPE_PROC_NM_CA" , "FREQUENCY_SCOPE_CA" , "WIRE_TYPE_CA" , "TYPE_PROC_NO_MA" , "TYPE_PROC_NM_MA" , "FREQUENCY_SCOPE_MA" , "WIRE_TYPE_MA" , "TYPE_PROC_NO_SMA" , "TYPE_PROC_NM_SMA" , "FREQUENCY_SCOPE_SMA" , "WIRE_TYPE_SMA" , "INS_DT" , "UPD_DT" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : insert() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_EQUIPMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,SIGUNGU_CODE,CIV_RECV_NUM,TYPE_PROC_NO_CA,TYPE_PROC_NM_CA,FREQUENCY_SCOPE_CA,WIRE_TYPE_CA,TYPE_PROC_NO_MA,TYPE_PROC_NM_MA,FREQUENCY_SCOPE_MA,WIRE_TYPE_MA,TYPE_PROC_NO_SMA,TYPE_PROC_NM_SMA,FREQUENCY_SCOPE_SMA,WIRE_TYPE_SMA,INS_DT,UPD_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getCIV_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NO_CA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NM_CA()))
			.append(",")
           .append(toDB(entity.getFREQUENCY_SCOPE_CA()))
			.append(",")
           .append(toDB(entity.getWIRE_TYPE_CA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NO_MA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NM_MA()))
			.append(",")
           .append(toDB(entity.getFREQUENCY_SCOPE_MA()))
			.append(",")
           .append(toDB(entity.getWIRE_TYPE_MA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NO_SMA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NM_SMA()))
			.append(",")
           .append(toDB(entity.getFREQUENCY_SCOPE_SMA()))
			.append(",")
           .append(toDB(entity.getWIRE_TYPE_SMA()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			
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

    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : insert() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_UB_EQUIPMENT ")
    .append(" ( RECV_NUM,SIDO_CODE,SIGUNGU_CODE,CIV_RECV_NUM,TYPE_PROC_NO_CA,TYPE_PROC_NM_CA,FREQUENCY_SCOPE_CA,WIRE_TYPE_CA,TYPE_PROC_NO_MA,TYPE_PROC_NM_MA,FREQUENCY_SCOPE_MA,WIRE_TYPE_MA,TYPE_PROC_NO_SMA,TYPE_PROC_NM_SMA,FREQUENCY_SCOPE_SMA,WIRE_TYPE_SMA,INS_DT,UPD_DT ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getSIGUNGU_CODE()))
			.append(",")
           .append(toDB(entity.getCIV_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NO_CA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NM_CA()))
			.append(",")
           .append(toDB(entity.getFREQUENCY_SCOPE_CA()))
			.append(",")
           .append(toDB(entity.getWIRE_TYPE_CA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NO_MA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NM_MA()))
			.append(",")
           .append(toDB(entity.getFREQUENCY_SCOPE_MA()))
			.append(",")
           .append(toDB(entity.getWIRE_TYPE_MA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NO_SMA()))
			.append(",")
           .append(toDB(entity.getTYPE_PROC_NM_SMA()))
			.append(",")
           .append(toDB(entity.getFREQUENCY_SCOPE_SMA()))
			.append(",")
           .append(toDB(entity.getWIRE_TYPE_SMA()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : update() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_EQUIPMENT  set ")
       
        .append("CIV_RECV_NUM = ")
        .append(toDB(entity.getCIV_RECV_NUM())).append(",")
        .append("TYPE_PROC_NO_CA = ")
        .append(toDB(entity.getTYPE_PROC_NO_CA())).append(",")
        .append("TYPE_PROC_NM_CA = ")
        .append(toDB(entity.getTYPE_PROC_NM_CA())).append(",")
        .append("FREQUENCY_SCOPE_CA = ")
        .append(toDB(entity.getFREQUENCY_SCOPE_CA())).append(",")
        .append("WIRE_TYPE_CA = ")
        .append(toDB(entity.getWIRE_TYPE_CA())).append(",")
        .append("TYPE_PROC_NO_MA = ")
        .append(toDB(entity.getTYPE_PROC_NO_MA())).append(",")
        .append("TYPE_PROC_NM_MA = ")
        .append(toDB(entity.getTYPE_PROC_NM_MA())).append(",")
        .append("FREQUENCY_SCOPE_MA = ")
        .append(toDB(entity.getFREQUENCY_SCOPE_MA())).append(",")
        .append("WIRE_TYPE_MA = ")
        .append(toDB(entity.getWIRE_TYPE_MA())).append(",")
        .append("TYPE_PROC_NO_SMA = ")
        .append(toDB(entity.getTYPE_PROC_NO_SMA())).append(",")
        .append("TYPE_PROC_NM_SMA = ")
        .append(toDB(entity.getTYPE_PROC_NM_SMA())).append(",")
        .append("FREQUENCY_SCOPE_SMA = ")
        .append(toDB(entity.getFREQUENCY_SCOPE_SMA())).append(",")
        .append("WIRE_TYPE_SMA = ")
        .append(toDB(entity.getWIRE_TYPE_SMA())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and SIGUNGU_CODE = ").append( toDB(entity.getSIGUNGU_CODE()));
         

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


    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : update() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_UB_EQUIPMENT  set ")
       
        .append("CIV_RECV_NUM = ")
        .append(toDB(entity.getCIV_RECV_NUM())).append(",")
        .append("TYPE_PROC_NO_CA = ")
        .append(toDB(entity.getTYPE_PROC_NO_CA())).append(",")
        .append("TYPE_PROC_NM_CA = ")
        .append(toDB(entity.getTYPE_PROC_NM_CA())).append(",")
        .append("FREQUENCY_SCOPE_CA = ")
        .append(toDB(entity.getFREQUENCY_SCOPE_CA())).append(",")
        .append("WIRE_TYPE_CA = ")
        .append(toDB(entity.getWIRE_TYPE_CA())).append(",")
        .append("TYPE_PROC_NO_MA = ")
        .append(toDB(entity.getTYPE_PROC_NO_MA())).append(",")
        .append("TYPE_PROC_NM_MA = ")
        .append(toDB(entity.getTYPE_PROC_NM_MA())).append(",")
        .append("FREQUENCY_SCOPE_MA = ")
        .append(toDB(entity.getFREQUENCY_SCOPE_MA())).append(",")
        .append("WIRE_TYPE_MA = ")
        .append(toDB(entity.getWIRE_TYPE_MA())).append(",")
        .append("TYPE_PROC_NO_SMA = ")
        .append(toDB(entity.getTYPE_PROC_NO_SMA())).append(",")
        .append("TYPE_PROC_NM_SMA = ")
        .append(toDB(entity.getTYPE_PROC_NM_SMA())).append(",")
        .append("FREQUENCY_SCOPE_SMA = ")
        .append(toDB(entity.getFREQUENCY_SCOPE_SMA())).append(",")
        .append("WIRE_TYPE_SMA = ")
        .append(toDB(entity.getWIRE_TYPE_SMA())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT()))
        .append(" where  1=1 ");
       
         sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
         
         sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
         
         sb.append(" and SIGUNGU_CODE = ").append( toDB(entity.getSIGUNGU_CODE()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : updateModifiedOnly() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;

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
    sb.append("update PT_UB_EQUIPMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     

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



    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : updateModifiedOnly() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;


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
    sb.append("update PT_UB_EQUIPMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : updateModifiedOnly() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;

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
    sb.append("update PT_UB_EQUIPMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     

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

    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : updateModifiedOnly() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;


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
    sb.append("update PT_UB_EQUIPMENT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()));
     
	  sb.append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()));
     
	  sb.append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : delete() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_EQUIPMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
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

    if((obj instanceof PT_UB_EQUIPMENTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_UB_EQUIPMENT : delete() ");
    }
    PT_UB_EQUIPMENTEntity entity = (PT_UB_EQUIPMENTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_UB_EQUIPMENT  where  1=1")
      
	  .append(" and RECV_NUM = ").append(toDB(entity.getRECV_NUM()))
      
	  .append(" and SIDO_CODE = ").append(toDB(entity.getSIDO_CODE()))
      
	  .append(" and SIGUNGU_CODE = ").append(toDB(entity.getSIGUNGU_CODE()))
       ;


   return sb.toString();
  }


}//Class End
