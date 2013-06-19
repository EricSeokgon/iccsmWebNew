

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_SM_PROGRAM_LOG
*  테이블 설명 :
*  테이블 PK   :  
*               LOG_NUM  
*               USER_CODE
*  테이블 컬럼 :  
*               LOG_NUM:NUMBER(22):  
*               USER_CODE:VARCHAR2(10):  
*               ACCESS_TIME:VARCHAR2(20):  
*               PROGRAM_ID:VARCHAR2(20):  
*               USER_ACTION:VARCHAR2(4):  
*               REQ_URI:VARCHAR2(128):  
*               USER_DATA:VARCHAR2(500):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class PT_SM_PROGRAM_LOGEntity extends ValueObject{

  
     private String LOG_NUM;
  
     private String USER_CODE;
  
     private String ACCESS_TIME;
  
     private String PROGRAM_ID;
  
     private String USER_ACTION;
  
     private String REQ_URI;
  
     private String USER_DATA;
  

//생성자를 만든다
    public PT_SM_PROGRAM_LOGEntity(){
    }
    public PT_SM_PROGRAM_LOGEntity(String LOG_NUM,String USER_CODE ){
       this.setLOG_NUM(LOG_NUM);
       this.setUSER_CODE(USER_CODE);
       
    }
    public PT_SM_PROGRAM_LOGEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("LOG_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("LOG_NUM",value);
       
       value = ent.getByName("USER_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("USER_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.LOG_NUM =request.getParameter("LOG_NUM");
		this.USER_CODE =request.getParameter("USER_CODE");
		this.ACCESS_TIME =request.getParameter("ACCESS_TIME");
		this.PROGRAM_ID =request.getParameter("PROGRAM_ID");
		this.USER_ACTION =request.getParameter("USER_ACTION");
		this.REQ_URI =request.getParameter("REQ_URI");
		this.USER_DATA =request.getParameter("USER_DATA");
		
    }
    
//Getter 함수를 만든다
  
     public String getLOG_NUM(){
             return LOG_NUM;
     };
  
     public String getUSER_CODE(){
             return USER_CODE;
     };
  
     public String getACCESS_TIME(){
             return ACCESS_TIME;
     };
  
     public String getPROGRAM_ID(){
             return PROGRAM_ID;
     };
  
     public String getUSER_ACTION(){
             return USER_ACTION;
     };
  
     public String getREQ_URI(){
             return REQ_URI;
     };
  
     public String getUSER_DATA(){
             return USER_DATA;
     };
  

//Setter 함수를 만든다
  
     public void setLOG_NUM(String LOG_NUM){
            this.LOG_NUM=LOG_NUM;
     };
  
     public void setUSER_CODE(String USER_CODE){
            this.USER_CODE=USER_CODE;
     };
  
     public void setACCESS_TIME(String ACCESS_TIME){
            this.ACCESS_TIME=ACCESS_TIME;
     };
  
     public void setPROGRAM_ID(String PROGRAM_ID){
            this.PROGRAM_ID=PROGRAM_ID;
     };
  
     public void setUSER_ACTION(String USER_ACTION){
            this.USER_ACTION=USER_ACTION;
     };
  
     public void setREQ_URI(String REQ_URI){
            this.REQ_URI=REQ_URI;
     };
  
     public void setUSER_DATA(String USER_DATA){
            this.USER_DATA=USER_DATA;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("LOG_NUM:"+ this.getLOG_NUM()+"\n");
      
      strB.append("USER_CODE:"+ this.getUSER_CODE()+"\n");
      
      strB.append("ACCESS_TIME:"+ this.getACCESS_TIME()+"\n");
      
      strB.append("PROGRAM_ID:"+ this.getPROGRAM_ID()+"\n");
      
      strB.append("USER_ACTION:"+ this.getUSER_ACTION()+"\n");
      
      strB.append("REQ_URI:"+ this.getREQ_URI()+"\n");
      
      strB.append("USER_DATA:"+ this.getUSER_DATA()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_SM_PROGRAM_LOGHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_SM_PROGRAM_LOGHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_SM_PROGRAM_LOGHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_SM_PROGRAM_LOGHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_SM_PROGRAM_LOGHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getLOG_NUM();
       values[1]= this.getUSER_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_SM_PROGRAM_LOGEntity();
  }

  public ValueObject getClone(){
         PT_SM_PROGRAM_LOGEntity newEnt = new PT_SM_PROGRAM_LOGEntity();
	 
          newEnt.setLOG_NUM(this.getLOG_NUM());
         
          newEnt.setUSER_CODE(this.getUSER_CODE());
         
          newEnt.setACCESS_TIME(this.getACCESS_TIME());
         
          newEnt.setPROGRAM_ID(this.getPROGRAM_ID());
         
          newEnt.setUSER_ACTION(this.getUSER_ACTION());
         
          newEnt.setREQ_URI(this.getREQ_URI());
         
          newEnt.setUSER_DATA(this.getUSER_DATA());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_SM_PROGRAM_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getLOG_NUM();
        
             case 2 :
                 return  this.getUSER_CODE();
        
             case 3 :
                 return  this.getACCESS_TIME();
        
             case 4 :
                 return  this.getPROGRAM_ID();
        
             case 5 :
                 return  this.getUSER_ACTION();
        
             case 6 :
                 return  this.getREQ_URI();
        
             case 7 :
                 return  this.getUSER_DATA();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_SM_PROGRAM_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setLOG_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setUSER_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setACCESS_TIME((String)value);
	            return;  
        
             case 4 :
                    this.setPROGRAM_ID((String)value);
	            return;  
        
             case 5 :
                    this.setUSER_ACTION((String)value);
	            return;  
        
             case 6 :
                    this.setREQ_URI((String)value);
	            return;  
        
             case 7 :
                    this.setUSER_DATA((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_SM_PROGRAM_LOGHelper.toXML(this);
  }
  
}
