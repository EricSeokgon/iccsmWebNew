

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_MEMO
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               MEMO_DT:VARCHAR2(8):  
*               MEMO_CONT:VARCHAR2(512):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               SEQ:NUMBER(4):  
*               WRT_TIME:VARCHAR2(4):  
*               WRT_NAME:VARCHAR2(20):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_MEMOEntity extends ValueObject{

  
     private String MEMO_DT;
  
     private String MEMO_CONT;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String SEQ;
  
     private String WRT_TIME;
  
     private String WRT_NAME;
  

//생성자를 만든다
    public PT_M_MEMOEntity(){
    }
    
    
    public PT_M_MEMOEntity(String SEQ,String TMP_WRT_NUM,String WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_MEMOEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
       value = ent.getByName("WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.MEMO_DT =request.getParameter("MEMO_DT");
		this.MEMO_CONT =request.getParameter("MEMO_CONT");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.WRT_NUM =request.getParameter("WRT_NUM");
		this.SEQ =request.getParameter("SEQ");
		this.WRT_TIME =request.getParameter("WRT_TIME");
		this.WRT_NAME =request.getParameter("WRT_NAME");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.MEMO_DT =KJFMi.dsGet(ds, arg_row, "MEMO_DT");
		this.MEMO_CONT =KJFMi.dsGet(ds, arg_row, "MEMO_CONT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
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
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getSEQ(){
             return SEQ;
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
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
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
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("WRT_TIME:"+ this.getWRT_TIME()+"\n");
      
      strB.append("WRT_NAME:"+ this.getWRT_NAME()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_MEMOHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_MEMOHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_MEMOHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_MEMOHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_MEMOHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       values[2]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_MEMOEntity();
  }

  public ValueObject getClone(){
         PT_M_MEMOEntity newEnt = new PT_M_MEMOEntity();
	 
          newEnt.setMEMO_DT(this.getMEMO_DT());
         
          newEnt.setMEMO_CONT(this.getMEMO_CONT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setWRT_TIME(this.getWRT_TIME());
         
          newEnt.setWRT_NAME(this.getWRT_NAME());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_MEMOHelper.fieldMap.get(key);
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
                 return  this.getTMP_WRT_NUM();
        
             case 7 :
                 return  this.getWRT_NUM();
        
             case 8 :
                 return  this.getSEQ();
        
             case 9 :
                 return  this.getWRT_TIME();
        
             case 10 :
                 return  this.getWRT_NAME();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_MEMOHelper.fieldMap.get(key);
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
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 8 :
                    this.setSEQ((String)value);
	            return;  
        
             case 9 :
                    this.setWRT_TIME((String)value);
	            return;  
        
             case 10 :
                    this.setWRT_NAME((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_MEMOHelper.toXML(this);
  }
  
}
