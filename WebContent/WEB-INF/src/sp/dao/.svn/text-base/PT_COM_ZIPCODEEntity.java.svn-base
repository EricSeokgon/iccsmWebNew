

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_COM_ZIPCODE
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(5):  
*               ZIPCODE:VARCHAR2(7):  
*               SIDO:VARCHAR2(6):  
*               GUGUN:VARCHAR2(30):  
*               DONG:VARCHAR2(100):  
*               BUNJI:VARCHAR2(30):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_COM_ZIPCODEEntity extends ValueObject{

  
     private String SEQ;
  
     private String ZIPCODE;
  
     private String SIDO;
  
     private String GUGUN;
  
     private String DONG;
  
     private String BUNJI;
  

//생성자를 만든다
    public PT_COM_ZIPCODEEntity(){
    }
    
      
    public PT_COM_ZIPCODEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.ZIPCODE =request.getParameter("ZIPCODE");
		this.SIDO =request.getParameter("SIDO");
		this.GUGUN =request.getParameter("GUGUN");
		this.DONG =request.getParameter("DONG");
		this.BUNJI =request.getParameter("BUNJI");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ZIPCODE =KJFMi.dsGet(ds, arg_row, "ZIPCODE");
		this.SIDO =KJFMi.dsGet(ds, arg_row, "SIDO");
		this.GUGUN =KJFMi.dsGet(ds, arg_row, "GUGUN");
		this.DONG =KJFMi.dsGet(ds, arg_row, "DONG");
		this.BUNJI =KJFMi.dsGet(ds, arg_row, "BUNJI");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getZIPCODE(){
             return ZIPCODE;
     };
  
     public String getSIDO(){
             return SIDO;
     };
  
     public String getGUGUN(){
             return GUGUN;
     };
  
     public String getDONG(){
             return DONG;
     };
  
     public String getBUNJI(){
             return BUNJI;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setZIPCODE(String ZIPCODE){
            this.ZIPCODE=ZIPCODE;
     };
  
     public void setSIDO(String SIDO){
            this.SIDO=SIDO;
     };
  
     public void setGUGUN(String GUGUN){
            this.GUGUN=GUGUN;
     };
  
     public void setDONG(String DONG){
            this.DONG=DONG;
     };
  
     public void setBUNJI(String BUNJI){
            this.BUNJI=BUNJI;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ZIPCODE:"+ this.getZIPCODE()+"\n");
      
      strB.append("SIDO:"+ this.getSIDO()+"\n");
      
      strB.append("GUGUN:"+ this.getGUGUN()+"\n");
      
      strB.append("DONG:"+ this.getDONG()+"\n");
      
      strB.append("BUNJI:"+ this.getBUNJI()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_COM_ZIPCODEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_COM_ZIPCODEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_COM_ZIPCODEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_COM_ZIPCODEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_COM_ZIPCODEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[0];
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_COM_ZIPCODEEntity();
  }

  public ValueObject getClone(){
         PT_COM_ZIPCODEEntity newEnt = new PT_COM_ZIPCODEEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setZIPCODE(this.getZIPCODE());
         
          newEnt.setSIDO(this.getSIDO());
         
          newEnt.setGUGUN(this.getGUGUN());
         
          newEnt.setDONG(this.getDONG());
         
          newEnt.setBUNJI(this.getBUNJI());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_COM_ZIPCODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getZIPCODE();
        
             case 3 :
                 return  this.getSIDO();
        
             case 4 :
                 return  this.getGUGUN();
        
             case 5 :
                 return  this.getDONG();
        
             case 6 :
                 return  this.getBUNJI();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_COM_ZIPCODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setZIPCODE((String)value);
	            return;  
        
             case 3 :
                    this.setSIDO((String)value);
	            return;  
        
             case 4 :
                    this.setGUGUN((String)value);
	            return;  
        
             case 5 :
                    this.setDONG((String)value);
	            return;  
        
             case 6 :
                    this.setBUNJI((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_COM_ZIPCODEHelper.toXML(this);
  }
  
}
