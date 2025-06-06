

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_DEFICIT
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               DEFI_SEQ:NUMBER(4):  
*               DEFI_CODE:VARCHAR2(6):  
*               DEFI_OUT:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               DEFI_GROUP:VARCHAR2(12):  
*               DEFI_PROC:VARCHAR2(2):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_DEFICITEntity extends ValueObject{

  
     private String DEFI_SEQ;
  
     private String DEFI_CODE;
  
     private String DEFI_OUT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String DEFI_GROUP;
  
     private String DEFI_PROC;
  

//생성자를 만든다
    public PT_R_DEFICITEntity(){
    }
    
      
    public PT_R_DEFICITEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.DEFI_SEQ =request.getParameter("DEFI_SEQ");
		this.DEFI_CODE =request.getParameter("DEFI_CODE");
		this.DEFI_OUT =request.getParameter("DEFI_OUT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.DEFI_GROUP =request.getParameter("DEFI_GROUP");
		this.DEFI_PROC =request.getParameter("DEFI_PROC");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.DEFI_SEQ =KJFMi.dsGet(ds, arg_row, "DEFI_SEQ");
		this.DEFI_CODE =KJFMi.dsGet(ds, arg_row, "DEFI_CODE");
		this.DEFI_OUT =KJFMi.dsGet(ds, arg_row, "DEFI_OUT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.DEFI_GROUP =KJFMi.dsGet(ds, arg_row, "DEFI_GROUP");
		this.DEFI_PROC =KJFMi.dsGet(ds, arg_row, "DEFI_PROC");
				
    }    
    
//Getter 함수를 만든다
  
     public String getDEFI_SEQ(){
             return DEFI_SEQ;
     };
  
     public String getDEFI_CODE(){
             return DEFI_CODE;
     };
  
     public String getDEFI_OUT(){
             return DEFI_OUT;
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
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getDEFI_GROUP(){
             return DEFI_GROUP;
     };
  
     public String getDEFI_PROC(){
             return DEFI_PROC;
     };
  

//Setter 함수를 만든다
  
     public void setDEFI_SEQ(String DEFI_SEQ){
            this.DEFI_SEQ=DEFI_SEQ;
     };
  
     public void setDEFI_CODE(String DEFI_CODE){
            this.DEFI_CODE=DEFI_CODE;
     };
  
     public void setDEFI_OUT(String DEFI_OUT){
            this.DEFI_OUT=DEFI_OUT;
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
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setDEFI_GROUP(String DEFI_GROUP){
            this.DEFI_GROUP=DEFI_GROUP;
     };
  
     public void setDEFI_PROC(String DEFI_PROC){
            this.DEFI_PROC=DEFI_PROC;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("DEFI_SEQ:"+ this.getDEFI_SEQ()+"\n");
      
      strB.append("DEFI_CODE:"+ this.getDEFI_CODE()+"\n");
      
      strB.append("DEFI_OUT:"+ this.getDEFI_OUT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("DEFI_GROUP:"+ this.getDEFI_GROUP()+"\n");
      
      strB.append("DEFI_PROC:"+ this.getDEFI_PROC()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_DEFICITHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_DEFICITHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_DEFICITHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_DEFICITHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_DEFICITHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[0];
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_DEFICITEntity();
  }

  public ValueObject getClone(){
         PT_R_DEFICITEntity newEnt = new PT_R_DEFICITEntity();
	 
          newEnt.setDEFI_SEQ(this.getDEFI_SEQ());
         
          newEnt.setDEFI_CODE(this.getDEFI_CODE());
         
          newEnt.setDEFI_OUT(this.getDEFI_OUT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setDEFI_GROUP(this.getDEFI_GROUP());
         
          newEnt.setDEFI_PROC(this.getDEFI_PROC());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_DEFICITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getDEFI_SEQ();
        
             case 2 :
                 return  this.getDEFI_CODE();
        
             case 3 :
                 return  this.getDEFI_OUT();
        
             case 4 :
                 return  this.getWRT_ID();
        
             case 5 :
                 return  this.getUPD_DT();
        
             case 6 :
                 return  this.getINS_DT();
        
             case 7 :
                 return  this.getRECV_NUM();
        
             case 8 :
                 return  this.getSIDO_CODE();
        
             case 9 :
                 return  this.getDEFI_GROUP();
        
             case 10 :
                 return  this.getDEFI_PROC();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_DEFICITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setDEFI_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setDEFI_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setDEFI_OUT((String)value);
	            return;  
        
             case 4 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 5 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 6 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 7 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 8 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 9 :
                    this.setDEFI_GROUP((String)value);
	            return;  
        
             case 10 :
                    this.setDEFI_PROC((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_DEFICITHelper.toXML(this);
  }
  
}
