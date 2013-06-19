

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_CONDEFICIT
*  테이블 설명 :
*  테이블 PK   :  
*               DEFI_SEQ  
*               RECV_NUM  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               DEFI_SEQ:NUMBER(4):  
*               DEFI_CODE:VARCHAR2(6):  
*               DEFI_OUT:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(20):  
*               SIGUNGU_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_UB_CONDEFICITEntity extends ValueObject{

  
     private String DEFI_SEQ;
  
     private String DEFI_CODE;
  
     private String DEFI_OUT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String SIGUNGU_CODE;
  

//생성자를 만든다
    public PT_UB_CONDEFICITEntity(){
    }
    
    
    public PT_UB_CONDEFICITEntity(String DEFI_SEQ,String RECV_NUM,String SIDO_CODE,String SIGUNGU_CODE ){
       this.setDEFI_SEQ(DEFI_SEQ);
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       this.setSIGUNGU_CODE(SIGUNGU_CODE);
       
    }
      
    public PT_UB_CONDEFICITEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("DEFI_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("DEFI_SEQ",value);
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SIDO_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIDO_CODE",value);
       
       value = ent.getByName("SIGUNGU_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIGUNGU_CODE",value);
       
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
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		
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
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
				
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
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
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
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
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
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_UB_CONDEFICITHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_UB_CONDEFICITHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_UB_CONDEFICITHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_UB_CONDEFICITHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_UB_CONDEFICITHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[4];
       values[0]= this.getDEFI_SEQ();
       values[1]= this.getRECV_NUM();
       values[2]= this.getSIDO_CODE();
       values[3]= this.getSIGUNGU_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_UB_CONDEFICITEntity();
  }

  public ValueObject getClone(){
         PT_UB_CONDEFICITEntity newEnt = new PT_UB_CONDEFICITEntity();
	 
          newEnt.setDEFI_SEQ(this.getDEFI_SEQ());
         
          newEnt.setDEFI_CODE(this.getDEFI_CODE());
         
          newEnt.setDEFI_OUT(this.getDEFI_OUT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_UB_CONDEFICITHelper.fieldMap.get(key);
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
                 return  this.getSIGUNGU_CODE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_UB_CONDEFICITHelper.fieldMap.get(key);
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
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_UB_CONDEFICITHelper.toXML(this);
  }
  
}
