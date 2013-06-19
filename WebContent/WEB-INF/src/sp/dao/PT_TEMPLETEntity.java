

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_TEMPLET
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               USERID:VARCHAR2(50):  
*               FORMID:VARCHAR2(50):  
*               SAMPLENAME:VARCHAR2(50):  
*               XML:VARCHAR2(256):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_TEMPLETEntity extends ValueObject{

  
     private String USERID;
  
     private String FORMID;
  
     private String SAMPLENAME;
  
     private String XML;
  

//생성자를 만든다
    public PT_TEMPLETEntity(){
    }
    
      
    public PT_TEMPLETEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.USERID =request.getParameter("USERID");
		this.FORMID =request.getParameter("FORMID");
		this.SAMPLENAME =request.getParameter("SAMPLENAME");
	
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.USERID =KJFMi.dsGet(ds, arg_row, "USERID");
		this.FORMID =KJFMi.dsGet(ds, arg_row, "FORMID");
		this.SAMPLENAME =KJFMi.dsGet(ds, arg_row, "SAMPLENAME");
		
				
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
  
     
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("USERID:"+ this.getUSERID()+"\n");
      
      strB.append("FORMID:"+ this.getFORMID()+"\n");
      
      strB.append("SAMPLENAME:"+ this.getSAMPLENAME()+"\n");
      
      
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_TEMPLETHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_TEMPLETHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_TEMPLETHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_TEMPLETHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_TEMPLETHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[0];
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_TEMPLETEntity();
  }

  public ValueObject getClone(){
         PT_TEMPLETEntity newEnt = new PT_TEMPLETEntity();
	 
          newEnt.setUSERID(this.getUSERID());
         
          newEnt.setFORMID(this.getFORMID());
         
          newEnt.setSAMPLENAME(this.getSAMPLENAME());
         
   
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_TEMPLETHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getUSERID();
        
             case 2 :
                 return  this.getFORMID();
        
             case 3 :
                 return  this.getSAMPLENAME();
        
          
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_TEMPLETHelper.fieldMap.get(key);
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
       
	          
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_TEMPLETHelper.toXML(this);
  }
  
}
