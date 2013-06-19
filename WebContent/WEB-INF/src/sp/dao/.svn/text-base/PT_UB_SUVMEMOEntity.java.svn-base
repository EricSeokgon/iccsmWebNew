

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_SUVMEMO
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               MEMO_DT:VARCHAR2(8):  
*               MEMO_CONT:VARCHAR2(512):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               SEQ:NUMBER(4):  
*               RECV_NUM:VARCHAR2(16):  
*               SIDO_CODE:VARCHAR2(4):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               WRT_TIME:VARCHAR2(5):  
*               WRT_NAME:VARCHAR2(25):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_UB_SUVMEMOEntity extends ValueObject{

  
     private String MEMO_DT;
  
     private String MEMO_CONT;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SEQ;
  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String SIGUNGU_CODE;
  
     private String WRT_TIME;
  
     private String WRT_NAME;
  

//생성자를 만든다
    public PT_UB_SUVMEMOEntity(){
    }
    
    
    public PT_UB_SUVMEMOEntity(String RECV_NUM,String SEQ,String SIDO_CODE,String SIGUNGU_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSEQ(SEQ);
       this.setSIDO_CODE(SIDO_CODE);
       this.setSIGUNGU_CODE(SIGUNGU_CODE);
       
    }
      
    public PT_UB_SUVMEMOEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
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
		this.MEMO_DT =request.getParameter("MEMO_DT");
		this.MEMO_CONT =request.getParameter("MEMO_CONT");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SEQ =request.getParameter("SEQ");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.WRT_TIME =request.getParameter("WRT_TIME");
		this.WRT_NAME =request.getParameter("WRT_NAME");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.MEMO_DT =KJFMi.dsGet(ds, arg_row, "MEMO_DT");
		this.MEMO_CONT =KJFMi.dsGet(ds, arg_row, "MEMO_CONT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.WRT_TIME =KJFMi.dsGet(ds, arg_row, "WRT_TIME");
		this.WRT_NAME =KJFMi.dsGet(ds, arg_row, "WRT_NAME");
				
    }    
    
//Getter 함수를 만든다
  
     public String getMEMO_DT(){
             return MEMO_DT;
     };
  
     public String getMEMO_CONT(){
             return MEMO_CONT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getSEQ(){
             return SEQ;
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
  
     public String getWRT_TIME(){
             return WRT_TIME;
     };
  
     public String getWRT_NAME(){
             return WRT_NAME;
     };
  

//Setter 함수를 만든다
  
     public void setMEMO_DT(String MEMO_DT){
            this.MEMO_DT=MEMO_DT;
     };
  
     public void setMEMO_CONT(String MEMO_CONT){
            this.MEMO_CONT=MEMO_CONT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
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
  
     public void setWRT_TIME(String WRT_TIME){
            this.WRT_TIME=WRT_TIME;
     };
  
     public void setWRT_NAME(String WRT_NAME){
            this.WRT_NAME=WRT_NAME;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("MEMO_DT:"+ this.getMEMO_DT()+"\n");
      
      strB.append("MEMO_CONT:"+ this.getMEMO_CONT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("WRT_TIME:"+ this.getWRT_TIME()+"\n");
      
      strB.append("WRT_NAME:"+ this.getWRT_NAME()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_UB_SUVMEMOHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_UB_SUVMEMOHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_UB_SUVMEMOHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_UB_SUVMEMOHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_UB_SUVMEMOHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[4];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSEQ();
       values[2]= this.getSIDO_CODE();
       values[3]= this.getSIGUNGU_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_UB_SUVMEMOEntity();
  }

  public ValueObject getClone(){
         PT_UB_SUVMEMOEntity newEnt = new PT_UB_SUVMEMOEntity();
	 
          newEnt.setMEMO_DT(this.getMEMO_DT());
         
          newEnt.setMEMO_CONT(this.getMEMO_CONT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setWRT_TIME(this.getWRT_TIME());
         
          newEnt.setWRT_NAME(this.getWRT_NAME());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_UB_SUVMEMOHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getMEMO_DT();
        
             case 2 :
                 return  this.getMEMO_CONT();
        
             case 3 :
                 return  this.getINS_DT();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getWRT_ID();
        
             case 6 :
                 return  this.getSEQ();
        
             case 7 :
                 return  this.getRECV_NUM();
        
             case 8 :
                 return  this.getSIDO_CODE();
        
             case 9 :
                 return  this.getSIGUNGU_CODE();
        
             case 10 :
                 return  this.getWRT_TIME();
        
             case 11 :
                 return  this.getWRT_NAME();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_UB_SUVMEMOHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setMEMO_DT((String)value);
	            return;  
        
             case 2 :
                    this.setMEMO_CONT((String)value);
	            return;  
        
             case 3 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 4 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 5 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 6 :
                    this.setSEQ((String)value);
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
        
             case 10 :
                    this.setWRT_TIME((String)value);
	            return;  
        
             case 11 :
                    this.setWRT_NAME((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_UB_SUVMEMOHelper.toXML(this);
  }
  
}
