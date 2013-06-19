

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_SM_USER_LOG
*  테이블 설명 :
*  테이블 PK   :  
*               LOG_NUM
*  테이블 컬럼 :  
*               LOG_NUM:NUMBER(11):  
*               USER_ID:VARCHAR2(16):  
*               ACCESS_TIME:VARCHAR2(20):  
*               END_TIME:VARCHAR2(20):  
*               ACCESS_IP:VARCHAR2(15):  
*               BROWSER:VARCHAR2(128):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_SM_USER_LOGEntity extends ValueObject{

  
     private String LOG_NUM;
  
     private String USER_ID;
  
     private String ACCESS_TIME;
  
     private String END_TIME;
  
     private String ACCESS_IP;
  
     private String BROWSER;
  

//생성자를 만든다
    public PT_SM_USER_LOGEntity(){
    }
    
    
    public PT_SM_USER_LOGEntity(String LOG_NUM ){
       this.setLOG_NUM(LOG_NUM);
       
    }
      
    public PT_SM_USER_LOGEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("LOG_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("LOG_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.LOG_NUM =request.getParameter("LOG_NUM");
		this.USER_ID =request.getParameter("USER_ID");
		this.ACCESS_TIME =request.getParameter("ACCESS_TIME");
		this.END_TIME =request.getParameter("END_TIME");
		this.ACCESS_IP =request.getParameter("ACCESS_IP");
		this.BROWSER =request.getParameter("BROWSER");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.LOG_NUM =KJFMi.dsGet(ds, arg_row, "LOG_NUM");
		this.USER_ID =KJFMi.dsGet(ds, arg_row, "USER_ID");
		this.ACCESS_TIME =KJFMi.dsGet(ds, arg_row, "ACCESS_TIME");
		this.END_TIME =KJFMi.dsGet(ds, arg_row, "END_TIME");
		this.ACCESS_IP =KJFMi.dsGet(ds, arg_row, "ACCESS_IP");
		this.BROWSER =KJFMi.dsGet(ds, arg_row, "BROWSER");
				
    }    
    
//Getter 함수를 만든다
  
     public String getLOG_NUM(){
             return LOG_NUM;
     };
  
     public String getUSER_ID(){
             return USER_ID;
     };
  
     public String getACCESS_TIME(){
             return ACCESS_TIME;
     };
  
     public String getEND_TIME(){
             return END_TIME;
     };
  
     public String getACCESS_IP(){
             return ACCESS_IP;
     };
  
     public String getBROWSER(){
             return BROWSER;
     };
  

//Setter 함수를 만든다
  
     public void setLOG_NUM(String LOG_NUM){
            this.LOG_NUM=LOG_NUM;
     };
  
     public void setUSER_ID(String USER_ID){
            this.USER_ID=USER_ID;
     };
  
     public void setACCESS_TIME(String ACCESS_TIME){
            this.ACCESS_TIME=ACCESS_TIME;
     };
  
     public void setEND_TIME(String END_TIME){
            this.END_TIME=END_TIME;
     };
  
     public void setACCESS_IP(String ACCESS_IP){
            this.ACCESS_IP=ACCESS_IP;
     };
  
     public void setBROWSER(String BROWSER){
            this.BROWSER=BROWSER;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("LOG_NUM:"+ this.getLOG_NUM()+"\n");
      
      strB.append("USER_ID:"+ this.getUSER_ID()+"\n");
      
      strB.append("ACCESS_TIME:"+ this.getACCESS_TIME()+"\n");
      
      strB.append("END_TIME:"+ this.getEND_TIME()+"\n");
      
      strB.append("ACCESS_IP:"+ this.getACCESS_IP()+"\n");
      
      strB.append("BROWSER:"+ this.getBROWSER()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_SM_USER_LOGHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_SM_USER_LOGHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_SM_USER_LOGHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_SM_USER_LOGHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_SM_USER_LOGHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getLOG_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_SM_USER_LOGEntity();
  }

  public ValueObject getClone(){
         PT_SM_USER_LOGEntity newEnt = new PT_SM_USER_LOGEntity();
	 
          newEnt.setLOG_NUM(this.getLOG_NUM());
         
          newEnt.setUSER_ID(this.getUSER_ID());
         
          newEnt.setACCESS_TIME(this.getACCESS_TIME());
         
          newEnt.setEND_TIME(this.getEND_TIME());
         
          newEnt.setACCESS_IP(this.getACCESS_IP());
         
          newEnt.setBROWSER(this.getBROWSER());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_SM_USER_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getLOG_NUM();
        
             case 2 :
                 return  this.getUSER_ID();
        
             case 3 :
                 return  this.getACCESS_TIME();
        
             case 4 :
                 return  this.getEND_TIME();
        
             case 5 :
                 return  this.getACCESS_IP();
        
             case 6 :
                 return  this.getBROWSER();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_SM_USER_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setLOG_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setUSER_ID((String)value);
	            return;  
        
             case 3 :
                    this.setACCESS_TIME((String)value);
	            return;  
        
             case 4 :
                    this.setEND_TIME((String)value);
	            return;  
        
             case 5 :
                    this.setACCESS_IP((String)value);
	            return;  
        
             case 6 :
                    this.setBROWSER((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_SM_USER_LOGHelper.toXML(this);
  }
  
}
