

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_OTOB_COM_CODE
*  테이블 설명 :
*  테이블 PK   :  
*               OTOB_COM_CODE
*  테이블 컬럼 :  
*               OTOB_COM_CODE:VARCHAR2(6):  
*               OTOB_COM_TOB_CONT:VARCHAR2(50):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_OTOB_COM_CODEEntity extends ValueObject{

  
     private String OTOB_COM_CODE;
  
     private String OTOB_COM_TOB_CONT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_R_OTOB_COM_CODEEntity(){
    }
    
    
    public PT_R_OTOB_COM_CODEEntity(String OTOB_COM_CODE ){
       this.setOTOB_COM_CODE(OTOB_COM_CODE);
       
    }
      
    public PT_R_OTOB_COM_CODEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("OTOB_COM_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("OTOB_COM_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.OTOB_COM_CODE =request.getParameter("OTOB_COM_CODE");
		this.OTOB_COM_TOB_CONT =request.getParameter("OTOB_COM_TOB_CONT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.OTOB_COM_CODE =KJFMi.dsGet(ds, arg_row, "OTOB_COM_CODE");
		this.OTOB_COM_TOB_CONT =KJFMi.dsGet(ds, arg_row, "OTOB_COM_TOB_CONT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getOTOB_COM_CODE(){
             return OTOB_COM_CODE;
     };
  
     public String getOTOB_COM_TOB_CONT(){
             return OTOB_COM_TOB_CONT;
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
  

//Setter 함수를 만든다
  
     public void setOTOB_COM_CODE(String OTOB_COM_CODE){
            this.OTOB_COM_CODE=OTOB_COM_CODE;
     };
  
     public void setOTOB_COM_TOB_CONT(String OTOB_COM_TOB_CONT){
            this.OTOB_COM_TOB_CONT=OTOB_COM_TOB_CONT;
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
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("OTOB_COM_CODE:"+ this.getOTOB_COM_CODE()+"\n");
      
      strB.append("OTOB_COM_TOB_CONT:"+ this.getOTOB_COM_TOB_CONT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_OTOB_COM_CODEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_OTOB_COM_CODEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_OTOB_COM_CODEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_OTOB_COM_CODEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_OTOB_COM_CODEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getOTOB_COM_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_OTOB_COM_CODEEntity();
  }

  public ValueObject getClone(){
         PT_R_OTOB_COM_CODEEntity newEnt = new PT_R_OTOB_COM_CODEEntity();
	 
          newEnt.setOTOB_COM_CODE(this.getOTOB_COM_CODE());
         
          newEnt.setOTOB_COM_TOB_CONT(this.getOTOB_COM_TOB_CONT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_OTOB_COM_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getOTOB_COM_CODE();
        
             case 2 :
                 return  this.getOTOB_COM_TOB_CONT();
        
             case 3 :
                 return  this.getWRT_ID();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_OTOB_COM_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setOTOB_COM_CODE((String)value);
	            return;  
        
             case 2 :
                    this.setOTOB_COM_TOB_CONT((String)value);
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
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_OTOB_COM_CODEHelper.toXML(this);
  }
  
}
