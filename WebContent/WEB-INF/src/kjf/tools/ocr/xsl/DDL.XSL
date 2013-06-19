<?xml version="1.0" encoding="EUC-KR" ?>
<!--
* @(#) DDL.xsl
*
* MODIFICATION HISTORY
* 1.0.0 (2006.04.27-김경덕)
*
-->

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="text" encoding="EUC-KR" />

<xsl:template match="table">

<xsl:variable name="pk" select="primarykey"/>
create table <xsl:value-of select="@name"/>(
    <xsl:for-each select="contents/field">
         <xsl:value-of select="@name"/><xsl:text> </xsl:text>
         <xsl:value-of select="@dbtype"/><xsl:text> </xsl:text>
         <xsl:if test="contains($pk,@name)">NOT NULL</xsl:if> , /*<xsl:value-of select="@desc"/> */
    </xsl:for-each>PRIMARY KEY(<xsl:for-each select="primarykey/key"><xsl:value-of select="."/> <xsl:if test="not(position()=last())">,</xsl:if> </xsl:for-each>)
   );
</xsl:template>

</xsl:stylesheet>
