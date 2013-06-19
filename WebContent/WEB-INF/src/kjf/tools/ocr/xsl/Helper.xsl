<?xml version="1.0" encoding="EUC-KR" ?>
<!--
* @(#) Helper.xsl
*
* MODIFICATION HISTORY
* 1.0.0 (2006.04.27-김경덕)
*
-->

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="text" encoding="EUC-KR" />

<xsl:template match="table">

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


import kjf.ops.*;

import java.util.*;

public class <xsl:value-of select="@name"/>Helper{

  <xsl:for-each select="contents/field">final static public String <xsl:value-of select="@name"/> = "<xsl:value-of select='@name'/>";
  </xsl:for-each>


  public static HashMap fieldMap = new HashMap(<xsl:value-of select='count(contents/field)'/>);
  static{
  <xsl:for-each select="contents/field">fieldMap.put(<xsl:value-of select='@name'/>,new Integer(<xsl:value-of select='position()'/>) );
  </xsl:for-each>
  }

     final public static String PACKAGE = "<xsl:value-of select='@pkgname'/>";
     final public static String TABLE = "<xsl:value-of select='@name'/>";
     final public static String PREFIX = "<xsl:value-of select='@pkgname'/>.<xsl:value-of select='@name'/>";
     final public static String TABLE_DESC = "<xsl:value-of select='desc'/>";
  
     final public static String PRIMARYKEY_LIST[] = { 
       <xsl:for-each select='primarykey/key'><xsl:if test='position()!=1'>,</xsl:if><xsl:value-of select='.'/>
       </xsl:for-each> };
     final public static String FIELD_LIST[] = { 
       <xsl:for-each select='contents/field'><xsl:if test='position()!=1'>,</xsl:if><xsl:value-of select='@name'/>
       </xsl:for-each> };
     public static String getFieldDesc(String key){
         Integer idx = (Integer)fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        <xsl:for-each select="contents/field">
        <xsl:variable name="fieldType"><xsl:value-of select="."/></xsl:variable>
             case <xsl:value-of select='position()'/> : 
	                  return  "<xsl:value-of select='@desc'/>";</xsl:for-each>
	    }

         return null;
    }

   public static String toXML(<xsl:value-of select="@name"/>Entity ent){

         StringBuffer xml = new StringBuffer(); 
         xml.append("&lt;object type='object' name='").append(ent.getClass().getName()).append("' &gt;\n");
        
        <xsl:for-each select="contents/field">
         xml.append("&lt;field type='").append("<xsl:value-of select='@type'/>").append("' ")
            .append(" name='").append("<xsl:value-of select='@name'/>").append("'")
            .append(" value='").append(""+ent.get<xsl:value-of select="@name"/>()).append("' /&gt;\n");
        </xsl:for-each>

         xml.append("&lt;/object&gt;\n");
         
         return xml.toString();
  }

}
</xsl:template>


</xsl:stylesheet>
