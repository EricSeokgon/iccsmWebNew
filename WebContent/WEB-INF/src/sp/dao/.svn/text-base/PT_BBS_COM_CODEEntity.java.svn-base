

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_COM_CODE
*  테이블 설명 :
*  테이블 PK   :  
*               CODE  
*               CODE_GROUP
*  테이블 컬럼 :  
*               CODE_GROUP:VARCHAR2(16):  
*               CODE:VARCHAR2(16):  
*               CODE_NAME:VARCHAR2(50):  
*               BIGO:VARCHAR2(100):  
*               ORDER_NUM:NUMBER(22):  
*               USE_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_BBS_COM_CODEEntity extends ValueObject{

  
     private String CODE_GROUP;
  
     private String CODE;
  
     private String CODE_NAME;
  
     private String BIGO;
  
     private String ORDER_NUM;
  
     private String USE_YN;
  

//생성자를 만든다
    public PT_BBS_COM_CODEEntity(){
    }
    
    
    public PT_BBS_COM_CODEEntity(String CODE,String CODE_GROUP ){
       this.setCODE(CODE);
       this.setCODE_GROUP(CODE_GROUP);
       
    }
      
    public PT_BBS_COM_CODEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CODE",value);
       
       value = ent.getByName("CODE_GROUP");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CODE_GROUP",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CODE_GROUP =request.getParameter("CODE_GROUP");
		this.CODE =request.getParameter("CODE");
		this.CODE_NAME =request.getParameter("CODE_NAME");
		this.BIGO =request.getParameter("BIGO");
		this.ORDER_NUM =request.getParameter("ORDER_NUM");
		this.USE_YN =request.getParameter("USE_YN");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CODE_GROUP =KJFMi.dsGet(ds, arg_row, "CODE_GROUP");
		this.CODE =KJFMi.dsGet(ds, arg_row, "CODE");
		this.CODE_NAME =KJFMi.dsGet(ds, arg_row, "CODE_NAME");
		this.BIGO =KJFMi.dsGet(ds, arg_row, "BIGO");
		this.ORDER_NUM =KJFMi.dsGet(ds, arg_row, "ORDER_NUM");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCODE_GROUP(){
             return CODE_GROUP;
     };
  
     public String getCODE(){
             return CODE;
     };
  
     public String getCODE_NAME(){
             return CODE_NAME;
     };
  
     public String getBIGO(){
             return BIGO;
     };
  
     public String getORDER_NUM(){
             return ORDER_NUM;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  

//Setter 함수를 만든다
  
     public void setCODE_GROUP(String CODE_GROUP){
            this.CODE_GROUP=CODE_GROUP;
     };
  
     public void setCODE(String CODE){
            this.CODE=CODE;
     };
  
     public void setCODE_NAME(String CODE_NAME){
            this.CODE_NAME=CODE_NAME;
     };
  
     public void setBIGO(String BIGO){
            this.BIGO=BIGO;
     };
  
     public void setORDER_NUM(String ORDER_NUM){
            this.ORDER_NUM=ORDER_NUM;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CODE_GROUP:"+ this.getCODE_GROUP()+"\n");
      
      strB.append("CODE:"+ this.getCODE()+"\n");
      
      strB.append("CODE_NAME:"+ this.getCODE_NAME()+"\n");
      
      strB.append("BIGO:"+ this.getBIGO()+"\n");
      
      strB.append("ORDER_NUM:"+ this.getORDER_NUM()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_BBS_COM_CODEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_BBS_COM_CODEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_BBS_COM_CODEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_BBS_COM_CODEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_BBS_COM_CODEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCODE();
       values[1]= this.getCODE_GROUP();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_BBS_COM_CODEEntity();
  }

  public ValueObject getClone(){
         PT_BBS_COM_CODEEntity newEnt = new PT_BBS_COM_CODEEntity();
	 
          newEnt.setCODE_GROUP(this.getCODE_GROUP());
         
          newEnt.setCODE(this.getCODE());
         
          newEnt.setCODE_NAME(this.getCODE_NAME());
         
          newEnt.setBIGO(this.getBIGO());
         
          newEnt.setORDER_NUM(this.getORDER_NUM());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_BBS_COM_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCODE_GROUP();
        
             case 2 :
                 return  this.getCODE();
        
             case 3 :
                 return  this.getCODE_NAME();
        
             case 4 :
                 return  this.getBIGO();
        
             case 5 :
                 return  this.getORDER_NUM();
        
             case 6 :
                 return  this.getUSE_YN();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_BBS_COM_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCODE_GROUP((String)value);
	            return;  
        
             case 2 :
                    this.setCODE((String)value);
	            return;  
        
             case 3 :
                    this.setCODE_NAME((String)value);
	            return;  
        
             case 4 :
                    this.setBIGO((String)value);
	            return;  
        
             case 5 :
                    this.setORDER_NUM((String)value);
	            return;  
        
             case 6 :
                    this.setUSE_YN((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_BBS_COM_CODEHelper.toXML(this);
  }
  
}
