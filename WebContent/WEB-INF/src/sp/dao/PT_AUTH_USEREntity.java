

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_AUTH_USER
*  테이블 설명 :
*  테이블 PK   :  
*               PG_ID  
*               USER_ID
*  테이블 컬럼 :  
*               USER_ID:VARCHAR2(30):  
*               PG_ID:VARCHAR2(5):  
*               PG_GROUP_ID:VARCHAR2(5):  
*               READ_FLAG:VARCHAR2(1):  
*               WRITE_FLAG:VARCHAR2(1):  
*               COM_FLAG:VARCHAR2(1):  
*               UPD_DT:DATE:
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_AUTH_USEREntity extends ValueObject{

  
     private String USER_ID;
  
     private String PG_ID;
  
     private String PG_GROUP_ID;
  
     private String READ_FLAG;
  
     private String WRITE_FLAG;
  
     private String COM_FLAG;
  
     private Date UPD_DT;
  

//생성자를 만든다
    public PT_AUTH_USEREntity(){
    }
    
    
    public PT_AUTH_USEREntity(String PG_ID,String USER_ID ){
       this.setPG_ID(PG_ID);
       this.setUSER_ID(USER_ID);
       
    }
      
    public PT_AUTH_USEREntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("PG_ID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("PG_ID",value);
       
       value = ent.getByName("USER_ID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("USER_ID",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.USER_ID =request.getParameter("USER_ID");
		this.PG_ID =request.getParameter("PG_ID");
		this.PG_GROUP_ID =request.getParameter("PG_GROUP_ID");
		this.READ_FLAG =request.getParameter("READ_FLAG");
		this.WRITE_FLAG =request.getParameter("WRITE_FLAG");
		this.COM_FLAG =request.getParameter("COM_FLAG");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.USER_ID =KJFMi.dsGet(ds, arg_row, "USER_ID");
		this.PG_ID =KJFMi.dsGet(ds, arg_row, "PG_ID");
		this.PG_GROUP_ID =KJFMi.dsGet(ds, arg_row, "PG_GROUP_ID");
		this.READ_FLAG =KJFMi.dsGet(ds, arg_row, "READ_FLAG");
		this.WRITE_FLAG =KJFMi.dsGet(ds, arg_row, "WRITE_FLAG");
		this.COM_FLAG =KJFMi.dsGet(ds, arg_row, "COM_FLAG");
				
    }    
    
//Getter 함수를 만든다
  
     public String getUSER_ID(){
             return USER_ID;
     };
  
     public String getPG_ID(){
             return PG_ID;
     };
  
     public String getPG_GROUP_ID(){
             return PG_GROUP_ID;
     };
  
     public String getREAD_FLAG(){
             return READ_FLAG;
     };
  
     public String getWRITE_FLAG(){
             return WRITE_FLAG;
     };
  
     public String getCOM_FLAG(){
             return COM_FLAG;
     };
  
     public Date getUPD_DT(){
             return UPD_DT;
     };
  

//Setter 함수를 만든다
  
     public void setUSER_ID(String USER_ID){
            this.USER_ID=USER_ID;
     };
  
     public void setPG_ID(String PG_ID){
            this.PG_ID=PG_ID;
     };
  
     public void setPG_GROUP_ID(String PG_GROUP_ID){
            this.PG_GROUP_ID=PG_GROUP_ID;
     };
  
     public void setREAD_FLAG(String READ_FLAG){
            this.READ_FLAG=READ_FLAG;
     };
  
     public void setWRITE_FLAG(String WRITE_FLAG){
            this.WRITE_FLAG=WRITE_FLAG;
     };
  
     public void setCOM_FLAG(String COM_FLAG){
            this.COM_FLAG=COM_FLAG;
     };
  
     public void setUPD_DT(Date UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("USER_ID:"+ this.getUSER_ID()+"\n");
      
      strB.append("PG_ID:"+ this.getPG_ID()+"\n");
      
      strB.append("PG_GROUP_ID:"+ this.getPG_GROUP_ID()+"\n");
      
      strB.append("READ_FLAG:"+ this.getREAD_FLAG()+"\n");
      
      strB.append("WRITE_FLAG:"+ this.getWRITE_FLAG()+"\n");
      
      strB.append("COM_FLAG:"+ this.getCOM_FLAG()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_AUTH_USERHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_AUTH_USERHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_AUTH_USERHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_AUTH_USERHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_AUTH_USERHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getPG_ID();
       values[1]= this.getUSER_ID();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_AUTH_USEREntity();
  }

  public ValueObject getClone(){
         PT_AUTH_USEREntity newEnt = new PT_AUTH_USEREntity();
	 
          newEnt.setUSER_ID(this.getUSER_ID());
         
          newEnt.setPG_ID(this.getPG_ID());
         
          newEnt.setPG_GROUP_ID(this.getPG_GROUP_ID());
         
          newEnt.setREAD_FLAG(this.getREAD_FLAG());
         
          newEnt.setWRITE_FLAG(this.getWRITE_FLAG());
         
          newEnt.setCOM_FLAG(this.getCOM_FLAG());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_AUTH_USERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getUSER_ID();
        
             case 2 :
                 return  this.getPG_ID();
        
             case 3 :
                 return  this.getPG_GROUP_ID();
        
             case 4 :
                 return  this.getREAD_FLAG();
        
             case 5 :
                 return  this.getWRITE_FLAG();
        
             case 6 :
                 return  this.getCOM_FLAG();
        
             case 7 :
                 return  this.getUPD_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_AUTH_USERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setUSER_ID((String)value);
	            return;  
        
             case 2 :
                    this.setPG_ID((String)value);
	            return;  
        
             case 3 :
                    this.setPG_GROUP_ID((String)value);
	            return;  
        
             case 4 :
                    this.setREAD_FLAG((String)value);
	            return;  
        
             case 5 :
                    this.setWRITE_FLAG((String)value);
	            return;  
        
             case 6 :
                    this.setCOM_FLAG((String)value);
	            return;  
        
             case 7 :
                    this.setUPD_DT((Date)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_AUTH_USERHelper.toXML(this);
  }
  
}
