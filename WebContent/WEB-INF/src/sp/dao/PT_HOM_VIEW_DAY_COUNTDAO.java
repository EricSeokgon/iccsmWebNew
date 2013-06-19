


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_HOM_VIEW_DAY_COUNT
*  테이블 설명 :
*  테이블 PK   :
*               PAGE_ID
*  테이블 컬럼 :
*               PAGE_ID:VARCHAR2(50):
*               REG_DATE:VARCHAR2(12):
*               D_01:NUMBER(22):
*               D_02:NUMBER(22):
*               D_03:NUMBER(22):
*               D_04:NUMBER(22):
*               D_05:NUMBER(22):
*               D_06:NUMBER(22):
*               D_07:NUMBER(22):
*               D_08:NUMBER(22):
*               D_09:NUMBER(22):
*               D_10:NUMBER(22):
*               D_11:NUMBER(22):
*               D_12:NUMBER(22):
*               D_13:NUMBER(22):
*               D_14:NUMBER(22):
*               D_15:NUMBER(22):
*               D_16:NUMBER(22):
*               D_17:NUMBER(22):
*               D_18:NUMBER(22):
*               D_19:NUMBER(22):
*               D_20:NUMBER(22):
*               D_21:NUMBER(22):
*               D_22:NUMBER(22):
*               D_23:NUMBER(22):
*               D_24:NUMBER(22):
*               D_25:NUMBER(22):
*               D_26:NUMBER(22):
*               D_27:NUMBER(22):
*               D_28:NUMBER(22):
*               D_29:NUMBER(22):
*               D_30:NUMBER(22):
*               D_31:NUMBER(22):
*               MONTH_TOTAL:NUMBER(22):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_HOM_VIEW_DAY_COUNTDAO  extends SuperToDB{

  private String default_fields[]={ "PAGE_ID" , "REG_DATE" , "D_01" , "D_02" , "D_03" , "D_04" , "D_05" , "D_06" , "D_07" , "D_08" , "D_09" , "D_10" , "D_11" , "D_12" , "D_13" , "D_14" , "D_15" , "D_16" , "D_17" , "D_18" , "D_19" , "D_20" , "D_21" , "D_22" , "D_23" , "D_24" , "D_25" , "D_26" , "D_27" , "D_28" , "D_29" , "D_30" , "D_31" , "MONTH_TOTAL" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_HOM_VIEW_DAY_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VIEW_DAY_COUNT : insert() ");
    }
    PT_HOM_VIEW_DAY_COUNTEntity entity = (PT_HOM_VIEW_DAY_COUNTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_HOM_VIEW_DAY_COUNT ")
    .append(" ( PAGE_ID,REG_DATE,D_01,D_02,D_03,D_04,D_05,D_06,D_07,D_08,D_09,D_10,D_11,D_12,D_13,D_14,D_15,D_16,D_17,D_18,D_19,D_20,D_21,D_22,D_23,D_24,D_25,D_26,D_27,D_28,D_29,D_30,D_31,MONTH_TOTAL ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getPAGE_ID()))
			.append(",")
           .append(toDB(entity.getREG_DATE()))
			.append(",")
           .append(toDB(entity.getD_01()))
			.append(",")
           .append(toDB(entity.getD_02()))
			.append(",")
           .append(toDB(entity.getD_03()))
			.append(",")
           .append(toDB(entity.getD_04()))
			.append(",")
           .append(toDB(entity.getD_05()))
			.append(",")
           .append(toDB(entity.getD_06()))
			.append(",")
           .append(toDB(entity.getD_07()))
			.append(",")
           .append(toDB(entity.getD_08()))
			.append(",")
           .append(toDB(entity.getD_09()))
			.append(",")
           .append(toDB(entity.getD_10()))
			.append(",")
           .append(toDB(entity.getD_11()))
			.append(",")
           .append(toDB(entity.getD_12()))
			.append(",")
           .append(toDB(entity.getD_13()))
			.append(",")
           .append(toDB(entity.getD_14()))
			.append(",")
           .append(toDB(entity.getD_15()))
			.append(",")
           .append(toDB(entity.getD_16()))
			.append(",")
           .append(toDB(entity.getD_17()))
			.append(",")
           .append(toDB(entity.getD_18()))
			.append(",")
           .append(toDB(entity.getD_19()))
			.append(",")
           .append(toDB(entity.getD_20()))
			.append(",")
           .append(toDB(entity.getD_21()))
			.append(",")
           .append(toDB(entity.getD_22()))
			.append(",")
           .append(toDB(entity.getD_23()))
			.append(",")
           .append(toDB(entity.getD_24()))
			.append(",")
           .append(toDB(entity.getD_25()))
			.append(",")
           .append(toDB(entity.getD_26()))
			.append(",")
           .append(toDB(entity.getD_27()))
			.append(",")
           .append(toDB(entity.getD_28()))
			.append(",")
           .append(toDB(entity.getD_29()))
			.append(",")
           .append(toDB(entity.getD_30()))
			.append(",")
           .append(toDB(entity.getD_31()))
			.append(",")
           .append(toDB(entity.getMONTH_TOTAL()))
			
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


    if((obj instanceof PT_HOM_VIEW_DAY_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VIEW_DAY_COUNT : update() ");
    }
    PT_HOM_VIEW_DAY_COUNTEntity entity = (PT_HOM_VIEW_DAY_COUNTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_HOM_VIEW_DAY_COUNT  set ")
       
        .append("REG_DATE = ")
        .append(toDB(entity.getREG_DATE())).append(",")
        .append("D_01 = ")
        .append(toDB(entity.getD_01())).append(",")
        .append("D_02 = ")
        .append(toDB(entity.getD_02())).append(",")
        .append("D_03 = ")
        .append(toDB(entity.getD_03())).append(",")
        .append("D_04 = ")
        .append(toDB(entity.getD_04())).append(",")
        .append("D_05 = ")
        .append(toDB(entity.getD_05())).append(",")
        .append("D_06 = ")
        .append(toDB(entity.getD_06())).append(",")
        .append("D_07 = ")
        .append(toDB(entity.getD_07())).append(",")
        .append("D_08 = ")
        .append(toDB(entity.getD_08())).append(",")
        .append("D_09 = ")
        .append(toDB(entity.getD_09())).append(",")
        .append("D_10 = ")
        .append(toDB(entity.getD_10())).append(",")
        .append("D_11 = ")
        .append(toDB(entity.getD_11())).append(",")
        .append("D_12 = ")
        .append(toDB(entity.getD_12())).append(",")
        .append("D_13 = ")
        .append(toDB(entity.getD_13())).append(",")
        .append("D_14 = ")
        .append(toDB(entity.getD_14())).append(",")
        .append("D_15 = ")
        .append(toDB(entity.getD_15())).append(",")
        .append("D_16 = ")
        .append(toDB(entity.getD_16())).append(",")
        .append("D_17 = ")
        .append(toDB(entity.getD_17())).append(",")
        .append("D_18 = ")
        .append(toDB(entity.getD_18())).append(",")
        .append("D_19 = ")
        .append(toDB(entity.getD_19())).append(",")
        .append("D_20 = ")
        .append(toDB(entity.getD_20())).append(",")
        .append("D_21 = ")
        .append(toDB(entity.getD_21())).append(",")
        .append("D_22 = ")
        .append(toDB(entity.getD_22())).append(",")
        .append("D_23 = ")
        .append(toDB(entity.getD_23())).append(",")
        .append("D_24 = ")
        .append(toDB(entity.getD_24())).append(",")
        .append("D_25 = ")
        .append(toDB(entity.getD_25())).append(",")
        .append("D_26 = ")
        .append(toDB(entity.getD_26())).append(",")
        .append("D_27 = ")
        .append(toDB(entity.getD_27())).append(",")
        .append("D_28 = ")
        .append(toDB(entity.getD_28())).append(",")
        .append("D_29 = ")
        .append(toDB(entity.getD_29())).append(",")
        .append("D_30 = ")
        .append(toDB(entity.getD_30())).append(",")
        .append("D_31 = ")
        .append(toDB(entity.getD_31())).append(",")
        .append("MONTH_TOTAL = ")
        .append(toDB(entity.getMONTH_TOTAL()))
        .append(" where  1=1 ");
       
         sb.append(" and PAGE_ID = ").append( toDB(entity.getPAGE_ID()));
         

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



    if((obj instanceof PT_HOM_VIEW_DAY_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VIEW_DAY_COUNT : updateModifiedOnly() ");
    }
    PT_HOM_VIEW_DAY_COUNTEntity entity = (PT_HOM_VIEW_DAY_COUNTEntity)obj;

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
    sb.append("update PT_HOM_VIEW_DAY_COUNT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and PAGE_ID = ").append(toDB(entity.getPAGE_ID()));
     

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

    if((obj instanceof PT_HOM_VIEW_DAY_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VIEW_DAY_COUNT : updateModifiedOnly() ");
    }
    PT_HOM_VIEW_DAY_COUNTEntity entity = (PT_HOM_VIEW_DAY_COUNTEntity)obj;

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
    sb.append("update PT_HOM_VIEW_DAY_COUNT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and PAGE_ID = ").append(toDB(entity.getPAGE_ID()));
     

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

    if((obj instanceof PT_HOM_VIEW_DAY_COUNTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_HOM_VIEW_DAY_COUNT : delete() ");
    }
    PT_HOM_VIEW_DAY_COUNTEntity entity = (PT_HOM_VIEW_DAY_COUNTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_HOM_VIEW_DAY_COUNT  where  1=1")
      
	  .append(" and PAGE_ID = ").append(toDB(entity.getPAGE_ID()))
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
