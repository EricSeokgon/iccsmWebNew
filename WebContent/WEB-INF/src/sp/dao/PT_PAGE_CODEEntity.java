

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_PAGE_CODE
*  테이블 설명 :
*  테이블 PK   :  
*               CODE_GROUP_ID
*  테이블 컬럼 :  
*               CODE_GROUP_ID:NUMBER(22):  
*               CODE_GROUP:VARCHAR2(4):  
*               CODE:VARCHAR2(16):  
*               CODE_NAME:VARCHAR2(50):  
*               CODE_URL:VARCHAR2(100):  
*               ORDER_NUM:NUMBER(22):  
*               USE_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_PAGE_CODEEntity extends ValueObject{

  
     private String CODE_GROUP_ID;
  
     private String CODE_GROUP;
  
     private String CODE;
  
     private String CODE_NAME;
  
     private String CODE_URL;
  
     private String ORDER_NUM;
  
     private String USE_YN;
  

//생성자를 만든다
    public PT_PAGE_CODEEntity(){
    }
    
    
    public PT_PAGE_CODEEntity(String CODE_GROUP_ID ){
       this.setCODE_GROUP_ID(CODE_GROUP_ID);
       
    }
      
    public PT_PAGE_CODEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CODE_GROUP_ID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CODE_GROUP_ID",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CODE_GROUP_ID =request.getParameter("CODE_GROUP_ID");
		this.CODE_GROUP =request.getParameter("CODE_GROUP");
		this.CODE =request.getParameter("CODE");
		this.CODE_NAME =request.getParameter("CODE_NAME");
		this.CODE_URL =request.getParameter("CODE_URL");
		this.ORDER_NUM =request.getParameter("ORDER_NUM");
		this.USE_YN =request.getParameter("USE_YN");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CODE_GROUP_ID =KJFMi.dsGet(ds, arg_row, "CODE_GROUP_ID");
		this.CODE_GROUP =KJFMi.dsGet(ds, arg_row, "CODE_GROUP");
		this.CODE =KJFMi.dsGet(ds, arg_row, "CODE");
		this.CODE_NAME =KJFMi.dsGet(ds, arg_row, "CODE_NAME");
		this.CODE_URL =KJFMi.dsGet(ds, arg_row, "CODE_URL");
		this.ORDER_NUM =KJFMi.dsGet(ds, arg_row, "ORDER_NUM");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCODE_GROUP_ID(){
             return CODE_GROUP_ID;
     };
  
     public String getCODE_GROUP(){
             return CODE_GROUP;
     };
  
     public String getCODE(){
             return CODE;
     };
  
     public String getCODE_NAME(){
             return CODE_NAME;
     };
  
     public String getCODE_URL(){
             return CODE_URL;
     };
  
     public String getORDER_NUM(){
             return ORDER_NUM;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  

//Setter 함수를 만든다
  
     public void setCODE_GROUP_ID(String CODE_GROUP_ID){
            this.CODE_GROUP_ID=CODE_GROUP_ID;
     };
  
     public void setCODE_GROUP(String CODE_GROUP){
            this.CODE_GROUP=CODE_GROUP;
     };
  
     public void setCODE(String CODE){
            this.CODE=CODE;
     };
  
     public void setCODE_NAME(String CODE_NAME){
            this.CODE_NAME=CODE_NAME;
     };
  
     public void setCODE_URL(String CODE_URL){
            this.CODE_URL=CODE_URL;
     };
  
     public void setORDER_NUM(String ORDER_NUM){
            this.ORDER_NUM=ORDER_NUM;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CODE_GROUP_ID:"+ this.getCODE_GROUP_ID()+"\n");
      
      strB.append("CODE_GROUP:"+ this.getCODE_GROUP()+"\n");
      
      strB.append("CODE:"+ this.getCODE()+"\n");
      
      strB.append("CODE_NAME:"+ this.getCODE_NAME()+"\n");
      
      strB.append("CODE_URL:"+ this.getCODE_URL()+"\n");
      
      strB.append("ORDER_NUM:"+ this.getORDER_NUM()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_PAGE_CODEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_PAGE_CODEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_PAGE_CODEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_PAGE_CODEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_PAGE_CODEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getCODE_GROUP_ID();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_PAGE_CODEEntity();
  }

  public ValueObject getClone(){
         PT_PAGE_CODEEntity newEnt = new PT_PAGE_CODEEntity();
	 
          newEnt.setCODE_GROUP_ID(this.getCODE_GROUP_ID());
         
          newEnt.setCODE_GROUP(this.getCODE_GROUP());
         
          newEnt.setCODE(this.getCODE());
         
          newEnt.setCODE_NAME(this.getCODE_NAME());
         
          newEnt.setCODE_URL(this.getCODE_URL());
         
          newEnt.setORDER_NUM(this.getORDER_NUM());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_PAGE_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCODE_GROUP_ID();
        
             case 2 :
                 return  this.getCODE_GROUP();
        
             case 3 :
                 return  this.getCODE();
        
             case 4 :
                 return  this.getCODE_NAME();
        
             case 5 :
                 return  this.getCODE_URL();
        
             case 6 :
                 return  this.getORDER_NUM();
        
             case 7 :
                 return  this.getUSE_YN();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_PAGE_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCODE_GROUP_ID((String)value);
	            return;  
        
             case 2 :
                    this.setCODE_GROUP((String)value);
	            return;  
        
             case 3 :
                    this.setCODE((String)value);
	            return;  
        
             case 4 :
                    this.setCODE_NAME((String)value);
	            return;  
        
             case 5 :
                    this.setCODE_URL((String)value);
	            return;  
        
             case 6 :
                    this.setORDER_NUM((String)value);
	            return;  
        
             case 7 :
                    this.setUSE_YN((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_PAGE_CODEHelper.toXML(this);
  }
  
}
