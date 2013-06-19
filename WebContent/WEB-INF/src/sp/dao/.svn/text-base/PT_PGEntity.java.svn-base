

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_PG
*  테이블 설명 :
*  테이블 PK   :  
*               PG_ID
*  테이블 컬럼 :  
*               PG_ID:NUMBER(10):  
*               PG_NAME:VARCHAR2(100):  
*               PG_URL:VARCHAR2(200):  
*               UPD_DT:DATE:  
*               USE_YN:VARCHAR2(1):  
*               ORDER_SEQ:NUMBER(22):  
*               PG_GROUP_ID:VARCHAR2(5):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_PGEntity extends ValueObject{

  
     private String PG_ID;
  
     private String PG_NAME;
  
     private String PG_URL;
  
     private Date UPD_DT;
  
     private String USE_YN;
  
     private String ORDER_SEQ;
  
     private String PG_GROUP_ID;
  

//생성자를 만든다
    public PT_PGEntity(){
    }
    
    
    public PT_PGEntity(String PG_ID ){
       this.setPG_ID(PG_ID);
       
    }
      
    public PT_PGEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("PG_ID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("PG_ID",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.PG_ID =request.getParameter("PG_ID");
		this.PG_NAME =request.getParameter("PG_NAME");
		this.PG_URL =request.getParameter("PG_URL");
		this.USE_YN =request.getParameter("USE_YN");
		this.ORDER_SEQ =request.getParameter("ORDER_SEQ");
		this.PG_GROUP_ID =request.getParameter("PG_GROUP_ID");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.PG_ID =KJFMi.dsGet(ds, arg_row, "PG_ID");
		this.PG_NAME =KJFMi.dsGet(ds, arg_row, "PG_NAME");
		this.PG_URL =KJFMi.dsGet(ds, arg_row, "PG_URL");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
		this.ORDER_SEQ =KJFMi.dsGet(ds, arg_row, "ORDER_SEQ");
		this.PG_GROUP_ID =KJFMi.dsGet(ds, arg_row, "PG_GROUP_ID");
				
    }    
    
//Getter 함수를 만든다
  
     public String getPG_ID(){
             return PG_ID;
     };
  
     public String getPG_NAME(){
             return PG_NAME;
     };
  
     public String getPG_URL(){
             return PG_URL;
     };
  
     public Date getUPD_DT(){
             return UPD_DT;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  
     public String getORDER_SEQ(){
             return ORDER_SEQ;
     };
  
     public String getPG_GROUP_ID(){
             return PG_GROUP_ID;
     };
  

//Setter 함수를 만든다
  
     public void setPG_ID(String PG_ID){
            this.PG_ID=PG_ID;
     };
  
     public void setPG_NAME(String PG_NAME){
            this.PG_NAME=PG_NAME;
     };
  
     public void setPG_URL(String PG_URL){
            this.PG_URL=PG_URL;
     };
  
     public void setUPD_DT(Date UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
     public void setORDER_SEQ(String ORDER_SEQ){
            this.ORDER_SEQ=ORDER_SEQ;
     };
  
     public void setPG_GROUP_ID(String PG_GROUP_ID){
            this.PG_GROUP_ID=PG_GROUP_ID;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("PG_ID:"+ this.getPG_ID()+"\n");
      
      strB.append("PG_NAME:"+ this.getPG_NAME()+"\n");
      
      strB.append("PG_URL:"+ this.getPG_URL()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      strB.append("ORDER_SEQ:"+ this.getORDER_SEQ()+"\n");
      
      strB.append("PG_GROUP_ID:"+ this.getPG_GROUP_ID()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_PGHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_PGHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_PGHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_PGHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_PGHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getPG_ID();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_PGEntity();
  }

  public ValueObject getClone(){
         PT_PGEntity newEnt = new PT_PGEntity();
	 
          newEnt.setPG_ID(this.getPG_ID());
         
          newEnt.setPG_NAME(this.getPG_NAME());
         
          newEnt.setPG_URL(this.getPG_URL());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
          newEnt.setORDER_SEQ(this.getORDER_SEQ());
         
          newEnt.setPG_GROUP_ID(this.getPG_GROUP_ID());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_PGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getPG_ID();
        
             case 2 :
                 return  this.getPG_NAME();
        
             case 3 :
                 return  this.getPG_URL();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getUSE_YN();
        
             case 6 :
                 return  this.getORDER_SEQ();
        
             case 7 :
                 return  this.getPG_GROUP_ID();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_PGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setPG_ID((String)value);
	            return;  
        
             case 2 :
                    this.setPG_NAME((String)value);
	            return;  
        
             case 3 :
                    this.setPG_URL((String)value);
	            return;  
        
             case 4 :
                    this.setUPD_DT((Date)value);
	            return;  
        
             case 5 :
                    this.setUSE_YN((String)value);
	            return;  
        
             case 6 :
                    this.setORDER_SEQ((String)value);
	            return;  
        
             case 7 :
                    this.setPG_GROUP_ID((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_PGHelper.toXML(this);
  }
  
}
