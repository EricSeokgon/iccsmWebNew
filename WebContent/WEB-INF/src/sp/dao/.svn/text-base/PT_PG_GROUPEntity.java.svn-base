

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_PG_GROUP
*  테이블 설명 :
*  테이블 PK   :  
*               PG_GROUP_ID
*  테이블 컬럼 :  
*               PG_GROUP_ID:VARCHAR2(5):  
*               P_PG_GROUP_ID:VARCHAR2(5):  
*               GROUP_NAME:VARCHAR2(100):  
*               UPD_DT:DATE:  
*               PG_GROUP_URL:VARCHAR2(100):  
*               USE_YN:VARCHAR2(1):  
*               ORDER_SEQ:NUMBER(11):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_PG_GROUPEntity extends ValueObject{

  
     private String PG_GROUP_ID;
  
     private String P_PG_GROUP_ID;
  
     private String GROUP_NAME;
  
     private Date UPD_DT;
  
     private String PG_GROUP_URL;
  
     private String USE_YN;
  
     private String ORDER_SEQ;
  

//생성자를 만든다
    public PT_PG_GROUPEntity(){
    }
    
    
    public PT_PG_GROUPEntity(String PG_GROUP_ID ){
       this.setPG_GROUP_ID(PG_GROUP_ID);
       
    }
      
    public PT_PG_GROUPEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("PG_GROUP_ID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("PG_GROUP_ID",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.PG_GROUP_ID =request.getParameter("PG_GROUP_ID");
		this.P_PG_GROUP_ID =request.getParameter("P_PG_GROUP_ID");
		this.GROUP_NAME =request.getParameter("GROUP_NAME");
		this.PG_GROUP_URL =request.getParameter("PG_GROUP_URL");
		this.USE_YN =request.getParameter("USE_YN");
		this.ORDER_SEQ =request.getParameter("ORDER_SEQ");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.PG_GROUP_ID =KJFMi.dsGet(ds, arg_row, "PG_GROUP_ID");
		this.P_PG_GROUP_ID =KJFMi.dsGet(ds, arg_row, "P_PG_GROUP_ID");
		this.GROUP_NAME =KJFMi.dsGet(ds, arg_row, "GROUP_NAME");
		this.PG_GROUP_URL =KJFMi.dsGet(ds, arg_row, "PG_GROUP_URL");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
		this.ORDER_SEQ =KJFMi.dsGet(ds, arg_row, "ORDER_SEQ");
				
    }    
    
//Getter 함수를 만든다
  
     public String getPG_GROUP_ID(){
             return PG_GROUP_ID;
     };
  
     public String getP_PG_GROUP_ID(){
             return P_PG_GROUP_ID;
     };
  
     public String getGROUP_NAME(){
             return GROUP_NAME;
     };
  
     public Date getUPD_DT(){
             return UPD_DT;
     };
  
     public String getPG_GROUP_URL(){
             return PG_GROUP_URL;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  
     public String getORDER_SEQ(){
             return ORDER_SEQ;
     };
  

//Setter 함수를 만든다
  
     public void setPG_GROUP_ID(String PG_GROUP_ID){
            this.PG_GROUP_ID=PG_GROUP_ID;
     };
  
     public void setP_PG_GROUP_ID(String P_PG_GROUP_ID){
            this.P_PG_GROUP_ID=P_PG_GROUP_ID;
     };
  
     public void setGROUP_NAME(String GROUP_NAME){
            this.GROUP_NAME=GROUP_NAME;
     };
  
     public void setUPD_DT(Date UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setPG_GROUP_URL(String PG_GROUP_URL){
            this.PG_GROUP_URL=PG_GROUP_URL;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
     public void setORDER_SEQ(String ORDER_SEQ){
            this.ORDER_SEQ=ORDER_SEQ;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("PG_GROUP_ID:"+ this.getPG_GROUP_ID()+"\n");
      
      strB.append("P_PG_GROUP_ID:"+ this.getP_PG_GROUP_ID()+"\n");
      
      strB.append("GROUP_NAME:"+ this.getGROUP_NAME()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("PG_GROUP_URL:"+ this.getPG_GROUP_URL()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      strB.append("ORDER_SEQ:"+ this.getORDER_SEQ()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_PG_GROUPHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_PG_GROUPHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_PG_GROUPHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_PG_GROUPHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_PG_GROUPHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getPG_GROUP_ID();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_PG_GROUPEntity();
  }

  public ValueObject getClone(){
         PT_PG_GROUPEntity newEnt = new PT_PG_GROUPEntity();
	 
          newEnt.setPG_GROUP_ID(this.getPG_GROUP_ID());
         
          newEnt.setP_PG_GROUP_ID(this.getP_PG_GROUP_ID());
         
          newEnt.setGROUP_NAME(this.getGROUP_NAME());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setPG_GROUP_URL(this.getPG_GROUP_URL());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
          newEnt.setORDER_SEQ(this.getORDER_SEQ());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_PG_GROUPHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getPG_GROUP_ID();
        
             case 2 :
                 return  this.getP_PG_GROUP_ID();
        
             case 3 :
                 return  this.getGROUP_NAME();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getPG_GROUP_URL();
        
             case 6 :
                 return  this.getUSE_YN();
        
             case 7 :
                 return  this.getORDER_SEQ();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_PG_GROUPHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setPG_GROUP_ID((String)value);
	            return;  
        
             case 2 :
                    this.setP_PG_GROUP_ID((String)value);
	            return;  
        
             case 3 :
                    this.setGROUP_NAME((String)value);
	            return;  
        
             case 4 :
                    this.setUPD_DT((Date)value);
	            return;  
        
             case 5 :
                    this.setPG_GROUP_URL((String)value);
	            return;  
        
             case 6 :
                    this.setUSE_YN((String)value);
	            return;  
        
             case 7 :
                    this.setORDER_SEQ((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_PG_GROUPHelper.toXML(this);
  }
  
}
