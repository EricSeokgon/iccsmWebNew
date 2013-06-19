


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_HOM_VISIT_HOUR_COUNT
*  테이블 설명 :
*  테이블 PK   :
*               REG_DATE
*  테이블 컬럼 :
*               REG_DATE:VARCHAR2(12):
*               H_01:NUMBER(22):
*               H_02:NUMBER(22):
*               H_03:NUMBER(22):
*               H_04:NUMBER(22):
*               H_05:NUMBER(22):
*               H_06:NUMBER(22):
*               H_07:NUMBER(22):
*               H_08:NUMBER(22):
*               H_09:NUMBER(22):
*               H_10:NUMBER(22):
*               H_11:NUMBER(22):
*               H_12:NUMBER(22):
*               H_13:NUMBER(22):
*               H_14:NUMBER(22):
*               H_15:NUMBER(22):
*               H_16:NUMBER(22):
*               H_17:NUMBER(22):
*               H_18:NUMBER(22):
*               H_19:NUMBER(22):
*               H_20:NUMBER(22):
*               H_21:NUMBER(22):
*               H_22:NUMBER(22):
*               H_23:NUMBER(22):
*               H_24:NUMBER(22):
*               DAY_TOTAL:NUMBER(22):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_HOM_VISIT_HOUR_COUNTDAO  extends SuperToDB{

  private String default_fields[]={ "REG_DATE" , "H_01" , "H_02" , "H_03" , "H_04" , "H_05" , "H_06" , "H_07" , "H_08" , "H_09" , "H_10" , "H_11" , "H_12" , "H_13" , "H_14" , "H_15" , "H_16" , "H_17" , "H_18" , "H_19" , "H_20" , "H_21" , "H_22" , "H_23" , "H_24" , "DAY_TOTAL" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_HOM_VISIT_HOUR_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VISIT_HOUR_COUNT : insert() ");
    }
    PT_HOM_VISIT_HOUR_COUNTEntity entity = (PT_HOM_VISIT_HOUR_COUNTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_HOM_VISIT_HOUR_COUNT ")
    .append(" ( REG_DATE,H_01,H_02,H_03,H_04,H_05,H_06,H_07,H_08,H_09,H_10,H_11,H_12,H_13,H_14,H_15,H_16,H_17,H_18,H_19,H_20,H_21,H_22,H_23,H_24,DAY_TOTAL ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getREG_DATE()))
			.append(",")
           .append(toDB(entity.getH_01()))
			.append(",")
           .append(toDB(entity.getH_02()))
			.append(",")
           .append(toDB(entity.getH_03()))
			.append(",")
           .append(toDB(entity.getH_04()))
			.append(",")
           .append(toDB(entity.getH_05()))
			.append(",")
           .append(toDB(entity.getH_06()))
			.append(",")
           .append(toDB(entity.getH_07()))
			.append(",")
           .append(toDB(entity.getH_08()))
			.append(",")
           .append(toDB(entity.getH_09()))
			.append(",")
           .append(toDB(entity.getH_10()))
			.append(",")
           .append(toDB(entity.getH_11()))
			.append(",")
           .append(toDB(entity.getH_12()))
			.append(",")
           .append(toDB(entity.getH_13()))
			.append(",")
           .append(toDB(entity.getH_14()))
			.append(",")
           .append(toDB(entity.getH_15()))
			.append(",")
           .append(toDB(entity.getH_16()))
			.append(",")
           .append(toDB(entity.getH_17()))
			.append(",")
           .append(toDB(entity.getH_18()))
			.append(",")
           .append(toDB(entity.getH_19()))
			.append(",")
           .append(toDB(entity.getH_20()))
			.append(",")
           .append(toDB(entity.getH_21()))
			.append(",")
           .append(toDB(entity.getH_22()))
			.append(",")
           .append(toDB(entity.getH_23()))
			.append(",")
           .append(toDB(entity.getH_24()))
			.append(",")
           .append(toDB(entity.getDAY_TOTAL()))
			
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


    if((obj instanceof PT_HOM_VISIT_HOUR_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VISIT_HOUR_COUNT : update() ");
    }
    PT_HOM_VISIT_HOUR_COUNTEntity entity = (PT_HOM_VISIT_HOUR_COUNTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_HOM_VISIT_HOUR_COUNT  set ")
       
        .append("H_01 = ")
        .append(toDB(entity.getH_01())).append(",")
        .append("H_02 = ")
        .append(toDB(entity.getH_02())).append(",")
        .append("H_03 = ")
        .append(toDB(entity.getH_03())).append(",")
        .append("H_04 = ")
        .append(toDB(entity.getH_04())).append(",")
        .append("H_05 = ")
        .append(toDB(entity.getH_05())).append(",")
        .append("H_06 = ")
        .append(toDB(entity.getH_06())).append(",")
        .append("H_07 = ")
        .append(toDB(entity.getH_07())).append(",")
        .append("H_08 = ")
        .append(toDB(entity.getH_08())).append(",")
        .append("H_09 = ")
        .append(toDB(entity.getH_09())).append(",")
        .append("H_10 = ")
        .append(toDB(entity.getH_10())).append(",")
        .append("H_11 = ")
        .append(toDB(entity.getH_11())).append(",")
        .append("H_12 = ")
        .append(toDB(entity.getH_12())).append(",")
        .append("H_13 = ")
        .append(toDB(entity.getH_13())).append(",")
        .append("H_14 = ")
        .append(toDB(entity.getH_14())).append(",")
        .append("H_15 = ")
        .append(toDB(entity.getH_15())).append(",")
        .append("H_16 = ")
        .append(toDB(entity.getH_16())).append(",")
        .append("H_17 = ")
        .append(toDB(entity.getH_17())).append(",")
        .append("H_18 = ")
        .append(toDB(entity.getH_18())).append(",")
        .append("H_19 = ")
        .append(toDB(entity.getH_19())).append(",")
        .append("H_20 = ")
        .append(toDB(entity.getH_20())).append(",")
        .append("H_21 = ")
        .append(toDB(entity.getH_21())).append(",")
        .append("H_22 = ")
        .append(toDB(entity.getH_22())).append(",")
        .append("H_23 = ")
        .append(toDB(entity.getH_23())).append(",")
        .append("H_24 = ")
        .append(toDB(entity.getH_24())).append(",")
        .append("DAY_TOTAL = ")
        .append(toDB(entity.getDAY_TOTAL()))
        .append(" where  1=1 ");
       
         sb.append(" and REG_DATE = ").append( toDB(entity.getREG_DATE()));
         

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



    if((obj instanceof PT_HOM_VISIT_HOUR_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VISIT_HOUR_COUNT : updateModifiedOnly() ");
    }
    PT_HOM_VISIT_HOUR_COUNTEntity entity = (PT_HOM_VISIT_HOUR_COUNTEntity)obj;

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
    sb.append("update PT_HOM_VISIT_HOUR_COUNT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and REG_DATE = ").append(toDB(entity.getREG_DATE()));
     

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

    if((obj instanceof PT_HOM_VISIT_HOUR_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VISIT_HOUR_COUNT : updateModifiedOnly() ");
    }
    PT_HOM_VISIT_HOUR_COUNTEntity entity = (PT_HOM_VISIT_HOUR_COUNTEntity)obj;

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
    sb.append("update PT_HOM_VISIT_HOUR_COUNT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and REG_DATE = ").append(toDB(entity.getREG_DATE()));
     

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

    if((obj instanceof PT_HOM_VISIT_HOUR_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VISIT_HOUR_COUNT : delete() ");
    }
    PT_HOM_VISIT_HOUR_COUNTEntity entity = (PT_HOM_VISIT_HOUR_COUNTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_HOM_VISIT_HOUR_COUNT  where  1=1")
      
	  .append(" and REG_DATE = ").append(toDB(entity.getREG_DATE()))
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
