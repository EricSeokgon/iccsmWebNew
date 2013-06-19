<?xml version="1.0" encoding="EUC-KR" ?>
<!--
* @(#) Entity.xsl
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

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class <xsl:value-of select="@name"/>Entity extends ValueObject{

  <xsl:for-each select="contents/field">
     private <xsl:value-of select="@type"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>;
  </xsl:for-each>

//생성자를 만든다
    public <xsl:value-of select="@name"/>Entity(){
    }
    
    <xsl:if test='count(primarykey/key) > 0'>
    public <xsl:value-of select="@name"/>Entity(<xsl:for-each select="primarykey/key">
          <xsl:if test='position()!=1'>,</xsl:if> <xsl:apply-templates select="."/>
         </xsl:for-each> ){
       <xsl:for-each select="primarykey/key">this.set<xsl:value-of select="."/>(<xsl:value-of select="."/>);
       </xsl:for-each>
    }
    </xsl:if>  
    public <xsl:value-of select="@name"/>Entity(ValueObject ent) throws Exception{
       Object value = null; 
       <xsl:for-each select="primarykey/key">
       value = ent.getByName("<xsl:value-of select="."/>");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("<xsl:value-of select="."/>",value);
       </xsl:for-each>
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		<xsl:for-each select="contents/field">			
		<xsl:choose>
		<xsl:when test = '@type = "Date"'></xsl:when>
		<xsl:otherwise>this.<xsl:value-of select="@name"/> =request.getParameter("<xsl:value-of select="@name"/>");
		</xsl:otherwise>
		</xsl:choose>
		</xsl:for-each>
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		<xsl:for-each select="contents/field">			
		<xsl:choose>
		<xsl:when test = '@type = "Date"'></xsl:when>
		<xsl:otherwise>this.<xsl:value-of select="@name"/> =KJFMi.dsGet(ds, arg_row, "<xsl:value-of select="@name"/>");
		</xsl:otherwise>
		</xsl:choose>
		</xsl:for-each>		
    }    
    
//Getter 함수를 만든다
  <xsl:for-each select="contents/field">
     public <xsl:value-of select="@type"/> get<xsl:value-of select="@name"/>(){
             return <xsl:value-of select="@name"/>;
     };
  </xsl:for-each>

//Setter 함수를 만든다
  <xsl:for-each select="contents/field">
     public void set<xsl:value-of select="@name"/>(<xsl:value-of select="@type"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>){
            this.<xsl:value-of select="@name"/>=<xsl:value-of select="@name"/>;
     };
  </xsl:for-each>
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      <xsl:for-each select="contents/field">
      strB.append("<xsl:value-of select="@name"/>:"+ this.get<xsl:value-of select="@name"/>()+"\n");
      </xsl:for-each>
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return <xsl:value-of select='@name'/>Helper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return <xsl:value-of select='@name'/>Helper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return <xsl:value-of select='@name'/>Helper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return <xsl:value-of select='@name'/>Helper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return <xsl:value-of select='@name'/>Helper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[<xsl:value-of select="count(primarykey/key)"/>];
       <xsl:for-each select="primarykey/key">values[<xsl:value-of select='position()-1'/>]= this.get<xsl:value-of select="."/>();
       </xsl:for-each>
       return values;
      }
  public ValueObject getTemp(){
          return new <xsl:value-of select="@name"/>Entity();
  }

  public ValueObject getClone(){
         <xsl:value-of select="@name"/>Entity newEnt = new <xsl:value-of select="@name"/>Entity();
	 <xsl:for-each select="contents/field">
          newEnt.set<xsl:value-of select="@name"/>(this.get<xsl:value-of select="@name"/>());
         </xsl:for-each>
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)<xsl:value-of select='@name'/>Helper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        <xsl:for-each select="contents/field">
             case <xsl:value-of select='position()'/> :
                 return  this.get<xsl:value-of select="@name"/>();
        </xsl:for-each>
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)<xsl:value-of select='@name'/>Helper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        <xsl:for-each select="contents/field">
             case <xsl:value-of select='position()'/> :
                    this.set<xsl:value-of select="@name"/>((<xsl:value-of select='@type'/>)value);
	            return;  
        </xsl:for-each>
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return <xsl:value-of select='@name'/>Helper.toXML(this);
  }
  
}
</xsl:template>

<xsl:template match="key">
      <xsl:variable name="fieldType"><xsl:value-of select="."/></xsl:variable>
      <xsl:value-of select="//field[@name=$fieldType]/@type"/><xsl:text> </xsl:text><xsl:value-of select="."/>
</xsl:template>

</xsl:stylesheet>
