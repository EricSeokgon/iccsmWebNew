<?xml version="1.0" encoding="EUC-KR" ?>

<!--
* @(#) DAO.xsl
*
* MODIFICATION HISTORY
* 1.0.0 (2006.04.27-김경덕)
*
-->


<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

<xsl:output method="text"  encoding="EUC-KR" />



<xsl:template match="table">

 <xsl:variable name="pk" select="primarykey"/>


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :<xsl:value-of select="@name"/>
*  테이블 설명 :<xsl:value-of select="desc"/>
*  테이블 PK   :<xsl:for-each select="primarykey/key">
*               <xsl:value-of select="."/></xsl:for-each>
*  테이블 컬럼 :<xsl:for-each select="contents/field">
*               <xsl:value-of select="@name"/>:<xsl:value-of select="@dbtype"/>:<xsl:value-of select="@desc"/></xsl:for-each>
*/
package <xsl:value-of select="@pkgname"/>;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class <xsl:value-of select="@name"/>DAO  extends SuperToDB{

  private String default_fields[]={<xsl:for-each select='contents/field'>  <xsl:if test='position()!=1'>,</xsl:if> "<xsl:value-of select='@name'/>" </xsl:for-each>};	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : insert() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into <xsl:value-of select='@schema'/><xsl:value-of select='@name'/> ")
    .append(" ( <xsl:for-each select='contents/field'>  <xsl:if test='position()!=1'>,</xsl:if> <xsl:value-of select='@name'/> </xsl:for-each> ) ")
    .append(" values ( ")
      <xsl:for-each select="contents/field">
        <xsl:if test='position()!=1'>.append(",")</xsl:if>
        <xsl:if test='@insert'>
           .append("<xsl:value-of select='@insert'/>")
        </xsl:if>
        <xsl:if test='not(@insert)'>
			<xsl:if test="@dbtype='CLOB'">
		   .append("?")
			</xsl:if>
			<xsl:if test="@dbtype!='CLOB'">
           .append(toDB(entity.get<xsl:value-of select="@name"/>()))
			</xsl:if>
        </xsl:if>
      </xsl:for-each>
    .append(" ) ");

   KJFLog.sql(sb.toString());


   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

    int i=1;
	<xsl:for-each select="contents/field">
		<xsl:if test="@dbtype='CLOB'">
	<!-- 2008년 1월15일 오라클용 수정
	ps.setString(i++,toDB(entity.get<xsl:value-of select="@name"/>()));
	-->
	ps.setString(i++,entity.get<xsl:value-of select="@name"/>());
		</xsl:if>
	</xsl:for-each>
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

    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : insert() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into <xsl:value-of select='@schema'/><xsl:value-of select='@name'/> ")
    .append(" ( <xsl:for-each select='contents/field'>  <xsl:if test='position()!=1'>,</xsl:if> <xsl:value-of select='@name'/> </xsl:for-each> ) ")
    .append(" values ( ")
      <xsl:for-each select="contents/field">
        <xsl:if test='position()!=1'>.append(",")</xsl:if>
        <xsl:if test='@insert'>
           .append("<xsl:value-of select='@insert'/>")
        </xsl:if>
        <xsl:if test='not(@insert)'>
			<xsl:if test="@dbtype='CLOB'">
		   .append("?")
			</xsl:if>
			<xsl:if test="@dbtype!='CLOB'">
           .append(toDB(entity.get<xsl:value-of select="@name"/>()))
			</xsl:if>
        </xsl:if>
      </xsl:for-each>
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : update() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update <xsl:value-of select='@schema'/><xsl:value-of select="@name"/>  set ")
       <xsl:for-each select="contents/field">
        <xsl:if test="not(contains($pk,@name))">
        .append("<xsl:value-of select="@name"/> = ")
        <xsl:if test='@update'     >.append("<xsl:value-of select='@update'/>" )     </xsl:if>
        <xsl:if test='not(@update)'>
			<xsl:if test="@dbtype='CLOB'">.append("?")</xsl:if>
			<xsl:if test="@dbtype!='CLOB'">.append(toDB(entity.get<xsl:value-of select="@name"/>()))</xsl:if>
		</xsl:if>
        <xsl:if test="position()!=last()">.append(",")</xsl:if>
        </xsl:if>
       </xsl:for-each>
        .append(" where  1=1 ");
       <xsl:for-each select="contents/field">
         <xsl:if test="contains($pk,@name)">
         sb.append(" and <xsl:value-of select='@name'/> = ").append( toDB(entity.get<xsl:value-of select="@name"/>()));
         </xsl:if>
         <xsl:if test="@timestamp='true'">
         <!-- 2001/12/13 수정   -->
	      if (entity.get<xsl:value-of select="@name"/>()!=null){
           sb.append(" and <xsl:value-of select='@name'/> = ")
             .append( toDB(entity.get<xsl:value-of select="@name"/>()));
	        };
         <!-- 2001/12/13 수정끝 -->
         </xsl:if>
       </xsl:for-each>

   KJFLog.sql(sb.toString());

   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int i=1;
	<xsl:for-each select="contents/field">
		<xsl:if test="@dbtype='CLOB'">
	<!-- 2008년 1월15일 오라클용 수정
	ps.setString(i++,toDB(entity.get<xsl:value-of select="@name"/>()) );
	-->
	ps.setString(i++,entity.get<xsl:value-of select="@name"/>());
		</xsl:if>
	</xsl:for-each>
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


    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : update() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update <xsl:value-of select='@schema'/><xsl:value-of select="@name"/>  set ")
       <xsl:for-each select="contents/field">
        <xsl:if test="not(contains($pk,@name))">
        .append("<xsl:value-of select="@name"/> = ")
        <xsl:if test='@update'     >.append("<xsl:value-of select='@update'/>" )     </xsl:if>
        <xsl:if test='not(@update)'>
			<xsl:if test="@dbtype='CLOB'">.append("?")</xsl:if>
			<xsl:if test="@dbtype!='CLOB'">.append(toDB(entity.get<xsl:value-of select="@name"/>()))</xsl:if>
		</xsl:if>
        <xsl:if test="position()!=last()">.append(",")</xsl:if>
        </xsl:if>
       </xsl:for-each>
        .append(" where  1=1 ");
       <xsl:for-each select="contents/field">
         <xsl:if test="contains($pk,@name)">
         sb.append(" and <xsl:value-of select='@name'/> = ").append( toDB(entity.get<xsl:value-of select="@name"/>()));
         </xsl:if>
         <xsl:if test="@timestamp='true'">
         <!-- 2001/12/13 수정   -->
	      if (entity.get<xsl:value-of select="@name"/>()!=null){
           sb.append(" and <xsl:value-of select='@name'/> = ")
             .append( toDB(entity.get<xsl:value-of select="@name"/>()));
	        };
         <!-- 2001/12/13 수정끝 -->
         </xsl:if>
       </xsl:for-each>

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(<xsl:value-of select='count(contents/field[@update])'/>);
  static{
     <xsl:for-each select="contents/field[@update]">
     default_update_field.put("<xsl:value-of select='@name'/>", "<xsl:value-of select='@update'/>");
     </xsl:for-each>
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : updateModifiedOnly() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;

	HashMap clobs = new HashMap();
	<xsl:for-each select="contents/field"><xsl:if test="@dbtype='CLOB'">clobs.put("<xsl:value-of select="@name"/>","1");</xsl:if></xsl:for-each>

	Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i &lt; fields.length ; i++){
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

    <xsl:for-each select="contents/field[@update]">
     setString.append(",").append("<xsl:value-of select='@name'/>").append("=").append("<xsl:value-of select='@update'/>") ;
    </xsl:for-each>

    StringBuffer sb = new StringBuffer();
    sb.append("update <xsl:value-of select='@schema'/><xsl:value-of select="@name"/>  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     <xsl:for-each select="contents/field"><xsl:if test="contains($pk,@name)">
	  sb.append(" and <xsl:value-of select='@name'/> = ").append(toDB(entity.get<xsl:value-of select="@name"/>()));
     </xsl:if>
         <xsl:if test="@timestamp='true'">
         <!-- 수정   -->
	      if (entity.get<xsl:value-of select="@name"/>()!=null){
           sb.append(" and <xsl:value-of select='@name'/> = ")
             .append( toDB(entity.get<xsl:value-of select="@name"/>()));
	        };
         <!-- 수정끝 -->
         </xsl:if>
     </xsl:for-each>

   KJFLog.sql( sb.toString());

    try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int k=1;
    for(int i=0 ; i &lt; fields.length ; i++){
       if(clobs.containsKey(fields[i])){
    	   <!-- 2008년 1월15일 오라클용 수정
    	   ps.setString(k++,toDB(entity.getByName(fields[i])));
    	   -->
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



    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : updateModifiedOnly() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;


	HashMap clobs = new HashMap();
	<xsl:for-each select="contents/field"><xsl:if test="@dbtype='CLOB'">clobs.put("<xsl:value-of select="@name"/>","1");</xsl:if></xsl:for-each>

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i &lt; fields.length ; i++){
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

    <xsl:for-each select="contents/field[@update]">
     setString.append(",").append("<xsl:value-of select='@name'/>").append("=").append("<xsl:value-of select='@update'/>") ;
    </xsl:for-each>

    StringBuffer sb = new StringBuffer();
    sb.append("update <xsl:value-of select='@schema'/><xsl:value-of select="@name"/>  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     <xsl:for-each select="contents/field"><xsl:if test="contains($pk,@name)">
	  sb.append(" and <xsl:value-of select='@name'/> = ").append(toDB(entity.get<xsl:value-of select="@name"/>()));
     </xsl:if>
         <xsl:if test="@timestamp='true'">
         <!-- 수정   -->
	      if (entity.get<xsl:value-of select="@name"/>()!=null){
           sb.append(" and <xsl:value-of select='@name'/> = ")
             .append( toDB(entity.get<xsl:value-of select="@name"/>()));
	        };
         <!-- 수정끝 -->
         </xsl:if>
     </xsl:for-each>

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : updateModifiedOnly() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;

	HashMap clobs = new HashMap();
	<xsl:for-each select="contents/field"><xsl:if test="@dbtype='CLOB'">clobs.put("<xsl:value-of select="@name"/>","1");</xsl:if></xsl:for-each>

	Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i &lt; fields.length ; i++){
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

    <xsl:for-each select="contents/field[@update]">
     setString.append(",").append("<xsl:value-of select='@name'/>").append("=").append("<xsl:value-of select='@update'/>") ;
    </xsl:for-each>

    StringBuffer sb = new StringBuffer();
    sb.append("update <xsl:value-of select='@schema'/><xsl:value-of select="@name"/>  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     <xsl:for-each select="contents/field"><xsl:if test="contains($pk,@name)">
	  sb.append(" and <xsl:value-of select='@name'/> = ").append(toDB(entity.get<xsl:value-of select="@name"/>()));
     </xsl:if>
         <xsl:if test="@timestamp='true'">
         <!-- 수정   -->
	      if (entity.get<xsl:value-of select="@name"/>()!=null){
           sb.append(" and <xsl:value-of select='@name'/> = ")
             .append( toDB(entity.get<xsl:value-of select="@name"/>()));
	        };
         <!-- 수정끝 -->
         </xsl:if>
     </xsl:for-each>

   KJFLog.sql( sb.toString());

    try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int k=1;
    for(int i=0 ; i &lt; fields.length ; i++){
       if(clobs.containsKey(fields[i])){
    	   <!-- 2008년 1월15일 오라클용 수정
    	   ps.setString(k++,toDB(entity.getByName(fields[i])));
    	   -->
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

    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : updateModifiedOnly() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;


	HashMap clobs = new HashMap();
	<xsl:for-each select="contents/field"><xsl:if test="@dbtype='CLOB'">clobs.put("<xsl:value-of select="@name"/>","1");</xsl:if></xsl:for-each>


    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i &lt; fields.length ; i++){
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

    <xsl:for-each select="contents/field[@update]">
     setString.append(",").append("<xsl:value-of select='@name'/>").append("=").append("<xsl:value-of select='@update'/>") ;
    </xsl:for-each>

    StringBuffer sb = new StringBuffer();
    sb.append("update <xsl:value-of select='@schema'/><xsl:value-of select="@name"/>  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     <xsl:for-each select="contents/field"><xsl:if test="contains($pk,@name)">
	  sb.append(" and <xsl:value-of select='@name'/> = ").append(toDB(entity.get<xsl:value-of select="@name"/>()));
     </xsl:if>
         <xsl:if test="@timestamp='true'">
         <!-- 수정   -->
	      if (entity.get<xsl:value-of select="@name"/>()!=null){
           sb.append(" and <xsl:value-of select='@name'/> = ")
             .append( toDB(entity.get<xsl:value-of select="@name"/>()));
	        };
         <!-- 수정끝 -->
         </xsl:if>
     </xsl:for-each>
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : delete() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from <xsl:value-of select='@schema'/><xsl:value-of select='@name'/>  where  1=1")
      <xsl:for-each select="contents/field"> <xsl:if test="contains($pk,@name)">
	  .append(" and <xsl:value-of select='@name'/> = ").append(toDB(entity.get<xsl:value-of select="@name"/>()))
      </xsl:if></xsl:for-each> ;

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

    if((obj instanceof <xsl:value-of select="@name"/>Entity) == false){
        throw new  SQLException("DAO 에러(1): <xsl:value-of select="@name"/> : delete() ");
    }
    <xsl:value-of select="@name"/>Entity entity = (<xsl:value-of select="@name"/>Entity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from <xsl:value-of select='@schema'/><xsl:value-of select='@name'/>  where  1=1")
      <xsl:for-each select="contents/field"> <xsl:if test="contains($pk,@name)">
	  .append(" and <xsl:value-of select='@name'/> = ").append(toDB(entity.get<xsl:value-of select="@name"/>()))
      </xsl:if></xsl:for-each> ;


   return sb.toString();
  }


}//Class End
</xsl:template>


</xsl:stylesheet>