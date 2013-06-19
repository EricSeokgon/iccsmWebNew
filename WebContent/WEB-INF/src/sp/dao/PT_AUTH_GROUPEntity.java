

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_AUTH_GROUP
*  테이블 설명 :
*  테이블 PK   :  
*               AUTH_GROUP_CODE
*  테이블 컬럼 :  
*               AUTH_GROUP_CODE:VARCHAR2(5):  
*               AUTH_GROUP_NAME:VARCHAR2(30):  
*               ORDER_SEQ:NUMBER(11):  
*               UPD_DT:VARCHAR2(24):  
*               USE_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_AUTH_GROUPEntity extends ValueObject{

  
     private String AUTH_GROUP_CODE;
  
     private String AUTH_GROUP_NAME;
  
     private String ORDER_SEQ;
  
     private String UPD_DT;
  
     private String USE_YN;
  

//생성자를 만든다
    public PT_AUTH_GROUPEntity(){
    }
    
    
    public PT_AUTH_GROUPEntity(String AUTH_GROUP_CODE ){
       this.setAUTH_GROUP_CODE(AUTH_GROUP_CODE);
       
    }
      
    public PT_AUTH_GROUPEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("AUTH_GROUP_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("AUTH_GROUP_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.AUTH_GROUP_CODE =request.getParameter("AUTH_GROUP_CODE");
		this.AUTH_GROUP_NAME =request.getParameter("AUTH_GROUP_NAME");
		this.ORDER_SEQ =request.getParameter("ORDER_SEQ");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.USE_YN =request.getParameter("USE_YN");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.AUTH_GROUP_CODE =KJFMi.dsGet(ds, arg_row, "AUTH_GROUP_CODE");
		this.AUTH_GROUP_NAME =KJFMi.dsGet(ds, arg_row, "AUTH_GROUP_NAME");
		this.ORDER_SEQ =KJFMi.dsGet(ds, arg_row, "ORDER_SEQ");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
				
    }    
    
//Getter 함수를 만든다
  
     public String getAUTH_GROUP_CODE(){
             return AUTH_GROUP_CODE;
     };
  
     public String getAUTH_GROUP_NAME(){
             return AUTH_GROUP_NAME;
     };
  
     public String getORDER_SEQ(){
             return ORDER_SEQ;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  

//Setter 함수를 만든다
  
     public void setAUTH_GROUP_CODE(String AUTH_GROUP_CODE){
            this.AUTH_GROUP_CODE=AUTH_GROUP_CODE;
     };
  
     public void setAUTH_GROUP_NAME(String AUTH_GROUP_NAME){
            this.AUTH_GROUP_NAME=AUTH_GROUP_NAME;
     };
  
     public void setORDER_SEQ(String ORDER_SEQ){
            this.ORDER_SEQ=ORDER_SEQ;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("AUTH_GROUP_CODE:"+ this.getAUTH_GROUP_CODE()+"\n");
      
      strB.append("AUTH_GROUP_NAME:"+ this.getAUTH_GROUP_NAME()+"\n");
      
      strB.append("ORDER_SEQ:"+ this.getORDER_SEQ()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_AUTH_GROUPHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_AUTH_GROUPHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_AUTH_GROUPHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_AUTH_GROUPHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_AUTH_GROUPHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getAUTH_GROUP_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_AUTH_GROUPEntity();
  }

  public ValueObject getClone(){
         PT_AUTH_GROUPEntity newEnt = new PT_AUTH_GROUPEntity();
	 
          newEnt.setAUTH_GROUP_CODE(this.getAUTH_GROUP_CODE());
         
          newEnt.setAUTH_GROUP_NAME(this.getAUTH_GROUP_NAME());
         
          newEnt.setORDER_SEQ(this.getORDER_SEQ());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_AUTH_GROUPHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getAUTH_GROUP_CODE();
        
             case 2 :
                 return  this.getAUTH_GROUP_NAME();
        
             case 3 :
                 return  this.getORDER_SEQ();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getUSE_YN();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_AUTH_GROUPHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setAUTH_GROUP_CODE((String)value);
	            return;  
        
             case 2 :
                    this.setAUTH_GROUP_NAME((String)value);
	            return;  
        
             case 3 :
                    this.setORDER_SEQ((String)value);
	            return;  
        
             case 4 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 5 :
                    this.setUSE_YN((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_AUTH_GROUPHelper.toXML(this);
  }
  
}
