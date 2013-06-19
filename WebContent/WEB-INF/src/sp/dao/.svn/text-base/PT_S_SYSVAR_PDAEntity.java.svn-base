

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_SYSVAR_PDA
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               PDA_MAC_ADDR:VARCHAR2(125):  
*               PDA_NUM:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SIDO_CODE:VARCHAR2(4):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               SEQ:NUMBER(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_S_SYSVAR_PDAEntity extends ValueObject{

  
     private String PDA_MAC_ADDR;
  
     private String PDA_NUM;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String SIDO_CODE;
  
     private String SIGUNGU_CODE;
  
     private String SEQ;
  

//생성자를 만든다
    public PT_S_SYSVAR_PDAEntity(){
    }
    
    
    public PT_S_SYSVAR_PDAEntity(String SEQ,String SIDO_CODE,String SIGUNGU_CODE ){
       this.setSEQ(SEQ);
       this.setSIDO_CODE(SIDO_CODE);
       this.setSIGUNGU_CODE(SIGUNGU_CODE);
       
    }
      
    public PT_S_SYSVAR_PDAEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
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
		this.PDA_MAC_ADDR =request.getParameter("PDA_MAC_ADDR");
		this.PDA_NUM =request.getParameter("PDA_NUM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.SEQ =request.getParameter("SEQ");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.PDA_MAC_ADDR =KJFMi.dsGet(ds, arg_row, "PDA_MAC_ADDR");
		this.PDA_NUM =KJFMi.dsGet(ds, arg_row, "PDA_NUM");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
				
    }    
    
//Getter 함수를 만든다
  
     public String getPDA_MAC_ADDR(){
             return PDA_MAC_ADDR;
     };
  
     public String getPDA_NUM(){
             return PDA_NUM;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getSEQ(){
             return SEQ;
     };
  

//Setter 함수를 만든다
  
     public void setPDA_MAC_ADDR(String PDA_MAC_ADDR){
            this.PDA_MAC_ADDR=PDA_MAC_ADDR;
     };
  
     public void setPDA_NUM(String PDA_NUM){
            this.PDA_NUM=PDA_NUM;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("PDA_MAC_ADDR:"+ this.getPDA_MAC_ADDR()+"\n");
      
      strB.append("PDA_NUM:"+ this.getPDA_NUM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_S_SYSVAR_PDAHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_S_SYSVAR_PDAHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_S_SYSVAR_PDAHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_S_SYSVAR_PDAHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_S_SYSVAR_PDAHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getSEQ();
       values[1]= this.getSIDO_CODE();
       values[2]= this.getSIGUNGU_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_S_SYSVAR_PDAEntity();
  }

  public ValueObject getClone(){
         PT_S_SYSVAR_PDAEntity newEnt = new PT_S_SYSVAR_PDAEntity();
	 
          newEnt.setPDA_MAC_ADDR(this.getPDA_MAC_ADDR());
         
          newEnt.setPDA_NUM(this.getPDA_NUM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setSEQ(this.getSEQ());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_S_SYSVAR_PDAHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getPDA_MAC_ADDR();
        
             case 2 :
                 return  this.getPDA_NUM();
        
             case 3 :
                 return  this.getWRT_ID();
        
             case 4 :
                 return  this.getINS_DT();
        
             case 5 :
                 return  this.getUPD_DT();
        
             case 6 :
                 return  this.getSIDO_CODE();
        
             case 7 :
                 return  this.getSIGUNGU_CODE();
        
             case 8 :
                 return  this.getSEQ();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_S_SYSVAR_PDAHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setPDA_MAC_ADDR((String)value);
	            return;  
        
             case 2 :
                    this.setPDA_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 4 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 5 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 6 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 7 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 8 :
                    this.setSEQ((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_S_SYSVAR_PDAHelper.toXML(this);
  }
  
}
