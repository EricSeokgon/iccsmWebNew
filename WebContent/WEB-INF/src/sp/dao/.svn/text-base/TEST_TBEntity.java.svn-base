

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :TEST_TB
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               JUMIN:VARCHAR2(32):  
*               JUMIN_ENCODE:VARCHAR2(50):  
*               JUMIN_JAVA:VARCHAR2(50):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class TEST_TBEntity extends ValueObject{

  
     private String JUMIN;
  
     private String JUMIN_ENCODE;
  
     private String JUMIN_JAVA;
  

//생성자를 만든다
    public TEST_TBEntity(){
    }
    
      
    public TEST_TBEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.JUMIN =request.getParameter("JUMIN");
		this.JUMIN_ENCODE =request.getParameter("JUMIN_ENCODE");
		this.JUMIN_JAVA =request.getParameter("JUMIN_JAVA");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.JUMIN =KJFMi.dsGet(ds, arg_row, "JUMIN");
		this.JUMIN_ENCODE =KJFMi.dsGet(ds, arg_row, "JUMIN_ENCODE");
		this.JUMIN_JAVA =KJFMi.dsGet(ds, arg_row, "JUMIN_JAVA");
				
    }    
    
//Getter 함수를 만든다
  
     public String getJUMIN(){
             return JUMIN;
     };
  
     public String getJUMIN_ENCODE(){
             return JUMIN_ENCODE;
     };
  
     public String getJUMIN_JAVA(){
             return JUMIN_JAVA;
     };
  

//Setter 함수를 만든다
  
     public void setJUMIN(String JUMIN){
            this.JUMIN=JUMIN;
     };
  
     public void setJUMIN_ENCODE(String JUMIN_ENCODE){
            this.JUMIN_ENCODE=JUMIN_ENCODE;
     };
  
     public void setJUMIN_JAVA(String JUMIN_JAVA){
            this.JUMIN_JAVA=JUMIN_JAVA;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("JUMIN:"+ this.getJUMIN()+"\n");
      
      strB.append("JUMIN_ENCODE:"+ this.getJUMIN_ENCODE()+"\n");
      
      strB.append("JUMIN_JAVA:"+ this.getJUMIN_JAVA()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return TEST_TBHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return TEST_TBHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return TEST_TBHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return TEST_TBHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return TEST_TBHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[0];
       
       return values;
      }
  public ValueObject getTemp(){
          return new TEST_TBEntity();
  }

  public ValueObject getClone(){
         TEST_TBEntity newEnt = new TEST_TBEntity();
	 
          newEnt.setJUMIN(this.getJUMIN());
         
          newEnt.setJUMIN_ENCODE(this.getJUMIN_ENCODE());
         
          newEnt.setJUMIN_JAVA(this.getJUMIN_JAVA());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)TEST_TBHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getJUMIN();
        
             case 2 :
                 return  this.getJUMIN_ENCODE();
        
             case 3 :
                 return  this.getJUMIN_JAVA();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)TEST_TBHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setJUMIN((String)value);
	            return;  
        
             case 2 :
                    this.setJUMIN_ENCODE((String)value);
	            return;  
        
             case 3 :
                    this.setJUMIN_JAVA((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return TEST_TBHelper.toXML(this);
  }
  
}
