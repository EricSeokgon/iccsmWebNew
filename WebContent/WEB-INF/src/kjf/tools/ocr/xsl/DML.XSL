<?xml version="1.0" encoding="EUC-KR" ?>
<!--
* @(#) SQL_SELECT.xsl
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
SELECT 
	<xsl:for-each select='contents/field'>  <xsl:if test='position()!=1'>, </xsl:if> <xsl:value-of select='@name'/> </xsl:for-each> 
FROM   <xsl:value-of select='@schema'/><xsl:value-of select='@name'/> ;
                   
</xsl:template>

</xsl:stylesheet>
