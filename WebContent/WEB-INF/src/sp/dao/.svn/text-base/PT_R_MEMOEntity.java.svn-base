

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_MEMO
*  테이블 설명 :
*  테이블 PK   :  
*               MEMO_SEQ  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               MEMO_SEQ:NUMBER(4):  
*               MEMO_CONT:VARCHAR2(256):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               INS_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_MEMOEntity extends ValueObject{

  
     private String MEMO_SEQ;
  
     private String MEMO_CONT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String INS_DT;
  
     private String WRT_DT;
  

//생성자를 만든다
    public PT_R_MEMOEntity(){
    }
    
    
    public PT_R_MEMOEntity(String MEMO_SEQ,String RECV_NUM,String SIDO_CODE ){
       this.setMEMO_SEQ(MEMO_SEQ);
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       
    }
      
    public PT_R_MEMOEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("MEMO_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("MEMO_SEQ",value);
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SIDO_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIDO_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.MEMO_SEQ =request.getParameter("MEMO_SEQ");
		this.MEMO_CONT =request.getParameter("MEMO_CONT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.INS_DT =request.getParameter("INS_DT");
		this.WRT_DT =request.getParameter("WRT_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.MEMO_SEQ =KJFMi.dsGet(ds, arg_row, "MEMO_SEQ");
		this.MEMO_CONT =KJFMi.dsGet(ds, arg_row, "MEMO_CONT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getMEMO_SEQ(){
             return MEMO_SEQ;
     };
  
     public String getMEMO_CONT(){
             return MEMO_CONT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
     };
  

//Setter 함수를 만든다
  
     public void setMEMO_SEQ(String MEMO_SEQ){
            this.MEMO_SEQ=MEMO_SEQ;
     };
  
     public void setMEMO_CONT(String MEMO_CONT){
            this.MEMO_CONT=MEMO_CONT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("MEMO_SEQ:"+ this.getMEMO_SEQ()+"\n");
      
      strB.append("MEMO_CONT:"+ this.getMEMO_CONT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_MEMOHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_MEMOHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_MEMOHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_MEMOHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_MEMOHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getMEMO_SEQ();
       values[1]= this.getRECV_NUM();
       values[2]= this.getSIDO_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_MEMOEntity();
  }

  public ValueObject getClone(){
         PT_R_MEMOEntity newEnt = new PT_R_MEMOEntity();
	 
          newEnt.setMEMO_SEQ(this.getMEMO_SEQ());
         
          newEnt.setMEMO_CONT(this.getMEMO_CONT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_MEMOHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getMEMO_SEQ();
        
             case 2 :
                 return  this.getMEMO_CONT();
        
             case 3 :
                 return  this.getWRT_ID();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getRECV_NUM();
        
             case 6 :
                 return  this.getSIDO_CODE();
        
             case 7 :
                 return  this.getINS_DT();
        
             case 8 :
                 return  this.getWRT_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_MEMOHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setMEMO_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setMEMO_CONT((String)value);
	            return;  
        
             case 3 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 4 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 5 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 6 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 7 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_MEMOHelper.toXML(this);
  }
  
}
