

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_XML
*  테이블 설명 :
*  테이블 PK   :  
*               DSNAME  
*               FORMID  
*               SAMPLENAME  
*               USERID
*  테이블 컬럼 :  
*               USERID:VARCHAR2(50):  
*               FORMID:VARCHAR2(50):  
*               SAMPLENAME:VARCHAR2(50):  
*               XML:VARCHAR2(4000):  
*               DSNAME:VARCHAR2(50):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_XMLEntity extends ValueObject{

  
     private String USERID;
  
     private String FORMID;
  
     private String SAMPLENAME;
  
     private String XML;
  
     private String DSNAME;
  

//생성자를 만든다
    public PT_XMLEntity(){
    }
    
    
    public PT_XMLEntity(String DSNAME,String FORMID,String SAMPLENAME,String USERID ){
       this.setDSNAME(DSNAME);
       this.setFORMID(FORMID);
       this.setSAMPLENAME(SAMPLENAME);
       this.setUSERID(USERID);
       
    }
      
    public PT_XMLEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("DSNAME");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("DSNAME",value);
       
       value = ent.getByName("FORMID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("FORMID",value);
       
       value = ent.getByName("SAMPLENAME");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SAMPLENAME",value);
       
       value = ent.getByName("USERID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("USERID",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.USERID =request.getParameter("USERID");
		this.FORMID =request.getParameter("FORMID");
		this.SAMPLENAME =request.getParameter("SAMPLENAME");
		this.XML =request.getParameter("XML");
		this.DSNAME =request.getParameter("DSNAME");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.USERID =KJFMi.dsGet(ds, arg_row, "USERID");
		this.FORMID =KJFMi.dsGet(ds, arg_row, "FORMID");
		this.SAMPLENAME =KJFMi.dsGet(ds, arg_row, "SAMPLENAME");
		this.XML =KJFMi.dsGet(ds, arg_row, "XML");
		this.DSNAME =KJFMi.dsGet(ds, arg_row, "DSNAME");
				
    }    
    
//Getter 함수를 만든다
  
     public String getUSERID(){
             return USERID;
     };
  
     public String getFORMID(){
             return FORMID;
     };
  
     public String getSAMPLENAME(){
             return SAMPLENAME;
     };
  
     public String getXML(){
             return XML;
     };
  
     public String getDSNAME(){
             return DSNAME;
     };
  

//Setter 함수를 만든다
  
     public void setUSERID(String USERID){
            this.USERID=USERID;
     };
  
     public void setFORMID(String FORMID){
            this.FORMID=FORMID;
     };
  
     public void setSAMPLENAME(String SAMPLENAME){
            this.SAMPLENAME=SAMPLENAME;
     };
  
     public void setXML(String XML){
            this.XML=XML;
     };
  
     public void setDSNAME(String DSNAME){
            this.DSNAME=DSNAME;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("USERID:"+ this.getUSERID()+"\n");
      
      strB.append("FORMID:"+ this.getFORMID()+"\n");
      
      strB.append("SAMPLENAME:"+ this.getSAMPLENAME()+"\n");
      
      strB.append("XML:"+ this.getXML()+"\n");
      
      strB.append("DSNAME:"+ this.getDSNAME()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_XMLHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_XMLHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_XMLHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_XMLHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_XMLHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[4];
       values[0]= this.getDSNAME();
       values[1]= this.getFORMID();
       values[2]= this.getSAMPLENAME();
       values[3]= this.getUSERID();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_XMLEntity();
  }

  public ValueObject getClone(){
         PT_XMLEntity newEnt = new PT_XMLEntity();
	 
          newEnt.setUSERID(this.getUSERID());
         
          newEnt.setFORMID(this.getFORMID());
         
          newEnt.setSAMPLENAME(this.getSAMPLENAME());
         
          newEnt.setXML(this.getXML());
         
          newEnt.setDSNAME(this.getDSNAME());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_XMLHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getUSERID();
        
             case 2 :
                 return  this.getFORMID();
        
             case 3 :
                 return  this.getSAMPLENAME();
        
             case 4 :
                 return  this.getXML();
        
             case 5 :
                 return  this.getDSNAME();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_XMLHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setUSERID((String)value);
	            return;  
        
             case 2 :
                    this.setFORMID((String)value);
	            return;  
        
             case 3 :
                    this.setSAMPLENAME((String)value);
	            return;  
        
             case 4 :
                    this.setXML((String)value);
	            return;  
        
             case 5 :
                    this.setDSNAME((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_XMLHelper.toXML(this);
  }
  
}
