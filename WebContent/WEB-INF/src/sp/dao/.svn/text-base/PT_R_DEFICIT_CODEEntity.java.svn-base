

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_DEFICIT_CODE
*  테이블 설명 :
*  테이블 PK   :  
*               DEFI_CODE  
*               DEFI_GROUP
*  테이블 컬럼 :  
*               DEFI_CODE:VARCHAR2(6):  
*               CONT:VARCHAR2(500):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               DEFI_GROUP:VARCHAR2(6):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_DEFICIT_CODEEntity extends ValueObject{

  
     private String DEFI_CODE;
  
     private String CONT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String DEFI_GROUP;
  

//생성자를 만든다
    public PT_R_DEFICIT_CODEEntity(){
    }
    
    
    public PT_R_DEFICIT_CODEEntity(String DEFI_CODE,String DEFI_GROUP ){
       this.setDEFI_CODE(DEFI_CODE);
       this.setDEFI_GROUP(DEFI_GROUP);
       
    }
      
    public PT_R_DEFICIT_CODEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("DEFI_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("DEFI_CODE",value);
       
       value = ent.getByName("DEFI_GROUP");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("DEFI_GROUP",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.DEFI_CODE =request.getParameter("DEFI_CODE");
		this.CONT =request.getParameter("CONT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.DEFI_GROUP =request.getParameter("DEFI_GROUP");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.DEFI_CODE =KJFMi.dsGet(ds, arg_row, "DEFI_CODE");
		this.CONT =KJFMi.dsGet(ds, arg_row, "CONT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.DEFI_GROUP =KJFMi.dsGet(ds, arg_row, "DEFI_GROUP");
				
    }    
    
//Getter 함수를 만든다
  
     public String getDEFI_CODE(){
             return DEFI_CODE;
     };
  
     public String getCONT(){
             return CONT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getDEFI_GROUP(){
             return DEFI_GROUP;
     };
  

//Setter 함수를 만든다
  
     public void setDEFI_CODE(String DEFI_CODE){
            this.DEFI_CODE=DEFI_CODE;
     };
  
     public void setCONT(String CONT){
            this.CONT=CONT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setDEFI_GROUP(String DEFI_GROUP){
            this.DEFI_GROUP=DEFI_GROUP;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("DEFI_CODE:"+ this.getDEFI_CODE()+"\n");
      
      strB.append("CONT:"+ this.getCONT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("DEFI_GROUP:"+ this.getDEFI_GROUP()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_DEFICIT_CODEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_DEFICIT_CODEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_DEFICIT_CODEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_DEFICIT_CODEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_DEFICIT_CODEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getDEFI_CODE();
       values[1]= this.getDEFI_GROUP();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_DEFICIT_CODEEntity();
  }

  public ValueObject getClone(){
         PT_R_DEFICIT_CODEEntity newEnt = new PT_R_DEFICIT_CODEEntity();
	 
          newEnt.setDEFI_CODE(this.getDEFI_CODE());
         
          newEnt.setCONT(this.getCONT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setDEFI_GROUP(this.getDEFI_GROUP());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_DEFICIT_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getDEFI_CODE();
        
             case 2 :
                 return  this.getCONT();
        
             case 3 :
                 return  this.getWRT_ID();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getINS_DT();
        
             case 6 :
                 return  this.getDEFI_GROUP();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_DEFICIT_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setDEFI_CODE((String)value);
	            return;  
        
             case 2 :
                    this.setCONT((String)value);
	            return;  
        
             case 3 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 4 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 5 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 6 :
                    this.setDEFI_GROUP((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_DEFICIT_CODEHelper.toXML(this);
  }
  
}
